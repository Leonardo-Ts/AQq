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
 public abstract class AbstractFormatoGarantiaPrendaria extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opGarantiaSEQ", sequenceName = "formato_garantia_prendaria_seq", allocationSize = 1)
	 @Id
	 @Column(name = "GP_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opGarantiaSEQ")
	 private Integer id;
	

	 
	 @Column(name="EMAIL_DEFAULT", length=100)
		private String emailDefault;

		@Column(name="ENVIADO_FTP")
		private Integer enviadoFtp;

		@Column(name="FTP_RESPUESTA", length=255)
		private String ftpRespuesta;

		@Column(name="GP_ASEGURADO", length=5)
		private String gpAsegurado;

		@Column(name="GP_BIENES", length=150)
		private String gpBienes;

		@Column(name="GP_CANTIDAD", length=20)
		private String gpCantidad;

		@Column(name="GP_CANTIDAD_LETRA", length=100)
		private String gpCantidadLetra;

		@Column(name="GP_CLAVE_AJUSTADOR", length=20)
		private String gpClaveAjustador;

		@Column(name="GP_COLOR_AUTO", length=20)
		private String gpColorAuto;

		@Column(name="GP_DIAS", length=20)
		private String gpDias;

		@Column(name="GP_FACTURA", length=50)
		private String gpFactura;

		@Column(name="GP_FACTURA_EXPEDIDA", length=100)
		private String gpFacturaExpedida;

		@Temporal(TemporalType.DATE)
		@Column(name="GP_FACTURA_FECHA")
		private Date gpFacturaFecha;

		@Temporal(TemporalType.DATE)
		@Column(name="GP_FECHA")
		private Date gpFecha;

		@Temporal(TemporalType.DATE)
		@Column(name="GP_FECHA_FIRMA")
		private Date gpFechaFirma;

		@Column(name="GP_MARCA_AUTO", length=50)
		private String gpMarcaAuto;

		@Column(name="GP_MODELO_AUTO", length=50)
		private String gpModeloAuto;

		@Column(name="GP_NOM_ACREEDOR", length=100)
		private String gpNomAcreedor;

		@Column(name="GP_NOM_DEUDOR", length=100)
		private String gpNomDeudor;

		@Column(name="GP_NUM_INCISO", length=20)
		private String gpNumInciso;

		@Column(name="GP_NUM_POLIZA", length=20)
		private String gpNumPoliza;

		@Column(name="GP_NUM_REPORTE", length=255)
		private String gpNumReporte;

		@Column(name="GP_PLACAS_AUTO", length=20)
		private String gpPlacasAuto;

		@Column(name="GP_SR", length=100)
		private String gpSr;

		@Column(name="GP_SR_CALLE", length=100)
		private String gpSrCalle;

		@Column(name="GP_SR_CIUDAD", length=100)
		private String gpSrCiudad;

		@Column(name="GP_SR_COLONIA", length=100)
		private String gpSrColonia;

		@Column(name="GP_SR_CP", length=10)
		private String gpSrCp;

		@Column(name="GP_SR_IDENTIFICACION", length=100)
		private String gpSrIdentificacion;

		@Column(name="GP_SR_MUNICIPIO", length=100)
		private String gpSrMunicipio;

		@Column(name="GP_TIPO_AUTO", length=50)
		private String gpTipoAuto;
		
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
	    
	    @Column(name = "FIRMA_DEUDOR")
		private String firmaDeudor;
	    
	    @Column(name = "FIRMA_ACREEDOR")
		private String firmaAcreedor;

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
	public AbstractFormatoGarantiaPrendaria() {
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
	 * @return the gpAsegurado
	 */
	public String getGpAsegurado() {
		return gpAsegurado;
	}


	/**
	 * @param gpAsegurado the gpAsegurado to set
	 */
	public void setGpAsegurado(String gpAsegurado) {
		this.gpAsegurado = gpAsegurado;
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
	 * @return the gpBienes
	 */
	public String getGpBienes() {
		return gpBienes;
	}












	/**
	 * @param gpBienes the gpBienes to set
	 */
	public void setGpBienes(String gpBienes) {
		this.gpBienes = gpBienes;
	}












	/**
	 * @return the gpCantidad
	 */
	public String getGpCantidad() {
		return gpCantidad;
	}












	/**
	 * @param gpCantidad the gpCantidad to set
	 */
	public void setGpCantidad(String gpCantidad) {
		this.gpCantidad = gpCantidad;
	}












	/**
	 * @return the gpCantidadLetra
	 */
	public String getGpCantidadLetra() {
		return gpCantidadLetra;
	}












	/**
	 * @param gpCantidadLetra the gpCantidadLetra to set
	 */
	public void setGpCantidadLetra(String gpCantidadLetra) {
		this.gpCantidadLetra = gpCantidadLetra;
	}












	/**
	 * @return the gpClaveAjustador
	 */
	public String getGpClaveAjustador() {
		return gpClaveAjustador;
	}












	/**
	 * @param gpClaveAjustador the gpClaveAjustador to set
	 */
	public void setGpClaveAjustador(String gpClaveAjustador) {
		this.gpClaveAjustador = gpClaveAjustador;
	}












	/**
	 * @return the gpColorAuto
	 */
	public String getGpColorAuto() {
		return gpColorAuto;
	}












	/**
	 * @param gpColorAuto the gpColorAuto to set
	 */
	public void setGpColorAuto(String gpColorAuto) {
		this.gpColorAuto = gpColorAuto;
	}












	/**
	 * @return the gpDias
	 */
	public String getGpDias() {
		return gpDias;
	}












	/**
	 * @param gpDias the gpDias to set
	 */
	public void setGpDias(String gpDias) {
		this.gpDias = gpDias;
	}












	/**
	 * @return the gpFactura
	 */
	public String getGpFactura() {
		return gpFactura;
	}












	/**
	 * @param gpFactura the gpFactura to set
	 */
	public void setGpFactura(String gpFactura) {
		this.gpFactura = gpFactura;
	}












	/**
	 * @return the gpFacturaExpedida
	 */
	public String getGpFacturaExpedida() {
		return gpFacturaExpedida;
	}












	/**
	 * @param gpFacturaExpedida the gpFacturaExpedida to set
	 */
	public void setGpFacturaExpedida(String gpFacturaExpedida) {
		this.gpFacturaExpedida = gpFacturaExpedida;
	}












	/**
	 * @return the gpFacturaFecha
	 */
	public Date getGpFacturaFecha() {
		return gpFacturaFecha;
	}












	/**
	 * @param gpFacturaFecha the gpFacturaFecha to set
	 */
	public void setGpFacturaFecha(Date gpFacturaFecha) {
		this.gpFacturaFecha = gpFacturaFecha;
	}












	/**
	 * @return the gpFecha
	 */
	public Date getGpFecha() {
		return gpFecha;
	}












	/**
	 * @param gpFecha the gpFecha to set
	 */
	public void setGpFecha(Date gpFecha) {
		this.gpFecha = gpFecha;
	}












	/**
	 * @return the gpFechaFirma
	 */
	public Date getGpFechaFirma() {
		return gpFechaFirma;
	}












	/**
	 * @param gpFechaFirma the gpFechaFirma to set
	 */
	public void setGpFechaFirma(Date gpFechaFirma) {
		this.gpFechaFirma = gpFechaFirma;
	}












	/**
	 * @return the gpMarcaAuto
	 */
	public String getGpMarcaAuto() {
		return gpMarcaAuto;
	}












	/**
	 * @param gpMarcaAuto the gpMarcaAuto to set
	 */
	public void setGpMarcaAuto(String gpMarcaAuto) {
		this.gpMarcaAuto = gpMarcaAuto;
	}












	/**
	 * @return the gpModeloAuto
	 */
	public String getGpModeloAuto() {
		return gpModeloAuto;
	}












	/**
	 * @param gpModeloAuto the gpModeloAuto to set
	 */
	public void setGpModeloAuto(String gpModeloAuto) {
		this.gpModeloAuto = gpModeloAuto;
	}












	/**
	 * @return the gpNomAcreedor
	 */
	public String getGpNomAcreedor() {
		return gpNomAcreedor;
	}












	/**
	 * @param gpNomAcreedor the gpNomAcreedor to set
	 */
	public void setGpNomAcreedor(String gpNomAcreedor) {
		this.gpNomAcreedor = gpNomAcreedor;
	}












	/**
	 * @return the gpNomDeudor
	 */
	public String getGpNomDeudor() {
		return gpNomDeudor;
	}












	/**
	 * @param gpNomDeudor the gpNomDeudor to set
	 */
	public void setGpNomDeudor(String gpNomDeudor) {
		this.gpNomDeudor = gpNomDeudor;
	}












	/**
	 * @return the gpNumInciso
	 */
	public String getGpNumInciso() {
		return gpNumInciso;
	}












	/**
	 * @param gpNumInciso the gpNumInciso to set
	 */
	public void setGpNumInciso(String gpNumInciso) {
		this.gpNumInciso = gpNumInciso;
	}












	/**
	 * @return the gpNumPoliza
	 */
	public String getGpNumPoliza() {
		return gpNumPoliza;
	}












	/**
	 * @param gpNumPoliza the gpNumPoliza to set
	 */
	public void setGpNumPoliza(String gpNumPoliza) {
		this.gpNumPoliza = gpNumPoliza;
	}












	/**
	 * @return the gpNumReporte
	 */
	public String getGpNumReporte() {
		return gpNumReporte;
	}












	/**
	 * @param gpNumReporte the gpNumReporte to set
	 */
	public void setGpNumReporte(String gpNumReporte) {
		this.gpNumReporte = gpNumReporte;
	}












	/**
	 * @return the gpPlacasAuto
	 */
	public String getGpPlacasAuto() {
		return gpPlacasAuto;
	}












	/**
	 * @param gpPlacasAuto the gpPlacasAuto to set
	 */
	public void setGpPlacasAuto(String gpPlacasAuto) {
		this.gpPlacasAuto = gpPlacasAuto;
	}












	/**
	 * @return the gpSr
	 */
	public String getGpSr() {
		return gpSr;
	}












	/**
	 * @param gpSr the gpSr to set
	 */
	public void setGpSr(String gpSr) {
		this.gpSr = gpSr;
	}












	/**
	 * @return the gpSrCalle
	 */
	public String getGpSrCalle() {
		return gpSrCalle;
	}












	/**
	 * @param gpSrCalle the gpSrCalle to set
	 */
	public void setGpSrCalle(String gpSrCalle) {
		this.gpSrCalle = gpSrCalle;
	}












	/**
	 * @return the gpSrCiudad
	 */
	public String getGpSrCiudad() {
		return gpSrCiudad;
	}












	/**
	 * @param gpSrCiudad the gpSrCiudad to set
	 */
	public void setGpSrCiudad(String gpSrCiudad) {
		this.gpSrCiudad = gpSrCiudad;
	}












	/**
	 * @return the gpSrColonia
	 */
	public String getGpSrColonia() {
		return gpSrColonia;
	}












	/**
	 * @param gpSrColonia the gpSrColonia to set
	 */
	public void setGpSrColonia(String gpSrColonia) {
		this.gpSrColonia = gpSrColonia;
	}












	/**
	 * @return the gpSrCp
	 */
	public String getGpSrCp() {
		return gpSrCp;
	}












	/**
	 * @param gpSrCp the gpSrCp to set
	 */
	public void setGpSrCp(String gpSrCp) {
		this.gpSrCp = gpSrCp;
	}












	/**
	 * @return the gpSrIdentificacion
	 */
	public String getGpSrIdentificacion() {
		return gpSrIdentificacion;
	}












	/**
	 * @param gpSrIdentificacion the gpSrIdentificacion to set
	 */
	public void setGpSrIdentificacion(String gpSrIdentificacion) {
		this.gpSrIdentificacion = gpSrIdentificacion;
	}












	/**
	 * @return the gpSrMunicipio
	 */
	public String getGpSrMunicipio() {
		return gpSrMunicipio;
	}












	/**
	 * @param gpSrMunicipio the gpSrMunicipio to set
	 */
	public void setGpSrMunicipio(String gpSrMunicipio) {
		this.gpSrMunicipio = gpSrMunicipio;
	}












	/**
	 * @return the gpTipoAuto
	 */
	public String getGpTipoAuto() {
		return gpTipoAuto;
	}












	/**
	 * @param gpTipoAuto the gpTipoAuto to set
	 */
	public void setGpTipoAuto(String gpTipoAuto) {
		this.gpTipoAuto = gpTipoAuto;
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
	 * @return the firmaDeudor
	 */
	public String getFirmaDeudor() {
		return firmaDeudor;
	}












	/**
	 * @param firmaDeudor the firmaDeudor to set
	 */
	public void setFirmaDeudor(String firmaDeudor) {
		this.firmaDeudor = firmaDeudor;
	}












	/**
	 * @return the firmaAcreedor
	 */
	public String getFirmaAcreedor() {
		return firmaAcreedor;
	}












	/**
	 * @param firmaAcreedor the firmaAcreedor to set
	 */
	public void setFirmaAcreedor(String firmaAcreedor) {
		this.firmaAcreedor = firmaAcreedor;
	}












	
	
	









}