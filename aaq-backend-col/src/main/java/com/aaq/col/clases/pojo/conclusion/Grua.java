package com.aaq.col.clases.pojo.conclusion;

import java.util.Date;

public class Grua {
	
	private String codigoGrua;
	private String tipoAfectado;
	private String respuestaGruasColi;
	private Date fecha;
	private String claveProveedor;
	private String proveedorNombre;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getProveedorNombre() {
		return proveedorNombre;
	}
	public void setProveedorNombre(String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}
	public String getClaveProveedor() {
		return claveProveedor;
	}
	public void setClaveProveedor(String claveProveedor) {
		this.claveProveedor = claveProveedor;
	}
	public String getTipoAfectado() {
		return tipoAfectado;
	}
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}
	public String getCodigoGrua() {
		return codigoGrua;
	}
	public void setCodigoGrua(String codigoGrua) {
		this.codigoGrua = codigoGrua;
	}
	public String getRespuestaGruasColi() {
		return respuestaGruasColi;
	}
	public void setRespuestaGruasColi(String respuestaGruasColi) {
		this.respuestaGruasColi = respuestaGruasColi;
	}
	
	
	

}
