package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoMarcaTerc;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoMarcaTercDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaTercServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoMarcaTercService")
@Transactional
public class CatalogoMarcaTercService implements CatalogoMarcaTercServiceInterfase  {

	@Autowired
	CatalogoMarcaTercDaoInterfase catMarcaTercDao;

	@Override
	public CatalogoMarcaTerc objetoCatalogoMarcaTerc(String id) {
		return this.catMarcaTercDao.objetoCatalogoMarcaTerc(id);
	}

	@Override
	public List<CatalogoMarcaTerc> listaDeCatalogoMarcaTerc(String clave, String descripcion) {
		return this.catMarcaTercDao.listaDeCatalogoMarcaTerc(clave, descripcion);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoMarcaTerc t) {
		return this.catMarcaTercDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoMarcaTerc t) {
		return this.catMarcaTercDao.guardarObjeto(t);
	}
	
	
}
