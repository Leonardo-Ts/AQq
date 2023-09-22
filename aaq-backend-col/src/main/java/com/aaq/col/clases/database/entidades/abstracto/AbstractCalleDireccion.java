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


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCalleDireccion extends JMEntidad {

	private static final long serialVersionUID = -6485261314847450407L;

	@SequenceGenerator(name = "calle_direccionSEQ", sequenceName = "calle_direccion_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calle_direccionSEQ")
	private Integer id;

	@Column(name = "prec", nullable = true, unique = false)
	private Integer prec;

	@Column(name = "fecha", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "latitud", length = 255, nullable = false, unique = true)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = false, unique = true)
	private String longitud;

	@Column(name = "direccion", nullable = true, unique = false)
	private String direccion;

	// Constructors

	/** default constructor */
	public AbstractCalleDireccion() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @return the prec
	 */
	public Integer getPrec() {
		return this.prec;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @param prec
	 *            the prec to set
	 */
	public void setPrec(final Integer prec) {
		this.prec = prec;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:15:15 PM
	 * 
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

}