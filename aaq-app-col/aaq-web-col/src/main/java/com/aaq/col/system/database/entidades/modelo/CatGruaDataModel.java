package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatGruaDataModel extends JMModeloBasico<CatalogoGrua> {

	private static final long serialVersionUID = 2286512865561832085L;

	public CatGruaDataModel(List<CatalogoGrua> datasource) {
		super(datasource);
	}

}
