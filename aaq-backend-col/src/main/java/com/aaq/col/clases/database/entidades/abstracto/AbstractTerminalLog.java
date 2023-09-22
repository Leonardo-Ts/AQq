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
public abstract class AbstractTerminalLog extends JMEntidad {

	private static final long serialVersionUID = 4491205666350610773L;

	@SequenceGenerator(name = "terminal_logSEQ", sequenceName = "terminal_log_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_logSEQ")
	private Integer id;

	@Column(name = "latitud", length = 255, nullable = false, unique = true)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = false, unique = true)
	private String longitud;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "reporte_estatus", nullable = true, unique = false)
	private Integer reporteEstatus;

	@Column(name = "posicion_direccion", length = 255, nullable = true, unique = false)
	private String posicionDireccion;

	@Column(name = "reporte_numero", length = 255, nullable = true, unique = false)
	private String reporteNumero;

	@Column(name = "posicion_texto", nullable = true, unique = false)
	private String posicionTexto;

	@Column(name = "posicion_valida", nullable = true, unique = true)
	@Convert("booleanConverter")
	private Boolean posicionValida;

	@Column(name = "velocidad", length = 255, nullable = true, unique = false)
	private String velocidad;

	@Column(name = "longitud_mensaje", nullable = true, unique = false)
	private Integer longitudMensaje;

	@Column(name = "metros_recorridos", nullable = true, unique = false)
	private java.lang.Double metrosRecorridos;

	@Column(name = "segundos_transcurridos", nullable = true, unique = false)
	private java.lang.Double segundosTranscurridos;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	// Constructors

	/** default constructor */
	public AbstractTerminalLog() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the reporteEstatus
	 */
	public Integer getReporteEstatus() {
		return this.reporteEstatus;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param reporteEstatus
	 *            the reporteEstatus to set
	 */
	public void setReporteEstatus(final Integer reporteEstatus) {
		this.reporteEstatus = reporteEstatus;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the posicionDireccion
	 */
	public String getPosicionDireccion() {
		return this.posicionDireccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param posicionDireccion
	 *            the posicionDireccion to set
	 */
	public void setPosicionDireccion(final String posicionDireccion) {
		this.posicionDireccion = posicionDireccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the reporteNumero
	 */
	public String getReporteNumero() {
		return this.reporteNumero;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param reporteNumero
	 *            the reporteNumero to set
	 */
	public void setReporteNumero(final String reporteNumero) {
		this.reporteNumero = reporteNumero;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the posicionTexto
	 */
	public String getPosicionTexto() {
		return this.posicionTexto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param posicionTexto
	 *            the posicionTexto to set
	 */
	public void setPosicionTexto(final String posicionTexto) {
		this.posicionTexto = posicionTexto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the posicionValida
	 */
	public Boolean getPosicionValida() {
		return this.posicionValida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param posicionValida
	 *            the posicionValida to set
	 */
	public void setPosicionValida(final Boolean posicionValida) {
		this.posicionValida = posicionValida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the velocidad
	 */
	public String getVelocidad() {
		return this.velocidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param velocidad
	 *            the velocidad to set
	 */
	public void setVelocidad(final String velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the longitudMensaje
	 */
	public Integer getLongitudMensaje() {
		return this.longitudMensaje;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param longitudMensaje
	 *            the longitudMensaje to set
	 */
	public void setLongitudMensaje(final Integer longitudMensaje) {
		this.longitudMensaje = longitudMensaje;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the metrosRecorridos
	 */
	public java.lang.Double getMetrosRecorridos() {
		return this.metrosRecorridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param metrosRecorridos
	 *            the metrosRecorridos to set
	 */
	public void setMetrosRecorridos(final java.lang.Double metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the segundosTranscurridos
	 */
	public java.lang.Double getSegundosTranscurridos() {
		return this.segundosTranscurridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param segundosTranscurridos
	 *            the segundosTranscurridos to set
	 */
	public void setSegundosTranscurridos(final java.lang.Double segundosTranscurridos) {
		this.segundosTranscurridos = segundosTranscurridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:44:26 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

}