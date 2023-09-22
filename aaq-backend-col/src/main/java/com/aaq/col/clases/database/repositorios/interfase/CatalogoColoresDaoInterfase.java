package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoColores;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoColoresDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoColores> {
	
	public abstract CatalogoColores objetoCatalogoColores(final String id) ;
	public abstract List<CatalogoColores> listaDeCatalogoColores(final String clave, final String descripcion);

}
