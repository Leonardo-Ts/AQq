package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.aaq.col.clases.database.repositorios.impl.ReporteAbogadoDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteAbogadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("reporteAbogadoService")
@Transactional
public class ReporteAbogadoService implements ReporteAbogadoServiceInterfase {
	
	@Autowired
	@Qualifier("reporteAbogadoDao")
	ReporteAbogadoDao reporteAbogadoDao;

	@Override
	public ReporteAbogado objetoReporteAbogado(final String id) {
		return this.reporteAbogadoDao.objetoReporteAbogado(id);
	}

	@Override
	public ReporteAbogado objetoReporteAbogadoParaNumeroReporte(final String reporte) {
		return this.reporteAbogadoDao.objetoReporteAbogadoParaNumeroReporte(reporte);
	}

	@Override
	public ReporteAbogado objetoReporteAbogadoParaNumeroReporteYReporteLegal(final String reporteSISE,
			final String reporteLegal) {
		return this.reporteAbogadoDao.objetoReporteAbogadoParaNumeroReporteYReporteLegal(reporteSISE, reporteLegal);
	}

	@Override
	public List<ReporteAbogado> listaDeReporteAbogado(final Integer limite) {
		return this.reporteAbogadoDao.listaDeReporteAbogado(limite);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final ReporteAbogado t) {
		return this.reporteAbogadoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final ReporteAbogado t) {
		return this.reporteAbogadoDao.guardarObjeto(t);
	}
}