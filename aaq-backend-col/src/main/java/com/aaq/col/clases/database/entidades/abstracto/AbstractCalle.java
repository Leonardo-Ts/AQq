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

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCalle extends JMEntidad {

	private static final long serialVersionUID = -7704295031041760941L;

	@SequenceGenerator(name = "calleSEQ", sequenceName = "calle_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calleSEQ")
	private Integer id;

	@Column(name = "latitud", nullable = false, unique = true)
	private java.lang.Double latitud;

	@Column(name = "longitud", nullable = false, unique = true)
	private java.lang.Double longitud;

	@Column(name = "idcolonia", nullable = false, unique = true)
	private Integer idcolonia;

	@Column(name = "idmunicipio", nullable = false, unique = true)
	private Integer idmunicipio;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "nombre_colonia", length = 255, nullable = false, unique = false)
	private String nombreColonia;

	@Column(name = "nombre_municipio", length = 255, nullable = false, unique = false)
	private String nombreMunicipio;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractCalle() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the id
	 */
//	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the latitud
	 */
	public java.lang.Double getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final java.lang.Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the longitud
	 */
	public java.lang.Double getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final java.lang.Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the idcolonia
	 */
	public Integer getIdcolonia() {
		return this.idcolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param idcolonia
	 *            the idcolonia to set
	 */
	public void setIdcolonia(final Integer idcolonia) {
		this.idcolonia = idcolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the idmunicipio
	 */
	public Integer getIdmunicipio() {
		return this.idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param idmunicipio
	 *            the idmunicipio to set
	 */
	public void setIdmunicipio(final Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the nombreColonia
	 */
	public String getNombreColonia() {
		return this.nombreColonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param nombreColonia
	 *            the nombreColonia to set
	 */
	public void setNombreColonia(final String nombreColonia) {
		this.nombreColonia = nombreColonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the nombreMunicipio
	 */
	public String getNombreMunicipio() {
		return this.nombreMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param nombreMunicipio
	 *            the nombreMunicipio to set
	 */
	public void setNombreMunicipio(final String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:13:44 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}