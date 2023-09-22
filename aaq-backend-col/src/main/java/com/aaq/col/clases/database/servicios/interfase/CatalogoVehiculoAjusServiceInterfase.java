package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoAjus;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoVehiculoAjusServiceInterfase extends JMServicioGenericoInterfase<CatalogoVehiculoAjus> {

	public abstract CatalogoVehiculoAjus objetoCatalogoVehiculoAjus(final String id);
	public abstract List<CatalogoVehiculoAjus> listaDeCatalogoVehiculoAjus();
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoVehiculoAjus t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoVehiculoAjus t) ;
}
