package com.aaq.col.clases.webservices.movil.peticion;


public class MovilDatosCobertura {
	private String claveCobertura;

	private double estimacion;
	
	private String claveCoberturaFlexibles;

	public MovilDatosCobertura() {
		super();
	}

	public double getEstimacion() {
		return this.estimacion;
	}

	public void setEstimacion(final double estimacion) {
		this.estimacion = estimacion;
	}

	public String getClaveCobertura() {
		return this.claveCobertura;
	}

	public void setClaveCobertura(final String claveCobertura) {
		this.claveCobertura = claveCobertura;
	}

	public String getClaveCoberturaFlexibles() {
		return claveCoberturaFlexibles;
	}

	public void setClaveCoberturaFlexibles(String claveCoberturaFlexibles) {
		this.claveCoberturaFlexibles = claveCoberturaFlexibles;
	}

}
