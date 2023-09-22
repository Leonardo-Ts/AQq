package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioFrecuencia;
import com.aaq.col.clases.database.servicios.interfase.UsuarioFrecuenciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "usuarioFrecuencia")
@RequestScoped
@Entity(name = "UsuarioFrecuencia")
@Access(AccessType.FIELD)
@Table(name = "usuario_frecuencia")
public class UsuarioFrecuencia extends AbstractUsuarioFrecuencia {
	private static final long serialVersionUID = -3007799577407536837L;

	/** default constructor */
	public UsuarioFrecuencia() {
		super();
	}

	private static UsuarioFrecuenciaServiceInterfase usuarioFrecuenciaService;

	public static UsuarioFrecuenciaServiceInterfase getUsuarioFrecuenciaService() {
		if (UsuarioFrecuencia.usuarioFrecuenciaService == null) {
			UsuarioFrecuencia.usuarioFrecuenciaService = JMSIICAServerServiceSingleton.getInstance()
					.getUsuarioFrecuenciaService();
		}
		return UsuarioFrecuencia.usuarioFrecuenciaService;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return UsuarioFrecuencia.getUsuarioFrecuenciaService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return UsuarioFrecuencia.getUsuarioFrecuenciaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
