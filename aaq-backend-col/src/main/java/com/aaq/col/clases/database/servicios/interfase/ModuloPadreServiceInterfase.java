package com.aaq.col.clases.database.servicios.interfase;

import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ModuloPadreServiceInterfase extends JMServicioGenericoInterfase<ModuloPadre> {

	public abstract ModuloPadre objetoModuloPadre(String id) ;
	public abstract JMResultadoOperacion eliminarObjeto(ModuloPadre t) ;
	public abstract JMResultadoOperacion guardarObjeto(ModuloPadre t) ;
}