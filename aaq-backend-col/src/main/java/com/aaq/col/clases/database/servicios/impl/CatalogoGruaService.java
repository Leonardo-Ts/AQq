package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoGruaDaoInterface;
import com.aaq.col.clases.database.servicios.interfase.CatalogoGruaServiceInterface;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoGruaService")
@Transactional
public class CatalogoGruaService implements CatalogoGruaServiceInterface{

	@Autowired
	private CatalogoGruaDaoInterface catGruaDao;
	
	@Override
	public CatalogoGrua objetoCatalogoGrua(String id) {
		return this.catGruaDao.objetoCatalogoGrua(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoGrua t) {
		return this.catGruaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoGrua t) {
		return this.catGruaDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoGrua> listaDeCatalogoGrua(String clave, String descripcion, String codigo) {
		return this.catGruaDao.listaDeCatalogoGrua(clave, descripcion, codigo);
	}
	
}
