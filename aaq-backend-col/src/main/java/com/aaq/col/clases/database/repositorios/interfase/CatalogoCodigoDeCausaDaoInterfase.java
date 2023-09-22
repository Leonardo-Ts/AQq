package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoCodigoDeCausaDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoCodigoDeCausa> {

	public abstract CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausa(String id);
	public abstract CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausaParaClave(String clave);
	public abstract List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa();
	public abstract List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa(Integer idPermitido);

}