package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.TerminalReporteDocumentoTipo;
import com.aaq.col.clases.database.repositorios.impl.TerminalReporteDocumentoTipoDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalReporteDocumentoTipoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@Service("terminalReporteDocumentoTipoService")
@Transactional
public class TerminalReporteDocumentoTipoService implements TerminalReporteDocumentoTipoServiceInterfase {
	
	@Autowired
	@Qualifier("terminalReporteDocumentoTipoDao")
	TerminalReporteDocumentoTipoDao terminalReporteDocumentoTipoDao;

	@Override
	public TerminalReporteDocumentoTipo objetoTerminalReporteDocumentoTipo(final String id) {
		return this.terminalReporteDocumentoTipoDao.objetoTerminalReporteDocumentoTipo(id);
	}

	@Override
	public List<TerminalReporteDocumentoTipo> listaDeTerminalReporteDocumentoTipo() {
		return this.terminalReporteDocumentoTipoDao.listaDeTerminalReporteDocumentoTipo();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final TerminalReporteDocumentoTipo t) {
		return this.terminalReporteDocumentoTipoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final TerminalReporteDocumentoTipo t) {
		return this.terminalReporteDocumentoTipoDao.guardarObjeto(t);
	}
}