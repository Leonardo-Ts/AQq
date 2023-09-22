 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoTipo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoVehiculoTipoDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoVehiculoTipo> {

	public abstract List<CatalogoVehiculoTipo> listaDeCatalogoVehiculoTipo();
	public abstract CatalogoVehiculoTipo objetoCatalogoVehiculoTipo(String id);
	public abstract CatalogoVehiculoTipo objetoCatalogoVehiculoParaClave(String clave);

}