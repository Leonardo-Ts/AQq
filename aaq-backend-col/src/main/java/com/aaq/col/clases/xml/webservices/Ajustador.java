package com.aaq.col.clases.xml.webservices;

import java.util.Date;

public class Ajustador {
	
	private String claveAjustador;
	private String nombreAjustador;
	private String claveOficinaAjustador;
	private String nombreOficinaAjustador;
	private Date fechaDisponible;

	/**
	 * 
	 */
	public Ajustador() {
		super();
	}

	/**
	 * @param claveAjustador
	 * @param nombreAjustador
	 * @param claveOficinaAjustador
	 * @param nombreOficinaAjustador
	 * @param fechaDisponible
	 */
	public Ajustador(String claveAjustador, String nombreAjustador, String claveOficinaAjustador,
			String nombreOficinaAjustador, Date fechaDisponible) {
		super();
		this.claveAjustador = claveAjustador;
		this.nombreAjustador = nombreAjustador;
		this.claveOficinaAjustador = claveOficinaAjustador;
		this.nombreOficinaAjustador = nombreOficinaAjustador;
		this.fechaDisponible = fechaDisponible;
	}

	/**
	 * @return the claveAjustador
	 */
	public String getClaveAjustador() {
		return this.claveAjustador;
	}

	/**
	 * @param claveAjustador
	 *            the claveAjustador to set
	 */
	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}

	/**
	 * @return the nombreAjustador
	 */
	public String getNombreAjustador() {
		return this.nombreAjustador;
	}

	/**
	 * @param nombreAjustador
	 *            the nombreAjustador to set
	 */
	public void setNombreAjustador(String nombreAjustador) {
		this.nombreAjustador = nombreAjustador;
	}

	/**
	 * @return the claveOficinaAjustador
	 */
	public String getClaveOficinaAjustador() {
		return this.claveOficinaAjustador;
	}

	/**
	 * @param claveOficinaAjustador
	 *            the claveOficinaAjustador to set
	 */
	public void setClaveOficinaAjustador(String claveOficinaAjustador) {
		this.claveOficinaAjustador = claveOficinaAjustador;
	}

	/**
	 * @return the nombreOficinaAjustador
	 */
	public String getNombreOficinaAjustador() {
		return this.nombreOficinaAjustador;
	}

	/**
	 * @param nombreOficinaAjustador
	 *            the nombreOficinaAjustador to set
	 */
	public void setNombreOficinaAjustador(String nombreOficinaAjustador) {
		this.nombreOficinaAjustador = nombreOficinaAjustador;
	}

	/**
	 * @return the fechaDisponible
	 */
	public Date getFechaDisponible() {
		return this.fechaDisponible;
	}

	/**
	 * @param fechaDisponible
	 *            the fechaDisponible to set
	 */
	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}
}
