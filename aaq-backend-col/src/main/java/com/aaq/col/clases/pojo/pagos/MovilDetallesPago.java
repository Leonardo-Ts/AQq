package com.aaq.col.clases.pojo.pagos;

import java.util.List;

import com.aaq.col.clases.pojo.aaq.DetallesPago;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

public class MovilDetallesPago {

	private boolean exito;
	private String mensaje;
	private String fecha;
	private List<DetallesPago> detalles;
	
	
	public MovilDetallesPago() {
		super();
	}


	public MovilDetallesPago(boolean exito, String mensaje, List<DetallesPago> detalles) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);;
		this.detalles = detalles;
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


	public List<DetallesPago> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetallesPago> detalles) {
		this.detalles = detalles;
	}
	
	
	
	
}
