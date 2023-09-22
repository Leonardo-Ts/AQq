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
 public abstract class AbstractFormatoEncuestaServicio extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	 @SequenceGenerator(name = "opEncuestaSEQ", sequenceName = "formato_encuesta_servicio_seq", allocationSize = 1)
	 @Id
	 @Column(name="ES_ID", unique=true, nullable=false)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opEncuestaSEQ")
	 private Integer id;
	
	 @Column(name="ENVIADO_FTP")
		private Integer enviadoFtp;

		@Column(name="ES_ASEGURADO", length=5)
		private String esAsegurado;

		@Column(name="ES_CLAVE_AJUSTADOR", length=20)
		private String esClaveAjustador;

		@Column(name="ES_EMAIL_CONDUCTOR", length=50)
		private String esEmailConductor;

		@Temporal(TemporalType.DATE)
		@Column(name="ES_FECHA")
		private Date esFecha;

		@Column(name="ES_FTP_RESPUESTA", length=255)
		private String esFtpRespuesta;

		@Column(name="ES_LUGAR", length=100)
		private String esLugar;

		@Column(name="ES_NOM_ASEGURADO", length=100)
		private String esNomAsegurado;

		@Column(name="ES_NOM_CONDUCTOR", length=100)
		private String esNomConductor;

		@Column(name="ES_NUM_INCISO", length=20)
		private String esNumInciso;

		@Column(name="ES_NUM_POLIZA", length=20)
		private String esNumPoliza;

		@Column(name="ES_NUM_REPORTE", length=20)
		private String esNumReporte;

		@Column(name="ES_NUM_SINIESTRO", length=20)
		private String esNumSiniestro;

		@Column(name="ES_OBSERVACIONES", length=300)
		private String esObservaciones;

		@Column(name="ES_PREGUNTA_1")
		private Integer esPregunta1;

		@Column(name="ES_PREGUNTA_10")
		private Integer esPregunta10;

		@Column(name="ES_PREGUNTA_2")
		private Integer esPregunta2;

		@Column(name="ES_PREGUNTA_3")
		private Integer esPregunta3;

		@Column(name="ES_PREGUNTA_4")
		private Integer esPregunta4;

		@Column(name="ES_PREGUNTA_5")
		private Integer esPregunta5;

		@Column(name="ES_PREGUNTA_6")
		private Integer esPregunta6;

		@Column(name="ES_PREGUNTA_7")
		private Integer esPregunta7;

		@Column(name="ES_PREGUNTA_8")
		private Integer esPregunta8;

		@Column(name="ES_PREGUNTA_9")
		private Integer esPregunta9;

		@Column(name="ES_TEL_CONDUCTOR", length=15)
		private String esTelConductor;


		
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
	public AbstractFormatoEncuestaServicio() {
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




	public Integer getEnviadoFtp() {
		return this.enviadoFtp;
	}

	public void setEnviadoFtp(Integer enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}

	

	/**
	 * @return the esAsegurado
	 */
	public String getEsAsegurado() {
		return esAsegurado;
	}




	/**
	 * @param esAsegurado the esAsegurado to set
	 */
	public void setEsAsegurado(String esAsegurado) {
		this.esAsegurado = esAsegurado;
	}




	public String getEsClaveAjustador() {
		return this.esClaveAjustador;
	}

	public void setEsClaveAjustador(String esClaveAjustador) {
		this.esClaveAjustador = esClaveAjustador;
	}

	public String getEsEmailConductor() {
		return this.esEmailConductor;
	}

	public void setEsEmailConductor(String esEmailConductor) {
		this.esEmailConductor = esEmailConductor;
	}

	public Date getEsFecha() {
		return this.esFecha;
	}

	public void setEsFecha(Date esFecha) {
		this.esFecha = esFecha;
	}

	public String getEsFtpRespuesta() {
		return this.esFtpRespuesta;
	}

	public void setEsFtpRespuesta(String esFtpRespuesta) {
		this.esFtpRespuesta = esFtpRespuesta;
	}

	public String getEsLugar() {
		return this.esLugar;
	}

	public void setEsLugar(String esLugar) {
		this.esLugar = esLugar;
	}

	public String getEsNomAsegurado() {
		return this.esNomAsegurado;
	}

	public void setEsNomAsegurado(String esNomAsegurado) {
		this.esNomAsegurado = esNomAsegurado;
	}

	public String getEsNomConductor() {
		return this.esNomConductor;
	}

	public void setEsNomConductor(String esNomConductor) {
		this.esNomConductor = esNomConductor;
	}

	public String getEsNumInciso() {
		return this.esNumInciso;
	}

	public void setEsNumInciso(String esNumInciso) {
		this.esNumInciso = esNumInciso;
	}

	public String getEsNumPoliza() {
		return this.esNumPoliza;
	}

	public void setEsNumPoliza(String esNumPoliza) {
		this.esNumPoliza = esNumPoliza;
	}

	public String getEsNumReporte() {
		return this.esNumReporte;
	}

	public void setEsNumReporte(String esNumReporte) {
		this.esNumReporte = esNumReporte;
	}

	public String getEsNumSiniestro() {
		return this.esNumSiniestro;
	}

	public void setEsNumSiniestro(String esNumSiniestro) {
		this.esNumSiniestro = esNumSiniestro;
	}

	public String getEsObservaciones() {
		return this.esObservaciones;
	}

	public void setEsObservaciones(String esObservaciones) {
		this.esObservaciones = esObservaciones;
	}

	public Integer getEsPregunta1() {
		return this.esPregunta1;
	}

	public void setEsPregunta1(Integer esPregunta1) {
		this.esPregunta1 = esPregunta1;
	}

	public Integer getEsPregunta10() {
		return this.esPregunta10;
	}

	public void setEsPregunta10(Integer esPregunta10) {
		this.esPregunta10 = esPregunta10;
	}

	public Integer getEsPregunta2() {
		return this.esPregunta2;
	}

	public void setEsPregunta2(Integer esPregunta2) {
		this.esPregunta2 = esPregunta2;
	}

	public Integer getEsPregunta3() {
		return this.esPregunta3;
	}

	public void setEsPregunta3(Integer esPregunta3) {
		this.esPregunta3 = esPregunta3;
	}

	public Integer getEsPregunta4() {
		return this.esPregunta4;
	}

	public void setEsPregunta4(Integer esPregunta4) {
		this.esPregunta4 = esPregunta4;
	}

	public Integer getEsPregunta5() {
		return this.esPregunta5;
	}

	public void setEsPregunta5(Integer esPregunta5) {
		this.esPregunta5 = esPregunta5;
	}

	public Integer getEsPregunta6() {
		return this.esPregunta6;
	}

	public void setEsPregunta6(Integer esPregunta6) {
		this.esPregunta6 = esPregunta6;
	}

	public Integer getEsPregunta7() {
		return this.esPregunta7;
	}

	public void setEsPregunta7(Integer esPregunta7) {
		this.esPregunta7 = esPregunta7;
	}

	public Integer getEsPregunta8() {
		return this.esPregunta8;
	}

	public void setEsPregunta8(Integer esPregunta8) {
		this.esPregunta8 = esPregunta8;
	}

	public Integer getEsPregunta9() {
		return this.esPregunta9;
	}

	public void setEsPregunta9(Integer esPregunta9) {
		this.esPregunta9 = esPregunta9;
	}

	public String getEsTelConductor() {
		return this.esTelConductor;
	}

	public void setEsTelConductor(String esTelConductor) {
		this.esTelConductor = esTelConductor;
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