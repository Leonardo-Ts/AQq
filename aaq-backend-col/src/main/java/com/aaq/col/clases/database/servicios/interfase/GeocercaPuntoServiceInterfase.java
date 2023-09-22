package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.GeocercaPunto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface GeocercaPuntoServiceInterfase extends JMServicioGenericoInterfase<GeocercaPunto> {

	public abstract GeocercaPunto objetoGeocercaPunto(final String id) ;
	public abstract List<GeocercaPunto> listaDeGeocercaPunto(Geocerca geocerca) ;
	public abstract JMResultadoOperacion eliminarObjeto(GeocercaPunto t) ;
	public abstract JMResultadoOperacion guardarObjeto(GeocercaPunto t) ;
}