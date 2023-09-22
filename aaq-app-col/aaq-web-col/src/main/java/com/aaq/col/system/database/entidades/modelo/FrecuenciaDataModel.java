package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class FrecuenciaDataModel extends JMModeloBasico<Frecuencia> {
	
	private static final long serialVersionUID = 6261824273800418223L;

	public FrecuenciaDataModel(final List<Frecuencia> datasource) {
		super(datasource);
	}
}