 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaBase {
	String respuesta;

	Base[] base;

	public ListaBase() {
		super();
	}

	public ListaBase(final String respuesta, final Base[] base) {
		super();
		this.respuesta = respuesta;
		this.base = base;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public Base[] getBase() {
		return this.base;
	}

	public void setBase(final Base[] base) {
		this.base = base;
	}

}
