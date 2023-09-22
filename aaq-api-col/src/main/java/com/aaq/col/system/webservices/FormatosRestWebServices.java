package com.aaq.col.system.webservices;

import java.sql.SQLException;
//import java.text.ParseException;
/*import java.util.HashMap;
import java.util.Map;*/

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.FormatoEliminarFirmas;
import com.aaq.col.clases.database.entidades.pojo.FormatoServicioErrores;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionAutomovilesDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionMotocicletasDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionPesadoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAsignacionAbogadoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAsistenciaVialDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoCargoTarjetaCreditoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoCuestionarioRoboDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoDeclaracionUniversalDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoEncuestaServicioDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoGarantiaPrendariaDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoInspeccionMotoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoInspeccionPesadoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoInventarioAutomovilesDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoInventarioUnicoPesadoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoMemoriaDescriptivaDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoNuevosVehiculosDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoObservacionesAseguradoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoOrdenServicioDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoPaseMedicoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoReciboIngresoSiniestroDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoReciboPagoDeducibleDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoReclamacionComprobantePeajeDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoReclamacionPendienteDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoReparacionBienesDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoReparacionBienesDiversosDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoResponsabilidadCivilDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoSolicitudDiagnosticoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoValeAmbulanciaDao;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionAutomoviles;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionMotocicletas;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionPesado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAsignacionAbogado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAsistenciaVial;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoCargoTarjetaCredito;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoCuestionarioRobo;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoDeclaracionUniversal;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoEncuestaServicio;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoGarantiaPrendaria;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInspeccionMoto;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInspeccionPesado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInventarioAutomoviles;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInventarioUnicoPesado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoMemoriaDescriptiva;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoNuevosVehiculos;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoObservacionesAsegurado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoOrdenServicio;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoPaseMedico;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReciboIngresoSiniestro;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReciboPagoDeducible;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReclamacionPendiente;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReparacionBienes;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReparacionBienesDiversos;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoResponsabilidadCivil;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoSolicitudDiagnostico;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoValeAmbulancia;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionAutomoviles;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.webservices.formatos.FormatoAdmisionPesado;
import com.aaq.col.clases.webservices.formatos.FormatoAsignacionAbogado;
import com.aaq.col.clases.webservices.formatos.FormatoAsistenciaVial;
import com.aaq.col.clases.webservices.formatos.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.webservices.formatos.FormatoCuestionarioRobo;
import com.aaq.col.clases.webservices.formatos.FormatoDeclaracionUniversal;
import com.aaq.col.clases.webservices.formatos.FormatoEncuestaServicio;
import com.aaq.col.clases.webservices.formatos.FormatoGarantiaPrendaria;
import com.aaq.col.clases.webservices.formatos.FormatoInspeccionMoto;
import com.aaq.col.clases.webservices.formatos.FormatoInspeccionPesado;
import com.aaq.col.clases.webservices.formatos.FormatoInventarioAutomoviles;
import com.aaq.col.clases.webservices.formatos.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.webservices.formatos.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.webservices.formatos.FormatoNuevosVehiculos;
import com.aaq.col.clases.webservices.formatos.FormatoObservacionesAsegurado;
import com.aaq.col.clases.webservices.formatos.FormatoOdaAuto;
import com.aaq.col.clases.webservices.formatos.FormatoOrdenServicio;
import com.aaq.col.clases.webservices.formatos.FormatoPaseMedico;
import com.aaq.col.clases.webservices.formatos.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.webservices.formatos.FormatoReciboPagoDeducible;
import com.aaq.col.clases.webservices.formatos.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.webservices.formatos.FormatoReclamacionPendiente;
import com.aaq.col.clases.webservices.formatos.FormatoReparacionBienes;
import com.aaq.col.clases.webservices.formatos.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.webservices.formatos.FormatoResponsabilidadCivil;
import com.aaq.col.clases.webservices.formatos.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.webservices.formatos.FormatoValeAmbulancia;
import com.aaq.col.clases.webservices.movil.GETMovilResultadoOperacion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
 
public class FormatosRestWebServices implements FormatosRestWebServicesInterface {
 
	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
	@Autowired
	private FormatoAsistenciaVialDao fav;
	@Autowired
	private FormatoValeAmbulanciaDao fva;
	@Autowired
	private FormatoReclamacionPendienteDao frp;
	@Autowired
	private FormatoEncuestaServicioDao fes;
	@Autowired
	private FormatoOrdenServicioDao fos;
	@Autowired
	private FormatoGarantiaPrendariaDao fgp;
	@Autowired
	private FormatoNuevosVehiculosDao fnv;
	@Autowired
	private FormatoReparacionBienesDao frb;
	@Autowired
	private FormatoPaseMedicoDao fpm;
	@Autowired
	private FormatoInventarioAutomovilesDao fia;
	@Autowired
	private FormatoInspeccionPesadoDao fip;
	@Autowired
	private FormatoInspeccionMotoDao fim;
	@Autowired
	private FormatoAdmisionAutomovilesDao faauto;
	@Autowired
	private FormatoAdmisionMotocicletasDao fam;
	@Autowired
	private FormatoAdmisionPesadoDao fap;
	@Autowired
	private FormatoAsignacionAbogadoDao faabogado;
	@Autowired
	private FormatoCuestionarioRoboDao fcr;
	@Autowired
	private FormatoDeclaracionUniversalDao fdu;

	@Autowired
	private FormatoReciboIngresoSiniestroDao fri;

	@Autowired
	private FormatoReciboPagoDeducibleDao frd;

	@Autowired
	private FormatoSolicitudDiagnosticoDao fsd;

	@Autowired
	private FormatoMemoriaDescriptivaDao fmd;
	
	@Autowired
	private FormatoCargoTarjetaCreditoDao ftc;
	
	@Autowired
	private FormatoResponsabilidadCivilDao frc;
	
	@Autowired
	private FormatoReparacionBienesDiversosDao fbd;
	
	@Autowired
	private FormatoObservacionesAseguradoDao foa;
	
	@Autowired
	private FormatoInventarioUnicoPesadoDao finp;

	@Autowired
	private FormatoReclamacionComprobantePeajeDao frcp;
	
	//@Autowired
	//private FormatoOdaAuto foad;
	
	
	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
//	private final String fuenteWS = "SIICA Servicios Web -> Formatos Rest Web Service -> ";
	private final String operacion = "Generación Expediente Electrónico";
	// fabricas
	private final JMXMLObjectFactory xmlFactory = new JMXMLObjectFactory();

	public FormatosRestWebServices() {
		super();
	}

	FormatoServicioErrores formatoServicioErrores = new FormatoServicioErrores();
	FormatoEliminarFirmas limpiar= new FormatoEliminarFirmas();

	@Override 
	public GETMovilResultadoOperacion InsertarFAV(FormatoAsistenciaVial formato) throws SQLException {
		try { 
			
			DatosInsertarFormatoAsistenciaVial s = new DatosInsertarFormatoAsistenciaVial();
			s.setAvNumReporte(formato.getAvNumReporte());
			s.setAvFecha(formato.getAvFecha());
			s.setAvNumPoliza(formato.getAvNumPoliza());
			s.setAvNumInciso(formato.getAvNumInciso());
			s.setAvPregunta1(formato.getAvPregunta1());
			s.setAvPregunta2(formato.getAvPregunta2());
			s.setAvPregunta3(formato.getAvPregunta3());
			s.setAvPregunta4(formato.getAvPregunta4());
			s.setAvPregunta5(formato.getAvPregunta5());
			s.setAvPregunta6(formato.getAvPregunta6());
			s.setAvPregunta7(formato.getAvPregunta7());
			s.setAvComentarios(formato.getAvComentarios());
			s.setAvNomAsegurado(formato.getAvNomAsegurado());
			s.setAvEmail(formato.getAvEmail());
			s.setAvClaveAjustador(formato.getAvClaveAjustador());
			s.setAvAsegurado(formato.getAvAsegurado());
			s.setCheck_1(formato.getCheck_1());
			s.setCheck_2(formato.getCheck_2());
			s.setCheck_3(formato.getCheck_3());
			s.setCheck_4(formato.getCheck_4());
			s.setFirma_Asegurado(formato.getFirma_Asegurado());
			s.setCorreo_oculto(formato.getCorreo_oculto());
			s.setFuente_ws(formato.getFuente_ws());
			s.setCheck_5(formato.getCheck_5());
			s.setCheck_6(formato.getCheck_6());
			
			
			if(formato.getAvClaveAjustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}
			//
			String resultado = null;

			resultado = fav.InsertarFormatoAsistenciaVial(s);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getAvClaveAjustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getAvNumReporte(),
					 "FormatoAsistenciaVial", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAsistenciaVial(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorAsistenciaVial(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			return new GETMovilResultadoOperacion(true, resultado);

		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAsistenciaVial");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getAvClaveAjustador(), null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getAvNumReporte(),
						 "FormatoAsistenciaVial", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAsistenciaVial(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAsistenciaVial");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	} 

	public GETMovilResultadoOperacion InsertarFVA(FormatoValeAmbulancia formato) throws SQLException {
		try {
			DatosInsertarFormatoValeAmbulancia d = new DatosInsertarFormatoValeAmbulancia();
			d.setVa_Num_Reporte(formato.getVa_Num_Reporte());
			d.setVa_Num_Siniestro(formato.getVa_Num_Siniestro());
			d.setVa_Folio_Electro(formato.getVa_Folio_Electro());
			d.setVa_Asegurado(formato.getVa_Asegurado());
			d.setVa_Hora(formato.getVa_Hora());
			d.setVa_Num_Poliza(formato.getVa_Num_Poliza());
			d.setVa_Num_Endoso(formato.getVa_Num_Endoso());
			d.setVa_Num_Inciso(formato.getVa_Num_Inciso());
			d.setVa_Nom_Razon(formato.getVa_Nom_Razon());
			d.setVa_Hospital(formato.getVa_Hospital());
			d.setVa_Nom_Paciente(formato.getVa_Nom_Paciente());
			d.setVa_Tel_Paciente(formato.getVa_Tel_Paciente());
			d.setVa_Dir_Paciente(formato.getVa_Dir_Paciente());
			d.setVa_Edad_Paciente(formato.getVa_Edad_Paciente());
			d.setVa_Sexo(formato.getVa_Sexo());
			d.setVa_Diagnostico(formato.getVa_Diagnostico());
			d.setVa_Lugar(formato.getVa_Lugar());
			d.setVa_Nom_Ajustador(formato.getVa_Nom_Ajustador());
			d.setVa_Datos_Conductor(formato.getVa_Datos_Conductor());
			d.setVa_Datos_Lesionado(formato.getVa_Datos_Lesionado());
			d.setEmail_Default(formato.getEmail_Default());
			d.setVa_Clave_Ajustador(formato.getVa_Clave_Ajustador());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Conductor(formato.getFirma_Conductor());
			d.setFirma_Lesionado(formato.getFirma_Lesionado());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getVa_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;
			resultado = fva.InsertarFormatoValeAmbulancia(d);
			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getVa_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getVa_Num_Reporte(),
					"FormatoValeAmbulacia", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoValeAmbulancia(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorValeAmbulancia(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoValeAmbulacia");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getVa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getVa_Num_Reporte(),
						 "FormatoValeAmbulacia", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoValeAmbulancia(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoValeAmbulacia");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFRP(FormatoReclamacionPendiente formato) throws SQLException {
		try {
			DatosInsertarFormatoReclamacionPendiente d = new DatosInsertarFormatoReclamacionPendiente();

			d.setRp_Nom_Ajustador(formato.getRp_Nom_Ajustador());
			d.setRp_Fecha(formato.getRp_Fecha());
			d.setRp_Num_Reclamacion(formato.getRp_Num_Reclamacion());
			d.setRp_Num_Poliza(formato.getRp_Num_Poliza());
			d.setRp_Recibo_Pago(formato.getRp_Recibo_Pago());
			d.setRp_Licencia(formato.getRp_Licencia());
			d.setRp_Copia_Acta_Mp(formato.getRp_Copia_Acta_Mp());
			d.setRp_Otros(formato.getRp_Otros());
			d.setRp_Obs_Endoso_Aclara(formato.getRp_Obs_Endoso_Aclara());
			d.setRp_Observaciones(formato.getRp_Observaciones());
			d.setRp_Nom_Conductor(formato.getRp_Nom_Conductor());
			d.setRp_Num_Reporte(formato.getRp_Num_Reporte());
			d.setRp_Num_Inciso(formato.getRp_Num_Inciso());
			d.setEmail_Default(formato.getEmail_Default());
			d.setRp_Asegurado(formato.getRp_Asegurado());
			d.setRp_Df_Endoso(formato.getRp_Df_Endoso());
			d.setRp_Nombre_Conductor(formato.getRp_Nombre_Conductor());
			d.setRp_Clave_Ajustador(formato.getRp_Clave_Ajustador());
			d.setRp_Poliza_Vigente(formato.getRp_Poliza_Vigente());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setRp_datos_oficina(formato.getRp_datos_oficina());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());

			if(formato.getRp_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}
			
			String resultado = null;

			resultado = frp.InsertarFormatoReclamacionPendiente(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getRp_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRp_Num_Reporte(),
					 "FormatoReclamacionPendiente", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReclamacionPendiente(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorReclamacionPendiente(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReclamacionPendiente");

			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getRp_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRp_Num_Reporte(),
						 "FormatoReclamacionPendiente", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReclamacionPendiente(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReclamacionPendiente");

			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFES(FormatoEncuestaServicio formato) throws SQLException {
		try {
			DatosInsertarFormatoEncuestaServicio d = new DatosInsertarFormatoEncuestaServicio();

			d.setEs_Num_Reporte(formato.getEs_Num_Reporte());
			d.setEs_Num_Siniestro(formato.getEs_Num_Siniestro());
			d.setEs_Nom_Asegurado(formato.getEs_Nom_Asegurado());
			d.setEs_Pregunta_1(formato.getEs_Pregunta_1());
			d.setEs_Pregunta_2(formato.getEs_Pregunta_2());
			d.setEs_Pregunta_3(formato.getEs_Pregunta_3());
			d.setEs_Pregunta_4(formato.getEs_Pregunta_4());
			d.setEs_Pregunta_5(formato.getEs_Pregunta_5());
			d.setEs_Pregunta_6(formato.getEs_Pregunta_6());
			d.setEs_Pregunta_7(formato.getEs_Pregunta_7());
			d.setEs_Pregunta_8(formato.getEs_Pregunta_8());
			d.setEs_Pregunta_9(formato.getEs_Pregunta_9());
			d.setEs_Pregunta_10(formato.getEs_Pregunta_10());
			d.setEs_Observaciones(formato.getEs_Observaciones());
			d.setEs_Nom_Conductor(formato.getEs_Nom_Conductor());
			d.setEs_Tel_Conductor(formato.getEs_Tel_Conductor());
			d.setEs_Email_Conductor(formato.getEs_Email_Conductor());
			d.setEs_Lugar(formato.getEs_Lugar());
			d.setEs_Fecha(formato.getEs_Fecha());
			d.setEs_Num_Poliza(formato.getEs_Num_Poliza());
			d.setEs_Num_Inciso(formato.getEs_Num_Inciso());
			d.setEs_Clave_Ajustador(formato.getEs_Clave_Ajustador());
			d.setEs_Asegurado(formato.getEs_Asegurado());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getEs_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}
			

			String resultado = null;

			resultado = fes.InsertarFormatoEncuestaServicio(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getEs_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getEs_Num_Reporte(),
					 "FormatoEncuestaServicio", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoEncuestaServicio(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorEncuestaServicio(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoEncuestaServicio");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getEs_Clave_Ajustador(), null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getEs_Num_Reporte(),
						 "FormatoEncuestaServicio", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoEncuestaServicio(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoEncuestaServicio");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFOS(FormatoOrdenServicio formato) throws SQLException {
		try {
			DatosInsertarFormatoOrdenServicio d = new DatosInsertarFormatoOrdenServicio();

			d.setOs_Poliza(formato.getOs_Poliza());
			d.setOs_Num_reporte(formato.getOs_Num_reporte());
			d.setOs_Num_siniestro(formato.getOs_Num_siniestro());
			d.setOs_Fecha_Atencion(formato.getOs_Fecha_Atencion());
			d.setOs_Nom_Conductor(formato.getOs_Nom_Conductor());
			d.setOs_Lugar_Servicio(formato.getOs_Lugar_Servicio());
			d.setOs_Tel_Conductor(formato.getOs_Tel_Conductor());
			d.setOs_Edad_Conductor(formato.getOs_Edad_Conductor());
			d.setOs_Sexo_Conductor(formato.getOs_Sexo_Conductor());
			d.setOs_Email_Conductor(formato.getOs_Email_Conductor());
			d.setOs_Marca_Auto(formato.getOs_Marca_Auto());
			d.setOs_Tipo_Auto(formato.getOs_Tipo_Auto());
			d.setOs_Anio_Auto(formato.getOs_Anio_Auto());
			d.setOs_Modelo_Auto(formato.getOs_Modelo_Auto());
			d.setOs_Placas_Auto(formato.getOs_Placas_Auto());
			d.setOs_Num_Serie_Auto(formato.getOs_Num_Serie_Auto());
			d.setOs_Surtido_Combustible(formato.getOs_Surtido_Combustible());
			d.setOs_Tipo_Servicio(formato.getOs_Tipo_Servicio());
			d.setOs_Hora_Reporte(formato.getOs_Hora_Reporte());
			d.setOs_Hora_Arribo(formato.getOs_Hora_Arribo());
			d.setOs_Hora_Termino(formato.getOs_Hora_Termino());
			d.setOs_Informe_Ajustador(formato.getOs_Informe_Ajustador());
			d.setOs_Nom_Ajustador(formato.getOs_Nom_Ajustador());
			d.setOs_Clave(formato.getOs_Clave());
			d.setOs_Num_Inciso(formato.getOs_Num_Inciso());
			d.setOs_Asegurado(formato.getOs_Asegurado());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getOs_Clave()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fos.InsertarFormatoOrdenServicio(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getOs_Clave(), null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOs_Num_reporte(),
					 "FormatoOrdenServicio", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoOrdenServicio(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorOrdenServicio(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		} catch (javax.persistence.PersistenceException se) {
			this.utileriaExcepcion.manejarExcepcion(se, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoOrdenServicio");
			try {

				Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(formato.getOs_Clave(),
						null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOs_Num_reporte(),
						 "FormatoOrdenServicio", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoOrdenServicio(formato)) + "Excepcion: " + se.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoOrdenServicio");
			}

			if (se.getMessage().contains("Error Code: 6502")) {
				return new GETMovilResultadoOperacion(false, "Se espera un dato numerico en: EDAD CONDUCTOR");
			}

			return new GETMovilResultadoOperacion(false, se.getMessage());
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoOrdenServicio");

			try {
				Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(formato.getOs_Clave(),
						null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOs_Num_reporte(),
						 "FormatoOrdenServicio", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoOrdenServicio(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoOrdenServicio");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFGP(FormatoGarantiaPrendaria formato) throws SQLException {
		try {
			DatosInsertarFormatoGarantiaPrendaria d = new DatosInsertarFormatoGarantiaPrendaria();
			String resultado = null;
			d.setGp_Sr(formato.getGp_Sr());
			d.setGp_Sr_Calle(formato.getGp_Sr_Calle());
			d.setGp_Sr_Colonia(formato.getGp_Sr_Colonia());
			d.setGp_Sr_Municipio(formato.getGp_Sr_Municipio());
			d.setGp_Sr_Cp(formato.getGp_Sr_Cp());
			d.setGp_Sr_Ciudad(formato.getGp_Sr_Ciudad());
			d.setGp_Sr_Identificacion(formato.getGp_Sr_Identificacion());
			d.setGp_Cantidad(formato.getGp_Cantidad());
			d.setGp_Cantidad_Letra(formato.getGp_Cantidad_Letra());
			d.setGp_Marca_Auto(formato.getGp_Marca_Auto());
			d.setGp_Tipo_Auto(formato.getGp_Tipo_Auto());
			d.setGp_Modelo_Auto(formato.getGp_Modelo_Auto());
			d.setGp_Placas_Auto(formato.getGp_Placas_Auto());
			d.setGp_Color_Auto(formato.getGp_Color_Auto());
			d.setGp_Num_Poliza(formato.getGp_Num_Poliza());
			d.setGp_Bienes(formato.getGp_Bienes());
			d.setGp_Factura(formato.getGp_Factura());
			d.setGp_Factura_Expedida(formato.getGp_Factura_Expedida());
			d.setGp_Factura_Fecha(formato.getGp_Factura_Fecha());
			d.setGp_Dias(formato.getGp_Dias());
			d.setGp_Fecha(formato.getGp_Fecha());
			d.setGp_Fecha_Firma(formato.getGp_Fecha_Firma());
			d.setGp_Nom_Deudor(formato.getGp_Nom_Deudor());
			d.setGp_Nom_Acreedor(formato.getGp_Nom_Acreedor());
			d.setGp_Num_Reporte(formato.getGp_Num_Reporte());
			d.setGp_Num_Inciso(formato.getGp_Num_Inciso());
			d.setEmail_Default(formato.getEmail_Default());
			d.setGp_Asegurado(formato.getGp_Asegurado());
			d.setGp_Clave_Ajustador(formato.getGp_Clave_Ajustador());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Deudor(formato.getFirma_Deudor());
			d.setFirma_Acreedor(formato.getFirma_Acreedor());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getGp_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			resultado = fgp.InsertarFormatoGarantiaPrendaria(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getGp_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getGp_Num_Reporte(),
					 "FormatoGarantiaPrendaria", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoGarantiaPrendaria(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorGarantiaPrendaria(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);

		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoGarantiaPrendaria");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getGp_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getGp_Num_Reporte(),
						 "FormatoGarantiaPrendaria", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoGarantiaPrendaria(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoGarantiaPrendaria");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFNV(FormatoNuevosVehiculos formato) throws SQLException {
		try {
			DatosInsertarFormatoNuevosVehiculos d = new DatosInsertarFormatoNuevosVehiculos();
			d.setNv_Solicitante(formato.getNv_Solicitante());
			d.setNv_Oficna(formato.getNv_Oficna());
			d.setNv_Hora(formato.getNv_Hora());
			d.setNv_Ubicacion(formato.getNv_Ubicacion());
			d.setNv_Email(formato.getNv_Email());
			d.setNv_Unidad_Auto(formato.getNv_Unidad_Auto());
			d.setNv_Tipo_Auto(formato.getNv_Tipo_Auto());
			d.setNv_Modelo_Auto(formato.getNv_Modelo_Auto());
			d.setNv_Motor_Auto(formato.getNv_Motor_Auto());
			d.setNv_Num_Serie_Auto(formato.getNv_Num_Serie_Auto());
			d.setNv_Kilometros_Auto(formato.getNv_Kilometros_Auto());
			d.setNv_Puertas_Auto(formato.getNv_Puertas_Auto());
			d.setNv_Transmision_Auto(formato.getNv_Transmision_Auto());
			d.setNv_Observaciones_Auto(formato.getNv_Observaciones_Auto());
			d.setNv_Procedencia_Auto(formato.getNv_Procedencia_Auto());
			d.setNv_Derivada_Auto(formato.getNv_Derivada_Auto());
			d.setNv_Foto_Serie(formato.getNv_Foto_Serie());
			d.setNv_Foto_Motor(formato.getNv_Foto_Motor());
			d.setNv_Total_Fotos(formato.getNv_Total_Fotos());
			d.setNv_Fecha_Inspeccion(formato.getNv_Fecha_Inspeccion());
			d.setNv_Tipo_Empleado(formato.getNv_Tipo_Empleado());
			d.setNv_Nombre_Cliente(formato.getNv_Nombre_Cliente());
			d.setNv_Nombre_Ajustador(formato.getNv_Nombre_Ajustador());
			d.setNv_Tel_Solicitante(formato.getNv_Tel_Solicitante());
			d.setNv_Clave_Ajustador(formato.getNv_Clave_Ajustador());
			d.setNv_Num_Reporte(formato.getNv_Num_Reporte());
			d.setNv_Num_Poliza(formato.getNv_Num_Poliza());
			d.setNv_Num_Inciso(formato.getNv_Num_Inciso());
			d.setNv_Asegurado(formato.getNv_Asegurado());
			d.setNv_Fecha(formato.getNv_Fecha());
			d.setNv_Placas(formato.getNv_Placas());
			d.setNv_Danios_Pre(formato.getNv_Danios_Pre());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Cliente(formato.getFirma_Cliente());
			d.setFirma_Agente(formato.getFirma_Agente());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getNv_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fnv.InsertarFormatoNuevosVehiculos(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getNv_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getNv_Num_Reporte(),
					 "FormatoNuevosVehiculos", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoNuevosVehiculos(formato)) + "Resultado SP: " + resultado);

			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorNuevosVehiculos(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoNuevosVehiculos");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getNv_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getNv_Num_Reporte(),
						 "FormatoNuevosVehiculos", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoNuevosVehiculos(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoNuevosVehiculos");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFRB(FormatoReparacionBienes formato) throws SQLException {
		try {
			DatosInsertarFormatoReparacionBienes d = new DatosInsertarFormatoReparacionBienes();
			d.setRb_Num_Reporte(formato.getRb_Num_Reporte());
			d.setRb_Num_Siniestro(formato.getRb_Num_Siniestro());
			d.setRb_Folio_Electro(formato.getRb_Folio_Electro());
			d.setRb_Num_Poliza(formato.getRb_Num_Poliza());
			d.setRb_Num_Endoso(formato.getRb_Num_Endoso());
			d.setRb_Num_Inciso(formato.getRb_Num_Inciso());
			d.setRb_Nom_Repara(formato.getRb_Nom_Repara());
			d.setRb_Email_Repara(formato.getRb_Email_Repara());
			d.setRb_Tel_Repara(formato.getRb_Tel_Repara());
			d.setRb_Nom_Afectado(formato.getRb_Nom_Afectado());
			d.setRb_Repre_Afectado(formato.getRb_Repre_Afectado());
			d.setRb_Tel_Afectado(formato.getRb_Tel_Afectado());
			d.setRb_Dom_Afectado(formato.getRb_Dom_Afectado());
			d.setRb_Danios(formato.getRb_Danios());
			d.setRb_Material(formato.getRb_Material());
			d.setRb_Med_Long(formato.getRb_Med_Long());
			d.setRb_Med_Alto(formato.getRb_Med_Alto());
			d.setRb_Med_Ancho(formato.getRb_Med_Ancho());
			d.setRb_Car_Marca(formato.getRb_Car_Marca());
			d.setRb_Car_Modelo(formato.getRb_Car_Modelo());
			d.setRb_Tramo(formato.getRb_Tramo());
			d.setRb_Km(formato.getRb_Km());
			d.setRb_Cuerpo_A(formato.getRb_Cuerpo_A());
			d.setRb_Observaciones(formato.getRb_Observaciones());
			d.setRb_Des_Danios(formato.getRb_Des_Danios());
			d.setRb_Num_Fotos(formato.getRb_Num_Fotos());
			d.setRb_Danios_Pre(formato.getRb_Danios_Pre());
			d.setRb_Otros(formato.getRb_Otros());
			d.setRb_Nom_Ajustador(formato.getRb_Nom_Ajustador());
			d.setRb_Clave_Ajustador(formato.getRb_Clave_Ajustador());
			d.setRb_Asegurado(formato.getRb_Asegurado());
			d.setFecha_Hora(formato.getFecha_Hora());
			d.setRb_Municipio(formato.getRb_Municipio());
			d.setRb_Estado(formato.getRb_Estado());
			d.setRb_Nom_Asegurado(formato.getRb_Nom_Asegurado());
			d.setRb_Email_Afectado(formato.getRb_Email_Afectado());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getRb_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = frb.InsertarFormatoReparacionBienes(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getRb_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRb_Num_Reporte(),
					 "FormatoReparacionBienes", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReparacionBienes(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorReparacionBienes(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReparacionBienes");
			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getRb_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRb_Num_Reporte(),
						 "FormatoReparacionBienes", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReparacionBienes(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReparacionBienes");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFPM(FormatoPaseMedico formato) throws SQLException {
		try {
			DatosInsertarFormatoPaseMedico d = new DatosInsertarFormatoPaseMedico();
			d.setPm_Folio_Electro(formato.getPm_Folio_Electro());
			d.setPm_Num_Reporte(formato.getPm_Num_Reporte());
			d.setPm_Num_Siniestro(formato.getPm_Num_Siniestro());
			d.setPm_Num_Poliza(formato.getPm_Num_Poliza());
			d.setPm_Num_Inciso(formato.getPm_Num_Inciso());
			d.setPm_Num_Endoso(formato.getPm_Num_Endoso());
			d.setPm_Nom_Asegurado(formato.getPm_Nom_Asegurado());
			d.setPm_Email_Asegurado(formato.getPm_Email_Asegurado());
			d.setPm_Lugar_Emision(formato.getPm_Lugar_Emision());
			d.setPm_Lugar_Estado(formato.getPm_Lugar_Estado());
			d.setPm_Fecha_Emision(formato.getPm_Fecha_Emision());
			d.setPm_Fecha_Siniestro(formato.getPm_Fecha_Siniestro());
			d.setPm_Num_Ocupantes(formato.getPm_Num_Ocupantes());
			d.setPm_Tipo_Vehiculo(formato.getPm_Tipo_Vehiculo());
			d.setPm_Otro_Vehiculo(formato.getPm_Otro_Vehiculo());
			d.setPm_Causa_Lesion(formato.getPm_Causa_Lesion());
			d.setPm_Otra_Lesion(formato.getPm_Otra_Lesion());
			d.setPm_Cobertura_Afec(formato.getPm_Cobertura_Afec());
			d.setPm_Otra_Cobertura(formato.getPm_Otra_Cobertura());
			d.setPm_Nom_Lesionado(formato.getPm_Nom_Lesionado());
			d.setPm_Edad_Lesionado(formato.getPm_Edad_Lesionado());
			d.setPm_Tel_Lesionado(formato.getPm_Tel_Lesionado());
			d.setPm_Num_Lesionado(formato.getPm_Num_Lesionado());
			d.setPm_Ambulatoria(formato.getPm_Ambulatoria());
			d.setPm_Ide_Lesionado(formato.getPm_Ide_Lesionado());
			d.setPm_Lesiones_Aparentes(formato.getPm_Lesiones_Aparentes());
			d.setPm_Tipo_Clinica(formato.getPm_Tipo_Clinica());
			d.setPm_Convenio(formato.getPm_Convenio());
			d.setPm_Clave_Clinica(formato.getPm_Clave_Clinica());
			d.setPm_Nom_Clinica(formato.getPm_Nom_Clinica());
			d.setPm_Dom_Clinica(formato.getPm_Dom_Clinica());
			d.setPm_Tel_Clinica(formato.getPm_Tel_Clinica());
			d.setPm_Medico_red(formato.getPm_Medico_red());
			d.setPm_Clave_Medico(formato.getPm_Clave_Medico());
			d.setPm_Nom_Medico(formato.getPm_Nom_Medico());
			d.setPm_Tel_Medico(formato.getPm_Tel_Medico());
			d.setPm_Nom_Ajustador(formato.getPm_Nom_Ajustador());
			d.setPm_Clave_Ajustador(formato.getPm_Clave_Ajustador());
			d.setPm_Asegurado(formato.getPm_Asegurado());
			d.setPm_Email_Lesionado(formato.getPm_Email_Lesionado());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setFirma_Lesionado(formato.getFirma_Lesionado());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getPm_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fpm.InsertarFormatoPaseMedico(d);
			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getPm_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getPm_Num_Reporte(),
					 "FormatoPaseMedico", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoPaseMedico(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorPaseMedico(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoPaseMedico");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getPm_Clave_Ajustador(), null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getPm_Num_Reporte(),
						 "FormatoPaseMedico", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoPaseMedico(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoPaseMedico");
			}
			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}
	}

	public GETMovilResultadoOperacion InsertarFIA(FormatoInventarioAutomoviles formato) throws SQLException {
		try {
			DatosInsertarFormatoInventarioAutomoviles d = new DatosInsertarFormatoInventarioAutomoviles();

			d.setIa_Num_Reporte(formato.getIa_Num_Reporte());
			d.setIa_Num_Siniestro(formato.getIa_Num_Siniestro());
			d.setIa_Nom_Razon(formato.getIa_Nom_Razon());
			d.setIa_Asegurado(formato.getIa_Asegurado());
			d.setIa_Llaves(formato.getIa_Llaves());
			d.setIa_Cantidad(formato.getIa_Cantidad());
			d.setIa_Hora(formato.getIa_Hora());
			d.setIa_Num_Poliza(formato.getIa_Num_Poliza());
			d.setIa_Destino(formato.getIa_Destino());
			d.setIa_Nom_Destino(formato.getIa_Nom_Destino());
			d.setIa_Dir_Destino(formato.getIa_Dir_Destino());
			d.setIa_Marca_Auto(formato.getIa_Marca_Auto());
			d.setIa_Tipo_Auto(formato.getIa_Tipo_Auto());
			d.setIa_Puertas_Auto(formato.getIa_Puertas_Auto());
			d.setIa_Anio_Auto(formato.getIa_Anio_Auto());
			d.setIa_Num_Motor(formato.getIa_Num_Motor());
			d.setIa_Num_Serie(formato.getIa_Num_Serie());
			d.setIa_Color_Auto(formato.getIa_Color_Auto());
			d.setIa_Placas_Auto(formato.getIa_Placas_Auto());
			d.setIa_T_Manual(formato.getIa_T_Manual());
			d.setIa_Kilometraje(formato.getIa_Kilometraje());
			d.setIa_Combustible(formato.getIa_Combustible());
			d.setIa_Des_Auto(formato.getIa_Des_Auto());
			d.setIa_Vida_Llantas(formato.getIa_Vida_Llantas());
			d.setIa_Observacion(formato.getIa_Observacion());
			d.setIa_Nom_Operador(formato.getIa_Nom_Operador());
			d.setEmail_Default(formato.getEmail_Default());
			d.setIa_Nom_Asegurado(formato.getIa_Nom_Asegurado());
			d.setIa_Inventario_1(formato.getIa_Inventario_1());
			d.setIa_Inventario_2(formato.getIa_Inventario_2());
			d.setIa_Inventario_3(formato.getIa_Inventario_3());
			d.setIa_Inventario_4(formato.getIa_Inventario_4());
			d.setIa_Inventario_5(formato.getIa_Inventario_5());
			d.setIa_Num_Inciso(formato.getIa_Num_Inciso());
			d.setIa_Nom_Ajustador(formato.getIa_Nom_Ajustador());
			d.setIa_Clave_Ajustador(formato.getIa_Clave_Ajustador());
			d.setIa_Objetos_Per(formato.getIa_Objetos_Per());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setFirma_Oper_Recibe(formato.getFirma_Oper_Recibe());
			d.setFirma_Ajus_Recibe(formato.getFirma_Ajus_Recibe());
			d.setNiu(formato.getNiu());
			d.setIaCorreoGrua(formato.getIa_correo_grua());
			d.setIaCorreoTaller(formato.getIa_correo_taller());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getIa_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fia.InsertarFormatoInventarioAutomoviles(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getIa_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIa_Num_Reporte(),
					 "FormatoInventarioAutomoviles", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInventarioAutomoviles(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorInventarioAutomoviles(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);

		} catch (javax.persistence.PersistenceException se) {
			this.utileriaExcepcion.manejarExcepcion(se, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInventarioAutomoviles");
			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getIa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIa_Num_Reporte(),
						 "FormatoInventarioAutomoviles", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInventarioAutomoviles(formato)) + "Excepcion: " + se.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInventarioAutomoviles");
			}

			if (se.getMessage().contains("Error Code: 6502")) {
				return new GETMovilResultadoOperacion(false, "Se espera un dato numerico en: NIU");
			}

			return new GETMovilResultadoOperacion(false, se.getMessage());
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInventarioAutomoviles");
			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getIa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIa_Num_Reporte(),
						 "FormatoInventarioAutomoviles", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInventarioAutomoviles(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInventarioAutomoviles");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}
	}

	public GETMovilResultadoOperacion InsertarFIP(FormatoInspeccionPesado formato) throws SQLException {
		try {
			DatosInsertarFormatoInspeccionPesado d = new DatosInsertarFormatoInspeccionPesado();
			d.setIp_Solicitante(formato.getIp_Solicitante());
			d.setIp_Oficina(formato.getIp_Oficina());
			d.setIp_Telefono(formato.getIp_Telefono());
			d.setIp_Fecha(formato.getIp_Fecha());
			d.setIp_Atencion(formato.getIp_Atencion());
			d.setIp_Dia_hora(formato.getIp_Dia_hora());
			d.setIp_Ubicacion(formato.getIp_Ubicacion());
			d.setIp_Email(formato.getIp_Email());
			d.setIp_Tipo(formato.getIp_Tipo());
			d.setIp_Modelo(formato.getIp_Modelo());
			d.setIp_Placas(formato.getIp_Placas());
			d.setIp_Puertas_D(formato.getIp_Puertas_D());
			d.setIp_Estandar_T(formato.getIp_Estandar_T());
			d.setIp_Color(formato.getIp_Color());
			d.setIp_Num_Serie(formato.getIp_Num_Serie());
			d.setIp_Kilometraje(formato.getIp_Kilometraje());
			d.setIp_Observaciones(formato.getIp_Observaciones());
			d.setIp_Procedencia(formato.getIp_Procedencia());
			d.setIp_Salvamentos(formato.getIp_Salvamentos());
			d.setIp_Total_Fotos(formato.getIp_Total_Fotos());
			d.setIp_Fecha_Inspeccion(formato.getIp_Fecha_Inspeccion());
			d.setIp_Tipo_Encargado(formato.getIp_Tipo_Encargado());
			d.setIp_Nom_Cliente(formato.getIp_Nom_Cliente());
			d.setIp_Nom_Ajustador(formato.getIp_Nom_Ajustador());
			d.setIp_Circulacion(formato.getIp_Circulacion());
			d.setIp_Importacion_1(formato.getIp_Importacion_1());
			d.setIp_T_Circulacion_1(formato.getIp_T_Circulacion_1());
			d.setIp_T_Circulacion_2(formato.getIp_T_Circulacion_2());
			d.setIp_Importacion_2(formato.getIp_Importacion_2());
			d.setIp_Calificacion(formato.getIp_Calificacion());
			d.setIp_Pago(formato.getIp_Pago());
			d.setIp_Equipo(formato.getIp_Equipo());
			d.setIp_Adaptaciones(formato.getIp_Adaptaciones());
			d.setIp_Pago_Si_No(formato.getIp_Pago_Si_No());
			d.setIp_Equipo_Si_No(formato.getIp_Equipo_Si_No());
			d.setIp_Adaptaciones_Si_No(formato.getIp_Adaptaciones_Si_No());
			d.setIp_Documentacion_1(formato.getIp_Documentacion_1());
			d.setIp_Documentacion_2(formato.getIp_Documentacion_2());
			d.setIp_Asegurado_Compa(formato.getIp_Asegurado_Compa());
			d.setIp_Num_Poliza(formato.getIp_Num_Poliza());
			d.setIp_Compania(formato.getIp_Compania());
			d.setIp_Clave_Ajustador(formato.getIp_Clave_Ajustador());
			d.setIp_Asegurado(formato.getIp_Asegurado());
			d.setIp_Num_Reporte(formato.getIp_Num_Reporte());
			d.setIp_Num_Siniestro(formato.getIp_Num_Siniestro());
			d.setIp_Num_Inciso(formato.getIp_Num_Inciso());
			d.setIp_Marca(formato.getIp_Marca());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Cliente(formato.getFirma_Cliente());
			d.setFirma_Agente(formato.getFirma_Agente());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getIp_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fip.InsertarFormatoInspeccionPesado(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getIp_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIp_Num_Reporte(),
					 "FormatoInspeccionPesado", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInspeccionPesado(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorInspecciónPesado(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInspeccionPesado");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getIp_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIp_Num_Reporte(),
						 "FormatoInspeccionPesado", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInspeccionPesado(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInspeccionPesado");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFIM(FormatoInspeccionMoto formato) throws SQLException {
		try {
			DatosInsertarFormatoInspeccionMoto d = new DatosInsertarFormatoInspeccionMoto();
			d.setIm_Solicitante(formato.getIm_Solicitante());
			d.setIm_Oficina(formato.getIm_Oficina());
			d.setIm_Telefono(formato.getIm_Telefono());
			d.setIm_Fecha(formato.getIm_Fecha());
			d.setIm_Atencion(formato.getIm_Atencion());
			d.setIm_Dia_Hora(formato.getIm_Dia_Hora());
			d.setIm_Ubicacion(formato.getIm_Ubicacion());
			d.setIm_Email(formato.getIm_Email());
			d.setIm_Marca(formato.getIm_Marca());
			d.setIm_Tipo(formato.getIm_Tipo());
			d.setIm_Modelo(formato.getIm_Modelo());
			d.setIm_Placas(formato.getIm_Placas());
			d.setIm_Estandar_T(formato.getIm_Estandar_T());
			d.setIm_Color(formato.getIm_Color());
			d.setIm_Num_Serie(formato.getIm_Num_Serie());
			d.setIm_Kilometraje(formato.getIm_Kilometraje());
			d.setIm_Observaciones(formato.getIm_Observaciones());
			d.setIm_Procedencia(formato.getIm_Procedencia());
			d.setIm_Total_Fotos(formato.getIm_Total_Fotos());
			d.setIm_Fecha_Inspeccion(formato.getIm_Fecha_Inspeccion());
			d.setIm_Tipo_Encargado(formato.getIm_Tipo_Encargado());
			d.setIm_Nom_Cliente(formato.getIm_Nom_Cliente());
			d.setIm_Nom_Ajustador(formato.getIm_Nom_Ajustador());
			d.setIm_Circulacion(formato.getIm_Circulacion());
			d.setIm_Importacion_1(formato.getIm_Importacion_1());
			d.setIm_T_Circulacion_1(formato.getIm_T_Circulacion_1());
			d.setIm_Pago(formato.getIm_Pago());
			d.setIm_Adaptaciones(formato.getIm_Adaptaciones());
			d.setIm_Pago_Si_No(formato.getIm_Pago_Si_No());
			d.setIm_Equipo_Si_No(formato.getIm_Equipo_Si_No());
			d.setIm_Adaptaciones_Si_No(formato.getIm_Adaptaciones_Si_No());
			d.setIm_Documentacion_1(formato.getIm_Documentacion_1());
			d.setIm_Documentacion_2(formato.getIm_Documentacion_2());
			d.setIm_Asegurado_Compa(formato.getIm_Asegurado_Compa());
			d.setIm_Num_Poliza(formato.getIm_Num_Poliza());
			d.setIm_Compania(formato.getIm_Compania());
			d.setIm_Clave_Ajustador(formato.getIm_Clave_Ajustador());
			d.setIm_Asegurado(formato.getIm_Asegurado());
			d.setIm_Num_Reporte(formato.getIm_Num_Reporte());
			d.setIm_Num_Inciso(formato.getIm_Num_Inciso());
			d.setIm_Num_Siniestro(formato.getIm_Num_Siniestro());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Cliente(formato.getFirma_Cliente());
			d.setFirma_Agente(formato.getFirma_Agente());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getIm_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado;
			resultado = fim.InsertarFormatoInspeccionMoto(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getIm_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIm_Num_Reporte(),
					 "FormatoInspeccionMoto", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInspeccionMoto(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorInspeccionMotocicletas(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInspeccionMoto");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getIm_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getIm_Num_Reporte(),
						 "FormatoInspeccionMoto", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInspeccionMoto(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInspeccionMoto");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFAAuto(FormatoAdmisionAutomoviles formato) throws SQLException {
		try {
			DatosInsertarFormatoAdmisionAutomoviles d = new DatosInsertarFormatoAdmisionAutomoviles();
			d.setOa_Folio_Electro(formato.getOa_Folio_Electro());
			d.setOa_Num_Reporte(formato.getOa_Num_Reporte());
			d.setOa_Num_Siniestro(formato.getOa_Num_Siniestro());
			d.setOa_Asegurado(formato.getOa_Asegurado());
			d.setOa_Fecha(formato.getOa_Fecha());
			d.setOa_Num_Poliza(formato.getOa_Num_Poliza());
			d.setOa_Num_Endoso(formato.getOa_Num_Endoso());
			d.setOa_Num_Inciso(formato.getOa_Num_Inciso());
			d.setOa_Nom_Cliente(formato.getOa_Nom_Cliente());
			d.setOa_Email_Cliente(formato.getOa_Email_Cliente());
			d.setOa_Tel_Cliente(formato.getOa_Tel_Cliente());
			d.setOa_Razon_Envio(formato.getOa_Razon_Envio());
			d.setOa_Razon_Responsable(formato.getOa_Razon_Responsable());
			d.setOa_Razon_Telefono(formato.getOa_Razon_Telefono());
			d.setOa_Razon_Domicilio(formato.getOa_Razon_Domicilio());
			d.setOa_Razon_Cobertura(formato.getOa_Razon_Cobertura());
			d.setOa_Marca_Auto(formato.getOa_Marca_Auto());
			d.setOa_Tipo_Auto(formato.getOa_Tipo_Auto());
			d.setOa_Kilometraje(formato.getOa_Kilometraje());
			d.setOa_Num_Serie(formato.getOa_Num_Serie());
			d.setOa_Color_Auto(formato.getOa_Color_Auto());
			d.setOa_Placa_Auto(formato.getOa_Placa_Auto());
			d.setOa_T_Manual(formato.getOa_T_Manual());
			d.setOa_Deducible(formato.getOa_Deducible());
			d.setOa_Tipo_Deducible(formato.getOa_Tipo_Deducible());
			d.setOa_Admin_Deducible(formato.getOa_Admin_Deducible());
			d.setOa_Suma_Asegurada(formato.getOa_Suma_Asegurada());
			d.setOa_Porcentaje_Ded(formato.getOa_Porcentaje_Ded());
			d.setOa_Cantidad(formato.getOa_Cantidad());
			d.setOa_Desc_Danios(formato.getOa_Desc_Danios());
			d.setOa_Nivel_Inundacion(formato.getOa_Nivel_Inundacion());
			d.setOa_Perdida_Total(formato.getOa_Perdida_Total());
			d.setOa_Danios_Pre(formato.getOa_Danios_Pre());
			d.setOa_Nom_Ajustador(formato.getOa_Nom_Ajustador());
			d.setOa_Clave_Ajustador(formato.getOa_Clave_Ajustador());
			d.setOa_Modelo_Auto(formato.getOa_Modelo_Auto());
			d.setOa_Agravamiento(formato.getOa_Agravamiento());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setNiu(formato.getNiu());
			d.setOa_carril_expres(formato.getOa_carril_expres());
			d.setOa_Danio_Menor(formato.getOa_Danio_Menor());
			d.setOa_producto_esencial(formato.getOa_producto_esencial());
			d.setOa_codigo_qr(formato.getOa_codigo_qr());
			d.setOa_pt_evidente(formato.getOa_pt_evidente());
			d.setOa_abandono(formato.getOa_abandono());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getOa_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}
			
			String resultado = null;

			resultado = faauto.InsertarFormatoAdmisionAutomoviles(d);
			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getOa_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOa_Num_Reporte(),
					 "FormatoAdmisionAutomoviles", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionAutomoviles(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------

			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorAdmisionAuto(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}
			}
			if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);
		} catch (javax.persistence.PersistenceException se) {
			this.utileriaExcepcion.manejarExcepcion(se, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisionAutomoviles");
			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getOa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOa_Num_Reporte(),
						 "FormatoAdmisionAutomoviles", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionAutomoviles(formato)) + "Excepcion: " + se.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisionAutomoviles");
			}

			if (se.getMessage().contains("Error Code: 6502")) {
				return new GETMovilResultadoOperacion(false, "Se espera un dato numerico en: NIU");
			}

			return new GETMovilResultadoOperacion(false, se.getMessage());
		}

		catch (Exception ex) {

			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisionAutomoviles");
			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getOa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOa_Num_Reporte(),
						 "FormatoAdmisionAutomoviles", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionAutomoviles(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisionAutomoviles");
			}
			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFAM(FormatoAdmisionMotocicletas formato) throws SQLException {
		try {
			DatosInsertarFormatoAdmisionMotocicletas d = new DatosInsertarFormatoAdmisionMotocicletas();
			d.setOa_Folio_Electro(formato.getOa_Folio_Electro());
			d.setOa_Num_Reporte(formato.getOa_Num_Reporte());
			d.setOa_Num_Siniestro(formato.getOa_Num_Siniestro());
			d.setOa_Asegurado(formato.getOa_Asegurado());
			d.setOa_Fecha(formato.getOa_Fecha());
			d.setOa_Num_Poliza(formato.getOa_Num_Poliza());
			d.setOa_Num_Endoso(formato.getOa_Num_Endoso());
			d.setOa_Num_Inciso(formato.getOa_Num_Inciso());
			d.setOa_Nom_Cliente(formato.getOa_Nom_Cliente());
			d.setOa_Email_Cliente(formato.getOa_Email_Cliente());
			d.setOa_Tel_Cliente(formato.getOa_Tel_Cliente());
			d.setOa_Razon_Envio(formato.getOa_Razon_Envio());
			d.setOa_Razon_Responsable(formato.getOa_Razon_Responsable());
			d.setOa_Razon_Telefono(formato.getOa_Razon_Telefono());
			d.setOa_Razon_Domicilio(formato.getOa_Razon_Domicilio());
			d.setOa_Razon_Cobertura(formato.getOa_Razon_Cobertura());
			d.setOa_Marca_Auto(formato.getOa_Marca_Auto());
			d.setOa_Tipo_Auto(formato.getOa_Tipo_Auto());
			d.setOa_Kilometraje(formato.getOa_Kilometraje());
			d.setOa_Num_Serie(formato.getOa_Num_Serie());
			d.setOa_Color_Auto(formato.getOa_Color_Auto());
			d.setOa_Placa_Auto(formato.getOa_Placa_Auto());
			d.setOa_T_Manual(formato.getOa_T_Manual());
			d.setOa_Deducible(formato.getOa_Deducible());
			d.setOa_Tipo_Deducible(formato.getOa_Tipo_Deducible());
			d.setOa_Admin_Deducible(formato.getOa_Admin_Deducible());
			d.setOa_Suma_Asegurada(formato.getOa_Suma_Asegurada());
			d.setOa_Porcentaje_Ded(formato.getOa_Porcentaje_Ded());
			d.setOa_Cantidad(formato.getOa_Cantidad());
			d.setOa_Desc_Danios(formato.getOa_Desc_Danios());
			d.setOa_Nivel_Inundacion(formato.getOa_Nivel_Inundacion());
			d.setOa_Perdida_Total(formato.getOa_Perdida_Total());
			d.setOa_Danios_Pre(formato.getOa_Danios_Pre());
			d.setOa_Nom_Ajustador(formato.getOa_Nom_Ajustador());
			d.setOa_Clave_Ajustador(formato.getOa_Clave_Ajustador());
			d.setOa_Modelo_Auto(formato.getOa_Modelo_Auto());
			d.setOa_Agravamiento(formato.getOa_Agravamiento());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setOa_codigo_qr(formato.getOa_codigo_qr());
			d.setOa_pt_evidente(formato.getOa_pt_evidente());
			d.setOa_abandono(formato.getOa_abandono());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getOa_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fam.InsertarFormatoAdmisionMotocicletas(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getOa_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOa_Num_Reporte(),
					 "FormatoAdmisionMotocicletas", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionMotocicletas(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorAdmisionMotocicleta(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisiónMotocicletas");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getOa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOa_Num_Reporte(),
						 "FormatoAdmisionMotocicletas", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionMotocicletas(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisiónMotocicletas");
				;
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFAP(FormatoAdmisionPesado formato) throws SQLException {
		try {
			DatosInsertarFormatoAdmisionPesado d = new DatosInsertarFormatoAdmisionPesado();
			String resultado = null;
			d.setOp_Folio_Electro(formato.getOp_Folio_Electro());
			d.setOp_Num_Reporte(formato.getOp_Num_Reporte());
			d.setOp_Num_Siniestro(formato.getOp_Num_Siniestro());
			d.setOp_Num_Poliza(formato.getOp_Num_Poliza());
			d.setOp_Num_Inciso(formato.getOp_Num_Inciso());
			d.setOp_Num_Endoso(formato.getOp_Num_Endoso());
			d.setOp_Vigencia(formato.getOp_Vigencia());
			d.setOp_Nom_Asegurado(formato.getOp_Nom_Asegurado());
			d.setOp_Tel_Asegurado(formato.getOp_Tel_Asegurado());
			d.setOp_Conductor_Ase(formato.getOp_Conductor_Ase());
			d.setOp_Tel_Con_Ase(formato.getOp_Tel_Con_Ase());
			d.setOp_Marca_Auto_Ase(formato.getOp_Marca_Auto_Ase());
			d.setOp_Tipo_Auto_Ase(formato.getOp_Tipo_Auto_Ase());
			d.setOp_Color_Auto_Ase(formato.getOp_Color_Auto_Ase());
			d.setOp_Placas_Auto_Ase(formato.getOp_Placas_Auto_Ase());
			d.setOp_Motor_Auto_Ase(formato.getOp_Motor_Auto_Ase());
			d.setOp_Serie_Auto_Ase(formato.getOp_Serie_Auto_Ase());
			d.setOp_Suma_Asegurado(formato.getOp_Suma_Asegurado());
			d.setOp_Nom_Afe(formato.getOp_Nom_Afe());
			d.setOp_Tel_Afe(formato.getOp_Tel_Afe());
			d.setOp_Conductor_Afe(formato.getOp_Conductor_Afe());
			d.setOp_Tel_Con_Afe(formato.getOp_Tel_Con_Afe());
			d.setOp_Marca_Auto_Afe(formato.getOp_Marca_Auto_Afe());
			d.setOp_Tipo_Auto_Afe(formato.getOp_Tipo_Auto_Afe());
			d.setOp_Color_Auto_Afe(formato.getOp_Color_Auto_Afe());
			d.setOp_Placas_Auto_Afe(formato.getOp_Placas_Auto_Afe());
			d.setOp_Motor_Auto_Afe(formato.getOp_Motor_Auto_Afe());
			d.setOp_Serie_Auto_Afe(formato.getOp_Serie_Auto_Afe());
			d.setOp_Deducible(formato.getOp_Deducible());
			d.setOp_Tipo_Deducible(formato.getOp_Tipo_Deducible());
			d.setOp_Ded_Admin(formato.getOp_Ded_Admin());
			d.setOp_Definicion(formato.getOp_Definicion());
			d.setOp_Cantidad(formato.getOp_Cantidad());
			d.setOp_Ded_Dias(formato.getOp_Ded_Dias());
			d.setOp_Danios_Camion(formato.getOp_Danios_Camion());
			d.setOp_Danios_Caja(formato.getOp_Danios_Caja());
			d.setOp_Danios_Tanque(formato.getOp_Danios_Tanque());
			d.setOp_Nom_Taller(formato.getOp_Nom_Taller());
			d.setOp_Tel_Taller(formato.getOp_Tel_Taller());
			d.setOp_Dir_Taller(formato.getOp_Dir_Taller());
			d.setOp_Atencion_Taller(formato.getOp_Atencion_Taller());
			d.setOp_Siniestro_Camion(formato.getOp_Siniestro_Camion());
			d.setOp_Siniestro_Caja(formato.getOp_Siniestro_Caja());
			d.setOp_Siniestro_Tanque(formato.getOp_Siniestro_Tanque());
			d.setOp_Nom_Ajustador(formato.getOp_Nom_Ajustador());
			d.setEmail_Default(formato.getEmail_Default());
			d.setOp_Asegurado(formato.getOp_Asegurado());
			d.setOp_Modelo_Ase(formato.getOp_Modelo_Ase());
			d.setOp_Modelo_Ter(formato.getOp_Modelo_Ter());
			d.setOf_Fecha(formato.getOf_Fecha());
			d.setOp_Clave_Ajustador(formato.getOp_Clave_Ajustador());
			d.setOp_Email_Tercero(formato.getOp_Email_Tercero());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setNiu(formato.getNiu());
			d.setOp_codigo_qr(formato.getOp_codigo_qr());
			d.setOp_pt_evidente(formato.getOp_pt_evidente());
			d.setOp_abandono(formato.getOp_abandono());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			
			if(formato.getOp_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			resultado = fap.InsertarFormatoAdmisionPesado(d);
			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getOp_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOp_Num_Reporte(),
					 "FormatoAdmisionPesado", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionPesado(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorAdmisionPesado(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);
		} catch (javax.persistence.PersistenceException se) {
			this.utileriaExcepcion.manejarExcepcion(se, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisionPesado");
			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getOp_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOp_Num_Reporte(),
						 "FormatoAdmisionPesado", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionPesado(formato)) + "Excepcion: " + se.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisionPesado");
			}

			if (se.getMessage().contains("Error Code: 6502")) {
				return new GETMovilResultadoOperacion(false, "Se espera un dato numerico en: NIU");
			}

			return new GETMovilResultadoOperacion(false, se.getMessage());
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisiónPesado");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getOp_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getOp_Num_Reporte(),
						 "FormatoAdmisionPesado", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAdmisionPesado(formato)) + " Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAdmisiónPesado");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}
	}

	public GETMovilResultadoOperacion InsertarFAABOGADO(FormatoAsignacionAbogado formato) throws SQLException {
		try {
			DatosInsertarFormatoAsignacionAbogado d = new DatosInsertarFormatoAsignacionAbogado();
			String resultado = null;

			d.setAa_Pregunta_1a(formato.getAa_Pregunta_1a());
			d.setAa_Pregunta_2(formato.getAa_Pregunta_2());
			d.setAa_Pregunta_3(formato.getAa_Pregunta_3());
			d.setAa_Pregunta_4(formato.getAa_Pregunta_4());
			d.setAa_Pregunta_5(formato.getAa_Pregunta_5());
			d.setAa_Pregunta_6(formato.getAa_Pregunta_6());
			d.setAa_Hora_Siniestro(formato.getAa_Hora_Siniestro());
			d.setAa_Hora_Turnado(formato.getAa_Hora_Turnado());
			d.setAa_Hora_Abogado(formato.getAa_Hora_Abogado());
			d.setAa_Num_Siniestro(formato.getAa_Num_Siniestro());
			d.setAa_Num_Reporte(formato.getAa_Num_Reporte());
			d.setAa_Num_Poliza(formato.getAa_Num_Poliza());
			d.setAa_Marca_Auto(formato.getAa_Marca_Auto());
			d.setAa_Tipo_Auto(formato.getAa_Tipo_Auto());
			d.setAa_Color_Auto(formato.getAa_Color_Auto());
			d.setAa_Placa_Auto(formato.getAa_Placa_Auto());
			d.setAa_Danios_Na(formato.getAa_Danios_Na());
			d.setAa_Monto_Crucero(formato.getAa_Monto_Crucero());
			d.setAa_Monto_Deducible(formato.getAa_Monto_Deducible());
			d.setAa_Deducible_Rc(formato.getAa_Deducible_Rc());
			d.setAa_Pagado(formato.getAa_Pagado());
			d.setAa_Nom_Asegurado(formato.getAa_Nom_Asegurado());
			d.setAa_Nom_Conductor(formato.getAa_Nom_Conductor());
			d.setAa_Propietario(formato.getAa_Propietario());
			d.setAa_Tel_Oficina(formato.getAa_Tel_Oficina());
			d.setAa_Ubicacion_Actual(formato.getAa_Ubicacion_Actual());
			d.setAa_Descripcion_Danios(formato.getAa_Descripcion_Danios());
			d.setAa_Tel_Casa(formato.getAa_Tel_Casa());
			d.setAa_Email(formato.getAa_Email());
			d.setAa_Lugar_Siniestro(formato.getAa_Lugar_Siniestro());
			d.setAa_Autoridad(formato.getAa_Autoridad());
			d.setAa_Num_Accidente(formato.getAa_Num_Accidente());
			d.setAa_Grua(formato.getAa_Grua());
			d.setAa_Nom_Tercero(formato.getAa_Nom_Tercero());
			d.setAa_Tel_Casa_Tercero(formato.getAa_Tel_Casa_Tercero());
			d.setAa_Tel_Oficina_Tercero(formato.getAa_Tel_Oficina_Tercero());
			d.setAa_Danios_Estimados(formato.getAa_Danios_Estimados());
			d.setAa_Comentarios(formato.getAa_Comentarios());
			d.setAa_Des_Danios_Ter(formato.getAa_Des_Danios_Ter());
			d.setAa_Nom_Lesionados(formato.getAa_Nom_Lesionados());
			d.setAa_Informe(formato.getAa_Informe());
			d.setAa_Otros(formato.getAa_Otros());
			d.setAa_Grua_Tercero(formato.getAa_Grua_Tercero());
			d.setAa_Declaracion_Conduc(formato.getAa_Declaracion_Conduc());
			d.setAa_Parte_Acciden(formato.getAa_Parte_Acciden());
			d.setAa_Copia_Poliza(formato.getAa_Copia_Poliza());
			d.setAa_Presu_Asegurado(formato.getAa_Presu_Asegurado());
			d.setAa_Copia_Licencia(formato.getAa_Copia_Licencia());
			d.setAa_Orden_Admision(formato.getAa_Orden_Admision());
			d.setAa_Pase_Medico(formato.getAa_Pase_Medico());
			d.setAa_Clave_Ajustador(formato.getAa_Clave_Ajustador());
			d.setAa_Nom_Ajustador(formato.getAa_Nom_Ajustador());
			d.setAa_Clave_Abogado(formato.getAa_Clave_Abogado());
			d.setAa_Nom_Abogado(formato.getAa_Nom_Abogado());
			d.setAa_Num_Inciso(formato.getAa_Num_Inciso());
			d.setAa_Asegurado(formato.getAa_Asegurado());
			d.setAa_Pregunta_1b(formato.getAa_Pregunta_1b());
			d.setAa_Pregunta_1(formato.getAa_Pregunta_1());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Abogado(formato.getFirma_Abogado());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setAa_Pregunta_7a(formato.getAa_Pregunta_7a());
			d.setAa_Pregunta_7b(formato.getAa_Pregunta_7b());
			d.setFirma_tercero(formato.getFirma_tercero());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getAa_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			resultado = faabogado.InsertarFormatoAsignacionAbogado(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getAa_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getAa_Num_Reporte(),
					 "FormatoAsignacionAbogado", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAsignacionAbogado(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorAsignacionAbogado(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);

		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAsignaciónAbogado");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getAa_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getAa_Num_Reporte(),
						 "FormatoAsignacionAbogado", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoAsignacionAbogado(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAsignaciónAbogado");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());

		}

	}

	public GETMovilResultadoOperacion InsertarFCR(FormatoCuestionarioRobo formato) throws SQLException {
		try {
			DatosInsertarFormatoCuestionarioRobo d = new DatosInsertarFormatoCuestionarioRobo();
			d.setCr_Num_Reporte(formato.getCr_Num_Reporte());
			d.setCr_Num_Poliza(formato.getCr_Num_Poliza());
			d.setCr_Num_Siniestro(formato.getCr_Num_Siniestro());
			d.setCr_Inc_Asegurado(formato.getCr_Inc_Asegurado());
			d.setCr_Estacionado(formato.getCr_Estacionado());
			d.setCr_Pregunta_1(formato.getCr_Pregunta_1());
			d.setCr_Pregunta_2(formato.getCr_Pregunta_2());
			d.setCr_Bool_2(formato.getCr_Bool_2());
			d.setCr_Pregunta_3(formato.getCr_Pregunta_3());
			d.setCr_Bool_3(formato.getCr_Bool_3());
			d.setCr_Pregunta_4(formato.getCr_Pregunta_4());
			d.setCr_Pregunta_5(formato.getCr_Pregunta_5());
			d.setCr_Bool_5(formato.getCr_Bool_5());
			d.setCr_Pregunta_6(formato.getCr_Pregunta_6());
			d.setCr_Pregunta_7(formato.getCr_Pregunta_7());
			d.setCr_Pregunta_8_1(formato.getCr_Pregunta_8_1());
			d.setCr_Pregunta_8_2(formato.getCr_Pregunta_8_2());
			d.setCr_Pregunta_8_3(formato.getCr_Pregunta_8_3());
			d.setCr_Bool_8(formato.getCr_Bool_8());
			d.setCr_Pregunta_9(formato.getCr_Pregunta_9());
			d.setCr_Bool_9(formato.getCr_Bool_9());
			d.setCr_Pregunta_10_1(formato.getCr_Pregunta_10_1());
			d.setCr_Pregunta_10_2(formato.getCr_Pregunta_10_2());
			d.setCr_Pregunta_11(formato.getCr_Pregunta_11());
			d.setCr_Bool_11(formato.getCr_Bool_11());
			d.setCr_Pregunta_12(formato.getCr_Pregunta_12());
			d.setCr_Bool_12(formato.getCr_Bool_12());
			d.setCr_Pregunta_13(formato.getCr_Pregunta_13());
			d.setCr_Bool_13(formato.getCr_Bool_13());
			d.setCr_Pregunta_14(formato.getCr_Pregunta_14());
			d.setCr_Bool_14(formato.getCr_Bool_14());
			d.setCr_Pregunta_15(formato.getCr_Pregunta_15());
			d.setCr_Bool_15(formato.getCr_Bool_15());
			d.setCr_O16_Particular(formato.getCr_O16_Particular());
			d.setCr_O16_Publico(formato.getCr_O16_Publico());
			d.setCr_O16_Carga(formato.getCr_O16_Carga());
			d.setCr_O16_Enseñanza(formato.getCr_O16_Enseñanza());
			d.setCr_O16_Otros(formato.getCr_O16_Otros());
			d.setCr_Otros(formato.getCr_Otros());
			d.setCr_Pregunta_17(formato.getCr_Pregunta_17());
			d.setCr_Pregunta_18(formato.getCr_Pregunta_18());
			d.setCr_Pregunta_19(formato.getCr_Pregunta_19());
			d.setCr_Bool_19(formato.getCr_Bool_19());
			d.setCr_Bool_20(formato.getCr_Bool_20());
			d.setCr_Pregunta_21(formato.getCr_Pregunta_21());
			d.setCr_Pregunta_22(formato.getCr_Pregunta_22());
			d.setCr_Pregunta_23(formato.getCr_Pregunta_23());
			d.setCr_Pregunta_24(formato.getCr_Pregunta_24());
			d.setCr_Pregunta_25(formato.getCr_Pregunta_25());
			d.setCr_Pregunta_26(formato.getCr_Pregunta_26());
			d.setCr_Bool_26(formato.getCr_Bool_26());
			d.setCr_Pregunta_27(formato.getCr_Pregunta_27());
			d.setCr_Bool_27(formato.getCr_Bool_27());
			d.setCr_Pregunta_28_1(formato.getCr_Pregunta_28_1());
			d.setCr_Pregunta_28_2(formato.getCr_Pregunta_28_2());
			d.setCr_Pregunta_28_3(formato.getCr_Pregunta_28_3());
			d.setCr_Bool_28(formato.getCr_Bool_28());
			d.setCr_Pregunta_29(formato.getCr_Pregunta_29());
			d.setCr_Bool_29(formato.getCr_Bool_29());
			d.setCr_Pregunta_30(formato.getCr_Pregunta_30());
			d.setCr_Bool_30(formato.getCr_Bool_30());
			d.setCr_Pregunta_31(formato.getCr_Pregunta_31());
			d.setCr_Bool_31(formato.getCr_Bool_31());
			d.setCr_Pregunta_32(formato.getCr_Pregunta_32());
			d.setCr_Nom_Asegurado(formato.getCr_Nom_Asegurado());
			d.setCr_Dir_Asegurado(formato.getCr_Dir_Asegurado());
			d.setCr_Tel_Casa_Asegurado(formato.getCr_Tel_Casa_Asegurado());
			d.setCr_Tel_Ofi_Asegurado(formato.getCr_Tel_Ofi_Asegurado());
			d.setCr_Tel_Celular_Asegurado(formato.getCr_Tel_Celular_Asegurado());
			d.setCr_Ocu_Asegurado(formato.getCr_Ocu_Asegurado());
			d.setCr_Email_Asegurado(formato.getCr_Email_Asegurado());
			d.setCr_Hora(formato.getCr_Hora());
			d.setCr_Num_Inciso(formato.getCr_Num_Inciso());
			d.setCr_Clave_Ajustador(formato.getCr_Clave_Ajustador());
			d.setCr_Asegurado(formato.getCr_Asegurado());
			d.setCr_Num_Endoso(formato.getCr_Num_Endoso());
			d.setCr_O16_Emergencia(formato.getCr_O16_Emergencia());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getCr_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}


			String resultado = null;

			resultado = fcr.InsertarFormatoCuestionarioRobo(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getCr_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getCr_Num_Reporte(),
					 "FormatoCuestionarioRobo", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoCuestionarioRobo(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorCuestionarioRobo(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------
			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoCuestionarioRobo");
			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getCr_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getCr_Num_Reporte(),
						 "FormatoCuestionarioRobo", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoCuestionarioRobo(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoCuestionarioRobo");
			}

			return new GETMovilResultadoOperacion(true, ex.getMessage());
		}

	}

	public GETMovilResultadoOperacion InsertarFDU(FormatoDeclaracionUniversal formato) throws SQLException {
		String resultado = null;
		try {

			DatosInsertarFormatoDeclaracionUniversal d = new DatosInsertarFormatoDeclaracionUniversal();

			d.setDu_Fecha_Ocurrido(formato.getDu_Fecha_Ocurrido());
			d.setDu_Fecha_Atencion(formato.getDu_Fecha_Atencion());
			d.setDu_Lugar(formato.getDu_Lugar());
			d.setDu_Nom_Cia(formato.getDu_Nom_Cia());
			d.setDu_Num_Poliza(formato.getDu_Num_Poliza());
			d.setDu_Inc(formato.getDu_Inc());
			d.setDu_Num_Siniestro(formato.getDu_Num_Siniestro());
			d.setDu_Num_Reporte(formato.getDu_Num_Reporte());
			d.setDu_Vigencia_De(formato.getDu_Vigencia_De());
			d.setDu_Vigencia_Al(formato.getDu_Vigencia_Al());
			d.setDu_Cobertura(formato.getDu_Cobertura());
			d.setDu_Cobranza(formato.getDu_Cobranza());
			d.setDu_Nom_Asegurado(formato.getDu_Nom_Asegurado());
			d.setDu_Tel_Asegurado(formato.getDu_Tel_Asegurado());
			d.setDu_Nom_Conductor(formato.getDu_Nom_Conductor());
			d.setDu_Edad_Conductor(formato.getDu_Edad_Conductor());
			d.setDu_Tel_Conductor(formato.getDu_Tel_Conductor());
			d.setDu_Dir_Conductor(formato.getDu_Dir_Conductor());
			d.setDu_Email_Conductor(formato.getDu_Email_Conductor());
			d.setDu_Licencia_Num(formato.getDu_Licencia_Num());
			d.setDu_Licencia_Estado(formato.getDu_Licencia_Estado());
			d.setDu_Tipo_Licencia(formato.getDu_Tipo_Licencia());
			d.setDu_Caducidad_Licencia(formato.getDu_Caducidad_Licencia());
			d.setDu_Marca_Auto(formato.getDu_Marca_Auto());
			d.setDu_Tipo_Auto(formato.getDu_Tipo_Auto());
			d.setDu_Color_Auto(formato.getDu_Color_Auto());
			d.setDu_Placas_Auto(formato.getDu_Placas_Auto());
			d.setDu_Serie(formato.getDu_Serie());
			d.setDu_Narracion(formato.getDu_Narracion());
			d.setDu_Arribo_Ajustador(formato.getDu_Arribo_Ajustador());
			d.setDu_Termino_Ajustador(formato.getDu_Termino_Ajustador());
			d.setDu_Danios_Apre(formato.getDu_Danios_Apre());
			d.setDu_Danios_Pre(formato.getDu_Danios_Pre());
			d.setDu_Fecha_Ocurrido_B(formato.getDu_Fecha_Ocurrido_B());
			d.setDu_Fecha_Atencion_B(formato.getDu_Fecha_Atencion_B());
			d.setDu_Lugar_B(formato.getDu_Lugar_B());
			d.setDu_Nom_Cia_B(formato.getDu_Nom_Cia_B());
			d.setDu_Num_Poliza_B(formato.getDu_Num_Poliza_B());
			d.setDu_Inc_B(formato.getDu_Inc_B());
			d.setDu_Num_Siniestro_B(formato.getDu_Num_Siniestro_B());
			d.setDu_Num_Reporte_B(formato.getDu_Num_Reporte_B());
			d.setDu_Vigencia_De_B(formato.getDu_Vigencia_De_B());
			d.setDu_Vigencia_Al_B(formato.getDu_Vigencia_Al_B());
			d.setDu_Cobertura_B(formato.getDu_Cobertura_B());
			d.setDu_Cobranza_B(formato.getDu_Cobranza_B());
			d.setDu_Nom_Asegurado_B(formato.getDu_Nom_Asegurado_B());
			d.setDu_Nom_Conductor_B(formato.getDu_Nom_Conductor_B());
			d.setDu_Edad_Conductor_B(formato.getDu_Edad_Conductor_B());
			d.setDu_Tel_Conductor_B(formato.getDu_Tel_Conductor_B());
			d.setDu_Dir_Conductor_B(formato.getDu_Dir_Conductor_B());
			d.setDu_Email_Conductor_B(formato.getDu_Email_Conductor_B());
			d.setDu_Licencia_Num_B(formato.getDu_Licencia_Num_B());
			d.setDu_Licencia_Estado_B(formato.getDu_Licencia_Estado_B());
			d.setDu_Tipo_Licencia_B(formato.getDu_Tipo_Licencia_B());
			d.setDu_Caducidad_Licencia_B(formato.getDu_Caducidad_Licencia_B());
			d.setDu_Marca_Auto_B(formato.getDu_Marca_Auto_B());
			d.setDu_Tipo_Auto_B(formato.getDu_Tipo_Auto_B());
			d.setDu_Color_Auto_B(formato.getDu_Color_Auto_B());
			d.setDu_Placas_Auto_B(formato.getDu_Placas_Auto_B());
			d.setDu_Serie_B(formato.getDu_Serie_B());
			d.setDu_Narracion_B(formato.getDu_Narracion_B());
			d.setDu_Arribo_Ajustador_B(formato.getDu_Arribo_Ajustador_B());
			d.setDu_Termino_Ajustador_B(formato.getDu_Termino_Ajustador_B());
			d.setDu_Danios_Apre_B(formato.getDu_Danios_Apre_B());
			d.setDu_Danios_Pre_B(formato.getDu_Danios_Pre_B());
			d.setDu_Tel_Asegurado_B(formato.getDu_Tel_Asegurado_B());
			d.setDu_Responsable_A(formato.getDu_Responsable_A());
			d.setDu_Sipac(formato.getDu_Sipac());
			d.setDu_En_Espera(formato.getDu_En_Espera());
			d.setDu_Nom_Ajustador(formato.getDu_Nom_Ajustador());
			d.setDu_Clave_Ajustador(formato.getDu_Clave_Ajustador());
			d.setDu_Nom_Ajustador_B(formato.getDu_Nom_Ajustador_B());
			d.setDu_Clave_Ajustador_B(formato.getDu_Clave_Ajustador_B());
			d.setDu_Ocupante_1(formato.getDu_Ocupante_1());
			d.setDu_Ocupante_2(formato.getDu_Ocupante_2());
			d.setDu_Ocupante_3(formato.getDu_Ocupante_3());
			d.setDu_Ocupante_4(formato.getDu_Ocupante_4());
			d.setDu_Ocupante_5(formato.getDu_Ocupante_5());
			d.setDu_Ocupante_1_B(formato.getDu_Ocupante_1_B());
			d.setDu_Ocupante_2_B(formato.getDu_Ocupante_2_B());
			d.setDu_Ocupante_3_B(formato.getDu_Ocupante_3_B());
			d.setDu_Ocupante_4_B(formato.getDu_Ocupante_4_B());
			d.setDu_Ocupante_5_B(formato.getDu_Ocupante_5_B());
			d.setDu_Volante_Admison(formato.getDu_Volante_Admison());
			d.setDu_Aplico_Deducible(formato.getDu_Aplico_Deducible());
			d.setDu_Hora_Grua(formato.getDu_Hora_Grua());
			d.setDu_Vehicuo_Corralon(formato.getDu_Vehicuo_Corralon());
			d.setDu_Hora_Ambulancia(formato.getDu_Hora_Ambulancia());
			d.setDu_Hora_Abogado(formato.getDu_Hora_Abogado());
			d.setDu_Tradicional_Ent(formato.getDu_Tradicional_Ent());
			d.setDu_Tradicional_Rec(formato.getDu_Tradicional_Rec());
			d.setDu_Sipac_Ent(formato.getDu_Sipac_Ent());
			d.setDu_Sipac_Rec(formato.getDu_Sipac_Rec());
			d.setDu_Otros(formato.getDu_Otros());
			d.setDu_Otros_Rec(formato.getDu_Otros_Rec());
			d.setDu_Otros_Ent(formato.getDu_Otros_Ent());
			d.setDu_Recuperacion(formato.getDu_Recuperacion());
			d.setDu_Autoridad(formato.getDu_Autoridad());
			d.setDu_Num_Acta(formato.getDu_Num_Acta());
			d.setDu_Num_Reporte_Aut(formato.getDu_Num_Reporte_Aut());
			d.setDu_Nom_Abogado(formato.getDu_Nom_Abogado());
			d.setDu_Danios_Materiales(formato.getDu_Danios_Materiales());
			d.setDu_Equipo_Especial(formato.getDu_Equipo_Especial());
			d.setDu_Robo_Total(formato.getDu_Robo_Total());
			d.setDu_Res_Bienes(formato.getDu_Res_Bienes());
			d.setDu_Res_Personas(formato.getDu_Res_Personas());
			d.setDu_Num_Personas(formato.getDu_Num_Personas());
			d.setDu_Gastos_Medicos(formato.getDu_Gastos_Medicos());
			d.setDu_Num_Ocupantes(formato.getDu_Num_Ocupantes());
			d.setDu_Gastos_Legales(formato.getDu_Gastos_Legales());
			d.setDu_Acci_Personales(formato.getDu_Acci_Personales());
			d.setDu_Num_Personales(formato.getDu_Num_Personales());
			d.setDu_Rc_Viajero(formato.getDu_Rc_Viajero());
			d.setDu_Num_Rc(formato.getDu_Num_Rc());
			d.setDu_Cristales(formato.getDu_Cristales());
			d.setDu_Otro(formato.getDu_Otro());
			d.setDu_Otro_Especificar(formato.getDu_Otro_Especificar());
			d.setDu_Nom_Supervisor(formato.getDu_Nom_Supervisor());
			d.setDu_Estado_Ajuste(formato.getDu_Estado_Ajuste());
			d.setDu_Condicionado_A(formato.getDu_Condicionado_A());
			d.setDu_Conclusiones(formato.getDu_Conclusiones());
			d.setDu_Informe_Adicional(formato.getDu_Informe_Adicional());
			d.setDu_Pregunta_1a(formato.getDu_Pregunta_1a());
			d.setDu_Pregunta_2a(formato.getDu_Pregunta_2a());
			d.setDu_Pregunta_3a(formato.getDu_Pregunta_3a());
			d.setDu_Pregunta_4a(formato.getDu_Pregunta_4a());
			d.setDu_Pregunta_5a(formato.getDu_Pregunta_5a());
			d.setDu_Pregunta_6a(formato.getDu_Pregunta_6a());
			d.setDu_Pregunta_7a(formato.getDu_Pregunta_7a());
			d.setDu_Pregunta_8a(formato.getDu_Pregunta_8a());
			d.setDu_Pregunta_9a(formato.getDu_Pregunta_9a());
			d.setDu_Pregunta_10a(formato.getDu_Pregunta_10a());
			d.setDu_Pregunta_11a(formato.getDu_Pregunta_11a());
			d.setDu_Pregunta_12a(formato.getDu_Pregunta_12a());
			d.setDu_Pregunta_13a(formato.getDu_Pregunta_13a());
			d.setDu_Pregunta_14a(formato.getDu_Pregunta_14a());
			d.setDu_Pregunta_15a(formato.getDu_Pregunta_15a());
			d.setDu_Pregunta_16a(formato.getDu_Pregunta_16a());
			d.setDu_Pregunta_17a(formato.getDu_Pregunta_17a());
			d.setDu_Pregunta_18a(formato.getDu_Pregunta_18a());
			d.setDu_Pregunta_19a(formato.getDu_Pregunta_19a());
			d.setDu_Pregunta_1b(formato.getDu_Pregunta_1b());
			d.setDu_Pregunta_2b(formato.getDu_Pregunta_2b());
			d.setDu_Pregunta_3b(formato.getDu_Pregunta_3b());
			d.setDu_Pregunta_4b(formato.getDu_Pregunta_4b());
			d.setDu_Pregunta_5b(formato.getDu_Pregunta_5b());
			d.setDu_Pregunta_6b(formato.getDu_Pregunta_6b());
			d.setDu_Pregunta_7b(formato.getDu_Pregunta_7b());
			d.setDu_Pregunta_8b(formato.getDu_Pregunta_8b());
			d.setDu_Pregunta_9b(formato.getDu_Pregunta_9b());
			d.setDu_Pregunta_10b(formato.getDu_Pregunta_10b());
			d.setDu_Pregunta_11b(formato.getDu_Pregunta_11b());
			d.setDu_Pregunta_12b(formato.getDu_Pregunta_12b());
			d.setDu_Pregunta_13b(formato.getDu_Pregunta_13b());
			d.setDu_Pregunta_14b(formato.getDu_Pregunta_14b());
			d.setDu_Pregunta_15b(formato.getDu_Pregunta_15b());
			d.setDu_Pregunta_16b(formato.getDu_Pregunta_16b());
			d.setDu_Pregunta_17b(formato.getDu_Pregunta_17b());
			d.setDu_Pregunta_18b(formato.getDu_Pregunta_18b());
			d.setDu_Pregunta_19b(formato.getDu_Pregunta_19b());
			d.setDu_Pregunta_A(formato.getDu_Pregunta_A());
			d.setDu_Folio(formato.getDu_Folio());
			d.setDu_Num_Inciso(formato.getDu_Num_Inciso());
			d.setDu_Asegurado(formato.getDu_Asegurado());
			d.setDu_Num_Endoso(formato.getDu_Num_Endoso());
			d.setDu_Nom_Ajustador_Gral(formato.getDu_Nom_Ajustador_Gral());
			d.setDu_Clave_Ajustador_Gral(formato.getDu_Clave_Ajustador_Gral());
			d.setDu_Pregunta_A_Bool(formato.getDu_Pregunta_A_Bool());
			d.setDu_Pregunta_B_Bool(formato.getDu_Pregunta_B_Bool());
			d.setDu_Modelo_Auto_A(formato.getDu_Modelo_Auto_A());
			d.setDu_Modelo_Auto_B(formato.getDu_Modelo_Auto_B());
			d.setDu_Uso_Auto_A(formato.getDu_Uso_Auto_A());
			d.setDu_Uso_Auto_B(formato.getDu_Uso_Auto_B());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Con_A(formato.getFirma_Con_A());
			d.setFirma_Con_B(formato.getFirma_Con_B());
			d.setFirma_Responsable(formato.getFirma_Responsable());
			d.setFirma_Ajus_A(formato.getFirma_Ajus_A());
			d.setFirma_Ajus_B(formato.getFirma_Ajus_B());
			d.setFirma_Ajus_Qualitas(formato.getFirma_Ajus_Qualitas());
			d.setDu_Folio_Informe(formato.getDu_Folio_Informe());
			d.setDu_Croquis(formato.getDu_Croquis());
			d.setDu_Calca_A(formato.getDu_Calca_A());
			d.setDu_Calca_B(formato.getDu_Calca_B());
			d.setDu_Descripcion_Croquis(formato.getDu_Descripcion_Croquis());
			d.setDu_codigo_responsabilidad(formato.getDu_codigo_responsabilidad());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			if(formato.getDu_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			resultado = fdu.InsertarFormatoDeclaracionUniversal(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getDu_Clave_Ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getDu_Num_Reporte(),
					 "FormatoDeclaracionUniversal", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoDeclaracionUniversal(formato)) + "Resultado SP: " + resultado);

			// --------------------------------------------------
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorDeclaracionUniversal(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			// --------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoDeclaracionUniversal");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getDu_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getDu_Num_Reporte(),
						 "FormatoDeclaracionUniversal", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoDeclaracionUniversal(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoDeclaracionUniversal");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	@Override
	public GETMovilResultadoOperacion InsertarFRI(FormatoReciboIngresoSiniestro formato) throws SQLException {
		try {

			DatosInsertarFormatoReciboIngresoSiniestro s = new DatosInsertarFormatoReciboIngresoSiniestro();

			s.setRi_NumSiniestro(formato.getRiNumSiniestro());
			s.setRiFolio(formato.getRiFolio());
			s.setRiFecha(formato.getRiFecha());
			s.setRiNumPoliza(formato.getRiNumPoliza());
			s.setRiNumInciso(formato.getRiNumInciso());
			s.setRiClaveProv(formato.getRiClaveProv());
			s.setRiCobertura(formato.getRiCobertura());
			s.setRiAjustador(formato.getRiAjustador());
			s.setRiRecibimosDe(formato.getRiRecibimosDe());
			s.setRiRfc(formato.getRiRfc());
			s.setRiEmail(formato.getRiEmail());
			s.setRiTelefono(formato.getRiTelefono());
			s.setRiDomicilio(formato.getRiDomicilio());
			s.setRiCantidad(formato.getRiCantidad());
			s.setRiImporteLetra(formato.getRiImporteLetra());
			s.setRiConceptoDe(formato.getRiConceptoDe());
			s.setRiValores(formato.getRiValores());
			s.setRiBanco1(formato.getRiBanco1());
			s.setRiImporte1(formato.getRiImporte1());
			s.setRiAutorizacion1(formato.getRiAutorizacion1());
			s.setRiNumTarjeta1(formato.getRiNumTarjeta1());
			s.setRiBanco2(formato.getRiBanco2());
			s.setRiImporte2(formato.getRiImporte2());
			s.setRiAutorizacion2(formato.getRiAutorizacion2());
			s.setRiNumTarjeta2(formato.getRiNumTarjeta2());
			s.setRiBanco3(formato.getRiBanco3());
			s.setRiImporte3(formato.getRiImporte3());
			s.setRiAutorizacion3(formato.getRiAutorizacion3());
			s.setRiNumTarjeta3(formato.getRiNumTarjeta3());
			s.setRiImporteTotal(formato.getRiImporteTotal());
			s.setRiFirmaAsegurado(formato.getRiFirmaAsegurado());
			s.setRiFirmaTercero(formato.getRiFirmaTercero());
			s.setRiFirmaAjustador(formato.getRiFirmaAjustador());
			s.setRiLugarExp(formato.getRiLugarExp());
			s.setRiFirmaRecibido(formato.getRiFirmaRecibido());
			s.setCheck1(formato.getCheck1());
			s.setCheck2(formato.getCheck2());
			s.setCheck3(formato.getCheck3());
			s.setCheck4(formato.getCheck4());
			s.setRiNomTercero(formato.getRiNomTercero());
			s.setRiNomAsegurado(formato.getRiNomAsegurado());
			s.setCancelado(formato.getCancelado());
			s.setRiNumReporte(formato.getRiNumReporte());
			s.setRiNumTercero(formato.getRiNumTercero());
			s.setCorreo_oculto(formato.getCorreo_oculto());
			s.setFuente_ws(formato.getFuente_ws());
			s.setCheck_5(formato.getCheck_5());
			s.setCheck_6(formato.getCheck_6());
			
			if(formato.getRiClaveProv()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fri.InsertarFormatoReciboIngresoSiniestro(s);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getRiClaveProv(), null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRiNumReporte(),
					 "FormatoReciboIngresoSiniestro", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReciboIngresoSiniestro(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorReciboIngreso(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);

		}

		catch (javax.persistence.PersistenceException se) {
			this.utileriaExcepcion.manejarExcepcion(se, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReciboIngresoSiniestro");
			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getRiClaveProv(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRiNumReporte(),
						 "FormatoReciboIngresoSiniestro", this.operacion,
						"Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(limpiar.eliminaFormatoReciboIngresoSiniestro(formato)) + "Excepcion: "
								+ se.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReciboIngresoSiniestro");
			}

			if (se.getMessage().contains("Error Code: 6502")) {
				return new GETMovilResultadoOperacion(false,
						"Se espera un dato numerico en: NÚMERO DE TERCERO/ASEGURADO");
			}

			return new GETMovilResultadoOperacion(false, se.getMessage());
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReciboIngresoSiniestro");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getRiClaveProv(), null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRiNumReporte(),
						 "FormatoReciboIngresoSiniestro", this.operacion,
						"Ejecucion del Metodo Con Datos -> " + this.xmlFactory.obtenerString(limpiar.eliminaFormatoReciboIngresoSiniestro(formato)) + "Excepcion: "
								+ ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReciboIngresoSiniestro");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	// recibo pago deducible
	@Override
	public GETMovilResultadoOperacion InsertarFRD(FormatoReciboPagoDeducible formato) throws SQLException {
		try {

			DatosInsertarFormatoReciboPagoDeducible s = new DatosInsertarFormatoReciboPagoDeducible();

			s.setRd_NumSiniestro(formato.getRdNumSiniestro());
			s.setRd_NumReporte(formato.getRdNumReporte());
			s.setRd_Folio(formato.getRdFolio());
			s.setRd_Fecha(formato.getRdFecha());
			s.setRd_NumPoliza(formato.getRdNumPoliza());
			s.setRd_NumInciso(formato.getRdNumInciso());
			s.setRd_Clave(formato.getRdClave());
			s.setRd_Ajustador(formato.getRdAjustador());
			s.setRd_RecibimosDe(formato.getRdRecibimosDe());
			s.setRd_Rfc(formato.getRdRfc());
			s.setRd_Email(formato.getRdEmail());
			s.setRd_Telefono(formato.getRdTelefono());
			s.setRd_Domicilio(formato.getRdDomicilio());
			s.setRd_Cantidad(formato.getRdCantidad());
			s.setRd_ImporteLetra(formato.getRdImporteLetra());
			s.setRd_ConceptoDe(formato.getRdConceptoDe());
			s.setRd_Valores(formato.getRdValores());
			s.setRd_NumCuenta1(formato.getRdNumCuenta1());
			s.setRd_NumCuenta2(formato.getRdNumCuenta2());
			s.setRd_Banco1(formato.getRdBanco1());
			s.setRd_Banco2(formato.getRdBanco2());
			s.setRd_Importe1(formato.getRdImporte1());
			s.setRd_Importe2(formato.getRdImporte2());
			s.setRd_Autorizacion1(formato.getRdAutorizacion1());
			s.setRd_Autorizacion2(formato.getRdAutorizacion2());
			s.setRd_NumTarjeta1(formato.getRdNumTarjeta1());
			s.setRd_NumTarjeta2(formato.getRdNumTarjeta2());
			s.setRd_Banco1B(formato.getRdBanco1B());
			s.setRd_Banco2B(formato.getRdBanco1B());
			s.setRd_Importe1B(formato.getRdImporte1B());
			s.setRd_Importe2B(formato.getRdImporte2B());
			s.setRd_ImporteTotal(formato.getRdImporteTotal());
			s.setRd_LugarExp(formato.getRdLugarExp());
			s.setRd_FirmaRecibido(formato.getRdFirmaRecibido());
			s.setCheck1(formato.getCheck1());
			s.setCheck2(formato.getCheck2());
			s.setCheck3(formato.getCheck3());
			s.setCheck4(formato.getCheck4());
			s.setCancelado(formato.getCancelado());
			s.setCorreo_oculto(formato.getCorreo_oculto());
			s.setFuente_ws(formato.getFuente_ws());
			s.setCheck_5(formato.getCheck_5());
			s.setCheck_6(formato.getCheck_6());
			
			if(formato.getRdClave()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = frd.InsertarFormatoReciboPagoDeducible(s);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getRd_Clave(), null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRdNumReporte(),
					 "FormatoReciboPagoDeducible", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReciboPagoDeducible(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorReciboDeducible(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);

		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReciboPagoDeducible");

			try {
				Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(formato.getRdClave(),
						null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRdNumReporte(),
						 "FormatoReciboPagoDeducible", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReciboPagoDeducible(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReciboPagoDeducible");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}

	@Override
	public GETMovilResultadoOperacion InsertarFSD(FormatoSolicitudDiagnostico formato) throws SQLException {

		try {
			DatosInsertarFormatoSolicitudDiagnostico d = new DatosInsertarFormatoSolicitudDiagnostico();
			d.setSd_Num_Reporte(formato.getSd_Num_Reporte());
			d.setSd_Fecha(formato.getSd_Fecha());
			d.setSd_Num_Poliza(formato.getSd_Num_Poliza());
			d.setSd_Num_Endoso(formato.getSd_Num_Endoso());
			d.setSd_Num_Inciso(formato.getSd_Num_Inciso());
			d.setSd_Num_Siniestro(formato.getSd_Num_Siniestro());
			d.setSd_Nom_Cliente(formato.getSd_Nom_Cliente());
			d.setSd_Email_Cliente(formato.getSd_Email_Cliente());
			d.setSd_Tel_Cliente(formato.getSd_Tel_Cliente());
			d.setSd_Razon_Envio(formato.getSd_Razon_Envio());
			d.setSd_Razon_Responsable(formato.getSd_Razon_Responsable());
			d.setSd_Razon_Telefono(formato.getSd_Razon_Telefono());
			d.setSd_Razon_Domicilio(formato.getSd_Razon_Domicilio());
			d.setSd_Razon_Cobertura(formato.getSd_Razon_Cobertura());
			d.setSd_Marca_Auto(formato.getSd_Marca_Auto());
			d.setSd_Tipo_Auto(formato.getSd_Tipo_Auto());
			d.setSd_Modelo_Auto(formato.getSd_Modelo_Auto());
			d.setSd_Kilometraje_Auto(formato.getSd_Kilometraje_Auto());
			d.setSd_Num_Serie(formato.getSd_Num_Serie());
			d.setSd_Color_Auto(formato.getSd_Color_Auto());
			d.setSd_Placa_Auto(formato.getSd_Placa_Auto());
			d.setSd_Transmision(formato.getSd_Transmision());
			d.setSd_Danios_Unidad(formato.getSd_Danios_Unidad());
			d.setSd_Descripcion_Danios(formato.getSd_Descripcion_Danios());
			d.setSd_Danios_Pre(formato.getSd_Danios_Pre());
			d.setSd_Nom_Ajustador(formato.getSd_Nom_Ajustador());
			d.setSd_Clave_Ajustador(formato.getSd_Clave_Ajustador());
			d.setCheck_1(formato.getCheck_1());
			d.setCheck_2(formato.getCheck_2());
			d.setCheck_3(formato.getCheck_3());
			d.setCheck_4(formato.getCheck_4());
			d.setFirma_Ajustador(formato.getFirma_Ajustador());
			d.setFirma_Asegurado(formato.getFirma_Asegurado());
			d.setSd_Otro(formato.getSd_Otro());
			d.setSd_Nivel_Inundacion(formato.getSd_Nivel_Inundacion());
			d.setSd_Descripcion_Danios_Pre(formato.getSd_Descripcion_Danios_Pre());
			d.setCorreo_oculto(formato.getCorreo_oculto());
			d.setFuente_ws(formato.getFuente_ws());
			d.setCheck_5(formato.getCheck_5());
			d.setCheck_6(formato.getCheck_6());
			
			
			if(formato.getSd_Clave_Ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fsd.InsertarFormatoSolicitudDiagnostico(d);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(d.getSd_Clave_Ajustador(),
					null);
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getSd_Num_Reporte(),
					 "FormatoSolicitudDiagnostico", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoSolicitudDiagnostico(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorSolicitudDiagnostico(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);
		}

		catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoSolicitudDiagnostico");
			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getSd_Clave_Ajustador(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getSd_Num_Reporte(),
						 "FormatoSolicitudDiagnostico", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoSolicitudDiagnostico(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoSolicitudDiagnostico");
			}
			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}
	}

	@Override
	public GETMovilResultadoOperacion InsertarFMD(FormatoMemoriaDescriptiva formato) throws SQLException {
		try {

			DatosInsertarFormatoMemoriaDescriptiva s = new DatosInsertarFormatoMemoriaDescriptiva();

			s.setFecha(formato.getFecha());
			s.setReporte(formato.getReporte());
			s.setSiniestro(formato.getSiniestro());
			s.setFolioElectro(formato.getFolioElectro());
			s.setCobertura(formato.getCobertura());
			s.setPoliza(formato.getPoliza());
			s.setEndoso(formato.getEndoso());
			s.setInciso(formato.getInciso());
			s.setNomSocial(formato.getNomSocial());
			s.setTipoAsegurado(formato.getTipoAsegurado());
			s.setMarca(formato.getMarca());
			s.setTipo(formato.getTipo());
			s.setModelo(formato.getModelo());
			s.setPlacas(formato.getPlacas());
			s.setColor(formato.getColor());
			s.setDuracionMan(formato.getDuracionMan());
			s.setGruaLugar(formato.getGruaLugar());
			s.setConcesion(formato.getConcesion());
			s.setEstatalFede(formato.getEstatalFede());
			s.setManiobras(formato.getManiobras());
			s.setTipoGrua(formato.getTipoGrua());
			s.setOtraGrua(formato.getOtraGrua());
			s.setOtraGruaTexto(formato.getOtraGruaTexto());
			s.setCardan1(formato.getCardan1());
			s.setCardan2(formato.getCardan2());
			s.setCardan3(formato.getCardan3());
			s.setCantidadGruas(formato.getCantidadGruas());
			s.setTraspaleo(formato.getTraspaleo());
			s.setTipoTraspaleo(formato.getTipoTraspaleo());
			s.setProveedor(formato.getProveedor());
			s.setCantidadGruasTexto(formato.getCantidadGruasTexto());
			s.setTelefono(formato.getTelefono());
			s.setDomicilioProv(formato.getDomicilioProv());
			s.setUbicacionOrigen(formato.getUbicacionOrigen());
			s.setTrasladoDestino(formato.getTrasladoDestino());
			s.setCamionToneladas(formato.getCamionToneladas());
			s.setHorarioSolicitado(formato.getHorarioSolicitado());
			s.setHorarioArribo(formato.getHorarioArribo());
			s.setHorarioTraslado(formato.getHorarioTraslado());
			s.setManEspeciales(formato.getManEspeciales());
			s.setServicioDesacoplar(formato.getServicioDesacoplar());
			s.setServicioAbanderaM(formato.getServicioAbanderaM());
			s.setServicioAbanderaG(formato.getServicioAbanderaG());
			s.setManualHora(formato.getManualHora());
			s.setGruaHora(formato.getGruaHora());
			s.setServicioEnganche(formato.getServicioEnganche());
			s.setServicioFueraC(formato.getServicioFueraC());
			s.setServicioSobreC(formato.getServicioSobreC());
			s.setServicioVolcadura(formato.getServicioVolcadura());
			s.setServicioCarga(formato.getServicioCarga());
			s.setServicioRescate(formato.getServicioRescate());
			s.setServicioCustodia(formato.getServicioCustodia());
			s.setServicioManiobra(formato.getServicioManiobra());
			s.setFirmaAsegurado(formato.getFirmaAsegurado());
			s.setNomEmpleado(formato.getNomEmpleado());
			s.setFirmaEmpleado(formato.getFirmaEmpleado());
			s.setClaveEmpleado(formato.getClaveEmpleado());
			s.setNomOperadorGrua(formato.getNomOperadorGrua());
			s.setNumEcoGrua(formato.getNumEcoGrua());
			s.setFirmaOperadorGrua(formato.getFirmaOperadorGrua());
			s.setCroquis(formato.getCroquis());
			s.setTipoGruaAbander(formato.getTipoGruaAbander());
			s.setCorreo(formato.getCorreo());
			s.setCheck_1(formato.getCheck_1());
			s.setCheck_2(formato.getCheck_2());
			s.setCheck_3(formato.getCheck_3());
			s.setCheck_4(formato.getCheck_4());
			s.setCorreo_oculto(formato.getCorreo_oculto());
			s.setFuente_ws(formato.getFuente_ws());
			s.setCheck_5(formato.getCheck_5());
			s.setCheck_6(formato.getCheck_6());
			
			if(formato.getClaveEmpleado()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}

			String resultado = null;

			resultado = fmd.InsertarFormatoMemoriaDescriptiva(s);

			// LOG.info("Res sp:"+resultado);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getClaveEmpleado(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getReporte(),
					 "FormatoMemoriaDescriptiva", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoMemoriaDescriptiva(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorMemoriaDescriptiva(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			// -------------------------------------------------

			return new GETMovilResultadoOperacion(true, resultado);

		} catch (javax.persistence.PersistenceException se) {
			this.utileriaExcepcion.manejarExcepcion(se, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoMemoriaDescriptiva");
			try {

				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getClaveEmpleado(), null);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getReporte(),
						 "FormatoMemoriaDescriptiva", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoMemoriaDescriptiva(formato)) + "Excepcion: " + se.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoMemoriaDescriptiva");
			}

			if (se.getMessage().contains("Error Code: 6502")) {
				return new GETMovilResultadoOperacion(false, "Se espera un dato numerico en: CANTIDAD DE GRÚAS");
			}

			return new GETMovilResultadoOperacion(false, se.getMessage());
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoMemoriaDescriptiva");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getClaveEmpleado(), null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getReporte(),
						 "FormatoMemoriaDescriptiva", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoMemoriaDescriptiva(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoMemoriaDescriptiva");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}
	
	//nuevo formato tarjeta credito
	@Override
	public GETMovilResultadoOperacion InsertarFCT(FormatoCargoTarjetaCredito formato) throws SQLException {
		try {

			DatosInsertarFormatoCargoTarjetaCredito s = new DatosInsertarFormatoCargoTarjetaCredito();
			
			s.setTc_num_reporte(formato.getTc_num_reporte() );
			s.setTc_num_siniestro(formato.getTc_num_siniestro());
			s.setTc_num_asegurado(formato.getTc_num_asegurado() );
			s.setTc_num_autorizacion(formato.getTc_num_autorizacion() );
			s.setTc_nombre(formato.getTc_nombre() );
			s.setTc_fecha(formato.getTc_fecha() );
			s.setTc_direccion(formato.getTc_direccion() );
			s.setTc_estado(formato.getTc_estado() );
			s.setTc_cp(formato.getTc_cp() );
			s.setTc_telefono(formato.getTc_telefono() );
			s.setTc_cantidad_autorizada(formato.getTc_cantidad_autorizada() );
			s.setTc_pago_opcion(formato.getTc_pago_opcion() );
			s.setTc_num_tarjeta(formato.getTc_num_tarjeta() );
			s.setTc_vencimiento_tarjeta(formato.getTc_vencimiento_tarjeta() );
			s.setTc_clave_ajustador(formato.getTc_clave_ajustador() );
			s.setCheck_1(formato.getCheck_1() );
			s.setCheck_2(formato.getCheck_2() );
			s.setCheck_3(formato.getCheck_3() );
			s.setCheck_4(formato.getCheck_4() );
			s.setFirma_tarjetahabiente(formato.getFirma_tarjetahabiente() );
			s.setTc_num_poliza(formato.getTc_num_poliza());
			s.setTc_correo(formato.getTc_correo());
			s.setCorreo_oculto(formato.getCorreo_oculto());
			s.setFuente_ws(formato.getFuente_ws());
			s.setCheck_5(formato.getCheck_5());
			s.setCheck_6(formato.getCheck_6());

			if(formato.getTc_clave_ajustador()==null ) {
				return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
			}
			//
			String resultado = null;

			resultado = ftc.InsertarFormatoCargoTarjetaCredito(s);

			Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getTc_clave_ajustador(),
					null);

			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getTc_num_reporte(),
					 "FormatoCargoTarjetaCredito", this.operacion, "Ejecucion del Metodo Con Datos -> "
							+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoCargoTarjetaCredito(formato)) + "Resultado SP: " + resultado);
			// --------------------------------------------------
			String descripcion_campo = null;
			if (resultado.contains("Error 1")) {
				descripcion_campo = formatoServicioErrores.errorCargoTarjetCredito(resultado);
				if (descripcion_campo != null) {
					String info = StringUtils.substringBetween(resultado, "(", ")");
					return new GETMovilResultadoOperacion(false,
							"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
				} else {
					return new GETMovilResultadoOperacion(false, resultado);
				}

			} else if (resultado.contains("Error 2")) {
				return new GETMovilResultadoOperacion(false, resultado);
			}

			return new GETMovilResultadoOperacion(true, resultado);

		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoAsistenciaVial");

			try {
				Terminal term = Terminal.getTerminalService()
						.objetoTerminalParaProveedorYPasswd(formato.getTc_clave_ajustador(), null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getTc_num_reporte(),
						 "FormatoCargoTarjetaCredito", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoCargoTarjetaCredito(formato)) + "Excepcion: " + ex.getMessage());
			} catch (Exception e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
						"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoCargoTarjetaCredito");
			}

			return new GETMovilResultadoOperacion(false, ex.getMessage());
		}

	}
	// 
	
	//nuevo formato responsabilidad civil
		@Override
		public GETMovilResultadoOperacion InsertarFRC (FormatoResponsabilidadCivil formato) throws SQLException {
			try {

				DatosInsertarFormatoResponsabilidadCivil s = new DatosInsertarFormatoResponsabilidadCivil();
				
			
				s.setRc_num_reporte(formato.getRc_num_reporte() );
				  s.setRc_num_siniestro(formato.getRc_num_siniestro() ); 
				  s.setRc_num_poliza(formato.getRc_num_poliza() );
				  s.setRc_num_asegurado(formato.getRc_num_asegurado() );
				  s.setRc_fecha_siniestro(formato.getRc_fecha_siniestro() );
				  s.setRc_folio_dua(formato.getRc_folio_dua() );
				  s.setRc_vehiculo_q(formato.getRc_vehiculo_q() );  
				  s.setRc_compania_trans_mer(formato.getRc_compania_trans_mer() );
				  s.setRc_reporte_vehiculo(formato.getRc_reporte_vehiculo() );
				  s.setRc_nom_propietario(formato.getRc_nom_propietario() );
				  s.setRc_tel_propietario(formato.getRc_tel_propietario() );
				  s.setRc_correo_propietario(formato.getRc_correo_propietario() );  
				  s.setRc_nom_transportista(formato.getRc_nom_transportista() ); 
				  s.setRc_tel_transportista(formato.getRc_tel_transportista() );
				  s.setRc_correo_transportista(formato.getRc_correo_transportista() ); 
				  s.setRc_dir_siniestro(formato.getRc_dir_siniestro() );
				  s.setRc_entidad_siniestro(formato.getRc_entidad_siniestro() ); 
				  s.setRc_dir_resguardo(formato.getRc_dir_resguardo() );
				  s.setRc_entidad_resguardo(formato.getRc_entidad_resguardo() );
				  s.setRc_responsable(formato.getRc_responsable() ); 
				  s.setRc_entidad_resp(formato.getRc_entidad_resp() ); 
				  s.setRc_tel_responsable(formato.getRc_tel_responsable() ); 
				  s.setRc_tipo_siniestro(formato.getRc_tipo_siniestro() );
				  s.setRc_num_acta(formato.getRc_num_acta() ); 
				  s.setRc_descripcion_veh(formato.getRc_descripcion_veh() ); 
				  s.setRc_nom_operador(formato.getRc_nom_operador() );  
				  s.setRc_opc_ebriedad(formato.getRc_opc_ebriedad() ); 
				  s.setRc_opc_licencia(formato.getRc_opc_licencia() ); 
				  s.setRc_dictamen(formato.getRc_dictamen() );
				   s.setRc_opc_carga_daniada(formato.getRc_opc_carga_daniada() );
				  s.setRc_descripcion_merc(formato.getRc_descripcion_merc() );
				  s.setRc_porcentaje_aprox(formato.getRc_porcentaje_aprox() );
				  s.setRc_opc_seguro_trans(formato.getRc_opc_seguro_trans() );
				  s.setRc_nom_aseguradora(formato.getRc_nom_aseguradora() ); 
				  s.setRc_opc_interviene_a(formato.getRc_opc_interviene_a() ); 
				  s.setRc_opc_traspaleo_c(formato.getRc_opc_traspaleo_c() );
				  s.setRc_folio_carta(formato.getRc_folio_carta() );
				  s.setRc_folio_factura(formato.getRc_folio_factura() );  
				  s.setRc_folio_remision(formato.getRc_folio_remision() ); 
				  s.setRc_folio_guia(formato.getRc_folio_guia() );
				  s.setRc_folio_mapa(formato.getRc_folio_mapa() );
				  s.setRc_informe_ajustador(formato.getRc_informe_ajustador() );
				  s.setRc_nom_ajustador(formato.getRc_nom_ajustador() );
				  s.setRc_clave_ajustador(formato.getRc_clave_ajustador() ); 
				  s.setRc_nom_asegurado_tercero(formato.getRc_nom_asegurado_tercero() ); 
				  s.setRc_nom_asegurado(formato.getRc_nom_asegurado() ); 
				  s.setRc_documentos_req(formato.getRc_documentos_req() ); 
				  s.setCheck_1(formato.getCheck_1() ); 
				  s.setCheck_2(formato.getCheck_2() );
				  s.setCheck_3(formato.getCheck_3() ); 
				  s.setCheck_4(formato.getCheck_4() ); 
				  s.setCroquis(formato.getCroquis() );  
				  s.setFirma_ajustador(formato.getFirma_ajustador() );
				  s.setFirma_asegurado_tercero(formato.getFirma_asegurado_tercero() );
				  s.setFirma_asegurado(formato.getFirma_asegurado() );
				  s.setCorreo_oculto(formato.getCorreo_oculto());
				  s.setFuente_ws(formato.getFuente_ws());
				  s.setCheck_5(formato.getCheck_5());
					s.setCheck_6(formato.getCheck_6());


					if(formato.getRc_clave_ajustador()==null ) {
						return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
					}
				//
				String resultado = null;

				resultado = frc.InsertarFormatoResponsabilidadCivil(s);

				Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getRc_clave_ajustador(),
						null);

				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRc_num_reporte(),
						 "FormatoResponsabilidadCivil", this.operacion, "Ejecucion del Metodo Con Datos -> "
								+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoResponsabilidadCivil(formato)) + "Resultado SP: " + resultado);
				// --------------------------------------------------
				String descripcion_campo = null;
				if (resultado.contains("Error 1")) {
					descripcion_campo = formatoServicioErrores.errorResponsabilidadCivil(resultado);
					if (descripcion_campo != null) {
						String info = StringUtils.substringBetween(resultado, "(", ")");
						return new GETMovilResultadoOperacion(false,
								"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
					} else {
						return new GETMovilResultadoOperacion(false, resultado);
					}

				} else if (resultado.contains("Error 2")) {
					return new GETMovilResultadoOperacion(false, resultado);
				}

				return new GETMovilResultadoOperacion(true, resultado);

			} catch (Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"solicitarResponsabilidadCivil => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoResponsabilidadCivil");

				try {
					Terminal term = Terminal.getTerminalService()
							.objetoTerminalParaProveedorYPasswd(formato.getRc_clave_ajustador(), null);

					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getRc_num_reporte(),
							 "FormatoResponsabilidadCivil", this.operacion, "Ejecucion del Metodo Con Datos -> "
									+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoResponsabilidadCivil(formato)) + "Excepcion: " + ex.getMessage());
				} catch (Exception e) {
					this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
							"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoResponsabilidadCivil");
				}

				return new GETMovilResultadoOperacion(false, ex.getMessage());
			}

		}
		// nuevo formato bienes diversos
		
		//nuevo formato responsabilidad civil
				@Override
				public GETMovilResultadoOperacion InsertarFBD (FormatoReparacionBienesDiversos formato) throws SQLException {
					try {

						DatosInsertarFormatoReparacionBienesDiversos s = new DatosInsertarFormatoReparacionBienesDiversos();
						
					
						
						s.setBd_num_reporte(formato.getBd_num_reporte() ); 
						s.setBd_num_siniestro(formato.getBd_num_siniestro()  );
						s.setBd_num_poliza(formato.getBd_num_poliza()  );
						s.setBd_num_asegurado(formato.getBd_num_asegurado()  ); 
						s.setBd_fecha(formato.getBd_fecha()  );
						s.setBd_nombre_afectado(formato.getBd_nombre_afectado()  );
						s.setBd_tel_afectado(formato.getBd_tel_afectado()  );
						s.setBd_ubicacion_siniestro(formato.getBd_ubicacion_siniestro()  );
						s.setBd_domicilio_siniestro(formato.getBd_domicilio_siniestro()  );
						s.setBd_telefono_siniestro(formato.getBd_telefono_siniestro()  );
						s.setBd_ubicacion_resguardo(formato.getBd_ubicacion_resguardo()  );
						s.setBd_domicilio_resguardo(formato.getBd_domicilio_resguardo()  );
						s.setBd_telefono_resguardo(formato.getBd_telefono_resguardo()  );
						s.setBd_responsable(formato.getBd_responsable()  );
						s.setBd_danios_diversos(formato.getBd_danios_diversos()  );
						s.setBd_observaciones(formato.getBd_observaciones()  );
						s.setBd_long(formato.getBd_long() );
						s.setBd_alto(formato.getBd_alto()  );
						s.setBd_ancho(formato.getBd_ancho()  );
						s.setBd_tipo(formato.getBd_tipo() ); 
						s.setBd_serie(formato.getBd_serie()  ); 
						s.setBd_tramo(formato.getBd_tramo()  ); 
						s.setBd_km(formato.getBd_km()  ); 
						s.setBd_descripcion_danios_can(formato.getBd_descripcion_danios_can()  );
					
						s.setBd_des_danios_pre(formato.getBd_des_danios_pre()  ); 
						s.setBd_motivo(formato.getBd_motivo() ); 
						s.setBd_correo(formato.getBd_correo()  ); 
						s.setBd_nom_ajustador(formato.getBd_nom_ajustador()  ); 
						s.setBd_clave_ajustador(formato.getBd_clave_ajustador()  ); 
						s.setBd_nom_asegurado_tercero(formato.getBd_nom_asegurado_tercero()  ); 
						s.setCheck_1(formato.getCheck_1() ); 
						s.setCheck_2(formato.getCheck_2() ); 
						s.setCheck_3(formato.getCheck_3()  ); 
						s.setCheck_4(formato.getCheck_4()  ); 
						s.setIlustracion(formato.getIlustracion()  ); 
						s.setFirma_ajustador(formato.getFirma_ajustador()  );
						s.setFirma_asegurado_tercero(formato.getFirma_asegurado_tercero()  );
						s.setCorreo_oculto(formato.getCorreo_oculto());
						s.setFuente_ws(formato.getFuente_ws());
						s.setCheck_5(formato.getCheck_5());
						s.setCheck_6(formato.getCheck_6());

						if(formato.getBd_clave_ajustador()==null ) {
							return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
						}
						//
						String resultado = null;

						resultado = fbd.InsertarFormatoReparacionBienesDiversos(s);

						Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getBd_clave_ajustador(),
								null);

						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getBd_num_reporte(),
								 "FormatoReparacionBienesDiversos", this.operacion, "Ejecucion del Metodo Con Datos -> "
										+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReparacionBienesDiversos(formato)) + "Resultado SP: " + resultado);
						// --------------------------------------------------
						String descripcion_campo = null;
						if (resultado.contains("Error 1")) {
							descripcion_campo = formatoServicioErrores.errorBienesDiversos(resultado);
							if (descripcion_campo != null) {
								String info = StringUtils.substringBetween(resultado, "(", ")");
								return new GETMovilResultadoOperacion(false,
										"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
							} else {
								return new GETMovilResultadoOperacion(false, resultado);
							}

						} else if (resultado.contains("Error 2")) {
							return new GETMovilResultadoOperacion(false, resultado);
						}

						return new GETMovilResultadoOperacion(true, resultado);

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"solicitarResponsabilidadCivil => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReparacionBienesDiversos");

						try {
							Terminal term = Terminal.getTerminalService()
									.objetoTerminalParaProveedorYPasswd(formato.getBd_clave_ajustador(), null);

							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getBd_num_reporte(),
									 "FormatoReparacionBienesDiversos", this.operacion, "Ejecucion del Metodo Con Datos -> "
											+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReparacionBienesDiversos(formato)) + "Excepcion: " + ex.getMessage());
						} catch (Exception e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
									"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReparacionBienesDiversos");
						}

						return new GETMovilResultadoOperacion(false, ex.getMessage());
					}

				}
		
		//
				
				//nuevo observaciones asegurado
				@Override
				public GETMovilResultadoOperacion InsertarFOA (FormatoObservacionesAsegurado formato) throws SQLException {
					try {

						DatosInsertarFormatoObservacionesAsegurado s = new DatosInsertarFormatoObservacionesAsegurado ();

						 	s.setFOA_NUM_REPORTE(formato.getFOA_NUM_REPORTE() );
				            s.setFOA_NUM_SINIESTRO(formato.getFOA_NUM_SINIESTRO() );
				            s.setFOA_NUM_POLIZA(formato.getFOA_NUM_POLIZA() );
				            s.setFOA_NUM_ASEGURADO(formato.getFOA_NUM_ASEGURADO() );
				            s.setFOA_NOM_AJUSTADOR(formato.getFOA_NOM_AJUSTADOR() );
				            s.setFOA_OBSERVACIONES(formato.getFOA_OBSERVACIONES() );
				            s.setFOA_NOM_CONDUCTOR(formato.getFOA_NOM_CONDUCTOR());
				            s.setFOA_TELEFONO(formato.getFOA_TELEFONO() );
				            s.setFOA_CORREO_CONDUCTOR(formato.getFOA_CORREO_CONDUCTOR() );
				            s.setFOA_CLAVE_AJUSTADOR(formato.getFOA_CLAVE_AJUSTADOR() );
				            s.setFOA_FECHA(formato.getFOA_FECHA() );
				            s.setFOA_LUGAR(formato.getFOA_LUGAR() );
				            s.setFIRMA_CONDUCTOR(formato.getFIRMA_CONDUCTOR() );
							s.setCHECK_1(formato.getCHECK_1() ); 
							s.setCHECK_2(formato.getCHECK_2() ); 
							s.setCHECK_3(formato.getCHECK_3()  ); 
							s.setCHECK_4(formato.getCHECK_4()  ); 
							s.setCorreo_oculto(formato.getCorreo_oculto());
							s.setFuente_ws(formato.getFuente_ws());
							s.setCheck_5(formato.getCheck_5());
							s.setCheck_6(formato.getCheck_6());
							
							if(formato.getFOA_CLAVE_AJUSTADOR()==null ) {
								return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
							}
						//
						String resultado = null;

						resultado = foa.InsertarFormatoObservacionesAsegurado(s);

						Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getFOA_CLAVE_AJUSTADOR(),
								null);
 
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getFOA_NUM_REPORTE(),
								 "FormatoObservacionesAsegurado", this.operacion, "Ejecucion del Metodo Con Datos -> "
										+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoObservacionesAsegurado(formato)) + "Resultado SP: " + resultado);
						// --------------------------------------------------
						String descripcion_campo = null;
						if (resultado.contains("Error 1")) {
							descripcion_campo = formatoServicioErrores.errorObservacionesAsegurado(resultado);
							if (descripcion_campo != null) {
								String info = StringUtils.substringBetween(resultado, "(", ")");
								return new GETMovilResultadoOperacion(false,
										"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
							} else {
								return new GETMovilResultadoOperacion(false, resultado);
							}

						} else if (resultado.contains("Error 2")) {
							return new GETMovilResultadoOperacion(false, resultado);
						}

						return new GETMovilResultadoOperacion(true, resultado);

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"solicitarObservacionesAsegurado => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoObservacionesAsegurado");

						try {
							Terminal term = Terminal.getTerminalService()
									.objetoTerminalParaProveedorYPasswd(formato.getFOA_CLAVE_AJUSTADOR(), null);

							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, formato.getFOA_NUM_REPORTE(),
									 "FormatoObservacionesAsegurado", this.operacion, "Ejecucion del Metodo Con Datos -> "
											+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoObservacionesAsegurado(formato)) + "Excepcion: " + ex.getMessage());
						} catch (Exception e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
									"solicitarObservacionesDiverso => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoObservacionesAsegurado");
						}

						return new GETMovilResultadoOperacion(false, ex.getMessage());
					}

				}

				
				
				// NUEVO FORMATO INVENTARIO PESADO
				@Override
				public GETMovilResultadoOperacion InsertarFINP(FormatoInventarioUnicoPesado formato) throws SQLException {
					try {

						DatosInsertarFormatoInventarioUnicoPesado s = new DatosInsertarFormatoInventarioUnicoPesado();
						
						
				        s.setInp_folio_e(formato.getInp_folio_e());
						s.setInp_serie(formato.getInp_serie());
						s.setInp_color(formato.getInp_color());
						s.setInp_placas(formato.getInp_placas());
						
						s.setInp_num_reporte(formato.getInp_num_reporte());
						s.setInp_num_siniestro(formato.getInp_num_siniestro());
						s.setInp_num_poliza(formato.getInp_num_poliza());
						s.setInp_num_asegurado(formato.getInp_num_asegurado());
						s.setInp_nombre_afectado(formato.getInp_nombre_afectado());
						s.setInp_llaves(formato.getInp_llaves());
						s.setInp_fecha(formato.getInp_fecha());
						s.setInp_num_endoso(formato.getInp_num_endoso());
						s.setInp_num_inciso(formato.getInp_num_inciso());
						s.setInp_marca(formato.getInp_marca());
						s.setInp_tipo(formato.getInp_tipo());
						s.setInp_puertas(formato.getInp_puertas());
						s.setInp_modelo(formato.getInp_modelo());
						s.setInp_num_motor(formato.getInp_num_motor());
						s.setInp_kilometraje(formato.getInp_kilometraje());
						s.setInp_combustible(formato.getInp_combustible());
						s.setInp_correo(formato.getInp_correo());
						s.setInp_tractocamion_pieza(formato.getInp_tractocamion_pieza());
						s.setInp_originales_camion(formato.getInp_originales_camion());
						s.setInp_renovadas_camion(formato.getInp_renovadas_camion());
						s.setInp_daniadas_camion(formato.getInp_daniadas_camion());
						s.setInp_faltantes_camion(formato.getInp_faltantes_camion());
						s.setInp_daniadas_remolque(formato.getInp_daniadas_remolque());
						s.setInp_faltantes_remolque(formato.getInp_faltantes_remolque());
						s.setInp_nombre_conductor(formato.getInp_nombre_conductor());
						s.setInp_nombre_operador_grua(formato.getInp_nombre_operador_grua());
						s.setInp_caso1_fecha(formato.getInp_caso1_fecha());
						s.setInp_caso1_lugar(formato.getInp_caso1_lugar());
						s.setInp_caso1_observaciones(formato.getInp_caso1_observaciones());
						s.setInp_caso1_nom_entrega(formato.getInp_caso1_nom_entrega());
						s.setInp_caso1_nom_recibe(formato.getInp_caso1_nom_recibe());
						s.setInp_caso2_fecha(formato.getInp_caso2_fecha());
						s.setInp_caso2_lugar(formato.getInp_caso2_lugar());
						s.setInp_caso2_observaciones(formato.getInp_caso2_observaciones());
						s.setInp_caso2_nom_entrega(formato.getInp_caso2_nom_entrega());
						s.setInp_caso2_nom_recibe(formato.getInp_caso2_nom_recibe());
						s.setInp_caso3_fecha(formato.getInp_caso3_fecha());
						s.setInp_caso3_lugar(formato.getInp_caso3_lugar());
						s.setInp_caso3_observaciones(formato.getInp_caso3_observaciones());
						s.setInp_caso3_nom_entrega(formato.getInp_caso3_nom_entrega());
						s.setInp_caso3_nom_recibe(formato.getInp_caso3_nom_recibe());
						s.setFirma_ajustador(formato.getFirma_ajustador());
						s.setFirma_conductor(formato.getFirma_conductor());
						s.setFirma_operador_grua(formato.getFirma_operador_grua());
						s.setFirma_caso1_entrega(formato.getFirma_caso1_entrega());
						s.setFirma_caso1_recibe(formato.getFirma_caso1_recibe());
						s.setFirma_caso2_entrega(formato.getFirma_caso2_entrega());
						s.setFirma_caso2_recibe(formato.getFirma_caso2_recibe());
						s.setFirma_caso3_entrega(formato.getFirma_caso3_entrega());
						s.setFirma_caso3_recibe(formato.getFirma_caso3_recibe());
						s.setInp_nom_ajustador(formato.getInp_nom_ajustador());
						s.setInp_clave_ajustador(formato.getInp_clave_ajustador());
						s.setCheck_1(formato.getCheck_1());
						s.setCheck_2(formato.getCheck_2());
						s.setCheck_3(formato.getCheck_3());
						s.setCheck_4(formato.getCheck_4());
						//
						s.setInp_correo_grua(formato.getInp_correo_grua() );
						s.setInp_correo_taller(formato.getInp_correo_taller() );
						
						s.setInp_caso_1_ubicacion_flecha(formato.getInp_caso_1_ubicacion_flecha() );
						s.setInp_caso_1_a_lugar(formato.getInp_caso_1_a_lugar() );
						s.setInp_caso_1_prestador(formato.getInp_caso_1_prestador() );
						s.setInp_caso_1_danios_faltantes(formato.getInp_caso_1_danios_faltantes() );
						s.setInp_caso_1_crucero(formato.getInp_caso_1_crucero() );
						s.setInp_caso_1_taller(formato.getInp_caso_1_taller() );
						s.setInp_caso_1_mp(formato.getInp_caso_1_mp() );
						s.setInp_caso_1_ajustador(formato.getInp_caso_1_ajustador() );
						
						s.setInp_caso_2_ubicacion_flecha(formato.getInp_caso_2_ubicacion_flecha() );
						s.setInp_caso_2_a_lugar(formato.getInp_caso_2_a_lugar() );
						s.setInp_caso_2_prestador(formato.getInp_caso_2_prestador() );
						s.setInp_caso_2_danios_faltantes(formato.getInp_caso_2_danios_faltantes() );
						s.setInp_caso_2_crucero(formato.getInp_caso_2_crucero() );
						s.setInp_caso_2_taller(formato.getInp_caso_2_taller() );
						s.setInp_caso_2_mp(formato.getInp_caso_2_mp() );
						s.setInp_caso_2_ajustador(formato.getInp_caso_2_ajustador() );
						
						s.setInp_caso_3_ubicacion_flecha(formato.getInp_caso_3_ubicacion_flecha() );
						s.setInp_caso_3_a_lugar(formato.getInp_caso_3_a_lugar() );
						s.setInp_caso_3_prestador(formato.getInp_caso_3_prestador() );
						s.setInp_caso_3_danios_faltantes(formato.getInp_caso_3_danios_faltantes() );
						s.setInp_caso_3_crucero(formato.getInp_caso_3_crucero() );
						s.setInp_caso_3_taller(formato.getInp_caso_3_taller() );
						s.setInp_caso_3_mp(formato.getInp_caso_3_mp() );
						s.setInp_caso_3_ajustador(formato.getInp_caso_3_ajustador() );
						
						
						s.setInp_nom_entrega_gral(formato.getInp_nom_entrega_gral() );
						s.setInp_nom_recibe_gral(formato.getInp_nom_recibe_gral() );
						s.setFirma_recibe_gral(formato.getFirma_recibe_gral() );
						s.setFirma_entrega_gral(formato.getFirma_entrega_gral() );
						s.setCorreo_oculto(formato.getCorreo_oculto());
						s.setFuente_ws(formato.getFuente_ws());
						s.setCheck_5(formato.getCheck_5());
						s.setCheck_6(formato.getCheck_6());
						
						if(formato.getInp_clave_ajustador()==null ) {
							return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
						}

						String resultado = null;

						resultado = finp.InsertarFormatoInventarioUnicoPesado(s);

						Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getInp_clave_ajustador(),
								null);

						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
								formato.getInp_num_reporte(), "FormatoInventarioUnicoPesado", this.operacion,
								"Ejecucion del Metodo Con Datos -> "
										+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInventarioUnicoPesado(formato))
										+ "Resultado SP: " + resultado);
						// --------------------------------------------------
						String descripcion_campo = null;
						if (resultado.contains("Error 1")) {
							descripcion_campo = formatoServicioErrores.errorInventarioUnicoPesado(resultado);
							if (descripcion_campo != null) {
								String info = StringUtils.substringBetween(resultado, "(", ")");
								return new GETMovilResultadoOperacion(false,
										"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
							} else {
								return new GETMovilResultadoOperacion(false, resultado);
							}

						} else if (resultado.contains("Error 2")) {
							return new GETMovilResultadoOperacion(false, resultado);
						}

						return new GETMovilResultadoOperacion(true, resultado);

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInventarioUnicoPesado");

						try {
							Terminal term = Terminal.getTerminalService()
									.objetoTerminalParaProveedorYPasswd(formato.getInp_clave_ajustador(), null);

							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
									formato.getInp_num_reporte(), "FormatoInventarioUnicoPesado", this.operacion,
									"Ejecucion del Metodo Con Datos -> "
											+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoInventarioUnicoPesado(formato))
											+ "Excepcion: " + ex.getMessage());
						} catch (Exception e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
									"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoInventarioUnicoPesado");
						}

						return new GETMovilResultadoOperacion(false, ex.getMessage());
					}

				}

				@Override
				public GETMovilResultadoOperacion InsertarFRCP(FormatoReclamacionComprobantePeaje formato) throws SQLException {
					try {

						DatosInsertarFormatoReclamacionComprobantePeaje s = new DatosInsertarFormatoReclamacionComprobantePeaje();
			 
						s.setRcp_num_reporte(formato.getRcp_num_reporte());
						s.setRcp_num_siniestro(formato.getRcp_num_siniestro());
						s.setRcp_num_poliza(formato.getRcp_num_poliza());
						s.setRcp_num_asegurado(formato.getRcp_num_asegurado());
						s.setRcp_nom_usuario(formato.getRcp_nom_usuario());
						s.setRcp_sexo_usuario(formato.getRcp_sexo_usuario());
						s.setRcp_edad_usuario(formato.getRcp_edad_usuario());
						s.setRcp_estado_civil_usuario(formato.getRcp_estado_civil_usuario());
						s.setRcp_ocupacion_usuario(formato.getRcp_ocupacion_usuario());
						s.setRcp_telefono_usuario(formato.getRcp_telefono_usuario());
						s.setRcp_correo_usuario(formato.getRcp_correo_usuario());
						s.setRcp_calle_usuario(formato.getRcp_calle_usuario());
						s.setRcp_colonia_usuario(formato.getRcp_colonia_usuario());
						s.setRcp_cp_usuario(formato.getRcp_cp_usuario());
						s.setRcp_estado_usuario(formato.getRcp_estado_usuario());
						s.setRcp_poblacion_usuario(formato.getRcp_poblacion_usuario());
						s.setRcp_delegacion_usuario(formato.getRcp_delegacion_usuario());
						s.setRcp_calle_oficina(formato.getRcp_calle_oficina());
						s.setRcp_colonia_oficina(formato.getRcp_colonia_oficina());
						s.setRcp_cp_oficina(formato.getRcp_cp_oficina());
						s.setRcp_estado_oficina(formato.getRcp_estado_oficina());
						s.setRcp_poblacion_oficina(formato.getRcp_poblacion_oficina());
						s.setRcp_delegacion_oficina(formato.getRcp_delegacion_oficina());
						s.setRcp_razon_circula_auto(formato.getRcp_razon_circula_auto());
						s.setRcp_fecha_siniestro(formato.getRcp_fecha_siniestro());
						s.setRcp_marca_vehiculo(formato.getRcp_marca_vehiculo());
						s.setRcp_vehiculo_propio(formato.getRcp_vehiculo_propio());
						s.setRcp_licencia(formato.getRcp_licencia());
						s.setRcp_origen_viaje(formato.getRcp_origen_viaje());
						s.setRcp_destino_viaje(formato.getRcp_destino_viaje());
						s.setRcp_motivo_no_comprob(formato.getRcp_motivo_no_comprob());
						s.setRcp_nom_ajustador(formato.getRcp_nom_ajustador());
						s.setRcp_clave_ajustador(formato.getRcp_clave_ajustador());
						s.setRcp_nom_administracion(formato.getRcp_nom_administracion());
						s.setRcp_testigo_1(formato.getRcp_testigo_1());
						s.setRcp_testigo_2(formato.getRcp_testigo_2());
						s.setRcp_pago_previo_peaje(formato.getRcp_pago_previo_peaje());
						s.setRcp_nom_plaza_1(formato.getRcp_nom_plaza_1());
						s.setRcp_nom_plaza_2(formato.getRcp_nom_plaza_2());
						s.setRcp_cantidad_plaza_1(formato.getRcp_cantidad_plaza_1());
						s.setRcp_cantidad_plaza_2(formato.getRcp_cantidad_plaza_2());
						s.setRcp_frecuencia_circula(formato.getRcp_frecuencia_circula());
						s.setRcp_tarjeta_iave(formato.getRcp_tarjeta_iave());
						s.setRcp_pago_tarjeta_credito(formato.getRcp_pago_tarjeta_credito());
						s.setRcp_via_ingreso(formato.getRcp_via_ingreso());
						s.setRcp_motivo_danio(formato.getRcp_motivo_danio());
						s.setRcp_causa_meteorologica(formato.getRcp_causa_meteorologica());
						s.setRcp_causa_evento(formato.getRcp_causa_evento());
						s.setRcp_ingirio_sustancia(formato.getRcp_ingirio_sustancia());
						s.setRcp_vehiculo_asegurado(formato.getRcp_vehiculo_asegurado());
						s.setRcp_vehiculo_asegurado_poliza(formato.getRcp_vehiculo_asegurado_poliza());
						s.setRcp_vehiculo_asegurado_compania(formato.getRcp_vehiculo_asegurado_compania());
						s.setRcp_anexo_identificacion(formato.getRcp_anexo_identificacion());
						s.setRcp_anexo_licencia(formato.getRcp_anexo_licencia());
						s.setRcp_anexo_narracion(formato.getRcp_anexo_narracion());
						s.setRcp_nom_testigo(formato.getRcp_nom_testigo());
						s.setRcp_relacion_testigo(formato.getRcp_relacion_testigo());
						s.setRcp_telefono_testigo(formato.getRcp_telefono_testigo());
						s.setRcp_calle_testigo(formato.getRcp_calle_testigo());
						s.setRcp_colonia_testigo(formato.getRcp_colonia_testigo());
						s.setRcp_cp_testigo(formato.getRcp_cp_testigo());
						s.setRcp_estado_testigo(formato.getRcp_estado_testigo());
						s.setRcp_poblacion_testigo(formato.getRcp_poblacion_testigo());
						s.setRcp_delegacion_testigo(formato.getRcp_delegacion_testigo());
						s.setRcp_declaracion_testigo(formato.getRcp_declaracion_testigo());
						s.setCheck_1(formato.getCheck_1());
						s.setCheck_2(formato.getCheck_2());
						s.setCheck_3(formato.getCheck_3());
						s.setCheck_4(formato.getCheck_4());
						s.setFirma_ajustador(formato.getFirma_ajustador());
						s.setFirma_administracion(formato.getFirma_administracion());
						s.setFirma_usuario(formato.getFirma_usuario());
						s.setFirma_testigo1(formato.getFirma_testigo1());
						s.setFirma_testigo2(formato.getFirma_testigo2());
						s.setCorreo_oculto(formato.getCorreo_oculto());
						s.setFuente_ws(formato.getFuente_ws());
						s.setCheck_5(formato.getCheck_5());
						s.setCheck_6(formato.getCheck_6());
						
						if(formato.getRcp_clave_ajustador()==null ) {
							return new GETMovilResultadoOperacion(false, "La clave del ajustador es obligatoria");
						}

						String resultado = null;
			 
						resultado = frcp.InsertarFormatoReclamacionComprobantePeaje(s);

						Terminal term = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(s.getRcp_clave_ajustador(),
								null);

						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
								formato.getRcp_num_reporte(), "FormatoReclamacionComprobantePeaje", this.operacion,
								"Ejecucion del Metodo Con Datos -> "
										+ this.xmlFactory.obtenerString(limpiar.eliminaFormatoReclamacionComprobantePeaje(formato))
										+ "Resultado SP: " + resultado);
						// --------------------------------------------------
						String descripcion_campo = null;
						if (resultado.contains("Error 1")) {
							descripcion_campo = formatoServicioErrores.errorReclamacionComprobantePeaje(resultado);
							if (descripcion_campo != null) {
								String info = StringUtils.substringBetween(resultado, "(", ")");
								return new GETMovilResultadoOperacion(false,
										"Ha excedido la cantidad de caracteres de " + descripcion_campo + " (" + info + ")");
							} else {
								return new GETMovilResultadoOperacion(false, resultado);
							}

						} else if (resultado.contains("Error 2")) {
							return new GETMovilResultadoOperacion(false, resultado);
						}

						return new GETMovilResultadoOperacion(true, resultado);

					} catch (Exception ex) {
						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
								"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReclamacionComprobantePeaje");

						try {
							Terminal term = Terminal.getTerminalService()
									.objetoTerminalParaProveedorYPasswd(formato.getRcp_clave_ajustador(), null);

							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
									formato.getRcp_num_reporte(), "FormatoReclamacionComprobantePeaje", this.operacion,
									"Ejecucion del Metodo Con Datos -> "
											+ this.xmlFactory
													.obtenerString(limpiar.eliminaFormatoReclamacionComprobantePeaje(formato))
											+ "Excepcion: " + ex.getMessage());
						} catch (Exception e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
									"solicitarServiciosDiversos => ejecutarFuncionHistoricoResumenAjustadorNuevo => FormatoReclamacionComprobantePeaje");
						}

						return new GETMovilResultadoOperacion(false, ex.getMessage());
					}

				}
				
				@Override
				public GETMovilResultadoOperacion InsertarFOAD(FormatoOdaAuto formato) { //throws SQLException {
					System.out.println("Formato:"+formato.toString());
					
					/*Map<String, String> entry = new HashMap<String, String>();
					String result = null;*/
					
					return null;
				}
}