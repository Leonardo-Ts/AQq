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

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * @author mfernandez
 */
@Access(AccessType.FIELD)
@MappedSuperclass
public class AbstractUsuarioEstado extends JMEntidad {
	private static final long serialVersionUID = -4549755770926630021L;

	@SequenceGenerator(name = "usuario_estadoSEQ", sequenceName = "usuario_estado_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_estadoSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	@Column(name = "id_estado", nullable = false, unique = false, insertable = false, updatable = false)
	private Integer idEstado_;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Usuario usuario;

	@Column(name = "id_usuario", nullable = false, unique = false, insertable = false, updatable = false)
	private Integer idUsuario_;

	/**
	 * Oct 17, 2014 4:07:10 PM mfernandez
	 */
	public AbstractUsuarioEstado() {
		super();
	}

	/**
	 * Oct 17, 2014 4:07:16 PM mfernandez
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 * @param usuario
	 */
	public AbstractUsuarioEstado(final Estado estado, final Usuario usuario) {
		super();
		this.estado = estado;
		this.usuario = usuario;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @return the idEstado_
	 */
	public Integer getIdEstado_() {
		return this.idEstado_;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @param idEstado_
	 *            the idEstado_ to set
	 */
	public void setIdEstado_(final Integer idEstado_) {
		this.idEstado_ = idEstado_;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @return the idUsuario_
	 */
	public Integer getIdUsuario_() {
		return this.idUsuario_;
	}

	/**
	 * Oct 17, 2014 4:06:28 PM mfernandez
	 * 
	 * @param idUsuario_
	 *            the idUsuario_ to set
	 */
	public void setIdUsuario_(final Integer idUsuario_) {
		this.idUsuario_ = idUsuario_;
	}

}
