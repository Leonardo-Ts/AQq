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
 public abstract class AbstractFormatoReparacionBienesDiversos extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opReparacionBienesDiversoslSEQ", sequenceName = "formato_ReparacionBienesDiversos_seq", allocationSize = 1)
	 @Id
	 @Column(name = "BD_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oReparacionBienesDiversosSEQ")
	 private Integer id;
	
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
    
    
    @Column(name="BD_NUM_REPORTE") private String bdNumReporte; 
	@Column(name="BD_NUM_SINIESTRO") private String bdNumSiniestro;
	@Column(name="BD_NUM_POLIZA") private String bdNumPoliza;
	@Column(name="BD_NUM_ASEGURADO") private String bdNumAsegurado; 
	@Column(name="BD_FECHA") private Date bdFecha ;
	@Column(name="BD_NOMBRE_AFECTADO") private String bdNombreAfectado;
	@Column(name="BD_TEL_AFECTADO") private String bdTelAfectado;
	@Column(name="BD_UBICACION_SINIESTRO") private String bdUbicacionSiniestro ;
	@Column(name="BD_DOMICILIO_SINIESTRO") private String bdDomicilioSiniestro;
	@Column(name="BD_TELEFONO_SINIESTRO") private String bdTelefonoSiniestro;
	@Column(name="BD_UBICACION_RESGUARDO") private String bdUbicacionResguardo;
	@Column(name="BD_DOMICILIO_RESGUARDO") private String bdDomicilioResguardo;
	@Column(name="BD_TELEFONO_RESGUARDO") private String bdTelefonoResguardo;
	@Column(name="BD_RESPONSABLE") private String bdResponsable;
	@Column(name="BD_DANIOS_DIVERSOS") private String bdDaniosDiversos;
	@Column(name="BD_OBSERVACIONES") private String bdObservaciones;
	@Column(name="BD_LONG") private String bdLong;
	@Column(name="BD_ALTO") private String bdAlto;
	@Column(name="BD_ANCHO") private String bdAncho;
	@Column(name="BD_TIPO") private String bdTipo; 
	@Column(name="BD_SERIE") private String bdSerie; 
	@Column(name="BD_TRAMO") private String bdTramo; 
	@Column(name="BD_KM") private String bdKm; 
	@Column(name="BD_DESCRIPCION_DANIOS_CAN") private String bdDescripcionDaniosCan;
	@Column(name="BD_DES_DANIOS_PRE") private String bdDesDaniosPre; 
	@Column(name="BD_MOTIVO") private String bdMotivo; 
	@Column(name="BD_CORREO") private String bdCorreo; 
	@Column(name="BD_NOM_AJUSTADOR") private String bdNomAjustador; 
	@Column(name="BD_CLAVE_AJUSTADOR") private String bdClaveAjustador; 
	@Column(name="BD_NOM_ASEGURADO_TERCERO") private String bdNomAseguradoTercero; 


	@Column(name="ILUSTRACION")
	private String ilustracion; 
	
	@Column(name="FIRMA_AJUSTADOR")
	private String firmaAjustador;
	
	@Column(name="FIRMA_ASEGURADO_TERCERO")
	private String firmaAseguradoTercero;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnviadoFtp() {
		return enviadoFtp;
	}

	public void setEnviadoFtp(Integer enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}

	public String getFtpRespuesta() {
		return ftpRespuesta;
	}

	public void setFtpRespuesta(String ftpRespuesta) {
		this.ftpRespuesta = ftpRespuesta;
	}

	public Integer getEnviadoEmail() {
		return enviadoEmail;
	}

	public void setEnviadoEmail(Integer enviadoEmail) {
		this.enviadoEmail = enviadoEmail;
	}

	public String getMensajeEmail() {
		return mensajeEmail;
	}

	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
	}

	public Integer getProceso() {
		return proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

	public Timestamp getHoraEnvioEmail() {
		return horaEnvioEmail;
	}

	public void setHoraEnvioEmail(Timestamp horaEnvioEmail) {
		this.horaEnvioEmail = horaEnvioEmail;
	}

	public Timestamp getHoraEnvioSftp() {
		return horaEnvioSftp;
	}

	public void setHoraEnvioSftp(Timestamp horaEnvioSftp) {
		this.horaEnvioSftp = horaEnvioSftp;
	}

	public String getNodoEnvio() {
		return nodoEnvio;
	}

	public void setNodoEnvio(String nodoEnvio) {
		this.nodoEnvio = nodoEnvio;
	}

	public Integer getCheck1() {
		return check1;
	}

	public void setCheck1(Integer check1) {
		this.check1 = check1;
	}

	public Integer getCheck2() {
		return check2;
	}

	public void setCheck2(Integer check2) {
		this.check2 = check2;
	}

	public Integer getCheck3() {
		return check3;
	}

	public void setCheck3(Integer check3) {
		this.check3 = check3;
	}

	public Integer getCheck4() {
		return check4;
	}

	public void setCheck4(Integer check4) {
		this.check4 = check4;
	}

	

	public String getBdNumReporte() {
		return bdNumReporte;
	}

	public void setBdNumReporte(String bdNumReporte) {
		this.bdNumReporte = bdNumReporte;
	}

	public String getBdNumSiniestro() {
		return bdNumSiniestro;
	}

	public void setBdNumSiniestro(String bdNumSiniestro) {
		this.bdNumSiniestro = bdNumSiniestro;
	}

	public String getBdNumPoliza() {
		return bdNumPoliza;
	}

	public void setBdNumPoliza(String bdNumPoliza) {
		this.bdNumPoliza = bdNumPoliza;
	}

	public String getBdNumAsegurado() {
		return bdNumAsegurado;
	}

	public void setBdNumAsegurado(String bdNumAsegurado) {
		this.bdNumAsegurado = bdNumAsegurado;
	}

	public Date getBdFecha() {
		return bdFecha;
	}

	public void setBdFecha(Date bdFecha) {
		this.bdFecha = bdFecha;
	}

	public String getBdNombreAfectado() {
		return bdNombreAfectado;
	}

	public void setBdNombreAfectado(String bdNombreAfectado) {
		this.bdNombreAfectado = bdNombreAfectado;
	}

	public String getBdTelAfectado() {
		return bdTelAfectado;
	}

	public void setBdTelAfectado(String bdTelAfectado) {
		this.bdTelAfectado = bdTelAfectado;
	}

	public String getBdUbicacionSiniestro() {
		return bdUbicacionSiniestro;
	}

	public void setBdUbicacionSiniestro(String bdUbicacionSiniestro) {
		this.bdUbicacionSiniestro = bdUbicacionSiniestro;
	}

	public String getBdDomicilioSiniestro() {
		return bdDomicilioSiniestro;
	}

	public void setBdDomicilioSiniestro(String bdDomicilioSiniestro) {
		this.bdDomicilioSiniestro = bdDomicilioSiniestro;
	}

	public String getBdTelefonoSiniestro() {
		return bdTelefonoSiniestro;
	}

	public void setBdTelefonoSiniestro(String bdTelefonoSiniestro) {
		this.bdTelefonoSiniestro = bdTelefonoSiniestro;
	}

	public String getBdUbicacionResguardo() {
		return bdUbicacionResguardo;
	}

	public void setBdUbicacionResguardo(String bdUbicacionResguardo) {
		this.bdUbicacionResguardo = bdUbicacionResguardo;
	}

	public String getBdDomicilioResguardo() {
		return bdDomicilioResguardo;
	}

	public void setBdDomicilioResguardo(String bdDomicilioResguardo) {
		this.bdDomicilioResguardo = bdDomicilioResguardo;
	}

	public String getBdTelefonoResguardo() {
		return bdTelefonoResguardo;
	}

	public void setBdTelefonoResguardo(String bdTelefonoResguardo) {
		this.bdTelefonoResguardo = bdTelefonoResguardo;
	}

	public String getBdDaniosDiversos() {
		return bdDaniosDiversos;
	}

	public void setBdDaniosDiversos(String bdDaniosDiversos) {
		this.bdDaniosDiversos = bdDaniosDiversos;
	}

	public String getBdObservaciones() {
		return bdObservaciones;
	}

	public void setBdObservaciones(String bdObservaciones) {
		this.bdObservaciones = bdObservaciones;
	}

	public String getBdLong() {
		return bdLong;
	}

	public void setBdLong(String bdLong) {
		this.bdLong = bdLong;
	}

	public String getBdAlto() {
		return bdAlto;
	}

	public void setBdAlto(String bdAlto) {
		this.bdAlto = bdAlto;
	}

	public String getBdAncho() {
		return bdAncho;
	}

	public void setBdAncho(String bdAncho) {
		this.bdAncho = bdAncho;
	}

	public String getBdTipo() {
		return bdTipo;
	}

	public void setBdTipo(String bdTipo) {
		this.bdTipo = bdTipo;
	}

	public String getBdSerie() {
		return bdSerie;
	}

	public void setBdSerie(String bdSerie) {
		this.bdSerie = bdSerie;
	}

	public String getBdTramo() {
		return bdTramo;
	}

	public void setBdTramo(String bdTramo) {
		this.bdTramo = bdTramo;
	}

	public String getBdKm() {
		return bdKm;
	}

	public void setBdKm(String bdKm) {
		this.bdKm = bdKm;
	}

	public String getBdDescripcionDaniosCan() {
		return bdDescripcionDaniosCan;
	}

	public void setBdDescripcionDaniosCan(String bdDescripcionDaniosCan) {
		this.bdDescripcionDaniosCan = bdDescripcionDaniosCan;
	}

	

	public String getBdDesDaniosPre() {
		return bdDesDaniosPre;
	}

	public void setBdDesDaniosPre(String bdDesDaniosPre) {
		this.bdDesDaniosPre = bdDesDaniosPre;
	}

	

	public String getBdResponsable() {
		return bdResponsable;
	}

	public void setBdResponsable(String bdResponsable) {
		this.bdResponsable = bdResponsable;
	}

	public String getBdMotivo() {
		return bdMotivo;
	}

	public void setBdMotivo(String bdMotivo) {
		this.bdMotivo = bdMotivo;
	}

	public String getBdCorreo() {
		return bdCorreo;
	}

	public void setBdCorreo(String bdCorreo) {
		this.bdCorreo = bdCorreo;
	}

	public String getBdNomAjustador() {
		return bdNomAjustador;
	}

	public void setBdNomAjustador(String bdNomAjustador) {
		this.bdNomAjustador = bdNomAjustador;
	}

	public String getBdClaveAjustador() {
		return bdClaveAjustador;
	}

	public void setBdClaveAjustador(String bdClaveAjustador) {
		this.bdClaveAjustador = bdClaveAjustador;
	}

	public String getBdNomAseguradoTercero() {
		return bdNomAseguradoTercero;
	}

	public void setBdNomAseguradoTercero(String bdNomAseguradoTercero) {
		this.bdNomAseguradoTercero = bdNomAseguradoTercero;
	}

	public String getIlustracion() {
		return ilustracion;
	}

	public void setIlustracion(String ilustracion) {
		this.ilustracion = ilustracion;
	}

	public String getFirmaAjustador() {
		return firmaAjustador;
	}

	public void setFirmaAjustador(String firmaAjustador) {
		this.firmaAjustador = firmaAjustador;
	}

	public String getFirmaAseguradoTercero() {
		return firmaAseguradoTercero;
	}

	public void setFirmaAseguradoTercero(String firmaAseguradoTercero) {
		this.firmaAseguradoTercero = firmaAseguradoTercero;
	} 
	
	

	

 }

