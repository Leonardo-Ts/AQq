 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.clases.database.repositorios.impl.PuntoInteresDao;
import com.aaq.col.clases.database.servicios.interfase.PuntoInteresServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("puntoInteresService")
@Transactional
public class PuntoInteresService implements PuntoInteresServiceInterfase {
	
	@Autowired
	@Qualifier("puntoInteresDao")
	PuntoInteresDao puntoInteresDao;

	@Override
	public PuntoInteres objetoPuntoInteres(final String id) {
		return this.puntoInteresDao.objetoPuntoInteres(id);
	}

	@Override
	public List<PuntoInteres> listaDePuntoInteres(final Estado estado, final List<PuntoInteresTipo> tipo) {
		return this.puntoInteresDao.listaDePuntoInteres(estado, tipo);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final PuntoInteres t) {
		return this.puntoInteresDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final PuntoInteres t) {
		return this.puntoInteresDao.guardarObjeto(t);
	}
}