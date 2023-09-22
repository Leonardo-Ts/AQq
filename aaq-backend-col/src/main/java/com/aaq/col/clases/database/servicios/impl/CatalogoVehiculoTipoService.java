package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoTipo;
import com.aaq.col.clases.database.repositorios.impl.CatalogoVehiculoTipoDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehiculoTipoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoVehiculoTipoService")
@Transactional
public class CatalogoVehiculoTipoService implements CatalogoVehiculoTipoServiceInterfase {

	@Autowired
	@Qualifier("catalogoVehiculoTipoDao")
	CatalogoVehiculoTipoDao catalogoVehiculoTipoDao;

	@Override
	public List<CatalogoVehiculoTipo> listaDeCatalogoVehiculoTipo() {
		return this.catalogoVehiculoTipoDao.listaDeCatalogoVehiculoTipo();
	}

	@Override
	public CatalogoVehiculoTipo objetoCatalogoVehiculoTipo(final String id) {
		return this.catalogoVehiculoTipoDao.objetoCatalogoVehiculoTipo(id);
	}

	@Override
	public CatalogoVehiculoTipo objetoCatalogoVehiculoParaClave(final String clave) {
		return this.catalogoVehiculoTipoDao.objetoCatalogoVehiculoParaClave(clave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoVehiculoTipo t) {
		return this.catalogoVehiculoTipoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoVehiculoTipo t) {
		return this.catalogoVehiculoTipoDao.guardarObjeto(t);
	}
}