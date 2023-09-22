package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Permiso;
import com.aaq.col.clases.database.repositorios.impl.PermisoDao;
import com.aaq.col.clases.database.servicios.interfase.PermisoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("permisoService")
@Transactional
public class PermisoService implements PermisoServiceInterfase {
	
	@Autowired
	@Qualifier("permisoDao")
	PermisoDao permisoDao;

	@Override
	public Permiso objetoPermiso(final String id) {
		return this.permisoDao.objetoPermiso(id);
	}

	@Override
	public List<Permiso> listaDePermiso(final Perfil perfil) {
		return this.permisoDao.listaDePermiso(perfil);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Permiso t) {
		return this.permisoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Permiso t) {
		return this.permisoDao.guardarObjeto(t);
	}
}