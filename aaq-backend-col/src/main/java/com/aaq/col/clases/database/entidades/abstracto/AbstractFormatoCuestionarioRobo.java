 package com.aaq.col.clases.database.entidades.abstracto;

 import java.sql.Timestamp;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;


import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractFormatoCuestionarioRobo extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opCuestionarioSEQ", sequenceName = "formato_cuestionario_robo_seq", allocationSize = 1)
	 @Id
	 @Column(name = "CR_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opCuestionarioSEQ")
	 private Integer id;
	
	@Column(name="CR_ASEGURADO", length=5)
	private String crAsegurado;

	@Column(name="CR_BOOL_11")
	private Integer crBool11;

	@Column(name="CR_BOOL_12")
	private Integer crBool12;

	@Column(name="CR_BOOL_13")
	private Integer crBool13;

	@Column(name="CR_BOOL_14")
	private Integer crBool14;

	@Column(name="CR_BOOL_15")
	private Integer crBool15;

	@Column(name="CR_BOOL_19")
	private Integer crBool19;

	@Column(name="CR_BOOL_2")
	private Integer crBool2;

	@Column(name="CR_BOOL_20")
	private Integer crBool20;

	@Column(name="CR_BOOL_26")
	private Integer crBool26;

	@Column(name="CR_BOOL_27")
	private Integer crBool27;

	@Column(name="CR_BOOL_28")
	private Integer crBool28;

	@Column(name="CR_BOOL_29")
	private Integer crBool29;

	@Column(name="CR_BOOL_3")
	private Integer crBool3;

	@Column(name="CR_BOOL_30")
	private Integer crBool30;

	@Column(name="CR_BOOL_31")
	private Integer crBool31;

	@Column(name="CR_BOOL_5")
	private Integer crBool5;

	@Column(name="CR_BOOL_8")
	private Integer crBool8;

	@Column(name="CR_BOOL_9")
	private Integer crBool9;

	@Column(name="CR_CLAVE_AJUSTADOR", length=20)
	private String crClaveAjustador;

	@Column(name="CR_DIR_ASEGURADO", length=150)
	private String crDirAsegurado;

	@Column(name="CR_EMAIL_ASEGURADO", length=50)
	private String crEmailAsegurado;

	@Column(name="CR_ESTACIONADO")
	private Integer crEstacionado;



	@Column(name="CR_HORA")
	private Timestamp crHora;

	@Column(name="CR_INC_ASEGURADO", length=100)
	private String crIncAsegurado;

	@Column(name="CR_NOM_ASEGURADO", length=100)
	private String crNomAsegurado;

	@Column(name="CR_NUM_ENDOSO", length=20)
	private String crNumEndoso;

	@Column(name="CR_NUM_INCISO", length=20)
	private String crNumInciso;

	@Column(name="CR_NUM_POLIZA", length=20)
	private String crNumPoliza;

	@Column(name="CR_NUM_REPORTE", length=20)
	private String crNumReporte;

	@Column(name="CR_NUM_SINIESTRO", length=20)
	private String crNumSiniestro;

	@Column(name="CR_O16_CARGA")
	private Integer crO16Carga;

	@Column(name="CR_O16_ENSEÑANZA")
	private Integer crO16Enseñanza;

	@Column(name="CR_O16_OTROS")
	private Integer crO16Otros;

	@Column(name="CR_O16_PARTICULAR")
	private Integer crO16Particular;
	
	@Column(name="CR_O16_EMERGENCIA")
	private Integer crO16Emergencia;

	@Column(name="CR_O16_PUBLICO")
	private Integer crO16Publico;

	@Column(name="CR_OCU_ASEGURADO", length=50)
	private String crOcuAsegurado;

	@Column(name="CR_OTROS", length=100)
	private String crOtros;

	@Column(name="CR_PREGUNTA_1", length=200)
	private String crPregunta1;

	@Column(name="CR_PREGUNTA_10_1", length=1000)
	private String crPregunta101;

	@Column(name="CR_PREGUNTA_10_2", length=1000)
	private String crPregunta102;

	@Column(name="CR_PREGUNTA_11", length=150)
	private String crPregunta11;

	@Column(name="CR_PREGUNTA_12", length=200)
	private String crPregunta12;

	@Column(name="CR_PREGUNTA_13", length=150)
	private String crPregunta13;

	@Column(name="CR_PREGUNTA_14", length=150)
	private String crPregunta14;

	@Column(name="CR_PREGUNTA_15", length=200)
	private String crPregunta15;

	@Column(name="CR_PREGUNTA_17", length=150)
	private String crPregunta17;

	@Column(name="CR_PREGUNTA_18", length=150)
	private String crPregunta18;

	@Column(name="CR_PREGUNTA_19", length=150)
	private String crPregunta19;

	@Column(name="CR_PREGUNTA_2", length=100)
	private String crPregunta2;

	@Column(name="CR_PREGUNTA_21", length=200)
	private String crPregunta21;

	@Column(name="CR_PREGUNTA_22", length=200)
	private String crPregunta22;

	@Column(name="CR_PREGUNTA_23", length=200)
	private String crPregunta23;

	@Column(name="CR_PREGUNTA_24", length=200)
	private String crPregunta24;

	@Column(name="CR_PREGUNTA_25", length=200)
	private String crPregunta25;

	@Column(name="CR_PREGUNTA_26", length=150)
	private String crPregunta26;

	@Column(name="CR_PREGUNTA_27", length=150)
	private String crPregunta27;

	@Column(name="CR_PREGUNTA_28_1", length=100)
	private String crPregunta281;

	@Column(name="CR_PREGUNTA_28_2", length=100)
	private String crPregunta282;

	@Column(name="CR_PREGUNTA_28_3", length=100)
	private String crPregunta283;

	@Column(name="CR_PREGUNTA_29", length=100)
	private String crPregunta29;

	@Column(name="CR_PREGUNTA_3", length=200)
	private String crPregunta3;

	@Column(name="CR_PREGUNTA_30", length=150)
	private String crPregunta30;

	@Column(name="CR_PREGUNTA_31", length=150)
	private String crPregunta31;

	@Column(name="CR_PREGUNTA_32", length=150)
	private String crPregunta32;

	@Column(name="CR_PREGUNTA_4", length=200)
	private String crPregunta4;

	@Column(name="CR_PREGUNTA_5", length=100)
	private String crPregunta5;

	@Column(name="CR_PREGUNTA_6", length=200)
	private String crPregunta6;

	@Column(name="CR_PREGUNTA_7", length=200)
	private String crPregunta7;

	@Column(name="CR_PREGUNTA_8_1", length=100)
	private String crPregunta81;

	@Column(name="CR_PREGUNTA_8_2", length=100)
	private String crPregunta82;

	@Column(name="CR_PREGUNTA_8_3", length=100)
	private String crPregunta83;

	@Column(name="CR_PREGUNTA_9", length=100)
	private String crPregunta9;

	@Column(name="CR_TEL_CASA_ASEGURADO", length=15)
	private String crTelCasaAsegurado;

	@Column(name="CR_TEL_CELULAR_ASEGURADO", length=15)
	private String crTelCelularAsegurado;

	@Column(name="CR_TEL_OFI_ASEGURADO", length=15)
	private String crTelOfiAsegurado;

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
	public AbstractFormatoCuestionarioRobo() {
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
	 * @return the crAsegurado
	 */
	public String getCrAsegurado() {
		return crAsegurado;
	}






	/**
	 * @param crAsegurado the crAsegurado to set
	 */
	public void setCrAsegurado(String crAsegurado) {
		this.crAsegurado = crAsegurado;
	}






	/**
	 * @return the crBool11
	 */
	public Integer getCrBool11() {
		return crBool11;
	}



	/**
	 * @param crBool11 the crBool11 to set
	 */
	public void setCrBool11(Integer crBool11) {
		this.crBool11 = crBool11;
	}



	/**
	 * @return the crBool12
	 */
	public Integer getCrBool12() {
		return crBool12;
	}



	/**
	 * @param crBool12 the crBool12 to set
	 */
	public void setCrBool12(Integer crBool12) {
		this.crBool12 = crBool12;
	}



	/**
	 * @return the crBool13
	 */
	public Integer getCrBool13() {
		return crBool13;
	}



	/**
	 * @param crBool13 the crBool13 to set
	 */
	public void setCrBool13(Integer crBool13) {
		this.crBool13 = crBool13;
	}



	/**
	 * @return the crBool14
	 */
	public Integer getCrBool14() {
		return crBool14;
	}



	/**
	 * @param crBool14 the crBool14 to set
	 */
	public void setCrBool14(Integer crBool14) {
		this.crBool14 = crBool14;
	}



	/**
	 * @return the crBool15
	 */
	public Integer getCrBool15() {
		return crBool15;
	}



	/**
	 * @param crBool15 the crBool15 to set
	 */
	public void setCrBool15(Integer crBool15) {
		this.crBool15 = crBool15;
	}



	/**
	 * @return the crBool19
	 */
	public Integer getCrBool19() {
		return crBool19;
	}



	/**
	 * @param crBool19 the crBool19 to set
	 */
	public void setCrBool19(Integer crBool19) {
		this.crBool19 = crBool19;
	}



	/**
	 * @return the crBool2
	 */
	public Integer getCrBool2() {
		return crBool2;
	}



	/**
	 * @param crBool2 the crBool2 to set
	 */
	public void setCrBool2(Integer crBool2) {
		this.crBool2 = crBool2;
	}



	/**
	 * @return the crBool20
	 */
	public Integer getCrBool20() {
		return crBool20;
	}



	/**
	 * @param crBool20 the crBool20 to set
	 */
	public void setCrBool20(Integer crBool20) {
		this.crBool20 = crBool20;
	}



	/**
	 * @return the crBool26
	 */
	public Integer getCrBool26() {
		return crBool26;
	}



	/**
	 * @param crBool26 the crBool26 to set
	 */
	public void setCrBool26(Integer crBool26) {
		this.crBool26 = crBool26;
	}



	/**
	 * @return the crBool27
	 */
	public Integer getCrBool27() {
		return crBool27;
	}



	/**
	 * @param crBool27 the crBool27 to set
	 */
	public void setCrBool27(Integer crBool27) {
		this.crBool27 = crBool27;
	}



	/**
	 * @return the crBool28
	 */
	public Integer getCrBool28() {
		return crBool28;
	}



	/**
	 * @param crBool28 the crBool28 to set
	 */
	public void setCrBool28(Integer crBool28) {
		this.crBool28 = crBool28;
	}



	/**
	 * @return the crBool29
	 */
	public Integer getCrBool29() {
		return crBool29;
	}



	/**
	 * @param crBool29 the crBool29 to set
	 */
	public void setCrBool29(Integer crBool29) {
		this.crBool29 = crBool29;
	}



	/**
	 * @return the crBool3
	 */
	public Integer getCrBool3() {
		return crBool3;
	}



	/**
	 * @param crBool3 the crBool3 to set
	 */
	public void setCrBool3(Integer crBool3) {
		this.crBool3 = crBool3;
	}



	/**
	 * @return the crBool30
	 */
	public Integer getCrBool30() {
		return crBool30;
	}



	/**
	 * @param crBool30 the crBool30 to set
	 */
	public void setCrBool30(Integer crBool30) {
		this.crBool30 = crBool30;
	}



	/**
	 * @return the crBool31
	 */
	public Integer getCrBool31() {
		return crBool31;
	}



	/**
	 * @param crBool31 the crBool31 to set
	 */
	public void setCrBool31(Integer crBool31) {
		this.crBool31 = crBool31;
	}



	/**
	 * @return the crBool5
	 */
	public Integer getCrBool5() {
		return crBool5;
	}



	/**
	 * @param crBool5 the crBool5 to set
	 */
	public void setCrBool5(Integer crBool5) {
		this.crBool5 = crBool5;
	}



	/**
	 * @return the crBool8
	 */
	public Integer getCrBool8() {
		return crBool8;
	}



	/**
	 * @param crBool8 the crBool8 to set
	 */
	public void setCrBool8(Integer crBool8) {
		this.crBool8 = crBool8;
	}



	/**
	 * @return the crBool9
	 */
	public Integer getCrBool9() {
		return crBool9;
	}



	/**
	 * @param crBool9 the crBool9 to set
	 */
	public void setCrBool9(Integer crBool9) {
		this.crBool9 = crBool9;
	}



	/**
	 * @return the crClaveAjustador
	 */
	public String getCrClaveAjustador() {
		return crClaveAjustador;
	}



	/**
	 * @param crClaveAjustador the crClaveAjustador to set
	 */
	public void setCrClaveAjustador(String crClaveAjustador) {
		this.crClaveAjustador = crClaveAjustador;
	}



	/**
	 * @return the crDirAsegurado
	 */
	public String getCrDirAsegurado() {
		return crDirAsegurado;
	}



	/**
	 * @param crDirAsegurado the crDirAsegurado to set
	 */
	public void setCrDirAsegurado(String crDirAsegurado) {
		this.crDirAsegurado = crDirAsegurado;
	}



	/**
	 * @return the crEmailAsegurado
	 */
	public String getCrEmailAsegurado() {
		return crEmailAsegurado;
	}



	/**
	 * @param crEmailAsegurado the crEmailAsegurado to set
	 */
	public void setCrEmailAsegurado(String crEmailAsegurado) {
		this.crEmailAsegurado = crEmailAsegurado;
	}



	/**
	 * @return the crEstacionado
	 */
	public Integer getCrEstacionado() {
		return crEstacionado;
	}



	/**
	 * @param crEstacionado the crEstacionado to set
	 */
	public void setCrEstacionado(Integer crEstacionado) {
		this.crEstacionado = crEstacionado;
	}






	/**
	 * @return the crHora
	 */
	public Timestamp getCrHora() {
		return crHora;
	}



	/**
	 * @param crHora the crHora to set
	 */
	public void setCrHora(Timestamp crHora) {
		this.crHora = crHora;
	}



	/**
	 * @return the crIncAsegurado
	 */
	public String getCrIncAsegurado() {
		return crIncAsegurado;
	}



	/**
	 * @param crIncAsegurado the crIncAsegurado to set
	 */
	public void setCrIncAsegurado(String crIncAsegurado) {
		this.crIncAsegurado = crIncAsegurado;
	}



	/**
	 * @return the crNomAsegurado
	 */
	public String getCrNomAsegurado() {
		return crNomAsegurado;
	}



	/**
	 * @param crNomAsegurado the crNomAsegurado to set
	 */
	public void setCrNomAsegurado(String crNomAsegurado) {
		this.crNomAsegurado = crNomAsegurado;
	}



	/**
	 * @return the crNumEndoso
	 */
	public String getCrNumEndoso() {
		return crNumEndoso;
	}



	/**
	 * @param crNumEndoso the crNumEndoso to set
	 */
	public void setCrNumEndoso(String crNumEndoso) {
		this.crNumEndoso = crNumEndoso;
	}



	/**
	 * @return the crNumInciso
	 */
	public String getCrNumInciso() {
		return crNumInciso;
	}



	/**
	 * @param crNumInciso the crNumInciso to set
	 */
	public void setCrNumInciso(String crNumInciso) {
		this.crNumInciso = crNumInciso;
	}



	/**
	 * @return the crNumPoliza
	 */
	public String getCrNumPoliza() {
		return crNumPoliza;
	}



	/**
	 * @param crNumPoliza the crNumPoliza to set
	 */
	public void setCrNumPoliza(String crNumPoliza) {
		this.crNumPoliza = crNumPoliza;
	}



	/**
	 * @return the crNumReporte
	 */
	public String getCrNumReporte() {
		return crNumReporte;
	}



	/**
	 * @param crNumReporte the crNumReporte to set
	 */
	public void setCrNumReporte(String crNumReporte) {
		this.crNumReporte = crNumReporte;
	}



	/**
	 * @return the crNumSiniestro
	 */
	public String getCrNumSiniestro() {
		return crNumSiniestro;
	}



	/**
	 * @param crNumSiniestro the crNumSiniestro to set
	 */
	public void setCrNumSiniestro(String crNumSiniestro) {
		this.crNumSiniestro = crNumSiniestro;
	}



	/**
	 * @return the crO16Carga
	 */
	public Integer getCrO16Carga() {
		return crO16Carga;
	}



	/**
	 * @param crO16Carga the crO16Carga to set
	 */
	public void setCrO16Carga(Integer crO16Carga) {
		this.crO16Carga = crO16Carga;
	}



	/**
	 * @return the crO16Enseñanza
	 */
	public Integer getCrO16Enseñanza() {
		return crO16Enseñanza;
	}



	/**
	 * @param crO16Enseñanza the crO16Enseñanza to set
	 */
	public void setCrO16Enseñanza(Integer crO16Enseñanza) {
		this.crO16Enseñanza = crO16Enseñanza;
	}



	/**
	 * @return the crO16Otros
	 */
	public Integer getCrO16Otros() {
		return crO16Otros;
	}



	/**
	 * @param crO16Otros the crO16Otros to set
	 */
	public void setCrO16Otros(Integer crO16Otros) {
		this.crO16Otros = crO16Otros;
	}



	/**
	 * @return the crO16Particular
	 */
	public Integer getCrO16Particular() {
		return crO16Particular;
	}



	/**
	 * @param crO16Particular the crO16Particular to set
	 */
	public void setCrO16Particular(Integer crO16Particular) {
		this.crO16Particular = crO16Particular;
	}



	/**
	 * @return the crO16Publico
	 */
	public Integer getCrO16Publico() {
		return crO16Publico;
	}



	/**
	 * @param crO16Publico the crO16Publico to set
	 */
	public void setCrO16Publico(Integer crO16Publico) {
		this.crO16Publico = crO16Publico;
	}



	/**
	 * @return the crOcuAsegurado
	 */
	public String getCrOcuAsegurado() {
		return crOcuAsegurado;
	}



	/**
	 * @param crOcuAsegurado the crOcuAsegurado to set
	 */
	public void setCrOcuAsegurado(String crOcuAsegurado) {
		this.crOcuAsegurado = crOcuAsegurado;
	}



	/**
	 * @return the crOtros
	 */
	public String getCrOtros() {
		return crOtros;
	}



	/**
	 * @param crOtros the crOtros to set
	 */
	public void setCrOtros(String crOtros) {
		this.crOtros = crOtros;
	}



	/**
	 * @return the crPregunta1
	 */
	public String getCrPregunta1() {
		return crPregunta1;
	}



	/**
	 * @param crPregunta1 the crPregunta1 to set
	 */
	public void setCrPregunta1(String crPregunta1) {
		this.crPregunta1 = crPregunta1;
	}



	/**
	 * @return the crPregunta101
	 */
	public String getCrPregunta101() {
		return crPregunta101;
	}



	/**
	 * @param crPregunta101 the crPregunta101 to set
	 */
	public void setCrPregunta101(String crPregunta101) {
		this.crPregunta101 = crPregunta101;
	}



	/**
	 * @return the crPregunta102
	 */
	public String getCrPregunta102() {
		return crPregunta102;
	}



	/**
	 * @param crPregunta102 the crPregunta102 to set
	 */
	public void setCrPregunta102(String crPregunta102) {
		this.crPregunta102 = crPregunta102;
	}



	/**
	 * @return the crPregunta11
	 */
	public String getCrPregunta11() {
		return crPregunta11;
	}



	/**
	 * @param crPregunta11 the crPregunta11 to set
	 */
	public void setCrPregunta11(String crPregunta11) {
		this.crPregunta11 = crPregunta11;
	}



	/**
	 * @return the crPregunta12
	 */
	public String getCrPregunta12() {
		return crPregunta12;
	}



	/**
	 * @param crPregunta12 the crPregunta12 to set
	 */
	public void setCrPregunta12(String crPregunta12) {
		this.crPregunta12 = crPregunta12;
	}



	/**
	 * @return the crPregunta13
	 */
	public String getCrPregunta13() {
		return crPregunta13;
	}



	/**
	 * @param crPregunta13 the crPregunta13 to set
	 */
	public void setCrPregunta13(String crPregunta13) {
		this.crPregunta13 = crPregunta13;
	}



	/**
	 * @return the crPregunta14
	 */
	public String getCrPregunta14() {
		return crPregunta14;
	}



	/**
	 * @param crPregunta14 the crPregunta14 to set
	 */
	public void setCrPregunta14(String crPregunta14) {
		this.crPregunta14 = crPregunta14;
	}



	/**
	 * @return the crPregunta15
	 */
	public String getCrPregunta15() {
		return crPregunta15;
	}



	/**
	 * @param crPregunta15 the crPregunta15 to set
	 */
	public void setCrPregunta15(String crPregunta15) {
		this.crPregunta15 = crPregunta15;
	}



	/**
	 * @return the crPregunta17
	 */
	public String getCrPregunta17() {
		return crPregunta17;
	}



	/**
	 * @param crPregunta17 the crPregunta17 to set
	 */
	public void setCrPregunta17(String crPregunta17) {
		this.crPregunta17 = crPregunta17;
	}



	/**
	 * @return the crPregunta18
	 */
	public String getCrPregunta18() {
		return crPregunta18;
	}



	/**
	 * @param crPregunta18 the crPregunta18 to set
	 */
	public void setCrPregunta18(String crPregunta18) {
		this.crPregunta18 = crPregunta18;
	}



	/**
	 * @return the crPregunta19
	 */
	public String getCrPregunta19() {
		return crPregunta19;
	}



	/**
	 * @param crPregunta19 the crPregunta19 to set
	 */
	public void setCrPregunta19(String crPregunta19) {
		this.crPregunta19 = crPregunta19;
	}



	/**
	 * @return the crPregunta2
	 */
	public String getCrPregunta2() {
		return crPregunta2;
	}



	/**
	 * @param crPregunta2 the crPregunta2 to set
	 */
	public void setCrPregunta2(String crPregunta2) {
		this.crPregunta2 = crPregunta2;
	}



	/**
	 * @return the crPregunta21
	 */
	public String getCrPregunta21() {
		return crPregunta21;
	}



	/**
	 * @param crPregunta21 the crPregunta21 to set
	 */
	public void setCrPregunta21(String crPregunta21) {
		this.crPregunta21 = crPregunta21;
	}



	/**
	 * @return the crPregunta22
	 */
	public String getCrPregunta22() {
		return crPregunta22;
	}



	/**
	 * @param crPregunta22 the crPregunta22 to set
	 */
	public void setCrPregunta22(String crPregunta22) {
		this.crPregunta22 = crPregunta22;
	}



	/**
	 * @return the crPregunta23
	 */
	public String getCrPregunta23() {
		return crPregunta23;
	}



	/**
	 * @param crPregunta23 the crPregunta23 to set
	 */
	public void setCrPregunta23(String crPregunta23) {
		this.crPregunta23 = crPregunta23;
	}



	/**
	 * @return the crPregunta24
	 */
	public String getCrPregunta24() {
		return crPregunta24;
	}



	/**
	 * @param crPregunta24 the crPregunta24 to set
	 */
	public void setCrPregunta24(String crPregunta24) {
		this.crPregunta24 = crPregunta24;
	}



	/**
	 * @return the crPregunta25
	 */
	public String getCrPregunta25() {
		return crPregunta25;
	}



	/**
	 * @param crPregunta25 the crPregunta25 to set
	 */
	public void setCrPregunta25(String crPregunta25) {
		this.crPregunta25 = crPregunta25;
	}



	/**
	 * @return the crPregunta26
	 */
	public String getCrPregunta26() {
		return crPregunta26;
	}



	/**
	 * @param crPregunta26 the crPregunta26 to set
	 */
	public void setCrPregunta26(String crPregunta26) {
		this.crPregunta26 = crPregunta26;
	}



	/**
	 * @return the crPregunta27
	 */
	public String getCrPregunta27() {
		return crPregunta27;
	}



	/**
	 * @param crPregunta27 the crPregunta27 to set
	 */
	public void setCrPregunta27(String crPregunta27) {
		this.crPregunta27 = crPregunta27;
	}



	/**
	 * @return the crPregunta281
	 */
	public String getCrPregunta281() {
		return crPregunta281;
	}



	/**
	 * @param crPregunta281 the crPregunta281 to set
	 */
	public void setCrPregunta281(String crPregunta281) {
		this.crPregunta281 = crPregunta281;
	}



	/**
	 * @return the crPregunta282
	 */
	public String getCrPregunta282() {
		return crPregunta282;
	}



	/**
	 * @param crPregunta282 the crPregunta282 to set
	 */
	public void setCrPregunta282(String crPregunta282) {
		this.crPregunta282 = crPregunta282;
	}



	/**
	 * @return the crPregunta283
	 */
	public String getCrPregunta283() {
		return crPregunta283;
	}



	/**
	 * @param crPregunta283 the crPregunta283 to set
	 */
	public void setCrPregunta283(String crPregunta283) {
		this.crPregunta283 = crPregunta283;
	}



	/**
	 * @return the crPregunta29
	 */
	public String getCrPregunta29() {
		return crPregunta29;
	}



	/**
	 * @param crPregunta29 the crPregunta29 to set
	 */
	public void setCrPregunta29(String crPregunta29) {
		this.crPregunta29 = crPregunta29;
	}



	/**
	 * @return the crPregunta3
	 */
	public String getCrPregunta3() {
		return crPregunta3;
	}



	/**
	 * @param crPregunta3 the crPregunta3 to set
	 */
	public void setCrPregunta3(String crPregunta3) {
		this.crPregunta3 = crPregunta3;
	}



	/**
	 * @return the crPregunta30
	 */
	public String getCrPregunta30() {
		return crPregunta30;
	}



	/**
	 * @param crPregunta30 the crPregunta30 to set
	 */
	public void setCrPregunta30(String crPregunta30) {
		this.crPregunta30 = crPregunta30;
	}



	/**
	 * @return the crPregunta31
	 */
	public String getCrPregunta31() {
		return crPregunta31;
	}



	/**
	 * @param crPregunta31 the crPregunta31 to set
	 */
	public void setCrPregunta31(String crPregunta31) {
		this.crPregunta31 = crPregunta31;
	}



	/**
	 * @return the crPregunta32
	 */
	public String getCrPregunta32() {
		return crPregunta32;
	}



	/**
	 * @param crPregunta32 the crPregunta32 to set
	 */
	public void setCrPregunta32(String crPregunta32) {
		this.crPregunta32 = crPregunta32;
	}



	/**
	 * @return the crPregunta4
	 */
	public String getCrPregunta4() {
		return crPregunta4;
	}



	/**
	 * @param crPregunta4 the crPregunta4 to set
	 */
	public void setCrPregunta4(String crPregunta4) {
		this.crPregunta4 = crPregunta4;
	}



	/**
	 * @return the crPregunta5
	 */
	public String getCrPregunta5() {
		return crPregunta5;
	}



	/**
	 * @param crPregunta5 the crPregunta5 to set
	 */
	public void setCrPregunta5(String crPregunta5) {
		this.crPregunta5 = crPregunta5;
	}



	/**
	 * @return the crPregunta6
	 */
	public String getCrPregunta6() {
		return crPregunta6;
	}



	/**
	 * @param crPregunta6 the crPregunta6 to set
	 */
	public void setCrPregunta6(String crPregunta6) {
		this.crPregunta6 = crPregunta6;
	}



	/**
	 * @return the crPregunta7
	 */
	public String getCrPregunta7() {
		return crPregunta7;
	}



	/**
	 * @param crPregunta7 the crPregunta7 to set
	 */
	public void setCrPregunta7(String crPregunta7) {
		this.crPregunta7 = crPregunta7;
	}



	/**
	 * @return the crPregunta81
	 */
	public String getCrPregunta81() {
		return crPregunta81;
	}



	/**
	 * @param crPregunta81 the crPregunta81 to set
	 */
	public void setCrPregunta81(String crPregunta81) {
		this.crPregunta81 = crPregunta81;
	}



	/**
	 * @return the crPregunta82
	 */
	public String getCrPregunta82() {
		return crPregunta82;
	}



	/**
	 * @param crPregunta82 the crPregunta82 to set
	 */
	public void setCrPregunta82(String crPregunta82) {
		this.crPregunta82 = crPregunta82;
	}



	/**
	 * @return the crPregunta83
	 */
	public String getCrPregunta83() {
		return crPregunta83;
	}



	/**
	 * @param crPregunta83 the crPregunta83 to set
	 */
	public void setCrPregunta83(String crPregunta83) {
		this.crPregunta83 = crPregunta83;
	}



	/**
	 * @return the crPregunta9
	 */
	public String getCrPregunta9() {
		return crPregunta9;
	}



	/**
	 * @param crPregunta9 the crPregunta9 to set
	 */
	public void setCrPregunta9(String crPregunta9) {
		this.crPregunta9 = crPregunta9;
	}



	/**
	 * @return the crTelCasaAsegurado
	 */
	public String getCrTelCasaAsegurado() {
		return crTelCasaAsegurado;
	}



	/**
	 * @param crTelCasaAsegurado the crTelCasaAsegurado to set
	 */
	public void setCrTelCasaAsegurado(String crTelCasaAsegurado) {
		this.crTelCasaAsegurado = crTelCasaAsegurado;
	}



	/**
	 * @return the crTelCelularAsegurado
	 */
	public String getCrTelCelularAsegurado() {
		return crTelCelularAsegurado;
	}



	/**
	 * @param crTelCelularAsegurado the crTelCelularAsegurado to set
	 */
	public void setCrTelCelularAsegurado(String crTelCelularAsegurado) {
		this.crTelCelularAsegurado = crTelCelularAsegurado;
	}



	/**
	 * @return the crTelOfiAsegurado
	 */
	public String getCrTelOfiAsegurado() {
		return crTelOfiAsegurado;
	}



	/**
	 * @param crTelOfiAsegurado the crTelOfiAsegurado to set
	 */
	public void setCrTelOfiAsegurado(String crTelOfiAsegurado) {
		this.crTelOfiAsegurado = crTelOfiAsegurado;
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
	 * @return the crO16Emergencia
	 */
	public Integer getCrO16Emergencia() {
		return crO16Emergencia;
	}



	/**
	 * @param crO16Emergencia the crO16Emergencia to set
	 */
	public void setCrO16Emergencia(Integer crO16Emergencia) {
		this.crO16Emergencia = crO16Emergencia;
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






	



}