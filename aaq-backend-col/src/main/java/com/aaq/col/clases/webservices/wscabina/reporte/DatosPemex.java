 package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for datosPemex complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datosPemex">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestPemes" type="{http://webservices.ws.cabina.qualitas.com/}requestPemex" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosPemex", propOrder = { "requestPemes" })
public class DatosPemex {

	protected RequestPemex requestPemes;

	/**
	 * Gets the value of the requestPemes property.
	 * 
	 * @return possible object is {@link RequestPemex }
	 */
	public RequestPemex getRequestPemes() {
		return this.requestPemes;
	}

	/**
	 * Sets the value of the requestPemes property.
	 * 
	 * @param value
	 *            allowed object is {@link RequestPemex }
	 */
	public void setRequestPemes(final RequestPemex value) {
		this.requestPemes = value;
	}

}
