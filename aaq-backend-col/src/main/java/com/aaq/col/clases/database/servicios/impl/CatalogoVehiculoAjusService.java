package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoAjus;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoVehiculoAjusDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehiculoAjusServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoVehiculoAjusService")
@Transactional
public class CatalogoVehiculoAjusService implements CatalogoVehiculoAjusServiceInterfase {

	@Autowired
	@Qualifier("catalogoVehiculoAjusDao")
	private CatalogoVehiculoAjusDaoInterfase catalogoVehiculoAjusDao;
	
	@Override
	public CatalogoVehiculoAjus objetoCatalogoVehiculoAjus(String id) {
		return catalogoVehiculoAjusDao.objetoCatalogoVehiculoAjus(id);
	}

	@Override
	public List<CatalogoVehiculoAjus> listaDeCatalogoVehiculoAjus() {
		return catalogoVehiculoAjusDao.listaDeCatalogoVehiculoAjus();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoVehiculoAjus t) {
		return catalogoVehiculoAjusDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoVehiculoAjus t) {
		return catalogoVehiculoAjusDao.guardarObjeto(t);
	}

}
