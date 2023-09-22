package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface ReporteMovilDaoInterfase extends JMRepositorioGenericoInterfase<ReporteMovil> {

	public abstract ReporteMovil objetoReporteMovil(final String id);
	public abstract List<ReporteMovil> listaDeReporteMovil(Date fechaInicio, Date fechaFin, boolean soloActivos);

}