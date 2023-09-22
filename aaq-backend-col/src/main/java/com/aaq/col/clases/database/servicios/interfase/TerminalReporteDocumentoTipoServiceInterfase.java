package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.TerminalReporteDocumentoTipo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalReporteDocumentoTipoServiceInterfase extends
		JMServicioGenericoInterfase<TerminalReporteDocumentoTipo> {

	public abstract TerminalReporteDocumentoTipo objetoTerminalReporteDocumentoTipo(String id);
	public abstract List<TerminalReporteDocumentoTipo> listaDeTerminalReporteDocumentoTipo() ;
	public abstract JMResultadoOperacion eliminarObjeto(TerminalReporteDocumentoTipo t);
	public abstract JMResultadoOperacion guardarObjeto(TerminalReporteDocumentoTipo t);
}