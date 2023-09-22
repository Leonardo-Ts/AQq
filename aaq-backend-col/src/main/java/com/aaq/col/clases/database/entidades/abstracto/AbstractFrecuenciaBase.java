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

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractFrecuenciaBase entity provides the base persistence definition of the
 * FrecuenciaBase entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractFrecuenciaBase extends JMEntidad {

	private static final long serialVersionUID = -1707526951045462434L;

	@SequenceGenerator(name = "frecuencia_baseSEQ", sequenceName = "frecuencia_base_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frecuencia_baseSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Base.class)
	@JoinColumn(name = "idzona", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Base base;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Frecuencia.class)
	@JoinColumn(name = "idfrecuencia", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Frecuencia frecuencia;

	// Constructors

	/** default constructor */
	public AbstractFrecuenciaBase() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @return the base
	 */
	public Base getBase() {
		return this.base;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @param base
	 *            the base to set
	 */
	public void setBase(final Base base) {
		this.base = base;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @return the frecuencia
	 */
	public Frecuencia getFrecuencia() {
		return this.frecuencia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @param frecuencia
	 *            the frecuencia to set
	 */
	public void setFrecuencia(final Frecuencia frecuencia) {
		this.frecuencia = frecuencia;
	}

}