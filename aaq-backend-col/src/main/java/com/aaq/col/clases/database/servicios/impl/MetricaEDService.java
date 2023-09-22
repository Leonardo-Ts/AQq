package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.MetricaED;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.aaq.col.clases.database.repositorios.interfase.MetricaEDDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.MetricaEDServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("metricaEDService")
@Transactional
public class MetricaEDService implements  MetricaEDServiceInterfase {

	@Autowired
	private MetricaEDDaoInterfase metricaEDDao;

	@Override
	public JMResultadoOperacion ejecutarMetricaED(String numReporte, String involucrado, int oaAuto, int dua,
			int oaMoto, int oAEP, String claveAjustador, int edua, String folio, boolean enviado) {
		return this.metricaEDDao.ejecutarMetricaED(numReporte, involucrado, oaAuto, dua, oaMoto, oAEP, claveAjustador, edua, folio, enviado);
	}

	@Override
	public List<MetricaED> listaDeMetricasED(String edo, String base, String claveAjustador, Date fechaInicio,
			Date fechaFin, String reporte, String nombreFormato) {
		return this.metricaEDDao.listaDeMetricasED(edo, base, claveAjustador, fechaInicio, fechaFin, reporte, nombreFormato);
	}

	@Override
	public List<EntidadObjeto> listaDeMetricaParaGrafica(Date fechaInicial, Date fechaFinal, Integer limite, String edo,
			String base, String claveAjustador, String nombreFormato, String reporte) {
		return this.metricaEDDao.listaDeMetricaParaGrafica(fechaInicial, fechaFinal, limite, edo, base, claveAjustador, nombreFormato, reporte);
	}

	@Override
	public List<EntidadObjetoQuinto> obtenerContadorTotal(Date fechaInicial, Date fechaFinal, String edo, String base,
			String nombreFormato, String claveAjustador, String reporte) {
		return this.metricaEDDao.obtenerContadorTotal(fechaInicial, fechaFinal, edo, base, nombreFormato, claveAjustador, reporte);
	}
	
	
}
