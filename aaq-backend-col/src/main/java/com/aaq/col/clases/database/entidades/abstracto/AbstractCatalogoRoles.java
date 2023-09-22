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

/**
 * AbstractEstado entity provides the base persistence definition of the Estado
 * entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoRoles extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1512554305919202741L;

	@SequenceGenerator(name = "catalogoRolesSEQ", sequenceName = "catalogo_roles_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogoRolesSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;


	// Constructors

	/** default constructor */
	public AbstractCatalogoRoles() {
		super();
	}

	/**
	 * @param id
	 * @param identidad
	 * @param husoHorario
	 * @param nombre
	 */
	public AbstractCatalogoRoles(final Integer id, final String nombre) {
		super();
		this.id = id;
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

}