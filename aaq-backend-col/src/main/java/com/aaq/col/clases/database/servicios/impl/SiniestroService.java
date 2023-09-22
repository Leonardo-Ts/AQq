package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Siniestro;
import com.aaq.col.clases.database.repositorios.impl.SiniestroDao;
import com.aaq.col.clases.database.servicios.interfase.SiniestroServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("siniestroService")
@Transactional
public class SiniestroService implements SiniestroServiceInterfase {
	
	@Autowired
	@Qualifier("siniestroDao")
	SiniestroDao siniestroDao;

	@Override
	public Siniestro objetoSiniestro(final String id) {
		return this.siniestroDao.objetoSiniestro(id);
	}

	@Override
	public Siniestro objetoSiniestro(final String numeroReporte, final String identificadorUnico) {
		return this.siniestroDao.objetoSiniestro(numeroReporte, identificadorUnico);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Siniestro t) {
		return this.siniestroDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Siniestro t) {
		return this.siniestroDao.guardarObjeto(t);
	}
}