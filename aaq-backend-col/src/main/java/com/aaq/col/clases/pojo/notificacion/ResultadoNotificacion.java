package com.aaq.col.clases.pojo.notificacion;


import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

public class ResultadoNotificacion {
	
	private boolean exito;

	private String mensaje;

	private String fecha;

	public ResultadoNotificacion() {
		super();
	}

	public ResultadoNotificacion(boolean exito, String mensaje) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}