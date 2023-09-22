package com.aaq.col.clases.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

public class UtilTiempoCancelar {

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Log4JLogger loggerCancelarReporte = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.cancelarReportes");

	
	public long tiempoDiferenciaSA(Date fechaSA)  {
		long diferencia = 0;
		try {
			synchronized (formatter) {
				long fhServ = System.currentTimeMillis();
				Date date = new Date(fhServ);
				this.loggerCancelarReporte.info("Hora del servidor: "+formatter.format(date)+" - ");
				diferencia = fhServ - fechaSA.getTime();
			}
		} catch (ClassCastException | IndexOutOfBoundsException  | IllegalArgumentException e) {
			this.loggerCancelarReporte.error("Excepcion en tiempoDiferenciaSA-> "+e);
		}
		return diferencia;
	}
}
