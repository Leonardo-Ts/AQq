package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumento;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface TerminalReporteDocumentoDaoInterfase extends JMRepositorioGenericoInterfase<TerminalReporteDocumento> {

	public abstract TerminalReporteDocumento objetoTerminalReporteDocumento(String id);
	public abstract List<TerminalReporteDocumento> listaDeTerminalReporteDocumento(TerminalReporte reporte);

}