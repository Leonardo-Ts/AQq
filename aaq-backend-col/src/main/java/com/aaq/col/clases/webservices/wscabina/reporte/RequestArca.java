package com.aaq.col.clases.webservices.wscabina.reporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for requestArca complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestArca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcionHechos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="existeDPA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lesionados" type="{http://webservices.ws.cabina.qualitas.com/}lesionados" minOccurs="0"/>
 *         &lt;element name="montoAproxDanos" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="obra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="presenciaMedios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="turnadoLegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vehiculosImplicados" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestArca", propOrder = { "descripcionHechos", "existeDPA", "lesionados", "montoAproxDanos", "obra",
		"presenciaMedios", "reporte", "turnadoLegal", "vehiculosImplicados", "fallecidos", "numFallecidos"})
public class RequestArca {

	protected String descripcionHechos;

	protected String existeDPA;

	protected Lesionados lesionados;

	protected Float montoAproxDanos;

	protected String obra;

	protected String presenciaMedios;

	protected String reporte;

	protected String turnadoLegal;

	protected Integer vehiculosImplicados;
	
	protected String fallecidos;
	
	protected Integer numFallecidos;
	

	/**
	 * Gets the value of the descripcionHechos property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDescripcionHechos() {
		return this.descripcionHechos;
	}

	/**
	 * Sets the value of the descripcionHechos property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setDescripcionHechos(final String value) {
		this.descripcionHechos = value;
	}

	/**
	 * Gets the value of the existeDPA property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getExisteDPA() {
		return this.existeDPA;
	}

	/**
	 * Sets the value of the existeDPA property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setExisteDPA(final String value) {
		this.existeDPA = value;
	}

	/**
	 * Gets the value of the lesionados property.
	 * 
	 * @return possible object is {@link Lesionados }
	 */
	public Lesionados getLesionados() {
		return this.lesionados;
	}

	/**
	 * Sets the value of the lesionados property.
	 * 
	 * @param value
	 *            allowed object is {@link Lesionados }
	 */
	public void setLesionados(final Lesionados value) {
		this.lesionados = value;
	}

	/**
	 * Gets the value of the montoAproxDanos property.
	 * 
	 * @return possible object is {@link Float }
	 */
	public Float getMontoAproxDanos() {
		return this.montoAproxDanos;
	}

	/**
	 * Sets the value of the montoAproxDanos property.
	 * 
	 * @param value
	 *            allowed object is {@link Float }
	 */
	public void setMontoAproxDanos(final Float value) {
		this.montoAproxDanos = value;
	}

	/**
	 * Gets the value of the obra property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getObra() {
		return this.obra;
	}

	/**
	 * Sets the value of the obra property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setObra(final String value) {
		this.obra = value;
	}

	/**
	 * Gets the value of the presenciaMedios property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPresenciaMedios() {
		return this.presenciaMedios;
	}

	/**
	 * Sets the value of the presenciaMedios property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setPresenciaMedios(final String value) {
		this.presenciaMedios = value;
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
	 * Gets the value of the turnadoLegal property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTurnadoLegal() {
		return this.turnadoLegal;
	}

	/**
	 * Sets the value of the turnadoLegal property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setTurnadoLegal(final String value) {
		this.turnadoLegal = value;
	}

	/**
	 * Gets the value of the vehiculosImplicados property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getVehiculosImplicados() {
		return this.vehiculosImplicados;
	}

	/**
	 * Sets the value of the vehiculosImplicados property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 */
	public void setVehiculosImplicados(final Integer value) {
		this.vehiculosImplicados = value;
	}

	public String getFallecidos() {
		return fallecidos;
	}

	public void setFallecidos(String fallecidos) {
		this.fallecidos = fallecidos;
	}

	public Integer getNumFallecidos() {
		return numFallecidos;
	}

	public void setNumFallecidos(Integer numFallecidos) {
		this.numFallecidos = numFallecidos;
	}

}
