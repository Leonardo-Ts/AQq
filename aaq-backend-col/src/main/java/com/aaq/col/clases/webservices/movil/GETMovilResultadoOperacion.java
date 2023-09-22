package com.aaq.col.clases.webservices.movil;

import javax.xml.bind.annotation.XmlRootElement;

import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@XmlRootElement
public class GETMovilResultadoOperacion {
	private boolean exito;

	private String mensaje;

	private String fecha;

	public GETMovilResultadoOperacion() {
		super();
	}
	public GETMovilResultadoOperacion(final boolean exito, final String mensaje) {
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
