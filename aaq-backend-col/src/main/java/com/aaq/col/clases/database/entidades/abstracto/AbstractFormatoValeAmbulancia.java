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


import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractFormatoValeAmbulancia extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opAdmisionSEQ", sequenceName = "orden_pase_admision_seq", allocationSize = 1)
	@Id
	 @Column(name = "VA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAdmisionSEQ")
	private Integer id;
	
	// @Column(name = "usuario", length = 255, nullable = true, unique = false)
	// private String usuario;
	 
	
	 @Column(name="ENVIADO_FTP")
		private Integer enviadoFtp;

		@Column(name="FTP_RESPUESTA", length=255)
		private String respuestaFtp;
		
		@Column(name="EMAIL_DEFAULT")
		private String emailDefault;

		
		

		@Column(name="VA_ASEGURADO", length=5)
		private String vaAsegurado;

		@Column(name="VA_CLAVE_AJUSTADOR", length=20)
		private String vaClaveAjustador;

		@Column(name="VA_DATOS_CONDUCTOR", length=100)
		private String vaDatosConductor;

		@Column(name="VA_DATOS_LESIONADO", length=100)
		private String vaDatosLesionado;

		@Column(name="VA_DIAGNOSTICO", length=100)
		private String vaDiagnostico;

		@Column(name="VA_DIR_PACIENTE", length=100)
		private String vaDirPaciente;

		@Column(name="VA_EDAD_PACIENTE", length=3)
		private String vaEdadPaciente;


		

		@Column(name="VA_FOLIO_ELECTRO", length=20)
		private String vaFolioElectro;

		@Column(name="VA_HORA")
		private Date vaHora;

		@Column(name="VA_HOSPITAL", length=100)
		private String vaHospital;

		@Column(name="VA_LUGAR")
		private String vaLugar;

		@Column(name="VA_NOM_AJUSTADOR", length=100)
		private String vaNomAjustador;

		@Column(name="VA_NOM_PACIENTE", length=100)
		private String vaNomPaciente;

		@Column(name="VA_NOM_RAZON", length=100)
		private String vaNomRazon;

		@Column(name="VA_NUM_ENDOSO", length=20)
		private String vaNumEndoso;

		@Column(name="VA_NUM_INCISO", length=20)
		private String vaNumInciso;

		@Column(name="VA_NUM_POLIZA", length=20)
		private String vaNumPoliza;

		@Column(name="VA_NUM_REPORTE", length=20)
		private String vaNumReporte;

		@Column(name="VA_NUM_SINIESTRO", length=20)
		private String vaNumSiniestro;

		@Column(name="VA_SEXO", length=1)
		private String vaSexo;

		@Column(name="VA_TEL_PACIENTE", length=20)
		private String vaTelPaciente;

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
	    
	    @Column(name = "FIRMA_CONDUCTOR")
		private String firmaConductor;
	    
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

	public AbstractFormatoValeAmbulancia() {
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
	 * @return the respuestaFtp
	 */
	public String getRespuestaFtp() {
		return respuestaFtp;
	}


	/**
	 * @param respuestaFtp the respuestaFtp to set
	 */
	public void setRespuestaFtp(String respuestaFtp) {
		this.respuestaFtp = respuestaFtp;
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
	 * @return the vaAsegurado
	 */
	public String getVaAsegurado() {
		return vaAsegurado;
	}


	/**
	 * @param vaAsegurado the vaAsegurado to set
	 */
	public void setVaAsegurado(String vaAsegurado) {
		this.vaAsegurado = vaAsegurado;
	}







	/**
	 * @return the vaClaveAjustador
	 */
	public String getVaClaveAjustador() {
		return vaClaveAjustador;
	}




	/**
	 * @param vaClaveAjustador the vaClaveAjustador to set
	 */
	public void setVaClaveAjustador(String vaClaveAjustador) {
		this.vaClaveAjustador = vaClaveAjustador;
	}




	/**
	 * @return the vaDatosConductor
	 */
	public String getVaDatosConductor() {
		return vaDatosConductor;
	}




	/**
	 * @param vaDatosConductor the vaDatosConductor to set
	 */
	public void setVaDatosConductor(String vaDatosConductor) {
		this.vaDatosConductor = vaDatosConductor;
	}




	/**
	 * @return the vaDatosLesionado
	 */
	public String getVaDatosLesionado() {
		return vaDatosLesionado;
	}




	/**
	 * @param vaDatosLesionado the vaDatosLesionado to set
	 */
	public void setVaDatosLesionado(String vaDatosLesionado) {
		this.vaDatosLesionado = vaDatosLesionado;
	}




	/**
	 * @return the vaDiagnostico
	 */
	public String getVaDiagnostico() {
		return vaDiagnostico;
	}




	/**
	 * @param vaDiagnostico the vaDiagnostico to set
	 */
	public void setVaDiagnostico(String vaDiagnostico) {
		this.vaDiagnostico = vaDiagnostico;
	}




	/**
	 * @return the vaDirPaciente
	 */
	public String getVaDirPaciente() {
		return vaDirPaciente;
	}




	/**
	 * @param vaDirPaciente the vaDirPaciente to set
	 */
	public void setVaDirPaciente(String vaDirPaciente) {
		this.vaDirPaciente = vaDirPaciente;
	}




	/**
	 * @return the vaEdadPaciente
	 */
	public String getVaEdadPaciente() {
		return vaEdadPaciente;
	}




	/**
	 * @param vaEdadPaciente the vaEdadPaciente to set
	 */
	public void setVaEdadPaciente(String vaEdadPaciente) {
		this.vaEdadPaciente = vaEdadPaciente;
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
	 * @return the vaFolioElectro
	 */
	public String getVaFolioElectro() {
		return vaFolioElectro;
	}




	/**
	 * @param vaFolioElectro the vaFolioElectro to set
	 */
	public void setVaFolioElectro(String vaFolioElectro) {
		this.vaFolioElectro = vaFolioElectro;
	}




	/**
	 * @return the vaHora
	 */
	public Date getVaHora() {
		return vaHora;
	}




	/**
	 * @param vaHora the vaHora to set
	 */
	public void setVaHora(Date vaHora) {
		this.vaHora = vaHora;
	}




	/**
	 * @return the vaHospital
	 */
	public String getVaHospital() {
		return vaHospital;
	}




	/**
	 * @param vaHospital the vaHospital to set
	 */
	public void setVaHospital(String vaHospital) {
		this.vaHospital = vaHospital;
	}




	/**
	 * @return the vaLugar
	 */
	public String getVaLugar() {
		return vaLugar;
	}




	/**
	 * @param vaLugar the vaLugar to set
	 */
	public void setVaLugar(String vaLugar) {
		this.vaLugar = vaLugar;
	}




	/**
	 * @return the vaNomAjustador
	 */
	public String getVaNomAjustador() {
		return vaNomAjustador;
	}




	/**
	 * @param vaNomAjustador the vaNomAjustador to set
	 */
	public void setVaNomAjustador(String vaNomAjustador) {
		this.vaNomAjustador = vaNomAjustador;
	}




	/**
	 * @return the vaNomPaciente
	 */
	public String getVaNomPaciente() {
		return vaNomPaciente;
	}




	/**
	 * @param vaNomPaciente the vaNomPaciente to set
	 */
	public void setVaNomPaciente(String vaNomPaciente) {
		this.vaNomPaciente = vaNomPaciente;
	}




	/**
	 * @return the vaNomRazon
	 */
	public String getVaNomRazon() {
		return vaNomRazon;
	}




	/**
	 * @param vaNomRazon the vaNomRazon to set
	 */
	public void setVaNomRazon(String vaNomRazon) {
		this.vaNomRazon = vaNomRazon;
	}




	/**
	 * @return the vaNumEndoso
	 */
	public String getVaNumEndoso() {
		return vaNumEndoso;
	}




	/**
	 * @param vaNumEndoso the vaNumEndoso to set
	 */
	public void setVaNumEndoso(String vaNumEndoso) {
		this.vaNumEndoso = vaNumEndoso;
	}




	/**
	 * @return the vaNumInciso
	 */
	public String getVaNumInciso() {
		return vaNumInciso;
	}




	/**
	 * @param vaNumInciso the vaNumInciso to set
	 */
	public void setVaNumInciso(String vaNumInciso) {
		this.vaNumInciso = vaNumInciso;
	}




	/**
	 * @return the vaNumPoliza
	 */
	public String getVaNumPoliza() {
		return vaNumPoliza;
	}




	/**
	 * @param vaNumPoliza the vaNumPoliza to set
	 */
	public void setVaNumPoliza(String vaNumPoliza) {
		this.vaNumPoliza = vaNumPoliza;
	}




	/**
	 * @return the vaNumReporte
	 */
	public String getVaNumReporte() {
		return vaNumReporte;
	}




	/**
	 * @param vaNumReporte the vaNumReporte to set
	 */
	public void setVaNumReporte(String vaNumReporte) {
		this.vaNumReporte = vaNumReporte;
	}




	/**
	 * @return the vaNumSiniestro
	 */
	public String getVaNumSiniestro() {
		return vaNumSiniestro;
	}




	/**
	 * @param vaNumSiniestro the vaNumSiniestro to set
	 */
	public void setVaNumSiniestro(String vaNumSiniestro) {
		this.vaNumSiniestro = vaNumSiniestro;
	}




	/**
	 * @return the vaSexo
	 */
	public String getVaSexo() {
		return vaSexo;
	}




	/**
	 * @param vaSexo the vaSexo to set
	 */
	public void setVaSexo(String vaSexo) {
		this.vaSexo = vaSexo;
	}




	/**
	 * @return the vaTelPaciente
	 */
	public String getVaTelPaciente() {
		return vaTelPaciente;
	}




	/**
	 * @param vaTelPaciente the vaTelPaciente to set
	 */
	public void setVaTelPaciente(String vaTelPaciente) {
		this.vaTelPaciente = vaTelPaciente;
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
	 * @return the firmaConductor
	 */
	public String getFirmaConductor() {
		return firmaConductor;
	}







	/**
	 * @param firmaConductor the firmaConductor to set
	 */
	public void setFirmaConductor(String firmaConductor) {
		this.firmaConductor = firmaConductor;
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