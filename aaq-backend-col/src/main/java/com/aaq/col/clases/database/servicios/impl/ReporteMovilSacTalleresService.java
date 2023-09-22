package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTalleres;
import com.aaq.col.clases.database.repositorios.impl.ReporteMovilSacTalleresDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTalleresServiceInterfase;


@Service("reporteMovilSacTalleresService")
@Transactional
public class ReporteMovilSacTalleresService implements ReporteMovilSacTalleresServiceInterfase {
	
	@Autowired
	@Qualifier("reporteMovilSacTalleresDao")
	ReporteMovilSacTalleresDao reporteMovilSacTalleresDao;

	@Override
	public ReporteMovilSacTalleres objetoReporteMovilSacTalleres(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacTalleresDao.objetoReporteMovilSacTalleres(numeroReporte,numeroAjustador);
	}
	
	@Override
	public List<ReporteMovilSacTalleres> listaDeReporteMovilSacTalleres(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacTalleresDao.listaDeReporteMovilSacTalleres(numeroReporte, numeroAjustador);
	}
	
}