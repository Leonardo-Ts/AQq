package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractMensajeSms entity provides the base persistence definition of the
 * MensajeSms entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractMensajeSms extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5531898982724293491L;

	@SequenceGenerator(name = "mensaje_smsSEQ", sequenceName = "mensaje_sms_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensaje_smsSEQ")
	private Integer id;

	@Column(name = "telefonodestino", length = 255, nullable = false, unique = false)
	private String telefonodestino;

	@Column(name = "numeroreporte", length = 255, nullable = true, unique = true)
	private String numeroreporte;

	@Column(name = "causa", length = 255, nullable = true, unique = false)
	private String causa;

	@Column(name = "descripcioncausa", nullable = true, unique = false)
	private String descripcioncausa;

	@Column(name = "ramo", length = 255, nullable = true, unique = false)
	private String ramo;

	@Column(name = "ejercicio", length = 255, nullable = true, unique = false)
	private String ejercicio;

	@Column(name = "poliza", length = 255, nullable = true, unique = true)
	private String poliza;

	@Column(name = "agente", length = 255, nullable = true, unique = true)
	private String agente;

	@Column(name = "oficina", length = 255, nullable = true, unique = true)
	private String oficina;

	@Column(name = "gerente", length = 255, nullable = true, unique = true)
	private String gerente;

	@Column(name = "asegurado", length = 255, nullable = true, unique = false)
	private String asegurado;

	@Column(name = "texto", nullable = true, unique = false)
	private String texto;
	
	@Column(name = "fecha", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "mensajeoriginal", nullable = true, unique = false)
	private String mensajeoriginal;

	@Column(name = "direccion_ip", length = 255, nullable = true, unique = false)
	private String direccionIp;

	@Column(name = "uid_android", nullable = true, unique = false)
	private String uid_android;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractMensajeSms() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the telefonodestino
	 */
	public String getTelefonodestino() {
		return this.telefonodestino;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param telefonodestino
	 *            the telefonodestino to set
	 */
	public void setTelefonodestino(final String telefonodestino) {
		this.telefonodestino = telefonodestino;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the numeroreporte
	 */
	public String getNumeroreporte() {
		return this.numeroreporte;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param numeroreporte
	 *            the numeroreporte to set
	 */
	public void setNumeroreporte(final String numeroreporte) {
		this.numeroreporte = numeroreporte;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the causa
	 */
	public String getCausa() {
		return this.causa;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param causa
	 *            the causa to set
	 */
	public void setCausa(final String causa) {
		this.causa = causa;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the descripcioncausa
	 */
	public String getDescripcioncausa() {
		return this.descripcioncausa;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param descripcioncausa
	 *            the descripcioncausa to set
	 */
	public void setDescripcioncausa(final String descripcioncausa) {
		this.descripcioncausa = descripcioncausa;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the ramo
	 */
	public String getRamo() {
		return this.ramo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param ramo
	 *            the ramo to set
	 */
	public void setRamo(final String ramo) {
		this.ramo = ramo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the ejercicio
	 */
	public String getEjercicio() {
		return this.ejercicio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param ejercicio
	 *            the ejercicio to set
	 */
	public void setEjercicio(final String ejercicio) {
		this.ejercicio = ejercicio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the poliza
	 */
	public String getPoliza() {
		return this.poliza;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param poliza
	 *            the poliza to set
	 */
	public void setPoliza(final String poliza) {
		this.poliza = poliza;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the agente
	 */
	public String getAgente() {
		return this.agente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param agente
	 *            the agente to set
	 */
	public void setAgente(final String agente) {
		this.agente = agente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the oficina
	 */
	public String getOficina() {
		return this.oficina;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param oficina
	 *            the oficina to set
	 */
	public void setOficina(final String oficina) {
		this.oficina = oficina;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the gerente
	 */
	public String getGerente() {
		return this.gerente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param gerente
	 *            the gerente to set
	 */
	public void setGerente(final String gerente) {
		this.gerente = gerente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the asegurado
	 */
	public String getAsegurado() {
		return this.asegurado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param asegurado
	 *            the asegurado to set
	 */
	public void setAsegurado(final String asegurado) {
		this.asegurado = asegurado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the texto
	 */
	public String getTexto() {
		return this.texto;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param texto
	 *            the texto to set
	 */
	public void setTexto(final String texto) {
		this.texto = texto;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the mensajeoriginal
	 */
	public String getMensajeoriginal() {
		return this.mensajeoriginal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param mensajeoriginal
	 *            the mensajeoriginal to set
	 */
	public void setMensajeoriginal(final String mensajeoriginal) {
		this.mensajeoriginal = mensajeoriginal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the direccionIp
	 */
	public String getDireccionIp() {
		return this.direccionIp;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param direccionIp
	 *            the direccionIp to set
	 */
	public void setDireccionIp(final String direccionIp) {
		this.direccionIp = direccionIp;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:45:28 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUid_android() {
		return uid_android;
	}

	public void setUid_android(String uid_android) {
		this.uid_android = uid_android;
	}
	
	
	


}