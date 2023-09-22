package com.aaq.col.clases.database.servicios.interfase;


import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteMovilSacGruasServiceInterfase extends JMServicioGenericoInterfase<ReporteMovilSacGruas> {

	public abstract ReporteMovilSacGruas objetoReporteMovilSacGruas(final String numeroReporte, final String numeroAjustador) ;
	public abstract List<ReporteMovilSacGruas> listaDeReporteMovilSacGruas(final String numeroReporte, final String numeroAjustador) ;
	public abstract List<ReporteMovilSacGruas> listaDeReporteMovilSacGruasC(final String numeroReporte, final String numeroAjustador,
			final String tipoAfectado) ;
	public abstract JMResultadoOperacion guardarObjeto(ReporteMovilSacGruas reporteMovilSacGruas) ;


}