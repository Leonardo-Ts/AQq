package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractReporteMovil entity provides the base persistence definition of the
 * ReporteMovil entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReporteMovil extends JMEntidad {

	private static final long serialVersionUID = -5603228037082682542L;

	@SequenceGenerator(name = "reporte_movilSEQ", sequenceName = "reporte_movil_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_movilSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "poliza", length = 255, nullable = true, unique = false)
	private String poliza;

	@Column(name = "endoso", length = 255, nullable = true, unique = false)
	private String endoso;

	@Column(name = "inciso", length = 255, nullable = true, unique = false)
	private String inciso;

	@Column(name = "latitud", length = 255, nullable = true, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = true, unique = false)
	private String longitud;

	@Column(name = "causa", length = 255, nullable = true, unique = false)
	private String causa;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;

	@Column(name = "nombre_reporta", length = 255, nullable = true, unique = false)
	private String nombreReporta;

	@Column(name = "nombre_conductor", length = 255, nullable = true, unique = false)
	private String nombreConductor;

	@Column(name = "telefono_contacto", length = 255, nullable = true, unique = false)
	private String telefonoContacto;

	@Column(name = "sise_reporte", length = 255, nullable = true, unique = false)
	private String siseReporte;

	@Column(name = "sise_siniestro", length = 255, nullable = true, unique = false)
	private String siseSiniestro;

	@Column(name = "fecha_visto", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaVisto;

	@Column(name = "fuente", length = 255, nullable = true, unique = false)
	private String fuente;

	@Column(name = "agente", length = 255, nullable = true, unique = false)
	private String agente;

	// Constructors

	/** default constructor */
	public AbstractReporteMovil() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the poliza
	 */
	public String getPoliza() {
		return this.poliza;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param poliza
	 *            the poliza to set
	 */
	public void setPoliza(final String poliza) {
		this.poliza = poliza;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the endoso
	 */
	public String getEndoso() {
		return this.endoso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param endoso
	 *            the endoso to set
	 */
	public void setEndoso(final String endoso) {
		this.endoso = endoso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the inciso
	 */
	public String getInciso() {
		return this.inciso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param inciso
	 *            the inciso to set
	 */
	public void setInciso(final String inciso) {
		this.inciso = inciso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the causa
	 */
	public String getCausa() {
		return this.causa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param causa
	 *            the causa to set
	 */
	public void setCausa(final String causa) {
		this.causa = causa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the nombreReporta
	 */
	public String getNombreReporta() {
		return this.nombreReporta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param nombreReporta
	 *            the nombreReporta to set
	 */
	public void setNombreReporta(final String nombreReporta) {
		this.nombreReporta = nombreReporta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the nombreConductor
	 */
	public String getNombreConductor() {
		return this.nombreConductor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param nombreConductor
	 *            the nombreConductor to set
	 */
	public void setNombreConductor(final String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the telefonoContacto
	 */
	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param telefonoContacto
	 *            the telefonoContacto to set
	 */
	public void setTelefonoContacto(final String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the siseReporte
	 */
	public String getSiseReporte() {
		return this.siseReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param siseReporte
	 *            the siseReporte to set
	 */
	public void setSiseReporte(final String siseReporte) {
		this.siseReporte = siseReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the siseSiniestro
	 */
	public String getSiseSiniestro() {
		return this.siseSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param siseSiniestro
	 *            the siseSiniestro to set
	 */
	public void setSiseSiniestro(final String siseSiniestro) {
		this.siseSiniestro = siseSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the fechaVisto
	 */
	public java.util.Date getFechaVisto() {
		return this.fechaVisto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param fechaVisto
	 *            the fechaVisto to set
	 */
	public void setFechaVisto(final java.util.Date fechaVisto) {
		this.fechaVisto = fechaVisto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the fuente
	 */
	public String getFuente() {
		return this.fuente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param fuente
	 *            the fuente to set
	 */
	public void setFuente(final String fuente) {
		this.fuente = fuente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @return the agente
	 */
	public String getAgente() {
		return this.agente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:08:25 PM
	 * 
	 * @param agente
	 *            the agente to set
	 */
	public void setAgente(final String agente) {
		this.agente = agente;
	}

}