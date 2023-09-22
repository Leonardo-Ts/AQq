package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoOficinaDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoOficina> {

	public abstract CatalogoOficina objetoCatalogoOficina(final String id);
	public abstract CatalogoOficina objetoCatalogoOficinaParaClave(final String clave);
	public abstract List<CatalogoOficina> listaDeCatalogoOficina(final Estado estado);

}