package com.aaq.col.clases.util;


import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

/**
 * @author Arturo de la Cruz
 * Clase para validar mensajes y enviar los SMS a los destinatarios
 */
public class GenericoEnviarSMS {
	
//	public Log log = LogFactory.getLog(GenericoEnviarSMS.class);

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
	
	private final Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");
	
	private String respuestaBroker;
	private ResponseEntity<String> responseEntity;
	private RestTemplate restTemplate;
	private String URI_TO_SEND;
	private String URL;
	private HttpHeaders requestHeaders = new HttpHeaders();
	private ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();
	private HistoricoTerminalServiceInterfase historicoTerminalDao = HistoricoTerminal.getHistoricoTerminalService();
	private final String fuenteWS = "SIICA Servicios Web -> SIICA Webservice -> ";
	
	public GenericoEnviarSMS(){
		
	}

	public String obtenerIPRemota(WebServiceContext wsContext) {
		// Para llamadas locales
		String clientIP = "LOCALSERVER";
		
		if(wsContext.getMessageContext() != null) {
			// Obtener ip de cliente que invoca web service
			MessageContext msg = wsContext.getMessageContext();
			HttpServletRequest req = (HttpServletRequest) msg.get(MessageContext.SERVLET_REQUEST);
			clientIP = req.getRemoteAddr();			
		}

		return clientIP;
	}
	
	public Boolean enviarPush(Terminal term, String numeroReporte){
		HttpEntity<Object> entity;
		// ----- INICIA BLOQUE ENVIO DE PUSH ANDROID -----
		// ------Uid_Android----
		// Valida que terminal existe y que tiene AndroidUid
		if (term != null && term.getAndroidUid() != null) {

			this.loggerEspecial.info(numeroReporte + "=> Envio de Token y Mensaje (Push Android) " + "a ServRestful push-services/rest/notification/send/one==> [" + "token: " + term.getAndroidUid()
					+ ", mensaje: (NUEVO REPORTE ASIGNADO: " + numeroReporte + ")] ==>[idApp: com.qualitas.ajustadormovil]");

			try {
				// Prepara objeto JSON para enviar a Servicio WEB
				JSONObject obj = new JSONObject();
				obj.put("idApp", "com.qualitas.ajustadormovil");
				obj.put("token", term.getAndroidUid());
				obj.put("mensaje", numeroReporte);

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
				responseEntity = restTemplate.exchange(URI_TO_SEND, HttpMethod.POST, entity, String.class);
				respuestaBroker = responseEntity.getBody();

				this.loggerEspecial.info(numeroReporte + "=> Respuesta ServRestful: [" + respuestaBroker + "]");

				this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS + "nuevoReporteAVQ", "consumiendoServicioRest: " + "/push-services/rest/notification/send/one",
						"Respuesta ServRest: " + respuestaBroker);
			} catch (Exception ex) {
				try {

					this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, term, numeroReporte, this.fuenteWS + "nuevoReporteAVQ",
							"consumiendoServicioRest: " + "/push-services/rest/notification/send/one", "Errro al enviar la informacion!!");
					
				} catch (Exception e) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => historicoTerminalDao");
					return false;
				}

				this.loggerEspecial.info(numeroReporte + "Error: No se Pudo Consumir ServicioRest: " + "/push-services/rest/notification/send/one");

				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => consumiendoServicio: /push-services/rest");
				return false;
			}

		} else {
			// Si validacion de este bloque if-else no fue valida, entonces
			// valida objetos por separado
			// Valida que terminal no existe
			if (term == null) {
				this.loggerEspecial.info(numeroReporte + "=> El ajustador no fue encontrado en la base de datos.No hay envio de Token y Mensaje (Push Android) :(");
				return false;
			}
			this.loggerEspecial.info(numeroReporte + "=> El Ajustador No cuenta con uid_Android => No hay envio de Token y Mensaje (Push Android)");
			return false;
		}
		// ----- FIN BLOQUE ENVIO DE PUSH ANDROID -----
		
		return true;
	}
	
	public Boolean enviarPushNotificacion(Terminal term, String numeroReporte){
		HttpEntity<Object> entity;
		// ----- INICIA BLOQUE ENVIO DE PUSH ANDROID -----
		// ------Uid_Android----
		// Valida que terminal existe y que tiene AndroidUid
		if (term != null && term.getAndroidUid() != null) {

			this.loggerEspecial.info(numeroReporte + "=> Envio de Token y Mensaje (Push Android) " + "a ServRestful push-services/rest/notification/send/one==> [" + "token: " + term.getAndroidUid()
					+ ", mensaje: (NUEVO REPORTE ASIGNADO: " + numeroReporte + ")] ==>[idApp: com.qualitas.ajustadormovil]");

			try {
				// Prepara objeto JSON para enviar a Servicio WEB
				JSONObject obj = new JSONObject();
				obj.put("idApp", "com.qualitas.ajustadormovil");
				obj.put("token", term.getAndroidUid());
				obj.put("mensaje", numeroReporte);
				
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
				responseEntity = restTemplate.exchange(URI_TO_SEND, HttpMethod.POST, entity, String.class);
				respuestaBroker = responseEntity.getBody();

				this.loggerEspecial.info(numeroReporte + "=> Respuesta ServRestful: [" + respuestaBroker + "]");

			
			} catch (Exception ex) {
				this.loggerEspecial.info(numeroReporte + "Error: No se Pudo Consumir ServicioRest: " + "/push-services/rest/notification/send/one -> "+ex);
				this.loggerEspecial.info(numeroReporte + "Error: No se Pudo Consumir ServicioRest: " + "/push-services/rest/notification/send/one -> Causa: "+ex.getCause());

				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteParaProveedor => consumiendoServicio: /push-services/rest");
				return false;
			}

		} else {
			// Si validacion de este bloque if-else no fue valida, entonces
			// valida objetos por separado
			// Valida que terminal no existe
			if (term == null) {
				this.loggerEspecial.info(numeroReporte + "=> El ajustador no fue encontrado en la base de datos.No hay envio de Token y Mensaje (Push Android) :(");
				return false;
			}
			this.loggerEspecial.info(numeroReporte + "=> El Ajustador No cuenta con uid_Android => No hay envio de Token y Mensaje (Push Android)");
			return false;
		}
		// ----- FIN BLOQUE ENVIO DE PUSH ANDROID -----
		
		return true;
	}
	
	public boolean enviarSMS(String numeroDestino, String mensajeSMS) {
	 RestTemplate restTemplate;
	 ResponseEntity<String> result = null;
	 long dial = 0;
	 String token = null, apiKey = null, dialBD = null;
	 String lada = null;
	 JSONObject peticion = new JSONObject();
	 String country = null;
	// Obtener datos de BASE
	try {
		URL = this.configuracionDao.obtenerCadena(JMConstantes.SMS_URL);
		apiKey = this.configuracionDao.obtenerCadena(JMConstantes.SMS_APIKEY);
		country = this.configuracionDao.obtenerCadena(JMConstantes.SMS_COUNTRY);
		dialBD = this.configuracionDao.obtenerCadena(JMConstantes.SMS_DIAL);
		token = this.configuracionDao.obtenerCadena(JMConstantes.SMS_TOKEN);
		lada = this.configuracionDao.obtenerCadena(JMConstantes.SMS_LADA);
//		 URL = "https://api.broadcastermobile.com/brdcstr-endpoint-web/services/messaging/";
//		 apiKey = "253"; // MX-> 253   PERU->1169   EL SALVADOR->1173
//		 country = "MX"; // MX-> MX   PERU->PE   EL SALVADOR -> SV
//		 dialBD = "26262"; //MEXICO-> 26262     PERU-> 43434   EL SALVADOR->50370396255L 
//		 lada = "52"; //lada   MX_52+10 DIGITOS   PERU->51+9DIGITOS   EL SALVADOR -> 503 + número a 8 dígitos
//		 token = "1AmeToli6duvWhdZpXgFwm/YzKs=";// PERU gN3ZjbxRpfhRnibPyTNiE6i0Rjc=        EL SALVADOR d3Qo4Ab8SJGAGNXESuQpR3eF8tk=  			MEXICO 1AmeToli6duvWhdZpXgFwm/YzKs=

	} catch (Exception e) {
		this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"GenericoEnviarSMS => enviarSMSMigracion");
		this.loggerEspecial.info("GenericoEnviarSMS EXCEPCION! ==> enviarSMSMigracion(). ERROR al obtener datos de BD ==>[" + e.getMessage() + "]");
		return false;
	}
	
	try {
		if (country.contains("SV")) {
			dial = Long.parseLong(dialBD);
		} else {dial = Integer.parseInt(dialBD); }
	}catch (Exception e) {
		this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"GenericoEnviarSMS => enviarSMSMigracion");
		this.loggerEspecial.info("GenericoEnviarSMS EXCEPCION! ==> enviarSMSMigracion(). ERROR al convertir cadena a long ==>[" + e.getMessage() + "]");
		return false;
	}
		// Crear JSON
		try {
			peticion.put("apiKey", Integer.parseInt(apiKey));
			peticion.put("country", country);
			peticion.put("dial", dial);
			peticion.put("message",mensajeSMS );
			JSONArray arrayNum = new JSONArray();
				arrayNum.put(lada+numeroDestino);  
			peticion.put("msisdns", arrayNum);
			peticion.put("tag", "ENVIO DE SMS");
		} catch (Exception e) {
			this.utileriaExcepcion
			.manejarExcepcion(e, this.getClass(),
					"GenericoEnviarSMS => enviarSMSMigracion");
			this.loggerEspecial.info("GenericoEnviarSMS EXCEPCION! ==> enviarSMSMigracion(). Detalles: Formar JSON ==>[" + e.getMessage() + "]");
			return false;
		}
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(10000);
		clientHttpRequestFactory.setReadTimeout(10000);
		
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Authorization", token); 
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//			log.info("PETICION: "+peticion.toString());		
		 HttpEntity<String> entity = new HttpEntity<String>(peticion.toString(), httpHeaders);
		 restTemplate = new RestTemplate(clientHttpRequestFactory);
//		try {
//		SSLUtil.offSSL();
//		}catch (Exception e) {
//			this.utileriaExcepcion
//			.manejarExcepcion(e, this.getClass(),
//					"GenericoEnviarSMS => enviarSMSMigracion Error de SSL");
//		}
		try {
			result = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
		}catch (Exception ex) {
			this.loggerEspecial.error("Excepcion de restTemplate: "+ex);
			return false;
		}

		this.loggerEspecial.info( "RESPUESTA: "+result.getBody());
		boolean salida = parseoRespuesta(result.getBody());
		return salida ? true : false;
	    
	}
	
	public  boolean parseoRespuesta(String resultado) {
		try {
		JSONObject salida = new JSONObject(resultado);
			int code = salida.getInt("code");
		return code == 0 ? true : false;
		} catch (Exception e) {
			this.loggerEspecial.info("Invocacion del Servicio! ==> parseoRespuesta(). Detalles de error en parseo ==> "+e);
		}
		return false;
	}
	

	
}
