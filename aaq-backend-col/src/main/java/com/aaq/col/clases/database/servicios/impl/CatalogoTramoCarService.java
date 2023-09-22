package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoTramoCarDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoTramoCarServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoTramoCarService")
@Transactional
public class CatalogoTramoCarService implements CatalogoTramoCarServiceInterfase{

	@Autowired
	CatalogoTramoCarDaoInterfase catalogoTramoCarDao;
	
	@Override
	public CatalogoTramoCar objetoCatalogoTramoCar(final String id) {
		return this.catalogoTramoCarDao.objetoCatalogoTramoCar(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoTramoCar t) {
		return this.catalogoTramoCarDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoTramoCar t) {
		return this.catalogoTramoCarDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoTramoCar> listaDeCatalogoTramoCar(String clave, String descripcion) {
		return this.catalogoTramoCarDao.listaDeCatalogoTramoCar(clave, descripcion);
	}
}
