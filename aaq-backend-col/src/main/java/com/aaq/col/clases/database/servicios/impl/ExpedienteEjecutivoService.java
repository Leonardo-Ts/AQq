package com.aaq.col.clases.database.servicios.impl;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;


import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ExpedienteEjecutivo;
import com.aaq.col.clases.database.entidades.FormatoAdmisionAutomoviles;
import com.aaq.col.clases.database.entidades.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.database.entidades.FormatoAdmisionPesado;
import com.aaq.col.clases.database.entidades.FormatoAsignacionAbogado;
import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;
import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.aaq.col.clases.database.entidades.FormatoCuestionarioRobo;
import com.aaq.col.clases.database.entidades.FormatoDeclaracionUniversal;
import com.aaq.col.clases.database.entidades.FormatoEncuestaServicio;
import com.aaq.col.clases.database.entidades.FormatoGarantiaPrendaria;
import com.aaq.col.clases.database.entidades.FormatoInspeccionMoto;
import com.aaq.col.clases.database.entidades.FormatoInspeccionPesado;
import com.aaq.col.clases.database.entidades.FormatoInventarioAutomoviles;
import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.database.entidades.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.database.entidades.FormatoNuevosVehiculos;
import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;
import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;
import com.aaq.col.clases.database.entidades.FormatoPaseMedico;
import com.aaq.col.clases.database.entidades.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.database.entidades.FormatoReciboPagoDeducible;
import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;
import com.aaq.col.clases.database.entidades.FormatoReparacionBienes;
import com.aaq.col.clases.database.entidades.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.database.entidades.FormatoResponsabilidadCivil;
import com.aaq.col.clases.database.entidades.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.database.entidades.FormatoValeAmbulancia;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.aaq.col.clases.database.entidades.pojo.ErrorFormatos;
import com.aaq.col.clases.database.repositorios.impl.ExpedienteEjecutivoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionAutomovilesDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionMotocicletasDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionPesadoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAsignacionAbogadoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoAsistenciaVialDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoCargoTarjetaCreditoDao;
import com.aaq.col.clases.database.repositorios.impl.FormatoCatalogosDao;
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
import com.aaq.col.clases.database.servicios.interfase.ExpedienteEjecutivoServiceInterfase;
import com.aaq.col.clases.util.ValidarFormatosPlantillas;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("expedienteEjecutivoService")
@Transactional
public class ExpedienteEjecutivoService implements ExpedienteEjecutivoServiceInterfase {
	
	Log4JLogger loggerDownload = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.downloadFile");

	@Autowired
	@Qualifier("formatoInspeccionPesadoDao")
	FormatoInspeccionPesadoDao formatoInspeccionPesadoDao;

	@Autowired
	@Qualifier("formatoInspeccionMotoDao")
	FormatoInspeccionMotoDao formatoInspeccionMotoDao;

	@Autowired
	@Qualifier("formatoInventarioAutomovilesDao")
	FormatoInventarioAutomovilesDao formatoInventarioAutomovilesDao;

	@Autowired
	@Qualifier("formatoCuestionarioRoboDao")
	FormatoCuestionarioRoboDao formatoCuestionarioRoboDao;

	@Autowired
	@Qualifier("formatoReciboPagoDeducibleDao")
	FormatoReciboPagoDeducibleDao formatoReciboPagoDeducibleDao;

	@Autowired
	@Qualifier("formatoReciboIngresoSiniestroDao")
	FormatoReciboIngresoSiniestroDao formatoReciboIngresoSiniestroDao;

	@Autowired
	@Qualifier("formatoSolicitudDiagnosticoDao")
	FormatoSolicitudDiagnosticoDao formatoSolicitudDiagnosticoDao;

	@Autowired
	@Qualifier("formatoMemoriaDescriptivaDao")
	FormatoMemoriaDescriptivaDao formatoMemoriaDescriptivaDao;

	@Autowired
	@Qualifier("formatoOrdenServicioDao")
	FormatoOrdenServicioDao formatoOrdenServicioDao;

	@Autowired
	@Qualifier("formatoValeAmbulanciaDao")
	FormatoValeAmbulanciaDao formatoValeAmbulanciaDao;

	@Autowired
	@Qualifier("formatoReparacionBienesDao")
	FormatoReparacionBienesDao formatoReparacionBienesDao;

	@Autowired
	@Qualifier("formatoGarantiaPrendariaDao")
	FormatoGarantiaPrendariaDao formatoGarantiaPrendariaDao;

	@Autowired
	@Qualifier("formatoAsignacionAbogadoDao")
	FormatoAsignacionAbogadoDao formatoAsignacionAbogadoDao;

	@Autowired
	@Qualifier("formatoNuevosVehiculosDao")
	FormatoNuevosVehiculosDao formatoNuevosVehiculosDao;

	@Autowired
	@Qualifier("expedienteEjecutivoDao")
	ExpedienteEjecutivoDao expedienteEjecutivoDao;
	
	@Autowired
	@Qualifier("formatoAsistenciaVialDao")
	FormatoAsistenciaVialDao formatoAsistenciaVialDao;

	@Autowired
	@Qualifier("formatoEncuestaServicioDao")
	FormatoEncuestaServicioDao formatoEncuestaServicioDao;

	@Autowired
	@Qualifier("formatoReclamacionPendienteDao")
	FormatoReclamacionPendienteDao formatoReclamacionPendienteDao;

	@Autowired
	@Qualifier("formatoAdmisionAutomovilesDao")
	FormatoAdmisionAutomovilesDao formatoAdmisionAutomovilesDao;

	@Autowired
	@Qualifier("formatoAdmisionMotocicletasDao")
	FormatoAdmisionMotocicletasDao formatoAdmisionMotocicletasDao;

	@Autowired
	@Qualifier("formatoAdmisionPesadoDao")
	FormatoAdmisionPesadoDao formatoAdmisionPesadoDao;

	@Autowired
	@Qualifier("formatoDeclaracionUniversalDao")
	FormatoDeclaracionUniversalDao formatoDeclaracionUniversalDao;

	@Autowired
	@Qualifier("formatoPaseMedicoDao")
	FormatoPaseMedicoDao formatoPaseMedicoDao;

	@Autowired
	@Qualifier("formatoCatalogosDao")
	FormatoCatalogosDao formatoCatalogosDao;
	
	@Autowired
	@Qualifier("formatoCargoTarjetaCreditoDao")
	FormatoCargoTarjetaCreditoDao formatoCargoTarjetaCreditoDao;
	
	@Autowired
	@Qualifier("formatoResponsabilidadCivilDao")
	FormatoResponsabilidadCivilDao formatoResponsabilidadCivilDao;
	
	@Autowired
	@Qualifier("formatoReparacionBienesDiversosDao")
	FormatoReparacionBienesDiversosDao formatoReparacionBienesDiversosDao;
	
	@Autowired
	@Qualifier("formatoObservacionesAseguradoDao")
	FormatoObservacionesAseguradoDao formatoObservacionesAseguradoDao;
	
	@Autowired
	@Qualifier("formatoInventarioUnicoPesadoDao")
	FormatoInventarioUnicoPesadoDao formatoInventarioUnicoPesadoDao;
	
	@Autowired
	@Qualifier("formatoReclamacionComprobantePeajeDao")
	FormatoReclamacionComprobantePeajeDao formatoReclamacionComprobantePeajeDao;
	
	public static final String TIPO_DOCUMENTO = "QSID";

	public static final String FORMATO_RECLAMACION_PENDIENTE = "QS19";

	public static final String FORMATO_ENCUESTA_SERVICIO = "QS25";

	public static final String FORMATO_ASISTENCIA_VIAL = "QS65";

	public static final String FORMATO_NUEVOS_VEHICULOS = "QS60";

	public static final String FORMATO_PASE_MEDICO = "QS07";

	public static final String FORMATO_ASIGNACION_ABOGADO = "LE29";

	public static final String FORMATO_GARANTIA_PRENDARIA = "GN08";

	public static final String FORMATO_REPARACION_BIENES = "QS53";

	public static final String FORMATO_VALE_AMBULANCIA = "QS21";

	public static final String FORMATO_ORDEN_SERVICIO = "QS62";

	public static final String FORMATO_DECLARACION_UNIVERSAL = "QSD1";

	public static final String FORMATO_INVENTARIO_AUTOMOVILES = "QS03";

	public static final String FORMATO_CUESTIONARIO_ROBO = "RO01";

	public static final String FORMATO_ADMISION_AUTOMOVILES = "QS08";

	public static final String FORMATO_ADMISION_MOTOCICLETAS = "QS63";

	public static final String FORMATO_ADMISION_PESADO = "PESADO";

	public static final String F_INSPECCION_PESADO = "QS0000";

	public static final String F_INSPECCION_MOTO = "Q00000";

	public static final String FORMATO_RECIBO_INGRESO = "QS11";

	public static final String FORMATO_RECIBO_DEDUCIBLE = "QS10";

	public static final String FORMATO_SOLICITUD_DIAGNOSTICO = "GN71";

	public static final String FORMATO_MEMORIA_DESCRIPTIVA = "QS42";
	
	public static final String FORMATO_CARGO_TARJETA = "QE26";

	public static final String FORMATO_RESPONSABILIDAD_CIVIL= "RC03";
	
	public static final String FORMATO_BIENES_DIVERSOS= "QS57";
	
	public static final String FORMATO_OBSERVACIONES_ASEGURADO= "OB01";
	
	public static final String FORMATO_INVENTARIO_PESADO= "QS3A";
	
	public static final String FORMATO_RECLAMACION_COMPROBANTE_PEAJE= "QS41";
	
	
	@Override
	public ExpedienteEjecutivo objetoExpediente(String id, String nombreFormato, String reporte)  {
		return this.expedienteEjecutivoDao.objetoExpediente(id, nombreFormato, reporte);
	}

	@Override
	public List<ExpedienteEjecutivo> listaDeExpedientesNoEnviados(Estado edo, Integer base, Integer terminal, Date fechaInicio,
			Date fechaFin, String reporte, String nombreFormato, Boolean noSftp, Boolean noEmail, Boolean sftp, Boolean email) {
		return this.expedienteEjecutivoDao.listaDeExpedientesNoEnviado(edo, base, terminal, fechaInicio,
				fechaFin, reporte, nombreFormato, noSftp, noEmail, sftp, email);
	}

	@Override
	public JMResultadoOperacion funcionExpedienteError(ErrorFormatos datos) {
		return this.expedienteEjecutivoDao.funcionExpedienteError(datos);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(ExpedienteEjecutivo ed) {
		return this.expedienteEjecutivoDao.eliminarObjeto(ed);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(ExpedienteEjecutivo ed) {
		return this.expedienteEjecutivoDao.guardarObjeto(ed);
	}
	
	@Override
	public  List<EntidadObjeto> obtenerContador(String reporte) {
		return this.expedienteEjecutivoDao.obtenerContador(reporte);
	}
	
	@Override
	public ExpedienteEjecutivo funcionSeleccionaByFormato(int id)  {
		return this.expedienteEjecutivoDao.funcionSeleccionaByIdFormato(id);
	}

	public String nombre = null;

	@Override
	public String nombrarPDF()  {
		return nombre;
	}

	//
	@Override
	public boolean generePDF(int id, int numeroFormato, OutputStream ou)  {
	
		ValidarFormatosPlantillas genera = new ValidarFormatosPlantillas();
		List<FormatoCatalogos> datosCatalogos;
		datosCatalogos = formatoCatalogosDao.listaDeFormatoCatalogos();
		
		switch (numeroFormato) {
		case 1:
			try {
				FormatoReclamacionPendiente formatoReclamacionPendiente = new FormatoReclamacionPendiente();

				String idCadena = String.valueOf(id);
				formatoReclamacionPendiente = formatoReclamacionPendienteDao
						.objetoFormatoReclamacionPendiente(idCadena);
				genera.procesoReclamacionPendienteError(formatoReclamacionPendiente, ou);

			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.FormatoReclamacionPendiente=> ",e);
				e.getMessage();
			}
			break;
		case 2:
			try {
				FormatoEncuestaServicio formatoEncuestaServicio = new FormatoEncuestaServicio();
				String idCadena = String.valueOf(id);
				formatoEncuestaServicio = formatoEncuestaServicioDao.objetoFormatoEncuestaServicio(idCadena);
				genera.procesoEncuestaServicioError(formatoEncuestaServicio, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoEncuestaServicio=> ",e);
				e.getMessage();
			}
			break;

		case 3:
			try {
				FormatoAsistenciaVial formatoAsistenciaVial = new FormatoAsistenciaVial();
				String idCadena = String.valueOf(id);
				formatoAsistenciaVial = formatoAsistenciaVialDao.objetoFormatoAsistenciaVial(idCadena);
				genera.procesoAsistenciaVialError(formatoAsistenciaVial, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoAsistenciaVial=> ",e);
				e.getMessage();
			}
			break;

		case 4:
			try {
				FormatoNuevosVehiculos formatoNuevosVehiculos = new FormatoNuevosVehiculos();
				String idCadena = String.valueOf(id);
				formatoNuevosVehiculos = formatoNuevosVehiculosDao.objetoFormatoNuevosVehiculos(idCadena);
				genera.procesoNuevosVehiculosError(formatoNuevosVehiculos, datosCatalogos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF. formatoNuevosVehiculos=> ",e);
				e.getMessage();
			}
			break;

		case 5:
			try {
				FormatoPaseMedico formatoPaseMedico = new FormatoPaseMedico();
				String idCadena = String.valueOf(id);
				formatoPaseMedico = formatoPaseMedicoDao.objetoFormatoPaseMedico(idCadena);
				genera.procesoPaseMedicoError(formatoPaseMedico, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoPaseMedico=> ",e);
				e.getMessage();
			}
			break;

		case 6:
			try {
				FormatoAsignacionAbogado formatoAsignacionAbogado = new FormatoAsignacionAbogado();
				String idCadena = String.valueOf(id);
				formatoAsignacionAbogado = formatoAsignacionAbogadoDao.objetoFormatoAsignacionAbogado(idCadena);
				genera.procesoAsignacionAbogadoError(formatoAsignacionAbogado, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoAsignacionAbogado=> ",e);
				e.getMessage();
			}
			break;

		case 7:
			try {
				FormatoAdmisionAutomoviles formatoAdmisionAutomoviles = new FormatoAdmisionAutomoviles();
				String idCadena = String.valueOf(id);
				formatoAdmisionAutomoviles = formatoAdmisionAutomovilesDao.objetoFormatoAdmisionAutomoviles(idCadena);
				genera.procesoAdmisionAutomovilesError(formatoAdmisionAutomoviles, datosCatalogos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.FormatoAdmisionAutomoviles => ",e);
				e.getMessage();
			}
			break;

		case 8:
			try {
				FormatoAdmisionMotocicletas formatoAdmisionMotocicletas = new FormatoAdmisionMotocicletas();
				String idCadena = String.valueOf(id);
				formatoAdmisionMotocicletas = formatoAdmisionMotocicletasDao
						.objetoFormatoAdmisionMotocicletas(idCadena);
				genera.procesoAdmisionMotocicletasError(formatoAdmisionMotocicletas, datosCatalogos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoAdmisionMotocicletas=> ",e);
				e.getMessage();
			}
			break;

		case 9:
			try {
				FormatoGarantiaPrendaria formatoGarantiaPrendaria = new FormatoGarantiaPrendaria();
				String idCadena = String.valueOf(id);
				formatoGarantiaPrendaria = formatoGarantiaPrendariaDao.objetoFormatoGarantiaPrendaria(idCadena);
				genera.procesoGarantiaPrendariaError(formatoGarantiaPrendaria, ou);
			} catch (Exception e) {
				this.loggerDownload.info("Ocurrio un error en generarPDF: "+e);
				e.getMessage();
			}
			break;

		case 10:
			try {
				FormatoReparacionBienes formatoReparacionBienes = new FormatoReparacionBienes();
				String idCadena = String.valueOf(id);
				formatoReparacionBienes = formatoReparacionBienesDao.objetoFormatoReparacionBienes(idCadena);
				genera.procesoReparacionBienesError(formatoReparacionBienes, datosCatalogos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoReparacionBienes=> ",e);
				e.getMessage();
			}
			break;

		case 11:
			try {
				FormatoValeAmbulancia formatoValeAmbulancia = new FormatoValeAmbulancia();
				String idCadena = String.valueOf(id);
				formatoValeAmbulancia = formatoValeAmbulanciaDao.objetoFormatoValeAmbulancia(idCadena);
				genera.procesoFValeAmbulanciaError(formatoValeAmbulancia, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoValeAmbulancia=> ",e);
				e.getMessage();
			}
			break;

		case 12:
			try {
				FormatoOrdenServicio formatoOrdenServicio = new FormatoOrdenServicio();
				String idCadena = String.valueOf(id);
				formatoOrdenServicio = formatoOrdenServicioDao.objetoFormatoOrdenServicio(idCadena);
				genera.procesoFOrdenServicioError(formatoOrdenServicio, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoOrdenServicio ",e);
				e.getMessage();
			}
			break;

		case 13:
			try {
				FormatoInspeccionPesado formatoInspeccionPesado = new FormatoInspeccionPesado();
				String idCadena = String.valueOf(id);
				formatoInspeccionPesado = formatoInspeccionPesadoDao.objetoFormatoInspeccionPesado(idCadena);
				genera.procesoInspeccionPesadoError(formatoInspeccionPesado, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoInspeccionPesado=> ",e);
				e.getMessage();
			}
			break;

		case 14:
			try {
				FormatoInspeccionMoto formatoInspeccionMoto = new FormatoInspeccionMoto();
				String idCadena = String.valueOf(id);
				formatoInspeccionMoto = formatoInspeccionMotoDao.objetoFormatoInspeccionMoto(idCadena);
				genera.procesoInspeccionMotoError(formatoInspeccionMoto, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoInspeccionMoto=> ",e);
				e.getMessage();
			}
			break;

		case 15:
			try {
				FormatoAdmisionPesado formatoAdmisionPesado = new FormatoAdmisionPesado();
				String idCadena = String.valueOf(id);
				formatoAdmisionPesado = formatoAdmisionPesadoDao.objetoFormatoAdmisionPesado(idCadena);
				genera.procesoAdmisionPesadoError(formatoAdmisionPesado, datosCatalogos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoAdmisionPesado=> ",e);
				e.getMessage();
			}
			break;

		case 16:
			try {
				FormatoInventarioAutomoviles formatoInventarioAutomoviles = new FormatoInventarioAutomoviles();
				String idCadena = String.valueOf(id);
				formatoInventarioAutomoviles = formatoInventarioAutomovilesDao
						.objetoFormatoInventarioAutomoviles(idCadena);
				genera.procesoInventarioAutomovilesCompletoError(formatoInventarioAutomoviles, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoInventarioAutomoviles=> ",e);
				e.getMessage();
			}
			break;

		case 17:
			try {
				FormatoCuestionarioRobo formatoCuestionarioRobo = new FormatoCuestionarioRobo();
				String idCadena = String.valueOf(id);
				formatoCuestionarioRobo = formatoCuestionarioRoboDao.objetoFormatoCuestionarioRobo(idCadena);
				genera.procesoCuestionarioRoboCompletoError(formatoCuestionarioRobo, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoCuestionarioRobo=> ",e);
				e.getMessage();
			}
			break;
		case 18:
			try {

				FormatoDeclaracionUniversal formatoDeclaracionUniversal = new FormatoDeclaracionUniversal();
				String idCadena = String.valueOf(id);
				formatoDeclaracionUniversal = formatoDeclaracionUniversalDao
						.objetoFormatoDeclaracionUniversal(idCadena);
				genera.procesoDeclaracionUniversalCompletoError(formatoDeclaracionUniversal, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoDeclaracionUniversal=> ",e);
				e.getMessage();
			}
			break;

		case 19:
			try {
				FormatoReciboPagoDeducible formatoReciboPagoDeducible = new FormatoReciboPagoDeducible();
				String idCadena = String.valueOf(id);
				formatoReciboPagoDeducible = formatoReciboPagoDeducibleDao.objetoFormatoReciboPagoDeducible(idCadena);
				genera.procesoReciboPagoDeducibleError(formatoReciboPagoDeducible, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDFformatoReciboPagoDeducible=> ",e);
				e.getMessage();
			}
			break;

		case 20:
			try {
				FormatoReciboIngresoSiniestro formatoReciboIngresoSiniestro = new FormatoReciboIngresoSiniestro();
				String idCadena = String.valueOf(id);
				formatoReciboIngresoSiniestro = formatoReciboIngresoSiniestroDao
						.objetoFormatoReciboIngresoSiniestro(idCadena);
				genera.procesoReciboIngresoSiniestroError(formatoReciboIngresoSiniestro, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoReciboIngresoSiniestro=> ",e);
				e.getMessage();
			}
			break;

		case 21:
			try {
				FormatoSolicitudDiagnostico formatoSolicitudDiagnostico = new FormatoSolicitudDiagnostico();
				String idCadena = String.valueOf(id);
				formatoSolicitudDiagnostico = formatoSolicitudDiagnosticoDao
						.objetoFormatoSolicitudDiagnostico(idCadena);
				genera.procesoSolicitudDiagnosticoError(formatoSolicitudDiagnostico, datosCatalogos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoSolicitudDiagnostico=> ",e);
				e.getMessage();
			}
			break;
		case 22:
			try {
				FormatoMemoriaDescriptiva formatoMemoriaDescriptiva = new FormatoMemoriaDescriptiva();
				String idCadena = String.valueOf(id);
				formatoMemoriaDescriptiva = formatoMemoriaDescriptivaDao.objetoFormatoMemoriaDescriptiva(idCadena);
				genera.procesoMemoriaDescriptivaError(formatoMemoriaDescriptiva, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoMemoriaDescriptiva=> ",e);
				e.getMessage();
			}
			break;
			
		case 24:
			try {
				FormatoCargoTarjetaCredito formatoCargoTarjetaCredito = new FormatoCargoTarjetaCredito();
				String idCadena = String.valueOf(id);
				formatoCargoTarjetaCredito = formatoCargoTarjetaCreditoDao.objetoFormatoCargoTarjetaCredito(idCadena);
				genera.procesoCargoTarjetaCreditoError(formatoCargoTarjetaCredito, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoCargoTarjetaCredito=> ",e);
				e.getMessage();
			}
			break;
		case 25:
			try {
				FormatoResponsabilidadCivil formatoResponsabilidadCivil = new FormatoResponsabilidadCivil();
				String idCadena = String.valueOf(id);
				formatoResponsabilidadCivil = formatoResponsabilidadCivilDao.objetoFormatoResponsabilidadCivil(idCadena);
				genera.procesoResponsabilidadCivilError(formatoResponsabilidadCivil, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoResponsabilidadCivil=> ",e);
				e.getMessage();
			}
			break;
		case 26:
			try {
				FormatoReparacionBienesDiversos formatoReparacionBienesDiversos = new FormatoReparacionBienesDiversos();
				String idCadena = String.valueOf(id);
				formatoReparacionBienesDiversos = formatoReparacionBienesDiversosDao.objetoFormatoReparacionBienesDiversos(idCadena);
				genera.procesoBienesDiversosError(formatoReparacionBienesDiversos, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoReparacionBienesDiversos=> ",e);
				e.getMessage();
			}
			break;
			
		case 27:
			try {
				FormatoObservacionesAsegurado formatoObservacionesAsegurado = new FormatoObservacionesAsegurado();
				String idCadena = String.valueOf(id);
				formatoObservacionesAsegurado = formatoObservacionesAseguradoDao.objetoFormatoObservacionesAsegurado(idCadena);
				genera.procesoObservacionesAseguradoError(formatoObservacionesAsegurado, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoObservacionesAsegurado=> ",e);
				e.getMessage();
			}
			break;
			
		case 28:
			try {
				FormatoInventarioUnicoPesado formatoInventarioUnicoPesado = new FormatoInventarioUnicoPesado();
				String idCadena = String.valueOf(id);
				formatoInventarioUnicoPesado = formatoInventarioUnicoPesadoDao.objetoFormatoInventarioUnicoPesado(idCadena);
				genera.procesoInventarioUnicoPesadoError(formatoInventarioUnicoPesado, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoInventarioUnicoPesado=> ",e);
				e.getMessage();
			}
			break;
			
			
		case 29:
			try {
				FormatoReclamacionComprobantePeaje formatoReclamacionComprobantePeaje = new FormatoReclamacionComprobantePeaje();
				String idCadena = String.valueOf(id);
				formatoReclamacionComprobantePeaje = formatoReclamacionComprobantePeajeDao.objetoFormatoReclamacionComprobantePeaje(idCadena);
				genera.procesoReclamacionComprobantePeajeError(formatoReclamacionComprobantePeaje, ou);
			} catch (Exception e) {
				this.loggerDownload.error("Ocurrio un error en generarPDF.formatoReclamacionComprobantePeaje=> ",e);
				e.getMessage();
			}
			break;

		}
		return false;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public ExpedienteEjecutivo funcionSeleccionaByIdFormato(int id) {
		return this.expedienteEjecutivoDao.funcionSeleccionaByIdFormato(id);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTableroEjecutivo(Terminal term, String nombreFormato,
			String claveProveedor, String reporte, Integer folio, boolean esAjusteExpres) {
		return this.expedienteEjecutivoDao.ejecutarFuncionTableroEjecutivo(term, nombreFormato, claveProveedor, reporte, folio, esAjusteExpres);
	}

	@Override
	public List<EntidadObjeto> listaDeFormatosParaGrafica(Date fechaInicial, Date fechaFinal, Integer limite,
			Integer edo, Integer base, String claveAjustador, String nombreFormato, Integer terminal, String reporte) {
		return this.expedienteEjecutivoDao.listaDeFormatosParaGrafica(fechaInicial, fechaFinal, limite, edo, base,
				claveAjustador, nombreFormato, terminal, reporte);
	}

	@Override
	public List<EntidadObjetoQuinto> obtenerContadorTotal(Date fechaInicial, Date fechaFinal, Integer edo, Integer base,
			String nombreFormato, Terminal terminal, String reporte) {
		return this.expedienteEjecutivoDao.obtenerContadorTotal(fechaInicial, fechaFinal, edo, base, nombreFormato, terminal, reporte);
	}

	@Override
	public List<ExpedienteEjecutivo> listaDocumentos(String reporte, String claveAjustador) {
		return this.expedienteEjecutivoDao.listaDocumentos(reporte, claveAjustador);
	}
	public  List<ExpedienteEjecutivo> listaDeExpedientesExcel(Estado edo, Integer base, Integer terminal, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato){
		return this.expedienteEjecutivoDao.listaDeExpedientesExcel(edo, base, terminal, fechaInicio, fechaFin, reporte, nombreFormato);
	}

	@Override
	public List<EntidadObjeto> docEnviado(String nombreFormato, Terminal term, String reporte) {
		return this.expedienteEjecutivoDao.docEnviado(nombreFormato, term, reporte);
	}
	


}
