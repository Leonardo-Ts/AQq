package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface EstadoServiceInterfase extends JMServicioGenericoInterfase<Estado> {

	
	public abstract Estado objetoEstado(String id) ;
	public abstract List<Estado> listaDeEstado() ;
	public abstract List<Estado> listaDeEstado(String nombre, Integer identidad, String orden) ;
	public abstract JMResultadoOperacion eliminarObjeto(Estado t);
	public abstract JMResultadoOperacion guardarObjeto(Estado t);
	public abstract Estado objetoEstadoNombre(String nombre) ;

}