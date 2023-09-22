 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Carretera;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.CarreteraDao;
import com.aaq.col.clases.database.servicios.interfase.CarreteraServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("carreteraService")
@Transactional
public class CarreteraService implements CarreteraServiceInterfase {
	@Autowired
	@Qualifier("carreteraDao")
	CarreteraDao carreteraDao;

	@Override
	public Carretera objetoCarretera(final String id) {
		return this.carreteraDao.objetoCarretera(id);
	}

	@Override
	public List<Carretera> listaDeCarretera(final Estado estado, final String nombre) {
		return this.carreteraDao.listaDeCarretera(estado, nombre);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Carretera t) {
		return this.carreteraDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Carretera t) {
		return this.carreteraDao.guardarObjeto(t);
	}
}