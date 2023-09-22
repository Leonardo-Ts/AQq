package com.aaq.col.system.model;

import com.aaq.col.clases.pojo.edocta.EstadoCuenta;

public class EstadoCuentaRequest {

	private boolean success;
	private EstadoCuenta edoCta;
	private String mensaje;
	
	
	public EstadoCuentaRequest(boolean success, EstadoCuenta edoCta, String mensaje) {
		super();
		this.success = success;
		this.edoCta = edoCta;
		this.mensaje = mensaje;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public EstadoCuenta getEdoCta() {
		return edoCta;
	}
	public void setEdoCta(EstadoCuenta edoCta) {
		this.edoCta = edoCta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
