package com.aaq.col.clases.webservices.movil;

public class GETMovilDatosDocumentoIntercambio {
	private String[] claveDocumento;

	private String[] nombreDocumento;

	private String[] cantidadVales;

	private String[] aseguradoras;

	private String[] numeroSiniestro;

	private String[] folioVale;

	private Boolean[] proveeDocumento;

	/**
	 * 
	 */
	public GETMovilDatosDocumentoIntercambio() {
		super();
	}

	public String[] getClaveDocumento() {
		return this.claveDocumento;
	}

	public void setClaveDocumento(final String[] claveDocumento) {
		this.claveDocumento = claveDocumento;
	}

	public String[] getNombreDocumento() {
		return this.nombreDocumento;
	}

	public void setNombreDocumento(final String[] nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	
	public String[] getCantidadVales() {
		return this.cantidadVales;
	}

	public void setCantidadVales(final String[] cantidadVales) {
		this.cantidadVales = cantidadVales;
	}

	public String[] getAseguradoras() {
		return this.aseguradoras;
	}

	public void setAseguradoras(final String[] aseguradoras) {
		this.aseguradoras = aseguradoras;
	}

	public String[] getNumeroSiniestro() {
		return this.numeroSiniestro;
	}

	public void setNumeroSiniestro(final String[] numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String[] getFolioVale() {
		return this.folioVale;
	}

	public void setFolioVale(final String[] folioVale) {
		this.folioVale = folioVale;
	}

	public Boolean[] getProveeDocumento() {
		return this.proveeDocumento;
	}

	public void setProveeDocumento(final Boolean[] proveeDocumento) {
		this.proveeDocumento = proveeDocumento;
	}

}
