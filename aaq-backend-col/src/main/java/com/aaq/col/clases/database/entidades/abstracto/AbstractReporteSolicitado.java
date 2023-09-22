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

import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractReporteSolicitado entity provides the base persistence definition of
 * the ReporteSolicitado entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReporteSolicitado extends JMEntidad {

	private static final long serialVersionUID = -1239117646359873407L;

	@SequenceGenerator(name = "reporte_solicitadoSEQ", sequenceName = "reporte_solicitado_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_solicitadoSEQ")
	private Integer id;

	@Column(name = "fecha_insertado", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaInsertado;

	@Column(name = "fecha_enviado_sise", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEnviadoSise;

	@Column(name = "tipo_de_servicio", length = 255, nullable = true, unique = false)
	private String tipoDeServicio;

	@Column(name = "atencion_a", length = 255, nullable = true, unique = false)
	private String atencionA;

	@Column(name = "clave_proveedor", length = 255, nullable = true, unique = false)
	private String claveProveedor;

	@Column(name = "clave_ambulancia", length = 255, nullable = true, unique = false)
	private String claveAmbulancia;

	@Column(name = "folio_vale_talonario", length = 255, nullable = true, unique = false)
	private String folioValeTalonario;

	@Column(name = "lesionado_nombre", length = 255, nullable = true, unique = false)
	private String lesionadoNombre;

	@Column(name = "lesionado_sexo", length = 255, nullable = true, unique = false)
	private String lesionadoSexo;

	@Column(name = "lesionado_edad", length = 255, nullable = true, unique = false)
	private String lesionadoEdad;

	@Column(name = "numero_reporte", length = 255, nullable = true, unique = true)
	private String numeroReporte;

	@Column(name = "sise_respuesta_clave", length = 255, nullable = true, unique = false)
	private String siseRespuestaClave;

	@Column(name = "sise_respuesta_folio", length = 255, nullable = true, unique = false)
	private String siseRespuestaFolio;

	@Column(name = "fecha_estimada", length = 255, nullable = true, unique = false)
	private String fechaEstimada;

	@Column(name = "hora_estimada", length = 255, nullable = true, unique = false)
	private String horaEstimada;

	@Column(name = "fecha_real", length = 255, nullable = true, unique = false)
	private String fechaReal;

	@Column(name = "hora_real", length = 255, nullable = true, unique = false)
	private String horaReal;

	@Column(name = "comentario", nullable = true, unique = false)
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	// Constructors

	/** default constructor */
	public AbstractReporteSolicitado() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the fechaInsertado
	 */
	public java.util.Date getFechaInsertado() {
		return this.fechaInsertado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param fechaInsertado
	 *            the fechaInsertado to set
	 */
	public void setFechaInsertado(final java.util.Date fechaInsertado) {
		this.fechaInsertado = fechaInsertado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the fechaEnviadoSise
	 */
	public java.util.Date getFechaEnviadoSise() {
		return this.fechaEnviadoSise;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param fechaEnviadoSise
	 *            the fechaEnviadoSise to set
	 */
	public void setFechaEnviadoSise(final java.util.Date fechaEnviadoSise) {
		this.fechaEnviadoSise = fechaEnviadoSise;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the tipoDeServicio
	 */
	public String getTipoDeServicio() {
		return this.tipoDeServicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param tipoDeServicio
	 *            the tipoDeServicio to set
	 */
	public void setTipoDeServicio(final String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the atencionA
	 */
	public String getAtencionA() {
		return this.atencionA;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param atencionA
	 *            the atencionA to set
	 */
	public void setAtencionA(final String atencionA) {
		this.atencionA = atencionA;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the claveProveedor
	 */
	public String getClaveProveedor() {
		return this.claveProveedor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param claveProveedor
	 *            the claveProveedor to set
	 */
	public void setClaveProveedor(final String claveProveedor) {
		this.claveProveedor = claveProveedor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the claveAmbulancia
	 */
	public String getClaveAmbulancia() {
		return this.claveAmbulancia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param claveAmbulancia
	 *            the claveAmbulancia to set
	 */
	public void setClaveAmbulancia(final String claveAmbulancia) {
		this.claveAmbulancia = claveAmbulancia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the folioValeTalonario
	 */
	public String getFolioValeTalonario() {
		return this.folioValeTalonario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param folioValeTalonario
	 *            the folioValeTalonario to set
	 */
	public void setFolioValeTalonario(final String folioValeTalonario) {
		this.folioValeTalonario = folioValeTalonario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the lesionadoNombre
	 */
	public String getLesionadoNombre() {
		return this.lesionadoNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param lesionadoNombre
	 *            the lesionadoNombre to set
	 */
	public void setLesionadoNombre(final String lesionadoNombre) {
		this.lesionadoNombre = lesionadoNombre;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the lesionadoSexo
	 */
	public String getLesionadoSexo() {
		return this.lesionadoSexo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param lesionadoSexo
	 *            the lesionadoSexo to set
	 */
	public void setLesionadoSexo(final String lesionadoSexo) {
		this.lesionadoSexo = lesionadoSexo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the lesionadoEdad
	 */
	public String getLesionadoEdad() {
		return this.lesionadoEdad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param lesionadoEdad
	 *            the lesionadoEdad to set
	 */
	public void setLesionadoEdad(final String lesionadoEdad) {
		this.lesionadoEdad = lesionadoEdad;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param numeroReporte
	 *            the numeroReporte to set
	 */
	public void setNumeroReporte(final String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the siseRespuestaClave
	 */
	public String getSiseRespuestaClave() {
		return this.siseRespuestaClave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param siseRespuestaClave
	 *            the siseRespuestaClave to set
	 */
	public void setSiseRespuestaClave(final String siseRespuestaClave) {
		this.siseRespuestaClave = siseRespuestaClave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the siseRespuestaFolio
	 */
	public String getSiseRespuestaFolio() {
		return this.siseRespuestaFolio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param siseRespuestaFolio
	 *            the siseRespuestaFolio to set
	 */
	public void setSiseRespuestaFolio(final String siseRespuestaFolio) {
		this.siseRespuestaFolio = siseRespuestaFolio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the fechaEstimada
	 */
	public String getFechaEstimada() {
		return this.fechaEstimada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param fechaEstimada
	 *            the fechaEstimada to set
	 */
	public void setFechaEstimada(final String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the horaEstimada
	 */
	public String getHoraEstimada() {
		return this.horaEstimada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param horaEstimada
	 *            the horaEstimada to set
	 */
	public void setHoraEstimada(final String horaEstimada) {
		this.horaEstimada = horaEstimada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the fechaReal
	 */
	public String getFechaReal() {
		return this.fechaReal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param fechaReal
	 *            the fechaReal to set
	 */
	public void setFechaReal(final String fechaReal) {
		this.fechaReal = fechaReal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the horaReal
	 */
	public String getHoraReal() {
		return this.horaReal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param horaReal
	 *            the horaReal to set
	 */
	public void setHoraReal(final String horaReal) {
		this.horaReal = horaReal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the comentario
	 */
	public String getComentario() {
		return this.comentario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(final String comentario) {
		this.comentario = comentario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:14:07 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

}