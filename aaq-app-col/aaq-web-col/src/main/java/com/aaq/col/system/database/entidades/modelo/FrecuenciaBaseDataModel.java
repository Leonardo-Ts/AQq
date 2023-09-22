package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class FrecuenciaBaseDataModel extends JMModeloBasico<FrecuenciaBase> {
	
	private static final long serialVersionUID = -2991830388491712207L;

	public FrecuenciaBaseDataModel(final List<FrecuenciaBase> datasource) {
		super(datasource);
	}
}