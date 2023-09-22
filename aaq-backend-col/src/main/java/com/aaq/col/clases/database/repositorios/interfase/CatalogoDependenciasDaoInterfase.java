package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoDependencias;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoDependenciasDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoDependencias> {

	public abstract CatalogoDependencias objetoCatalogoDependencias(String id);
	public abstract List<CatalogoDependencias> listaDeCatalogoDependencias(final String clave, final String descripcion);

	
}
