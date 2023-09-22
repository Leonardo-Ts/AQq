package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.repositorios.impl.CatalogoMarcaDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoMarcaService")
@Transactional
public class CatalogoMarcaService implements CatalogoMarcaServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoMarcaDao")
	CatalogoMarcaDao catalogoMarcaDao;

	@Override
	public CatalogoMarca objetoCatalogoMarca(final String id) {
		return this.catalogoMarcaDao.objetoCatalogoMarca(id);
	}

	@Override
	public List<CatalogoMarca> listaDeCatalogoMarca() {
		return this.catalogoMarcaDao.listaDeCatalogoMarca();
	}

	@Override
	public CatalogoMarca objetoCatalogoMarcaParaClave(final String clave) {
		return this.catalogoMarcaDao.objetoCatalogoMarcaParaClave(clave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoMarca t) {
		return this.catalogoMarcaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoMarca t) {
		return this.catalogoMarcaDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoMarca> listaDeCatalogoMarca(String clave, String nombre) {
		return this.catalogoMarcaDao.listaDeCatalogoMarca(clave, nombre);
	}
}