package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumento;
import com.aaq.col.clases.database.repositorios.impl.TerminalReporteDocumentoDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalReporteDocumentoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalReporteDocumentoService")
@Transactional
public class TerminalReporteDocumentoService implements TerminalReporteDocumentoServiceInterfase {
	
	@Autowired
	@Qualifier("terminalReporteDocumentoDao")
	TerminalReporteDocumentoDao terminalReporteDocumentoDao;

	@Override
	public TerminalReporteDocumento objetoTerminalReporteDocumento(final String id) {
		return this.terminalReporteDocumentoDao.objetoTerminalReporteDocumento(id);
	}

	@Override
	public List<TerminalReporteDocumento> listaDeTerminalReporteDocumento(final TerminalReporte reporte) {
		return this.terminalReporteDocumentoDao.listaDeTerminalReporteDocumento(reporte);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final TerminalReporteDocumento t) {
		return this.terminalReporteDocumentoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final TerminalReporteDocumento t) {
		return this.terminalReporteDocumentoDao.guardarObjeto(t);
	}
}