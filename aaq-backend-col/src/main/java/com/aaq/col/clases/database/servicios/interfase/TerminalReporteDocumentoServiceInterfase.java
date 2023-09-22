package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumento;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalReporteDocumentoServiceInterfase extends JMServicioGenericoInterfase<TerminalReporteDocumento> {

	public abstract TerminalReporteDocumento objetoTerminalReporteDocumento(String id) ;
	public abstract List<TerminalReporteDocumento> listaDeTerminalReporteDocumento(TerminalReporte reporte);
	public abstract JMResultadoOperacion eliminarObjeto(TerminalReporteDocumento t) ;
	public abstract JMResultadoOperacion guardarObjeto(TerminalReporteDocumento t);
}