package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarcaTerc;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoMarcaTercServiceInterfase extends JMServicioGenericoInterfase<CatalogoMarcaTerc>{

	public abstract CatalogoMarcaTerc objetoCatalogoMarcaTerc(String id);
	public abstract List<CatalogoMarcaTerc> listaDeCatalogoMarcaTerc(String clave, String descripcion);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoMarcaTerc t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoMarcaTerc t);
}
