package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class PuntoInteresDataModel extends JMModeloBasico<PuntoInteres> {
	
	private static final long serialVersionUID = 5055863147919002210L;

	public PuntoInteresDataModel(final List<PuntoInteres> datasource) {
		super(datasource);
	}
}