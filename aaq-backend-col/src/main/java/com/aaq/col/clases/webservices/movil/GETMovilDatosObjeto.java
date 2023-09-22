package com.aaq.col.clases.webservices.movil;

public class GETMovilDatosObjeto {
	private String[] bache;
	private String[] malla;
	private String[] objetoFijoOSemimoviente;
	private  String[] terceroCorreoObjeto;
	private  String[] terceroNombreObjeto;
	private  String[] terceroTelefonoObjeto;


	public GETMovilDatosObjeto() {
		super();
	}

	public String[] getBache() {
		return this.bache;
	}

	public String[] getMalla() {
		return this.malla;
	}

	public String[] getObjetoFijoOSemimoviente() {
		return this.objetoFijoOSemimoviente;
	}

	public void setBache(final String[] bache) {
		this.bache = bache;
	}

	public void setMalla(final String[] malla) {
		this.malla = malla;
	}

	public void setObjetoFijoOSemimoviente(final String[] objetoFijoOSemimoviente) {
		this.objetoFijoOSemimoviente = objetoFijoOSemimoviente;
	}

	public String[] getTerceroCorreoObjeto() {
		return terceroCorreoObjeto;
	}

	public void setTerceroCorreoObjeto(final String[] terceroCorreoObjeto) {
		this.terceroCorreoObjeto = terceroCorreoObjeto;
	}

	public String[] getTerceroNombreObjeto() {
		return terceroNombreObjeto;
	}

	public void setTerceroNombreObjeto(final String[] terceroNombreObjeto) {
		this.terceroNombreObjeto = terceroNombreObjeto;
	}

	public String[] getTerceroTelefonoObjeto() {
		return terceroTelefonoObjeto;
	}

	public void setTerceroTelefonoObjeto(final String[] terceroTelefonoObjeto) {
		this.terceroTelefonoObjeto = terceroTelefonoObjeto;
	}
}
