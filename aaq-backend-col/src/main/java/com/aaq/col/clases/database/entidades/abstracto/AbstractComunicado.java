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

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractComunicado entity provides the base persistence definition of the
 * Comunicado entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractComunicado extends JMEntidad {

	// Fields

	/**
	 *  Jan 16, 2014 11:06:06 AM
	 */
	private static final long serialVersionUID = 3685563887931948973L;

	@SequenceGenerator(name = "comunicadoSEQ", sequenceName = "comunicado_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comunicadoSEQ")
	private Integer id;

	@Column(name = "fecha_captura", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaCaptura;

	@Column(name = "fecha_inicio", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaInicio;

	@Column(name = "fecha_termino", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaTermino;

	@Column(name = "texo", nullable = true, unique = false)
	private String texo;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Base.class)
	@JoinColumn(name = "id_base", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Base base;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractComunicado() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the fechaCaptura
	 */
	public java.util.Date getFechaCaptura() {
		return this.fechaCaptura;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param fechaCaptura
	 *            the fechaCaptura to set
	 */
	public void setFechaCaptura(final java.util.Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return this.fechaInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(final java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the fechaTermino
	 */
	public java.util.Date getFechaTermino() {
		return this.fechaTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param fechaTermino
	 *            the fechaTermino to set
	 */
	public void setFechaTermino(final java.util.Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the texo
	 */
	public String getTexo() {
		return this.texo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param texo
	 *            the texo to set
	 */
	public void setTexo(final String texo) {
		this.texo = texo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the base
	 */
	public Base getBase() {
		return this.base;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param base
	 *            the base to set
	 */
	public void setBase(final Base base) {
		this.base = base;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:26:41 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

}