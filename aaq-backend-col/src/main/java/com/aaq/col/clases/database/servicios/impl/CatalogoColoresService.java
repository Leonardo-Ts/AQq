package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoColores;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoColoresDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoColoresServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoColoresService")
@Transactional
public class CatalogoColoresService implements CatalogoColoresServiceInterfase {
	
	@Autowired
	CatalogoColoresDaoInterfase catalogoColoresDao;
	
	@Override
	public CatalogoColores objetoCatalogoColores(final String id) {
		return this.catalogoColoresDao.objetoCatalogoColores(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoColores t) {
		return this.catalogoColoresDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoColores t) {
		return this.catalogoColoresDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoColores> listaDeCatalogoColores(String clave, String nombre) {
		return this.catalogoColoresDao.listaDeCatalogoColores(clave, nombre);
	}

}
