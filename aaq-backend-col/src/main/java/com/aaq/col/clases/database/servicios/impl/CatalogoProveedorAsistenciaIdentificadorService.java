package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistenciaIdentificador;
import com.aaq.col.clases.database.repositorios.impl.CatalogoProveedorAsistenciaIdentificadorDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoProveedorAsistenciaIdentificadorServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoProveedorAsistenciaIdentificadorService")
@Transactional
public class CatalogoProveedorAsistenciaIdentificadorService implements
		CatalogoProveedorAsistenciaIdentificadorServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoProveedorAsistenciaIdentificadorDao")
	CatalogoProveedorAsistenciaIdentificadorDao catalogoProveedorAsistenciaIdentificadorDao;

	@Override
	public CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificador(final String id) {
		return this.catalogoProveedorAsistenciaIdentificadorDao.objetoCatalogoProveedorAsistenciaIdentificador(id);
	}

	@Override
	public CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificadorParaNumero(
			final Integer numero) {
		return this.catalogoProveedorAsistenciaIdentificadorDao
				.objetoCatalogoProveedorAsistenciaIdentificadorParaNumero(numero);
	}

	@Override
	public List<CatalogoProveedorAsistenciaIdentificador> listaDeCatalogoProveedorAsistenciaIdentificador(
			final CatalogoProveedorAsistencia prov) {
		return this.catalogoProveedorAsistenciaIdentificadorDao.listaDeCatalogoProveedorAsistenciaIdentificador(prov);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoProveedorAsistenciaIdentificador t) {
		return this.catalogoProveedorAsistenciaIdentificadorDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoProveedorAsistenciaIdentificador t) {
		return this.catalogoProveedorAsistenciaIdentificadorDao.guardarObjeto(t);
	}
}