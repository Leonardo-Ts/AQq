package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.GeocercaPunto;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class GeocercaPuntoDataModel extends JMModeloBasico<GeocercaPunto> {
	
	private static final long serialVersionUID = -6255613091328230053L;

	public GeocercaPuntoDataModel(final List<GeocercaPunto> datasource) {
		super(datasource);
	}
}