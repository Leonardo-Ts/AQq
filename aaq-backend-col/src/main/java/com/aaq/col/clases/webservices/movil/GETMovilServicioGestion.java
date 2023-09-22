package com.aaq.col.clases.webservices.movil;

import com.aaq.col.clases.webservices.movil.peticion.MovilDatosAsegurado;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosObjeto;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosRecupero;
import com.aaq.col.clases.webservices.movil.peticion.MovilDatosTercero;

public class GETMovilServicioGestion {
	
	private String usuario;

	private String passwd;

	private MovilDatosAsegurado datosAsegurado;

	private MovilDatosTercero[] datosTercero;

	private MovilDatosObjeto[] datosObjeto;

	private MovilDatosRecupero[] datosRecupero;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public MovilDatosAsegurado getDatosAsegurado() {
		return datosAsegurado;
	}

	public void setDatosAsegurado(MovilDatosAsegurado datosAsegurado) {
		this.datosAsegurado = datosAsegurado;
	}

	public MovilDatosTercero[] getDatosTercero() {
		return datosTercero;
	}

	public void setDatosTercero(MovilDatosTercero[] datosTercero) {
		this.datosTercero = datosTercero;
	}

	public MovilDatosObjeto[] getDatosObjeto() {
		return datosObjeto;
	}

	public void setDatosObjeto(MovilDatosObjeto[] datosObjeto) {
		this.datosObjeto = datosObjeto;
	}

	public MovilDatosRecupero[] getDatosRecupero() {
		return datosRecupero;
	}

	public void setDatosRecupero(MovilDatosRecupero[] datosRecupero) {
		this.datosRecupero = datosRecupero;
	}

	
}
