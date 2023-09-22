package com.aaq.col.clases.webservices.wscabina.reporte;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("all")
/**
 * <p>Java class for getReportesResultado complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReportesResultado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="reporte" type="{http://webservices.ws.cabina.qualitas.com/}reporte" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="error" type="{http://webservices.ws.cabina.qualitas.com/}error" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReportesResultado", propOrder = { "reportes", "error" })
public class GetReportesResultado {

	protected GetReportesResultado.Reportes reportes;

	protected Error error;

	/**
	 * Gets the value of the reportes property.
	 * 
	 * @return possible object is {@link GetReportesResultado.Reportes }
	 */
	public GetReportesResultado.Reportes getReportes() {
		return this.reportes;
	}

	/**
	 * Sets the value of the reportes property.
	 * 
	 * @param value
	 *            allowed object is {@link GetReportesResultado.Reportes }
	 */
	public void setReportes(final GetReportesResultado.Reportes value) {
		this.reportes = value;
	}

	/**
	 * Gets the value of the error property.
	 * 
	 * @return possible object is {@link Error }
	 */
	public Error getError() {
		return this.error;
	}

	/**
	 * Sets the value of the error property.
	 * 
	 * @param value
	 *            allowed object is {@link Error }
	 */
	public void setError(final Error value) {
		this.error = value;
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
	 *         &lt;element name="reporte" type="{http://webservices.ws.cabina.qualitas.com/}reporte" maxOccurs="unbounded" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "reporte" })
	public static class Reportes {

		protected List<Reporte> reporte;

		/**
		 * Gets the value of the reporte property.
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the reporte property.
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getReporte().add(newItem);
		 * </pre>
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link Reporte }
		 */
		public List<Reporte> getReporte() {
			if (this.reporte == null) {
				this.reporte = new ArrayList<Reporte>();
			}
			return this.reporte;
		}

	}

}
