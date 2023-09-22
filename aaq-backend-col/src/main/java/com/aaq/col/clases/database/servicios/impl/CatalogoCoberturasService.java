package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.aaq.col.clases.database.repositorios.impl.CatalogoCoberturasDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCoberturasServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoCoberturasService")
@Transactional
public class CatalogoCoberturasService implements CatalogoCoberturasServiceInterfase {
	@Autowired
	@Qualifier("catalogoCoberturasDao")
	CatalogoCoberturasDao catalogoCoberturasDao;

	@Override
	public CatalogoCoberturas objetoCatalogoCoberturasClave(String clave)  {
		return this.catalogoCoberturasDao.objetoCatalogoCoberturasClave(clave);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoCoberturas t) {
		return this.catalogoCoberturasDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoCoberturas t) {
		return this.catalogoCoberturasDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoCoberturas> listaDeCatalogoCoberturas(String clave, String descripcion) {
		return this.catalogoCoberturasDao.listaDeCatalogoCoberturas(clave, descripcion);
	}
}