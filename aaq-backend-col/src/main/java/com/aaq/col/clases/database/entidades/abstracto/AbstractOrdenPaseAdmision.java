package com.aaq.col.clases.database.entidades.abstracto;

 import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractOrdenPaseAdmision extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opAdmisionSEQ", sequenceName = "orden_pase_admision_seq", allocationSize = 1)
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAdmisionSEQ")
	 private Integer id;
	
	 @Column(name = "usuario", length = 255, nullable = true, unique = false)
	 private String usuario;
	 
	 @Column(name = "fecha_hora", nullable = false, unique = true)
	 @Temporal(TemporalType.TIMESTAMP)
	 private java.util.Date fechaHora;
	 
	 @Column(name = "numero_reporte", length = 255, nullable = true, unique = false)
	 private String numeroReporte;
	 
	 @Column(name = "tipo_orden", length = 255, nullable = true, unique = false)
	 private String tipoOrden;
	 
	 @Column(name = "tipo_afectado", length = 255, nullable = true, unique = false)
	 private String tipoAfectado;
	 
	 @Column(name = "conductor", length = 255, nullable = true, unique = false)
	 private String conductor;
	 
	 @Column(name = "telefono_conductor", length = 255, nullable = true, unique = false)
	 private String telefonoConductor;
	 
	 @Column(name = "oficina", length = 255, nullable = true, unique = false)
	 private String oficina;
	 
	 @Column(name = "ubicacion", length = 255, nullable = true, unique = false)
	 private String ubicacion;
	 
	 @Column(name = "tipo_proveedor", length = 255, nullable = true, unique = false)
	 private String tipoProveedor;
	 
	 @Column(name = "clave_proveedor", length = 255, nullable = true, unique = false)
	 private String claveProveedor;
	 
	 @Column(name = "responsable_taller", length = 255, nullable = true, unique = false)
	 private String responsableTaller;
	 
	 @Column(name = "telefono_taller", length = 255, nullable = true, unique = false)
	 private String telefonoTaller;
	 
	 @Column(name = "domicilio_taller", length = 255, nullable = true, unique = false)
	 private String domicilioTaller;
	 
	 @Column(name = "cobertura", length = 255, nullable = true, unique = false)
	 private String cobertura;
	 
	 @Column(name = "marca_vehiculo", length = 255, nullable = true, unique = false)
	 private String marcaVehiculo;
	 
	 @Column(name = "tipo_vehiculo", length = 255, nullable = true, unique = false)
	 private String tipoVehiculo;
	 
	 @Column(name = "modelo_vehiculo", length = 255, nullable = true, unique = false)
	 private String modeloVehiculo;
	 
	 @Column(name = "serie_vehiculo", length = 255, nullable = true, unique = false)
	 private String serieVehiculo;
	 
	 @Column(name = "color_vehiculo", length = 255, nullable = true, unique = false)
	 private String colorVehiculo;
	 
	 @Column(name = "placas_vehiculo", length = 255, nullable = true, unique = false)
	 private String placasVehiculo;
	 
	 @Column(name = "danos_preexistentes", length = 255, nullable = true, unique = false)
	 private String danosPreexistentes;
	 
	 @Column(name = "danos_siniestro", length = 255, nullable = true, unique = false)
	 private String danosSiniestro;
	 
	 @Column(name = "deducible", nullable = true, unique = false)
	 @Convert("booleanConverter")
	 private Boolean deducible;
	 
	 @Column(name = "tipo_deducible", length = 255, nullable = true, unique = false)
	 private String tipoDeducible;
	 
	 @Column(name = "suma_asegurada", length = 255, nullable = true, unique = false)
	 private String sumaAsegurada;
	 
	 @Column(name = "porcentaje_deducible", length = 255, nullable = true, unique = false)
	 private String porcentajeDeducible;
	 
	 @Column(name = "monto", length = 255, nullable = true, unique = false)
	 private String monto;
	 
	 @Column(name = "observaciones", length = 255, nullable = true, unique = false)
	 private String observaciones;
	 
	 @Column(name = "enviado_ftp", nullable = true, unique = false)
	 @Convert("booleanConverter")
	 private Boolean enviadoFtp;
	 
	 @Column(name = "ftp_respuesta", length = 255, nullable = true, unique = false)
	 private String respuestaFtp;
	 
	 @Column(name = "reporte_numero_poliza", length = 50, nullable = true, unique = false)
	 private String reporteNumeroPoliza;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "id_ajustador", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Terminal terminal;
	
	 
	// Constructors

	/** default constructor */
	public AbstractOrdenPaseAdmision() {
		super();
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the claveProveedor
	 */
	public String getClaveProveedor() {
		return this.claveProveedor;
	}


	/**
	 * @param claveProveedor the claveProveedor to set
	 */
	public void setClaveProveedor(final String claveProveedor) {
		this.claveProveedor = claveProveedor;
	}


	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return the fechaHora
	 */
	public java.util.Date getFechaHora() {
		return this.fechaHora;
	}


	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(final java.util.Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	/**
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}


	/**
	 * @param numeroReporte the numeroReporte to set
	 */
	public void setNumeroReporte(final String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}


	/**
	 * @return the tipoOrden
	 */
	public String getTipoOrden() {
		return this.tipoOrden;
	}


	/**
	 * @param tipoOrden the tipoOrden to set
	 */
	public void setTipoOrden(final String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}


	/**
	 * @return the tipoAfectado
	 */
	public String getTipoAfectado() {
		return this.tipoAfectado;
	}


	/**
	 * @param tipoAfectado the tipoAfectado to set
	 */
	public void setTipoAfectado(final String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}


	/**
	 * @return the conductor
	 */
	public String getConductor() {
		return this.conductor;
	}


	/**
	 * @param conductor the conductor to set
	 */
	public void setConductor(final String conductor) {
		this.conductor = conductor;
	}


	/**
	 * @return the telefonoConductor
	 */
	public String getTelefonoConductor() {
		return this.telefonoConductor;
	}


	/**
	 * @param telefonoConductor the telefonoConductor to set
	 */
	public void setTelefonoConductor(final String telefonoConductor) {
		this.telefonoConductor = telefonoConductor;
	}


	/**
	 * @return the oficina
	 */
	public String getOficina() {
		return this.oficina;
	}


	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(final String oficina) {
		this.oficina = oficina;
	}


	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return this.ubicacion;
	}


	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(final String ubicacion) {
		this.ubicacion = ubicacion;
	}


	/**
	 * @return the tipoProveedor
	 */
	public String getTipoProveedor() {
		return this.tipoProveedor;
	}


	/**
	 * @param tipoProveedor the tipoProveedor to set
	 */
	public void setTipoProveedor(final String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}


	/**
	 * @return the responsableTaller
	 */
	public String getResponsableTaller() {
		return this.responsableTaller;
	}


	/**
	 * @param responsableTaller the responsableTaller to set
	 */
	public void setResponsableTaller(final String responsableTaller) {
		this.responsableTaller = responsableTaller;
	}


	/**
	 * @return the telefonoTaller
	 */
	public String getTelefonoTaller() {
		return this.telefonoTaller;
	}


	/**
	 * @param telefonoTaller the telefonoTaller to set
	 */
	public void setTelefonoTaller(final String telefonoTaller) {
		this.telefonoTaller = telefonoTaller;
	}


	/**
	 * @return the domicilioTaller
	 */
	public String getDomicilioTaller() {
		return this.domicilioTaller;
	}


	/**
	 * @param domicilioTaller the domicilioTaller to set
	 */
	public void setDomicilioTaller(final String domicilioTaller) {
		this.domicilioTaller = domicilioTaller;
	}


	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return this.cobertura;
	}


	/**
	 * @param cobertura the cobertura to set
	 */
	public void setCobertura(final String cobertura) {
		this.cobertura = cobertura;
	}


	/**
	 * @return the marcaVehiculo
	 */
	public String getMarcaVehiculo() {
		return this.marcaVehiculo;
	}


	/**
	 * @param marcaVehiculo the marcaVehiculo to set
	 */
	public void setMarcaVehiculo(final String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}


	/**
	 * @return the tipoVehiculo
	 */
	public String getTipoVehiculo() {
		return this.tipoVehiculo;
	}


	/**
	 * @param tipoVehiculo the tipoVehiculo to set
	 */
	public void setTipoVehiculo(final String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	/**
	 * @return the modeloVehiculo
	 */
	public String getModeloVehiculo() {
		return this.modeloVehiculo;
	}


	/**
	 * @param modeloVehiculo the modeloVehiculo to set
	 */
	public void setModeloVehiculo(final String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}


	/**
	 * @return the serieVehiculo
	 */
	public String getSerieVehiculo() {
		return this.serieVehiculo;
	}


	/**
	 * @param serieVehiculo the serieVehiculo to set
	 */
	public void setSerieVehiculo(final String serieVehiculo) {
		this.serieVehiculo = serieVehiculo;
	}


	/**
	 * @return the colorVehiculo
	 */
	public String getColorVehiculo() {
		return this.colorVehiculo;
	}


	/**
	 * @param colorVehiculo the colorVehiculo to set
	 */
	public void setColorVehiculo(final String colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}


	/**
	 * @return the placasVehiculo
	 */
	public String getPlacasVehiculo() {
		return placasVehiculo;
	}


	/**
	 * @param placasVehiculo the placasVehiculo to set
	 */
	public void setPlacasVehiculo(final String placasVehiculo) {
		this.placasVehiculo = placasVehiculo;
	}


	/**
	 * @return the danosPreexistentes
	 */
	public String getDanosPreexistentes() {
		return this.danosPreexistentes;
	}


	/**
	 * @param danosPreexistentes the danosPreexistentes to set
	 */
	public void setDanosPreexistentes(final String danosPreexistentes) {
		this.danosPreexistentes = danosPreexistentes;
	}


	/**
	 * @return the danosSiniestro
	 */
	public String getDanosSiniestro() {
		return this.danosSiniestro;
	}


	/**
	 * @param danosSiniestro the danosSiniestro to set
	 */
	public void setDanosSiniestro(final String danosSiniestro) {
		this.danosSiniestro = danosSiniestro;
	}


	/**
	 * @return the deducible
	 */
	public Boolean getDeducible() {
		return this.deducible;
	}


	/**
	 * @param deducible the deducible to set
	 */
	public void setDeducible(final Boolean deducible) {
		this.deducible = deducible;
	}


	/**
	 * @return the tipoDeducible
	 */
	public String getTipoDeducible() {
		return this.tipoDeducible;
	}


	/**
	 * @param tipoDeducible the tipoDeducible to set
	 */
	public void setTipoDeducible(final String tipoDeducible) {
		this.tipoDeducible = tipoDeducible;
	}


	/**
	 * @return the sumaAsegurada
	 */
	public String getSumaAsegurada() {
		return this.sumaAsegurada;
	}


	/**
	 * @param sumaAsegurada the sumaAsegurada to set
	 */
	public void setSumaAsegurada(final String sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}


	/**
	 * @return the porcentajeDeducible
	 */
	public String getPorcentajeDeducible() {
		return this.porcentajeDeducible;
	}


	/**
	 * @param porcentajeDeducible the porcentajeDeducible to set
	 */
	public void setPorcentajeDeducible(final String porcentajeDeducible) {
		this.porcentajeDeducible = porcentajeDeducible;
	}


	/**
	 * @return the monto
	 */
	public String getMonto() {
		return this.monto;
	}


	/**
	 * @param monto the monto to set
	 */
	public void setMonto(final String monto) {
		this.monto = monto;
	}


	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return this.observaciones;
	}


	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
	}


	/**
	 * @return the enviadoFtp
	 */
	public Boolean getEnviadoFtp() {
		return this.enviadoFtp;
	}


	/**
	 * @param enviadoFtp the enviadoFtp to set
	 */
	public void setEnviadoFtp(final Boolean enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}


	/**
	 * @return the respuestaFtp
	 */
	public String getRespuestaFtp() {
		return this.respuestaFtp;
	}


	/**
	 * @param respuestaFtp the respuestaFtp to set
	 */
	public void setRespuestaFtp(final String respuestaFtp) {
		this.respuestaFtp = respuestaFtp;
	}


	/**
	 * @return the reporteNumeroPoliza
	 */
	public String getReporteNumeroPoliza() {
		return reporteNumeroPoliza;
	}


	/**
	 * @param reporteNumeroPoliza the reporteNumeroPoliza to set
	 */
	public void setReporteNumeroPoliza(String reporteNumeroPoliza) {
		this.reporteNumeroPoliza = reporteNumeroPoliza;
	}

	/**
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}


	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}
}