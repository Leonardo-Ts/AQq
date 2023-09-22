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

/**
 * AbstractReferencia entity provides the base persistence definition of the
 * Referencia entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReferencia extends JMEntidad {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6738048497934819437L;

	@SequenceGenerator(name = "referenciaSEQ", sequenceName = "referencia_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referenciaSEQ")
	private Integer id;

	@Column(name = "latitud", nullable = false, unique = false)
	private java.lang.Double latitud;

	@Column(name = "longitud", nullable = false, unique = false)
	private java.lang.Double longitud;

	@Column(name = "idcolonia", nullable = true, unique = false)
	private Integer idcolonia;

	@Column(name = "idmunicipio", nullable = true, unique = true)
	private Integer idmunicipio;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "nombrecolonia", length = 255, nullable = false, unique = false)
	private String nombrecolonia;

	@Column(name = "nombremunicipio", length = 255, nullable = false, unique = false)
	private String nombremunicipio;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractReferencia() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the latitud
	 */
	public java.lang.Double getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final java.lang.Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the longitud
	 */
	public java.lang.Double getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final java.lang.Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the idcolonia
	 */
	public Integer getIdcolonia() {
		return this.idcolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param idcolonia
	 *            the idcolonia to set
	 */
	public void setIdcolonia(final Integer idcolonia) {
		this.idcolonia = idcolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the idmunicipio
	 */
	public Integer getIdmunicipio() {
		return this.idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param idmunicipio
	 *            the idmunicipio to set
	 */
	public void setIdmunicipio(final Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the nombrecolonia
	 */
	public String getNombrecolonia() {
		return this.nombrecolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param nombrecolonia
	 *            the nombrecolonia to set
	 */
	public void setNombrecolonia(final String nombrecolonia) {
		this.nombrecolonia = nombrecolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the nombremunicipio
	 */
	public String getNombremunicipio() {
		return this.nombremunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param nombremunicipio
	 *            the nombremunicipio to set
	 */
	public void setNombremunicipio(final String nombremunicipio) {
		this.nombremunicipio = nombremunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:05:23 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}