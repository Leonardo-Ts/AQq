package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.aaq.col.clases.database.repositorios.impl.ReporteMovilSacGruasDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacGruasServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("reporteMovilSacGruasService")
@Transactional
public class ReporteMovilSacGruasService implements ReporteMovilSacGruasServiceInterfase {
	
	@Autowired
	@Qualifier("reporteMovilSacGruasDao")
	ReporteMovilSacGruasDao reporteMovilSacGruasDao;

	@Override
	public ReporteMovilSacGruas objetoReporteMovilSacGruas(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacGruasDao.objetoReporteMovilSacGruas(numeroReporte,numeroAjustador);
	}
	
	@Override
	public List<ReporteMovilSacGruas> listaDeReporteMovilSacGruas(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacGruasDao.listaDeReporteMovilSacGruas(numeroReporte, numeroAjustador);
	}
	
	@Override
	public List<ReporteMovilSacGruas> listaDeReporteMovilSacGruasC(String numeroReporte, String numeroAjustador, String tipoAfectado) {
		return this.reporteMovilSacGruasDao.listaDeReporteMovilSacGruasC(numeroReporte, numeroAjustador, tipoAfectado);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(ReporteMovilSacGruas reporteMovilSacGruas) {
		return this.reporteMovilSacGruasDao.guardarObjeto(reporteMovilSacGruas);
	}
	
}