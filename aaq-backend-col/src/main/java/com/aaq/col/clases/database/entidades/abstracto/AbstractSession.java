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

import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractSession entity provides the base persistence definition of the
 * Session entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractSession extends JMEntidad {

	private static final long serialVersionUID = -2650647703138039687L;

	@SequenceGenerator(name = "sessionSEQ", sequenceName = "sesion_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessionSEQ")
	private Integer id;

	@Column(name = "fecha_inicio", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaInicio;

	@Column(name = "fecha_ultimo_movimiento", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaUltimoMovimiento;

	@Column(name = "pagina_actual", length = 255, nullable = true, unique = false)
	private String paginaActual;

	@Column(name = "direccion_ip", length = 255, nullable = true, unique = false)
	private String direccionIp;

	@Column(name = "identificador_de_session", length = 255, nullable = true, unique = false)
	private String identificadorDeSession;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "idusuario", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractSession() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return this.fechaInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(final java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the fechaUltimoMovimiento
	 */
	public java.util.Date getFechaUltimoMovimiento() {
		return this.fechaUltimoMovimiento;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param fechaUltimoMovimiento
	 *            the fechaUltimoMovimiento to set
	 */
	public void setFechaUltimoMovimiento(final java.util.Date fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the paginaActual
	 */
	public String getPaginaActual() {
		return this.paginaActual;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param paginaActual
	 *            the paginaActual to set
	 */
	public void setPaginaActual(final String paginaActual) {
		this.paginaActual = paginaActual;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the direccionIp
	 */
	public String getDireccionIp() {
		return this.direccionIp;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param direccionIp
	 *            the direccionIp to set
	 */
	public void setDireccionIp(final String direccionIp) {
		this.direccionIp = direccionIp;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the identificadorDeSession
	 */
	public String getIdentificadorDeSession() {
		return this.identificadorDeSession;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param identificadorDeSession
	 *            the identificadorDeSession to set
	 */
	public void setIdentificadorDeSession(final String identificadorDeSession) {
		this.identificadorDeSession = identificadorDeSession;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:49 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

}