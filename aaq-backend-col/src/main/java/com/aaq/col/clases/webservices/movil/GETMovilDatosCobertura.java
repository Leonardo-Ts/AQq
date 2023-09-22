package com.aaq.col.clases.webservices.movil;

public class GETMovilDatosCobertura {
	private String[] claveCobertura;

	private double[] estimacion;

	public GETMovilDatosCobertura() {
		super();
	}

	public double[] getEstimacion() {
		return this.estimacion;
	}

	public void setEstimacion(final double[] estimacion) {
		this.estimacion = estimacion;
	}

	public String[] getClaveCobertura() {
		return this.claveCobertura;
	}

	public void setClaveCobertura(final String[] claveCobertura) {
		this.claveCobertura = claveCobertura;
	}

}
