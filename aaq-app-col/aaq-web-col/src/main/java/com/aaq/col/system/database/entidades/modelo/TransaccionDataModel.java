package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Transaccion;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class TransaccionDataModel extends JMModeloBasico<Transaccion> {
	
	private static final long serialVersionUID = 592847673097515325L;

	public TransaccionDataModel(final List<Transaccion> datasource) {
		super(datasource);
	}
}