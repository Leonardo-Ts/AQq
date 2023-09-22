 package com.aaq.col.clases.database.entidades.abstracto;

 import java.sql.Timestamp;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractFormatoReclamacionPendiente extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "frPendienteSEQ", sequenceName = "formato_reclamacion_pendiente_seq", allocationSize = 1) /// SE PUEDE COMENTAR CREO
	
	@Id
	@Column(name="RP_ID", unique=true, nullable=false, precision=38)
	private Integer id;

	@Column(name="EMAIL_DEFAULT", length=100)
	private String emailDefault;

	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;



	@Column(name="RP_ASEGURADO",length=5)
	private String rpAsegurado;

	@Column(name="RP_CLAVE_AJUSTADOR", length=20)
	private String rpClaveAjustador;

	@Column(name="RP_COPIA_ACTA_MP", precision=38)
	private Integer rpCopiaActaMp;

	@Column(name="RP_DF_ENDOSO")
	private Integer rpDfEndoso;

	@Column(name="RP_FECHA")
	private Timestamp rpFecha;

	@Column(name="RP_LICENCIA", precision=38)
	private Integer rpLicencia;

	@Column(name="RP_NOM_AJUSTADOR", length=100)
	private String rpNomAjustador;

	@Column(name="RP_NOM_CONDUCTOR", length=100)
	private String rpNomConductor;

	@Column(name="RP_NOMBRE_CONDUCTOR", length=100)
	private String rpNombreConductor;

	@Column(name="RP_NUM_INCISO", length=20)
	private String rpNumInciso;

	@Column(name="RP_NUM_POLIZA", length=20)
	private String rpNumPoliza;

	@Column(name="RP_NUM_RECLAMACION", length=20)
	private String rpNumReclamacion;

	@Column(name="RP_NUM_REPORTE", length=20)
	private String rpNumReporte;

	@Column(name="RP_OBS_ENDOSO_ACLARA", length=20)
	private String rpObsEndosoAclara;

	@Column(name="RP_OBSERVACIONES", length=330)
	private String rpObservaciones;

	@Column(name="RP_OTROS", precision=38)
	private Integer rpOtros;

	@Column(name="RP_POLIZA_VIGENTE")
	private Integer rpPolizaVigente;

	@Column(name="RP_RECIBO_PAGO", precision=38)
	private Integer rpReciboPago;



	@Column(name="ENVIADO_EMAIL")
	private Integer enviadoEmail;

    @Column(name="MENSAJES_EMAIL", length=255)
	private String mensajeEmail;
    
    
    
    @Column(name="PROCESO")
	private Integer proceso;
    
    @Column(name="HORA_ENVIO_EMAIL")
	private Timestamp horaEnvioEmail;
    
    @Column(name="HORA_ENVIO_Sftp")
   	private Timestamp horaEnvioSftp;
    
    @Column(name="NODO_ENVIO", length=255)
   	private String nodoEnvio;
    
    
    @Column(name="CHECK_1")
    private Integer check1;
    
    @Column(name="CHECK_2")
    private Integer check2;
    
    @Column(name="CHECK_3")
    private Integer check3;
    
    @Column(name="CHECK_4")
    private Integer check4;
    
    
    @Column(name = "FIRMA_ASEGURADO")
    private String firmaAsegurado;
    
    @Column(name = "FIRMA_AJUSTADOR")
    private String firmaAjustador;
    
    @Column(name="RP_DATOS_OFICINA")
	private String rpDatosOficina;

    @Column(name="NUM_CONSECUTIVO")
	private Integer numConsecutivo;

    @Column(name="CORREO_OCULTO")
	private String correoOculto;
    
    @Column(name="FUENTE_WS")
	private String fuenteWs;
    
    @Column(name="CHECK_5")
    private Integer check5;
    
    @Column(name="CHECK_6")
    private Integer check6;
    
    

	public Integer getCheck5() {
		return check5;
	}
	public void setCheck5(Integer check5) {
		this.check5 = check5;
	}
	public Integer getCheck6() {
		return check6;
	}
	public void setCheck6(Integer check6) {
		this.check6 = check6;
	}
    

	public String getFuenteWs() {
		return fuenteWs;
	}
	public void setFuenteWs(String fuenteWs) {
		this.fuenteWs = fuenteWs;
	}

	public Integer getNumConsecutivo() {
		return numConsecutivo;
	}
	public void setNumConsecutivo(Integer numConsecutivo) {
		this.numConsecutivo = numConsecutivo;
	}
	
	public String getCorreoOculto() {
		return correoOculto;
	}
	public void setCorreoOculto(String correoOculto) {
		this.correoOculto = correoOculto;
	}
	
	
	
	/**
	 * @return the enviadoEmail
	 */
	public Integer getEnviadoEmail() {
		return enviadoEmail;
	}

	/**
	 * @param enviadoEmail the enviadoEmail to set
	 */
	public void setEnviadoEmail(Integer enviadoEmail) {
		this.enviadoEmail = enviadoEmail;
	}

	/**
	 * @return the proceso
	 */
	public Integer getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the horaEnvioEmail
	 */
	public Timestamp getHoraEnvioEmail() {
		return horaEnvioEmail;
	}

	/**
	 * @param horaEnvioEmail the horaEnvioEmail to set
	 */
	public void setHoraEnvioEmail(Timestamp horaEnvioEmail) {
		this.horaEnvioEmail = horaEnvioEmail;
	}

	/**
	 * @return the horaEnvioSftp
	 */
	public Timestamp getHoraEnvioSftp() {
		return horaEnvioSftp;
	}

	/**
	 * @param horaEnvioSftp the horaEnvioSftp to set
	 */
	public void setHoraEnvioSftp(Timestamp horaEnvioSftp) {
		this.horaEnvioSftp = horaEnvioSftp;
	}

	/**
	 * @return the nodoEnvio
	 */
	public String getNodoEnvio() {
		return nodoEnvio;
	}

	/**
	 * @param nodoEnvio the nodoEnvio to set
	 */
	public void setNodoEnvio(String nodoEnvio) {
		this.nodoEnvio = nodoEnvio;
	}

	/**
	 * @return the mensajeEmail
	 */
	public String getMensajeEmail() {
		return mensajeEmail;
	}

	/**
	 * @param mensajeEmail the mensajeEmail to set
	 */
	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the emailDefault
	 */
	public String getEmailDefault() {
		return emailDefault;
	}

	/**
	 * @param emailDefault the emailDefault to set
	 */
	public void setEmailDefault(String emailDefault) {
		this.emailDefault = emailDefault;
	}

	/**
	 * @return the enviadoFtp
	 */
	public Integer getEnviadoFtp() {
		return enviadoFtp;
	}

	/**
	 * @param enviadoFtp the enviadoFtp to set
	 */
	public void setEnviadoFtp(Integer enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}

	/**
	 * @return the ftpRespuesta
	 */
	public String getFtpRespuesta() {
		return ftpRespuesta;
	}

	/**
	 * @param ftpRespuesta the ftpRespuesta to set
	 */
	public void setFtpRespuesta(String ftpRespuesta) {
		this.ftpRespuesta = ftpRespuesta;
	}

	

	/**
	 * @return the rpAsegurado
	 */
	public String getRpAsegurado() {
		return rpAsegurado;
	}

	/**
	 * @param rpAsegurado the rpAsegurado to set
	 */
	public void setRpAsegurado(String rpAsegurado) {
		this.rpAsegurado = rpAsegurado;
	}

	/**
	 * @return the rpClaveAjustador
	 */
	public String getRpClaveAjustador() {
		return rpClaveAjustador;
	}

	/**
	 * @param rpClaveAjustador the rpClaveAjustador to set
	 */
	public void setRpClaveAjustador(String rpClaveAjustador) {
		this.rpClaveAjustador = rpClaveAjustador;
	}

	/**
	 * @return the rpCopiaActaMp
	 */
	public Integer getRpCopiaActaMp() {
		return rpCopiaActaMp;
	}

	/**
	 * @param rpCopiaActaMp the rpCopiaActaMp to set
	 */
	public void setRpCopiaActaMp(Integer rpCopiaActaMp) {
		this.rpCopiaActaMp = rpCopiaActaMp;
	}

	/**
	 * @return the rpDfEndoso
	 */
	public Integer getRpDfEndoso() {
		return rpDfEndoso;
	}

	/**
	 * @param rpDfEndoso the rpDfEndoso to set
	 */
	public void setRpDfEndoso(Integer rpDfEndoso) {
		this.rpDfEndoso = rpDfEndoso;
	}

	/**
	 * @return the rpFecha
	 */
	public Timestamp getRpFecha() {
		return rpFecha;
	}

	/**
	 * @param rpFecha the rpFecha to set
	 */
	public void setRpFecha(Timestamp rpFecha) {
		this.rpFecha = rpFecha;
	}

	/**
	 * @return the rpLicencia
	 */
	public Integer getRpLicencia() {
		return rpLicencia;
	}

	/**
	 * @param rpLicencia the rpLicencia to set
	 */
	public void setRpLicencia(Integer rpLicencia) {
		this.rpLicencia = rpLicencia;
	}

	/**
	 * @return the rpNomAjustador
	 */
	public String getRpNomAjustador() {
		return rpNomAjustador;
	}

	/**
	 * @param rpNomAjustador the rpNomAjustador to set
	 */
	public void setRpNomAjustador(String rpNomAjustador) {
		this.rpNomAjustador = rpNomAjustador;
	}

	/**
	 * @return the rpNomConductor
	 */
	public String getRpNomConductor() {
		return rpNomConductor;
	}

	/**
	 * @param rpNomConductor the rpNomConductor to set
	 */
	public void setRpNomConductor(String rpNomConductor) {
		this.rpNomConductor = rpNomConductor;
	}

	/**
	 * @return the rpNombreConductor
	 */
	public String getRpNombreConductor() {
		return rpNombreConductor;
	}

	/**
	 * @param rpNombreConductor the rpNombreConductor to set
	 */
	public void setRpNombreConductor(String rpNombreConductor) {
		this.rpNombreConductor = rpNombreConductor;
	}

	/**
	 * @return the rpNumInciso
	 */
	public String getRpNumInciso() {
		return rpNumInciso;
	}

	/**
	 * @param rpNumInciso the rpNumInciso to set
	 */
	public void setRpNumInciso(String rpNumInciso) {
		this.rpNumInciso = rpNumInciso;
	}

	/**
	 * @return the rpNumPoliza
	 */
	public String getRpNumPoliza() {
		return rpNumPoliza;
	}

	/**
	 * @param rpNumPoliza the rpNumPoliza to set
	 */
	public void setRpNumPoliza(String rpNumPoliza) {
		this.rpNumPoliza = rpNumPoliza;
	}

	/**
	 * @return the rpNumReclamacion
	 */
	public String getRpNumReclamacion() {
		return rpNumReclamacion;
	}

	/**
	 * @param rpNumReclamacion the rpNumReclamacion to set
	 */
	public void setRpNumReclamacion(String rpNumReclamacion) {
		this.rpNumReclamacion = rpNumReclamacion;
	}

	/**
	 * @return the rpNumReporte
	 */
	public String getRpNumReporte() {
		return rpNumReporte;
	}

	/**
	 * @param rpNumReporte the rpNumReporte to set
	 */
	public void setRpNumReporte(String rpNumReporte) {
		this.rpNumReporte = rpNumReporte;
	}

	/**
	 * @return the rpObsEndosoAclara
	 */
	public String getRpObsEndosoAclara() {
		return rpObsEndosoAclara;
	}

	/**
	 * @param rpObsEndosoAclara the rpObsEndosoAclara to set
	 */
	public void setRpObsEndosoAclara(String rpObsEndosoAclara) {
		this.rpObsEndosoAclara = rpObsEndosoAclara;
	}

	/**
	 * @return the rpObservaciones
	 */
	public String getRpObservaciones() {
		return rpObservaciones;
	}

	/**
	 * @param rpObservaciones the rpObservaciones to set
	 */
	public void setRpObservaciones(String rpObservaciones) {
		this.rpObservaciones = rpObservaciones;
	}

	/**
	 * @return the rpOtros
	 */
	public Integer getRpOtros() {
		return rpOtros;
	}

	/**
	 * @param rpOtros the rpOtros to set
	 */
	public void setRpOtros(Integer rpOtros) {
		this.rpOtros = rpOtros;
	}

	/**
	 * @return the rpPolizaVigente
	 */
	public Integer getRpPolizaVigente() {
		return rpPolizaVigente;
	}

	/**
	 * @param rpPolizaVigente the rpPolizaVigente to set
	 */
	public void setRpPolizaVigente(Integer rpPolizaVigente) {
		this.rpPolizaVigente = rpPolizaVigente;
	}

	/**
	 * @return the rpReciboPago
	 */
	public Integer getRpReciboPago() {
		return rpReciboPago;
	}

	/**
	 * @param rpReciboPago the rpReciboPago to set
	 */
	public void setRpReciboPago(Integer rpReciboPago) {
		this.rpReciboPago = rpReciboPago;
	}

	/**
	 * @return the check1
	 */
	public Integer getCheck1() {
		return check1;
	}

	/**
	 * @param check1 the check1 to set
	 */
	public void setCheck1(Integer check1) {
		this.check1 = check1;
	}

	/**
	 * @return the check2
	 */
	public Integer getCheck2() {
		return check2;
	}

	/**
	 * @param check2 the check2 to set
	 */
	public void setCheck2(Integer check2) {
		this.check2 = check2;
	}

	/**
	 * @return the check3
	 */
	public Integer getCheck3() {
		return check3;
	}

	/**
	 * @param check3 the check3 to set
	 */
	public void setCheck3(Integer check3) {
		this.check3 = check3;
	}

	/**
	 * @return the check4
	 */
	public Integer getCheck4() {
		return check4;
	}

	/**
	 * @param check4 the check4 to set
	 */
	public void setCheck4(Integer check4) {
		this.check4 = check4;
	}

	/**
	 * @return the firmaAsegurado
	 */
	public String getFirmaAsegurado() {
		return firmaAsegurado;
	}

	/**
	 * @param firmaAsegurado the firmaAsegurado to set
	 */
	public void setFirmaAsegurado(String firmaAsegurado) {
		this.firmaAsegurado = firmaAsegurado;
	}

	/**
	 * @return the firmaAjustador
	 */
	public String getFirmaAjustador() {
		return firmaAjustador;
	}

	/**
	 * @param firmaAjustador the firmaAjustador to set
	 */
	public void setFirmaAjustador(String firmaAjustador) {
		this.firmaAjustador = firmaAjustador;
	}

	public String getRpDatosOficina() {
		return rpDatosOficina;
	}

	public void setRpDatosOficina(String rpDatosOficina) {
		this.rpDatosOficina = rpDatosOficina;
	}

	
	
	
	

	
	
	
 }

