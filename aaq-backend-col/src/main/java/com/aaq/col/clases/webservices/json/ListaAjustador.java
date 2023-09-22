package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaAjustador {
	String respuesta;

	Ajustador[] ajustador;

	public ListaAjustador() {
		super();
	}

	public ListaAjustador(final String respuesta, final Ajustador[] ajustador) {
		super();
		this.respuesta = respuesta;
		this.ajustador = ajustador;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public Ajustador[] getAjustador() {
		return this.ajustador;
	}
	public void setAjustador(final Ajustador[] ajustador) {
		this.ajustador = ajustador;
	}

}
