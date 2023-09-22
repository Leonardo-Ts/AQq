package com.aaq.col.clases.pojo.aaq;

import java.util.List;

public class InformacionPago {

	private String status;
	private List<DetallesPago> detalles;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<DetallesPago> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetallesPago> detalles) {
		this.detalles = detalles;
	}
	
	
}
