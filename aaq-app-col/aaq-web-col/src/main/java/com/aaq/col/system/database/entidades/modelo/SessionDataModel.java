package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Session;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class SessionDataModel extends JMModeloBasico<Session> {
	
	private static final long serialVersionUID = -7165764769070094601L;

	public SessionDataModel(final List<Session> datasource) {
		super(datasource);
	}
}