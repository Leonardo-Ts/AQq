package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoPartesAutoDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoPartesAuto> {

	public abstract CatalogoPartesAuto objetoCatalogoPartesAuto(final String id) ;
	public abstract List<CatalogoPartesAuto> listaDeCatalogoPartesAuto(final String tipoParte, final String numParte, final String nombreParte);
}
