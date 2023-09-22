package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoMovil;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoMovilDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMovilServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoMovilService")
@Transactional
public class CatalogoMovilService implements CatalogoMovilServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoMovilDao")
	private CatalogoMovilDaoInterfase catalogoMovilDao;

	@Override
	public CatalogoMovil objetoCatalogoMovil(String id) {
		return catalogoMovilDao.objetoCatalogoMovil(id);
	}

	@Override
	public List<CatalogoMovil> listaDeCatalogoMovil() {
		return catalogoMovilDao.listaDeCatalogoMovil();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoMovil t)  {
		return catalogoMovilDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoMovil t)  {
		return catalogoMovilDao.guardarObjeto(t);
	}

}
