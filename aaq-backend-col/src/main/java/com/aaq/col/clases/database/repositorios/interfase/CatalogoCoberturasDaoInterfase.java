package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoCoberturasDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoCoberturas> {

	public abstract CatalogoCoberturas objetoCatalogoCoberturasClave(String clave);
	public abstract List<CatalogoCoberturas> listaDeCatalogoCoberturas(final String clave, final String descripcion);

}