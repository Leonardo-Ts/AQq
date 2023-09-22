package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoVehTercDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoVehTerc> {

	public abstract CatalogoVehTerc objetoCatalogoVehTerc(String id);
	public abstract List<CatalogoVehTerc> listaDeCatalogoVehTerc(final String clave, final String descripcion);

}
