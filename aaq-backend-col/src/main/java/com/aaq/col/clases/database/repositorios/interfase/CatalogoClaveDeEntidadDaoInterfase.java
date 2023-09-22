 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoClaveDeEntidad;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoClaveDeEntidadDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoClaveDeEntidad> {

	public abstract CatalogoClaveDeEntidad objetoCatalogoClaveDeEntidad(String id);
	public abstract List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad();
	public abstract List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad(String llave, boolean soloConLlave);

}