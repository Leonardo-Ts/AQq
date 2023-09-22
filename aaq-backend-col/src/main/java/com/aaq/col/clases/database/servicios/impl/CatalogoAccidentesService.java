package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoAccidentesDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAccidentesServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoAccidentesService")
@Transactional
public class CatalogoAccidentesService implements CatalogoAccidentesServiceInterfase {

	@Autowired
	private CatalogoAccidentesDaoInterfase catAccidentesDao;
	
	@Override
	public CatalogoAccidentes objetoCatalogoAccidentesClave(String clave) {
		return catAccidentesDao.objetoCatalogoAccidentes(clave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoAccidentes t) {
		return catAccidentesDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoAccidentes t) {
		return catAccidentesDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoAccidentes> listaDeCatalogoAccidentes(String clave, String descripcion, String codigo) {
		return catAccidentesDao.listaDeCatalogoAccidentes(clave, descripcion, codigo);
	}

}
