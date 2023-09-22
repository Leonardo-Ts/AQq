package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.NotasReporte;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.interfase.NotasReporteDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.NotasReporteServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("notasReporteService")
@Transactional
public class NotasReporteService implements NotasReporteServiceInterfase {

	@Autowired
	NotasReporteDaoInterfase notasReporteDao;
	
	
	@Override
	public NotasReporte objetoNotasReporte(String id) {
		return this.notasReporteDao.objetoNotasReporte(id);
	}

	@Override
	public List<NotasReporte> listaDeNotasReporte(Date fechaInicio, Date fechaFin, String reporte, Terminal terminal,
			Estado estado, Base base) {
		return this.notasReporteDao.listaDeNotasReportes(fechaInicio, fechaFin, reporte, terminal, estado, base);
	}
	
	@Override
	public JMResultadoOperacion eliminarObjeto(NotasReporte t)  {
		return notasReporteDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(NotasReporte t)  {
		return notasReporteDao.guardarObjeto(t);
	}

	@Override
	public List<NotasReporte> listarNotas(Terminal terminal, String reporte) {
		return this.notasReporteDao.listarNotas(terminal, reporte);
	}
	

}
