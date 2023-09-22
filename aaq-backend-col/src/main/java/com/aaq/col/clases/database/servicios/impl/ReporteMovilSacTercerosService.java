package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.repositorios.impl.ReporteMovilSacTercerosDao;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTercerosServiceInterfase;
import com.aaq.col.clases.sac.model.DatosGestionTerceroSac;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("reporteMovilSacTercerosService")
@Transactional
public class ReporteMovilSacTercerosService implements ReporteMovilSacTercerosServiceInterfase {
	
	@Autowired
	@Qualifier("reporteMovilSacTercerosDao")
	ReporteMovilSacTercerosDao reporteMovilSacTercerosDao;

	@Override
	public ReporteMovilSacTerceros objetoReporteMovilSacTerceros(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacTercerosDao.objetoReporteMovilSacTerceros(numeroReporte,numeroAjustador);
	}
	
	@Override
	public List<ReporteMovilSacTerceros> listaDeReporteMovilSacTerceros(String numeroReporte, String numeroAjustador) {
		return this.reporteMovilSacTercerosDao.listaDeReporteMovilSacTerceros(numeroReporte, numeroAjustador);
	}
	
	@Override
	public JMResultadoOperacion guardarTerceros(final String numeroReporte, final String claveProveedor, final String poliza, final DatosGestionTerceroSac dgts){
		return this.reporteMovilSacTercerosDao.guardarTerceros(numeroReporte, claveProveedor, poliza, dgts);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(ReporteMovilSacTerceros rms) {
		return this.reporteMovilSacTercerosDao.guardarObjeto(rms);
	}
	
}