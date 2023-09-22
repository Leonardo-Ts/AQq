package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.UsuarioLog;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface UsuarioLogServiceInterfase extends JMServicioGenericoInterfase<UsuarioLog> {

	public abstract UsuarioLog objetoUsuarioLog(String id) ;
	public abstract List<UsuarioLog> listaDeUsuarioLog(Date fechaInicial, Date fechaFinal, boolean validez,
			Integer limite) ;
	public abstract JMResultadoOperacion eliminarObjeto(UsuarioLog t) ;
	public abstract JMResultadoOperacion guardarObjeto(UsuarioLog t) ;
}