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

import com.aaq.col.clases.database.entidades.CarreteraTipo;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCarretera extends JMEntidad {

	private static final long serialVersionUID = 1630778329040503125L;

	@SequenceGenerator(name = "carreteraSEQ", sequenceName = "carretera_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carreteraSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "latitud", nullable = false, unique = false)
	private java.lang.Double latitud;

	@Column(name = "longitud", nullable = false, unique = false)
	private java.lang.Double longitud;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CarreteraTipo.class)
	@JoinColumn(name = "idcarreteratipo", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private CarreteraTipo carreteraTipo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractCarretera() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @return the latitud
	 */
	public java.lang.Double getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final java.lang.Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @return the longitud
	 */
	public java.lang.Double getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final java.lang.Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @return the carreteraTipo
	 */
	public CarreteraTipo getCarreteraTipo() {
		return this.carreteraTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @param carreteraTipo
	 *            the carreteraTipo to set
	 */
	public void setCarreteraTipo(final CarreteraTipo carreteraTipo) {
		this.carreteraTipo = carreteraTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:16:11 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}