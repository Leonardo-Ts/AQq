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
 public abstract class AbstractFormatoSolicitudDiagnostico extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "sdSolicitudDiagnosticoSEQ", sequenceName = "formato_solicitud_diagnostico_seq", allocationSize = 1)
	 @Id
	 @Column(name = "SD_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opSolicitudDiagnosticoSEQ")
	 private Integer id;
	
	
	@Column(name="SD_NUM_REPORTE", length=30)
	private String sdNumReporte;
	
	@Column(name="SD_FECHA")
	private Timestamp sdFecha;

	

	@Column(name="SD_NUM_POLIZA", length=20)
	private String sdNumPoliza;

	@Column(name="SD_NUM_ENDOSO", length=20)
	private String sdNumEndoso;

	@Column(name="SD_NUM_INCISO", length=20)
	private String sdNumInciso;

	@Column(name="SD_NUM_SINIESTRO")
	private String sdNumSiniestro;

	@Column(name="SD_NOM_CLIENTE", length=200)
	private String sdNomCliente;

	@Column(name="SD_EMAIL_CLIENTE", length=50)
	private String sdEmailCliente;

	@Column(name="SD_TEL_CLIENTE", length=15)
	private String sdTelCliente;

	@Column(name="SD_RAZON_ENVIO")
	private String sdRazonEnvio;

	@Column(name="SD_RAZON_RESPONSABLE")
	private String sdRazonResponsable;

	@Column(name="SD_RAZON_TELEFONO")
	private String sdRazonTelefono;

	@Column(name="SD_RAZON_DOMICILIO")
	private String sdRazonDomicilio;

	

	@Column(name="SD_RAZON_COBERTURA")
	private String sdRazonCobertura;



	@Column(name="SD_MARCA_AUTO")
	private String sdMarcaAuto;

	@Column(name="SD_TIPO_AUTO")
	private String sdTipoAuto;

	@Column(name="SD_MODELO_AUTO")
	private String sdModeloAuto;

	@Column(name="SD_KILOMETRAJE_AUTO")
	private String sdKilometrajeAuto;

	@Column(name="SD_NUM_SERIE")
	private String sdNumSerie;

	@Column(name="SD_COLOR_AUTO")
	private String sdColorAuto;

	@Column(name="SD_PLACA_AUTO")
	private String sdPlacaAuto;

	@Column(name="SD_TRANSMISION")
	private Integer sdTransmision;

	@Column(name="SD_DANIOS_UNIDAD")
	private String sdDaniosUnidad;

	@Column(name="SD_DESCRIPCION_DANIOS")
	private String sdDescripcionDanios;

	@Column(name="SD_DANIOS_PRE")
	private String sdDaniosPre;

	@Column(name="SD_NOM_AJUSTADOR")
	private String sdNomAjustador;

	@Column(name="SD_CLAVE_AJUSTADOR")
	private String sdClaveAjustador;

	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA")
	private String ftpRespuesta;

	@Column(name="ENVIADO_EMAIL")
	private Integer enviadoEmail;

	@Column(name="MENSAJES_EMAIL")
	private String mensajesEmail;

	@Column(name="PROCESO")
	private Integer proceso;

	@Column(name="HORA_ENVIO_EMAIL")
	private Timestamp horaEnvioEmail;

	@Column(name="HORA_ENVIO_SFTP")
	private Timestamp horaEnvioSftp;

	@Column(name="CHECK_1")
	private Integer check1;

	@Column(name="CHECK_2")
	private Integer check2;

	@Column(name="CHECK_3")
	private Integer check3;

	@Column(name="CHECK_4")
	private Integer check4;

	@Column(name="FIRMA_AJUSTADOR")
	private String firmaAJUSTADOR;


	
	@Column(name="FIRMA_ASEGURADO")
	private String firmaAsegurado;
    
    @Column(name="SD_OTRO")
	private String sdOtro;
    
    @Column(name="SD_NIVEL_INUNDACION")
   	private Integer sdNivelInundacion;
    
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
	 * @return the sdNumReporte
	 */
	public String getSdNumReporte() {
		return sdNumReporte;
	}

	/**
	 * @param sdNumReporte the sdNumReporte to set
	 */
	public void setSdNumReporte(String sdNumReporte) {
		this.sdNumReporte = sdNumReporte;
	}

	/**
	 * @return the sdFecha
	 */
	public Timestamp getSdFecha() {
		return sdFecha;
	}

	/**
	 * @param sdFecha the sdFecha to set
	 */
	public void setSdFecha(Timestamp sdFecha) {
		this.sdFecha = sdFecha;
	}

	

	/**
	 * @return the sdNumPoliza
	 */
	public String getSdNumPoliza() {
		return sdNumPoliza;
	}

	/**
	 * @param sdNumPoliza the sdNumPoliza to set
	 */
	public void setSdNumPoliza(String sdNumPoliza) {
		this.sdNumPoliza = sdNumPoliza;
	}

	/**
	 * @return the sdNumEndoso
	 */
	public String getSdNumEndoso() {
		return sdNumEndoso;
	}

	/**
	 * @param sdNumEndoso the sdNumEndoso to set
	 */
	public void setSdNumEndoso(String sdNumEndoso) {
		this.sdNumEndoso = sdNumEndoso;
	}

	/**
	 * @return the sdNumInciso
	 */
	public String getSdNumInciso() {
		return sdNumInciso;
	}

	/**
	 * @param sdNumInciso the sdNumInciso to set
	 */
	public void setSdNumInciso(String sdNumInciso) {
		this.sdNumInciso = sdNumInciso;
	}

	/**
	 * @return the sdNumSiniestro
	 */
	public String getSdNumSiniestro() {
		return sdNumSiniestro;
	}

	/**
	 * @param sdNumSiniestro the sdNumSiniestro to set
	 */
	public void setSdNumSiniestro(String sdNumSiniestro) {
		this.sdNumSiniestro = sdNumSiniestro;
	}

	/**
	 * @return the sdNomCliente
	 */
	public String getSdNomCliente() {
		return sdNomCliente;
	}

	/**
	 * @param sdNomCliente the sdNomCliente to set
	 */
	public void setSdNomCliente(String sdNomCliente) {
		this.sdNomCliente = sdNomCliente;
	}

	/**
	 * @return the sdEmailCliente
	 */
	public String getSdEmailCliente() {
		return sdEmailCliente;
	}

	/**
	 * @param sdEmailCliente the sdEmailCliente to set
	 */
	public void setSdEmailCliente(String sdEmailCliente) {
		this.sdEmailCliente = sdEmailCliente;
	}

	/**
	 * @return the sdTelCliente
	 */
	public String getSdTelCliente() {
		return sdTelCliente;
	}

	/**
	 * @param sdTelCliente the sdTelCliente to set
	 */
	public void setSdTelCliente(String sdTelCliente) {
		this.sdTelCliente = sdTelCliente;
	}

	/**
	 * @return the sdRazonEnvio
	 */
	public String getSdRazonEnvio() {
		return sdRazonEnvio;
	}

	/**
	 * @param sdRazonEnvio the sdRazonEnvio to set
	 */
	public void setSdRazonEnvio(String sdRazonEnvio) {
		this.sdRazonEnvio = sdRazonEnvio;
	}

	/**
	 * @return the sdRazonResponsable
	 */
	public String getSdRazonResponsable() {
		return sdRazonResponsable;
	}

	/**
	 * @param sdRazonResponsable the sdRazonResponsable to set
	 */
	public void setSdRazonResponsable(String sdRazonResponsable) {
		this.sdRazonResponsable = sdRazonResponsable;
	}

	/**
	 * @return the sdRazonTelefono
	 */
	public String getSdRazonTelefono() {
		return sdRazonTelefono;
	}

	/**
	 * @param sdRazonTelefono the sdRazonTelefono to set
	 */
	public void setSdRazonTelefono(String sdRazonTelefono) {
		this.sdRazonTelefono = sdRazonTelefono;
	}

	/**
	 * @return the sdRazonDomicilio
	 */
	public String getSdRazonDomicilio() {
		return sdRazonDomicilio;
	}

	/**
	 * @param sdRazonDomicilio the sdRazonDomicilio to set
	 */
	public void setSdRazonDomicilio(String sdRazonDomicilio) {
		this.sdRazonDomicilio = sdRazonDomicilio;
	}

	/**
	 * @return the sdRazonCobertura
	 */
	public String getSdRazonCobertura() {
		return sdRazonCobertura;
	}

	/**
	 * @param sdRazonCobertura the sdRazonCobertura to set
	 */
	public void setSdRazonCobertura(String sdRazonCobertura) {
		this.sdRazonCobertura = sdRazonCobertura;
	}

	/**
	 * @return the sdMarcaAuto
	 */
	public String getSdMarcaAuto() {
		return sdMarcaAuto;
	}

	/**
	 * @param sdMarcaAuto the sdMarcaAuto to set
	 */
	public void setSdMarcaAuto(String sdMarcaAuto) {
		this.sdMarcaAuto = sdMarcaAuto;
	}

	/**
	 * @return the sdTipoAuto
	 */
	public String getSdTipoAuto() {
		return sdTipoAuto;
	}

	/**
	 * @param sdTipoAuto the sdTipoAuto to set
	 */
	public void setSdTipoAuto(String sdTipoAuto) {
		this.sdTipoAuto = sdTipoAuto;
	}

	/**
	 * @return the sdModeloAuto
	 */
	public String getSdModeloAuto() {
		return sdModeloAuto;
	}

	/**
	 * @param sdModeloAuto the sdModeloAuto to set
	 */
	public void setSdModeloAuto(String sdModeloAuto) {
		this.sdModeloAuto = sdModeloAuto;
	}

	/**
	 * @return the sdKilometrajeAuto
	 */
	public String getSdKilometrajeAuto() {
		return sdKilometrajeAuto;
	}

	/**
	 * @param sdKilometrajeAuto the sdKilometrajeAuto to set
	 */
	public void setSdKilometrajeAuto(String sdKilometrajeAuto) {
		this.sdKilometrajeAuto = sdKilometrajeAuto;
	}

	/**
	 * @return the sdNumSerie
	 */
	public String getSdNumSerie() {
		return sdNumSerie;
	}

	/**
	 * @param sdNumSerie the sdNumSerie to set
	 */
	public void setSdNumSerie(String sdNumSerie) {
		this.sdNumSerie = sdNumSerie;
	}

	/**
	 * @return the sdColorAuto
	 */
	public String getSdColorAuto() {
		return sdColorAuto;
	}

	/**
	 * @param sdColorAuto the sdColorAuto to set
	 */
	public void setSdColorAuto(String sdColorAuto) {
		this.sdColorAuto = sdColorAuto;
	}

	/**
	 * @return the sdPlacaAuto
	 */
	public String getSdPlacaAuto() {
		return sdPlacaAuto;
	}

	/**
	 * @param sdPlacaAuto the sdPlacaAuto to set
	 */
	public void setSdPlacaAuto(String sdPlacaAuto) {
		this.sdPlacaAuto = sdPlacaAuto;
	}

	/**
	 * @return the sdTransmision
	 */
	public Integer getSdTransmision() {
		return sdTransmision;
	}

	/**
	 * @param sdTransmision the sdTransmision to set
	 */
	public void setSdTransmision(Integer sdTransmision) {
		this.sdTransmision = sdTransmision;
	}

	/**
	 * @return the sdDaniosUnidad
	 */
	public String getSdDaniosUnidad() {
		return sdDaniosUnidad;
	}

	/**
	 * @param sdDaniosUnidad the sdDaniosUnidad to set
	 */
	public void setSdDaniosUnidad(String sdDaniosUnidad) {
		this.sdDaniosUnidad = sdDaniosUnidad;
	}

	/**
	 * @return the sdDescripcionDanios
	 */
	public String getSdDescripcionDanios() {
		return sdDescripcionDanios;
	}

	/**
	 * @param sdDescripcionDanios the sdDescripcionDanios to set
	 */
	public void setSdDescripcionDanios(String sdDescripcionDanios) {
		this.sdDescripcionDanios = sdDescripcionDanios;
	}

	/**
	 * @return the sdDaniosPre
	 */
	public String getSdDaniosPre() {
		return sdDaniosPre;
	}

	/**
	 * @param sdDaniosPre the sdDaniosPre to set
	 */
	public void setSdDaniosPre(String sdDaniosPre) {
		this.sdDaniosPre = sdDaniosPre;
	}

	/**
	 * @return the sdNomAjustador
	 */
	public String getSdNomAjustador() {
		return sdNomAjustador;
	}

	/**
	 * @param sdNomAjustador the sdNomAjustador to set
	 */
	public void setSdNomAjustador(String sdNomAjustador) {
		this.sdNomAjustador = sdNomAjustador;
	}

	/**
	 * @return the sdClaveAjustador
	 */
	public String getSdClaveAjustador() {
		return sdClaveAjustador;
	}

	/**
	 * @param sdClaveAjustador the sdClaveAjustador to set
	 */
	public void setSdClaveAjustador(String sdClaveAjustador) {
		this.sdClaveAjustador = sdClaveAjustador;
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
	 * @return the mensajesEmail
	 */
	public String getMensajesEmail() {
		return mensajesEmail;
	}

	/**
	 * @param mensajesEmail the mensajesEmail to set
	 */
	public void setMensajesEmail(String mensajesEmail) {
		this.mensajesEmail = mensajesEmail;
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
	 * @return the firmaAJUSTADOR
	 */
	public String getFirmaAJUSTADOR() {
		return firmaAJUSTADOR;
	}

	/**
	 * @param firmaAJUSTADOR the firmaAJUSTADOR to set
	 */
	public void setFirmaAJUSTADOR(String firmaAJUSTADOR) {
		this.firmaAJUSTADOR = firmaAJUSTADOR;
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
	 * @return the sdOtro
	 */
	public String getSdOtro() {
		return sdOtro;
	}

	/**
	 * @param sdOtro the sdOtro to set
	 */
	public void setSdOtro(String sdOtro) {
		this.sdOtro = sdOtro;
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
	 * @return the sdNivelInundacion
	 */
	public Integer getSdNivelInundacion() {
		return sdNivelInundacion;
	}

	/**
	 * @param sdNivelInundacion the sdNivelInundacion to set
	 */
	public void setSdNivelInundacion(Integer sdNivelInundacion) {
		this.sdNivelInundacion = sdNivelInundacion;
	}
    
    
    
 }
