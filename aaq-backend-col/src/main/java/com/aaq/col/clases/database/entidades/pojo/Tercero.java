package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class Tercero implements Serializable {

	private static final long serialVersionUID = 8979286070304656451L;
	
	private Date fecha;
	private String tipoTercero;
	private String correo;
	private String numeroTercero;
	private String telefono;
	private Vehiculo vehiculo;

	public String getTipoTercero() {
		return tipoTercero;
	}
	public void setTipoTercero(String tipoTercero) {
		this.tipoTercero = tipoTercero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNumeroTercero() {
		return numeroTercero;
	}
	public void setNumeroTercero(String numeroTercero) {
		this.numeroTercero = numeroTercero;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public String getConductor() {
		if(this.getVehiculo()!=null)
		return this.getVehiculo().getConductor()!=null?this.getVehiculo().getConductor():"";
		else
			return "";
	}
	
	public String getMarca() {
		if(this.getVehiculo()!=null)
		return this.getVehiculo().getMarca()!=null?this.getVehiculo().getMarca():"";
		else
			return "";
	}
	
	public String getSerie(){
		if(this.getVehiculo()!=null)
			return this.getVehiculo().getSerie()!=null?this.getVehiculo().getSerie():"";
			else
				return "";
	}
	
	public String getPlacas(){
		if(this.getVehiculo()!=null)
			return this.getVehiculo().getPlacas()!=null?this.getVehiculo().getPlacas():"";
			else
				return "";
	}
	
	public String getTipo(){
		if(this.getVehiculo()!=null)
			return this.getVehiculo().getTipo()!=null?this.getVehiculo().getTipo():"";
			else
				return "";
	}
	
	public String getModelo(){
		if(this.getVehiculo()!=null)
			return this.getVehiculo().getModelo()!=null?this.getVehiculo().getModelo():"";
			else
				return "";
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
