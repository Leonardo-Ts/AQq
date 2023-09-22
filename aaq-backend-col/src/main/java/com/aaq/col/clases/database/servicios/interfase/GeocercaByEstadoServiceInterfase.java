package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;

public interface GeocercaByEstadoServiceInterfase extends JMServicioGenericoInterfase<GeocercaByEstado> {
	
	public abstract GeocercaByEstado objetoGeocercaByEstado(final String id);
	public abstract List<GeocercaByEstado> listaDeGeocercaByEstado(final String id);

}