package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.CatalogoOficinaDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoOficinaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoOficinaService")
@Transactional
public class CatalogoOficinaService implements CatalogoOficinaServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoOficinaDao")
	CatalogoOficinaDao catalogoOficinaDao;

	@Override
	public CatalogoOficina objetoCatalogoOficina(final String id) {
		return this.catalogoOficinaDao.objetoCatalogoOficina(id);
	}

	@Override
	public CatalogoOficina objetoCatalogoOficinaParaClave(final String clave) {
		return this.catalogoOficinaDao.objetoCatalogoOficinaParaClave(clave);
	}

	@Override
	public List<CatalogoOficina> listaDeCatalogoOficina(final Estado estado) {
		return this.catalogoOficinaDao.listaDeCatalogoOficina(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoOficina t) {
		return this.catalogoOficinaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoOficina t) {
		return this.catalogoOficinaDao.guardarObjeto(t);
	}
}