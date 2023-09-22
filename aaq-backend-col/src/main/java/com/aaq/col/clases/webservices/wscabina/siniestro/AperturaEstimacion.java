package com.aaq.col.clases.webservices.wscabina.siniestro;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for aperturaEstimacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aperturaEstimacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estimaciones" type="{http://webservices.ws.cabina.qualitas.com/}aperturaReserva" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cveUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aperturaEstimacion", propOrder = { "reporte", "estimaciones", "cveUsuario" })
public class AperturaEstimacion {

	protected String reporte;

	@XmlElement(name = "Estimaciones")
	protected List<AperturaReserva> estimaciones;

	protected String cveUsuario;

	/**
	 * Gets the value of the reporte property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReporte() {
		return this.reporte;
	}

	/**
	 * Sets the value of the reporte property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setReporte(final String value) {
		this.reporte = value;
	}

	/**
	 * Gets the value of the estimaciones property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the estimaciones property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEstimaciones().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link AperturaReserva }
	 */
	public List<AperturaReserva> getEstimaciones() {
		if (this.estimaciones == null) {
			this.estimaciones = new ArrayList<AperturaReserva>();
		}
		return this.estimaciones;
	}

	/**
	 * Gets the value of the cveUsuario property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCveUsuario() {
		return this.cveUsuario;
	}

	/**
	 * Sets the value of the cveUsuario property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setCveUsuario(final String value) {
		this.cveUsuario = value;
	}

}
