package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoClaseVehDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoClaseVeh> {

	public abstract CatalogoClaseVeh objetoCatalogoClaseVeh(final String id) ;
	public abstract List<CatalogoClaseVeh> listaDeCatalogoClaseVeh(final String clave, final String descripcion);

	
}
