package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatVehTercDataModel extends JMModeloBasico<CatalogoVehTerc> {

	private static final long serialVersionUID = -5468860687562435263L;

	public CatVehTercDataModel(List<CatalogoVehTerc> datasource) {
		super(datasource);
	}

}
