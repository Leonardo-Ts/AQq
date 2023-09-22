package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface TerminalAlertaDaoInterfase extends JMRepositorioGenericoInterfase<TerminalAlerta> {

	public abstract TerminalAlerta objetoTerminalAlerta(final String id);
	public abstract List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal);
	public abstract List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal,
			final PuntoInteres puntoInteres, final Geocerca geocerca);

}