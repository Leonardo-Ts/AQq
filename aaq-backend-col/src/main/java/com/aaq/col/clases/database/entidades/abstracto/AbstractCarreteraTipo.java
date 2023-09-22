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
 * AbstractCarreteraTipo entity provides the base persistence definition of the
 * CarreteraTipo entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCarreteraTipo extends JMEntidad {

	private static final long serialVersionUID = -6574409376795192096L;

	@SequenceGenerator(name = "carretera_tipoSEQ", sequenceName = "carretera_tipo_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carretera_tipoSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = false)
	private String nombre;

	// Constructors

	/** default constructor */
	public AbstractCarreteraTipo() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:17:34 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:17:34 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:17:34 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:17:34 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}