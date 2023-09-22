package com.aaq.col.system.webservices;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoResponsabilidadServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SacSP_ServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.sac.model.DatosArriboSac;
import com.aaq.col.clases.sac.model.DatosTerminoSac;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;


import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioArriboApp;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioTermino;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioTerminoApp;
import com.aaq.col.clases.xml.webservices.JMWSTerminalGenesys;

@WebService(serviceName = "GenesysWebService", portName = "GenesysWebServicePort", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices", endpointInterface = "com.aaq.col.system.webservices.GenesysWebServiceInterfase")
public class GenesysWebService implements GenesysWebServiceInterfase, InitializingBean {
    // fabricas
    private final JMXMLObjectFactory xmlFactory = new JMXMLObjectFactory();

    // dao
    @Autowired
    private ConfiguracionServiceInterfase configuracionDao;

    @Autowired
    private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
    
    @Autowired
    private TerminalServiceInterfase terminalDao;

    @Autowired
    private SacSP_ServiceInterfase SacSPDao;
	
	@Autowired
	private HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorDao;
	
	@Autowired
	private CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoRespDao;
	
	@Autowired
    private SIICAWebService siicaWebService;
	
    private final String fuenteWS = "SIICA Servicios Web -> SIICA Movil Web Service ->  Genesys -> ";

    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
    public GenesysWebService() {
        super();
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    }
    
    @Override
    public MovilResultadoOperacion insertarArriboApp(final MovilServicioArriboApp serv) {
    	if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getNumeroReporte())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'reporte' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getPlacas()) && StringUtils.isBlank(serv.getSerie())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'placas' y 'serie' de arribo es nulo");
        }
        if ((StringUtils.length(serv.getPlacas()) != 3) && (StringUtils.length(serv.getSerie()) != 3)) {
            return new MovilResultadoOperacion(false, "ERROR: Es requerido capturar placas o serie de 3 digitos");
        }
        if (StringUtils.isNotBlank(serv.getQuienLlegoPrimero())) {
            if (!StringUtils.equalsIgnoreCase(serv.getQuienLlegoPrimero(), "C")
                    && !StringUtils.equalsIgnoreCase(serv.getQuienLlegoPrimero(), "Q")) {
                return new MovilResultadoOperacion(false,
                        "ERROR: Los valores validos para QuienLlegoPrimero son 'C' y 'Q'. Se recibio: '"
                                + serv.getQuienLlegoPrimero() + "'");
            }
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), null);
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarArribo => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario es invalido");
        }
      //***  SAC
        if (term.getReporteSac() != null ) {
        	String numReporte = null;
        	if (term.getReporteSac().getGeneralNumeroReporte() != null) {
				numReporte = term.getReporteSac().getGeneralNumeroReporte();
			}
			// Se graba lo que llega
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
				numReporte, this.fuenteWS + "insertarArribo","Arribo Movil V3",
				"Ejecucion del Metodo Con Datos -> "+ this.xmlFactory.obtenerString(serv));
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
				"insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
			}

			if(!serv.getPlacas().equals("")){
				if(term.getReporteSac().getVehiculoPlacas().length() >= 3) {
					if(!term.getReporteSac().getVehiculoPlacas().substring(term.getReporteSac().getVehiculoPlacas().length() - 3).equals(serv.getPlacas())){
						return new MovilResultadoOperacion(false, "ERROR: Las placas del vehiculo no corresponden.");
					}
				}
				
				if(term.getReporteSac().getVehiculoPlacas().equalsIgnoreCase("SP") && !serv.getPlacas().equalsIgnoreCase("SP")) {
					return new MovilResultadoOperacion(false, "ERROR: Las placas del vehiculo no corresponden.");
				}
			}
			
			if(!serv.getSerie().equals("")){
				if(term.getReporteSac().getVehiculoPlacas().length() >= 3) {
					if(!term.getReporteSac().getVehiculoSerie().substring(term.getReporteSac().getVehiculoSerie().length() - 3).equals(serv.getSerie())){
						return new MovilResultadoOperacion(false, "ERROR: La serie del vehiculo no corresponde.");
					}
				}
				
				if(term.getReporteSac().getVehiculoSerie().equalsIgnoreCase("SP") && !serv.getSerie().equalsIgnoreCase("SP")){
					return new MovilResultadoOperacion(false, "ERROR: La serie del vehiculo no corresponde.");
				}
			}
			
			if(!term.getReporteSac().getGeneralNumeroReporte().equals(serv.getNumeroReporte())) {
				return new MovilResultadoOperacion(false, "ERROR: El numero reporte que trata de arribar no coincide.");
			}
            //*** Manda DATOS para SAC(Si la informacion se guardo bien en Oracle ejecuto impacto en mi BD)
			
			 final DatosArriboSac datosParaSac = new DatosArriboSac();
			 datosParaSac.setFechaArribo(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
			 datosParaSac.setHoraArribo(DateFormatUtils.format(new Date(), "HH:mm:ss"));
			 datosParaSac.setPlacas(StringUtils.length(serv.getPlacas()) == 3 ? StringUtils.upperCase(serv.getPlacas()) : null);
			 datosParaSac.setSerie(StringUtils.length(serv.getSerie()) == 3 ? StringUtils.upperCase(serv.getSerie()) : null);
			 datosParaSac.setReporte(term.getReporteSac().toString());
			 datosParaSac.setUsuario(term.getNumeroproveedor());
			 datosParaSac.setQuienLlegoPrimero(serv.getQuienLlegoPrimero());
			 datosParaSac.setTramoCarretero(serv.getTramoCarretero());
			 datosParaSac.setLatitud(serv.getLatitudArriboAjustador());
			 datosParaSac.setLongitud(serv.getLongitudArriboAjustador());
			 datosParaSac.setDistanciaAlArribo(serv.getDistanciaAlArribo());
			 datosParaSac.setProximidad(3); // 3 Arribo por GENESYS
			 datosParaSac.setUbicacionCorrecta(1);

			 String respuestaSac = null;
		        
		     // Se graba el envio
		        try {
		           this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
		             this.fuenteWS + "insertarArribo", "Arribo Movil V3",
		             "Envio a SAC -> " + this.xmlFactory.obtenerString(datosParaSac));
		        } catch (final Exception ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
		        }

		        try {
		            respuestaSac = this.SacSPDao.arriboSac(datosParaSac);
		        } catch (final Exception e) {

		            // Se graba la excepcion
		            try {
		                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
		                   this.fuenteWS + "insertarArribo", "Arribo Movil V3",
		                   "MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
		            }

		            return new MovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje: " + e.getMessage());
		        }

		        // Se graba la respuesta
		        try {
		            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
		                    this.fuenteWS + "insertarArribo", "Arribo Movil V3", "Respuesta de SAC -> " + respuestaSac);
		        } catch (final Exception ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "insertarArribo => ejecutarFuncionHistoricoTerminalNuevo");
		        }

		        if (respuestaSac == null) {
		            return new MovilResultadoOperacion(false, "ERROR: La respuesta de SAC es nula");
		        }
		        
		        if (StringUtils.containsIgnoreCase(respuestaSac, "OK")) {
		        	
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
							if( StringUtils.isBlank(term.getReporteSac().getAjusteFechaArriboAjustador() ) ) {
								term.getReporteSac().setAjusteFechaArriboAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
							}
							
							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraArriboAjustador()) ){
								term.getReporteSac().setAjusteHoraArriboAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
							}

							term.getReporteSac().setQuienLlegoPrimero(serv.getQuienLlegoPrimero());
							term.getReporteSac().setTramoCarretero(serv.getTramoCarretero());
							term.getReporteSac().setCoordLatitudArribo(serv.getLatitudArriboAjustador());
							term.getReporteSac().setCoordLongitudArribo(serv.getLongitudArriboAjustador());
							term.getReporteSac().setDistanciaAlArribo(serv.getDistanciaAlArribo());
							term.getReporteSac().setUbicacionCorrecta("SI");
							term.getReporteSac().guardarObjeto();
						}

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"insertarArribo => guardarObjeto_ReporteMovilSac en SIICA");
					}
		        	
		        	//*** Poner Estatus Arribo	
					try {
						// Validar fecha estatus arribo, si campo es null obtiene fecha actual, de lo contrario envia la fecha que ya tiene guardada
						Date fechaArribo = new Date();
						
						if(term.getFechaEstatusArribo() != null){
							fechaArribo = term.getFechaEstatusArribo();
						}
						
						this.terminalDao.ejecutarFuncionTerminalEstatusArribo(fechaArribo, serv.getUsuario(),
		                        JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "insertarArribo");
						
		                return new MovilResultadoOperacion(true, respuestaSac);
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarArribo => ejecutarFuncionTerminalEstatusArriboSac");
		                return new MovilResultadoOperacion(false, ex.getMessage());
		            }

		        	
				}
		        
		        return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);		

	   }
        return new MovilResultadoOperacion(false, "ERROR Intente más tarde.");

    }

    
    @Override
    public MovilResultadoOperacion insertarTerminoApp(final MovilServicioTerminoApp serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto termino es nulo");
        }
        
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de termino es nulo");
        }
        
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de termino es nulo");
        }
        
        if (StringUtils.isBlank(serv.getAseguradoCorreo())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'aseguradoCorreo' de termino es nulo");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), null);
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarTermino => objetoTerminalParaProveedorYPasswd");
        }
        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o passwd son invalidos");
        }
        String numReporte = null;
        if (term.getReporteSac() != null && term.getReporteSac().getGeneralNumeroReporte() != null) {
			numReporte = term.getReporteSac().getGeneralNumeroReporte();
		}
        // Se graba lo que llega
        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
                    this.fuenteWS + "insertarTermino", "Termino Movil V3", "Ejecucion del Metodo Con Datos -> "
                            + this.xmlFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarTermino => ejecutarFuncionHistoricoTerminalNuevo");
        }
        
        if (!term.getReporteSac().getGeneralNumeroReporte().equals(serv.getNumeroReporte())) {
        	return new MovilResultadoOperacion(false, "ERROR: El numero reporte que trata de Terminar no coincide.");
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
				return new MovilResultadoOperacion(false, "ERROR: NO SE CAPTURARON DATOS ARCA/HEINEKEN. FAVOR DE REGISTRARLOS.");
			}
        	
			char[] caracteresEspeciales = {'\u00A1','\u0021','\u0022','\u0023','\u0024','\u0025','\u0026','\u002F','\u0028','\u0029','\u003D','\u003F','\u00BF','\u007B','\u007D','\u005B','\u005D','\u003A','\u002E','\u002D','\u005F','\u002A','\u002B', '\u05F3', '\u00B4', ' '};
			
			if(MovilServicioTermino.containsAny(serv.getSerieAsegurado(), caracteresEspeciales)) {
				return new MovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR.");
			}
			
			if(MovilServicioTermino.containsAny(serv.getPlacas(), caracteresEspeciales)) {
				return new MovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR."); 
			}
			
			if(MovilServicioTermino.containsAny(serv.getMotorAsegurado(), caracteresEspeciales)) {
				return new MovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR."); 
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
            // Se le asigna latitud y longitud de termino 
            datosSac.setLatitud(serv.getLatitudTerminoAjustador());
            datosSac.setLongitud(serv.getLongitudTerminoAjustador());
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
            
            // Se graba el envio
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().toString(),
                        this.fuenteWS + "insertarTermino", "Termino Movil V3",
                        "Envio a SAC -> " + this.xmlFactory.obtenerString(datosSac));
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

                return new MovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje: " + e.getMessage());
            }

            // Se graba la respuesta de SAC
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().toString(),
                        this.fuenteWS + "insertarTermino", "Termino Movil V3", "Respuesta de SAC -> " + respuestaSac);
                
                if(respuestaSac.get("salida").contains("ERROR SAC")) {
                	 return new MovilResultadoOperacion(false, "SOLICITAR TERMINO DE SU ATENCION A CABINA O INTENTAR NUEVAMENTE.");
                }
                
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "insertarTermino => ejecutarFuncionHistoricoTerminalNuevo");
            }

            if (respuestaSac == null) {
                return new MovilResultadoOperacion(false, "ERROR: La respuesta de SAC es nula");
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
            	
				if (StringUtils.containsIgnoreCase(respuestaSac.get("salida"), "OK")) {
					try {
						this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
								term.getNumeroproveedor(), term.getNombre(),
								term.getReporteSac().getGeneralNumeroReporte(),
								term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(),
								"Insertar Término", serv.getUsuario(), "Dispositivo Móvil", descActividad,
								respuestaSac.get("salida"));
					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"insertarTermino => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
				}
            	
        	}catch (Exception ex) {
        		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "insertarTermino => ejecutarFuncionHistoricoResumenAjustadorNuevo");
			}
            
            if (StringUtils.containsIgnoreCase(respuestaSac.get("salida"), "OK")) {
            	
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

						term.getReporteSac().setCoordLatitudTermino(serv.getLatitudTerminoAjustador());
						term.getReporteSac().setCoordLongitudTermino(serv.getLongitudTerminoAjustador());
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
						
	                }
	                
	                return new MovilResultadoOperacion(true, "OK");
	                
	            } catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "insertarTermino => ejecutarFuncionTerminalEstatusTerminoSac");
	                return new MovilResultadoOperacion(false, ex.getMessage());
	            }

	        	
			}
	        
	        return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);

        }
       
        return new MovilResultadoOperacion(false, "ERROR: Intente más tarde.");
    }
    
    public ConfiguracionServiceInterfase getConfiguracionDao() {
    	return this.configuracionDao;
    }

	@Override
	public JMWSTerminalGenesys informacionTerminal(String usuario) {
		if (StringUtils.isBlank(usuario)) {
			return null;
		}
		
		Terminal terminal = null;
		
		try {
			terminal = this.terminalDao.objetoTerminalParaProveedorYPasswd(usuario, null);
			JMWSTerminalGenesys infoTerminal = new JMWSTerminalGenesys(terminal);
			if (terminal != null) {
					
				try {
					ReporteMovilSac reporte = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(infoTerminal.getReporteAsignado(), terminal.getNumeroproveedor());
						infoTerminal.setFechaEstatusArribo(reporte.getAjusteFechaArriboAjustador() + " " + reporte.getAjusteHoraArriboAjustador());						
						infoTerminal.setFechaEstatusAsignado(reporte.getAjusteFechaPasadoAjustador() + " " + reporte.getAjusteHoraPasadoAjustador());						
						infoTerminal.setFechaEstatusTermino(reporte.getAjusteFechaTerminoAjustador() + " " + reporte.getAjusteHoraTerminoAjustador());
				} catch (Exception e) {
					this.utileriaExcepcion.manejarExcepcion(e, getClass(), "obtener reporte de terminal para fechas de arribo y de asignado");
				}
				
				return infoTerminal;
			}
			
			 
		} catch (Exception e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "Genesys => informacionTerminal => Obteniendo Terminal");
		}
		
		return null;
	}
	
}
