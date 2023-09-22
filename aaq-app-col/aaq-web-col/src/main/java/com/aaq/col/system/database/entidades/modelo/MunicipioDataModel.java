package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Municipio;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class MunicipioDataModel extends JMModeloBasico<Municipio> {

	private static final long serialVersionUID = -2992491136410669265L;

	public MunicipioDataModel(List<Municipio> datasource) {
		super(datasource);
	}

}
