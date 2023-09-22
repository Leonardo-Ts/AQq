package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatMarcasDataModel extends JMModeloBasico<CatalogoMarca> { 
	
	private static final long serialVersionUID = 2408636306102280914L;

	public CatMarcasDataModel(List<CatalogoMarca> datasource) {
		super(datasource);
	}

}
