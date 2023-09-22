package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for error complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="error">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mensajeError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroError" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "error", propOrder = { "mensajeError", "numeroError" })
public class Error {

	protected String mensajeError;

	protected int numeroError;

	/**
	 * Gets the value of the mensajeError property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMensajeError() {
		return this.mensajeError;
	}

	/**
	 * Sets the value of the mensajeError property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setMensajeError(final String value) {
		this.mensajeError = value;
	}

	/**
	 * Gets the value of the numeroError property.
	 */
	public int getNumeroError() {
		return this.numeroError;
	}

	/**
	 * Sets the value of the numeroError property.
	 */
	public void setNumeroError(final int value) {
		this.numeroError = value;
	}

}
