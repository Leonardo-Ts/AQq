package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Calle;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.CalleDao;
import com.aaq.col.clases.database.servicios.interfase.CalleServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("calleService")
@Transactional
public class CalleService implements CalleServiceInterfase {
	
	@Autowired
	@Qualifier("calleDao")
	CalleDao calleDao;

	@Override
	public Calle objetoCalle(final String id) {
		return this.calleDao.objetoCalle(id);
	}

	@Override
	public List<Calle> listaDeCalle(final Estado estado, final String idmunicipio, final String idcolonia,
			final String nombre) {
		return this.calleDao.listaDeCalle(estado, idmunicipio, idcolonia, nombre);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Calle t) {
		return this.calleDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Calle t) {
		return this.calleDao.guardarObjeto(t);
	}
}