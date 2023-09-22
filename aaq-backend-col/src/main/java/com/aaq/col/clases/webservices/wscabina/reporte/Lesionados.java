package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for lesionados complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lesionados">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lesionados" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lesionados", propOrder = { "lesionados", "numero" })
public class Lesionados {

	protected String lesionados;

	protected Integer numero;

	/**
	 * Gets the value of the lesionados property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLesionados() {
		return this.lesionados;
	}

	/**
	 * Sets the value of the lesionados property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setLesionados(final String value) {
		this.lesionados = value;
	}

	/**
	 * Gets the value of the numero property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getNumero() {
		return this.numero;
	}

	/**
	 * Sets the value of the numero property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 */
	public void setNumero(final Integer value) {
		this.numero = value;
	}

}
