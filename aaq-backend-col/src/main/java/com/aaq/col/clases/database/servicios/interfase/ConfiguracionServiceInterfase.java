 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface ConfiguracionServiceInterfase extends JMServicioGenericoInterfase<Configuracion> {

	public abstract Configuracion objetoConfiguracion(String id) ;
	public abstract boolean obtenerBooleano(String llave) ;
	public abstract int obtenerEntero(String llave) ;
	public abstract double obtenerDoble(String llave) ;
	public abstract String obtenerCadena(String llave);
	public abstract List<Configuracion> listaDeConfiguracion() ;
	public abstract String obtenerUltimoId(String tabla) ;
	public abstract JMResultadoOperacion eliminarObjeto(Configuracion t) ;
	public abstract JMResultadoOperacion guardarObjeto(Configuracion t) ;
}