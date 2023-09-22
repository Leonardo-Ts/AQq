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

import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractOrdenPaseReclamacion extends JMEntidad {

	private static final long serialVersionUID = -6681838172292569030L;

	@SequenceGenerator(name = "opReclamacionSEQ", sequenceName = "orden_pase_reclamacion_seq", allocationSize = 1)
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opReclamacionSEQ")
	 private Integer id;
	
	 @Column(name = "usuario", length = 255, nullable = true, unique = false)
	 private String usuario;
	 
	 @Column(name = "fecha_hora", nullable = false, unique = true)
	 @Temporal(TemporalType.TIMESTAMP)
	 private java.util.Date fechaHora;
	 
	 @Column(name = "numero_reporte", length = 255, nullable = true, unique = false)
	 private String numeroReporte;
	 
	 @Column(name = "documentos_faltantes", length = 255, nullable = true, unique = false)
	 private String documentosFaltantes;
	 
	 @Column(name = "observaciones", length = 255, nullable = true, unique = false)
	 private String observaciones;
	
	 @Column(name = "enviado_ftp", nullable = true, unique = false)
	 @Convert("booleanConverter")
	 private Boolean enviadoFtp;
	 
	 @Column(name = "ftp_respuesta", length = 255, nullable = true, unique = false)
	 private String respuestaFtp;
	 
	 @Column(name = "reporte_numero_poliza", length = 50, nullable = true, unique = false)
	 private String reporteNumeroPoliza;
	 
	 @ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	 @JoinColumn(name = "id_ajustador", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	 private Terminal terminal;
	 
	// Constructors

	/** default constructor */
	public AbstractOrdenPaseReclamacion() {
		super();
	}

	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}

	/**
	 * @param numeroReporte the numeroReporte to set
	 */
	public void setNumeroReporte(final String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}


	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return the fechaHora
	 */
	public java.util.Date getFechaHora() {
		return this.fechaHora;
	}


	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(final java.util.Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	/**
	 * @return the documentosFaltantes
	 */
	public String getDocumentosFaltantes() {
		return this.documentosFaltantes;
	}


	/**
	 * @param documentosFaltantes the documentosFaltantes to set
	 */
	public void setDocumentosFaltantes(final String documentosFaltantes) {
		this.documentosFaltantes = documentosFaltantes;
	}


	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return this.observaciones;
	}


	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
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
	
	/**
	 * @return the reporteNumeroPoliza
	 */
	public String getReporteNumeroPoliza() {
		return reporteNumeroPoliza;
	}


	/**
	 * @param reporteNumeroPoliza the reporteNumeroPoliza to set
	 */
	public void setReporteNumeroPoliza(String reporteNumeroPoliza) {
		this.reporteNumeroPoliza = reporteNumeroPoliza;
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
	
}