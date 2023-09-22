package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;

public class ServicioLogFormatosAjustadorError {

	private String usuario;
	private String passwd;
	private String descripcion;
	private String nombreFormato;
	private String folioFormato;
	private Timestamp fechaHora;
	private Integer id;

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the nombreFormato
	 */
	public String getNombreFormato() {
		return nombreFormato;
	}

	/**
	 * @param nombreFormato
	 *            the nombreFormato to set
	 */
	public void setNombreFormato(String nombreFormato) {
		this.nombreFormato = nombreFormato;
	}

	/**
	 * @return the folioFormato
	 */
	public String getFolioFormato() {
		return folioFormato;
	}

	/**
	 * @param folioFormato
	 *            the folioFormato to set
	 */
	public void setFolioFormato(String folioFormato) {
		this.folioFormato = folioFormato;
	}

	/**
	 * @return the fechaHora
	 */
	public Timestamp getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
