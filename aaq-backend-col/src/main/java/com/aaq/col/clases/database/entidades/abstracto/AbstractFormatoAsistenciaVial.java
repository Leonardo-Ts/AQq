package com.aaq.col.clases.database.entidades.abstracto;

 import java.sql.Timestamp;
import java.util.Date;

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


import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractFormatoAsistenciaVial extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opAsistenciaSEQ", sequenceName = "formato_asistencia_vial_seq", allocationSize = 1)
	 @Id
	 @Column(name = "AV_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAsistenciaSEQ")
	 private Integer id;
	
	@Column(name="AV_ASEGURADO", length=5)
	private String avAsegurado;

	@Column(name="AV_CLAVE_AJUSTADOR", length=20)
	private String avClaveAjustador;

	@Column(name="AV_COMENTARIOS", length=300)
	private String avComentarios;

	@Column(name="AV_EMAIL", length=100)
	private String avEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="AV_FECHA")
	private Date avFecha;

	@Column(name="AV_NOM_ASEGURADO", length=100)
	private String avNomAsegurado;

	@Column(name="AV_NUM_INCISO", length=20)
	private String avNumInciso;

	@Column(name="AV_NUM_POLIZA", length=20)
	private String avNumPoliza;

	@Column(name="AV_NUM_REPORTE", length=20)
	private String avNumReporte;

	@Column(name="AV_PREGUNTA_1")
	private Integer avPregunta1;

	@Column(name="AV_PREGUNTA_2")
	private Integer avPregunta2;

	@Column(name="AV_PREGUNTA_3")
	private Integer avPregunta3;

	@Column(name="AV_PREGUNTA_4")
	private Integer avPregunta4;

	@Column(name="AV_PREGUNTA_5", length=300)
	private String avPregunta5;

	@Column(name="AV_PREGUNTA_6")
	private Integer avPregunta6;

	@Column(name="AV_PREGUNTA_7")
	private Integer avPregunta7;

	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;




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
    
    
    @Column(name = "FIRMA_AJUSTADOR")
   	private String firmaAjustador;
       
    @Column(name = "FIRMA_ASEGURADO")
    private String firmaAsegurado;
    
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

	 
	// Constructors

	/** default constructor */
	public AbstractFormatoAsistenciaVial() {
		super();
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
	 * @return the avAsegurado
	 */
	public String getAvAsegurado() {
		return avAsegurado;
	}








	/**
	 * @param avAsegurado the avAsegurado to set
	 */
	public void setAvAsegurado(String avAsegurado) {
		this.avAsegurado = avAsegurado;
	}








	/**
	 * @return the avClaveAjustador
	 */
	public String getAvClaveAjustador() {
		return avClaveAjustador;
	}




	/**
	 * @param avClaveAjustador the avClaveAjustador to set
	 */
	public void setAvClaveAjustador(String avClaveAjustador) {
		this.avClaveAjustador = avClaveAjustador;
	}




	/**
	 * @return the avComentarios
	 */
	public String getAvComentarios() {
		return avComentarios;
	}




	/**
	 * @param avComentarios the avComentarios to set
	 */
	public void setAvComentarios(String avComentarios) {
		this.avComentarios = avComentarios;
	}




	/**
	 * @return the avEmail
	 */
	public String getAvEmail() {
		return avEmail;
	}




	/**
	 * @param avEmail the avEmail to set
	 */
	public void setAvEmail(String avEmail) {
		this.avEmail = avEmail;
	}




	/**
	 * @return the avFecha
	 */
	public Date getAvFecha() {
		return avFecha;
	}




	/**
	 * @param avFecha the avFecha to set
	 */
	public void setAvFecha(Date avFecha) {
		this.avFecha = avFecha;
	}




	/**
	 * @return the avNomAsegurado
	 */
	public String getAvNomAsegurado() {
		return avNomAsegurado;
	}




	/**
	 * @param avNomAsegurado the avNomAsegurado to set
	 */
	public void setAvNomAsegurado(String avNomAsegurado) {
		this.avNomAsegurado = avNomAsegurado;
	}




	/**
	 * @return the avNumInciso
	 */
	public String getAvNumInciso() {
		return avNumInciso;
	}




	/**
	 * @param avNumInciso the avNumInciso to set
	 */
	public void setAvNumInciso(String avNumInciso) {
		this.avNumInciso = avNumInciso;
	}




	/**
	 * @return the avNumPoliza
	 */
	public String getAvNumPoliza() {
		return avNumPoliza;
	}




	/**
	 * @param avNumPoliza the avNumPoliza to set
	 */
	public void setAvNumPoliza(String avNumPoliza) {
		this.avNumPoliza = avNumPoliza;
	}




	/**
	 * @return the avNumReporte
	 */
	public String getAvNumReporte() {
		return avNumReporte;
	}




	/**
	 * @param avNumReporte the avNumReporte to set
	 */
	public void setAvNumReporte(String avNumReporte) {
		this.avNumReporte = avNumReporte;
	}




	/**
	 * @return the avPregunta1
	 */
	public Integer getAvPregunta1() {
		return avPregunta1;
	}




	/**
	 * @param avPregunta1 the avPregunta1 to set
	 */
	public void setAvPregunta1(Integer avPregunta1) {
		this.avPregunta1 = avPregunta1;
	}




	/**
	 * @return the avPregunta2
	 */
	public Integer getAvPregunta2() {
		return avPregunta2;
	}




	/**
	 * @param avPregunta2 the avPregunta2 to set
	 */
	public void setAvPregunta2(Integer avPregunta2) {
		this.avPregunta2 = avPregunta2;
	}




	/**
	 * @return the avPregunta3
	 */
	public Integer getAvPregunta3() {
		return avPregunta3;
	}




	/**
	 * @param avPregunta3 the avPregunta3 to set
	 */
	public void setAvPregunta3(Integer avPregunta3) {
		this.avPregunta3 = avPregunta3;
	}




	/**
	 * @return the avPregunta4
	 */
	public Integer getAvPregunta4() {
		return avPregunta4;
	}




	/**
	 * @param avPregunta4 the avPregunta4 to set
	 */
	public void setAvPregunta4(Integer avPregunta4) {
		this.avPregunta4 = avPregunta4;
	}




	/**
	 * @return the avPregunta5
	 */
	public String getAvPregunta5() {
		return avPregunta5;
	}




	/**
	 * @param avPregunta5 the avPregunta5 to set
	 */
	public void setAvPregunta5(String avPregunta5) {
		this.avPregunta5 = avPregunta5;
	}




	/**
	 * @return the avPregunta6
	 */
	public Integer getAvPregunta6() {
		return avPregunta6;
	}




	/**
	 * @param avPregunta6 the avPregunta6 to set
	 */
	public void setAvPregunta6(Integer avPregunta6) {
		this.avPregunta6 = avPregunta6;
	}




	/**
	 * @return the avPregunta7
	 */
	public Integer getAvPregunta7() {
		return avPregunta7;
	}




	/**
	 * @param avPregunta7 the avPregunta7 to set
	 */
	public void setAvPregunta7(Integer avPregunta7) {
		this.avPregunta7 = avPregunta7;
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








	
	





}