package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTalleres;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface ReporteMovilSacTalleresDaoInterfase extends JMRepositorioGenericoInterfase<ReporteMovilSacTalleres> {

	public abstract ReporteMovilSacTalleres objetoReporteMovilSacTalleres(final String numeroReporte, final String numeroAjustador);
	public abstract List<ReporteMovilSacTalleres> listaDeReporteMovilSacTalleres(final String numeroReporte, final String numeroAjustador);
}