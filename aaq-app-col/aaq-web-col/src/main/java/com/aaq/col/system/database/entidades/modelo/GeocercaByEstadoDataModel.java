package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class GeocercaByEstadoDataModel extends JMModeloBasico<GeocercaByEstado> {
	
	private static final long serialVersionUID = -3319520313943413328L;

	public GeocercaByEstadoDataModel(final List<GeocercaByEstado> datasource) {
		super(datasource);
	}
}