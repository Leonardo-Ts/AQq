package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoCredencialesDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCredencialesServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoCredencialesService")
@Transactional
public class CatalogoCredencialesService implements CatalogoCredencialesServiceInterfase {

	@Autowired
	CatalogoCredencialesDaoInterfase catCredencialesDao;
	
	@Override
	public CatalogoCredenciales objetoCatalogoCredenciales(final String id) {
		return this.catCredencialesDao.objetoCatalogoCredenciales(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoCredenciales t) {
		return this.catCredencialesDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoCredenciales t) {
		return this.catCredencialesDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoCredenciales> listaDeCatalogoCredenciales(final String nombre, final String url, final String usuario, final String pwd) {
		return this.catCredencialesDao.listaDeCatalogoCredenciales(nombre, url, usuario, pwd);
	}
}
