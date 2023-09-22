package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;

public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 5953045114211414910L;
	
	private String marca;
	private String tipo;
	private String conductor;
	private String modelo;
	private String serie;
	private String placas;
		
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", tipo=" + tipo + ", conductor="
				+ conductor + ", modelo=" + modelo + ", serie=" + serie
				+ ", placas=" + placas + "]";
	}
	
}
