package com.aaq.col.clases.webservices.movil;

public class GETMovilDatosRobo {
	private String localizadoEn;

	private String fecha;

	private String telefono;

	private String dependencia;

	public GETMovilDatosRobo() {
		super();
	}

	public String getLocalizadoEn() {
		return this.localizadoEn;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getDependencia() {
		return this.dependencia;
	}

	public void setLocalizadoEn(final String localizadoEn) {
		this.localizadoEn = localizadoEn;
	}

	public void setFecha(final String fecha) {
		this.fecha = fecha;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public void setDependencia(final String dependencia) {
		this.dependencia = dependencia;
	}

}
