package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatalogoOficinaDataModel extends JMModeloBasico<CatalogoOficina> {
	
	private static final long serialVersionUID = -4591072838800011575L;

	public CatalogoOficinaDataModel(final List<CatalogoOficina> datasource) {
		super(datasource);
	}
}