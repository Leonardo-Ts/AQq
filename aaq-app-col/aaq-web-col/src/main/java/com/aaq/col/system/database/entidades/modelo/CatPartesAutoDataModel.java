package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatPartesAutoDataModel extends JMModeloBasico<CatalogoPartesAuto> {

	private static final long serialVersionUID = 168765014140480522L;

	public CatPartesAutoDataModel(List<CatalogoPartesAuto> datasource) {
		super(datasource);
	}

	
}
