package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoVehTercDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehTercServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoVehTercService")
@Transactional
public class CatalogoVehTercService implements  CatalogoVehTercServiceInterfase{

	@Autowired
	private CatalogoVehTercDaoInterfase catalogoVehTercService;

	@Override
	public CatalogoVehTerc objetoCatalogoVehTerc(String id) {
		return this.catalogoVehTercService.objetoCatalogoVehTerc(id);
	}

	@Override
	public List<CatalogoVehTerc> listaDeCatalogoVehTerc(String clave, String descripcion) {
		return catalogoVehTercService.listaDeCatalogoVehTerc(clave, descripcion);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoVehTerc t) {
		return this.catalogoVehTercService.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoVehTerc t) {
		return catalogoVehTercService.guardarObjeto(t);
	}
	
	
}
