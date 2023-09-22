package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Municipio {
	private String nombre;

	private String claveEntidad;

	public Municipio() {
		super();

	}

	public Municipio(final String nombre, final String claveEntidad) {
		super();
		this.nombre = nombre;
		this.claveEntidad = claveEntidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getClaveEntidad() {
		return this.claveEntidad;
	}

	public void setClaveEntidad(final String claveEntidad) {
		this.claveEntidad = claveEntidad;
	}

}
