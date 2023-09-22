package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarcaTerc;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoMarcaTercDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoMarcaTerc> {
	
	public abstract CatalogoMarcaTerc objetoCatalogoMarcaTerc(final String id) ;
	public abstract List<CatalogoMarcaTerc> listaDeCatalogoMarcaTerc(final String clave, final String descripcion);

}
