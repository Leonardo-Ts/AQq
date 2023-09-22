package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoFaq;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoFaqDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoFaq> {
	
	public abstract CatalogoFaq objetoCatalogoFaq(final String id) ;
	public abstract List<CatalogoFaq> listaDeCatalogoFaq(final String clave, final String descripcion);

}
