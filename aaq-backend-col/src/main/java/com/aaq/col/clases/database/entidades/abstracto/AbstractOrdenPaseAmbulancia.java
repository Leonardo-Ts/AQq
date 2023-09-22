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
 public abstract class AbstractOrdenPaseAmbulancia extends JMEntidad {

	 private static final long serialVersionUID = 2051180652847240842L;

	 @SequenceGenerator(name = "opAmbulanciaSEQ", sequenceName = "orden_pase_ambulancia_seq", allocationSize = 1)
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAmbulanciaSEQ")
	 private Integer id;
	 
	 @Column(name = "usuario", length = 255, nullable = true, unique = false)
	 private String usuario;
	 
	 @Column(name = "fecha_hora", nullable = false, unique = true)
	 @Temporal(TemporalType.TIMESTAMP)
	 private java.util.Date fechaHora;
	 
	 @Column(name = "numero_reporte", length = 255, nullable = true, unique = false)
	 private String numeroReporte;
	 
	 @Column(name = "tipo_atencion", length = 255, nullable = true, unique = false)
	 private String tipoAtencion;
	 
	 @Column(name = "clave_hospital", length = 255, nullable = true, unique = false)
	 private String claveHospital;
	 
	 @Column(name = "clave_ambulancia", length = 255, nullable = true, unique = false)
	 private String claveAmbulancia;
	 
	 @Column(name = "hospital", length = 255, nullable = true, unique = false)
	 private String hospital;
	 
	 @Column(name = "direccion_traslado", length = 255, nullable = true, unique = false)
	 private String direccionTraslado;
	 
	 @Column(name = "telefono_hospital", length = 255, nullable = true, unique = false)
	 private String telefonoHospital;
	 
	 @Column(name = "nombre_lesionado", length = 255, nullable = true, unique = false)
	 private String nombreLesionado;
	 
	 @Column(name = "ubicacion_lesionado", length = 255, nullable = true, unique = false)
	 private String ubicacionLesionado;
	 
	 @Column(name = "edad_lesionado", length = 255, nullable = true, unique = false)
	 private String edadLesionado;
	 
	 @Column(name = "sexo_lesionado", length = 255, nullable = true, unique = false)
	 private String sexoLesionado;
	 
	 @Column(name = "telefono_lesionado", length = 255, nullable = true, unique = false)
	 private String telefonoLesionado;
	 
	 @Column(name = "diagnostico", length = 255, nullable = true, unique = false)
	 private String diagnostico;
	 
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
	public AbstractOrdenPaseAmbulancia() {
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
	 * @return the tipoAtencion
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}


	/**
	 * @param tipoAtencion the tipoAtencion to set
	 */
	public void setTipoAtencion(final String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}


	/**
	 * @return the claveHospital
	 */
	public String getClaveHospital() {
		return this.claveHospital;
	}


	/**
	 * @param claveHospital the claveHospital to set
	 */
	public void setClaveHospital(final String claveHospital) {
		this.claveHospital = claveHospital;
	}


	/**
	 * @return the claveAmbulancia
	 */
	public String getClaveAmbulancia() {
		return this.claveAmbulancia;
	}


	/**
	 * @param claveAmbulancia the claveAmbulancia to set
	 */
	public void setClaveAmbulancia(final String claveAmbulancia) {
		this.claveAmbulancia = claveAmbulancia;
	}


	/**
	 * @return the hospital
	 */
	public String getHospital() {
		return this.hospital;
	}


	/**
	 * @param hospital the hospital to set
	 */
	public void setHospital(final String hospital) {
		this.hospital = hospital;
	}


	/**
	 * @return the direccionTraslado
	 */
	public String getDireccionTraslado() {
		return this.direccionTraslado;
	}


	/**
	 * @param direccionTraslado the direccionTraslado to set
	 */
	public void setDireccionTraslado(final String direccionTraslado) {
		this.direccionTraslado = direccionTraslado;
	}


	/**
	 * @return the telefonoHospital
	 */
	public String getTelefonoHospital() {
		return this.telefonoHospital;
	}


	/**
	 * @param telefonoHospital the telefonoHospital to set
	 */
	public void setTelefonoHospital(final String telefonoHospital) {
		this.telefonoHospital = telefonoHospital;
	}


	/**
	 * @return the nombreLesionado
	 */
	public String getNombreLesionado() {
		return this.nombreLesionado;
	}


	/**
	 * @param nombreLesionado the nombreLesionado to set
	 */
	public void setNombreLesionado(final String nombreLesionado) {
		this.nombreLesionado = nombreLesionado;
	}


	/**
	 * @return the ubicacionLesionado
	 */
	public String getUbicacionLesionado() {
		return this.ubicacionLesionado;
	}


	/**
	 * @param ubicacionLesionado the ubicacionLesionado to set
	 */
	public void setUbicacionLesionado(final String ubicacionLesionado) {
		this.ubicacionLesionado = ubicacionLesionado;
	}


	/**
	 * @return the edadLesionado
	 */
	public String getEdadLesionado() {
		return this.edadLesionado;
	}


	/**
	 * @param edadLesionado the edadLesionado to set
	 */
	public void setEdadLesionado(final String edadLesionado) {
		this.edadLesionado = edadLesionado;
	}


	/**
	 * @return the sexoLesionado
	 */
	public String getSexoLesionado() {
		return this.sexoLesionado;
	}


	/**
	 * @param sexoLesionado the sexoLesionado to set
	 */
	public void setSexoLesionado(final String sexoLesionado) {
		this.sexoLesionado = sexoLesionado;
	}


	/**
	 * @return the telefonoLesionado
	 */
	public String getTelefonoLesionado() {
		return this.telefonoLesionado;
	}


	/**
	 * @param telefonoLesionado the telefonoLesionado to set
	 */
	public void setTelefonoLesionado(final String telefonoLesionado) {
		this.telefonoLesionado = telefonoLesionado;
	}


	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return this.diagnostico;
	}


	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(final String diagnostico) {
		this.diagnostico = diagnostico;
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