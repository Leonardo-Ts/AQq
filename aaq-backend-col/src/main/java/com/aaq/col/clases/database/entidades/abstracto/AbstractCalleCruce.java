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

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractCalleCruce entity provides the base persistence definition of the
 * CalleCruce entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCalleCruce extends JMEntidad {

	private static final long serialVersionUID = 5073011262526661817L;

	@SequenceGenerator(name = "calle_cruceSEQ", sequenceName = "calle_cruce_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calle_cruceSEQ")
	private Integer id;

	@Column(name = "nombre_calle_uno", length = 255, nullable = false, unique = true)
	private String nombreCalleUno;

	@Column(name = "nombre_calle_dos", length = 255, nullable = false, unique = true)
	private String nombreCalleDos;

	@Column(name = "idcolonia_uno", nullable = false, unique = true)
	private Integer idcoloniaUno;

	@Column(name = "idcolonia_dos", nullable = false, unique = true)
	private Integer idcoloniaDos;

	@Column(name = "idmunicipio_uno", nullable = false, unique = true)
	private Integer idmunicipioUno;

	@Column(name = "idmunicipio_dos", nullable = false, unique = true)
	private Integer idmunicipioDos;

	@Column(name = "latitud", nullable = false, unique = false)
	private java.lang.Double latitud;

	@Column(name = "longitud", nullable = false, unique = false)
	private java.lang.Double longitud;

	@Column(name = "nombre_colonia_uno", length = 255, nullable = false, unique = false)
	private String nombreColoniaUno;

	@Column(name = "nombre_colonia_dos", length = 255, nullable = false, unique = false)
	private String nombreColoniaDos;

	@Column(name = "nombre_municipio_uno", length = 255, nullable = false, unique = false)
	private String nombreMunicipioUno;

	@Column(name = "nombre_municipio_dos", length = 255, nullable = false, unique = false)
	private String nombreMunicipioDos;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractCalleCruce() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the nombreCalleUno
	 */
	public String getNombreCalleUno() {
		return this.nombreCalleUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param nombreCalleUno
	 *            the nombreCalleUno to set
	 */
	public void setNombreCalleUno(final String nombreCalleUno) {
		this.nombreCalleUno = nombreCalleUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the nombreCalleDos
	 */
	public String getNombreCalleDos() {
		return this.nombreCalleDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param nombreCalleDos
	 *            the nombreCalleDos to set
	 */
	public void setNombreCalleDos(final String nombreCalleDos) {
		this.nombreCalleDos = nombreCalleDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the idcoloniaUno
	 */
	public Integer getIdcoloniaUno() {
		return this.idcoloniaUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param idcoloniaUno
	 *            the idcoloniaUno to set
	 */
	public void setIdcoloniaUno(final Integer idcoloniaUno) {
		this.idcoloniaUno = idcoloniaUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the idcoloniaDos
	 */
	public Integer getIdcoloniaDos() {
		return this.idcoloniaDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param idcoloniaDos
	 *            the idcoloniaDos to set
	 */
	public void setIdcoloniaDos(final Integer idcoloniaDos) {
		this.idcoloniaDos = idcoloniaDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the idmunicipioUno
	 */
	public Integer getIdmunicipioUno() {
		return this.idmunicipioUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param idmunicipioUno
	 *            the idmunicipioUno to set
	 */
	public void setIdmunicipioUno(final Integer idmunicipioUno) {
		this.idmunicipioUno = idmunicipioUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the idmunicipioDos
	 */
	public Integer getIdmunicipioDos() {
		return this.idmunicipioDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param idmunicipioDos
	 *            the idmunicipioDos to set
	 */
	public void setIdmunicipioDos(final Integer idmunicipioDos) {
		this.idmunicipioDos = idmunicipioDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the latitud
	 */
	public java.lang.Double getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final java.lang.Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the longitud
	 */
	public java.lang.Double getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final java.lang.Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the nombreColoniaUno
	 */
	public String getNombreColoniaUno() {
		return this.nombreColoniaUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param nombreColoniaUno
	 *            the nombreColoniaUno to set
	 */
	public void setNombreColoniaUno(final String nombreColoniaUno) {
		this.nombreColoniaUno = nombreColoniaUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the nombreColoniaDos
	 */
	public String getNombreColoniaDos() {
		return this.nombreColoniaDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param nombreColoniaDos
	 *            the nombreColoniaDos to set
	 */
	public void setNombreColoniaDos(final String nombreColoniaDos) {
		this.nombreColoniaDos = nombreColoniaDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the nombreMunicipioUno
	 */
	public String getNombreMunicipioUno() {
		return this.nombreMunicipioUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param nombreMunicipioUno
	 *            the nombreMunicipioUno to set
	 */
	public void setNombreMunicipioUno(final String nombreMunicipioUno) {
		this.nombreMunicipioUno = nombreMunicipioUno;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the nombreMunicipioDos
	 */
	public String getNombreMunicipioDos() {
		return this.nombreMunicipioDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param nombreMunicipioDos
	 *            the nombreMunicipioDos to set
	 */
	public void setNombreMunicipioDos(final String nombreMunicipioDos) {
		this.nombreMunicipioDos = nombreMunicipioDos;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:14:38 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}