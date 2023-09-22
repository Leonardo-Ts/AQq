/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class OrdenesPasesServicioReclamacion {

	private String usuario;
	private String passwd;
	private Date fechaHora;
	private String reporte;
	private String numeroPoliza;

	private String documentosFaltantes;
	private String observaciones;

	/**
	 * 
	 */
	public OrdenesPasesServicioReclamacion() {
		super();
	}

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
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the reporte
	 */
	public String getReporte() {
		return reporte;
	}

	/**
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	/**
	 * @return the numeroPoliza
	 */
	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	/**
	 * @param numeroPoliza
	 *            the numeroPoliza to set
	 */
	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	/**
	 * @return the documentosFaltantes
	 */
	public String getDocumentosFaltantes() {
		return documentosFaltantes;
	}

	/**
	 * @param documentosFaltantes
	 *            the documentosFaltantes to set
	 */
	public void setDocumentosFaltantes(String documentosFaltantes) {
		this.documentosFaltantes = documentosFaltantes;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
