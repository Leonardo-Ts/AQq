package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteMovilServiceInterfase extends JMServicioGenericoInterfase<ReporteMovil> {

	public abstract ReporteMovil objetoReporteMovil(final String id) ;
	public abstract List<ReporteMovil> listaDeReporteMovil(Date fechaInicio, Date fechaFin, boolean soloActivos);
	public abstract JMResultadoOperacion eliminarObjeto(ReporteMovil t) ;
	public abstract JMResultadoOperacion guardarObjeto(ReporteMovil t) ;
}