package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Calle;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CalleServiceInterfase extends JMServicioGenericoInterfase<Calle> {

	public abstract Calle objetoCalle(String id) ;
	public abstract List<Calle> listaDeCalle(Estado estado, String idmunicipio, String idcolonia, String nombre);
	public abstract JMResultadoOperacion eliminarObjeto(Calle t) ;
	public abstract JMResultadoOperacion guardarObjeto(Calle t) ;
}