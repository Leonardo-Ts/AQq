 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.repositorios.impl.ConfiguracionDao;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("configuracionService")
@Transactional
public class ConfiguracionService implements ConfiguracionServiceInterfase {
	
	@Autowired
	@Qualifier("configuracionDao")
	ConfiguracionDao configuracionDao;

	@Override
	public Configuracion objetoConfiguracion(final String id) {
		return this.configuracionDao.objetoConfiguracion(id);
	}

	@Override
	public boolean obtenerBooleano(final String llave) {
		return this.configuracionDao.obtenerBooleano(llave);
	}

	@Override
	public int obtenerEntero(final String llave) {
		return this.configuracionDao.obtenerEntero(llave);
	}

	@Override
	public double obtenerDoble(final String llave) {
		return this.configuracionDao.obtenerDoble(llave);
	}

	@Override
	public String obtenerCadena(final String llave) {
		return this.configuracionDao.obtenerCadena(llave);
	}

	@Override
	public List<Configuracion> listaDeConfiguracion() {
		return this.configuracionDao.listaDeConfiguracion();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Configuracion t) {
		return this.configuracionDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Configuracion t) {
		return this.configuracionDao.guardarObjeto(t);
	}

	@Override
	public String obtenerUltimoId(final String tabla) {
		return this.configuracionDao.obtenerUltimoId(tabla);
	}
}