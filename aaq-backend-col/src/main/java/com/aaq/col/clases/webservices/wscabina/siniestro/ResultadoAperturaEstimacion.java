package com.aaq.col.clases.webservices.wscabina.siniestro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for resultadoAperturaEstimacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultadoAperturaEstimacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroEstimacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroSiniestro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resultado" type="{http://webservices.ws.cabina.qualitas.com/}resultado" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoAperturaEstimacion", propOrder = { "numeroEstimacion", "numeroSiniestro", "resultado" })
public class ResultadoAperturaEstimacion {

	protected int numeroEstimacion;

	protected String numeroSiniestro;

	protected Resultado resultado;

	/**
	 * Gets the value of the numeroEstimacion property.
	 */
	public int getNumeroEstimacion() {
		return this.numeroEstimacion;
	}

	/**
	 * Sets the value of the numeroEstimacion property.
	 */
	public void setNumeroEstimacion(final int value) {
		this.numeroEstimacion = value;
	}

	/**
	 * Gets the value of the numeroSiniestro property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumeroSiniestro() {
		return this.numeroSiniestro;
	}

	/**
	 * Sets the value of the numeroSiniestro property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNumeroSiniestro(final String value) {
		this.numeroSiniestro = value;
	}

	/**
	 * Gets the value of the resultado property.
	 * 
	 * @return possible object is {@link Resultado }
	 */
	public Resultado getResultado() {
		return this.resultado;
	}

	/**
	 * Sets the value of the resultado property.
	 * 
	 * @param value
	 *            allowed object is {@link Resultado }
	 */
	public void setResultado(final Resultado value) {
		this.resultado = value;
	}

}
