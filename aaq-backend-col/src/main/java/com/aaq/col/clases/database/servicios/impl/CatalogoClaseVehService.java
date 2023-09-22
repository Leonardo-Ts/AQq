package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoClaseVehDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoClaseVehServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@Service("catalogoClaseVehService")
@Transactional
public class CatalogoClaseVehService implements CatalogoClaseVehServiceInterfase{

	@Autowired
	private CatalogoClaseVehDaoInterfase catClaseVehDao;
	
	@Override
	public CatalogoClaseVeh objetoCatalogoClaseVeh(String id) {
		return this.catClaseVehDao.objetoCatalogoClaseVeh(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoClaseVeh t) {
		return this.catClaseVehDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoClaseVeh t) {
		return this.catClaseVehDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoClaseVeh> listaDeCatalogoClaseVeh(String clave, String descripcion) {
		return this.catClaseVehDao.listaDeCatalogoClaseVeh(clave, descripcion);
	}


}
