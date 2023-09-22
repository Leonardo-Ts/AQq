package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface GeocercaServiceInterfase extends JMServicioGenericoInterfase<Geocerca> {

	public abstract Geocerca objetoGeocerca(final String id) ;
	public abstract List<Geocerca> listaDeGeocerca(final Estado estado) ;
	public abstract JMResultadoOperacion eliminarObjeto(Geocerca t) ;
	public abstract JMResultadoOperacion guardarObjeto(Geocerca t) ;
}