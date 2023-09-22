package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface ReporteMovilSacGruasDaoInterfase extends JMRepositorioGenericoInterfase<ReporteMovilSacGruas> {

	public abstract ReporteMovilSacGruas objetoReporteMovilSacGruas(final String numeroReporte, final String numeroAjustador);
	public abstract List<ReporteMovilSacGruas> listaDeReporteMovilSacGruas(final String numeroReporte, final String numeroAjustador);
	public abstract List<ReporteMovilSacGruas> listaDeReporteMovilSacGruasC(String numeroReporte, String numeroAjustador, String  tipoAfectado);
}