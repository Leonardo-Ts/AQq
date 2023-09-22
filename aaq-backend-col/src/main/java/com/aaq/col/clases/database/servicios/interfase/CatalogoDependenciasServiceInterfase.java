package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoDependencias;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoDependenciasServiceInterfase extends JMServicioGenericoInterfase<CatalogoDependencias> {

	public abstract CatalogoDependencias objetoCatalogoDependencias(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoDependencias t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoDependencias t);
	public abstract List<CatalogoDependencias> listaDeCatalogoDependencias(String clave, String descripcion) ;
}
