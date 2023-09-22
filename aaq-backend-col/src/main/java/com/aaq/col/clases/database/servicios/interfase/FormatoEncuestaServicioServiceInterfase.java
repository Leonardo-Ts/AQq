package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoEncuestaServicio;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoEncuestaServicioServiceInterfase extends JMServicioGenericoInterfase<FormatoEncuestaServicio> {

	
	public abstract FormatoEncuestaServicio objetoFormatoEncuestaServicio(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoEncuestaServicio t);
	public abstract List<FormatoEncuestaServicio> listaDeFormatoEncuestaServicio();
	public abstract String ejecutarFuncionInsertarEncuestaServicio(String esTelConductor, Integer esId,
			String esNumSiniestro, String esNumReporte, String esNomAsegurado,
			String esLugar, String esClaveAjustador, Integer esPregunta8, Integer esPregunta9, Integer esPregunta6,
			String esNomConductor, Integer esPregunta7, Integer esPregunta4, Integer esPregunta5, Integer esPregunta2,
			Integer esPregunta3, Integer esPregunta1, String esNumInciso, String esNumPoliza, String esAsegurado,
			Date esFecha, Integer esPregunta10, String esObservaciones, String esEmailConductor,
			Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAsegurado
	);
	public abstract int obtenerConsecutivo(String reporte);

}