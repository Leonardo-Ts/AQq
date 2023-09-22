package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class GrupoDataModel extends JMModeloBasico<Grupo> {
	
	private static final long serialVersionUID = 6261824273800418223L;

	public GrupoDataModel(final List<Grupo> datasource) {
		super(datasource);
	}
}