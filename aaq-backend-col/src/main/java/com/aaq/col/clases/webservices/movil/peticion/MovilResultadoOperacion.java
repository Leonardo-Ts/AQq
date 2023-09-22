package com.aaq.col.clases.webservices.movil.peticion;

import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

/**
 * @author mfernandez
 * Apr 6, 2011 10:13:29 PM
 */
public class MovilResultadoOperacion {
	private boolean exito;

	private String mensaje;

	private String fecha;

	/**
	 * 
	 */
	public MovilResultadoOperacion() {
		super();
	}

	/**
	 * @param exito
	 * @param mensaje
	 */
	public MovilResultadoOperacion(final boolean exito, final String mensaje) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
	}

	/**
	 * Apr 6, 2011 10:38:22 PM
	 * 
	 * @return the exito
	 */
	public boolean isExito() {
		return this.exito;
	}

	/**
	 * Apr 6, 2011 10:38:22 PM
	 * 
	 * @param exito
	 *            the exito to set
	 */
	public void setExito(final boolean exito) {
		this.exito = exito;
	}

	/**
	 * Apr 6, 2011 10:38:22 PM
	 * 
	 * @return the mensaje
	 */
	public String getMensaje() {
		return this.mensaje;
	}

	/**
	 * Apr 6, 2011 10:38:22 PM
	 * 
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Apr 6, 2011 10:38:23 PM
	 * 
	 * @return the fecha
	 */
	public String getFecha() {
		return this.fecha;
	}

	/**
	 * Apr 6, 2011 10:38:23 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final String fecha) {
		this.fecha = fecha;
	}

}
