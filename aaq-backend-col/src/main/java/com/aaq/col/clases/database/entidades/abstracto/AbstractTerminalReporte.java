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

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.entidades.CatalogoClaveDeEntidad;
import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;



@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTerminalReporte extends JMEntidad {

	private static final long serialVersionUID = 7679743842723841924L;

	@SequenceGenerator(name = "terminal_reporteSEQ", sequenceName = "terminal_reporte_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_reporteSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "ramo", length = 255, nullable = true, unique = true)
	private String ramo;

	@Column(name = "anio", length = 255, nullable = true, unique = true)
	private String anio;

	@Column(name = "reporte", length = 255, nullable = true, unique = true)
	private String reporte;

	@Column(name = "siniestro", length = 255, nullable = true, unique = true)
	private String siniestro;

	@Column(name = "deposito_fecha", length = 255, nullable = true, unique = false)
	private String depositoFecha;

	@Column(name = "deposito_hora", length = 255, nullable = true, unique = false)
	private String depositoHora;

	@Column(name = "deposito_banco", length = 255, nullable = true, unique = false)
	private String depositoBanco;

	@Column(name = "deposito_folio", length = 255, nullable = true, unique = false)
	private String depositoFolio;

	@Column(name = "deposito_importe", length = 255, nullable = true, unique = false)
	private String depositoImporte;

	@Column(name = "ajustador_original", length = 255, nullable = true, unique = true)
	private String ajustadorOriginal;

	@Column(name = "ajustador_nuevo", length = 255, nullable = true, unique = false)
	private String ajustadorNuevo;

	@Column(name = "identificadorunico", length = 255, nullable = true, unique = true)
	private String identificadorunico;

	@Column(name = "deposito_tipo_pago", length = 255, nullable = true, unique = false)
	private String depositoTipoPago;

	@Column(name = "deposito_referencia", length = 255, nullable = true, unique = false)
	private String depositoReferencia;

	@Column(name = "folio_ajustador", length = 255, nullable = true, unique = false)
	private String folioAjustador;

	@Column(name = "averiguacion_previa_numero", length = 255, nullable = true, unique = false)
	private String averiguacionPreviaNumero;

	@Column(name = "averiguacion_previa_fecha", length = 255, nullable = true, unique = false)
	private String averiguacionPreviaFecha;

	@Column(name = "repuve_fecha_de_enviado", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date repuveFechaDeEnviado;

	@Column(name = "repuve_respuesta_del_ws", length = 255, nullable = true, unique = false)
	private String repuveRespuestaDelWs;

	@Column(name = "sipac_aplica", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean sipacAplica;

	@Column(name = "sipac_dimos", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean sipacDimos;

	@Column(name = "sipac_recibimos", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean sipacRecibimos;

	@Column(name = "sipac_ambos", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean sipacAmbos;

	@Column(name = "sipac_folio", length = 255, nullable = true, unique = false)
	private String sipacFolio;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoAseguradora.class)
	@JoinColumn(name = "sipac_recibimos_id", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoAseguradora catalogoAseguradoraBySipacRecibimosId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoAseguradora.class)
	@JoinColumn(name = "sipac_ambos_id", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoAseguradora catalogoAseguradoraBySipacAmbosId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoAseguradora.class)
	@JoinColumn(name = "sipac_dimos_id", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoAseguradora catalogoAseguradoraBySipacDimosId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoClaveDeEntidad.class)
	@JoinColumn(name = "codigo_de_entidad", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoClaveDeEntidad catalogoClaveDeEntidadByCodigoDeEntidad;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoClaveDeEntidad.class)
	@JoinColumn(name = "codigo_de_municipio", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoClaveDeEntidad catalogoClaveDeEntidadByCodigoDeMunicipio;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoCodigoDeCausa.class)
	@JoinColumn(name = "codigo_de_causa", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoCodigoDeCausa catalogoCodigoDeCausa;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	// Constructors

	/** default constructor */
	public AbstractTerminalReporte() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the ramo
	 */
	public String getRamo() {
		return this.ramo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param ramo
	 *            the ramo to set
	 */
	public void setRamo(final String ramo) {
		this.ramo = ramo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the anio
	 */
	public String getAnio() {
		return this.anio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(final String anio) {
		this.anio = anio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the reporte
	 */
	public String getReporte() {
		return this.reporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(final String reporte) {
		this.reporte = reporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the siniestro
	 */
	public String getSiniestro() {
		return this.siniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param siniestro
	 *            the siniestro to set
	 */
	public void setSiniestro(final String siniestro) {
		this.siniestro = siniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoFecha
	 */
	public String getDepositoFecha() {
		return this.depositoFecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoFecha
	 *            the depositoFecha to set
	 */
	public void setDepositoFecha(final String depositoFecha) {
		this.depositoFecha = depositoFecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoHora
	 */
	public String getDepositoHora() {
		return this.depositoHora;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoHora
	 *            the depositoHora to set
	 */
	public void setDepositoHora(final String depositoHora) {
		this.depositoHora = depositoHora;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoBanco
	 */
	public String getDepositoBanco() {
		return this.depositoBanco;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoBanco
	 *            the depositoBanco to set
	 */
	public void setDepositoBanco(final String depositoBanco) {
		this.depositoBanco = depositoBanco;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoFolio
	 */
	public String getDepositoFolio() {
		return this.depositoFolio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoFolio
	 *            the depositoFolio to set
	 */
	public void setDepositoFolio(final String depositoFolio) {
		this.depositoFolio = depositoFolio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoImporte
	 */
	public String getDepositoImporte() {
		return this.depositoImporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoImporte
	 *            the depositoImporte to set
	 */
	public void setDepositoImporte(final String depositoImporte) {
		this.depositoImporte = depositoImporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the ajustadorOriginal
	 */
	public String getAjustadorOriginal() {
		return this.ajustadorOriginal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param ajustadorOriginal
	 *            the ajustadorOriginal to set
	 */
	public void setAjustadorOriginal(final String ajustadorOriginal) {
		this.ajustadorOriginal = ajustadorOriginal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the ajustadorNuevo
	 */
	public String getAjustadorNuevo() {
		return this.ajustadorNuevo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param ajustadorNuevo
	 *            the ajustadorNuevo to set
	 */
	public void setAjustadorNuevo(final String ajustadorNuevo) {
		this.ajustadorNuevo = ajustadorNuevo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the identificadorunico
	 */
	public String getIdentificadorunico() {
		return this.identificadorunico;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param identificadorunico
	 *            the identificadorunico to set
	 */
	public void setIdentificadorunico(final String identificadorunico) {
		this.identificadorunico = identificadorunico;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoTipoPago
	 */
	public String getDepositoTipoPago() {
		return this.depositoTipoPago;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoTipoPago
	 *            the depositoTipoPago to set
	 */
	public void setDepositoTipoPago(final String depositoTipoPago) {
		this.depositoTipoPago = depositoTipoPago;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the depositoReferencia
	 */
	public String getDepositoReferencia() {
		return this.depositoReferencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param depositoReferencia
	 *            the depositoReferencia to set
	 */
	public void setDepositoReferencia(final String depositoReferencia) {
		this.depositoReferencia = depositoReferencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the folioAjustador
	 */
	public String getFolioAjustador() {
		return this.folioAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param folioAjustador
	 *            the folioAjustador to set
	 */
	public void setFolioAjustador(final String folioAjustador) {
		this.folioAjustador = folioAjustador;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the averiguacionPreviaNumero
	 */
	public String getAveriguacionPreviaNumero() {
		return this.averiguacionPreviaNumero;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param averiguacionPreviaNumero
	 *            the averiguacionPreviaNumero to set
	 */
	public void setAveriguacionPreviaNumero(final String averiguacionPreviaNumero) {
		this.averiguacionPreviaNumero = averiguacionPreviaNumero;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the averiguacionPreviaFecha
	 */
	public String getAveriguacionPreviaFecha() {
		return this.averiguacionPreviaFecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param averiguacionPreviaFecha
	 *            the averiguacionPreviaFecha to set
	 */
	public void setAveriguacionPreviaFecha(final String averiguacionPreviaFecha) {
		this.averiguacionPreviaFecha = averiguacionPreviaFecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the repuveFechaDeEnviado
	 */
	public java.util.Date getRepuveFechaDeEnviado() {
		return this.repuveFechaDeEnviado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param repuveFechaDeEnviado
	 *            the repuveFechaDeEnviado to set
	 */
	public void setRepuveFechaDeEnviado(final java.util.Date repuveFechaDeEnviado) {
		this.repuveFechaDeEnviado = repuveFechaDeEnviado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the repuveRespuestaDelWs
	 */
	public String getRepuveRespuestaDelWs() {
		return this.repuveRespuestaDelWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param repuveRespuestaDelWs
	 *            the repuveRespuestaDelWs to set
	 */
	public void setRepuveRespuestaDelWs(final String repuveRespuestaDelWs) {
		this.repuveRespuestaDelWs = repuveRespuestaDelWs;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the sipacAplica
	 */
	public Boolean getSipacAplica() {
		return this.sipacAplica;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param sipacAplica
	 *            the sipacAplica to set
	 */
	public void setSipacAplica(final Boolean sipacAplica) {
		this.sipacAplica = sipacAplica;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the sipacDimos
	 */
	public Boolean getSipacDimos() {
		return this.sipacDimos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param sipacDimos
	 *            the sipacDimos to set
	 */
	public void setSipacDimos(final Boolean sipacDimos) {
		this.sipacDimos = sipacDimos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the sipacRecibimos
	 */
	public Boolean getSipacRecibimos() {
		return this.sipacRecibimos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param sipacRecibimos
	 *            the sipacRecibimos to set
	 */
	public void setSipacRecibimos(final Boolean sipacRecibimos) {
		this.sipacRecibimos = sipacRecibimos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the sipacAmbos
	 */
	public Boolean getSipacAmbos() {
		return this.sipacAmbos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param sipacAmbos
	 *            the sipacAmbos to set
	 */
	public void setSipacAmbos(final Boolean sipacAmbos) {
		this.sipacAmbos = sipacAmbos;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the sipacFolio
	 */
	public String getSipacFolio() {
		return this.sipacFolio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param sipacFolio
	 *            the sipacFolio to set
	 */
	public void setSipacFolio(final String sipacFolio) {
		this.sipacFolio = sipacFolio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the catalogoAseguradoraBySipacRecibimosId
	 */
	public CatalogoAseguradora getCatalogoAseguradoraBySipacRecibimosId() {
		return this.catalogoAseguradoraBySipacRecibimosId;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param catalogoAseguradoraBySipacRecibimosId
	 *            the catalogoAseguradoraBySipacRecibimosId to set
	 */
	public void setCatalogoAseguradoraBySipacRecibimosId(final CatalogoAseguradora catalogoAseguradoraBySipacRecibimosId) {
		this.catalogoAseguradoraBySipacRecibimosId = catalogoAseguradoraBySipacRecibimosId;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the catalogoAseguradoraBySipacAmbosId
	 */
	public CatalogoAseguradora getCatalogoAseguradoraBySipacAmbosId() {
		return this.catalogoAseguradoraBySipacAmbosId;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param catalogoAseguradoraBySipacAmbosId
	 *            the catalogoAseguradoraBySipacAmbosId to set
	 */
	public void setCatalogoAseguradoraBySipacAmbosId(final CatalogoAseguradora catalogoAseguradoraBySipacAmbosId) {
		this.catalogoAseguradoraBySipacAmbosId = catalogoAseguradoraBySipacAmbosId;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the catalogoAseguradoraBySipacDimosId
	 */
	public CatalogoAseguradora getCatalogoAseguradoraBySipacDimosId() {
		return this.catalogoAseguradoraBySipacDimosId;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param catalogoAseguradoraBySipacDimosId
	 *            the catalogoAseguradoraBySipacDimosId to set
	 */
	public void setCatalogoAseguradoraBySipacDimosId(final CatalogoAseguradora catalogoAseguradoraBySipacDimosId) {
		this.catalogoAseguradoraBySipacDimosId = catalogoAseguradoraBySipacDimosId;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the catalogoClaveDeEntidadByCodigoDeEntidad
	 */
	public CatalogoClaveDeEntidad getCatalogoClaveDeEntidadByCodigoDeEntidad() {
		return this.catalogoClaveDeEntidadByCodigoDeEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param catalogoClaveDeEntidadByCodigoDeEntidad
	 *            the catalogoClaveDeEntidadByCodigoDeEntidad to set
	 */
	public void setCatalogoClaveDeEntidadByCodigoDeEntidad(
			final CatalogoClaveDeEntidad catalogoClaveDeEntidadByCodigoDeEntidad) {
		this.catalogoClaveDeEntidadByCodigoDeEntidad = catalogoClaveDeEntidadByCodigoDeEntidad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the catalogoClaveDeEntidadByCodigoDeMunicipio
	 */
	public CatalogoClaveDeEntidad getCatalogoClaveDeEntidadByCodigoDeMunicipio() {
		return this.catalogoClaveDeEntidadByCodigoDeMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param catalogoClaveDeEntidadByCodigoDeMunicipio
	 *            the catalogoClaveDeEntidadByCodigoDeMunicipio to set
	 */
	public void setCatalogoClaveDeEntidadByCodigoDeMunicipio(
			final CatalogoClaveDeEntidad catalogoClaveDeEntidadByCodigoDeMunicipio) {
		this.catalogoClaveDeEntidadByCodigoDeMunicipio = catalogoClaveDeEntidadByCodigoDeMunicipio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the catalogoCodigoDeCausa
	 */
	public CatalogoCodigoDeCausa getCatalogoCodigoDeCausa() {
		return this.catalogoCodigoDeCausa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param catalogoCodigoDeCausa
	 *            the catalogoCodigoDeCausa to set
	 */
	public void setCatalogoCodigoDeCausa(final CatalogoCodigoDeCausa catalogoCodigoDeCausa) {
		this.catalogoCodigoDeCausa = catalogoCodigoDeCausa;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:12 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

}