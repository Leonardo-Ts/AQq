 package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for datosArca complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datosArca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestArca" type="{http://webservices.ws.cabina.qualitas.com/}requestArca" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosArca", propOrder = { "requestArca" })
public class DatosArca {

	protected RequestArca requestArca;

	/**
	 * Gets the value of the requestArca property.
	 * 
	 * @return possible object is {@link RequestArca }
	 */
	public RequestArca getRequestArca() {
		return this.requestArca;
	}

	/**
	 * Sets the value of the requestArca property.
	 * 
	 * @param value
	 *            allowed object is {@link RequestArca }
	 */
	public void setRequestArca(final RequestArca value) {
		this.requestArca = value;
	}

}
