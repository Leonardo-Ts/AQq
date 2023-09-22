 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Icono {
	private String nombre;

	private String descripcion;

	private String url;

	/**
	 * Jose Miguel Nov 5, 2012 8:59:41 PM
	 */
	public Icono() {
		super();
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:44 PM
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param url
	 */
	public Icono(final String nombre, final String descripcion, final String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:53 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:53 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:53 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:53 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:53 PM
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:59:53 PM
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

}
