package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoHospitalesDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoHospitalesServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("catalogoHospitalesService")
@Transactional
public class CatalogoHospitalesService implements CatalogoHospitalesServiceInterfase {

	@Autowired
	CatalogoHospitalesDaoInterfase catHospitalesDao;
	
	@Override
	public CatalogoHospitales objetoCatalogoHospitales(String id) {
		return this.catHospitalesDao.objetoCatalogoHospitales(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(CatalogoHospitales t) {
		return this.catHospitalesDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(CatalogoHospitales t) {
		return this.catHospitalesDao.guardarObjeto(t);
	}

	@Override
	public List<CatalogoHospitales> listaDeCatalogoHospitales(String clave) {
		return this.catHospitalesDao.listaDeCatalogoHospitales(clave);
	}

}
