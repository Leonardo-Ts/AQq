package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class ReporteMovilDataModel extends JMModeloBasico<ReporteMovil> {
	
	private static final long serialVersionUID = 545293254935207944L;

	public ReporteMovilDataModel(final List<ReporteMovil> datasource) {
		super(datasource);
	}
}