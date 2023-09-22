package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.sac.model.DatosGestionTerceroSac;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteMovilSacTercerosDaoInterfase extends JMRepositorioGenericoInterfase<ReporteMovilSacTerceros> {

	public abstract ReporteMovilSacTerceros objetoReporteMovilSacTerceros(final String numeroReporte, final String numeroAjustador);
	public abstract List<ReporteMovilSacTerceros> listaDeReporteMovilSacTerceros(final String numeroReporte, final String numeroAjustador);
	public abstract JMResultadoOperacion guardarTerceros(final String numeroReporte, final String claveProveedor, final String poliza, final DatosGestionTerceroSac dgts);
	
}