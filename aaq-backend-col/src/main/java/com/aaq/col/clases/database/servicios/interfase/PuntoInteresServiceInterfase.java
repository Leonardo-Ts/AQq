package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface PuntoInteresServiceInterfase extends JMServicioGenericoInterfase<PuntoInteres> {

	public abstract PuntoInteres objetoPuntoInteres(final String id) ;
	public abstract List<PuntoInteres> listaDePuntoInteres(final Estado estado, final List<PuntoInteresTipo> tipo);
	public abstract JMResultadoOperacion eliminarObjeto(PuntoInteres t) ;
	public abstract JMResultadoOperacion guardarObjeto(PuntoInteres t) ;
}