 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.repositorios.impl.PerfilDao;
import com.aaq.col.clases.database.servicios.interfase.PerfilServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("perfilService")
@Transactional
public class PerfilService implements PerfilServiceInterfase {
	
	@Autowired
	@Qualifier("perfilDao")
	PerfilDao perfilDao;

	@Override
	public Perfil objetoPerfil(final String id) {
		return this.perfilDao.objetoPerfil(id);
	}

	@Override
	public List<Perfil> listaDePerfil() {
		return this.perfilDao.listaDePerfil();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Perfil t) {
		return this.perfilDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Perfil t) {
		return this.perfilDao.guardarObjeto(t);
	}
}