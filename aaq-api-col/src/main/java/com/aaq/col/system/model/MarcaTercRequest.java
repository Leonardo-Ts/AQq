package com.aaq.col.system.model;

public class MarcaTercRequest {

	private String clave;
	private String descripcion;
	private boolean autosYsubcompactos;
	private boolean semipesado;
	private boolean pesado;
	private boolean motos;
	private boolean blindado;
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isAutosYsubcompactos() {
		return autosYsubcompactos;
	}
	public void setAutosYsubcompactos(boolean autosYsubcompactos) {
		this.autosYsubcompactos = autosYsubcompactos;
	}
	public boolean isSemipesado() {
		return semipesado;
	}
	public void setSemipesado(boolean semipesado) {
		this.semipesado = semipesado;
	}
	public boolean isPesado() {
		return pesado;
	}
	public void setPesado(boolean pesado) {
		this.pesado = pesado;
	}
	public boolean isMotos() {
		return motos;
	}
	public void setMotos(boolean motos) {
		this.motos = motos;
	}
	public boolean isBlindado() {
		return blindado;
	}
	public void setBlindado(boolean blindado) {
		this.blindado = blindado;
	}
	
	
}
