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
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractSessionExterna extends JMEntidad {
	private static final long serialVersionUID = -1619091642400467095L;

	@SequenceGenerator(name = "session_externaSEQ", sequenceName = "session_externa_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_externaSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "operacion", length = 255, nullable = false, unique = false)
	private String operacion;

	@Column(name = "valida", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean valida;

	@Column(name = "estado", length = 255, nullable = true, unique = false)
	private String estado;

	@Column(name = "base", length = 255, nullable = true, unique = false)
	private String base;

	@Column(name = "proveedor", length = 255, nullable = true, unique = false)
	private String proveedor;

	@Column(name = "radio", length = 255, nullable = true, unique = false)
	private String radio;

	@Column(name = "nombre", length = 255, nullable = true, unique = false)
	private String nombre;

	@Column(name = "estatus", length = 255, nullable = true, unique = false)
	private String estatus;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	/** default constructor */
	public AbstractSessionExterna() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the operacion
	 */
	public String getOperacion() {
		return this.operacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param operacion
	 *            the operacion to set
	 */
	public void setOperacion(final String operacion) {
		this.operacion = operacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the valida
	 */
	public Boolean getValida() {
		return this.valida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param valida
	 *            the valida to set
	 */
	public void setValida(final Boolean valida) {
		this.valida = valida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the estado
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final String estado) {
		this.estado = estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the base
	 */
	public String getBase() {
		return this.base;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param base
	 *            the base to set
	 */
	public void setBase(final String base) {
		this.base = base;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the proveedor
	 */
	public String getProveedor() {
		return this.proveedor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(final String proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the radio
	 */
	public String getRadio() {
		return this.radio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param radio
	 *            the radio to set
	 */
	public void setRadio(final String radio) {
		this.radio = radio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the estatus
	 */
	public String getEstatus() {
		return this.estatus;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(final String estatus) {
		this.estatus = estatus;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:15:43 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

}