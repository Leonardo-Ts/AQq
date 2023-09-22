package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalComentario;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface TerminalComentarioDaoInterfase extends JMRepositorioGenericoInterfase<TerminalComentario> {

	public abstract TerminalComentario objetoTerminalComentario(final String id);
	public abstract List<TerminalComentario> listaTerminalComentarios(final Terminal terminal);
	public abstract List<TerminalComentario> listaTerminalComentariosVistos(Terminal terminal);
}
