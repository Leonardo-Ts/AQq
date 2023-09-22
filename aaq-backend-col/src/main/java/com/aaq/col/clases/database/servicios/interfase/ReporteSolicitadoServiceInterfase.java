package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteSolicitadoServiceInterfase extends JMServicioGenericoInterfase<ReporteSolicitado> {

	public abstract ReporteSolicitado objetoReporteSolicitado(final String id) ;
	public abstract List<ReporteSolicitado> listaDeReporteSolicitado(final String clavePrestador,
			String tipoDeServicio, String numeroReporte, Date fechaInicial, Date fechaFinal) ;
	public abstract JMResultadoOperacion eliminarObjeto(ReporteSolicitado t) ;
	public abstract JMResultadoOperacion guardarObjeto(ReporteSolicitado t) ;
}