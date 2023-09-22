package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.TerminalLog;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class TerminalLogDataModel extends JMModeloBasico<TerminalLog> {
	
	private static final long serialVersionUID = -8010545705409592121L;

	public TerminalLogDataModel(final List<TerminalLog> datasource) {
		super(datasource);
	}
}