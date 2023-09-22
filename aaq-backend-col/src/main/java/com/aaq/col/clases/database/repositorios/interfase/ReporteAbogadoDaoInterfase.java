package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface ReporteAbogadoDaoInterfase extends JMRepositorioGenericoInterfase<ReporteAbogado> {

	public abstract ReporteAbogado objetoReporteAbogado(final String id);
	public abstract ReporteAbogado objetoReporteAbogadoParaNumeroReporte(final String reporte);
	public abstract ReporteAbogado objetoReporteAbogadoParaNumeroReporteYReporteLegal(final String reporteSISE,
			final String reporteLegal);
	public abstract List<ReporteAbogado> listaDeReporteAbogado(final Integer limite);

}