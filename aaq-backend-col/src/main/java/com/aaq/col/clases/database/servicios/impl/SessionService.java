package com.aaq.col.clases.database.servicios.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aaq.col.clases.database.entidades.Session;
import com.aaq.col.clases.database.repositorios.impl.SessionDao;
import com.aaq.col.clases.database.servicios.interfase.SessionServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("sessionService")
@Transactional
public class SessionService implements SessionServiceInterfase {
	
	@Autowired
	@Qualifier("sessionDao")
	SessionDao sessionDao;

	@Override
	public Session objetoSession(final String id) {
		return this.sessionDao.objetoSession(id);
	}

	@Override
	public Session objetoSessionParaIdentificador(final String id) {
		return this.sessionDao.objetoSessionParaIdentificador(id);
	}

	@Override
	public List<Session> listaDeSession() {
		return this.sessionDao.listaDeSession();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Session t) {
		return this.sessionDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Session t) {
		return this.sessionDao.guardarObjeto(t);
	}
}