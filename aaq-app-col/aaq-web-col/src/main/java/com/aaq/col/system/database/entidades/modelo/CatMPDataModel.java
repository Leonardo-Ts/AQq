package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMP;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatMPDataModel extends JMModeloBasico<CatalogoMP> {

	private static final long serialVersionUID = 4204799000326811934L;

	public CatMPDataModel(List<CatalogoMP> datasource) {
		super(datasource);
	}

	
}
