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
 public abstract class AbstractFormatoOrdenServicio extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opOrservicioSEQ", sequenceName = "formato_orden_servicio_seq", allocationSize = 1)
	@Id
	 @Column(name = "OS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opOrservicioSEQ")
	private Integer id;
	
	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;

	@Column(name="OS_ANIO_AUTO")
	private String osAnioAuto;

	@Column(name="OS_ASEGURADO", length=5)
	private String osAsegurado;

	@Column(name="OS_CLAVE", length=20)
	private String osClave;

	@Column(name="OS_EDAD_CONDUCTOR", precision=38)
	private Integer osEdadConductor;

	@Column(name="OS_EMAIL_CONDUCTOR", length=100)
	private String osEmailConductor;

	@Temporal(TemporalType.DATE)
	@Column(name="OS_FECHA_ATENCION")
	private Date osFechaAtencion;

	@Column(name="OS_HORA_ARRIBO")
	private Timestamp osHoraArribo;

	@Column(name="OS_HORA_REPORTE")
	private Timestamp osHoraReporte;

	@Column(name="OS_HORA_TERMINO")
	private Timestamp osHoraTermino;

	@Column(name="OS_INFORME_AJUSTADOR", length=500)
	private String osInformeAjustador;

	@Column(name="OS_LUGAR_SERVICIO", length=100)
	private String osLugarServicio;

	@Column(name="OS_MARCA_AUTO", precision=38)
	private String osMarcaAuto;

	@Column(name="OS_MODELO_AUTO")
	private String osModeloAuto;

	@Column(name="OS_NOM_AJUSTADOR", length=100)
	private String osNomAjustador;

	@Column(name="OS_NOM_CONDUCTOR", length=100)
	private String osNomConductor;

	

	@Column(name="OS_NUM_INCISO", length=20)
	private String osNumInciso;

	@Column(name="OS_NUM_REPORTE", length=20)
	private String osNumReporte;

	@Column(name="OS_NUM_SERIE_AUTO", length=30)
	private String osNumSerieAuto;

	@Column(name="OS_NUM_SINIESTRO", length=20)
	private String osNumSiniestro;

	@Column(name="OS_PLACAS_AUTO", length=10)
	private String osPlacasAuto;

	@Column(name="OS_POLIZA", length=20)
	private String osPoliza;

	@Column(name="OS_SEXO_CONDUCTOR", length=1)
	private String osSexoConductor;

	@Column(name="OS_SURTIDO_COMBUSTIBLE", precision=38)
	private Integer osSurtidoCombustible;

	@Column(name="OS_TEL_CONDUCTOR", length=15)
	private String osTelConductor;

	@Column(name="OS_TIPO_AUTO", precision=38)
	private String osTipoAuto;

	@Column(name="OS_TIPO_SERVICIO")
	private Integer osTipoServicio;


	
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
	public AbstractFormatoOrdenServicio() {
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
	 * @return the osAnioAuto
	 */
	public String getOsAnioAuto() {
		return osAnioAuto;
	}




	/**
	 * @param osAnioAuto the osAnioAuto to set
	 */
	public void setOsAnioAuto(String osAnioAuto) {
		this.osAnioAuto = osAnioAuto;
	}








	/**
	 * @return the osAsegurado
	 */
	public String getOsAsegurado() {
		return osAsegurado;
	}




	/**
	 * @param osAsegurado the osAsegurado to set
	 */
	public void setOsAsegurado(String osAsegurado) {
		this.osAsegurado = osAsegurado;
	}




	/**
	 * @return the osClave
	 */
	public String getOsClave() {
		return osClave;
	}




	/**
	 * @param osClave the osClave to set
	 */
	public void setOsClave(String osClave) {
		this.osClave = osClave;
	}




	/**
	 * @return the osEdadConductor
	 */
	public Integer getOsEdadConductor() {
		return osEdadConductor;
	}




	/**
	 * @param osEdadConductor the osEdadConductor to set
	 */
	public void setOsEdadConductor(Integer osEdadConductor) {
		this.osEdadConductor = osEdadConductor;
	}




	/**
	 * @return the osEmailConductor
	 */
	public String getOsEmailConductor() {
		return osEmailConductor;
	}




	/**
	 * @param osEmailConductor the osEmailConductor to set
	 */
	public void setOsEmailConductor(String osEmailConductor) {
		this.osEmailConductor = osEmailConductor;
	}




	/**
	 * @return the osFechaAtencion
	 */
	public Date getOsFechaAtencion() {
		return osFechaAtencion;
	}




	/**
	 * @param osFechaAtencion the osFechaAtencion to set
	 */
	public void setOsFechaAtencion(Date osFechaAtencion) {
		this.osFechaAtencion = osFechaAtencion;
	}




	/**
	 * @return the osHoraArribo
	 */
	public Timestamp getOsHoraArribo() {
		return osHoraArribo;
	}




	/**
	 * @param osHoraArribo the osHoraArribo to set
	 */
	public void setOsHoraArribo(Timestamp osHoraArribo) {
		this.osHoraArribo = osHoraArribo;
	}




	/**
	 * @return the osHoraReporte
	 */
	public Timestamp getOsHoraReporte() {
		return osHoraReporte;
	}




	/**
	 * @param osHoraReporte the osHoraReporte to set
	 */
	public void setOsHoraReporte(Timestamp osHoraReporte) {
		this.osHoraReporte = osHoraReporte;
	}




	/**
	 * @return the osHoraTermino
	 */
	public Timestamp getOsHoraTermino() {
		return osHoraTermino;
	}




	/**
	 * @param osHoraTermino the osHoraTermino to set
	 */
	public void setOsHoraTermino(Timestamp osHoraTermino) {
		this.osHoraTermino = osHoraTermino;
	}




	/**
	 * @return the osInformeAjustador
	 */
	public String getOsInformeAjustador() {
		return osInformeAjustador;
	}




	/**
	 * @param osInformeAjustador the osInformeAjustador to set
	 */
	public void setOsInformeAjustador(String osInformeAjustador) {
		this.osInformeAjustador = osInformeAjustador;
	}




	/**
	 * @return the osLugarServicio
	 */
	public String getOsLugarServicio() {
		return osLugarServicio;
	}




	/**
	 * @param osLugarServicio the osLugarServicio to set
	 */
	public void setOsLugarServicio(String osLugarServicio) {
		this.osLugarServicio = osLugarServicio;
	}




	/**
	 * @return the osMarcaAuto
	 */
	public String getOsMarcaAuto() {
		return osMarcaAuto;
	}




	/**
	 * @param osMarcaAuto the osMarcaAuto to set
	 */
	public void setOsMarcaAuto(String osMarcaAuto) {
		this.osMarcaAuto = osMarcaAuto;
	}




	/**
	 * @return the osModeloAuto
	 */
	public String getOsModeloAuto() {
		return osModeloAuto;
	}




	/**
	 * @param osModeloAuto the osModeloAuto to set
	 */
	public void setOsModeloAuto(String osModeloAuto) {
		this.osModeloAuto = osModeloAuto;
	}




	/**
	 * @return the osNomAjustador
	 */
	public String getOsNomAjustador() {
		return osNomAjustador;
	}




	/**
	 * @param osNomAjustador the osNomAjustador to set
	 */
	public void setOsNomAjustador(String osNomAjustador) {
		this.osNomAjustador = osNomAjustador;
	}




	/**
	 * @return the osNomConductor
	 */
	public String getOsNomConductor() {
		return osNomConductor;
	}




	/**
	 * @param osNomConductor the osNomConductor to set
	 */
	public void setOsNomConductor(String osNomConductor) {
		this.osNomConductor = osNomConductor;
	}








	/**
	 * @return the osNumInciso
	 */
	public String getOsNumInciso() {
		return osNumInciso;
	}




	/**
	 * @param osNumInciso the osNumInciso to set
	 */
	public void setOsNumInciso(String osNumInciso) {
		this.osNumInciso = osNumInciso;
	}




	/**
	 * @return the osNumReporte
	 */
	public String getOsNumReporte() {
		return osNumReporte;
	}




	/**
	 * @param osNumReporte the osNumReporte to set
	 */
	public void setOsNumReporte(String osNumReporte) {
		this.osNumReporte = osNumReporte;
	}




	/**
	 * @return the osNumSerieAuto
	 */
	public String getOsNumSerieAuto() {
		return osNumSerieAuto;
	}




	/**
	 * @param osNumSerieAuto the osNumSerieAuto to set
	 */
	public void setOsNumSerieAuto(String osNumSerieAuto) {
		this.osNumSerieAuto = osNumSerieAuto;
	}




	/**
	 * @return the osNumSiniestro
	 */
	public String getOsNumSiniestro() {
		return osNumSiniestro;
	}




	/**
	 * @param osNumSiniestro the osNumSiniestro to set
	 */
	public void setOsNumSiniestro(String osNumSiniestro) {
		this.osNumSiniestro = osNumSiniestro;
	}




	/**
	 * @return the osPlacasAuto
	 */
	public String getOsPlacasAuto() {
		return osPlacasAuto;
	}




	/**
	 * @param osPlacasAuto the osPlacasAuto to set
	 */
	public void setOsPlacasAuto(String osPlacasAuto) {
		this.osPlacasAuto = osPlacasAuto;
	}




	/**
	 * @return the osPoliza
	 */
	public String getOsPoliza() {
		return osPoliza;
	}




	/**
	 * @param osPoliza the osPoliza to set
	 */
	public void setOsPoliza(String osPoliza) {
		this.osPoliza = osPoliza;
	}




	/**
	 * @return the osSexoConductor
	 */
	public String getOsSexoConductor() {
		return osSexoConductor;
	}




	/**
	 * @param osSexoConductor the osSexoConductor to set
	 */
	public void setOsSexoConductor(String osSexoConductor) {
		this.osSexoConductor = osSexoConductor;
	}




	/**
	 * @return the osSurtidoCombustible
	 */
	public Integer getOsSurtidoCombustible() {
		return osSurtidoCombustible;
	}




	/**
	 * @param osSurtidoCombustible the osSurtidoCombustible to set
	 */
	public void setOsSurtidoCombustible(Integer osSurtidoCombustible) {
		this.osSurtidoCombustible = osSurtidoCombustible;
	}




	/**
	 * @return the osTelConductor
	 */
	public String getOsTelConductor() {
		return osTelConductor;
	}




	/**
	 * @param osTelConductor the osTelConductor to set
	 */
	public void setOsTelConductor(String osTelConductor) {
		this.osTelConductor = osTelConductor;
	}




	/**
	 * @return the osTipoAuto
	 */
	public String getOsTipoAuto() {
		return osTipoAuto;
	}




	/**
	 * @param osTipoAuto the osTipoAuto to set
	 */
	public void setOsTipoAuto(String osTipoAuto) {
		this.osTipoAuto = osTipoAuto;
	}




	/**
	 * @return the osTipoServicio
	 */
	public Integer getOsTipoServicio() {
		return osTipoServicio;
	}




	/**
	 * @param osTipoServicio the osTipoServicio to set
	 */
	public void setOsTipoServicio(Integer osTipoServicio) {
		this.osTipoServicio = osTipoServicio;
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