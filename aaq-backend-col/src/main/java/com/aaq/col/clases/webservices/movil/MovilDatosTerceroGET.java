package com.aaq.col.clases.webservices.movil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="MovilDatosTercero")
@XmlType(name = "movilDatosTercero", propOrder = { "consecutivoTercero", "vehiculoMarca","vehiculoModelo",
		"vehiculoColor","vehiculoTipo","terceroNombre","terceroCorreo","terceroSerie","terceroTelefono","atropello","vehiculoClave",
		"vehiculoPlacas","conductor"})
public class MovilDatosTerceroGET {
	
	private String consecutivoTercero;

	private String vehiculoMarca;

	private String vehiculoModelo;

	private String vehiculoColor;

	private String vehiculoTipo;

	private String terceroNombre;

	private String terceroCorreo;

	private String terceroSerie;

	private String terceroTelefono;

	private Boolean atropello;
	
	private String vehiculoClave;
	
	private String vehiculoPlacas;

	private String conductor;

	public MovilDatosTerceroGET() {
		super();
	}

	public String getConsecutivoTercero() {
		return consecutivoTercero;
	}

	public void setConsecutivoTercero(String consecutivoTercero) {
		this.consecutivoTercero = consecutivoTercero;
	}

	public String getVehiculoMarca() {
		return vehiculoMarca;
	}

	public void setVehiculoMarca(String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	public String getVehiculoModelo() {
		return vehiculoModelo;
	}

	public void setVehiculoModelo(String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}

	public String getVehiculoColor() {
		return vehiculoColor;
	}

	public void setVehiculoColor(String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	public String getVehiculoTipo() {
		return vehiculoTipo;
	}

	public void setVehiculoTipo(String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}

	public String getTerceroNombre() {
		return terceroNombre;
	}

	public void setTerceroNombre(String terceroNombre) {
		this.terceroNombre = terceroNombre;
	}

	public String getTerceroCorreo() {
		return terceroCorreo;
	}

	public void setTerceroCorreo(String terceroCorreo) {
		this.terceroCorreo = terceroCorreo;
	}

	public String getTerceroSerie() {
		return terceroSerie;
	}

	public void setTerceroSerie(String terceroSerie) {
		this.terceroSerie = terceroSerie;
	}

	public String getTerceroTelefono() {
		return terceroTelefono;
	}

	public void setTerceroTelefono(String terceroTelefono) {
		this.terceroTelefono = terceroTelefono;
	}

	public Boolean getAtropello() {
		return atropello;
	}

	public void setAtropello(Boolean atropello) {
		this.atropello = atropello;
	}

	public String getVehiculoClave() {
		return vehiculoClave;
	}

	public void setVehiculoClave(String vehiculoClave) {
		this.vehiculoClave = vehiculoClave;
	}

	public String getVehiculoPlacas() {
		return vehiculoPlacas;
	}

	public void setVehiculoPlacas(String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	

}
