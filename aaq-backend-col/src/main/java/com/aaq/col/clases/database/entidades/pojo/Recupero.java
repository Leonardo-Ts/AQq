package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class Recupero implements Serializable {

	private static final long serialVersionUID = 8894696218606966408L;

	private Date fecha;
	private String cveAseguradora;
	private String numeroTercero;
	private String decRecupero;
	private String cveRecupero;
	private String monto;
	private String descClaveRecupero;
	private String nombreAseguradora;
	private String descripMonto;
	
	public String getCveAseguradora() {
		return cveAseguradora;
	}
	public void setCveAseguradora(String cveAseguradora) {
		this.cveAseguradora = cveAseguradora;
	}
	public String getNumeroTercero() {
		return numeroTercero;
	}
	public void setNumeroTercero(String numeroTercero) {
		this.numeroTercero = numeroTercero;
	}
	public String getDecRecupero() {
		return decRecupero;
	}
	public void setDecRecupero(String decRecupero) {
		this.decRecupero = decRecupero;
	}
	public String getCveRecupero() {
		return cveRecupero;
	}
	public void setCveRecupero(String cveRecupero) {
		this.cveRecupero = cveRecupero;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getDescClaveRecupero() {
		return descClaveRecupero;
	}
	public void setDescClaveRecupero(String descClaveRecupero) {
		this.descClaveRecupero = descClaveRecupero;
	}
	public String getNombreAseguradora() {
		return nombreAseguradora;
	}
	public void setNombreAseguradora(String nombreAseguradora) {
		this.nombreAseguradora = nombreAseguradora;
	}
	@Override
	public String toString() {
		return "Recupero [cveAseguradora=" + cveAseguradora
				+ ", numeroTercero=" + numeroTercero + ", decRecupero="
				+ decRecupero + ", cveRecupero=" + cveRecupero + ", monto="
				+ monto + ", descClaveRecupero=" + descClaveRecupero
				+ ", nombreAseguradora=" + nombreAseguradora + "]";
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the descripcionMonton
	 */
	public String getDescripMonto() {
		return descripMonto;
	}
	/**
	 * @param descripcionMonton the descripcionMonton to set
	 */
	public void setDescripMonto(String descripMonto) {
		this.descripMonto = descripMonto;
	}
	
	
	
}
