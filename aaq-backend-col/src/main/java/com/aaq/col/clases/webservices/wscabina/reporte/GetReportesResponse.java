package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for getReportesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReportesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getReportesResultado" type="{http://webservices.ws.cabina.qualitas.com/}getReportesResultado" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReportesResponse", propOrder = { "getReportesResultado" })
public class GetReportesResponse {

	protected GetReportesResultado getReportesResultado;

	/**
	 * Gets the value of the getReportesResultado property.
	 * 
	 * @return possible object is {@link GetReportesResultado }
	 */
	public GetReportesResultado getGetReportesResultado() {
		return this.getReportesResultado;
	}

	/**
	 * Sets the value of the getReportesResultado property.
	 * 
	 * @param value
	 *            allowed object is {@link GetReportesResultado }
	 */
	public void setGetReportesResultado(final GetReportesResultado value) {
		this.getReportesResultado = value;
	}

}
