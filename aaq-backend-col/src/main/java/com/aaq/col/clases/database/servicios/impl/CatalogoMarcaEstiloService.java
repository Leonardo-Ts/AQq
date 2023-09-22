 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.entidades.CatalogoMarcaEstilo;
import com.aaq.col.clases.database.repositorios.impl.CatalogoMarcaEstiloDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaEstiloServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoMarcaEstiloService")
@Transactional
public class CatalogoMarcaEstiloService implements CatalogoMarcaEstiloServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoMarcaEstiloDao")
	CatalogoMarcaEstiloDao catalogoMarcaEstiloDao;

	@Override
	public CatalogoMarcaEstilo objetoCatalogoMarcaEstilo(final String id) {
		return this.catalogoMarcaEstiloDao.objetoCatalogoMarcaEstilo(id);
	}

	@Override
	public List<CatalogoMarcaEstilo> listaDeCatalogoMarcaEstilo(final CatalogoMarca catalogoMarca) {
		return this.catalogoMarcaEstiloDao.listaDeCatalogoMarcaEstilo(catalogoMarca);
	}

	@Override
	public CatalogoMarcaEstilo objetoCatalogoMarcaEstiloParaClave(final CatalogoMarca catalogoMarca, final String clave) {
		return this.catalogoMarcaEstiloDao.objetoCatalogoMarcaEstiloParaClave(catalogoMarca, clave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoMarcaEstilo t) {
		return this.catalogoMarcaEstiloDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoMarcaEstilo t) {
		return this.catalogoMarcaEstiloDao.guardarObjeto(t);
	}
}