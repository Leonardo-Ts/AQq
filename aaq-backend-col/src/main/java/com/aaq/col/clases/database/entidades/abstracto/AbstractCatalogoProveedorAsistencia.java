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

/**
 * AbstractCatalogoProveedorAsistencia entity provides the base persistence
 * definition of the CatalogoProveedorAsistencia entity. @author mfernandez
 * Fernandez
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoProveedorAsistencia extends JMEntidad {

	private static final long serialVersionUID = 8395759768960989783L;

	@SequenceGenerator(name = "catalogo_proveedor_asistenciaSEQ", sequenceName = "catalogo_proveedor_asistencia_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_proveedor_asistenciaSEQ")
	private Integer id;

	@Column(name = "razon_social", length = 255, nullable = true, unique = false)
	private String razonSocial;

	@Column(name = "nombre_comercial", length = 255, nullable = true, unique = false)
	private String nombreComercial;

	@Column(name = "nombre_tipo", length = 255, nullable = true, unique = false)
	private String nombreTipo;

	@Column(name = "oficina_clave", length = 255, nullable = true, unique = false)
	private String oficinaClave;

	@Column(name = "oficina_nombre", length = 255, nullable = true, unique = false)
	private String oficinaNombre;

	@Column(name = "region", length = 255, nullable = true, unique = false)
	private String region;

	@Column(name = "telefono", length = 255, nullable = true, unique = false)
	private String telefono;

	@Column(name = "email", length = 255, nullable = true, unique = false)
	private String email;

	@Column(name = "clave_prestador", length = 255, nullable = true, unique = false)
	private String clavePrestador;

	@Column(name = "usuario", length = 255, nullable = true, unique = false)
	private String usuario;

	@Column(name = "passwd", length = 255, nullable = true, unique = false)
	private String passwd;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;

	// Constructors

	/** default constructor */
	public AbstractCatalogoProveedorAsistencia() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return this.razonSocial;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param razonSocial
	 *            the razonSocial to set
	 */
	public void setRazonSocial(final String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the nombreComercial
	 */
	public String getNombreComercial() {
		return this.nombreComercial;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param nombreComercial
	 *            the nombreComercial to set
	 */
	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the nombreTipo
	 */
	public String getNombreTipo() {
		return this.nombreTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param nombreTipo
	 *            the nombreTipo to set
	 */
	public void setNombreTipo(final String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the oficinaClave
	 */
	public String getOficinaClave() {
		return this.oficinaClave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param oficinaClave
	 *            the oficinaClave to set
	 */
	public void setOficinaClave(final String oficinaClave) {
		this.oficinaClave = oficinaClave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the oficinaNombre
	 */
	public String getOficinaNombre() {
		return this.oficinaNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param oficinaNombre
	 *            the oficinaNombre to set
	 */
	public void setOficinaNombre(final String oficinaNombre) {
		this.oficinaNombre = oficinaNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the region
	 */
	public String getRegion() {
		return this.region;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param region
	 *            the region to set
	 */
	public void setRegion(final String region) {
		this.region = region;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the telefono
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the clavePrestador
	 */
	public String getClavePrestador() {
		return this.clavePrestador;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param clavePrestador
	 *            the clavePrestador to set
	 */
	public void setClavePrestador(final String clavePrestador) {
		this.clavePrestador = clavePrestador;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the passwd
	 */
	public String getPasswd() {
		return this.passwd;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:22:42 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}