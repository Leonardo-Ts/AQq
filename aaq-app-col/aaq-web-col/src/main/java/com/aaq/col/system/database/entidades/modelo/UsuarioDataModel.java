package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class UsuarioDataModel extends JMModeloBasico<Usuario> {
	
	private static final long serialVersionUID = -4346933054588336496L;

	public UsuarioDataModel(final List<Usuario> datasource) {
		super(datasource);
	}
}