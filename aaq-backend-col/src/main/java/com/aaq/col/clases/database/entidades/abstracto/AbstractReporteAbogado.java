package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

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

/**
 * AbstractReporteAbogado entity provides the base persistence definition of the
 * ReporteAbogado entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReporteAbogado extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7444032871596231778L;

	@SequenceGenerator(name = "reporte_abogadoSEQ", sequenceName = "reporte_abogado_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_abogadoSEQ")
	private Integer id;

	@Column(name = "fecha_recibido_ws", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRecibidoWs;

	@Column(name = "fecha_asignado", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaAsignado;

	@Column(name = "fecha_arribo", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaArribo;

	@Column(name = "numero_reporte_sise", length = 255, nullable = true, unique = false)
	private String numeroReporteSise;

	@Column(name = "numero_reporte_legal", length = 255, nullable = true, unique = false)
	private String numeroReporteLegal;

	@Column(name = "numero_proveedor_abogado", nullable = true, unique = false)
	private String numeroProveedorAbogado;

	@Column(name = "estatus", length = 255, nullable = true, unique = false)
	private String estatus;

	@Column(name = "conductor_detenido", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean conductorDetenido;

	@Column(name = "vehiculo_retenido", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean vehiculoRetenido;

	@Column(name = "numero_lesionados_na", nullable = true, unique = false)
	private Integer numeroLesionadosNa;

	@Column(name = "numero_lesionados_ts", nullable = true, unique = false)
	private Integer numeroLesionadosTs;

	@Column(name = "numero_muertos_na", nullable = true, unique = false)
	private Integer numeroMuertosNa;

	@Column(name = "numero_muertos_ts", nullable = true, unique = false)
	private Integer numeroMuertosTs;

	@Column(name = "lugar_a_presentarse", length = 255, nullable = true, unique = false)
	private String lugarAPresentarse;

	@Column(name = "enviado_a_sise", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean enviadoASise;

	@Column(name = "enviado_por_sms", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean enviadoPorSms;
	
	@Column(name = "responsabilidad", nullable = true, unique = false)
	private Integer responsabilidad;
	
	@Column(name = "motivo_solicitud", nullable = true, unique = false)
	private Integer motivoSolicitud;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;
	
	@Column(name = "telefono_Abogado", nullable = true, unique = false)
	private Integer telefonoAbogado;

	// Constructors

	/** default constructor */
	public AbstractReporteAbogado() {
		super();
	}

	/**
	 * full constructor
	 * 
	 * @param terminal
	 * @param fechaRecibidoWs
	 * @param numeroReporteSise
	 * @param numeroReporteLegal
	 * @param numeroProveedorAbogado
	 * @param estatus
	 * @param conductorDetenido
	 * @param vehiculoRetenido
	 * @param numeroLesionadosNa
	 * @param numeroLesionadosTs
	 * @param numeroMuertosNa
	 * @param numeroMuertosTs
	 * @param lugarAPresentarse
	 * @param enviadoASise
	 * @param enviadoPorSms
	 * @param telefonoAbogado
	 */
	public AbstractReporteAbogado(final Terminal terminal, final Date fechaRecibidoWs, final String numeroReporteSise,
			final String numeroReporteLegal, final String numeroProveedorAbogado, final String estatus,
			final Boolean conductorDetenido, final Boolean vehiculoRetenido, final Integer numeroLesionadosNa,
			final Integer numeroLesionadosTs, final Integer numeroMuertosNa, final Integer numeroMuertosTs,
			final String lugarAPresentarse, final Boolean enviadoASise, final Boolean enviadoPorSms, final Integer responsabilidad,
			final Integer motivoSolicitud, final Integer telefonoAbogado) {
		this.terminal = terminal;
		this.fechaRecibidoWs = fechaRecibidoWs;
		this.numeroReporteSise = numeroReporteSise;
		this.numeroReporteLegal = numeroReporteLegal;
		this.numeroProveedorAbogado = numeroProveedorAbogado;
		this.estatus = estatus;
		this.conductorDetenido = conductorDetenido;
		this.vehiculoRetenido = vehiculoRetenido;
		this.numeroLesionadosNa = numeroLesionadosNa;
		this.numeroLesionadosTs = numeroLesionadosTs;
		this.numeroMuertosNa = numeroMuertosNa;
		this.numeroMuertosTs = numeroMuertosTs;
		this.lugarAPresentarse = lugarAPresentarse;
		this.enviadoASise = enviadoASise;
		this.enviadoPorSms = enviadoPorSms;
		this.responsabilidad = responsabilidad;
		this.motivoSolicitud = motivoSolicitud;
		this.telefonoAbogado = telefonoAbogado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the fechaRecibidoWs
	 */
	public java.util.Date getFechaRecibidoWs() {
		return this.fechaRecibidoWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param fechaRecibidoWs
	 *            the fechaRecibidoWs to set
	 */
	public void setFechaRecibidoWs(final java.util.Date fechaRecibidoWs) {
		this.fechaRecibidoWs = fechaRecibidoWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the fechaAsignado
	 */
	public java.util.Date getFechaAsignado() {
		return this.fechaAsignado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param fechaAsignado
	 *            the fechaAsignado to set
	 */
	public void setFechaAsignado(final java.util.Date fechaAsignado) {
		this.fechaAsignado = fechaAsignado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the fechaArribo
	 */
	public java.util.Date getFechaArribo() {
		return this.fechaArribo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param fechaArribo
	 *            the fechaArribo to set
	 */
	public void setFechaArribo(final java.util.Date fechaArribo) {
		this.fechaArribo = fechaArribo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroReporteSise
	 */
	public String getNumeroReporteSise() {
		return this.numeroReporteSise;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroReporteSise
	 *            the numeroReporteSise to set
	 */
	public void setNumeroReporteSise(final String numeroReporteSise) {
		this.numeroReporteSise = numeroReporteSise;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroReporteLegal
	 */
	public String getNumeroReporteLegal() {
		return this.numeroReporteLegal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroReporteLegal
	 *            the numeroReporteLegal to set
	 */
	public void setNumeroReporteLegal(final String numeroReporteLegal) {
		this.numeroReporteLegal = numeroReporteLegal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroProveedorAbogado
	 */
	public String getNumeroProveedorAbogado() {
		return this.numeroProveedorAbogado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroProveedorAbogado
	 *            the numeroProveedorAbogado to set
	 */
	public void setNumeroProveedorAbogado(final String numeroProveedorAbogado) {
		this.numeroProveedorAbogado = numeroProveedorAbogado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the estatus
	 */
	public String getEstatus() {
		return this.estatus;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(final String estatus) {
		this.estatus = estatus;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the conductorDetenido
	 */
	public Boolean getConductorDetenido() {
		return this.conductorDetenido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param conductorDetenido
	 *            the conductorDetenido to set
	 */
	public void setConductorDetenido(final Boolean conductorDetenido) {
		this.conductorDetenido = conductorDetenido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the vehiculoRetenido
	 */
	public Boolean getVehiculoRetenido() {
		return this.vehiculoRetenido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param vehiculoRetenido
	 *            the vehiculoRetenido to set
	 */
	public void setVehiculoRetenido(final Boolean vehiculoRetenido) {
		this.vehiculoRetenido = vehiculoRetenido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroLesionadosNa
	 */
	public Integer getNumeroLesionadosNa() {
		return this.numeroLesionadosNa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroLesionadosNa
	 *            the numeroLesionadosNa to set
	 */
	public void setNumeroLesionadosNa(final Integer numeroLesionadosNa) {
		this.numeroLesionadosNa = numeroLesionadosNa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroLesionadosTs
	 */
	public Integer getNumeroLesionadosTs() {
		return this.numeroLesionadosTs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroLesionadosTs
	 *            the numeroLesionadosTs to set
	 */
	public void setNumeroLesionadosTs(final Integer numeroLesionadosTs) {
		this.numeroLesionadosTs = numeroLesionadosTs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroMuertosNa
	 */
	public Integer getNumeroMuertosNa() {
		return this.numeroMuertosNa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroMuertosNa
	 *            the numeroMuertosNa to set
	 */
	public void setNumeroMuertosNa(final Integer numeroMuertosNa) {
		this.numeroMuertosNa = numeroMuertosNa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the numeroMuertosTs
	 */
	public Integer getNumeroMuertosTs() {
		return this.numeroMuertosTs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param numeroMuertosTs
	 *            the numeroMuertosTs to set
	 */
	public void setNumeroMuertosTs(final Integer numeroMuertosTs) {
		this.numeroMuertosTs = numeroMuertosTs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the lugarAPresentarse
	 */
	public String getLugarAPresentarse() {
		return this.lugarAPresentarse;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param lugarAPresentarse
	 *            the lugarAPresentarse to set
	 */
	public void setLugarAPresentarse(final String lugarAPresentarse) {
		this.lugarAPresentarse = lugarAPresentarse;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the enviadoASise
	 */
	public Boolean getEnviadoASise() {
		return this.enviadoASise;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param enviadoASise
	 *            the enviadoASise to set
	 */
	public void setEnviadoASise(final Boolean enviadoASise) {
		this.enviadoASise = enviadoASise;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the enviadoPorSms
	 */
	public Boolean getEnviadoPorSms() {
		return this.enviadoPorSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param enviadoPorSms
	 *            the enviadoPorSms to set
	 */
	public void setEnviadoPorSms(final Boolean enviadoPorSms) {
		this.enviadoPorSms = enviadoPorSms;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the responsabilidad
	 */
	public Integer getResponsabilidad() {
		return responsabilidad;
	}

	/**
	 * @author Arturo de la Cruz
	 * @param responsabilidad the responsabilidad to set
	 */
	public void setResponsabilidad(Integer responsabilidad) {
		this.responsabilidad = responsabilidad;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the motivoSolicitud
	 */
	public Integer getMotivoSolicitud() {
		return motivoSolicitud;
	}

	/**
	 * @author Arturo de la Cruz
	 * @param motivoSolicitud the motivoSolicitud to set
	 */
	public void setMotivoSolicitud(Integer motivoSolicitud) {
		this.motivoSolicitud = motivoSolicitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:06:05 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	public Integer getTelefonoAbogado() {
		return telefonoAbogado;
	}

	public void setTelefonoAbogado(Integer telefonoAbogado) {
		this.telefonoAbogado = telefonoAbogado;
	}
}