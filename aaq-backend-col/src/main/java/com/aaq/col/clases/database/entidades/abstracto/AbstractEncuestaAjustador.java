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
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractEncuestaAjustador extends JMEntidad {
	private static final long serialVersionUID = -4080429575423424470L;

	@SequenceGenerator(name = "encuestaSEQ", sequenceName = "encuesta_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encuestaSEQ")
	private Integer id;
	
	@Column(name = "numero_reporte", length = 255, nullable = true, unique = false)
	private String numeroReporte;
	
	@Column(name = "nombre_asegurado", length = 255, nullable = true, unique = false)
	private String nombreAsegurado;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "clave_ajustador", referencedColumnName = "numeroproveedor", nullable = true, unique = false, insertable = true, updatable = true)
	private Terminal terminal;
	
//	@Column(name = "clave_ajustador", length = 255, nullable = true, unique = false)
//	private String claveAjustador;

	@Column(name = "atencion_personal_cabina", nullable = false, unique = false)
	private Integer atencionPersonalCabina;
	
	@Column(name = "llegada_ajustador", nullable = false, unique = false)
	private Integer llegadaAjustador;
	
	@Column(name = "presentacion_ajustador", nullable = false, unique = false)
	private Integer presentacionAjustador;
	
	@Column(name = "trato_ajustador", nullable = false, unique = false)
	private Integer tratoAjustador;
	
	@Column(name = "capacidad_ajustador", nullable = false, unique = false)
	private Integer capacidadAjustador;
	
	@Column(name = "trato_ajustador_tercero", nullable = false, unique = false)
	private Integer tratoAjustadorTercero;
	
	@Column(name = "servicio_de_Grua", nullable = true, unique = false)
	private Integer servicioGrua;

	@Column(name = "seleccion_de_Taller", nullable = true, unique = false)
	private Integer seleccionDeTaller;

	@Column(name = "observo_irregularidad_servicio", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean observoIrregularidadServicio;

	@Column(name = "recibio_copia_da", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean recibioCopiaDA;

	@Column(name = "observaciones", length = 255, nullable = true, unique = false)
	private String observaciones;
	
	@Column(name = "nombre_conductor", length = 255, nullable = true, unique = false)
	private String nombreConductor;
	
	@Column(name = "telefono_conductor", length = 255, nullable = true, unique = false)
	private String telefonoConductor;
	
	@Column(name = "correo_conductor", length = 255, nullable = true, unique = false)
	private String correoConductor;
	
	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Estado.class)
	@JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Base.class)
	@JoinColumn(name = "id_base", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Base base;
	
	@Column(name = "poliza", length = 255, nullable = true, unique = false)
	private String poliza;
	
	@Column(name = "enviado_ftp", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean enviadoFtp;
	 
	@Column(name = "ftp_respuesta", length = 255, nullable = true, unique = false)
	private String respuestaFtp;

	// Constructors

	/** default constructor */
	public AbstractEncuestaAjustador() {
		super();
	}


	/**
	 * @return the id
	 */
	public final Integer getId() {
		return this.id;
	}


	/**
	 * @param id the id to set
	 */
	public final void setId(final Integer id) {
		this.id = id;
	}


	/**
	 * @return the numeroReporte
	 */
	public final String getNumeroReporte() {
		return this.numeroReporte;
	}


	/**
	 * @param numeroReporte the numeroReporte to set
	 */
	public final void setNumeroReporte(final String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}


	/**
	 * @return the nombreAsegurado
	 */
	public final String getNombreAsegurado() {
		return this.nombreAsegurado;
	}


	/**
	 * @param nombreAsegurado the nombreAsegurado to set
	 */
	public final void setNombreAsegurado(final String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
	}


//	/**
//	 * @return the claveAjustador
//	 */
//	public final String getClaveAjustador() {
//		return this.claveAjustador;
//	}
//
//
//	/**
//	 * @param claveAjustador the claveAjustador to set
//	 */
//	public final void setClaveAjustador(final String claveAjustador) {
//		this.claveAjustador = claveAjustador;
//	}


	/**
	 * @return the atencionPersonalCabina
	 */
	public final Integer getAtencionPersonalCabina() {
		return this.atencionPersonalCabina;
	}


	/**
	 * @param atencionPersonalCabina the atencionPersonalCabina to set
	 */
	public final void setAtencionPersonalCabina(final Integer atencionPersonalCabina) {
		this.atencionPersonalCabina = atencionPersonalCabina;
	}


	/**
	 * @return the llegadaAjustador
	 */
	public final Integer getLlegadaAjustador() {
		return this.llegadaAjustador;
	}


	/**
	 * @param llegadaAjustador the llegadaAjustador to set
	 */
	public final void setLlegadaAjustador(final Integer llegadaAjustador) {
		this.llegadaAjustador = llegadaAjustador;
	}


	/**
	 * @return the presentacionAjustador
	 */
	public final Integer getPresentacionAjustador() {
		return this.presentacionAjustador;
	}


	/**
	 * @param presentacionAjustador the presentacionAjustador to set
	 */
	public final void setPresentacionAjustador(final Integer presentacionAjustador) {
		this.presentacionAjustador = presentacionAjustador;
	}


	/**
	 * @return the tratoAjustador
	 */
	public final Integer getTratoAjustador() {
		return this.tratoAjustador;
	}


	/**
	 * @param tratoAjustador the tratoAjustador to set
	 */
	public final void setTratoAjustador(final Integer tratoAjustador) {
		this.tratoAjustador = tratoAjustador;
	}


	/**
	 * @return the capacidadAjustador
	 */
	public final Integer getCapacidadAjustador() {
		return this.capacidadAjustador;
	}


	/**
	 * @param capacidadAjustador the capacidadAjustador to set
	 */
	public final void setCapacidadAjustador(final Integer capacidadAjustador) {
		this.capacidadAjustador = capacidadAjustador;
	}


	/**
	 * @return the tratoAjustadorTercero
	 */
	public final Integer getTratoAjustadorTercero() {
		return this.tratoAjustadorTercero;
	}


	/**
	 * @param tratoAjustadorTercero the tratoAjustadorTercero to set
	 */
	public final void setTratoAjustadorTercero(final Integer tratoAjustadorTercero) {
		this.tratoAjustadorTercero = tratoAjustadorTercero;
	}


	/**
	 * @return the servicioGrua
	 */
	public final Integer getServicioGrua() {
		return this.servicioGrua;
	}


	/**
	 * @param servicioGrua the servicioGrua to set
	 */
	public final void setServicioGrua(final Integer servicioGrua) {
		this.servicioGrua = servicioGrua;
	}


	/**
	 * @return the seleccionDeTaller
	 */
	public final Integer getSeleccionDeTaller() {
		return this.seleccionDeTaller;
	}


	/**
	 * @param seleccionDeTaller the seleccionDeTaller to set
	 */
	public final void setSeleccionDeTaller(final Integer seleccionDeTaller) {
		this.seleccionDeTaller = seleccionDeTaller;
	}


	/**
	 * @return the observoIrregularidadServicio
	 */
	public final Boolean getObservoIrregularidadServicio() {
		return this.observoIrregularidadServicio;
	}


	/**
	 * @param observoIrregularidadServicio the observoIrregularidadServicio to set
	 */
	public final void setObservoIrregularidadServicio(
			final Boolean observoIrregularidadServicio) {
		this.observoIrregularidadServicio = observoIrregularidadServicio;
	}


	/**
	 * @return the recibioCopiaDA
	 */
	public final Boolean getRecibioCopiaDA() {
		return this.recibioCopiaDA;
	}


	/**
	 * @param recibioCopiaDA the recibioCopiaDA to set
	 */
	public final void setRecibioCopiaDA(final Boolean recibioCopiaDA) {
		this.recibioCopiaDA = recibioCopiaDA;
	}
	
	/**
	 * @return the observaciones
	 */
	public final String getObservaciones() {
		return this.observaciones;
	}


	/**
	 * @param observaciones the observaciones to set
	 */
	public final void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
	}


	/**
	 * @return the nombreConductor
	 */
	public final String getNombreConductor() {
		return this.nombreConductor;
	}


	/**
	 * @param nombreConductor the nombreConductor to set
	 */
	public final void setNombreConductor(final String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}


	/**
	 * @return the telefonoConductor
	 */
	public final String getTelefonoConductor() {
		return this.telefonoConductor;
	}


	/**
	 * @param telefonoConductor the telefonoConductor to set
	 */
	public final void setTelefonoConductor(final String telefonoConductor) {
		this.telefonoConductor = telefonoConductor;
	}


	/**
	 * @return the correoConductor
	 */
	public final String getCorreoConductor() {
		return this.correoConductor;
	}


	/**
	 * @param correoConductor the correoConductor to set
	 */
	public final void setCorreoConductor(final String correoConductor) {
		this.correoConductor = correoConductor;
	}


	/**
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}


	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}


	/**
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
	}


	/**
	 * @return the base
	 */
	public Base getBase() {
		return this.base;
	}


	/**
	 * @param base the base to set
	 */
	public void setBase(final Base base) {
		this.base = base;
	}


	/**
	 * @return the poliza
	 */
	public String getPoliza() {
		return this.poliza;
	}


	/**
	 * @param poliza the poliza to set
	 */
	public void setPoliza(final String poliza) {
		this.poliza = poliza;
	}
	
	/**
	 * @return the enviadoFtp
	 */
	public Boolean getEnviadoFtp() {
		return this.enviadoFtp;
	}


	/**
	 * @param enviadoFtp the enviadoFtp to set
	 */
	public void setEnviadoFtp(final Boolean enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}


	/**
	 * @return the respuestaFtp
	 */
	public String getRespuestaFtp() {
		return this.respuestaFtp;
	}


	/**
	 * @param respuestaFtp the respuestaFtp to set
	 */
	public void setRespuestaFtp(final String respuestaFtp) {
		this.respuestaFtp = respuestaFtp;
	}

}