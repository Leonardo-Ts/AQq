package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.repositorios.impl.TerminalReporteDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalReporteServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalReporteService")
@Transactional
public class TerminalReporteService implements TerminalReporteServiceInterfase {
	@Autowired
	@Qualifier("terminalReporteDao")
	TerminalReporteDao terminalReporteDao;

	@Override
	public TerminalReporte objetoTerminalReporte(final String id) {
		return this.terminalReporteDao.objetoTerminalReporte(id);
	}

	@Override
	public List<TerminalReporte> listaDeTerminalReporte(final Terminal terminal, final String ramo, final String anio,
			final String reporte, final String siniestro, final String identificadorUnico, final Date fechaInicial,
			final Date fechaFinal, final Integer limite) {
		return this.terminalReporteDao.listaDeTerminalReporte(terminal, ramo, anio, reporte, siniestro,
				identificadorUnico, fechaInicial, fechaFinal, limite);
	}

	@Override
	public List<JMEntidadObjeto> listaDeTerminalReporteParaGrafica(final String idterminal, final String ramo,
			final String anio, final String reporte, final String siniestro, final String identificadorUnico,
			final Date fechaInicial, final Date fechaFinal) {
		return this.terminalReporteDao.listaDeTerminalReporteParaGrafica(idterminal, ramo, anio, reporte, siniestro,
				identificadorUnico, fechaInicial, fechaFinal);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final TerminalReporte t) {
		return this.terminalReporteDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final TerminalReporte t) {
		return this.terminalReporteDao.guardarObjeto(t);
	}
}