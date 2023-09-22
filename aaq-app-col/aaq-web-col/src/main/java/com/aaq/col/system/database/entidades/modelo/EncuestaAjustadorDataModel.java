package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.EncuestaAjustador;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class EncuestaAjustadorDataModel extends JMModeloBasico<EncuestaAjustador> {
	
	private static final long serialVersionUID = 1648335484356236373L;

	public EncuestaAjustadorDataModel(final List<EncuestaAjustador> datasource) {
		super(datasource);
	}
}