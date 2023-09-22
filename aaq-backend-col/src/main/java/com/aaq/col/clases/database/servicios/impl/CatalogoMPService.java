package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoMP;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoMPDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMPServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoMPService")
@Transactional
public class CatalogoMPService implements CatalogoMPServiceInterfase{

	@Autowired
	CatalogoMPDaoInterfase catMpDao;
	
	@Override
	public CatalogoMP objetoCatalogoMP(String id) {
		return this.catMpDao.objetoCatalogoMP(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoMP t) {
		return this.catMpDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoMP t) {
		return this.catMpDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoMP> listaDeCatalogoMP(String clave, String descripcion) {
		return this.catMpDao.listaDeCatalogoMP(clave, descripcion);
	}

}
