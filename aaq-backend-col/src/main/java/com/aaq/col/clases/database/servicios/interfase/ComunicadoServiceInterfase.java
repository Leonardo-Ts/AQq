package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Comunicado;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ComunicadoServiceInterfase extends JMServicioGenericoInterfase<Comunicado> {

	public abstract Comunicado objetoComunicado(String id);
	public abstract List<Comunicado> listaDeComunicado(Estado estado, Base base, Terminal terminal,
			final Boolean soloActivos) ;
	public abstract JMResultadoOperacion eliminarObjeto(Comunicado t) ;
	public abstract JMResultadoOperacion guardarObjeto(Comunicado t) ;
}