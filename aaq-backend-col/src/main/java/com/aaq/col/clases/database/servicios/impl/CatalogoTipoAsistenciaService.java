package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoTipoAsistencia;
import com.aaq.col.clases.database.repositorios.impl.CatalogoTipoAsistenciaDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoTipoAsistenciaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoTipoAsistenciaService")
@Transactional
public class CatalogoTipoAsistenciaService implements CatalogoTipoAsistenciaServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoTipoAsistenciaDao")
	CatalogoTipoAsistenciaDao catalogoTipoAsistenciaDao;

	@Override
	public CatalogoTipoAsistencia objetoCatalogoTipoAsistencia(final String id) {
		return this.catalogoTipoAsistenciaDao.objetoCatalogoTipoAsistencia(id);
	}

	@Override
	public List<CatalogoTipoAsistencia> listaDeCatalogoTipoAsistencia() {
		return this.catalogoTipoAsistenciaDao.listaDeCatalogoTipoAsistencia();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoTipoAsistencia t) {
		return this.catalogoTipoAsistenciaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoTipoAsistencia t) {
		return this.catalogoTipoAsistenciaDao.guardarObjeto(t);
	}
}