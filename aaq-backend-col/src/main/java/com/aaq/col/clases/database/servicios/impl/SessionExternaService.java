package com.aaq.col.clases.database.servicios.impl;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.SessionExterna;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.SessionExternaDao;
import com.aaq.col.clases.database.servicios.interfase.SessionExternaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("sessionExternaService")
@Transactional
public class SessionExternaService implements SessionExternaServiceInterfase {
	
	@Autowired
	@Qualifier("sessionExternaDao")
	SessionExternaDao sessionExternaDao;

	@Override
	public SessionExterna objetoSessionExterna(final String id) {
		return this.sessionExternaDao.objetoSessionExterna(id);
	}

	@Override
	public SessionExterna objetoSessionExternaParaTerminal(final Terminal terminal) {
		return this.sessionExternaDao.objetoSessionExternaParaTerminal(terminal);
	}

	@Override
	public List<SessionExterna> listaDeSessionExterna(final List<Terminal> listaTerminales, final Date fechaInicia,
			final Date fechaFinal) {
		return this.sessionExternaDao.listaDeSessionExterna(listaTerminales, fechaInicia, fechaFinal);
	}

	@Override
	public void informacionDeSessionExterna(final Terminal terminal, final String operacion) {
		this.sessionExternaDao.informacionDeSessionExterna(terminal, operacion);

	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final SessionExterna t) {
		return this.sessionExternaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final SessionExterna t) {
		return this.sessionExternaDao.guardarObjeto(t);
	}
}