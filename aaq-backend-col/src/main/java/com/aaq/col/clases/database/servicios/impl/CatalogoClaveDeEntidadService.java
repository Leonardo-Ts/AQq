package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoClaveDeEntidad;
import com.aaq.col.clases.database.repositorios.impl.CatalogoClaveDeEntidadDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoClaveDeEntidadServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoClaveDeEntidadService")
@Transactional
public class CatalogoClaveDeEntidadService implements CatalogoClaveDeEntidadServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoClaveDeEntidadDao")
	CatalogoClaveDeEntidadDao catalogoClaveDeEntidadDao;

	@Override
	public CatalogoClaveDeEntidad objetoCatalogoClaveDeEntidad(final String id) {
		return this.catalogoClaveDeEntidadDao.objetoCatalogoClaveDeEntidad(id);
	}

	@Override
	public List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad() {
		return this.catalogoClaveDeEntidadDao.listaDeCatalogoClaveDeEntidad();
	}

	@Override
	public List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad(final String llave, final boolean soloConLlave) {
		return this.catalogoClaveDeEntidadDao.listaDeCatalogoClaveDeEntidad(llave, soloConLlave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoClaveDeEntidad t) {
		return this.catalogoClaveDeEntidadDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoClaveDeEntidad t) {
		return this.catalogoClaveDeEntidadDao.guardarObjeto(t);
	}
}