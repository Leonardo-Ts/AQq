 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Carretera;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface CarreteraServiceInterfase extends JMServicioGenericoInterfase<Carretera> {

	public abstract Carretera objetoCarretera(String id);
	public abstract List<Carretera> listaDeCarretera(Estado estado, String nombre);
	public abstract JMResultadoOperacion eliminarObjeto(Carretera t) ;
	public abstract JMResultadoOperacion guardarObjeto(Carretera t);
}