package com.aaq.col.clases.webservices.movil.peticion;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.aaq.col.clases.database.entidades.Comunicado;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@XmlRootElement(name = "MovilResultadoInicioDeSession")
public class MovilResultadoInicioDeSession {
	private boolean exito;
	private String mensaje;
	private String fecha;
	private List<MovilComunicado> listaDeComunicados;

	/**
	 * Constructor
	 */
	public MovilResultadoInicioDeSession() {
		super();
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
		this.listaDeComunicados = new Vector<>();
	}

	/**
	 * @param exito
	 * @param mensaje
	 */
	public MovilResultadoInicioDeSession(final boolean exito, final String mensaje) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
		this.listaDeComunicados = new Vector<>();

	}

	public MovilResultadoInicioDeSession(final boolean exito, final String mensaje, final List<Comunicado> listado) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
		this.fecha = JMUtileriaFecha.obtenerFechaActual(true);
		this.listaDeComunicados = new Vector<>();

		if ((listado != null) && (listado.size() > 0)) {
			for (final Comunicado c : listado) {
				this.listaDeComunicados.add(new MovilComunicado(c.getTexo(), c.getFechaInicio(), c.getFechaTermino()));
			}
		}
	}

	@XmlElement(name = "exito")
	public boolean isExito() {
		return this.exito;
	}

	public void setExito(final boolean exito) {
		this.exito = exito;
	}

	@XmlElement(name = "mensaje")
	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}

	@XmlElement(name = "fecha")
	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(final String fecha) {
		this.fecha = fecha;
	}

	@XmlElement(name = "listaDeComunicados")
	public List<MovilComunicado> getListaDeComunicados() {
		return this.listaDeComunicados;
	}

	public void setListaDeComunicados(final Vector<MovilComunicado> listaDeComunicados) {
		this.listaDeComunicados = listaDeComunicados;
	}

}
