package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Comunicado;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class ComunicadoDataModel extends JMModeloBasico<Comunicado> {

	private static final long serialVersionUID = -90333338403906639L;

	public ComunicadoDataModel(final List<Comunicado> datasource) {
		super(datasource);
	}
}