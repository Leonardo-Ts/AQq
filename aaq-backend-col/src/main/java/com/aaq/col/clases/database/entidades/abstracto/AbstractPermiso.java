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

import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.Perfil;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractPermiso entity provides the base persistence definition of the
 * Permiso entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractPermiso extends JMEntidad {

	private static final long serialVersionUID = -8074172873167365314L;

	@SequenceGenerator(name = "permisoSEQ", sequenceName = "permiso_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permisoSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Modulo.class)
	@JoinColumn(name = "idmodulo", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Modulo modulo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Perfil.class)
	@JoinColumn(name = "idperfil", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private Perfil perfil;

	// Constructors

	/** default constructor */
	public AbstractPermiso() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:52:32 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:52:32 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:52:32 PM
	 * 
	 * @return the modulo
	 */
	public Modulo getModulo() {
		return this.modulo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:52:32 PM
	 * 
	 * @param modulo
	 *            the modulo to set
	 */
	public void setModulo(final Modulo modulo) {
		this.modulo = modulo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:52:32 PM
	 * 
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return this.perfil;
	}

	/**
	 * mfernandez Aug 7, 2014 3:52:32 PM
	 * 
	 * @param perfil
	 *            the perfil to set
	 */
	public void setPerfil(final Perfil perfil) {
		this.perfil = perfil;
	}

}