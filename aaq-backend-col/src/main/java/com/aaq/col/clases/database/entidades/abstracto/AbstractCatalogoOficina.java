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

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoOficina extends JMEntidad {

	private static final long serialVersionUID = -6870224972837789641L;

	// Fields
	@SequenceGenerator(name = "catalogo_oficinaSEQ", sequenceName = "catalogo_oficina_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_oficinaSEQ")
	private Integer id;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "clave", length = 255, nullable = true, unique = false)
	private String clave;

	@Column(name = "gerente", length = 255, nullable = true, unique = false)
	private String gerente;

	@Column(name = "coordinador_siniestros", length = 255, nullable = true, unique = false)
	private String coordinadorSiniestros;

	@Column(name = "direccion", nullable = true, unique = false)
	private String direccion;

	@Column(name = "telefono", length = 255, nullable = true, unique = false)
	private String telefono;

	@Column(name = "fax", length = 255, nullable = true, unique = false)
	private String fax;

	@Column(name = "nextel", length = 255, nullable = true, unique = false)
	private String nextel;

	@Column(name = "email", length = 255, nullable = true, unique = false)
	private String email;

	@Column(name = "dir_calle", length = 255, nullable = true, unique = false)
	private String dirCalle;

	@Column(name = "dir_colonia", length = 255, nullable = true, unique = false)
	private String dirColonia;

	@Column(name = "dir_municipio", length = 255, nullable = true, unique = false)
	private String dirMunicipio;

	@Column(name = "dir_cp", length = 255, nullable = true, unique = false)
	private String dirCp;

	@Column(name = "dir_estado", length = 255, nullable = true, unique = false)
	private String dirEstado;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@Column(name = "latitud", length = 255, nullable = true, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = true, unique = false)
	private String longitud;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractCatalogoOficina() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the clave
	 */
	public String getClave() {
		return this.clave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(final String clave) {
		this.clave = clave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the gerente
	 */
	public String getGerente() {
		return this.gerente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param gerente
	 *            the gerente to set
	 */
	public void setGerente(final String gerente) {
		this.gerente = gerente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the coordinadorSiniestros
	 */
	public String getCoordinadorSiniestros() {
		return this.coordinadorSiniestros;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param coordinadorSiniestros
	 *            the coordinadorSiniestros to set
	 */
	public void setCoordinadorSiniestros(final String coordinadorSiniestros) {
		this.coordinadorSiniestros = coordinadorSiniestros;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the telefono
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(final String fax) {
		this.fax = fax;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the nextel
	 */
	public String getNextel() {
		return this.nextel;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param nextel
	 *            the nextel to set
	 */
	public void setNextel(final String nextel) {
		this.nextel = nextel;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the dirCalle
	 */
	public String getDirCalle() {
		return this.dirCalle;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param dirCalle
	 *            the dirCalle to set
	 */
	public void setDirCalle(final String dirCalle) {
		this.dirCalle = dirCalle;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the dirColonia
	 */
	public String getDirColonia() {
		return this.dirColonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param dirColonia
	 *            the dirColonia to set
	 */
	public void setDirColonia(final String dirColonia) {
		this.dirColonia = dirColonia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the dirMunicipio
	 */
	public String getDirMunicipio() {
		return this.dirMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param dirMunicipio
	 *            the dirMunicipio to set
	 */
	public void setDirMunicipio(final String dirMunicipio) {
		this.dirMunicipio = dirMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the dirCp
	 */
	public String getDirCp() {
		return this.dirCp;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param dirCp
	 *            the dirCp to set
	 */
	public void setDirCp(final String dirCp) {
		this.dirCp = dirCp;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the dirEstado
	 */
	public String getDirEstado() {
		return this.dirEstado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param dirEstado
	 *            the dirEstado to set
	 */
	public void setDirEstado(final String dirEstado) {
		this.dirEstado = dirEstado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:53 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}