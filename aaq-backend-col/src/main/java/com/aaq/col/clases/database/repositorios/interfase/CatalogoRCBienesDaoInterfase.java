package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoRCBienes;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoRCBienesDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoRCBienes> {

	public abstract CatalogoRCBienes objetoCatalogoRCBienes(String id);
	public abstract List<CatalogoRCBienes> listaCatalogoRCBienes(final String clave, final String descripcion);

	
}
