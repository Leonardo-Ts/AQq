package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface PuntoInteresTipoServiceInterfase extends JMServicioGenericoInterfase<PuntoInteresTipo> {

	public abstract PuntoInteresTipo objetoPuntoInteresTipo(String id) ;
	public abstract PuntoInteresTipo objetoPuntoInteresTipoParaNombre(String nombre) ;
	public abstract List<PuntoInteresTipo> listaDePuntoInteresTipo() ;
	public abstract List<PuntoInteresTipo> listaDePuntoInteresTipo(String idPermitido, String idNoPermitido);
	public abstract JMResultadoOperacion eliminarObjeto(PuntoInteresTipo t) ;
	public abstract JMResultadoOperacion guardarObjeto(PuntoInteresTipo t) ;
}