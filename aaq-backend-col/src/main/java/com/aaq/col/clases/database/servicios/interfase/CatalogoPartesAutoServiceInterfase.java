package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoPartesAutoServiceInterfase extends JMServicioGenericoInterfase<CatalogoPartesAuto>{

	public abstract CatalogoPartesAuto objetoCatalogoPartesAuto(String id);
	public abstract List<CatalogoPartesAuto> listaDeCatalogoPartesAuto(final String tipoParte, final String numParte, final String nombreParte);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoPartesAuto t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoPartesAuto t);
	
}
