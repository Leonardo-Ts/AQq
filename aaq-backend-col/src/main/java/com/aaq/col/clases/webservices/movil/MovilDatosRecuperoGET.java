package com.aaq.col.clases.webservices.movil;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Elemento Agregado
public class MovilDatosRecuperoGET {
	private String tipoRecupero;

	private String totalDeVales;

	private String ciaAseguradora;

	private String numeroSiniestro;

	private String folioVale;

	private String monto;

	private String descripcionDeMonto;

	public String getTipoRecupero() {
		return tipoRecupero;
	}

	public void setTipoRecupero(String tipoRecupero) {
		this.tipoRecupero = tipoRecupero;
	}

	public String getTotalDeVales() {
		return totalDeVales;
	}

	public void setTotalDeVales(String totalDeVales) {
		this.totalDeVales = totalDeVales;
	}

	public String getCiaAseguradora() {
		return ciaAseguradora;
	}

	public void setCiaAseguradora(String ciaAseguradora) {
		this.ciaAseguradora = ciaAseguradora;
	}

	public String getNumeroSiniestro() {
		return numeroSiniestro;
	}

	public void setNumeroSiniestro(String numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String getFolioVale() {
		return folioVale;
	}

	public void setFolioVale(String folioVale) {
		this.folioVale = folioVale;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getDescripcionDeMonto() {
		return descripcionDeMonto;
	}

	public void setDescripcionDeMonto(String descripcionDeMonto) {
		this.descripcionDeMonto = descripcionDeMonto;
	}

}
