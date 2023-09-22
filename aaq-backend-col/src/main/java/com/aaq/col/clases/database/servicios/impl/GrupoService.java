package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.repositorios.impl.GrupoDao;
import com.aaq.col.clases.database.servicios.interfase.GrupoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("grupoService")
@Transactional
public class GrupoService implements GrupoServiceInterfase {
	
	@Autowired
	@Qualifier("grupoDao")
	GrupoDao grupoDao;

	@Override
	public Grupo objetoGrupo(final String id) {
		return this.grupoDao.objetoGrupo(id);
	}
	
	@Override
	public Grupo objetoGrupoPorNombre(final String nombre) {
		return this.grupoDao.grupoEncontrado(nombre);
	}

	@Override
	public List<Grupo> listaDeGrupo() {
		return this.grupoDao.listaDeGrupo();
	}
	
	@Override
	public List<Grupo> listaDeGrupo(Estado estado) {
		return this.grupoDao.listaDeGrupo(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Grupo t) {
		return this.grupoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Grupo t) {
		return this.grupoDao.guardarObjeto(t);
	}

	@Override
	public Grupo listaDeGrupoEdoNom(Estado estado, String nombre) {
		return this.grupoDao.listaDeGrupoEdoNom(estado, nombre);
	}
}