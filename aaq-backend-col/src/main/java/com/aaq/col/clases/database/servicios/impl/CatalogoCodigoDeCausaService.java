 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.repositorios.impl.CatalogoCodigoDeCausaDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoDeCausaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoCodigoDeCausaService")
@Transactional
public class CatalogoCodigoDeCausaService implements CatalogoCodigoDeCausaServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoCodigoDeCausaDao")
	CatalogoCodigoDeCausaDao catalogoCodigoDeCausaDao;

	@Override
	public CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausa(final String id) {
		return this.catalogoCodigoDeCausaDao.objetoCatalogoCodigoDeCausa(id);
	}

	@Override
	public CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausaParaClave(final String clave) {
		return this.catalogoCodigoDeCausaDao.objetoCatalogoCodigoDeCausaParaClave(clave);
	}

	@Override
	public List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa() {
		return this.catalogoCodigoDeCausaDao.listaDeCatalogoCodigoDeCausa();
	}

	@Override
	public List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa(final Integer idPermitido) {
		return this.catalogoCodigoDeCausaDao.listaDeCatalogoCodigoDeCausa(idPermitido);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CatalogoCodigoDeCausa t) {
		return this.catalogoCodigoDeCausaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CatalogoCodigoDeCausa t) {
		return this.catalogoCodigoDeCausaDao.guardarObjeto(t);
	}
}