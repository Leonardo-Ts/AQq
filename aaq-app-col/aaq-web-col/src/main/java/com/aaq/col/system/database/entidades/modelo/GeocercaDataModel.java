package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class GeocercaDataModel extends JMModeloBasico<Geocerca> {
	
	private static final long serialVersionUID = -3997534329112219327L;

	public GeocercaDataModel(final List<Geocerca> datasource) {
		super(datasource);
	}
}