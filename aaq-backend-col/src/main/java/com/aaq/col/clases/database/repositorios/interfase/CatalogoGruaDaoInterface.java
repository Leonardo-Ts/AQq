package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoGruaDaoInterface extends JMRepositorioGenericoInterfase<CatalogoGrua>{

	public abstract CatalogoGrua objetoCatalogoGrua(final String id) ;
	public abstract List<CatalogoGrua> listaDeCatalogoGrua(final String clave, final String descripcion, final String codigo);

}
