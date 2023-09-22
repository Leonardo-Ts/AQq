package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoUso;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoVehiculoUsoDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoVehiculoUso> {

	public abstract List<CatalogoVehiculoUso> listaDeCatalogoVehiculoUso();
	public abstract CatalogoVehiculoUso objetoCatalogoVehiculoUso(String id);
	public abstract CatalogoVehiculoUso objetoCatalogoVehiculoUsoParaClave(String clave);

}