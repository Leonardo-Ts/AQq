package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface CatalogoRecuperacionesServiceInterfase extends JMServicioGenericoInterfase<CatalogoRecuperaciones> {
	
	public abstract CatalogoRecuperaciones objetoCatalogoRecuperacionesClave(String clave);
	public abstract List<CatalogoRecuperaciones> listaRecuperaciones(String clave, String nombre);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoRecuperaciones t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoRecuperaciones t);

}