package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioCoberturaEstimacion {
	private String usuario;

	private String passwd;

	private String reporte;

	private MovilDatosCobertura[] datosCobertura;

	public MovilServicioCoberturaEstimacion() {
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

	public MovilDatosCobertura[] getDatosCobertura() {
		return datosCobertura;
	}

	public void setDatosCobertura(MovilDatosCobertura[] datosCobertura) {
		this.datosCobertura = datosCobertura;
	}

	
}
