package com.aaq.col.system.webservices;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.commons.validator.routines.EmailValidator;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
import com.aaq.col.clases.database.entidades.Comunicado;
import com.aaq.col.clases.database.entidades.EntidadAbogadoCrm;
import com.aaq.col.clases.database.entidades.InfoReconocimiento;
import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTalleres;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.abstracto.AbstractEntidadAbogadoCrm.Estatus;
import com.aaq.col.clases.database.entidades.pojo.sisesac.ReconocimientoSISE;
import com.aaq.col.clases.database.repositorios.interfase.ConclusionSiniestroDaoInterfase;
import com.aaq.col.clases.database.servicios.impl.SiseSP_Service;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAseguradoraServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCoberturasServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoResponsabilidadServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRecuperacionesServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ComunicadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EncuestaAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EntidadAbogadoCrmServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoRecuperosAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteAbogadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacGruasServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTalleresServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTercerosServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SacSP_ServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SessionExternaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioFrecuenciaServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.pojo.conclusion.ResumenAjustadorInfo;
import com.aaq.col.clases.pojo.notificacion.EncuestaCorreo;
import com.aaq.col.clases.sac.model.AsignacionProveedorLesionadoSac;
import com.aaq.col.clases.sac.model.DatosArriboSac;
import com.aaq.col.clases.sac.model.DatosDispositivoMovilFolio;
import com.aaq.col.clases.sac.model.DatosFolioHospitalAmbulancia;
import com.aaq.col.clases.sac.model.DatosGestionRecuperoSac;
import com.aaq.col.clases.sac.model.DatosGestionSac;
import com.aaq.col.clases.sac.model.DatosGestionTerceroSac;
import com.aaq.col.clases.sac.model.DatosSolicitudAbogado;
import com.aaq.col.clases.sac.model.DatosTerminoSac;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaBancaria;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.UtileriaCadenas;
import com.aaq.col.clases.util.UtileriaFechas;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioAbogadoArribo;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioArribo;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCoberturaEstimacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioCobroBancario;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioDiverso;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioEncuesta;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioGestion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioServicio;
import com.aaq.col.clases.webservices.movil.peticion.MovilCobroBancario;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosAsegurado;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosCobertura;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosGrua;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosRecupero;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosTercero;
import com.aaq.col.clases.webservices.movil.peticion.MovilInicioDeSesion;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporte;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSiseGrua;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSiseTaller;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSiseTercero;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoInicioDeSession;
import com.aaq.col.clases.webservices.movil.peticion.MovilResumenAjustador;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioAbogado;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioReconocimiento;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioTermino;
import com.aaq.col.clases.webservices.movil.peticion.MovilSolicitarTicketCondiciones;
import com.aaq.col.clases.webservices.wscabina.siniestro.AperturaEstimacion;
import com.aaq.col.clases.webservices.wscabina.siniestro.AperturaReserva;
import com.aaq.col.clases.webservices.wscabina.siniestro.ObjectFactory;
import com.aaq.col.clases.webservices.wscabina.siniestro.ResultadoAperturaEstimacion;
import com.aaq.col.clases.webservices.wscabina.siniestro.WSSiniestroServiceImplService;
import com.aaq.col.clases.webservices.wsreportes.reportes.Taller;
import com.aaq.col.clases.webservices.wsreportes.reportes.Talleres;
import com.aaq.col.clases.webservices.wsreportes.reportes.Tercero;
import com.aaq.col.clases.webservices.wsreportes.reportes.Terceros;
import com.aaq.col.clases.xml.webservices.JMWSAsignacionGrua;
import com.aaq.col.clases.xml.webservices.JMWSAsignacionGruaVehiculo;
import com.aaq.col.clases.xml.webservices.Resultado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;


@WebService(serviceName = "SIICAMovilWebService", portName = "SIICAMovilWebServicePort", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices", endpointInterface = "com.aaq.col.system.webservices.SIICAMovilInterfase")
public class SIICAMovilWebService implements SIICAMovilInterfase, InitializingBean {
    
    private final JMXMLObjectFactory xmlFactory = new JMXMLObjectFactory();
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");

    @Autowired
    private ConfiguracionServiceInterfase configuracionDao;

    @Autowired
    private ComunicadoServiceInterfase comunicadoDao;

    @Autowired
    private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
    
    @Autowired
    private HistoricoRecuperosAjustadorServiceInterfase historicoRecuperosajustadorServiceInterfase;

    @Autowired
    private SessionExternaServiceInterfase sessionExternaDao;

    @Autowired
    private TerminalServiceInterfase terminalDao;

    @Autowired
    private ReporteAbogadoServiceInterfase reporteAbogadoDao;

    @Autowired
	private ReporteMovilSacServiceInterfase reporteSacDao;
    
	@Autowired
    private ReporteMovilSacTercerosServiceInterfase reporteSacTercerosDao;
	
	@Autowired
    private EncuestaAjustadorServiceInterfase encuestaDao;
	
	@Autowired
    private SacSP_ServiceInterfase SacSPDao;
	
	@Autowired
    private EntidadAbogadoCrmServiceInterfase entidadAbogadoCrmService;

	@Autowired
	private HistoricoResumenAjustadorServiceInterfase historicoResumenAjustadorDao;
	
	@Autowired
	private CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoRespDao;
	
	@Autowired
	private CatalogoAseguradoraServiceInterfase catalogoAseguradoraDao;
	
	@Autowired
	private CatalogoRecuperacionesServiceInterfase catalogoRecuperacionesDao;
	
	@Autowired
	private CatalogoCoberturasServiceInterfase catalogoCoberturasDao;
	
	@Autowired
    private SIICAWebService siicaWebService;
	
	@Autowired
	private ReporteMovilSacTalleresServiceInterfase reporteMovilSacTalleresService;
	
	@Autowired
	private ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasService;
	
	@Autowired
	private SiseSP_Service siseSR_Service;
	
	@Autowired
	private UsuarioFrecuenciaServiceInterfase usuarioFrecuenciaService;
	
	@Autowired
	private ConclusionSiniestroDaoInterfase conclusionSiniestro;
	
    private final JMXMLObjectFactory factory = new JMXMLObjectFactory();

    private final String fuenteWS = "SIICA Servicios Web -> SIICA Movil Web Service -> ";

    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
    public SIICAMovilWebService() {
        super();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
      public MovilResultadoOperacion insertarArribo(final MovilServicioArribo serv) {

          if (serv == null) {
              return new MovilResultadoOperacion(false, "ERROR: El objeto arribo es nulo");
          }
          if (StringUtils.isBlank(serv.getUsuario())) {
              return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de arribo es nulo");
          }
          if (StringUtils.isBlank(serv.getPasswd())) {
              return new MovilResultadoOperacion(false, "ERROR: El campo 'passwd' de arribo es nulo");
          }
          if (StringUtils.isBlank(serv.getFechaHora())) {
              return new MovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de arribo es nulo");
          }
          if (serv.getFechaHora() != null) {
  			UtileriaFechas utilfechas = new UtileriaFechas();
  			boolean valida = utilfechas.validarFecha(serv.getFechaHora());
  			if (!valida) {
  				return new MovilResultadoOperacion(false, "Formato de fechaHora no valida. Valido dd/MM/yyyy HH:mm:ss");
  			}
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
          
          if (StringUtils.isBlank(serv.getUbicacionCorrecta())) {
              return new MovilResultadoOperacion(false, "ERROR: El campo 'ubicacionCorrecta' es un valor obligatorio.");
          }
          
          if (StringUtils.isNotBlank(serv.getUbicacionCorrecta())) {
              if (!StringUtils.equalsIgnoreCase(serv.getUbicacionCorrecta(), "SI")
                      && !StringUtils.equalsIgnoreCase(serv.getUbicacionCorrecta(), "NO")) {
                  return new MovilResultadoOperacion(false,
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
              return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
          }
        //***  SAC
          if (term.getReporteSac() != null) {
          	String numReporte = null;
          	if (term.getReporteSac().getGeneralNumeroReporte() != null) {
				numReporte = term.getReporteSac().getGeneralNumeroReporte();
			}
  			try {
  				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
  						numReporte, this.fuenteWS + "insertarArribo",
  						"Arribo Movil V3", "Ejecucion del Metodo Con Datos -> "
  						+ this.xmlFactory.obtenerString(serv));
  			} catch (final Exception ex) {
  				this.utileriaExcepcion
  						.manejarExcepcion(ex, this.getClass(),
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
  		        
  		        if ( StringUtils.containsIgnoreCase(respuestaSac, "OK")) {
  		        	
  		        	try {
  	            		this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(), 
  	                			term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
  	                			"Insertar Arribo", serv.getUsuario(), "Dispositivo Móvil", "Insertar Arribo", respuestaSac);
  	            	}catch (Exception ex) {
  	            		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
  	                            "insertarArribo => ejecutarFuncionHistoricoResumenAjustadorNuevo");
  					}
  		        	
  					try {
  						if (term.getReporteSac() != null) {
  							UtileriaFechas utileriaF = new UtileriaFechas();
  				  			Map<String, String> respuestaQA = utileriaF.fechaHoraArriboSacAQ(serv.getFechaHora(), false);
  				  			String fechaQA = null;
  				  			String horaQA = null;
  				  			if (respuestaQA != null) {
	  				  			fechaQA = respuestaQA.get("fecha");
	  				  			horaQA = respuestaQA.get("hora");
  							}
  				  			
  							
  							if (term.getReporteSac().getEsSegundaAtencion() != null) {
  								if (term.getReporteSac().getEsSegundaAtencion()) {
  									term.getReporteSac().setAjusteFechaArriboAjustador(fechaQA);
  	  								term.getReporteSac().setAjusteHoraArriboAjustador(horaQA);
  								} else {
  		  							if( StringUtils.isBlank(term.getReporteSac().getAjusteFechaArriboAjustador() ) ) {
  		  									term.getReporteSac().setAjusteFechaArriboAjustador(fechaQA);
  		  							}
  		  							
  		  							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraArriboAjustador()) ){
  		  									term.getReporteSac().setAjusteHoraArriboAjustador(horaQA);
  		  							}
  								}
							} else {
  		  							if( StringUtils.isBlank(term.getReporteSac().getAjusteFechaArriboAjustador() ) ) {
  		  								term.getReporteSac().setAjusteFechaArriboAjustador(fechaQA);
  		  							}
  		  							
  		  							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraArriboAjustador()) ){
  		  									term.getReporteSac().setAjusteHoraArriboAjustador(horaQA);
  		  							}
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
//  						Date fechaArribo = new Date();
  						UtileriaFechas util = new UtileriaFechas();
  						Date fechaArribo = util.convertirFecha(serv.getFechaHora());
  								
  						if(term.getFechaEstatusArribo() != null){
  							fechaArribo = term.getFechaEstatusArribo();
  						}
  						
  						this.terminalDao.ejecutarFuncionTerminalEstatusArribo(fechaArribo, serv.getUsuario(),
  		                        JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "insertarArribo");
  						
  		                return new MovilResultadoOperacion(true, "OK");
  		            } catch (final Exception ex) {
  		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
  		                        "insertarArribo => ejecutarFuncionTerminalEstatusArriboSac");
  		                return new MovilResultadoOperacion(false, ex.getMessage());
  		            }

  		        	
  				}
  		        
  		        return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);		

  	   }
		return new MovilResultadoOperacion(false, "ERROR, Intente más tarde.");
          
      }

    @Override
    public MovilResultadoOperacion insertarTermino(final MovilServicioTermino serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto termino es nulo");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de termino es nulo");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'passwd' de termino es nulo");
        }
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de termino es nulo");
        }
        if (StringUtils.isBlank(serv.getAseguradoCorreo())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'aseguradoCorreo' de termino es nulo");
        }

        if (serv.getPolizaTurista() == null ) {
			return new MovilResultadoOperacion(false, "ERROR: Es nesario especificar 'true' o 'false' en campo 'polizaTurista'");

		} 
        
        if (serv.getPolizaTurista() != false  && serv.getPolizaTurista() != true  ) {
			return new MovilResultadoOperacion(false, "ERROR: Es nesario especificar 'true' o 'false' en campo 'polizaTurista'");
		}  
       
        if (serv.getPolizaTurista()) {
			if (serv.getNumeroPolizaTurista() != null &&  serv.getNumeroPolizaTurista().length() > 1 ) {
				if (serv.getNumeroPolizaTurista().length() > 10 ) 
					return new MovilResultadoOperacion(false, "ERROR: El campo 'numeropolizaTurista' debe ser maximo 10 digitos") ;
			}  else {
				return new MovilResultadoOperacion(false, "ERROR: Es nesario especificar el campo 'numeroPolizaTurista'") ;
			}
			
			if (serv.getIncisoPolizaTurista() != null  &&  serv.getIncisoPolizaTurista().length() > 1) {
				if (serv.getIncisoPolizaTurista().length() > 4 ) 
					return new MovilResultadoOperacion(false, "ERROR: El campo 'incisoPolizaTurista' debe ser maximo 4 digitos") ;
			}  else {
				return new MovilResultadoOperacion(false, "ERROR: Es nesario especificar el campo 'incisoPolizaTurista'") ;
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
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o passwd son invalidos");
        }
        String numReporte = null;
        if (term.getReporteSac() != null && term.getReporteSac().getGeneralNumeroReporte() != null) {
			numReporte = term.getReporteSac().getGeneralNumeroReporte();
		}

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
                    this.fuenteWS + "insertarTermino", "Termino Movil V3", "Ejecucion del Metodo Con Datos -> "
                            + this.xmlFactory.obtenerString(serv));
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
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
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
                    this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
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
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
                        this.fuenteWS + "insertarTermino", "Termino Movil V3", "Respuesta de SAC -> " + respuestaSac);
                
                if ((respuestaSac != null) && !StringUtils.equalsIgnoreCase(respuestaSac.get("salida").toString(), "null")) {
                	if(respuestaSac.get("salida").toString().contains("ERROR SAC")){
               	 return new MovilResultadoOperacion(false, "SOLICITAR TERMINO DE SU ATENCION A CABINA O INTENTAR NUEVAMENTE.");
               }
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
            	
				try {
					if (term.getReporteSac() != null) {

						if (term.getReporteSac().getEsSegundaAtencion() != null) {
							if (term.getReporteSac().getEsSegundaAtencion()) {
								term.getReporteSac().setAjusteFechaTerminoAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));	
								term.getReporteSac().setAjusteHoraTerminoAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
							} else {
								if(StringUtils.isBlank(term.getReporteSac().getAjusteFechaTerminoAjustador()) ){
									term.getReporteSac().setAjusteFechaTerminoAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
								}
								
								if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraTerminoAjustador()) ){
									term.getReporteSac().setAjusteHoraTerminoAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
								}
							}
						} else {
							if(StringUtils.isBlank(term.getReporteSac().getAjusteFechaTerminoAjustador()) ){
								term.getReporteSac().setAjusteFechaTerminoAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
							}
							
							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraTerminoAjustador()) ){
								term.getReporteSac().setAjusteHoraTerminoAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
							}
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
	        	
				try {
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
		               
		                return new MovilResultadoOperacion(true, "OK");
	                } 
	                //Realizar asignacion de reporte y envio de push
	                try {
	                	if ((respuestaSac != null) && !StringUtils.equalsIgnoreCase(respuestaSac.get("reporteEncolado").toString(), "null")) {
	                		siicaWebService.nuevoReporteParaProveedor(respuestaSac.get("reporteEncolado").toString(), 
			                		term.getNumeroproveedor(), "UsuarioSAC" , "SAC", false);
	                	}
	                } catch (Exception e) {
					}
	                
	                return new MovilResultadoOperacion(true, "OK");
	                
	            } catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "insertarTermino => ejecutarFuncionTerminalEstatusTerminoSac");
	                return new MovilResultadoOperacion(false, ex.getMessage());
	            }

	        	
			}
	        try {
	        	 return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac.get("salida").toString());
	        } catch (Exception e) {
			}
	        return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);

        }
		return new MovilResultadoOperacion(false, "ERROR. Intente más tarde.");
    }
	
	
    @Override
    public MovilResultadoOperacion insertarGestion(final MovilServicioGestion serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto gestion es nulo");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de gestion es nulo");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'passwd' de gestion es nulo");
        }
        if (serv.getDatosAsegurado() == null) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'Datos Asegurado' de gestion es nulo");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarGestion => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o passwd son invalidos");
        }
        String reporteSac = null;
        if (term.getReporteSac() != null && term.getReporteSac().getGeneralNumeroReporte() != null) {
			reporteSac = term.getReporteSac().getGeneralNumeroReporte();
		}

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSac,
                    this.fuenteWS + "insertarGestion", "Gestion Movil V3", "Ejecucion del Metodo Con Datos -> "
                            + this.xmlFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarGestion => ejecutarFuncionHistoricoTerminalNuevo");
        }
         //***  SAC
        if (term.getReporteSac() != null) {
        	
        	final DatosGestionSac datos = new DatosGestionSac();
            datos.setEdad(serv.getDatosAsegurado().getEdad());
            datos.setSexo(serv.getDatosAsegurado().getSexo());
            datos.setReporte(term.getReporteSac().toString());
            datos.setCorreoAsegurado(serv.getDatosAsegurado().getAseguradoCorreo());
            datos.setNombreAsegurado(serv.getDatosAsegurado().getAseguradoNombre());
            datos.setTelefonoAsegurado(serv.getDatosAsegurado().getAseguradoTelefono());
            // Folia AMIS del Asegurado para SAC
            datos.setFolioAMIS(serv.getDatosAsegurado().getFolioAMIS());
            
            //Datos de recupero
            if ((serv.getDatosRecupero() != null) && (serv.getDatosRecupero().length > 0)) {
                for (final MovilDatosRecupero dat : serv.getDatosRecupero()) {
                    final DatosGestionRecuperoSac dgr = new DatosGestionRecuperoSac();
                    dgr.setCiaAseguradora(dat.getCiaAseguradora());
                    dgr.setFolioVale(dat.getFolioVale());
                    dgr.setNumeroSiniestro(dat.getNumeroSiniestro());
                    dgr.setTipoRecupero(dat.getTipoRecupero());
                    dgr.setTotalDeVales(dat.getTotalDeVales());
                    dgr.setMonto(dat.getMonto());
                    dgr.setDescripcionDeMonto(dat.getDescripcionDeMonto());
                 
                    dgr.setConsecutivoTercero(dat.getConsecutivoTercero());
                   
                    
                    datos.getRecuperos().add(dgr);
                }
            }
            
            if ((serv.getDatosTercero() != null) && (serv.getDatosTercero().length > 0)) {
                for (final MovilDatosTercero dat : serv.getDatosTercero()) {
						if (dat.getConsecutivoTercero().trim().equals("")) {
							return new MovilResultadoOperacion(false, "ERROR: No se asignó un Id de Asegurado o Tercero");
						}
						//Validar Modelo de Vehiculo
						//Maximo 4 caracteres y el formato de anio debe ser completo (yyyy) y no menor a 1800
						String modeloVehiculo = null;
						int currentYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
						if(dat.getAtropello() == null || !dat.getAtropello()) {
							if (StringUtils.isNotBlank(dat.getVehiculoModelo())) {
							if(dat.getVehiculoModelo().length() == 4){
								if(Integer.parseInt(dat.getVehiculoModelo()) >= 1800 && Integer.parseInt(dat.getVehiculoModelo()) <= currentYear){
									modeloVehiculo = dat.getVehiculoModelo();
								}else{
									return new MovilResultadoOperacion(false, "ERROR: Modelo Vehiculo fuera de rango (1800 - " + currentYear + ").");
								}
							}else{
								return new MovilResultadoOperacion(false, "ERROR: Modelo Vehiculo debe contener 4 digitos.");
							}
							}
						}
						char[] caracteresEspeciales = {'\u00A1','\u0021','\u0022','\u0023','\u0024','\u0025','\u0026','\u002F','\u0028','\u0029','\u003D','\u003F','\u00BF','\u007B','\u007D','\u005B','\u005D','\u003A','\u002E','\u002D','\u005F','\u002A','\u002B', '\u05F3', '\u00B4', ' '};
						
						
						final DatosGestionTerceroSac dgt = new DatosGestionTerceroSac();
						dgt.setColorVehiculo(StringUtils.defaultString(dat.getVehiculoColor()));
						dgt.setConductorTercero(StringUtils.defaultString(dat.getConductor()));
						dgt.setDescripcionTercero(StringUtils.defaultString(dat.getConsecutivoTercero()));
						dgt.setMarcaVehiculo(StringUtils.defaultString(dat.getVehiculoMarca()));
						dgt.setModeloVehiculo(modeloVehiculo);
						dgt.setNumero(StringUtils.defaultString(dat.getConsecutivoTercero()));
						dgt.setPlacasVehiculo(StringUtils.defaultString(dat.getVehiculoPlacas()));
						dgt.setTipoTercero("V");
						dgt.setTipoVehiculo(StringUtils.defaultString(dat.getVehiculoTipo()));
						dgt.setNombreTercero(StringUtils.defaultString(dat.getTerceroNombre()));
						
						if (dat.getTerceroSerie() != null) {
							if(MovilServicioTermino.containsAny(StringUtils.defaultString(dat.getTerceroSerie()), caracteresEspeciales)) {
								return new MovilResultadoOperacion(false, "ERROR: EXISTEN CARACTERES EXTRAÃ‘OS O ESPACIOS EN BLANCO, FAVOR DE CORREGIR.");
							}
						}
						
						
						if (dat.getAtropello() == null || BooleanUtils.isFalse(dat.getAtropello()) ) {
							if(StringUtils.isNotBlank(dat.getTerceroSerie())) { 
								if (StringUtils.defaultString(dat.getTerceroSerie()) != null && StringUtils.defaultString(dat.getTerceroSerie()).length() == 17) {
									dgt.setSerieTercero(StringUtils.defaultString(dat.getTerceroSerie()));
								}else {
									return new MovilResultadoOperacion(false, "ERROR: El campo 'Serie Tercero' debe ser de 17 digitos");
								}
							}
						}
				        
						dgt.setCorreoTercero(StringUtils.defaultString(dat.getTerceroCorreo()));
						dgt.setTelefonoTercero(StringUtils.defaultString(dat.getTerceroTelefono()));
						dgt.setClaveVehiculo(StringUtils.defaultString(dat.getVehiculoClave()));

						// Añadir datos del ajustador del Tercero
						dgt.setNombreAjustadorTercero(StringUtils.defaultString(dat.getNombreAjustadorTercero()));
						dgt.setPolizaTercero(StringUtils.defaultString(dat.getPolizaTercero()));
						dgt.setIncisoPolizaTercero(StringUtils.defaultString(dat.getIncisoPolizaTercero()));
						
						if (dat.getAtropello() != null) {
							if (BooleanUtils.isTrue(dat.getAtropello())) {
								dgt.setTipoTercero("P");
								dgt.setAtropello("true");
							}
						}
						
						  if (StringUtils.isNotBlank(dat.getBache()) || StringUtils.isNotBlank(dat.getMalla())
		                            || StringUtils.isNotBlank(dat.getObjetoFijoOSemimoviente())) {

//		                        final DatosGestionTerceroSac dgR = new DatosGestionTerceroSac();
							  dgt.setTipoTercero("O");
							  dgt.setNumero(dat.getConsecutivoTercero());
							  dgt.setDescripcionTercero(StringUtils.trim(StringUtils.defaultString(dat.getBache()) + " "
		                                + StringUtils.defaultString(dat.getMalla()) + " "
		                                + StringUtils.defaultString(dat.getObjetoFijoOSemimoviente())));
							  dgt.setNombreTercero(dat.getTerceroNombreObjeto());
							  dgt.setConductorTercero(dat.getTerceroNombreObjeto());
							  dgt.setTelefonoTercero(dat.getTerceroTelefonoObjeto());
							  dgt.setCorreoTercero(dat.getTerceroCorreoObjeto());
							  dgt.setIdObjeto(dat.getIdObjeto()); // Se añade el tag id Objeti
		                    }
						datos.getTerceros().add(dgt);
//					}
                } // terminal for de Tercero
            }
            
            Map<String, String> respuestaSac = null;
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSac,
                        this.fuenteWS + "insertarGestion", "Gestion Movil V3",
                        "Envio a SAC: " + this.xmlFactory.obtenerString(datos));
                
                respuestaSac = this.SacSPDao.gestionSac(datos, term);
                
                if (respuestaSac != null) {
                	Map<String, List<Map<String, Object>>> descAtividadTerceros = null;
                	List<Map<String, Object>> detalleTipoTerceroList = null;
                	Map<String, Object> detalleTercero;
                	
                	List<Map<String, Object>> detalleRecuperoList = null;
                	Map<String, Object> detalleRecupero;
                	
                	if(datos.getTerceros().size() > 0) {
                		descAtividadTerceros = new HashMap<String, List<Map<String, Object>>>();
                		detalleTipoTerceroList = new ArrayList<>();
                		
                        for (Integer i = 0; i < datos.getTerceros().size(); i++) {
                        	detalleTercero = new HashMap<>();
                        	Map<String, Object> detalleTipoTercero = new HashMap<>();
                        	
                        	detalleTercero.put("numeroTercero", datos.getTerceros().get(i).getNumero());
                        	detalleTercero.put("telefono", datos.getTerceros().get(i).getTelefonoTercero());
                        	detalleTercero.put("correo", datos.getTerceros().get(i).getCorreoTercero());
                        	detalleTercero.put("tipoTercero", datos.getTerceros().get(i).getTipoTercero());
        					
        					if (datos.getTerceros().get(i).getTipoTercero().equals("V")) {
        						detalleTipoTercero.put("conductor", datos.getTerceros().get(i).getConductorTercero());
        						detalleTipoTercero.put("tipo", datos.getTerceros().get(i).getTipoVehiculo());
        						detalleTipoTercero.put("marca", datos.getTerceros().get(i).getMarcaVehiculo());
        						detalleTipoTercero.put("modelo", datos.getTerceros().get(i).getModeloVehiculo());
        						detalleTipoTercero.put("placas", datos.getTerceros().get(i).getPlacasVehiculo());
        						detalleTipoTercero.put("serie", datos.getTerceros().get(i).getSerieTercero());
        						
        						detalleTercero.put("vehiculo", detalleTipoTercero);
        						
    						}else if(datos.getTerceros().get(i).getTipoTercero().equals("O")){
    							detalleTipoTercero.put("objeto", datos.getTerceros().get(i).getNombreTercero());
    							detalleTipoTercero.put("tipo", datos.getTerceros().get(i).getDescripcionTercero());
    							
    							detalleTercero.put("objeto", detalleTipoTercero);
    						}
        					
        					detalleTipoTerceroList.add(detalleTercero);
        				}
                        
                        descAtividadTerceros.put("terceros", detalleTipoTerceroList);
                	}
                    
                	if(datos.getRecuperos().size() > 0) {
                		detalleRecuperoList = new ArrayList<>();
                		
                		for (int i = 0; i < datos.getRecuperos().size(); i++) {
                			
                			CatalogoRecuperaciones catalogoRecuperaciones = new CatalogoRecuperaciones();
                        	try {
                        		catalogoRecuperaciones = catalogoRecuperacionesDao.objetoCatalogoRecuperacionesClave(datos.getRecuperos().get(i).getTipoRecupero());
            				} catch (Exception ex) {
            					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
            	                        "insertarGestion => obtenerDescRecuperacion");
            				}
                        	
                        	CatalogoAseguradora catalogoAseguradora = new CatalogoAseguradora();
                        	try {
                        		catalogoAseguradora = catalogoAseguradoraDao.objetoCatalogoAseguradoraClave(datos.getRecuperos().get(i).getCiaAseguradora());
            				} catch (Exception ex) {
            					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
            	                        "insertarTermino => obtenerDescResponsabilidad");
            				}
                        	
                			detalleRecupero = new HashMap<>();
                			
                			detalleRecupero.put("numeroTercero", datos.getRecuperos().get(i).getConsecutivoTercero());
                			detalleRecupero.put("cveRecupero", datos.getRecuperos().get(i).getTipoRecupero());
                			detalleRecupero.put("descClaveRecupero", (catalogoRecuperaciones != null ? catalogoRecuperaciones.getDescripcion() : ""));
                			detalleRecupero.put("monto", datos.getRecuperos().get(i).getMonto());
                			if (datos.getRecuperos().get(i).getDescripcionDeMonto().equals("005") || datos.getRecuperos().get(i).getDescripcionDeMonto().equals("006") || 
                					datos.getRecuperos().get(i).getDescripcionDeMonto().equals("008")) {
                				detalleRecupero.put("descripMonto", datos.getRecuperos().get(i).getDescripcionDeMonto());								
							}
                			detalleRecupero.put("cveAseguradora", datos.getRecuperos().get(i).getCiaAseguradora());
                			detalleRecupero.put("nombreAseguradora", (catalogoAseguradora != null ? catalogoAseguradora.getDescripcion() : ""));
                			
                			detalleRecuperoList.add(detalleRecupero);
    					}
                		
                		 descAtividadTerceros.put("recuperos", detalleRecuperoList);
                	}
                	
                	ObjectMapper mapper = new ObjectMapper();
                	String descActividad = mapper.writeValueAsString(descAtividadTerceros);
                	
                    String resultado = "";
                    
                    if(respuestaSac.containsKey("TERCEROS")) {
                    	resultado += respuestaSac.get("TERCEROS").contains("OK") ? "TERCERO REGISTRADO CORRECTAMENTE" : respuestaSac.get("TERCEROS");
                    }
                    
                    if(respuestaSac.containsKey("RECUPEROS")) {
                    	resultado += respuestaSac.containsKey("TERCEROS") && respuestaSac.containsKey("RECUPEROS") ? "|" : "";
                    	
                    	resultado += respuestaSac.get("RECUPEROS").contains("OK") ? "RECUPERO REGISTRADO CORRECTAMENTE" : respuestaSac.get("RECUPEROS");
                    }
                    
                    try {
                    	this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
    							term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(),
    							term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(),
    							"Insertar Gestión", serv.getUsuario(), "Dispositivo Móvil", descActividad,
    							resultado);
                    }catch (final Exception ex) {
                    	this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                                "insertarGestion => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
                }
            } catch (final Exception e) {

                try {
                    this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSac,
                            this.fuenteWS + "insertarGestion", "Gestion Movil V3",
                            "MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
                } catch (final Exception ex) {
                    this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                            "insertarGestion => ejecutarFuncionHistoricoTerminalNuevo");
                }

                return new MovilResultadoOperacion(false, "ERROR: SAC Excepciona: " + e.getMessage());
            }

            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSac, 
                        this.fuenteWS + "insertarGestion", "Gestion Movil V3", "Respuesta de SAC -> " + respuestaSac);
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "insertarGestion => ejecutarFuncionHistoricoTerminalNuevo");
            }

            if (respuestaSac != null) {
            	if(datos.getTerceros().size()>0){
        			for (DatosGestionTerceroSac tercero : datos.getTerceros()) {
        				try {
							this.reporteSacTercerosDao.guardarTerceros(datos
									.getReporte(), term.getNumeroproveedor(),
									term.getReporteSac().getGeneralNumeroPoliza(),tercero);
						} catch (Exception ex) {
						
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarGestion => guardarTerceros en SIICA");
						}
        			}
        		}
            	
            	//Datos de recupero
                if ((serv.getDatosRecupero() != null) && (serv.getDatosRecupero().length > 0)) {
            		
            		for (final MovilDatosRecupero dat : serv.getDatosRecupero()) {
            			CatalogoAseguradora catalogoAseguradora = null;
						try {
							catalogoAseguradora = catalogoAseguradoraDao.objetoCatalogoAseguradoraClave(dat.getCiaAseguradora());
						} catch (Exception ex) {
        					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
        	                        "insertarGestion => obtenerCatalogoAseguradora");
						}
            			CatalogoRecuperaciones catalogoRecuperaciones = null;
						try {
							catalogoRecuperaciones = catalogoRecuperacionesDao.objetoCatalogoRecuperacionesClave(dat.getTipoRecupero());
						} catch (Exception ex) {
        					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
        	                        "insertarGestion => obtenerCatalogoRecuperaciones");
						}

                        	try {
								this.historicoRecuperosajustadorServiceInterfase.ejecutarFuncionHistoricoRecuperosAjustadorNuevo(dat.getTipoRecupero(), catalogoRecuperaciones.getDescripcion(), dat.getTotalDeVales(),
										dat.getCiaAseguradora(), (catalogoAseguradora != null ? catalogoAseguradora.getDescripcion() : ""), term.getNumeroproveedor(), term.getReporteSac().getGeneralNumeroReporte(),dat.getConsecutivoTercero(),
										term.getReporteSac().getGeneralNumeroSiniestro(), dat.getFolioVale(), dat.getMonto(), dat.getDescripcionDeMonto());
							} catch (Exception ex) {
								this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
				                        "insertarGestion => ejecutarFuncionHistoricoRecuperosAjustadorNuevo");
							}
                }
            	return new MovilResultadoOperacion(true, "OK");
            }
            return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);
            }	
        }
        return new MovilResultadoOperacion(false, "ERROR Intente más tarde.");
    }

    @Override
    public MovilResultadoOperacion insertarCoberturaEstimacion(final MovilServicioCoberturaEstimacion serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto Cobertura Estimacion es nulo");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de CoberturaEstimacion es nulo");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'passwd' de CoberturaEstimacion es nulo");
        }
        

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarCoberturaEstimacion => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o passwd son invalidos");
        }

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
                    this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3",
                    "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarCoberturaEstimacion => ejecutarFuncionHistoricoTerminalNuevo");
        }

        if ((serv.getDatosCobertura() == null) || (serv.getDatosCobertura().length == 0)) {
            return new MovilResultadoOperacion(false, "ERROR: Los datos de cobertura / monto son nulos");
        }

        final Set<String> tempSet = new HashSet<>();

        for (final MovilDatosCobertura cob : serv.getDatosCobertura()) {
            if (!tempSet.add(cob.getClaveCobertura())) {
                return new MovilResultadoOperacion(false, "ERROR: Se detecto una cobertura duplicada: "
                        + cob.getClaveCobertura());
            }
        }
        
		try {
			if (term.getFechaEstatusTermino() == null) {
				return new MovilResultadoOperacion(false,
						"ERROR: Favor de terminar su reporte para generar Siniestro.");
			}
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"insertarCoberturaEstimacion => validarFechaEstatusTermino");
		}

        try {
            final WSSiniestroServiceImplService ws = new WSSiniestroServiceImplService(
                    new URL(this.configuracionDao
                            .obtenerCadena(JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_MOVIL_COBERTURA_ESTIMACION_WSDL)));

            // Aperturas
            final AperturaEstimacion ap = new ObjectFactory().createAperturaEstimacion();
            ap.setCveUsuario(this.getConfiguracionDao().obtenerCadena(
                    JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_MOVIL_COBERTURA_ESTIMACION_USUARIO));
            ap.setReporte(serv.getReporte());

//            boolean cobFlex13 = false ;
            for (final MovilDatosCobertura cob : serv.getDatosCobertura()) {
                if (StringUtils.isNotBlank(cob.getClaveCobertura())) {
                    final AperturaReserva res = new ObjectFactory().createAperturaReserva();
                    res.setCveCobertura(cob.getClaveCobertura());
                    res.setMontoEstimacion(new Float(cob.getEstimacion()).floatValue());
                    //Envio de coberturas flexibles
                    res.setCveCoberturaFlexible(cob.getClaveCoberturaFlexibles());
//                    if (cob.getClaveCoberturaFlexibles().contains("13")) {
//						cobFlex13 = true;
//					}
                    ap.getEstimaciones().add(res);
                }
            }

            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
                    this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3",
                    "Envio a  SISE -> " + this.xmlFactory.obtenerString(ap));
    		
            final ResultadoAperturaEstimacion req = ws.getWSSiniestroServiceImplPort().aperturaEstimacion(
                    serv.getReporte(),
                    ap.getEstimaciones(),
                    this.getConfiguracionDao().obtenerCadena(
                            JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_MOVIL_COBERTURA_ESTIMACION_USUARIO));

            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
                    this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3",
                    "Respuesta de SISE -> " + this.xmlFactory.obtenerString(req));

            if (req == null) {
                return new MovilResultadoOperacion(false, "ERROR: Respuesta de SISE NULA o vacio");

            }
            if (req.getResultado() == null) {
                return new MovilResultadoOperacion(false, "ERROR: Resultado en Respuesta de SISE NULO o vacio");

            }

            if ((req.getResultado().getCodigo() == 0)) {
                this.terminalDao.ejecutarFuncionTerminalInsertarUltimoSiniestro(term.getId(), req.getNumeroSiniestro());
                
                if(term.getReporteSac() != null){
                    Map<String, Object> respuestaSac = new HashMap<String, Object>();
    					
                        this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
                                this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3",
                                "Envio a  SAC -> " + this.xmlFactory.obtenerString(ap));
                        
                    	try{
                    		respuestaSac = SacSPDao.insertarCoberturaEstimacion(ap, req.getNumeroSiniestro());
                    	
                    	}catch(Exception e){
                            try {
                                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
                                        this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3",
                                        "MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
                            } catch (final Exception ex) {
                                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                                        "insertarCoberturaEstimacion => ejecutarFuncionHistoricoTerminalNuevo");
                            }
                            return new MovilResultadoOperacion(false, "ERROR en SAC: " + e.getMessage());
                    	}
                    	
                    	try {
        	                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
        	                        this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3", "Respuesta de SAC -> " + respuestaSac);
        	            } catch (final Exception ex) {
        	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
        	                        "insertarCoberturaEstimacion => ejecutarFuncionHistoricoTerminalNuevo");
        	            }
                    	
                    	if(!respuestaSac.get("salida").toString().contains("ERROR")){
                    		Map<String, List<Map<String, Object>>> descAtividadRecuperos = new HashMap<String, List<Map<String, Object>>>();
                    		List<Map<String, Object>> detalleCoberturaList = new ArrayList<Map<String, Object>>();
                        	Map<String, Object> detalleCobertura;
                    		for (MovilDatosCobertura datosCobertura : serv.getDatosCobertura()) {
                    			CatalogoCoberturas catalogoCoberturas = new CatalogoCoberturas();
                            	try {
                            		catalogoCoberturas = catalogoCoberturasDao.objetoCatalogoCoberturasClave(datosCobertura.getClaveCobertura());
                				} catch (Exception ex) {
                					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                	                        "insertarGestion => obtenerDescRecuperacion");
                				}
                    			detalleCobertura = new HashMap<>();
                    			detalleCobertura.put("claveCobertura", datosCobertura.getClaveCobertura());
                    			detalleCobertura.put("decClaveCobertura", (catalogoCoberturas != null ? catalogoCoberturas.getDescripcion() : ""));
                    			detalleCobertura.put("monto", datosCobertura.getEstimacion());
                    			
                    			detalleCoberturaList.add(detalleCobertura);
							}
                    		
                    		descAtividadRecuperos.put("coberturas", detalleCoberturaList);
                    		
                    		ObjectMapper mapper = new ObjectMapper();
                        	String descActividad = mapper.writeValueAsString(descAtividadRecuperos);
                    		
                    		this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), 
                    				term.getReporteSac().getGeneralNumeroReporte(), term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
                    				"Insertar Cobertura - Estimación", serv.getUsuario(), "Dispositivo Móvil", descActividad, req.getNumeroSiniestro());
                    		try {
                    			this.conclusionSiniestro.actualizarSiniestro(term.getReporteSac().getGeneralNumeroReporte().toString(), term.getReporteSac().getGeneralNumeroPoliza().toString(), req.getNumeroSiniestro().toString());
                    		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException |RollbackException e) {
                    			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"Insertar Cobertura - Estimación => actualizarSiniestro");
							} catch (DataAccessException | PersistenceException e) {
								this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"Insertar Cobertura - Estimación => actualizarSiniestro");
							}
                    		
							term.getReporteSac().setGeneralNumeroSiniestro(req.getNumeroSiniestro());
                    		term.getReporteSac().guardarObjeto();
//                    		if (cobFlex13) {
//                    			try {
//                        			usuarioFrecuenciaService.envioDeCorreoCobFlex13(term,req.getNumeroSiniestro(), serv.getReporte() ,3,6);
//                        		} catch (Exception e) {
//                        			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
//                        					"insertarEncuesta => usuarioFrecuenciaService envio de Correo");
//                    			}
//                    		}
                    		return new MovilResultadoOperacion(true, "OK: " + req.getNumeroSiniestro());
                    	}
                    	return new MovilResultadoOperacion(false, "ERROR: " + respuestaSac.get("salida"));
                }
                term.getReporteSac().setGeneralNumeroSiniestro(req.getNumeroSiniestro());
                term.getReporteSac().guardarObjeto();
                
                return new MovilResultadoOperacion(true, "OK: " + req.getNumeroSiniestro());
            }
            return new MovilResultadoOperacion(false, "ERROR: SISE Responde: " + req.getResultado().getDescripcion());

        } catch (final Exception e) {
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
                        this.fuenteWS + "insertarCoberturaEstimacion", "Insertar Cobertura Estimacion V3",
                        "MUY MAL !!! SISE EXCEPCIONA!!! -> " + e.getMessage());
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "insertarCoberturaEstimacion => ejecutarFuncionHistoricoTerminalNuevo");
            }

            return new MovilResultadoOperacion(false, "ERROR en SISE: " + e.getMessage());
        }

    }

    @Override
    public MovilResultadoInicioDeSession solicitarInicioDeSesion(final MovilInicioDeSesion serv) {
        if (serv == null) {
            return new MovilResultadoInicioDeSession(false, "ERROR: Es necesario especificar las credenciales");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoInicioDeSession(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoInicioDeSession(false, "ERROR: Es necesario especificar una contrasena");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => objetoTerminalParaProveedorYPasswd");
        }
        if (term == null) {
            return new MovilResultadoInicioDeSession(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }
        
        //Verificar la Version
        String versionAjustador = null;
        try {
		  versionAjustador = this.getConfiguracionDao().obtenerCadena(JMConstantes.CONFIGURACION_VERSION_AJUSTADOR);
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => objetoConfiguracionVersionAjustador");
        }
        
        try {
        	String[] versiones = versionAjustador.split("\\|");
        	ArrayList<String> lista = new ArrayList<>();
	        	for (int i = 0; i < versiones.length; i++) {
					lista.add(versiones[i]); 
				}
	       if(lista.contains(serv.getVersion())) {} else {
	    	   try {
	               this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
	                       this.fuenteWS + "solicitarInicioDeSesion", "Inicio de Sesion Movil V3",
	                       "ADVERTENCIA: La versión no está actualizada, no es posible iniciar sesión. -> " + this.xmlFactory.obtenerString(serv));
	           } catch (final Exception ex) {
	               this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                       "solicitarInicioDeSesion => ejecutarFuncionHistoricoTerminalNuevo");
	           }
	    	 return new MovilResultadoInicioDeSession(false, "ADVERTENCIA: La versión no está actualizada, no es posible iniciar sesión.");
	    	   
	    	   
	       }
        } catch (Exception e) {
        	 this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
                     "solicitarInicioDeSesion => VerificarVersionDeAjustador");
		}
        if (StringUtils.isNotBlank(serv.getUid())) {
        	try {
				this.terminalDao.ejecutarFuncionTerminalInsertarUidAndroid(term.getId(), serv.getUid());
			} catch (Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "solicitarInicioDeSesion => ejecutarFuncionTerminalInsertarUidAndroid");;
			}
        }
        try {
            this.terminalDao.ejecutarFuncionTerminalInsertarFechaUltimoLoginDia(term.getId());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => ejecutarFuncionTerminalInsertarFechaUltimoLoginDia");
        }

        try {
            this.sessionExternaDao.informacionDeSessionExterna(term, "Inicio de sesion con usuario y contraseña");
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => informacionDeSessionExterna");

        }

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
                    this.fuenteWS + "solicitarInicioDeSesion", "Inicio de Sesion Movil V3",
                    "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => ejecutarFuncionHistoricoTerminalNuevo");
        }

        if (!StringUtils.equalsIgnoreCase(term.getEstatus(), "disponible")
                && !StringUtils.equalsIgnoreCase(term.getEstatus(), "guardia")
                && !StringUtils.equalsIgnoreCase(term.getEstatus(), "autopista")) {

            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null, term, null, this.fuenteWS + "solicitarInicioDeSesion",
                      "Inicio de Sesion Movil V3",
                      "Inicio de Sesion Rechazado. Usuario -> " + serv.getUsuario() + ", Passwd-> "
                      + serv.getPasswd() + "Estatus actual: " + term.getEstatus());
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "solicitarInicioDeSesion => ejecutarFuncionHistoricoTerminalNuevo");
            }

            return new MovilResultadoInicioDeSession(false, "Inicio de Sesion Rechazada. Su estatus es: "
                    + term.getEstatus());

        }

        List<Comunicado> lc = null;
        try {
            lc = this.comunicadoDao.listaDeComunicado(null, null, term, Boolean.TRUE);
        } catch (final Exception ex) {
            this.utileriaExcepcion
                    .manejarExcepcion(ex, this.getClass(), "solicitarInicioDeSesion => listaDeComunicado");
        }

        if (term.getReporteSise() != null) {

            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
                        this.fuenteWS + "solicitarInicioDeSesion", "Inicio de Sesion Movil V3",
                        "Usuario -> se inicio sesion pero tiene el reporte: "
                                + term.getReporteSise().getGeneralNumeroReporte() + ". Se mantiene su estatus actual.");
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "solicitarInicioDeSesion => ejecutarFuncionHistoricoTerminalNuevo");
            }
            return new MovilResultadoInicioDeSession(true, "OK", lc);

        }else if (term.getReporteSac() != null) {

            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
                        this.fuenteWS + "solicitarInicioDeSesion", "Inicio de Sesion Movil V3",
                        "Usuario -> se inicio sesion pero tiene el reporte: "
                                + term.getReporteSac().getGeneralNumeroReporte() + ". Se mantiene su estatus actual.");
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "solicitarInicioDeSesion => ejecutarFuncionHistoricoTerminalNuevo");
            }
            return new MovilResultadoInicioDeSession(true, "OK", lc);

        }

        try {
            this.historicoTerminalServiceInterfase
                    .ejecutarFuncionHistoricoTerminalNuevo(null, term, null, this.fuenteWS + "solicitarInicioDeSesion",
                     "Inicio de Sesion Movil V3",
                     "Se inicio sesion y se puso en disponible, no tiene reportes pendientes.");
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => ejecutarFuncionHistoricoTerminalNuevo");
        }

        try {
            final JMResultadoOperacion r = this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(serv.getUsuario(),
                    JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "solictarInicioDeSession");

            return new MovilResultadoInicioDeSession(r.isExito(), r.getMensaje(), lc);
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarInicioDeSesion => ejecutarFuncionTerminalEstatusDisponible");
            return new MovilResultadoInicioDeSession(false, ex.getMessage());

        }

    }

    @Override
    public MovilResultadoOperacion solicitarCobroBancario(final MovilServicioCobroBancario serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar las credenciales");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
        }

        if (StringUtils.isBlank(serv.getReporte())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un numero de reporte");
        }
        if (StringUtils.isBlank(serv.getTipoCobro())) {
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar un tipo de cobro. Pago de Prima, Pago de Deducible o Pago de Poliza (P.P. P.D. P.R)");
        }
        if (StringUtils.length(serv.getTarjetaNombre()) < 5) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre especificado es muy corto");
        }

        if (StringUtils.equalsIgnoreCase(serv.getTarjetaTipo(), "AMEX")
                && (StringUtils.length(serv.getTarjetaCVV()) != 4)) {
            return new MovilResultadoOperacion(false, "ERROR: El codigo CVV debe de tener solamente 4 digitos numerico");
        }

        if (StringUtils.equalsIgnoreCase(serv.getTarjetaTipo(), "V/MC")
                && (StringUtils.length(serv.getTarjetaCVV()) != 3)) {
            return new MovilResultadoOperacion(false, "ERROR: El codigo CVV debe de tener solamente 3 digitos numerico");
        }

        if (StringUtils.length(serv.getTarjetaExpiraAno()) != 2) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El anio de expiracion de la tarjeta debe de contener solamente 2 digitos numericos");
        }
        if (StringUtils.length(serv.getTarjetaExpiraMes()) != 2) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El mes de expiracion de la tarjeta debe de contener solamente 2 digitos numericos");
        }

        if (StringUtils.isBlank(serv.getTarjetaNumero())) {
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar el numero de 16 digitos de la tarjeta de credito");
        }
        if (StringUtils.isBlank(serv.getTarjetaTipo())) {
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar el tipo de la tarjeta de credito");
        }
        if (StringUtils.isBlank(serv.getMonto())) {
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar el monto a cobrar de la tarjeta de credito");
        }

        if (!StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.P.")
                && !StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.D.")
                && !StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.R.")) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El tipo de cobro no es correcto. Los valores permitidos son 'P.P.', 'P.D.', 'P.R.'");
        }

        if (!StringUtils.equalsIgnoreCase(serv.getTarjetaTipo(), "V/MC")
                && !StringUtils.equalsIgnoreCase(serv.getTarjetaTipo(), "AMEX")) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El tipo de tarjeta. Los valores permitidos son 'V/MC', 'AMEX'");
        }

        if (StringUtils.length(serv.getTelefono()) != 10) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El numero de telefono celular debe ser en formato de 10 digitos numericos sin 044.");
        }

        if (serv.getMesesSinIntereses() == null) {
            return new MovilResultadoOperacion(false,
                    "ERROR: Es requerido indicar si la operacion es a meses sin intereses o no.");

        }
        if (BooleanUtils.isTrue(serv.getMesesSinIntereses()) && (serv.getNumeroDeMesesSinIntereses() == null)) {
            return new MovilResultadoOperacion(false,
                    "ERROR: Es requerido indicar el numero de meses sin intereses si la operacion va a ser a meses sin intereses.");
        }
        if (BooleanUtils.isTrue(serv.getMesesSinIntereses()) && (serv.getNumeroDeMesesSinIntereses().intValue() != 3)
                && (serv.getNumeroDeMesesSinIntereses().intValue() != 6)) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El numero de meses sin intereses no es valido. Los valores aceptados son '3' y '6'.");
        }
        
        if(BooleanUtils.isFalse(serv.getMesesSinIntereses()) && (serv.getNumeroDeMesesSinIntereses() != 0)){
        	return new MovilResultadoOperacion(false, "ERROR: Existe un error para solicitar meses sin intereses, favor de reportarlo.");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarCobroBancario => objetoTerminalParaProveedorYPasswd");

        }
        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                    null, term, serv.getReporte(), this.fuenteWS + "solicitarCobroBancario", "Cobro Movil V3",
                    "Usuario -->" + serv.getUsuario() + "pass -->" + serv.getPasswd() + ", rep -->" + serv.getReporte()
                            + ", tipo-->" + serv.getTipoCobro() + ", num--> *************************, nomb -->"
                            + serv.getTarjetaNombre() +  ", expm -->"
                            + serv.getTarjetaExpiraMes() + ", expa -->" + serv.getTarjetaExpiraAno() + ", tipo -->"
                            + serv.getTarjetaTipo() + ", monto -->" + serv.getMonto() + ", telefono -->"
                            + serv.getTelefono() + ", correo -->" + serv.getCorreoElectronico() + ", es a meses -->"
                            + serv.getMesesSinIntereses() + ", numero de meses sin intereses -->"
                            + serv.getNumeroDeMesesSinIntereses() + ", cobertura afectada --> "
                            + serv.getCoberturaAfectada());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
        }

        try {
            this.sessionExternaDao.informacionDeSessionExterna(term, "Cobro con tarjeta de credito");
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarCobroBancario => informacionDeSessionExterna");
        }

        try {
            final Transaccion transaccion = JMUtileriaBancaria.realizarCobro(term, null, serv.getTipoCobro(), serv
                    .getTarjetaNombre(), serv.getTarjetaNumero(), serv.getTarjetaExpiraMes(), serv
                    .getTarjetaExpiraAno(), serv.getTarjetaCVV(), serv.getTarjetaTipo(), serv.getMonto(), term
                    .getReporteAtendiendo(), term.getReporteSise() != null ? term.getReporteSise()
                    .getGeneralNumeroPoliza() : null, null, serv.getCoberturaAfectada(), serv.getTelefono(), serv
                    .getCorreoElectronico(), JMConstantes.TRANSACCION_FUENTE_CELULAR, serv.getMesesSinIntereses(), serv
                    .getNumeroDeMesesSinIntereses(), null);

            if (transaccion != null) {
            	
				try {

					Map<String, String> descAtividadCobro = new HashMap<>();
					Map<String, String> descResultado = new HashMap<>();

					descAtividadCobro.put("coberturaAfectada", serv.getCoberturaAfectada());
					descAtividadCobro.put("mesesSinIntereses", (serv.getMesesSinIntereses() ? "SI" : "NO"));
					
					if(serv.getMesesSinIntereses()) {
						descAtividadCobro.put("numeroMesesSinIntereses", String.valueOf(serv.getNumeroDeMesesSinIntereses()));
					}
					
					descAtividadCobro.put("monto", serv.getMonto());
					descAtividadCobro.put("tipoCobro", serv.getTipoCobro());
					
					descResultado.put("numeroAutorizacion", transaccion.getNumeroAutorizacion());
					descResultado.put("numeroOperacion", transaccion.getNumeroOperacion());
					descResultado.put("estatus", (transaccion.getTransaccionAprobada() ? "ACEPTADA" : "DECLINADA"));
					
					ObjectMapper mapper = new ObjectMapper();
					String descActividad = mapper.writeValueAsString(descAtividadCobro);
					
					ObjectMapper mapperResultado = new ObjectMapper();
					String resultado = mapperResultado.writeValueAsString(descResultado);

					this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
							term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(),
							term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(),
							"Cobro Bancario", serv.getUsuario(), "Dispositivo Móvil", descActividad, resultado);
				} catch (Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarTermino => ejecutarFuncionHistoricoResumenAjustadorNuevo");
				}
            	
                if (BooleanUtils.isTrue(transaccion.getTransaccionAprobada())) {
                    return new MovilResultadoOperacion(true, "APROBADA. FECHA: " + transaccion.getFecha()
                            + " OPERACION: " + transaccion.getNumeroOperacion() + "  AUTORIZACION: "
                            + transaccion.getNumeroAutorizacion() + " MONTO: " + transaccion.getMonto());
                }
                return new MovilResultadoOperacion(false, "NO APROBADA: " + transaccion.getRespuestaAmigable());

            }

        } catch (final Exception e) {
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                        serv.getReporte(), this.fuenteWS + "solicitarCobroBancario", "Cobro Movil V3",
                        "MUY MAL!!! LINK2B  EXCEPCIONA ->" + e.getMessage());
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "solicitarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
            }

            return new MovilResultadoOperacion(false, "Error al hacer el cobro. Detalles: " + e.getMessage());
        }

        return new MovilResultadoOperacion(false, "DECLINADA.");
    }

    @Override
    public MovilReporte solicitarDatosDeReporte(final MovilInicioDeSesion serv) {
    	boolean esAjustadorVulnerable = false;
        if (serv == null) {
            return new MovilReporte("ERROR: Es necesario especificar las credenciales", null, null, esAjustadorVulnerable);
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilReporte("ERROR: Es necesario especificar un usuario", null, null, esAjustadorVulnerable);
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilReporte("ERROR: Es necesario especificar una contrasena", null, null, esAjustadorVulnerable);
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarDatosDeReporte => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilReporte("ERROR: Usuario o contrasena invalidos", null, null,esAjustadorVulnerable);
        }

        try {
            this.sessionExternaDao.informacionDeSessionExterna(term, "Consulta simple de su reporte");
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarDatosDeReporte => informacionDeSessionExterna");
        }
        
		// ***REPORTE SAC***
        if (term.getReporteSac() != null) {

			try {
								
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term
						.getReporteSac().toString(), this.fuenteWS + "solicitarDatosDeReporteSac",
	                  "Solicitar  Datos de Reporte Movil V3",
	            "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
				
				try{
					final ReporteMovilSac repSacOut = this.reporteSacDao.objetoReporteMovilSac(
							term.getReporteSac().toString(), term.getNumeroproveedor());
					
					if(repSacOut != null){
						if (term.getBase().getVulnerable()) {
							repSacOut.setConductorTelefonoContacto(term.getReporteSac().getConductorTelefonoContacto());
							esAjustadorVulnerable = true;
						} else {
							repSacOut.setConductorTelefonoContacto("NO DISPONIBLE");
						}
						
						try {
							ReporteMovilSac salida = reporteSacDao.objetoReporteMovilSac(repSacOut.getGeneralNumeroReporte(), null);
							if (salida != null) {
								UtileriaCadenas utileria = new UtileriaCadenas();
								String fechaOcurrido = null;
								String fechaPasado = null;
								String horaOcurrido = null;
								String horaPasado = null;
								if (StringUtils.isNotBlank(salida.getGeneralFechaOcurrido())) {
									if (salida.getGeneralFechaOcurrido().contains("-")) {
										fechaOcurrido = utileria.modFechaOcurrido(salida.getGeneralFechaOcurrido());
										if (StringUtils.isNotBlank(fechaOcurrido)) {
											salida.setGeneralFechaOcurrido(fechaOcurrido);
											repSacOut.setGeneralFechaOcurrido(fechaOcurrido);
										}
									}
									if (salida.getHoraFechaOcurrido().contains(".")) {
										horaOcurrido = utileria.modHora(salida.getGeneralHoraOcurrido());
										if (StringUtils.isNotBlank(horaOcurrido)) {
											salida.setGeneralHoraOcurrido(horaOcurrido);
											repSacOut.setGeneralHoraOcurrido(horaOcurrido);
										}
									}
									if (salida.getAjusteFechaPasadoAjustador().contains("-")) {
										fechaPasado = utileria.modFechaPasado(salida.getAjusteFechaPasadoAjustador());
										if (StringUtils.isNotBlank(fechaPasado)) {
											salida.setAjusteFechaPasadoAjustador(fechaPasado);
											repSacOut.setAjusteFechaPasadoAjustador(fechaPasado);
										}
									}
									if (salida.getAjusteHoraPasadoAjustador().contains(".")) {
										horaPasado = utileria.modHora(salida.getAjusteHoraPasadoAjustador());
										if (StringUtils.isNotBlank(horaPasado)) {
											salida.setAjusteHoraPasadoAjustador(horaPasado);
											repSacOut.setAjusteHoraPasadoAjustador(horaPasado);
										}
									}
									if (StringUtils.isNotBlank(fechaOcurrido) | StringUtils.isNotBlank(horaOcurrido) |
											StringUtils.isNotBlank(fechaPasado) | StringUtils.isNotBlank(horaPasado)) {
										salida.guardarObjeto();
									}
								}
								
							}
						} catch (DataAccessException | RollbackException  | ClassCastException  e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
			                        "solicitarDatosDeReporte => validacion ajuste_fecha_pasado_ajustador");
			            
						} catch (Exception  e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
			                        "solicitarDatosDeReporte => validacion ajuste_fecha_pasado_ajustador");
			            
						}
						
						if(repSacOut.getFechaReporteLecturaPorWs() == null){
							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term
									.getReporteSac().toString(), this.fuenteWS + "solicitarDatosDeReporteSac",
				                  "Solicitar  Datos de Reporte Movil V3",
				            "Ejecucion de SP_DISPOSITIVO_MOVIL_VISTO -> " + repSacOut.getGeneralNumeroReporte());
							
							final String respVistoSac = this.SacSPDao.dispositivoMovilVisto(repSacOut.getGeneralNumeroReporte());
							
							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term
									.getReporteSac().toString(), this.fuenteWS + "solicitarDatosDeReporteSac",
				                  "Solicitar  Datos de Reporte Movil V3",
				            "Respuesta SP_DISPOSITIVO_MOVIL_VISTO -> " + respVistoSac);
							
							try {
				                this.reporteSacDao.ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs(term.getReporteSac().getId());
				            } catch (final Exception ex) {
				                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
				                        "solicitarDatosDeReporte => ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs");
				            }
							
							this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
									term.getNumeroproveedor(), term.getNombre(), repSacOut.getGeneralNumeroReporte(),
									repSacOut.getGeneralNumeroPoliza(), repSacOut.getGeneralInciso(),
									"Solicitar Datos de Reporte", serv.getUsuario(), "Dispositivo Móvil",
									"Solicitar Datos de Reporte ", respVistoSac);
						}
					}else{
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().toString(), this.fuenteWS + " solicitarDatosDeReporteSac", 
								"Solicitar  Datos de Reporte Movil V3", "Reporte no Existente o sin código de Ajustador");
					}
					
					return new MovilReporte("OK", null, repSacOut, esAjustadorVulnerable ); 
				}catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "solicitarDatosDeReporte => ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs");
	                return new MovilReporte("ERROR: " + ex.getMessage(), null, null, esAjustadorVulnerable);
	            }
						
			} catch (Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"solicitarDatosDeReporte => objetoReporteMovilSac");
				return new MovilReporte("ERROR: " + ex.getMessage(), null, null, esAjustadorVulnerable);
			}

		}
        return new MovilReporte("ERROR: Intente más tarde.",null, null, false);
    }

    @Override
	public MovilResultadoOperacion insertarAbogado(final MovilServicioAbogado serv) {
		if (serv == null) {
			return new MovilResultadoOperacion(false, "ERROR: El objeto es nulo");
		}
		if (StringUtils.isBlank(serv.getUsuario())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(serv.getPasswd())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
		}
		if (StringUtils.isBlank(serv.getNumeroReporte())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de reporte");
		}
		if (serv.getConductorDetenido() == null) {
			return new MovilResultadoOperacion(false,"ERROR: Es necesario especificar si el conductor ha sido detenido");
		}
		if (serv.getVehiculoDetenido() == null) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar si el vehiculo ha sido retenido");
		}
		if (serv.getNumeroLesionadosNA() == null) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de lesionados NA");
		}
		if (serv.getNumeroLesionadosTS() == null) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de lesionados TS");
		}
		if (serv.getNumeroMuertosNA() == null) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de muertos NA");
		}
		if (serv.getNumeroMuertosTS() == null) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de muertos TS");
		}
		if (StringUtils.isBlank(serv.getLugarAPresentarse())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el lugar a presentarse");
		}
		if (StringUtils.isBlank(serv.getIdEntidad())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el codigo de entidad");
		}
		if (serv.getMotivoSolicitud() == null) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el motivo de la solicitud");
		}
		if (StringUtils.isBlank(serv.getResponsabilidad())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar la responsabilidad");
		}
		if (StringUtils.isBlank(serv.getDescAPresentarse())) {
			return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar la descripción lugar a presentarse");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"insertarAbogado => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return new MovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
		}

		if (term.getReporteSise() == null && term.getReporteSac() == null) {
			return new MovilResultadoOperacion(false,
					"ERROR: El usuario actual no se encuentra atendiendo algun reporte.");
		}

		String reporteAEnviar = "";
		Map<String, Object> respuestaSac = new HashMap<String, Object>();
		String[] mensaje = {};
		boolean esEntidadBloqueada = true;
		
		// -------------Cambio Temporal ----------------
		if (term.getReporteSise() != null && term.getReporteSise().getUbicacionEntidad() != null) {
			reporteAEnviar = term.getReporteSise().getGeneralNumeroReporte();
			EntidadAbogadoCrm entidadAbogado = new EntidadAbogadoCrm();
			
			try {
				entidadAbogado = entidadAbogadoCrmService.objetoEntidadAbogadoCrm(term.getReporteSise().getUbicacionEntidad());
				if(entidadAbogado != null && entidadAbogado.getAbogadoCrmEstatus() == Estatus.A){
					esEntidadBloqueada = BooleanUtils.toBooleanObject(entidadAbogado.getCrmAbogado());
					if(!esEntidadBloqueada) {
						return new MovilResultadoOperacion(false, "FAVOR DE SOLICITAR A CABINA EL SERVICIO");
					}
				}
			} catch (Exception e1) {
			}
			
			final DatosSolicitudAbogado solicitudAbogado = new DatosSolicitudAbogado();

			solicitudAbogado.setNumeroReporte(serv.getNumeroReporte());
			solicitudAbogado.setCodigoAjustador(term.getNumeroproveedor());
			solicitudAbogado.setMotivoAsignacion(serv.getMotivoSolicitud().toString());
			solicitudAbogado.setApreciacionResponsabilidad(serv.getResponsabilidad());
			solicitudAbogado.setLugarPresentarse(serv.getLugarAPresentarse());
			solicitudAbogado.setVehiculoDetenido(serv.getVehiculoDetenido());
			solicitudAbogado.setNumLesa(serv.getNumeroLesionadosNA());
			solicitudAbogado.setNumHoma(serv.getNumeroMuertosNA());
			solicitudAbogado.setNumLest(serv.getNumeroLesionadosTS());
			solicitudAbogado.setNumHomt(serv.getNumeroMuertosTS());
			solicitudAbogado.setConductorDetenido(serv.getConductorDetenido());	
			solicitudAbogado.setIdEntidad(serv.getIdEntidad());
			solicitudAbogado.setDescripPresentarse(serv.getDescAPresentarse());
			
			try {
				if (serv.getPt() != null) {
					if (serv.getPt()) {
						solicitudAbogado.setPt(1); 
					} else {
						solicitudAbogado.setPt(0); 
					}
				} else {
					solicitudAbogado.setPt(0); 
				}
			} catch (ClassCastException e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				solicitudAbogado.setPt(0);
			}
			

			try {
				
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
							serv.getNumeroReporte(), this.fuenteWS + "insertarAbogado", "Insertar Abogado Movil V3",
							"Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(solicitudAbogado));
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				}
				
				respuestaSac = this.SacSPDao.solicitudAbogado(solicitudAbogado, term);
				mensaje = respuestaSac.get("salida").toString().split("\\|");
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
							this.fuenteWS + "insertarAbogado", "insertarAbogado Movil V3",
							"Respuesta de SAC -> " + mensaje);
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				}

				if (respuestaSac != null && respuestaSac.get("salida") != null) {
					mensaje = respuestaSac.get("salida").toString().split("\\|");

					if (mensaje[0].equals("1")) {
						ObjectMapper mapper = new ObjectMapper();
						String descActividad = mapper.writeValueAsString(solicitudAbogado);
						
						try {
							this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
									term.getNumeroproveedor(), term.getNombre(),
									term.getReporteSac().getGeneralNumeroReporte(),
									term.getReporteSac().getGeneralNumeroPoliza(),
									term.getReporteSac().getGeneralInciso(), "Insertar Abogado", serv.getUsuario(),
									"Dispositivo Móvil", descActividad, mensaje[1]);
						} catch (Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarAbogado => ejecutarFuncionHistoricoResumenAjustadorNuevo");
						}
						
						final ReporteAbogado reporte = new ReporteAbogado(term, new Date(), reporteAEnviar, null, null,
								"Abierto", serv.getConductorDetenido(), serv.getVehiculoDetenido(),
								serv.getNumeroLesionadosNA(), serv.getNumeroLesionadosTS(), serv.getNumeroMuertosNA(),
								serv.getNumeroMuertosTS(), serv.getLugarAPresentarse(), Integer.parseInt(serv.getResponsabilidad()),
								serv.getMotivoSolicitud(), null);

						reporte.guardarObjeto();
					}

					return new MovilResultadoOperacion(mensaje[0].equals("1") ? true : false, mensaje[1]);
				} else {
					return new MovilResultadoOperacion(false, "No se recibio respuesta de SAC");
				}
			} catch (Exception e) {
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getNumeroReporte(),
							this.fuenteWS + "insertarAbogado", "insertar Abogado Movil V3",
							"MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				}

				return new MovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje:  " + e.getMessage());
			}
		}

		//************ REPORTE SAC****************
		if (term.getReporteSac() != null && term.getReporteSac().getUbicacionEntidad() != null) {
			reporteAEnviar = term.getReporteSac().getGeneralNumeroReporte();
			EntidadAbogadoCrm entidadAbogado = new EntidadAbogadoCrm();
			
			try {
				entidadAbogado = entidadAbogadoCrmService.objetoEntidadAbogadoCrm(term.getReporteSac().getUbicacionEntidad());
				if(entidadAbogado != null && entidadAbogado.getAbogadoCrmEstatus() == Estatus.A){
					esEntidadBloqueada = BooleanUtils.toBooleanObject(entidadAbogado.getCrmAbogado());
					if(!esEntidadBloqueada) {
						return new MovilResultadoOperacion(false, "FAVOR DE SOLICITAR A CABINA EL SERVICIO");
					}
				}
			} catch (Exception e1) {
			}
			
			final DatosSolicitudAbogado solicitudAbogado = new DatosSolicitudAbogado();

			solicitudAbogado.setNumeroReporte(serv.getNumeroReporte());
			solicitudAbogado.setCodigoAjustador(term.getNumeroproveedor());
			solicitudAbogado.setMotivoAsignacion(serv.getMotivoSolicitud().toString());
			solicitudAbogado.setApreciacionResponsabilidad(serv.getResponsabilidad());
			solicitudAbogado.setLugarPresentarse(serv.getLugarAPresentarse());
			solicitudAbogado.setVehiculoDetenido(serv.getVehiculoDetenido());
			solicitudAbogado.setNumLesa(serv.getNumeroLesionadosNA());
			solicitudAbogado.setNumHoma(serv.getNumeroMuertosNA());
			solicitudAbogado.setNumLest(serv.getNumeroLesionadosTS());
			solicitudAbogado.setNumHomt(serv.getNumeroMuertosTS());
			solicitudAbogado.setConductorDetenido(serv.getConductorDetenido());
			solicitudAbogado.setIdEntidad(serv.getIdEntidad());
			solicitudAbogado.setDescripPresentarse(serv.getDescAPresentarse());
			
			try {
				if (serv.getPt() != null) {
					if (serv.getPt()) {
						solicitudAbogado.setPt(1); 
					} else {
						solicitudAbogado.setPt(0); 
					}
				} else {
					solicitudAbogado.setPt(0); 
				}
			} catch (ClassCastException e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				solicitudAbogado.setPt(0);
			}

			try {
				
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
							serv.getNumeroReporte(), this.fuenteWS + "insertarAbogado", "Insertar Abogado Movil V3",
							"Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(solicitudAbogado));
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				}
				
				respuestaSac = this.SacSPDao.solicitudAbogado(solicitudAbogado, term);
				mensaje = respuestaSac.get("salida").toString().split("\\|");
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getNumeroReporte(),
							this.fuenteWS + "insertarAbogado", "insertarAbogado Movil V3",
							"Respuesta de SAC -> " + respuestaSac);
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				}

				if (respuestaSac != null && respuestaSac.get("salida") != null) {
					mensaje = respuestaSac.get("salida").toString().split("\\|");

					if (mensaje[0].equals("1")) {
						final ReporteAbogado reporte = new ReporteAbogado(term, new Date(), reporteAEnviar, null, null,
								"Abierto", serv.getConductorDetenido(), serv.getVehiculoDetenido(),
								serv.getNumeroLesionadosNA(), serv.getNumeroLesionadosTS(), serv.getNumeroMuertosNA(),
								serv.getNumeroMuertosTS(), serv.getLugarAPresentarse(), Integer.parseInt(serv.getResponsabilidad()),
								serv.getMotivoSolicitud(),null);

						reporte.guardarObjeto();
						
						try {
							
							ObjectMapper mapper = new ObjectMapper();
							String descActividad = mapper.writeValueAsString(solicitudAbogado);
							
							this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
									term.getNumeroproveedor(), term.getNombre(),
									term.getReporteSac().getGeneralNumeroReporte(),
									term.getReporteSac().getGeneralNumeroPoliza(),
									term.getReporteSac().getGeneralInciso(), "Insertar Abogado", serv.getUsuario(),
									"Dispositivo Móvil", descActividad, mensaje[1]);
						} catch (Exception ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
									"insertarAbogado => ejecutarFuncionHistoricoResumenAjustadorNuevo");
						}
					}
					return new MovilResultadoOperacion(mensaje[0].equals("1") ? true : false, mensaje[1]);
				} else {
					return new MovilResultadoOperacion(false, "NO SE PUDO SOLICITAR LA ASIGNACIÓN. FAVOR DE INTENTAR DE NUEVO O APOYARSE CON CABINA.");
				}
			} catch (Exception e) {
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getNumeroReporte(),
							this.fuenteWS + "insertarAbogado", "insertar Abogado Movil V3",
							"MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"insertarAbogado => ejecutarFuncionHistoricoTerminalNuevo");
				}

				return new MovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje:  " + e.getMessage());
			}
		}
		return new MovilResultadoOperacion(false, "ERROR: Intente más tarde.");
	}

    @SuppressWarnings("unused")
	@Override
    public MovilResultadoOperacion solicitarServicio(final MovilServicioServicio serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto es nulo");
        }

        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarServicio => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }
        if (term.getReporteSise() == null) {
            return new MovilResultadoOperacion(false,
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
                    "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarServicio => ejecutarFuncionHistoricoTerminalNuevo");
        }

        if (StringUtils.isBlank(serv.getServicio())) {
            return new MovilResultadoOperacion(
                    false,
                    "ERROR: Es necesario especificar un tipo de servicio. Los valores permitidos son 'Grua', 'Ambulancia', 'Abogado', 'Constructora'");
        }

        if (StringUtils.isBlank(serv.getAtencion())) {
            return new MovilResultadoOperacion(
                    false,
                    "ERROR: Es necesario especificar un receptor de la atencion. Los valores permitidos son 'A' para asegurado, 'T' para tercero");
        }

        if (!StringUtils.equalsIgnoreCase(serv.getServicio(), "Grua")
                && !StringUtils.equalsIgnoreCase(serv.getServicio(), "Ambulancia")
                && !StringUtils.equalsIgnoreCase(serv.getServicio(), "Abogado")
                && !serv.getServicio().equalsIgnoreCase("Constructora")) {
            return new MovilResultadoOperacion(false,
                    "ERROR: El tipo de servicio especificado no es valido. Los valores permitidos son 'Grua', 'Ambulancia', 'Abogado'");
        }

        if (!StringUtils.equalsIgnoreCase(serv.getAtencion(), "A")
                && !StringUtils.containsIgnoreCase(serv.getAtencion(), "T")) {
            return new MovilResultadoOperacion(
                    false,
                    "ERROR: El tipo de atencion especificado no es valido. Los valores permitidos son 'A' para asegurado, 'T1','T2', 'T3 para tercero");
        }

        if (StringUtils.isBlank(serv.getProveedor())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una clave de proveedor.");
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

                return new MovilResultadoOperacion(false, "Respuesta de SISE con ERROR: " + e.getMessage());
            }

            if (resultado != null) {
                try {
                    final Resultado res = new JMXMLObjectFactory().obtenerResultadoParaString(resultado);

                    return new MovilResultadoOperacion(true, res.getDescResultado());
                } catch (final Exception e) {
                    return new MovilResultadoOperacion(false, "Respuesta de SISE con ERROR");
                }

            }
            return new MovilResultadoOperacion(false, "Resultado de SISE sin datos");

        }
        return null;
    }

    @Override
    public MovilResultadoOperacion insertarAbogadoArribo(final MovilServicioAbogadoArribo serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto es nulo");
        }

        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarAbogadoArribo => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                    serv.getNumeroReporte(), this.fuenteWS + "insertarAbogadoArribo",
                    "Insertar Arribo Abogado Movil V3",
                    "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarAbogadoArribo => ejecutarFuncionHistoricoTerminalNuevo");

        }

        if (StringUtils.isBlank(serv.getNumeroReporte())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar el numero de reporte");
        }
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new MovilResultadoOperacion(false,
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
                return new MovilResultadoOperacion(true, reporte.guardarObjeto().getMensaje());
            }
            return new MovilResultadoOperacion(false, "ERROR: El reporte especificado ya cuenta con fecha de arribo: "
                    + reporte.getFechaArribo());
        }
        return new MovilResultadoOperacion(false,
                "ERROR: El reporte no fue encontrado en la base de datos de reporte de abogados");
    }

    @Override
    public MovilResultadoOperacion solicitarServiciosDiversos(final MovilServicioDiverso serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto es nulo");
        }

        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
        }
        if (serv.getPersona() == null) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar si tercero es una persona.");
        }

        if (StringUtils.isNotBlank(serv.getPtEvidente())) {
        	 if (!StringUtils.equalsIgnoreCase(serv.getPtEvidente(), "1") && !StringUtils.containsIgnoreCase(serv.getPtEvidente(), "0")) {
                 return new MovilResultadoOperacion(false,
                        "ERROR: Pt Evidente no es valido. Los valores permitidos son '0' o '1'.");
             }
        }
        
        if (StringUtils.isNotBlank(serv.getAbandonoEvidente())) {
       	 if (!StringUtils.equalsIgnoreCase(serv.getAbandonoEvidente(), "1") && !StringUtils.containsIgnoreCase(serv.getAbandonoEvidente(), "0")) {
                return new MovilResultadoOperacion(false,
                       "ERROR: Abandono Evidente no es valido. Los valores permitidos son '0' o '1'.");
            }
       }
        
        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarServiciosDiversos => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }

        /*FOLIO SAC*/
        if (term.getReporteSac() != null) {
        	String numReporte = null;
        	if (term.getReporteSac().getGeneralNumeroReporte() != null) {
				numReporte = term.getReporteSac().getGeneralNumeroReporte();
			}
        	try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                		numReporte, this.fuenteWS + "solicitarServiciosDiversos",
                        "Solicitud de Servicios Diversos Movil V3",
                        "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
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
                return new MovilResultadoOperacion(
                        false,
                        "ERROR: Es necesario especificar un tipo de servicio. Los valores permitidos son 'Hospital', 'Ambulancia', 'Taller', 'Agencia', 'Constructora'");
            }

            if (StringUtils.isBlank(serv.getAtencionA())) {
                return new MovilResultadoOperacion(
                        false,
                        "ERROR: Es necesario especificar un receptor de la atencion. Los valores permitidos son 'A' para asegurado, 'T' para tercero");
            }

            if (StringUtils.isBlank(serv.getClaveDeProveedor())) {
                return new MovilResultadoOperacion(false,
                        "ERROR: Es necesario especificar una clave de proveedor solicitado.");
            }
            
            if(StringUtils.isNotBlank(serv.getPtEvidente())) {
            	 if (!StringUtils.equalsIgnoreCase(serv.getPtEvidente(), "0")
                         && !StringUtils.containsIgnoreCase(serv.getPtEvidente(), "1")) {
                     return new MovilResultadoOperacion(false,
                             "ERROR: El valor ptEvidente no es valido. Los valores permitidos son '0' y '1'.");
                 }
            }
            
            if(StringUtils.isNotBlank(serv.getAbandonoEvidente())) {
           	 if (!StringUtils.equalsIgnoreCase(serv.getAbandonoEvidente(), "0")
                        && !StringUtils.containsIgnoreCase(serv.getAbandonoEvidente(), "1")) {
                    return new MovilResultadoOperacion(false,
                            "ERROR: El valor abandonoEvidente no es valido. Los valores permitidos son '0' y '1'.");
                }
           }

            if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Hospital")
                    && (StringUtils.isBlank(serv.getLesionadoEdad()) || StringUtils.isBlank(serv.getLesionadoSexo()) || StringUtils
                    .isBlank(serv.getLesionadoNombre()))) {
                return new MovilResultadoOperacion(false,
                        "ERROR: Para el tipo de servicio 'Hospital' es requerido proporcionar los datos de los lesionados");
            }

            if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Ambulancia")
                    && StringUtils.isBlank(serv.getClaveDeAmbulancia())) {
                return new MovilResultadoOperacion(false,
                        "ERROR: Para el tipo de servicio 'Ambulancia' es requerido proporcionar la clave de la ambulancia");
            }

            if (!StringUtils.equalsIgnoreCase(serv.getAtencionA(), "A")
                    && !StringUtils.containsIgnoreCase(serv.getAtencionA(), "T")) {
                return new MovilResultadoOperacion(
                        false,
                        "ERROR: El tipo de atencion especificado no es valido. Los valores permitidos son 'A' para asegurado, 'T1','T2', 'T3 para tercero");
            }


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
            report.setNumeroReporte(term.getReporteSac().getGeneralNumeroReporte());
            report.setTerminal(term);
            report.setTipoDeServicio(serv.getTipoDeServicioSolicitado());

            final DatosDispositivoMovilFolio ap = new DatosDispositivoMovilFolio();

            ap.setAtencion(StringUtils.defaultString(serv.getAtencionA()));
            ap.setFolioVale(StringUtils.defaultString(serv.getFolioValeTalonario()));
            ap.setNumProveedor(StringUtils.defaultString(serv.getClaveDeProveedor()));
            ap.setNumReporte(report.getNumeroReporte());
            ap.setRamo(null);
            ap.setEjercicio(null);
            ap.setCodigoME(serv.getCodigoME());
            ap.setCobertura(serv.getCobertura());
            ap.setMontoMedico(serv.getMontoMedico());
            ap.setPolizaTerceroQualitas(serv.getPolizaTerceroQualitas());
            ap.setIncisoTerceroQualitas(serv.getIncisoTerceroQualitas());
            ap.setEndosoTerceroQualitas(serv.getEndosoTerceroQualitas());
            try {
	            if ( serv.getCarrilExpress() != null ) {
	            	ap.setCarrilExpress(serv.getCarrilExpress());            	
	            } 
            } catch (ClassCastException | IndexOutOfBoundsException | IllegalStateException | NumberFormatException e) {
			}
            
            ap.setIdObjeto(serv.getIdObjeto());
            ap.setPtEvidente(serv.getPtEvidente());
            ap.setAbadonoEvidente(serv.getAbandonoEvidente());

            int tipoClaveDeProveedor = 0;
            final AsignacionProveedorLesionadoSac les = new AsignacionProveedorLesionadoSac();
            les.setEdadLesionado(StringUtils.isNotBlank(serv.getLesionadoEdad()) ? new Integer(serv.getLesionadoEdad()) : new Integer(0));
            les.setNombreLesionado(StringUtils.defaultString(serv.getLesionadoNombre()));
            les.setSexoLesionado(StringUtils.defaultString(serv.getLesionadoSexo()));

            if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Taller")) {
                tipoClaveDeProveedor = 1;
            }
            if (StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Pago por Daños")) {
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
                return new MovilResultadoOperacion(
                        false,
                        "ERROR: El tipo de Proveedor no fue encontrado");

            }

            ap.setTipoProveedor(String.valueOf(tipoClaveDeProveedor));
            ap.setDanioMenor(serv.getDanioMenor());

            final String entradaSac = new JMXMLObjectFactory().obtenerString(ap, false);

            Map<String, Object> respuestaSac = null;
            String data = null;
            String tipoTercero = null;
            
            try {

                final DatosFolioHospitalAmbulancia objetoFolioHospitalAmbulancia = new DatosFolioHospitalAmbulancia();
                
                final MovilDatosAsegurado movilDatosAsegurado = new MovilDatosAsegurado();
                movilDatosAsegurado.setEdad(null);
                movilDatosAsegurado.setSexo(null);
                movilDatosAsegurado.setAseguradoNombre(term.getReporteSac().getGeneralNombreAsegurado());
                movilDatosAsegurado.setAseguradoCorreo(term.getReporteSac().getGeneralCorreoAsegurado());
                movilDatosAsegurado.setAseguradoTelefono(term.getReporteSac().getGeneralAseguradoTelefono());
                
                objetoFolioHospitalAmbulancia.setReporte(ap.getNumReporte());
                objetoFolioHospitalAmbulancia.setMovilDatosAsegurado(movilDatosAsegurado);
                objetoFolioHospitalAmbulancia.setEdadTercero(String.valueOf(les.getEdadLesionado()));
                objetoFolioHospitalAmbulancia.setNumeroTercero(serv.getAtencionA());
                
                objetoFolioHospitalAmbulancia.setSexoTercero(String.valueOf(les.getSexoLesionado()));
                
                objetoFolioHospitalAmbulancia.setLesionadoTercero(les);
                
                objetoFolioHospitalAmbulancia.setTelefonoTercero(null);
                objetoFolioHospitalAmbulancia.setCorreoTercero(serv.getCorreoTercero());
                objetoFolioHospitalAmbulancia.setAtencion(serv.getAtencionA());
                objetoFolioHospitalAmbulancia.setCobertura(serv.getCobertura()!=null?serv.getCobertura():"");
                objetoFolioHospitalAmbulancia.setMontoMedico(serv.getMontoMedico()!=null?serv.getMontoMedico():"");
                
                JSONObject json = new JSONObject();
                int consecutivo = 1;
                if(term.getReporteSac().getServiciosdiversos_consecutivos() != null){
                	 json = new JSONObject(term.getReporteSac().getServiciosdiversos_consecutivos());
                	 
                	try{
                		 consecutivo = json.getInt(objetoFolioHospitalAmbulancia.getAtencion());
                		 consecutivo += 1;
                		 json.put(objetoFolioHospitalAmbulancia.getAtencion(), consecutivo);
                	}catch(JSONException e){
                		
                		if(e.getMessage().contains("not found")){
                			json.put(objetoFolioHospitalAmbulancia.getAtencion(), 1);
                		}else{
                			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                					numReporte, this.fuenteWS + "solicitarServiciosDiversos",
                                    "Solicitud Servicios Diversos V3", "error al obtener consecutivos -> " + e.getMessage());
                		}
                	}
                }else{
                	json.put(objetoFolioHospitalAmbulancia.getAtencion(), 1);
                }
                
                objetoFolioHospitalAmbulancia.setTipoTercero("L" + consecutivo);
                objetoFolioHospitalAmbulancia.setIdObjeto(serv.getIdObjeto());
                
                //Informacon nueva
                objetoFolioHospitalAmbulancia.setFolioAMIS(serv.getFolioAMIS());
                objetoFolioHospitalAmbulancia.setNombreAjustadorTercero(serv.getNombreAjustadorTercero());
                objetoFolioHospitalAmbulancia.setPolizaTercero(serv.getPolizaTercero());
                objetoFolioHospitalAmbulancia.setIncisoPolizaTercero(serv.getIncisoPolizaTercero());

                data = json.toString();
                
                final String entradaSacPM = new JMXMLObjectFactory().obtenerString(objetoFolioHospitalAmbulancia, false);
                respuestaSac = null;
                if(StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Ambulancia") || StringUtils.equalsIgnoreCase(serv.getTipoDeServicioSolicitado(), "Hospital") ){
                	this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                			numReporte, this.fuenteWS + "solicitarServiciosDiversos",
                             "Solicitud Servicios Diversos V3", "Envio a SAC -> " + entradaSacPM);
                	
                	respuestaSac = this.SacSPDao.dispositivoMovilFolioHospitalAmbulancia(objetoFolioHospitalAmbulancia, serv.getClaveDeProveedor(), term, serv.getPersona());

                	tipoTercero = objetoFolioHospitalAmbulancia.getTipoTercero();
                }else{
                	 this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                			 numReporte, this.fuenteWS + "solicitarServiciosDiversos",
                             "Solicitud Servicios Diversos V3", "Envio a SAC -> " + entradaSac);
                	 
                	respuestaSac = this.SacSPDao.dispositivoMovilFolio(ap, term);
                	tipoTercero = ap.getAtencion();
                }

                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                		numReporte, this.fuenteWS + "solicitarServiciosDiversos",
                        "Solicitud Servicios Diversos V3", "Respuesta SAC -> " + respuestaSac);

            } catch (final Exception e) {

                try {
                    this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                    		numReporte, this.fuenteWS + "solicitarServiciosDiversos",
                            "Solicitud Servicios Diversos V3", "MUY MAL !!! BREAK CALL SP EXCEPCIONA!!! -> " + e.getMessage());
                } catch (final Exception ex) {
                    this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                            "solicitarServiciosDiversos => ejecutarFuncionHistoricoTerminalNuevo");
                }

                return new MovilResultadoOperacion(false, "ERROR: " + e.getMessage());
            }
            report.setFechaEnviadoSise(new Date());
            report.guardarObjeto();

            if ((respuestaSac != null) && !StringUtils.equalsIgnoreCase(respuestaSac.get("salida").toString(), "null")) {
            	if(respuestaSac.get("salida").toString().contains("OK")){
            		
					try {
						
						if(String.valueOf(respuestaSac.get("folio")).equals("null")){
							return new MovilResultadoOperacion(false, "ERROR: " + String.valueOf(respuestaSac.get("salida")));
						}
						this.reporteSacDao.ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos(term.getReporteSac().getId(), data);
					
					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "solicitarServiciosDiversos => actualizarconsecutivos");
					}
				String tipoAfectadoDS = null;
					try {
						
						Map<String, String> descAtividadFolio = new HashMap<>();
						descAtividadFolio.put("servicioSolicitado", serv.getTipoDeServicioSolicitado());
						descAtividadFolio.put("claveProveedor", serv.getClaveDeProveedor());
						descAtividadFolio.put("nombreProveedor", serv.getNombreDeProveedor() != null ? serv.getNombreDeProveedor() : "");
						if (StringUtils.equals(serv.getTipoDeServicioSolicitado(), "Hospital") || StringUtils.equals(serv.getTipoDeServicioSolicitado(), "Ambulancia")) {
							descAtividadFolio.put("tipoAfectado", ap.getAtencion());
							descAtividadFolio.put("nombreAfectado", serv.getLesionadoNombre());
							descAtividadFolio.put("lesionado", tipoTercero);
							descAtividadFolio.put("edad", serv.getLesionadoEdad());
							tipoAfectadoDS= ap.getAtencion(); 
						} else {
							descAtividadFolio.put("tipoAfectado", tipoTercero);
							tipoAfectadoDS = tipoTercero;
						}
		            	
		            	ObjectMapper mapper = new ObjectMapper();
		            	String descActividad = mapper.writeValueAsString(descAtividadFolio);
		            	
						this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(), 
								term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
								"Solicitar Folio", serv.getUsuario(), "Dispositivo Móvil", 
								descActividad, respuestaSac.get("folio").toString());
						
						
						//Guardar Datos de Supervisor 
						if (StringUtils.isNotBlank(serv.getNombreSupervisor()) ) {
							try {
								Map<String, String> descAtividadODR = new HashMap<>();
								descAtividadODR.put("servicioSolicitado", serv.getTipoDeServicioSolicitado());
								descAtividadODR.put("nombreProveedor", serv.getNombreDeProveedor() != null ? serv.getNombreDeProveedor() : "");
								descAtividadODR.put("tipoAfectado", tipoAfectadoDS );
								descAtividadODR.put("supervServicio", serv.getNombreSupervisor());
								descAtividadODR.put("telSupervServicio", serv.getTelefonoSupervisor());
								descAtividadODR.put("correoSupervisor", serv.getMailSupervisor());
				            	
				            	String descActividadDS = mapper.writeValueAsString(descAtividadODR);
				            	
					            this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(
								term.getNumeroproveedor(), term.getNombre(),  term.getReporteSac().getGeneralNumeroReporte(), "", "", "Servicio ODR Externo",
								term.getNumeroproveedor(), "Dispositivo Móvil", descActividadDS ,respuestaSac.get("folio").toString());
							} catch (Exception e) {
							}
						}
						
					}catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
            		return new MovilResultadoOperacion(true, "OK: " + String.valueOf(respuestaSac.get("folio")));
            	}
                	return new MovilResultadoOperacion(false, respuestaSac.get("salida").toString());
            
        	
            }
        }
        return new MovilResultadoOperacion(false, "Error, intente más tarde.");
    }

     @Override
    public String insertarEncuesta(final MovilServicioEncuesta serv) {
    	if (StringUtils.isBlank(serv.getUsuario())) {
    		return "ERROR: Es necesario especificar un usuario";
    	}
    	if (StringUtils.isBlank(serv.getPasswd())) {
    		return "ERROR: Es necesario especificar una contrasena";
    	}

    	if (StringUtils.isBlank(serv.getNumeroDeReporte())) {
    		return "ERROR: Es necesario especificar Numero de Reporte";
    	}

    	if (StringUtils.isBlank(serv.getNombreAsegurado())) {
    		return "ERROR: Es necesario especificar Nombre del Asegurado";
    	}

    	if (serv.getAtencionPersonalCabina()>=5||serv.getAtencionPersonalCabina()==0) {
    		return "ERROR: VAlOR INVALIDO en atencionPersonalCabina!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente";
    	}

    	if (serv.getLlegadaAjustador()>=5||serv.getLlegadaAjustador()==0) {
    		return "ERROR: VAlOR INVALIDO en llegadaAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente";
    	}

    	if (serv.getPresentacionAjustador()>=5||serv.getPresentacionAjustador()==0) {
    		return "ERROR: VAlOR INVALIDO en presentacionAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente";
    	}

    	if (serv.getTratoAjustador()>=5 ) {
    		return "ERROR: VAlOR INVALIDO en tratoAjustador!.VALORES VALIDOS 0=noAplica, 1=mal,2=regular,3=bien,4=excelente";
    	}
    	if (serv.getCapacidadAjustador()>=5||serv.getCapacidadAjustador()==0) {
    		return "ERROR: VAlOR INVALIDO en capacidadAjustador!.VALORES VALIDOS 1=mal,2=regular,3=bien,4=excelente";
    	}
    	if (serv.getTratoAjustadorTercero()>=5) {
    		return "ERROR: VAlOR INVALIDO en tratoAjustadorTercero!.VALORES VALIDOS 0=noAplica, 1=mal,2=regular,3=bien,4=excelente";
    	}
    	if (serv.getServicioDeGrua()>=5) {
    		return "ERROR: VAlOR INVALIDO en servicioDeGrua!.VALORES VALIDOS 0=noAplica,1=mal,2=regular,3=bien,4=excelente";
    	}

    	if (serv.getObservoIrregularidadServicio()==null) {
    		return "ERROR: VAlOR INVALIDO en ObservoIrregularidadServicio!.VALORES VALIDOS true o false";
    	}
     	if (serv.getSeleccionDeTaller()==null) {
    		return "ERROR: VAlOR INVALIDO en SeleccionDeTaller!.VALORES VALIDOS 0=noAplica, 1=Si, 2=No";
    	}
    	if (serv.getRecibioCopiaDA()==null) {
    		return "ERROR: VAlOR INVALIDO en RecibioCopiaDA!.VALORES VALIDOS true o false";
    	}



    	Terminal term = null;
    	try {
    		term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
    	} catch (final Exception ex) {
    		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
    				"ajustadoresInsertarEncuesta => objetoTerminalParaProveedorYPasswd");
    	}

    	if (term == null) {

    		return "ERROR: El usuario y contrasena indicados no son validos.";
    	}
    	String numReporte = null;
    	if (term.getReporteSac() != null && term.getReporteSac().getGeneralNumeroReporte() != null) {
			numReporte = term.getReporteSac().getGeneralNumeroReporte();
		}
    	// Se graba lo que llega
    	try {
    		this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
    				this.fuenteWS + "insertarEncuesta", "Encuesta Movil V3", "Ejecucion del Metodo Con Datos -> "
    						+ this.xmlFactory.obtenerString(serv));
    	} catch (final Exception ex) {
    		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
    				"insertarEncuesta => ejecutarFuncionHistoricoTerminalNuevo");
    	}

    	String respuesta=null;
    	String poliza;
    	try {
    		if(term.getReporteSise() == null){
    			poliza = term.getReporteSac().getGeneralNumeroPoliza();
    		}else{
    			poliza = term.getReporteSise().getGeneralNumeroPoliza();
    		}
    		respuesta=this.encuestaDao.ejecutarFuncioninsertarEncuestaAjustador(serv.getUsuario(), serv.getPasswd(), 
    				serv.getNumeroDeReporte(), serv.getNombreAsegurado(), serv.getAtencionPersonalCabina(), serv.getLlegadaAjustador(), 
    				serv.getPresentacionAjustador(), serv.getTratoAjustador(), serv.getCapacidadAjustador(), serv.getTratoAjustadorTercero(), 
    				serv.getServicioDeGrua(),serv.getSeleccionDeTaller(), serv.getObservoIrregularidadServicio(), serv.getRecibioCopiaDA(),
    				serv.getObservaciones(),serv.getNombreConductor(),serv.getTelefonoConductor(),serv.getCorreoConductor(),term.getEstado().getId(),
    				term.getBase().getId(),poliza);		

    	} catch (final Exception ex) {
    		return "ERROR: " + "No se pudieron guardar lo Datos. Vuelva a intentarlo por favor.";

    	}

    	if(respuesta!=null){
    		if (respuesta.contains("OK")) {
    		EncuestaCorreo encuesta = new EncuestaCorreo();
    		// Envio de correo al coordinador del ajustador
    		/*** Llegada ajustador ***/
    		if (serv.getLlegadaAjustador() == 1) {
				encuesta.setCalifLlegadaAjus("Mala");
			}
    		if (serv.getLlegadaAjustador() == 2) {
    			encuesta.setCalifLlegadaAjus("Regular");
			}
    		/*** Presentacion Ajustador ***/
    		if (serv.getPresentacionAjustador() == 1) {
				encuesta.setCalifPresentacionAjus("Mala");
			}
    		if (serv.getPresentacionAjustador() == 2) {
				encuesta.setCalifPresentacionAjus("Regular");
			}
    		/*** Trato del Ajustador ***/
    		if (serv.getTratoAjustador() == 1) {
				encuesta.setCalifTratoAjus("Malo");
			}
    		if (serv.getTratoAjustador() == 2) {
				encuesta.setCalifTratoAjus("Regular");
			}
    		/*** Capacidad del ajustador ***/
    		if (serv.getCapacidadAjustador() == 1) {
				encuesta.setCalifCapacidadAjus("Mala");
			}
    		if (serv.getCapacidadAjustador() == 2) {
				encuesta.setCalifCapacidadAjus("Regular");
			}
    		/*** Trato ajustador Tercero ***/
    		if (serv.getTratoAjustadorTercero() == 1) {
				encuesta.setCalifTratoAjusTercero("Mala");
			}
    		if (serv.getTratoAjustadorTercero() == 2) {
				encuesta.setCalifTratoAjusTercero("Regular");
			}
    		/*** Observo irregularidades ***/
    		if (serv.getObservoIrregularidadServicio()) {
				encuesta.setObservoIrregularidad("SI");
			}
    		try {
    		if ( (StringUtils.isNotBlank(encuesta.getCalifCapacidadAjus())) || (StringUtils.isNotBlank(encuesta.getCalifLlegadaAjus()))
    			|| (StringUtils.isNotBlank(encuesta.getCalifPresentacionAjus())) || (StringUtils.isNotBlank(encuesta.getCalifTratoAjus()))
    			|| (StringUtils.isNotBlank(encuesta.getCalifTratoAjusTercero())) || (StringUtils.isNotBlank(encuesta.getObservoIrregularidad())) ) {
	    			try {
	        			usuarioFrecuenciaService.envioDeCorreoEncuesta(term, encuesta, serv.getNumeroDeReporte(),4);
	        		} catch (Exception e) {
	        			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
	        					"insertarEncuesta => usuarioFrecuenciaService envio de Correo");
	    			}	
				} 
    		} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			}
    		
    		// Se graba la respuesta
    		try {
    			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
    					this.fuenteWS + "insertarEncuesta", "Encuesta Movil V3", "Respuesta de Encuesta -> " + respuesta);

    		} catch (final Exception ex) {
    			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
    					"insertarEncuesta => ejecutarFuncionHistoricoTerminalNuevo");
    			}
    		}
    		return respuesta;
    	}
    	return respuesta;	
    }
    
    @SuppressWarnings("unused")
	private void getListasMovilReporte(MovilReporte reporte, ReporteMovilSac reporteSac) {
		if (reporte.getReporte() != null) {
			
			// Insercion de Talleres
			if (StringUtils.isNotBlank(reporteSac.getGeneralNumeroReporte())) {
				List<ReporteMovilSacTalleres> lista = null;
				try {
					lista = reporteMovilSacTalleresService.listaDeReporteMovilSacTalleres(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("listaDeReporteMovilSacTalleres", ex);
				}
				if ((lista != null) && (lista.size() > 0)) {
					
					for (final ReporteMovilSacTalleres rmstaller : lista) {	
						reporte.getReporte().getTalleres().add(
								new MovilReporteSiseTaller(
										rmstaller.getIdTalleres(), 
										rmstaller.getCodigo(),
										rmstaller.getNombre(), 
										rmstaller.getTipo(), 
										rmstaller.getTipoAfectado(), 
										rmstaller.getIndiceTercero(), 
										rmstaller.getVale(),
										rmstaller.getIdTalleres()));
					}
				}
			}
			
			// Insercion de Terceros
			if (StringUtils.isNotBlank(reporteSac.getGeneralNumeroReporte())) {
				List<ReporteMovilSacTerceros> lista = null;
				try {
					lista = reporteSacTercerosDao.listaDeReporteMovilSacTerceros(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("listaDeReporteMovilSacTerceros", ex);
				}
				if ((lista != null) && (lista.size() > 0)) {
					Boolean containIDZero = false;
					
					for (final ReporteMovilSacTerceros rmst : lista) {	
						reporte.getReporte().getTerceros().add(new MovilReporteSiseTercero(
								rmst.getIdTercero(),
								rmst.getVehiculoMarca(),
								rmst.getVehiculoTipo(),
								rmst.getVehiculoAnoModelo(),
								rmst.getVehiculoPlacas(),
								rmst.getVehiculoSerie(),
								rmst.getVehiculoColor(),
								rmst.getVehiculoConductor(),
								rmst.getTelefonoContacto(),
								null, null, null));
						
						try{
							if(rmst.getIdTercero().trim().replace("[{^0-9]", "").equals("0")){
								containIDZero = true;
							}
						}catch(Exception ex){
							JMEntidad.getLogger().error("ObtenerListaTalleres", ex);
						}
					}
					
					if(!containIDZero){
						reporte.getReporte().getTerceros().add(new MovilReporteSiseTercero(
								"0",
								reporteSac.getVehiculoMarca(),
								reporteSac.getVehiculoTipo(),
								reporteSac.getVehiculoModelo(),
								reporteSac.getVehiculoPlacas(),
								reporteSac.getVehiculoSerie(),
								reporteSac.getVehiculoColor(),
								reporteSac.getConductorNombre(),
								reporteSac.getConductorTelefonoContacto(),
								null, null, null));
					}
				}
				else {
					JMEntidad.getLogger().error("listaDeReporteMovilSacTerceros ERROR SIN TERCEROS: "+lista);
				}
			}
			
			// Insercion de Gruas
			if (StringUtils.isNotBlank(reporteSac.getGeneralNumeroReporte())) {
				List<ReporteMovilSacGruas> lista = null;
				try {
					lista = reporteMovilSacGruasService.listaDeReporteMovilSacGruas(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("listaDeReporteMovilSacGruas", ex);
				}
				if ((lista != null) && (lista.size() > 0)) {
					for (final ReporteMovilSacGruas rmsg : lista) {	
						reporte.getReporte().getGruas().add(new MovilReporteSiseGrua(rmsg.getClave(), rmsg.getEstatus(), 
								rmsg.getProveedorClave(), rmsg.getProveedorNombre(), rmsg.getFechaEstimada(), rmsg.getHoraEstimada(),
								rmsg.getTipoAfectado()));
					}
				}
			}
		}
    }
    
    @SuppressWarnings("unused")
	private void getListasReporteMovilSise(MovilReporte reporte, ReporteSise reporteSise) {
		if (reporte.getReporte() != null) {

			// Insercoin de Terceros
			if (StringUtils.isNotBlank(reporteSise.getTerceros())) {
				try {
					@SuppressWarnings("unchecked")
					final ArrayList<Terceros> terceros = (ArrayList<Terceros>) new XStream().fromXML(reporteSise.getTerceros());
					if ((terceros != null) && (terceros.size() > 0)) {
						for (final Terceros tts : terceros) {
							if ((tts != null) && (tts.getTercero() != null) && (tts.getTercero().size() > 0)) {
								for (final Tercero tercero : tts
										.getTercero()) {
									reporte.getReporte().getTerceros().add(
											new MovilReporteSiseTercero(tercero.getIDTercero(), tercero
													.getTerMarca(), tercero.getTerTipo(),
													tercero.getTerAnoModelo(), tercero.getTerPlaca(), tercero
															.getTerSerie(), tercero.getTerColor(), tercero
															.getTerConductor(), tercero.getTerTelContacto(),
													tercero.getTerCiaAseg(), tercero.getTerNumPol(), tercero
															.getTerGXG()));
								}
							}

						}

					}
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("ObtenerListaTerceros", ex);
				}
			}

			// Insercion de Talleres
			if (StringUtils.isNotBlank(reporteSise.getTalleres())) {
				try {
					@SuppressWarnings("unchecked")
					final ArrayList<Talleres> talleres = (ArrayList<Talleres>) new XStream().fromXML(reporteSise.getTalleres());

					if ((talleres != null) && (talleres.size() > 0)) {
						for (final Talleres tlls : talleres) {
							if ((tlls != null) && (tlls.getTaller() != null) && (tlls.getTaller().size() > 0)) {
								for (final Taller taller : tlls.getTaller()) {
									reporte.getReporte().getTalleres().add(
											new MovilReporteSiseTaller(taller.getIDTaller(), taller.getTallerCod(),
													taller.getTallerNombre(), taller.getTallerTipo(), taller
															.getTallerTipoAfectado(), taller
															.getTallerIndiceTercero(), taller.getTallerVale(),
													taller.getTallerNotas()));
								}

							}
						}
					}
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("ObtenerListaTalleres", ex);
				}
			}

		}
    }


    public ConfiguracionServiceInterfase getConfiguracionDao() {
    	return this.configuracionDao;
    }
    
    public Map<String,String> claveAbo(String numeroProveedorA){
    	Map<String, String> resultado = new HashMap<String, String>();
    	String claveA = "";
    	String nombreA = "";
    	int indiceAux = numeroProveedorA.indexOf("*");
    	String[] resultadoClave = numeroProveedorA.split(" ");
    	  
        if(indiceAux != -1) {
        	 resultadoClave = numeroProveedorA.split(":");
        	 String[] resultadoAux = resultadoClave[1].trim().split(" ");
        	 claveA = resultadoAux[0].trim();
        	 String nombreAux = "";
        	 for(int i=1; i<resultadoAux.length; i++) {
        		nombreAux = nombreAux + " " + resultadoAux[i];
        	 }
        	 int indice = nombreAux.indexOf("*"); 
        	 nombreA = nombreAux.substring(0,indice);
         } else {
        	 claveA = resultadoClave[0].trim();
        	 String nombreAux = "";
        	 for(int i=1; i<resultadoClave.length; i++) {
         		nombreAux = nombreAux + " " + resultadoClave[i];
         	 }
        	 nombreA = nombreAux;
         }
         
        resultado.put("claveA", claveA);
        resultado.put("nombreA", nombreA);
        
        return resultado;
    } 
    

	@Override
	public MovilResultadoOperacion guardarCobroBancario(MovilCobroBancario serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar las credenciales");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
        }
        if (StringUtils.isBlank(serv.getPwd())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contraseña");
        }

        if (StringUtils.isBlank(serv.getReporte())) {
            return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un numero de reporte");
        }
        
        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPwd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "guardarCobroBancario => objetoTerminalParaProveedorYPasswd");

        }
        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El usuario y contrasena indicados no son validos.");
        }


        if (StringUtils.isBlank(serv.getTipoCobro())) {
        	 try {
                 this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                         null,
                         term,
                         serv.getReporte(),
                         this.fuenteWS + "guardarCobroBancario",
                         "Guardar Cobro Movil V3",
                         "Usuario --> " + serv.getUsuario() + ", pass --> " + serv.getPwd() + ", reporte --> " + serv.getReporte()
                                 + " ERROR:  Es necesario especificar un tipo de cobro. Pago de Prima, Pago de Deducible o Pago de Poliza (P.P. P.D. P.R) ");
             } catch (final Exception ex) {
                 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                         "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
             }
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar un tipo de cobro. Pago de Prima, Pago de Deducible o Pago de Poliza (P.P. P.D. P.R)");
        }
        if (StringUtils.isBlank(serv.getResponse())) {
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ", reporte --> " + serv.getReporte()
                             + " ERROR: Es necesario espeficicar el campo response del cobro ");
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar el campo response del cobro ");
        }
        
        if (StringUtils.isBlank(serv.getMonto())) {
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ", reporte --> " + serv.getReporte()
                             + " ERROR:  Es necesario especificar el monto a cobrar. ");
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }
            return new MovilResultadoOperacion(false,
                    "ERROR: Es necesario especificar el monto a cobrar.");
        }
        

        if (!StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.P.")
                && !StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.D.")
                && !StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.R.")) {
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ", reporte --> " + serv.getReporte()
                             + " ERROR:  El tipo de cobro no es correcto. Los valores permitidos son  P.P. , P.D. , P.R");
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }
            return new MovilResultadoOperacion(false,
                    "ERROR: El tipo de cobro no es correcto. Los valores permitidos son 'P.P.', 'P.D.', 'P.R.'");
        }

        if (StringUtils.length(serv.getTelefono()) != 10) {
        	
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ", reporte --> " + serv.getReporte()
                             + " ERROR: El numero de telefono celular debe ser en formato de 10 digitos numericos sin 044");
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }
            return new MovilResultadoOperacion(false,
                    "ERROR: El numero de telefono celular debe ser en formato de 10 digitos numericos sin 044.");
        }
        
        if( !StringUtils.equalsIgnoreCase(serv.getResponse(), "approved")
                && !StringUtils.equalsIgnoreCase(serv.getResponse(), "denied")
                && !StringUtils.equalsIgnoreCase(serv.getResponse(), "error")) {
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ", reporte --> " + serv.getReporte()
                             + "ERROR: El tipo de respuesta no es correcto. Los valores pueden ser approved, denied, error");
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }
        	
            return new MovilResultadoOperacion(false,
                    "ERROR: El tipo de  respuesta no es correcto. Los valores pueden ser approved, denied, error");
        }
        
       
        UtileriaCadenas utilerias = new UtileriaCadenas();
        if ((StringUtils.length(serv.getCorreoElectronico()) > 0)) {
			boolean validador = utilerias.validarUnSoloCorreo(serv.getCorreoElectronico());
			if (!validador) {
				try {
		             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
		                     null,
		                     term,
		                     serv.getReporte(),
		                     this.fuenteWS + "guardarCobroBancario",
		                     "Guardar Cobro Movil V3",
		                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ",reporte --> " + serv.getReporte()
		                             + " ERROR: El campo correo electronico "+serv.getCorreoElectronico()+" es incorrecto, ingresar solo un correo.");
		         } catch (final Exception ex) {
		             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
		         }
		        	return new MovilResultadoOperacion(false,
		                    "ERROR: El campo correo electronico es incorrecto, ingresar solo un correo.");
			}
		}

        if ((StringUtils.length(serv.getCorreoElectronico()) > 0) && !EmailValidator.getInstance().isValid(serv.getCorreoElectronico())) {
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ",reporte --> " + serv.getReporte()
                             + " ERROR: El campo correo electronico es incorrecto."+serv.getCorreoElectronico());
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }
        	
        	return new MovilResultadoOperacion(false,
                    "ERROR: El campo correo electronico es incorrecto.");
		}
       

        try {
            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                    null,
                    term,
                    serv.getReporte(),
                    this.fuenteWS + "guardarCobroBancario",
                    "Guardar Cobro Movil V3",
                    "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ",rep --> " + serv.getReporte()
                            + ", tipo-->" + serv.getTipoCobro() +  ", cobertura afectada --> "
                            + serv.getCoberturaAfectada()+", correo Electronico --> "+serv.getCorreoElectronico()+", monto --> "+serv.getMonto()
                            +", response --> "+serv.getResponse());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
        }

        try {
            
        	final Transaccion transaccion = JMUtileriaBancaria.guardarCobro(term,serv.getCoberturaAfectada(), serv.getCorreoElectronico(),
        			 serv.getMonto(), serv.getReporte(), serv.getTelefono(), serv.getTipoCobro(),  serv.getResponse(),serv.getAuth(),
        			 serv.getFolioCPagos(), serv.getCdError(),serv.getDescripcion(), serv.getCdResponse(),  
        			 serv.getDatosBanco(), serv.getTipoOperacion(),
        			 serv.getDireccion(), serv.getFecha() );
	        	if(transaccion != null) {
	           	 try {
	                 this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
	                         null,
	                         term,
	                         serv.getReporte(),
	                         this.fuenteWS + "guardarCobroBancario",
	                         "Guardar Cobro Movil V3",
	                         "Salida del servicio : Se guardaron exitosamente los datos.");
	             } catch (final Exception ex) {
	                 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                         "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
	             }
	        	return new MovilResultadoOperacion(true,"Se guardaron exitosamente los datos.");
	        	}

        } catch (final Exception e) {
            try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
                        serv.getReporte(), this.fuenteWS + "guardarCobroBancario", "Guardar Cobro Movil V3",
                        "MUY MAL!!! EXCEPCION ->" + e.getMessage());
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
            }
            
       	 try {
             this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                     null,
                     term,
                     serv.getReporte(),
                     this.fuenteWS + "guardarCobroBancario",
                     "Guardar Cobro Movil V3",
                     "Usuario --> " + serv.getUsuario() + ",pass --> " + serv.getPwd() + ",reporte --> " + serv.getReporte()
                             + " ERROR al guardar el cobro. Detalles: "+e.getMessage());
         } catch (final Exception ex) {
             this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "guardarCobroBancario => ejecutarFuncionHistoricoTerminalNuevo");
         }

            return new MovilResultadoOperacion(false, "Error al guardar  el cobro. Detalles: " + e.getMessage());
        }

        return new MovilResultadoOperacion(false, "ERROR.");
	} 
  
	@Override
    public MovilResultadoOperacion insertarReconocimiento( MovilServicioReconocimiento serv ) {
  	
		if ( serv == null) {
           return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar las credenciales");
       }
       if (StringUtils.isBlank(serv.getUsuario())) {
           return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un usuario");
       }
       if (StringUtils.isBlank(serv.getPwd())) {
           return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar una contrasena");
       }
       if (StringUtils.isBlank(serv.getReporte())) {
           return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un el reporte");
       }
       if (StringUtils.isBlank(serv.getNombre())) {
           return new MovilResultadoOperacion(false, "ERROR: Es necesario especificar un nombre");
       }
 	  Terminal term = null;
  	  JMResultadoOperacion salida = null;
  	  
       try {
           term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPwd());
       } catch (final Exception ex) {
           this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                   "insertarReconocimiento => objetoTerminalParaProveedorYPasswd");
       }

       if (term == null) {
           return new MovilResultadoOperacion(false, "ERROR: Usuario o contrasena invalidos");
       }
       
       try {
       this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
               null,
               term,
               serv.getReporte(),
               this.fuenteWS + "identificacionMovil",
               "insertarReconocimiento Movil V3",
               "Entrada al metodo " + this.xmlFactory.obtenerString(serv));	
       }catch (Exception e) {
    	   try {
               this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
                       this.fuenteWS + "insertarReconocimiento", "Identificacion Movil V3", "Error ejecutarFuncionHistoricoTerminalNuevo  -> "
                               + e.getMessage());
           } catch (final Exception ex) {
               this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                       "insertarReconocimiento => ejecutarFuncionHistoricoTerminalNuevo");
           }
	}
       
       try {
    	   
    	   //Conexion a SISE
    	   ReconocimientoSISE entradasSise = new ReconocimientoSISE();
    	   		entradasSise.setReporte(serv.getReporte());
    	   		entradasSise.setNombre(serv.getNombre());
    	   		entradasSise.setApellidoPat(serv.getApellidoPaterno());
    	   		entradasSise.setApellidoMat(serv.getApellidoMaterno());
    	   		entradasSise.setCurp(serv.getCurp());
    	   		entradasSise.setTipo(serv.getTipo());
    	   		
    	   	 this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
	                    null,
	                    term,
	                    serv.getReporte(),
	                    this.fuenteWS + "insertarReconocimiento",
	                    "Identificacion Movil V3",
	                    "Envio a SISE " + this.xmlFactory.obtenerString(entradasSise));	
    	   		
    	    String salidaSise = siseSR_Service.reconocimientoSise(entradasSise);
    	    
    	    this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
                    null,
                    term,
                    serv.getReporte(),
                    this.fuenteWS + "insertarReconocimiento",
                    "identificacion Movil V3",
                    "Salida de SISE ==> " + salidaSise);	
    	    
       if (salidaSise.contains("ERROR")) {
    	   return new MovilResultadoOperacion(false, salidaSise);
       } else {
       try {
    	   		InfoReconocimiento info  = new InfoReconocimiento();
    	   			info.setNombre(serv.getNombre());
					info.setApellidoPaterno(serv.getApellidoPaterno());
					info.setApellidoMaterno(serv.getApellidoMaterno());
					info.setCurp(serv.getCurp());
					info.setReporte(serv.getReporte());
					info.setFecha(new Date());
//					info.setTipoAfectado(serv.getTipoAfectado());
					
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
		                    null,
		                    term,
		                    serv.getReporte(),
		                    this.fuenteWS + "insertarReconocimiento",
		                    "Identificacion Movil V3",
		                    "Envio a BD: " + this.xmlFactory.obtenerString(info));	
				
			  salida = info.guardarObjeto();
			  
		       if ( salida == null) {
		    	   
		    	   this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
		                    null,
		                    term,
		                    serv.getReporte(),
		                    this.fuenteWS + "insertarReconocimiento",
		                    "Identificacion Movil V3",
		                    "Salida de  DB: " + salida);
		           return new MovilResultadoOperacion(false, "ERROR: Al guardar en Base");
		       } else {
		    	   this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(
		                    null,
		                    term,
		                    serv.getReporte(),
		                    this.fuenteWS + "insertarReconocimiento",
		                    "Identificacion Movil V3",
		                    "Salida de  DB: " + salida.getMensaje());
		       }

		       if (salida.isExito()) {
		           return new MovilResultadoOperacion(true, "Guardado en SISE, "+salida.getMensaje());
		       }
		       
			} catch (Exception e) {
				try {
	                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
	                        this.fuenteWS + "identificacionMovil", "Identificacion Movil V3", "Error al guardar en BD  -> "
	                                + e.getMessage());
	            } catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "insertarReconocimiento => ejecutarFuncionHistoricoTerminalNuevo");
	            }
	            return new MovilResultadoOperacion(false, "ERROR: Excepcion en GuardarEnBase " + e.getMessage());
			}
       }
       
       } catch (Exception e) {
			try {
                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
                        this.fuenteWS + "insertarReconocimiento", "Identificacion Movil V3", "Error e  -> "
                                + e.getMessage());
            } catch (final Exception ex) {
                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "insertarReconocimiento => ejecutarFuncionHistoricoTerminalNuevo");
            }
            return new MovilResultadoOperacion(false, "ERROR: Excepcion en SISE " + e.getMessage());
		}

       return new MovilResultadoOperacion(false, "ERROR: " + salida.getMensaje());

   }
    
	@Override
    public MovilDatosGrua solicitarDatosDeGrua(final MovilInicioDeSesion serv) {
       
		if (serv == null) {
            return new MovilDatosGrua("ERROR: Es necesario especificar las credenciales", null);
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilDatosGrua("ERROR: Es necesario especificar un usuario", null);
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilDatosGrua("ERROR: Es necesario especificar una contrasena", null);
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarDatosDeReporte => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilDatosGrua("ERROR: Usuario o contrasena invalidos", null);
        }

        try {
            this.sessionExternaDao.informacionDeSessionExterna(term, "Consulta simple de su reporte");
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "solicitarDatosDeReporte => informacionDeSessionExterna");
        }
        
		// ***REPORTE SAC***
        if (term.getReporteSac() != null) {

			try {
								
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term
						.getReporteSac().toString(), this.fuenteWS + "solicitarDatosDeGrua",
	                  "Solicitar  Datos de Grua Movil V3",
	            "Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(serv));
				
				try{
					final ReporteMovilSac repSacOut = this.reporteSacDao.objetoReporteMovilSac(
							term.getReporteSac().toString(), term.getNumeroproveedor());
					
					return new MovilDatosGrua("OK", repSacOut); 
				}catch (final Exception ex) {
	                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "solicitarDatosDeGrua => ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs");
	                return new MovilDatosGrua("ERROR: " + ex.getMessage(),  null);

	            }
						
			} catch (Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"solicitarDatosDeGrua => objetoReporteMovilSac");
				return new MovilDatosGrua("ERROR: " + ex.getMessage(),  null);
			}

		}

        return null;
    }

	@Override
	public MovilResumenAjustador resumenAjustador(String reporte) {
		// Validad a 11 digitos el numero de reporte.	
		if (StringUtils.isBlank(reporte)) {
			return new MovilResumenAjustador(false, "El número de reporte es obligatorio.", null);
		}
		if (reporte.length() != 11) {
			return new MovilResumenAjustador(false, "El número de reporte debe ser de 11 dígitos.", null);
		}
		
		ResumenAjustadorInfo data = new ResumenAjustadorInfo();
		try {
			data = historicoResumenAjustadorDao.consultarResumenAjustador(reporte);
			if (data != null) {
				return new MovilResumenAjustador(true, "Datos del reporte: "+reporte, data);
			} else {
				return new MovilResumenAjustador(false, "No se encontraron datos del reporte ingresado.", null);

			}
		} catch (Exception e) {
			return new MovilResumenAjustador(false, "Ocurrio un error. "+e.getMessage(), null);
		}

	}
	

	@Override
    public MovilResultadoOperacion insertarArriboAct(final MovilServicioArribo serv) {
        if (serv == null) {
            return new MovilResultadoOperacion(false, "ERROR: El objeto arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getUsuario())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getPasswd())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'passwd' de arribo es nulo");
        }
        if (StringUtils.isBlank(serv.getFechaHora())) {
            return new MovilResultadoOperacion(false, "ERROR: El campo 'fechaHora' de arribo es nulo");
        }
        if (StringUtils.isNotBlank(serv.getQuienLlegoPrimero())) {
            if (!StringUtils.equalsIgnoreCase(serv.getQuienLlegoPrimero(), "C")
                    && !StringUtils.equalsIgnoreCase(serv.getQuienLlegoPrimero(), "Q")) {
                return new MovilResultadoOperacion(false,
                        "ERROR: Los valores validos para QuienLlegoPrimero son 'C' y 'Q'. Se recibio: '"
                                + serv.getQuienLlegoPrimero() + "'");
            }
        }
        if (StringUtils.isBlank(serv.getUbicacionCorrecta())) {
        	  return new MovilResultadoOperacion(false, "ERROR: El campo 'ubicacionCorrecta' de arribo es nulo");
		}
        if (StringUtils.isNotBlank(serv.getUbicacionCorrecta())) {
            if (!StringUtils.equalsIgnoreCase(serv.getUbicacionCorrecta(), "SI")
                    && !StringUtils.equalsIgnoreCase(serv.getUbicacionCorrecta(), "NO")) {
                return new MovilResultadoOperacion(false,
                        "ERROR: Los valores validos para ubicacionCorrecta son 'SI' y 'NO'. Se recibio: '"
                                + serv.getUbicacionCorrecta() + "'");
            }
        }

        Terminal term = null;
        try {
            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
        } catch (final Exception ex) {
            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                    "insertarArriboCercania => objetoTerminalParaProveedorYPasswd");
        }

        if (term == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
        }
      //***  SAC
        if (term.getReporteSac() != null) {
        	
			// Se graba lo que llega
			try {
				this.historicoTerminalServiceInterfase
						.ejecutarFuncionHistoricoTerminalNuevo(null, term,
								term.getReporteSac().getGeneralNumeroReporte(), this.fuenteWS + "insertarArriboCercania",
								"Arribo Movil Por Cercania V3",
								"Ejecucion del Metodo Con Datos -> "
										+ this.xmlFactory.obtenerString(serv));
			} catch (final Exception ex) {
				this.utileriaExcepcion
						.manejarExcepcion(ex, this.getClass(),
								"insertarArriboCercania => ejecutarFuncionHistoricoTerminalNuevo");
			}

//			Validar si no tiene arribo por cercania, solicitar Placas y Serie
			if (StringUtils.isBlank(term.getReporteSac().getAjusteFechaArriboAjustador())) {
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
			}
			
			
			 final DatosArriboSac datosParaSac = new DatosArriboSac();
			 if (StringUtils.isNotBlank(term.getReporteSac().getAjusteFechaArriboAjustador())) {
				 datosParaSac.setFechaArribo(term.getReporteSac().getAjusteFechaArriboAjustador());
			} else {
				 datosParaSac.setFechaArribo(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
			}
			 
			 if (StringUtils.isNotBlank(term.getReporteSac().getAjusteHoraArriboAjustador())) {
				 datosParaSac.setHoraArribo(term.getReporteSac().getAjusteHoraArriboAjustador());
			} else {
				datosParaSac.setHoraArribo(DateFormatUtils.format(new Date(), "HH:mm:ss"));
			}
			 
			 
			 if (StringUtils.isNotBlank(term.getReporteSac().getVehiculoPlacas())) {
				 if (term.getReporteSac().getVehiculoPlacas().length() > 3) {
					 datosParaSac.setPlacas(term.getReporteSac().getVehiculoPlacas().substring(term.getReporteSac().getVehiculoPlacas().length() - 3));
				} else if (StringUtils.isNotBlank(term.getReporteSac().getVehiculoSerie())) {
					if (term.getReporteSac().getVehiculoSerie().length() > 3) {
						datosParaSac.setSerie(term.getReporteSac().getVehiculoSerie().substring(term.getReporteSac().getVehiculoSerie().length() - 3));
					}
				}
			} else if (StringUtils.isNotBlank(term.getReporteSac().getVehiculoSerie())) {
				if (term.getReporteSac().getVehiculoSerie().length() > 3) {
					datosParaSac.setSerie(term.getReporteSac().getVehiculoSerie().substring(term.getReporteSac().getVehiculoSerie().length() - 3));
				}
			}
			 
			 datosParaSac.setReporte(term.getReporteSac().toString());
			 datosParaSac.setUsuario(term.getNumeroproveedor());
			 datosParaSac.setQuienLlegoPrimero(serv.getQuienLlegoPrimero());
			 datosParaSac.setTramoCarretero(serv.getTramoCarretero());
			 datosParaSac.setLatitud(term.getLongitud());
			 datosParaSac.setLongitud(term.getLatitud());
			 datosParaSac.setDistanciaAlArribo(serv.getDistanciaAlArribo());
			 datosParaSac.setProximidad(2); //2 Para arribo por cercania
			 
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
		            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, 
		            		term.getReporteSac().getGeneralNumeroReporte(),
		                    this.fuenteWS + "insertarArriboCercania", "Arribo Movil Por Cercania V3",
		                    "Envio a SAC -> " + this.xmlFactory.obtenerString(datosParaSac));
		        } catch (final Exception ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "insertarArriboCercania => ejecutarFuncionHistoricoTerminalNuevo");
		        }

		        try {
		            respuestaSac = this.SacSPDao.arriboSac(datosParaSac);
		        } catch (final Exception e) {

		            // Se graba la excepcion
		            try {
		                this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, 
		                		term.getReporteSac().getGeneralNumeroReporte(),
		                        this.fuenteWS + "insertarArriboCercania", "Arribo Movil Por Cercania V3",
		                        "MUY MAL !!! SAC EXCEPCIONA!!! -> " + e.getMessage());
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarArriboCercania => ejecutarFuncionHistoricoTerminalNuevo");
		            }

		            return new MovilResultadoOperacion(false, "ERROR: SAC Excepciona con mensaje: " + e.getMessage());
		        }

		        // Se graba la respuesta
		        try {
		            this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, term.getReporteSac().getGeneralNumeroReporte(),
		                    this.fuenteWS + "insertarArriboCercania", "Arribo Movil Por Cercania V3", "Respuesta de SAC -> " + respuestaSac);
		        } catch (final Exception ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "insertarArriboCercania => ejecutarFuncionHistoricoTerminalNuevo");
		        }

		        if (respuestaSac == null) {
		            return new MovilResultadoOperacion(false, "ERROR: La respuesta de SAC es nula");
		        }
		        
		        if ( StringUtils.containsIgnoreCase(respuestaSac, "OK")) {
		        	
		        	try {
	            		this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(term.getNumeroproveedor(), term.getNombre(), term.getReporteSac().getGeneralNumeroReporte(), 
	                			term.getReporteSac().getGeneralNumeroPoliza(), term.getReporteSac().getGeneralInciso(), 
	                			"Insertar Arribo", serv.getUsuario(), "Dispositivo Móvil", "Insertar Arribo", respuestaSac);
	            	}catch (Exception ex) {
	            		this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                            "insertarArriboCercania => ejecutarFuncionHistoricoResumenAjustadorNuevo");
					}
		        	
					try {
						if (term.getReporteSac() != null) {
							if( StringUtils.isBlank(term.getReporteSac().getAjusteFechaArriboAjustador() ) ) {
								term.getReporteSac().setAjusteFechaArriboAjustador(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
							}
							
							if(StringUtils.isBlank(term.getReporteSac().getAjusteHoraArriboAjustador()) ){
								term.getReporteSac().setAjusteHoraArriboAjustador(DateFormatUtils.format(new Date(), "HH:mm:ss"));
							}

							term.getReporteSac().setQuienLlegoPrimero(serv.getQuienLlegoPrimero());
							term.getReporteSac().setTramoCarretero(serv.getTramoCarretero());
							term.getReporteSac().setCoordLatitudArribo(term.getLatitud());
							term.getReporteSac().setCoordLongitudArribo(term.getLongitud());
							term.getReporteSac().setDistanciaAlArribo(serv.getDistanciaAlArribo());
							if (StringUtils.isBlank(serv.getLongitudArriboAsegurado())) {
								term.getReporteSac().setLongitudArriboAsegurado(term.getLatitud());
							} else {
								term.getReporteSac().setLongitudArriboAsegurado(serv.getLongitudArriboAsegurado());
							}
							
							if (StringUtils.isBlank(serv.getLatitudArriboAsegurado())) {
								term.getReporteSac().setLatitudArriboAsegurado(term.getLongitud());
							} else {
								term.getReporteSac().setLatitudArriboAsegurado(serv.getLatitudArriboAsegurado());
							}
							term.getReporteSac().setArribloCloud(serv.getArriboCloud());
							term.getReporteSac().setUbicacionCorrecta(serv.getUbicacionCorrecta());
							term.getReporteSac().guardarObjeto();
						}

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"insertarArriboCercania => guardarObjeto_ReporteMovilSac en SIICA");
					}
		        	
					try {
						// Validar fecha estatus arribo, si campo es null obtiene fecha actual, de lo contrario envia la fecha que ya tiene guardada
						Date fechaArribo = new Date();
						
						if(term.getFechaEstatusArribo() != null){
							fechaArribo = term.getFechaEstatusArribo();
						} else {
							 if (StringUtils.isNotBlank(term.getReporteSac().getAjusteFechaArriboAjustador()) &&
									 StringUtils.isNotBlank(term.getReporteSac().getAjusteHoraArriboAjustador()) ) {
								 // Generar Date con arribo por cercania
								 try {
									 UtileriaCadenas util = new UtileriaCadenas();
									 fechaArribo = util.convertirFecha(term.getReporteSac().getAjusteFechaArriboAjustador(),
											 term.getReporteSac().getAjusteHoraArriboAjustador() );
								 } catch (Exception e) {
								}
							} 
						}
						
						this.terminalDao.ejecutarFuncionTerminalEstatusArribo(fechaArribo, serv.getUsuario(),
		                        JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "insertarArribo");
						
		                return new MovilResultadoOperacion(true, "OK");
		            } catch (final Exception ex) {
		                this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                        "insertarArriboCercania => ejecutarFuncionTerminalEstatusArriboSac");
		                return new MovilResultadoOperacion(false, ex.getMessage());
		            }
				}
		        return new MovilResultadoOperacion(false, "ERROR SAC Responde: " + respuestaSac);		
	   } else {
        return new MovilResultadoOperacion(false, "ERROR : No se cuenta con reporte valido. ");
	   }
  }
  
	  
	 @Override
	 public MovilResultadoOperacion solicitarTicketCondiciones(MovilSolicitarTicketCondiciones solicitarTicket) {
			 if (solicitarTicket  == null) {
		            return new MovilResultadoOperacion(false, "ERROR: El objeto solicitarTicket es nulo");
		        }
		        if (StringUtils.isBlank(solicitarTicket.getUsuario())) {
		            return new MovilResultadoOperacion(false, "ERROR: El campo 'usuario' es nulo");
		        }
		        if (StringUtils.isBlank(solicitarTicket.getPwd())) {
		            return new MovilResultadoOperacion(false, "ERROR: El campo 'pwd' es nulo");
		        }
		        
		        if (StringUtils.isBlank(solicitarTicket.getClaveCondicion())) {
		            return new MovilResultadoOperacion(false, "ERROR: El campo 'claveCondicion' es nulo");
		        }

		        Terminal term = null;
		        try {
		            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(solicitarTicket.getUsuario(), solicitarTicket.getPwd());
		        } catch (final ClassCastException | RollbackException |IllegalArgumentException ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "solicitarTicketCondiciones => objetoTerminalParaProveedorYPasswd");
		        } catch (final PersistenceException | DataAccessException ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "solicitarTicketCondiciones => objetoTerminalParaProveedorYPasswd");
		        }

		        if (term == null) {
		            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
		        }
		        
		        if (term.getReporteSac() == null) {
		        	return new MovilResultadoOperacion(false, "ERROR: El usuario "+solicitarTicket.getUsuario()+" no cuenta con un reporte asigando.");
				} else {
				
				 try {
					try {
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
						term.getReporteSac().getGeneralNumeroReporte(), this.fuenteWS + "solicitarTicketCondiciones", "Solicitar Ticker Condiciones V3",
						"Ejecucion del Metodo Con Datos -> "+ this.xmlFactory.obtenerString(solicitarTicket));
					} catch (final RollbackException | ClassCastException | NoResultException ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"solicitarTicketCondiciones");
					} catch (final PersistenceException | CannotResolveClassException ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"solicitarTicketCondiciones");
					}
					String respuestaSAC= null;
					
					try {
					 respuestaSAC = SacSPDao.solicitarTicketCondiciones(term, solicitarTicket.getClaveCondicion());
					} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
						 return new MovilResultadoOperacion(false, "ERROR: "+e);
					}catch (CannotGetJdbcConnectionException | DataIntegrityViolationException | NoResultException| RollbackException ex) {
							this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
							 return new MovilResultadoOperacion(false, "ERROR: "+ex);
					} catch (ClassCastException | DataAccessException | PersistenceException e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
							 return new MovilResultadoOperacion(false, "ERROR: "+e);
					} 
					
					try {
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
						term.getReporteSac().getGeneralNumeroReporte(), this.fuenteWS + "solicitarTicketCondiciones", "Solicitar Ticker Condiciones V3",
						"Respuesta de SAC -> "+ respuestaSAC);
					} catch (final RollbackException | ClassCastException | NoResultException ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"solicitarTicketCondiciones");
						 return new MovilResultadoOperacion(false, "ERROR: "+ex);
					} catch (final PersistenceException | CannotResolveClassException |  DataAccessException ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"solicitarTicketCondiciones");
						 return new MovilResultadoOperacion(false, "ERROR: "+ex);
					}  
				 
					if (respuestaSAC != null) {
						if (respuestaSAC.contains("|")) {
							String[] infoSAC = respuestaSAC.split("\\|");
							ArrayList<String> salida = new ArrayList<String>();
							for (int i = 0; i < infoSAC.length; i++) {
								salida.add(infoSAC[i]);
							}
						 if (salida.size() > 1) {
							 if (respuestaSAC.contains("OK")) {
								 return new MovilResultadoOperacion(true, salida.get(1) );
							}
							if (respuestaSAC.contains("ERROR")) {
								 return new MovilResultadoOperacion(false, salida.get(1) );
							}
						 } 
						}
						if (respuestaSAC.contains("OK")) {
							 return new MovilResultadoOperacion(true, respuestaSAC );
						}
						if (respuestaSAC.contains("ERROR")) {
							 return new MovilResultadoOperacion(false, respuestaSAC );
						}
						
					}
				} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
					this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"solicitarTicketCondiciones");
					 return new MovilResultadoOperacion(false, "ERROR: Ocurrio un error "+e );
				} catch (PersistenceException |  IllegalArgumentException e) {
					this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"solicitarTicketCondiciones");
					return new MovilResultadoOperacion(false, "ERROR: Ocurrio un error "+e );
				}
				} 
		        return new MovilResultadoOperacion(false, "ERROR en solicitar ticket Condiciones");
		}
	        
}
