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

import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractUsuarioLog extends JMEntidad {

	private static final long serialVersionUID = 463673634569991261L;

	@SequenceGenerator(name = "usuario_logSEQ", sequenceName = "usuario_log_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_logSEQ")
	private Integer id;

	@Column(name = "latitud", length = 255, nullable = true, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = true, unique = false)
	private String longitud;

	@Column(name = "fecha", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "direccion", nullable = true, unique = false)
	private String direccion;

	@Column(name = "valida", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean valida;

	@Column(name = "velocidad", nullable = true, unique = false)
	private java.lang.Double velocidad;

	@Column(name = "segundos_transcurridos", nullable = true, unique = false)
	private java.lang.Double segundosTranscurridos;

	@Column(name = "metros_recorridos", nullable = true, unique = false)
	private java.lang.Double metrosRecorridos;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractUsuarioLog() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the valida
	 */
	public Boolean getValida() {
		return this.valida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param valida
	 *            the valida to set
	 */
	public void setValida(final Boolean valida) {
		this.valida = valida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the velocidad
	 */
	public java.lang.Double getVelocidad() {
		return this.velocidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param velocidad
	 *            the velocidad to set
	 */
	public void setVelocidad(final java.lang.Double velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the segundosTranscurridos
	 */
	public java.lang.Double getSegundosTranscurridos() {
		return this.segundosTranscurridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param segundosTranscurridos
	 *            the segundosTranscurridos to set
	 */
	public void setSegundosTranscurridos(final java.lang.Double segundosTranscurridos) {
		this.segundosTranscurridos = segundosTranscurridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the metrosRecorridos
	 */
	public java.lang.Double getMetrosRecorridos() {
		return this.metrosRecorridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param metrosRecorridos
	 *            the metrosRecorridos to set
	 */
	public void setMetrosRecorridos(final java.lang.Double metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:53:08 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

}