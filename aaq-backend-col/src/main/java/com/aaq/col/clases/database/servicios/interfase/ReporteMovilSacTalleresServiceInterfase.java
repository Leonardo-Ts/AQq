package com.aaq.col.clases.database.servicios.interfase;


import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTalleres;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;

public interface ReporteMovilSacTalleresServiceInterfase extends JMServicioGenericoInterfase<ReporteMovilSacTalleres> {

	public abstract ReporteMovilSacTalleres objetoReporteMovilSacTalleres(final String numeroReporte, final String numeroAjustador) ;
	public abstract List<ReporteMovilSacTalleres> listaDeReporteMovilSacTalleres(final String numeroReporte, final String numeroAjustador) ;

}