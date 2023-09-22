package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.eclipse.persistence.annotations.Convert;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractCatalogoTipoAsistencia entity provides the base persistence
 * definition of the CatalogoTipoAsistencia entity. @author mfernandez [Jose
 * Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoTipoAsistencia extends JMEntidad {

	private static final long serialVersionUID = -6393468044174382240L;

	@SequenceGenerator(name = "catalogo_tipo_asistenciaSEQ", sequenceName = "catalogo_tipo_asistencia_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_tipo_asistenciaSEQ")
	private Integer id;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	// Constructors

	/** default constructor */
	public AbstractCatalogoTipoAsistencia() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:37 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:37 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:37 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:37 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:37 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:37 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

}