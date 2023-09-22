package com.aaq.col.clases.xml.webservices;

import java.util.ArrayList;

public class AjustadorWebService {

	private String entidad;
	private String base;
	private String mensaje;
	private ArrayList<Ajustador> ajustador;
	
	
	public AjustadorWebService(String entidad, String base, String mensaje, ArrayList<Ajustador> ajustador) {
		super();
		this.entidad = entidad;
		this.base = base;
		this.mensaje = mensaje;
		this.ajustador = ajustador;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ArrayList<Ajustador> getAjustador() {
		return ajustador;
	}
	public void setAjustador(ArrayList<Ajustador> ajustador) {
		this.ajustador = ajustador;
	}
	
	
}
