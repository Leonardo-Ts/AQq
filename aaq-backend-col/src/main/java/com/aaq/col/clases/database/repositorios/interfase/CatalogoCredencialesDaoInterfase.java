package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoCredencialesDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoCredenciales> {
	
	public abstract CatalogoCredenciales objetoCatalogoCredenciales(String id);
	public abstract List<CatalogoCredenciales> listaDeCatalogoCredenciales(final String nombre, final String url, final String usuario, final String pwd);


}
