package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.repositorios.impl.GeocercaDao;
import com.aaq.col.clases.database.servicios.interfase.GeocercaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("geocercaService")
@Transactional
public class GeocercaService implements GeocercaServiceInterfase {
	
	@Autowired
	@Qualifier("geocercaDao")
	GeocercaDao geocercaDao;

	@Override
	public Geocerca objetoGeocerca(final String id) {
		return this.geocercaDao.objetoGeocerca(id);
	}

	@Override
	public List<Geocerca> listaDeGeocerca(final Estado estado) {
		return this.geocercaDao.listaDeGeocerca(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Geocerca t) {
		return this.geocercaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Geocerca t) {
		return this.geocercaDao.guardarObjeto(t);
	}
}