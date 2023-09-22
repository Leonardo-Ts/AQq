package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoTipo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoVehiculoTipoServiceInterfase extends JMServicioGenericoInterfase<CatalogoVehiculoTipo> {

	public abstract List<CatalogoVehiculoTipo> listaDeCatalogoVehiculoTipo() ;
	public abstract CatalogoVehiculoTipo objetoCatalogoVehiculoTipo(String id) ;
	public abstract CatalogoVehiculoTipo objetoCatalogoVehiculoParaClave(String clave) ;
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoVehiculoTipo t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoVehiculoTipo t) ;
}