package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatHospitaleDataModel extends JMModeloBasico<CatalogoHospitales> {

	private static final long serialVersionUID = 2738653340251360688L;

	public CatHospitaleDataModel(List<CatalogoHospitales> datasource) {
		super(datasource);
	}

}
