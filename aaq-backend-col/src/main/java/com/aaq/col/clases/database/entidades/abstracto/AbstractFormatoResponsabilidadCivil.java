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
 public abstract class AbstractFormatoResponsabilidadCivil extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opResponsabilidadCivilSEQ", sequenceName = "formato_responsabilidad_civil_seq", allocationSize = 1)
	 @Id
	 @Column(name = "RC_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oResponsabilidadSEQ")
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
    
  
    
    @Column(name="RC_NUM_REPORTE")
    private String rcNumReporte;
    
	@Column(name="RC_NUM_SINIESTRO")
    private String  rcNumSiniestro;
	
	@Column(name="RC_NUM_POLIZA")
	private String rcNumPoliza;
	
	@Column(name="RC_NUM_ASEGURADO")
	private String rcNumAsegurado;
	
	@Column(name="RC_FECHA_SINIESTRO")
	private Date rcFechaSiniestro;
	
	@Column(name="RC_FOLIO_DUA")
	private String rcFolioDua;
	
	@Column(name="RC_VEHICULO_Q")
	private Integer rcVehiculoQ;
	
	@Column(name="RC_COMPANIA_TRANS_MER")
	private String rcCompaniaTransMer;
	
	@Column(name="RC_REPORTE_VEHICULO")
	private String rcReporteVehiculo; 
	
	@Column(name="RC_NOM_PROPIETARIO")
	private String rcNomPropietario;
	
	@Column(name="RC_TEL_PROPIETARIO")
	private String rcTelPropietario;
	
	@Column(name="RC_CORREO_PROPIETARIO")
	private String rcCorreoPropietario;
	
	@Column(name="RC_NOM_TRANSPORTISTA")
	private String rcNomTransportista;
	 
	@Column(name="RC_TEL_TRANSPORTISTA")
	private String rcTelTransportista;
	
	@Column(name="RC_CORREO_TRANSPORTISTA")
	private String rcCorreoTransportista; 
	
	@Column(name="RC_DIR_SINIESTRO")
	private String rcDirSiniestro;
	
	@Column(name="RC_ENTIDAD_SINIESTRO")
	private String rcEntidadSiniestro;
	
	@Column(name="RC_DIR_RESGUARDO")
	private String rcDirResguardo;
	
	@Column(name="RC_ENTIDAD_RESGUARDO")
	private String rcEntidadResguardo;
	
	@Column(name="RC_RESPONSABLE")
	private String rcResponsable;
	
	@Column(name="RC_ENTIDAD_RESP")
	private String rcEntidadResp;
	
	@Column(name="RC_TEL_RESPONSABLE")
	private String rcTelResponsable;
	
	@Column(name="RC_TIPO_SINIESTRO")
	private Integer rcTipoSiniestro;
	
	@Column(name="RC_NUM_ACTA")
	private String rcNumActa;
	
	@Column(name="RC_DESCRIPCION_VEH")
	private String rcDescripcionVeh;
	
	@Column(name="RC_NOM_OPERADOR")
	private String rcNomOperador;
	
	@Column(name="RC_OPC_EBRIEDAD")
	private Integer rcOpcEbriedad;
	
	@Column(name="RC_OPC_LICENCIA")
	private Integer rcOpcLicencia;
	 
	@Column(name="RC_DICTAMEN")
	private String rcDictamen; 
	
	@Column(name="RC_DESCRIPCION_MERC")
	private String rcDescripcionMerc;
	
	@Column(name="RC_OPC_SEGURO_TRANS")
	private Integer rcOpcSeguroTrans;
	
	@Column(name="RC_NOM_ASEGURADORA")
	private String rcNomAseguradora; 
	
	@Column(name="RC_OPC_INTERVIENE_A")
	private Integer rcOpcIntervieneA;
	
	@Column(name="RC_OPC_TRASPALEO_C")
	private Integer rcOpcTraspaleoC;
	
	@Column(name="RC_FOLIO_CARTA")
	private String rcFolioCarta;
	
	@Column(name="RC_FOLIO_FACTURA")
	private String rcFolioFactura;
	
	@Column(name="RC_FOLIO_REMISION")
	private String rcFolioRemision;
	
	@Column(name="RC_FOLIO_GUIA")
	private String rcFolioGuia;
	
	@Column(name="RC_FOLIO_MAPA")
	private String rcFolioMapa;
	
	@Column(name="RC_INFORME_AJUSTADOR")
	private String rcInformeAjustador;
	
	@Column(name="RC_NOM_AJUSTADOR")
	private String rcNomAjustador;
	
	@Column(name="RC_CLAVE_AJUSTADOR")
	private String rcClaveAjustador;
	
	@Column(name="RC_NOM_ASEGURADO_TERCERO")
	private String rcNomAseguradoTercero;
	
	@Column(name="RC_NOM_ASEGURADO")
	private String rcNomAsegurado;
	
	@Column(name="RC_DOCUMENTOS_REQ")	
	private String rcDocumentosReq;
	
	
	@Column(name="CROQUIS")
	private String croquis;
	
	@Column(name="FIRMA_AJUSTADOR")
	private String firmaAjustador; 
	
	@Column(name="FIRMA_ASEGURADO_TERCERO")
	private String firmaAseguradoTercero; 
	
	@Column(name="FIRMA_ASEGURADO")
	private String firmaAsegurado;
	
	@Column(name="RC_OPC_CARGA_DANIADA")
	private Integer rcOpcCargaDaniada;
	
	@Column(name="RC_PORCENTAJE_APROX")
	private String rcPorcentajeAprox;
	
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

	

	public String getRcNumReporte() {
		return rcNumReporte;
	}

	public void setRcNumReporte(String rcNumReporte) {
		this.rcNumReporte = rcNumReporte;
	}

	public String getRcNumSiniestro() {
		return rcNumSiniestro;
	}

	public void setRcNumSiniestro(String rcNumSiniestro) {
		this.rcNumSiniestro = rcNumSiniestro;
	}

	public String getRcNumPoliza() {
		return rcNumPoliza;
	}

	public void setRcNumPoliza(String rcNumPoliza) {
		this.rcNumPoliza = rcNumPoliza;
	}

	public String getRcNumAsegurado() {
		return rcNumAsegurado;
	}

	public void setRcNumAsegurado(String rcNumAsegurado) {
		this.rcNumAsegurado = rcNumAsegurado;
	}

	public Date getRcFechaSiniestro() {
		return rcFechaSiniestro;
	}

	public void setRcFechaSiniestro(Date rcFechaSiniestro) {
		this.rcFechaSiniestro = rcFechaSiniestro;
	}

	public String getRcFolioDua() {
		return rcFolioDua;
	}

	public void setRcFolioDua(String rcFolioDua) {
		this.rcFolioDua = rcFolioDua;
	}

	public Integer getRcVehiculoQ() {
		return rcVehiculoQ;
	}

	public void setRcVehiculoQ(Integer rcVehiculoQ) {
		this.rcVehiculoQ = rcVehiculoQ;
	}

	public String getRcCompaniaTransMer() {
		return rcCompaniaTransMer;
	}

	public void setRcCompaniaTransMer(String rcCompaniaTransMer) {
		this.rcCompaniaTransMer = rcCompaniaTransMer;
	}

	public String getRcReporteVehiculo() {
		return rcReporteVehiculo;
	}

	public void setRcReporteVehiculo(String rcReporteVehiculo) {
		this.rcReporteVehiculo = rcReporteVehiculo;
	}

	public String getRcNomPropietario() {
		return rcNomPropietario;
	}

	public void setRcNomPropietario(String rcNomPropietario) {
		this.rcNomPropietario = rcNomPropietario;
	}

	public String getRcTelPropietario() {
		return rcTelPropietario;
	}

	public void setRcTelPropietario(String rcTelPropietario) {
		this.rcTelPropietario = rcTelPropietario;
	}

	public String getRcCorreoPropietario() {
		return rcCorreoPropietario;
	}

	public void setRcCorreoPropietario(String rcCorreoPropietario) {
		this.rcCorreoPropietario = rcCorreoPropietario;
	}

	public String getRcNomTransportista() {
		return rcNomTransportista;
	}

	public void setRcNomTransportista(String rcNomTransportista) {
		this.rcNomTransportista = rcNomTransportista;
	}

	public String getRcTelTransportista() {
		return rcTelTransportista;
	}

	public void setRcTelTransportista(String rcTelTransportista) {
		this.rcTelTransportista = rcTelTransportista;
	}

	public String getRcCorreoTransportista() {
		return rcCorreoTransportista;
	}

	public void setRcCorreoTransportista(String rcCorreoTransportista) {
		this.rcCorreoTransportista = rcCorreoTransportista;
	}

	public String getRcDirSiniestro() {
		return rcDirSiniestro;
	}

	public void setRcDirSiniestro(String rcDirSiniestro) {
		this.rcDirSiniestro = rcDirSiniestro;
	}

	public String getRcEntidadSiniestro() {
		return rcEntidadSiniestro;
	}

	public void setRcEntidadSiniestro(String rcEntidadSiniestro) {
		this.rcEntidadSiniestro = rcEntidadSiniestro;
	}

	public String getRcDirResguardo() {
		return rcDirResguardo;
	}

	public void setRcDirResguardo(String rcDirResguardo) {
		this.rcDirResguardo = rcDirResguardo;
	}

	public String getRcEntidadResguardo() {
		return rcEntidadResguardo;
	}

	public void setRcEntidadResguardo(String rcEntidadResguardo) {
		this.rcEntidadResguardo = rcEntidadResguardo;
	}

	public String getRcResponsable() {
		return rcResponsable;
	}

	public void setRcResponsable(String rcResponsable) {
		this.rcResponsable = rcResponsable;
	}

	public String getRcEntidadResp() {
		return rcEntidadResp;
	}

	public void setRcEntidadResp(String rcEntidadResp) {
		this.rcEntidadResp = rcEntidadResp;
	}

	public String getRcTelResponsable() {
		return rcTelResponsable;
	}

	public void setRcTelResponsable(String rcTelResponsable) {
		this.rcTelResponsable = rcTelResponsable;
	}

	public Integer getRcTipoSiniestro() {
		return rcTipoSiniestro;
	}

	public void setRcTipoSiniestro(Integer rcTipoSiniestro) {
		this.rcTipoSiniestro = rcTipoSiniestro;
	}

	
	public String getRcNumActa() {
		return rcNumActa;
	}

	public void setRcNumActa(String rcNumActa) {
		this.rcNumActa = rcNumActa;
	}

	public String getRcDescripcionVeh() {
		return rcDescripcionVeh;
	}

	public void setRcDescripcionVeh(String rcDescripcionVeh) {
		this.rcDescripcionVeh = rcDescripcionVeh;
	}

	public String getRcNomOperador() {
		return rcNomOperador;
	}

	public void setRcNomOperador(String rcNomOperador) {
		this.rcNomOperador = rcNomOperador;
	}

	public Integer getRcOpcEbriedad() {
		return rcOpcEbriedad;
	}

	public void setRcOpcEbriedad(Integer rcOpcEbriedad) {
		this.rcOpcEbriedad = rcOpcEbriedad;
	}

	public Integer getRcOpcLicencia() {
		return rcOpcLicencia;
	}

	public void setRcOpcLicencia(Integer rcOpcLicencia) {
		this.rcOpcLicencia = rcOpcLicencia;
	}

	public String getRcDictamen() {
		return rcDictamen;
	}

	public void setRcDictamen(String rcDictamen) {
		this.rcDictamen = rcDictamen;
	}

	public String getRcDescripcionMerc() {
		return rcDescripcionMerc;
	}

	public void setRcDescripcionMerc(String rcDescripcionMerc) {
		this.rcDescripcionMerc = rcDescripcionMerc;
	}

	public Integer getRcOpcSeguroTrans() {
		return rcOpcSeguroTrans;
	}

	public void setRcOpcSeguroTrans(Integer rcOpcSeguroTrans) {
		this.rcOpcSeguroTrans = rcOpcSeguroTrans;
	}

	public String getRcNomAseguradora() {
		return rcNomAseguradora;
	}

	public void setRcNomAseguradora(String rcNomAseguradora) {
		this.rcNomAseguradora = rcNomAseguradora;
	}

	public Integer getRcOpcIntervieneA() {
		return rcOpcIntervieneA;
	}

	public void setRcOpcIntervieneA(Integer rcOpcIntervieneA) {
		this.rcOpcIntervieneA = rcOpcIntervieneA;
	}

	public Integer getRcOpcTraspaleoC() {
		return rcOpcTraspaleoC;
	}

	public void setRcOpcTraspaleoC(Integer rcOpcTraspaleoC) {
		this.rcOpcTraspaleoC = rcOpcTraspaleoC;
	}

	public String getRcFolioCarta() {
		return rcFolioCarta;
	}

	public void setRcFolioCarta(String rcFolioCarta) {
		this.rcFolioCarta = rcFolioCarta;
	}

	public String getRcFolioFactura() {
		return rcFolioFactura;
	}

	public void setRcFolioFactura(String rcFolioFactura) {
		this.rcFolioFactura = rcFolioFactura;
	}

	public String getRcFolioRemision() {
		return rcFolioRemision;
	}

	public void setRcFolioRemision(String rcFolioRemision) {
		this.rcFolioRemision = rcFolioRemision;
	}

	public String getRcFolioGuia() {
		return rcFolioGuia;
	}

	public void setRcFolioGuia(String rcFolioGuia) {
		this.rcFolioGuia = rcFolioGuia;
	}

	public String getRcFolioMapa() {
		return rcFolioMapa;
	}

	public void setRcFolioMapa(String rcFolioMapa) {
		this.rcFolioMapa = rcFolioMapa;
	}

	public String getRcInformeAjustador() {
		return rcInformeAjustador;
	}

	public void setRcInformeAjustador(String rcInformeAjustador) {
		this.rcInformeAjustador = rcInformeAjustador;
	}

	public String getRcNomAjustador() {
		return rcNomAjustador;
	}

	public void setRcNomAjustador(String rcNomAjustador) {
		this.rcNomAjustador = rcNomAjustador;
	}

	public String getRcClaveAjustador() {
		return rcClaveAjustador;
	}

	public void setRcClaveAjustador(String rcClaveAjustador) {
		this.rcClaveAjustador = rcClaveAjustador;
	}

	public String getRcNomAseguradoTercero() {
		return rcNomAseguradoTercero;
	}

	public void setRcNomAseguradoTercero(String rcNomAseguradoTercero) {
		this.rcNomAseguradoTercero = rcNomAseguradoTercero;
	}

	public String getRcNomAsegurado() {
		return rcNomAsegurado;
	}

	public void setRcNomAsegurado(String rcNomAsegurado) {
		this.rcNomAsegurado = rcNomAsegurado;
	}

	public String getRcDocumentosReq() {
		return rcDocumentosReq;
	}

	public void setRcDocumentosReq(String rcDocumentosReq) {
		this.rcDocumentosReq = rcDocumentosReq;
	}

	public String getCroquis() {
		return croquis;
	}

	public void setCroquis(String croquis) {
		this.croquis = croquis;
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

	public String getFirmaAsegurado() {
		return firmaAsegurado;
	}

	public void setFirmaAsegurado(String firmaAsegurado) {
		this.firmaAsegurado = firmaAsegurado;
	}

	public Integer getRcOpcCargaDaniada() {
		return rcOpcCargaDaniada;
	}

	public void setRcOpcCargaDaniada(Integer rcOpcCargaDaniada) {
		this.rcOpcCargaDaniada = rcOpcCargaDaniada;
	}

	public String getRcPorcentajeAprox() {
		return rcPorcentajeAprox;
	}

	public void setRcPorcentajeAprox(String rcPorcentajeAprox) {
		this.rcPorcentajeAprox = rcPorcentajeAprox;
	}
	
	
	
	
	
	

 }

