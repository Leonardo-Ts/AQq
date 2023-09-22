 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoTipoAsistencia;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoTipoAsistenciaDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoTipoAsistencia> {

	public abstract CatalogoTipoAsistencia objetoCatalogoTipoAsistencia(final String id);
	public abstract List<CatalogoTipoAsistencia> listaDeCatalogoTipoAsistencia();

}