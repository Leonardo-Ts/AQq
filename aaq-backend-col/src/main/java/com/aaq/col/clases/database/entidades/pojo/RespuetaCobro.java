package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;

public class RespuetaCobro implements Serializable {

	private static final long serialVersionUID = 122250829445620728L;

	private String estatus;
	private String numeroAutorizacion;
	private String numeroOperacion;
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}
	public String getNumeroOperacion() {
		return numeroOperacion;
	}
	public void setNumeroOperacion(String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}
}
