 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estado {
	private String id;

	private String nombre;

	/**
	 * Jose Miguel Nov 5, 2012 6:10:14 PM
	 */
	public Estado() {
		super();

	}

	/**
	 * Jose Miguel Nov 5, 2012 6:10:19 PM
	 * 
	 * @param id
	 * @param nombre
	 */
	public Estado(final String id, final String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 6:01:16 PM
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Jose Miguel Nov 5, 2012 6:01:16 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Jose Miguel Nov 5, 2012 6:01:16 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 6:01:16 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
