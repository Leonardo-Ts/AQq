package com.aaq.col.clases.webservices.movil.emergencia;

public class MovilDatosPoliza {
	private String nomAseg;

	private String marca;

	private String modelo;

	private String statusPoliza;

	private String statusCober;

	private String serie;

	private String color;

	private String placas;

	private String fechaInic;

	private String fechaFin;

	private String nomAgte;

	private String telAgte;

	private String poliza;

	private String endoso;

	private String inciso;

	private String informacionConsulta;

	/**
	 * 
	 */
	public MovilDatosPoliza() {
		super();
	}

	/**
	 * @param informacionConsulta
	 */
	public MovilDatosPoliza(String informacionConsulta) {
		this.informacionConsulta = informacionConsulta;
	}

	/**
	 * @param nomAseg
	 * @param marca
	 * @param modelo
	 * @param statusPoliza
	 * @param statusCober
	 * @param serie
	 * @param color
	 * @param placas
	 * @param fechaInic
	 * @param fechaFin
	 * @param nomAgte
	 * @param telAgte
	 * @param poliza
	 * @param endoso
	 * @param inciso
	 * @param informacionConsulta
	 */
	public MovilDatosPoliza(String nomAseg, String marca, String modelo, String statusPoliza, String statusCober,
			String serie, String color, String placas, String fechaInic, String fechaFin, String nomAgte,
			String telAgte, String poliza, String endoso, String inciso, String informacionConsulta) {
		super();
		this.nomAseg = nomAseg;
		this.marca = marca;
		this.modelo = modelo;
		this.statusPoliza = statusPoliza;
		this.statusCober = statusCober;
		this.serie = serie;
		this.color = color;
		this.placas = placas;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.nomAgte = nomAgte;
		this.telAgte = telAgte;
		this.poliza = poliza;
		this.endoso = endoso;
		this.inciso = inciso;
		this.informacionConsulta = informacionConsulta;
	}

	/**
	 * @return the nomAseg
	 */
	public String getNomAseg() {
		return this.nomAseg;
	}

	/**
	 * @param nomAseg
	 *            the nomAseg to set
	 */
	public void setNomAseg(String nomAseg) {
		this.nomAseg = nomAseg;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return this.modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the statusPoliza
	 */
	public String getStatusPoliza() {
		return this.statusPoliza;
	}

	/**
	 * @param statusPoliza
	 *            the statusPoliza to set
	 */
	public void setStatusPoliza(String statusPoliza) {
		this.statusPoliza = statusPoliza;
	}

	/**
	 * @return the statusCober
	 */
	public String getStatusCober() {
		return this.statusCober;
	}

	/**
	 * @param statusCober
	 *            the statusCober to set
	 */
	public void setStatusCober(String statusCober) {
		this.statusCober = statusCober;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return this.serie;
	}

	/**
	 * @param serie
	 *            the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the placas
	 */
	public String getPlacas() {
		return this.placas;
	}

	/**
	 * @param placas
	 *            the placas to set
	 */
	public void setPlacas(String placas) {
		this.placas = placas;
	}

	/**
	 * @return the fechaInic
	 */
	public String getFechaInic() {
		return this.fechaInic;
	}

	/**
	 * @param fechaInic
	 *            the fechaInic to set
	 */
	public void setFechaInic(String fechaInic) {
		this.fechaInic = fechaInic;
	}

	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return this.fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the nomAgte
	 */
	public String getNomAgte() {
		return this.nomAgte;
	}

	/**
	 * @param nomAgte
	 *            the nomAgte to set
	 */
	public void setNomAgte(String nomAgte) {
		this.nomAgte = nomAgte;
	}

	/**
	 * @return the telAgte
	 */
	public String getTelAgte() {
		return this.telAgte;
	}

	/**
	 * @param telAgte
	 *            the telAgte to set
	 */
	public void setTelAgte(String telAgte) {
		this.telAgte = telAgte;
	}

	/**
	 * @return the poliza
	 */
	public String getPoliza() {
		return this.poliza;
	}

	/**
	 * @param poliza
	 *            the poliza to set
	 */
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	/**
	 * @return the endoso
	 */
	public String getEndoso() {
		return this.endoso;
	}

	/**
	 * @param endoso
	 *            the endoso to set
	 */
	public void setEndoso(String endoso) {
		this.endoso = endoso;
	}

	/**
	 * @return the inciso
	 */
	public String getInciso() {
		return this.inciso;
	}

	/**
	 * @param inciso
	 *            the inciso to set
	 */
	public void setInciso(String inciso) {
		this.inciso = inciso;
	}

	/**
	 * Jan 24, 2012
	 * 
	 * @return the informacionConsulta
	 */
	public String getInformacionConsulta() {
		return this.informacionConsulta;
	}

	/**
	 * Jan 24, 2012
	 * 
	 * @param informacionConsulta
	 *            the informacionConsulta to set
	 */
	public void setInformacionConsulta(String informacionConsulta) {
		this.informacionConsulta = informacionConsulta;
	}

}
