 package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@SuppressWarnings("all")
/**
 * <p>Java class for getListaReportes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getListaReportes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ajustador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInico" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListaReportes", propOrder = { "ajustador", "fechaInico", "fechaFin" })
public class GetListaReportes {

	protected String ajustador;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fechaInico;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fechaFin;

	/**
	 * Gets the value of the ajustador property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAjustador() {
		return this.ajustador;
	}

	/**
	 * Sets the value of the ajustador property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setAjustador(final String value) {
		this.ajustador = value;
	}

	/**
	 * Gets the value of the fechaInico property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFechaInico() {
		return this.fechaInico;
	}

	/**
	 * Sets the value of the fechaInico property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFechaInico(final XMLGregorianCalendar value) {
		this.fechaInico = value;
	}

	/**
	 * Gets the value of the fechaFin property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFechaFin() {
		return this.fechaFin;
	}

	/**
	 * Sets the value of the fechaFin property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFechaFin(final XMLGregorianCalendar value) {
		this.fechaFin = value;
	}

}
