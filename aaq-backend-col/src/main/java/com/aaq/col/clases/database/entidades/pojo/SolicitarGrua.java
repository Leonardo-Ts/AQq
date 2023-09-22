package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class SolicitarGrua implements Serializable {

	private static final long serialVersionUID = 7967822675667578024L;
	
	private String codigoGrua;
	private String tipoAfectado;
	private String respuestaGruasColi;
	private Date fecha;
	private String claveProovedor;
	private String proveedorNombre;
	
	public String getCodigoGrua() {
		return codigoGrua;
	}
	public void setCodigoGrua(String codigoGrua) {
		this.codigoGrua = codigoGrua;
	}
	public String getTipoAfectado() {
		return tipoAfectado;
	}
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}
	
	public String getRespuestaGruasColi() {
		return respuestaGruasColi;
	}
	public void setRespuestaGruasColi(String respuestaGruasColi) {
		this.respuestaGruasColi = respuestaGruasColi;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "SolicitarGrua [codigoGrua=" + codigoGrua + ", tipoAfectado="
				+ tipoAfectado + ", respuestaGruasColi=" + respuestaGruasColi
				+ ", fecha=" + fecha + "]";
	}
	/**
	 * @return the claveProovedor
	 */
	public String getClaveProovedor() {
		return claveProovedor;
	}
	/**
	 * @param claveProovedor the claveProovedor to set
	 */
	public void setClaveProovedor(String claveProovedor) {
		this.claveProovedor = claveProovedor;
	}
	/**
	 * @return the proveedorNombre
	 */
	public String getProveedorNombre() {
		return proveedorNombre;
	}
	/**
	 * @param proveedorNombre the proveedorNombre to set
	 */
	public void setProveedorNombre(String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}
	
	
}
