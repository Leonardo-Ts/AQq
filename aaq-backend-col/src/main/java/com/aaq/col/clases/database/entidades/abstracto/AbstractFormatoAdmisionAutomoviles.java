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
 public abstract class AbstractFormatoAdmisionAutomoviles extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opAdmisionAutosSEQ", sequenceName = "formato_admision_automoviles_seq", allocationSize = 1)
	 @Id
	 @Column(name = "OA_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAdmisionAutosSEQ")
	 private Integer id;
	
	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;

	@Column(name="OA_ADMIN_DEDUCIBLE")
	private Integer oaAdminDeducible;

	@Column(name="OA_AGRAVAMIENTO", length=100)
	private String oaAgravamiento;

	@Column(name="OA_ASEGURADO", length=5)
	private String oaAsegurado;

	@Column(name="OA_CANTIDAD", precision=126)
	private String oaCantidad;

	@Column(name="OA_CLAVE_AJUSTADOR", length=20)
	private String oaClaveAjustador;

	@Column(name="OA_COLOR_AUTO", length=20)
	private String oaColorAuto;

	@Column(name="OA_DANIOS_PRE")
	private String oaDaniosPre;

	@Column(name="OA_DEDUCIBLE")
	private Integer oaDeducible;

	@Column(name="OA_DESC_DANIOS", length=300)
	private String oaDescDanios;

	@Column(name="OA_EMAIL_CLIENTE", length=50)
	private String oaEmailCliente;

	@Column(name="OA_FECHA")
	private Timestamp oaFecha;

	

	@Column(name="OA_FOLIO_ELECTRO", length=20)
	private String oaFolioElectro;



	@Column(name="OA_KILOMETRAJE", length=10)
	private String oaKilometraje;

	@Column(name="OA_MARCA_AUTO", length=30)
	private String oaMarcaAuto;

	@Column(name="OA_MODELO_AUTO", length=20)
	private String oaModeloAuto;

	@Column(name="OA_NIVEL_INUNDACION")
	private Integer oaNivelInundacion;

	@Column(name="OA_NOM_AJUSTADOR", length=20)
	private String oaNomAjustador;

	@Column(name="OA_NOM_CLIENTE", length=100)
	private String oaNomCliente;

	@Column(name="OA_NUM_ENDOSO", length=20)
	private String oaNumEndoso;

	@Column(name="OA_NUM_INCISO", length=20)
	private String oaNumInciso;

	@Column(name="OA_NUM_POLIZA", length=20)
	private String oaNumPoliza;

	@Column(name="OA_NUM_REPORTE", length=20)
	private String oaNumReporte;

	@Column(name="OA_NUM_SERIE", length=20)
	private String oaNumSerie;

	@Column(name="OA_NUM_SINIESTRO", length=20)
	private String oaNumSiniestro;

	@Column(name="OA_PERDIDA_TOTAL")
	private Integer oaPerdidaTotal;

	@Column(name="OA_PLACA_AUTO", length=20)
	private String oaPlacaAuto;

	@Column(name="OA_PORCENTAJE_DED", precision=126)
	private String oaPorcentajeDed;

	@Column(name="OA_RAZON_COBERTURA", length=100)
	private String oaRazonCobertura;

	@Column(name="OA_RAZON_DOMICILIO", length=100)
	private String oaRazonDomicilio;

	@Column(name="OA_RAZON_ENVIO", length=100)
	private String oaRazonEnvio;

	@Column(name="OA_RAZON_RESPONSABLE", length=100)
	private String oaRazonResponsable;

	@Column(name="OA_RAZON_TELEFONO", length=100)
	private String oaRazonTelefono;

	@Column(name="OA_SUMA_ASEGURADA", precision=126)
	private String oaSumaAsegurada;

	@Column(name="OA_T_MANUAL")
	private Integer oaTManual;

	@Column(name="OA_TEL_CLIENTE", length=15)
	private String oaTelCliente;

	@Column(name="OA_TIPO_AUTO", length=30)
	private String oaTipoAuto;

	@Column(name="OA_TIPO_DEDUCIBLE")
	private Integer oaTipoDeducible;


	
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

    @Column(name="NIU")
	private String niu;
    
    @Column(name="OA_CARRIL_EXPRES")
   	private Integer oaCarrilExpres;

    @Column(name = "OA_DANIO_MENOR")
	private String oaDanioMenor;
    
    @Column(name="OA_PRODUCTO_ESENCIAL")
   	private Integer oaProductoEsencial;
    
    @Column(name="OA_CODIGO_QR")
	private String oaCodigoQr;
    
    @Column(name="OA_PT_EVIDENTE")
   	private Integer oaPtEvidente;
    
    @Column(name="OA_ABANDONO")
   	private Integer oaAbandono;

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






	/** default constructor */
	public AbstractFormatoAdmisionAutomoviles() {
		super();
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
	 * @return the oaAsegurado
	 */
	public String getOaAsegurado() {
		return oaAsegurado;
	}






	/**
	 * @param oaAsegurado the oaAsegurado to set
	 */
	public void setOaAsegurado(String oaAsegurado) {
		this.oaAsegurado = oaAsegurado;
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
	 * @return the oaAdminDeducible
	 */
	public Integer getOaAdminDeducible() {
		return oaAdminDeducible;
	}




	/**
	 * @param oaAdminDeducible the oaAdminDeducible to set
	 */
	public void setOaAdminDeducible(Integer oaAdminDeducible) {
		this.oaAdminDeducible = oaAdminDeducible;
	}




	/**
	 * @return the oaAgravamiento
	 */
	public String getOaAgravamiento() {
		return oaAgravamiento;
	}




	/**
	 * @param oaAgravamiento the oaAgravamiento to set
	 */
	public void setOaAgravamiento(String oaAgravamiento) {
		this.oaAgravamiento = oaAgravamiento;
	}










	/**
	 * @return the oaCantidad
	 */
	public String getOaCantidad() {
		return oaCantidad;
	}






	/**
	 * @param oaCantidad the oaCantidad to set
	 */
	public void setOaCantidad(String oaCantidad) {
		this.oaCantidad = oaCantidad;
	}






	/**
	 * @return the oaClaveAjustador
	 */
	public String getOaClaveAjustador() {
		return oaClaveAjustador;
	}




	/**
	 * @param oaClaveAjustador the oaClaveAjustador to set
	 */
	public void setOaClaveAjustador(String oaClaveAjustador) {
		this.oaClaveAjustador = oaClaveAjustador;
	}




	/**
	 * @return the oaColorAuto
	 */
	public String getOaColorAuto() {
		return oaColorAuto;
	}




	/**
	 * @param oaColorAuto the oaColorAuto to set
	 */
	public void setOaColorAuto(String oaColorAuto) {
		this.oaColorAuto = oaColorAuto;
	}







	/**
	 * @return the oaDaniosPre
	 */
	public String getOaDaniosPre() {
		return oaDaniosPre;
	}






	/**
	 * @param oaDaniosPre the oaDaniosPre to set
	 */
	public void setOaDaniosPre(String oaDaniosPre) {
		this.oaDaniosPre = oaDaniosPre;
	}






	/**
	 * @return the oaDeducible
	 */
	public Integer getOaDeducible() {
		return oaDeducible;
	}




	/**
	 * @param oaDeducible the oaDeducible to set
	 */
	public void setOaDeducible(Integer oaDeducible) {
		this.oaDeducible = oaDeducible;
	}




	/**
	 * @return the oaDescDanios
	 */
	public String getOaDescDanios() {
		return oaDescDanios;
	}




	/**
	 * @param oaDescDanios the oaDescDanios to set
	 */
	public void setOaDescDanios(String oaDescDanios) {
		this.oaDescDanios = oaDescDanios;
	}




	/**
	 * @return the oaEmailCliente
	 */
	public String getOaEmailCliente() {
		return oaEmailCliente;
	}




	/**
	 * @param oaEmailCliente the oaEmailCliente to set
	 */
	public void setOaEmailCliente(String oaEmailCliente) {
		this.oaEmailCliente = oaEmailCliente;
	}




	/**
	 * @return the oaFecha
	 */
	public Timestamp getOaFecha() {
		return oaFecha;
	}




	/**
	 * @param oaFecha the oaFecha to set
	 */
	public void setOaFecha(Timestamp oaFecha) {
		this.oaFecha = oaFecha;
	}






	/**
	 * @return the oaFolioElectro
	 */
	public String getOaFolioElectro() {
		return oaFolioElectro;
	}




	/**
	 * @param oaFolioElectro the oaFolioElectro to set
	 */
	public void setOaFolioElectro(String oaFolioElectro) {
		this.oaFolioElectro = oaFolioElectro;
	}







	/**
	 * @return the oaKilometraje
	 */
	public String getOaKilometraje() {
		return oaKilometraje;
	}




	/**
	 * @param oaKilometraje the oaKilometraje to set
	 */
	public void setOaKilometraje(String oaKilometraje) {
		this.oaKilometraje = oaKilometraje;
	}




	/**
	 * @return the oaMarcaAuto
	 */
	public String getOaMarcaAuto() {
		return oaMarcaAuto;
	}




	/**
	 * @param oaMarcaAuto the oaMarcaAuto to set
	 */
	public void setOaMarcaAuto(String oaMarcaAuto) {
		this.oaMarcaAuto = oaMarcaAuto;
	}




	/**
	 * @return the oaModeloAuto
	 */
	public String getOaModeloAuto() {
		return oaModeloAuto;
	}




	/**
	 * @param oaModeloAuto the oaModeloAuto to set
	 */
	public void setOaModeloAuto(String oaModeloAuto) {
		this.oaModeloAuto = oaModeloAuto;
	}




	/**
	 * @return the oaNivelInundacion
	 */
	public Integer getOaNivelInundacion() {
		return oaNivelInundacion;
	}




	/**
	 * @param oaNivelInundacion the oaNivelInundacion to set
	 */
	public void setOaNivelInundacion(Integer oaNivelInundacion) {
		this.oaNivelInundacion = oaNivelInundacion;
	}




	/**
	 * @return the oaNomAjustador
	 */
	public String getOaNomAjustador() {
		return oaNomAjustador;
	}




	/**
	 * @param oaNomAjustador the oaNomAjustador to set
	 */
	public void setOaNomAjustador(String oaNomAjustador) {
		this.oaNomAjustador = oaNomAjustador;
	}




	/**
	 * @return the oaNomCliente
	 */
	public String getOaNomCliente() {
		return oaNomCliente;
	}




	/**
	 * @param oaNomCliente the oaNomCliente to set
	 */
	public void setOaNomCliente(String oaNomCliente) {
		this.oaNomCliente = oaNomCliente;
	}




	/**
	 * @return the oaNumEndoso
	 */
	public String getOaNumEndoso() {
		return oaNumEndoso;
	}




	/**
	 * @param oaNumEndoso the oaNumEndoso to set
	 */
	public void setOaNumEndoso(String oaNumEndoso) {
		this.oaNumEndoso = oaNumEndoso;
	}




	/**
	 * @return the oaNumInciso
	 */
	public String getOaNumInciso() {
		return oaNumInciso;
	}




	/**
	 * @param oaNumInciso the oaNumInciso to set
	 */
	public void setOaNumInciso(String oaNumInciso) {
		this.oaNumInciso = oaNumInciso;
	}




	/**
	 * @return the oaNumPoliza
	 */
	public String getOaNumPoliza() {
		return oaNumPoliza;
	}




	/**
	 * @param oaNumPoliza the oaNumPoliza to set
	 */
	public void setOaNumPoliza(String oaNumPoliza) {
		this.oaNumPoliza = oaNumPoliza;
	}




	/**
	 * @return the oaNumReporte
	 */
	public String getOaNumReporte() {
		return oaNumReporte;
	}




	/**
	 * @param oaNumReporte the oaNumReporte to set
	 */
	public void setOaNumReporte(String oaNumReporte) {
		this.oaNumReporte = oaNumReporte;
	}




	/**
	 * @return the oaNumSerie
	 */
	public String getOaNumSerie() {
		return oaNumSerie;
	}




	/**
	 * @param oaNumSerie the oaNumSerie to set
	 */
	public void setOaNumSerie(String oaNumSerie) {
		this.oaNumSerie = oaNumSerie;
	}




	/**
	 * @return the oaNumSiniestro
	 */
	public String getOaNumSiniestro() {
		return oaNumSiniestro;
	}




	/**
	 * @param oaNumSiniestro the oaNumSiniestro to set
	 */
	public void setOaNumSiniestro(String oaNumSiniestro) {
		this.oaNumSiniestro = oaNumSiniestro;
	}




	/**
	 * @return the oaPerdidaTotal
	 */
	public Integer getOaPerdidaTotal() {
		return oaPerdidaTotal;
	}




	/**
	 * @param oaPerdidaTotal the oaPerdidaTotal to set
	 */
	public void setOaPerdidaTotal(Integer oaPerdidaTotal) {
		this.oaPerdidaTotal = oaPerdidaTotal;
	}




	/**
	 * @return the oaPlacaAuto
	 */
	public String getOaPlacaAuto() {
		return oaPlacaAuto;
	}




	/**
	 * @param oaPlacaAuto the oaPlacaAuto to set
	 */
	public void setOaPlacaAuto(String oaPlacaAuto) {
		this.oaPlacaAuto = oaPlacaAuto;
	}






	/**
	 * @return the oaPorcentajeDed
	 */
	public String getOaPorcentajeDed() {
		return oaPorcentajeDed;
	}






	/**
	 * @param oaPorcentajeDed the oaPorcentajeDed to set
	 */
	public void setOaPorcentajeDed(String oaPorcentajeDed) {
		this.oaPorcentajeDed = oaPorcentajeDed;
	}






	/**
	 * @return the oaRazonCobertura
	 */
	public String getOaRazonCobertura() {
		return oaRazonCobertura;
	}




	/**
	 * @param oaRazonCobertura the oaRazonCobertura to set
	 */
	public void setOaRazonCobertura(String oaRazonCobertura) {
		this.oaRazonCobertura = oaRazonCobertura;
	}




	/**
	 * @return the oaRazonDomicilio
	 */
	public String getOaRazonDomicilio() {
		return oaRazonDomicilio;
	}




	/**
	 * @param oaRazonDomicilio the oaRazonDomicilio to set
	 */
	public void setOaRazonDomicilio(String oaRazonDomicilio) {
		this.oaRazonDomicilio = oaRazonDomicilio;
	}




	/**
	 * @return the oaRazonEnvio
	 */
	public String getOaRazonEnvio() {
		return oaRazonEnvio;
	}




	/**
	 * @param oaRazonEnvio the oaRazonEnvio to set
	 */
	public void setOaRazonEnvio(String oaRazonEnvio) {
		this.oaRazonEnvio = oaRazonEnvio;
	}




	/**
	 * @return the oaRazonResponsable
	 */
	public String getOaRazonResponsable() {
		return oaRazonResponsable;
	}




	/**
	 * @param oaRazonResponsable the oaRazonResponsable to set
	 */
	public void setOaRazonResponsable(String oaRazonResponsable) {
		this.oaRazonResponsable = oaRazonResponsable;
	}




	/**
	 * @return the oaRazonTelefono
	 */
	public String getOaRazonTelefono() {
		return oaRazonTelefono;
	}




	/**
	 * @param oaRazonTelefono the oaRazonTelefono to set
	 */
	public void setOaRazonTelefono(String oaRazonTelefono) {
		this.oaRazonTelefono = oaRazonTelefono;
	}




	/**
	 * @return the oaSumaAsegurada
	 */
	public String getOaSumaAsegurada() {
		return oaSumaAsegurada;
	}




	/**
	 * @param oaSumaAsegurada the oaSumaAsegurada to set
	 */
	public void setOaSumaAsegurada(String oaSumaAsegurada) {
		this.oaSumaAsegurada = oaSumaAsegurada;
	}




	/**
	 * @return the oaTManual
	 */
	public Integer getOaTManual() {
		return oaTManual;
	}




	/**
	 * @param oaTManual the oaTManual to set
	 */
	public void setOaTManual(Integer oaTManual) {
		this.oaTManual = oaTManual;
	}




	/**
	 * @return the oaTelCliente
	 */
	public String getOaTelCliente() {
		return oaTelCliente;
	}




	/**
	 * @param oaTelCliente the oaTelCliente to set
	 */
	public void setOaTelCliente(String oaTelCliente) {
		this.oaTelCliente = oaTelCliente;
	}




	/**
	 * @return the oaTipoAuto
	 */
	public String getOaTipoAuto() {
		return oaTipoAuto;
	}




	/**
	 * @param oaTipoAuto the oaTipoAuto to set
	 */
	public void setOaTipoAuto(String oaTipoAuto) {
		this.oaTipoAuto = oaTipoAuto;
	}




	/**
	 * @return the oaTipoDeducible
	 */
	public Integer getOaTipoDeducible() {
		return oaTipoDeducible;
	}




	/**
	 * @param oaTipoDeducible the oaTipoDeducible to set
	 */
	public void setOaTipoDeducible(Integer oaTipoDeducible) {
		this.oaTipoDeducible = oaTipoDeducible;
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






	public String getNiu() {
		return niu;
	}






	public void setNiu(String niu) {
		this.niu = niu;
	}






	public Integer getOaCarrilExpres() {
		return oaCarrilExpres;
	}






	public void setOaCarrilExpres(Integer oaCarrilExpres) {
		this.oaCarrilExpres = oaCarrilExpres;
	}






	public String getOaDanioMenor() {
		return oaDanioMenor;
	}






	public void setOaDanioMenor(String oaDanioMenor) {
		this.oaDanioMenor = oaDanioMenor;
	}






	public Integer getOaProductoEsencial() {
		return oaProductoEsencial;
	}






	public void setOaProductoEsencial(Integer oaProductoEsencial) {
		this.oaProductoEsencial = oaProductoEsencial;
	}






	public String getOaCodigoQr() {
		return oaCodigoQr;
	}






	public void setOaCodigoQr(String oaCodigoQr) {
		this.oaCodigoQr = oaCodigoQr;
	}






	public Integer getOaPtEvidente() {
		return oaPtEvidente;
	}






	public void setOaPtEvidente(Integer oaPtEvidente) {
		this.oaPtEvidente = oaPtEvidente;
	}






	public Integer getOaAbandono() {
		return oaAbandono;
	}






	public void setOaAbandono(Integer oaAbandono) {
		this.oaAbandono = oaAbandono;
	}











	
	


 }

