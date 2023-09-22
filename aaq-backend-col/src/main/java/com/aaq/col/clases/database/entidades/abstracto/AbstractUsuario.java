package com.aaq.col.clases.database.entidades.abstracto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;
import org.eclipse.persistence.annotations.PrivateOwned;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.UsuarioEstado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
@ObjectTypeConverter(
		name="booleanConverter",
		dataType=java.lang.String.class,
		objectType=java.lang.Boolean.class,
		conversionValues={
			@ConversionValue(dataValue="t", objectValue="true"),
			@ConversionValue(dataValue="f", objectValue="false")
		},
		defaultObjectValue="false"
)
public abstract class AbstractUsuario extends JMEntidad {

	private static final long serialVersionUID = 1324927432407689609L;		

	@SequenceGenerator(name = "usuarioSEQ", sequenceName = "usuario_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = false)
	private String nombre;

	@Column(name = "passwd", length = 255, nullable = false, unique = true)
	private String passwd;

	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@Column(name = "avq_asigna", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean avqAsigna;

	@Column(name = "avq_captura", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean avqCaptura;

	@Column(name = "avq_cierra", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean avqCierra;
	
	@Column(name = "avq_permiso_todos_los_reportes", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean avqPermiso_VerTodosLosReportes;
	
	@Column(name = "catalogo_permiso_av", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean catalogoPermisoAv;

	@Column(name = "latitud", length = 255, nullable = true, unique = true)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = true, unique = true)
	private String longitud;

	@Column(name = "ultima_localizacion", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date ultimaLocalizacion;

	@Column(name = "telefono", length = 255, nullable = true, unique = false)
	private String telefono;

	@Column(name = "proveedor_telefonia", length = 255, nullable = true, unique = false)
	private String proveedorTelefonia;

	@Column(name = "velocidad", nullable = true, unique = false)
	private java.lang.Double velocidad;

	@Column(name = "direccion", nullable = true, unique = false)
	private String direccion;

	@Column(name = "ultima_localizacion_valida", nullable = true, unique = false)	
	@Convert("booleanConverter")
	private Boolean ultimaLocalizacionValida;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Base.class)
	@JoinColumn(name = "idzona", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Base base;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Frecuencia.class)
	@JoinColumn(name = "idfrecuencia", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Frecuencia frecuencia;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Perfil.class)
	@JoinColumn(name = "idperfil", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Perfil perfil;

	@OneToMany(targetEntity = UsuarioEstado.class, fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	@PrivateOwned
	private final Set<UsuarioEstado> usuarioEstadoUsuarioViaIdUsuario = new HashSet<>();
	
	@Column(name = "mail", length = 100, nullable = true, unique = false)
	private String mail;

	// Constructors
	/** default constructor */
	public AbstractUsuario() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the passwd
	 */
	public String getPasswd() {
		return this.passwd;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the habilitado
	 */	
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */	
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the ultimaLocalizacion
	 */
	public java.util.Date getUltimaLocalizacion() {
		return this.ultimaLocalizacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param ultimaLocalizacion
	 *            the ultimaLocalizacion to set
	 */
	public void setUltimaLocalizacion(final java.util.Date ultimaLocalizacion) {
		this.ultimaLocalizacion = ultimaLocalizacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the telefono
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the proveedorTelefonia
	 */
	public String getProveedorTelefonia() {
		return this.proveedorTelefonia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param proveedorTelefonia
	 *            the proveedorTelefonia to set
	 */
	public void setProveedorTelefonia(final String proveedorTelefonia) {
		this.proveedorTelefonia = proveedorTelefonia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the velocidad
	 */
	public java.lang.Double getVelocidad() {
		return this.velocidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param velocidad
	 *            the velocidad to set
	 */
	public void setVelocidad(final java.lang.Double velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the ultimaLocalizacionValida
	 */
	public Boolean getUltimaLocalizacionValida() {
		return this.ultimaLocalizacionValida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param ultimaLocalizacionValida
	 *            the ultimaLocalizacionValida to set
	 */
	public void setUltimaLocalizacionValida(final Boolean ultimaLocalizacionValida) {
		this.ultimaLocalizacionValida = ultimaLocalizacionValida;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the base
	 */
	public Base getBase() {
		return this.base;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param base
	 *            the base to set
	 */
	public void setBase(final Base base) {
		this.base = base;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the frecuencia
	 */
	public Frecuencia getFrecuencia() {
		return this.frecuencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param frecuencia
	 *            the frecuencia to set
	 */
	public void setFrecuencia(final Frecuencia frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return this.perfil;
	}

	/**
	 * mfernandez Aug 7, 2014 4:51:34 PM
	 * 
	 * @param perfil
	 *            the perfil to set
	 */
	public void setPerfil(final Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * mfernandez Aug 11, 2014 8:52:55 PM
	 * 
	 * @return the avqAsigna
	 */
	public Boolean getAvqAsigna() {
		return this.avqAsigna;
	}

	/**
	 * mfernandez Aug 11, 2014 8:52:55 PM
	 * 
	 * @param avqAsigna
	 *            the avqAsigna to set
	 */
	public void setAvqAsigna(final Boolean avqAsigna) {
		this.avqAsigna = avqAsigna;
	}

	/**
	 * mfernandez Aug 11, 2014 8:52:55 PM
	 * 
	 * @return the avqCaptura
	 */
	public Boolean getAvqCaptura() {
		return this.avqCaptura;
	}

	/**
	 * mfernandez Aug 11, 2014 8:52:55 PM
	 * 
	 * @param avqCaptura
	 *            the avqCaptura to set
	 */
	public void setAvqCaptura(final Boolean avqCaptura) {
		this.avqCaptura = avqCaptura;
	}

	/**
	 * mfernandez Aug 11, 2014 8:52:55 PM
	 * 
	 * @return the avqCierra
	 */
	public Boolean getAvqCierra() {
		return this.avqCierra;
	}

	/**
	 * mfernandez Aug 11, 2014 8:52:55 PM
	 * 
	 * @param avqCierra
	 *            the avqCierra to set
	 */
	public void setAvqCierra(final Boolean avqCierra) {
		this.avqCierra = avqCierra;
	}

	/**
	 * Oct 17, 2014 4:17:36 PM mfernandez
	 * 
	 * @return the usuarioEstadoUsuarioViaIdUsuario
	 */
	public Set<UsuarioEstado> getUsuarioEstadoUsuarioViaIdUsuario() {
		return this.usuarioEstadoUsuarioViaIdUsuario;
	}
	
	/**
	 * @return the avqPermiso_VerTodosLosReportes
	 */
	public Boolean getAvqPermiso_VerTodosLosReportes() {
		return this.avqPermiso_VerTodosLosReportes;
	}

	/**
	 * @param avqPermiso_VerTodosLosReportes the avqPermiso_VerTodosLosReportes to set
	 */
	public void setAvqPermiso_VerTodosLosReportes(final Boolean avqPermiso_VerTodosLosReportes) {
		this.avqPermiso_VerTodosLosReportes = avqPermiso_VerTodosLosReportes;
	}
	
	/**
	 * @return
	 */
	public Boolean getCatalogoPermisoAv() {
		return this.catalogoPermisoAv;
	}

	/**
	 * 
	 * @param catalogoPermisoAv
	 */
	public void setCatalogoPermisoAv(final Boolean catalogoPermisoAv) {
		this.catalogoPermisoAv = catalogoPermisoAv;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}