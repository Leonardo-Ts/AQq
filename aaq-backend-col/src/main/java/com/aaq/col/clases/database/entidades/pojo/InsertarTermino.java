package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class InsertarTermino implements Serializable{

	private static final long serialVersionUID = 7376085495650862223L;
	
	private String codigoResp;
	private String observaciones;
	private String origen;
	private Date fecha;
	private String descDaniosPre;
	private String descCodigoResp;
	private DatosRobo datosRobo;
	
	public String getCodigoResp() {
		return codigoResp;
	}
	public void setCodigoResp(String codigoResp) {
		this.codigoResp = codigoResp;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescDaniosPre() {
		return descDaniosPre;
	}
	public void setDescDaniosPre(String descDaniosPre) {
		this.descDaniosPre = descDaniosPre;
	}
	public DatosRobo getDatosRobo() {
		return datosRobo;
	}
	public void setDatosRobo(DatosRobo datosRobo) {
		this.datosRobo = datosRobo;
	}
	public String getDescCodigoResp() {
		return descCodigoResp;
	}
	public void setDescCodigoResp(String descCodigoResp) {
		this.descCodigoResp = descCodigoResp;
	}
}
