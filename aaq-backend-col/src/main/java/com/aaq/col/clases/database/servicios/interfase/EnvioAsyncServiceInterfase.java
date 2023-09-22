package com.aaq.col.clases.database.servicios.interfase;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.pojo.conclusion.ConclusionAjustador;

public interface EnvioAsyncServiceInterfase {

	public void enviarCorreoNuevo(Terminal term, String reporte);
	public abstract void enviarCorreoResumenAjustador(Terminal term , String reporte, boolean equipoPesado);
	public abstract void enviarCorreoDeslindeResponsabilidad(Terminal term , String reporte, String claveAcc);
	public abstract boolean enviarCorreoResumenAjustadorExpres(ConclusionAjustador datosExpres, Terminal terminal , ReporteMovilSac reporteSAC) ;
}
