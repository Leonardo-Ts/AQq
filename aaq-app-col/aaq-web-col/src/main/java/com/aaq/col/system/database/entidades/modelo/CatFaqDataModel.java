package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoFaq;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatFaqDataModel extends JMModeloBasico<CatalogoFaq> {

	private static final long serialVersionUID = -7364311225815674843L;

	public CatFaqDataModel(List<CatalogoFaq> datasource) {
		super(datasource);
	}

}
