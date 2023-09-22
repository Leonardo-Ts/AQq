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
 * AbstractConfiguracion entity provides the base persistence definition of the
 * Configuracion entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractConfiguracion extends JMEntidad {

	private static final long serialVersionUID = -6765323899390117109L;

	@SequenceGenerator(name = "configuracionSEQ", sequenceName = "configuracion_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuracionSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "nombre", length = 255, nullable = false, unique = false)
	private String nombre;

	@Column(name = "llave", length = 255, nullable = false, unique = true)
	private String llave;

	@Column(name = "valor", length = 512, nullable = false, unique = false)
	private String valor;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "idusuario", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractConfiguracion() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @return the llave
	 */
	public String getLlave() {
		return this.llave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @param llave
	 *            the llave to set
	 */
	public void setLlave(final String llave) {
		this.llave = llave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @return the valor
	 */
	public String getValor() {
		return this.valor;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(final String valor) {
		this.valor = valor;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:27:23 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

}