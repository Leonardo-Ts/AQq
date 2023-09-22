package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.aaq.col.clases.database.repositorios.impl.FormatoCatalogosDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoCatalogosServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoCatalogosService")
@Transactional
public class FormatoCatalogosService implements FormatoCatalogosServiceInterfase {
	
	@Autowired
	@Qualifier("formatoCatalogosDao")
	FormatoCatalogosDao formatoCatalogosDao;

	@Override
	public FormatoCatalogos objetoFormatoCatalogos(String id) {
		return this.formatoCatalogosDao.objetoFormatoCatalogos(id);
	}

	@Override
	public String ejecutarFuncionInsertarCatalogos(String nombre, String valores) {
		return this.formatoCatalogosDao.ejecutarFuncionInsertarCatalogos(nombre, valores);
	}

	@Override
	public List<FormatoCatalogos> listaDeFormatoCatalogos() {
		return this.formatoCatalogosDao.listaDeFormatoCatalogos();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoCatalogos t) {
		return this.formatoCatalogosDao.guardarObjeto(t);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(FormatoCatalogos t) {
		return this.formatoCatalogosDao.eliminarObjeto(t);
	}

	@Override
	public List<FormatoCatalogos> listaDeFormatoCatalogos(String nombre) {
		return this.formatoCatalogosDao.listaDeFormatoCatalogos(nombre);
	}

}