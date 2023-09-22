package com.aaq.col.system.classes.web.tomcat;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.aaq.col.clases.database.entidades.Session;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

public class JMSessionListener implements HttpSessionListener {

	public JMSessionListener() {
		super();
	}

	@Override
	public void sessionCreated(final HttpSessionEvent arg0) {
		final HttpSession session = arg0.getSession();
		if (session != null) {
			final Session sess = new Session();
			sess.setIdentificadorDeSession(session.getId());
			sess.setFechaInicio(new Date(session.getCreationTime()));
			sess.setFechaUltimoMovimiento(new Date(session.getLastAccessedTime()));
			sess.guardarObjeto();
		}
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent arg0) {
		final HttpSession session = arg0.getSession();
		if (session != null) {
			Session sess = null;
			try {
				sess = Session.getSessionService().objetoSessionParaIdentificador(session.getId());
			} catch (final Exception ex) {
				JMEntidad.getLogger().error(ex);
			}
			if (sess != null) {
				sess.eliminarObjeto();
			}
		}
	}

}
