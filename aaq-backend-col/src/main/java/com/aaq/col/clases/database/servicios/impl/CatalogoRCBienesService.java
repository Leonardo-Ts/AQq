package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoRCBienes;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoRCBienesDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRCBienesServiceInterface;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoRCBienesService")
@Transactional
public class CatalogoRCBienesService implements CatalogoRCBienesServiceInterface{

	@Autowired
	private CatalogoRCBienesDaoInterfase catRCBienesService;

	@Override
	public CatalogoRCBienes objetoCatalogoRCBienesClave(String id) {
		return this.catRCBienesService.objetoCatalogoRCBienes(id);
	}

	@Override
	public List<CatalogoRCBienes> listaCatalogoRCBienes(String clave, String descripcion) {
		return this.catRCBienesService.listaCatalogoRCBienes(clave, descripcion);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoRCBienes t) {
		return this.catRCBienesService.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoRCBienes t) {
		return this.catRCBienesService.guardarObjeto(t);
	}
	
	
}
