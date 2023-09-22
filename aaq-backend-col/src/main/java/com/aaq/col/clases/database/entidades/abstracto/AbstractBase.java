 package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

import java.util.Date;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractBase extends JMEntidad {

	private static final long serialVersionUID = 8673998520063064113L;

	@SequenceGenerator(name = "baseSEQ", sequenceName = "base_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = true, unique = true)
	private String nombre;

	@Column(name = "direccion", length = 255, nullable = true, unique = true)
	private String direccion;
	@Column(name = "latitud", length = 255, nullable = true, unique = true)
	private String latitud;
	@Column(name = "longitud", length = 255, nullable = true, unique = true)
	private String longitud;
	@Column(name = "zona", length = 255, nullable = true, unique = true)
	private String zona;

	@Column(name = "habilitado_en_mapa", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitadoEnMapa;
	
	@Column(name = "habilitado_en_mapa_cabina", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitadoEnMapaCabina;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@Column(name = "fecha_modificacion", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	@Column(name = "identidad", nullable = false, unique = true, insertable = false, updatable = false)
	private Integer identidad_;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Usuario usuario;
	
	@Column(name = "VULNERABLE", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean vulnerable;


	// Constructors

	/** default constructor */
	public AbstractBase() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

	/**
	 * mfernandez Aug 11, 2014 9:58:29 AM
	 * 
	 * @return the identidad_
	 */
	public Integer getIdentidad_() {
		return this.identidad_;
	}

	/**
	 * mfernandez Aug 11, 2014 9:58:29 AM
	 * 
	 * @param identidad_
	 *            the identidad_ to set
	 */
	public void setIdentidad_(final Integer identidad_) {
		this.identidad_ = identidad_;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @return la dir
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @param direccion
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @return la lat
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @param latitud
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @return la lon
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @param longitud
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @return la zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @param zona
	 */
	public void setZona(final String zona) {
		this.zona = zona;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @return el habilitado
	 */
	public Boolean getHabilitadoEnMapa() {
		return habilitadoEnMapa;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @param habilitadoEnMapa
	 */
	public void setHabilitadoEnMapa(final Boolean habilitadoEnMapa) {
		this.habilitadoEnMapa = habilitadoEnMapa;
	}

	/**
	 * @return the habilitadoEnMapaCabina
	 */
	public Boolean getHabilitadoEnMapaCabina() {
		return habilitadoEnMapaCabina;
	}

	/**
	 * @param habilitadoEnMapaCabina the habilitadoEnMapaCabina to set
	 */
	public void setHabilitadoEnMapaCabina(final Boolean habilitadoEnMapaCabina) {
		this.habilitadoEnMapaCabina = habilitadoEnMapaCabina;
	}
	
	/**
	 *  mfernandez enero 24 2015
	 * @return la fecha de moficiacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 *  mfernandez enero 24 2015
	 * @param fechaModificacion
	 */
	public void setFechaModificacion(final Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 *  mfernandez enero 27 2015
	 *
	 * @return el usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 *  mfernandez enero 27 2015
	 *
	 * @param usuario
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(Boolean vulnerable) {
		this.vulnerable = vulnerable;
	}
	
}