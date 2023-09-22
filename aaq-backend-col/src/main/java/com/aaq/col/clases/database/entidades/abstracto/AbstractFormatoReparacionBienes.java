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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


 @Access(AccessType.FIELD)
 @MappedSuperclass
 public abstract class AbstractFormatoReparacionBienes extends JMEntidad {

	private static final long serialVersionUID = 5424100084476994606L;

	@SequenceGenerator(name = "opReparacionSEQ", sequenceName = "formato_reparacion_bienes_seq", allocationSize = 1)
	 @Id
	 @Column(name = "RB_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opReparacionSEQ")
	 private Integer id;
	
	@Column(name="RB_ASEGURADO", length=5)
	private String rbAsegurado;

	@Column(name="RB_CAR_MARCA", length=50)
	private String rbCarMarca;

	@Column(name="RB_CAR_MODELO", length=50)
	private String rbCarModelo;

	@Column(name="RB_CLAVE_AJUSTADOR")
	private String rbClaveAjustador;

	@Column(name="RB_CUERPO_A")
	private Integer rbCuerpoA;

	@Column(name="RB_DANIOS", length=4000)
	private String rbDanios;

	@Column(name="RB_DANIOS_PRE")
	private Integer rbDaniosPre;

	@Column(name="RB_DES_DANIOS", length=300)
	private String rbDesDanios;

	@Column(name="RB_DOM_AFECTADO")
	private String rbDomAfectado;

	@Column(name="RB_EMAIL_REPARA", length=50)
	private String rbEmailRepara;
	
	 
	 @Column(name = "FECHA_HORA", nullable = false, unique = true)
	 @Temporal(TemporalType.TIMESTAMP)
	 private java.util.Date fechaHora;
	 
	

     @Column(name = "enviado_ftp", nullable = true, unique = false)
	 private Integer enviadoFtp;
	 
	 @Column(name = "ftp_respuesta", length = 255, nullable = true, unique = false)
	 private String respuestaFtp;
	 
	

		@Column(name="RB_FOLIO_ELECTRO", length=20)
		private String rbFolioElectro;

		

		@Column(name="RB_KM", length=50)
		private String rbKm;

		@Column(name="RB_MATERIAL", length=4000)
		private String rbMaterial;

		@Column(name="RB_MED_ALTO", length=50)
		private String rbMedAlto;

		@Column(name="RB_MED_ANCHO", length=50)
		private String rbMedAncho;

		@Column(name="RB_MED_Long", length=50)
		private String rbMedLong;

		@Column(name="RB_NOM_AFECTADO", length=100)
		private String rbNomAfectado;

		@Column(name="RB_NOM_AJUSTADOR", length=100)
		private String rbNomAjustador;

		@Column(name="RB_NOM_REPARA", length=100)
		private String rbNomRepara;

		@Column(name="RB_NUM_ENDOSO", length=20)
		private String rbNumEndoso;

		@Column(name="RB_NUM_FOTOS", length=4)
		private String rbNumFotos;

		@Column(name="RB_NUM_INCISO", length=20)
		private String rbNumInciso;

		@Column(name="RB_NUM_POLIZA", length=20)
		private String rbNumPoliza;

		@Column(name="RB_NUM_REPORTE", length=20)
		private String rbNumReporte;

		@Column(name="RB_NUM_SINIESTRO", length=20)
		private String rbNumSiniestro;

		@Column(name="RB_OBSERVACIONES", length=180)
		private String rbObservaciones;

		@Column(name="RB_OTROS", length=200)
		private String rbOtros;

		@Column(name="RB_REPRE_AFECTADO", length=100)
		private String rbRepreAfectado;

		@Column(name="RB_TEL_AFECTADO", length=15)
		private String rbTelAfectado;

		@Column(name="RB_TEL_REPARA", length=15)
		private String rbTelRepara;

		
		@Column(name="RB_TRAMO", length=50)
		private String rbTramo;
	 
		@Column(name="RB_NOM_ASEGURADO")
		private String rbNomAsegurado;
		
		@Column(name="RB_MUNICIPIO" )
		private String rbMunicipio;
		
		@Column(name="RB_ESTADO")
		private String rbEstado;
	
		@Column(name="ENVIADO_EMAIL")
		private Integer enviadoEmail;

	    @Column(name="MENSAJES_EMAIL", length=255)
		private String mensajeEmail; 
	    
	    @Column(name="RB_EMAIL_AFECTADO", length=100)
	    private String rbEmailAfectado;
	    
	    
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
	public AbstractFormatoReparacionBienes() {
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
	 * @return the rbAsegurado
	 */
	public String getRbAsegurado() {
		return rbAsegurado;
	}




	/**
	 * @param rbAsegurado the rbAsegurado to set
	 */
	public void setRbAsegurado(String rbAsegurado) {
		this.rbAsegurado = rbAsegurado;
	}




	/**
	 * @return the rbCarMarca
	 */
	public String getRbCarMarca() {
		return rbCarMarca;
	}


	/**
	 * @param rbCarMarca the rbCarMarca to set
	 */
	public void setRbCarMarca(String rbCarMarca) {
		this.rbCarMarca = rbCarMarca;
	}


	/**
	 * @return the rbCarModelo
	 */
	public String getRbCarModelo() {
		return rbCarModelo;
	}


	/**
	 * @param rbCarModelo the rbCarModelo to set
	 */
	public void setRbCarModelo(String rbCarModelo) {
		this.rbCarModelo = rbCarModelo;
	}


	/**
	 * @return the rbClaveAjustador
	 */
	public String getRbClaveAjustador() {
		return rbClaveAjustador;
	}


	/**
	 * @param rbClaveAjustador the rbClaveAjustador to set
	 */
	public void setRbClaveAjustador(String rbClaveAjustador) {
		this.rbClaveAjustador = rbClaveAjustador;
	}


	/**
	 * @return the rbCuerpoA
	 */
	public Integer getRbCuerpoA() {
		return rbCuerpoA;
	}


	/**
	 * @param rbCuerpoA the rbCuerpoA to set
	 */
	public void setRbCuerpoA(Integer rbCuerpoA) {
		this.rbCuerpoA = rbCuerpoA;
	}


	/**
	 * @return the rbDanios
	 */
	public String getRbDanios() {
		return rbDanios;
	}


	/**
	 * @param rbDanios the rbDanios to set
	 */
	public void setRbDanios(String rbDanios) {
		this.rbDanios = rbDanios;
	}


	/**
	 * @return the rbDaniosPre
	 */
	public Integer getRbDaniosPre() {
		return rbDaniosPre;
	}


	/**
	 * @param rbDaniosPre the rbDaniosPre to set
	 */
	public void setRbDaniosPre(Integer rbDaniosPre) {
		this.rbDaniosPre = rbDaniosPre;
	}


	/**
	 * @return the rbDesDanios
	 */
	public String getRbDesDanios() {
		return rbDesDanios;
	}


	/**
	 * @param rbDesDanios the rbDesDanios to set
	 */
	public void setRbDesDanios(String rbDesDanios) {
		this.rbDesDanios = rbDesDanios;
	}


	/**
	 * @return the rbDomAfectado
	 */
	public String getRbDomAfectado() {
		return rbDomAfectado;
	}


	/**
	 * @param rbDomAfectado the rbDomAfectado to set
	 */
	public void setRbDomAfectado(String rbDomAfectado) {
		this.rbDomAfectado = rbDomAfectado;
	}


	/**
	 * @return the rbEmailRepara
	 */
	public String getRbEmailRepara() {
		return rbEmailRepara;
	}


	/**
	 * @param rbEmailRepara the rbEmailRepara to set
	 */
	public void setRbEmailRepara(String rbEmailRepara) {
		this.rbEmailRepara = rbEmailRepara;
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
	 * @return the rb_fecha
	 */
	



	



	/**
	 * @return the fechaHora
	 */
	public java.util.Date getFechaHora() {
		return fechaHora;
	}


	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(java.util.Date fechaHora) {
		this.fechaHora = fechaHora;
	}







	/**
	 * @return the rbFolioElectro
	 */
	public String getRbFolioElectro() {
		return rbFolioElectro;
	}


	/**
	 * @param rbFolioElectro the rbFolioElectro to set
	 */
	public void setRbFolioElectro(String rbFolioElectro) {
		this.rbFolioElectro = rbFolioElectro;
	}


	/**
	 * @return the rbHora
	 */
	


	/**
	 * @return the rbKm
	 */
	public String getRbKm() {
		return rbKm;
	}


	/**
	 * @param rbKm the rbKm to set
	 */
	public void setRbKm(String rbKm) {
		this.rbKm = rbKm;
	}


	/**
	 * @return the rbMaterial
	 */
	public String getRbMaterial() {
		return rbMaterial;
	}


	/**
	 * @param rbMaterial the rbMaterial to set
	 */
	public void setRbMaterial(String rbMaterial) {
		this.rbMaterial = rbMaterial;
	}


	/**
	 * @return the rbMedAlto
	 */
	public String getRbMedAlto() {
		return rbMedAlto;
	}


	/**
	 * @param rbMedAlto the rbMedAlto to set
	 */
	public void setRbMedAlto(String rbMedAlto) {
		this.rbMedAlto = rbMedAlto;
	}


	/**
	 * @return the rbMedAncho
	 */
	public String getRbMedAncho() {
		return rbMedAncho;
	}


	/**
	 * @param rbMedAncho the rbMedAncho to set
	 */
	public void setRbMedAncho(String rbMedAncho) {
		this.rbMedAncho = rbMedAncho;
	}


	/**
	 * @return the rbMedInteger
	 */
	public String getRbMedLong() {
		return rbMedLong;
	}


	/**
	 * @param rbMedInteger the rbMedInteger to set
	 */
	public void setRbMedLong(String rbMedLong) {
		this.rbMedLong = rbMedLong;
	}


	/**
	 * @return the rbNomAfectado
	 */
	public String getRbNomAfectado() {
		return rbNomAfectado;
	}


	/**
	 * @param rbNomAfectado the rbNomAfectado to set
	 */
	public void setRbNomAfectado(String rbNomAfectado) {
		this.rbNomAfectado = rbNomAfectado;
	}


	/**
	 * @return the rbNomAjustador
	 */
	public String getRbNomAjustador() {
		return rbNomAjustador;
	}


	/**
	 * @param rbNomAjustador the rbNomAjustador to set
	 */
	public void setRbNomAjustador(String rbNomAjustador) {
		this.rbNomAjustador = rbNomAjustador;
	}


	/**
	 * @return the rbNomRepara
	 */
	public String getRbNomRepara() {
		return rbNomRepara;
	}


	/**
	 * @param rbNomRepara the rbNomRepara to set
	 */
	public void setRbNomRepara(String rbNomRepara) {
		this.rbNomRepara = rbNomRepara;
	}


	/**
	 * @return the rbNumEndoso
	 */
	public String getRbNumEndoso() {
		return rbNumEndoso;
	}


	/**
	 * @param rbNumEndoso the rbNumEndoso to set
	 */
	public void setRbNumEndoso(String rbNumEndoso) {
		this.rbNumEndoso = rbNumEndoso;
	}


	/**
	 * @return the rbNumFotos
	 */
	public String getRbNumFotos() {
		return rbNumFotos;
	}


	/**
	 * @param rbNumFotos the rbNumFotos to set
	 */
	public void setRbNumFotos(String rbNumFotos) {
		this.rbNumFotos = rbNumFotos;
	}


	/**
	 * @return the rbNumInciso
	 */
	public String getRbNumInciso() {
		return rbNumInciso;
	}


	/**
	 * @param rbNumInciso the rbNumInciso to set
	 */
	public void setRbNumInciso(String rbNumInciso) {
		this.rbNumInciso = rbNumInciso;
	}


	/**
	 * @return the rbNumPoliza
	 */
	public String getRbNumPoliza() {
		return rbNumPoliza;
	}


	/**
	 * @param rbNumPoliza the rbNumPoliza to set
	 */
	public void setRbNumPoliza(String rbNumPoliza) {
		this.rbNumPoliza = rbNumPoliza;
	}


	/**
	 * @return the rbNumReporte
	 */
	public String getRbNumReporte() {
		return rbNumReporte;
	}


	/**
	 * @param rbNumReporte the rbNumReporte to set
	 */
	public void setRbNumReporte(String rbNumReporte) {
		this.rbNumReporte = rbNumReporte;
	}


	/**
	 * @return the rbNumSiniestro
	 */
	public String getRbNumSiniestro() {
		return rbNumSiniestro;
	}


	/**
	 * @param rbNumSiniestro the rbNumSiniestro to set
	 */
	public void setRbNumSiniestro(String rbNumSiniestro) {
		this.rbNumSiniestro = rbNumSiniestro;
	}


	/**
	 * @return the rbObservaciones
	 */
	public String getRbObservaciones() {
		return rbObservaciones;
	}


	/**
	 * @param rbObservaciones the rbObservaciones to set
	 */
	public void setRbObservaciones(String rbObservaciones) {
		this.rbObservaciones = rbObservaciones;
	}


	/**
	 * @return the rbOtros
	 */
	public String getRbOtros() {
		return rbOtros;
	}


	/**
	 * @param rbOtros the rbOtros to set
	 */
	public void setRbOtros(String rbOtros) {
		this.rbOtros = rbOtros;
	}


	/**
	 * @return the rbRepreAfectado
	 */
	public String getRbRepreAfectado() {
		return rbRepreAfectado;
	}


	/**
	 * @param rbRepreAfectado the rbRepreAfectado to set
	 */
	public void setRbRepreAfectado(String rbRepreAfectado) {
		this.rbRepreAfectado = rbRepreAfectado;
	}


	/**
	 * @return the rbTelAfectado
	 */
	public String getRbTelAfectado() {
		return rbTelAfectado;
	}


	/**
	 * @param rbTelAfectado the rbTelAfectado to set
	 */
	public void setRbTelAfectado(String rbTelAfectado) {
		this.rbTelAfectado = rbTelAfectado;
	}


	/**
	 * @return the rbTelRepara
	 */
	public String getRbTelRepara() {
		return rbTelRepara;
	}


	/**
	 * @param rbTelRepara the rbTelRepara to set
	 */
	public void setRbTelRepara(String rbTelRepara) {
		this.rbTelRepara = rbTelRepara;
	}


	
	

	/**
	 * @return the rbTramo
	 */
	public String getRbTramo() {
		return rbTramo;
	}


	/**
	 * @param rbTramo the rbTramo to set
	 */
	public void setRbTramo(String rbTramo) {
		this.rbTramo = rbTramo;
	}


	
	
	
	/**
	 * @return the rbNomAsegurado
	 */
	public String getRbNomAsegurado() {
		return rbNomAsegurado;
	}









	/**
	 * @param rbNomAsegurado the rbNomAsegurado to set
	 */
	public void setRbNomAsegurado(String rbNomAsegurado) {
		this.rbNomAsegurado = rbNomAsegurado;
	}









	/**
	 * @return the rbMunicipio
	 */
	public String getRbMunicipio() {
		return rbMunicipio;
	}









	/**
	 * @param rbMunicipio the rbMunicipio to set
	 */
	public void setRbMunicipio(String rbMunicipio) {
		this.rbMunicipio = rbMunicipio;
	}









	/**
	 * @return the rbEstado
	 */
	public String getRbEstado() {
		return rbEstado;
	}









	/**
	 * @param rbEstado the rbEstado to set
	 */
	public void setRbEstado(String rbEstado) {
		this.rbEstado = rbEstado;
	}




	/**
	 * @return the rbEmailAfectado
	 */
	public String getRbEmailAfectado() {
		return rbEmailAfectado;
	}




	/**
	 * @param rbEmailAfectado the rbEmailAfectado to set
	 */
	public void setRbEmailAfectado(String rbEmailAfectado) {
		this.rbEmailAfectado = rbEmailAfectado;
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




	
	
	
	








	


}