package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalReporteServiceInterfase extends JMServicioGenericoInterfase<TerminalReporte> {

	public abstract TerminalReporte objetoTerminalReporte(final String id) ;
	public abstract List<TerminalReporte> listaDeTerminalReporte(final Terminal terminal, final String ramo,
			final String anio, final String reporte, final String siniestro, final String identificadorUnico,
			final Date fechaInicial, final Date fechaFinal, final Integer limite) ;
	public abstract List<JMEntidadObjeto> listaDeTerminalReporteParaGrafica(final String idterminal, final String ramo,
			final String anio, final String reporte, final String siniestro, final String identificadorUnico,
			final Date fechaInicial, final Date fechaFinal) ;
	public abstract JMResultadoOperacion eliminarObjeto(TerminalReporte t) ;
	public abstract JMResultadoOperacion guardarObjeto(TerminalReporte t) ;
}