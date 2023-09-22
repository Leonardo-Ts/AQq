package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.ControlFotografias;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.interfase.ControlFotografiasDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.ControlFotografiasServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("controlFotografiasService")
@Transactional
public class ControlFotografiasService implements ControlFotografiasServiceInterfase {

	@Autowired
	private ControlFotografiasDaoInterfase controlFotografiasDao;

	@Override
	public ControlFotografias objetoControlFotos(String id) {
		return this.controlFotografiasDao.objetoControlFoto(id);
	}

	@Override
	public List<ControlFotografias> listarControlFotografias(Date fechaInicial, Date fechaFinal, String tipoFoto, String numReporte, Estado edo, Base base) {
		return this.controlFotografiasDao.listarControlFotografias(fechaInicial, fechaFinal, tipoFoto, numReporte, edo, base);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(ControlFotografias t) {
		return this.controlFotografiasDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(ControlFotografias t) {
		return this.controlFotografiasDao.guardarObjeto(t);
	}

	@Override
	public List<EntidadObjeto> listaParaGraficaFotos(Date fechaInicial, Date fechaFinal, String estado, String base,
			String reporte, String claveDocumental) {
		return this.controlFotografiasDao.listaParaGraficaFotos(fechaInicial, fechaFinal, estado, base, reporte, claveDocumental);
	}
	
	
	
}
