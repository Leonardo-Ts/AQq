package com.aaq.col.clases.webservices.movil.peticion;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"idTercero", "terTelContacto", "terAnoModelo", "terColor", "terConductor", 
		"terMarca", "terPlaca", "terSerie", "terTipo"})
public class MovilReporteSacTercero {
	
	@XmlElement(name = "vehMarca")
	protected String terMarca;
	@XmlElement(name = "vehTipo")
	protected String terTipo;
	@XmlElement(name = "vehAnoModelo")
	protected String terAnoModelo;
	@XmlElement(name = "vehPlaca")
	protected String terPlaca;
	@XmlElement(name = "vehSerie")
	protected String terSerie;
	@XmlElement(name = "vehColor")
	protected String terColor;
	@XmlElement(name = "vehConductor")
	protected String terConductor;
	@XmlElement(name = "telefonoContacto")
	protected String terTelContacto;
	/*@XmlElement(name = "TerCiaAseg")
	protected String terCiaAseg;*/
	//@XmlElement(name = "TerNumPol")
	//protected String terNumPol;
	//@XmlElement(name = "TerGXG")
	//protected String terGXG;
	@XmlElement(name = "id")
	protected String idTercero;

	
	/**
	 * @param terMarca
	 * @param terTipo
	 * @param terAnoModelo
	 * @param terPlaca
	 * @param terSerie
	 * @param terColor
	 * @param terConductor
	 * @param terTelContacto
	 * @param terCiaAseg
	 * @param terNumPol
	 * @param terGXG
	 * @param idTercero
	 */
	public MovilReporteSacTercero(String terMarca, String terTipo,
			String terAnoModelo, String terPlaca, String terSerie,
			String terColor, String terConductor, String terTelContacto,
			String idTercero) {
		super();
		this.terMarca = terMarca;
		this.terTipo = terTipo;
		this.terAnoModelo = terAnoModelo;
		this.terPlaca = terPlaca;
		this.terSerie = terSerie;
		this.terColor = terColor;
		this.terConductor = terConductor;
		this.terTelContacto = terTelContacto;
		//this.terCiaAseg = terCiaAseg;
		//this.terNumPol = terNumPol;
		//this.terGXG = terGXG;
		this.idTercero = idTercero;
	}

	/**
	 * Gets the value of the terMarca property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerMarca() {
		return this.terMarca;
	}

	/**
	 * Sets the value of the terMarca property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerMarca(final String value) {
		this.terMarca = value;
	}

	/**
	 * Gets the value of the terTipo property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerTipo() {
		return this.terTipo;
	}

	/**
	 * Sets the value of the terTipo property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerTipo(final String value) {
		this.terTipo = value;
	}

	/**
	 * Gets the value of the terAnoModelo property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerAnoModelo() {
		return this.terAnoModelo;
	}

	/**
	 * Sets the value of the terAnoModelo property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerAnoModelo(final String value) {
		this.terAnoModelo = value;
	}

	/**
	 * Gets the value of the terPlaca property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerPlaca() {
		return this.terPlaca;
	}

	/**
	 * Sets the value of the terPlaca property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerPlaca(final String value) {
		this.terPlaca = value;
	}

	/**
	 * Gets the value of the terSerie property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerSerie() {
		return this.terSerie;
	}

	/**
	 * Sets the value of the terSerie property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerSerie(final String value) {
		this.terSerie = value;
	}

	/**
	 * Gets the value of the terColor property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerColor() {
		return this.terColor;
	}

	/**
	 * Sets the value of the terColor property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerColor(final String value) {
		this.terColor = value;
	}

	/**
	 * Gets the value of the terConductor property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerConductor() {
		return this.terConductor;
	}

	/**
	 * Sets the value of the terConductor property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerConductor(final String value) {
		this.terConductor = value;
	}

	/**
	 * Gets the value of the terTelContacto property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerTelContacto() {
		return this.terTelContacto;
	}

	/**
	 * Sets the value of the terTelContacto property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerTelContacto(final String value) {
		this.terTelContacto = value;
	}

	/**
	 * Gets the value of the terCiaAseg property.
	 *
	 * @return possible object is {@link String }
	 */
	/*public String getTerCiaAseg() {
		return this.terCiaAseg;
	}

	/**
	 * Sets the value of the terCiaAseg property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	/*public void setTerCiaAseg(final String value) {
		this.terCiaAseg = value;
	}

	/**
	 * Gets the value of the terNumPol property.
	 *
	 * @return possible object is {@link String }
	 */
	/*public String getTerNumPol() {
		return this.terNumPol;
	}

	/**
	 * Sets the value of the terNumPol property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	/*public void setTerNumPol(final String value) {
		this.terNumPol = value;
	}

	/**
	 * Gets the value of the terGXG property.
	 *
	 * @return possible object is {@link String }
	 */
	/*public String getTerGXG() {
		return this.terGXG;
	}

	/**
	 * Sets the value of the terGXG property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	/*public void setTerGXG(final String value) {
		this.terGXG = value;
	}

	/**
	 * Gets the value of the idTercero property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getIDTercero() {
		return this.idTercero;
	}

	/**
	 * Sets the value of the idTercero property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setIDTercero(final String value) {
		this.idTercero = value;
	}

}
