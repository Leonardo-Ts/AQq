package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatCoberturasDataModel extends JMModeloBasico<CatalogoCoberturas>{

	private static final long serialVersionUID = 4192326130405569682L;

	public CatCoberturasDataModel(List<CatalogoCoberturas> datasource) {
		super(datasource);
	}

}
