package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoPartesAutoDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoPartesAutoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoPartesAutoService")
@Transactional
public class CatalogoPartesAutoService implements CatalogoPartesAutoServiceInterfase{

	@Autowired
	private CatalogoPartesAutoDaoInterfase catPartesAutoDao;

	@Override
	public CatalogoPartesAuto objetoCatalogoPartesAuto(String id) {
		return this.catPartesAutoDao.objetoCatalogoPartesAuto(id);
	}

	@Override
	public List<CatalogoPartesAuto> listaDeCatalogoPartesAuto(String tipoParte, String numParte, String nombreParte) {
		return this.catPartesAutoDao.listaDeCatalogoPartesAuto(tipoParte, numParte, nombreParte);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoPartesAuto t) {
		return this.catPartesAutoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoPartesAuto t) {
		return this.catPartesAutoDao.guardarObjeto(t);
	}
	
	
}
