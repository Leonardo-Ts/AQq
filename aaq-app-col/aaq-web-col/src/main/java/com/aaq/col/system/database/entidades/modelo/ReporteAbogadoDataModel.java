package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class ReporteAbogadoDataModel extends JMModeloBasico<ReporteAbogado> {
	
	private static final long serialVersionUID = 8945658089826269684L;

	public ReporteAbogadoDataModel(final List<ReporteAbogado> datasource) {
		super(datasource);
	}
}