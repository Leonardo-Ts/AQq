 package com.aaq.col.clases.webservices.wscabina.siniestro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for aperturaEstimacionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aperturaEstimacionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultadoApertura" type="{http://webservices.ws.cabina.qualitas.com/}resultadoAperturaEstimacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aperturaEstimacionResponse", propOrder = { "resultadoApertura" })
public class AperturaEstimacionResponse {

	protected ResultadoAperturaEstimacion resultadoApertura;

	/**
	 * Gets the value of the resultadoApertura property.
	 * 
	 * @return possible object is {@link ResultadoAperturaEstimacion }
	 */
	public ResultadoAperturaEstimacion getResultadoApertura() {
		return this.resultadoApertura;
	}

	/**
	 * Sets the value of the resultadoApertura property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoAperturaEstimacion }
	 */
	public void setResultadoApertura(final ResultadoAperturaEstimacion value) {
		this.resultadoApertura = value;
	}

}
