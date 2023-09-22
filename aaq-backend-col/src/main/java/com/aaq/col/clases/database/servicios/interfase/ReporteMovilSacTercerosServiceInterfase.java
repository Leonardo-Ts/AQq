package com.aaq.col.clases.database.servicios.interfase;


import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.sac.model.DatosGestionTerceroSac;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteMovilSacTercerosServiceInterfase extends JMServicioGenericoInterfase<ReporteMovilSacTerceros> {

	public abstract ReporteMovilSacTerceros objetoReporteMovilSacTerceros(final String numeroReporte, final String numeroAjustador) ;
	public abstract List<ReporteMovilSacTerceros> listaDeReporteMovilSacTerceros(final String numeroReporte, final String numeroAjustador) ;
	public abstract JMResultadoOperacion guardarTerceros(final String numeroReporte, final String claveProveedor, final String poliza, final DatosGestionTerceroSac dgst) ;
	public abstract JMResultadoOperacion guardarObjeto(ReporteMovilSacTerceros rms) ;
}