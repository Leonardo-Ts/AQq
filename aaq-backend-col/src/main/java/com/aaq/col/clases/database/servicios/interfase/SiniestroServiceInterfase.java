 package com.aaq.col.clases.database.servicios.interfase;

import com.aaq.col.clases.database.entidades.Siniestro;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface SiniestroServiceInterfase extends JMServicioGenericoInterfase<Siniestro> {

	public abstract Siniestro objetoSiniestro(final String id) ;
	public abstract Siniestro objetoSiniestro(String numeroReporte, String identificadorUnico) ;
	public abstract JMResultadoOperacion eliminarObjeto(Siniestro t) ;
	public abstract JMResultadoOperacion guardarObjeto(Siniestro t) ;
}