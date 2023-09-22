package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;

public interface TerminalReporteDaoInterfase extends JMRepositorioGenericoInterfase<TerminalReporte> {


	public abstract TerminalReporte objetoTerminalReporte(final String id);
	public abstract List<TerminalReporte> listaDeTerminalReporte(final Terminal terminal, final String ramo,
			final String anio, final String reporte, final String siniestro, final String identificadorUnico,
			final Date fechaInicial, final Date fechaFinal, final Integer limite);
	public abstract List<JMEntidadObjeto> listaDeTerminalReporteParaGrafica(final String idterminal, final String ramo,
			final String anio, final String reporte, final String siniestro, final String identificadorUnico,
			final Date fechaInicial, final Date fechaFinal);

}