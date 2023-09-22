package com.aaq.col.clases.sac.model;

import java.util.ArrayList;
import java.util.List;


public class DatosGestionSac {
	private String Reporte;
	private String Edad;
	private String Sexo;
	private String NombreAsegurado;
	private String CorreoAsegurado;
	private String TelefonoAsegurado;
	private String folioAMIS;
	private List<DatosGestionTerceroSac> Terceros;
	private List<DatosGestionRecuperoSac> recuperos;
	

	/**
	 * 
	 */
	public DatosGestionSac() {
		super();
		this.setReporte("");
		this.setEdad("");
		this.setSexo("");
		this.setNombreAsegurado("");
		this.setFolioAMIS("");
		
		this.setTerceros(new ArrayList<DatosGestionTerceroSac>());
		this.setRecuperos(new ArrayList<DatosGestionRecuperoSac>());
		
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @return the reporte
	 */
	public String getReporte() {
		return this.Reporte;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(final String reporte) {
		this.Reporte = reporte;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @return the edad
	 */
	public String getEdad() {
		return this.Edad;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(final String edad) {
		this.Edad = edad;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @return the sexo
	 */
	public String getSexo() {
		return this.Sexo;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(final String sexo) {
		this.Sexo = sexo;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @return the terceros
	 */
	public List<DatosGestionTerceroSac> getTerceros() {
		return this.Terceros;
	}

	/**
	 * Jose Miguel 05/07/2011 21:45:30
	 * 
	 * @param terceros
	 *            the terceros to set
	 */
	public void setTerceros(final List<DatosGestionTerceroSac> terceros) {
		this.Terceros = terceros;
	}

	/**
	 * Jul 16, 2014 1:12:19 PM mfernandez
	 * 
	 * @return the nombreAsegurado
	 */
	public String getNombreAsegurado() {
		return this.NombreAsegurado;
	}

	/**
	 * Jul 16, 2014 1:12:19 PM mfernandez
	 * 
	 * @param nombreAsegurado
	 *            the nombreAsegurado to set
	 */
	public void setNombreAsegurado(final String nombreAsegurado) {
		this.NombreAsegurado = nombreAsegurado;
	}

	/**
	 * Jul 16, 2014 1:12:19 PM mfernandez
	 * 
	 * @return the correoAsegurado
	 */
	public String getCorreoAsegurado() {
		return this.CorreoAsegurado;
	}

	/**
	 * Jul 16, 2014 1:12:19 PM mfernandez
	 * 
	 * @param correoAsegurado
	 *            the correoAsegurado to set
	 */
	public void setCorreoAsegurado(final String correoAsegurado) {
		this.CorreoAsegurado = correoAsegurado;
	}

	/**
	 *
	 * @return el telefono
	 */
	public String getTelefonoAsegurado() {
		return TelefonoAsegurado;
	}

	/**
	 *
	 * @param telefonoAsegurado el telefono
	 */
	public void setTelefonoAsegurado(final String telefonoAsegurado) {
		TelefonoAsegurado = telefonoAsegurado;
	}
	
	/**
	 * 
	 * @return lista de recuperos
	 */
	public List<DatosGestionRecuperoSac> getRecuperos() {
		return recuperos;
	}
	
	/**
	 * 
	 * @param recuperos los recuperos
	 */
	public void setRecuperos(final List<DatosGestionRecuperoSac> recuperos) {
		this.recuperos = recuperos;
	}

	public String getFolioAMIS() {
		return folioAMIS;
	}

	public void setFolioAMIS(String folioAMIS) {
		this.folioAMIS = folioAMIS;
	}
	
	
}
