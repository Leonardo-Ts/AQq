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
public abstract class AbstractMunicipio extends JMEntidad {

	private static final long serialVersionUID = 5077608937103117642L;

	@SequenceGenerator(name = "municipioSEQ", sequenceName = "municipio_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipioSEQ")
	private Integer id;

	@Column(name = "idmunicipio", nullable = false, unique = true)
	private Integer idmunicipio;

	@Column(name = "nombre", length = 255, nullable = false, unique = false)
	private String nombre;

	@Column(name = "clave_entidad", length = 255, nullable = true, unique = false)
	private String claveEntidad;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	@Column(name = "identidad", nullable = false, unique = true, insertable = false, updatable = false)
	private Integer identidad_;

	// Constructors

	/**
	 * mfernandez Aug 9, 2014 10:03:55 AM
	 * 
	 * @return the identidad_
	 */
	public Integer getIdentidad_() {
		return this.identidad_;
	}

	/**
	 * mfernandez Aug 9, 2014 10:03:55 AM
	 * 
	 * @param identidad_
	 *            the identidad_ to set
	 */
	public void setIdentidad_(final Integer identidad_) {
		this.identidad_ = identidad_;
	}

	/** default constructor */
	public AbstractMunicipio() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @return the idmunicipio
	 */
	public Integer getIdmunicipio() {
		return this.idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @param idmunicipio
	 *            the idmunicipio to set
	 */
	public void setIdmunicipio(final Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @return the claveEntidad
	 */
	public String getClaveEntidad() {
		return this.claveEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @param claveEntidad
	 *            the claveEntidad to set
	 */
	public void setClaveEntidad(final String claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:15 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}