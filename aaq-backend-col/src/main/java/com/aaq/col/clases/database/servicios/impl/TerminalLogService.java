 package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.aaq.col.clases.database.repositorios.impl.TerminalLogDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalLogServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalLogService")
@Transactional
public class TerminalLogService implements TerminalLogServiceInterfase {
	
	@Autowired
	@Qualifier("terminalLogDao")
	TerminalLogDao terminalLogDao;

	@Override
	public TerminalLog objetoTerminalLog(final String id) {
		return this.terminalLogDao.objetoTerminalLog(id);
	}

	@Override
	public List<TerminalLog> listaDeTerminalLog(final Date fechaInicial, final Date fechaFinal) {
		return this.terminalLogDao.listaDeTerminalLog(fechaInicial, fechaFinal);
	}

	@Override
	public List<TerminalLog> listaDeTerminalLog(final List<Terminal> terminal, final Date fechaInicial,
			final Date fechaFinal, final boolean validez, final boolean esTraza, final Integer limite) {
		return this.terminalLogDao.listaDeTerminalLog(terminal, fechaInicial, fechaFinal, validez, esTraza, limite);
	}

	@Override
	public List<TerminalLog> listaDeTerminalLogParaCoordenadas(final Date fechaInicial, final Date fechaFinal,
			final String latitud, final String longitud, final String radio) {
		return this.terminalLogDao
				.listaDeTerminalLogParaCoordenadas(fechaInicial, fechaFinal, latitud, longitud, radio);
	}

	@Override
	public List<JMEntidadObjeto> listaDeTerminalLogParaGrafica(final Date fechainicial, final Date fechaFinal,
			final String idterminal, final String reporte) {
		return this.terminalLogDao.listaDeTerminalLogParaGrafica(fechainicial, fechaFinal, idterminal, reporte);
	}

	@Override
	public List<JMEntidadObjeto> listaDeTerminalLogParaGraficaKMDia(final Date fechainicial, final Date fechaFinal,
			final String terminal) {
		return this.terminalLogDao.listaDeTerminalLogParaGraficaKMDia(fechainicial, fechaFinal, terminal);
	}

	@Override
	public List<JMEntidadObjeto> listaDeTerminalLogParaTiempoDeParado(final Date fechainicial, final Date fechaFinal,
			final String terminal) {
		return this.terminalLogDao.listaDeTerminalLogParaTiempoDeParado(fechainicial, fechaFinal, terminal);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final TerminalLog t) {
		return this.terminalLogDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final TerminalLog t) {
		return this.terminalLogDao.guardarObjeto(t);
	}

}