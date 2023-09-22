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
 * AbstractColonia entity provides the base persistence definition of the
 * Colonia entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractColonia extends JMEntidad {

	private static final long serialVersionUID = -1346814828886560713L;

	@SequenceGenerator(name = "coloniaSEQ", sequenceName = "colonia_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coloniaSEQ")
	private Integer id;

	@Column(name = "cp", length = 255, nullable = false, unique = false)
	private String cp;

	@Column(name = "idcolonia", nullable = false, unique = false)
	private Integer idcolonia;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "idmunicipio", nullable = false, unique = true)
	private Integer idmunicipio;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractColonia() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @return the cp
	 */
	public String getCp() {
		return this.cp;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @param cp
	 *            the cp to set
	 */
	public void setCp(final String cp) {
		this.cp = cp;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @return the idcolonia
	 */
	public Integer getIdcolonia() {
		return this.idcolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @param idcolonia
	 *            the idcolonia to set
	 */
	public void setIdcolonia(final Integer idcolonia) {
		this.idcolonia = idcolonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @return the idmunicipio
	 */
	public Integer getIdmunicipio() {
		return this.idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @param idmunicipio
	 *            the idmunicipio to set
	 */
	public void setIdmunicipio(final Integer idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:25:58 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}