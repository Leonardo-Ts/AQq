package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalAlertaServiceInterfase extends JMServicioGenericoInterfase<TerminalAlerta> {

	public abstract TerminalAlerta objetoTerminalAlerta(final String id) ;
	public abstract List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal) ;
	public abstract List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal,
			final PuntoInteres puntoInteres, final Geocerca geocerca) ;
	public abstract JMResultadoOperacion eliminarObjeto(TerminalAlerta t) ;
	public abstract JMResultadoOperacion guardarObjeto(TerminalAlerta t) ;
}