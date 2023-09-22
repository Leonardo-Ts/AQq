package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Geocerca {
	private String estado;

	private String nombre;

	private String descripcion;

	private String color;

	private String[][] puntosLatLng;

	/**
	 * Jose Miguel Nov 5, 2012 9:40:40 PM
	 */
	public Geocerca() {
		super();
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:40:36 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 * @param nombre
	 * @param descripcion
	 * @param color
	 * @param puntosLatLng
	 */
	public Geocerca(final String estado, final String nombre, final String descripcion, final String color,
			final String[][] puntosLatLng) {
		super();
		this.estado = estado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.color = color;
		this.puntosLatLng = puntosLatLng;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:15:11 PM
	 * 
	 * @return the estado
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:15:11 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final String estado) {
		this.estado = estado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:15:11 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:15:11 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:15:11 PM
	 * 
	 * @return the puntosLatLng
	 */
	public String[][] getPuntosLatLng() {
		return this.puntosLatLng;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:15:11 PM
	 * 
	 * @param puntosLatLng
	 *            the puntosLatLng to set
	 */
	public void setPuntosLatLng(final String[][] puntosLatLng) {
		this.puntosLatLng = puntosLatLng;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:40:28 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:40:28 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:40:28 PM
	 * 
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Jose Miguel Nov 5, 2012 9:40:28 PM
	 * 
	 * @param color
	 *            the color to set
	 */
	public void setColor(final String color) {
		this.color = color;
	}

}
