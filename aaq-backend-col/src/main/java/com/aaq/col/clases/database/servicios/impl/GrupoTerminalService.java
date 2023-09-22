 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GrupoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.GrupoTerminalDao;
import com.aaq.col.clases.database.servicios.interfase.GrupoTerminalServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("grupoTerminalService")
@Transactional
public class GrupoTerminalService implements GrupoTerminalServiceInterfase {
	
	@Autowired
	@Qualifier("grupoTerminalDao")
	GrupoTerminalDao grupoTerminalDao;

	@Override
	public GrupoTerminal objetoGrupoTerminal(final String id) {
		return this.grupoTerminalDao.objetoGrupoTerminal(id);
	}

	@Override
	public List<GrupoTerminal> listaDeGrupoTerminal(final Grupo grupo) {
		return this.grupoTerminalDao.listaDeGrupoTerminal(grupo);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final GrupoTerminal t) {
		return this.grupoTerminalDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final GrupoTerminal t) {
		return this.grupoTerminalDao.guardarObjeto(t);
	}

	@Override
	public List<GrupoTerminal> listaDeGrupoTerminal(Terminal terminal)  {
		return this.grupoTerminalDao.listaDeGrupoTerminal(terminal);
	}
}