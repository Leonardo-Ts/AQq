package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoDependencias;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoDependenciasDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoDependenciasServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoDependenciasService")
@Transactional
public class CatalogoDependenciasService implements CatalogoDependenciasServiceInterfase {

	@Autowired
	private CatalogoDependenciasDaoInterfase catDependenciasDao;
	
	@Override
	public CatalogoDependencias objetoCatalogoDependencias(String id) {
		return this.catDependenciasDao.objetoCatalogoDependencias(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoDependencias t) {
		return this.catDependenciasDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoDependencias t) {
		return this.catDependenciasDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoDependencias> listaDeCatalogoDependencias(String clave, String descripcion) {
		return this.catDependenciasDao.listaDeCatalogoDependencias(clave, descripcion);
	}

}
