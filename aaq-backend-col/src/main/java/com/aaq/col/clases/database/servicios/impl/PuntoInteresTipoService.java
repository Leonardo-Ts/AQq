package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.clases.database.repositorios.impl.PuntoInteresTipoDao;
import com.aaq.col.clases.database.servicios.interfase.PuntoInteresTipoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("puntoInteresTipoService")
@Transactional
public class PuntoInteresTipoService implements PuntoInteresTipoServiceInterfase {
	
	@Autowired
	@Qualifier("puntoInteresTipoDao")
	PuntoInteresTipoDao puntoInteresTipoDao;

	@Override
	public PuntoInteresTipo objetoPuntoInteresTipo(final String id) {
		return this.puntoInteresTipoDao.objetoPuntoInteresTipo(id);
	}

	@Override
	public PuntoInteresTipo objetoPuntoInteresTipoParaNombre(final String nombre) {
		return this.puntoInteresTipoDao.objetoPuntoInteresTipoParaNombre(nombre);
	}

	@Override
	public List<PuntoInteresTipo> listaDePuntoInteresTipo() {
		return this.puntoInteresTipoDao.listaDePuntoInteresTipo();
	}

	@Override
	public List<PuntoInteresTipo> listaDePuntoInteresTipo(final String idPermitido, final String idNoPermitido) {
		return this.puntoInteresTipoDao.listaDePuntoInteresTipo(idPermitido, idNoPermitido);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final PuntoInteresTipo t) {
		return this.puntoInteresTipoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final PuntoInteresTipo t) {
		return this.puntoInteresTipoDao.guardarObjeto(t);
	}
}