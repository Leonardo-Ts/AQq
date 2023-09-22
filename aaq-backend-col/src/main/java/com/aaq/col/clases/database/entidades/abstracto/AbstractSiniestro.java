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

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * AbstractSiniestro entity provides the base persistence definition of the
 * Siniestro entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractSiniestro extends JMEntidad {
	private static final long serialVersionUID = 5880022619014372231L;

	@SequenceGenerator(name = "siniestroSEQ", sequenceName = "siniestro_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "siniestroSEQ")
	private Integer id;

	@Column(name = "latitud", length = 255, nullable = true, unique = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = true, unique = false)
	private String longitud;

	@Column(name = "fecha", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@XStreamAlias("reportenumero")
	@Column(name = "numero_reporte", length = 255, nullable = false, unique = true)
	private String numeroReporte;

	@Column(name = "identificador_unico", length = 255, nullable = true, unique = true)
	private String identificadorUnico;

	@Column(name = "REPORTE_NOMBRE_OPERADOR_TELE", length = 255, nullable = true, unique = false)
	private String reporteNombreOperadorTelefonico;

	@Column(name = "ubicacion_calle", length = 255, nullable = true, unique = false)
	private String ubicacionCalle;

	@Column(name = "ubicacion_colonia", length = 255, nullable = true, unique = false)
	private String ubicacionColonia;

	@Column(name = "ubicacion_municipio", length = 255, nullable = true, unique = false)
	private String ubicacionMunicipio;

	@Column(name = "ubicacion_entre_calle", length = 255, nullable = true, unique = false)
	private String ubicacionEntreCalle;

	@Column(name = "ubicacion_esquina", length = 255, nullable = true, unique = false)
	private String ubicacionEsquina;

	@Column(name = "ubicacion_numero", length = 255, nullable = true, unique = false)
	private String ubicacionNumero;

	@Column(name = "ubicacion_referencia", length = 255, nullable = true, unique = false)
	private String ubicacionReferencia;

	@Column(name = "ubicacion_estado", length = 255, nullable = true, unique = false)
	private String ubicacionEstado;

	@Column(name = "ubicacion_pais", length = 255, nullable = true, unique = false)
	private String ubicacionPais;

	@Column(name = "ubicacion_codigo_postal", length = 255, nullable = true, unique = false)
	private String ubicacionCodigoPostal;

	@Column(name = "clave_de_entidad", length = 255, nullable = true, unique = false)
	private String claveDeEntidad;

	@Column(name = "ubicacion_carretera_nombre", length = 255, nullable = true, unique = false)
	private String ubicacionCarreteraNombre;

	@Column(name = "ubicacion_carretera_kilometro", length = 255, nullable = true, unique = false)
	private String ubicacionCarreteraKilometro;

	@Column(name = "cerrar_localizacion", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean cerrarLocalizacion;

	@Column(name = "cerrar_asignacion", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean cerrarAsignacion;

	@Column(name = "id_mun_sepomex", length = 255, nullable = true, unique = false)
	private String idMunSepomex;

	@Column(name = "id_ent_sepomex", length = 255, nullable = true, unique = false)
	private String idEntSepomex;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Estado estado;

	@XStreamOmitField
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractSiniestro() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public String getNumeroReporte() {
		return numeroReporte;
	}

	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	public String getIdentificadorUnico() {
		return identificadorUnico;
	}

	public void setIdentificadorUnico(String identificadorUnico) {
		this.identificadorUnico = identificadorUnico;
	}

	public String getReporteNombreOperadorTelefonico() {
		return reporteNombreOperadorTelefonico;
	}

	public void setReporteNombreOperadorTelefonico(String reporteNombreOperadorTelefonico) {
		this.reporteNombreOperadorTelefonico = reporteNombreOperadorTelefonico;
	}

	public String getUbicacionCalle() {
		return ubicacionCalle;
	}

	public void setUbicacionCalle(String ubicacionCalle) {
		this.ubicacionCalle = ubicacionCalle;
	}

	public String getUbicacionColonia() {
		return ubicacionColonia;
	}

	public void setUbicacionColonia(String ubicacionColonia) {
		this.ubicacionColonia = ubicacionColonia;
	}

	public String getUbicacionMunicipio() {
		return ubicacionMunicipio;
	}

	public void setUbicacionMunicipio(String ubicacionMunicipio) {
		this.ubicacionMunicipio = ubicacionMunicipio;
	}

	public String getUbicacionEntreCalle() {
		return ubicacionEntreCalle;
	}

	public void setUbicacionEntreCalle(String ubicacionEntreCalle) {
		this.ubicacionEntreCalle = ubicacionEntreCalle;
	}

	public String getUbicacionEsquina() {
		return ubicacionEsquina;
	}

	public void setUbicacionEsquina(String ubicacionEsquina) {
		this.ubicacionEsquina = ubicacionEsquina;
	}

	public String getUbicacionNumero() {
		return ubicacionNumero;
	}

	public void setUbicacionNumero(String ubicacionNumero) {
		this.ubicacionNumero = ubicacionNumero;
	}

	public String getUbicacionReferencia() {
		return ubicacionReferencia;
	}

	public void setUbicacionReferencia(String ubicacionReferencia) {
		this.ubicacionReferencia = ubicacionReferencia;
	}

	public String getUbicacionEstado() {
		return ubicacionEstado;
	}

	public void setUbicacionEstado(String ubicacionEstado) {
		this.ubicacionEstado = ubicacionEstado;
	}

	public String getUbicacionPais() {
		return ubicacionPais;
	}

	public void setUbicacionPais(String ubicacionPais) {
		this.ubicacionPais = ubicacionPais;
	}

	public String getUbicacionCodigoPostal() {
		return ubicacionCodigoPostal;
	}

	public void setUbicacionCodigoPostal(String ubicacionCodigoPostal) {
		this.ubicacionCodigoPostal = ubicacionCodigoPostal;
	}

	public String getClaveDeEntidad() {
		return claveDeEntidad;
	}

	public void setClaveDeEntidad(String claveDeEntidad) {
		this.claveDeEntidad = claveDeEntidad;
	}

	public String getUbicacionCarreteraNombre() {
		return ubicacionCarreteraNombre;
	}

	public void setUbicacionCarreteraNombre(String ubicacionCarreteraNombre) {
		this.ubicacionCarreteraNombre = ubicacionCarreteraNombre;
	}

	public String getUbicacionCarreteraKilometro() {
		return ubicacionCarreteraKilometro;
	}

	public void setUbicacionCarreteraKilometro(String ubicacionCarreteraKilometro) {
		this.ubicacionCarreteraKilometro = ubicacionCarreteraKilometro;
	}

	public Boolean getCerrarLocalizacion() {
		return cerrarLocalizacion;
	}

	public void setCerrarLocalizacion(Boolean cerrarLocalizacion) {
		this.cerrarLocalizacion = cerrarLocalizacion;
	}

	public Boolean getCerrarAsignacion() {
		return cerrarAsignacion;
	}

	public void setCerrarAsignacion(Boolean cerrarAsignacion) {
		this.cerrarAsignacion = cerrarAsignacion;
	}

	public String getIdMunSepomex() {
		return idMunSepomex;
	}

	public void setIdMunSepomex(String idMunSepomex) {
		this.idMunSepomex = idMunSepomex;
	}

	public String getIdEntSepomex() {
		return idEntSepomex;
	}

	public void setIdEntSepomex(String idEntSepomex) {
		this.idEntSepomex = idEntSepomex;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}