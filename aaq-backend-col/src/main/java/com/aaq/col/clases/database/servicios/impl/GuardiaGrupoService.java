 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GuardiaGrupo;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.GuardiaGrupoDao;
import com.aaq.col.clases.database.servicios.interfase.GuardiaGrupoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("guardiaGrupoService")
@Transactional
public class GuardiaGrupoService implements GuardiaGrupoServiceInterfase {
	
	@Autowired
	@Qualifier("guardiaGrupoDao")
	GuardiaGrupoDao guardiaGrupoDao;

	@Override
	public List<GuardiaGrupo> listaDeGuardiaGrupo(final Grupo grupo) {
		return this.guardiaGrupoDao.listaDeGuardiaGrupo(grupo);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final GuardiaGrupo t) {
		return this.guardiaGrupoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final GuardiaGrupo t) {
		return this.guardiaGrupoDao.guardarObjeto(t);
	}

	@Override
	public GuardiaGrupo objetoGuardiaGrupo(String id)  {
		return this.guardiaGrupoDao.objetoGuardiaGrupo(id);
	}
	
	@Override
	public GuardiaGrupo objetoGuardiaPorGrupo(Grupo idGrupo)  {
		return this.guardiaGrupoDao.objetoGuardiaPorGrupo(idGrupo);
	}

	@Override
	public List<GuardiaGrupo> listaDeGuardiaGrupo(Terminal terminal)  {
		return null;
	}

	

}