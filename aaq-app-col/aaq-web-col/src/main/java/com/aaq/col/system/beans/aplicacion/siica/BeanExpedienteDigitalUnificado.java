	package com.aaq.col.system.beans.aplicacion.siica;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.io.ByteArrayOutputStream;
	import java.io.IOException;
	import java.util.NoSuchElementException;
	
	import javax.annotation.PostConstruct;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;
	import javax.faces.context.ExternalContext;
	import javax.faces.context.FacesContext;
	import javax.faces.event.ActionEvent;
	
	import org.apache.commons.lang3.StringUtils;
	import org.apache.commons.lang3.math.NumberUtils;
	import org.primefaces.model.chart.Axis;
	import org.primefaces.model.chart.AxisType;
	//import org.primefaces.model.chart.BarChartModel;
	import org.primefaces.model.chart.ChartSeries;
	import org.primefaces.model.chart.HorizontalBarChartModel;
	import org.primefaces.model.chart.LegendPlacement;
	import org.primefaces.model.chart.PieChartModel;
	import javax.persistence.PersistenceException;
	
	import org.apache.commons.lang3.time.DateFormatUtils;
	import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ExpedienteEjecutivo;
import com.aaq.col.clases.database.entidades.FormatoAdmisionAutomoviles;
import com.aaq.col.clases.database.entidades.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.database.entidades.FormatoAdmisionPesado;
import com.aaq.col.clases.database.entidades.FormatoAsignacionAbogado;
import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;
import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
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
import com.aaq.col.clases.database.entidades.MetricaED;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.aaq.col.clases.util.UtileriaNumeros;
import com.aaq.col.clases.util.ValidarFormatosPlantillas;
	import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
	import com.aaq.col.system.database.entidades.modelo.ExpedienteEjecutivoModel;
	import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
	import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
	import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
	
	import jxl.Workbook;
	import jxl.format.Alignment;
	import jxl.format.Border;
	import jxl.format.BorderLineStyle;
	import jxl.format.Colour;
	import jxl.format.UnderlineStyle;
	import jxl.format.VerticalAlignment;
	import jxl.write.Label;
	import jxl.write.WritableCellFormat;
	import jxl.write.WritableFont;
	import jxl.write.WritableSheet;
	import jxl.write.WritableWorkbook;
	import jxl.write.WriteException;
	
@ManagedBean(name ="beanExpedienteDigitalUnificado")
@SessionScoped
public class BeanExpedienteDigitalUnificado  extends JMBeanExtensiblePrincipal<ExpedienteEjecutivo> {
	
	private static final long serialVersionUID = -2790320349430209112L;
	
	private ExpedienteEjecutivo objetoActua;
	private String docDescargar;
	private String txtNumeroReporte;
	private String txtFaltantesCorreo;
	private String txtFaltantesQContent;
	private String txtNumeroReporteBuscar;
	private String _filtroNombreF;
	private String txtExitoCorreo;
	private String txtErrorCorreo;
	private String txtExitoSFTP;
	private String txtErrorSFTP;
	private String txtExitoCorreoPorc;
	private String txtErrorCorreoPorc;
	private String txtExitoSFTPPorc;
	private String txtErrorSFTPPorc;
	private String txtTotalCont;
	private boolean noSftp = false;
	private boolean noEmail = false;
	
	private Boolean botonSftp = Boolean.FALSE;
	private Boolean botonNoSftp = Boolean.FALSE;
	private Boolean botonEmail = Boolean.FALSE;
	private Boolean botonNoEmail = Boolean.FALSE;
	
	private String txtOAAuto;
	private String txtOAMoto;
	private String txtOAEP;
	private String txtDua;
	private String txtTotalMetrica;
	private String txtReportesDocs;
	private String txtTotalRepOAA;
	private String txtTotalRepOAM;
	private String txtTotalRepOAE;
	private String txtTotalRepDUA;
	
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
	
	//**GRAFICAS
	private PieChartModel pieModel;
	private HorizontalBarChartModel horizontalBarModel;
	    
	@PostConstruct  
	    public void init() {  
	createModels();  
	    }
	
	public BeanExpedienteDigitalUnificado() {
	super();
	this.actualizarGrafica();
	}
	
	ValidarFormatosPlantillas validarF = new ValidarFormatosPlantillas();
	
	public void cambiarValoresEmail() {
		this.setBotonEmail(true);
		this.setBotonNoEmail(false);
		this.setBotonSftp(false);
		this.setBotonNoSftp(false);
	}
	
	public void cambiarValoresSftp() {
		this.setBotonEmail(false);
		this.setBotonNoEmail(false);
		this.setBotonSftp(true);
		this.setBotonNoSftp(false);
	}
	
	public void cambiarValoresErrorEmail() {
		this.setBotonEmail(false);
		this.setBotonNoEmail(true);
		this.setBotonSftp(false);
		this.setBotonNoSftp(false);
	}
	
	public void cambiarValoresSErrorftp() {
		this.setBotonEmail(false);
		this.setBotonNoEmail(false);
		this.setBotonSftp(false);
		this.setBotonNoSftp(true);
	}
	
	
	
	@Override
	public void actualizarListado() {
	}
	
	public void actualizarListadoNuevo() {
	if((this.getTxtFechaInicio() != null)
	&& (this.getTxtFechaFin() != null)
	&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
	this.ponerMensajeAdvertencia("Los formatos digitales estan limitado a 31 días naturales.");
	return;
	}
	if (this.getBotonEmail() || this.getBotonSftp()) {
		if (StringUtils.isBlank(this.get_filtroNombreF()) || this.get_filtroNombreF().contains("todos")) {
			this.ponerMensajeAdvertencia("Es necesario especificar el Nombre del Formato a consultar.");
			return;
		}
	}
	try {
	int idAjustador=-999;
	int baseId = -999;
	try {
		if (StringUtils.isNotBlank(this.getIdTerminal())) {
			idAjustador = Integer.parseInt(this.getIdTerminal());
		}
		if (StringUtils.isNotBlank(this.getIdBase())) {
			baseId = Integer.parseInt(this.getIdBase());
		}
	} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
	
	}
	
	if (getPermisoTodosEstados() && getPermisoTodosBases()){
	if(!this.getIdEstado().equals("9999") ) {
	if(!getIdEstado().equals("null")  ) {
	if ( Integer.parseInt(this.getIdBase()) > 0) {
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel( this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(this.getEstadoService().objetoEstado(this.getIdEstado()),
		baseId, idAjustador , this.getTxtFechaInicio(), this.getTxtFechaFin(), 
		this.getTxtNumeroReporte(), this.get_filtroNombreF(), this.getBotonNoSftp(), this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
	return ;
	} else {
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel( this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(this.getEstadoService().objetoEstado(this.getIdEstado()),
		null, idAjustador , this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.get_filtroNombreF(),
		this.getBotonNoSftp(), this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
	return;
	}
	}
	}else {
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel( this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(
		null, null, idAjustador, this.getTxtFechaInicio(), this.getTxtFechaFin(),
		this.getTxtNumeroReporte(), this.get_filtroNombreF(), this.getBotonNoSftp(), this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
	return;
	}
	
	} else {
	if (this.getIdEstado().equals("9999")){
		if (Integer.parseInt(this.getIdBase()) < 0)
		{
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel( this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(
		 this.getEstadoService().objetoEstado(this.getIdEstado()), null, idAjustador,
		 this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.get_filtroNombreF(), this.getBotonNoSftp(),
		 this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
		return;
		} else {
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel(this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(
		 this.getEstadoService().objetoEstado(this.getIdEstado()), baseId, idAjustador,
		 this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.get_filtroNombreF(), this.getBotonNoSftp(), this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
		return;
		}
	} else {
	if (Integer.parseInt(this.getIdBase()) < 0)
	{
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel( this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(
		null, null, idAjustador, this.getTxtFechaInicio(), 
		this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.get_filtroNombreF(), this.getBotonNoSftp(), this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
		return;
	} else {
		ExpedienteEjecutivoModel data = new ExpedienteEjecutivoModel( this.getExpedienteEjecutivoService().listaDeExpedientesNoEnviados(
		 this.getEstadoService().objetoEstado(this.getIdEstado()), baseId, 
		 idAjustador, this.getTxtFechaInicio(), this.getTxtFechaFin(), 
		 this.getTxtNumeroReporte(), this.get_filtroNombreF(), this.getBotonNoSftp(), this.getBotonNoEmail(), this.getBotonSftp(), this.getBotonEmail()));
		this.setListado(data);
		return;
	}
	}
	}
	
	} catch (Exception e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
	}
	
	
	}
	
	
	
	public ArrayList<JMColumna> getColumnas() {
	return new JMListadoColumna(new String[] { "Num. Folio,folio","Fecha,fecha,fecha","Evento,causa","Ajustador,terminal",
	"Reporte,reporte","Estado/Base,edoBase","Expediente,nombreExpediente" }).getLista();
	}
	
	public void doAccionDescargaPDF() {
	this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
	try {
	  if ( !this.getObjetoABM().isSftp() || !this.getObjetoABM().isCorreo()) {
	if (this.getObjetoABM().getIdFReclamacionPend() != null && this.getObjetoABM().getIdFReclamacionPend() != 0 ) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf"); 
	 String fileName = null;
	 FormatoReclamacionPendiente formatoReclamacionPendiente = new FormatoReclamacionPendiente();
	 String idCadena = String.valueOf(getObjetoABM().getIdFReclamacionPend());
	formatoReclamacionPendiente = this.getFormatoReclamacionPendienteService() 
	.objetoFormatoReclamacionPendiente(idCadena);
	if (formatoReclamacionPendiente!= null ) {
	int tipoAfec = validarF.validarAsegurado(formatoReclamacionPendiente.getRpAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_RECLAMACION_PENDIENTE, this.getObjetoABM().getReporte(),
	formatoReclamacionPendiente.getRpNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	    this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFReclamacionPend(), 1, ec.getResponseOutputStream());
	    fc.responseComplete();
	}
	}
	if (this.getObjetoABM().getIdFEncuesta() != null && this.getObjetoABM().getIdFEncuesta() != 0) {
	 FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	      String fileName = null;
	     FormatoEncuestaServicio formatoEncuestaServicio = new FormatoEncuestaServicio();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFEncuesta());
	formatoEncuestaServicio = this.getFormatoEncuestaServicioService().objetoFormatoEncuestaServicio(idCadena); 
	
	int tipoAfec = validarF.validarAsegurado(formatoEncuestaServicio.getEsAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ENCUESTA_SERVICIO, formatoEncuestaServicio.getEsNumReporte(),
	formatoEncuestaServicio.getEsNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFEncuesta(), 2, ec.getResponseOutputStream());
	fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFAsistenciaVial() != null && this.getObjetoABM().getIdFAsistenciaVial() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoAsistenciaVial formatoAsistenciaVial = new FormatoAsistenciaVial();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFAsistenciaVial());
	formatoAsistenciaVial = this.getFormatoAsistenciaVialService().objetoFormatoAsistenciaVial(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoAsistenciaVial.getAvAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ASISTENCIA_VIAL,formatoAsistenciaVial.getAvNumReporte(),
	formatoAsistenciaVial.getAvNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFAsistenciaVial(), 3, ec.getResponseOutputStream());
	fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFNuevoVehi() != null && this.getObjetoABM().getIdFNuevoVehi() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null; 
	 FormatoNuevosVehiculos formatoNuevosVehiculos = new FormatoNuevosVehiculos();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFNuevoVehi());
	formatoNuevosVehiculos = this.getFormatoNuevosVehiculosService().objetoFormatoNuevosVehiculos(idCadena);
	
	int tipoAfec = validarF.validarAsegurado(formatoNuevosVehiculos.getNvAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_NUEVOS_VEHICULOS, formatoNuevosVehiculos.getNvNumReporte(),
	formatoNuevosVehiculos.getNvNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFNuevoVehi(), 4, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFPaseMed() != null && this.getObjetoABM().getIdFPaseMed() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoPaseMedico formatoPaseMedico = new FormatoPaseMedico();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFPaseMed());
	formatoPaseMedico = this.getFormatoPaseMedicoService().objetoFormatoPaseMedico(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoPaseMedico.getPmAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_PASE_MEDICO, formatoPaseMedico.getPmNumReporte(),
	formatoPaseMedico.getPmNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFPaseMed(), 5, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFAsignacionAbog() != null && this.getObjetoABM().getIdFAsignacionAbog() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoAsignacionAbogado formatoAsignacionAbogado = new FormatoAsignacionAbogado();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFAsignacionAbog());
	formatoAsignacionAbogado = this.getFormatoAsignacionAbogadoService().objetoFormatoAsignacionAbogado(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoAsignacionAbogado.getAaAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ASIGNACION_ABOGADO, formatoAsignacionAbogado.getAaNumReporte(),
	formatoAsignacionAbogado.getAaNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFAsignacionAbog(), 6, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFAdmisionAuto() != null && this.getObjetoABM().getIdFAdmisionAuto() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoAdmisionAutomoviles formatoAdmisionAutomoviles = new FormatoAdmisionAutomoviles();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFAdmisionAuto());
	formatoAdmisionAutomoviles = this.getFormatoAdmisionAutomovilesService().objetoFormatoAdmisionAutomoviles(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoAdmisionAutomoviles.getOaAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ADMISION_AUTOMOVILES,formatoAdmisionAutomoviles.getOaNumReporte(),
	formatoAdmisionAutomoviles.getOaNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	 this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFAdmisionAuto(), 7, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFAdmisionMoto() != null && this.getObjetoABM().getIdFAdmisionMoto() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoAdmisionMotocicletas formatoAdmisionMotocicletas = new FormatoAdmisionMotocicletas();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFAdmisionMoto());
	formatoAdmisionMotocicletas = this.getFormatoAdmisionMotocicletasService()
	.objetoFormatoAdmisionMotocicletas(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoAdmisionMotocicletas.getOaAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ADMISION_MOTOCICLETAS, formatoAdmisionMotocicletas.getOaNumReporte(),
	formatoAdmisionMotocicletas.getOaNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFAdmisionMoto(), 8, ec.getResponseOutputStream());
	 
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFGarantiaPrendaria() != null && this.getObjetoABM().getIdFGarantiaPrendaria() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoGarantiaPrendaria formatoGarantiaPrendaria = new FormatoGarantiaPrendaria();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFGarantiaPrendaria() );
	formatoGarantiaPrendaria = this.getFormatoGarantiaPrendaria().objetoFormatoGarantiaPrendaria(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoGarantiaPrendaria.getGpAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_GARANTIA_PRENDARIA, formatoGarantiaPrendaria.getGpNumReporte(),
	formatoGarantiaPrendaria.getGpNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFGarantiaPrendaria(), 9, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFReparacionBienes() != null && this.getObjetoABM().getIdFReparacionBienes() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoReparacionBienes formatoReparacionBienes = new FormatoReparacionBienes();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFReparacionBienes());
	formatoReparacionBienes = this.getFormatoReparacionBienesService().objetoFormatoReparacionBienes(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoReparacionBienes.getRbAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_REPARACION_BIENES, formatoReparacionBienes.getRbNumReporte(),
	formatoReparacionBienes.getRbNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFReparacionBienes(), 10, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFValeAmb() != null && this.getObjetoABM().getIdFValeAmb() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoValeAmbulancia formatoValeAmbulancia = new FormatoValeAmbulancia();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFValeAmb());
	formatoValeAmbulancia = this.getFormatoValeAmbulanciaService().objetoFormatoValeAmbulancia(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoValeAmbulancia.getVaAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_VALE_AMBULANCIA, formatoValeAmbulancia.getVaNumReporte(),
	formatoValeAmbulancia.getVaNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFValeAmb(), 11, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFOrdenServ() != null && this.getObjetoABM().getIdFOrdenServ() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoOrdenServicio formatoOrdenServicio = new FormatoOrdenServicio();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFOrdenServ());
	formatoOrdenServicio = this.getFormatoOrdenServicioService().objetoFormatoOrdenServicio(idCadena); 
	int tipoAfec = validarF.validarAsegurado(formatoOrdenServicio.getOsAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ORDEN_SERVICIO, formatoOrdenServicio.getOsNumReporte(),
	formatoOrdenServicio.getOsPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFOrdenServ(), 12, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFInspeccionPesado() != null && this.getObjetoABM().getIdFInspeccionPesado() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoInspeccionPesado formatoInspeccionPesado = new FormatoInspeccionPesado();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFInspeccionPesado());
	formatoInspeccionPesado = this.getFormatoInspeccionPesado().objetoFormatoInspeccionPesado(idCadena); 
	int tipoAfec = validarF.validarAsegurado(formatoInspeccionPesado.getIpAsegurado());
	fileName = validarF.nombrarArchivo(F_INSPECCION_PESADO, formatoInspeccionPesado.getIpNumReporte(),
	formatoInspeccionPesado.getIpNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFInspeccionPesado(), 13, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFInspeccionMoto() != null && this.getObjetoABM().getIdFInspeccionMoto() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoInspeccionMoto formatoInspeccionMoto = new FormatoInspeccionMoto();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFInspeccionMoto());
	formatoInspeccionMoto = this.getFormatoInspeccionMotoService().objetoFormatoInspeccionMoto(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoInspeccionMoto.getImAsegurado());
	fileName = validarF.nombrarArchivo(F_INSPECCION_MOTO, formatoInspeccionMoto.getImNumReporte(),
	formatoInspeccionMoto.getImNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFInspeccionMoto(), 14, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFAdmisionPesado() != null && this.getObjetoABM().getIdFAdmisionPesado() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoAdmisionPesado formatoAdmisionPesado = new FormatoAdmisionPesado();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFAdmisionPesado());
	formatoAdmisionPesado = this.getFormatoAdmisionPesadoService().objetoFormatoAdmisionPesado(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoAdmisionPesado.getOpAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_ADMISION_PESADO, formatoAdmisionPesado.getOpNumReporte(),
	formatoAdmisionPesado.getOpNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFAdmisionPesado(), 15, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFInventarioAuto() != null && this.getObjetoABM().getIdFInventarioAuto() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoInventarioAutomoviles formatoInventarioAutomoviles = new FormatoInventarioAutomoviles();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFInventarioAuto());
	formatoInventarioAutomoviles = this.getFormatoInventarioService()
	.objetoFormatoInventarioAutomoviles(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoInventarioAutomoviles.getIaAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_INVENTARIO_AUTOMOVILES,formatoInventarioAutomoviles.getIaNumReporte(),
	formatoInventarioAutomoviles.getIaNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	 this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFInventarioAuto(), 16, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFCuestionarioRobo() != null && this.getObjetoABM().getIdFCuestionarioRobo() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	FormatoCuestionarioRobo formatoCuestionarioRobo = new FormatoCuestionarioRobo();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFCuestionarioRobo());
	formatoCuestionarioRobo = this.getFormatoCuestionarioRoboService().objetoFormatoCuestionarioRobo(idCadena);
	int tipoAfec = validarF.validarAsegurado(formatoCuestionarioRobo.getCrAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_CUESTIONARIO_ROBO, formatoCuestionarioRobo.getCrNumReporte(),
	formatoCuestionarioRobo.getCrNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFCuestionarioRobo(), 17, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFDeclaracionU() != null && this.getObjetoABM().getIdFDeclaracionU() != 0) {
	
	FacesContext fc = FacesContext.getCurrentInstance();
	ExternalContext ec = fc.getExternalContext();
	ec.responseReset(); 
	ec.setResponseContentType("application/pdf");
	String fileName = null;
	FormatoDeclaracionUniversal formatoDeclaracionUniversal = new FormatoDeclaracionUniversal();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFDeclaracionU());
	formatoDeclaracionUniversal = this.getFormatoDeclaracionUniversal()
	.objetoFormatoDeclaracionUniversal(idCadena); 
	int tipoAfec = validarF.validarAsegurado(formatoDeclaracionUniversal.getDuAsegurado());
	fileName = validarF.nombrarArchivo(FORMATO_DECLARACION_UNIVERSAL, formatoDeclaracionUniversal.getDuNumReporte(),
	formatoDeclaracionUniversal.getDuNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	    this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFDeclaracionU(), 18, ec.getResponseOutputStream());
	fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFReciboPagoDed() != null && this.getObjetoABM().getIdFReciboPagoDed() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoReciboPagoDeducible formatoReciboPagoDeducible = new FormatoReciboPagoDeducible();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFReciboPagoDed() );
	formatoReciboPagoDeducible = this.getFormatoReciboPagoDeducible().objetoFormatoReciboPagoDeducible(idCadena);
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_RECIBO_DEDUCIBLE ,formatoReciboPagoDeducible.getRdNumReporte(),
	formatoReciboPagoDeducible.getRdNumPoliza(),""+tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFReciboPagoDed(), 19, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFReciboIngSin() != null && this.getObjetoABM().getIdFReciboIngSin()  != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoReciboIngresoSiniestro formatoReciboIngresoSiniestro = new FormatoReciboIngresoSiniestro();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFReciboIngSin() );
	formatoReciboIngresoSiniestro = this.getFormatoReciboIngresoSiniestroService()
	.objetoFormatoReciboIngresoSiniestro(idCadena);
	// VALIDAR
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_RECIBO_INGRESO, formatoReciboIngresoSiniestro.getRiNumReporte(),
	formatoReciboIngresoSiniestro.getRiNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFReciboIngSin(), 20, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFSolicDiag() != null && this.getObjetoABM().getIdFSolicDiag() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoSolicitudDiagnostico formatoSolicitudDiagnostico = new FormatoSolicitudDiagnostico();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFSolicDiag());
	formatoSolicitudDiagnostico = this.getFormatoSolicitudDiagnostico()
	.objetoFormatoSolicitudDiagnostico(idCadena);
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_SOLICITUD_DIAGNOSTICO, formatoSolicitudDiagnostico.getSdNumReporte(),
	formatoSolicitudDiagnostico.getSdNumPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFSolicDiag(), 21, ec.getResponseOutputStream());
	
	fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFMemoriaDesc() != null && this.getObjetoABM().getIdFMemoriaDesc() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoMemoriaDescriptiva formatoMemoriaDescriptiva = new FormatoMemoriaDescriptiva();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFMemoriaDesc());
	formatoMemoriaDescriptiva = this.getFormatoMemoriaDescriptiva().objetoFormatoMemoriaDescriptiva(idCadena);
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_MEMORIA_DESCRIPTIVA, formatoMemoriaDescriptiva.getReporte(),
	formatoMemoriaDescriptiva.getPoliza(),""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFMemoriaDesc(), 22, ec.getResponseOutputStream());
	 fc.responseComplete();
	}
	
	if (this.getObjetoABM().getIdFCargoTarjeta() != null && this.getObjetoABM().getIdFCargoTarjeta() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoCargoTarjetaCredito formatoCargoTarjetaCredito = new FormatoCargoTarjetaCredito();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFCargoTarjeta());
	formatoCargoTarjetaCredito = this.getFormatoCargoTarjetaCredito().objetoFormatoCargoTarjetaCredito(idCadena);
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_CARGO_TARJETA, formatoCargoTarjetaCredito.getTcNumReporte(),
	formatoCargoTarjetaCredito.getTcNumPoliza(), ""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFCargoTarjeta(), 24, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	
	//
	if (this.getObjetoABM().getIdFResponsabilidadCivil() != null && this.getObjetoABM().getIdFResponsabilidadCivil() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoResponsabilidadCivil formatoResponsabilidadCivil = new FormatoResponsabilidadCivil();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFResponsabilidadCivil());
	formatoResponsabilidadCivil = this.getFormatoResponsabilidadCivil().objetoFormatoResponsabilidadCivil(idCadena);
	
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_RESPONSABILIDAD_CIVIL, formatoResponsabilidadCivil.getRcNumReporte(),
	formatoResponsabilidadCivil.getRcNumPoliza(), ""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFResponsabilidadCivil(), 25, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	
	// Orden de Bienes Diversos 
	if (this.getObjetoABM().getIdFOrdenBienesDiversos() != null && this.getObjetoABM().getIdFOrdenBienesDiversos() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	FormatoReparacionBienesDiversos formatoReparacionBienesDiversos = new FormatoReparacionBienesDiversos();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFOrdenBienesDiversos());
	formatoReparacionBienesDiversos = this.getFormatoReparacionBienesDiversos().objetoFormatoReparacionBienesDiversos(idCadena);
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_BIENES_DIVERSOS,formatoReparacionBienesDiversos.getBdNumReporte(),
	formatoReparacionBienesDiversos.getBdNumPoliza(), ""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFOrdenBienesDiversos(), 26, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	if (this.getObjetoABM().getIdFObservacionAseg() != null && this.getObjetoABM().getIdFObservacionAseg() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoObservacionesAsegurado formatoObservacionesAsegurado = new FormatoObservacionesAsegurado();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFObservacionAseg());
	formatoObservacionesAsegurado = this.getFormatoObservacionesAsegurado().objetoFormatoObservacionesAsegurado(idCadena);
	 
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_OBSERVACIONES_ASEGURADO,formatoObservacionesAsegurado.getFoaNumReporte(),
	formatoObservacionesAsegurado.getFoaNumPoliza(), ""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFObservacionAseg(), 27, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	//FORMATO INVENTARIO UNICO PESADO
	if (this.getObjetoABM().getIdFInventarioUnicPesado() != null && this.getObjetoABM().getIdFInventarioUnicPesado()!= 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoInventarioUnicoPesado formatoInventarioUnicoPesado = new FormatoInventarioUnicoPesado();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFInventarioUnicPesado());
	formatoInventarioUnicoPesado = this.getFormatoInventarioUnicoPesado().objetoFormatoInventarioUnicoPesado(idCadena);
	
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_INVENTARIO_PESADO, formatoInventarioUnicoPesado.getInNumReporte(),
	formatoInventarioUnicoPesado.getInpNumPoliza(), ""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFInventarioUnicPesado(), 28, ec.getResponseOutputStream());
	
	 fc.responseComplete();
	}
	
	//Formato Reclamación sin comprobante de peaje
	if (this.getObjetoABM().getIdFReclamacionComprobPeaje() != null && this.getObjetoABM().getIdFReclamacionComprobPeaje() != 0) {
	FacesContext fc = FacesContext.getCurrentInstance();
	 ExternalContext ec = fc.getExternalContext();
	 ec.responseReset(); 
	 ec.setResponseContentType("application/pdf");
	 String fileName = null;
	 FormatoReclamacionComprobantePeaje formatoReclamacionComprobantePeaje = new FormatoReclamacionComprobantePeaje();
	String idCadena = String.valueOf(this.getObjetoABM().getIdFReclamacionComprobPeaje());
	formatoReclamacionComprobantePeaje = this.getFormatoReclamacionComprobantePeaje().objetoFormatoReclamacionComprobantePeaje(idCadena);
	
	int tipoAfec = validarF.validarAsegurado(null);
	fileName = validarF.nombrarArchivo(FORMATO_RECLAMACION_COMPROBANTE_PEAJE, formatoReclamacionComprobantePeaje.getRcp_num_reporte(),
	formatoReclamacionComprobantePeaje.getRcp_num_poliza(), ""+ tipoAfec, "");
	ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	this.getExpedienteEjecutivoService().generePDF(this.getObjetoABM().getIdFReclamacionComprobPeaje(), 29, ec.getResponseOutputStream());
	fc.responseComplete();
	}
	
	  }
	}catch (Exception e) {
	this.ponerMensajeError("No se puede descargar el PDF -> "+e);
	}
	
	}
	
	public void actualizarPendientes() {
	if (this.getTxtNumeroReporteBuscar() != null) {
	List<EntidadObjeto> resultado = this.getExpedienteEjecutivoService().obtenerContador(this.getTxtNumeroReporteBuscar());
	if (resultado != null) {
	if (resultado.size() > 0) { 
	this.setTxtFaltantesCorreo(resultado.get(0).getValor0().toString());
	this.setTxtFaltantesQContent(resultado.get(0).getValor1().toString());
	} else { 
	this.setTxtFaltantesCorreo("0");
	this.setTxtFaltantesQContent("0");
	}
	} else { 
	this.setTxtFaltantesCorreo("0");
	this.setTxtFaltantesQContent("0");
	}
	} else {
	this.ponerMensajeInfo("Es necesario especificar el número de reporte para obtener resultados.");
	}
	}
	
	
	public PieChartModel getPieModel() {  
	return pieModel;  
	}
	
	private void createModels() {  
	createPieModel();  
	createHorizontalBarModel();
	} 
	
	private void createPieModel() {
	pieModel = new PieChartModel();
	List<EntidadObjeto> salida = null;
	int total = 0;
	
	
	
	try {
		int idAjustador=-999;
		int baseId = -999;
		try {
			if (StringUtils.isNotBlank(this.getIdTerminal())) {
				idAjustador = Integer.parseInt(this.getIdTerminal());
			}
			if (StringUtils.isNotBlank(this.getIdBase())) {
				baseId = Integer.parseInt(this.getIdBase());
			}
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
	
		}
		
	if(!this.getIdEstado().equals("9999") ) {
	if (Integer.parseInt(this.getIdBase())> 0) {
		salida = getExpedienteEjecutivoService().listaDeFormatosParaGrafica(this.getTxtFechaInicio(), this.getTxtFechaFin(),null,  
		Integer.parseInt(this.getIdEstado()), baseId, null,
		this.get_filtroNombreF(), idAjustador,  this.getTxtNumeroReporte());
	} else {
		salida = getExpedienteEjecutivoService().listaDeFormatosParaGrafica(this.getTxtFechaInicio(), this.getTxtFechaFin(),null, 
		Integer.parseInt(this.getIdEstado()), null,null, this.get_filtroNombreF(), 
		idAjustador, this.getTxtNumeroReporte());
	}
	} else {
		salida = getExpedienteEjecutivoService().listaDeFormatosParaGrafica(this.getTxtFechaInicio(), this.getTxtFechaFin(),null, null, null,
				null, this.get_filtroNombreF(), idAjustador, this.getTxtNumeroReporte());
	}
	
	
	//log.info("Tamaño de la lista: "+salida.size());
	if(salida != null && salida.size() >0) {
	
	for (EntidadObjeto objects : salida) {
	pieModel.set(objects.getValor0().toString(),  Integer.parseInt(objects.getValor1().toString()));
	total = total + Integer.parseInt(objects.getValor1().toString());
	//Actualizamos contadores;
	}
		pieModel.setTitle("Grafica De "+total+" Formatos Digitales Enviados.");  
		pieModel.setLegendPosition("e"); 
		pieModel.setShowDataLabels(true);
		pieModel.setSliceMargin(1);
		pieModel.setShadow(false);
		pieModel.setMouseoverHighlight(true);
		pieModel.setDataFormat("value");
		pieModel.setDataLabelFormatString("%d");
		pieModel.setSeriesColors("939BA1, 78CAD1, EACCE8, 7C7782, 008C99, 9F85B8, CACACC,"
		+ "2CA8B5, 91278F, E2E2E2, B1EDF2, D68ECC, B3E5E5, D6C5E8, "
		+ "E6E6E6, 088A85, 8A0886, F2F2F2, 04B486, DF01A5, 848484, "
		+ "D0A9F5, 2C3E50, EC407A, 004D40, 266A43, 8BACCD, 720EBD, DAD032");
		pieModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
	
		} else {
		pieModel.set("Sin Valores para graficar", 0);
		pieModel.setTitle("No hay datos de formatos digitales enviados.");  
		pieModel.setLegendPosition("c"); 
		pieModel.setShowDataLabels(false);
		pieModel.setSliceMargin(1);
		pieModel.setMouseoverHighlight(false);
		}
	
	} catch (Exception e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
	}
	}
	
	
	
	public void actualizarGrafica() {
	if((this.getTxtFechaInicio() != null)
	&& (this.getTxtFechaFin() != null)
	&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
	this.ponerMensajeAdvertencia("Los formatos digitales estan limitado a 31 días naturales.");
	return;
	}
	try {
	//this.actualizarListado();
	this.actualizarContadorTotal();
	
	this.createModels();
	this.setListado(null);
	}catch (Exception e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
	}
	}
	
	
	//@Override
	public String doAccionReporteMetrica() {
	return this.enviarArchivoACliente("reportes_metrica_oa_dua.xls", this.obtenerReporteMetrica());
	}
	
	public byte[] obtenerReporteMetrica() {
	final ByteArrayOutputStream paraFuera = new ByteArrayOutputStream();
	try {
	final WritableWorkbook workbook = Workbook.createWorkbook(paraFuera);
	workbook.setProtected(false);
	
	// fuentes
	final WritableFont fuenteTitulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
	final WritableFont fuenteEncabezado = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, false,
	UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	final WritableFont fuenteDatos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
	
	final WritableCellFormat estiloTitulo = new WritableCellFormat(fuenteTitulo);
	estiloTitulo.setBackground(Colour.WHITE);
	estiloTitulo.setAlignment(Alignment.CENTRE);
	estiloTitulo.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloTitulo.setLocked(true);
	
	final WritableCellFormat estiloEncabezadoDatosColumna = new WritableCellFormat(fuenteEncabezado);
	estiloEncabezadoDatosColumna.setBackground(Colour.GREEN);
	estiloEncabezadoDatosColumna.setAlignment(Alignment.CENTRE);
	estiloEncabezadoDatosColumna.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloEncabezadoDatosColumna.setLocked(true);
	
	final WritableCellFormat estiloEncabezadoRespuestaEncuesta = new WritableCellFormat(fuenteEncabezado);
	estiloEncabezadoRespuestaEncuesta.setBackground(Colour.CORAL);
	estiloEncabezadoRespuestaEncuesta.setAlignment(Alignment.CENTRE);
	estiloEncabezadoRespuestaEncuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloEncabezadoRespuestaEncuesta.setLocked(true);
	
	final WritableCellFormat estiloEncabezadoValorRespuesta = new WritableCellFormat(fuenteEncabezado);
	estiloEncabezadoValorRespuesta.setBackground(Colour.GREY_25_PERCENT);
	estiloEncabezadoValorRespuesta.setAlignment(Alignment.CENTRE);
	estiloEncabezadoValorRespuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloEncabezadoValorRespuesta.setLocked(true);
	
	
	final WritableCellFormat estiloDatos = new WritableCellFormat(fuenteDatos);
	estiloDatos.setBackground(Colour.WHITE);
	estiloDatos.setAlignment(Alignment.CENTRE);
	estiloDatos.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloDatos.setBorder(Border.ALL, BorderLineStyle.THIN);
	estiloDatos.setLocked(true);
	
	final WritableSheet hoja = workbook.createSheet("Reporte Expediente Digital OA - DUA", 0);
	
	// Titulo
	hoja.setRowView(0, 40 * 20);
	hoja.setRowView(1, 35 * 20);
	hoja.setRowView(2, 35 * 20);
	final Label labelTitulo = new Label(1, 0, "Reportes Expediente Digital Métrica OA - DUA"+ "  del "
	+ DateFormatUtils.format(this.getTxtFechaInicio(), "yyyy/MM/dd HH:mm:ss") + " al "
	+ DateFormatUtils.format(this.getTxtFechaFin(), "yyyy/MM/dd 23:59:59"), estiloTitulo);
	hoja.addCell(labelTitulo);
	hoja.getSettings().setVerticalFreeze(2);
	hoja.mergeCells(1, 0, 15, 0);
	
	int contadorColumna = 0;
	
	contadorColumna = 0;
	//Nuevo
	hoja.addCell(new Label(contadorColumna++, 2, "Numero Reporte",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Fecha",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Clave Ajustador",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Entidad",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Zona",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Código Causa",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "OA Autos",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "OA Motocicletas",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "OA Pesado",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Declaración Universal",estiloEncabezadoDatosColumna ));
	
	List<MetricaED> lista = null;
	try {
	String nombreEdo = null;
	String nombreBase = null;
	String claveAjustador = null;
	//Obtener nombre edo
	try {
	Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
	if (edo != null ) {
	nombreEdo = edo.getNombre();
	}
	try {
	if (StringUtils.isNotBlank(this.getIdBase()) && Integer.parseInt(this.getIdBase()) >0 ) {
	Base base = getBaseService().objetoBase(this.getIdBase());
	if (base != null) {
	nombreBase = base.getNombre();
	}
	}
	} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
	}
	if (StringUtils.isNotBlank(this.getIdTerminal())) {
	Terminal terminal = this.getTerminalService().objetoTerminal(this.getIdTerminal());
	if (terminal != null) {
	claveAjustador = terminal.getNumeroproveedor();
	}
	}
	
	} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
	}
	
	lista  =this.getMetricaEDService().listaDeMetricasED(nombreEdo, nombreBase, claveAjustador, this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.get_filtroNombreF());
	
	} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  catch (final NoSuchElementException ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  catch (final ClassCastException ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  catch (final Exception ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  
	
	int contadorFila = 3;
	if ((lista != null) && (lista.size() > 0)) {
	for ( final MetricaED expediente : lista) {
	contadorColumna = 0;
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getNumeroReporte(), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(expediente.getFecha(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getClaveAjustador(), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getEntidad(), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getBase(), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getCodigoCausa(), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(expediente.getOaAuto()), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(expediente.getOaMoto()), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(expediente.getOaEP()), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(expediente.getDua()), estiloDatos));
	
	contadorFila++;
	}
	}
	contadorFila++;
	contadorColumna = 0;
	
	workbook.write();
	workbook.close();
	return paraFuera.toByteArray();
	
	} catch (final IOException e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Expediente Digital Excel Metrica");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital : " + e.getMessage());
	}  catch (final WriteException e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Error al crear Excel de reporte Expediente Digital Metrica OA/DUA");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital  : " + e.getMessage());
	}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Error al crear Excel de reporte Expediente Digital Metrica OA/DUA ");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital  : " + e.getMessage());
	}  catch (final Exception e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Error al crear Excel de reporte Expediente Digital Metrica OA/DUA ");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital  : " + e.getMessage());
	
	}
	return null;
	
	}
	
	//@Override
	public String doAccionReporte() {
	return this.enviarArchivoACliente("reportes_expediente_digital.xls", this.obtenerReporte());
	}
	
	public byte[] obtenerReporte() {
	
	final ByteArrayOutputStream paraFuera = new ByteArrayOutputStream();
	try {
	final WritableWorkbook workbook = Workbook.createWorkbook(paraFuera);
	workbook.setProtected(false);
	
	// fuentes
	final WritableFont fuenteTitulo = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
	final WritableFont fuenteEncabezado = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, false,
	UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	final WritableFont fuenteDatos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
	
	final WritableCellFormat estiloTitulo = new WritableCellFormat(fuenteTitulo);
	estiloTitulo.setBackground(Colour.WHITE);
	estiloTitulo.setAlignment(Alignment.CENTRE);
	estiloTitulo.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloTitulo.setLocked(true);
	
	final WritableCellFormat estiloEncabezadoDatosColumna = new WritableCellFormat(fuenteEncabezado);
	estiloEncabezadoDatosColumna.setBackground(Colour.GREEN);
	estiloEncabezadoDatosColumna.setAlignment(Alignment.CENTRE);
	estiloEncabezadoDatosColumna.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloEncabezadoDatosColumna.setLocked(true);
	
	final WritableCellFormat estiloEncabezadoRespuestaEncuesta = new WritableCellFormat(fuenteEncabezado);
	estiloEncabezadoRespuestaEncuesta.setBackground(Colour.CORAL);
	estiloEncabezadoRespuestaEncuesta.setAlignment(Alignment.CENTRE);
	estiloEncabezadoRespuestaEncuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloEncabezadoRespuestaEncuesta.setLocked(true);
	
	final WritableCellFormat estiloEncabezadoValorRespuesta = new WritableCellFormat(fuenteEncabezado);
	estiloEncabezadoValorRespuesta.setBackground(Colour.GREY_25_PERCENT);
	estiloEncabezadoValorRespuesta.setAlignment(Alignment.CENTRE);
	estiloEncabezadoValorRespuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloEncabezadoValorRespuesta.setLocked(true);
	
	
	final WritableCellFormat estiloDatos = new WritableCellFormat(fuenteDatos);
	estiloDatos.setBackground(Colour.WHITE);
	estiloDatos.setAlignment(Alignment.CENTRE);
	estiloDatos.setVerticalAlignment(VerticalAlignment.CENTRE);
	estiloDatos.setBorder(Border.ALL, BorderLineStyle.THIN);
	estiloDatos.setLocked(true);
	
	final WritableSheet hoja = workbook.createSheet("Reporte Expediente Digital", 0);
	
	// Titulo
	hoja.setRowView(0, 40 * 20);
	hoja.setRowView(1, 35 * 20);
	hoja.setRowView(2, 35 * 20);
	final Label labelTitulo = new Label(1, 0, "Reportes Expediente Digital"+ "  del "
	+ DateFormatUtils.format(this.getTxtFechaInicio(), "yyyy/MM/dd HH:mm:ss") + " al "
	+ DateFormatUtils.format(this.getTxtFechaFin(), "yyyy/MM/dd 23:59:59"), estiloTitulo);
	hoja.addCell(labelTitulo);
	hoja.getSettings().setVerticalFreeze(2);
	hoja.mergeCells(1, 0, 15, 0);
	
	int contadorColumna = 0;
	
	contadorColumna = 0;
	//Nuevo
	hoja.addCell(new Label(contadorColumna++, 2, "Num. Folio",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Fecha",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Evento",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Clave Ajustador",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Numero Reporte",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Estado",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Nombre Expediente",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "SFTP",estiloEncabezadoDatosColumna ));
	hoja.addCell(new Label(contadorColumna++, 2, "Correo",estiloEncabezadoDatosColumna ));
	
	List<ExpedienteEjecutivo> lista = null;
	try {
	
		int idAjustador=-999;
		int baseId = -999;
		try {
			if (StringUtils.isNotBlank(this.getIdTerminal())) {
				idAjustador = Integer.parseInt(this.getIdTerminal());
			}
			if (StringUtils.isNotBlank(this.getIdBase())) {
				baseId = Integer.parseInt(this.getIdBase());
			}
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
	
		}
		
	if(!this.getIdEstado().equals("9999") ) {
	if (Integer.parseInt(this.getIdBase()) > 0) {
		lista = this.getExpedienteEjecutivoService().listaDeExpedientesExcel(
		this.getEstadoService().objetoEstado(this.getIdEstado()), baseId, idAjustador, this.getTxtFechaInicio(), this.getTxtFechaFin(),
		this.getTxtNumeroReporte(), this.get_filtroNombreF());
	} else {
		lista = this.getExpedienteEjecutivoService().listaDeExpedientesExcel(
		this.getEstadoService().objetoEstado(this.getIdEstado()), null, idAjustador, this.getTxtFechaInicio(), this.getTxtFechaFin(),
		this.getTxtNumeroReporte(), this.get_filtroNombreF());
	}
	} else {
		lista = this.getExpedienteEjecutivoService().listaDeExpedientesExcel(
		null,null, idAjustador, this.getTxtFechaInicio(), this.getTxtFechaFin(),
		this.getTxtNumeroReporte(), this.get_filtroNombreF());
	}
	
	
	} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  catch (final NoSuchElementException ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  catch (final ClassCastException ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  catch (final Exception ex) {
	this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
	"obtenerReporte => listaDeExpedientes");
	}  
	
	int contadorFila = 3;
	if ((lista != null) && (lista.size() > 0)) {
	for ( final ExpedienteEjecutivo expediente : lista) {
	contadorColumna = 0;
	hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(expediente.getFolio()), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(expediente.getFecha(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getCausa(), estiloDatos));
	if (expediente.getTerminal() != null) {
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getClaveProveedor(), estiloDatos));
	} else {
	hoja.addCell(new Label(contadorColumna++, contadorFila, "", estiloDatos));
	}
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getReporte(), estiloDatos));
	if ( expediente.getEstado() != null && expediente.getBase() != null) {
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getEstado().getNombre(), estiloDatos));
	} else {
	hoja.addCell(new Label(contadorColumna++, contadorFila, "", estiloDatos));
	}
	
	hoja.addCell(new Label(contadorColumna++, contadorFila, expediente.getNombreExpediente(), estiloDatos));
	if (expediente.isSftp()) {
	hoja.addCell(new Label(contadorColumna++,contadorFila, "Enviado", estiloDatos));
	} else {
	hoja.addCell(new Label(contadorColumna++, contadorFila, "No Enviado", estiloDatos));
	}
	
	if (expediente.isCorreo()) {
	hoja.addCell(new Label(contadorColumna++,contadorFila, "Enviado", estiloDatos));
	} else {
	hoja.addCell(new Label(contadorColumna++, contadorFila, "No Enviado", estiloDatos));
	}
	
	contadorFila++;
	}
	}
	contadorFila++;
	contadorColumna = 0;
	
	workbook.write();
	workbook.close();
	return paraFuera.toByteArray();
	
	} catch (final IOException e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Expediente Digital Excel");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital : " + e.getMessage());
	}  catch (final WriteException e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Error al crear Excel de reporte Expediente Digital l");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital  : " + e.getMessage());
	}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Error al crear Excel de reporte Expediente Digital ");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital  : " + e.getMessage());
	}  catch (final Exception e) {
	this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Error al crear Excel de reporte Expediente Digital ");
	this.ponerMensajeError("Error al crear Excel de reporte Expediente Digital  : " + e.getMessage());
	
	}
	return null;
	
	}
	
	
	public void actualizarContadorTotal() {
	List<EntidadObjetoQuinto> resultado;
	List<EntidadObjetoQuinto> resulMetrica;
	String nombreEdo = null;
	String nombreBase = null;
	String claveAjustador = null;
	//Obtener nombre edo
	try {
	Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
	if (edo != null ) {
	nombreEdo = edo.getNombre();
	}
	try {
	if (StringUtils.isNotBlank(this.getIdBase()) && Integer.parseInt(this.getIdBase()) >0 ) {
	Base base = getBaseService().objetoBase(this.getIdBase());
	if (base != null) {
	nombreBase = base.getNombre();
	}
	}
	} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
	}
	if (StringUtils.isNotBlank(this.getIdTerminal())) {
	Terminal terminal = this.getTerminalService().objetoTerminal(this.getIdTerminal());
	if (terminal != null) {
	claveAjustador = terminal.getNumeroproveedor();
	}
	}
	
	} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
	}
	if(!this.getIdEstado().equals("9999") ) {
	if (Integer.parseInt(this.getIdBase()) > 0) {
	resultado = this.getExpedienteEjecutivoService().obtenerContadorTotal(this.getTxtFechaInicio(), this.getTxtFechaFin(),
	Integer.parseInt(this.getIdEstado()), Integer.parseInt(this.getIdBase()), this.get_filtroNombreF(), this.getTerminalService().objetoTerminal(this.getIdTerminal()),
	this.getTxtNumeroReporte() );
	resulMetrica = this.getMetricaEDService().obtenerContadorTotal(this.getTxtFechaInicio(), this.getTxtFechaFin(), nombreEdo, nombreBase, this.get_filtroNombreF(), claveAjustador, this.getTxtNumeroReporte());
	} else {
	resultado = this.getExpedienteEjecutivoService().obtenerContadorTotal(this.getTxtFechaInicio(), this.getTxtFechaFin(),
	Integer.parseInt(this.getIdEstado()), null,  this.get_filtroNombreF(),this.getTerminalService().objetoTerminal(this.getIdTerminal()),
	this.getTxtNumeroReporte());
	resulMetrica = this.getMetricaEDService().obtenerContadorTotal(this.getTxtFechaInicio(), this.getTxtFechaFin(), nombreEdo, nombreBase, this.get_filtroNombreF(), claveAjustador, this.getTxtNumeroReporte());
	}
	} else {
	resultado = this.getExpedienteEjecutivoService().obtenerContadorTotal(this.getTxtFechaInicio(), this.getTxtFechaFin(),null,null,this.get_filtroNombreF(),
	this.getTerminalService().objetoTerminal(this.getIdTerminal()),this.getTxtNumeroReporte());
	resulMetrica = this.getMetricaEDService().obtenerContadorTotal(this.getTxtFechaInicio(), this.getTxtFechaFin(), nombreEdo, nombreBase, this.get_filtroNombreF(), claveAjustador, this.getTxtNumeroReporte());
	}
	
	if (resultado != null) {
	if (resultado.size() > 0) { 
	UtileriaNumeros utileria = new UtileriaNumeros();
	int contEmail = 0;
	int contSFTP = 0;
	this.setTxtExitoCorreo(resultado.get(0).getValor0().toString());
	this.setTxtExitoSFTP(resultado.get(0).getValor1().toString());
	this.setTxtErrorCorreo(resultado.get(0).getValor2().toString());
	this.setTxtErrorSFTP(resultado.get(0).getValor3().toString());
	this.setTxtReportesDocs(resultado.get(0).getValor4().toString());
	
	//Agregamos los contadores para porcentajes
	contEmail = Integer.parseInt(resultado.get(0).getValor0().toString()) + Integer.parseInt(resultado.get(0).getValor2().toString());
	contSFTP= Integer.parseInt(resultado.get(0).getValor1().toString()) + Integer.parseInt(resultado.get(0).getValor3().toString());
	this.setTxtTotalCont(Integer.toString(contSFTP));
	
	float correoExF = (Integer.parseInt(resultado.get(0).getValor0().toString()) * 100 );
	float correoEx =( correoExF / contEmail);
	
	this.setTxtExitoCorreoPorc(utileria.float2Digitos(correoEx) + "%");
	
	float sftpoExF = ((Integer.parseInt(resultado.get(0).getValor1().toString()) * 100 ));
	float sftpoEx = sftpoExF / contSFTP;
	this.setTxtExitoSFTPPorc(utileria.float2Digitos(sftpoEx)+"%");
	
	float correoFF = ((Integer.parseInt(resultado.get(0).getValor2().toString()) * 100 ) );
	float correoF = correoFF / contEmail;
	this.setTxtErrorCorreoPorc(utileria.float2Digitos(correoF)+"%");
	
	float SftpFF = ((Integer.parseInt(resultado.get(0).getValor3().toString()) * 100 ) );
	float SftpF = SftpFF / contSFTP;
	this.setTxtErrorSFTPPorc(utileria.float2Digitos(SftpF) +"%");
	if (resulMetrica != null) {
	if (resulMetrica.size() > 0) {
	int contTotal = 0;
	
	contTotal = Integer.parseInt(resulMetrica.get(0).getValor4().toString());
	
	//Contador total de reportes
	this.setTxtTotalRepOAA(resulMetrica.get(0).getValor0().toString());
	this.setTxtTotalRepOAM(resulMetrica.get(0).getValor1().toString());
	this.setTxtTotalRepOAE(resulMetrica.get(0).getValor2().toString());
	this.setTxtTotalRepDUA(resulMetrica.get(0).getValor3().toString());
	
	float contOAAuto = (Integer.parseInt(resulMetrica.get(0).getValor0().toString()) * 100 );
	float contOAAutoDiv = ( contOAAuto / contTotal);
	this.setTxtOAAuto(utileria.float2Digitos(contOAAutoDiv) + "%");
	
	float contOAMoto = (Integer.parseInt(resulMetrica.get(0).getValor1().toString()) * 100 );
	float contOAMotoDiv = (contOAMoto / contTotal);
	this.setTxtOAMoto(utileria.float2Digitos(contOAMotoDiv) + "%");
	
	float contOAEP = (Integer.parseInt(resulMetrica.get(0).getValor2().toString()) * 100 );
	float contOAEPDiv = (contOAEP / contTotal);
	this.setTxtOAEP(utileria.float2Digitos(contOAEPDiv) + "%");
	
	float contDUA = (Integer.parseInt(resulMetrica.get(0).getValor3().toString()) * 100 );
	float contDUADiv = (contDUA / contTotal);
	this.setTxtDua(utileria.float2Digitos(contDUADiv) + "%");
	
	this.setTxtTotalMetrica(Integer.toString(contTotal));
	}
	}
	} else { 
	this.setTxtExitoCorreo("0");
	this.setTxtExitoSFTP("0");
	this.setTxtErrorCorreo("0");
	this.setTxtErrorSFTP("0");
	this.setTxtTotalCont("0");
	this.setTxtReportesDocs("0");
	
	this.setTxtExitoCorreoPorc("0%");
	this.setTxtExitoSFTPPorc("0%");
	this.setTxtErrorCorreoPorc("0%");
	this.setTxtErrorSFTPPorc("0%");
	
	this.setTxtOAAuto("0%");
	this.setTxtOAMoto("0%");
	this.setTxtOAEP("0%");
	this.setTxtDua("0%");
	this.setTxtTotalMetrica("0");
	this.setTxtTotalRepOAA("0");
	this.setTxtTotalRepOAM("0");
	this.setTxtTotalRepOAE("0");
	this.setTxtTotalRepDUA("0");
	}
	} else { 
	this.setTxtExitoCorreo("0");
	this.setTxtExitoSFTP("0");
	this.setTxtErrorCorreo("0");
	this.setTxtErrorSFTP("0");
	this.setTxtTotalCont("0");
	this.setTxtReportesDocs("0");
	
	this.setTxtExitoCorreoPorc("0%");
	this.setTxtExitoSFTPPorc("0%");
	this.setTxtErrorCorreoPorc("0%");
	this.setTxtErrorSFTPPorc("0%");
	
	this.setTxtOAAuto("0%");
	this.setTxtOAMoto("0%");
	this.setTxtOAEP("0%");
	this.setTxtDua("0%");
	this.setTxtTotalMetrica("0");
	this.setTxtTotalRepOAA("0");
	this.setTxtTotalRepOAM("0");
	this.setTxtTotalRepOAE("0");
	this.setTxtTotalRepDUA("0");
	}
	}
	
	 public HorizontalBarChartModel getHorizontalBarModel() {
	        return horizontalBarModel;
	    }
	
	 
	 private void createHorizontalBarModel() {
	        horizontalBarModel = new HorizontalBarChartModel();
	        ChartSeries enviados = new ChartSeries();
	        enviados.setLabel("Generado");
	        enviados.set("OA Autos", Integer.parseInt(this.getTxtTotalRepOAA()));
	        enviados.set("OA Motos", Integer.parseInt(this.getTxtTotalRepOAM()));
	        enviados.set("OA Equipo P.", Integer.parseInt(this.getTxtTotalRepOAE()));
	        enviados.set("DUA", Integer.parseInt(this.getTxtTotalRepDUA()));
	        
	        ChartSeries noEnviado = new ChartSeries();
	        noEnviado.setLabel("No Generado");
	        noEnviado.set("OA Autos", Integer.parseInt(this.getTxtTotalMetrica()) - Integer.parseInt(this.getTxtTotalRepOAA()));
	        noEnviado.set("OA Motos", Integer.parseInt(this.getTxtTotalMetrica()) - Integer.parseInt(this.getTxtTotalRepOAM()));
	        noEnviado.set("OA Equipo P.", Integer.parseInt(this.getTxtTotalMetrica()) - Integer.parseInt(this.getTxtTotalRepOAE()));
	        noEnviado.set("DUA", Integer.parseInt(this.getTxtTotalMetrica()) - Integer.parseInt(this.getTxtTotalRepDUA()));
	
	        horizontalBarModel.addSeries(enviados);
	        horizontalBarModel.addSeries(noEnviado);
	
	        horizontalBarModel.setTitle("Aquí va el título de la Gráfica");
	        horizontalBarModel.setLegendPosition("ne");
	        horizontalBarModel.setAnimate(true);
	        horizontalBarModel.setShowPointLabels(true);
	        horizontalBarModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
	//        setShowDataLabels
	//        horizontalBarModel.setLegendPosition("e");
	        //model.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
	
	        horizontalBarModel.setStacked(true);
	
	        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
	        xAxis.setLabel("Cantidad");
	        xAxis.setMin(0);
	        UtileriaNumeros utilNum = new UtileriaNumeros();
	        xAxis.setMax(utilNum.obtenerMultiplo(Integer.parseInt(this.getTxtTotalMetrica())));
	
	        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
	        yAxis.setLabel("Documento");
	        horizontalBarModel.setSeriesColors("2CA8B5, D68ECC");
	    }
	
	 public void doAccionVerError(final ActionEvent e) {
	if (StringUtils.isNotBlank(this.obtenerParametroDeRequest("id"))) {
	ExpedienteEjecutivo objeto = this.getExpedienteEjecutivoService().objetoExpediente(this.obtenerParametroDeRequest("id"), null, null);
	
	this.setObjetoActua(objeto);
	}
	}
	 
	 public void doAccionRegistroCerrar(final ActionEvent e) {
	this.setObjetoABM(null);
	}
	 
	 public void valueDescargar(final ActionEvent e) {
	    if (StringUtils.isNotBlank(this.getDocDescargar())) {
	if (StringUtils.contains(this.getDocDescargar(), "listadoErrores")) {
	this.doAccionReporte();
	}
	if (StringUtils.contains(this.getDocDescargar(), "listadoMetrica")) {
	    this.doAccionReporteMetrica();
	}
	}
	}
	 
	
	public String getTxtNumeroReporte() {
	return this.txtNumeroReporte;
	}
	
	public void setTxtNumeroReporte(final String txtNumeroReporte) {
	this.txtNumeroReporte = txtNumeroReporte;
	}
	
	public String getTxtFaltantesCorreo() {
	return txtFaltantesCorreo;
	}
	
	public void setTxtFaltantesCorreo(String txtFaltantesCorreo) {
	this.txtFaltantesCorreo = txtFaltantesCorreo;
	}
	
	public String getTxtFaltantesQContent() {
	return txtFaltantesQContent;
	}
	
	public void setTxtFaltantesQContent(String txtFaltantesQContent) {
	this.txtFaltantesQContent = txtFaltantesQContent;
	}
	
	public String getTxtNumeroReporteBuscar() {
	return txtNumeroReporteBuscar;
	}
	
	public void setTxtNumeroReporteBuscar(String txtNumeroReporteBuscar) {
	this.txtNumeroReporteBuscar = txtNumeroReporteBuscar;
	}
	
	public String get_filtroNombreF() {
	return _filtroNombreF;
	}
	
	public void set_filtroNombreF(String _filtroNombreF) {
	this._filtroNombreF = _filtroNombreF;
	}
	
	public String getTxtExitoCorreo() {
	return txtExitoCorreo;
	}
	
	
	public void setTxtExitoCorreo(String txtExitoCorreo) {
	this.txtExitoCorreo = txtExitoCorreo;
	}
	
	
	public String getTxtErrorCorreo() {
	return txtErrorCorreo;
	}
	
	
	public void setTxtErrorCorreo(String txtErrorCorreo) {
	this.txtErrorCorreo = txtErrorCorreo;
	}
	
	
	public String getTxtExitoSFTP() {
	return txtExitoSFTP;
	}
	
	
	public void setTxtExitoSFTP(String txtExitoSFTP) {
	this.txtExitoSFTP = txtExitoSFTP;
	}
	
	
	public String getTxtErrorSFTP() {
	return txtErrorSFTP;
	}
	
	
	public void setTxtErrorSFTP(String txtErrorSFTP) {
	this.txtErrorSFTP = txtErrorSFTP;
	}
	
	
	public String getTxtExitoCorreoPorc() {
	return txtExitoCorreoPorc;
	}
	
	
	public void setTxtExitoCorreoPorc(String txtExitoCorreoPorc) {
	this.txtExitoCorreoPorc = txtExitoCorreoPorc;
	}
	
	
	public String getTxtErrorCorreoPorc() {
	return txtErrorCorreoPorc;
	}
	
	
	public void setTxtErrorCorreoPorc(String txtErrorCorreoPorc) {
	this.txtErrorCorreoPorc = txtErrorCorreoPorc;
	}
	
	
	public String getTxtExitoSFTPPorc() {
	return txtExitoSFTPPorc;
	}
	
	
	public void setTxtExitoSFTPPorc(String txtExitoSFTPPorc) {
	this.txtExitoSFTPPorc = txtExitoSFTPPorc;
	}
	
	
	public String getTxtErrorSFTPPorc() {
	return txtErrorSFTPPorc;
	}
	
	
	public void setTxtErrorSFTPPorc(String txtErrorSFTPPorc) {
	this.txtErrorSFTPPorc = txtErrorSFTPPorc;
	}
	
	
	public boolean isNoSftp() {
	return noSftp;
	}
	
	
	public void setNoSftp(boolean noSftp) {
	this.noSftp = noSftp;
	}
	
	
	public boolean isNoEmail() {
	return noEmail;
	}
	
	
	public void setNoEmail(boolean noEmail) {
	this.noEmail = noEmail;
	}
	
	public String getTxtTotalCont() {
	return txtTotalCont;
	}
	
	public void setTxtTotalCont(String txtTotalCont) {
	this.txtTotalCont = txtTotalCont;
	}
	
	public String getTxtOAAuto() {
	return txtOAAuto;
	}
	
	public void setTxtOAAuto(String txtOAAuto) {
	this.txtOAAuto = txtOAAuto;
	}
	
	public String getTxtOAMoto() {
	return txtOAMoto;
	}
	
	public void setTxtOAMoto(String txtOAMoto) {
	this.txtOAMoto = txtOAMoto;
	}
	
	public String getTxtOAEP() {
	return txtOAEP;
	}
	
	public void setTxtOAEP(String txtOAEP) {
	this.txtOAEP = txtOAEP;
	}
	
	public String getTxtDua() {
	return txtDua;
	}
	
	public void setTxtDua(String txtDua) {
	this.txtDua = txtDua;
	}
	
	public String getTxtTotalMetrica() {
	return txtTotalMetrica;
	}
	
	public void setTxtTotalMetrica(String txtTotalMetrica) {
	this.txtTotalMetrica = txtTotalMetrica;
	}
	
	public String getTxtReportesDocs() {
	return txtReportesDocs;
	}
	
	public void setTxtReportesDocs(String txtReportesDocs) {
	this.txtReportesDocs = txtReportesDocs;
	}
	
	public String getTxtTotalRepOAA() {
	return txtTotalRepOAA;
	}
	
	public void setTxtTotalRepOAA(String txtTotalRepOAA) {
	this.txtTotalRepOAA = txtTotalRepOAA;
	}
	
	public String getTxtTotalRepOAM() {
	return txtTotalRepOAM;
	}
	
	public void setTxtTotalRepOAM(String txtTotalRepOAM) {
	this.txtTotalRepOAM = txtTotalRepOAM;
	}
	
	public String getTxtTotalRepOAE() {
	return txtTotalRepOAE;
	}
	
	public void setTxtTotalRepOAE(String txtTotalRepOAE) {
	this.txtTotalRepOAE = txtTotalRepOAE;
	}
	
	public String getTxtTotalRepDUA() {
	return txtTotalRepDUA;
	}
	
	public void setTxtTotalRepDUA(String txtTotalRepDUA) {
	this.txtTotalRepDUA = txtTotalRepDUA;
	}
	
	public ExpedienteEjecutivo getObjetoActua() {
	return objetoActua;
	}
	
	public void setObjetoActua(ExpedienteEjecutivo objetoActua) {
	this.objetoActua = objetoActua;
	}
	
	public String getDocDescargar() {
	return docDescargar;
	}
	
	public void setDocDescargar(String docDescargar) {
	this.docDescargar = docDescargar;
	}
	
	public Boolean getBotonSftp() {
	return botonSftp;
	}
	
	public void setBotonSftp(Boolean botonSftp) {
	this.botonSftp = botonSftp;
	}
	
	public Boolean getBotonNoSftp() {
	return botonNoSftp;
	}
	
	public void setBotonNoSftp(Boolean botonNoSftp) {
	this.botonNoSftp = botonNoSftp;
	}
	
	public Boolean getBotonEmail() {
	return botonEmail;
	}
	
	public void setBotonEmail(Boolean botonEmail) {
	this.botonEmail = botonEmail;
	}
	
	public Boolean getBotonNoEmail() {
	return botonNoEmail;
	}
	
	public void setBotonNoEmail(Boolean botonNoEmail) {
	this.botonNoEmail = botonNoEmail;
	}
	
	
	
	
	}
