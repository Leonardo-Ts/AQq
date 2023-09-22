 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaPuntoInteres {
	String respuesta;

	PuntoInteres[] puntoInteres;

	public ListaPuntoInteres() {
		super();
	}

	public ListaPuntoInteres(final String respuesta, final PuntoInteres[] puntoInteres) {
		super();
		this.respuesta = respuesta;
		this.puntoInteres = puntoInteres;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public PuntoInteres[] getPuntoInteres() {
		return this.puntoInteres;
	}

	public void setPuntoInteres(final PuntoInteres[] puntoInteres) {
		this.puntoInteres = puntoInteres;
	}

}
