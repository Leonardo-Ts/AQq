package com.aaq.col.clases.webservices.movil;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Elemento Agregado
public class MovilDatosObjetoGET {
	private String bache;
	private String malla;
	private String objetoFijoOSemimoviente;
	private  String terceroCorreoObjeto;
	private  String terceroNombreObjeto;
	private  String terceroTelefonoObjeto;

	public MovilDatosObjetoGET() {
		super();
	}

	public String getBache() {
		return bache;
	}

	public void setBache(String bache) {
		this.bache = bache;
	}

	public String getMalla() {
		return malla;
	}

	public void setMalla(String malla) {
		this.malla = malla;
	}

	public String getObjetoFijoOSemimoviente() {
		return objetoFijoOSemimoviente;
	}

	public void setObjetoFijoOSemimoviente(String objetoFijoOSemimoviente) {
		this.objetoFijoOSemimoviente = objetoFijoOSemimoviente;
	}

	public String getTerceroCorreoObjeto() {
		return terceroCorreoObjeto;
	}

	public void setTerceroCorreoObjeto(String terceroCorreoObjeto) {
		this.terceroCorreoObjeto = terceroCorreoObjeto;
	}

	public String getTerceroNombreObjeto() {
		return terceroNombreObjeto;
	}

	public void setTerceroNombreObjeto(String terceroNombreObjeto) {
		this.terceroNombreObjeto = terceroNombreObjeto;
	}

	public String getTerceroTelefonoObjeto() {
		return terceroTelefonoObjeto;
	}

	public void setTerceroTelefonoObjeto(String terceroTelefonoObjeto) {
		this.terceroTelefonoObjeto = terceroTelefonoObjeto;
	}

}
