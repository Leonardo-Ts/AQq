package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatCredencialesDataModel extends JMModeloBasico<CatalogoCredenciales> {

	private static final long serialVersionUID = -2558008242278961143L;
	
	public CatCredencialesDataModel(List<CatalogoCredenciales> datasource) {
		super(datasource);
	}
}
