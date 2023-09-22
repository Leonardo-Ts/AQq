package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractSession;
import com.aaq.col.clases.database.servicios.interfase.SessionServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "sessionSistema")
@RequestScoped
@Entity(name = "Session")
@Access(AccessType.FIELD)
@Table(name = "sesion")
public class Session extends AbstractSession {

	private static final long serialVersionUID = -6583558506600704995L;

	public Session() {
		super();
	}

	private static SessionServiceInterfase sessionService;

	public static SessionServiceInterfase getSessionService() {
		if (Session.sessionService == null) {
			Session.sessionService = JMSIICAServerServiceSingleton.getInstance().getSessionService();
		}
		return Session.sessionService;
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Identificador,identificadorDeSession", "Nombre,usuario",
				"Direccion IP,direccionIp", "Inicio de Sesion,fechaInicio,fecha",
				"F. Ultimo Movimiento,fechaUltimoMovimiento,fecha", "Pagina Actual,paginaActual" }).getLista();

	}

	/*
	 * (non-Javadoc)
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return Session.getSessionService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Session.getSessionService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
