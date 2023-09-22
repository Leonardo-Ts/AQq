package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CalleDireccion;
import com.aaq.col.clases.database.repositorios.impl.CalleDireccionDao;
import com.aaq.col.clases.database.servicios.interfase.CalleDireccionServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("calleDireccionService")
@Transactional
public class CalleDireccionService implements CalleDireccionServiceInterfase {
	
	@Autowired
	@Qualifier("calleDireccionDao")
	CalleDireccionDao calleDireccionDao;

	@Override
	public CalleDireccion objetoCalleDireccion(final String id) {
		return this.calleDireccionDao.objetoCalleDireccion(id);
	}

	@Override
	public CalleDireccion objetoCalleDireccionParaCoordenadas(final String latitud, final String longitud) {
		return this.calleDireccionDao.objetoCalleDireccionParaCoordenadas(latitud, longitud);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CalleDireccion t) {
		return this.calleDireccionDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CalleDireccion t) {
		return this.calleDireccionDao.guardarObjeto(t);
	}
}