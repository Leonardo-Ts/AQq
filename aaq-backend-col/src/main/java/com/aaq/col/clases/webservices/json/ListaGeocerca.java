 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaGeocerca {
	String respuesta;

	Geocerca[] geocerca;

	public ListaGeocerca() {
		super();
	}
	public ListaGeocerca(final String respuesta, final Geocerca[] geocerca) {
		super();
		this.respuesta = respuesta;
		this.geocerca = geocerca;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public Geocerca[] getGeocerca() {
		return this.geocerca;
	}

	public void setGeocerca(final Geocerca[] geocerca) {
		this.geocerca = geocerca;
	}

}
