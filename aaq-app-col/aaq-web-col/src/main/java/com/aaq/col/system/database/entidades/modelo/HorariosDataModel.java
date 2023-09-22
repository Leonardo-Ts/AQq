package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Horarios;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class HorariosDataModel extends JMModeloBasico<Horarios> {
	
	private static final long serialVersionUID = 6261824273800418223L;

	public HorariosDataModel(final List<Horarios> datasource) {
		super(datasource);
	}
}