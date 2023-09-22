package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.aaq.col.clases.database.repositorios.impl.ReporteMovilDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("reporteMovilService")
@Transactional
public class ReporteMovilService implements ReporteMovilServiceInterfase {
	
	@Autowired
	@Qualifier("reporteMovilDao")
	ReporteMovilDao reporteMovilDao;

	@Override
	public ReporteMovil objetoReporteMovil(final String id) {
		return this.reporteMovilDao.objetoReporteMovil(id);
	}

	@Override
	public List<ReporteMovil> listaDeReporteMovil(final Date fechaInicio, final Date fechaFin, final boolean soloActivos) {
		return this.reporteMovilDao.listaDeReporteMovil(fechaInicio, fechaFin, soloActivos);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final ReporteMovil t) {
		return this.reporteMovilDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final ReporteMovil t) {
		return this.reporteMovilDao.guardarObjeto(t);
	}
}