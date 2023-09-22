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

import org.eclipse.persistence.annotations.Convert;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReporteMovilSac extends JMEntidad {


	private static final long serialVersionUID = -3050216391703100495L;

	@SequenceGenerator(name = "reporte_movil_sacSEQ", sequenceName = "reporte_movil_sac_seq1", allocationSize = 1)
	@Id
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_movil_sacSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "general_numero_reporte", length = 255, nullable = true, unique = false)
	private String generalNumeroReporte;

	@Column(name = "general_numero_poliza", length = 255, nullable = true, unique = false)
	private String generalNumeroPoliza;

	@Column(name = "general_endoso", length = 255, nullable = true, unique = false)
	private String generalEndoso;

	@Column(name = "general_inciso", length = 255, nullable = true, unique = false)
	private String generalInciso;

	@Column(name = "general_nombre_asegurado", length = 255, nullable = true, unique = false)
	private String generalNombreAsegurado;

	@Column(name = "conductor_nombre", length = 255, nullable = true, unique = false)
	private String conductorNombre;

	@Column(name = "vehiculo_serie", length = 255, nullable = true, unique = false)
	private String vehiculoSerie;

	@Column(name = "vehiculo_placas", length = 255, nullable = true, unique = false)
	private String vehiculoPlacas;

	@Column(name = "ajuste_fecha_pasado_ajustador", length = 255, nullable = true, unique = false)
	private String ajusteFechaPasadoAjustador;

	@Column(name = "ajuste_fecha_arribo_ajustador", length = 255, nullable = true, unique = false)
	private String ajusteFechaArriboAjustador;

	@Column(name = "ajuste_fecha_termino_ajustador", length = 255, nullable = true, unique = false)
	private String ajusteFechaTerminoAjustador;

	@Column(name = "general_como_ocurrio", nullable = true, unique = false)
	private String generalComoOcurrio;

	@Column(name = "ajuste_hora_pasado_ajustador", length = 255, nullable = true, unique = false)
	private String ajusteHoraPasadoAjustador;

	@Column(name = "ajuste_hora_arribo_ajustador", length = 255, nullable = true, unique = false)
	private String ajusteHoraArriboAjustador;

	@Column(name = "ajuste_hora_termino_ajustador", length = 255, nullable = true, unique = false)
	private String ajusteHoraTerminoAjustador;

	@Column(name = "ajuste_codigo_causa", length = 255, nullable = true, unique = false)
	private String ajusteCodigoCausa;

	@Column(name = "conductor_telefono_contacto", length = 255, nullable = true, unique = false)
	private String conductorTelefonoContacto;

	@Column(name = "general_numero_siniestro", length = 255, nullable = true, unique = true)
	private String generalNumeroSiniestro;

	@Column(name = "vehiculo_marca", length = 255, nullable = true, unique = false)
	private String vehiculoMarca;

	@Column(name = "vehiculo_tipo", length = 255, nullable = true, unique = false)
	private String vehiculoTipo;

	@Column(name = "vehiculo_modelo", length = 255, nullable = true, unique = false)
	private String vehiculoModelo;

	@Column(name = "vehiculo_color", length = 255, nullable = true, unique = false)
	private String vehiculoColor;

	@Column(name = "general_usuario", length = 255, nullable = true, unique = false)
	private String generalUsuario;

	@Column(name = "es_reasignado_numero", nullable = true, unique = false)
	private Integer esReasignadoNumero;

	@Column(name = "es_segunda_atencion", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean esSegundaAtencion;

	@Column(name = "es_reasignado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean esReasignado;

	@Column(name = "coord_latitud_inicio", length = 255, nullable = true, unique = false)
	private String coordLatitudInicio;

	@Column(name = "coord_longitud_inicio", length = 255, nullable = true, unique = false)
	private String coordLongitudInicio;

	@Column(name = "coord_latitud_arribo", length = 255, nullable = true, unique = false)
	private String coordLatitudArribo;

	@Column(name = "coord_longitud_arribo", length = 255, nullable = true, unique = false)
	private String coordLongitudArribo;

	@Column(name = "coord_latitud_termino", length = 255, nullable = true, unique = false)
	private String coordLatitudTermino;

	@Column(name = "coord_longitud_termino", length = 255, nullable = true, unique = false)
	private String coordLongitudTermino;

	@Column(name = "general_oficina_reporte", length = 255, nullable = true, unique = false)
	private String generalOficinaReporte;

	@Column(name = "general_fecha_ocurrido", length = 255, nullable = true, unique = false)
	private String generalFechaOcurrido;

	@Column(name = "general_hora_ocurrido", length = 255, nullable = true, unique = false)
	private String generalHoraOcurrido;

	@Column(name = "general_asegurado_codigo", length = 255, nullable = true, unique = false)
	private String generalAseguradoCodigo;

	@Column(name = "GENERAL_ASEGURADO_TEL_ENCUESTA", length = 255, nullable = true, unique = false)
	private String generalAseguradoTelefonoEncuesta;

	@Column(name = "general_asegurado_telefono", length = 255, nullable = true, unique = false)
	private String generalAseguradoTelefono;

	@Column(name = "general_reporto", length = 255, nullable = true, unique = false)
	private String generalReporto;

	@Column(name = "general_observacion", nullable = true, unique = false)
	private String generalObservacion;

	@Column(name = "general_tipo_reporte", length = 255, nullable = true, unique = false)
	private String generalTipoReporte;

	@Column(name = "GENERAL_FECHA_REGISTRO_SINIEST", length = 255, nullable = true, unique = false)
	private String generalFechaRegistroSiniestro;

	@Column(name = "conductor_edad", length = 255, nullable = true, unique = false)
	private String conductorEdad;

	@Column(name = "conductor_sexo", length = 255, nullable = true, unique = false)
	private String conductorSexo;

	@Column(name = "ubicacion_direccion", nullable = true, unique = false)
	private String ubicacionDireccion;

	@Column(name = "ubicacion_carretera", length = 255, nullable = true, unique = false)
	private String ubicacionCarretera;

	@Column(name = "ubicacion_nacional", length = 255, nullable = true, unique = false)
	private String ubicacionNacional;

	@Column(name = "ubicacion_codigo_postal", length = 255, nullable = true, unique = false)
	private String ubicacionCodigoPostal;

	@Column(name = "ubicacion_entidad", length = 255, nullable = true, unique = false)
	private String ubicacionEntidad;

	@Column(name = "ubicacion_municipio", length = 255, nullable = true, unique = false)
	private String ubicacionMunicipio;

	@Column(name = "ubicacion_colonia_codigo", length = 255, nullable = true, unique = false)
	private String ubicacionColoniaCodigo;

	@Column(name = "ubicacion_colonia_desc", length = 255, nullable = true, unique = false)
	private String ubicacionColoniaDesc;

	@Column(name = "vehiculo_motor", length = 255, nullable = true, unique = false)
	private String vehiculoMotor;

	@Column(name = "ajuste_ajustador_codigo", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorCodigo;

	@Column(name = "ajuste_ajustador_nombre", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorNombre;

	@Column(name = "ajuste_ajustador_oficina", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorOficina;

	@Column(name = "general_moneda_clave", length = 255, nullable = true, unique = false)
	private String generalMonedaClave;

	@Column(name = "general_moneda_nombre", length = 255, nullable = true, unique = false)
	private String generalMonedaNombre;

	@Column(name = "fecha_reporte_envio_sms", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaReporteEnvioSms;

	@Column(name = "fecha_reporte_lectura_por_ws", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaReporteLecturaPorWs;

	@Column(name = "ubicacion_referencia", nullable = true, unique = false)
	private String ubicacionReferencia;

	@Column(name = "token", length = 255, nullable = true, unique = false)
	private String token;
	
	@Column(name = "general_correo_asegurado", length = 255, nullable = true, unique = false)
	private String generalCorreoAsegurado;
	
	@Column(name = "AJUSTE_QUIENLLEGOPRIMERO_ARRIB", length = 255, nullable = true, unique = false)
	private String quienLlegoPrimero;
	
	@Column(name = "ajuste_tramocarretero_arribo", length = 255, nullable = true, unique = false)
	private String tramoCarretero;
	
	@Column(name = "pre_averiguacion", length = 255, nullable = true, unique = false)
	private String preAveriguacion;
	
	@Column(name = "REPUVE_AVERIG_PREVIA_FEC", length = 255, nullable = true, unique = false)
	private String repuveAveriguacionPreviaFecha;
	
	@Column(name = "repuve_entidad_federativa", length = 255, nullable = true, unique = false)
	private String repuveEntidadFederativa;
	
	@Column(name = "repuve_municipio", length = 255, nullable = true, unique = false)
	private String repuveMunicipio;
	
	@Column(name = "repuve_numero_averiguacion", length = 255, nullable = true, unique = false)
	private String repuveNumeroAveriguacion;
	
	@Column(name = "robo_localizado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean roboLocalizado;
	
	@Column(name = "robo_localizado_en", length = 255, nullable = true, unique = false)
	private String roboLocalizadoEn;
	
	@Column(name = "robo_dependencia", length = 255, nullable = true, unique = false)
	private String roboDependencia;
	
	@Column(name = "robo_fecha", length = 255, nullable = true, unique = false)
	private String roboFecha;
	
	@Column(name = "robo_telefono", length = 255, nullable = true, unique = false)
	private String roboTelefono;
	
	@Column(name = "serviciosdiversos_consecutivos", length = 255, nullable = true, unique = false)
	private String serviciosdiversos_consecutivos;
	
	@Column(name = "proximidad", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean proximidad;
	
	@Column(name = "latitud_telefonia", length = 255, nullable = true, unique = false)
	private String latitudTelefonia;
	
	@Column(name = "longitud_telefonia", length = 255, nullable = true, unique = false)
	private String longitudTelefonia;
	
	@Column(name = "latitud_radio", length = 255, nullable = true, unique = false)
	private String latitudRadio;
	
	@Column(name = "longitud_radio", length = 255, nullable = true, unique = false)
	private String longitudRadio;
	
	@Column(name = "general_numero_reporte_sise", length = 255, nullable = true, unique = false)
	private String generalNumeroReporteSise;
	
	@Column(name = "deducible_nocturno", length = 255, nullable = true, unique = false)
	private String deducibleNocturno;
	
	@Column(name = "codigo_responsabilidad", nullable = true, unique = false)
	private String codigoResponsabilidad;
	
	@Column(name = "servicio_ambulancia", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean servicioAmbulancia;
	
	@Column(name = "GENERAL_POLIZA_ESTATUS", length = 100, nullable = true, unique = false)
	private String generalPolizaEstatus;
	
	@Column(name = "datos_arca", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean datosArca;
	
	@Column(name = "matriz", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean matriz;
	
	@Column(name = "codigo_matriz", nullable = true, unique = false)
	private String codigoMatriz;
	
	@Column(name = "distancia_al_arribo", length = 100, nullable = true, unique = false)
	private String distanciaAlArribo;
	
	@Column(name = "servicio_asistencia_vial", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean serviciosAsistenciaVial;
	
	@Column(name = "latitud_arribo_asegurado", nullable = true, unique = false)
	private String latitudArriboAsegurado;
	
	@Column(name = "longitud_arribo_asegurado", length = 100, nullable = true, unique = false)
	private String longitudArriboAsegurado;
	
	@Column(name = "arribo_cloud", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean arribloCloud;
	
	@Column(name = "tipo_unidad_asegurado", nullable = true, unique = false)
	private String tipoUnidadAsegurado;
	
	@Column(name="CLAVE_AGENTE", nullable= true, unique= false)
	private String claveAgente;
	
	@Column(name="UBICACION_CORRECTA", nullable= true, unique= false)
	private String ubicacionCorrecta;
	
//	@Column(name="causa_sa", nullable=true, unique= false)
//	private String causaSA;
//	
//	@Column(name = "FECHA_SA", nullable = true, unique = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	private java.util.Date fechaSA;
	
	// Constructors

	/** default constructor */
	public AbstractReporteMovilSac() {
		super();
	}

	
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 *
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 *
	 *
	 * @return the generalNumeroReporte
	 */
	public String getGeneralNumeroReporte() {
		return this.generalNumeroReporte;
	}

	/**
	 *
	 *
	 * @param generalNumeroReporte
	 *            the generalNumeroReporte to set
	 */
	public void setGeneralNumeroReporte(final String generalNumeroReporte) {
		this.generalNumeroReporte = generalNumeroReporte;
	}

	/**
	 *
	 *
	 * @return the generalNumeroPoliza
	 */
	public String getGeneralNumeroPoliza() {
		return this.generalNumeroPoliza;
	}

	/**
	 * 
	 *
	 * @param generalNumeroPoliza
	 *            the generalNumeroPoliza to set
	 */
	public void setGeneralNumeroPoliza(final String generalNumeroPoliza) {
		this.generalNumeroPoliza = generalNumeroPoliza;
	}

	/**
	 * 
	 *
	 * @return the generalEndoso
	 */
	public String getGeneralEndoso() {
		return this.generalEndoso;
	}

	/**
	 *
	 *
	 * @param generalEndoso
	 *            the generalEndoso to set
	 */
	public void setGeneralEndoso(final String generalEndoso) {
		this.generalEndoso = generalEndoso;
	}

	/**
	 * 
	 *
	 * @return the generalInciso
	 */
	public String getGeneralInciso() {
		return this.generalInciso;
	}

	/**
	 *
	 *
	 * @param generalInciso
	 *            the generalInciso to set
	 */
	public void setGeneralInciso(final String generalInciso) {
		this.generalInciso = generalInciso;
	}

	/**
	 *
	 *
	 * @return the generalNombreAsegurado
	 */
	public String getGeneralNombreAsegurado() {
		return this.generalNombreAsegurado;
	}

	/**
	 *
	 *
	 * @param generalNombreAsegurado
	 *            the generalNombreAsegurado to set
	 */
	public void setGeneralNombreAsegurado(final String generalNombreAsegurado) {
		this.generalNombreAsegurado = generalNombreAsegurado;
	}

	/**
	 *
	 *
	 * @return the conductorNombre
	 */
	public String getConductorNombre() {
		return this.conductorNombre;
	}

	/**
	 *
	 *
	 * @param conductorNombre
	 *            the conductorNombre to set
	 */
	public void setConductorNombre(final String conductorNombre) {
		this.conductorNombre = conductorNombre;
	}

	/**
	 *
	 *
	 * @return the vehiculoSerie
	 */
	public String getVehiculoSerie() {
		return this.vehiculoSerie;
	}

	/**
	 *
	 *
	 * @param vehiculoSerie
	 *            the vehiculoSerie to set
	 */
	public void setVehiculoSerie(final String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}

	/**
	 *
	 *
	 * @return the vehiculoPlacas
	 */
	public String getVehiculoPlacas() {
		return this.vehiculoPlacas;
	}

	/**
	 *
	 *
	 * @param vehiculoPlacas
	 *            the vehiculoPlacas to set
	 */
	public void setVehiculoPlacas(final String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}

	/**
	 *
	 *
	 * @return the ajusteFechaPasadoAjustador
	 */
	public String getAjusteFechaPasadoAjustador() {
		return this.ajusteFechaPasadoAjustador;
	}

	/**
	 *
	 *
	 * @param ajusteFechaPasadoAjustador
	 *            the ajusteFechaPasadoAjustador to set
	 */
	public void setAjusteFechaPasadoAjustador(final String ajusteFechaPasadoAjustador) {
		this.ajusteFechaPasadoAjustador = ajusteFechaPasadoAjustador;
	}

	/**
	 *
	 *
	 * @return the ajusteFechaArriboAjustador
	 */
	public String getAjusteFechaArriboAjustador() {
		return this.ajusteFechaArriboAjustador;
	}

	/**
	 *
	 *
	 * @param ajusteFechaArriboAjustador
	 *            the ajusteFechaArriboAjustador to set
	 */
	public void setAjusteFechaArriboAjustador(final String ajusteFechaArriboAjustador) {
		this.ajusteFechaArriboAjustador = ajusteFechaArriboAjustador;
	}

	/**
	 *
	 *
	 * @return the ajusteFechaTerminoAjustador
	 */
	public String getAjusteFechaTerminoAjustador() {
		return this.ajusteFechaTerminoAjustador;
	}

	/**
	 *
	 *
	 * @param ajusteFechaTerminoAjustador
	 *            the ajusteFechaTerminoAjustador to set
	 */
	public void setAjusteFechaTerminoAjustador(final String ajusteFechaTerminoAjustador) {
		this.ajusteFechaTerminoAjustador = ajusteFechaTerminoAjustador;
	}

	/**
	 *
	 *
	 * @return the generalComoOcurrio
	 */
	public String getGeneralComoOcurrio() {
		return this.generalComoOcurrio;
	}

	/**
	 *
	 *
	 * @param generalComoOcurrio
	 *            the generalComoOcurrio to set
	 */
	public void setGeneralComoOcurrio(final String generalComoOcurrio) {
		this.generalComoOcurrio = generalComoOcurrio;
	}

	/**
	 * 
	 *
	 * @return the ajusteHoraPasadoAjustador
	 */
	public String getAjusteHoraPasadoAjustador() {
		return this.ajusteHoraPasadoAjustador;
	}

	/**
	 *
	 *
	 * @param ajusteHoraPasadoAjustador
	 *            the ajusteHoraPasadoAjustador to set
	 */
	public void setAjusteHoraPasadoAjustador(final String ajusteHoraPasadoAjustador) {
		this.ajusteHoraPasadoAjustador = ajusteHoraPasadoAjustador;
	}

	/**
	 *
	 *
	 * @return the ajusteHoraArriboAjustador
	 */
	public String getAjusteHoraArriboAjustador() {
		return this.ajusteHoraArriboAjustador;
	}

	/**
	 *
	 *
	 * @param ajusteHoraArriboAjustador
	 *            the ajusteHoraArriboAjustador to set
	 */
	public void setAjusteHoraArriboAjustador(final String ajusteHoraArriboAjustador) {
		this.ajusteHoraArriboAjustador = ajusteHoraArriboAjustador;
	}

	/**
	 * 
	 *
	 * @return the ajusteHoraTerminoAjustador
	 */
	public String getAjusteHoraTerminoAjustador() {
		return this.ajusteHoraTerminoAjustador;
	}

	/**
	 * 
	 *
	 * @param ajusteHoraTerminoAjustador
	 *            the ajusteHoraTerminoAjustador to set
	 */
	public void setAjusteHoraTerminoAjustador(final String ajusteHoraTerminoAjustador) {
		this.ajusteHoraTerminoAjustador = ajusteHoraTerminoAjustador;
	}

	/**
	 * 
	 *
	 * @return the ajusteCodigoCausa
	 */
	public String getAjusteCodigoCausa() {
		return this.ajusteCodigoCausa;
	}

	/**
	 * 
	 *
	 * @param ajusteCodigoCausa
	 *            the ajusteCodigoCausa to set
	 */
	public void setAjusteCodigoCausa(final String ajusteCodigoCausa) {
		this.ajusteCodigoCausa = ajusteCodigoCausa;
	}

	/**
	 * 
	 *
	 * @return the conductorTelefonoContacto
	 */
	public String getConductorTelefonoContacto() {
		return this.conductorTelefonoContacto;
	}

	/**
	 *
	 *
	 * @param conductorTelefonoContacto
	 *            the conductorTelefonoContacto to set
	 */
	public void setConductorTelefonoContacto(final String conductorTelefonoContacto) {
		this.conductorTelefonoContacto = conductorTelefonoContacto;
	}

	/**
	 *
	 *
	 * @return the generalNumeroSiniestro
	 */
	public String getGeneralNumeroSiniestro() {
		return this.generalNumeroSiniestro;
	}

	/**
	 *
	 *
	 * @param generalNumeroSiniestro
	 *            the generalNumeroSiniestro to set
	 */
	public void setGeneralNumeroSiniestro(final String generalNumeroSiniestro) {
		this.generalNumeroSiniestro = generalNumeroSiniestro;
	}

	/**
	 *
	 *
	 * @return the vehiculoMarca
	 */
	public String getVehiculoMarca() {
		return this.vehiculoMarca;
	}

	/**
	 * 
	 *
	 * @param vehiculoMarca
	 *            the vehiculoMarca to set
	 */
	public void setVehiculoMarca(final String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	/**
	 *
	 *
	 * @return the vehiculoTipo
	 */
	public String getVehiculoTipo() {
		return this.vehiculoTipo;
	}

	/**
	 * 
	 *
	 * @param vehiculoTipo
	 *            the vehiculoTipo to set
	 */
	public void setVehiculoTipo(final String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}

	/**
	 * 
	 *
	 * @return the vehiculoModelo
	 */
	public String getVehiculoModelo() {
		return this.vehiculoModelo;
	}

	/**
	 * 
	 *
	 * @param vehiculoModelo
	 *            the vehiculoModelo to set
	 */
	public void setVehiculoModelo(final String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}

	/**
	 * 
	 *
	 * @return the vehiculoColor
	 */
	public String getVehiculoColor() {
		return this.vehiculoColor;
	}

	/**
	 *
	 *
	 * @param vehiculoColor
	 *            the vehiculoColor to set
	 */
	public void setVehiculoColor(final String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	/**
	 *
	 *
	 * @return the generalUsuario
	 */
	public String getGeneralUsuario() {
		return this.generalUsuario;
	}

	/**
	 *
	 *
	 * @param generalUsuario
	 *            the generalUsuario to set
	 */
	public void setGeneralUsuario(final String generalUsuario) {
		this.generalUsuario = generalUsuario;
	}

	/**
	 *
	 *
	 * @return the esReasignadoNumero
	 */
	public Integer getEsReasignadoNumero() {
		return this.esReasignadoNumero;
	}

	/**
	 *
	 *
	 * @param esReasignadoNumero
	 *            the esReasignadoNumero to set
	 */
	public void setEsReasignadoNumero(final Integer esReasignadoNumero) {
		this.esReasignadoNumero = esReasignadoNumero;
	}

	/**
	 *
	 *
	 * @return the esSegundaAtencion
	 */
	public Boolean getEsSegundaAtencion() {
		return this.esSegundaAtencion;
	}

	/**
	 *
	 *
	 * @param esSegundaAtencion
	 *            the esSegundaAtencion to set
	 */
	public void setEsSegundaAtencion(final Boolean esSegundaAtencion) {
		this.esSegundaAtencion = esSegundaAtencion;
	}

	/**
	 *
	 *
	 * @return the esReasignado
	 */
	public Boolean getEsReasignado() {
		return this.esReasignado;
	}

	/**
	 *
	 *
	 * @param esReasignado
	 *            the esReasignado to set
	 */
	public void setEsReasignado(final Boolean esReasignado) {
		this.esReasignado = esReasignado;
	}

	/**
	 *
	 *
	 * @return the coordLatitudInicio
	 */
	public String getCoordLatitudInicio() {
		return this.coordLatitudInicio;
	}

	/**
	 *
	 *
	 * @param coordLatitudInicio
	 *            the coordLatitudInicio to set
	 */
	public void setCoordLatitudInicio(final String coordLatitudInicio) {
		this.coordLatitudInicio = coordLatitudInicio;
	}

	/**
	 *
	 *
	 * @return the coordLongitudInicio
	 */
	public String getCoordLongitudInicio() {
		return this.coordLongitudInicio;
	}

	/**
	 *
	 *
	 * @param coordLongitudInicio
	 *            the coordLongitudInicio to set
	 */
	public void setCoordLongitudInicio(final String coordLongitudInicio) {
		this.coordLongitudInicio = coordLongitudInicio;
	}

	/**
	 *
	 *
	 * @return the coordLatitudArribo
	 */
	public String getCoordLatitudArribo() {
		return this.coordLatitudArribo;
	}

	/**
	 *
	 *
	 * @param coordLatitudArribo
	 *            the coordLatitudArribo to set
	 */
	public void setCoordLatitudArribo(final String coordLatitudArribo) {
		this.coordLatitudArribo = coordLatitudArribo;
	}

	/**
	 *
	 *
	 * @return the coordLongitudArribo
	 */
	public String getCoordLongitudArribo() {
		return this.coordLongitudArribo;
	}

	/**
	 *
	 *
	 * @param coordLongitudArribo
	 *            the coordLongitudArribo to set
	 */
	public void setCoordLongitudArribo(final String coordLongitudArribo) {
		this.coordLongitudArribo = coordLongitudArribo;
	}

	/**
	 *
	 *
	 * @return the coordLatitudTermino
	 */
	public String getCoordLatitudTermino() {
		return this.coordLatitudTermino;
	}

	/**
	 *
	 *
	 * @param coordLatitudTermino
	 *            the coordLatitudTermino to set
	 */
	public void setCoordLatitudTermino(final String coordLatitudTermino) {
		this.coordLatitudTermino = coordLatitudTermino;
	}

	/**
	 *
	 *
	 * @return the coordLongitudTermino
	 */
	public String getCoordLongitudTermino() {
		return this.coordLongitudTermino;
	}

	/**
	 *
	 *
	 * @param coordLongitudTermino
	 *            the coordLongitudTermino to set
	 */
	public void setCoordLongitudTermino(final String coordLongitudTermino) {
		this.coordLongitudTermino = coordLongitudTermino;
	}

	/**
	 * 
	 *
	 * @return the generalOficinaReporte
	 */
	public String getGeneralOficinaReporte() {
		return this.generalOficinaReporte;
	}

	/**
	 *
	 *
	 * @param generalOficinaReporte
	 *            the generalOficinaReporte to set
	 */
	public void setGeneralOficinaReporte(final String generalOficinaReporte) {
		this.generalOficinaReporte = generalOficinaReporte;
	}

	/**
	 * 
	 *
	 * @return the generalFechaOcurrido
	 */
	public String getGeneralFechaOcurrido() {
		return this.generalFechaOcurrido;
	}

	/**
	 *
	 *
	 * @param generalFechaOcurrido
	 *            the generalFechaOcurrido to set
	 */
	public void setGeneralFechaOcurrido(final String generalFechaOcurrido) {
		this.generalFechaOcurrido = generalFechaOcurrido;
	}

	/**
	 *
	 *
	 * @return the generalHoraOcurrido
	 */
	public String getGeneralHoraOcurrido() {
		return this.generalHoraOcurrido;
	}

	/**
	 *
	 *
	 * @param generalHoraOcurrido
	 *            the generalHoraOcurrido to set
	 */
	public void setGeneralHoraOcurrido(final String generalHoraOcurrido) {
		this.generalHoraOcurrido = generalHoraOcurrido;
	}

	/**
	 *
	 *
	 * @return the generalAseguradoCodigo
	 */
	public String getGeneralAseguradoCodigo() {
		return this.generalAseguradoCodigo;
	}

	/**
	 *
	 *
	 * @param generalAseguradoCodigo
	 *            the generalAseguradoCodigo to set
	 */
	public void setGeneralAseguradoCodigo(final String generalAseguradoCodigo) {
		this.generalAseguradoCodigo = generalAseguradoCodigo;
	}

	/**
	 *
	 *
	 * @return the generalAseguradoTelefonoEncuesta
	 */
	public String getGeneralAseguradoTelefonoEncuesta() {
		return this.generalAseguradoTelefonoEncuesta;
	}

	/**
	 *
	 *
	 * @param generalAseguradoTelefonoEncuesta
	 *            the generalAseguradoTelefonoEncuesta to set
	 */
	public void setGeneralAseguradoTelefonoEncuesta(final String generalAseguradoTelefonoEncuesta) {
		this.generalAseguradoTelefonoEncuesta = generalAseguradoTelefonoEncuesta;
	}

	/**
	 *
	 *
	 * @return the generalAseguradoTelefono
	 */
	public String getGeneralAseguradoTelefono() {
		return this.generalAseguradoTelefono;
	}

	/**
	 *
	 *
	 * @param generalAseguradoTelefono
	 *            the generalAseguradoTelefono to set
	 */
	public void setGeneralAseguradoTelefono(final String generalAseguradoTelefono) {
		this.generalAseguradoTelefono = generalAseguradoTelefono;
	}

	/**
	 *
	 *
	 * @return the generalReporto
	 */
	public String getGeneralReporto() {
		return this.generalReporto;
	}

	/**
	 *
	 *
	 * @param generalReporto
	 *            the generalReporto to set
	 */
	public void setGeneralReporto(final String generalReporto) {
		this.generalReporto = generalReporto;
	}

	/**
	 *
	 *
	 * @return the generalObservacion
	 */
	public String getGeneralObservacion() {
		return this.generalObservacion;
	}

	/**
	 *
	 *
	 * @param generalObservacion
	 *            the generalObservacion to set
	 */
	public void setGeneralObservacion(final String generalObservacion) {
		this.generalObservacion = generalObservacion;
	}

	/**
	 *
	 *
	 * @return the generalTipoReporte
	 */
	public String getGeneralTipoReporte() {
		return this.generalTipoReporte;
	}

	/**
	 *
	 *
	 * @param generalTipoReporte
	 *            the generalTipoReporte to set
	 */
	public void setGeneralTipoReporte(final String generalTipoReporte) {
		this.generalTipoReporte = generalTipoReporte;
	}

	/**
	 *
	 *
	 * @return the generalFechaRegistroSiniestro
	 */
	public String getGeneralFechaRegistroSiniestro() {
		return this.generalFechaRegistroSiniestro;
	}

	/**
	 *
	 *
	 * @param generalFechaRegistroSiniestro
	 *            the generalFechaRegistroSiniestro to set
	 */
	public void setGeneralFechaRegistroSiniestro(final String generalFechaRegistroSiniestro) {
		this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
	}

	/**
	 * 
	 *
	 * @return the conductorEdad
	 */
	public String getConductorEdad() {
		return this.conductorEdad;
	}

	/**
	 * 
	 *
	 * @param conductorEdad
	 *            the conductorEdad to set
	 */
	public void setConductorEdad(final String conductorEdad) {
		this.conductorEdad = conductorEdad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the conductorSexo
	 */
	public String getConductorSexo() {
		return this.conductorSexo;
	}

	/**
	 *
	 *
	 * @param conductorSexo
	 *            the conductorSexo to set
	 */
	public void setConductorSexo(final String conductorSexo) {
		this.conductorSexo = conductorSexo;
	}

	/**
	 *
	 *
	 * @return the ubicacionDireccion
	 */
	public String getUbicacionDireccion() {
		return this.ubicacionDireccion;
	}

	/**
	 *
	 *
	 * @param ubicacionDireccion
	 *            the ubicacionDireccion to set
	 */
	public void setUbicacionDireccion(final String ubicacionDireccion) {
		this.ubicacionDireccion = ubicacionDireccion;
	}

	/**
	 *
	 *
	 * @return the ubicacionCarretera
	 */
	public String getUbicacionCarretera() {
		return this.ubicacionCarretera;
	}

	/**
	 *
	 *
	 * @param ubicacionCarretera
	 *            the ubicacionCarretera to set
	 */
	public void setUbicacionCarretera(final String ubicacionCarretera) {
		this.ubicacionCarretera = ubicacionCarretera;
	}

	/**
	 *
	 *
	 * @return the ubicacionNacional
	 */
	public String getUbicacionNacional() {
		return this.ubicacionNacional;
	}

	/**
	 *
	 *
	 * @param ubicacionNacional
	 *            the ubicacionNacional to set
	 */
	public void setUbicacionNacional(final String ubicacionNacional) {
		this.ubicacionNacional = ubicacionNacional;
	}

	/**
	 *
	 *
	 * @return the ubicacionCodigoPostal
	 */
	public String getUbicacionCodigoPostal() {
		return this.ubicacionCodigoPostal;
	}

	/**
	 *
	 *
	 * @param ubicacionCodigoPostal
	 *            the ubicacionCodigoPostal to set
	 */
	public void setUbicacionCodigoPostal(final String ubicacionCodigoPostal) {
		this.ubicacionCodigoPostal = ubicacionCodigoPostal;
	}

	/**
	 *
	 *
	 * @return the ubicacionEntidad
	 */
	public String getUbicacionEntidad() {
		return this.ubicacionEntidad;
	}

	/**
	 * 
	 *
	 * @param ubicacionEntidad
	 *            the ubicacionEntidad to set
	 */
	public void setUbicacionEntidad(final String ubicacionEntidad) {
		this.ubicacionEntidad = ubicacionEntidad;
	}

	/**
	 * 
	 *
	 * @return the ubicacionMunicipio
	 */
	public String getUbicacionMunicipio() {
		return this.ubicacionMunicipio;
	}

	/**
	 * 
	 *
	 * @param ubicacionMunicipio
	 *            the ubicacionMunicipio to set
	 */
	public void setUbicacionMunicipio(final String ubicacionMunicipio) {
		this.ubicacionMunicipio = ubicacionMunicipio;
	}

	/**
	 *
	 *
	 * @return the ubicacionColoniaCodigo
	 */
	public String getUbicacionColoniaCodigo() {
		return this.ubicacionColoniaCodigo;
	}

	/**
	 * 
	 *
	 * @param ubicacionColoniaCodigo
	 *            the ubicacionColoniaCodigo to set
	 */
	public void setUbicacionColoniaCodigo(final String ubicacionColoniaCodigo) {
		this.ubicacionColoniaCodigo = ubicacionColoniaCodigo;
	}

	/**
	 *
	 *
	 * @return the ubicacionColoniaDesc
	 */
	public String getUbicacionColoniaDesc() {
		return this.ubicacionColoniaDesc;
	}

	/**
	 *
	 *
	 * @param ubicacionColoniaDesc
	 *            the ubicacionColoniaDesc to set
	 */
	public void setUbicacionColoniaDesc(final String ubicacionColoniaDesc) {
		this.ubicacionColoniaDesc = ubicacionColoniaDesc;
	}

	/**
	 *
	 *
	 * @return the vehiculoMotor
	 */
	public String getVehiculoMotor() {
		return this.vehiculoMotor;
	}

	/**
	 *
	 *
	 * @param vehiculoMotor
	 *            the vehiculoMotor to set
	 */
	public void setVehiculoMotor(final String vehiculoMotor) {
		this.vehiculoMotor = vehiculoMotor;
	}

	/**
	 *
	 *
	 * @return the ajusteAjustadorCodigo
	 */
	public String getAjusteAjustadorCodigo() {
		return this.ajusteAjustadorCodigo;
	}

	/**
	 *
	 *
	 * @param ajusteAjustadorCodigo
	 *            the ajusteAjustadorCodigo to set
	 */
	public void setAjusteAjustadorCodigo(final String ajusteAjustadorCodigo) {
		this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
	}

	/**
	 *
	 *
	 * @return the ajusteAjustadorNombre
	 */
	public String getAjusteAjustadorNombre() {
		return this.ajusteAjustadorNombre;
	}

	/**
	 *
	 *
	 * @param ajusteAjustadorNombre
	 *            the ajusteAjustadorNombre to set
	 */
	public void setAjusteAjustadorNombre(final String ajusteAjustadorNombre) {
		this.ajusteAjustadorNombre = ajusteAjustadorNombre;
	}

	/**
	 *
	 *
	 * @return the ajusteAjustadorOficina
	 */
	public String getAjusteAjustadorOficina() {
		return this.ajusteAjustadorOficina;
	}

	/**
	 *
	 *
	 * @param ajusteAjustadorOficina
	 *            the ajusteAjustadorOficina to set
	 */
	public void setAjusteAjustadorOficina(final String ajusteAjustadorOficina) {
		this.ajusteAjustadorOficina = ajusteAjustadorOficina;
	}

	/**
	 *
	 *
	 * @return the generalMonedaClave
	 */
	public String getGeneralMonedaClave() {
		return this.generalMonedaClave;
	}

	/**
	 *
	 *
	 * @param generalMonedaClave
	 *            the generalMonedaClave to set
	 */
	public void setGeneralMonedaClave(final String generalMonedaClave) {
		this.generalMonedaClave = generalMonedaClave;
	}

	/**
	 * 
	 *
	 * @return the generalMonedaNombre
	 */
	public String getGeneralMonedaNombre() {
		return this.generalMonedaNombre;
	}

	/**
	 * 
	 *
	 * @param generalMonedaNombre
	 *            the generalMonedaNombre to set
	 */
	public void setGeneralMonedaNombre(final String generalMonedaNombre) {
		this.generalMonedaNombre = generalMonedaNombre;
	}

	/**
	 * 
	 *
	 * @return the fechaReporteEnvioSms
	 */
	public java.util.Date getFechaReporteEnvioSms() {
		return this.fechaReporteEnvioSms;
	}

	/**
	 * 
	 *
	 * @param fechaReporteEnvioSms
	 *            the fechaReporteEnvioSms to set
	 */
	public void setFechaReporteEnvioSms(final java.util.Date fechaReporteEnvioSms) {
		this.fechaReporteEnvioSms = fechaReporteEnvioSms;
	}

	/**
	 * 
	 *
	 * @return the fechaReporteLecturaPorWs
	 */
	public java.util.Date getFechaReporteLecturaPorWs() {
		return this.fechaReporteLecturaPorWs;
	}

	/**
	 *
	 *
	 * @param fechaReporteLecturaPorWs
	 *            the fechaReporteLecturaPorWs to set
	 */
	public void setFechaReporteLecturaPorWs(final java.util.Date fechaReporteLecturaPorWs) {
		this.fechaReporteLecturaPorWs = fechaReporteLecturaPorWs;
	}

	/**
	 *
	 *
	 * @return the ubicacionReferencia
	 */
	public String getUbicacionReferencia() {
		return this.ubicacionReferencia;
	}

	/**
	 *
	 *
	 * @param ubicacionReferencia
	 *            the ubicacionReferencia to set
	 */
	public void setUbicacionReferencia(final String ubicacionReferencia) {
		this.ubicacionReferencia = ubicacionReferencia;
	}

	/**
	 *
	 *
	 * @return the token
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 *
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(final String token) {
		this.token = token;
	}

	/**
	 *
	 * 
	 * @return the generalCorreoAsegurado
	 */
	public String getGeneralCorreoAsegurado() {
		return this.generalCorreoAsegurado;
	}

	/**
	 *
	 * 
	 * @param generalCorreoAsegurado
	 *            the generalCorreoAsegurado to set
	 */
	public void setGeneralCorreoAsegurado(final String generalCorreoAsegurado) {
		this.generalCorreoAsegurado = generalCorreoAsegurado;
	}
	
	/**
	 * @return the quienLlegoPrimero
	 */
	public String getQuienLlegoPrimero() {
		return this.quienLlegoPrimero;
	}


	/**
	 * @param quienLlegoPrimero the quienLlegoPrimero to set
	 */
	public void setQuienLlegoPrimero(final String quienLlegoPrimero) {
		this.quienLlegoPrimero = quienLlegoPrimero;
	}


	/**
	 * @return the tramoCarretero
	 */
	public String getTramoCarretero() {
		return this.tramoCarretero;
	}


	/**
	 * @param tramoCarretero the tramoCarretero to set
	 */
	public void setTramoCarretero(final String tramoCarretero) {
		this.tramoCarretero = tramoCarretero;
	}


	/**
	 * @return the preAveriguacion
	 */
	public String getPreAveriguacion() {
		return this.preAveriguacion;
	}


	/**
	 * @param preAveriguacion the preAveriguacion to set
	 */
	public void setPreAveriguacion(final String preAveriguacion) {
		this.preAveriguacion = preAveriguacion;
	}


	/**
	 * @return the repuveAveriguacionPreviaFecha
	 */
	public String getRepuveAveriguacionPreviaFecha() {
		return this.repuveAveriguacionPreviaFecha;
	}


	/**
	 * @param repuveAveriguacionPreviaFecha the repuveAveriguacionPreviaFecha to set
	 */
	public void setRepuveAveriguacionPreviaFecha(
			final String repuveAveriguacionPreviaFecha) {
		this.repuveAveriguacionPreviaFecha = repuveAveriguacionPreviaFecha;
	}


	/**
	 * @return the repuveEntidadFederativa
	 */
	public String getRepuveEntidadFederativa() {
		return this.repuveEntidadFederativa;
	}


	/**
	 * @param repuveEntidadFederativa the repuveEntidadFederativa to set
	 */
	public void setRepuveEntidadFederativa(final String repuveEntidadFederativa) {
		this.repuveEntidadFederativa = repuveEntidadFederativa;
	}


	/**
	 * @return the repuveMunicipio
	 */
	public String getRepuveMunicipio() {
		return this.repuveMunicipio;
	}


	/**
	 * @param repuveMunicipio the repuveMunicipio to set
	 */
	public void setRepuveMunicipio(final String repuveMunicipio) {
		this.repuveMunicipio = repuveMunicipio;
	}


	/**
	 * @return the repuveNumeroAveriguacion
	 */
	public String getRepuveNumeroAveriguacion() {
		return this.repuveNumeroAveriguacion;
	}


	/**
	 * @param repuveNumeroAveriguacion the repuveNumeroAveriguacion to set
	 */
	public void setRepuveNumeroAveriguacion(final String repuveNumeroAveriguacion) {
		this.repuveNumeroAveriguacion = repuveNumeroAveriguacion;
	}


	/**
	 * @return the roboLocalizado
	 */
	public Boolean getRoboLocalizado() {
		return this.roboLocalizado;
	}


	/**
	 * @param roboLocalizado the roboLocalizado to set
	 */
	public void setRoboLocalizado(final Boolean roboLocalizado) {
		this.roboLocalizado = roboLocalizado;
	}


	/**
	 * @return the roboLocalizadoEn
	 */
	public String getRoboLocalizadoEn() {
		return this.roboLocalizadoEn;
	}


	/**
	 * @param roboLocalizadoEn the roboLocalizadoEn to set
	 */
	public void setRoboLocalizadoEn(final String roboLocalizadoEn) {
		this.roboLocalizadoEn = roboLocalizadoEn;
	}


	/**
	 * @return the roboDependencia
	 */
	public String getRoboDependencia() {
		return this.roboDependencia;
	}


	/**
	 * @param roboDependencia the roboDependencia to set
	 */
	public void setRoboDependencia(final String roboDependencia) {
		this.roboDependencia = roboDependencia;
	}


	/**
	 * @return the roboFecha
	 */
	public String getRoboFecha() {
		return this.roboFecha;
	}


	/**
	 * @param roboFecha the roboFecha to set
	 */
	public void setRoboFecha(final String roboFecha) {
		this.roboFecha = roboFecha;
	}


	/**
	 * @return the roboTelefono
	 */
	public String getRoboTelefono() {
		return this.roboTelefono;
	}


	/**
	 * @param roboTelefono the roboTelefono to set
	 */
	public void setRoboTelefono(final String roboTelefono) {
		this.roboTelefono = roboTelefono;
	}


	/**
	 * @return the serviciosdiversos_consecutivos
	 */
	public String getServiciosdiversos_consecutivos() {
		return serviciosdiversos_consecutivos;
	}


	/**
	 * @param serviciosdiversos_consecutivos the serviciosdiversos_consecutivos to set
	 */
	public void setServiciosdiversos_consecutivos(
			String serviciosdiversos_consecutivos) {
		this.serviciosdiversos_consecutivos = serviciosdiversos_consecutivos;
	}


	/**
	 * @return the proximidad
	 */
	public Boolean getProximidad() {
		return proximidad;
	}


	/**
	 * @param proximidad the proximidad to set
	 */
	public void setProximidad(Boolean proximidad) {
		this.proximidad = proximidad;
	}


	/**
	 * @return the latitudTelefonia
	 */
	public String getLatitudTelefonia() {
		return latitudTelefonia;
	}


	/**
	 * @param latitudTelefonia the latitudTelefonia to set
	 */
	public void setLatitudTelefonia(String latitudTelefonia) {
		this.latitudTelefonia = latitudTelefonia;
	}


	/**
	 * @return the longitudTelefonia
	 */
	public String getLongitudTelefonia() {
		return longitudTelefonia;
	}


	/**
	 * @param longitudTelefonia the longitudTelefonia to set
	 */
	public void setLongitudTelefonia(String longitudTelefonia) {
		this.longitudTelefonia = longitudTelefonia;
	}


	/**
	 * @return the latitudRadio
	 */
	public String getLatitudRadio() {
		return latitudRadio;
	}


	/**
	 * @param latitudRadio the latitudRadio to set
	 */
	public void setLatitudRadio(String latitudRadio) {
		this.latitudRadio = latitudRadio;
	}


	/**
	 * @return the longitudRadio
	 */
	public String getLongitudRadio() {
		return longitudRadio;
	}


	/**
	 * @param longitudRadio the longitudRadio to set
	 */
	public void setLongitudRadio(String longitudRadio) {
		this.longitudRadio = longitudRadio;
	}


	/**
	 * @return the generalNumeroReporteSise
	 */
	public String getGeneralNumeroReporteSise() {
		return generalNumeroReporteSise;
	}


	/**
	 * @param generalNumeroReporteSise the generalNumeroReporteSise to set
	 */
	public void setGeneralNumeroReporteSise(String generalNumeroReporteSise) {
		this.generalNumeroReporteSise = generalNumeroReporteSise;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the deducibleNocturno
	 */
	public String getDeducibleNocturno() {
		return deducibleNocturno;
	}


	/**
	 * @author Arturo de la Cruz
	 * @param deducibleNocturno the deducibleNocturno to set
	 */
	public void setDeducibleNocturno(String deducibleNocturno) {
		this.deducibleNocturno = deducibleNocturno;
	}
	

	/**
	 * @return the codigoResponsabilidad
	 */
	public String getCodigoResponsabilidad() {
		return codigoResponsabilidad;
	}


	/**
	 * @param codigoResponsabilidad the codigoResponsabilidad to set
	 */
	public void setCodigoResponsabilidad(String codigoResponsabilidad) {
		this.codigoResponsabilidad = codigoResponsabilidad;
	}


	/**
	 * @return the servicioAmbulancia
	 */
	public Boolean getServicioAmbulancia() {
		return servicioAmbulancia;
	}


	/**
	 * @param servicioAmbulancia the servicioAmbulancia to set
	 */
	public void setServicioAmbulancia(Boolean servicioAmbulancia) {
		this.servicioAmbulancia = servicioAmbulancia;
	}


	/**
	 * @return the datosArca
	 */
	public Boolean getDatosArca() {
		return datosArca;
	}


	/**
	 * @param datosArca the datosArca to set
	 */
	public void setDatosArca(Boolean datosArca) {
		this.datosArca = datosArca;
	}

	public String getGeneralPolizaEstatus() {
		return generalPolizaEstatus;
	}

	public void setGeneralPolizaEstatus(String generalPolizaEstatus) {
		this.generalPolizaEstatus = generalPolizaEstatus;
	}
	
	/**
	 * @return the matriz
	 */
	public Boolean getMatriz() {
		return matriz;
	}


	/**
	 * @param matriz the matriz to set
	 */
	public void setMatriz(Boolean matriz) {
		this.matriz = matriz;
	}


	/**
	 * @return the codigoMatriz
	 */
	public String getCodigoMatriz() {
		return codigoMatriz;
	}


	/**
	 * @param codigoMatriz the codigoMatriz to set
	 */
	public void setCodigoMatriz(String codigoMatriz) {
		this.codigoMatriz = codigoMatriz;
	}


	/**
	 * @return the distanciaAlArribo
	 */
	public String getDistanciaAlArribo() {
		return distanciaAlArribo;
	}


	/**
	 * @param distanciaAlArribo the distanciaAlArribo to set
	 */
	public void setDistanciaAlArribo(String distanciaAlArribo) {
		this.distanciaAlArribo = distanciaAlArribo;
	}


	/**
	 * @return the serviciosAsistenciaVial
	 */
	public Boolean getServiciosAsistenciaVial() {
		return serviciosAsistenciaVial;
	}


	/**
	 * @param serviciosAsistenciaVial the serviciosAsistenciaVial to set
	 */
	public void setServiciosAsistenciaVial(Boolean serviciosAsistenciaVial) {
		this.serviciosAsistenciaVial = serviciosAsistenciaVial;
	}


	/**
	 * @return the latitudArriboAsegurado
	 */
	public String getLatitudArriboAsegurado() {
		return latitudArriboAsegurado;
	}


	/**
	 * @param latitudArriboAsegurado the latitudArriboAsegurado to set
	 */
	public void setLatitudArriboAsegurado(String latitudArriboAsegurado) {
		this.latitudArriboAsegurado = latitudArriboAsegurado;
	}


	/**
	 * @return the longitudArriboAsegurado
	 */
	public String getLongitudArriboAsegurado() {
		return longitudArriboAsegurado;
	}


	/**
	 * @param longitudArriboAsegurado the longitudArriboAsegurado to set
	 */
	public void setLongitudArriboAsegurado(String longitudArriboAsegurado) {
		this.longitudArriboAsegurado = longitudArriboAsegurado;
	}


	/**
	 * @return the arribloCloud
	 */
	public Boolean getArribloCloud() {
		return arribloCloud;
	}


	/**
	 * @param arribloCloud the arribloCloud to set
	 */
	public void setArribloCloud(Boolean arribloCloud) {
		this.arribloCloud = arribloCloud;
	}

	/**
	 * @return the tipoUnidadAsegurado
	 */
	public String getTipoUnidadAsegurado() {
		return tipoUnidadAsegurado;
	}

	
	/**
	 * @param tipoUnidadAsegurado the tipoUnidadAsegurado to set
	 */
	public void setTipoUnidadAsegurado(String tipoUnidadAsegurado) {
		this.tipoUnidadAsegurado = tipoUnidadAsegurado;
	}


	/**
	 * @return the claveAgente
	 */
	public String getClaveAgente() {
		return claveAgente;
	}


	/**
	 * @param claveAgente the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}


	public String getUbicacionCorrecta() {
		return ubicacionCorrecta;
	}


	public void setUbicacionCorrecta(String ubicacionCorrecta) {
		this.ubicacionCorrecta = ubicacionCorrecta;
	}


	
	
	
}