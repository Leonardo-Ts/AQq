package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoAccidentesDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoAccidentes>{
	
	public abstract CatalogoAccidentes objetoCatalogoAccidentes(final String id) ;
	public abstract List<CatalogoAccidentes> listaDeCatalogoAccidentes(final String clave, final String descripcion, final String codigo);

}
