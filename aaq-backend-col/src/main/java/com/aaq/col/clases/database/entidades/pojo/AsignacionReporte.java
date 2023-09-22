package com.aaq.col.clases.database.entidades.pojo;
import java.io.Serializable;
import java.util.Date;

public class AsignacionReporte implements Serializable {

	private static final long serialVersionUID = -4149425225415168441L;
	private String usuario;
	private String servicioAmbulancia;
	private String origen;
	private Date fecha;
	private Date hora;
	private String proximidad;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getServicioAmbulancia() {
		return servicioAmbulancia;
	}
	public void setServicioAmbulancia(String servicioAmbulancia) {
		this.servicioAmbulancia = servicioAmbulancia;
	}
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "AsignacionReporte [usuario=" + usuario
				+ ", servicioAmbulancia=" + servicioAmbulancia + ", origen="
				+ origen + ", fecha=" + fecha + "]";
	}
	public String getProximidad() {
		return proximidad;
	}
	public void setProximidad(String proximidad) {
		this.proximidad = proximidad;
	}
	/**
	 * @return the hora
	 */
	public Date getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
}
