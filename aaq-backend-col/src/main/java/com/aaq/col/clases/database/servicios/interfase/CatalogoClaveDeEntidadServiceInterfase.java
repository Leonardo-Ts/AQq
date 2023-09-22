 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoClaveDeEntidad;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoClaveDeEntidadServiceInterfase extends JMServicioGenericoInterfase<CatalogoClaveDeEntidad> {

	public abstract CatalogoClaveDeEntidad objetoCatalogoClaveDeEntidad(String id)  ;
	public abstract List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad()  ;
	public abstract List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad(String llave, boolean soloConLlave);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoClaveDeEntidad t)  ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoClaveDeEntidad t)  ;
}