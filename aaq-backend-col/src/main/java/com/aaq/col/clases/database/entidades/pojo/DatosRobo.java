package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;

public class DatosRobo implements Serializable{
	
	private static final long serialVersionUID = 7921073841309585007L;
	private String motor;
	private String serieAsegurado;
	private String color;
	private String averiguacionPrev;
	private String placasAsegurado;
	
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getSerieAsegurado() {
		return serieAsegurado;
	}
	public void setSerieAsegurado(String serieAsegurado) {
		this.serieAsegurado = serieAsegurado;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAveriguacionPrev() {
		return averiguacionPrev;
	}
	public void setAveriguacionPrev(String averiguacionPrev) {
		this.averiguacionPrev = averiguacionPrev;
	}
	public String getPlacasAsegurado() {
		return placasAsegurado;
	}
	public void setPlacasAsegurado(String placasAsegurado) {
		this.placasAsegurado = placasAsegurado;
	}
	@Override
	public String toString() {
		return "DatosRobos [motor=" + motor + ", serieAsegurado="
				+ serieAsegurado + ", color=" + color + ", averiguacionPrev="
				+ averiguacionPrev + ", placasAsegurado=" + placasAsegurado
				+ "]";
	}
	
}
