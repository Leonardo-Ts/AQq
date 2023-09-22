package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatFormatosDataModel extends JMModeloBasico<FormatoCatalogos> {

	private static final long serialVersionUID = -5896374889560672328L;

	public CatFormatosDataModel(List<FormatoCatalogos> datasource) {
		super(datasource);
	}

}
