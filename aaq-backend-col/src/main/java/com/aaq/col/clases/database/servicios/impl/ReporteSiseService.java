 package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.ReporteSiseDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteSiseServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("reporteSiseService")
@Transactional
public class ReporteSiseService implements ReporteSiseServiceInterfase {
	
	@Autowired
	@Qualifier("reporteSiseDao")
	ReporteSiseDao reporteSiseDao;

	@Override
	public ReporteSise objetoReporteSise(final String numeroReporte) {
		return this.reporteSiseDao.objetoReporteSise(numeroReporte);
	}

	@Override
	public List<ReporteSise> listaDeReporteSise(final Estado estado, final Terminal terminal,
			final CatalogoCodigoDeCausa codigoCausa, final Date fechaInicio, final Date fechaFinal,
			final String reporte, final String siniestro, final Boolean coordenadasValidasArribo,
			final Boolean coordenadasValidasTermino, final Integer limite) {
		return this.reporteSiseDao.listaDeReporteSise(estado, terminal, codigoCausa, fechaInicio, fechaFinal, reporte,
				siniestro, coordenadasValidasArribo, coordenadasValidasTermino, limite);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSiseActualizarFechaReporteLecturaPorWs(final Integer id) {
		return this.reporteSiseDao.ejecutarFuncionReporteSiseActualizarFechaReporteLecturaPorWs(id);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSiseActualizar(final ReporteSise reporte) {
		return this.reporteSiseDao.ejecutarFuncionReporteSiseActualizar(reporte);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final ReporteSise t) {
		return this.reporteSiseDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final ReporteSise t) {
		return this.reporteSiseDao.guardarObjeto(t);
	}
}