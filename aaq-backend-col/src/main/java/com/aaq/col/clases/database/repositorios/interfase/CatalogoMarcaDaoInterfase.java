package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoMarcaDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoMarca> {

	public abstract CatalogoMarca objetoCatalogoMarca(String id);
	public abstract List<CatalogoMarca> listaDeCatalogoMarca();
	public abstract CatalogoMarca objetoCatalogoMarcaParaClave(String clave);
	public abstract List<CatalogoMarca> listaDeCatalogoMarca(final String clave, final String nombre);

}