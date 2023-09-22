package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.repositorios.impl.FrecuenciaDao;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("frecuenciaService")
@Transactional
public class FrecuenciaService implements FrecuenciaServiceInterfase {
	
	@Autowired
	@Qualifier("frecuenciaDao")
	FrecuenciaDao frecuenciaDao;

	@Override
	public Frecuencia objetoFrecuencia(final String id) {
		return this.frecuenciaDao.objetoFrecuencia(id);
	}

	@Override
	public List<Frecuencia> listaDeFrecuencia(final Estado estado) {
		return this.frecuenciaDao.listaDeFrecuencia(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Frecuencia t) {
		return this.frecuenciaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Frecuencia t) {
		return this.frecuenciaDao.guardarObjeto(t);
	}
}