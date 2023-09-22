 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Colonia;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface ColoniaServiceInterfase extends JMServicioGenericoInterfase<Colonia> {

	public abstract Colonia objetoColonia(final String id) ;
	public abstract Colonia objetoColonia(final String idcolonia, String idmunicipio) ;
	public abstract List<Colonia> listaDeColonia(final Estado estado, final String idmunicipio) ;
	public abstract JMResultadoOperacion eliminarObjeto(Colonia t) ;
	public abstract JMResultadoOperacion guardarObjeto(Colonia t) ;
}