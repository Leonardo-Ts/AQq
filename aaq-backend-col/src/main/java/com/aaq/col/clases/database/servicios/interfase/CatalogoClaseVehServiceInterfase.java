package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoClaseVehServiceInterfase extends JMServicioGenericoInterfase<CatalogoClaseVeh> {

	public abstract CatalogoClaseVeh objetoCatalogoClaseVeh(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoClaseVeh t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoClaseVeh t);
	public abstract List<CatalogoClaseVeh> listaDeCatalogoClaseVeh(String clave, String descripcion) ;
}
