package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for datosCartaCob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datosCartaCob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestCartaCob" type="{http://webservices.ws.cabina.qualitas.com/}requestCartaCob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosCartaCob", propOrder = { "requestCartaCob" })
public class DatosCartaCob {
	
	protected RequestCartaCob requestCartaCob;

	/**
	 * @return the requestCartaCob
	 */
	public RequestCartaCob getRequestCartaCob() {
		return requestCartaCob;
	}

	/**
	 * @param requestCartaCob the requestCartaCob to set
	 */
	public void setRequestCartaCob(RequestCartaCob requestCartaCob) {
		this.requestCartaCob = requestCartaCob;
	}
	

}
