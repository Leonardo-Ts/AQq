package com.aaq.col.system.webservices;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.persistence.RollbackException;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.TerminalDao;
import com.aaq.col.clases.database.servicios.interfase.BaseServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EstadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTercerosServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteSiseServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.TokenMicroAppGenesis;
import com.aaq.col.clases.xml.webservices.Ajustador;
import com.aaq.col.clases.xml.webservices.AjustadorWebService;
import com.aaq.col.clases.xml.webservices.JMWSResultadoOperacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

@Service("siicaWebService")
@WebService(serviceName = "SIICAWebService", portName = "SIICAWebServicePort", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices", endpointInterface = "com.aaq.col.system.webservices.SIICAWebServiceInterface")
public class SIICAWebService implements SIICAWebServiceInterface {
	private final JMXMLObjectFactory xmlFactory = new JMXMLObjectFactory();

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	private final Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");
	
	@Autowired
	private BaseServiceInterfase baseDao;

	@Autowired
	private EstadoServiceInterfase estadoDao;

	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalDao;

	@Autowired
	private ReporteSiseServiceInterfase reporteSiseDao;

	@Autowired
	private TerminalServiceInterfase terminalDao;

	@Autowired
	private ConfiguracionServiceInterfase configuracionDao;
	
	@Autowired
    private ReporteMovilSacServiceInterfase reporteSacDao;
	
	@Autowired
	private ReporteMovilSacTercerosServiceInterfase reporteMovilSacTercerosDao;
	
	@Autowired
	private HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorDao;
	
	@Resource(name="wsContext")
	WebServiceContext wsContext;
	
	private final String fuenteWS = "SIICA Servicios Web -> SIICA Webservice -> ";
	
	private GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();
	
	/**/
	private String resJason;
	private ResponseEntity<String> responsePush;
	private RestTemplate restTemplate;
	private HttpEntity<?> entity;
	private HttpHeaders requestHeaders = new HttpHeaders();
	private String URI_TO_SEND;
	private String URL_TO_GENESYS;


	public SIICAWebService() {
		super();
	}

	@Override
	public String nuevoReporteParaProveedor(final String numeroReporte, final String numeroProveedor, final String usuario, final String fuente, final Boolean reporteApartado) {

		Boolean permiso_sms_asignacion;
		Boolean permiso_push_asignacion;
		// Validacion de la fuente de asignacion (SAC, SISE, REINGENIERIA)
		if (StringUtils.isBlank(fuente)
				|| StringUtils.isBlank(usuario)
				|| (!StringUtils.equalsIgnoreCase(fuente, "SAC") && !StringUtils.equalsIgnoreCase(fuente, "SISE") && !StringUtils.equalsIgnoreCase(fuente, "REINGENIERIA") && !StringUtils
						.equalsIgnoreCase(fuente, "QMOVIL"))) {
			return "ERROR: Es requerido proporcionar usuario y fuente (SAC,SISE,REINGENIERIA)";
		}

		//Registrar el origen de la peticion(IPREMOTA)
		this.loggerEspecial.info("Invocacion inicial del Servicio! ==> Nuevo Reporte Para Proveedor. Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
				", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
		

		Terminal term = null;
		try {
			// Obtener datos del ajustador al que se le quiere asignar reporte
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedor, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => objetoTerminalParaProveedorYPasswd");
		}

		// Valida que el ajustador se encuentre en Terminal
		if ((term != null)) {
			//**Inicia codigo para Apartar Ajustador para Atender Otro Reporte al dar Termino a Reporte Actual
			if(reporteApartado){
				JSONObject reporteApartadoData = new JSONObject();
				try{
					reporteApartadoData.put("numeroReporte", numeroReporte);
					reporteApartadoData.put("fechaApartado", DateFormatUtils.format(new Date(), "dd/MM/yyyy HH:mm:ss"));
					reporteApartadoData.put("usuario", usuario);
					reporteApartadoData.put("fuente", fuente);
					
					term.setReporteApartado(reporteApartadoData.toString());
					
					term.guardarObjeto();
				}catch(Exception ex){
					this.loggerEspecial.info(numeroReporte + " => Error al guardar datos de reporte apartado. => " + ex);
				}
				return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(true, "OK: Reporte Apartado"));
			}
			//**Termina codigo para Apartar Ajustador para Atender Otro Reporte al dar Termino a Reporte Actual
			
			try {
				permiso_sms_asignacion = this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_PERMISO_SMS_ASIGNACION);
				
				this.loggerEspecial.info(numeroReporte + "=> Ajustador Encontrado! Con Nombre ==>[" + term.getNombre() + "], y Telefono ==>[" + term.getTelefono() + "]");
				
				this.loggerEspecial.info(numeroReporte + "=> SMS Inicial! Inicia Validacion. Telefono ==> [" + term.getTelefono() + "] es de 10 Digitos? ==>["
						+ (StringUtils.length(term.getTelefono()) == 10) + "] Permiso para envio de SMS ==> ["+permiso_sms_asignacion+"]");
				
				if (permiso_sms_asignacion) {
					// Valida que numero de telefono ajustador sea valido
					if ((StringUtils.length(term.getTelefono()) == 10)) {
						
						// Se crea cadena para envio de SMS
						final StringBuilder rep = new StringBuilder("Nuevo Reporte:" + numeroReporte);
						boolean enviado = true;
						
						// Si mensaje es demasiado largo se mete a un array para envio
						// de SMS por separados al alcanzar el max de caracteres
						final ArrayList<String> listaMensajes = JMUtileriaString.romperString(Objects.toString(rep), 153);
						
						// Se recorre la cadena del mensaje
						for (final String texto : listaMensajes) {
							try {
								// Se prepara mensaje para guardar en base de datos
								final MensajeSms mensajeSMS = new MensajeSms();
								mensajeSMS.setFecha(new Date());
								mensajeSMS.setMensajeoriginal(Objects.toString(rep));
								mensajeSMS.setTelefonodestino(term.getTelefono());
								mensajeSMS.setTexto(texto);
								mensajeSMS.setTerminal(this.terminalDao.objetoTerminalParaNumeroTelefono(term.getTelefono()));
								mensajeSMS.setUsuario(null);
								mensajeSMS.setDireccionIp(null);
								mensajeSMS.setNumeroreporte(numeroReporte);
								
								term.getReporteSac().setFechaReporteEnvioSms(new Date());
								term.setProximidad(term.getReporteSac().getProximidad() == null ? false : term.getReporteSac().getProximidad());
								term.getReporteSac().guardarObjeto();
								term.guardarObjeto();
								if (genericoEnviarSMS.enviarSMS(term.getTelefono(), texto)) {
									this.loggerEspecial.info(" => Invocacion del Servicio! ==> Enviar SMS. Respuesta OK.");
									mensajeSMS.guardarObjeto();
									enviado = true;
								} else {
									this.loggerEspecial.info(" => Invocacion del Servicio! ==> Enviar SMS respondio con error");
									enviado = false;
								}
								
								this.loggerEspecial.info(numeroReporte + "=> Validacion Correcta, Se envio el SMS Inicial? ==>[" + enviado + "]");
							} catch (final Exception ex) {
								this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarMensajeSMS", texto, term.getTelefono());
							}
						}
					
					}
				}
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, getClass(), "Obtener valor de configuracion_permiso_sms=>asignacion" );
			}
			
		} else {
			this.loggerEspecial.info(numeroReporte + "=> Este numero de proveedor ==>[" + numeroProveedor + "] no fue encontrado en la base de datos. Ni modo :( ");
		}

		// ----- INICIA VALIDACIONES FUENTE -----
		// INICIA VALIDACION REPORTE ---SISE---REINGENIERIA
		// Valida que la fuente se SISE
		if (!StringUtils.equalsIgnoreCase(fuente, "SAC") && !StringUtils.equalsIgnoreCase(fuente, "QMOVIL")) {
			JMResultadoOperacion respuestaTerminalAsignarReporteSise = null;
							
			//Registrar el origen de la peticion(IPREMOTA)
			this.loggerEspecial.info("Nuevo Reporte Para Proveedor-" + fuente.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
					", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
			try {
				// Ejecuta funcion Terminal Asignar Reporte y se guarda
				// respuesta
				respuestaTerminalAsignarReporteSise = this.terminalDao.ejecutarFuncionTerminalAsignarReporte(null, numeroProveedor, numeroReporte, fuente + " Usuario-> " + usuario, this.fuenteWS
						+ "nuevoReporteParaProveedor", Boolean.FALSE);

				this.loggerEspecial.info(numeroReporte + "=> Ejecucion de Stored Procedure para Asignar Reporte al Ajustador. Resultado ==>[" + respuestaTerminalAsignarReporteSise.getMensaje() + "]");

			} catch (final Exception ex) {
				this.loggerEspecial.error(numeroReporte + "=> EXCEPCION! Ejecucion de Stored Procedure para Asignar Reporte al Ajustador. Mensaje ==>[" + ex.getMessage() + "]");

				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => ejecutarFuncionTerminalAsignarReporte");

			}

			if (!respuestaTerminalAsignarReporteSise.getMensaje().equals("OK")) {
				return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(false, respuestaTerminalAsignarReporteSise.getMensaje()));
			}

			this.loggerEspecial.info(numeroReporte + "=> Vamos ahora a obtener la informacion desde el servicio Web de SISE para este reporte");


		} else {
			// Ahora valida si fuente es SAC

			JMResultadoOperacion respuestaTerminalAsignarReporteSac = null;
			
			//Registrar el origen de la peticion(IPREMOTA)
			this.loggerEspecial.info("Nuevo Reporte Para Proveedor-" + fuente.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
					", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
			try {

				// Ejecuta funcion Terminal Asignar Reporte SAC
				respuestaTerminalAsignarReporteSac = this.terminalDao.ejecutarFuncionTerminalAsignarReporteSac(null, numeroProveedor, numeroReporte, fuente + " Usuario-> " + usuario, this.fuenteWS
						+ "nuevoReporteParaProveedor");

				this.loggerEspecial.info(numeroReporte + "=> Ejecucion de Stored Procedure para Asignar Reporte SAC al Ajustador. Resultado ==>[" + respuestaTerminalAsignarReporteSac.getMensaje()
						+ "]");
				try {
 
					Map<String, String> descActividadAsignacion = new HashMap<>();
					descActividadAsignacion.put("usuario", usuario);
					try {
						if(term.getReporteSac().getServicioAmbulancia() != null && term.getReporteSac().getServicioAmbulancia()) {
							descActividadAsignacion.put("servicioAmbulancia", "SI");
						}
					} catch (Exception e) {
						this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "nuevoReporteParaProveedor => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
	            	
	            	ObjectMapper mapper = new ObjectMapper();
	            	String descActividad = mapper.writeValueAsString(descActividadAsignacion);
	            	
	            this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
							term.getNumeroproveedor(), term.getNombre(), numeroReporte, null, null, "Asignación Reporte",
							usuario, fuente, descActividad, respuestaTerminalAsignarReporteSac.getMensaje());
		           
	    		
				}catch (Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					
					// Se vuelve a intentar el guardado 
					Map<String, String> descActividadAsignacion = new HashMap<>();
					descActividadAsignacion.put("usuario", usuario);
					try {
						if(term.getReporteSac().getServicioAmbulancia() != null && term.getReporteSac().getServicioAmbulancia()) {
							descActividadAsignacion.put("servicioAmbulancia", "SI");
						}
					} catch (Exception e) {
						this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "nuevoReporteParaProveedor => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
	            	ObjectMapper mapper = new ObjectMapper();
	            	String descActividad = mapper.writeValueAsString(descActividadAsignacion);
					this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
								term.getNumeroproveedor(), term.getNombre(), numeroReporte, null, null, "Asignación Reporte",
								usuario, fuente, descActividad, respuestaTerminalAsignarReporteSac.getMensaje());
			       // Fin del segundo intento    
		            	
				}
				
				// Valida respuesta de funcion
				if (!respuestaTerminalAsignarReporteSac.getMensaje().equals("OK")) {
					this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS + "nuevoReporteParaProveedor", 
							"Ejecutar Funcion TerminalAsignarReporteSac", "Respuesta de SIICA -> " + respuestaTerminalAsignarReporteSac.getMensaje());
					return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(false, respuestaTerminalAsignarReporteSac.getMensaje()));
				}

			} catch (final Exception ex) {
				this.loggerEspecial.error(numeroReporte + "=> EXCEPCION! Ejecucion de Stored Procedure para Asignar Reporte SAC al Ajustador. Mensaje ==>[" + ex.getMessage() + "]");
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => ejecutarFuncionTerminalAsignarReporteSac");
				return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(false, ex.getMessage()));
			}
		}
		// ----- FIN VALIDACIONES FUENTE -----

		// ----- INICIA BLOQUE ENVIO DE PUSH ANDROID -----
		// ------Uid_Android----
		// Valida que terminal existe y que tiene AndroidUid
		try {
			permiso_push_asignacion = this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_PERMISO_PUSH_ASIGNACION);
			
			if (permiso_push_asignacion) {
				if (term != null && term.getAndroidUid() != null) {
					this.loggerEspecial.info(numeroReporte + "=> Envio de Token y Mensaje (Push Android) " + "a ServRestful push-services/rest/notification/send/one==> [" + "token: " + term.getAndroidUid()
							+ ", mensaje: (NUEVO REPORTE ASIGNADO: " + numeroReporte + ")] ==>[idApp: com.qualitas.ajustadormovil]");

					try {
						// Prepara objeto JSON para enviar a Servicio WEB
						JSONObject obj = new JSONObject();
						obj.put("idApp", "com.qualitas.ajustadormovil");
						obj.put("token", term.getAndroidUid());
						obj.put("mensaje", "Tu reporte asignado es el " + numeroReporte);

						// Pone tiempo de conexion para esperar respuesta del servidor
						SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
						clientHttpRequestFactory.setConnectTimeout(10000);

						// Prepara la peticion al servidor
						requestHeaders.setContentType(new org.springframework.http.MediaType("application", "json"));
						entity = new HttpEntity<Object>(obj.toString(), requestHeaders);
						restTemplate = new RestTemplate(clientHttpRequestFactory);

						// Obtiene URI del Servicio WEB
						URI_TO_SEND = this.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_WEBSERVICES_RESTFUL_PUSH_SERVICES);

						// Realiza la peticion
						responsePush = restTemplate.exchange(URI_TO_SEND, HttpMethod.POST, entity, String.class);
						resJason = responsePush.getBody();
						this.loggerEspecial.info(numeroReporte + "=> Respuesta ServRestful: [" + resJason + "]");
						
						if(resJason.contains("Ok") && resJason.contains("exito")){
							this.terminalDao.ejecutarFuncionTerminalInsertarFechaPush(term.getId());
							this.loggerEspecial.info(numeroReporte + "=> Se guarda fecha envio PUSH");
						}
						
						this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS, "consumiendoServicioRest: " + "/push-services/rest/notification/send/one",
								"Respuesta ServRest: " + resJason);
					} catch (Exception ex) {
						try {

							this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS,
									"consumiendoServicioRest: " + "/push-services/rest/notification/send/one", "Errro al enviar la informacion!! "+ex);
						} catch (Exception e) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => historicoTerminalDao");
						}
						this.loggerEspecial.info(numeroReporte + "Error: No se Pudo Consumir ServicioRest: " + "/push-services/rest/notification/send/one -> "+ex);
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => consumiendoServicio: /push-services/rest");
					}
				} else {
					// Si validacion de este bloque if-else no fue valida, entonces
					if (term == null) {
						this.loggerEspecial.info(numeroReporte + "=> El ajustador no fue encontrado en la base de datos.No hay envio de Token y Mensaje (Push Android) :(");
					}
					this.loggerEspecial.info(numeroReporte + "=> El Ajustador No cuenta con uid_Android => No hay envio de Token y Mensaje (Push Android)");
				}
			}
		} catch (Exception e) {
			this.utileriaExcepcion.manejarExcepcion(e, getClass(), "Obtener valor de configuracion_permiso_push=>asignacion" );
		}
		
		// ----- FIN BLOQUE ENVIO DE PUSH ANDROID -----
		// ---- INICIA BLOQUE ENVIO DE SMS URL GENESYS
		if(usuario.equals("GENESYS")) {
		try {
			URL_TO_GENESYS = this.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_GENESYS_URL_SMS);
			Boolean permiso_sms = this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_GENESYS_PERMISO_SMS);
			String token = TokenMicroAppGenesis.getToken(numeroReporte);
			if (permiso_sms) {
			
				if (term != null) {
					
					if ((StringUtils.length(term.getTelefono()) == 10)) {
						final StringBuilder rep = new StringBuilder(URL_TO_GENESYS +numeroReporte+token);
						boolean enviado = true;
						final ArrayList<String> listaMensajes = JMUtileriaString.romperString(Objects.toString(rep), 153);
						for (final String texto : listaMensajes) {
							try {
								final MensajeSms mensajeSMS = new MensajeSms();
								mensajeSMS.setFecha(new Date());
								mensajeSMS.setMensajeoriginal(Objects.toString(rep));
								mensajeSMS.setTelefonodestino(term.getTelefono());
								mensajeSMS.setTexto(texto);
								mensajeSMS.setTerminal(this.terminalDao.objetoTerminalParaNumeroTelefono(term.getTelefono()));
								mensajeSMS.setUsuario(null);
								mensajeSMS.setDireccionIp(null);
								mensajeSMS.setNumeroreporte(numeroReporte);
			
								if (genericoEnviarSMS.enviarSMS(term.getTelefono(), texto)) {
									this.loggerEspecial.info(" => Invocacion del Servicio! ==> Enviar SMS Genesys. Respuesta OK.");
									mensajeSMS.guardarObjeto();
									enviado = true;
								} else {
									this.loggerEspecial.info(" => Invocacion del Servicio! ==> Enviar SMS respondio con error");
									enviado = false;
								}
								
							} catch (final Exception ex) {
								this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarMensajeSMS", texto, term.getTelefono());
							}
						}
						this.loggerEspecial.info(numeroReporte + "=> Validacion Correcta, Se envio el SMS Inicial? ==>[" + enviado + "]");
					}
				}else {
					this.loggerEspecial.info(numeroReporte + "=> Este numero de proveedor ==>[" + numeroProveedor + "] no fue encontrado en la base de datos. Ni modo :( ");
				}
			}
		} catch (Exception e) {
			this.utileriaExcepcion.manejarExcepcion(e, getClass(), "nuevoReporteParaProveedor => EnvioSMSGenesys");
		}
		}
		return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(true, "OK"));
	}

	@Override
	public String reasignarReporteParaProveedor(final String numeroReporte, final String numeroProveedor, final boolean esReasignacion, final boolean esSegundaAtencion, final String usuario,
			final String fuente) {

		// Validacion de la fuente de asignacion (SAC, SISE, REINGENIERIA)
		if (StringUtils.isBlank(fuente) || StringUtils.isBlank(usuario)
				|| (!StringUtils.equalsIgnoreCase(fuente, "SAC") && !StringUtils.equalsIgnoreCase(fuente, "SISE") && !StringUtils.equalsIgnoreCase(fuente, "REINGENIERIA"))) {
			return "ERROR: Es requerido proporcionar usuario y fuente (SAC,SISE,REINGENIERIA)";
		}

		// Valida que se envie un ajustador
		if (StringUtils.isBlank(numeroProveedor)) {
			return "ERROR: Es requerido proporcionar el numero de proveedor";
		}
		// Valida que se envie un reporte
		if (StringUtils.isBlank(numeroReporte)) {
			return "ERROR: Es requerido proporcionar el numero de reporte";
		}

		Terminal term = null;
		try {
			// Obtener datos del ajustador al que se le quiere asignar reporte
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedor, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoTerminalParaProveedorYPasswd[" + numeroReporte + "]");
		}
		
		String[] clavesComodin1 = null;
		List<String> containsComodin1 = null;
		try {
			clavesComodin1 = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_SIICA_SERVER_CLAVES_COMODIN).split("\\|");
			containsComodin1 = Arrays.asList(clavesComodin1);
		} catch (Exception e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "reasignarReporteParaProveedor => clavesComodin1[" + numeroReporte + "]");

		}

		// Valida si ajustador existe en Terminal
		if (term == null && !containsComodin1.contains(numeroProveedor) ) {
				return "ERROR: Ajustador No Existente";
		}

		//Registrar el origen de la peticion(IPREMOTA)
		this.loggerEspecial.info("Invocacion incial del Servicio! => Reasignar Reporte Para Proveedor-" + fuente.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + 
		numeroProveedor + "]" +	", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
		
		String fuenteConcatena = fuente;

		// Valida si reasignacion esta marcado
		if ((esReasignacion)) {
			fuenteConcatena += " / REASIGNACION";
		}
		// Valida si segunda atencion esta marcado
		if ((esSegundaAtencion)) {
			fuenteConcatena += " / 2da ATENCION";
		}

		// ----- INICIA VALIDACION REPORTE SAC -----
		if (StringUtils.equalsIgnoreCase(fuente, "SAC")) {
			Boolean seEnvioPush;

			ReporteMovilSac repSac = null;
			List<ReporteMovilSacTerceros> repSacTerceros = null;
			String[] clavesComodin = null;
			List<String> containsComodin = null;
			try {
				repSac = this.reporteSacDao.objetoReporteMovilSac(numeroReporte, null);
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoReporteMovilSac[" + numeroReporte + "]");
			}
			if ((repSac != null) && (repSac.getAjusteAjustadorCodigo() != null) && esReasignacion) {
			if(term != null) {
				if (repSac.getAjusteAjustadorCodigo().equals(term.getNumeroproveedor())) {
					this.loggerEspecial.info(numeroReporte + " => ERROR: Este reporte ya estaba asignado al mismo proveedor que se le esta intentando reasignar");
					return "ERROR: Este reporte ya estaba asignado al mismo proveedor que se le esta intentando reasignar";
				}
			}

				if (repSac.getAjusteAjustadorCodigo() != null) {
					Terminal terminalAnterior = null;
					try {
						clavesComodin = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_SIICA_SERVER_CLAVES_COMODIN).split("\\|");
						terminalAnterior = this.terminalDao.objetoTerminalParaNumeroProveedor(null, repSac.getAjusteAjustadorCodigo());
						repSacTerceros = this.reporteMovilSacTercerosDao.listaDeReporteMovilSacTerceros(numeroReporte, repSac.getAjusteAjustadorCodigo());
					} catch (final Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoTerminalParaNumeroProveedor[" + numeroReporte + "]");
					}
					containsComodin = Arrays.asList(clavesComodin);
					Terminal terminalReasignacion = null;
					if (containsComodin.contains(repSac.getAjusteAjustadorCodigo())) {	
						try {
							this.loggerEspecial.info("Reasignar Reporte Para Proveedor-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
									", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
							JMResultadoOperacion res = this.terminalDao.ejecutarFuncionTerminalAsignarReporteSac(null, numeroProveedor, numeroReporte, fuenteConcatena + " Usuario->" + usuario,
									this.fuenteWS + "reasignarReporteParaProveedor(ClaveComodin) -> [" + repSac.getAjusteAjustadorCodigo() + "]");
							if (res.isExito()) {
								try {
									terminalReasignacion = this.terminalDao.objetoTerminalParaNumeroProveedor(null, numeroProveedor);
									if (terminalReasignacion != null) {
										repSac.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
										repSac.setAjusteAjustadorNombre(terminalReasignacion.getNombre());
										repSac.setAjusteAjustadorOficina(terminalReasignacion.getClaveOficina());
										repSac.setFechaReporteLecturaPorWs(null);
										repSac.guardarObjeto();
										for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTerceros) {
											reporteMovilSacTerceros.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
											reporteMovilSacTerceros.guardarObjeto();
										}
									} else {
										this.loggerEspecial.info(numeroReporte + " => ERROR: No se encontro el proveedor " + numeroProveedor);
										return "No se encontro el proveedor " + numeroProveedor;
									}

								} catch (final Exception ex) {
									this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoTerminalParaNumeroProveedor[" + numeroReporte + "]");
								}
							} else {
								this.loggerEspecial.info(numeroReporte + " => ERROR: Error al recibir respuesta de AsignarReporteSAC -> " + res.getMensaje());
								return "Error al recibir respuesta de AsignarReporteSAC";
							}

						} catch (final Exception ex) {

							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionTerminalAsignarReporteSac[" + numeroReporte + "]");
						}
						repSac.setEsReasignado(new Boolean(esReasignacion));
						repSac.setEsSegundaAtencion(new Boolean(esSegundaAtencion));
						repSac.guardarObjeto();

						seEnvioPush = genericoEnviarSMS.enviarPush(terminalReasignacion, numeroReporte);

						this.loggerEspecial.info("reasignarReporteParaProveedor-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>["
								+ numeroProveedor + "]" + "Se envio PUSH => [" + seEnvioPush + "]");
						
						return "OK";
					}
					if ((terminalAnterior != null) && (terminalAnterior.getReporteSac() != null)) {
						try {
							this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, terminalAnterior, terminalAnterior.getReporteSac().toString(), this.fuenteWS,
									"Reasignacion de Reporte por medio de " + fuente, "Se le removio a esta terminal este reporte por que fue reasignado a otra terminal -> "
											+ terminalAnterior.getReporteSac().toString());
						} catch (final Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionHistoricoTerminalNuevo[" + numeroReporte + "]");
						}
						try {
							JMResultadoOperacion resultadoCancelar = 	this.terminalDao.ejecutarFuncionTerminalCancelarReporteSac(null, terminalAnterior.getNumeroproveedor(), terminalAnterior.getReporteSac().toString(), fuenteConcatena
									+ " Usuario->" + usuario, this.fuenteWS + "reasignarReporteParaProveedor");
							
							this.loggerEspecial.info(numeroReporte + " => Respuesta de SIICA" + resultadoCancelar);	
						} catch (final Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionTerminalCancelarReporte[" + numeroReporte + "]");
							return "ERROR: " + ex.getMessage();

						}
						try {
							this.loggerEspecial.info("Reasignar Reporte-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
									", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
							JMResultadoOperacion res = this.terminalDao.ejecutarFuncionTerminalAsignarReporteSac(null, numeroProveedor, numeroReporte, fuenteConcatena + " Usuario->" + usuario,
									this.fuenteWS + "reasignarReporteParaProveedor");
							if (res.isExito()) {
								try {
									terminalReasignacion = this.terminalDao.objetoTerminalParaNumeroProveedor(null, numeroProveedor);
									if (terminalReasignacion != null) {
										repSac.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
										repSac.setAjusteAjustadorNombre(terminalReasignacion.getNombre());
										repSac.setAjusteAjustadorOficina(terminalReasignacion.getClaveOficina());
										repSac.setFechaReporteLecturaPorWs(null);
										repSac.guardarObjeto();
										for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTerceros) {
											reporteMovilSacTerceros.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
											reporteMovilSacTerceros.guardarObjeto();
										}
									} else {
										final JMResultadoOperacion r = this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(terminalAnterior.getNumeroproveedor(),
							                    JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "solictarInicioDeSession");
										this.loggerEspecial.info(r.getMensaje() + " => Liberar ajustador antiguo " + terminalAnterior.getNumeroproveedor());
										
										this.loggerEspecial.info(numeroReporte + " => No se encontro el proveedor " + numeroProveedor);
										return "No se encontro el proveedor " + numeroProveedor;
									}

								} catch (final Exception ex) {
									this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoTerminalParaNumeroProveedor[" + numeroReporte + "]");
								}
							} else {
								this.loggerEspecial.info(numeroReporte + " => Error al recibir respuesta de AsignarReporteSAC -> " + res.getMensaje());
								return "Error al recibir respuesta de AsignarReporteSAC";
							}

						} catch (final Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionTerminalAsignarReporteSac");
						}

						repSac.setEsReasignado(new Boolean(esReasignacion));
						repSac.setEsSegundaAtencion(new Boolean(esSegundaAtencion));
						repSac.guardarObjeto();
						
						seEnvioPush = genericoEnviarSMS.enviarPush(terminalReasignacion, numeroReporte);

						this.loggerEspecial.info("reasignarReporteParaProveedor-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>["
								+ numeroProveedor + "]" + "Se envio PUSH => [" + seEnvioPush + "]");
						return "OK";
					}else{
						if(terminalAnterior == null){
							this.loggerEspecial.info("No se pudo Cancelar el reporte " + numeroReporte + " al Ajustador actual " + repSac.getAjusteAjustadorCodigo() + " (Ajustador no existente)");
							return "No se pudo Cancelar el reporte " + numeroReporte + " al Ajustador actual " + repSac.getAjusteAjustadorCodigo() + " (Ajustador no existente)";
						}
						this.loggerEspecial.info("No se pudo Cancelar el reporte " + numeroReporte + " al Ajustador actual " + repSac.getAjusteAjustadorCodigo() + "(sin reporte SAC asignado)");
						return "No se pudo Cancelar el reporte " + numeroReporte + " al Ajustador actual " + repSac.getAjusteAjustadorCodigo() + "(sin reporte SAC asignado)";
					}
				}
				this.loggerEspecial.info(numeroReporte + " => ERROR: El Anterior Reporte SAC No Tiene Ajustador");
				return "El Anterior Reporte SAC No Tiene Ajustador";

			} else if ((repSac != null) && (repSac.getAjusteAjustadorCodigo() != null) && esSegundaAtencion) {
				Terminal terminalReasignacion = null;
				try {
					this.loggerEspecial.info("Segunda Atencion-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
							", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
					JMResultadoOperacion res = this.terminalDao.ejecutarFuncionTerminalAsignarReporteSac(null, numeroProveedor, numeroReporte, fuenteConcatena + " Usuario->" + usuario, this.fuenteWS
							+ "reasignarReporteParaProveedor2a");
					if (res.isExito()) {
						try {
							terminalReasignacion = this.terminalDao.objetoTerminalParaNumeroProveedor(null, numeroProveedor);
							repSacTerceros = this.reporteMovilSacTercerosDao.listaDeReporteMovilSacTerceros(numeroReporte, repSac.getAjusteAjustadorCodigo());
							if (terminalReasignacion != null) {
								repSac.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
								repSac.setAjusteAjustadorNombre(terminalReasignacion.getNombre());
								repSac.setAjusteAjustadorOficina(terminalReasignacion.getClaveOficina());
								repSac.setFechaReporteLecturaPorWs(null);
								repSac.guardarObjeto();

								for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTerceros) {
									reporteMovilSacTerceros.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
									reporteMovilSacTerceros.guardarObjeto();
								}
							} else {
								return "No se encontro el proveedor " + numeroProveedor;
							}

						} catch (final Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor2a => objetoTerminalParaNumeroProveedor[" + numeroReporte + "]");
						}
					} else {
						return "Error al recibir respuesta de AsignarReporteSAC2a";
					}
				} catch (final Exception ex) {

					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor2a => ejecutarFuncionTerminalAsignarReporteSac[" + numeroReporte + "]");
				}

				repSac.setEsReasignado(new Boolean(esReasignacion));
				repSac.setEsSegundaAtencion(new Boolean(esSegundaAtencion));
				repSac.guardarObjeto();
				
				seEnvioPush = genericoEnviarSMS.enviarPush(terminalReasignacion, numeroReporte);

				try {
					String actividad = ""; 
					
					if(esReasignacion) {
						actividad = "Reasignacion Reporte";
					}
					
					if(esSegundaAtencion) {
						actividad = "Segunda Atencion Reporte";
					}
					this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
							term.getNumeroproveedor(), term.getNombre(), numeroReporte, null, null,
							actividad, usuario, fuente, actividad, "OK");

				} catch (Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"nuevoReporteParaProveedor => ejecutarFuncionHistoricoResumenAjustadorNuevo");
				}

				this.loggerEspecial.info("2aAtn-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>["
						+ numeroProveedor + "]" + "Se envio PUSH => [" + seEnvioPush + "]");

				return "OK";
			} else {
				return "El Reporte SAC No Esta Registrado En SIICA";
			}
		}
		ReporteSise rep = null;

		try {
			rep = this.reporteSiseDao.objetoReporteSise(numeroReporte);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoReporteSise");

		}

		//Registrar el origen de la peticion(IPREMOTA)
		this.loggerEspecial.info("Reasignar Reporte Para Proveedor-" + fuenteConcatena.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
				", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
		
		if ((rep != null) && (rep.getTerminal() != null) && esReasignacion) {
			if ((rep.getTerminal().getId().intValue() == term.getId().intValue())) {
				return "ERROR: Este reporte ya estaba asignado al mismo proveedor que se le esta intentando reasignar";
			}

			if (rep.getTerminal() != null) {

				Terminal terminalAnterior = null;
				try {
					terminalAnterior = this.terminalDao.objetoTerminal(Objects.toString(rep.getTerminal().getId()));
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoTerminal");
				}

				if ((terminalAnterior != null) && (terminalAnterior.getReporteSise() != null)) {

					try {
						this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, terminalAnterior, terminalAnterior.getReporteSise().getGeneralNumeroReporte(), this.fuenteWS,
								"Reasignacion de Reporte por medio de SISE", "Se le removio a esta terminal este reporte por que fue reasignado a otra terminal -> "
										+ terminalAnterior.getReporteSise().getGeneralNumeroReporte());
					} catch (final Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionHistoricoTerminalNuevo");

					}

					try {
						final JMResultadoOperacion res = this.terminalDao.ejecutarFuncionTerminalCancelarReporte(null, terminalAnterior.getNumeroproveedor(), terminalAnterior.getReporteSise()
								.getGeneralNumeroReporte(), fuenteConcatena + " Usuario->" + usuario, this.fuenteWS + "reasignarReporteParaProveedor");

						return res != null ? res.getMensaje() : "OK";
					} catch (final Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionTerminalCancelarReporte");
						return "ERROR: " + ex.getMessage();

					}

				}

			}

		}

		try {
			rep = this.reporteSiseDao.objetoReporteSise(numeroReporte);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => objetoReporteSise");

		}

		try {
			this.terminalDao.ejecutarFuncionTerminalAsignarReporte(null, numeroProveedor, numeroReporte, fuenteConcatena + " Usuario->" + usuario, this.fuenteWS + "reasignarReporteParaProveedor",
					Boolean.FALSE);
			rep = this.reporteSiseDao.objetoReporteSise(numeroReporte);
		} catch (final Exception ex) {

			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "reasignarReporteParaProveedor => ejecutarFuncionTerminalAsignarReporte");
		}

		if (rep != null) {
			rep.setEsReasignado(new Boolean(esReasignacion));
			rep.setEsSegundaAtencion(new Boolean(esSegundaAtencion));
			rep.guardarObjeto();
		}

		return "OK";
	}

	@Override
	public String insertarFechaHoraParaReporteReasignado(final String numeroReporte, final String numeroProveedor,
			final String fecha, final String hora, final String tipoFecha) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return "ERROR: Es requerido proporcionar el numero de proveedor";
		}
		if (StringUtils.isBlank(numeroReporte)) {
			return "ERROR: Es requerido proporcionar el numero de reporte";
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedor, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"insertarFechaHoraParaReporteReasignado => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return "ERROR: Ajustador No Existente";
		}

		try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, null, this.fuenteWS,
					"Insercion de Fecha y Hora Arribo", "Numero Reporte -> " + numeroReporte + " Proveedor: "
							+ numeroProveedor + " Tipo de Fecha:" + tipoFecha + " Fecha :" + fecha + " Hora:" + hora);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"insertarFechaHoraParaReporteReasignado => ejecutarFuncionHistoricoTerminalNuevo");
		}

		if (term.getReporteSise() == null) {
			return "ERROR: Ajustador No Atiende Reporte";
		}

		if (StringUtils.isBlank(fecha)) {
			return "ERROR: Fecha en blanco";

		}
		if (StringUtils.isBlank(hora)) {
			return "ERROR: Hora en blanco";

		}
		if (StringUtils.isBlank(tipoFecha)) {
			return "ERROR: Tipo de fecha en blanco";
		}
		if (!StringUtils.equalsIgnoreCase(tipoFecha, "arribo") && !StringUtils.equalsIgnoreCase(tipoFecha, "termino")) {
			return "ERROR: Tipo de fecha invalido. Aceptados son 'arribo' y 'termino'";
		}

		final String fuente = BooleanUtils.isTrue(term.getReporteSise().getEsReasignado()) ? "SISE/Reasignacion"
				: BooleanUtils.isTrue(term.getReporteSise().getEsSegundaAtencion()) ? "SISE/2da Atencion" : "SISE";

		Date fechaBien = null;
		try {
			fechaBien = DateUtils.parseDate(fecha + " " + hora,   "yyyy/MM/dd hh:mm:ss" );
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"insertaReporte => insertarFechaHoraParaReporteReasignado");
		}

		if (fechaBien == null) {
			return "ERROR: La fecha no pudo ser interpretada. El formato aceptado es yyyy/MM/dd para fecha y hh:mm:ss para hora";

		}

		if (StringUtils.equalsIgnoreCase(tipoFecha, "arribo")) {
			try {
				this.terminalDao.ejecutarFuncionTerminalEstatusArribo(fechaBien, numeroProveedor, fuente, this.fuenteWS
						+ "insertarFechaHoraParaReporteReasignado");

				if (term.getReporteSise() != null) {
					term.getReporteSise().setCoordLatitudArribo(term.getLatitud());
					term.getReporteSise().setCoordLongitudArribo(term.getLongitud());
					term.getReporteSise().guardarObjeto();
				}
				
				
				
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"insertarFechaHoraParaReporteReasignado => ejecutarFuncionTerminalEstatusArribo");
			}
		}

		if (StringUtils.equalsIgnoreCase(tipoFecha, "termino")) {
			try {
				this.terminalDao.ejecutarFuncionTerminalEstatusTermino(fechaBien, numeroProveedor, fuente,
						this.fuenteWS + "insertarFechaHoraParaReporteReasignado");
				
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"insertarFechaHoraParaReporteReasignado => ejecutarFuncionTerminalEstatusTermino");
			}
		}
		return "OK";
	}


	@Override
	public String cerrarReporteParaProveedor(final String numeroReporte, final String numeroProveedor) {
		return this.cancelarReporteParaProveedor(numeroReporte, numeroProveedor);

	}

	@Override
	public String cancelarReporteParaProveedor(final String numeroReporte, final String numeroProveedor) {

		JMResultadoOperacion res = null;
		try {
			res = this.terminalDao.ejecutarFuncionTerminalCancelarReporte(null, numeroProveedor, numeroReporte,
					JMConstantes.SOCKET_FUENTE_SISE, this.fuenteWS + "cancelarReporteParaProveedor");
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"cancelarReporteParaProveedor => ejecutarFuncionTerminalCancelarReporte");

		}

		if ((res != null) && res.isExito()) {
			return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(true, res
					.getMensaje()));

		}
		return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(false,
				res != null ? res.getMensaje() : "Error"));

	}
	/*
	 * (non-Javadoc)
	 * @see
	 * (java.lang.String, java.util.ArrayList, java.lang.String)
	 */
	@Override
	public boolean enviarSMS(final String numeroOrigen, final ArrayList<String> numerosDestino, final String textoLibre) {

		if (StringUtils.isNotBlank(numeroOrigen) && StringUtils.isNotBlank(textoLibre)) {
				for (final String telefono : numerosDestino) {
					if (StringUtils.containsIgnoreCase(numeroOrigen, "elvis35")) {
						final String[] numeros = StringUtils.split(numeroOrigen, "|");
						if ((numeros != null) && (numeros.length == 2)) {
						}
					} else {
//						if (StringUtils.isNotBlank(textoLibre) && (StringUtils.length(telefono) == 10)) {
						if (StringUtils.isNotBlank(textoLibre)) {
							// String cadenaLibre = convertirCaracteresEspeciales(textoLibre);
							final ArrayList<String> listaMensajes = JMUtileriaString.romperString(textoLibre, 153);
							final MensajeSms mensajeSMS = new MensajeSms();
											
							for (final String texto : listaMensajes) {
								try{
									mensajeSMS.setFecha(new Date());
									mensajeSMS.setMensajeoriginal(textoLibre);
									mensajeSMS.setTelefonodestino(telefono);
									mensajeSMS.setTexto(texto);
									mensajeSMS.setTerminal(this.terminalDao.objetoTerminalParaNumeroTelefono(telefono));
									mensajeSMS.setUsuario(null);
									mensajeSMS.setDireccionIp(null);
									
									if(genericoEnviarSMS.enviarSMS(telefono, texto)){
										mensajeSMS.guardarObjeto();
										return true;
									}else{
										return false;
									}
									
								}catch(Exception ex){
									this.utileriaExcepcion
									.manejarExcepcion(ex, this.getClass(),
											"enviarMensajeSMS => restTemplate.exchange");
								}
							}
						}
						return false;
					}
				}
				return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * cambiarEstatusAjustador(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public String cambiarEstatusAjustador(final String numeroProveedor, final String numeroReporte, final String fecha,
			final String tipoEvento, final String usuario, final String fuente) {

		if (StringUtils.isBlank(numeroProveedor)) {
			return "ERROR: El numero de proveedor esta vacio. Favor de enviar un numero de proveedor de 5 digitos: Ejemplo 12345";
		}

		if (StringUtils.isBlank(numeroReporte)) {
			return "ERROR: El numero de reporte esta vacio. Favor de enviar un numero de reporte como 0409...";

		}
		if (StringUtils.isBlank(fecha)) {
			return "ERROR: La fecha esta vacia. Favor de enviar una fecha como DD/MM/AAAA HH:MM:SS";

		}
		if (StringUtils.isBlank(tipoEvento)) {
			return "ERROR: El tipo de evento esta vacio. Favor de enviar 'arribo' o 'termino' sin las comillas";

		}
		if (!StringUtils.equalsIgnoreCase(tipoEvento, "arribo") && !StringUtils.equalsIgnoreCase(tipoEvento, "termino")) {
			return "ERROR: El tipo de evento es incorrecto. Favor de enviar 'arribo' o 'termino' sin las comillas";

		}
		
		if (StringUtils.isBlank(fuente)||StringUtils.isBlank(usuario)
				|| (!StringUtils.equalsIgnoreCase(fuente, "SAC")
						&& !StringUtils.equalsIgnoreCase(fuente, "SISE") && !StringUtils
							.equalsIgnoreCase(fuente, "REINGENIERIA") 
							&& !StringUtils.equalsIgnoreCase(fuente, "GENESYS"))) {
			return "ERROR: Es requerido proporcionar usuario y fuente (SAC,SISE,REINGENIERIA,GENESYS)";
		}
		
		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedor, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"cambiarEstatusAjustador => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return "ERROR: No se encontro el numero de proveedor solicitado. Favor de enviar uno correcto: Ejemplo 12345";
		}

		try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS,
					"Cambio de Estatus por medio de "+fuente, "Usuario -> "+ usuario +", Proveedor -> " + numeroProveedor + ", Reporte -> "
							+ numeroReporte + ", Fecha -> " + fecha + ", TipoEvento -> " + tipoEvento);
		
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"cambiarEstatusAjustador => ejecutarFuncionHistoricoTerminalNuevo");
		}

		final StringBuilder retorno = new StringBuilder();
		if (StringUtils.equalsIgnoreCase(tipoEvento, "arribo")) {

			JMResultadoOperacion r = null;
			try {
				r = this.terminalDao.ejecutarFuncionTerminalEstatusArribo(new Date(), numeroProveedor,
						fuente+" Usuario-> "+usuario, this.fuenteWS + "cambiarEstatusAjustador");
				
				if (term.getReporteSise() != null) {
					term.getReporteSise().setCoordLatitudArribo(term.getLatitud());
					term.getReporteSise().setCoordLongitudArribo(term.getLongitud());
					term.getReporteSise().guardarObjeto();
				}
				
				if (term.getReporteSac() != null) {
					term.getReporteSac().setCoordLatitudArribo(term.getLatitud());
					term.getReporteSac().setCoordLongitudArribo(term.getLongitud());
					
					if(term.getReporteSac().getAjusteFechaArriboAjustador() == null){
						term.getReporteSac().setAjusteFechaArriboAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
					}
					
					if(term.getReporteSac().getAjusteHoraArriboAjustador() == null){
						term.getReporteSac().setAjusteHoraArriboAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
					}
					
					term.getReporteSac().guardarObjeto();
					
		        	try {
	            		this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(), 
	                			term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
	                			"Insertar Arribo", usuario, fuente, "Insertar Arribo", r.getMensaje());
	            	}catch (Exception ex) {
	            		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "cambiarEstatusAjustador => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
		        	
				}
				
				
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"cambiarEstatusAjustador => ejecutarFuncionTerminalEstatusArribo");

			}
			retorno.append("Fecha de arribo: Insertada a ajustador: " + (r != null ? r.getMensaje() : "ERROR"));
		}
		if (StringUtils.equalsIgnoreCase(tipoEvento, "termino")) {
			JMResultadoOperacion r = null;
			try {
				r = this.terminalDao.ejecutarFuncionTerminalEstatusTermino(new Date(), numeroProveedor,
						fuente+" Usuario-> "+usuario, this.fuenteWS + "cambiarEstatusAjustador");
				
				if (term.getReporteSac() != null) {
					term.getReporteSac().setCoordLatitudTermino(term.getLatitud());
					term.getReporteSac().setCoordLongitudTermino(term.getLongitud());
					
					if(term.getReporteSac().getAjusteFechaTerminoAjustador() == null){
						term.getReporteSac().setAjusteFechaTerminoAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
					}
					
					if(term.getReporteSac().getAjusteHoraTerminoAjustador() == null){
						term.getReporteSac().setAjusteHoraTerminoAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
					}
					
					term.getReporteSac().guardarObjeto();
					
		        	try {
	            		this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(), 
	                			term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
	                			"Insertar Término", usuario, fuente, "Insertar Término", r.getMensaje());
	            	}catch (Exception ex) {
	            		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "cambiarEstatusAjustador => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
		        	
				}
				
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"cambiarEstatusAjustador => ejecutarFuncionTerminalEstatusTermino");
			}
			retorno.append(" Fecha de termino: Insertada a ajustador: " + (r != null ? r.getMensaje() : "ERROR"));
		}
		return Objects.toString(retorno, "");

	}

	@Override
	public AjustadorWebService consultaAjustadores(final String entidad, final String oficina) {
		if (StringUtils.isBlank(entidad)) {
			return new AjustadorWebService(entidad, oficina,
					"ERROR 001: Es necesario proporcionar la clave de entidad", null);
		}

		List<Terminal> lista = null;
		try {
			lista = this.terminalDao.listaDeTerminal(this.estadoDao.objetoEstado(entidad),
					this.baseDao.objetoBase(oficina), null, null, null, null, null, null, null,null,
					TerminalDao.ordenWS,null,null,null,null,null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "consultaAjustadores => listaDeTerminal");
		}

		if ((lista == null) || (lista.size() < 1)) {
			return new AjustadorWebService(entidad, oficina,
					"ERROR 002: La lista de ajustadores para esta entidad y oficina esta vacia", null);
		}

		final ArrayList<Ajustador> l = new ArrayList<>();
		for (final Terminal terminal : lista) {
			l.add(new Ajustador(terminal.getNumeroproveedor(), terminal.getNombre(), terminal.getClaveOficina(),
					terminal.getBase().getNombre(), terminal.getFechaEstatusDisponible()));
		}

		return new AjustadorWebService(entidad, oficina, "OK:" + lista.size(), l);
	}


	@Override
	public String intercambiarReporte(String numeroReporteA, String numeroProveedorA, String numeroReporteB, String numeroProveedorB, 
			String usuario, String fuente) {
		
		if (StringUtils.isBlank(fuente) || StringUtils.isBlank(usuario)
			|| (!StringUtils.equalsIgnoreCase(fuente, "SAC") && !StringUtils.equalsIgnoreCase(fuente, "SISE") && !StringUtils.equalsIgnoreCase(fuente, "REINGENIERIA"))) {
			return "ERROR: Es requerido proporcionar usuario y fuente (SAC,SISE,REINGENIERIA)";
		}

		if (StringUtils.isBlank(numeroProveedorA)) {
			return "ERROR: Es requerido proporcionar el numero de proveedor A";
			}
		if (StringUtils.isBlank(numeroReporteA)) {
			return "ERROR: Es requerido proporcionar el numero de reporte A";
		}
		if (StringUtils.isBlank(numeroProveedorB)) {
			return "ERROR: Es requerido proporcionar el numero de proveedor B";
		}
		if (StringUtils.isBlank(numeroReporteB)) {
			return "ERROR: Es requerido proporcionar el numero de reporte B";
		}

		Terminal termA = null;
		try {
			termA = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedorA, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => objetoTerminalParaProveedorYPasswd[" + numeroReporteA + "]");
		}
		
		Terminal termB = null;
		try {
			termB = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedorB, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => objetoTerminalParaProveedorYPasswd[" + numeroReporteB + "]");
		}
		
		if (termA == null) {
			return "Ajustador A ["+numeroProveedorA+"] no encontrado.";
		}
		if (termB == null) {
			return "Ajustador B ["+numeroProveedorB+"] no encontrado.";
		}
				
		if (termA.getFechaEstatusOcupado() == null) {
			return "ERROR: Ajustador "+numeroProveedorA+" no cuenta con estatus ocupado";
		}
		
		if (termB.getFechaEstatusOcupado() == null) {
			return "ERROR: Ajustador "+numeroProveedorB+" no cuenta con estatus ocupado";
		}

		if (termA.getReporteSac().getGeneralNumeroReporte() == null) {
			return "ERROR: Ajustador A no cuenta con un reporte asignado.";
		}
		
		if (termB.getReporteSac().getGeneralNumeroReporte() == null) {
			return "ERROR: Ajustador B no cuenta con un reporte asignado.";
		}
		
		ReporteMovilSac repSacA = null;
		ReporteMovilSac repSacB = null;
		try {
			// Obtener datos de reporte desde reporte_movil_sac A
			repSacA = this.reporteSacDao.objetoReporteMovilSac(numeroReporteA, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => objetoReporteMovilSac[" + numeroReporteA + "]");
		}
		
		try {
			// Obtener datos de reporte desde reporte_movil_sac B
			repSacB = this.reporteSacDao.objetoReporteMovilSac(numeroReporteB, null);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => objetoReporteMovilSac[" + numeroReporteB + "]");
		}
		if (repSacA == null) {
			return "ERROR: Reporte A "+numeroReporteA+" no encontrado.";
		}
		if (repSacB == null) {
			return "ERROR: Reporte A "+numeroReporteB+" no encontrado.";
		}
		if (repSacA.getAjusteAjustadorCodigo() == null) {
			return "ERROR: Reporte "+numeroReporteA+" no cuenta con Ajustador Codigo";
		}
		if (repSacB.getAjusteAjustadorCodigo() == null) {
			return "ERROR: Reporte "+numeroReporteB+" no cuenta con Ajustador Codigo";
		}
		//Validar que no tenga asigando el reporte la Terminal
		if (termA.getReporteSac().getGeneralNumeroReporte().contains(numeroReporteB)) {
			return "ERROR: El Ajustador A ["+numeroProveedorA+"] tiene asigando el reporte B ["+numeroReporteB+"].";
		}
		if (termB.getReporteSac().getGeneralNumeroReporte().contains(numeroReporteA)) {
			return "ERROR: El Ajustador B ["+numeroProveedorB+"] tiene asigando el reporte A ["+numeroReporteA+"].";
		}
		
		String fuenteConcatena = fuente;
		
		//Registrar el origen de la peticion(IPREMOTA)
		this.loggerEspecial.info("Invocacion incial del Servicio! => Intercambiar Reporte Para Proveedores-" + fuente.toUpperCase() + ". Numero Reporte A ==>[" + numeroReporteA + "], Numero Proveedor A ==>[" + 
		numeroProveedorA + ", Numero Reporte B:"+numeroReporteB+", Numero Proveedor B:"+numeroProveedorB+"]" +	", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
		
		// ----- INICIA VALIDACION REPORTE SAC -----
			Boolean seEnvioPushA;
			Boolean seEnvioPushB;

		// --- Consultar ReporteSac --- ReporteSacTerceros
			List<ReporteMovilSacTerceros> repSacTercerosA = null;
			List<ReporteMovilSacTerceros> repSacTercerosB = null;
			String[] clavesComodin = null;
			List<String> containsComodin = null;
			//Valida que el ajustador que se quiere asignar no sea el mismo que ya tiene asignado
//			Terminal terminalAnteriorA = null;
//			Terminal terminalAnteriorB = null;
				try {
				// Se obtienen las claves comodin desde base para
				clavesComodin = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_SIICA_SERVER_CLAVES_COMODIN).split("\\|");
				// Se obtienen datos del ajustador que tiene el reporte
//				terminalAnteriorA = this.terminalDao.objetoTerminalParaNumeroProveedor(null, repSacA.getAjusteAjustadorCodigo());
//				terminalAnteriorB = this.terminalDao.objetoTerminalParaNumeroProveedor(null, repSacB.getAjusteAjustadorCodigo());
					
				// Se obtienen datos de reporte_movil_sac_terceros
					repSacTercerosA = this.reporteMovilSacTercerosDao.listaDeReporteMovilSacTerceros(numeroReporteA, repSacA.getAjusteAjustadorCodigo());
					repSacTercerosB = this.reporteMovilSacTercerosDao.listaDeReporteMovilSacTerceros(numeroReporteB, repSacB.getAjusteAjustadorCodigo());
				} catch ( Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => objetoTerminalParaNumeroProveedor[" + numeroReporteA + "]");
				}
				containsComodin = Arrays.asList(clavesComodin);
				// En caso de ser una reasignacion a un reporte con clave comodin, entonces se hace una asinagacion normal.
//				Terminal terminalIntercambioA = null;
//				Terminal terminalIntercambioB = null;
				
				if (containsComodin.contains(repSacA.getAjusteAjustadorCodigo())) {	
						// --- Asigna el ReporteSac ---
				try {
					//Registrar el origen de la peticion(IPREMOTA)
					this.loggerEspecial.info("Intercambiar Reporte-" + fuenteConcatena.toUpperCase() + ". Numero Reporte A ==>[" + numeroReporteA + "], Numero Proveedor A ==>[" + numeroProveedorA + "]" +
							" Numero Reporte B ==>[" + numeroReporteB + "], Numero Proveedor B ==>[" + numeroProveedorB + "]" +
					", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
									
					// Se ejecuta funcion Terminal Intercambiat Reporte SAC
					JMResultadoOperacion res = this.terminalDao.ejecutarIntercambioReporte(numeroProveedorA, numeroReporteA, numeroProveedorB,
							numeroReporteB, fuenteConcatena + " Usuario->" + usuario, this.fuenteWS + "intercambiarReporte- Ajustador A -> [" + repSacA.getAjusteAjustadorCodigo() + "] Ajustador B -> ["+repSacB.getAjusteAjustadorCodigo()+"]");
					
					if (res == null) {
						return "ERROR: Ocurrio un error ejecutarIntercambioReporte ";
					}
					
					if (res.isExito()) {
						try {

							// Valida que exista el ajustador nuevo
									repSacA.setAjusteAjustadorCodigo(termB.getNumeroproveedor());
									repSacA.setAjusteAjustadorNombre(termB.getNombre());
									repSacA.setAjusteAjustadorOficina(termB.getClaveOficina());
									repSacA.setFechaReporteLecturaPorWs(null);
									repSacA.guardarObjeto();

								// Prepara datos para actualizar
								for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTercerosA) {
										reporteMovilSacTerceros.setAjusteAjustadorCodigo(termB.getNumeroproveedor());
										reporteMovilSacTerceros.guardarObjeto();
									}
							
							// Valida que exista el ajustador nuevo
									// Prepara datos para actualizar
									repSacB.setAjusteAjustadorCodigo(termA.getNumeroproveedor());
									repSacB.setAjusteAjustadorNombre(termA.getNombre());
									repSacB.setAjusteAjustadorOficina(termA.getClaveOficina());
									repSacB.setFechaReporteLecturaPorWs(null);
									repSacB.guardarObjeto();

								// Prepara datos para actualizar
								for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTercerosB) {
										reporteMovilSacTerceros.setAjusteAjustadorCodigo(termA.getNumeroproveedor());
										reporteMovilSacTerceros.guardarObjeto();
									}
						} catch (final Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReportes => objetoTerminalParaNumeroProveedor[" + numeroReporteA + "]");
						}
					} else {
					   this.loggerEspecial.info(numeroReporteA + " => ERROR: Error al recibir respuesta de intercambiarReporte -> " + res.getMensaje());
						return "Error al recibir respuesta de intercambiarReporte";
						}

					} catch (final Exception ex) {

					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => TERMINAL_INTERCAMBIAR_REPORTE[" + numeroReporteA + "]");
				}

				seEnvioPushA = genericoEnviarSMS.enviarPush(termA, numeroReporteB);
				seEnvioPushB = genericoEnviarSMS.enviarPush(termB, numeroReporteA);

				this.loggerEspecial.info("intercambiarReporte -" + fuenteConcatena.toUpperCase() + ". Numero Reporte A ==>[" + numeroReporteA + "], Numero Proveedor A ==>["
					+ numeroProveedorA + "] Se envio PUSH => [" + seEnvioPushA + "] Numero Reporte B ==>[" + numeroReporteB + "], Numero Proveedor B ==>["+ 
					 numeroProveedorB+"]" + "Se envio PUSH => [" + seEnvioPushB + "]");
								
					return "OK";
					}
				// ************ Termina bloque asignacion clave comodin***************
				// Inicia validacion para cancelar reporte a ajustador
				// Valida que que terminal actual existe, valida que tenga
					try {
						this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, termA, termA.getReporteSac().toString(), this.fuenteWS,
							"Se realizo un intercambio de Reportes " + fuente, "Se intercambio reportes entre Terminales -> "
							+ termA.getReporteSac().toString()+", "+termB.getReporteSac().toString());
						} catch (final ClassCastException| RollbackException | IndexOutOfBoundsException | DatabaseException | DataIntegrityViolationException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => ejecutarFuncionHistoricoTerminalNuevo[" + numeroReporteA+ ", "+numeroProveedorB+"]");
						} catch (Exception e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "intercambiarReporte => ejecutarFuncionHistoricoTerminalNuevo[" + numeroReporteA+ ", "+numeroProveedorB+"]");
						}

					// --- Asigna el ReporteSac ---
					try {
						//Registrar el origen de la peticion(IPREMOTA)
						this.loggerEspecial.info("Reasignar Reporte-" + fuenteConcatena.toUpperCase() + ". Numero Reporte A ==>[" + numeroReporteA + "], Numero Proveedor A ==>[" + numeroProveedorA + "]" +
						", Numero Reporte B ["+numeroReporteB+"], Numero de Proveedor ["+numeroProveedorB+"], Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
					
						// Ejecuta funcion Terminal Asignar Reporte SAC
						JMResultadoOperacion res = this.terminalDao.ejecutarIntercambioReporte( numeroProveedorA, numeroReporteA, numeroProveedorB,
								numeroReporteB, fuenteConcatena + " Usuario->"+usuario, this.fuenteWS+" intercambiarReporte");

						if (res == null) {
							return "ERROR: Ocurrio un error ejecutarIntercambioReporte ";
						}
						if (res.isExito()) {
						try {
							// Valida que ajustador nuevo existe
								repSacB.setAjusteAjustadorCodigo(termA.getNumeroproveedor());
								repSacB.setAjusteAjustadorNombre(termA.getNombre());
								repSacB.setAjusteAjustadorOficina(termA.getClaveOficina());
								repSacB.setFechaReporteLecturaPorWs(null);
								repSacB.guardarObjeto();

							// Prepara datos para actualizar
							for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTercerosA) {
									reporteMovilSacTerceros.setAjusteAjustadorCodigo(termB.getNumeroproveedor());
									reporteMovilSacTerceros.guardarObjeto();
								}
							
							// Valida que ajustador nuevo existe
							repSacA.setAjusteAjustadorCodigo(termB.getNumeroproveedor());
							repSacA.setAjusteAjustadorNombre(termB.getNombre());
							repSacA.setAjusteAjustadorOficina(termB.getClaveOficina());
							repSacA.setFechaReporteLecturaPorWs(null);
							repSacA.guardarObjeto();

							// Prepara datos para actualizar
							for (ReporteMovilSacTerceros reporteMovilSacTerceros : repSacTercerosB) {
									reporteMovilSacTerceros.setAjusteAjustadorCodigo(termA.getNumeroproveedor());
									reporteMovilSacTerceros.guardarObjeto();
								}
						
							} catch (final Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => objetoTerminalParaNumeroProveedor[" + numeroReporteA + ", "+numeroReporteB+"]");
							}
						} else {
							this.loggerEspecial.info(numeroReporteA + " =>"+numeroReporteB+" Error al recibir respuesta de intercambiarReporte -> " + res.getMensaje());
							return "Error al recibir respuesta de intercambiarReporte";
						}

					} catch (final Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "intercambiarReporte => TERMINAL_INTERCAMBIAR_REPORTE");
						return "ERROR: "+ex.getMessage();
					}

					seEnvioPushA = genericoEnviarSMS.enviarPush(termA, numeroReporteB);
					seEnvioPushB = genericoEnviarSMS.enviarPush(termB, numeroReporteA);

					this.loggerEspecial.info("intercambiarReporte-" + fuenteConcatena.toUpperCase() + ". Numero Reporte A ==>[" + numeroReporteA + "], Numero Proveedor A ==>["
					+ numeroProveedorA + "], Numero Reporte B ["+numeroReporteB+"], Numero Proveedor B ["+numeroProveedorB+"], Se envio PUSH => [" + seEnvioPushA + ", y "+seEnvioPushB+"]");
					return "OK";
			}

}

