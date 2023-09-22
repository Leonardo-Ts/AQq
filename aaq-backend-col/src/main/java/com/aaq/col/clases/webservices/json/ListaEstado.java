package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaEstado {
	String respuesta;

	Estado[] estado;

	public ListaEstado() {
		super();
	}

	public ListaEstado(final String respuesta, final Estado[] estado) {
		super();
		this.respuesta = respuesta;
		this.estado = estado;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public Estado[] getEstado() {
		return this.estado;
	}

	public void setEstado(final Estado[] estado) {
		this.estado = estado;
	}

}
