package com.aaq.col.clases.webservices.movil;

public class GETMovilServicioCoberturaEstimacion {
	private String usuario;

	private String passwd;

	private String reporte;

	private GETMovilDatosCobertura datosCobertura;

	public GETMovilServicioCoberturaEstimacion() {
		super();
	}

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

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public GETMovilDatosCobertura getDatosCobertura() {
		return datosCobertura;
	}

	public void setDatosCobertura(GETMovilDatosCobertura datosCobertura) {
		this.datosCobertura = datosCobertura;
	}

	
}
