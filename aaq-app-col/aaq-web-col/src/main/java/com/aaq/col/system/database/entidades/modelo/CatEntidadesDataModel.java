package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatEntidadesDataModel extends JMModeloBasico<Estado> {

	private static final long serialVersionUID = -3147707394637130638L;

	public CatEntidadesDataModel(List<Estado> datasource) {
		super(datasource);
	}

	
}
