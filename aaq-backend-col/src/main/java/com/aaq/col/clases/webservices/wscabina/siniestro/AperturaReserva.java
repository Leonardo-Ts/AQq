package com.aaq.col.clases.webservices.wscabina.siniestro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for aperturaReserva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aperturaReserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cveCobertura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoEstimacion" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "aperturaReserva", propOrder = { "cveCobertura", "montoEstimacion"})
@XmlType(name = "aperturaReserva", propOrder = { "cveCobertura", "montoEstimacion", "cveCoberturaFlexible"})
public class AperturaReserva {

	protected String cveCobertura;

	protected float montoEstimacion;
	
	protected String cveCoberturaFlexible;

	/**
	 * Gets the value of the cveCobertura property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCveCobertura() {
		return this.cveCobertura;
	}

	/**
	 * Sets the value of the cveCobertura property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setCveCobertura(final String value) {
		this.cveCobertura = value;
	}

	/**
	 * Gets the value of the montoEstimacion property.
	 */
	public float getMontoEstimacion() {
		return this.montoEstimacion;
	}

	/**
	 * Sets the value of the montoEstimacion property.
	 */
	public void setMontoEstimacion(final float value) {
		this.montoEstimacion = value;
	}

	/**
	 * @return the cveCoberturaFlexible
	 */
	public String getCveCoberturaFlexible() {
		return cveCoberturaFlexible;
	}

	/**
	 * @param cveCoberturaFlexible the cveCoberturaFlexible to set
	 */
	public void setCveCoberturaFlexible(String cveCoberturaFlexible) {
		this.cveCoberturaFlexible = cveCoberturaFlexible;
	}

}
