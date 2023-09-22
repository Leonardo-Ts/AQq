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

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractTerminalAlertaLog entity provides the base persistence definition of
 * the TerminalAlertaLog entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTerminalAlertaLog extends JMEntidad {

	private static final long serialVersionUID = 3358495911363733789L;

	@SequenceGenerator(name = "terminal_alerta_logSEQ", sequenceName = "terminal_alerta_log_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_alerta_logSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "latitud", length = 255, nullable = false, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = false, unique = false)
	private String longitud;

	@Column(name = "tipo", length = 255, nullable = false, unique = false)
	private String tipo;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "enviada_sms", nullable = false, unique = false)
	@Convert("booleanConverter")
	private Boolean enviadaSms;

	@Column(name = "enviada_email", nullable = false, unique = false)
	@Convert("booleanConverter")
	private Boolean enviadaEmail;

	@Column(name = "enviada_web", nullable = false, unique = false)
	@Convert("booleanConverter")
	private Boolean enviadaWeb;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = TerminalAlerta.class)
	@JoinColumn(name = "id_terminal_alerta", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private TerminalAlerta terminalAlerta;

	// Constructors

	/** default constructor */
	public AbstractTerminalAlertaLog() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the enviadaSms
	 */
	public Boolean getEnviadaSms() {
		return this.enviadaSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param enviadaSms
	 *            the enviadaSms to set
	 */
	public void setEnviadaSms(final Boolean enviadaSms) {
		this.enviadaSms = enviadaSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the enviadaEmail
	 */
	public Boolean getEnviadaEmail() {
		return this.enviadaEmail;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param enviadaEmail
	 *            the enviadaEmail to set
	 */
	public void setEnviadaEmail(final Boolean enviadaEmail) {
		this.enviadaEmail = enviadaEmail;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the enviadaWeb
	 */
	public Boolean getEnviadaWeb() {
		return this.enviadaWeb;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param enviadaWeb
	 *            the enviadaWeb to set
	 */
	public void setEnviadaWeb(final Boolean enviadaWeb) {
		this.enviadaWeb = enviadaWeb;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @return the terminalAlerta
	 */
	public TerminalAlerta getTerminalAlerta() {
		return this.terminalAlerta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:43:44 PM
	 * 
	 * @param terminalAlerta
	 *            the terminalAlerta to set
	 */
	public void setTerminalAlerta(final TerminalAlerta terminalAlerta) {
		this.terminalAlerta = terminalAlerta;
	}

}