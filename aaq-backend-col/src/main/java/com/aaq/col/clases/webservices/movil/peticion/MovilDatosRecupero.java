package com.aaq.col.clases.webservices.movil.peticion;

public class MovilDatosRecupero {
	private String tipoRecupero;

	private String totalDeVales;

	private String ciaAseguradora;

	private String numeroSiniestro;

	private String folioVale;

	private String monto;

	private String descripcionDeMonto;

	private String consecutivoTercero;

	/**
	 * Aug 13, 2013 4:42:28 PM
	 * 
	 * @return the monto
	 */
	public String getMonto() {
		return this.monto;
	}

	/**
	 * Aug 13, 2013 4:42:28 PM
	 * 
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(final String monto) {
		this.monto = monto;
	}

	/**
	 * Aug 13, 2013 4:42:28 PM
	 * 
	 * @return the descripcionDeMonto
	 */
	public String getDescripcionDeMonto() {
		return this.descripcionDeMonto;
	}

	/**
	 * Aug 13, 2013 4:42:28 PM
	 * 
	 * @param descripcionDeMonto
	 *            the descripcionDeMonto to set
	 */
	public void setDescripcionDeMonto(final String descripcionDeMonto) {
		this.descripcionDeMonto = descripcionDeMonto;
	}

	/**
	 * 
	 */
	public MovilDatosRecupero() {
		super();
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @return the tipoRecupero
	 */
	public String getTipoRecupero() {
		return this.tipoRecupero;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @return the totalDeVales
	 */
	public String getTotalDeVales() {
		return this.totalDeVales;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @return the ciaAseguradora
	 */
	public String getCiaAseguradora() {
		return this.ciaAseguradora;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @return the folioVale
	 */
	public String getFolioVale() {
		return this.folioVale;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @param tipoRecupero
	 *            the tipoRecupero to set
	 */
	public void setTipoRecupero(final String tipoRecupero) {
		this.tipoRecupero = tipoRecupero;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @param totalDeVales
	 *            the totalDeVales to set
	 */
	public void setTotalDeVales(final String totalDeVales) {
		this.totalDeVales = totalDeVales;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @param ciaAseguradora
	 *            the ciaAseguradora to set
	 */
	public void setCiaAseguradora(final String ciaAseguradora) {
		this.ciaAseguradora = ciaAseguradora;
	}

	/**
	 * Apr 6, 2011 10:23:27 PM
	 * 
	 * @param folioVale
	 *            the folioVale to set
	 */
	public void setFolioVale(final String folioVale) {
		this.folioVale = folioVale;
	}

	/**
	 * Jose Miguel Jun 27, 2011 10:20:07 AM
	 * 
	 * @return the numeroSiniestro
	 */
	public String getNumeroSiniestro() {
		return this.numeroSiniestro;
	}

	/**
	 * Jose Miguel Jun 27, 2011 10:20:07 AM
	 * 
	 * @param numeroSiniestro
	 *            the numeroSiniestro to set
	 */
	public void setNumeroSiniestro(final String numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the consecutivoTercero
	 */
	public String getConsecutivoTercero() {
		return consecutivoTercero;
	}

	/**
	 * @author Arturo de la Cruz
	 * @param consecutivoTercero
	 *            the consecutivoTercero to set
	 */
	public void setConsecutivoTercero(String consecutivoTercero) {
		this.consecutivoTercero = consecutivoTercero;
	}

}
