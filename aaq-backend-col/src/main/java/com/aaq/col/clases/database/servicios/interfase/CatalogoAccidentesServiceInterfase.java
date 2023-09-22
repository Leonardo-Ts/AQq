package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoAccidentesServiceInterfase extends JMServicioGenericoInterfase<CatalogoAccidentes>{

	public abstract CatalogoAccidentes objetoCatalogoAccidentesClave(String clave) ;
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoAccidentes t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoAccidentes t);
	public abstract List<CatalogoAccidentes> listaDeCatalogoAccidentes(String clave, String descripcion, String codigo) ;

}
