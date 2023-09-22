 package com.aaq.col.clases.webservices.wscabina.reporte;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@SuppressWarnings("all")
/**
 * <p>Java class for reporte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reporte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroAjustador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estatusReporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroSiniestro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SUVA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poliza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endoso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inciso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conductor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cveCausa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaOcurrido" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="codigoOficina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claveAgente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreGerenteComercial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreDirectorOficina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detalleSiniestro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claveAsegurado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RFC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreAsegurado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="inicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="finVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionVehiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serieVin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primaTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="descCausa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vehiculo" type="{http://webservices.ws.cabina.qualitas.com/}vehiculo" minOccurs="0"/>
 *         &lt;element name="Terceros" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tercero" type="{http://webservices.ws.cabina.qualitas.com/}tercero" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="numeroReporte" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reporte", propOrder = { "numeroAjustador", "estatusReporte", "numeroSiniestro", "suva", "poliza",
		"endoso", "inciso", "descripcion", "conductor", "cveCausa", "fechaOcurrido", "codigoOficina", "claveAgente",
		"nombreGerenteComercial", "nombreDirectorOficina", "detalleSiniestro", "claveAsegurado", "rfc",
		"nombreAsegurado", "fechaEmision", "inicioVigencia", "finVigencia", "marca", "descripcionVehiculo", "modelo",
		"color", "serieVin", "primaTotal", "descCausa", "vehiculo", "terceros" })
public class Reporte {

	protected String numeroAjustador;

	protected String estatusReporte;

	protected String numeroSiniestro;

	@XmlElement(name = "SUVA")
	protected String suva;

	protected String poliza;

	protected String endoso;

	protected String inciso;

	protected String descripcion;

	protected String conductor;

	protected String cveCausa;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fechaOcurrido;

	protected String codigoOficina;

	protected String claveAgente;

	protected String nombreGerenteComercial;

	protected String nombreDirectorOficina;

	protected String detalleSiniestro;

	protected String claveAsegurado;

	@XmlElement(name = "RFC")
	protected String rfc;

	protected String nombreAsegurado;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar fechaEmision;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar inicioVigencia;

	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar finVigencia;

	protected String marca;

	protected String descripcionVehiculo;

	protected String modelo;

	protected String color;

	protected String serieVin;

	protected BigDecimal primaTotal;

	protected String descCausa;

	protected Vehiculo vehiculo;

	@XmlElement(name = "Terceros")
	protected Terceros terceros;

	@XmlAttribute(name = "numeroReporte")
	protected String numeroReporte;

	/**
	 * Gets the value of the numeroAjustador property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumeroAjustador() {
		return this.numeroAjustador;
	}

	/**
	 * Sets the value of the numeroAjustador property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNumeroAjustador(final String value) {
		this.numeroAjustador = value;
	}

	/**
	 * Gets the value of the estatusReporte property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEstatusReporte() {
		return this.estatusReporte;
	}

	/**
	 * Sets the value of the estatusReporte property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setEstatusReporte(final String value) {
		this.estatusReporte = value;
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
	 * Gets the value of the suva property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSUVA() {
		return this.suva;
	}

	/**
	 * Sets the value of the suva property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setSUVA(final String value) {
		this.suva = value;
	}

	/**
	 * Gets the value of the poliza property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPoliza() {
		return this.poliza;
	}

	/**
	 * Sets the value of the poliza property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setPoliza(final String value) {
		this.poliza = value;
	}

	/**
	 * Gets the value of the endoso property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEndoso() {
		return this.endoso;
	}

	/**
	 * Sets the value of the endoso property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setEndoso(final String value) {
		this.endoso = value;
	}

	/**
	 * Gets the value of the inciso property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInciso() {
		return this.inciso;
	}

	/**
	 * Sets the value of the inciso property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setInciso(final String value) {
		this.inciso = value;
	}

	/**
	 * Gets the value of the descripcion property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Sets the value of the descripcion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setDescripcion(final String value) {
		this.descripcion = value;
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
	 * Gets the value of the cveCausa property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCveCausa() {
		return this.cveCausa;
	}

	/**
	 * Sets the value of the cveCausa property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setCveCausa(final String value) {
		this.cveCausa = value;
	}

	/**
	 * Gets the value of the fechaOcurrido property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFechaOcurrido() {
		return this.fechaOcurrido;
	}

	/**
	 * Sets the value of the fechaOcurrido property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFechaOcurrido(final XMLGregorianCalendar value) {
		this.fechaOcurrido = value;
	}

	/**
	 * Gets the value of the codigoOficina property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCodigoOficina() {
		return this.codigoOficina;
	}

	/**
	 * Sets the value of the codigoOficina property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setCodigoOficina(final String value) {
		this.codigoOficina = value;
	}

	/**
	 * Gets the value of the claveAgente property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClaveAgente() {
		return this.claveAgente;
	}

	/**
	 * Sets the value of the claveAgente property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setClaveAgente(final String value) {
		this.claveAgente = value;
	}

	/**
	 * Gets the value of the nombreGerenteComercial property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNombreGerenteComercial() {
		return this.nombreGerenteComercial;
	}

	/**
	 * Sets the value of the nombreGerenteComercial property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNombreGerenteComercial(final String value) {
		this.nombreGerenteComercial = value;
	}

	/**
	 * Gets the value of the nombreDirectorOficina property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNombreDirectorOficina() {
		return this.nombreDirectorOficina;
	}

	/**
	 * Sets the value of the nombreDirectorOficina property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNombreDirectorOficina(final String value) {
		this.nombreDirectorOficina = value;
	}

	/**
	 * Gets the value of the detalleSiniestro property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDetalleSiniestro() {
		return this.detalleSiniestro;
	}

	/**
	 * Sets the value of the detalleSiniestro property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setDetalleSiniestro(final String value) {
		this.detalleSiniestro = value;
	}

	/**
	 * Gets the value of the claveAsegurado property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClaveAsegurado() {
		return this.claveAsegurado;
	}

	/**
	 * Sets the value of the claveAsegurado property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setClaveAsegurado(final String value) {
		this.claveAsegurado = value;
	}

	/**
	 * Gets the value of the rfc property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRFC() {
		return this.rfc;
	}

	/**
	 * Sets the value of the rfc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setRFC(final String value) {
		this.rfc = value;
	}

	/**
	 * Gets the value of the nombreAsegurado property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNombreAsegurado() {
		return this.nombreAsegurado;
	}

	/**
	 * Sets the value of the nombreAsegurado property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNombreAsegurado(final String value) {
		this.nombreAsegurado = value;
	}

	/**
	 * Gets the value of the fechaEmision property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFechaEmision() {
		return this.fechaEmision;
	}

	/**
	 * Sets the value of the fechaEmision property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFechaEmision(final XMLGregorianCalendar value) {
		this.fechaEmision = value;
	}

	/**
	 * Gets the value of the inicioVigencia property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getInicioVigencia() {
		return this.inicioVigencia;
	}

	/**
	 * Sets the value of the inicioVigencia property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 */
	public void setInicioVigencia(final XMLGregorianCalendar value) {
		this.inicioVigencia = value;
	}

	/**
	 * Gets the value of the finVigencia property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFinVigencia() {
		return this.finVigencia;
	}

	/**
	 * Sets the value of the finVigencia property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFinVigencia(final XMLGregorianCalendar value) {
		this.finVigencia = value;
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
	 * Gets the value of the serieVin property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSerieVin() {
		return this.serieVin;
	}

	/**
	 * Sets the value of the serieVin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setSerieVin(final String value) {
		this.serieVin = value;
	}

	/**
	 * Gets the value of the primaTotal property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getPrimaTotal() {
		return this.primaTotal;
	}

	/**
	 * Sets the value of the primaTotal property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 */
	public void setPrimaTotal(final BigDecimal value) {
		this.primaTotal = value;
	}

	/**
	 * Gets the value of the descCausa property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDescCausa() {
		return this.descCausa;
	}

	/**
	 * Sets the value of the descCausa property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setDescCausa(final String value) {
		this.descCausa = value;
	}

	/**
	 * Gets the value of the vehiculo property.
	 * 
	 * @return possible object is {@link Vehiculo }
	 */
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	/**
	 * Sets the value of the vehiculo property.
	 * 
	 * @param value
	 *            allowed object is {@link Vehiculo }
	 */
	public void setVehiculo(final Vehiculo value) {
		this.vehiculo = value;
	}

	/**
	 * Gets the value of the terceros property.
	 * 
	 * @return possible object is {@link Reporte.Terceros }
	 */
	public Reporte.Terceros getTerceros() {
		return this.terceros;
	}

	/**
	 * Sets the value of the terceros property.
	 * 
	 * @param value
	 *            allowed object is {@link Reporte.Terceros }
	 */
	public void setTerceros(final Reporte.Terceros value) {
		this.terceros = value;
	}

	/**
	 * Gets the value of the numeroReporte property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}

	/**
	 * Sets the value of the numeroReporte property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setNumeroReporte(final String value) {
		this.numeroReporte = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="tercero" type="{http://webservices.ws.cabina.qualitas.com/}tercero" maxOccurs="unbounded" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "tercero" })
	public static class Terceros {

		protected List<Tercero> tercero;

		/**
		 * Gets the value of the tercero property.
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the tercero property.
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getTercero().add(newItem);
		 * </pre>
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link Tercero }
		 */
		public List<Tercero> getTercero() {
			if (this.tercero == null) {
				this.tercero = new ArrayList<Tercero>();
			}
			return this.tercero;
		}

	}

}
