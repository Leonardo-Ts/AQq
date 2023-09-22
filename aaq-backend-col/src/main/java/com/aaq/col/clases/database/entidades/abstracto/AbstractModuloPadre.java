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
 * AbstractModuloPadre entity provides the base persistence definition of the
 * ModuloPadre entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractModuloPadre extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7151619628212788299L;

	@SequenceGenerator(name = "modulo_padreSEQ", sequenceName = "modulo_padre_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulo_padreSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = false)
	private String nombre;

	// Constructors

	/** default constructor */
	public AbstractModuloPadre() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:50:39 PM
	 * 
	 * @return the id
	 */
//	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:50:39 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:50:39 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:50:39 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}