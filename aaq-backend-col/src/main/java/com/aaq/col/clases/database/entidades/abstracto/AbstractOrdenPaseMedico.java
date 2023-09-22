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
 public abstract class AbstractOrdenPaseMedico extends JMEntidad {

	private static final long serialVersionUID = -3678126129425799084L;

	@SequenceGenerator(name = "opMedico1SEQ", sequenceName = "orden_pase_medico_seq", allocationSize = 1)
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opMedico1SEQ")
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
	 
	 @Column(name = "numero_ocupantes", length = 255, nullable = true, unique = false)
	 private String numeroOcupantes;
	 
	 @Column(name = "numero_lesionados", length = 255, nullable = true, unique = false)
	 private String numeroLesionados;
	 
	 @Column(name = "cobertura", length = 255, nullable = true, unique = false)
	 private String cobertura;
	 
	 @Column(name = "causas_lesion", length = 255, nullable = true, unique = false)
	 private String causasLesion;
	 
	 @Column(name = "identificacion", length = 255, nullable = true, unique = false)
	 private String identificacion;
	 
	 @Column(name = "nombre_lesionado", length = 255, nullable = true, unique = false)
	 private String nombreLesionado;
	 
	 @Column(name = "telefono_lesionado", length = 255, nullable = true, unique = false)
	 private String telefonoLesionado;
	 
	 @Column(name = "sexo_lesionado", length = 255, nullable = true, unique = false)
	 private String sexoLesionado;
	
	 @Column(name = "edad_lesionado", length = 255, nullable = true, unique = false)
	 private String edadLesionado;
	 
	 @Column(name = "tipo_atencion_medica", length = 255, nullable = true, unique = false)
	 private String tipoAtencionMedica;
	 
	 @Column(name = "lesiones_aparentes", length = 255, nullable = true, unique = false)
	 private String lesionesAparentes;
	 
	 @Column(name = "tipo_proveedor", length = 255, nullable = true, unique = false)
	 private String tipoProveedor;
	 
	 @Column(name = "clave_proveedor", length = 255, nullable = true, unique = false)
	 private String claveProveedor;
	 
	 @Column(name = "hospital", length = 255, nullable = true, unique = false)
	 private String hospital;
	 
	 @Column(name = "telefono_hospital", length = 255, nullable = true, unique = false)
	 private String telefonoHospital;
	 
	 @Column(name = "domicilio_hospital", length = 255, nullable = true, unique = false)
	 private String domicilioHospital;
	 
	 @Column(name = "enviado_ftp", nullable = true, unique = false)
	 @Convert("booleanConverter")
	 private Boolean enviadoFtp;
	 
	 @Column(name = "ftp_respuesta", length = 255, nullable = true, unique = false)
	 private String respuestaFtp;
	 
	 @Column(name = "reporte_numero_poliza", length = 255, nullable = true, unique = false)
	 private String reporteNumeroPoliza;
	 
	 @ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	 @JoinColumn(name = "id_ajustador", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	 private Terminal terminal;
	
	// Constructors

	/** default constructor */
	public AbstractOrdenPaseMedico() {
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
	 * @return the claveProveedor
	 */
	public String getClaveProveedor() {
		return this.claveProveedor;
	}

	/**
	 * @param claveProveedor the claveProveedor to set
	 */
	public void setClaveProveedor(final String claveProveedor) {
		this.claveProveedor = claveProveedor;
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
	 * @return the tipoAtencion
	 */
	public String getTipoAtencion() {
		return this.tipoAtencion;
	}

	/**
	 * @param tipoAtencion the tipoAtencion to set
	 */
	public void setTipoAtencion(final String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}

	/**
	 * @return the numeroOcupantes
	 */
	public String getNumeroOcupantes() {
		return this.numeroOcupantes;
	}

	/**
	 * @param numeroOcupantes the numeroOcupantes to set
	 */
	public void setNumeroOcupantes(final String numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}

	/**
	 * @return the numeroLesionados
	 */
	public String getNumeroLesionados() {
		return this.numeroLesionados;
	}

	/**
	 * @param numeroLesionados the numeroLesionados to set
	 */
	public void setNumeroLesionados(final String numeroLesionados) {
		this.numeroLesionados = numeroLesionados;
	}

	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return this.cobertura;
	}

	/**
	 * @param cobertura the cobertura to set
	 */
	public void setCobertura(final String cobertura) {
		this.cobertura = cobertura;
	}

	/**
	 * @return the causasLesion
	 */
	public String getCausasLesion() {
		return this.causasLesion;
	}

	/**
	 * @param causasLesion the causasLesion to set
	 */
	public void setCausasLesion(final String causasLesion) {
		this.causasLesion = causasLesion;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return this.identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
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
	 * @return the tipoAtencionMedica
	 */
	public String getTipoAtencionMedica() {
		return this.tipoAtencionMedica;
	}

	/**
	 * @param tipoAtencionMedica the tipoAtencionMedica to set
	 */
	public void setTipoAtencionMedica(final String tipoAtencionMedica) {
		this.tipoAtencionMedica = tipoAtencionMedica;
	}


	/**
	 * @return the tipoProveedor
	 */
	public String getTipoProveedor() {
		return tipoProveedor;
	}

	/**
	 * @param tipoProveedor the tipoProveedor to set
	 */
	public void setTipoProveedor(final String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
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
	 * @return the domicilioHospital
	 */
	public String getDomicilioHospital() {
		return this.domicilioHospital;
	}

	/**
	 * @param domicilioHospital the domicilioHospital to set
	 */
	public void setDomicilioHospital(final String domicilioHospital) {
		this.domicilioHospital = domicilioHospital;
	}

	/**
	 * @return the lesionesAparentes
	 */
	public String getLesionesAparentes() {
		return this.lesionesAparentes;
	}

	/**
	 * @param lesionesAparentes the lesionesAparentes to set
	 */
	public void setLesionesAparentes(final String lesionesAparentes) {
		this.lesionesAparentes = lesionesAparentes;
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