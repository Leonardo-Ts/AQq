package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractEstado extends JMEntidad {

	private static final long serialVersionUID = 1512554305919202741L;

	@SequenceGenerator(name = "estadoSEQ", sequenceName = "estado_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadoSEQ")
	private Integer id;

	@Column(name = "identidad", nullable = false, unique = true)
	private Integer identidad;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "huso_horario", nullable = true, unique = false)
	private Integer husoHorario;

	@Column(name = "clave_entidad", length = 255, nullable = true, unique = false)
	private String claveEntidad;

	// Constructors

	/** default constructor */
	public AbstractEstado() {
		super();
	}

	/**
	 * @param id
	 * @param identidad
	 * @param husoHorario
	 * @param nombre
	 */
	public AbstractEstado(final Integer id, final Integer identidad, final Integer husoHorario, final String nombre) {
		super();
		this.id = id;
		this.identidad = identidad;
		this.husoHorario = husoHorario;
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @return the id
	 */
//	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @return the identidad
	 */
	public Integer getIdentidad() {
		return this.identidad;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @param identidad
	 *            the identidad to set
	 */
	public void setIdentidad(final Integer identidad) {
		this.identidad = identidad;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @return the husoHorario
	 */
	public Integer getHusoHorario() {
		return this.husoHorario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @param husoHorario
	 *            the husoHorario to set
	 */
	public void setHusoHorario(final Integer husoHorario) {
		this.husoHorario = husoHorario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @return the claveEntidad
	 */
	public String getClaveEntidad() {
		return this.claveEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 3:33:19 PM
	 * 
	 * @param claveEntidad
	 *            the claveEntidad to set
	 */
	public void setClaveEntidad(final String claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

}