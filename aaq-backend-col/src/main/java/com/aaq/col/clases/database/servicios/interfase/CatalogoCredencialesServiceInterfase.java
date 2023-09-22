package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoCredencialesServiceInterfase extends JMServicioGenericoInterfase<CatalogoCredenciales> {

	public abstract CatalogoCredenciales objetoCatalogoCredenciales(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoCredenciales t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoCredenciales t);
	public abstract List<CatalogoCredenciales> listaDeCatalogoCredenciales(final String nombre, final String url, final String usuario, final String pwd) ;
}
