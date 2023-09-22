package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultadoOperacion {
	private String resultado;

	public ResultadoOperacion() {
		super();
	}

	public ResultadoOperacion(final String resultado) {
		super();
		this.resultado = resultado;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(final String resultado) {
		this.resultado = resultado;
	}

}
