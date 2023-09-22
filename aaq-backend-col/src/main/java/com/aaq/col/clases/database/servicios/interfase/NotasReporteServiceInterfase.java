package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.NotasReporte;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface NotasReporteServiceInterfase extends JMServicioGenericoInterfase<NotasReporte> {

	public abstract NotasReporte objetoNotasReporte(final String id);
	public abstract List<NotasReporte> listaDeNotasReporte(Date fechaInicio, Date fechaFin, String reporte, Terminal terminal,
			Estado estado, Base base);
	public abstract JMResultadoOperacion eliminarObjeto(NotasReporte t) ;
	public abstract JMResultadoOperacion guardarObjeto(NotasReporte t) ;
	public abstract List<NotasReporte> listarNotas(Terminal terminal, String reporte);
	
	
	
}