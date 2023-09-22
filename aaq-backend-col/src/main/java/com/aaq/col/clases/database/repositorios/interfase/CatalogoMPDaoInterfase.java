package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMP;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoMPDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoMP> {

	public abstract CatalogoMP objetoCatalogoMP(final String id) ;
	public abstract List<CatalogoMP> listaDeCatalogoMP(final String clave, final String descripcion);

}
