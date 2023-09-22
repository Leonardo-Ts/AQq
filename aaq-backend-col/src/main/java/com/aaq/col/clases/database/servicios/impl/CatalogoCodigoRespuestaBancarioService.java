package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.aaq.col.clases.database.repositorios.impl.CatalogoCodigoRespuestaBancarioDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoRespuestaBancarioServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoCodigoRespuestaBancarioService")
@Transactional
public class CatalogoCodigoRespuestaBancarioService implements CatalogoCodigoRespuestaBancarioServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoCodigoRespuestaBancarioDao")
	CatalogoCodigoRespuestaBancarioDao catalogoCodigoRespuestaBancarioDao;

	@Override
	public CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancario(final String id) {
		return this.catalogoCodigoRespuestaBancarioDao.objetoCatalogoCodigoRespuestaBancario(id);
	}

	@Override
	public CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancarioParaCodigo(final String codigoiso) {
		return this.catalogoCodigoRespuestaBancarioDao.objetoCatalogoCodigoRespuestaBancarioParaCodigo(codigoiso);
	}

	@Override
	public List<CatalogoCodigoRespuestaBancario> listaDeCatalogoCodigoRespuestaBancario() {
		return this.catalogoCodigoRespuestaBancarioDao.listaDeCatalogoCodigoRespuestaBancario();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoCodigoRespuestaBancario t) {
		return this.catalogoCodigoRespuestaBancarioDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoCodigoRespuestaBancario t) {
		return this.catalogoCodigoRespuestaBancarioDao.guardarObjeto(t);
	}
}