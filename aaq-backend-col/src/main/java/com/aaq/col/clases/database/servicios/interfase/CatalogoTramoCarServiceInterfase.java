package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoTramoCarServiceInterfase extends JMServicioGenericoInterfase<CatalogoTramoCar>{

	public abstract CatalogoTramoCar objetoCatalogoTramoCar(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoTramoCar t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoTramoCar t);
	public abstract List<CatalogoTramoCar> listaDeCatalogoTramoCar(String clave, String descripcion) ;

}
