package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatAccidentesDataModel extends JMModeloBasico<CatalogoAccidentes> {

	private static final long serialVersionUID = 1973607808761213970L;

	public CatAccidentesDataModel(List<CatalogoAccidentes> datasource) {
		super(datasource);
	}


}
