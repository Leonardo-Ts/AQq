package com.aaq.col.clases.webservices.wsreportes.reportes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TallerCod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TallerNombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TallerTipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TallerTipoAfectado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TallerIndiceTercero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TallerVale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TallerNotas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IDTaller" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "tallerCod", "tallerNombre", "tallerTipo", "tallerTipoAfectado",
		"tallerIndiceTercero", "tallerVale", "tallerNotas" })
@XmlRootElement(name = "Taller")
public class Taller {

	@XmlElement(name = "TallerCod", required = true)
	protected String tallerCod;
	@XmlElement(name = "TallerNombre", required = true)
	protected String tallerNombre;
	@XmlElement(name = "TallerTipo", required = true)
	protected String tallerTipo;
	@XmlElement(name = "TallerTipoAfectado", required = true)
	protected String tallerTipoAfectado;
	@XmlElement(name = "TallerIndiceTercero", required = true)
	protected String tallerIndiceTercero;
	@XmlElement(name = "TallerVale", required = true)
	protected String tallerVale;
	@XmlElement(name = "TallerNotas", required = true)
	protected String tallerNotas;
	@XmlAttribute(name = "IDTaller")
	protected String idTaller;

	public String getTallerCod() {
		return this.tallerCod;
	}

	public void setTallerCod(final String value) {
		this.tallerCod = value;
	}

	public String getTallerNombre() {
		return this.tallerNombre;
	}

	public void setTallerNombre(final String value) {
		this.tallerNombre = value;
	}

	public String getTallerTipo() {
		return this.tallerTipo;
	}

	public void setTallerTipo(final String value) {
		this.tallerTipo = value;
	}

	public String getTallerTipoAfectado() {
		return this.tallerTipoAfectado;
	}

	public void setTallerTipoAfectado(final String value) {
		this.tallerTipoAfectado = value;
	}

	public String getTallerIndiceTercero() {
		return this.tallerIndiceTercero;
	}

	public void setTallerIndiceTercero(final String value) {
		this.tallerIndiceTercero = value;
	}

	public String getTallerVale() {
		return this.tallerVale;
	}

	public void setTallerVale(final String value) {
		this.tallerVale = value;
	}

	public String getTallerNotas() {
		return this.tallerNotas;
	}

	public void setTallerNotas(final String value) {
		this.tallerNotas = value;
	}

	public String getIDTaller() {
		return this.idTaller;
	}

	public void setIDTaller(final String value) {
		this.idTaller = value;
	}

}
