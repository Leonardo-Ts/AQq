package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoCodigoDeCausaServiceInterfase extends JMServicioGenericoInterfase<CatalogoCodigoDeCausa> {

	public abstract CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausa(String id) ;
	public abstract CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausaParaClave(String clave);
	public abstract List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa();
	public abstract List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa(Integer idPermitido);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoCodigoDeCausa t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoCodigoDeCausa t);
}