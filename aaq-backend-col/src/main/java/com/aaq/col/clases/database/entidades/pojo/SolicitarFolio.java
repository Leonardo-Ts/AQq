package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class SolicitarFolio implements Serializable {

	private static final long serialVersionUID = 5792587655625944136L;
	
	private String servicioSolicitado;
	private String tipoAfectado;
	private String claveProveedor;
	private String folio;
	private Date fecha;
	private String nombreAfectado;
	private String lesionado;
	private String tag;
	private String nombreProveedor;
	
	
	public String getServicioSolicitado() {
		return servicioSolicitado;
	}
	public void setServicioSolicitado(String servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}
	public String getTipoAfectado() {
		return tipoAfectado;
	}
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getClaveProveedor() {
		return claveProveedor;
	}
	public void setClaveProveedor(String claveProveedor) {
		this.claveProveedor = claveProveedor;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return the nombreLesionado
	 */
	public String getNombreAfectado() {
		return nombreAfectado;
	}
	/**
	 * @param nombreLesionado the nombreLesionado to set
	 */
	public void setNombreAfectado(String nombreAfectado) {
		this.nombreAfectado = nombreAfectado;
	}
	/**
	 * @return the lesionado
	 */
	public String getLesionado() {
		return lesionado;
	}
	/**
	 * @param lesionado the lesionado to set
	 */
	public void setLesionado(String lesionado) {
		this.lesionado = lesionado;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	
	public void setTag (String tag) {
		this.tag = tag;
	}
	
	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	@Override
	public String toString() {
		return "SolicitarFolio [servicioSolicitado=" + servicioSolicitado
				+ ", tipoAfectado=" + tipoAfectado + ", claveProveedor="
				+ claveProveedor + ", nombreProveedor=" + nombreProveedor + ", folio=" + folio + ", fecha=" + fecha
				+ ", nombreLesionado" + nombreAfectado  + "]";
	}

	
	
}
