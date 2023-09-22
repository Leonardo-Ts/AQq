package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlertaLog;
import com.aaq.col.clases.database.repositorios.impl.TerminalAlertaLogDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalAlertaLogServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalAlertaLogService")
@Transactional
public class TerminalAlertaLogService implements TerminalAlertaLogServiceInterfase {
	
	@Autowired
	@Qualifier("terminalAlertaLogDao")
	TerminalAlertaLogDao terminalAlertaLogDao;

	@Override
	public TerminalAlertaLog objetoTerminalAlertaLog(final String id) {
		return this.terminalAlertaLogDao.objetoTerminalAlertaLog(id);
	}

	@Override
	public List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal) {
		return this.terminalAlertaLogDao.listaDeTerminalAlertaLog(terminal);
	}

	@Override
	public List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal, final Date fechaInicial,
			final Date fechaFinal) {
		return this.terminalAlertaLogDao.listaDeTerminalAlertaLog(terminal, fechaInicial, fechaFinal);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final TerminalAlertaLog t) {
		return null;
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final TerminalAlertaLog t) {
		return this.terminalAlertaLogDao.guardarObjeto(t);
	}

}