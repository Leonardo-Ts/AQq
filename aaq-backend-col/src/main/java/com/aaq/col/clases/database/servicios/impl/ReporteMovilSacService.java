package com.aaq.col.clases.database.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.json.JsonException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.sisesac.SegundasAtencion;
import com.aaq.col.clases.database.repositorios.impl.ReporteMovilSacDao;
import com.aaq.col.clases.database.repositorios.impl.SacSP_Dao;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteSiseServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.aaq.col.clases.xml.webservices.JMWSResultadoOperacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
/**
 *
 */
@Service("reporteMovilSacService")
@Transactional
public class ReporteMovilSacService implements ReporteMovilSacServiceInterfase {
	
	private final JMXMLObjectFactory xmlFactory = new JMXMLObjectFactory();
	
	public Log log = LogFactory.getLog(ReporteMovilSacService.class);
	
	private GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();
	
	private final String fuenteWS = "SIICA Servicios Web -> SIICA WEB -> ";

	@Autowired
	@Qualifier("reporteMovilSacDao")
	ReporteMovilSacDao reporteMovilSacDao;


	@Autowired
	private SacSP_Dao sacSP_Dao;
	
	@Autowired
	private TerminalServiceInterfase terminalDao;
	
	@Autowired
	private ConfiguracionServiceInterfase configuracionDao;
	
	@Autowired
	private ReporteSiseServiceInterfase reporteSiseDao;
	
	@Autowired
	private HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorDao;
	
	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalDao;
	
	
	/**/
	private String resJason;
	private ResponseEntity<String> responsePush;
	private RestTemplate restTemplate;
	private HttpEntity<?> entity;
	private HttpHeaders requestHeaders = new HttpHeaders();
	private String URI_TO_SEND;
	
	@Override
	public ReporteMovilSac objetoReporteMovilSac(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacDao.objetoReporteMovilSac(numeroReporte,numeroAjustador);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final ReporteMovilSac rms) {
		JMResultadoOperacion val = this.reporteMovilSacDao.guardarObjeto(rms);
		return val;   
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs(Integer id) {
		return this.reporteMovilSacDao.ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs(id);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos(Integer id, String data) {
		return this.reporteMovilSacDao.ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos(id, data);
	}
	
	@Override
	public List<ReporteMovilSac> listarReporteMovilSac(Date fechaInicial, Date fechaFinal, String estado, String base) {
		return this.reporteMovilSacDao.listarReporteMovilSac(fechaInicial, fechaFinal, estado, base);
	}

	@Override
	public List<EntidadObjeto> listaDeCodigosParaGrafica(Date fechaInicial, Date fechaFinal, String estado, String base) {
		return this.reporteMovilSacDao.listarCodigoResp(fechaInicial, fechaFinal, estado, base);
	}
	
	@Override
	public Boolean verificarReporte(String reporte) {
			List<ReporteMovilSac> reportes = reporteMovilSacDao.listaDeReportesModi(reporte);
			if(reportes.size() > 0) {
				return true;
			} else {
				return false;
		}
	}

	@Override
	public String segundasAtenciones(String reporte, String ajustador,  String usuarioAlta, String observacion, String edo,
			String colonia, String calle, String entre, String refer) {
		SegundasAtencion entrada = new SegundasAtencion();
			entrada.setReporte(reporte);
			entrada.setAjustador(ajustador);
			entrada.setUsuarioAlta(usuarioAlta);
			entrada.setObservacion(observacion);
			if(edo.length() == 1) {
				entrada.setEdoPob("0"+edo+"000");
			}else {
				entrada.setEdoPob(edo+"000");
			}
			
			entrada.setColonia(colonia);
			entrada.setCalle(calle);
			entrada.setEntre(entre);
			entrada.setRefer(refer);

		return this.sacSP_Dao.segundaAtencion(entrada);
	}
	
	@SuppressWarnings("unused")
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

		Terminal term = null;
		try {
			// Obtener datos del ajustador al que se le quiere asignar reporte
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedor, null);
		} catch (final  ClassCastException | IndexOutOfBoundsException | RollbackException ex) {
			log.info("nuevoReporteParaProveedor => objetoTerminalParaProveedorYPasswd");
		} catch (final NoClassDefFoundError |PersistenceException ex) {
			log.info("nuevoReporteParaProveedor => objetoTerminalParaProveedorYPasswd");
		} catch (final NoSuchElementException | DataAccessException ex) {
			log.info("nuevoReporteParaProveedor => objetoTerminalParaProveedorYPasswd");
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
				} catch(JSONException ex){
					this.log.info(numeroReporte + " => Error al guardar datos de reporte apartado. => " + ex);
				} catch(Exception ex){
					this.log.info(numeroReporte + " => Error al guardar datos de reporte apartado. => " + ex);
				}
				return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(true, "OK: Reporte Apartado"));
			}
			//**Termina codigo para Apartar Ajustador para Atender Otro Reporte al dar Termino a Reporte Actual
			
			try {
				permiso_sms_asignacion = this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_PERMISO_SMS_ASIGNACION);
				
				this.log.info(numeroReporte + "=> Ajustador Encontrado! Con Nombre ==>[" + term.getNombre() + "], y Telefono ==>[" + term.getTelefono() + "]");
				
				this.log.info(numeroReporte + "=> SMS Inicial! Inicia Validacion. Telefono ==> [" + term.getTelefono() + "] es de 10 Digitos? ==>["
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
								// Se envia SMS por medio de servicio web, si respuesta
								// es OK se guarda en base de datos
								if (genericoEnviarSMS.enviarSMS(term.getTelefono(), texto)) {
									this.log.info(" => Invocacion del Servicio! ==> Enviar SMS. Respuesta OK.");
									mensajeSMS.guardarObjeto();
									enviado = true;
								} else {
									this.log.info(" => Invocacion del Servicio! ==> Enviar SMS respondio con error");
									enviado = false;
								}
								
								this.log.info(numeroReporte + "=> Validacion Correcta, Se envio el SMS Inicial? ==>[" + enviado + "]");
							} catch (final Exception ex) {
								log.info( "enviarMensajeSMS "+ex);
							}
						}
					
					}
					
					
				}
			} catch (Exception e) {
				log.info("Obtener valor de configuracion_permiso_sms=>asignacion " +e);
			}
			
		} else {
			this.log.info(numeroReporte + "=> Este numero de proveedor ==>[" + numeroProveedor + "] no fue encontrado en la base de datos. Ni modo :( ");
		}

		// ----- INICIA VALIDACIONES FUENTE -----
		// INICIA VALIDACION REPORTE ---SISE---REINGENIERIA
		// Valida que la fuente se SISE
		if (!StringUtils.equalsIgnoreCase(fuente, "SAC") && !StringUtils.equalsIgnoreCase(fuente, "QMOVIL")) {
			JMResultadoOperacion respuestaTerminalAsignarReporteSise = null;
							
			//Registrar el origen de la peticion(IPREMOTA)
//			this.log.info("Nuevo Reporte Para Proveedor-" + fuente.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
//					", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
			try {
				// Ejecuta funcion Terminal Asignar Reporte y se guarda
				// respuesta
				respuestaTerminalAsignarReporteSise = this.terminalDao.ejecutarFuncionTerminalAsignarReporte(null, numeroProveedor, numeroReporte, fuente + " Usuario-> " + usuario, this.fuenteWS
						+ "nuevoReporteParaProveedor", Boolean.FALSE);

				this.log.info(numeroReporte + "=> Ejecucion de Stored Procedure para Asignar Reporte al Ajustador. Resultado ==>[" + respuestaTerminalAsignarReporteSise.getMensaje() + "]");

			} catch (final Exception ex) {
				this.log.error(numeroReporte + "=> EXCEPCION! Ejecucion de Stored Procedure para Asignar Reporte al Ajustador. Mensaje ==>[" + ex.getMessage() + "]");
 
				log.info( "nuevoReporteParaProveedor => ejecutarFuncionTerminalAsignarReporte "+ex);

			}

			if (!respuestaTerminalAsignarReporteSise.getMensaje().equals("OK")) {
				return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(false, respuestaTerminalAsignarReporteSise.getMensaje()));
			}

			this.log.info(numeroReporte + "=> Vamos ahora a obtener la informacion desde el servicio Web de SISE para este reporte");

			ReporteSise reporteSise = null;

			try {
				// Se realiza consulta de reporte a SISE
//				reporteSise = JMReporteSiseWSClient.obtenerReporteSiseParaProveedorYReporte(numeroProveedor, numeroReporte);
			} catch (final Exception ex) {
				this.log.error(numeroReporte + "=> Excepcion!! EL Servicio Web de Sise Excepciona con el mensaje =>" + ex.getMessage());
			}

			this.log.info(numeroReporte + "=> El reporte Obtenido desde SISE Fue ==>[" + reporteSise + "]");

			try {
				// Valida que reporte SISE contenga informacion
				if (reporteSise != null) {
					// Actualiza informacion de reporte SISE en reporte_sise con
					// la informacion obtenida de la consulta a SISE
					final JMResultadoOperacion res = this.reporteSiseDao.ejecutarFuncionReporteSiseActualizar(reporteSise);
					this.log.info(numeroReporte + "=> Se ejecuto el stored procedure de actualizacion de Reporte SISE. Resultado ==>[" + res.getMensaje() + "]");
				}
			} catch (final Exception ex) {
				this.log.error(numeroReporte + "=> EXCEPCION! Ejecucion de Stored Procedure de actualizacion de Reporte SISE. Mensaje ==>[" + ex.getMessage() + "]");

				this.log.info("nuevoReporteParaProveedor => ejecutarFuncionReporteSiseActualizar "+ex);

			}

			// Valida que terminal y reporte sise existen
			if ((term != null) && (reporteSise != null)) {
				
				try {
					permiso_sms_asignacion = this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_PERMISO_SMS_ASIGNACION);
					
					this.log.info(numeroReporte + "=> SMS Principal! Validacion! Telefono ==> [" + term.getTelefono() + "] es de 10 Digitos? ==>["
							+ (StringUtils.length(term.getTelefono()) == 10) + "] Permiso para envio de SMS ==> ["+permiso_sms_asignacion+"]");

					// Se prepara para enviar SMS pero ahora con los datos de
					// reporte
					// Valida telefono de ajustador
					if(permiso_sms_asignacion) {
						if ((StringUtils.length(term.getTelefono()) == 10)) {

							// Prepara cadena de texto para SMS
							final StringBuilder rep = new StringBuilder("Rep: " + numeroReporte + ", Pol: " + reporteSise.getGeneralNumeroPoliza());
							rep.append(", Cond: " + reporteSise.getConductorNombre() + ", Veh: " + reporteSise.getDatosVehiculo());
							rep.append("Dir: " + reporteSise.getDatosUbicacion());
							boolean principal = true;

							// Rompe mensaje hasta el max de caracteres que se pueden
							// enviar por SMS
							final ArrayList<String> listaMensajes = JMUtileriaString.romperString(Objects.toString(rep), 153);

							// Recorre cadena y prepara para enviar por separado SMS (en
							// caso de que exceda max de caracteres)
							for (final String texto : listaMensajes) {
								try {
									// Prepara datos para enviar a base de datos
									final MensajeSms mensajeSMS = new MensajeSms();
									mensajeSMS.setFecha(new Date());
									mensajeSMS.setMensajeoriginal(Objects.toString(rep));
									mensajeSMS.setTelefonodestino(term.getTelefono());
									mensajeSMS.setTexto(texto);
									mensajeSMS.setTerminal(this.terminalDao.objetoTerminalParaNumeroTelefono(term.getTelefono()));
									mensajeSMS.setUsuario(null);
									mensajeSMS.setDireccionIp(null);

									// Envia SMS por medio de servicio web, si respueta
									// es OK guarda en base de datos
									if (genericoEnviarSMS.enviarSMS(term.getTelefono(), texto)) {
										this.log.info(" => Invocacion del Servicio! ==> Enviar SMS. Respuesta OK.");
										mensajeSMS.guardarObjeto();
										principal = true;
									} else {
										this.log.info(" => Invocacion del Servicio! ==> Enviar SMS respondio con error");
										principal = false;
									}

								} catch (final Exception ex) {
									log.info("enviarMensajeSMS"+ texto+" " + term.getTelefono()+ ", "+ex);
								}
							}

							this.log.info(numeroReporte + "=> Validacion Correcta, Se envio el SMS Inicial? ==>[" + principal + "]");

						}
						
					}
				} catch (Exception e) {
					this.log.info("Obtener valor de configuracion_permiso_sms SISE=>asignacion "+e );
				}
			} else {
				// Si la validacion de este bloque if-else no fue valida,
				// entonces valida objetos por separado
				// Valida si fue ajustador el que no existe
				if (term == null) {
					this.log.info(numeroReporte + "=> El ajustador no fue encontrado en la base de datos. No hay SMS para este reporte :(");

				}
				// Valida si fue reporte SISE el que no existe
				if (reporteSise == null) {
					this.log.info(numeroReporte + "=> El reporte no pudo ser consultado en el servicio Web de SISE. No hay SMS para este reporte :(");
				}

			}

		} else {
			// Ahora valida si fuente es SAC

			JMResultadoOperacion respuestaTerminalAsignarReporteSac = null;
			
			//Registrar el origen de la peticion(IPREMOTA)
//			this.log.info("Nuevo Reporte Para Proveedor-" + fuente.toUpperCase() + ". Numero Reporte ==>[" + numeroReporte + "], Numero Proveedor ==>[" + numeroProveedor + "]" +
//					", Invocacion realizada desde => [" + genericoEnviarSMS.obtenerIPRemota(wsContext) + "]");
			try {

				// Ejecuta funcion Terminal Asignar Reporte SAC
				respuestaTerminalAsignarReporteSac = this.terminalDao.ejecutarFuncionTerminalAsignarReporteSac(null, numeroProveedor, numeroReporte, fuente + " Usuario-> " + usuario, this.fuenteWS
						+ "nuevoReporteParaProveedor");

				this.log.info(numeroReporte + "=> Ejecucion de Stored Procedure para Asignar Reporte SAC al Ajustador. Resultado ==>[" + respuestaTerminalAsignarReporteSac.getMensaje()
						+ "]");
				try {
					
					Map<String, String> descActividadAsignacion = new HashMap<>();
					descActividadAsignacion.put("usuario", usuario);
					
					if(term.getReporteSac().getServicioAmbulancia() != null && term.getReporteSac().getServicioAmbulancia()) {
						descActividadAsignacion.put("servicioAmbulancia", "SI");
					}
	            	
	            	ObjectMapper mapper = new ObjectMapper();
	            	String descActividad = mapper.writeValueAsString(descActividadAsignacion);
	            	
	            	this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
							term.getNumeroproveedor(), term.getNombre(), numeroReporte, null, null, "Asignación Reporte",
							usuario, fuente, descActividad, respuestaTerminalAsignarReporteSac.getMensaje());
	            	
				}catch (Exception ex) {
					this.log.info("nuevoReporteParaProveedor => ejecutarFuncionHistoricoResumenAjustadorNuevo "+ex);
				}
				
				// Valida respuesta de funcion
				if (!respuestaTerminalAsignarReporteSac.getMensaje().equals("OK")) {
					this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS + "nuevoReporteParaProveedor", 
							"Ejecutar Funcion TerminalAsignarReporteSac", "Respuesta de SIICA -> " + respuestaTerminalAsignarReporteSac.getMensaje());
					return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(false, respuestaTerminalAsignarReporteSac.getMensaje()));
				}

			} catch (final Exception ex) {
				this.log.error(numeroReporte + "=> EXCEPCION! Ejecucion de Stored Procedure para Asignar Reporte SAC al Ajustador. Mensaje ==>[" + ex.getMessage() + "]");

				this.log.info("nuevoReporteParaProveedor => ejecutarFuncionTerminalAsignarReporteSac "+ex);
				
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
					
					

					this.log.info(numeroReporte + "=> Envio de Token y Mensaje (Push Android) " + "a ServRestful push-services/rest/notification/send/one==> [" + "token: " + term.getAndroidUid()
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
						this.log.info(numeroReporte + "=> Respuesta ServRestful: [" + resJason + "]");
						
						if(resJason.contains("Ok") && resJason.contains("exito")){
							this.terminalDao.ejecutarFuncionTerminalInsertarFechaPush(term.getId());
							this.log.info(numeroReporte + "=> Se guarda fecha envio PUSH");
						}
						
						this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS, "consumiendoServicioRest: " + "/push-services/rest/notification/send/one",
								"Respuesta ServRest: " + resJason);
					} catch (Exception ex) {
						try {

							this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS,
									"consumiendoServicioRest: " + "/push-services/rest/notification/send/one", "Errro al enviar la informacion!!");
						} catch (Exception e) {
							this.log.info("nuevoReporteParaProveedor => historicoTerminalDao "+e);
						}

						this.log.info(numeroReporte + "Error: No se Pudo Consumir ServicioRest: " + "/push-services/rest/notification/send/one");

						this.log.info("nuevoReporteParaProveedor => consumiendoServicio: /push-services/rest");
					}

				} else {
					// Si validacion de este bloque if-else no fue valida, entonces
					// valida objetos por separado
					// Valida que terminal no existe
					if (term == null) {
						this.log.info(numeroReporte + "=> El ajustador no fue encontrado en la base de datos.No hay envio de Token y Mensaje (Push Android) :(");
					}
					this.log.info(numeroReporte + "=> El Ajustador No cuenta con uid_Android => No hay envio de Token y Mensaje (Push Android)");
				}
				
			}
		} catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.log.info( "Obtener valor de configuracion_permiso_push=>asignacion " +e);
		} catch (HttpStatusCodeException e) {
			this.log.info( "Obtener valor de configuracion_permiso_push=>asignacion " +e);
		} catch (CannotGetJdbcConnectionException | PersistenceException | DataIntegrityViolationException e) {
			this.log.info( "Obtener valor de configuracion_permiso_push=>asignacion " +e);
		} catch (JsonException | DataAccessException e) {
			this.log.info( "Obtener valor de configuracion_permiso_push=>asignacion " +e);
		}
		
		// Si proceso fue correcto, Servicio WEB envia respuesta OK
		return this.xmlFactory.obtenerStringParaJMResultadoOperacion(new JMWSResultadoOperacion(true, "OK"));
	}

	@Override
	public JMResultadoOperacion actualizarReporteSegundaAtencion(String reporte, String colonia, String calle, String entreCalle,
			String referencia, String observacion) {
		try {
			String infoCalles = null;
			String refObser = null;
			
			if (StringUtils.isNotBlank(calle)) {
				infoCalles = calle;
			}
			if (StringUtils.isNotBlank(entreCalle)) {
				infoCalles = infoCalles + JMConstantes.PIPE + "entre "+ entreCalle;
			}
			if (StringUtils.isNotBlank(referencia)) {
				refObser = referencia;
			}
			if (StringUtils.isNotBlank(observacion)) {
				refObser = refObser + JMConstantes.PIPE + observacion;
			}
//			log.info("Datos de entrada");
//			log.info("reporte: "+reporte);
//			log.info("colonia: "+colonia);
//			log.info("infoCalles: "+infoCalles);
//			log.info("refObservaciones: "+refObser);
			JMResultadoOperacion salida = 	this.reporteMovilSacDao.actualizarReporteSegundaAtencion(reporte, colonia, infoCalles, refObser);
			return salida;
		} catch ( IndexOutOfBoundsException | DataAccessException | ClassCastException | RollbackException e) {
			log.error("Ocurrio un error en -> "+e);
		} catch ( Exception e) {
			log.error("Ocurrio un error en -> "+e);
		}
		return null;
	}
	
//	public  List<ReporteMovilSac> listaDeReportesACancelar() {
//		return this.reporteMovilSacDao.listaDeReportesACancelar();
//	}
	
	

}