package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FrecuenciaServiceInterfase extends JMServicioGenericoInterfase<Frecuencia> {

	public abstract Frecuencia objetoFrecuencia(String id) ;
	public abstract List<Frecuencia> listaDeFrecuencia(Estado estado) ;
	public abstract JMResultadoOperacion eliminarObjeto(Frecuencia t) ;
	public abstract JMResultadoOperacion guardarObjeto(Frecuencia t) ;
}