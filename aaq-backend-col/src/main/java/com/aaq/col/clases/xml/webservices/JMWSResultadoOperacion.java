package com.aaq.col.clases.xml.webservices;

public class JMWSResultadoOperacion {

	private boolean esOperacionExitosa;

	private String detalleOperacion;

	public JMWSResultadoOperacion() {
		super();
	}

	public JMWSResultadoOperacion(boolean esOperacionExitosa, String detalleOperacion) {
		super();
		this.esOperacionExitosa = esOperacionExitosa;
		this.detalleOperacion = detalleOperacion;
	}

	public boolean isEsOperacionExitosa() {
		return esOperacionExitosa;
	}

	public void setEsOperacionExitosa(boolean esOperacionExitosa) {
		this.esOperacionExitosa = esOperacionExitosa;
	}

	public String getDetalleOperacion() {
		return detalleOperacion;
	}

	public void setDetalleOperacion(String detalleOperacion) {
		this.detalleOperacion = detalleOperacion;
	}


}
