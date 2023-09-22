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

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.CatalogoMovil;
import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.clases.database.entidades.CatalogoVehiculoAjus;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTerminal extends JMEntidad {
	private static final long serialVersionUID = -4080429575423424464L;

	@SequenceGenerator(name = "terminalSEQ", sequenceName = "terminal_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminalSEQ")
	private Integer id;

	@Column(name = "latitud", length = 255, nullable = false)
	private String latitud;

	@Column(name = "longitud", length = 255, nullable = false)
	private String longitud;

	@Column(name = "latitud_alterna", length = 255)
	private String latitudAlterna;

	@Column(name = "longitud_alterna", length = 255)
	private String longitudAlterna;

	@Column(name = "telefono", length = 255, nullable = false, unique = true)
	private String telefono;

	@Column(name = "ultimo_localizacion_fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date ultimoLocalizacionFecha;

	@Column(name = "numeroproveedor", length = 255, nullable = true, unique = true)
	private String numeroproveedor;

	@Column(name = "nombre", length = 255, nullable = true, unique = true)
	private String nombre;

	@Column(name = "numeroradio", length = 255, nullable = true, unique = true)
	private String numeroradio;

	@Column(name = "passwd", length = 255, nullable = true, unique = true)
	private String passwd;

	@Column(name = "fecha_estatus_desconectado", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusDesconectado;

	@Column(name = "fecha_estatus_disponible", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusDisponible;

	@Column(name = "fecha_estatus_ocupado", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusOcupado;

	@Column(name = "ultimo_localizacion_direccion", nullable = true, unique = false)
	private String ultimoLocalizacionDireccion;

	@Column(name = "ultimo_localizacion_valida", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean ultimoLocalizacionValida;

	@Column(name = "habilitado", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@Column(name = "ultimo_localizacion_velocidad", length = 255, nullable = true, unique = false)
	private String ultimoLocalizacionVelocidad;

	@Column(name = "unidad_nombre", length = 255, nullable = true, unique = false)
	private String unidadNombre;

	@Column(name = "unidad_marca", length = 255, nullable = true, unique = false)
	private String unidadMarca;

	@Column(name = "unidad_serie", length = 255, nullable = true, unique = false)
	private String unidadSerie;

	@Column(name = "unidad_modelo", length = 255, nullable = true, unique = false)
	private String unidadModelo;

	@Column(name = "unidad_placas", length = 255, nullable = true, unique = false)
	private String unidadPlacas;

	@Column(name = "dispositivo_nombre", length = 255, nullable = true, unique = true)
	private String dispositivoNombre;

	@Column(name = "dispositivo_passwd", length = 255, nullable = true, unique = false)
	private String dispositivoPasswd;

	@Column(name = "dispositivo_protocolo", length = 255, nullable = true, unique = false)
	private String dispositivoProtocolo;

	@Column(name = "fecha_estatus_asignado", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusAsignado;

	@Column(name = "fecha_estatus_arribo", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusArribo;

	@Column(name = "fecha_estatus_termino", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusTermino;

	@Column(name = "ultimo_localizacion_tiempo", length = 255, nullable = true, unique = false)
	private String ultimoLocalizacionTiempo;

	@Column(name = "ultimo_localizacion_reporte", length = 255, nullable = true, unique = false)
	private String ultimoLocalizacionReporte;

	@Column(name = "fecha_estatus_otros", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEstatusOtros;

	@Column(name = "fuente_disponible", length = 255, nullable = true, unique = false)
	private String fuenteDisponible;

	@Column(name = "fuente_asignacion", length = 255, nullable = true, unique = false)
	private String fuenteAsignacion;

	@Column(name = "fuente_arribo", length = 255, nullable = true, unique = false)
	private String fuenteArribo;

	@Column(name = "fuente_termino", length = 255, nullable = true, unique = false)
	private String fuenteTermino;

	@Column(name = "fuente_desconectado", length = 255, nullable = true, unique = false)
	private String fuenteDesconectado;

	@Column(name = "correo_electronico", length = 255, nullable = true, unique = false)
	private String correoElectronico;

	@Column(name = "clave_oficina", length = 255, nullable = true, unique = false)
	private String claveOficina;

	@Column(name = "estatus", length = 255, nullable = true, unique = false)
	private String estatus;

	@Column(name = "proveedor_telefonia", length = 255, nullable = true, unique = false)
	private String proveedorTelefonia;

	@Column(name = "intervalo_pool_minutos", nullable = false, unique = false)
	private Integer intervaloPoolMinutos;

	@Column(name = "ultimo_siniestro_ws", length = 255, nullable = true, unique = false)
	private String ultimoSiniestroWs;

	@Column(name = "reportes_este_dia", nullable = true, unique = false)
	private Integer reportesEsteDia;

	@Column(name = "ultimo_reporte_fecha", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date ultimoReporteFecha;

	@Column(name = "coordenadas_desde_servicio_web", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean coordenadasDesdeServicioWeb;

	@Column(name = "coordenadas_desde_base", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean coordenadasDesdeBase;

	@Column(name = "proximidad", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean proximidad;

	@Column(name = "estatus_inactivo", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean estatusInactivo;

	@Column(name = "mostrar_en_cercania", nullable = true, unique = true)
	@Convert("booleanConverter")
	private Boolean mostrarEnCercania;

	@Column(name = "horario", length = 255, nullable = true, unique = false)
	private String horario;

    @Column(name = "horario_salida", length = 255, nullable = true, unique = false)
    private String horarioSalida;

    @Column(name = "fecha_ultimo_login_dia", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaUltimoLoginDia;

    @Column(name = "fecha_primer_login_dia", nullable = true, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date fechaPrimerLoginDia;
    
    @Column(name = "fecha_modificacion", nullable = true, unique = false)
   	@Temporal(TemporalType.TIMESTAMP)
   	private java.util.Date fechaModificacion;
    
    @Column(name = "tag", nullable = true, unique = false)
    @Convert("booleanConverter")
	private Boolean tag;
    
    @Column(name = "asistencia_vial", nullable = true, unique = false)
    @Convert("booleanConverter")
   	private Boolean asistenciaVial;
    
    @Column(name = "reporte_siica_av", nullable = true, unique = false)
    @Convert("booleanConverter")
   	private Boolean reporteSiicaAv;
    
    @Column(name = "sin_posicion_actual", length = 255, nullable = true, unique = false)
   	private String sinPosicionActual;
    
    @Column(name = "uid_android", length = 255, nullable = true, unique = false)
    private String androidUid;
    
    @Column(name = "email_atraso", nullable = true, unique = false)
    @Convert("booleanConverter")
   	private Boolean emailAtraso;
    
    @Column(name = "tipo_asistencia_vial", nullable = true, unique = false)
    private String tipoAsistenciaVial;
    
    @Column(name = "reporte_apartado", nullable = true, unique = false)
    private String reporteApartado;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ReporteMovilSac.class)
   	@JoinColumn(name = "sac_numeroreporte", referencedColumnName = "general_numero_reporte", nullable = true, unique = true, insertable = true, updatable = true)
   	private ReporteMovilSac reporteSac;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Base.class)
	@JoinColumn(name = "idzona", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Base base;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ReporteSise.class)
	@JoinColumn(name = "idreporte", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private ReporteSise reporteSise;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = GeocercaByEstado.class)
	@JoinColumn(name = "idgeocerca", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private GeocercaByEstado geocercaByEstado;
	
	@Column(name = "fecha_push", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaPush;
	
    /** Nuevos campos*/
    
    @Column(name = "NUM_SERIE_DIS_MOV_QP", length = 255, nullable = true, unique = false)
    private String numSdmqp;
        
    @Column(name = "NUM_SERIE_DIS_MOV_QS", length = 255, nullable = true, unique = false)
    private String numSerieDmqs;
    
    @Column(name = "IMPRESORA_MARCA", length = 255, nullable = true, unique = false)
    private String impreMarca;
    
    @Column(name = "IMPRESORA_SERIE", length = 255, nullable = true, unique = false)
    private String impreSerie;
    
    @Column(name = "CAM_FOTO_MARCA", length = 255, nullable = true, unique = false)
    private String camFotoMarca;
    
    @Column(name = "CAM_FOTO_SERIE", length = 255, nullable = true, unique = false)
    private String camFotoSerie;
    
   @Column(name = "otros_disp", length = 255, nullable = true, unique = false)
    private String otrosDisp;
   
   @Column(name = "NUM_ECONOMICO", length = 255, nullable = true, unique = false)
   private String numeroEcon;
   
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CatalogoOficina.class)
	@JoinColumn(name = "idoficina", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoOficina catalogoOficina;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CatalogoMovil.class)
	@JoinColumn(name = "DIS_MOV_QUA_PRI", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoMovil catalogoMovil;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CatalogoMovil.class)
	@JoinColumn(name = "DIS_MOV_QUA_SEC", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoMovil catalogoMovilS;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CatalogoVehiculoAjus.class)
	@JoinColumn(name = "VEHICULO_MARCA", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoVehiculoAjus catalogoVehiculoAjus;
	
	// Nuevas declaraciones para Horarios
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Grupo.class)
	@JoinColumn(name = "idgrupo", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Grupo grupo;
	
	@Column(name = "subgrupo", length = 255, nullable = true, unique = false)
    private String subGrupo;
   
   @Column(name = "diadescanso", length = 255, nullable = true, unique = false)
   private String diaDescanso;
   
   @Column(name = "guardia", nullable = true, unique = false)
   @Convert("booleanConverter")
  	private Boolean guardia;
   
   @Column(name = "moto", nullable = true, unique = false)
   @Convert("booleanConverter")
  	private Boolean moto;
   
 //Nueva columna RAZON_ESTATUS
   @Column(name="RAZON_ESTATUS", nullable= true, unique= false)
   private String razonEstatus;
   
// Segunda Atencion
	@Column(name = "segunda_atencion", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean segundaAtencion;
	
// Equipo pesado
	@Column(name = "equipo_pesado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean equipoPesado;
	
	@Column(name = "visto_alarma", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean vistoAlarma;

	@Column(name = "cedula_ajustador", nullable = true, unique = false)
	private String  cedulaAjustador;
	
	//**** Nuevas 17
	@Column(name = "PROGRAMA", nullable = true, unique = false)
	private String  programa;
	
	@Column(name = "NO_EMPLEADO", nullable = true, unique = false)
	private String  noEmpleado;
	
	@Column(name = "COORDINADOR", nullable = true, unique = false)
	private String  coordinador;
	
	@Column(name = "SUPERVISOR", nullable = true, unique = false)
	private String  supervisor;
	
	@Column(name = "FECHA_INGRESO", nullable = true, unique = false)
	private String  fechaIngreso;
	
	@Column(name = "NO_LICENCIA", nullable = true, unique = false)
	private String  noLicencia;
	
	@Column(name = "VIGENCIA_LICENCIA", nullable = true, unique = false)
	private String  vigenciaLicencia;
	
	@Column(name = "NO_TARJETA_GASOLINA", nullable = true, unique = false)
	private String  noTarjetaGasolina;
	
	@Column(name = "NO_TAG", nullable = true, unique = false)
	private String  noTag;
	
	@Column(name = "GPS", nullable = true, unique = false)
	private String  gps;
	
	@Column(name = "TELEFONO_PERSONAL", nullable = true, unique = false)
	private String  telefonoPersonal;
	
	@Column(name = "DIR_CALLE", nullable = true, unique = false)
	private String  dirCalle;
	
	@Column(name = "DIR_NUMERO", nullable = true, unique = false)
	private String  dirNumero;
	
	@Column(name = "DIR_COLONIA", nullable = true, unique = false)
	private String  dirColonia;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "DIR_ESTADO", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Estado dirEstado;
	
	@Column(name = "DIR_CP", nullable = true, unique = false)
	private String  dirCP;
	
	@Column(name = "RFC", nullable = true, unique = false)
	private String  rfc;
	
	@Column(name = "conceptos", nullable = true, unique = false)
	private String  conceptos;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Usuario.class)
	@JoinColumn(name = "usuario_modif", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Usuario usuarioModif;
	
	public AbstractTerminal() {
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

	public String getLatitudAlterna() {
		return latitudAlterna;
	}

	public void setLatitudAlterna(String latitudAlterna) {
		this.latitudAlterna = latitudAlterna;
	}

	public String getLongitudAlterna() {
		return longitudAlterna;
	}

	public void setLongitudAlterna(String longitudAlterna) {
		this.longitudAlterna = longitudAlterna;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public java.util.Date getUltimoLocalizacionFecha() {
		return ultimoLocalizacionFecha;
	}

	public void setUltimoLocalizacionFecha(java.util.Date ultimoLocalizacionFecha) {
		this.ultimoLocalizacionFecha = ultimoLocalizacionFecha;
	}

	public String getNumeroproveedor() {
		return numeroproveedor;
	}

	public void setNumeroproveedor(String numeroproveedor) {
		this.numeroproveedor = numeroproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroradio() {
		return numeroradio;
	}

	public void setNumeroradio(String numeroradio) {
		this.numeroradio = numeroradio;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public java.util.Date getFechaEstatusDesconectado() {
		return fechaEstatusDesconectado;
	}

	public void setFechaEstatusDesconectado(java.util.Date fechaEstatusDesconectado) {
		this.fechaEstatusDesconectado = fechaEstatusDesconectado;
	}

	public java.util.Date getFechaEstatusDisponible() {
		return fechaEstatusDisponible;
	}

	public void setFechaEstatusDisponible(java.util.Date fechaEstatusDisponible) {
		this.fechaEstatusDisponible = fechaEstatusDisponible;
	}

	public java.util.Date getFechaEstatusOcupado() {
		return fechaEstatusOcupado;
	}

	public void setFechaEstatusOcupado(java.util.Date fechaEstatusOcupado) {
		this.fechaEstatusOcupado = fechaEstatusOcupado;
	}

	public String getUltimoLocalizacionDireccion() {
		return ultimoLocalizacionDireccion;
	}

	public void setUltimoLocalizacionDireccion(String ultimoLocalizacionDireccion) {
		this.ultimoLocalizacionDireccion = ultimoLocalizacionDireccion;
	}

	public Boolean getUltimoLocalizacionValida() {
		return ultimoLocalizacionValida;
	}

	public void setUltimoLocalizacionValida(Boolean ultimoLocalizacionValida) {
		this.ultimoLocalizacionValida = ultimoLocalizacionValida;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getUltimoLocalizacionVelocidad() {
		return ultimoLocalizacionVelocidad;
	}

	public void setUltimoLocalizacionVelocidad(String ultimoLocalizacionVelocidad) {
		this.ultimoLocalizacionVelocidad = ultimoLocalizacionVelocidad;
	}

	public String getUnidadNombre() {
		return unidadNombre;
	}

	public void setUnidadNombre(String unidadNombre) {
		this.unidadNombre = unidadNombre;
	}

	public String getUnidadMarca() {
		return unidadMarca;
	}

	public void setUnidadMarca(String unidadMarca) {
		this.unidadMarca = unidadMarca;
	}

	public String getUnidadSerie() {
		return unidadSerie;
	}

	public void setUnidadSerie(String unidadSerie) {
		this.unidadSerie = unidadSerie;
	}

	public String getUnidadModelo() {
		return unidadModelo;
	}

	public void setUnidadModelo(String unidadModelo) {
		this.unidadModelo = unidadModelo;
	}

	public String getUnidadPlacas() {
		return unidadPlacas;
	}

	public void setUnidadPlacas(String unidadPlacas) {
		this.unidadPlacas = unidadPlacas;
	}

	public String getDispositivoNombre() {
		return dispositivoNombre;
	}

	public void setDispositivoNombre(String dispositivoNombre) {
		this.dispositivoNombre = dispositivoNombre;
	}

	public String getDispositivoPasswd() {
		return dispositivoPasswd;
	}

	public void setDispositivoPasswd(String dispositivoPasswd) {
		this.dispositivoPasswd = dispositivoPasswd;
	}

	public String getDispositivoProtocolo() {
		return dispositivoProtocolo;
	}

	public void setDispositivoProtocolo(String dispositivoProtocolo) {
		this.dispositivoProtocolo = dispositivoProtocolo;
	}

	public java.util.Date getFechaEstatusAsignado() {
		return fechaEstatusAsignado;
	}

	public void setFechaEstatusAsignado(java.util.Date fechaEstatusAsignado) {
		this.fechaEstatusAsignado = fechaEstatusAsignado;
	}

	public java.util.Date getFechaEstatusArribo() {
		return fechaEstatusArribo;
	}

	public void setFechaEstatusArribo(java.util.Date fechaEstatusArribo) {
		this.fechaEstatusArribo = fechaEstatusArribo;
	}

	public java.util.Date getFechaEstatusTermino() {
		return fechaEstatusTermino;
	}

	public void setFechaEstatusTermino(java.util.Date fechaEstatusTermino) {
		this.fechaEstatusTermino = fechaEstatusTermino;
	}

	public String getUltimoLocalizacionTiempo() {
		return ultimoLocalizacionTiempo;
	}

	public void setUltimoLocalizacionTiempo(String ultimoLocalizacionTiempo) {
		this.ultimoLocalizacionTiempo = ultimoLocalizacionTiempo;
	}

	public String getUltimoLocalizacionReporte() {
		return ultimoLocalizacionReporte;
	}

	public void setUltimoLocalizacionReporte(String ultimoLocalizacionReporte) {
		this.ultimoLocalizacionReporte = ultimoLocalizacionReporte;
	}

	public java.util.Date getFechaEstatusOtros() {
		return fechaEstatusOtros;
	}

	public void setFechaEstatusOtros(java.util.Date fechaEstatusOtros) {
		this.fechaEstatusOtros = fechaEstatusOtros;
	}

	public String getFuenteDisponible() {
		return fuenteDisponible;
	}

	public void setFuenteDisponible(String fuenteDisponible) {
		this.fuenteDisponible = fuenteDisponible;
	}

	public String getFuenteAsignacion() {
		return fuenteAsignacion;
	}

	public void setFuenteAsignacion(String fuenteAsignacion) {
		this.fuenteAsignacion = fuenteAsignacion;
	}

	public String getFuenteArribo() {
		return fuenteArribo;
	}

	public void setFuenteArribo(String fuenteArribo) {
		this.fuenteArribo = fuenteArribo;
	}

	public String getFuenteTermino() {
		return fuenteTermino;
	}

	public void setFuenteTermino(String fuenteTermino) {
		this.fuenteTermino = fuenteTermino;
	}

	public String getFuenteDesconectado() {
		return fuenteDesconectado;
	}

	public void setFuenteDesconectado(String fuenteDesconectado) {
		this.fuenteDesconectado = fuenteDesconectado;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getClaveOficina() {
		return claveOficina;
	}

	public void setClaveOficina(String claveOficina) {
		this.claveOficina = claveOficina;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getProveedorTelefonia() {
		return proveedorTelefonia;
	}

	public void setProveedorTelefonia(String proveedorTelefonia) {
		this.proveedorTelefonia = proveedorTelefonia;
	}

	public Integer getIntervaloPoolMinutos() {
		return intervaloPoolMinutos;
	}

	public void setIntervaloPoolMinutos(Integer intervaloPoolMinutos) {
		this.intervaloPoolMinutos = intervaloPoolMinutos;
	}

	public String getUltimoSiniestroWs() {
		return ultimoSiniestroWs;
	}

	public void setUltimoSiniestroWs(String ultimoSiniestroWs) {
		this.ultimoSiniestroWs = ultimoSiniestroWs;
	}

	public Integer getReportesEsteDia() {
		return reportesEsteDia;
	}

	public void setReportesEsteDia(Integer reportesEsteDia) {
		this.reportesEsteDia = reportesEsteDia;
	}

	public java.util.Date getUltimoReporteFecha() {
		return ultimoReporteFecha;
	}

	public void setUltimoReporteFecha(java.util.Date ultimoReporteFecha) {
		this.ultimoReporteFecha = ultimoReporteFecha;
	}

	public Boolean getCoordenadasDesdeServicioWeb() {
		return coordenadasDesdeServicioWeb;
	}

	public void setCoordenadasDesdeServicioWeb(Boolean coordenadasDesdeServicioWeb) {
		this.coordenadasDesdeServicioWeb = coordenadasDesdeServicioWeb;
	}

	public Boolean getCoordenadasDesdeBase() {
		return coordenadasDesdeBase;
	}

	public void setCoordenadasDesdeBase(Boolean coordenadasDesdeBase) {
		this.coordenadasDesdeBase = coordenadasDesdeBase;
	}

	public Boolean getProximidad() {
		return proximidad;
	}

	public void setProximidad(Boolean proximidad) {
		this.proximidad = proximidad;
	}

	public Boolean getEstatusInactivo() {
		return estatusInactivo;
	}

	public void setEstatusInactivo(Boolean estatusInactivo) {
		this.estatusInactivo = estatusInactivo;
	}

	public Boolean getMostrarEnCercania() {
		return mostrarEnCercania;
	}

	public void setMostrarEnCercania(Boolean mostrarEnCercania) {
		this.mostrarEnCercania = mostrarEnCercania;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getHorarioSalida() {
		return horarioSalida;
	}

	public void setHorarioSalida(String horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	public java.util.Date getFechaUltimoLoginDia() {
		return fechaUltimoLoginDia;
	}

	public void setFechaUltimoLoginDia(java.util.Date fechaUltimoLoginDia) {
		this.fechaUltimoLoginDia = fechaUltimoLoginDia;
	}

	public java.util.Date getFechaPrimerLoginDia() {
		return fechaPrimerLoginDia;
	}

	public void setFechaPrimerLoginDia(java.util.Date fechaPrimerLoginDia) {
		this.fechaPrimerLoginDia = fechaPrimerLoginDia;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Boolean getTag() {
		return tag;
	}

	public void setTag(Boolean tag) {
		this.tag = tag;
	}

	public Boolean getAsistenciaVial() {
		return asistenciaVial;
	}

	public void setAsistenciaVial(Boolean asistenciaVial) {
		this.asistenciaVial = asistenciaVial;
	}

	public Boolean getReporteSiicaAv() {
		return reporteSiicaAv;
	}

	public void setReporteSiicaAv(Boolean reporteSiicaAv) {
		this.reporteSiicaAv = reporteSiicaAv;
	}

	public String getSinPosicionActual() {
		return sinPosicionActual;
	}

	public void setSinPosicionActual(String sinPosicionActual) {
		this.sinPosicionActual = sinPosicionActual;
	}

	public String getAndroidUid() {
		return androidUid;
	}

	public void setAndroidUid(String androidUid) {
		this.androidUid = androidUid;
	}

	public Boolean getEmailAtraso() {
		return emailAtraso;
	}

	public void setEmailAtraso(Boolean emailAtraso) {
		this.emailAtraso = emailAtraso;
	}

	public String getTipoAsistenciaVial() {
		return tipoAsistenciaVial;
	}

	public void setTipoAsistenciaVial(String tipoAsistenciaVial) {
		this.tipoAsistenciaVial = tipoAsistenciaVial;
	}

	public String getReporteApartado() {
		return reporteApartado;
	}

	public void setReporteApartado(String reporteApartado) {
		this.reporteApartado = reporteApartado;
	}

	public ReporteMovilSac getReporteSac() {
		return reporteSac;
	}

	public void setReporteSac(ReporteMovilSac reporteSac) {
		this.reporteSac = reporteSac;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public ReporteSise getReporteSise() {
		return reporteSise;
	}

	public void setReporteSise(ReporteSise reporteSise) {
		this.reporteSise = reporteSise;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GeocercaByEstado getGeocercaByEstado() {
		return geocercaByEstado;
	}

	public void setGeocercaByEstado(GeocercaByEstado geocercaByEstado) {
		this.geocercaByEstado = geocercaByEstado;
	}

	public java.util.Date getFechaPush() {
		return fechaPush;
	}

	public void setFechaPush(java.util.Date fechaPush) {
		this.fechaPush = fechaPush;
	}

	public String getNumSdmqp() {
		return numSdmqp;
	}

	public void setNumSdmqp(String numSdmqp) {
		this.numSdmqp = numSdmqp;
	}

	public String getNumSerieDmqs() {
		return numSerieDmqs;
	}

	public void setNumSerieDmqs(String numSerieDmqs) {
		this.numSerieDmqs = numSerieDmqs;
	}

	public String getImpreMarca() {
		return impreMarca;
	}

	public void setImpreMarca(String impreMarca) {
		this.impreMarca = impreMarca;
	}

	public String getImpreSerie() {
		return impreSerie;
	}

	public void setImpreSerie(String impreSerie) {
		this.impreSerie = impreSerie;
	}

	public String getCamFotoMarca() {
		return camFotoMarca;
	}

	public void setCamFotoMarca(String camFotoMarca) {
		this.camFotoMarca = camFotoMarca;
	}

	public String getCamFotoSerie() {
		return camFotoSerie;
	}

	public void setCamFotoSerie(String camFotoSerie) {
		this.camFotoSerie = camFotoSerie;
	}

	public String getOtrosDisp() {
		return otrosDisp;
	}

	public void setOtrosDisp(String otrosDisp) {
		this.otrosDisp = otrosDisp;
	}

	public String getNumeroEcon() {
		return numeroEcon;
	}

	public void setNumeroEcon(String numeroEcon) {
		this.numeroEcon = numeroEcon;
	}

	public CatalogoOficina getCatalogoOficina() {
		return catalogoOficina;
	}

	public void setCatalogoOficina(CatalogoOficina catalogoOficina) {
		this.catalogoOficina = catalogoOficina;
	}

	public CatalogoMovil getCatalogoMovil() {
		return catalogoMovil;
	}

	public void setCatalogoMovil(CatalogoMovil catalogoMovil) {
		this.catalogoMovil = catalogoMovil;
	}

	public CatalogoMovil getCatalogoMovilS() {
		return catalogoMovilS;
	}

	public void setCatalogoMovilS(CatalogoMovil catalogoMovilS) {
		this.catalogoMovilS = catalogoMovilS;
	}

	public CatalogoVehiculoAjus getCatalogoVehiculoAjus() {
		return catalogoVehiculoAjus;
	}

	public void setCatalogoVehiculoAjus(CatalogoVehiculoAjus catalogoVehiculoAjus) {
		this.catalogoVehiculoAjus = catalogoVehiculoAjus;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}

	public String getDiaDescanso() {
		return diaDescanso;
	}

	public void setDiaDescanso(String diaDescanso) {
		this.diaDescanso = diaDescanso;
	}

	public Boolean getGuardia() {
		return guardia;
	}

	public void setGuardia(Boolean guardia) {
		this.guardia = guardia;
	}

	public Boolean getMoto() {
		return moto;
	}

	public void setMoto(Boolean moto) {
		this.moto = moto;
	}

	public String getRazonEstatus() {
		return razonEstatus;
	}

	public void setRazonEstatus(String razonEstatus) {
		this.razonEstatus = razonEstatus;
	}

	public Boolean getSegundaAtencion() {
		return segundaAtencion;
	}

	public void setSegundaAtencion(Boolean segundaAtencion) {
		this.segundaAtencion = segundaAtencion;
	}

	public Boolean getEquipoPesado() {
		return equipoPesado;
	}

	public void setEquipoPesado(Boolean equipoPesado) {
		this.equipoPesado = equipoPesado;
	}

	public Boolean getVistoAlarma() {
		return vistoAlarma;
	}

	public void setVistoAlarma(Boolean vistoAlarma) {
		this.vistoAlarma = vistoAlarma;
	}

	public String getCedulaAjustador() {
		return cedulaAjustador;
	}

	public void setCedulaAjustador(String cedulaAjustador) {
		this.cedulaAjustador = cedulaAjustador;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getNoLicencia() {
		return noLicencia;
	}

	public void setNoLicencia(String noLicencia) {
		this.noLicencia = noLicencia;
	}

	public String getVigenciaLicencia() {
		return vigenciaLicencia;
	}

	public void setVigenciaLicencia(String vigenciaLicencia) {
		this.vigenciaLicencia = vigenciaLicencia;
	}

	public String getNoTarjetaGasolina() {
		return noTarjetaGasolina;
	}

	public void setNoTarjetaGasolina(String noTarjetaGasolina) {
		this.noTarjetaGasolina = noTarjetaGasolina;
	}

	public String getNoTag() {
		return noTag;
	}

	public void setNoTag(String noTag) {
		this.noTag = noTag;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getTelefonoPersonal() {
		return telefonoPersonal;
	}

	public void setTelefonoPersonal(String telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}

	public String getDirCalle() {
		return dirCalle;
	}

	public void setDirCalle(String dirCalle) {
		this.dirCalle = dirCalle;
	}

	public String getDirNumero() {
		return dirNumero;
	}

	public void setDirNumero(String dirNumero) {
		this.dirNumero = dirNumero;
	}

	public String getDirColonia() {
		return dirColonia;
	}

	public void setDirColonia(String dirColonia) {
		this.dirColonia = dirColonia;
	}

	public Estado getDirEstado() {
		return dirEstado;
	}

	public void setDirEstado(Estado dirEstado) {
		this.dirEstado = dirEstado;
	}

	public String getDirCP() {
		return dirCP;
	}

	public void setDirCP(String dirCP) {
		this.dirCP = dirCP;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getConceptos() {
		return conceptos;
	}

	public void setConceptos(String conceptos) {
		this.conceptos = conceptos;
	}

	public Usuario getUsuarioModif() {
		return usuarioModif;
	}

	public void setUsuarioModif(Usuario usuarioModif) {
		this.usuarioModif = usuarioModif;
	}

	

	
}