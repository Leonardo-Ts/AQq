package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Cartografia;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.CartografiaDao;
import com.aaq.col.clases.database.servicios.interfase.CartografiaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("cartografiaService")
@Transactional
public class CartografiaService implements CartografiaServiceInterfase {
	
	@Autowired
	@Qualifier("cartografiaDao")
	CartografiaDao cartografiaDao;

	@Override
	public Cartografia objetoCartografia(final String id) {
		return this.cartografiaDao.objetoCartografia(id);
	}

	@Override
	public Cartografia objetoCartografia(final Estado estado, final Integer tipo) {
		return this.cartografiaDao.objetoCartografia(estado, tipo);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Cartografia t) {
		return this.cartografiaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Cartografia t) {
		return this.cartografiaDao.guardarObjeto(t);
	}
}