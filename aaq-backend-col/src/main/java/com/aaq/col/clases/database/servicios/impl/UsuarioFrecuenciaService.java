package com.aaq.col.clases.database.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioFrecuencia;
import com.aaq.col.clases.database.repositorios.impl.UsuarioFrecuenciaDao;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaBaseServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioFrecuenciaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioServiceInterfase;
import com.aaq.col.clases.pojo.notificacion.EncuestaCorreo;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.CorreoEncuesta;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("usuarioFrecuenciaService")
@Transactional
public class UsuarioFrecuenciaService implements UsuarioFrecuenciaServiceInterfase {
	
	Log4JLogger log = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");

	

	@Autowired
	@Qualifier("usuarioFrecuenciaDao")
	UsuarioFrecuenciaDao usuarioFrecuenciaDao;
	
	@Autowired
	private FrecuenciaBaseServiceInterfase frecuenciaBaseService;

	@Autowired
	private ConfiguracionServiceInterfase configuracionDao;
	
	@Autowired
	private UsuarioServiceInterfase usuarioService;
	
	
	
	@Override
	public UsuarioFrecuencia objetoUsuarioFrecuencia(final String id) {
		return this.usuarioFrecuenciaDao.objetoUsuarioFrecuencia(id);
	}

	@Override
	public List<UsuarioFrecuencia> listaDeUsuarioFrecuencia(final Usuario usuario) {
		return this.usuarioFrecuenciaDao.listaDeUsuarioFrecuencia(usuario);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final UsuarioFrecuencia t) {
		return this.usuarioFrecuenciaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final UsuarioFrecuencia t) {
		return this.usuarioFrecuenciaDao.guardarObjeto(t);
	}

	@Override
	public void envioDeCorreoEncuesta(Terminal terminal, EncuestaCorreo resultados, String reporte, int rol)  {
		
		List<Usuario> usuarioF = this.obtenerUsuarioFrecuencia(terminal.getBase(), rol, 0);
		ArrayList<String> correos = new ArrayList<>();
		log.info("cantidad de usuario: "+usuarioF.size());
		boolean salida = false;
		CorreoEncuesta correoEncuesta;
		
		if (usuarioF != null) {
			for(Usuario usuariosFrecuencia: usuarioF) {
				if (usuariosFrecuencia.getMail() != null) {
					correos.add(usuariosFrecuencia.getMail());
				}
			}
		}
		log.info("Correos de usuarios frecuencia: "+correos);
		
		if ( correos.size() > 0) {
			
//			log.info(configuracionDao.obtenerBooleano(JMConstantes.PERMISO_ENCUESTA_CORREO_ADMIN));
			//Aqui añadimos el permiso para agregar el correo de armando
			try {
				if (configuracionDao.obtenerBooleano(JMConstantes.PERMISO_ENCUESTA_CORREO_ADMIN)) {
					correos.add("arpadilla@qualitas.com.mx");
				}
			}catch (Exception e) {
				log.info("Ocurrio un error al añadir correo de admin: "+e);
			}
			
			String asunto = null;
			String cuerpoCorreo  =  null;
			asunto = "Seguimiento Encuesta Ajustador";
			try {
				cuerpoCorreo  = this.cuerpoCorreo(terminal, resultados, reporte);
			}catch (Exception e) {
				log.info("Ocurrio un error al generar el cuerpo del correo: "+e);
			}
log.info("Correos: "+correos);
log.info("Asunto "+asunto);


		try {
			correoEncuesta = new CorreoEncuesta(
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
					configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
					null);
			try {
			 salida = correoEncuesta.enviarEmail(correos, asunto, cuerpoCorreo,null);
			}catch (Exception e) {
				log.info("Error en la salida de CorreoEncuesta -> "+e);
			}
			 log.info("Respuesta del envio de mensaje: "+salida);
		}catch (Exception e) {
			log.info("OCURRIO UN ERROR AL ENVIAR EL CORREO: "+e);
		}
		}
	}
	
	public List<Usuario> obtenerUsuarioFrecuencia(Base base, int rol, int rol2) {
		
		List<Usuario> usuarioF = new ArrayList<Usuario>();
		List<Usuario> usuariosRol = new ArrayList<Usuario>();	

		try {
			List<FrecuenciaBase> frecuenciaBase = frecuenciaBaseService.listaDeFrecuenciaBase(base);
			log.info("Tamaño de la lista frecuenciaBase para envio de correos: "+frecuenciaBase.size());
			
			for(FrecuenciaBase frecBase : frecuenciaBase) {
				usuarioF.addAll(usuarioService.listaDeUsuarioParaFrecuencia(frecBase.getFrecuencia()));
			}
			
			List<Base> bases = Base.getBaseService().listaDeBase(base.getEstado(), true);
//			log.info("Base estado: "+base.getEstado().getNombre()+"- Cantidad: "+bases.size());
			for(Base baseF : bases) {
				if (baseF.getId() < 0) {
					frecuenciaBase = frecuenciaBaseService.listaDeFrecuenciaBase(baseF);
				}
			}
			
			for(FrecuenciaBase frecBase : frecuenciaBase) {
				usuarioF.addAll(usuarioService.listaDeUsuarioParaFrecuencia(frecBase.getFrecuencia()));
			}
			
//			log.info("Usuario F: "+usuarioF.size());
				for (Usuario user: usuarioF){
					if (user.getHabilitado()) {
						if(user.getPerfil().getRol() != null){	
							if (user.getPerfil().getRol().getId().equals(rol)) {
								if (user.getMail() != null) {
									log.info("Usuario: "+user.getNombre()+"- Correo: "+user.getMail());
									usuariosRol.add(user);
								}
							}
							if (rol2 > 0) {
								if (user.getPerfil().getRol().getId().equals(rol2)) {
									if (user.getMail() != null) {
										log.info("Usuario: "+user.getNombre()+"- Correo: "+user.getMail());
										usuariosRol.add(user);
									}
								}
							}
						}
					}
				}
				return usuariosRol;
					
		}  catch (Exception e) {
			log.error("Ocurrio un error al obtener los usuarios para correos de encuesta", e);
		}
		
		return usuariosRol;
		
	}

	@Override
	public List<UsuarioFrecuencia> usuarioEncuestaFrecuencia(Frecuencia frecuencia)  {
		return usuarioFrecuenciaDao.listaDeUsuarioFrecuenciaEncuesta(frecuencia, null);
	}
	
	public String cuerpoCorreo(Terminal terminal, EncuestaCorreo resultados, String reporte) {
		String cuerpoCorreo = null;
		
		cuerpoCorreo = "<div><center>\r\n" + 
				"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 31px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
				"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
				"</center>\r\n" + 
				"<div>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 22.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 22.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;de Resultado de Encuesta.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado Sr. Coordinador/Gerente, es necesario reportarse con el asegurado para aclarar sus dudas.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">El ajustador "+terminal.getNombre()+", con clave "+terminal.getNumeroproveedor()+" y número de reporte: "+reporte+
				", obtuvo el siguiente resultado: \r\n" + 
				"\r\n" + 
				"<!-- o ignored --></p>\r\n" +  
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n";
		
				if(resultados.getCalifLlegadaAjus() != null) {
				cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">La oportunidad en la llegada del Ajustador al lugar del accidente fue:&nbsp; </span> "+resultados.getCalifLlegadaAjus() +"</p>\r\n" ; 
				}
				
				if (resultados.getCalifPresentacionAjus() != null) {
					cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">La presentación y personalidad del Ajustador fue:&nbsp;&nbsp; </span> "+resultados.getCalifPresentacionAjus()+" </p>\r\n";
				}
				
				if (resultados.getCalifTratoAjus() != null) {
					cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">¿Cómo fue el trato del ajustador?:&nbsp;&nbsp; </span> "+ resultados.getCalifTratoAjus() +"</p>\r\n" ; 
				}
				 
				if (resultados.getCalifCapacidadAjus() != null) {
					cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">La capacidad y asistencia del ajustador en el siniestro fue:&nbsp; </span>"+resultados.getCalifCapacidadAjus()+"</p>\r\n" ;
				}
				 
				if (resultados.getCalifTratoAjusTercero() != null) {
					cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">El trato del ajustador hacia el tercero involucrado fue:&nbsp; </span>"+resultados.getCalifTratoAjusTercero()+"</p>\r\n";
				}
				 
//				if (resultados.getSeleccionTaller() != null) {
//				cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">¿En su caso, eligio libremente del menú ofrecido por el ajustador, el taller/agencia para reparar su unidad?:&nbsp; </span>"+resultados.getSeleccionTaller()+"</p>\r\n";	
//				}
				 
				if (resultados.getObservoIrregularidad() != null) {
					cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">¿Observo alguna irregularidad en el servicio?:&nbsp; </span>"+resultados.getObservoIrregularidad()+"</p>\r\n" ;
				} 
//				 
//				if (resultados.getRecibioCopiaDA() != null) {
//					cuerpoCorreo = cuerpoCorreo + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">¿Recibió usted una copia de la Declaración de Accidente?:&nbsp; </span>"+resultados.getRecibioCopiaDA()+"</p>\r\n" ;
//				}
				 
				cuerpoCorreo = cuerpoCorreo +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<center>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//				"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<div style=\"font-family: Arial,sans-serif; color: #808080; font-size: 12px; font-weight: 600;\">En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br />LINEA DE ATENCI&Oacute;N TELEF&Oacute;NICA 01 800 062 3212</div>\r\n" + 
				"</center>\r\n" + 
				"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
				"</div>\r\n" + 
				"</div>";
		
			return cuerpoCorreo;
	}
	
	@Override
	public void envioDeCorreoSOS(Terminal terminal, int rol, int rol2)  {
		
		List<Usuario> usuarioF = this.obtenerUsuarioFrecuencia(terminal.getBase(), rol, rol2);
		ArrayList<String> correos = new ArrayList<>();
		log.info("cantidad de usuario: "+usuarioF.size());
		boolean salida = false;
		CorreoEncuesta correoEncuesta;
		try {
		if (usuarioF != null) {
				for(Usuario usuariosFrecuencia: usuarioF) {
					if (usuariosFrecuencia.getMail() != null) {
						if ( !(correos.contains(usuariosFrecuencia.getMail()))) {
							correos.add(usuariosFrecuencia.getMail());
						} 
						
					}
			 }
		}
		} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | ArrayStoreException | IllegalStateException   e) {
			log.error("Ocurrio un error en: "+e);
		}
		log.info("Correos de usuarios frecuencia: "+correos);
		
		if ( correos.size() > 0) {
			String asunto = null;
			String cuerpoCorreo  =  null;
			asunto = "ALERTA SOS";
			try {
				cuerpoCorreo  = this.cuerpoCorreoSOS(terminal);
			}catch (ClassCastException | IndexOutOfBoundsException | IllegalStateException e) {
				log.info("Ocurrio un error al generar el cuerpo del correo: "+e);
			}
			
log.info("Correos: "+correos);
log.info("Asunto "+asunto);


		try {
			correoEncuesta = new CorreoEncuesta(
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
					configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
					null);
			try {
			 salida = correoEncuesta.enviarEmail(correos, asunto, cuerpoCorreo,null);
			}catch (Exception e) {
				log.info("Error en la salida de envioDeCorreoSOS -> "+e);
			}
			 log.info("Respuesta del envio de mensaje: "+salida);
		}catch (Exception e) {
			log.info("OCURRIO UN ERROR AL ENVIAR EL CORREO: "+e);
		}
		}
	}
	
	public String cuerpoCorreoSOS(Terminal terminal) {
		String cuerpoCorreo = null;
		
		cuerpoCorreo = "<div><center>\r\n" + 
				"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 27px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
				"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
				"</center>\r\n" + 
				"<div>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 20.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 20.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ajustador SOS.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado Supervisor/Coordinador, se le notifica que se ha enviado una alerta de emergencia, favor de consultar el módulo Ajustador SOS para dar seguimiento.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">Ajustador: "+terminal.getNombre()+", con clave "+terminal.getNumeroproveedor()+
				"\r\n" + 
				"<!-- o ignored --></p>\r\n" +  
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n";
				cuerpoCorreo = cuerpoCorreo +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<center>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//				"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"</center>\r\n" + 
				"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
				"</div>\r\n" + 
				"</div>";
		
			return cuerpoCorreo;
	}
	
	@Override
	public void envioDeCorreoCobFlex13(Terminal terminal, String siniestro, String reporte, int rol, int rol2)  {
		
		List<Usuario> usuarioF = this.obtenerUsuarioFrecuencia(terminal.getBase(), rol, rol2);
		ArrayList<String> correos = new ArrayList<>();
		log.info("cantidad de usuario: "+usuarioF.size());
		boolean salida = false;
		CorreoEncuesta correoEncuesta;
		try {
		if (usuarioF != null) {
				for(Usuario usuariosFrecuencia: usuarioF) {
					if (usuariosFrecuencia.getMail() != null) {
						if ( !(correos.contains(usuariosFrecuencia.getMail()))) {
							correos.add(usuariosFrecuencia.getMail());
						} 
						
					}
			 }
		}
		} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | ArrayStoreException | IllegalStateException   e) {
			log.error("Ocurrio un error en: "+e);
		}
		log.info("Correos de usuarios frecuencia: "+correos);
		
		if ( correos.size() > 0) {
			String asunto = null;
			String cuerpoCorreo  =  null;
			asunto = "Afectación Cobertura Extensión RC";
			try {
				cuerpoCorreo  = this.cuerpoCorreoCobFlex13(terminal, reporte, siniestro);
			}catch (ClassCastException | IndexOutOfBoundsException | IllegalStateException e) {
				log.info("Ocurrio un error al generar el cuerpo del correo: "+e);
			}
			
log.info("Correos: "+correos);
log.info("Asunto "+asunto);


		try {
			correoEncuesta = new CorreoEncuesta(
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
					configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
					null);
			try {
			 salida = correoEncuesta.enviarEmail(correos, asunto, cuerpoCorreo,null);
			}catch (Exception e) {
				log.info("Error en la salida de envioDeCorreoSOS -> "+e);
			}
			 log.info("Respuesta del envio de mensaje: "+salida);
		}catch (Exception e) {
			log.info("OCURRIO UN ERROR AL ENVIAR EL CORREO: "+e);
		}
		}
	}
	
	public String cuerpoCorreoCobFlex13(Terminal terminal, String reporte, String siniestro) {
		String cuerpoCorreo = null;
		
		cuerpoCorreo = "<div><center>\r\n" + 
				"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 27px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
				"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
				"</center>\r\n" + 
				"<div>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 20.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 20.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Estimación Ajustador.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado Gerente/Supervisor, se le notifica que la Cobertura Flexible 13 Extensión de Responsabilidad Civil ha sido afectada.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"> El reporte "+reporte+" con número de siniestro "+siniestro+" ha sido atendido por el ajustador "+terminal.getNombre()+", con clave "+terminal.getNumeroproveedor()+". El reporte afectó la Cobertura Flexible 13 Extensión de Responsabilidad Civil."+
				"\r\n" + 
				"<!-- o ignored --></p>\r\n" +  
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n";
				cuerpoCorreo = cuerpoCorreo +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<center>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//				"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"</center>\r\n" + 
				"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
				"</div>\r\n" + 
				"</div>";
		
			return cuerpoCorreo;
	}
}