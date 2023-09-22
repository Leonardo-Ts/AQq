package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

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

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTerminalAlerta extends JMEntidad {
	private static final long serialVersionUID = 6426214032383503566L;

	@SequenceGenerator(name = "terminal_alertaSEQ", sequenceName = "terminal_alerta_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_alertaSEQ")
	private Integer id;

	@Column(name = "por_velocidad_mayor_kmh", nullable = true, unique = false)
	private Integer porVelocidadMayorKmh;

	@Column(name = "POR_TIE_PARADO_MAYOR_MIN", nullable = true, unique = false)
	private Integer porTiempoDeParadoMayorMinutos;

	@Column(name = "direccion_correo", length = 512, nullable = true, unique = false)
	private String direccionCorreo;

	@Column(name = "telefono_sms", length = 512, nullable = true, unique = false)
	private String telefonoSms;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@Column(name = "POR_PUNTO_INTERES_DIS_MTS", nullable = true, unique = false)
	private Integer porIdPuntoInteresDistanciaMetros;

	@Column(name = "hora_inicio", nullable = true, unique = false)
	@Temporal(TemporalType.TIME)
	private Date horaInicio;

	@Column(name = "hora_termino", nullable = true, unique = false)
	@Temporal(TemporalType.TIME)
	private Date horaTermino;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Geocerca.class)
	@JoinColumn(name = "por_id_geocerca_entra", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Geocerca geocercaByPorIdGeocercaEntra;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Geocerca.class)
	@JoinColumn(name = "por_id_geocerca_sale", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Geocerca geocercaByPorIdGeocercaSale;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PuntoInteres.class)
	@JoinColumn(name = "por_id_punto_interes", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private PuntoInteres puntoInteres;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terinal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	// Constructors

	/** default constructor */
	public AbstractTerminalAlerta() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the porVelocidadMayorKmh
	 */
	public Integer getPorVelocidadMayorKmh() {
		return this.porVelocidadMayorKmh;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param porVelocidadMayorKmh
	 *            the porVelocidadMayorKmh to set
	 */
	public void setPorVelocidadMayorKmh(final Integer porVelocidadMayorKmh) {
		this.porVelocidadMayorKmh = porVelocidadMayorKmh;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the porTiempoDeParadoMayorMinutos
	 */
	public Integer getPorTiempoDeParadoMayorMinutos() {
		return this.porTiempoDeParadoMayorMinutos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param porTiempoDeParadoMayorMinutos
	 *            the porTiempoDeParadoMayorMinutos to set
	 */
	public void setPorTiempoDeParadoMayorMinutos(final Integer porTiempoDeParadoMayorMinutos) {
		this.porTiempoDeParadoMayorMinutos = porTiempoDeParadoMayorMinutos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the direccionCorreo
	 */
	public String getDireccionCorreo() {
		return this.direccionCorreo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param direccionCorreo
	 *            the direccionCorreo to set
	 */
	public void setDireccionCorreo(final String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the telefonoSms
	 */
	public String getTelefonoSms() {
		return this.telefonoSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param telefonoSms
	 *            the telefonoSms to set
	 */
	public void setTelefonoSms(final String telefonoSms) {
		this.telefonoSms = telefonoSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the porIdPuntoInteresDistanciaMetros
	 */
	public Integer getPorIdPuntoInteresDistanciaMetros() {
		return this.porIdPuntoInteresDistanciaMetros;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param porIdPuntoInteresDistanciaMetros
	 *            the porIdPuntoInteresDistanciaMetros to set
	 */
	public void setPorIdPuntoInteresDistanciaMetros(final Integer porIdPuntoInteresDistanciaMetros) {
		this.porIdPuntoInteresDistanciaMetros = porIdPuntoInteresDistanciaMetros;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the horaInicio
	 */
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param horaInicio
	 *            the horaInicio to set
	 */
	public void setHoraInicio(final Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the horaTermino
	 */
	public Date getHoraTermino() {
		return this.horaTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param horaTermino
	 *            the horaTermino to set
	 */
	public void setHoraTermino(final Date horaTermino) {
		this.horaTermino = horaTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the geocercaByPorIdGeocercaEntra
	 */
	public Geocerca getGeocercaByPorIdGeocercaEntra() {
		return this.geocercaByPorIdGeocercaEntra;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param geocercaByPorIdGeocercaEntra
	 *            the geocercaByPorIdGeocercaEntra to set
	 */
	public void setGeocercaByPorIdGeocercaEntra(final Geocerca geocercaByPorIdGeocercaEntra) {
		this.geocercaByPorIdGeocercaEntra = geocercaByPorIdGeocercaEntra;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the geocercaByPorIdGeocercaSale
	 */
	public Geocerca getGeocercaByPorIdGeocercaSale() {
		return this.geocercaByPorIdGeocercaSale;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param geocercaByPorIdGeocercaSale
	 *            the geocercaByPorIdGeocercaSale to set
	 */
	public void setGeocercaByPorIdGeocercaSale(final Geocerca geocercaByPorIdGeocercaSale) {
		this.geocercaByPorIdGeocercaSale = geocercaByPorIdGeocercaSale;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the puntoInteres
	 */
	public PuntoInteres getPuntoInteres() {
		return this.puntoInteres;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param puntoInteres
	 *            the puntoInteres to set
	 */
	public void setPuntoInteres(final PuntoInteres puntoInteres) {
		this.puntoInteres = puntoInteres;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:01 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

}