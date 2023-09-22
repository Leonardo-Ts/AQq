package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class TerminalDataModel extends JMModeloBasico<Terminal> {
	
	private static final long serialVersionUID = 2284567918791676685L;

	public TerminalDataModel(final List<Terminal> datasource) {
		super(datasource);
	}
}