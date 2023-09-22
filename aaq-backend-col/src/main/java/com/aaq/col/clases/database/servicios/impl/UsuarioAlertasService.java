package com.aaq.col.clases.database.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioAlertas;
import com.aaq.col.clases.database.entidades.pojo.TipoAlertas;
import com.aaq.col.clases.database.repositorios.impl.UsuarioAlertasDao;
import com.aaq.col.clases.database.repositorios.interfase.UsuarioAlertasDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaBaseServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioAlertasServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.EnvioCorreoAlertas;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaEmail;

@Service("usuarioAlertasService")
@Transactional
public class UsuarioAlertasService implements UsuarioAlertasServiceInterfase {

	Log4JLogger loggerAlertas = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.alertas");
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");

	
	@Autowired
	@Qualifier("usuarioAlertasDao")
	private UsuarioAlertasDaoInterfase usuarioAlertasDao;
	
	@Autowired
	private FrecuenciaBaseServiceInterfase frecuenciaBaseService;
	
	@Autowired
	private FrecuenciaServiceInterfase frecuenciaService;
	
	@Autowired
	private ConfiguracionServiceInterfase configuracionDao;
	
	@Override
	public UsuarioAlertas objetoUsuarioAlertas(String id) {
		return usuarioAlertasDao.objetoUsuarioAlertas(id);
	}

	@Override
	public UsuarioAlertas objetoUsuarioAlertasParaUsuario(Usuario usuario) {
		return usuarioAlertasDao.objetoUsuarioAlertasParaUsuario(usuario);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(UsuarioAlertas t)  {
		return usuarioAlertasDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(UsuarioAlertas t)  {
		return usuarioAlertasDao.guardarObjeto(t);
	}

	@Override
	public List<UsuarioAlertas> usuarioAlertaParaFrecuencia(Frecuencia frecuencia, String filtroAlerta) {
		return usuarioAlertasDao.usuarioAlertaParaFrecuencia(frecuencia, filtroAlerta);
	}
	
	@Override 
	public void envioAlertasNoDisponible(Estado estado, String tipoAlerta, TipoAlertas tipoAlertas) {
		
		List<UsuarioAlertas> usuarios = this.obtenerUsuariosAlertaNoDisponible(estado, tipoAlertas);
//		log.info("Usuarios: "+usuarios.size());
		if (!usuarios.isEmpty()) {
			ArrayList<String> correos = new ArrayList<String>();
			ArrayList<String> telefonos = new ArrayList<String>();
			
			for (UsuarioAlertas usuarioAlertas : usuarios) {
				switch (usuarioAlertas.getTipoAlerta()) {
				case "CORREO":
					if (usuarioAlertas.getUsuario().getMail() != null) {
						correos.add(usuarioAlertas.getUsuario().getMail());
					}
					break;
				case "SMS":
					if (usuarioAlertas.getUsuario().getTelefono() != null) {
						telefonos.add(usuarioAlertas.getUsuario().getTelefono());
					}
					break;
				case "TODAS":
					if(usuarioAlertas.getUsuario().getMail() != null)
						correos.add(usuarioAlertas.getUsuario().getMail());
					if(usuarioAlertas.getUsuario().getTelefono() != null)
						telefonos.add(usuarioAlertas.getUsuario().getTelefono());
					break;
				}
			}
			
			if (!correos.isEmpty()) {
				final StringBuilder builderBody = new StringBuilder("");
				String asunto = null;
				
				asunto = "NO HAY AJUSTADORES DISPONIBLES.";					
				
				builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
				builderBody.append("EL ESTADO: <b>"+estado.getNombre()+" NO TIENE EN ESTE MOMENTO AJUSTADORES DISPONIBLES");			
				builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DE LOS AJUSTADORES.");
				
				this.loggerAlertas.info("ALERTA "+tipoAlerta+". Envio de correos: "+correos.toString());
				try {
					boolean permisoCorreo = this.configuracionDao
							.obtenerBooleano(JMConstantes.CONFIGURACION_ALERTAS_PERMISO_CORREO);
					
					this.loggerAlertas.info("PERMISO DE CORREO PARA ALERTAS: "+ permisoCorreo);
					if(permisoCorreo) {
						new JMUtileriaEmail(
						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
						configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG))
						.enviarEmail(correos,Objects.toString(asunto, ""), Objects.toString(builderBody, ""));						
					}
				} catch (Exception e) {
					this.loggerAlertas.error("ERROR AL ENVIAR MAILS DE: ESTADO: <b>"+estado.getNombre()+"</b> NO TIENE AJUSTADORES DISPONIBLES.");
					this.loggerAlertas.error(e,e);
				}	

			}
			
			if(!telefonos.isEmpty()) {				
				try {
					GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();					
					String mensaje = null;
											
						mensaje = "EL ESTADO: <b>"+estado.getNombre()+"</b> NO TIENE AJUSTADORES DISPONIBLES.";
										
					boolean permisoSMS = this.configuracionDao
							.obtenerBooleano(JMConstantes.CONFIGURACION_ALERTAS_PERMISO_SMS);
					
					this.loggerAlertas.info("PERMISO DE CORREO PARA SMS: "+permisoSMS);
					if(permisoSMS) {
						for (String tel : telefonos) {
							this.loggerAlertas.info("ALERTA "+tipoAlerta+". Envio de SMS Tel: "+tel);
							genericoEnviarSMS.enviarSMS(tel, mensaje);
						}
					}
				} catch (Exception e) {
					this.loggerAlertas.error("ERROR AL ENVIAR SMS DEL: ESTADO: <b>"+estado.getNombre()+" NO TIENE AJUSTADORES DISPONIBLES.");
					this.loggerAlertas.error(e,e);
				}
			}
		}
		
		
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public void envioAlertas(Terminal terminal, int tiempo, String tipoAlerta, TipoAlertas tipoAlertas, String rol, String complemento) {
		
		
		List<UsuarioAlertas> usuarios = this.obtenerUsuariosAlertas(terminal.getBase(), tipoAlertas, rol);
		if(!usuarios.isEmpty()) {
			ArrayList<String> correos = new ArrayList<String>();
			ArrayList<String> telefonos = new ArrayList<String>();
			
			for (UsuarioAlertas usuarioAlertas : usuarios) {
				
				this.loggerAlertas.info("Usuarios: "+usuarioAlertas.getUsuario().getNombre());

				switch (usuarioAlertas.getTipoAlerta()) {
				case "CORREO":
					if(usuarioAlertas.getUsuario().getMail() != null)
						correos.add(usuarioAlertas.getUsuario().getMail());
					break;				
				case "SMS":
					if(usuarioAlertas.getUsuario().getTelefono() != null)
						telefonos.add(usuarioAlertas.getUsuario().getTelefono());
					break;				
				case "TODAS":
					if(usuarioAlertas.getUsuario().getMail() != null)
						correos.add(usuarioAlertas.getUsuario().getMail());
					if(usuarioAlertas.getUsuario().getTelefono() != null)
						telefonos.add(usuarioAlertas.getUsuario().getTelefono());
					break;
				}
				this.loggerAlertas.info("usuario" +usuarioAlertas.getUsuario().getNombre());					

			}
			if(!correos.isEmpty()) {
				final StringBuilder builderBody = new StringBuilder("");
				String asunto = null;
				
				switch (tipoAlertas) {
				case TIEMPO_MUERTO:
					asunto = "AJUSTADOR CON "+tiempo+" MIN. DE "+tipoAlerta+".";
					
					builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
					builderBody.append("EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" BASE "+terminal.getBase().getNombre()+" LLEVA "+tiempo+" MIN. SIN ATENCIÓN O REPORTE ASIGNADO.");			
					builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DEL AJUSTADOR.");
					break;

				case TIEMPO_OCUPADO:
					asunto = "AJUSTADOR CON "+tiempo+" MIN. DE TIEMPO EN ATENCIÓN.";
					
					builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
					builderBody.append("EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" BASE "+terminal.getBase().getNombre()+" LLEVA "+tiempo+" MIN. EN ATENCIÓN SIN TERMINAR EL REPORTE.");			
					builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DEL AJUSTADOR.");
					break;
				case LOGIN:
					asunto = "AJUSTADOR CON INICIO DE SESIÓN DESPUES DE TIEMPO.";					
					
					builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
					builderBody.append("EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" BASE "+terminal.getBase().getNombre()+" TIENE UN INICIO DE SESIÓN DESPUES DE SU HORARIO. "+complemento);			
					builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DEL AJUSTADOR.");
					break;
				case LOGOUT:
					asunto = "AJUSTADOR CON CIERRE DE SESIÓN ANTES DE SU HORARIO DE SALIDA.";					
					
					builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
					builderBody.append("EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" BASE "+terminal.getBase().getNombre()+" TERMINO SESIÓN ANTES DE SU HORARIO DE SALIDA. "+complemento);			
					builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DEL AJUSTADOR.");
					break;
				case POST_ARRIBO:
					asunto = "AJUSTADOR CON ARRIBO DESPUES DE TIEMPO.";
					
					builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
					builderBody.append("EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" BASE "+terminal.getBase().getNombre()+" ARRIBO DESPUES DE TIEMPO.");			
					builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DEL AJUSTADOR.");	
					break;
					
				case TERMINO_DISTANCIA:
					asunto = "AJUSTADOR CON UBICACION DE TERMINO DISTINTO AL ARRIBO.";
					
					builderBody.append("<p><b>COORDINADORES Y/O SUPERVISORES: </b></p>");
					builderBody.append("EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" BASE "+terminal.getBase().getNombre()+" TERMINO EL REPORTE EN UNA LUGAR DISTINTO AL ARRIBO.");			
					builderBody.append("<br/><br/>FAVOR DE ESTAR AL PENDIENTE DEL AJUSTADOR.");	
					break;
				}
				
				this.loggerAlertas.info("ALERTA "+tipoAlerta+". Envio de correos: "+correos.toString());
//				log.info("CUERPO DEL CORREO: "+Objects.toString(builderBody, ""));
				try {
					boolean permisoCorreo = this.configuracionDao
							.obtenerBooleano(JMConstantes.CONFIGURACION_ALERTAS_PERMISO_CORREO);
					
					this.loggerAlertas.info("PERMISO DE CORREO PARA ALERTAS: "+ permisoCorreo);
					if(permisoCorreo) { 
//						new JMUtileriaEmail(
//						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
//						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
//						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
//						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
//						configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
//						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
//						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
//						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG))
//						.enviarEmail(correos,Objects.toString(asunto, ""), Objects.toString(builderBody, ""));	
						
						try {
							EnvioCorreoAlertas correoFirmaImagAsyncObj = new EnvioCorreoAlertas(
									Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
									Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
									Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
									Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
									Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
									Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
									Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
									true);
							try {
							correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  Objects.toString(builderBody, ""), null,null, null);
							}catch (Exception e) {
								this.loggerAlertas.info("Ocurrio un error: "+e);
								this.loggerAvisos.info("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: "+e);
							}
						}catch (Exception e) {
							this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
							this.loggerAlertas.info("Ocurrio un error: "+e);
				        	}
					}
				} catch (Exception e) {
					this.loggerAlertas.error("ERROR AL ENVIAR MAILS DE: AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TIENE "+tiempo+" MIN. DE "+tipoAlerta+".");
					this.loggerAlertas.error(e,e);
			}
			}
			
			if(!telefonos.isEmpty()) {				
				try {
					GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();					
					String mensaje = null;
					
					switch (tipoAlertas) {
					case TIEMPO_MUERTO:
						mensaje = "EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TIENE "+tiempo+" MIN. DE "+tipoAlerta+".";
						break;

					case TIEMPO_OCUPADO:
						mensaje = "EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TIENE "+tiempo+" MIN. DE "+tipoAlerta+".";
						break;
						
					case LOGIN:
						mensaje = "EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TIENE UN INICIO DE SESION DESPUES DE SU HORARIO. "+complemento;
						break;
						
					case LOGOUT:
						mensaje = "EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TERMINO SESION ANTES DE SU HORARIO DE SALIDA. "+complemento;
						break;
						
					case POST_ARRIBO:
						mensaje = "EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" ARRIBO DESPUES DE TIEMPO.";
						break;			
						
					case TERMINO_DISTANCIA:
						mensaje = "EL AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TERMINO EL REPORTE EN UN LUGAR DISTINTO AL ARRIBO.";
						break;
					}
										
					boolean permisoSMS = this.configuracionDao
							.obtenerBooleano(JMConstantes.CONFIGURACION_ALERTAS_PERMISO_SMS);
					
					this.loggerAlertas.info("PERMISO DE CORREO PARA SMS: "+permisoSMS);
					if(permisoSMS) {
						for (String tel : telefonos) {
							this.loggerAlertas.info("ALERTA "+tipoAlerta+". Envio de SMS Tel: "+tel);
							genericoEnviarSMS.enviarSMS(tel, mensaje);
						}
					}
				} catch (Exception e) {
					this.loggerAlertas.error("ERROR AL ENVIAR SMS DE: AJUSTADOR: <b>"+terminal.getNombre()+"</b> CLAVE: "+terminal.getNumeroproveedor()+" TIENE "+tiempo+" MIN. DE "+tipoAlerta+".");
					this.loggerAlertas.error(e,e);
				}
			}
			
		}
		
	}
	
	public List<UsuarioAlertas> obtenerUsuariosAlertaNoDisponible(Estado estado, TipoAlertas tipoAlerta){
		List<UsuarioAlertas> usuarios = new ArrayList<UsuarioAlertas>();
		try {
			List<Frecuencia> frecuencias  = frecuenciaService.listaDeFrecuencia(estado);
//			log.info("Frecuencia: "+frecuencias.size());
			for (Frecuencia frecuencia : frecuencias) {
//				log.info(frecuencia+"-"+frecuencia.getId());
				usuarios.addAll(this.usuarioAlertaParaFrecuencia(frecuencia, UsuarioAlertasDao.filtroNoDisponibles));
			}
			
		} catch(Exception e) {
			this.loggerAlertas.error("Ocurrio un error al obtener los usuarios para las alertas");
		}
		
		return usuarios;
	}
	
	public List<UsuarioAlertas> obtenerUsuariosAlertas(Base base, TipoAlertas tipoAlerta, String rol){
		List<UsuarioAlertas> usuarios = new ArrayList<UsuarioAlertas>();	
		List<UsuarioAlertas> usuariosRol = new ArrayList<UsuarioAlertas>();		
		String tipoFiltro = new String();
	
		switch (tipoAlerta) {
		case TIEMPO_MUERTO:
			tipoFiltro = UsuarioAlertasDao.filtroTiempoLibre;
			break;
		case TIEMPO_OCUPADO:
			tipoFiltro = UsuarioAlertasDao.filtroTiempoOcupado;
			break;
		case LOGIN:
			tipoFiltro = UsuarioAlertasDao.filtroLogin;
			break;
		case LOGOUT:
			tipoFiltro = UsuarioAlertasDao.filtroLogout;
			break;
		case POST_ARRIBO:
			tipoFiltro = UsuarioAlertasDao.filtroArriboPostTiempo;
			break;

		default:
			break;
		}

		try {
			// Se obtiene  la relacion de frecuancias y bases con la base
			List<FrecuenciaBase> frecuenciaBases = frecuenciaBaseService.listaDeFrecuenciaBase(base);			
			// Se obtienen los usuarios con respecto a la frecuencia y al tipo de alerta
			for (FrecuenciaBase frecuenciaBase : frecuenciaBases) {
				usuarios.addAll(this.usuarioAlertaParaFrecuencia(frecuenciaBase.getFrecuencia(), tipoFiltro));
			}
			
			List<Base> bases = Base.getBaseService().listaDeBase(base.getEstado(), true);
			
			for (Base base2 : bases) {
				if (base2.getId()<0) {
					frecuenciaBases = frecuenciaBaseService.listaDeFrecuenciaBase(base2);
				}
			}
			
			for (FrecuenciaBase frecuenciaBase : frecuenciaBases) {
				usuarios.addAll(this.usuarioAlertaParaFrecuencia(frecuenciaBase.getFrecuencia(), tipoFiltro));
			}
					
			if(StringUtils.isBlank(rol)){
				for (UsuarioAlertas user: usuarios){	
					this.loggerAlertas.info(user.getUsuario().getNombre());
					try {
						if(StringUtils.isBlank(String.valueOf(user.getUsuario().getPerfil().getRol().getId())) ){
							usuariosRol.add(user);
						}
					} catch (Exception e) {
						this.loggerAlertas.info("No tiene un rol asociado");
					}
				}
				return usuariosRol;
			} else {
				for (UsuarioAlertas user: usuarios){
					this.loggerAlertas.info(user.getUsuario().getNombre());
					if(user.getUsuario().getPerfil().getRol() != null){	
						try {
							if(StringUtils.equals(String.valueOf(user.getUsuario().getPerfil().getRol().getId() == null ? "": user.getUsuario().getPerfil().getRol().getId()), rol)){
								usuariosRol.add(user);
							}
						} catch (Exception e) {
							this.loggerAlertas.info("No tiene un rol asociado");
						}
					}
				}
				return usuariosRol;
			}
			
		} catch (Exception e) {
			this.loggerAlertas.error("Ocurrio un error al obtener los usuarios para las alertas", e);
		}
		
		return usuariosRol;
}

}
