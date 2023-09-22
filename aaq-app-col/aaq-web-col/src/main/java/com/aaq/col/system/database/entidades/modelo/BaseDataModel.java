package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class BaseDataModel extends JMModeloBasico<Base> {
	
	private static final long serialVersionUID = -8727666485019151535L;

	public BaseDataModel(final List<Base> datasource) {
		super(datasource);
	}
}