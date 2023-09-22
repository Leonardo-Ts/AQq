 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoUso;
import com.aaq.col.clases.database.repositorios.impl.CatalogoVehiculoUsoDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehiculoUsoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoVehiculoUsoService")
@Transactional
public class CatalogoVehiculoUsoService implements CatalogoVehiculoUsoServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoVehiculoUsoDao")
	CatalogoVehiculoUsoDao catalogoVehiculoUsoDao;

	@Override
	public List<CatalogoVehiculoUso> listaDeCatalogoVehiculoUso() {
		return this.catalogoVehiculoUsoDao.listaDeCatalogoVehiculoUso();
	}

	@Override
	public CatalogoVehiculoUso objetoCatalogoVehiculoUso(final String id) {
		return this.catalogoVehiculoUsoDao.objetoCatalogoVehiculoUso(id);
	}

	@Override
	public CatalogoVehiculoUso objetoCatalogoVehiculoUsoParaClave(final String clave) {
		return this.catalogoVehiculoUsoDao.objetoCatalogoVehiculoUsoParaClave(clave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoVehiculoUso t) {
		return this.catalogoVehiculoUsoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoVehiculoUso t) {
		return this.catalogoVehiculoUsoDao.guardarObjeto(t);
	}
}