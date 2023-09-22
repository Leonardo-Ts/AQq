 package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.repositorios.impl.HistoricoTerminalDao;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("historicoTerminalService")
@Transactional
public class HistoricoTerminalService implements HistoricoTerminalServiceInterfase {
	
	@Autowired
	@Qualifier("historicoTerminalDao")
	HistoricoTerminalDao historicoTerminalDao;

	@Override
	public HistoricoTerminal objetoHistoricoTerminal(final String id) {
		return this.historicoTerminalDao.objetoHistoricoTerminal(id);
	}

	@Override
	public List<HistoricoTerminal> listaDeHistoricoTerminal(final Terminal terminal, final String reporte,
			final String operacion, final Date fechaInicial, final Date fechaFinal, final Integer limite) {
		return this.historicoTerminalDao.listaDeHistoricoTerminal(terminal, reporte, operacion, fechaInicial,
				fechaFinal, limite);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoTerminalNuevo(final Usuario usuario, final Terminal terminal,
			final String reporte, final String fuente, final String operacion, final String detalles) {
		return this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(usuario, terminal, reporte, fuente,
				operacion, detalles);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final HistoricoTerminal t) {
		return this.historicoTerminalDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final HistoricoTerminal t) {
		return this.historicoTerminalDao.guardarObjeto(t);
	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoTerminal(final Usuario usuario, final Terminal terminal,
			final String reporte, final String fuente, final String operacion, final String detalles) {
		return this.historicoTerminalDao.ejecutarFuncionHistoricoTerminal(usuario, terminal, reporte, fuente, operacion, detalles);
	}

}