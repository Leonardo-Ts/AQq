package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoRecuperacionesDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoRecuperaciones> {

	public abstract CatalogoRecuperaciones objetoCatalogoRecuperacionesClave(String clave);
	public abstract List<CatalogoRecuperaciones> listaRecuperaciones(final String clave, final String nombre);

}