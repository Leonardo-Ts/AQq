package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.aaq.col.clases.database.repositorios.impl.GeocercaByEstadoDao;
import com.aaq.col.clases.database.servicios.interfase.GeocercaByEstadoServiceInterfase;

@Service("geocercaByEstadoService")
@Transactional
public class GeocercaByEstadoService implements GeocercaByEstadoServiceInterfase {
	
	@Autowired
	@Qualifier("geocercaByEstadoDao")
	GeocercaByEstadoDao geocercaByEstadoDao;

	@Override
	public GeocercaByEstado objetoGeocercaByEstado(String id) {
		return this.geocercaByEstadoDao.objetoGeocercaByEstado(id);
	}

	@Override
	public List<GeocercaByEstado> listaDeGeocercaByEstado(String id) {
		return this.geocercaByEstadoDao.listaDeGeocercaByEstado(id);
	}
}