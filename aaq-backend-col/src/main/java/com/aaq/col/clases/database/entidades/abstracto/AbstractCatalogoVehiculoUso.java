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
 * AbstractCatalogoVehiculoUso entity provides the base persistence definition
 * of the CatalogoVehiculoUso entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoVehiculoUso extends JMEntidad {

	/**
	 * mfernandez Aug 7, 2014 3:25:22 PM
	 */
	private static final long serialVersionUID = -3035258161869248894L;

	@SequenceGenerator(name = "catalogo_vehiculo_usoSEQ", sequenceName = "catalogo_vehiculo_uso_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_vehiculo_usoSEQ")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = true, unique = false)
	private String clave;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	// Constructors

	/** default constructor */
	public AbstractCatalogoVehiculoUso() {
	}

	/**
	 * mfernandez Aug 7, 2014 3:24:51 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:24:51 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:24:51 PM
	 * 
	 * @return the clave
	 */
	public String getClave() {
		return this.clave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:24:51 PM
	 * 
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(final String clave) {
		this.clave = clave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:24:51 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:24:51 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

}