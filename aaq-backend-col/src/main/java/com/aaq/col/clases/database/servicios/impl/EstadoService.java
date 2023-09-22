 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.EstadoDao;
import com.aaq.col.clases.database.servicios.interfase.EstadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("estadoService")
@Transactional
public class EstadoService implements EstadoServiceInterfase {
	
	@Autowired
	@Qualifier("estadoDao")
	EstadoDao estadoDao;

	@Override
	public Estado objetoEstado(final String id) {
		return this.estadoDao.objetoEstado(id);
	}

	@Override
	public List<Estado> listaDeEstado() {
		return this.estadoDao.listaDeEstado();
	}

	@Override
	public List<Estado> listaDeEstado(final String nombre, final Integer identidad, final String orden) {
		return this.estadoDao.listaDeEstado(nombre, identidad, orden);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Estado t) {
		return this.estadoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Estado t) {
		return this.estadoDao.guardarObjeto(t);
	}

	@Override
	public Estado objetoEstadoNombre(String nombre) {
		return this.estadoDao.objetoEstadoNombre(nombre);
	}
	
	
}