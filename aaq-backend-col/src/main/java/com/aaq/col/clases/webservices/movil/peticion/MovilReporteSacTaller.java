package com.aaq.col.clases.webservices.movil.peticion;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "tallerCod", "tallerNombre", "tallerTipo", "tallerTipoAfectado",
		"tallerIndiceTercero", "tallerVale", "tallerNotas" })
public class MovilReporteSacTaller {
	
	@XmlElement(name = "TallerCod", required = true)
	protected String tallerCod;
	@XmlElement(name = "TallerNombre", required = true)
	protected String tallerNombre;
	@XmlElement(name = "TallerTipo", required = true)
	protected String tallerTipo;
	@XmlElement(name = "TallerTipoAfectado", required = true)
	protected String tallerTipoAfectado;
	@XmlElement(name = "TallerIndiceTercero", required = true)
	protected String tallerIndiceTercero;
	@XmlElement(name = "TallerVale", required = true)
	protected String tallerVale;
	@XmlElement(name = "TallerNotas", required = true)
	protected String tallerNotas;
	@XmlAttribute(name = "IDTaller")
	protected String idTaller;
	
	
	
	/**
	 * @param tallerCod
	 * @param tallerNombre
	 * @param tallerTipo
	 * @param tallerTipoAfectado
	 * @param tallerIndiceTercero
	 * @param tallerVale
	 * @param tallerNotas
	 * @param idTaller
	 */
	public MovilReporteSacTaller(String tallerCod, String tallerNombre,
			String tallerTipo, String tallerTipoAfectado,
			String tallerIndiceTercero, String tallerVale, String tallerNotas,
			String idTaller) {
		super();
		this.tallerCod = tallerCod;
		this.tallerNombre = tallerNombre;
		this.tallerTipo = tallerTipo;
		this.tallerTipoAfectado = tallerTipoAfectado;
		this.tallerIndiceTercero = tallerIndiceTercero;
		this.tallerVale = tallerVale;
		this.tallerNotas = tallerNotas;
		this.idTaller = idTaller;
	}



	/**
	 * @return the tallerCod
	 */
	public String getTallerCod() {
		return tallerCod;
	}



	/**
	 * @param tallerCod the tallerCod to set
	 */
	public void setTallerCod(String tallerCod) {
		this.tallerCod = tallerCod;
	}



	/**
	 * @return the tallerNombre
	 */
	public String getTallerNombre() {
		return tallerNombre;
	}



	/**
	 * @param tallerNombre the tallerNombre to set
	 */
	public void setTallerNombre(String tallerNombre) {
		this.tallerNombre = tallerNombre;
	}



	/**
	 * @return the tallerTipo
	 */
	public String getTallerTipo() {
		return tallerTipo;
	}



	/**
	 * @param tallerTipo the tallerTipo to set
	 */
	public void setTallerTipo(String tallerTipo) {
		this.tallerTipo = tallerTipo;
	}



	/**
	 * @return the tallerTipoAfectado
	 */
	public String getTallerTipoAfectado() {
		return tallerTipoAfectado;
	}



	/**
	 * @param tallerTipoAfectado the tallerTipoAfectado to set
	 */
	public void setTallerTipoAfectado(String tallerTipoAfectado) {
		this.tallerTipoAfectado = tallerTipoAfectado;
	}



	/**
	 * @return the tallerIndiceTercero
	 */
	public String getTallerIndiceTercero() {
		return tallerIndiceTercero;
	}



	/**
	 * @param tallerIndiceTercero the tallerIndiceTercero to set
	 */
	public void setTallerIndiceTercero(String tallerIndiceTercero) {
		this.tallerIndiceTercero = tallerIndiceTercero;
	}



	/**
	 * @return the tallerVale
	 */
	public String getTallerVale() {
		return tallerVale;
	}



	/**
	 * @param tallerVale the tallerVale to set
	 */
	public void setTallerVale(String tallerVale) {
		this.tallerVale = tallerVale;
	}



	/**
	 * @return the tallerNotas
	 */
	public String getTallerNotas() {
		return tallerNotas;
	}



	/**
	 * @param tallerNotas the tallerNotas to set
	 */
	public void setTallerNotas(String tallerNotas) {
		this.tallerNotas = tallerNotas;
	}



	/**
	 * @return the idTaller
	 */
	public String getIdTaller() {
		return idTaller;
	}



	/**
	 * @param idTaller the idTaller to set
	 */
	public void setIdTaller(String idTaller) {
		this.idTaller = idTaller;
	}
	
}
