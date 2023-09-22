package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.SessionExterna;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class SessionExternaDataModel extends JMModeloBasico<SessionExterna> {
	
	private static final long serialVersionUID = 3330595631784129340L;

	public SessionExternaDataModel(final List<SessionExterna> datasource) {
		super(datasource);
	}
}