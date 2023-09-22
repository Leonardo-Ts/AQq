package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.repositorios.impl.CatalogoAseguradoraDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAseguradoraServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoAseguradoraService")
@Transactional
public class CatalogoAseguradoraService implements CatalogoAseguradoraServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoAseguradoraDao")
	CatalogoAseguradoraDao catalogoAseguradoraDao;

	@Override
	public CatalogoAseguradora objetoCatalogoAseguradora(final String id) {
		return this.catalogoAseguradoraDao.objetoCatalogoAseguradora(id);
	}


	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoAseguradora t) {
		return this.catalogoAseguradoraDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoAseguradora t) {
		return this.catalogoAseguradoraDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoAseguradora> listaCatalogoAseguradora(String clave, String descripcion) {
		return this.catalogoAseguradoraDao.listaCatalogoAseguradora(clave, descripcion);
	}


	@Override
	public CatalogoAseguradora objetoCatalogoAseguradoraClave(String clave) {
		return this.catalogoAseguradoraDao.objetoCatalogoAseguradoraClave(clave);
	}
}