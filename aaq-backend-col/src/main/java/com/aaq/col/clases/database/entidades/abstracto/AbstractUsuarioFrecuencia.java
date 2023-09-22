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

import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractUsuarioFrecuencia entity provides the base persistence definition of
 * the UsuarioFrecuencia entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractUsuarioFrecuencia extends JMEntidad {

	private static final long serialVersionUID = 4414060393327185759L;

	@SequenceGenerator(name = "usuario_frecuenciaSEQ", sequenceName = "usuario_frecuencia_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_frecuenciaSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = FrecuenciaBase.class)
	@JoinColumn(name = "idfrecuenciazona", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private FrecuenciaBase frecuenciaBase;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Usuario.class)
	@JoinColumn(name = "idusuario", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractUsuarioFrecuencia() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:52:32 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:52:32 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:52:32 PM
	 * 
	 * @return the frecuenciaBase
	 */
	public FrecuenciaBase getFrecuenciaBase() {
		return this.frecuenciaBase;
	}

	/**
	 * mfernandez Aug 7, 2014 4:52:32 PM
	 * 
	 * @param frecuenciaBase
	 *            the frecuenciaBase to set
	 */
	public void setFrecuenciaBase(final FrecuenciaBase frecuenciaBase) {
		this.frecuenciaBase = frecuenciaBase;
	}

	/**
	 * mfernandez Aug 7, 2014 4:52:32 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:52:32 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

}