package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CorreoPolizaAgenteDataModel extends JMModeloBasico<CorreoPolizaAgente> {
	
	private static final long serialVersionUID = 6261824273800418223L;
	
	public CorreoPolizaAgenteDataModel(List<CorreoPolizaAgente> datasource) {
		super(datasource);
	}

}
