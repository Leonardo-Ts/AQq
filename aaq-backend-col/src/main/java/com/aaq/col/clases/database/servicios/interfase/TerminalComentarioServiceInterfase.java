package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalComentario;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalComentarioServiceInterfase extends JMServicioGenericoInterfase<TerminalComentario> {

	public abstract TerminalComentario objetoTerminalComentario(final String id);
	public abstract List<TerminalComentario> listaTerminalComentarios(final Terminal terminal, String usuario);
	public abstract JMResultadoOperacion eliminarObjeto(TerminalComentario t) ;
	public abstract JMResultadoOperacion guardarObjeto(TerminalComentario t) ;
	public abstract boolean contieneComentariosNoVistos(Terminal terminal);
	public abstract List<TerminalComentario> listaTerminalComentarios(Terminal terminal);


}
