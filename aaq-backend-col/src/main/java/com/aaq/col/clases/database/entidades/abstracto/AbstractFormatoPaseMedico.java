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
 public abstract class AbstractFormatoPaseMedico extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opMedicoSEQ", sequenceName = "formato_pase_medico_seq", allocationSize = 1)
	 @Id
	 @Column(name = "PM_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opMedicoSEQ")
	 private Integer id;
	
	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;

	

	@Column(name="PM_AMBULATORIA")
	private Integer pmAmbulatoria;

	@Column(name="PM_ASEGURADO", length=5)
	private String pmAsegurado;

	@Column(name="PM_CAUSA_LESION")
	private Integer pmCausaLesion;

	@Column(name="PM_CLAVE_AJUSTADOR", length=20)
	private String pmClaveAjustador;

	@Column(name="PM_CLAVE_CLINICA", length=20)
	private String pmClaveClinica;

	@Column(name="PM_CLAVE_MEDICO", length=20)
	private String pmClaveMedico;

	@Column(name="PM_COBERTURA_AFEC")
	private Integer pmCoberturaAfec;

	@Column(name="PM_CONVENIO")
	private Integer pmConvenio;

	@Column(name="PM_DOM_CLINICA", length=100)
	private String pmDomClinica;

	@Column(name="PM_EDAD_LESIONADO", length=3)
	private String pmEdadLesionado;

	@Column(name="PM_EMAIL_ASEGURADO", length=50)
	private String pmEmailAsegurado;

	@Temporal(TemporalType.DATE)
	@Column(name="PM_FECHA_EMISION")
	private Date pmFechaEmision;

	@Temporal(TemporalType.DATE)
	@Column(name="PM_FECHA_SINIESTRO")
	private Date pmFechaSiniestro;

	@Column(name="PM_FOLIO_ELECTRO", length=20)
	private String pmFolioElectro;

	@Column(name="PM_IDE_LESIONADO", length=100)
	private String pmIdeLesionado;

	@Column(name="PM_LESIONES_APARENTES", length=150)
	private String pmLesionesAparentes;

	@Column(name="PM_LUGAR_EMISION")
	private Integer pmLugarEmision;

	@Column(name="PM_LUGAR_ESTADO", length=100)
	private String pmLugarEstado;

	@Column(name="PM_MEDICO_RED")
	private Integer pmMedicoRed;

	

	@Column(name="PM_NOM_AJUSTADOR", length=100)
	private String pmNomAjustador;

	@Column(name="PM_NOM_ASEGURADO", length=100)
	private String pmNomAsegurado;

	@Column(name="PM_NOM_CLINICA", length=100)
	private String pmNomClinica;

	@Column(name="PM_NOM_LESIONADO", length=100)
	private String pmNomLesionado;

	@Column(name="PM_NOM_MEDICO", length=100)
	private String pmNomMedico;

	@Column(name="PM_NUM_ENDOSO", length=20)
	private String pmNumEndoso;

	@Column(name="PM_NUM_INCISO", length=20)
	private String pmNumInciso;

	@Column(name="PM_NUM_LESIONADO", length=20)
	private String pmNumLesionado;

	@Column(name="PM_NUM_OCUPANTES", length=3)
	private String pmNumOcupantes;

	@Column(name="PM_NUM_POLIZA", length=20)
	private String pmNumPoliza;

	@Column(name="PM_NUM_REPORTE", length=20)
	private String pmNumReporte;

	@Column(name="PM_NUM_SINIESTRO", length=20)
	private String pmNumSiniestro;

	@Column(name="PM_OTRA_COBERTURA", length=50)
	private String pmOtraCobertura;

	@Column(name="PM_OTRA_LESION", length=50)
	private String pmOtraLesion;

	@Column(name="PM_OTRO_VEHICULO", length=50)
	private String pmOtroVehiculo;

	@Column(name="PM_TEL_CLINICA", length=15)
	private String pmTelClinica;

	@Column(name="PM_TEL_LESIONADO", length=15)
	private String pmTelLesionado;

	@Column(name="PM_TEL_MEDICO", length=15)
	private String pmTelMedico;

	@Column(name="PM_TIPO_CLINICA")
	private Integer pmTipoClinica;

	@Column(name="PM_TIPO_VEHICULO")
	private Integer pmTipoVehiculo;
	
	@Column(name="PM_EMAIL_LESIONADO", length=100)
	private String pmEmailLesionado;


	
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
     
     @Column(name = "FIRMA_LESIONADO")
     private String firmaLesionado;
     
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
	public AbstractFormatoPaseMedico() {
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
	 * @return the pmId
	 */
	public Integer getId() {
		return id;
	}




	/**
	 * @param pmId the pmId to set
	 */
	public void setId(Integer pmId) {
		this.id = pmId;
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
	 * @return the pmAmbulatoria
	 */
	public Integer getPmAmbulatoria() {
		return pmAmbulatoria;
	}




	/**
	 * @param pmAmbulatoria the pmAmbulatoria to set
	 */
	public void setPmAmbulatoria(Integer pmAmbulatoria) {
		this.pmAmbulatoria = pmAmbulatoria;
	}








	/**
	 * @return the pmAsegurado
	 */
	public String getPmAsegurado() {
		return pmAsegurado;
	}




	/**
	 * @param pmAsegurado the pmAsegurado to set
	 */
	public void setPmAsegurado(String pmAsegurado) {
		this.pmAsegurado = pmAsegurado;
	}




	/**
	 * @return the pmCausaLesion
	 */
	public Integer getPmCausaLesion() {
		return pmCausaLesion;
	}




	/**
	 * @param pmCausaLesion the pmCausaLesion to set
	 */
	public void setPmCausaLesion(Integer pmCausaLesion) {
		this.pmCausaLesion = pmCausaLesion;
	}




	/**
	 * @return the pmClaveAjustador
	 */
	public String getPmClaveAjustador() {
		return pmClaveAjustador;
	}




	/**
	 * @param pmClaveAjustador the pmClaveAjustador to set
	 */
	public void setPmClaveAjustador(String pmClaveAjustador) {
		this.pmClaveAjustador = pmClaveAjustador;
	}




	/**
	 * @return the pmClaveClinica
	 */
	public String getPmClaveClinica() {
		return pmClaveClinica;
	}




	/**
	 * @param pmClaveClinica the pmClaveClinica to set
	 */
	public void setPmClaveClinica(String pmClaveClinica) {
		this.pmClaveClinica = pmClaveClinica;
	}




	/**
	 * @return the pmClaveMedico
	 */
	public String getPmClaveMedico() {
		return pmClaveMedico;
	}




	/**
	 * @param pmClaveMedico the pmClaveMedico to set
	 */
	public void setPmClaveMedico(String pmClaveMedico) {
		this.pmClaveMedico = pmClaveMedico;
	}




	/**
	 * @return the pmCoberturaAfec
	 */
	public Integer getPmCoberturaAfec() {
		return pmCoberturaAfec;
	}




	/**
	 * @param pmCoberturaAfec the pmCoberturaAfec to set
	 */
	public void setPmCoberturaAfec(Integer pmCoberturaAfec) {
		this.pmCoberturaAfec = pmCoberturaAfec;
	}




	/**
	 * @return the pmConvenio
	 */
	public Integer getPmConvenio() {
		return pmConvenio;
	}




	/**
	 * @param pmConvenio the pmConvenio to set
	 */
	public void setPmConvenio(Integer pmConvenio) {
		this.pmConvenio = pmConvenio;
	}




	/**
	 * @return the pmDomClinica
	 */
	public String getPmDomClinica() {
		return pmDomClinica;
	}




	/**
	 * @param pmDomClinica the pmDomClinica to set
	 */
	public void setPmDomClinica(String pmDomClinica) {
		this.pmDomClinica = pmDomClinica;
	}




	/**
	 * @return the pmEdadLesionado
	 */
	public String getPmEdadLesionado() {
		return pmEdadLesionado;
	}




	/**
	 * @param pmEdadLesionado the pmEdadLesionado to set
	 */
	public void setPmEdadLesionado(String pmEdadLesionado) {
		this.pmEdadLesionado = pmEdadLesionado;
	}




	/**
	 * @return the pmEmailAsegurado
	 */
	public String getPmEmailAsegurado() {
		return pmEmailAsegurado;
	}




	/**
	 * @param pmEmailAsegurado the pmEmailAsegurado to set
	 */
	public void setPmEmailAsegurado(String pmEmailAsegurado) {
		this.pmEmailAsegurado = pmEmailAsegurado;
	}




	/**
	 * @return the pmFechaEmision
	 */
	public Date getPmFechaEmision() {
		return pmFechaEmision;
	}




	/**
	 * @param pmFechaEmision the pmFechaEmision to set
	 */
	public void setPmFechaEmision(Date pmFechaEmision) {
		this.pmFechaEmision = pmFechaEmision;
	}




	/**
	 * @return the pmFechaSiniestro
	 */
	public Date getPmFechaSiniestro() {
		return pmFechaSiniestro;
	}




	/**
	 * @param pmFechaSiniestro the pmFechaSiniestro to set
	 */
	public void setPmFechaSiniestro(Date pmFechaSiniestro) {
		this.pmFechaSiniestro = pmFechaSiniestro;
	}




	




	/**
	 * @return the pmFolioElectro
	 */
	public String getPmFolioElectro() {
		return pmFolioElectro;
	}




	/**
	 * @param pmFolioElectro the pmFolioElectro to set
	 */
	public void setPmFolioElectro(String pmFolioElectro) {
		this.pmFolioElectro = pmFolioElectro;
	}




	/**
	 * @return the pmIdeLesionado
	 */
	public String getPmIdeLesionado() {
		return pmIdeLesionado;
	}




	/**
	 * @param pmIdeLesionado the pmIdeLesionado to set
	 */
	public void setPmIdeLesionado(String pmIdeLesionado) {
		this.pmIdeLesionado = pmIdeLesionado;
	}




	/**
	 * @return the pmLesionesAparentes
	 */
	public String getPmLesionesAparentes() {
		return pmLesionesAparentes;
	}




	/**
	 * @param pmLesionesAparentes the pmLesionesAparentes to set
	 */
	public void setPmLesionesAparentes(String pmLesionesAparentes) {
		this.pmLesionesAparentes = pmLesionesAparentes;
	}




	/**
	 * @return the pmLugarEmision
	 */
	public Integer getPmLugarEmision() {
		return pmLugarEmision;
	}




	/**
	 * @param pmLugarEmision the pmLugarEmision to set
	 */
	public void setPmLugarEmision(Integer pmLugarEmision) {
		this.pmLugarEmision = pmLugarEmision;
	}




	/**
	 * @return the pmLugarEstado
	 */
	public String getPmLugarEstado() {
		return pmLugarEstado;
	}




	/**
	 * @param pmLugarEstado the pmLugarEstado to set
	 */
	public void setPmLugarEstado(String pmLugarEstado) {
		this.pmLugarEstado = pmLugarEstado;
	}




	/**
	 * @return the pmMedicoRed
	 */
	public Integer getPmMedicoRed() {
		return pmMedicoRed;
	}




	/**
	 * @param pmMedicoRed the pmMedicoRed to set
	 */
	public void setPmMedicoRed(Integer pmMedicoRed) {
		this.pmMedicoRed = pmMedicoRed;
	}








	/**
	 * @return the pmNomAjustador
	 */
	public String getPmNomAjustador() {
		return pmNomAjustador;
	}




	/**
	 * @param pmNomAjustador the pmNomAjustador to set
	 */
	public void setPmNomAjustador(String pmNomAjustador) {
		this.pmNomAjustador = pmNomAjustador;
	}




	/**
	 * @return the pmNomAsegurado
	 */
	public String getPmNomAsegurado() {
		return pmNomAsegurado;
	}




	/**
	 * @param pmNomAsegurado the pmNomAsegurado to set
	 */
	public void setPmNomAsegurado(String pmNomAsegurado) {
		this.pmNomAsegurado = pmNomAsegurado;
	}




	/**
	 * @return the pmNomClinica
	 */
	public String getPmNomClinica() {
		return pmNomClinica;
	}




	/**
	 * @param pmNomClinica the pmNomClinica to set
	 */
	public void setPmNomClinica(String pmNomClinica) {
		this.pmNomClinica = pmNomClinica;
	}




	/**
	 * @return the pmNomLesionado
	 */
	public String getPmNomLesionado() {
		return pmNomLesionado;
	}




	/**
	 * @param pmNomLesionado the pmNomLesionado to set
	 */
	public void setPmNomLesionado(String pmNomLesionado) {
		this.pmNomLesionado = pmNomLesionado;
	}




	/**
	 * @return the pmNomMedico
	 */
	public String getPmNomMedico() {
		return pmNomMedico;
	}




	/**
	 * @param pmNomMedico the pmNomMedico to set
	 */
	public void setPmNomMedico(String pmNomMedico) {
		this.pmNomMedico = pmNomMedico;
	}




	/**
	 * @return the pmNumEndoso
	 */
	public String getPmNumEndoso() {
		return pmNumEndoso;
	}




	/**
	 * @param pmNumEndoso the pmNumEndoso to set
	 */
	public void setPmNumEndoso(String pmNumEndoso) {
		this.pmNumEndoso = pmNumEndoso;
	}




	/**
	 * @return the pmNumInciso
	 */
	public String getPmNumInciso() {
		return pmNumInciso;
	}




	/**
	 * @param pmNumInciso the pmNumInciso to set
	 */
	public void setPmNumInciso(String pmNumInciso) {
		this.pmNumInciso = pmNumInciso;
	}




	/**
	 * @return the pmNumLesionado
	 */
	public String getPmNumLesionado() {
		return pmNumLesionado;
	}




	/**
	 * @param pmNumLesionado the pmNumLesionado to set
	 */
	public void setPmNumLesionado(String pmNumLesionado) {
		this.pmNumLesionado = pmNumLesionado;
	}




	/**
	 * @return the pmNumOcupantes
	 */
	public String getPmNumOcupantes() {
		return pmNumOcupantes;
	}




	/**
	 * @param pmNumOcupantes the pmNumOcupantes to set
	 */
	public void setPmNumOcupantes(String pmNumOcupantes) {
		this.pmNumOcupantes = pmNumOcupantes;
	}




	/**
	 * @return the pmNumPoliza
	 */
	public String getPmNumPoliza() {
		return pmNumPoliza;
	}




	/**
	 * @param pmNumPoliza the pmNumPoliza to set
	 */
	public void setPmNumPoliza(String pmNumPoliza) {
		this.pmNumPoliza = pmNumPoliza;
	}




	/**
	 * @return the pmNumReporte
	 */
	public String getPmNumReporte() {
		return pmNumReporte;
	}




	/**
	 * @param pmNumReporte the pmNumReporte to set
	 */
	public void setPmNumReporte(String pmNumReporte) {
		this.pmNumReporte = pmNumReporte;
	}




	/**
	 * @return the pmNumSiniestro
	 */
	public String getPmNumSiniestro() {
		return pmNumSiniestro;
	}




	/**
	 * @param pmNumSiniestro the pmNumSiniestro to set
	 */
	public void setPmNumSiniestro(String pmNumSiniestro) {
		this.pmNumSiniestro = pmNumSiniestro;
	}




	/**
	 * @return the pmOtraCobertura
	 */
	public String getPmOtraCobertura() {
		return pmOtraCobertura;
	}




	/**
	 * @param pmOtraCobertura the pmOtraCobertura to set
	 */
	public void setPmOtraCobertura(String pmOtraCobertura) {
		this.pmOtraCobertura = pmOtraCobertura;
	}




	/**
	 * @return the pmOtraLesion
	 */
	public String getPmOtraLesion() {
		return pmOtraLesion;
	}




	/**
	 * @param pmOtraLesion the pmOtraLesion to set
	 */
	public void setPmOtraLesion(String pmOtraLesion) {
		this.pmOtraLesion = pmOtraLesion;
	}




	/**
	 * @return the pmOtroVehiculo
	 */
	public String getPmOtroVehiculo() {
		return pmOtroVehiculo;
	}




	/**
	 * @param pmOtroVehiculo the pmOtroVehiculo to set
	 */
	public void setPmOtroVehiculo(String pmOtroVehiculo) {
		this.pmOtroVehiculo = pmOtroVehiculo;
	}




	/**
	 * @return the pmTelClinica
	 */
	public String getPmTelClinica() {
		return pmTelClinica;
	}




	/**
	 * @param pmTelClinica the pmTelClinica to set
	 */
	public void setPmTelClinica(String pmTelClinica) {
		this.pmTelClinica = pmTelClinica;
	}




	/**
	 * @return the pmTelLesionado
	 */
	public String getPmTelLesionado() {
		return pmTelLesionado;
	}




	/**
	 * @param pmTelLesionado the pmTelLesionado to set
	 */
	public void setPmTelLesionado(String pmTelLesionado) {
		this.pmTelLesionado = pmTelLesionado;
	}




	/**
	 * @return the pmTelMedico
	 */
	public String getPmTelMedico() {
		return pmTelMedico;
	}




	/**
	 * @param pmTelMedico the pmTelMedico to set
	 */
	public void setPmTelMedico(String pmTelMedico) {
		this.pmTelMedico = pmTelMedico;
	}




	/**
	 * @return the pmTipoClinica
	 */
	public Integer getPmTipoClinica() {
		return pmTipoClinica;
	}




	/**
	 * @param pmTipoClinica the pmTipoClinica to set
	 */
	public void setPmTipoClinica(Integer pmTipoClinica) {
		this.pmTipoClinica = pmTipoClinica;
	}




	/**
	 * @return the pmTipoVehiculo
	 */
	public Integer getPmTipoVehiculo() {
		return pmTipoVehiculo;
	}




	/**
	 * @param pmTipoVehiculo the pmTipoVehiculo to set
	 */
	public void setPmTipoVehiculo(Integer pmTipoVehiculo) {
		this.pmTipoVehiculo = pmTipoVehiculo;
	}




	/**
	 * @return the pmEmailLesionado
	 */
	public String getPmEmailLesionado() {
		return pmEmailLesionado;
	}




	/**
	 * @param pmEmailLesionado the pmEmailLesionado to set
	 */
	public void setPmEmailLesionado(String pmEmailLesionado) {
		this.pmEmailLesionado = pmEmailLesionado;
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




	/**
	 * @return the firmaLesionado
	 */
	public String getFirmaLesionado() {
		return firmaLesionado;
	}




	/**
	 * @param firmaLesionado the firmaLesionado to set
	 */
	public void setFirmaLesionado(String firmaLesionado) {
		this.firmaLesionado = firmaLesionado;
	}




	
	
	
	




}