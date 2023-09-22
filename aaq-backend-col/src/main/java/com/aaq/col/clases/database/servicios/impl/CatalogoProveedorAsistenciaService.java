package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.CatalogoProveedorAsistenciaDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoProveedorAsistenciaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoProveedorAsistenciaService")
@Transactional
public class CatalogoProveedorAsistenciaService implements CatalogoProveedorAsistenciaServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoProveedorAsistenciaDao")
	CatalogoProveedorAsistenciaDao catalogoProveedorAsistenciaDao;

	@Override
	public CatalogoProveedorAsistencia objetoCatalogoProveedorAsistencia(final String id) {
		return this.catalogoProveedorAsistenciaDao.objetoCatalogoProveedorAsistencia(id);
	}

	@Override
	public CatalogoProveedorAsistencia objetoCatalogoProveedorAsistenciaParaUserYPassword(final String username,
			final String passwd) {
		return this.catalogoProveedorAsistenciaDao.objetoCatalogoProveedorAsistenciaParaUserYPassword(username, passwd);
	}

	@Override
	public List<CatalogoProveedorAsistencia> listaDeCatalogoProveedorAsistencia(final Estado estado) {
		return this.catalogoProveedorAsistenciaDao.listaDeCatalogoProveedorAsistencia(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoProveedorAsistencia t) {
		return this.catalogoProveedorAsistenciaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoProveedorAsistencia t) {
		return this.catalogoProveedorAsistenciaDao.guardarObjeto(t);
	}
}