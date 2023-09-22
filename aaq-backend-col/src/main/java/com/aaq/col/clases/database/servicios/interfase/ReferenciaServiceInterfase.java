 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Referencia;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReferenciaServiceInterfase extends JMServicioGenericoInterfase<Referencia> {

	public abstract Referencia objetoReferencia(String id) ;
	public abstract List<Referencia> listaDeReferencia(Estado estado, String nombre) ;
	public abstract JMResultadoOperacion eliminarObjeto(Referencia t) ;
	public abstract JMResultadoOperacion guardarObjeto(Referencia t) ;
}