package com.aaq.col.clases.webservices.movil;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

import com.aaq.col.clases.database.entidades.Comunicado;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@XmlRootElement(name = "GETMovilResultadoInicioDeSession")
public class GETMovilResultadoInicioDeSession {
	private boolean exito;
	private String mensaje;
	private String fecha;
	private List<Comunicado> listaDeComunicados;

	public GETMovilResultadoInicioDeSession() {
		super();
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
		this.listaDeComunicados = new Vector<>();
	}

	public GETMovilResultadoInicioDeSession(boolean exito, String mensaje) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
	}


	public GETMovilResultadoInicioDeSession(boolean exito, String mensaje,
			List<Comunicado> listaDeComunicados) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
		this.listaDeComunicados = listaDeComunicados;
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

	public List<Comunicado> getListaDeComunicados() {
		return listaDeComunicados;
	}

	public void setListaDeComunicados(List<Comunicado> listaDeComunicados) {
		this.listaDeComunicados = listaDeComunicados;
	}

}
