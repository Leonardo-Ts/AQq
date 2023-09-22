package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface GeocercaDaoInterfase extends JMRepositorioGenericoInterfase<Geocerca> {

	public abstract Geocerca objetoGeocerca(final String id);
	public abstract List<Geocerca> listaDeGeocerca(final Estado estado);

}