 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteAbogadoServiceInterfase extends JMServicioGenericoInterfase<ReporteAbogado> {

	public abstract ReporteAbogado objetoReporteAbogado(final String id) ;
	public abstract ReporteAbogado objetoReporteAbogadoParaNumeroReporte(final String reporte) ;
	public abstract ReporteAbogado objetoReporteAbogadoParaNumeroReporteYReporteLegal(final String reporteSISE,
			final String reporteLegal) ;
	public abstract List<ReporteAbogado> listaDeReporteAbogado(final Integer limite) ;
	public abstract JMResultadoOperacion eliminarObjeto(ReporteAbogado t) ;
	public abstract JMResultadoOperacion guardarObjeto(ReporteAbogado t) ;
}