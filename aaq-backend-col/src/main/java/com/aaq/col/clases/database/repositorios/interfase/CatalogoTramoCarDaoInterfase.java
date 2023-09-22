package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoTramoCarDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoTramoCar> {
	
	public abstract CatalogoTramoCar objetoCatalogoTramoCar(final String id);
	public abstract List<CatalogoTramoCar> listaDeCatalogoTramoCar(final String clave, final String descripcion);

}
