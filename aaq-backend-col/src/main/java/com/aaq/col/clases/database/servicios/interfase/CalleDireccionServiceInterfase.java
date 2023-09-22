package com.aaq.col.clases.database.servicios.interfase;

import com.aaq.col.clases.database.entidades.CalleDireccion;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CalleDireccionServiceInterfase extends JMServicioGenericoInterfase<CalleDireccion> {

	public abstract CalleDireccion objetoCalleDireccion(final String id) ;
	public abstract CalleDireccion objetoCalleDireccionParaCoordenadas(final String latitud, final String longitud);
	public abstract JMResultadoOperacion eliminarObjeto(CalleDireccion t) ;
	public abstract JMResultadoOperacion guardarObjeto(CalleDireccion t);
}