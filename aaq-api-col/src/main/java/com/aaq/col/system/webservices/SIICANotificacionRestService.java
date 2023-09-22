package com.aaq.col.system.webservices;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.EnvioAsyncServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.pojo.conclusion.ConclusionAjustador;
import com.aaq.col.clases.pojo.notificacion.Correo;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.UtileriaCadenas;
import com.aaq.col.clases.util.UtileriaFechas;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

public class SIICANotificacionRestService implements SIICANotificacionRestServiceInterfase{
	

	  // fabricas
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");

	 private final String fuenteWS = "SIICA Servicios REST -> SIICA Notificacion REST Service -> ";

	 private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
	            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
	 
	 @Autowired
	 private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
	  
	 @Autowired
	 private EnvioAsyncServiceInterfase envioAsyncService;
	 
    @Autowired
    private TerminalServiceInterfase terminalDao;

    @Autowired
    private ReporteMovilSacServiceInterfase reporteMovilSacService;
    
	@Override
	public MovilResultadoOperacion enviarCorreoTermino(Correo entrada) {
		// Validaciones
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'usuario'");
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'pwd'");
		}
		if (StringUtils.isBlank(entrada.getReporte())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'reporte'");
		}
		
		if (StringUtils.isNotBlank(entrada.getEquipoPesado())) {
    		if ( !StringUtils.equalsIgnoreCase(entrada.getEquipoPesado(), "SI") && !StringUtils.equalsIgnoreCase(entrada.getEquipoPesado(), "NO") ) {
    			return new MovilResultadoOperacion(false, "ERROR: Los valores validos para 'equipoPesado' son 'SI' y 'NO'.");     
			}
		}
		
		
		Terminal term= null;
		  try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "enviarCorreoTermino => objetoTerminalParaProveedorYPasswd");
	        }

	        if (term == null) {
	            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
	        }
	        
	        try {
    			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, entrada.getReporte(),
    		               fuenteWS + "enviarCorreoTermino", "Enviar Correo Termino V3", "Inicia busqueda para envio de correo, Poliza: "+term.getReporteSac().getGeneralNumeroPoliza()+" - Clave Agente: " + term.getReporteSac().getClaveAgente());
        	}catch (Exception ex) {
        		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                         "enviarCorreoTermino => ejecutarFuncionHistoricoTerminalNuevo");
			}
        	try {
        		boolean esEquipoPesado = false;
        		if (StringUtils.isNotBlank(entrada.getEquipoPesado())) {
	        		if (entrada.getEquipoPesado().contains("SI")) {
						esEquipoPesado = true;
					}
        		}
        		this.envioAsyncService.enviarCorreoResumenAjustador(term, entrada.getReporte(), esEquipoPesado  );
        	}catch (Exception ex) {
        		this.loggerAvisos.info("Ocurrio un error en SIICANotificacionRestService.enviarCorreoTermino ->"+ex);
       		 	this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "enviarCorreoTermino => ejecutarFuncionHistoricoTerminalNuevo");
			}
		return new MovilResultadoOperacion(true, "Se incio proceso de envio de correo");
	}
	
	
	@Override
	public MovilResultadoOperacion enviarCorreoExpres(ConclusionAjustador entrada) {
		
		if (StringUtils.isBlank(entrada.getClaveAjustador())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'claveAjustador'");
		}
		if (StringUtils.isBlank(entrada.getNumeroReporte())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'numeroReporte'");
		}
		if (StringUtils.isNotBlank(entrada.getCroquis())) {
			UtileriaCadenas utileria = new UtileriaCadenas();
			if ( !utileria.validateBase64(entrada.getCroquis())) {
				return new MovilResultadoOperacion(false, "ERROR: Se espera 'croquis' en base64.");
			}
		}
		
		
		if (StringUtils.isNotBlank(entrada.getFirmaConductor())) {
			UtileriaCadenas utileria = new UtileriaCadenas();
			if ( !utileria.validateBase64(entrada.getFirmaConductor())) {
				return new MovilResultadoOperacion(false, "ERROR: Se espera 'firmaConductor' en base64.");
			}
		}
//		if (entrada.getCorreoDestinatario()  == null) {
//			return new MovilResultadoOperacion(false, "ERROR: Se espera al menos un correo destinatario.");
//		}
		
//		if (entrada.getCorreoDestinatario().size() == 0) {
//			return new MovilResultadoOperacion(false, "ERROR: Se espera al menos un correo destinatario.");
//		}
		
		if (entrada.getFechaArribo() != null) {
			UtileriaFechas utilfechas = new UtileriaFechas();
			boolean valida = utilfechas.validarFecha(entrada.getFechaArribo());
			if (!valida) {
				return new MovilResultadoOperacion(false, "Formato de fechaArribo no válida. Valido dd/MM/yyyy HH:mm:ss");
			}
		}
		if (entrada.getFechaAsignacion() != null) {
			UtileriaFechas utilfechas = new UtileriaFechas();
			boolean valida = utilfechas.validarFecha(entrada.getFechaAsignacion());
			if (!valida) {
				return new MovilResultadoOperacion(false, "Formato de fechaAsignacion no válida. Valido dd/MM/yyyy HH:mm:ss");
			}
		}
		if (entrada.getFechaOcurrido() != null) {
			UtileriaFechas utilfechas = new UtileriaFechas();
			boolean valida = utilfechas.validarFecha(entrada.getFechaOcurrido());
			if (!valida) {
				return new MovilResultadoOperacion(false, "Formato de fechaOcurrido no válida. Valido dd/MM/yyyy HH:mm:ss");
			}
		}
		if (entrada.getFechaTermino() != null) {
			UtileriaFechas utilfechas = new UtileriaFechas();
			boolean valida = utilfechas.validarFecha(entrada.getFechaTermino());
			if (!valida) {
				return new MovilResultadoOperacion(false, "Formato de fechaOcurrido no válida. Valido dd/MM/yyyy HH:mm:ss");
			}
		}
	String noCoincideDoc = "";	
		if (entrada.getDocumentosEntregados() != null) {
			if (entrada.getDocumentosEntregados().size() > 0) {
		String nombreDocError = "";
		boolean band = false;
		for (int i = 0; i < entrada.getDocumentosEntregados().size(); i++) {
			if ( !entrada.getDocumentosEntregados().get(i).contains("Formato Declaración Universal") && !entrada.getDocumentosEntregados().get(i).contains("Formato Admisión Autos")
					&& !entrada.getDocumentosEntregados().get(i).contains("Formato Asignación Abogado") && !entrada.getDocumentosEntregados().get(i).contains("Formato Encuesta Servicio") &&
					!entrada.getDocumentosEntregados().get(i).contains("Formato Declaracion Universal") && !entrada.getDocumentosEntregados().get(i).contains("Formato Admision Autos")
					&& !entrada.getDocumentosEntregados().get(i).contains("Formato Asignacion Abogado") ) {
				nombreDocError = nombreDocError + ", "+entrada.getDocumentosEntregados().get(i);
				band = true;
			}
		}
		if (band){
			try {
			noCoincideDoc = nombreDocError.substring(1)+ " no coincide con 'Formato Declaración Universal','Formato Admisión Autos','Formato Asignación Abogado' y/o 'Formato Encuesta Servicio' en documentosEntregados.";
			} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
			}
		}
	}}
		
		Terminal term= null;
		ReporteMovilSac reporteMovilSac= null;
		  try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getClaveAjustador(), null);
	            reporteMovilSac = this.reporteMovilSacService.objetoReporteMovilSac(entrada.getNumeroReporte(), null);
	        } catch (final Exception ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "enviarCorreoTermino => objetoTerminalParaProveedorYPasswd");
	        }

	       if (term == null) {
	           return new MovilResultadoOperacion(false, "ERROR: 'claveAjustador' no encontrada en AQ.");
	       }
	       
	       if (reporteMovilSac == null) {
	           return new MovilResultadoOperacion(false, "ERROR: Reporte no encontrado en AQ.");
	       }
	        
        	try {
        		this.envioAsyncService.enviarCorreoResumenAjustadorExpres(entrada, term, reporteMovilSac);
 	           return new MovilResultadoOperacion(true, "Correo resumen ajustador expres exitoso."+noCoincideDoc);
        	}catch (Exception ex) {
        		this.loggerAvisos.info("Ocurrio un error en SIICANotificacionRestService.enviarCorreoTermino ->"+ex);
       		 	this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "enviarCorreoTermino => ejecutarFuncionHistoricoTerminalNuevo");
       		 return new MovilResultadoOperacion(false, "Error al enviar resumen ajustador expres.");
			}
		
	}




}
