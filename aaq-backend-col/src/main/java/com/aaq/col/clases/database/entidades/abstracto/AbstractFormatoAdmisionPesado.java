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
 public abstract class AbstractFormatoAdmisionPesado extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opAdmisionPesadSEQ", sequenceName = "formato_admision_pesado_seq", allocationSize = 1)
	 @Id
	 @Column(name = "OP_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAdmisionPesadSEQ")
	 private Integer id;

	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;
	
	@Column(name="EMAIL_DEFAULT")
	private String emailDefault;

	@Column(name="OF_FECHA")
	private Timestamp ofFecha;

	@Column(name="OP_ASEGURADO", length=5)
	private String opAsegurado;

	@Column(name="OP_ATENCION_TALLER", length=100)
	private String opAtencionTaller;

	@Column(name="OP_CANTIDAD", precision=126)
	private String opCantidad;

	@Column(name="OP_CLAVE_AJUSTADOR")
	private String opClaveAjustador;

	@Column(name="OP_COLOR_AUTO_AFE", length=20)
	private String opColorAutoAfe;

	@Column(name="OP_COLOR_AUTO_ASE", length=20)
	private String opColorAutoAse;

	@Column(name="OP_CONDUCTOR_AFE", length=100)
	private String opConductorAfe;

	@Column(name="OP_CONDUCTOR_ASE", length=100)
	private String opConductorAse;

	@Column(name="OP_DANIOS_CAJA", length=4000)
	private String opDaniosCaja;

	@Column(name="OP_DANIOS_CAMION", length=4000)
	private String opDaniosCamion;

	@Column(name="OP_DANIOS_TANQUE", length=4000)
	private String opDaniosTanque;

	@Column(name="OP_DED_ADMIN")
	private Integer opDedAdmin;

	@Column(name="OP_DED_DIAS", length=20)
	private String opDedDias;

	@Column(name="OP_DEDUCIBLE")
	private Integer opDeducible;

	@Column(name="OP_DEFINICION", precision=126)
	private String opDefinicion;

	@Column(name="OP_DIR_TALLER", length=50)
	private String opDirTaller;


	@Column(name="OP_FOLIO_ELECTRO", length=20)
	private String opFolioElectro;

	@Column(name="OP_MARCA_AUTO_AFE", length=20)
	private String opMarcaAutoAfe;

	@Column(name="OP_MARCA_AUTO_ASE", length=20)
	private String opMarcaAutoAse;

	@Column(name="OP_MODELO_ASE", length=20)
	private String opModeloAse;

	@Column(name="OP_MODELO_TER", length=20)
	private String opModeloTer;

	@Column(name="OP_MOTOR_AUTO_AFE", length=20)
	private String opMotorAutoAfe;

	@Column(name="OP_MOTOR_AUTO_ASE", length=20)
	private String opMotorAutoAse;

	@Column(name="OP_NOM_AFE", length=100)
	private String opNomAfe;

	@Column(name="OP_NOM_AJUSTADOR", length=100)
	private String opNomAjustador;

	@Column(name="OP_NOM_ASEGURADO", length=100)
	private String opNomAsegurado;

	@Column(name="OP_NOM_TALLER", length=100)
	private String opNomTaller;

	@Column(name="OP_NUM_ENDOSO", length=20)
	private String opNumEndoso;

	@Column(name="OP_NUM_INCISO", length=20)
	private String opNumInciso;

	@Column(name="OP_NUM_POLIZA", length=20)
	private String opNumPoliza;

	@Column(name="OP_NUM_REPORTE", length=20)
	private String opNumReporte;

	@Column(name="OP_NUM_SINIESTRO", length=20)
	private String opNumSiniestro;





	@Column(name="OP_PLACAS_AUTO_AFE", length=20)
	private String opPlacasAutoAfe;

	@Column(name="OP_PLACAS_AUTO_ASE", length=20)
	private String opPlacasAutoAse;

	@Column(name="OP_SERIE_AUTO_AFE", length=20)
	private String opSerieAutoAfe;

	@Column(name="OP_SERIE_AUTO_ASE", length=20)
	private String opSerieAutoAse;

	@Column(name="OP_SINIESTRO_CAJA", length=4000)
	private String opSiniestroCaja;

	@Column(name="OP_SINIESTRO_CAMION", length=4000)
	private String opSiniestroCamion;

	@Column(name="OP_SINIESTRO_TANQUE", length=4000)
	private String opSiniestroTanque;

	@Column(name="OP_SUMA_ASEGURADO", length=20)
	private String opSumaAsegurado;

	@Column(name="OP_TEL_AFE", length=15)
	private String opTelAfe;

	@Column(name="OP_TEL_ASEGURADO", length=15)
	private String opTelAsegurado;

	@Column(name="OP_TEL_CON_AFE", length=15)
	private String opTelConAfe;

	@Column(name="OP_TEL_CON_ASE", length=15)
	private String opTelConAse;

	@Column(name="OP_TEL_TALLER", length=15)
	private String opTelTaller;

	@Column(name="OP_TIPO_AUTO_AFE", length=20)
	private String opTipoAutoAfe;

	@Column(name="OP_TIPO_AUTO_ASE", length=20)
	private String opTipoAutoAse;
	
	@Column(name="OP_EMAIL_TERCERO", length=100)
	private String opEmailTercero;


	@Column(name="OP_TIPO_DEDUCIBLE")
	private Integer opTipoDeducible;

	@Column(name="OP_VIGENCIA")
	private Timestamp opVigencia;
	
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
    
    @Column(name="OP_CODIGO_QR")
	private String opCodigoQr;
    
    @Column(name="OP_PT_EVIDENTE")
   	private Integer opPtEvidente;
   
    
    @Column(name="OP_ABANDONO")
   	private Integer opAbandono;
    
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
	public AbstractFormatoAdmisionPesado() {
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
	 * @return the ofFecha
	 */
	public Timestamp getOfFecha() {
		return ofFecha;
	}







	/**
	 * @param ofFecha the ofFecha to set
	 */
	public void setOfFecha(Timestamp ofFecha) {
		this.ofFecha = ofFecha;
	}







	







	/**
	 * @return the opAsegurado
	 */
	public String getOpAsegurado() {
		return opAsegurado;
	}




	/**
	 * @param opAsegurado the opAsegurado to set
	 */
	public void setOpAsegurado(String opAsegurado) {
		this.opAsegurado = opAsegurado;
	}




	/**
	 * @return the opAtencionTaller
	 */
	public String getOpAtencionTaller() {
		return opAtencionTaller;
	}







	/**
	 * @param opAtencionTaller the opAtencionTaller to set
	 */
	public void setOpAtencionTaller(String opAtencionTaller) {
		this.opAtencionTaller = opAtencionTaller;
	}







	/**
	 * @return the opCantidad
	 */
	public String getOpCantidad() {
		return opCantidad;
	}







	/**
	 * @param opCantidad the opCantidad to set
	 */
	public void setOpCantidad(String opCantidad) {
		this.opCantidad = opCantidad;
	}







	/**
	 * @return the opClaveAjustador
	 */
	public String getOpClaveAjustador() {
		return opClaveAjustador;
	}







	/**
	 * @param opClaveAjustador the opClaveAjustador to set
	 */
	public void setOpClaveAjustador(String opClaveAjustador) {
		this.opClaveAjustador = opClaveAjustador;
	}







	/**
	 * @return the opColorAutoAfe
	 */
	public String getOpColorAutoAfe() {
		return opColorAutoAfe;
	}







	/**
	 * @param opColorAutoAfe the opColorAutoAfe to set
	 */
	public void setOpColorAutoAfe(String opColorAutoAfe) {
		this.opColorAutoAfe = opColorAutoAfe;
	}







	/**
	 * @return the opColorAutoAse
	 */
	public String getOpColorAutoAse() {
		return opColorAutoAse;
	}







	/**
	 * @param opColorAutoAse the opColorAutoAse to set
	 */
	public void setOpColorAutoAse(String opColorAutoAse) {
		this.opColorAutoAse = opColorAutoAse;
	}







	/**
	 * @return the opConductorAfe
	 */
	public String getOpConductorAfe() {
		return opConductorAfe;
	}







	/**
	 * @param opConductorAfe the opConductorAfe to set
	 */
	public void setOpConductorAfe(String opConductorAfe) {
		this.opConductorAfe = opConductorAfe;
	}







	/**
	 * @return the opConductorAse
	 */
	public String getOpConductorAse() {
		return opConductorAse;
	}







	/**
	 * @param opConductorAse the opConductorAse to set
	 */
	public void setOpConductorAse(String opConductorAse) {
		this.opConductorAse = opConductorAse;
	}







	/**
	 * @return the opDaniosCaja
	 */
	public String getOpDaniosCaja() {
		return opDaniosCaja;
	}







	/**
	 * @param opDaniosCaja the opDaniosCaja to set
	 */
	public void setOpDaniosCaja(String opDaniosCaja) {
		this.opDaniosCaja = opDaniosCaja;
	}







	/**
	 * @return the opDaniosCamion
	 */
	public String getOpDaniosCamion() {
		return opDaniosCamion;
	}







	/**
	 * @param opDaniosCamion the opDaniosCamion to set
	 */
	public void setOpDaniosCamion(String opDaniosCamion) {
		this.opDaniosCamion = opDaniosCamion;
	}







	/**
	 * @return the opDaniosTanque
	 */
	public String getOpDaniosTanque() {
		return opDaniosTanque;
	}







	/**
	 * @param opDaniosTanque the opDaniosTanque to set
	 */
	public void setOpDaniosTanque(String opDaniosTanque) {
		this.opDaniosTanque = opDaniosTanque;
	}







	/**
	 * @return the opDedAdmin
	 */
	public Integer getOpDedAdmin() {
		return opDedAdmin;
	}







	/**
	 * @param opDedAdmin the opDedAdmin to set
	 */
	public void setOpDedAdmin(Integer opDedAdmin) {
		this.opDedAdmin = opDedAdmin;
	}







	/**
	 * @return the opDedDias
	 */
	public String getOpDedDias() {
		return opDedDias;
	}







	/**
	 * @param opDedDias the opDedDias to set
	 */
	public void setOpDedDias(String opDedDias) {
		this.opDedDias = opDedDias;
	}







	/**
	 * @return the opDeducible
	 */
	public Integer getOpDeducible() {
		return opDeducible;
	}







	/**
	 * @param opDeducible the opDeducible to set
	 */
	public void setOpDeducible(Integer opDeducible) {
		this.opDeducible = opDeducible;
	}










	/**
	 * @return the opDefinicion
	 */
	public String getOpDefinicion() {
		return opDefinicion;
	}




	/**
	 * @param opDefinicion the opDefinicion to set
	 */
	public void setOpDefinicion(String opDefinicion) {
		this.opDefinicion = opDefinicion;
	}




	/**
	 * @return the opDirTaller
	 */
	public String getOpDirTaller() {
		return opDirTaller;
	}







	/**
	 * @param opDirTaller the opDirTaller to set
	 */
	public void setOpDirTaller(String opDirTaller) {
		this.opDirTaller = opDirTaller;
	}







	







	/**
	 * @return the opFolioElectro
	 */
	public String getOpFolioElectro() {
		return opFolioElectro;
	}







	/**
	 * @param opFolioElectro the opFolioElectro to set
	 */
	public void setOpFolioElectro(String opFolioElectro) {
		this.opFolioElectro = opFolioElectro;
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
	 * @return the opMarcaAutoAfe
	 */
	public String getOpMarcaAutoAfe() {
		return opMarcaAutoAfe;
	}







	/**
	 * @param opMarcaAutoAfe the opMarcaAutoAfe to set
	 */
	public void setOpMarcaAutoAfe(String opMarcaAutoAfe) {
		this.opMarcaAutoAfe = opMarcaAutoAfe;
	}







	/**
	 * @return the opMarcaAutoAse
	 */
	public String getOpMarcaAutoAse() {
		return opMarcaAutoAse;
	}







	/**
	 * @param opMarcaAutoAse the opMarcaAutoAse to set
	 */
	public void setOpMarcaAutoAse(String opMarcaAutoAse) {
		this.opMarcaAutoAse = opMarcaAutoAse;
	}







	/**
	 * @return the opModeloAse
	 */
	public String getOpModeloAse() {
		return opModeloAse;
	}







	/**
	 * @param opModeloAse the opModeloAse to set
	 */
	public void setOpModeloAse(String opModeloAse) {
		this.opModeloAse = opModeloAse;
	}







	/**
	 * @return the opModeloTer
	 */
	public String getOpModeloTer() {
		return opModeloTer;
	}







	/**
	 * @param opModeloTer the opModeloTer to set
	 */
	public void setOpModeloTer(String opModeloTer) {
		this.opModeloTer = opModeloTer;
	}







	/**
	 * @return the opMotorAutoAfe
	 */
	public String getOpMotorAutoAfe() {
		return opMotorAutoAfe;
	}







	/**
	 * @param opMotorAutoAfe the opMotorAutoAfe to set
	 */
	public void setOpMotorAutoAfe(String opMotorAutoAfe) {
		this.opMotorAutoAfe = opMotorAutoAfe;
	}







	/**
	 * @return the opMotorAutoAse
	 */
	public String getOpMotorAutoAse() {
		return opMotorAutoAse;
	}







	/**
	 * @param opMotorAutoAse the opMotorAutoAse to set
	 */
	public void setOpMotorAutoAse(String opMotorAutoAse) {
		this.opMotorAutoAse = opMotorAutoAse;
	}







	/**
	 * @return the opNomAfe
	 */
	public String getOpNomAfe() {
		return opNomAfe;
	}







	/**
	 * @param opNomAfe the opNomAfe to set
	 */
	public void setOpNomAfe(String opNomAfe) {
		this.opNomAfe = opNomAfe;
	}







	/**
	 * @return the opNomAjustador
	 */
	public String getOpNomAjustador() {
		return opNomAjustador;
	}







	/**
	 * @param opNomAjustador the opNomAjustador to set
	 */
	public void setOpNomAjustador(String opNomAjustador) {
		this.opNomAjustador = opNomAjustador;
	}







	/**
	 * @return the opNomAsegurado
	 */
	public String getOpNomAsegurado() {
		return opNomAsegurado;
	}







	/**
	 * @param opNomAsegurado the opNomAsegurado to set
	 */
	public void setOpNomAsegurado(String opNomAsegurado) {
		this.opNomAsegurado = opNomAsegurado;
	}







	/**
	 * @return the opNomTaller
	 */
	public String getOpNomTaller() {
		return opNomTaller;
	}







	/**
	 * @param opNomTaller the opNomTaller to set
	 */
	public void setOpNomTaller(String opNomTaller) {
		this.opNomTaller = opNomTaller;
	}







	/**
	 * @return the opNumEndoso
	 */
	public String getOpNumEndoso() {
		return opNumEndoso;
	}







	/**
	 * @param opNumEndoso the opNumEndoso to set
	 */
	public void setOpNumEndoso(String opNumEndoso) {
		this.opNumEndoso = opNumEndoso;
	}







	/**
	 * @return the opNumInciso
	 */
	public String getOpNumInciso() {
		return opNumInciso;
	}







	/**
	 * @param opNumInciso the opNumInciso to set
	 */
	public void setOpNumInciso(String opNumInciso) {
		this.opNumInciso = opNumInciso;
	}







	/**
	 * @return the opNumPoliza
	 */
	public String getOpNumPoliza() {
		return opNumPoliza;
	}







	/**
	 * @param opNumPoliza the opNumPoliza to set
	 */
	public void setOpNumPoliza(String opNumPoliza) {
		this.opNumPoliza = opNumPoliza;
	}







	/**
	 * @return the opNumReporte
	 */
	public String getOpNumReporte() {
		return opNumReporte;
	}







	/**
	 * @param opNumReporte the opNumReporte to set
	 */
	public void setOpNumReporte(String opNumReporte) {
		this.opNumReporte = opNumReporte;
	}







	/**
	 * @return the opNumSiniestro
	 */
	public String getOpNumSiniestro() {
		return opNumSiniestro;
	}







	/**
	 * @param opNumSiniestro the opNumSiniestro to set
	 */
	public void setOpNumSiniestro(String opNumSiniestro) {
		this.opNumSiniestro = opNumSiniestro;
	}







	/**
	 * @return the opPlacasAutoAfe
	 */
	public String getOpPlacasAutoAfe() {
		return opPlacasAutoAfe;
	}







	/**
	 * @param opPlacasAutoAfe the opPlacasAutoAfe to set
	 */
	public void setOpPlacasAutoAfe(String opPlacasAutoAfe) {
		this.opPlacasAutoAfe = opPlacasAutoAfe;
	}







	/**
	 * @return the opPlacasAutoAse
	 */
	public String getOpPlacasAutoAse() {
		return opPlacasAutoAse;
	}







	/**
	 * @param opPlacasAutoAse the opPlacasAutoAse to set
	 */
	public void setOpPlacasAutoAse(String opPlacasAutoAse) {
		this.opPlacasAutoAse = opPlacasAutoAse;
	}







	/**
	 * @return the opSerieAutoAfe
	 */
	public String getOpSerieAutoAfe() {
		return opSerieAutoAfe;
	}







	/**
	 * @param opSerieAutoAfe the opSerieAutoAfe to set
	 */
	public void setOpSerieAutoAfe(String opSerieAutoAfe) {
		this.opSerieAutoAfe = opSerieAutoAfe;
	}







	/**
	 * @return the opSerieAutoAse
	 */
	public String getOpSerieAutoAse() {
		return opSerieAutoAse;
	}







	/**
	 * @param opSerieAutoAse the opSerieAutoAse to set
	 */
	public void setOpSerieAutoAse(String opSerieAutoAse) {
		this.opSerieAutoAse = opSerieAutoAse;
	}







	/**
	 * @return the opSiniestroCaja
	 */
	public String getOpSiniestroCaja() {
		return opSiniestroCaja;
	}







	/**
	 * @param opSiniestroCaja the opSiniestroCaja to set
	 */
	public void setOpSiniestroCaja(String opSiniestroCaja) {
		this.opSiniestroCaja = opSiniestroCaja;
	}







	/**
	 * @return the opSiniestroCamion
	 */
	public String getOpSiniestroCamion() {
		return opSiniestroCamion;
	}







	/**
	 * @param opSiniestroCamion the opSiniestroCamion to set
	 */
	public void setOpSiniestroCamion(String opSiniestroCamion) {
		this.opSiniestroCamion = opSiniestroCamion;
	}







	/**
	 * @return the opSiniestroTanque
	 */
	public String getOpSiniestroTanque() {
		return opSiniestroTanque;
	}







	/**
	 * @param opSiniestroTanque the opSiniestroTanque to set
	 */
	public void setOpSiniestroTanque(String opSiniestroTanque) {
		this.opSiniestroTanque = opSiniestroTanque;
	}







	/**
	 * @return the opSumaAsegurado
	 */
	public String getOpSumaAsegurado() {
		return opSumaAsegurado;
	}







	/**
	 * @param opSumaAsegurado the opSumaAsegurado to set
	 */
	public void setOpSumaAsegurado(String opSumaAsegurado) {
		this.opSumaAsegurado = opSumaAsegurado;
	}







	/**
	 * @return the opTelAfe
	 */
	public String getOpTelAfe() {
		return opTelAfe;
	}







	/**
	 * @param opTelAfe the opTelAfe to set
	 */
	public void setOpTelAfe(String opTelAfe) {
		this.opTelAfe = opTelAfe;
	}







	/**
	 * @return the opTelAsegurado
	 */
	public String getOpTelAsegurado() {
		return opTelAsegurado;
	}







	/**
	 * @param opTelAsegurado the opTelAsegurado to set
	 */
	public void setOpTelAsegurado(String opTelAsegurado) {
		this.opTelAsegurado = opTelAsegurado;
	}







	/**
	 * @return the opTelConAfe
	 */
	public String getOpTelConAfe() {
		return opTelConAfe;
	}







	/**
	 * @param opTelConAfe the opTelConAfe to set
	 */
	public void setOpTelConAfe(String opTelConAfe) {
		this.opTelConAfe = opTelConAfe;
	}







	/**
	 * @return the opTelConAse
	 */
	public String getOpTelConAse() {
		return opTelConAse;
	}







	/**
	 * @param opTelConAse the opTelConAse to set
	 */
	public void setOpTelConAse(String opTelConAse) {
		this.opTelConAse = opTelConAse;
	}







	/**
	 * @return the opTelTaller
	 */
	public String getOpTelTaller() {
		return opTelTaller;
	}







	/**
	 * @param opTelTaller the opTelTaller to set
	 */
	public void setOpTelTaller(String opTelTaller) {
		this.opTelTaller = opTelTaller;
	}







	/**
	 * @return the opTipoAutoAfe
	 */
	public String getOpTipoAutoAfe() {
		return opTipoAutoAfe;
	}







	/**
	 * @param opTipoAutoAfe the opTipoAutoAfe to set
	 */
	public void setOpTipoAutoAfe(String opTipoAutoAfe) {
		this.opTipoAutoAfe = opTipoAutoAfe;
	}







	/**
	 * @return the opTipoAutoAse
	 */
	public String getOpTipoAutoAse() {
		return opTipoAutoAse;
	}







	/**
	 * @param opTipoAutoAse the opTipoAutoAse to set
	 */
	public void setOpTipoAutoAse(String opTipoAutoAse) {
		this.opTipoAutoAse = opTipoAutoAse;
	}








	/**
	 * @return the opTipoDeducible
	 */
	public Integer getOpTipoDeducible() {
		return opTipoDeducible;
	}







	/**
	 * @param opTipoDeducible the opTipoDeducible to set
	 */
	public void setOpTipoDeducible(Integer opTipoDeducible) {
		this.opTipoDeducible = opTipoDeducible;
	}







	/**
	 * @return the opVigencia
	 */
	public Timestamp getOpVigencia() {
		return opVigencia;
	}







	/**
	 * @param opVigencia the opVigencia to set
	 */
	public void setOpVigencia(Timestamp opVigencia) {
		this.opVigencia = opVigencia;
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
	 * @return the opEmailTercero
	 */
	public String getOpEmailTercero() {
		return opEmailTercero;
	}




	/**
	 * @param opEmailTercero the opEmailTercero to set
	 */
	public void setOpEmailTercero(String opEmailTercero) {
		this.opEmailTercero = opEmailTercero;
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




	public String getOpCodigoQr() {
		return opCodigoQr;
	}




	public void setOpCodigoQr(String opCodigoQr) {
		this.opCodigoQr = opCodigoQr;
	}




	public Integer getOpPtEvidente() {
		return opPtEvidente;
	}




	public void setOpPtEvidente(Integer opPtEvidente) {
		this.opPtEvidente = opPtEvidente;
	}




	public Integer getOpAbandono() {
		return opAbandono;
	}




	public void setOpAbandono(Integer opAbandono) {
		this.opAbandono = opAbandono;
	}




	
	
	
	



}