package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteMovilSacDaoInterfase extends JMRepositorioGenericoInterfase<ReporteMovilSac> {


	public abstract ReporteMovilSac objetoReporteMovilSac(final String numeroReporte, final String numeroAjustador);
	public abstract JMResultadoOperacion ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs(Integer id);
	public abstract JMResultadoOperacion ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos(final Integer id, final String data);
	public abstract List<ReporteMovilSac> listaDeReportesModi(final String reporte);
	public abstract JMResultadoOperacion actualizarReporteSegundaAtencion(final String reporte, final String colonia, final String calles,
			final String refObs);

}