package com.aaq.col.clases.webservices.movil;

public class GETMovilDatosRecupero {
	private String[] tipoRecupero;

	private String[] totalDeVales;

	private String[] ciaAseguradora;

	private String[] numeroSiniestro;

	private String[] folioVale;

	private String[] monto;

	private String[] descripcionDeMonto;
	
	public GETMovilDatosRecupero() {
		super();
	}

	public String[] getMonto() {
		return this.monto;
	}

	public void setMonto(final String[] monto) {
		this.monto = monto;
	}

	public String[] getDescripcionDeMonto() {
		return this.descripcionDeMonto;
	}

	public void setDescripcionDeMonto(final String[] descripcionDeMonto) {
		this.descripcionDeMonto = descripcionDeMonto;
	}

	public String[] getTipoRecupero() {
		return this.tipoRecupero;
	}

	public String[] getTotalDeVales() {
		return this.totalDeVales;
	}

	public String[] getCiaAseguradora() {
		return this.ciaAseguradora;
	}

	public String[] getFolioVale() {
		return this.folioVale;
	}

	public void setTipoRecupero(final String[] tipoRecupero) {
		this.tipoRecupero = tipoRecupero;
	}

	public void setTotalDeVales(final String[] totalDeVales) {
		this.totalDeVales = totalDeVales;
	}

	public void setCiaAseguradora(final String[] ciaAseguradora) {
		this.ciaAseguradora = ciaAseguradora;
	}

	public void setFolioVale(final String[] folioVale) {
		this.folioVale = folioVale;
	}

	public String[] getNumeroSiniestro() {
		return this.numeroSiniestro;
	}

	public void setNumeroSiniestro(final String[] numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

}
