 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaIcono {
	String respuesta;

	Icono[] icono;

	public ListaIcono() {
		super();
	}

	public ListaIcono(final String respuesta, final Icono[] icono) {
		super();
		this.respuesta = respuesta;
		this.icono = icono;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public Icono[] getIcono() {
		return this.icono;
	}

	public void setIcono(final Icono[] icono) {
		this.icono = icono;
	}

}
