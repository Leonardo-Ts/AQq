package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarcaTerc;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatMarcaTercDataModel extends JMModeloBasico<CatalogoMarcaTerc>{

	private static final long serialVersionUID = 4587276624734522343L;

	public CatMarcaTercDataModel(List<CatalogoMarcaTerc> datasource) {
		super(datasource);
	}

}
