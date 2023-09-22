package com.aaq.col.clases.webservices.movil;

public class GETMovilDatosRepuve {
	private String averiguacionFecha;

	private String averiguacionNumero;

	private String municipio;

	private String entidadFederativa;

	public GETMovilDatosRepuve() {
		super();
	}

	public String getAveriguacionFecha() {
		return this.averiguacionFecha;
	}

	public String getAveriguacionNumero() {
		return this.averiguacionNumero;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public String getEntidadFederativa() {
		return this.entidadFederativa;
	}

	public void setAveriguacionFecha(final String averiguacionFecha) {
		this.averiguacionFecha = averiguacionFecha;
	}

	public void setAveriguacionNumero(final String averiguacionNumero) {
		this.averiguacionNumero = averiguacionNumero;
	}

	public void setMunicipio(final String municipio) {
		this.municipio = municipio;
	}

	public void setEntidadFederativa(final String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

}
