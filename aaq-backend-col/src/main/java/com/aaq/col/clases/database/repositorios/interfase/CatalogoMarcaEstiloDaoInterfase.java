package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.entidades.CatalogoMarcaEstilo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoMarcaEstiloDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoMarcaEstilo> {

	public abstract CatalogoMarcaEstilo objetoCatalogoMarcaEstilo(String id);
	public abstract List<CatalogoMarcaEstilo> listaDeCatalogoMarcaEstilo(CatalogoMarca catalogoMarca);
	public abstract CatalogoMarcaEstilo objetoCatalogoMarcaEstiloParaClave(CatalogoMarca catalogoMarca, String clave);

}