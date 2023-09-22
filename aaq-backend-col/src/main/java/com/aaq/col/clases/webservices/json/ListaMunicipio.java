package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nov 5, 2012 6:12:17 PM
 * 
 * @author mfernandez
 */
@XmlRootElement
public class ListaMunicipio {
	String respuesta;

	Municipio[] municipio;

	/**
	 * Jose Miguel Nov 5, 2012 6:12:01 PM
	 */
	public ListaMunicipio() {
		super();
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:42:21 PM
	 * 
	 * @param respuesta
	 * @param municipio
	 */
	public ListaMunicipio(final String respuesta, final Municipio[] municipio) {
		super();
		this.respuesta = respuesta;
		this.municipio = municipio;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:42:13 PM
	 * 
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return this.respuesta;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:42:13 PM
	 * 
	 * @param respuesta
	 *            the respuesta to set
	 */
	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Jose Miguel Jan 16, 2013 12:13:45 PM
	 * 
	 * @return the municipio
	 */
	public Municipio[] getMunicipio() {
		return this.municipio;
	}

	/**
	 * Jose Miguel Jan 16, 2013 12:13:45 PM
	 * 
	 * @param municipio
	 *            the municipio to set
	 */
	public void setMunicipio(final Municipio[] municipio) {
		this.municipio = municipio;
	}

}
