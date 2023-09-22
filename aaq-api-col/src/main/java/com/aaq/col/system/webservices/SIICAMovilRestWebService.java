package com.aaq.col.system.webservices;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaEmail;
import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoResponsabilidadServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EncuestaAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteAbogadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SacSP_ServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SessionExternaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.sac.model.DatosArriboSac;
import com.aaq.col.clases.sac.model.DatosTerminoSac;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.ToJSON;
import com.aaq.col.clases.util.UtileriaFechas;
import com.aaq.col.clases.webservices.movil.*;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioTermino;
import com.aaq.col.clases.xml.webservices.JMWSAsignacionGrua;
import com.aaq.col.clases.xml.webservices.JMWSAsignacionGruaVehiculo;
import com.aaq.col.clases.xml.webservices.JMWSAsignacionProveedor;
import com.aaq.col.clases.xml.webservices.JMWSAsignacionProveedorLesionado;
import com.aaq.col.clases.xml.webservices.Resultado;

public class SIICAMovilRestWebService implements SIICAMovilRestWebServiceInterfase, InitializingBean {
	
	// fabricas
    private final ToJSON jsonFactory = new ToJSON();

    // dao
    @Autowired
    private ConfiguracionServiceInterfase configuracionDao;

    @Autowired
    private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;

    @Autowired
    private SessionExternaServiceInterfase sessionExternaDao;

    @Autowired
    private TerminalServiceInterfase terminalDao;

    @Autowired
    private ReporteAbogadoServiceInterfase reporteAbogadoDao;

    @Autowired
    private EncuestaAjustadorServiceInterfase encuestaDao;
    
    @Autowired
	private UsuarioServiceInterfase usuarioDao;

    @Autowired
    private SIICAWebServiceInterface siicaWebService;
    
    @Autowired
	private HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorDao;
	
    @Autowired
    private SacSP_ServiceInterfase SacSPDao;
    
    @Autowired
	private CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoRespDao;
    
    private final JMXMLObjectFactory factory = new JMXMLObjectFactory();

    private final String fuenteWS = "SIICA Servicios Web -> SIICA Movil Web Service -> ";

    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
    ArrayList<Integer> numeroDatosRegistrados = new ArrayList<Integer>();
    
 // Consumo de URL
 	RestTemplate restTemplate;
 	HttpEntity<Object> entity = new HttpEntity<Object>(null);
 	JSONObject parametros = new JSONObject();
 	String respuestaBroker;
 	String  URL_CUNCURRENT;
 	
    
    public SIICAMovilRestWebService() {
		super();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	//***ACTUALIZADO***
//	@Override
	public GETMovilResultadoOperacion insertarArribo(GETMovilServicioArribo serv) {
		
		if (serv == null) {
            return new GETMovilResultadoOperacion(false, "ERROR: El objeto arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'usuario' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'passwd' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de arribo es nulo");
        }
        if (serv.getFechaHora() != null) {
			UtileriaFechas utilfechas = new UtileriaFechas();
			boolean valida = utilfechas.validarFecha(serv.getFechaHora());
			if (!valida) {
				return new GETMovilResultadoOperacion(false, "Formato de fechaHora no valida. Valido dd/MM/yyyy HH:mm:ss");
			}
		}
        if (StringUtils.isBlank(serv.getPlacas()) && StringUtils.isBlank(serv.getSerie())) {
            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'placas' y 'serie' de arribo es nulo");
        }
        if ((StringUtils.length(serv.getPlacas()) != 3) && (StringUtils.length(serv.getSerie()) != 3)) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es requerido capturar placas o serie de 3 digitos");
        }
        if (StringUtils.isNotBlank(serv.getQuienLlegoPrimero())) {
            if (!StringUtils.equalsIgnoreCase(serv.getQuienLlegoPrimero(), "C")
                    && !StringUtils.equalsIgnoreCase(serv.getQuienLlegoPrimero(), "Q")) {
                return new GETMovilResultadoOperacion(false,
                        "ERROR: Los valores validos para QuienLlegoPrimero son 'C' y 'Q'. Se recibio: '"
                                + serv.getQuienLlegoPrimero() + "'");
            }
        }
        
        if (StringUtils.isBlank(serv.getUbicacionCorrecta())) {
            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'ubicacionCorrecta' es un valor obligatorio.");
        }
        
        if (StringUtils.isNotBlank(serv.getUbicacionCorrecta())) {
            if (!StringUtils.equalsIgnoreCase(serv.getUbicacionCorrecta(), "SI")
                    && !StringUtils.equalsIgnoreCase(serv.getUbicacionCorrecta(), "NO")) {
                return new GETMovilResultadoOperacion(false,
                        "ERROR: Los valores validos para ubicacionCorrecta son 'SI' y 'NO'. Se recibio: '"
                                + serv.getUbicacionCorrecta() + "'");
            }
        }
        
        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarArribo => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new GETMovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
        }
      //***  SAC
        if (term.getReporteSac() != null) {
        	String reporteSAC = null;
        	if (term.getReporteSac().getGeneralNumeroReporte() != null) {
				reporteSAC = term.getReporteSac().getGeneralNumeroReporte();
			}
			// Se graba lo que llega
			try {
				this.historicoTerminalServiceInterfase
						.ejecutarFuncionHistoricoTerminalNuevo(null, term,
								reporteSAC, this.fuenteWS + "insertarArribo",
								"Arribo Movil V3",
								"Ejecucion del Metodo Con Datos -> "
										+ this.jsonFactory.obtenerString(serv));
			} catch (final Exception ex) {
				this.utileriaExcepcion
						.manejarExcepcion(ex, this.getClass(),
								"insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
			}

			if (StringUtils.isNotBlank(serv.getPlacas()))  {
				if(!serv.getPlacas().equals("")){
					if(term.getReporteSac().getVehiculoPlacas().length() >= 3) {
						if(!term.getReporteSac().getVehiculoPlacas().substring(term.getReporteSac().getVehiculoPlacas().length() - 3).equals(serv.getPlacas())){
							return new GETMovilResultadoOperacion(false, "ERROR: Las placas del vehiculo no corresponden.");
						}
					}
					
					if(term.getReporteSac().getVehiculoPlacas().equalsIgnoreCase("SP") && !serv.getPlacas().equalsIgnoreCase("SP")) {
						return new GETMovilResultadoOperacion(false, "ERROR: Las placas del vehiculo no corresponden.");
					}
				}
			}
			
			if (StringUtils.isNotBlank(serv.getSerie())) {
				if(!serv.getSerie().equals("")){
					if(term.getReporteSac().getVehiculoPlacas().length() >= 3) {
						if(!term.getReporteSac().getVehiculoSerie().substring(term.getReporteSac().getVehiculoSerie().length() - 3).equals(serv.getSerie())){
							return new GETMovilResultadoOperacion(false, "ERROR: La serie del vehiculo no corresponde.");
						}
					}
					
					if(term.getReporteSac().getVehiculoSerie().equalsIgnoreCase("SP") && !serv.getSerie().equalsIgnoreCase("SP")){
						return new GETMovilResultadoOperacion(false, "ERROR: La serie del vehiculo no corresponde.");
					}
				}
			}
            //*** Manda DATOS para SAC(Si la informacion se guardo bien en Oracle ejecuto impacto en mi BD)
			UtileriaFechas utileria = new UtileriaFechas();
			Map<String, String> respuesta = utileria.fechaHoraArriboSacAQ(serv.getFechaHora(), true);
			String fechaSac = null;
			String horaSac = null;
			if (respuesta != null) {
				 fechaSac = respuesta.get("fecha");
	  			 horaSac = respuesta.get("hora");
			}
			
			 final DatosArriboSac datosParaSac = new DatosArriboSac();
			 datosParaSac.setFechaArribo(fechaSac);
			 datosParaSac.setHoraArribo(horaSac);
			 datosParaSac.setPlacas(StringUtils.length(serv.getPlacas()) == 3 ? StringUtils.upperCase(serv.getPlacas()) : null);
			 datosParaSac.setSerie(StringUtils.length(serv.getSerie()) == 3 ? StringUtils.upperCase(serv.getSerie()) : null);
			 datosParaSac.setReporte(term.getReporteSac().toString());
			 datosParaSac.setUsuario(term.getNumeroproveedor());
			 datosParaSac.setQuienLlegoPrimero(serv.getQuienLlegoPrimero());
			 datosParaSac.setTramoCarretero(serv.getTramoCarretero());
			 datosParaSac.setLatitud(term.getLongitud());
			 datosParaSac.setLongitud(term.getLatitud());
			 datosParaSac.setDistanciaAlArribo(serv.getDistanciaAlArribo());
			 datosParaSac.setProximidad(1); // Para Arribo por placas o serie
			 if (StringUtils.isNotBlank(serv.getUbicacionCorrecta())) {
				if (serv.getUbicacionCorrecta().contains("SI")) {
					datosParaSac.setUbicacionCorrecta(1);
				}
				if (serv.getUbicacionCorrecta().contains("NO")) {
					datosParaSac.setUbicacionCorrecta(0);
				}
			}

			 String respuestaSac = null;
		        
		     // Se graba el envio
		        try {
		            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,
		                    this.fuenteWS + "insertarArribo", "Arribo Movil V3",
		                    "Envio a SAC -> " + this.jsonFactory.obtenerString(datosParaSac));
		        } catch (final Exception ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
		        }

		        try {
		            respuestaSac = this.SacSPDao.arriboSac(datosParaSac);
		        } catch (final Exception e) {

		            // Se graba la excepcion
		            try {
		                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,
		                        this.fuenteWS + "insertarArribo", "Arribo Movil V3",
		                        "MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
		            }

		            return new GETMovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje: " + e.getMessage());
		        }

		        // Se graba la respuesta
		        try {
		            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,
		                    this.fuenteWS + "insertarArribo", "Arribo Movil V3", "Respuesta de SAC -> " + respuestaSac);
		        } catch (final Exception ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
		        }

		        if (respuestaSac == null) {
		            return new GETMovilResultadoOperacion(false, "ERROR: La respuesta de SAC es nula");
		        }
		        
		        if ( StringUtils.containsIgnoreCase(respuestaSac, "OK")) {
		        	
		        	try {
	            		this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(), 
	                			term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
	                			"Insertar Arribo", serv.getUsuario(), "Dispositivo Móvil", "Insertar Arribo", respuestaSac);
	            	}catch (Exception ex) {
	            		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "insertarArribo => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
		        	
		        	//*** Guardar en ReporteMovilSac
					try {
						if (term.getReporteSac() != null) {
							// Validar si ya existe fecha y hora de Arribo
							// Si no existen fecha y hora se actualizan los campos
							UtileriaFechas utileriaF = new UtileriaFechas();
				  			Map<String, String> respuestaQA = utileriaF.fechaHoraArriboSacAQ(serv.getFechaHora(), false);
				  			String fechaQA = null;
				  			String horaQA = null;
				  			if (respuestaQA != null) {
	  				  			fechaQA = respuestaQA.get("fecha");
	  				  			horaQA = respuestaQA.get("hora");
							}
				  			
							if( StringUtils.isBlank(term.getReporteSac().getAjusteFechaArriboAjustador() ) ) {
									term.getReporteSac().setAjusteFechaArriboAjustador(fechaQA);

							}
							
							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraArriboAjustador()) ){
									term.getReporteSac().setAjusteHoraArriboAjustador(horaQA);
							}

							term.getReporteSac().setQuienLlegoPrimero(serv.getQuienLlegoPrimero());
							term.getReporteSac().setTramoCarretero(serv.getTramoCarretero());
							term.getReporteSac().setCoordLatitudArribo(term.getLatitud());
							term.getReporteSac().setCoordLongitudArribo(term.getLongitud());
							term.getReporteSac().setDistanciaAlArribo(serv.getDistanciaAlArribo());
							term.getReporteSac().setLongitudArriboAsegurado(serv.getLongitudArriboAsegurado());
							term.getReporteSac().setLatitudArriboAsegurado(serv.getLatitudArriboAsegurado());
							term.getReporteSac().setArribloCloud(serv.getArriboCloud());
							term.getReporteSac().setUbicacionCorrecta(serv.getUbicacionCorrecta());
							term.getReporteSac().guardarObjeto();
						}

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"insertarArribo => guardarObjeto_ReporteMovilSac en SIICA");
					}
		        	
		        	//*** Poner Estatus Arribo	
					try {
						// Validar fecha estatus arribo, si campo es null obtiene fecha actual, de lo contrario envia la fecha que ya tiene guardada
//						Date fechaArribo = new Date();
						UtileriaFechas util = new UtileriaFechas();
						Date fechaArribo = util.convertirFecha(serv.getFechaHora());
						
						if(term.getFechaEstatusArribo() != null){
							fechaArribo = term.getFechaEstatusArribo();
						}
						
						this.terminalDao.ejecutarFuncionTerminalEstatusArribo(fechaArribo, serv.getUsuario(),
		                        JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "insertarArribo");
						
		                return new GETMovilResultadoOperacion(true, "OK");
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarArribo => ejecutarFuncionTerminalEstatusArriboSac");
		                return new GETMovilResultadoOperacion(false, ex.getMessage());
		            }

		        	
				}
		        return new GETMovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);		
	   }
        return new GETMovilResultadoOperacion(false, "ERROR Intente más tarde.");
        
    }


	//*** ACTUALIZADO ***
//	@Override
	public GETMovilResultadoOperacion insertarTermino(
			GETMovilServicioTermino serv) {
		  if (serv == null) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El objeto termino es nulo");
	        }
	        if (StringUtils.isBlank(serv.getUsuario())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'usuario' de termino es nulo");
	        }
	        if (StringUtils.isBlank(serv.getPasswd())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'passwd' de termino es nulo");
	        }
	        if (StringUtils.isBlank(serv.getFechaHora())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de termino es nulo");
	        }
	        if (StringUtils.isBlank(serv.getAseguradoCorreo())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El campo 'aseguradoCorreo' de termino es nulo");
	        }
	        
	        if (serv.getPolizaTurista() == null ) {
				return new GETMovilResultadoOperacion(false, "ERROR: Es nesario especificar 'true' o 'false' en campo 'polizaTurista'");

			} 
	        
	        if (serv.getPolizaTurista() != false  && serv.getPolizaTurista() != true  ) {
				return new GETMovilResultadoOperacion(false, "ERROR: Es nesario especificar 'true' o 'false' en campo 'polizaTurista'");
			}  
	       
	        if (serv.getPolizaTurista()) {
				if (serv.getNumeroPolizaTurista() != null &&  serv.getNumeroPolizaTurista().length() > 1 ) {
					if (serv.getNumeroPolizaTurista().length() > 10 ) 
						return new GETMovilResultadoOperacion(false, "ERROR: El campo 'numeropolizaTurista' debe ser maximo 10 digitos") ;
				}  else {
					return new GETMovilResultadoOperacion(false, "ERROR: Es nesario especificar el campo 'numeroPolizaTurista'") ;
				}
				
				if (serv.getIncisoPolizaTurista() != null  &&  serv.getIncisoPolizaTurista().length() > 1) {
					if (serv.getIncisoPolizaTurista().length() > 4 ) 
						return new GETMovilResultadoOperacion(false, "ERROR: El campo 'incisoPolizaTurista' debe ser maximo 4 digitos") ;
				}  else {
					return new GETMovilResultadoOperacion(false, "ERROR: Es nesario especificar el campo 'incisoPolizaTurista'") ;
				}
			}
	        
	        
	        Terminal term = null;
	        try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "insertarTermino => objetoTerminalParaProveedorYPasswd");
	        }

	        if (term == null) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El nombre de usuario o passwd son invalidos");
	        }

	        // Se graba lo que llega
	        try {
	            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
	                    this.fuenteWS + "insertarTermino", "Termino Movil V3", "Ejecucion del Metodo Con Datos -> "
	                            + this.jsonFactory.obtenerString(serv));
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "insertarTermino => ejecutarFuncionHistoricoTerminalNuevo");
	        }
	        //***  SAC
	        if (term.getReporteSac() != null) {
	        	List<String> containsPolizaEspecial = null;
	        	String[] polizaEspecial = null;
				try {
					polizaEspecial = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_SIICA_INSERTARARCA_POLIZAS).split("\\|");
				} catch (Exception ex) {
					 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
			                    "insertarTermino => obtenerPolizasEspeciales");
				}
	        	containsPolizaEspecial = Arrays.asList(polizaEspecial);
	        	
				if (!(term.getReporteSac().getDatosArca() != null && term.getReporteSac().getDatosArca() == true) && containsPolizaEspecial
						.contains(StringUtils.trim(term.getReporteSac().getGeneralNumeroPoliza()))) {
					return new GETMovilResultadoOperacion(false, "ERROR: NO SE CAPTURARON DATOS ARCA/HEINEKEN. FAVOR DE REGISTRARLOS.");
				}
	        	
				char[] caracteresEspeciales = {'\u00A1','\u0021','\u0022','\u0023','\u0024','\u0025','\u0026','\u002F','\u0028','\u0029','\u003D','\u003F','\u00BF','\u007B','\u007D','\u005B','\u005D','\u003A','\u002E','\u002D','\u005F','\u002A','\u002B', '\u05F3', '\u00B4', ' '};
				
				if(MovilServicioTermino.containsAny(serv.getSerieAsegurado(), caracteresEspeciales)) {
					return new GETMovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR.");
				}
				
				if(MovilServicioTermino.containsAny(serv.getPlacas(), caracteresEspeciales)) {
					return new GETMovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR."); 
				}
				
				if(MovilServicioTermino.containsAny(serv.getMotorAsegurado(), caracteresEspeciales)) {
					return new GETMovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR."); 
				}
				
	        	final DatosTerminoSac datosSac = new DatosTerminoSac();
	            datosSac.setFechaTermino(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
	            datosSac.setHoraTermino(DateFormatUtils.format(new Date(), "HH:mm:ss"));
	            datosSac.setReporte(term.getReporteSac().toString());
	            datosSac.setAseguradoCorreo(serv.getAseguradoCorreo());
	            datosSac.setObservaciones(serv.getObservaciones());
	            datosSac.setSerieAsegurado(serv.getSerieAsegurado());
	            datosSac.setDescripcionDanosPrexistentes(serv.getDescripcionDanosPrexistentes());
	            datosSac.setPlacas(serv.getPlacas());
	            datosSac.setColorAsegurado(serv.getColorAsegurado());
	            datosSac.setMotorAsegurado(serv.getMotorAsegurado());
	            datosSac.setCodigoResponsabilidad(serv.getCodigoResponsabilidad());

	            if (StringUtils.isNotBlank(serv.getPreAveriguacion())) {
	                datosSac.setAveriguacion(serv.getPreAveriguacion());
	            }

	            if (serv.getDatosRepuve() != null) {
	                datosSac.setAveriguacionPrevia(serv.getDatosRepuve().getAveriguacionFecha());
	                datosSac.setEntidad(serv.getDatosRepuve().getEntidadFederativa());
	                datosSac.setMunicipio(serv.getDatosRepuve().getMunicipio());
	                datosSac.setNumAveriguacion(serv.getDatosRepuve().getAveriguacionNumero());
	            }
	         
	            final String robo = BooleanUtils.isTrue(serv.getRoboLocalizado()) ? "1" : "0";
	            datosSac.setRoboLocalizado(robo);
	            
	            if (serv.getDatosRobo() != null) {
	                datosSac.setRoboDependencia(serv.getDatosRobo().getDependencia());
	                datosSac.setRoboLocalizadoEn(serv.getDatosRobo().getLocalizadoEn());
	                datosSac.setRoboFecha(serv.getDatosRobo().getFecha());
	                datosSac.setRoboTel(serv.getDatosRobo().getTelefono());
	            }
	            
	            datosSac.setEstadoUnidad(serv.getEstadoUnidad() ? "1" : null);
	            datosSac.setMotivoNoInsp(serv.getMotivoNoInsp());
	            
	            // Se añade clave Accidente para SAC
	            datosSac.setCvAccidente(serv.getCvAccidente());

	            //Polizas especiales 
	            final String polizaT = BooleanUtils.isTrue(serv.getPolizaTurista()) ? "S" : "N";
	            datosSac.setPolizaTurista(polizaT);
	            if (serv.getPolizaTurista()) {
	            	 datosSac.setNumeroPolizaTurista(serv.getNumeroPolizaTurista());
	                 datosSac.setIncisoPolizaTurista(serv.getIncisoPolizaTurista());
				}
	           
	            // Codigo de Responsabilidad DUA
	            datosSac.setCodigoResponsabilidadDUA(serv.getCodigoResponsabilidadDUA());
	            
	            // Se graba el envio
	            try {
	                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().toString(),
	                        this.fuenteWS + "insertarTermino", "Termino Movil V3",
	                        "Envio a SAC -> " + this.jsonFactory.obtenerString(datosSac));
	            } catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "insertarTermino => ejecutarFuncionHistoricoTerminalNuevo");
	            }

	            Map<String, String> respuestaSac = null;

	            try {
	            	respuestaSac = this.SacSPDao.terminoSac(datosSac, term);
	            } catch (final Exception e) {
	                // Se graba la excepcion
	                try {
	                    this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().toString(),
	                            this.fuenteWS + "insertarTermino", "Termino Movil V3",
	                            "MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
	                } catch (final Exception ex) {
	                    this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "insertarTermino => ejecutarFuncionHistoricoTerminalNuevo");
	                }

	                return new GETMovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje: " + e.getMessage());
	            }

	            // Se graba la respuesta de SAC
	            try {
	                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().toString(),
	                        this.fuenteWS + "insertarTermino", "Termino Movil V3", "Respuesta de SAC -> " + respuestaSac);
	                
	                if ((respuestaSac != null) && !StringUtils.equalsIgnoreCase(respuestaSac.get("salida").toString(), "null")) {
	                	if(respuestaSac.get("salida").toString().contains("ERROR SAC")){
	               	 return new GETMovilResultadoOperacion(false, "SOLICITAR TERMINO DE SU ATENCION A CABINA O INTENTAR NUEVAMENTE.");
	               }
	                }
	                
	            } catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "insertarTermino => ejecutarFuncionHistoricoTerminalNuevo");
	            }

	            if (respuestaSac == null) {
	                return new GETMovilResultadoOperacion(false, "ERROR: La respuesta de SAC es nula");
	            }
	            
	            try {
	            	CatalogoCodigoResponsabilidad catalogoCodigoResponsabilidad = new CatalogoCodigoResponsabilidad();
	            	try {
	            		catalogoCodigoResponsabilidad = catalogoCodigoRespDao.objetoCatalogoCodigoResponsabilidadClave(serv.getCodigoResponsabilidad());
					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarTermino => obtenerDescResponsabilidad");
					}
	            	
	            	Map<String, Object> descAtividadTermino = new HashMap<>();
	            	Map<String, String> datosRobo = new HashMap<>();
	            	
	            	descAtividadTermino.put("observaciones", serv.getObservaciones());
	            	descAtividadTermino.put("codigoResp", serv.getCodigoResponsabilidad());
	            	descAtividadTermino.put("descCodigoResp", (catalogoCodigoResponsabilidad != null ? catalogoCodigoResponsabilidad.getDescripcion() : ""));
	            	descAtividadTermino.put("descDaniosPre", serv.getDescripcionDanosPrexistentes());
	            	
	            	if(serv.getDatosRobo() != null) {
	            		datosRobo.put("placasAsegurado", serv.getPlacas());
	            		datosRobo.put("serieAsegurado", serv.getSerieAsegurado());
	            		datosRobo.put("averiguacionPrev", serv.getPreAveriguacion());
	            		datosRobo.put("motor", serv.getMotorAsegurado());
	            		datosRobo.put("color", String.valueOf(serv.getColorAsegurado()));
	            		
	            		descAtividadTermino.put("datosRobo", datosRobo);
	            	}
	            	
	            	ObjectMapper mapper = new ObjectMapper();
	            	String descActividad = mapper.writeValueAsString(descAtividadTermino);
	            	
	            	if(StringUtils.containsIgnoreCase(respuestaSac.get("salida").toString(), "OK")) {
						try {
							this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
									term.getNumeroproveedor(), term.getNombre(),
									term.getReporteSac().getGeneralNumeroReporte(),
									term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(),
									"Insertar Término", serv.getUsuario(), "Dispositivo Móvil", descActividad,
									respuestaSac.get("salida").toString());
						} catch (Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarTermino => ejecutarFuncionHistoricoResumenAjustadorNuevo");
						}
					}
	            	
	        	}catch (Exception ex) {
	        		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "insertarTermino => ejecutarFuncionHistoricoResumenAjustadorNuevo");
				}
	            
	            if (StringUtils.containsIgnoreCase(respuestaSac.get("salida").toString(), "OK")) {
	            	
		        	//*** Guardar en ReporteMovilSac    	
					try {
						if (term.getReporteSac() != null) {

							//Validar fecha y hora de termino
							//Si no existen fecha y hora de termino se actualizan los campos
							if(StringUtils.isBlank(term.getReporteSac().getAjusteFechaTerminoAjustador()) ){
								term.getReporteSac().setAjusteFechaTerminoAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
							}
							
							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraTerminoAjustador()) ){
								term.getReporteSac().setAjusteHoraTerminoAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
							}

							term.getReporteSac().setCoordLatitudTermino(term.getLatitud());
							term.getReporteSac().setCoordLongitudTermino(term.getLongitud());
							term.getReporteSac().setGeneralCorreoAsegurado(serv.getAseguradoCorreo());
							term.getReporteSac().setGeneralObservacion(serv.getObservaciones());
					       
								term.getReporteSac().setCodigoResponsabilidad(serv.getCodigoResponsabilidad());

					            if (StringUtils.isNotBlank(serv.getPreAveriguacion())) {
					            	term.getReporteSac().setPreAveriguacion(serv.getPreAveriguacion());
					            }

					            if (serv.getDatosRepuve() != null) {
					            	term.getReporteSac().setRepuveAveriguacionPreviaFecha(serv.getDatosRepuve().getAveriguacionFecha());
					            	term.getReporteSac().setRepuveEntidadFederativa(serv.getDatosRepuve().getEntidadFederativa());
					            	term.getReporteSac().setRepuveMunicipio(serv.getDatosRepuve().getMunicipio());
					            	term.getReporteSac().setRepuveNumeroAveriguacion(serv.getDatosRepuve().getAveriguacionNumero());
					            }
					            
					            term.getReporteSac().setRoboLocalizado(serv.getRoboLocalizado());
					         
					            if (serv.getDatosRobo() != null) {
					            	term.getReporteSac().setRoboDependencia(serv.getDatosRobo().getDependencia());
					            	term.getReporteSac().setRoboLocalizadoEn(serv.getDatosRobo().getLocalizadoEn());
					            	term.getReporteSac().setRoboFecha(serv.getDatosRobo().getFecha());
					            	term.getReporteSac().setRoboTelefono(serv.getDatosRobo().getTelefono());
					            }
					            
					            term.getReporteSac().setMatriz(serv.getMatriz());
					            term.getReporteSac().setCodigoMatriz((serv.getMatriz() != null ? serv.getCodigoMatriz() : null));
					            
					            term.getReporteSac().guardarObjeto();
						}

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"insertarTermino => guardarObjeto_ReporteMovilSac en SIICA");
					}
		        	
		        	//*** Poner Estatus Termino
					try {
						//Validar fecha estatus arribo, si campo es null obtiene fecha actual, de lo contrario envia la fecha que ya tiene guardada
						Date fechaTermino = new Date();
						
						if(term.getFechaEstatusTermino() != null){
							fechaTermino = term.getFechaEstatusTermino();
						}
						
		                this.terminalDao.ejecutarFuncionTerminalEstatusTermino(fechaTermino, serv.getUsuario(),
		                        JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "insertarTermino");
		                
		                if(!StringUtils.isBlank(term.getReporteApartado())){
		                	JsonObject json = new JsonObject();
			                JsonParser parser = new JsonParser();
			                
			                json = (JsonObject) parser.parse(term.getReporteApartado());

			                siicaWebService.nuevoReporteParaProveedor(json.get("numeroReporte").getAsString(), 
			                		term.getNumeroproveedor(), json.get("usuario").getAsString(), json.get("fuente").getAsString(), false);
			               
			                return new GETMovilResultadoOperacion(true, "OK");
		                } 
		                //Realizar asignacion de reporte y envio de push
		                try {
		                	if ((respuestaSac != null) && !StringUtils.equalsIgnoreCase(respuestaSac.get("reporteEncolado").toString(), "null")) {
		                		siicaWebService.nuevoReporteParaProveedor(respuestaSac.get("reporteEncolado").toString(), 
				                		term.getNumeroproveedor(), "UsuarioSAC" , "SAC", false);
		                	}
		                } catch (Exception e) {
						}
		                
		                return new GETMovilResultadoOperacion(true, "OK");
		                
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarTermino => ejecutarFuncionTerminalEstatusTerminoSac");
		                return new GETMovilResultadoOperacion(false, ex.getMessage());
		            }

		        	
				}
		        try {
		        	 return new GETMovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac.get("salida").toString());
		        } catch (Exception e) {
				}
		        return new GETMovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);
	        }
	        return new GETMovilResultadoOperacion(false, "ERROR Intente más tarde." );
	    }
		
	
	
	@SuppressWarnings("unused")
	@Override
	public GETMovilResultadoOperacion solicitarServicio(GETMovilServicioServicio serv) {
		if (serv == null) {
            return new GETMovilResultadoOperacion(false, "ERROR: El objeto es nulo");
        }

        if (StringUtils.isBlank(serv.getUsuario())) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarServicio => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new GETMovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }
        if (term.getReporteSise() == null) {
            return new GETMovilResultadoOperacion(false,
                    "ERROR: El usuario actual no se encuentra atendiendo algun reporte.");
        }

        try {
            this.sessionExternaDao.informacionDeSessionExterna(term, "Solicitud de servicio: " + serv.getServicio());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarServicio => informacionDeSessionExterna");
        }

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                    term.getReporteAtendiendo(), this.fuenteWS + "solicitarServicio", "Solicitud de Servicio Movil V3",
                    "Ejecucion del Metodo Con Datos -> " + this.jsonFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarServicio => ejecutarFuncionHistoricoTerminalNuevo");
        }

        if (StringUtils.isBlank(serv.getServicio())) {
            return new GETMovilResultadoOperacion(
                    false,
                    "ERROR: Es necesario especificar un tipo de servicio. Los valores permitidos son 'Grua', 'Ambulancia', 'Abogado', 'Constructora'");
        }

        if (StringUtils.isBlank(serv.getAtencion())) {
            return new GETMovilResultadoOperacion(
                    false,
                    "ERROR: Es necesario especificar un receptor de la atencion. Los valores permitidos son 'A' para asegurado, 'T' para tercero");
        }

        if (!StringUtils.equalsIgnoreCase(serv.getServicio(), "Grua")
                && !StringUtils.equalsIgnoreCase(serv.getServicio(), "Ambulancia")
                && !StringUtils.equalsIgnoreCase(serv.getServicio(), "Abogado")
                && !serv.getServicio().equalsIgnoreCase("Constructora")) {
            return new GETMovilResultadoOperacion(false,
                    "ERROR: El tipo de servicio especificado no es valido. Los valores permitidos son 'Grua', 'Ambulancia', 'Abogado'");
        }

        if (!StringUtils.equalsIgnoreCase(serv.getAtencion(), "A")
                && !StringUtils.containsIgnoreCase(serv.getAtencion(), "T")) {
            return new GETMovilResultadoOperacion(
                    false,
                    "ERROR: El tipo de atencion especificado no es valido. Los valores permitidos son 'A' para asegurado, 'T1','T2', 'T3 para tercero");
        }

        if (StringUtils.isBlank(serv.getProveedor())) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar una clave de proveedor.");
        }

        // Solicitud de grua
        if (StringUtils.equalsIgnoreCase(serv.getServicio(), "Grua")) {
            final String reporte = term.getReporteSise().getGeneralNumeroReporte();

            final String ramo = StringUtils.substring(reporte, 0, 2);
            final String ejercicio = StringUtils.substring(reporte, 2, 4);
            final String numrep = StringUtils.substring(reporte, 4);

            final JMWSAsignacionGrua asignacionGrua = new JMWSAsignacionGrua();
            asignacionGrua.setAtencion(StringUtils.upperCase(serv.getAtencion()));
            asignacionGrua.setRamo(ramo);
            asignacionGrua.setEjercicio(ejercicio);
            asignacionGrua.setNumProveedor(StringUtils.upperCase(serv.getProveedor()));
            asignacionGrua.setNumReporte(numrep);
            asignacionGrua.setPassword(serv.getProveedor());

            final JMWSAsignacionGruaVehiculo veh = new JMWSAsignacionGruaVehiculo();

            if (StringUtils.equalsIgnoreCase(serv.getAtencion(), "A")) {
                veh.setColor("");
                veh.setConductor(term.getReporteSise().getConductorNombre());
                veh.setMarca("");
                veh.setPlacas(term.getReporteSise().getVehiculoPlacas());
                veh.setTipo("");
                veh.setModelo("");

            } else {
                veh.setColor("");
                veh.setConductor("Tercero");
                veh.setMarca("Tercero");
                veh.setPlacas("Tercero");
                veh.setTipo("");
                veh.setModelo("");

            }
            asignacionGrua.setVehiculo(veh);

            String resultado = null;
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                        term.getReporteAtendiendo(), this.fuenteWS + "solicitarServicio",
                        "Solicitud de Servicio Movil V3",
                        "Envio a SISE -> " + this.factory.obtenerString(asignacionGrua));

//                resultado = this.siseClient.insertarDatosAsignacionGrua(asignacionGrua);

                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                        term.getReporteAtendiendo(), this.fuenteWS + "solicitarServicio",
                        "Solicitud de Servicio Movil V3", "Respuesta SISE -> " + resultado);

            } catch (final Exception e) {
                try {
                    this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                            term.getReporteAtendiendo(), this.fuenteWS + "solicitarServicio",
                            "Solicitud de Servicio Movil V3", "MUY MAL !!! SISE EXCEPCIONA!!! -> " + e.getMessage());
                } catch (final Exception ex) {
                    this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                            "solicitarServicio => ejecutarFuncionHistoricoTerminalNuevo");

                }

                return new GETMovilResultadoOperacion(false, "Respuesta de SISE con ERROR: " + e.getMessage());
            }

            if (resultado != null) {
                try {
                    final Resultado res = new JMXMLObjectFactory().obtenerResultadoParaString(resultado);

                    return new GETMovilResultadoOperacion(true, res.getDescResultado());
                } catch (final Exception e) {
                    return new GETMovilResultadoOperacion(false, "Respuesta de SISE con ERROR");
                }

            }
            return new GETMovilResultadoOperacion(false, "Resultado de SISE sin datos");

        }
        return null;
	}

	
	@Override
	public GETMovilResultadoOperacion insertarAbogadoArribo(GETMovilServicioAbogadoArribo serv) {
		
		if (serv == null) {
            return new GETMovilResultadoOperacion(false, "ERROR: El objeto es nulo");
        }

        if (StringUtils.isBlank(serv.getUsuario())) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarAbogadoArribo => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new GETMovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                    serv.getNumeroReporte(), this.fuenteWS + "insertarAbogadoArribo",
                    "Insertar Arribo Abogado Movil V3",
                    "Ejecucion del Metodo Con Datos -> " + this.jsonFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarAbogadoArribo => ejecutarFuncionHistoricoTerminalNuevo");

        }

        if (StringUtils.isBlank(serv.getNumeroReporte())) {
            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de reporte");
        }
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new GETMovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar la fecha y la hora en formato dd/MM/yyyy HH:mm:ss");
        }

        ReporteAbogado reporte = null;
        try {
            reporte = this.reporteAbogadoDao.objetoReporteAbogadoParaNumeroReporte(serv.getNumeroReporte());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarAbogadoArribo => objetoReporteAbogadoParaNumeroReporte");
        }

        if (reporte != null) {
            if (reporte.getFechaArribo() == null) {
                reporte.setFechaArribo(new Date());
                return new GETMovilResultadoOperacion(true, reporte.guardarObjeto().getMensaje());
            }
            return new GETMovilResultadoOperacion(false, "ERROR: El reporte especificado ya cuenta con fecha de arribo: "
                    + reporte.getFechaArribo());
        }
        return new GETMovilResultadoOperacion(false,
                "ERROR: El reporte no fue encontrado en la base de datos de reporte de abogados");
	}
	
	@Override
	public GETMovilResultadoOperacion solicitarServiciosDiversos(final GETMovilServicioDiverso serv) {
		
		 if (serv == null) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El objeto es nulo");
	        }

	        if (StringUtils.isBlank(serv.getUsuario())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
	        }
	        if (StringUtils.isBlank(serv.getPasswd())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
	        }

	        Terminal term = null;
	        try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "solicitarServiciosDiversos => objetoTerminalParaProveedorYPasswd");
	        }

	        if (term == null) {
	            return new GETMovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
	        }

	        if (term.getReporteSise() == null) {
	            return new GETMovilResultadoOperacion(false,
	                    "ERROR: El usuario actual no se encuentra atendiendo algun reporte.");
	        }

	        try {
	            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
	                    term.getReporteAtendiendo(), this.fuenteWS + "solicitarServiciosDiversos",
	                    "Solicitud de Servicios Diversos Movil V3",
	                    "Ejecucion del Metodo Con Datos -> " + this.jsonFactory.obtenerString(serv));
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "solicitarServiciosDiversos => ejecutarFuncionHistoricoTerminalNuevo");
	        }

	        try {
	            this.sessionExternaDao.informacionDeSessionExterna(term,
	                    "Solicitud de servicio: " + serv.getTipoDeServicioSolicitado());
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "solicitarServiciosDiversos => informacionDeSessionExterna");
	        }

	        if (StringUtils.isBlank(serv.getTipoDeServicioSolicitado())) {
	            return new GETMovilResultadoOperacion(
	                    false,
	                    "ERROR: Es necesario especificar un tipo de servicio. Los valores permitidos son 'Hospital', 'Ambulancia', 'Taller', 'Agencia', 'Constructora'");
	        }

	        if (StringUtils.isBlank(serv.getAtencionA())) {
	            return new GETMovilResultadoOperacion(
	                    false,
	                    "ERROR: Es necesario especificar un receptor de la atencion. Los valores permitidos son 'A' para asegurado, 'T' para tercero");
	        }

	        if (StringUtils.isBlank(serv.getClaveDeProveedor())) {
	            return new GETMovilResultadoOperacion(false,
	                    "ERROR: Es necesario especificar una clave de proveedor solicitado.");
	        }



	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Hospital")
	                && (StringUtils.isBlank(serv.getLesionadoEdad()) || StringUtils.isBlank(serv.getLesionadoSexo()) || StringUtils
	                .isBlank(serv.getLesionadoNombre()))) {
	            return new GETMovilResultadoOperacion(false,
	                    "ERROR: Para el tipo de servicio 'Hospital' es requerido proporcionar los datos de los lesionados");
	        }

	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Ambulancia")
	                && StringUtils.isBlank(serv.getClaveDeAmbulancia())) {
	            return new GETMovilResultadoOperacion(false,
	                    "ERROR: Para el tipo de servicio 'Ambulancia' es requerido proporcionar la clave de la ambulancia");
	        }

	        if (!StringUtils.equalsIgnoreCase(serv.getAtencionA(), "A")
	                && !StringUtils.containsIgnoreCase(serv.getAtencionA(), "T")) {
	            return new GETMovilResultadoOperacion(
	                    false,
	                    "ERROR: El tipo de atencion especificado no es valido. Los valores permitidos son 'A' para asegurado, 'T1','T2', 'T3 para tercero");
	        }

	        if (StringUtils.isBlank(serv.getClaveDeProveedor())) {
	            return new GETMovilResultadoOperacion(false, "ERROR: Es necesario especificar una clave de proveedor.");
	        }

	        final String ramo = StringUtils.substring(term.getReporteSise().getGeneralNumeroReporte(), 0, 2);
	        final String ejercicio = StringUtils.substring(term.getReporteSise().getGeneralNumeroReporte(), 2, 4);

	        final ReporteSolicitado report = new ReporteSolicitado();
	        report.setAtencionA(serv.getAtencionA());
	        report.setClaveAmbulancia(serv.getClaveDeAmbulancia());
	        report.setClaveProveedor(serv.getClaveDeProveedor());
	        report.setComentario("Ingresado desde WS Celular");
	        report.setFechaInsertado(new Date());
	        report.setFolioValeTalonario(serv.getFolioValeTalonario());
	        report.setLesionadoEdad(serv.getLesionadoEdad());
	        report.setLesionadoNombre(serv.getLesionadoNombre());
	        report.setLesionadoSexo(serv.getLesionadoSexo());
	        report.setNumeroReporte(term.getReporteSise().getGeneralNumeroReporte());
	        report.setTerminal(term);
	        report.setTipoDeServicio(serv.getTipoDeServicioSolicitado());

	        final JMWSAsignacionProveedor ap = new JMWSAsignacionProveedor();

	        ap.setAtencion(StringUtils.defaultString(serv.getAtencionA()));
	        ap.setFolioVale(StringUtils.defaultString(serv.getFolioValeTalonario()));
	        ap.setNumProveedor(StringUtils.defaultString(serv.getClaveDeProveedor()));
	        ap.setNumReporte(StringUtils.defaultString(StringUtils.substring(term.getReporteSise()
	                .getGeneralNumeroReporte(), 4)));
	        ap.setRamo(ramo);
	        ap.setEjercicio(ejercicio);
	        ap.setUsuarioModifica("");
	        ap.setCodigoME(serv.getCodigoME());

	        int tipoClaveDeProveedor = 0;
	        final JMWSAsignacionProveedorLesionado les = new JMWSAsignacionProveedorLesionado();
	        les.setEdadLesionado(StringUtils.isNotBlank(serv.getLesionadoEdad()) ? new Integer(serv.getLesionadoEdad())
	                : new Integer(0));
	        les.setNombreLesionado(StringUtils.defaultString(serv.getLesionadoNombre()));
	        les.setSexoLesionado(StringUtils.defaultString(serv.getLesionadoSexo()));

	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Taller")) {
	            tipoClaveDeProveedor = 1;
	        }
	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Agencia")) {
	            tipoClaveDeProveedor = 2;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Cristalera")) {
	            tipoClaveDeProveedor = 3;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Refaccionaria")) {
	            tipoClaveDeProveedor = 4;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Grua")) {
	            tipoClaveDeProveedor = 5;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Ajustador")) {
	            tipoClaveDeProveedor = 6;
	        }
	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Hospital")) {
	            tipoClaveDeProveedor = 7;
	            ap.setLesionado(les);
	            ap.setCveAmbulancia(StringUtils.defaultString(serv.getClaveDeAmbulancia()));
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Investigador")) {
	            tipoClaveDeProveedor = 8;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Cromadora")) {
	            tipoClaveDeProveedor = 9;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Medico")) {
	            tipoClaveDeProveedor = 10;
	            ap.setLesionado(les);
	            ap.setCveAmbulancia(StringUtils.defaultString(serv.getClaveDeAmbulancia()));
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Notario")) {
	            tipoClaveDeProveedor = 11;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Abogado")) {
	            tipoClaveDeProveedor = 12;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Llantas")) {
	            tipoClaveDeProveedor = 13;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Servicio Electrico")) {
	            tipoClaveDeProveedor = 14;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Radiadior")) {
	            tipoClaveDeProveedor = 15;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Enfermera")) {
	            tipoClaveDeProveedor = 16;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Estudios de Gabinete")) {
	            tipoClaveDeProveedor = 17;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Localizador")) {
	            tipoClaveDeProveedor = 18;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Radio Receptor")) {
	            tipoClaveDeProveedor = 19;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Pelicula Fotografica")) {
	            tipoClaveDeProveedor = 20;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Fisioterapia")) {
	            tipoClaveDeProveedor = 21;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Constructora")) {
	            tipoClaveDeProveedor = 22;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Ortopedico")) {
	            tipoClaveDeProveedor = 23;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Perito")) {
	            tipoClaveDeProveedor = 24;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Encalcador")) {
	            tipoClaveDeProveedor = 25;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Pension")) {
	            tipoClaveDeProveedor = 26;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Reidentificador")) {
	            tipoClaveDeProveedor = 27;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Aseguradora")) {
	            tipoClaveDeProveedor = 28;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Asistencia")) {
	            tipoClaveDeProveedor = 29;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Administrativo")) {
	            tipoClaveDeProveedor = 32;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Laboratorio")) {
	            tipoClaveDeProveedor = 34;
	        }
	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Ambulancia")) {
	            tipoClaveDeProveedor = 39;
	            ap.setLesionado(les);
	            ap.setCveAmbulancia(StringUtils.defaultString(serv.getClaveDeAmbulancia()));
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Farmacia")) {
	            tipoClaveDeProveedor = 40;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Rayos X")) {
	            tipoClaveDeProveedor = 41;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Valuador")) {
	            tipoClaveDeProveedor = 45;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Medio Ambiente")) {
	            tipoClaveDeProveedor = 46;
	        }
	        if (StringUtils.containsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Corralon")) {
	            tipoClaveDeProveedor = 47;
	        }
	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Taller Equipo Pesado")) {
	            tipoClaveDeProveedor = 48;
	        }
	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Agencia Equipo Pesado")) {
	            tipoClaveDeProveedor = 49;
	        }
	        if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Refaccionaria Equipo Pesado")) {
	            tipoClaveDeProveedor = 50;
	        }

	        if (tipoClaveDeProveedor==0){
	            return new GETMovilResultadoOperacion(
	                    false,
	                    "ERROR: El tipo de Proveedor no fue encontrado");
	        }

	        ap.setTipoProveedor(new Integer(tipoClaveDeProveedor));

	        final String entradaSise = new JMXMLObjectFactory().obtenerString(ap, false);

	        String respuestaSise = null;
	        try {
	            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
	                    term.getReporteAtendiendo(), this.fuenteWS + "solicitarServiciosDiversos",
	                    "Solicitud Servicios Diversos V3", "Envio a SISE -> " + entradaSise);

//	            respuestaSise = new JMSISEWebServiceConsultaPort().insertarDatosAsignacionServicio(entradaSise);

	            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
	                    term.getReporteAtendiendo(), this.fuenteWS + "solicitarServiciosDiversos",
	                    "Solicitud Servicios Diversos V3", "Respuesta SISE -> " + respuestaSise);

	        } catch (final Exception e) {

	            try {
	                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
	                        term.getReporteAtendiendo(), this.fuenteWS + "solicitarServiciosDiversos",
	                        "Solicitud Servicios Diversos V3", "MUY MAL !!! SISE EXCEPCIONA!!! -> " + e.getMessage());
	            } catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "solicitarServiciosDiversos => ejecutarFuncionHistoricoTerminalNuevo");
	            }

	            return new GETMovilResultadoOperacion(false, "ERROR: " + e.getMessage());
	        }
	        report.setFechaEnviadoSise(new Date());
	        report.guardarObjeto();

//	        if ((respuestaSise != null) && !StringUtils.equalsIgnoreCase(respuestaSise, "null")) {
//	            final ResultadoResponse res = (ResultadoResponse) new JMXMLObjectFactory().obtenerObjeto(respuestaSise);
//
//	            if (res != null) {
//	                if ((res.getFolios() != null) && (res.getFolios().size() > 0)) {
//	                    for (final String s : res.getFolios()) {
//	                        if (StringUtils.isNotBlank(s)) {
//	                            report.setSiseRespuestaFolio(s);
//	                        }
//	                    }
//	                }
//
//	                report.setSiseRespuestaClave(res.getCodError());
//	                report.guardarObjeto();
//
//	                if (StringUtils.equalsIgnoreCase(res.getCodError(), "000")) {
//	                    return new GETMovilResultadoOperacion(true, "OK: " + res.getListaFolios());
//	                }
//	                return new GETMovilResultadoOperacion(false, "ERROR: " + res.getDescError());
//	            }
//
//	        }

	        return new GETMovilResultadoOperacion(false, "La solicitud no pudo ser insertada en SISE. SISE Responde: "
	                + respuestaSise);
	}
	
	@Override
	public GETMovilResultadoOperacion insertarEncuesta(GETMovilServicioEncuesta serv) {
		
		if (StringUtils.isBlank(serv.getUsuario())) {			
			return new GETMovilResultadoOperacion(false,"ERROR: Es necesario especificar un usuario");
    	}
    	if (StringUtils.isBlank(serv.getPasswd())) {
    		return new GETMovilResultadoOperacion(false,"ERROR: Es necesario especificar una contrasena");
    	}

    	if (StringUtils.isBlank(serv.getNumeroDeReporte())) {
    		return new GETMovilResultadoOperacion(false,"ERROR: Es necesario especificar Numero de Reporte");
    	}

    	if (StringUtils.isBlank(serv.getNombreAsegurado())) {
    		return new GETMovilResultadoOperacion(false,"ERROR: Es necesario especificar Nombre del Asegurado");
    	}

		if (serv.getAtencionPersonalCabina() == null 
				|| (serv.getAtencionPersonalCabina() != null && (serv.getAtencionPersonalCabina() >= 5 || serv.getAtencionPersonalCabina() == 0))) {
			return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en atencionPersonalCabina!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente");
		}
	
    	if (serv.getLlegadaAjustador() == null 
    			||(serv.getLlegadaAjustador()!=null && (serv.getLlegadaAjustador()>=5||serv.getLlegadaAjustador()==0))) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en llegadaAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente");
    	}
    	    	
    	if (serv.getPresentacionAjustador() == null 
    			|| (serv.getPresentacionAjustador()!=null && (serv.getPresentacionAjustador()>=5||serv.getPresentacionAjustador()==0))) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en presentacionAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente");
    	}  	

    	if (serv.getTratoAjustador() == null 
    			||(serv.getTratoAjustador()!=null && (serv.getTratoAjustador()>=5||serv.getTratoAjustador()==0))) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en tratoAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente");
    	}	
    	
    	if (serv.getCapacidadAjustador() == null 
    			|| (serv.getCapacidadAjustador()!=null && (serv.getCapacidadAjustador()>=5||serv.getCapacidadAjustador()==0))) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en capacidadAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente");
    	}

    	if (serv.getTratoAjustadorTercero() == null 
    			|| (serv.getTratoAjustadorTercero()!=null && (serv.getTratoAjustadorTercero()>=5||serv.getTratoAjustadorTercero()==0))) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en tratoAjustadorTercero!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente");
    	}
    		
    	if (serv.getServicioDeGrua() == null 
    			|| (serv.getServicioDeGrua() !=null && serv.getServicioDeGrua()>=5)) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en servicioDeGrua!.VALORES VALIDOS 0=noAplica,1=mal,2=regular,3=bien,4=excelente");
    	}

    	if (serv.getObservoIrregularidadServicio()==null) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en ObservoIrregularidadServicio!.VALORES VALIDOS true o false");
    	}
     	if (serv.getSeleccionDeTaller()==null) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en SeleccionDeTaller!.VALORES VALIDOS 0=noAplica, 1=Si, 2=No");
    	}
    	if (serv.getRecibioCopiaDA()==null) {
    		return new GETMovilResultadoOperacion(false,"ERROR: VAlOR INVALIDO en RecibioCopiaDA!.VALORES VALIDOS true o false");
    	}

    	Terminal term = null;
    	try {
    		term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
    	} catch (final Exception ex) {
    		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
    				"ajustadoresInsertarEncuesta => objetoTerminalParaProveedorYPasswd");
    	}

    	if (term == null) {	
    		return new GETMovilResultadoOperacion(false,"ERROR: El usuario y contrasena indicados no son validos.");
    	}

    	// Se graba lo que llega
    	try {
    		this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
    				this.fuenteWS + "insertarEncuesta", "Encuesta Movil V3", "Ejecucion del Metodo Con Datos -> "
    						+ this.jsonFactory.obtenerString(serv));
    	} catch (final Exception ex) {
    		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
    				"insertarEncuesta => ejecutarFuncionHistoricoTerminalNuevo");
    	}

    	String respuesta=null;
    	try {
    		respuesta=this.encuestaDao.ejecutarFuncioninsertarEncuestaAjustador(serv.getUsuario(), serv.getPasswd(), 
    				serv.getNumeroDeReporte(), serv.getNombreAsegurado(), serv.getAtencionPersonalCabina(), serv.getLlegadaAjustador(), 
    				serv.getPresentacionAjustador(), serv.getTratoAjustador(), serv.getCapacidadAjustador(), serv.getTratoAjustadorTercero(), 
    				serv.getServicioDeGrua(),serv.getSeleccionDeTaller(), serv.getObservoIrregularidadServicio(), serv.getRecibioCopiaDA(),
    				serv.getObservaciones(),serv.getNombreConductor(),serv.getTelefonoConductor(),serv.getCorreoConductor(),term.getEstado().getId(),
    				term.getBase().getId(),term.getReporteSise().getGeneralNumeroPoliza());	
    	} catch (final Exception ex) {   		
    		return new GETMovilResultadoOperacion(false,"ERROR: No se pudieron guardar lo Datos. Vuelva a intentarlo por favor.");
    	}

    	if(respuesta!=null){

    		//---Enviar Email---
    		if (StringUtils.isNotBlank(serv.getCorreoConductor()) && respuesta.contains("OK")) {
    		
    			final String observoIrregularidad=serv.getObservoIrregularidadServicio()?"Si":"NO";	
    			final String recibioCopia=serv.getRecibioCopiaDA()?"Si":"NO";
    			final int[] listaRespuestas = {
    					serv.getAtencionPersonalCabina(),
    					serv.getLlegadaAjustador(),
    					serv.getPresentacionAjustador(),
    					serv.getTratoAjustador(),
    					serv.getCapacidadAjustador(),
    					serv.getTratoAjustadorTercero(),
    					serv.getServicioDeGrua(),
    					serv.getSeleccionDeTaller()};

    			final String[] valorListaRespuestas = new String[listaRespuestas.length];

    			int valor=0;
    			for (int respuestas : listaRespuestas) {

    				if(valor==6 || valor==7){

    					if(valor==6){

    						// Respuesta Pregunta 7
    						switch (respuestas) {
    						case 0: valorListaRespuestas[valor]="No Aplica"; break;
    						case 1: valorListaRespuestas[valor]="Malo"; break;
    						case 2: valorListaRespuestas[valor]="Regular"; break;
    						case 3: valorListaRespuestas[valor]="Bueno"; break;
    						case 4: valorListaRespuestas[valor]="Excelente"; break;
    						default:
    							break;
    						}
    					}else{

    						// Respuesta Pregunta 8
    						switch (respuestas) {
    						case 0:  valorListaRespuestas[valor]="No Aplica"; break;
    						case 1:  valorListaRespuestas[valor]="Si"; break;
    						case 2:  valorListaRespuestas[valor]="No"; break;
    						default:
    							break;
    						}				
    					}

    				}else{			
    					// Respuesta Pregunta 1-6
    					switch (respuestas) {		
    					case 1: valorListaRespuestas[valor]="Malo"; break;
    					case 2: valorListaRespuestas[valor]="Regular"; break;
    					case 3: valorListaRespuestas[valor]="Bueno"; break;
    					case 4: valorListaRespuestas[valor]="Excelente";break;
    					default:
    						break;
    					}

    				}

         			valor++;

    			}

    			final String asunto = new String("RESPUESTAS ENCUESTA "+serv.getNumeroDeReporte());
    			final StringBuilder builderBody = new StringBuilder("");

    			builderBody.append("<p><b>Estimado Asegurado "+serv.getNombreAsegurado()+"</b></p>");
    			builderBody.append("<p>ENVIAMOS LAS RESPUESTAS GENERADAS POR USTED EN LA ENCUESTA DE SERVICIO PARA EL AJUSTADOR " + term.getNombre() +" QUIEN LO ATENDIÓ CON EL NÚMERO DE REPORTE "+ serv.getNumeroDeReporte()+"</p>");
    			builderBody.append("<br/><table><tr><td>1.-La Atención recibida por el personal de cabina, cuando realizó su reporte de accidente fue:</td>"
    					+ "<td>"+valorListaRespuestas[0]+"</td></tr>");
    			builderBody.append("<tr><td>2.-La Oportunidad en la llegada del Ajustador al lugar del accidente fue: </td>"
    					+ "<td>"+valorListaRespuestas[1]+"</td></tr>");
    			builderBody.append("<tr><td>3.-La Presentación y Personalidad del Ajustador fue: </td>"
    					+ "<td>"+valorListaRespuestas[2]+"</td></tr>");
    			builderBody.append("<tr><td>4.-¿Cómo fué el trato del Ajustador? </td>"
    					+ "<td>"+valorListaRespuestas[3]+"</td></tr>");
    			builderBody.append("<tr><td>5.-La Capacidad y Asistencia del Ajustador en el Siniestro fue: </td>"
    					+ "<td>"+valorListaRespuestas[4]+"</td></tr>");
    			builderBody.append("<tr><td>6.-El trato del Ajustador hacia el Tercero involucrado fue: </td>"
    					+ "<td>"+valorListaRespuestas[5]+"</td></tr>");
    			builderBody.append("<tr><td>7.-En su caso,El Servico de Grúa fue: </td>"
    					+ "<td>"+valorListaRespuestas[6]+"</td></tr>");
    			builderBody.append("<tr><td>8.-¿En su caso,Eligió libremente del menú ofrecido por el Ajustador, El Taller/Agencia para reparar su unidad? </td>"
    					+ "<td>"+valorListaRespuestas[7]+"</td></tr>");
    			builderBody.append("<tr><td>9.-¿Observó alguna irregularidad en el servicio? </td>"
    					+ "<td>"+observoIrregularidad+"</td></tr>");
    			builderBody.append("<tr><td>10.-¿Recibió usted copia de la Declaración de Accidente? </td>"
    					+ "<td>"+recibioCopia+"</td></tr>");
    			builderBody.append("</table>");

    			builderBody.append("Observaciones y/o Sugerencias: "+serv.getObservaciones()+"</br>");

    			builderBody.append("<p>ESTAMOS A SUS ORDENES.<p>");
    			builderBody.append("<p>QUALITAS COMPAÑÍA DE SEGUROS SA DE CV<p>");
    			builderBody.append("<p>Gracias.<p>");


    			final ArrayList<String> persona = new ArrayList<>();
    			persona.add(serv.getCorreoConductor());

    			try {
    				new JMUtileriaEmail(
    						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
    						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
    						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
    						configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
    						configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
    						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
    						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
    						configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG)).enviarEmail(persona,
    								Objects.toString(asunto, ""), Objects.toString(builderBody, ""));
    				
    				
    				//------------ Configuracion hotmail Erasto ---------------
    				
    				/*JavaMailSenderImpl sender = new JavaMailSenderImpl();
    				sender.setHost("smtp-mail.outlook.com");
    				sender.setPort(587);
    				sender.setProtocol("smtp");

    				sender.setUsername("eras_bernabe@hotmail.com");
    				sender.setPassword("kakaroto");
    				  				
    				Properties properties = new Properties();
    			    javax.mail.Session session;
    				properties.put("mail.smtp.host", "smtp-mail.outlook.com");
    				properties.put("mail.smtp.starttls.enable", "true");
    				properties.put("mail.smtp.port",587);
    				properties.put("mail.smtp.mail.sender","eras_bernabe@hotmail.com");
    				properties.put("mail.smtp.user", "eras_bernabe@hotmail.com");
    				properties.put("mail.smtp.auth", "true");
    				
    				sender.setJavaMailProperties(properties);
    				
    			    texto = "<html><head></head><body>" + builderBody
    							+ "</body></html>";
    			 				    				
    				MimeMessage message = sender.createMimeMessage();
    		
    				MimeMessageHelper msg = new MimeMessageHelper(message, true,
    							"UTF-8");
                    msg.setFrom("eras_bernabe@hotmail.com");

    				msg.addTo(serv.getCorreoConductor());
    						
    				msg.setSubject(asunto);
    				msg.setText(texto, true);
                    sender.send(message);*/
    				
    				
    			} catch (Exception e) {
    				
    				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
    						"insertarEncuesta => EnviarEmail a "+serv.getCorreoConductor());
    				throw new RuntimeException(e);
    			}

    		}

    		// Se graba la respuesta
    		try {
    			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
    					this.fuenteWS + "insertarEncuesta", "Encuesta Movil V3", "Respuesta de Encuesta -> " + respuesta);

    		} catch (final Exception ex) {
    			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
    					"insertarEncuesta => ejecutarFuncionHistoricoTerminalNuevo");
    		}
    		
    		if(respuesta.contains("OK")){return new GETMovilResultadoOperacion(true,respuesta);}


    	}

       return new GETMovilResultadoOperacion(false,respuesta);	
	}
	
	@Override
	public GETMovilResultadoOperacion ajustadoresInsertarCoordenadas(
			String usuario, String passwd, String latitud, String longitud,
			String FechaLocalizacion, String HoraLocalizacion,
			String FechaRecepcion, String HoraRecepcion) {
		
		if (StringUtils.isBlank(usuario)) {
			return new GETMovilResultadoOperacion(false,"ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(passwd)) {
			return new GETMovilResultadoOperacion(false,"ERROR: Es necesario especificar una contrasena");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(usuario, passwd);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadas => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return new GETMovilResultadoOperacion(false,"ERROR: El usuario y contrasena indicados no son validos.");
		}
		
		if(this.ajustadoresInsertarCoordenadasConTelefono(term.getTelefono(), latitud, longitud, FechaLocalizacion,
				HoraLocalizacion, FechaRecepcion, HoraRecepcion).contains("ERROR")){
			return new GETMovilResultadoOperacion(false,this.ajustadoresInsertarCoordenadasConTelefono(term.getTelefono(), latitud, longitud, FechaLocalizacion,
					HoraLocalizacion, FechaRecepcion, HoraRecepcion));
		}
		return new GETMovilResultadoOperacion(true,this.ajustadoresInsertarCoordenadasConTelefono(term.getTelefono(), latitud, longitud, FechaLocalizacion,
				HoraLocalizacion, FechaRecepcion, HoraRecepcion));

	}
		
	public String ajustadoresInsertarCoordenadasConTelefono(final String telefono, final String latitud,
			final String longitud, final String FechaLocalizacion, final String HoraLocalizacion,
			final String FechaRecepcion, final String HoraRecepcion) {

		if (StringUtils.isBlank(telefono)) {
			return "ERROR: Es necesario especificar un telefono";
		}

		if (StringUtils.isBlank(latitud)) {
			return "ERROR: Es necesario especificar una latitud";
		}
		if (StringUtils.isBlank(longitud)) {
			return "ERROR: Es necesario especificar una longitud";
		}
		if (StringUtils.isBlank(FechaLocalizacion)) {
			return "ERROR: Es necesario especificar una fecha de localizacion";
		}
		if (StringUtils.isBlank(HoraLocalizacion)) {
			return "ERROR: Es necesario especificar una hora de localizacion";
		}
		if (StringUtils.isBlank(FechaRecepcion)) {
			return "ERROR: Es necesario especificar una fecha de recepcion";
		}
		if (StringUtils.isBlank(HoraRecepcion)) {
			return "ERROR: Es necesario especificar una hora de recepcion";
		}

		final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fechaLocalizacion = null;
		try {
			fechaLocalizacion = formatter.parse(FechaLocalizacion + " " + HoraLocalizacion);
		} catch (final ParseException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "ajustadoresInsertarCoordenadasConTelefono",
					"Telefono -> " + telefono + " Latitud:" + latitud + " Longitud:" + longitud + " FechaLocalizacion:"
							+ FechaLocalizacion + " HoraLocalizacion:" + HoraLocalizacion + " FechaRecepcion:"
							+ FechaRecepcion + " HoraRecepcion:" + HoraRecepcion);
			return "ERROR: La fecha no pudo ser interpretada correctamente. Por favor utilice el formato dd/MM/yyyy para fecha y HH:mm:ss para horario";
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaNumeroTelefono(telefono);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => objetoTerminalParaProveedorYPasswd");
		}

		if (term != null) {
			return term.procesarLatitudLongitud(longitud, latitud, 0, fechaLocalizacion);

		}

		Usuario usuario = null;
		try {
			usuario = this.usuarioDao.objetoUsuarioParaTelefono(telefono);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => objetoUsuarioParaTelefono");
		}

		if (usuario != null) {
			usuario.procesarLatitudLongitudFecha(longitud, latitud, fechaLocalizacion);
			return "OK";
		}

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
					this.fuenteWS,
					"ajustadoresInsertarCoordenadasConTelefono. Identificador de Telefono NO encontrado", "Telefono "
							+ telefono + " Latitud:" + latitud + " Longitud:" + longitud + " FechaLocalizacion:"
							+ FechaLocalizacion + " HoraLocalizacion:" + HoraLocalizacion + " FechaRecepcion:"
							+ FechaRecepcion + " HoraRecepcion:" + HoraRecepcion);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => ejecutarFuncionHistoricoTerminalNuevo");

		}

		return "ERROR: El telefono indicado no fue encontrado en la base de datos.";

	}

	/**
	 * Parsear Arreglos de Entrada
	 */
	
	public MovilDatosDocumentoIntercambioGET[] parseoDatosDocIntercambio(GETMovilDatosDocumentoIntercambio serv){
		
		if (serv.getClaveDocumento() !=null){	      
			numeroDatosRegistrados.add(serv.getClaveDocumento().length);     		
		}
		if (serv.getNombreDocumento() !=null){	        	
			numeroDatosRegistrados.add(serv.getNombreDocumento().length);       		
		}
		if (serv.getCantidadVales() !=null){	        	
			numeroDatosRegistrados.add(serv.getCantidadVales().length);       		
		}
		if (serv.getAseguradoras() !=null){	        	
			numeroDatosRegistrados.add(serv.getAseguradoras().length);       		
		}
		if (serv.getNumeroSiniestro() !=null){	        	
			numeroDatosRegistrados.add(serv.getNumeroSiniestro().length);       		
		}
		if (serv.getFolioVale() !=null){	        	
			numeroDatosRegistrados.add(serv.getFolioVale().length);       		
		}
		if (serv.getProveeDocumento() !=null){	        	
			numeroDatosRegistrados.add(serv.getProveeDocumento().length);       		
		}
		
		int mayor = 0;
		for (Integer numeroDatosRegis : numeroDatosRegistrados) {
			if (numeroDatosRegis > mayor) mayor = numeroDatosRegis;
		}
		
		numeroDatosRegistrados.clear();

		MovilDatosDocumentoIntercambioGET[] datosDocumentoIntercambioArreglo = new MovilDatosDocumentoIntercambioGET[mayor];

		for (int i = 0; i <= mayor-1; i++) {

			MovilDatosDocumentoIntercambioGET datosDocumentoIntercambio= new MovilDatosDocumentoIntercambioGET();

			if (serv.getClaveDocumento() !=null){ 
				try {
					datosDocumentoIntercambio.setClaveDocumento(serv.getClaveDocumento()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}
			}
			if (serv.getNombreDocumento() !=null){   
				try {
					datosDocumentoIntercambio.setNombreDocumento(serv.getNombreDocumento()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}

			}
			if (serv.getCantidadVales() !=null){   
				try {
					datosDocumentoIntercambio.setCantidadVales(serv.getCantidadVales()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}

			}
			if (serv.getAseguradoras() !=null){   
				try {
					datosDocumentoIntercambio.setAseguradoras(serv.getAseguradoras()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}

			}
			if (serv.getNumeroSiniestro() !=null){   
				try {
					datosDocumentoIntercambio.setNumeroSiniestro(serv.getNumeroSiniestro()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}

			}
			if (serv.getFolioVale() !=null){   
				try {
					datosDocumentoIntercambio.setFolioVale(serv.getFolioVale()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}

			}
			if (serv.getProveeDocumento() !=null){   
				try {
					datosDocumentoIntercambio.setProveeDocumento(serv.getProveeDocumento()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParsearDocumentoIntercambio");
				}

			}
			
			datosDocumentoIntercambioArreglo[i]=datosDocumentoIntercambio;

		}
		return datosDocumentoIntercambioArreglo;	
	}

	public MovilDatosCoberturaGET[] parseoDatosCobertura(GETMovilDatosCobertura serv){
		
		if (serv.getClaveCobertura() !=null){	      
			numeroDatosRegistrados.add(serv.getClaveCobertura().length);     		
		}
		if (serv.getEstimacion() !=null){	        	
			numeroDatosRegistrados.add(serv.getEstimacion().length);       		
		}
		
		int mayor = 0;
		for (Integer numeroDatosRegis : numeroDatosRegistrados) {
			if (numeroDatosRegis > mayor) mayor = numeroDatosRegis;
		}
		
		numeroDatosRegistrados.clear();

		MovilDatosCoberturaGET[] datosCoberturaArreglo = new MovilDatosCoberturaGET[mayor];

		for (int i = 0; i <= mayor-1; i++) {

			MovilDatosCoberturaGET datosCobertura= new MovilDatosCoberturaGET();

			if (serv.getClaveCobertura() !=null){ 
				try {
					datosCobertura.setClaveCobertura(serv.getClaveCobertura()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosCobertura");
				}
			}
			if (serv.getEstimacion() !=null){   
				try {
					datosCobertura.setEstimacion(serv.getEstimacion()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosCobertura");
				}

			}
			
			datosCoberturaArreglo[i]=datosCobertura;

		}

		return datosCoberturaArreglo;
	}
	
	public MovilDatosRecuperoGET[] parseoRecupero(GETMovilDatosRecupero serv){
			
				if (serv.getTipoRecupero() !=null){	      
					numeroDatosRegistrados.add(serv.getTipoRecupero().length);     		
				}
				if (serv.getTotalDeVales() !=null){	        	
					numeroDatosRegistrados.add(serv.getTotalDeVales().length);       		
				}
				if (serv.getCiaAseguradora() !=null){	        	
					numeroDatosRegistrados.add(serv.getCiaAseguradora().length);       		
				}
				if (serv.getNumeroSiniestro() !=null){	        	
					numeroDatosRegistrados.add(serv.getNumeroSiniestro().length);       		
				}
				if (serv.getFolioVale() !=null){	        	
					numeroDatosRegistrados.add(serv.getFolioVale().length);       		
				}
				if (serv.getMonto() !=null){	        	
					numeroDatosRegistrados.add(serv.getMonto().length);       		
				}
				if (serv.getDescripcionDeMonto() !=null){	        	
					numeroDatosRegistrados.add(serv.getDescripcionDeMonto().length);       		
				}
				
				int mayor = 0;
				for (Integer numeroDatosRegis : numeroDatosRegistrados) {
					if (numeroDatosRegis > mayor) mayor = numeroDatosRegis;
				}
				
				numeroDatosRegistrados.clear();

				MovilDatosRecuperoGET[] datosRecuperoArreglo = new MovilDatosRecuperoGET[mayor];

				for (int i = 0; i <= mayor-1; i++) {

					MovilDatosRecuperoGET datosRecupero= new MovilDatosRecuperoGET();

					if (serv.getTipoRecupero() !=null){ 
						try {
							datosRecupero.setTipoRecupero(serv.getTipoRecupero()[i]);
						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => ParseardatosRecupero");
						}
					}
					if (serv.getTotalDeVales() !=null){   
						try {
							datosRecupero.setTotalDeVales(serv.getTotalDeVales()[i]);
						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => ParseardatosRecupero");
						}

					}
					if (serv.getCiaAseguradora() !=null){  

						try {
							datosRecupero.setCiaAseguradora(serv.getCiaAseguradora()[i]);
						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion =>  ParseardatosRecupero");
						}


					}
					if (serv.getNumeroSiniestro() !=null){  

						try {	        				
							datosRecupero.setNumeroSiniestro(serv.getNumeroSiniestro()[i]);		        			
						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => ParseardatosRecupero");
						}

					}	
					if (serv.getFolioVale() !=null){   

						try {
							datosRecupero.setFolioVale(serv.getFolioVale()[i]);
						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => ParseardatosRecupero");
						}
					}
					if (serv.getMonto() !=null){     	

						try {
							datosRecupero.setMonto(serv.getMonto()[i]);
						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => ParseardatosRecupero");
						}
					}
					if (serv.getDescripcionDeMonto() !=null){     

						try {
							datosRecupero.setDescripcionDeMonto(serv.getDescripcionDeMonto()[i]);

						} catch (final ArrayIndexOutOfBoundsException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => ParseardatosRecupero");
						}
					}
					

					datosRecuperoArreglo[i]=datosRecupero;

				}
				
				return datosRecuperoArreglo;		
	}
	
	public MovilDatosObjetoGET[] parseoObjeto(GETMovilDatosObjeto serv){
		
		if (serv.getBache() !=null){	      
			numeroDatosRegistrados.add(serv.getBache().length);     		
		}
		if (serv.getMalla() !=null){	        	
			numeroDatosRegistrados.add(serv.getMalla().length);       		
		}
		if (serv.getObjetoFijoOSemimoviente() !=null){	        	
			numeroDatosRegistrados.add(serv.getObjetoFijoOSemimoviente().length);       		
		}
		if (serv.getTerceroCorreoObjeto() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroCorreoObjeto().length);       		
		}
		if (serv.getTerceroNombreObjeto() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroNombreObjeto().length);       		
		}
		if (serv.getTerceroTelefonoObjeto() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroTelefonoObjeto().length);       		
		}
		
		int mayor = 0;
		for (Integer numeroDatosRegis : numeroDatosRegistrados) {
			if (numeroDatosRegis > mayor) mayor = numeroDatosRegis;
		}
		
		numeroDatosRegistrados.clear();

		MovilDatosObjetoGET[] datosObjetoArreglo = new MovilDatosObjetoGET[mayor];

		for (int i = 0; i <= mayor-1; i++) {

			MovilDatosObjetoGET datosObjeto= new MovilDatosObjetoGET();

			if (serv.getBache() !=null){ 
				try {
					datosObjeto.setBache(serv.getBache()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosObjeto");
				}
			}
			if (serv.getMalla() !=null){   
				try {
					datosObjeto.setMalla(serv.getMalla()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosObjeto");
				}

			}
			if (serv.getObjetoFijoOSemimoviente() !=null){  
				try {
					datosObjeto.setObjetoFijoOSemimoviente(serv.getObjetoFijoOSemimoviente()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion =>  ParseardatosObjeto");
				}


			}
			if (serv.getTerceroCorreoObjeto() !=null){  
				try {	        				
					datosObjeto.setTerceroCorreoObjeto(serv.getTerceroCorreoObjeto()[i]);		        			
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosObjeto");
				}
			}	
			if (serv.getTerceroNombreObjeto() !=null){   
				try {
					datosObjeto.setTerceroNombreObjeto(serv.getTerceroNombreObjeto()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosObjeto");
				}
			}
			if (serv.getTerceroTelefonoObjeto() !=null){     	
				try {
					datosObjeto.setTerceroTelefonoObjeto(serv.getTerceroTelefonoObjeto()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosObjeto");
				}
			}
			
			datosObjetoArreglo[i]=datosObjeto;

		}

		return datosObjetoArreglo;
	}
	
	public MovilDatosTerceroGET[] parseoTerceros(GETMovilDatosTercero serv){

		if (serv.getConsecutivoTercero() !=null){	      
			numeroDatosRegistrados.add(serv.getConsecutivoTercero().length);     		
		}
		if (serv.getVehiculoMarca() !=null){	        	
			numeroDatosRegistrados.add(serv.getVehiculoMarca().length);       		
		}
		if (serv.getVehiculoModelo() !=null){	        	
			numeroDatosRegistrados.add(serv.getVehiculoModelo().length);       		
		}
		if (serv.getVehiculoColor() !=null){	        	
			numeroDatosRegistrados.add(serv.getVehiculoColor().length);       		
		}
		if (serv.getVehiculoTipo() !=null){	        	
			numeroDatosRegistrados.add(serv.getVehiculoTipo().length);       		
		}
		if (serv.getTerceroNombre() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroNombre().length);       		
		}
		if (serv.getTerceroCorreo() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroCorreo().length);       		
		}
		if (serv.getTerceroSerie() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroSerie().length);       		
		}
		if (serv.getTerceroTelefono() !=null){	        	
			numeroDatosRegistrados.add(serv.getTerceroTelefono().length);       		
		}
		if (serv.getAtropello() !=null){	        	
			numeroDatosRegistrados.add(serv.getAtropello().length);       		
		}
		if (serv.getVehiculoClave() !=null){	        	
			numeroDatosRegistrados.add(serv.getVehiculoClave().length);       		
		}
		if (serv.getVehiculoPlacas() !=null){	        	
			numeroDatosRegistrados.add(serv.getVehiculoPlacas().length);       		
		}
		if (serv.getConductor() !=null){	        	
			numeroDatosRegistrados.add(serv.getConductor().length); 
		}

		int mayor = 0;
		for (Integer numeroDatosRegis : numeroDatosRegistrados) {
			if (numeroDatosRegis > mayor) mayor = numeroDatosRegis;
		}
		
		numeroDatosRegistrados.clear();

		MovilDatosTerceroGET[] datosTerceroArreglo = new MovilDatosTerceroGET[mayor];

		for (int i = 0; i <= mayor-1; i++) {

			MovilDatosTerceroGET datosTercero= new MovilDatosTerceroGET();

			if (serv.getConsecutivoTercero() !=null){ 
				try {
					datosTercero.setConsecutivoTercero(serv.getConsecutivoTercero()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getVehiculoMarca() !=null){   
				try {
					datosTercero.setVehiculoMarca(serv.getVehiculoMarca()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}

			}
			if (serv.getVehiculoModelo() !=null){  

				try {
					datosTercero.setVehiculoModelo(serv.getVehiculoModelo()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}


			}
			if (serv.getVehiculoColor() !=null){  

				try {	        				
					datosTercero.setVehiculoColor(serv.getVehiculoColor()[i]);		        			
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}

			}	
			if (serv.getVehiculoTipo() !=null){   

				try {
					datosTercero.setVehiculoTipo(serv.getVehiculoTipo()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getTerceroNombre() !=null){     	

				try {
					datosTercero.setTerceroNombre(serv.getTerceroNombre()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getTerceroCorreo() !=null){     

				try {
					datosTercero.setTerceroCorreo(serv.getTerceroCorreo()[i]);

				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getTerceroSerie() !=null){     

				try {
					datosTercero.setTerceroSerie(serv.getTerceroSerie()[i]);

				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getTerceroTelefono() !=null){     

				try {
					datosTercero.setTerceroTelefono(serv.getTerceroTelefono()[i]);

				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getAtropello() !=null){     		

				try {
					datosTercero.setAtropello(serv.getAtropello()[i]);

				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getVehiculoClave() !=null){     	

				try {
					datosTercero.setVehiculoClave(serv.getVehiculoClave()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getVehiculoPlacas() !=null){   

				try {
					datosTercero.setVehiculoPlacas(serv.getVehiculoPlacas()[i]);
				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}
			}
			if (serv.getConductor() !=null){

				try {
					datosTercero.setConductor(serv.getConductor()[i]);

				} catch (final ArrayIndexOutOfBoundsException ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarGestion => ParseardatosTercero");
				}

			}

			datosTerceroArreglo[i]=datosTercero;

		}

		return datosTerceroArreglo;

	}
	
	@Override
	public GETMovilResultadoOperacion nuevoReporteMovilSac(GETMovilReporteMovilSac servicioReporteMovilSac) {
		ReporteMovilSac reporteSac = new ReporteMovilSac();
		ReporteMovilSacTerceros reporteSacTerceros = new ReporteMovilSacTerceros();
		
		Terminal term = null;
		
		//Validaciones de entrada
		try{
			if(servicioReporteMovilSac.getGeneralNumeroReporte() == null)
				throw new Exception("Error: No se ha especificado un Número de Reporte.");
			
			if(servicioReporteMovilSac.getUsuarioCaptura() == null)
				throw new Exception("Error: No se ha especificado la fuente de origen.");
			
		}catch(Exception ex){
			return new GETMovilResultadoOperacion(false, ex.getLocalizedMessage());
		}
		
		//Validaciones contra base de datos
		try{
			if(!StringUtils.isBlank(servicioReporteMovilSac.getAjusteAjustadorCodigo())) {
				term = this.terminalDao.objetoTerminalParaNumeroProveedor(null, servicioReporteMovilSac.getAjusteAjustadorCodigo());
			}
			
			if(term != null) {
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS + "nuevoReporteMovilSac",
							"nuevoReporteMovilSac Movil V3", "NuevoReporteMovilSac desde " + servicioReporteMovilSac.getUsuarioCaptura());
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteMovilSac => ejecutarFuncionHistoricoTerminalNuevo");
				}
			}
			
			//Llenar objeto Reporte Movil Sac
			//Valores que se obtienen de forma automatica
			reporteSac.setFecha(new Date());
			reporteSac.setAjusteAjustadorNombre((term != null ? term.getNombre() : ""));
			reporteSac.setAjusteFechaPasadoAjustador((term != null ? new SimpleDateFormat("dd/MM/yyyy").format(new Date()) : null));
			reporteSac.setAjusteHoraPasadoAjustador((term != null ? new SimpleDateFormat("HH:mm").format(new Date()) : null));
			
			reporteSac.setGeneralNumeroReporte(servicioReporteMovilSac.getGeneralNumeroReporte());
			reporteSac.setGeneralNumeroPoliza(servicioReporteMovilSac.getGeneralNumeroPoliza());
			reporteSac.setGeneralEndoso(servicioReporteMovilSac.getGeneralEndoso());
			reporteSac.setGeneralInciso(servicioReporteMovilSac.getGeneralInciso());
			reporteSac.setGeneralNombreAsegurado(servicioReporteMovilSac.getGeneralNombreAsegurado());
			reporteSac.setConductorNombre(servicioReporteMovilSac.getConductorNombre());
			reporteSac.setConductorTelefonoContacto(servicioReporteMovilSac.getConductorTelefonoContacto());
			
			reporteSac.setVehiculoSerie(servicioReporteMovilSac.getVehiculoSerie());
			reporteSac.setVehiculoPlacas(servicioReporteMovilSac.getVehiculoPlacas());
			reporteSac.setVehiculoMotor(servicioReporteMovilSac.getVehiculoMotor());
			reporteSac.setVehiculoMarca(servicioReporteMovilSac.getVehiculoMarca());
			reporteSac.setVehiculoTipo(servicioReporteMovilSac.getVehiculoTipo());
			reporteSac.setVehiculoModelo(servicioReporteMovilSac.getVehiculoModelo());
			reporteSac.setVehiculoColor(servicioReporteMovilSac.getVehiculoColor());
			
			reporteSac.setGeneralComoOcurrio(servicioReporteMovilSac.getGeneralComoOcurrio());
			reporteSac.setGeneralFechaOcurrido(servicioReporteMovilSac.getGeneralFechaOcurrido());
			reporteSac.setGeneralHoraOcurrido(servicioReporteMovilSac.getGeneralHoraOcurrido());
			reporteSac.setAjusteCodigoCausa(servicioReporteMovilSac.getAjusteCodigoCausa());
			
			reporteSac.setUbicacionDireccion(servicioReporteMovilSac.getUbicacionDireccion());
			reporteSac.setUbicacionCodigoPostal(servicioReporteMovilSac.getUbicacionCodigoPostal());
			reporteSac.setUbicacionEntidad(servicioReporteMovilSac.getUbicacionEntidad());
			reporteSac.setUbicacionMunicipio(servicioReporteMovilSac.getUbicacionMunicipio());
			reporteSac.setUbicacionColoniaDesc(servicioReporteMovilSac.getUbicacionColonia());
			
			reporteSac.setGeneralMonedaClave(servicioReporteMovilSac.getGeneralMonedaClave());
			reporteSac.setGeneralMonedaNombre(servicioReporteMovilSac.getGeneralMonedaNombre());
			
			reporteSac.setLatitudTelefonia(servicioReporteMovilSac.getLatitudTelefonia());
			reporteSac.setLongitudTelefonia(servicioReporteMovilSac.getLongitudTelefonia());
			reporteSac.setProximidad(servicioReporteMovilSac.isProximidad());
			
			reporteSac.setGeneralUsuario(servicioReporteMovilSac.getUsuarioCaptura());
			
			//Llenar objeto Reporte Movil Sac Terceros
			reporteSacTerceros.setFecha(new Date());
			reporteSacTerceros.setGeneralNumeroReporte(servicioReporteMovilSac.getGeneralNumeroReporte());
			reporteSacTerceros.setIdTercero("0");
			reporteSacTerceros.setVehiculoMarca(servicioReporteMovilSac.getVehiculoMarca());
			reporteSacTerceros.setVehiculoTipo(servicioReporteMovilSac.getVehiculoTipo());
			reporteSacTerceros.setVehiculoAnoModelo(servicioReporteMovilSac.getVehiculoModelo());
			reporteSacTerceros.setVehiculoPlacas(servicioReporteMovilSac.getVehiculoPlacas());
			reporteSacTerceros.setVehiculoSerie(servicioReporteMovilSac.getVehiculoSerie());
			reporteSacTerceros.setVehiculoColor(servicioReporteMovilSac.getVehiculoColor());
			reporteSacTerceros.setVehiculoConductor(servicioReporteMovilSac.getConductorNombre());
			reporteSacTerceros.setTelefonoContacto(servicioReporteMovilSac.getConductorTelefonoContacto());
			
			JMResultadoOperacion rSac = null;
			JMResultadoOperacion rSacTerceros = null;

			try {
				rSac = reporteSac.guardarObjeto();
				GETMovilResultadoOperacion resultadoAsignacion = new GETMovilResultadoOperacion();
				
				if (rSac.isExito()) {
					try {
						rSacTerceros = reporteSacTerceros.guardarObjeto();

						if (rSacTerceros.isExito()) {

							if(term != null) {
								try {
									this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS
											+ "nuevoReporteMovilSac", "nuevoReporteMovilSac Movil V3", "Respuesta Guardar en SIICA -> " + "OK");
								} catch (final Exception ex) {
									this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteMovilSac => ejecutarFuncionHistoricoTerminalNuevo");
								}
							
							
								reporteSac.setAjusteAjustadorCodigo(servicioReporteMovilSac.getAjusteAjustadorCodigo());
								reporteSacTerceros.setAjusteAjustadorCodigo(servicioReporteMovilSac.getAjusteAjustadorCodigo());
								
								reporteSac.guardarObjeto();
								reporteSacTerceros.guardarObjeto();
								
//								resultadoAsignacion = SiicaWebServiceClient.nuevoReporteParaProveedorClient(parametros.getProperty("siica.ws"), servicioReporteMovilSac.getGeneralNumeroReporte(),
//										servicioReporteMovilSac.getAjusteAjustadorCodigo(), servicioReporteMovilSac. getUsuarioCaptura(), "QMovil", null);
								
								String res = siicaWebService.nuevoReporteParaProveedor(servicioReporteMovilSac.getGeneralNumeroReporte(), 
										servicioReporteMovilSac.getAjusteAjustadorCodigo(), servicioReporteMovilSac.getUsuarioCaptura(), "QMovil", false);
								
								DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
								DocumentBuilder b = f.newDocumentBuilder();
								Document doc = b.parse(new ByteArrayInputStream(res.getBytes("UTF-8"))); //Se comento "UTF-8" antes linea 4053 -- StandardCharsets.UTF_8
								NodeList results = doc.getElementsByTagName("ResultadoOperacion");
								
								Boolean exito = true;
								String detalle = null;
								for (int i = 0; i < results.getLength(); i++) {
								    Element result = (Element) results.item(i);
								    Node exitoTmp = result.getElementsByTagName("esOperacionExitosa").item(0);
								    exito = Boolean.valueOf(exitoTmp.getTextContent());
								    
								    Node detalleTmp = result.getElementsByTagName("detalleOperacion").item(0);
								    detalle = detalleTmp.getTextContent();
								}
								
								if(!exito){
									return new GETMovilResultadoOperacion(false, "No se pudo asignar reporte. Detalle: " + detalle);
								}
								else {
									// ELASTIC SEARCH
									if(term != null && servicioReporteMovilSac.getConductorTelefonoContacto()!= null) {
										 URL_CUNCURRENT = this.getConfiguracionDao().obtenerCadena(JMConstantes.CONFIGURACION_ASIGNACION_CUNCURRENT_REPORTES_URL);
										try {
										String fecha = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
										
										parametros.put("telefonoContacto", reporteSac.getConductorTelefonoContacto());
										parametros.put("telefonoAjustador",term.getTelefono());
										parametros.put("reporte", servicioReporteMovilSac.getGeneralNumeroReporte());
										parametros.put("automatizar", "1");
										parametros.put("lastUpdate", fecha);
										
										SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
										clientHttpRequestFactory.setConnectTimeout(20000);
										clientHttpRequestFactory.setReadTimeout(20000);
										
										// Preparar Peticion
											HttpHeaders requestHeaders = new HttpHeaders();
											requestHeaders.setContentType(new org.springframework.http.MediaType("application", "json"));
											
											entity = new HttpEntity<>(parametros.toString(), requestHeaders);
											restTemplate = new RestTemplate(clientHttpRequestFactory);
											
											this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS
													+ "nuevoReporteMovilSac", "nuevoReporteMovilSac Movil V3", "URL: "+URL_CUNCURRENT+" Envio a Servicio REST: "+parametros.toString());
										
										}catch(Exception ex){
											this.utileriaExcepcion.manejarExcepcion(null, this.getClass(), "nuevoReporteMovilSac => consumirServicioRest [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
													+ parametros.toString());
										}
										
										try {
											ResponseEntity<String> salida = restTemplate.exchange(URL_CUNCURRENT, HttpMethod.POST, entity, String.class);
											respuestaBroker = salida.getBody();
											
											this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS
													+ "nuevoReporteMovilSac", "nuevoReporteMovilSac Movil V3","Respuesta de Servicio REST: "+respuestaBroker);
											
										}catch(Exception ex){
											this.utileriaExcepcion.manejarExcepcion(null, this.getClass(), "nuevoReporteMovilSac => Salida de Peticion a Servicio REST  [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
													+ "Peticion: "+parametros+" Salida:"+respuestaBroker);
										}
									}
									// END ELASTIC SERCH 
									
									
									return new GETMovilResultadoOperacion(true, "Reporte " + servicioReporteMovilSac.getGeneralNumeroReporte() + " insertado con éxito.");
								}
							
							}else {
								resultadoAsignacion =  new GETMovilResultadoOperacion(true, "Reporte guardado. (No se realizo asignacion - envio sin clave de ajustador)");
							}
							
							return resultadoAsignacion;
							
						} else {
							if(term != null) {
								this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS
										+ "nuevoReporteMovilSac", "nuevoReporteMovilSac Movil V3", "Respuesta Guardar en SIICA -> No se pudo guardar reporte");
							}
							
							this.utileriaExcepcion.manejarExcepcion(null, this.getClass(), "nuevoReporteMovilSac => guardarReporteSAC [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
									+ servicioReporteMovilSac.getGeneralNumeroReporte() + "]" + rSacTerceros.getMensaje());
							
							return new GETMovilResultadoOperacion(false, rSacTerceros.getMensaje());
						}

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(null, this.getClass(), "nuevoReporteMovilSac => guardarReporteSAC [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
								+ servicioReporteMovilSac.getGeneralNumeroReporte() + "]" + rSacTerceros.getMensaje());
						
						return new GETMovilResultadoOperacion(false, ex.toString());
					}
				} else {
					if(term != null) {
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS + "nuevoReporteMovilSac",
								"nuevoReporteMovilSac Movil V3", "Respuesta SIICA -> No se pudo guardar reporte");
					}
					
					this.utileriaExcepcion.manejarExcepcion(null, this.getClass(), "nuevoReporteMovilSac => guardarReporteSAC [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
							+ servicioReporteMovilSac.getGeneralNumeroReporte() + "]" + rSac.getMensaje());
					
					return new GETMovilResultadoOperacion(false, rSac.getMensaje());
				}
			} catch (Exception ex) {
				if(term != null) {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS + "nuevoReporteMovilSac",
							"nuevoReporteMovilSac Movil V3", "Respuesta SIICA -> " + ex.toString());
				}
				
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteMovilSac => guardarReporteSAC [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
						+ servicioReporteMovilSac.getGeneralNumeroReporte() + "]");
				
				return new GETMovilResultadoOperacion(false, ex.toString());
			}

		} catch (Exception ex) {
			if(term != null) {
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, servicioReporteMovilSac.getGeneralNumeroReporte(), this.fuenteWS + "nuevoReporteMovilSac",
							"nuevoReporteMovilSac Movil V3", ex.getLocalizedMessage());
				} catch (final Exception ex1) {
					this.utileriaExcepcion.manejarExcepcion(ex1, this.getClass(), "nuevoReporteMovilSac => ejecutarFuncionHistoricoTerminalNuevo");
				}
			}
			
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "nuevoReporteMovilSac => guardarReporteSAC [" + servicioReporteMovilSac.getGeneralNumeroReporte() + "] ["
					+ servicioReporteMovilSac.getGeneralNumeroReporte() + "]");
			
			return new GETMovilResultadoOperacion(false, ex.getLocalizedMessage());
		}
	}

    public ConfiguracionServiceInterfase getConfiguracionDao() {
    	return this.configuracionDao;
    }

}
