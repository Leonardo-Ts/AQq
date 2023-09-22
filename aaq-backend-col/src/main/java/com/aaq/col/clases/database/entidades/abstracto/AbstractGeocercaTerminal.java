package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.*;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


/**
 * AbstractBase entity provides the base persistence definition of the Base
 * entity. @author mfernandez Fernandez
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractGeocercaTerminal extends JMEntidad {

	private static final long serialVersionUID = 8673998520063064199L;

	@SequenceGenerator(name = "baseSEQ", sequenceName = "base_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseSEQ")
	private Integer id;	
	@Column(name = "geocerca", length = 255, nullable = true, unique = true)
	private String geocerca;
	@Column(name = "descripcion", length = 255, nullable = true, unique = true)
	private String descripcion;

	// Constructors

	/** default constructor */
	public AbstractGeocercaTerminal() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:12:49 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the geocerca
	 */
	public String getGeocerca() {
		return this.geocerca;
	}

	/**
	 * @param geocerca the geocerca to set
	 */
	public void setGeocerca(final String geocerca) {
		this.geocerca = geocerca;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	
}