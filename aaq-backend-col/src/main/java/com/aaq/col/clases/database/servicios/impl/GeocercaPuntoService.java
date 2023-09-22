package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.GeocercaPunto;
import com.aaq.col.clases.database.repositorios.impl.GeocercaPuntoDao;
import com.aaq.col.clases.database.servicios.interfase.GeocercaPuntoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("geocercaPuntoService")
@Transactional
public class GeocercaPuntoService implements GeocercaPuntoServiceInterfase {
	
	@Autowired
	@Qualifier("geocercaPuntoDao")
	GeocercaPuntoDao geocercaPuntoDao;

	@Override
	public GeocercaPunto objetoGeocercaPunto(final String id) {
		return this.geocercaPuntoDao.objetoGeocercaPunto(id);
	}

	@Override
	public List<GeocercaPunto> listaDeGeocercaPunto(final Geocerca geocerca) {
		return this.geocercaPuntoDao.listaDeGeocercaPunto(geocerca);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final GeocercaPunto t) {
		return this.geocercaPuntoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final GeocercaPunto t) {
		return this.geocercaPuntoDao.guardarObjeto(t);
	}
}