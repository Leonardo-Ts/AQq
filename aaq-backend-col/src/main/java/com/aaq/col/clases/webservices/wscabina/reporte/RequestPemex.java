package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for requestPemex complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestPemex">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="claseVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conductor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ficha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inventario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organismo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="placa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoUnidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestPemex", propOrder = { "claseVehiculo", "conductor", "ficha", "inventario", "marca", "modelo",
		"organismo", "placa", "reporte", "serie", "tipo", "tipoUnidad" })
public class RequestPemex {

	protected String claseVehiculo;

	protected String conductor;

	protected String ficha;

	protected String inventario;

	protected String marca;

	protected String modelo;

	protected String organismo;

	protected String placa;

	protected String reporte;

	protected String serie;

	protected String tipo;

	protected String tipoUnidad;

	/**
	 * Gets the value of the claseVehiculo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClaseVehiculo() {
		return this.claseVehiculo;
	}

	/**
	 * Sets the value of the claseVehiculo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setClaseVehiculo(final String value) {
		this.claseVehiculo = value;
	}

	/**
	 * Gets the value of the conductor property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getConductor() {
		return this.conductor;
	}

	/**
	 * Sets the value of the conductor property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setConductor(final String value) {
		this.conductor = value;
	}

	/**
	 * Gets the value of the ficha property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFicha() {
		return this.ficha;
	}

	/**
	 * Sets the value of the ficha property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setFicha(final String value) {
		this.ficha = value;
	}

	/**
	 * Gets the value of the inventario property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInventario() {
		return this.inventario;
	}

	/**
	 * Sets the value of the inventario property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setInventario(final String value) {
		this.inventario = value;
	}

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

	

	public String getOrganismo() {
		return organismo;
	}

	public void setOrganismo(String organismo) {
		this.organismo = organismo;
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
	 * Gets the value of the tipo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Sets the value of the tipo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTipo(final String value) {
		this.tipo = value;
	}

	/**
	 * Gets the value of the tipoUnidad property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTipoUnidad() {
		return this.tipoUnidad;
	}

	/**
	 * Sets the value of the tipoUnidad property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTipoUnidad(final String value) {
		this.tipoUnidad = value;
	}

}
