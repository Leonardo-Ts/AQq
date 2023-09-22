package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatAseguradoraDataModel extends JMModeloBasico<CatalogoAseguradora> {

	private static final long serialVersionUID = 130611382985838053L;

	public CatAseguradoraDataModel(List<CatalogoAseguradora> datasource) {
		super(datasource);
	}

}
