package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class Abogado implements Serializable {

	private static final long serialVersionUID = 4820839474194705969L;
	
	private Date fecha;
	private String motivoAsignacion;
	private String apreciacionResponsabilidad;
	private String idEntidad;
	private String lugarPresentarse;
	private String vehiculoDetenido;
	private String numLesa;
	private String numHoma;
	private String numLest;
	private String numHomt;
	private String conductorDetenido;
	private String descripPresentarse;
	
	public String getMotivoAsignacion() {
		return motivoAsignacion;
	}
	public void setMotivoAsignacion(String motivoAsignacion) {
		this.motivoAsignacion = motivoAsignacion;
	}
	public String getApreciacionResponsabilidad() {
		return apreciacionResponsabilidad;
	}
	public void setApreciacionResponsabilidad(String apreciacionResponsabilidad) {
		this.apreciacionResponsabilidad = apreciacionResponsabilidad;
	}
	public String getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getLugarPresentarse() {
		return lugarPresentarse;
	}
	public void setLugarPresentarse(String lugarPresentarse) {
		this.lugarPresentarse = lugarPresentarse;
	}
	public String getVehiculoDetenido() {
		return vehiculoDetenido;
	}
	public void setVehiculoDetenido(String vehiculoDetenido) {
		this.vehiculoDetenido = vehiculoDetenido;
	}
	public String getConductorDetenido() {
		return conductorDetenido;
	}
	public void setConductorDetenido(String conductorDetenido) {
		this.conductorDetenido = conductorDetenido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNumLesa() {
		return numLesa;
	}
	public void setNumLesa(String numLesa) {
		this.numLesa = numLesa;
	}
	public String getNumHoma() {
		return numHoma;
	}
	public void setNumHoma(String numHoma) {
		this.numHoma = numHoma;
	}
	public String getNumLest() {
		return numLest;
	}
	public void setNumLest(String numLest) {
		this.numLest = numLest;
	}
	public String getNumHomt() {
		return numHomt;
	}
	public void setNumHomt(String numHomt) {
		this.numHomt = numHomt;
	}
	/**
	 * @return the descripPresentarse
	 */
	public String getDescripPresentarse() {
		return descripPresentarse;
	}
	/**
	 * @param descripPresentarse the descripPresentarse to set
	 */
	public void setDescripPresentarse(String descripPresentarse) {
		this.descripPresentarse = descripPresentarse;
	}

	
}
