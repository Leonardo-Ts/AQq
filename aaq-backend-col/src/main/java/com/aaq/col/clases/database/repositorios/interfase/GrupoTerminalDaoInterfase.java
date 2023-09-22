package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GrupoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface GrupoTerminalDaoInterfase extends JMRepositorioGenericoInterfase<GrupoTerminal> {

	public abstract GrupoTerminal objetoGrupoTerminal(final String id);
	public abstract List<GrupoTerminal> listaDeGrupoTerminal(final Grupo grupo);
	public abstract List<GrupoTerminal> listaDeGrupoTerminal(final Terminal terminal);

}