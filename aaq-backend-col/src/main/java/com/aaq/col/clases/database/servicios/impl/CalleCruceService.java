package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CalleCruce;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.CalleCruceDao;
import com.aaq.col.clases.database.servicios.interfase.CalleCruceServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("calleCruceService")
@Transactional
public class CalleCruceService implements CalleCruceServiceInterfase {
	
	@Autowired
	@Qualifier("calleCruceDao")
	CalleCruceDao calleCruceDao;

	@Override
	public CalleCruce objetoCalleCruce(final String id) {
		return this.calleCruceDao.objetoCalleCruce(id);
	}

	@Override
	public List<CalleCruce> listaDeCalleCruce(final Estado estado, final String idmunicipio, final String idcolonia,
			final String nombrecalleUno, final String nombrecalleDos) {
		return this.calleCruceDao.listaDeCalleCruce(estado, idmunicipio, idcolonia, nombrecalleUno, nombrecalleDos);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CalleCruce t) {
		return this.calleCruceDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CalleCruce t) {
		return this.calleCruceDao.guardarObjeto(t);
	}
}