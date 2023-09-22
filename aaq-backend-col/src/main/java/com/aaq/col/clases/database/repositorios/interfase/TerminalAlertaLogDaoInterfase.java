package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlertaLog;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface TerminalAlertaLogDaoInterfase extends JMRepositorioGenericoInterfase<TerminalAlertaLog> {

	public abstract TerminalAlertaLog objetoTerminalAlertaLog(final String id);
	public abstract List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal);
	public abstract List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal, Date fechaInicial,
			Date fechaFinal);

}