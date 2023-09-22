package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Permiso;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface PermisoServiceInterfase extends JMServicioGenericoInterfase<Permiso> {

	public abstract Permiso objetoPermiso(final String id) ;
	public abstract List<Permiso> listaDePermiso(final Perfil perfil) ;
	public abstract JMResultadoOperacion eliminarObjeto(Permiso t) ;
	public abstract JMResultadoOperacion guardarObjeto(Permiso t) ;
}