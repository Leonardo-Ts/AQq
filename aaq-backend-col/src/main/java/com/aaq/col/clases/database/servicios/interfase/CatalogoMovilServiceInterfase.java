package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMovil;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoMovilServiceInterfase extends JMServicioGenericoInterfase<CatalogoMovil> {

	public abstract CatalogoMovil objetoCatalogoMovil(String id);
	public abstract List<CatalogoMovil> listaDeCatalogoMovil();
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoMovil t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoMovil t) ;
}
