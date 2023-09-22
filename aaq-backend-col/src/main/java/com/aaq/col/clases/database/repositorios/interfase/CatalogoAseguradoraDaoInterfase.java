package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoAseguradoraDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoAseguradora> {

	public abstract CatalogoAseguradora objetoCatalogoAseguradora(String id);
	public abstract List<CatalogoAseguradora> listaCatalogoAseguradora(String clave, String descripcion);
	public abstract CatalogoAseguradora objetoCatalogoAseguradoraClave(String clave) ;

}