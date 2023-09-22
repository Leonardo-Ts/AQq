package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class MensajeSmsDataModel extends JMModeloBasico<MensajeSms> {
	
	private static final long serialVersionUID = -1662702816456299787L;

	public MensajeSmsDataModel(final List<MensajeSms> datasource) {
		super(datasource);
	}
}