package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class ConfiguracionDataModel extends JMModeloBasico<Configuracion> {
	
	private static final long serialVersionUID = -5656653403466382609L;

	public ConfiguracionDataModel(final List<Configuracion> datasource) {
		super(datasource);
	}
}