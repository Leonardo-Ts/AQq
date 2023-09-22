package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteSise;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class ReporteSiseDataModel extends JMModeloBasico<ReporteSise> {
	
	private static final long serialVersionUID = -3332732378115895971L;

	public ReporteSiseDataModel(final List<ReporteSise> datasource) {
		super(datasource);
	}
}