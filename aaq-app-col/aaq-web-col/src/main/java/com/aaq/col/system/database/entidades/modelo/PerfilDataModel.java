package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Perfil;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class PerfilDataModel extends JMModeloBasico<Perfil> {
	
	
	private static final long serialVersionUID = 9152343499354802918L;

	public PerfilDataModel(final List<Perfil> datasource) {
		super(datasource);
	}
}