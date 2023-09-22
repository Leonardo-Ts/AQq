package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for vehiculo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehiculo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehiculo", propOrder = { "marca", "descripcionVehiculo", "color", "serie", "placa", "modelo" })
public class Vehiculo {

	protected String marca;

	protected String descripcionVehiculo;

	protected String color;

	protected String serie;

	protected String placa;

	protected String modelo;

	/**
	 * Gets the value of the marca property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * Sets the value of the marca property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setMarca(final String value) {
		this.marca = value;
	}

	/**
	 * Gets the value of the descripcionVehiculo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDescripcionVehiculo() {
		return this.descripcionVehiculo;
	}

	/**
	 * Sets the value of the descripcionVehiculo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setDescripcionVehiculo(final String value) {
		this.descripcionVehiculo = value;
	}

	/**
	 * Gets the value of the color property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Sets the value of the color property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setColor(final String value) {
		this.color = value;
	}

	/**
	 * Gets the value of the serie property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSerie() {
		return this.serie;
	}

	/**
	 * Sets the value of the serie property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setSerie(final String value) {
		this.serie = value;
	}

	/**
	 * Gets the value of the placa property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPlaca() {
		return this.placa;
	}

	/**
	 * Sets the value of the placa property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setPlaca(final String value) {
		this.placa = value;
	}

	/**
	 * Gets the value of the modelo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getModelo() {
		return this.modelo;
	}

	/**
	 * Sets the value of the modelo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setModelo(final String value) {
		this.modelo = value;
	}

}
