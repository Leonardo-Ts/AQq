package com.aaq.col.clases.webservices.movil.peticion;

import com.aaq.col.clases.pojo.conclusion.ResumenAjustadorInfo;

public class MovilResumenAjustador {
	
	private boolean exito;
	private String mensaje;
	private ResumenAjustadorInfo info;
	

	public MovilResumenAjustador(boolean exito, String mensaje, ResumenAjustadorInfo info) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.info = info;
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public ResumenAjustadorInfo getInfo() {
		return info;
	}

	public void setInfo(ResumenAjustadorInfo info) {
		this.info = info;
	}

	
	
	

}
