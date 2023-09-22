package com.aaq.col.clases.xml.webservices;

import java.util.Date;

public class DatosAjustador {

	private String numeroProveedor;
	private Date fechaEnEstatus;
	private Double distanciaEnMetros;
	private Integer reportesEsteDia;
	
	public DatosAjustador() {
		super();
	}

	
	public DatosAjustador(String numeroProveedor, Date fechaEnEstatus, Double distanciaEnMetros,
			Integer reportesEsteDia) {
		super();
		this.numeroProveedor = numeroProveedor;
		this.fechaEnEstatus = fechaEnEstatus;
		this.distanciaEnMetros = distanciaEnMetros;
		this.reportesEsteDia = reportesEsteDia;
	}


	public String getNumeroProveedor() {
		return numeroProveedor;
	}

	public void setNumeroProveedor(String numeroProveedor) {
		this.numeroProveedor = numeroProveedor;
	}

	public Date getFechaEnEstatus() {
		return fechaEnEstatus;
	}

	public void setFechaEnEstatus(Date fechaEnEstatus) {
		this.fechaEnEstatus = fechaEnEstatus;
	}

	public Double getDistanciaEnMetros() {
		return distanciaEnMetros;
	}

	public void setDistanciaEnMetros(Double distanciaEnMetros) {
		this.distanciaEnMetros = distanciaEnMetros;
	}

	public Integer getReportesEsteDia() {
		return reportesEsteDia;
	}

	public void setReportesEsteDia(Integer reportesEsteDia) {
		this.reportesEsteDia = reportesEsteDia;
	}
	
	
	
	
	
}
