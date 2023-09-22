package com.aaq.col.clases.webservices.movil.peticion;

import java.util.Date;


public class MovilComunicado {
	private String mensaje;

	private Date inicia;

	private Date termina;

	/**
	 *  Jan 21, 2014 5:26:15 PM
	 */
	public MovilComunicado() {
		super();
	}

	/**
	 *  Jan 21, 2014 5:26:54 PM
	 * 
	 * @param mensaje
	 * @param inicia
	 * @param termina
	 */
	public MovilComunicado(final String mensaje, final Date inicia, final Date termina) {
		super();
		this.mensaje = mensaje;
		this.inicia = inicia;
		this.termina = termina;
	}

	/**
	 *  Jan 21, 2014 5:26:44 PM
	 * 
	 * @return the mensaje
	 */
	public String getMensaje() {
		return this.mensaje;
	}

	/**
	 *  Jan 21, 2014 5:26:44 PM
	 * 
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 *  Jan 21, 2014 5:26:44 PM
	 * 
	 * @return the inicia
	 */
	public Date getInicia() {
		return this.inicia;
	}

	/**
	 *  Jan 21, 2014 5:26:44 PM
	 * 
	 * @param inicia
	 *            the inicia to set
	 */
	public void setInicia(final Date inicia) {
		this.inicia = inicia;
	}

	/**
	 *  Jan 21, 2014 5:26:44 PM
	 * 
	 * @return the termina
	 */
	public Date getTermina() {
		return this.termina;
	}

	/**
	 *  Jan 21, 2014 5:26:44 PM
	 * 
	 * @param termina
	 *            the termina to set
	 */
	public void setTermina(final Date termina) {
		this.termina = termina;
	}

}
