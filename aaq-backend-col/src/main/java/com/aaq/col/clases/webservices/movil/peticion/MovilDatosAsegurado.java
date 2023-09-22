package com.aaq.col.clases.webservices.movil.peticion;

public class MovilDatosAsegurado {
	private String edad;
	private String sexo;
	private String aseguradoNombre;
	private String aseguradoCorreo;
	private String aseguradoTelefono;
	private String folioAMIS;


	/**

	 * 
	 */
	public MovilDatosAsegurado() {
		super();
	}

	/**
	 * Apr 6, 2011 10:19:35 PM
	 * 
	 * @return the edad
	 */
	public String getEdad() {
		return this.edad;
	}

	/**
	 * Apr 6, 2011 10:19:35 PM
	 * 
	 * @return the sexo
	 */
	public String getSexo() {
		return this.sexo;
	}

	/**
	 * Apr 6, 2011 10:19:35 PM
	 * 
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(final String edad) {
		this.edad = edad;
	}

	/**
	 * Apr 6, 2011 10:19:35 PM
	 * 
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(final String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Jul 16, 2014 1:11:32 PM mfernandez
	 * 
	 * @return the aseguradoNombre
	 */
	public String getAseguradoNombre() {
		return this.aseguradoNombre;
	}

	/**
	 * Jul 16, 2014 1:11:32 PM mfernandez
	 * 
	 * @param aseguradoNombre
	 *            the aseguradoNombre to set
	 */
	public void setAseguradoNombre(final String aseguradoNombre) {
		this.aseguradoNombre = aseguradoNombre;
	}

	/**
	 * Jul 16, 2014 1:11:32 PM mfernandez
	 * 
	 * @return the aseguradoCorreo
	 */
	public String getAseguradoCorreo() {
		return this.aseguradoCorreo;
	}

	/**
	 * Jul 16, 2014 1:11:32 PM mfernandez
	 * 
	 * @param aseguradoCorreo
	 *            the aseguradoCorreo to set
	 */
	public void setAseguradoCorreo(final String aseguradoCorreo) {
		this.aseguradoCorreo = aseguradoCorreo;
	}

	/**
	 *
	 * @return el telefono
	 */
	public String getAseguradoTelefono() {
		return aseguradoTelefono;
	}

	/**
	 *
	 * @param aseguradoTelefono el telefono
	 */
	public void setAseguradoTelefono(final String aseguradoTelefono) {
		this.aseguradoTelefono = aseguradoTelefono;
	}

	public String getFolioAMIS() {
		return folioAMIS;
	}

	public void setFolioAMIS(String folioAMIS) {
		this.folioAMIS = folioAMIS;
	}

	
}
