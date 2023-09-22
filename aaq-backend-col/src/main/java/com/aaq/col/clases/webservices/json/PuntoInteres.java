package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PuntoInteres {
	private String estado;

	private String latitud;

	private String lontigud;

	private String icono;

	private String nombre;

	private String descripcion;

	public PuntoInteres() {
		super();

	}

	public PuntoInteres(final String estado, final String latitud, final String lontigud, final String icono,
			final String nombre, final String descripcion) {
		super();
		this.estado = estado;
		this.latitud = latitud;
		this.lontigud = lontigud;
		this.icono = icono;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	public String getLontigud() {
		return this.lontigud;
	}

	public void setLontigud(final String lontigud) {
		this.lontigud = lontigud;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(final String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

}
