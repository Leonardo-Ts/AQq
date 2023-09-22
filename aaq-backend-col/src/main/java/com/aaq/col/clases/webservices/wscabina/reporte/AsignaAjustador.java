package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for asignaAjustador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="asignaAjustador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroReporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claveAjustador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asignaAjustador", propOrder = { "numeroReporte", "claveAjustador" })
public class AsignaAjustador {

	protected String numeroReporte;

	protected String claveAjustador;

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
	 * Gets the value of the claveAjustador property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClaveAjustador() {
		return this.claveAjustador;
	}

	/**
	 * Sets the value of the claveAjustador property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setClaveAjustador(final String value) {
		this.claveAjustador = value;
	}

}
