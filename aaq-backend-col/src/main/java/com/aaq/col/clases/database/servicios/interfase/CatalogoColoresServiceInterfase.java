package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoColores;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoColoresServiceInterfase extends JMServicioGenericoInterfase<CatalogoColores> {

	public abstract CatalogoColores objetoCatalogoColores(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoColores t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoColores t);
	public abstract List<CatalogoColores> listaDeCatalogoColores(String clave, String descripcion) ;
}
