package com.aaq.col.clases.database.entidades;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioLog;
import com.aaq.col.clases.database.servicios.interfase.UsuarioLogServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "usuarioLog")
@RequestScoped
@Entity(name = "UsuarioLog")
@Access(AccessType.FIELD)
@Table(name = "usuario_log")
public class UsuarioLog extends AbstractUsuarioLog {
	private static final long serialVersionUID = -6059578002296290887L;

	public UsuarioLog() {
		super();
		this.setFecha(new Date());
	}

	private static UsuarioLogServiceInterfase usuarioLogService;

	public static UsuarioLogServiceInterfase getUsuarioLogService() {
		if (UsuarioLog.usuarioLogService == null) {
			UsuarioLog.usuarioLogService = JMSIICAServerServiceSingleton.getInstance().getUsuarioLogService();
		}
		return UsuarioLog.usuarioLogService;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return UsuarioLog.getUsuarioLogService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return UsuarioLog.getUsuarioLogService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
