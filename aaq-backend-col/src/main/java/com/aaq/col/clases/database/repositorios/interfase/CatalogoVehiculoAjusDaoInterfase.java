package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoAjus;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoVehiculoAjusDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoVehiculoAjus> {

	public abstract CatalogoVehiculoAjus objetoCatalogoVehiculoAjus(final String id);
	public abstract List<CatalogoVehiculoAjus> listaDeCatalogoVehiculoAjus();
}
