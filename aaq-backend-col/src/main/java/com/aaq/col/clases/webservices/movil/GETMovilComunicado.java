package com.aaq.col.clases.webservices.movil;

import java.util.Date;

public class GETMovilComunicado {
	private String mensaje;

	private Date inicia;

	private Date termina;

	public GETMovilComunicado() {
		super();
	}

	public GETMovilComunicado(final String mensaje, final Date inicia, final Date termina) {
		super();
		this.mensaje = mensaje;
		this.inicia = inicia;
		this.termina = termina;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getInicia() {
		return this.inicia;
	}

	public void setInicia(final Date inicia) {
		this.inicia = inicia;
	}

	public Date getTermina() {
		return this.termina;
	}

	public void setTermina(final Date termina) {
		this.termina = termina;
	}

}
