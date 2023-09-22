package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMovil;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoMovilDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoMovil> {

	public abstract CatalogoMovil objetoCatalogoMovil(String id);
	public abstract List<CatalogoMovil> listaDeCatalogoMovil();
}
