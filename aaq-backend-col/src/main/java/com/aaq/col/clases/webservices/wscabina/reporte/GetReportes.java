 package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for getReportes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReportes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroReporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroSiniesto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroPoliza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReportes", propOrder = { "numeroReporte", "numeroSiniesto", "numeroPoliza" })
public class GetReportes {

	protected String numeroReporte;

	protected String numeroSiniesto;

	protected String numeroPoliza;

	/**
	 * Gets the value of the numeroReporte property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}

	/**
	 * Sets the value of the numeroReporte property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNumeroReporte(final String value) {
		this.numeroReporte = value;
	}

	/**
	 * Gets the value of the numeroSiniesto property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumeroSiniesto() {
		return this.numeroSiniesto;
	}

	/**
	 * Sets the value of the numeroSiniesto property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNumeroSiniesto(final String value) {
		this.numeroSiniesto = value;
	}

	/**
	 * Gets the value of the numeroPoliza property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumeroPoliza() {
		return this.numeroPoliza;
	}

	/**
	 * Sets the value of the numeroPoliza property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNumeroPoliza(final String value) {
		this.numeroPoliza = value;
	}

}
