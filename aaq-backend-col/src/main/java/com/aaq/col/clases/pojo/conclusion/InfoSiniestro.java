package com.aaq.col.clases.pojo.conclusion;

import java.util.Date;

public class InfoSiniestro {
	
	private String codigoCausa;
	private Date fechaOcurrido;
	private String reporte;
	private String ubicacionSiniestro;
	private Date fechaAsig;
	private Date fechaArribo;
	private String colonia;
	private String ciudad;
	private Date fechaTermino;
	
	
	public String getCodigoCausa() {
		return codigoCausa;
	}
	public void setCodigoCausa(String codigoCausa) {
		this.codigoCausa = codigoCausa;
	}
	public Date getFechaOcurrido() {
		return fechaOcurrido;
	}
	public void setFechaOcurrido(Date fechaOcurrido) {
		this.fechaOcurrido = fechaOcurrido;
	}
	public String getReporte() {
		return reporte;
	}
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	public String getUbicacionSiniestro() {
		return ubicacionSiniestro;
	}
	public void setUbicacionSiniestro(String ubicacionSiniestro) {
		this.ubicacionSiniestro = ubicacionSiniestro;
	}
	public Date getFechaAsig() {
		return fechaAsig;
	}
	public void setFechaAsig(Date fechaAsig) {
		this.fechaAsig = fechaAsig;
	}
	public Date getFechaArribo() {
		return fechaArribo;
	}
	public void setFechaArribo(Date fechaArribo) {
		this.fechaArribo = fechaArribo;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	

}
