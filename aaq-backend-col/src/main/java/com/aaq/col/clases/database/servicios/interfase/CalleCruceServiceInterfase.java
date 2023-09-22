package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CalleCruce;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CalleCruceServiceInterfase extends JMServicioGenericoInterfase<CalleCruce> {

	public abstract CalleCruce objetoCalleCruce(String id) ;
	public abstract List<CalleCruce> listaDeCalleCruce(Estado estado, String idmunicipio, String idcolonia,
			String nombrecalleUno, String nombrecalleDos) ;
	public abstract JMResultadoOperacion eliminarObjeto(CalleCruce t) ;
	public abstract JMResultadoOperacion guardarObjeto(CalleCruce t) ;
}