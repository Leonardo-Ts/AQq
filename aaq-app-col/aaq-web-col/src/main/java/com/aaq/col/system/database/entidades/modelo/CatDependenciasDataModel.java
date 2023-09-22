package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoDependencias;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatDependenciasDataModel extends JMModeloBasico<CatalogoDependencias> {

	private static final long serialVersionUID = -6060961630719169988L;

	public CatDependenciasDataModel(List<CatalogoDependencias> datasource) {
		super(datasource);
	}


}
