package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.GeocercaPunto;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface GeocercaPuntoDaoInterfase extends JMRepositorioGenericoInterfase<GeocercaPunto> {

	public abstract GeocercaPunto objetoGeocercaPunto(final String id);
	public abstract List<GeocercaPunto> listaDeGeocercaPunto(Geocerca geocerca);

}