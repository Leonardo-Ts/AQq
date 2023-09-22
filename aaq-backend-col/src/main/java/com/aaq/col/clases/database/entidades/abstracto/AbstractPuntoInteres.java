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

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractPuntoInteres entity provides the base persistence definition of the
 * PuntoInteres entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractPuntoInteres extends JMEntidad {

	private static final long serialVersionUID = -826925365627160386L;

	@SequenceGenerator(name = "punto_interesSEQ", sequenceName = "punto_interes_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "punto_interesSEQ")
	private Integer id;

	@Column(name = "latitud", length = 255, nullable = false, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = false, unique = false)
	private String longitud;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PuntoInteresTipo.class)
	@JoinColumn(name = "idpuntointerestipo", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private PuntoInteresTipo puntoInteresTipo;

	// Constructors

	/** default constructor */
	public AbstractPuntoInteres() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @return the puntoInteresTipo
	 */
	public PuntoInteresTipo getPuntoInteresTipo() {
		return this.puntoInteresTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:53:23 PM
	 * 
	 * @param puntoInteresTipo
	 *            the puntoInteresTipo to set
	 */
	public void setPuntoInteresTipo(final PuntoInteresTipo puntoInteresTipo) {
		this.puntoInteresTipo = puntoInteresTipo;
	}

}