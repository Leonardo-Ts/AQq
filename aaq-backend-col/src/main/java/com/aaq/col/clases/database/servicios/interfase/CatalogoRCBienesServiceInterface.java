package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoRCBienes;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoRCBienesServiceInterface  extends JMServicioGenericoInterfase<CatalogoRCBienes>{

	public abstract CatalogoRCBienes objetoCatalogoRCBienesClave(String id);
	public abstract List<CatalogoRCBienes> listaCatalogoRCBienes(String clave, String descripcion);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoRCBienes t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoRCBienes t);

	
}
