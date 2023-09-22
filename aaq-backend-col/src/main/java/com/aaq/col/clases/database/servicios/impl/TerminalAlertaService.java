package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;
import com.aaq.col.clases.database.repositorios.impl.TerminalAlertaDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalAlertaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalAlertaService")
@Transactional
public class TerminalAlertaService implements TerminalAlertaServiceInterfase {
	
	@Autowired
	@Qualifier("terminalAlertaDao")
	TerminalAlertaDao terminalAlertaDao;

	@Override
	public TerminalAlerta objetoTerminalAlerta(final String id) {
		return this.terminalAlertaDao.objetoTerminalAlerta(id);
	}

	@Override
	public List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal) {
		return this.terminalAlertaDao.listaDeTerminalAlerta(terminal);
	}

	@Override
	public List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal, final PuntoInteres puntoInteres,
			final Geocerca geocerca) {
		return this.terminalAlertaDao.listaDeTerminalAlerta(terminal, puntoInteres, geocerca);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final TerminalAlerta t) {
		return this.terminalAlertaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final TerminalAlerta t) {
		return this.terminalAlertaDao.guardarObjeto(t);
	}
}