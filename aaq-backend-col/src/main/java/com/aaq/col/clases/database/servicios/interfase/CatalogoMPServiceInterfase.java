package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMP;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoMPServiceInterfase extends JMServicioGenericoInterfase<CatalogoMP> {

	public abstract CatalogoMP objetoCatalogoMP(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoMP t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoMP t);
	public abstract List<CatalogoMP> listaDeCatalogoMP(String clave, String descripcion) ;

}
