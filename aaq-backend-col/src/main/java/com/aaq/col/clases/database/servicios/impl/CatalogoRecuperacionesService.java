package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
import com.aaq.col.clases.database.repositorios.impl.CatalogoRecuperacionesDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRecuperacionesServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoRecuperacionesService")
@Transactional
public class CatalogoRecuperacionesService implements CatalogoRecuperacionesServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoRecuperacionesDao")
	CatalogoRecuperacionesDao catalogoRecuperacionesDao;

	@Override
	public CatalogoRecuperaciones objetoCatalogoRecuperacionesClave(String clave)  {
		return this.catalogoRecuperacionesDao.objetoCatalogoRecuperacionesClave(clave);
	}

	@Override
	public List<CatalogoRecuperaciones> listaRecuperaciones(String clave, String nombre) {
		return this.catalogoRecuperacionesDao.listaRecuperaciones(clave, nombre);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoRecuperaciones t) {
		return this.catalogoRecuperacionesDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoRecuperaciones t) {
		return this.catalogoRecuperacionesDao.guardarObjeto(t);
	}
}