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
 * AbstractCartografia entity provides the base persistence definition of the
 * Cartografia entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCartografia extends JMEntidad {
	private static final long serialVersionUID = 2888415775949619303L;

	// Fields
	@SequenceGenerator(name = "cartografiaSEQ", sequenceName = "cartografia_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartografiaSEQ")
	private Integer id;

	@Column(name = "latitud", nullable = false, unique = false)
	private java.lang.Double latitud;

	@Column(name = "longitud", nullable = false, unique = false)
	private java.lang.Double longitud;

	@Column(name = "zoom", nullable = false, unique = false)
	private java.lang.Double zoom;

	@Column(name = "tipo", nullable = false, unique = true)
	private Integer tipo;

	@Column(name = "definicion", nullable = false, unique = false)
	private String definicion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractCartografia() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the latitud
	 */
	public java.lang.Double getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final java.lang.Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the longitud
	 */
	public java.lang.Double getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final java.lang.Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the zoom
	 */
	public java.lang.Double getZoom() {
		return this.zoom;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param zoom
	 *            the zoom to set
	 */
	public void setZoom(final java.lang.Double zoom) {
		this.zoom = zoom;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the tipo
	 */
	public Integer getTipo() {
		return this.tipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(final Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the definicion
	 */
	public String getDefinicion() {
		return this.definicion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param definicion
	 *            the definicion to set
	 */
	public void setDefinicion(final String definicion) {
		this.definicion = definicion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:18:18 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}