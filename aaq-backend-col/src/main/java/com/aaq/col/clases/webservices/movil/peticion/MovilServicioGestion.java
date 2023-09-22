package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioGestion {
	private String usuario;

	private String passwd;

	private MovilDatosAsegurado datosAsegurado;

	private MovilDatosTercero[] datosTercero;

//	private MovilDatosObjeto[] datosObjeto;

	private MovilDatosRecupero[] datosRecupero;

	/**
	 * 
	 */
	public MovilServicioGestion() {
		super();
	}

	/**
	 * Apr 6, 2011 10:14:56 PM
	 * 
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * Apr 6, 2011 10:14:56 PM
	 * 
	 * @return the passwd
	 */
	public String getPasswd() {
		return this.passwd;
	}

	/**
	 * Apr 6, 2011 10:21:58 PM
	 * 
	 * @return the datosAsegurado
	 */
	public MovilDatosAsegurado getDatosAsegurado() {
		return this.datosAsegurado;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @return the datosTercero
	 */
	public MovilDatosTercero[] getDatosTercero() {
		return this.datosTercero;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @param datosTercero
	 *            the datosTercero to set
	 */
	public void setDatosTercero(final MovilDatosTercero[] datosTercero) {
		this.datosTercero = datosTercero;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @return the datosObjeto
	 */
//	public MovilDatosObjeto[] getDatosObjeto() {
//		return this.datosObjeto;
//	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @param datosObjeto
	 *            the datosObjeto to set
	 */
//	public void setDatosObjeto(final MovilDatosObjeto[] datosObjeto) {
//		this.datosObjeto = datosObjeto;
//	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @return the datosRecupero
	 */
	public MovilDatosRecupero[] getDatosRecupero() {
		return this.datosRecupero;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @param datosRecupero
	 *            the datosRecupero to set
	 */
	public void setDatosRecupero(final MovilDatosRecupero[] datosRecupero) {
		this.datosRecupero = datosRecupero;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	/**
	 * Jose Miguel Jun 26, 2011 6:36:50 PM
	 * 
	 * @param datosAsegurado
	 *            the datosAsegurado to set
	 */
	public void setDatosAsegurado(final MovilDatosAsegurado datosAsegurado) {
		this.datosAsegurado = datosAsegurado;
	}

}
