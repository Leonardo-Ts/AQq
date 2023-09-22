package com.aaq.col.clases.webservices.movil;

public class GETMovilReporteSiseTercero {
	private String id;

	private String vehMarca;

	private String vehTipo;

	private String vehAnoModelo;

	private String vehPlaca;

	private String vehSerie;

	private String vehColor;

	private String vehConductor;

	private String telefonoContacto;

	private String ciaAsegurador;

	private String numeroPoliza;

	private String golpePorGolpe;

	public GETMovilReporteSiseTercero() {
		super();
	}

	public GETMovilReporteSiseTercero(final String id, final String vehMarca, final String vehTipo,
			final String vehAnoModelo, final String vehPlaca, final String vehSerie, final String vehColor,
			final String vehConductor, final String telefonoContacto, final String ciaAsegurador,
			final String numeroPoliza, final String golpePorGolpe) {
		super();
		this.id = id;
		this.vehMarca = vehMarca;
		this.vehTipo = vehTipo;
		this.vehAnoModelo = vehAnoModelo;
		this.vehPlaca = vehPlaca;
		this.vehSerie = vehSerie;
		this.vehColor = vehColor;
		this.vehConductor = vehConductor;
		this.telefonoContacto = telefonoContacto;
		this.ciaAsegurador = ciaAsegurador;
		this.numeroPoliza = numeroPoliza;
		this.golpePorGolpe = golpePorGolpe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehMarca() {
		return vehMarca;
	}

	public void setVehMarca(String vehMarca) {
		this.vehMarca = vehMarca;
	}

	public String getVehTipo() {
		return vehTipo;
	}

	public void setVehTipo(String vehTipo) {
		this.vehTipo = vehTipo;
	}

	public String getVehAnoModelo() {
		return vehAnoModelo;
	}

	public void setVehAnoModelo(String vehAnoModelo) {
		this.vehAnoModelo = vehAnoModelo;
	}

	public String getVehPlaca() {
		return vehPlaca;
	}

	public void setVehPlaca(String vehPlaca) {
		this.vehPlaca = vehPlaca;
	}

	public String getVehSerie() {
		return vehSerie;
	}

	public void setVehSerie(String vehSerie) {
		this.vehSerie = vehSerie;
	}

	public String getVehColor() {
		return vehColor;
	}

	public void setVehColor(String vehColor) {
		this.vehColor = vehColor;
	}

	public String getVehConductor() {
		return vehConductor;
	}

	public void setVehConductor(String vehConductor) {
		this.vehConductor = vehConductor;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getCiaAsegurador() {
		return ciaAsegurador;
	}

	public void setCiaAsegurador(String ciaAsegurador) {
		this.ciaAsegurador = ciaAsegurador;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getGolpePorGolpe() {
		return golpePorGolpe;
	}

	public void setGolpePorGolpe(String golpePorGolpe) {
		this.golpePorGolpe = golpePorGolpe;
	}


}
