 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteSiseDaoInterfase extends JMRepositorioGenericoInterfase<ReporteSise> {

	public abstract ReporteSise objetoReporteSise(final String numeroReporte);
	public abstract List<ReporteSise> listaDeReporteSise(final Estado estado, final Terminal terminal,
			CatalogoCodigoDeCausa codigoCausa, final Date fechaInicio, final Date fechaFinal, final String reporte,
			final String siniestro, Boolean coordenadasValidasArribo, Boolean coordenadasValidasTermino, Integer limite);
	public abstract JMResultadoOperacion ejecutarFuncionReporteSiseActualizarFechaReporteLecturaPorWs(Integer id);
	public abstract JMResultadoOperacion ejecutarFuncionReporteSiseActualizar(ReporteSise reporteSise);

}