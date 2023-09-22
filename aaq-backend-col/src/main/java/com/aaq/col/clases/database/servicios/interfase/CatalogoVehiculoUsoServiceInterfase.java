package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoUso;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoVehiculoUsoServiceInterfase extends JMServicioGenericoInterfase<CatalogoVehiculoUso> {

	public abstract List<CatalogoVehiculoUso> listaDeCatalogoVehiculoUso() ;
	public abstract CatalogoVehiculoUso objetoCatalogoVehiculoUso(String id) ;
	public abstract CatalogoVehiculoUso objetoCatalogoVehiculoUsoParaClave(String clave) ;
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoVehiculoUso t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoVehiculoUso t) ;
}