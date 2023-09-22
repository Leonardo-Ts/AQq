package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatRecuperacionDataModel extends JMModeloBasico<CatalogoRecuperaciones> {

	private static final long serialVersionUID = -3797997719760907325L;

	public CatRecuperacionDataModel(List<CatalogoRecuperaciones> datasource) {
		super(datasource);
	} 

}
