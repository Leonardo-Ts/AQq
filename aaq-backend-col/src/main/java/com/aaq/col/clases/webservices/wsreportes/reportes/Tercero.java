package com.aaq.col.clases.webservices.wsreportes.reportes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TerMarca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerTipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerAnoModelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerPlaca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerSerie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerConductor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerTelContacto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerCiaAseg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerNumPol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TerGXG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IDTercero" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "terMarca", "terTipo", "terAnoModelo", "terPlaca", "terSerie", "terColor",
		"terConductor", "terTelContacto", "terCiaAseg", "terNumPol", "terGXG" })
@XmlRootElement(name = "Tercero")
public class Tercero {

	@XmlElement(name = "TerMarca", required = true)
	protected String terMarca;
	@XmlElement(name = "TerTipo", required = true)
	protected String terTipo;
	@XmlElement(name = "TerAnoModelo", required = true)
	protected String terAnoModelo;
	@XmlElement(name = "TerPlaca", required = true)
	protected String terPlaca;
	@XmlElement(name = "TerSerie", required = true)
	protected String terSerie;
	@XmlElement(name = "TerColor", required = true)
	protected String terColor;
	@XmlElement(name = "TerConductor", required = true)
	protected String terConductor;
	@XmlElement(name = "TerTelContacto", required = true)
	protected String terTelContacto;
	@XmlElement(name = "TerCiaAseg", required = true)
	protected String terCiaAseg;
	@XmlElement(name = "TerNumPol", required = true)
	protected String terNumPol;
	@XmlElement(name = "TerGXG", required = true)
	protected String terGXG;
	@XmlAttribute(name = "IDTercero")
	protected String idTercero;

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
	public String getTerCiaAseg() {
		return this.terCiaAseg;
	}

	/**
	 * Sets the value of the terCiaAseg property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerCiaAseg(final String value) {
		this.terCiaAseg = value;
	}

	/**
	 * Gets the value of the terNumPol property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerNumPol() {
		return this.terNumPol;
	}

	/**
	 * Sets the value of the terNumPol property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerNumPol(final String value) {
		this.terNumPol = value;
	}

	/**
	 * Gets the value of the terGXG property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTerGXG() {
		return this.terGXG;
	}

	/**
	 * Sets the value of the terGXG property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTerGXG(final String value) {
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
