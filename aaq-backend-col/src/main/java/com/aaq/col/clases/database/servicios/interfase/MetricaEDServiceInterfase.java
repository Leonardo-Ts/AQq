package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.MetricaED;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface MetricaEDServiceInterfase extends JMServicioGenericoInterfase<MetricaED>{
	public abstract JMResultadoOperacion ejecutarMetricaED(String numReporte, String involucrado, int oaAuto, int dua, int oaMoto,
			int oAEP, String claveAjustador, int edua, String folio, boolean enviado);
	public abstract List<MetricaED> listaDeMetricasED(String edo, String base, String claveAjustador, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato);
	public abstract List<EntidadObjeto> listaDeMetricaParaGrafica(Date fechaInicial, Date fechaFinal, Integer limite, String edo, String  base,
			String claveAjustador, String nombreFormato, String reporte);
	public abstract List<EntidadObjetoQuinto> obtenerContadorTotal(Date fechaInicial, Date fechaFinal, String edo, String  base,
			 String nombreFormato, String claveAjustador, String reporte);
}
