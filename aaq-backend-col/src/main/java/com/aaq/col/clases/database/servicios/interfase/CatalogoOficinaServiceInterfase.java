package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface CatalogoOficinaServiceInterfase extends JMServicioGenericoInterfase<CatalogoOficina> {

	public abstract CatalogoOficina objetoCatalogoOficina(final String id) ;
	public abstract CatalogoOficina objetoCatalogoOficinaParaClave(final String clave) ;
	public abstract List<CatalogoOficina> listaDeCatalogoOficina(final Estado estado) ;
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoOficina t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoOficina t) ;
}