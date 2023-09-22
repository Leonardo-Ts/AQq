 package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.aaq.col.clases.database.repositorios.impl.ReporteSolicitadoDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteSolicitadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("reporteSolicitadoService")
@Transactional
public class ReporteSolicitadoService implements ReporteSolicitadoServiceInterfase {
	
	@Autowired
	@Qualifier("reporteSolicitadoDao")
	ReporteSolicitadoDao reporteSolicitadoDao;

	@Override
	public ReporteSolicitado objetoReporteSolicitado(final String id) {
		return this.reporteSolicitadoDao.objetoReporteSolicitado(id);
	}

	@Override
	public List<ReporteSolicitado> listaDeReporteSolicitado(final String clavePrestador, final String tipoDeServicio,
			final String numeroReporte, final Date fechaInicial, final Date fechaFinal) {
		return this.reporteSolicitadoDao.listaDeReporteSolicitado(clavePrestador, tipoDeServicio, numeroReporte,
				fechaInicial, fechaFinal);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final ReporteSolicitado t) {
		return this.reporteSolicitadoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final ReporteSolicitado t) {
		return this.reporteSolicitadoDao.guardarObjeto(t);
	}
}