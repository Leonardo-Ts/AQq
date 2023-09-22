package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoCoberturasServiceInterfase extends JMServicioGenericoInterfase<CatalogoCoberturas> {

	public abstract CatalogoCoberturas objetoCatalogoCoberturasClave(String clave) ;
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoCoberturas t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoCoberturas t);
	public abstract List<CatalogoCoberturas> listaDeCatalogoCoberturas(String clave, String descripcion) ;

	
}