 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Session;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface SessionServiceInterfase extends JMServicioGenericoInterfase<Session> {

	public abstract Session objetoSession(String id) ;
	public abstract Session objetoSessionParaIdentificador(String id) ;
	public abstract List<Session> listaDeSession() ;
	public abstract JMResultadoOperacion eliminarObjeto(Session t) ;
	public abstract JMResultadoOperacion guardarObjeto(Session t) ;
}