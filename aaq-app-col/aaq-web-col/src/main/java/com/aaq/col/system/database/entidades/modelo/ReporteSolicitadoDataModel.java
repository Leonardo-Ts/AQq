package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class ReporteSolicitadoDataModel extends JMModeloBasico<ReporteSolicitado> {
	
	private static final long serialVersionUID = 3493446331851766148L;

	public ReporteSolicitadoDataModel(final List<ReporteSolicitado> datasource) {
		super(datasource);
	}
}