 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.SessionExterna;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface SessionExternaDaoInterfase extends JMRepositorioGenericoInterfase<SessionExterna> {

	public abstract SessionExterna objetoSessionExterna(final String id);
	public abstract SessionExterna objetoSessionExternaParaTerminal(final Terminal terminal);
	public abstract List<SessionExterna> listaDeSessionExterna(List<Terminal> listaTerminales, Date fechaInicia,
			Date fechaFinal);
	public abstract void informacionDeSessionExterna(final Terminal terminal, final String operacion);

}