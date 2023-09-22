package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class HistoricoTerminalDataModel extends JMModeloBasico<HistoricoTerminal> {
	
	private static final long serialVersionUID = -230925642971163719L;

	public HistoricoTerminalDataModel(final List<HistoricoTerminal> datasource) {
		super(datasource);
	}
}