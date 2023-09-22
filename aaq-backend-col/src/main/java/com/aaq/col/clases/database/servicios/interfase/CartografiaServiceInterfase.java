 package com.aaq.col.clases.database.servicios.interfase;

import com.aaq.col.clases.database.entidades.Cartografia;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

/**
 */
public interface CartografiaServiceInterfase extends JMServicioGenericoInterfase<Cartografia> {

	public abstract Cartografia objetoCartografia(final String id);
	public abstract Cartografia objetoCartografia(final Estado estado, final Integer tipo);
	public abstract JMResultadoOperacion eliminarObjeto(Cartografia t);
	public abstract JMResultadoOperacion guardarObjeto(Cartografia t);
}