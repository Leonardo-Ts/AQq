package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.TerminalReporteDocumentoTipo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface TerminalReporteDocumentoTipoDaoInterfase extends
		JMRepositorioGenericoInterfase<TerminalReporteDocumentoTipo> {

	public abstract TerminalReporteDocumentoTipo objetoTerminalReporteDocumentoTipo(String id);
	public abstract List<TerminalReporteDocumentoTipo> listaDeTerminalReporteDocumentoTipo();

}