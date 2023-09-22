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

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReporteSise extends JMEntidad {

	private static final long serialVersionUID = 1667064660288598155L;

	@SequenceGenerator(name = "reporte_siseSEQ", sequenceName = "reporte_sise_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_siseSEQ")
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

	@Column(name = "general_correo_asegurado", length = 255, nullable = true, unique = false)
	private String generalCorreoAsegurado;
	
	@Column(name = "GENERAL_ASEGURADO_LATITUD_TELE", length = 255, nullable = true, unique = false)
	private String generalAseguradoLatitudTelefonia;
	
	@Column(name = "GENERAL_ASEGURADO_LONGITUD_TEL", length = 255, nullable = true, unique = false)
	private String generalAseguradoLongitudTelefonia;
	
	@Column(name = "GENERAL_ASEGURADO_LATITUD_RA", length = 255, nullable = true, unique = false)
	private String generalAseguradoLatitudRadio;
	
	@Column(name = "GENERAL_ASEGURADO_LONGITUD_RA", length = 255, nullable = true, unique = false)
	private String generalAseguradoLongitudRadio;

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

	@Column(name = "GENERAL_ASEGURADO_TELEFONO_ENC", length = 255, nullable = true, unique = false)
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

	@Column(name = "vehiculo_armadora_clave", length = 255, nullable = true, unique = false)
	private String vehiculoArmadoraClave;

	@Column(name = "vehiculo_armadora_nombre", length = 255, nullable = true, unique = false)
	private String vehiculoArmadoraNombre;

	@Column(name = "vehiculo_motor", length = 255, nullable = true, unique = false)
	private String vehiculoMotor;

	@Column(name = "ajuste_ajustador_codigo", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorCodigo;

	@Column(name = "ajuste_ajustador_nombre", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorNombre;

	@Column(name = "ajuste_ajustador_oficina", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorOficina;

	@Column(name = "ajuste_averiguacion", length = 255, nullable = true, unique = false)
	private String ajusteAveriguacion;

	@Column(name = "ajuste_deducible", length = 255, nullable = true, unique = false)
	private String ajusteDeducible;

	@Column(name = "ajuste_ministerio_publioc", length = 255, nullable = true, unique = false)
	private String ajusteMinisterioPublioc;

	@Column(name = "ajuste_pfp", length = 255, nullable = true, unique = false)
	private String ajustePfp;

	@Column(name = "ajuste_recupero_tipo", length = 255, nullable = true, unique = false)
	private String ajusteRecuperoTipo;

	@Column(name = "ajuste_recupero_notas", nullable = true, unique = false)
	private String ajusteRecuperoNotas;

	@Column(name = "consultado_ws", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean consultadoWs;

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

	@Column(name = "terceros", nullable = true, unique = false)
	private String terceros;

	@Column(name = "talleres", nullable = true, unique = false)
	private String talleres;

	@Column(name = "ubicacion_referencia", nullable = true, unique = false)
	private String ubicacionReferencia;

	@Column(name = "token", length = 255, nullable = true, unique = false)
	private String token;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoCodigoDeCausa.class)
	@JoinColumn(name = "id_codigo_causa", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoCodigoDeCausa catalogoCodigoDeCausa;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Estado.class)
	@JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Terminal terminal;
	
//	String numeroReporteLegalA;
//	String nombreA;
//	int telefonoA;
//	String fechaHoraA;
	
	// Constructors

	/** default constructor */
	public AbstractReporteSise() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalNumeroReporte
	 */
	public String getGeneralNumeroReporte() {
		return this.generalNumeroReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalNumeroReporte
	 *            the generalNumeroReporte to set
	 */
	public void setGeneralNumeroReporte(final String generalNumeroReporte) {
		this.generalNumeroReporte = generalNumeroReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalNumeroPoliza
	 */
	public String getGeneralNumeroPoliza() {
		return this.generalNumeroPoliza;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalNumeroPoliza
	 *            the generalNumeroPoliza to set
	 */
	public void setGeneralNumeroPoliza(final String generalNumeroPoliza) {
		this.generalNumeroPoliza = generalNumeroPoliza;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalEndoso
	 */
	public String getGeneralEndoso() {
		return this.generalEndoso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalEndoso
	 *            the generalEndoso to set
	 */
	public void setGeneralEndoso(final String generalEndoso) {
		this.generalEndoso = generalEndoso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalInciso
	 */
	public String getGeneralInciso() {
		return this.generalInciso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalInciso
	 *            the generalInciso to set
	 */
	public void setGeneralInciso(final String generalInciso) {
		this.generalInciso = generalInciso;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalNombreAsegurado
	 */
	public String getGeneralNombreAsegurado() {
		return this.generalNombreAsegurado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalNombreAsegurado
	 *            the generalNombreAsegurado to set
	 */
	public void setGeneralNombreAsegurado(final String generalNombreAsegurado) {
		this.generalNombreAsegurado = generalNombreAsegurado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the conductorNombre
	 */
	public String getConductorNombre() {
		return this.conductorNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param conductorNombre
	 *            the conductorNombre to set
	 */
	public void setConductorNombre(final String conductorNombre) {
		this.conductorNombre = conductorNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoSerie
	 */
	public String getVehiculoSerie() {
		return this.vehiculoSerie;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoSerie
	 *            the vehiculoSerie to set
	 */
	public void setVehiculoSerie(final String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoPlacas
	 */
	public String getVehiculoPlacas() {
		return this.vehiculoPlacas;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoPlacas
	 *            the vehiculoPlacas to set
	 */
	public void setVehiculoPlacas(final String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteFechaPasadoAjustador
	 */
	public String getAjusteFechaPasadoAjustador() {
		return this.ajusteFechaPasadoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteFechaPasadoAjustador
	 *            the ajusteFechaPasadoAjustador to set
	 */
	public void setAjusteFechaPasadoAjustador(final String ajusteFechaPasadoAjustador) {
		this.ajusteFechaPasadoAjustador = ajusteFechaPasadoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteFechaArriboAjustador
	 */
	public String getAjusteFechaArriboAjustador() {
		return this.ajusteFechaArriboAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteFechaArriboAjustador
	 *            the ajusteFechaArriboAjustador to set
	 */
	public void setAjusteFechaArriboAjustador(final String ajusteFechaArriboAjustador) {
		this.ajusteFechaArriboAjustador = ajusteFechaArriboAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteFechaTerminoAjustador
	 */
	public String getAjusteFechaTerminoAjustador() {
		return this.ajusteFechaTerminoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteFechaTerminoAjustador
	 *            the ajusteFechaTerminoAjustador to set
	 */
	public void setAjusteFechaTerminoAjustador(final String ajusteFechaTerminoAjustador) {
		this.ajusteFechaTerminoAjustador = ajusteFechaTerminoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalComoOcurrio
	 */
	public String getGeneralComoOcurrio() {
		return this.generalComoOcurrio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalComoOcurrio
	 *            the generalComoOcurrio to set
	 */
	public void setGeneralComoOcurrio(final String generalComoOcurrio) {
		this.generalComoOcurrio = generalComoOcurrio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteHoraPasadoAjustador
	 */
	public String getAjusteHoraPasadoAjustador() {
		return this.ajusteHoraPasadoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteHoraPasadoAjustador
	 *            the ajusteHoraPasadoAjustador to set
	 */
	public void setAjusteHoraPasadoAjustador(final String ajusteHoraPasadoAjustador) {
		this.ajusteHoraPasadoAjustador = ajusteHoraPasadoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteHoraArriboAjustador
	 */
	public String getAjusteHoraArriboAjustador() {
		return this.ajusteHoraArriboAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteHoraArriboAjustador
	 *            the ajusteHoraArriboAjustador to set
	 */
	public void setAjusteHoraArriboAjustador(final String ajusteHoraArriboAjustador) {
		this.ajusteHoraArriboAjustador = ajusteHoraArriboAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteHoraTerminoAjustador
	 */
	public String getAjusteHoraTerminoAjustador() {
		return this.ajusteHoraTerminoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteHoraTerminoAjustador
	 *            the ajusteHoraTerminoAjustador to set
	 */
	public void setAjusteHoraTerminoAjustador(final String ajusteHoraTerminoAjustador) {
		this.ajusteHoraTerminoAjustador = ajusteHoraTerminoAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteCodigoCausa
	 */
	public String getAjusteCodigoCausa() {
		return this.ajusteCodigoCausa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteCodigoCausa
	 *            the ajusteCodigoCausa to set
	 */
	public void setAjusteCodigoCausa(final String ajusteCodigoCausa) {
		this.ajusteCodigoCausa = ajusteCodigoCausa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the conductorTelefonoContacto
	 */
	public String getConductorTelefonoContacto() {
		return this.conductorTelefonoContacto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param conductorTelefonoContacto
	 *            the conductorTelefonoContacto to set
	 */
	public void setConductorTelefonoContacto(final String conductorTelefonoContacto) {
		this.conductorTelefonoContacto = conductorTelefonoContacto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalNumeroSiniestro
	 */
	public String getGeneralNumeroSiniestro() {
		return this.generalNumeroSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalNumeroSiniestro
	 *            the generalNumeroSiniestro to set
	 */
	public void setGeneralNumeroSiniestro(final String generalNumeroSiniestro) {
		this.generalNumeroSiniestro = generalNumeroSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoMarca
	 */
	public String getVehiculoMarca() {
		return this.vehiculoMarca;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoMarca
	 *            the vehiculoMarca to set
	 */
	public void setVehiculoMarca(final String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoTipo
	 */
	public String getVehiculoTipo() {
		return this.vehiculoTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoTipo
	 *            the vehiculoTipo to set
	 */
	public void setVehiculoTipo(final String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoModelo
	 */
	public String getVehiculoModelo() {
		return this.vehiculoModelo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoModelo
	 *            the vehiculoModelo to set
	 */
	public void setVehiculoModelo(final String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoColor
	 */
	public String getVehiculoColor() {
		return this.vehiculoColor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoColor
	 *            the vehiculoColor to set
	 */
	public void setVehiculoColor(final String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalUsuario
	 */
	public String getGeneralUsuario() {
		return this.generalUsuario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalUsuario
	 *            the generalUsuario to set
	 */
	public void setGeneralUsuario(final String generalUsuario) {
		this.generalUsuario = generalUsuario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the esReasignadoNumero
	 */
	public Integer getEsReasignadoNumero() {
		return this.esReasignadoNumero;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param esReasignadoNumero
	 *            the esReasignadoNumero to set
	 */
	public void setEsReasignadoNumero(final Integer esReasignadoNumero) {
		this.esReasignadoNumero = esReasignadoNumero;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the esSegundaAtencion
	 */
	public Boolean getEsSegundaAtencion() {
		return this.esSegundaAtencion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param esSegundaAtencion
	 *            the esSegundaAtencion to set
	 */
	public void setEsSegundaAtencion(final Boolean esSegundaAtencion) {
		this.esSegundaAtencion = esSegundaAtencion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the esReasignado
	 */
	public Boolean getEsReasignado() {
		return this.esReasignado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param esReasignado
	 *            the esReasignado to set
	 */
	public void setEsReasignado(final Boolean esReasignado) {
		this.esReasignado = esReasignado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the coordLatitudInicio
	 */
	public String getCoordLatitudInicio() {
		return this.coordLatitudInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param coordLatitudInicio
	 *            the coordLatitudInicio to set
	 */
	public void setCoordLatitudInicio(final String coordLatitudInicio) {
		this.coordLatitudInicio = coordLatitudInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the coordLongitudInicio
	 */
	public String getCoordLongitudInicio() {
		return this.coordLongitudInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param coordLongitudInicio
	 *            the coordLongitudInicio to set
	 */
	public void setCoordLongitudInicio(final String coordLongitudInicio) {
		this.coordLongitudInicio = coordLongitudInicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the coordLatitudArribo
	 */
	public String getCoordLatitudArribo() {
		return this.coordLatitudArribo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param coordLatitudArribo
	 *            the coordLatitudArribo to set
	 */
	public void setCoordLatitudArribo(final String coordLatitudArribo) {
		this.coordLatitudArribo = coordLatitudArribo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the coordLongitudArribo
	 */
	public String getCoordLongitudArribo() {
		return this.coordLongitudArribo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param coordLongitudArribo
	 *            the coordLongitudArribo to set
	 */
	public void setCoordLongitudArribo(final String coordLongitudArribo) {
		this.coordLongitudArribo = coordLongitudArribo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the coordLatitudTermino
	 */
	public String getCoordLatitudTermino() {
		return this.coordLatitudTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param coordLatitudTermino
	 *            the coordLatitudTermino to set
	 */
	public void setCoordLatitudTermino(final String coordLatitudTermino) {
		this.coordLatitudTermino = coordLatitudTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the coordLongitudTermino
	 */
	public String getCoordLongitudTermino() {
		return this.coordLongitudTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param coordLongitudTermino
	 *            the coordLongitudTermino to set
	 */
	public void setCoordLongitudTermino(final String coordLongitudTermino) {
		this.coordLongitudTermino = coordLongitudTermino;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalOficinaReporte
	 */
	public String getGeneralOficinaReporte() {
		return this.generalOficinaReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalOficinaReporte
	 *            the generalOficinaReporte to set
	 */
	public void setGeneralOficinaReporte(final String generalOficinaReporte) {
		this.generalOficinaReporte = generalOficinaReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalFechaOcurrido
	 */
	public String getGeneralFechaOcurrido() {
		return this.generalFechaOcurrido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalFechaOcurrido
	 *            the generalFechaOcurrido to set
	 */
	public void setGeneralFechaOcurrido(final String generalFechaOcurrido) {
		this.generalFechaOcurrido = generalFechaOcurrido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalHoraOcurrido
	 */
	public String getGeneralHoraOcurrido() {
		return this.generalHoraOcurrido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalHoraOcurrido
	 *            the generalHoraOcurrido to set
	 */
	public void setGeneralHoraOcurrido(final String generalHoraOcurrido) {
		this.generalHoraOcurrido = generalHoraOcurrido;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalAseguradoCodigo
	 */
	public String getGeneralAseguradoCodigo() {
		return this.generalAseguradoCodigo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalAseguradoCodigo
	 *            the generalAseguradoCodigo to set
	 */
	public void setGeneralAseguradoCodigo(final String generalAseguradoCodigo) {
		this.generalAseguradoCodigo = generalAseguradoCodigo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalAseguradoTelefonoEncuesta
	 */
	public String getGeneralAseguradoTelefonoEncuesta() {
		return this.generalAseguradoTelefonoEncuesta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalAseguradoTelefonoEncuesta
	 *            the generalAseguradoTelefonoEncuesta to set
	 */
	public void setGeneralAseguradoTelefonoEncuesta(final String generalAseguradoTelefonoEncuesta) {
		this.generalAseguradoTelefonoEncuesta = generalAseguradoTelefonoEncuesta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalAseguradoTelefono
	 */
	public String getGeneralAseguradoTelefono() {
		return this.generalAseguradoTelefono;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalAseguradoTelefono
	 *            the generalAseguradoTelefono to set
	 */
	public void setGeneralAseguradoTelefono(final String generalAseguradoTelefono) {
		this.generalAseguradoTelefono = generalAseguradoTelefono;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalReporto
	 */
	public String getGeneralReporto() {
		return this.generalReporto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalReporto
	 *            the generalReporto to set
	 */
	public void setGeneralReporto(final String generalReporto) {
		this.generalReporto = generalReporto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalObservacion
	 */
	public String getGeneralObservacion() {
		return this.generalObservacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalObservacion
	 *            the generalObservacion to set
	 */
	public void setGeneralObservacion(final String generalObservacion) {
		this.generalObservacion = generalObservacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalTipoReporte
	 */
	public String getGeneralTipoReporte() {
		return this.generalTipoReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalTipoReporte
	 *            the generalTipoReporte to set
	 */
	public void setGeneralTipoReporte(final String generalTipoReporte) {
		this.generalTipoReporte = generalTipoReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalFechaRegistroSiniestro
	 */
	public String getGeneralFechaRegistroSiniestro() {
		return this.generalFechaRegistroSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalFechaRegistroSiniestro
	 *            the generalFechaRegistroSiniestro to set
	 */
	public void setGeneralFechaRegistroSiniestro(final String generalFechaRegistroSiniestro) {
		this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the conductorEdad
	 */
	public String getConductorEdad() {
		return this.conductorEdad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
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
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param conductorSexo
	 *            the conductorSexo to set
	 */
	public void setConductorSexo(final String conductorSexo) {
		this.conductorSexo = conductorSexo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionDireccion
	 */
	public String getUbicacionDireccion() {
		return this.ubicacionDireccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionDireccion
	 *            the ubicacionDireccion to set
	 */
	public void setUbicacionDireccion(final String ubicacionDireccion) {
		this.ubicacionDireccion = ubicacionDireccion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionCarretera
	 */
	public String getUbicacionCarretera() {
		return this.ubicacionCarretera;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionCarretera
	 *            the ubicacionCarretera to set
	 */
	public void setUbicacionCarretera(final String ubicacionCarretera) {
		this.ubicacionCarretera = ubicacionCarretera;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionNacional
	 */
	public String getUbicacionNacional() {
		return this.ubicacionNacional;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionNacional
	 *            the ubicacionNacional to set
	 */
	public void setUbicacionNacional(final String ubicacionNacional) {
		this.ubicacionNacional = ubicacionNacional;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionCodigoPostal
	 */
	public String getUbicacionCodigoPostal() {
		return this.ubicacionCodigoPostal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionCodigoPostal
	 *            the ubicacionCodigoPostal to set
	 */
	public void setUbicacionCodigoPostal(final String ubicacionCodigoPostal) {
		this.ubicacionCodigoPostal = ubicacionCodigoPostal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionEntidad
	 */
	public String getUbicacionEntidad() {
		return this.ubicacionEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionEntidad
	 *            the ubicacionEntidad to set
	 */
	public void setUbicacionEntidad(final String ubicacionEntidad) {
		this.ubicacionEntidad = ubicacionEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionMunicipio
	 */
	public String getUbicacionMunicipio() {
		return this.ubicacionMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionMunicipio
	 *            the ubicacionMunicipio to set
	 */
	public void setUbicacionMunicipio(final String ubicacionMunicipio) {
		this.ubicacionMunicipio = ubicacionMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionColoniaCodigo
	 */
	public String getUbicacionColoniaCodigo() {
		return this.ubicacionColoniaCodigo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionColoniaCodigo
	 *            the ubicacionColoniaCodigo to set
	 */
	public void setUbicacionColoniaCodigo(final String ubicacionColoniaCodigo) {
		this.ubicacionColoniaCodigo = ubicacionColoniaCodigo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionColoniaDesc
	 */
	public String getUbicacionColoniaDesc() {
		return this.ubicacionColoniaDesc;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionColoniaDesc
	 *            the ubicacionColoniaDesc to set
	 */
	public void setUbicacionColoniaDesc(final String ubicacionColoniaDesc) {
		this.ubicacionColoniaDesc = ubicacionColoniaDesc;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoArmadoraClave
	 */
	public String getVehiculoArmadoraClave() {
		return this.vehiculoArmadoraClave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoArmadoraClave
	 *            the vehiculoArmadoraClave to set
	 */
	public void setVehiculoArmadoraClave(final String vehiculoArmadoraClave) {
		this.vehiculoArmadoraClave = vehiculoArmadoraClave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoArmadoraNombre
	 */
	public String getVehiculoArmadoraNombre() {
		return this.vehiculoArmadoraNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoArmadoraNombre
	 *            the vehiculoArmadoraNombre to set
	 */
	public void setVehiculoArmadoraNombre(final String vehiculoArmadoraNombre) {
		this.vehiculoArmadoraNombre = vehiculoArmadoraNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the vehiculoMotor
	 */
	public String getVehiculoMotor() {
		return this.vehiculoMotor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param vehiculoMotor
	 *            the vehiculoMotor to set
	 */
	public void setVehiculoMotor(final String vehiculoMotor) {
		this.vehiculoMotor = vehiculoMotor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteAjustadorCodigo
	 */
	public String getAjusteAjustadorCodigo() {
		return this.ajusteAjustadorCodigo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteAjustadorCodigo
	 *            the ajusteAjustadorCodigo to set
	 */
	public void setAjusteAjustadorCodigo(final String ajusteAjustadorCodigo) {
		this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteAjustadorNombre
	 */
	public String getAjusteAjustadorNombre() {
		return this.ajusteAjustadorNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteAjustadorNombre
	 *            the ajusteAjustadorNombre to set
	 */
	public void setAjusteAjustadorNombre(final String ajusteAjustadorNombre) {
		this.ajusteAjustadorNombre = ajusteAjustadorNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteAjustadorOficina
	 */
	public String getAjusteAjustadorOficina() {
		return this.ajusteAjustadorOficina;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteAjustadorOficina
	 *            the ajusteAjustadorOficina to set
	 */
	public void setAjusteAjustadorOficina(final String ajusteAjustadorOficina) {
		this.ajusteAjustadorOficina = ajusteAjustadorOficina;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteAveriguacion
	 */
	public String getAjusteAveriguacion() {
		return this.ajusteAveriguacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteAveriguacion
	 *            the ajusteAveriguacion to set
	 */
	public void setAjusteAveriguacion(final String ajusteAveriguacion) {
		this.ajusteAveriguacion = ajusteAveriguacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteDeducible
	 */
	public String getAjusteDeducible() {
		return this.ajusteDeducible;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteDeducible
	 *            the ajusteDeducible to set
	 */
	public void setAjusteDeducible(final String ajusteDeducible) {
		this.ajusteDeducible = ajusteDeducible;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteMinisterioPublioc
	 */
	public String getAjusteMinisterioPublioc() {
		return this.ajusteMinisterioPublioc;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteMinisterioPublioc
	 *            the ajusteMinisterioPublioc to set
	 */
	public void setAjusteMinisterioPublioc(final String ajusteMinisterioPublioc) {
		this.ajusteMinisterioPublioc = ajusteMinisterioPublioc;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajustePfp
	 */
	public String getAjustePfp() {
		return this.ajustePfp;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajustePfp
	 *            the ajustePfp to set
	 */
	public void setAjustePfp(final String ajustePfp) {
		this.ajustePfp = ajustePfp;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteRecuperoTipo
	 */
	public String getAjusteRecuperoTipo() {
		return this.ajusteRecuperoTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteRecuperoTipo
	 *            the ajusteRecuperoTipo to set
	 */
	public void setAjusteRecuperoTipo(final String ajusteRecuperoTipo) {
		this.ajusteRecuperoTipo = ajusteRecuperoTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ajusteRecuperoNotas
	 */
	public String getAjusteRecuperoNotas() {
		return this.ajusteRecuperoNotas;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ajusteRecuperoNotas
	 *            the ajusteRecuperoNotas to set
	 */
	public void setAjusteRecuperoNotas(final String ajusteRecuperoNotas) {
		this.ajusteRecuperoNotas = ajusteRecuperoNotas;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the consultadoWs
	 */
	public Boolean getConsultadoWs() {
		return this.consultadoWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param consultadoWs
	 *            the consultadoWs to set
	 */
	public void setConsultadoWs(final Boolean consultadoWs) {
		this.consultadoWs = consultadoWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalMonedaClave
	 */
	public String getGeneralMonedaClave() {
		return this.generalMonedaClave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalMonedaClave
	 *            the generalMonedaClave to set
	 */
	public void setGeneralMonedaClave(final String generalMonedaClave) {
		this.generalMonedaClave = generalMonedaClave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the generalMonedaNombre
	 */
	public String getGeneralMonedaNombre() {
		return this.generalMonedaNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param generalMonedaNombre
	 *            the generalMonedaNombre to set
	 */
	public void setGeneralMonedaNombre(final String generalMonedaNombre) {
		this.generalMonedaNombre = generalMonedaNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the fechaReporteEnvioSms
	 */
	public java.util.Date getFechaReporteEnvioSms() {
		return this.fechaReporteEnvioSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param fechaReporteEnvioSms
	 *            the fechaReporteEnvioSms to set
	 */
	public void setFechaReporteEnvioSms(final java.util.Date fechaReporteEnvioSms) {
		this.fechaReporteEnvioSms = fechaReporteEnvioSms;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the fechaReporteLecturaPorWs
	 */
	public java.util.Date getFechaReporteLecturaPorWs() {
		return this.fechaReporteLecturaPorWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param fechaReporteLecturaPorWs
	 *            the fechaReporteLecturaPorWs to set
	 */
	public void setFechaReporteLecturaPorWs(final java.util.Date fechaReporteLecturaPorWs) {
		this.fechaReporteLecturaPorWs = fechaReporteLecturaPorWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the terceros
	 */
	public String getTerceros() {
		return this.terceros;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param terceros
	 *            the terceros to set
	 */
	public void setTerceros(final String terceros) {
		this.terceros = terceros;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the talleres
	 */
	public String getTalleres() {
		return this.talleres;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param talleres
	 *            the talleres to set
	 */
	public void setTalleres(final String talleres) {
		this.talleres = talleres;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the ubicacionReferencia
	 */
	public String getUbicacionReferencia() {
		return this.ubicacionReferencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param ubicacionReferencia
	 *            the ubicacionReferencia to set
	 */
	public void setUbicacionReferencia(final String ubicacionReferencia) {
		this.ubicacionReferencia = ubicacionReferencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the token
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(final String token) {
		this.token = token;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the catalogoCodigoDeCausa
	 */
	public CatalogoCodigoDeCausa getCatalogoCodigoDeCausa() {
		return this.catalogoCodigoDeCausa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param catalogoCodigoDeCausa
	 *            the catalogoCodigoDeCausa to set
	 */
	public void setCatalogoCodigoDeCausa(final CatalogoCodigoDeCausa catalogoCodigoDeCausa) {
		this.catalogoCodigoDeCausa = catalogoCodigoDeCausa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:13:22 PM
	 *
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * mfernandez Dec 18, 2014 11:36:52 AM
	 * 
	 * @return the generalCorreoAsegurado
	 */
	public String getGeneralCorreoAsegurado() {
		return this.generalCorreoAsegurado;
	}

	/**
	 * mfernandez Dec 18, 2014 11:36:52 AM
	 * 
	 * @param generalCorreoAsegurado
	 *            the generalCorreoAsegurado to set
	 */
	public void setGeneralCorreoAsegurado(final String generalCorreoAsegurado) {
		this.generalCorreoAsegurado = generalCorreoAsegurado;
	}

	/**
	 * @return the generalAseguradoLatitudTelefonia
	 */
	public String getGeneralAseguradoLatitudTelefonia() {
		return this.generalAseguradoLatitudTelefonia;
	}

	/**
	 * @param generalAseguradoLatitudTelefonia the generalAseguradoLatitudTelefonia to set
	 */
	public void setGeneralAseguradoLatitudTelefonia(
			final String generalAseguradoLatitudTelefonia) {
		this.generalAseguradoLatitudTelefonia = generalAseguradoLatitudTelefonia;
	}

	/**
	 * @return the generalAseguradoLongitudTelefonia
	 */
	public String getGeneralAseguradoLongitudTelefonia() {
		return this.generalAseguradoLongitudTelefonia;
	}

	/**
	 * @param generalAseguradoLongitudTelefonia the generalAseguradoLongitudTelefonia to set
	 */
	public void setGeneralAseguradoLongitudTelefonia(
			final String generalAseguradoLongitudTelefonia) {
		this.generalAseguradoLongitudTelefonia = generalAseguradoLongitudTelefonia;
	}

	/**
	 * @return the generalAseguradoLatitudRadio
	 */
	public String getGeneralAseguradoLatitudRadio() {
		return this.generalAseguradoLatitudRadio;
	}

	/**
	 * @param generalAseguradoLatitudRadio the generalAseguradoLatitudRadio to set
	 */
	public void setGeneralAseguradoLatitudRadio(final String generalAseguradoLatitudRadio) {
		this.generalAseguradoLatitudRadio = generalAseguradoLatitudRadio;
	}

	/**
	 * @return the generalAseguradoLongitudRadio
	 */
	public String getGeneralAseguradoLongitudRadio() {
		return this.generalAseguradoLongitudRadio;
	}

	/**
	 * @param generalAseguradoLongitudRadio the generalAseguradoLongitudRadio to set
	 */
	public void setGeneralAseguradoLongitudRadio(
			final String generalAseguradoLongitudRadio) {
		this.generalAseguradoLongitudRadio = generalAseguradoLongitudRadio;
	}

//	public String getNumeroReporteLegalA() {
//		return numeroReporteLegalA;
//	}
//
//	public void setNumeroReporteLegalA(String numeroReporteSiseA) {
//		this.numeroReporteLegalA = numeroReporteSiseA;
//	}
//	
//	public String getNombreA() {
//		return nombreA;
//	}
//
//	public void setNombreA(String nombreA) {
//		this.nombreA = nombreA;
//	}
//
//	public int getTelefonoA() {
//		return telefonoA;
//	}
//
//	public void setTelefonoA(int telefonoA) {
//		this.telefonoA = telefonoA;
//	}
//
//	public String getFechaHoraA() {
//		return fechaHoraA;
//	}
//
//	public void setFechaHoraA(String fechaHoraA) {
//		this.fechaHoraA = fechaHoraA;
//	}


}