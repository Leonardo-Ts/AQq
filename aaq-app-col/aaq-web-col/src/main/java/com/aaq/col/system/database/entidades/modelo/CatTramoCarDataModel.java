package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatTramoCarDataModel extends JMModeloBasico<CatalogoTramoCar> {

	private static final long serialVersionUID = -9209570619433900387L;

	public CatTramoCarDataModel(List<CatalogoTramoCar> datasource) {
		super(datasource);
	}

}
