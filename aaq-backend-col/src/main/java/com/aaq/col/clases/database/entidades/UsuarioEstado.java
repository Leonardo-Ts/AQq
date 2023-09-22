package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioEstado;


/**
 * @author mfernandez Oct 17, 2014 4:11:00 PM
 */
@ManagedBean(name = "usuarioEstado")
@RequestScoped
@Entity(name = "UsuarioEstado")
@Access(AccessType.FIELD)
@Table(name = "usuario_estado")
public class UsuarioEstado extends AbstractUsuarioEstado {
	private static final long serialVersionUID = -8040131666893886079L;

	/**
	 * Oct 17, 2014 4:11:00 PM mfernandez
	 */
	public UsuarioEstado() {
		super();
	}

	/**
	 * Oct 17, 2014 4:11:00 PM mfernandez
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 * @param usuario
	 */
	public UsuarioEstado(final Estado estado, final Usuario usuario) {
		super(estado, usuario);
	}

}
