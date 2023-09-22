package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface ReporteSolicitadoDaoInterfase extends JMRepositorioGenericoInterfase<ReporteSolicitado> {

	public abstract ReporteSolicitado objetoReporteSolicitado(final String id);
	public abstract List<ReporteSolicitado> listaDeReporteSolicitado(final String clavePrestador,
			String tipoDeServicio, String numeroReporte, Date fechaInicial, Date fechaFinal);

}