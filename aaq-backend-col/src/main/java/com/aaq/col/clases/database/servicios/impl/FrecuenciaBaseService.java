package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.repositorios.impl.FrecuenciaBaseDao;
import com.aaq.col.clases.database.servicios.interfase.FrecuenciaBaseServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("frecuenciaBaseService")
@Transactional
public class FrecuenciaBaseService implements FrecuenciaBaseServiceInterfase {
	
	@Autowired
	@Qualifier("frecuenciaBaseDao")
	FrecuenciaBaseDao frecuenciaBaseDao;

	@Override
	public FrecuenciaBase objetoFrecuenciaBase(final String id) {
		return this.frecuenciaBaseDao.objetoFrecuenciaBase(id);
	}

	@Override
	public List<FrecuenciaBase> listaDeFrecuenciaBase(final Frecuencia frecuencia) {
		return this.frecuenciaBaseDao.listaDeFrecuenciaBase(frecuencia);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final FrecuenciaBase t) {
		return this.frecuenciaBaseDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final FrecuenciaBase t) {
		return this.frecuenciaBaseDao.guardarObjeto(t);
	}

	@Override
	public List<FrecuenciaBase> listaDeFrecuenciaBase(Base base) {
		return this.frecuenciaBaseDao.listaDeFrecuenciaBase(base);
	}
	
	@Override
	public List<FrecuenciaBase> listaDeFrecuenciaBaseGH(final Frecuencia frecuencia) {
		return this.frecuenciaBaseDao.listaDeFrecuenciaBaseGH(frecuencia);
	}
}