package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoFaq;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoFaqDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoFaqServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoFaqService")
@Transactional
public class CatalogoFaqService implements CatalogoFaqServiceInterfase {

	@Autowired
	private CatalogoFaqDaoInterfase catFaqDao;

	@Override
	public CatalogoFaq objetoCatalogoFaq(String id) {
		return this.catFaqDao.objetoCatalogoFaq(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoFaq t) {
		return this.catFaqDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoFaq t) {
		return this.catFaqDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoFaq> listaDeCatalogoFaq(String clave, String descripcion) {
		return this.catFaqDao.listaDeCatalogoFaq(clave, descripcion);
	}
	

}
