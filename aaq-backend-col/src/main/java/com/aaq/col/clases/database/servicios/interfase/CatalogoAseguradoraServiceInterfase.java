 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoAseguradoraServiceInterfase extends JMServicioGenericoInterfase<CatalogoAseguradora> {

	public abstract CatalogoAseguradora objetoCatalogoAseguradora(String id);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoAseguradora t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoAseguradora t);
	public abstract List<CatalogoAseguradora> listaCatalogoAseguradora(String clave, String descripcion);
	public abstract CatalogoAseguradora objetoCatalogoAseguradoraClave(String clave) ;
}