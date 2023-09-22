 package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for getListaReportesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getListaReportesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListaReportes" type="{http://webservices.ws.cabina.qualitas.com/}listaReportes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListaReportesResponse", propOrder = { "listaReportes" })
public class GetListaReportesResponse {

	@XmlElement(name = "ListaReportes")
	protected ListaReportes listaReportes;

	/**
	 * Gets the value of the listaReportes property.
	 * 
	 * @return possible object is {@link ListaReportes }
	 */
	public ListaReportes getListaReportes() {
		return this.listaReportes;
	}

	/**
	 * Sets the value of the listaReportes property.
	 * 
	 * @param value
	 *            allowed object is {@link ListaReportes }
	 */
	public void setListaReportes(final ListaReportes value) {
		this.listaReportes = value;
	}

}
