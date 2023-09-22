package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface GeocercaByEstadoDaoInterfase extends JMRepositorioGenericoInterfase<GeocercaByEstado> {

	public abstract GeocercaByEstado objetoGeocercaByEstado(final String id);
	public abstract List<GeocercaByEstado> listaDeGeocercaByEstado(final String id);

}