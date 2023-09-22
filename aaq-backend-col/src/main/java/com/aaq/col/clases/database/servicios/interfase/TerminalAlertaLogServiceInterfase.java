package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlertaLog;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalAlertaLogServiceInterfase extends JMServicioGenericoInterfase<TerminalAlertaLog> {

	public abstract TerminalAlertaLog objetoTerminalAlertaLog(final String id) ;
	public abstract List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal) ;
	public abstract List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal, Date fechaInicial,
			Date fechaFinal) ;
	public abstract JMResultadoOperacion eliminarObjeto(TerminalAlertaLog t) ;
	public abstract JMResultadoOperacion guardarObjeto(TerminalAlertaLog t) ;
}