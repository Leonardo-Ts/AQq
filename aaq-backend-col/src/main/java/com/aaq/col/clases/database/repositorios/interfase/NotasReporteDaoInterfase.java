package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.NotasReporte;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface NotasReporteDaoInterfase extends JMRepositorioGenericoInterfase<NotasReporte> {

	public abstract NotasReporte objetoNotasReporte(String id) ;
	public abstract List<NotasReporte> listaDeNotasReportes(Date fechaInicio, Date fechaFin, String reporte, Terminal terminal, Estado estado, Base base);
	public abstract List<NotasReporte> listarNotas(Terminal terminal, String reporte);
}
