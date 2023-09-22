package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.CalleDireccion;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CalleDireccionDaoInterfase extends JMRepositorioGenericoInterfase<CalleDireccion> {

	public abstract CalleDireccion objetoCalleDireccion(final String id);
	public abstract CalleDireccion objetoCalleDireccionParaCoordenadas(final String latitud, final String longitud);

}