package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GrupoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface GrupoTerminalServiceInterfase extends JMServicioGenericoInterfase<GrupoTerminal> {

	public abstract GrupoTerminal objetoGrupoTerminal(final String id) ;
	public abstract List<GrupoTerminal> listaDeGrupoTerminal(final Grupo grupo) ;
	public abstract  List<GrupoTerminal> listaDeGrupoTerminal(final Terminal terminal) ;
	public abstract JMResultadoOperacion eliminarObjeto(GrupoTerminal t) ;
	public abstract JMResultadoOperacion guardarObjeto(GrupoTerminal t) ;
}