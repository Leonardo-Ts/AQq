package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for datosPemexResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datosPemexResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Resultado" type="{http://webservices.ws.cabina.qualitas.com/}resultado" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosPemexResponse", propOrder = { "resultado" })
public class DatosPemexResponse {

	@XmlElement(name = "Resultado")
	protected Resultado resultado;

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
