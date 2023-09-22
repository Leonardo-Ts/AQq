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

import com.aaq.col.clases.database.entidades.Geocerca;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractGeocercaPunto entity provides the base persistence definition of the
 * GeocercaPunto entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractGeocercaPunto extends JMEntidad {
	private static final long serialVersionUID = 6493341926939662623L;

	// Fields

	@SequenceGenerator(name = "geocerca_puntoSEQ", sequenceName = "geocerca_punto_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geocerca_puntoSEQ")
	private Integer id;

	@Column(name = "latitud", length = 255, nullable = false, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = false, unique = false)
	private String longitud;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Geocerca.class)
	@JoinColumn(name = "id_mapa_geocerca", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Geocerca geocerca;

	// Constructors

	/** default constructor */
	public AbstractGeocercaPunto() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @return the geocerca
	 */
	public Geocerca getGeocerca() {
		return this.geocerca;
	}

	/**
	 * mfernandez Aug 7, 2014 3:42:09 PM
	 * 
	 * @param geocerca
	 *            the geocerca to set
	 */
	public void setGeocerca(final Geocerca geocerca) {
		this.geocerca = geocerca;
	}

}