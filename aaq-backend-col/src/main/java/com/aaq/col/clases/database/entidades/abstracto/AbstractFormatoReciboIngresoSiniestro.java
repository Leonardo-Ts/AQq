package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Date;
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
public abstract class AbstractFormatoReciboIngresoSiniestro extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opReciboSiniestroSEQ", sequenceName = "formato_recibo_ingreso_seq", allocationSize = 1)
	@Id
	@Column(name = "RI_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opReciboSiniestroSEQ")
	private Integer id;

	@Column(name = "RI_NUM_SINIESTRO", length = 300)
	private String riNumSiniestro;

	@Column(name = "RI_FOLIO", length = 300)
	private String riFolio;

	@Column(name = "RI_FECHA")
	private Date riFecha;

	@Column(name = "RI_NUM_POLIZA", length = 300)
	private String riNumPoliza;

	@Column(name = "RI_NUM_INCISO", length = 300)
	private String riNumInciso;

	@Column(name = "RI_CLAVE_PROV", length = 300)
	private String riClaveProv;

	@Column(name = "RI_COBERTURA", length = 300)
	private String riCobertura;

	@Column(name = "RI_AJUSTADOR", length = 300)
	private String riAjustador;

	@Column(name = "RI_RECIBIMOS_DE", length = 300)
	private String riRecibimosDe;

	@Column(name = "RI_RFC", length = 300)
	private String riRfc;

	@Column(name = "RI_EMAIL", length = 300)
	private String riEmail;

	@Column(name = "RI_TELEFONO", length = 300)
	private String riTelefono;

	@Column(name = "RI_DOMICILIO", length = 300)
	private String riDomicilio;

	@Column(name = "RI_CANTIDAD", length = 300)
	private String riCantidad;

	@Column(name = "RI_IMPORTE_LETRA", length = 300)
	private String riImporteLetra;

	@Column(name = "RI_CONCEPTO_DE", length = 300)
	private String riConceptoDe;

	@Column(name = "RI_VALORES")
	private Integer riValores;

	@Column(name = "RI_BANCO1", length = 300)
	private String riBanco1;
	@Column(name = "RI_BANCO2", length = 300)
	private String riBanco2;
	@Column(name = "RI_BANCO3")
	private String riBanco3;

	@Column(name = "RI_IMPORTE1", length = 300)
	private String riImporte1;
	@Column(name = "RI_IMPORTE2", length = 300)
	private String riImporte2;
	@Column(name = "RI_IMPORTE3", length = 300)
	private String riImporte3;

	@Column(name = "RI_AUTORIZACION1", length = 300)
	private String riAutorizacion1;
	@Column(name = "RI_AUTORIZACION2", length = 300)
	private String riAutorizacion2;
	@Column(name = "RI_AUTORIZACION3", length = 300)
	private String riAutorizacion3;

	@Column(name = "RI_NUM_TARJETA1", length = 300)
	private String riNumTarjeta1;
	@Column(name = "RI_NUM_TARJETA2", length = 300)
	private String riNumTarjeta2;
	@Column(name = "RI_NUM_TARJETA3", length = 300)
	private String riNumTarjeta3;

	@Column(name = "RI_IMPORTE_TOTAL", length = 300)
	private String riImporteTotal;

	@Column(name = "RI_LUGAR_EXP", length = 300)
	private String riLugarExp;

	@Column(name = "ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name = "FTP_RESPUESTA", length = 255)
	private String ftpRespuesta;

	@Column(name = "ENVIADO_EMAIL")
	private Integer enviadoEmail;

	@Column(name = "MENSAJES_EMAIL", length = 255)
	private String mensajeEmail;

	@Column(name = "PROCESO")
	private Integer proceso;

	@Column(name = "HORA_ENVIO_EMAIL")
	private Timestamp horaEnvioEmail;

	@Column(name = "HORA_ENVIO_Sftp")
	private Timestamp horaEnvioSftp;

	@Column(name = "NODO_ENVIO", length = 255)
	private String nodoEnvio;

	@Column(name = "CHECK_1")
	private Integer check1;

	@Column(name = "CHECK_2")
	private Integer check2;

	@Column(name = "CHECK_3")
	private Integer check3;

	@Column(name = "CHECK_4")
	private Integer check4;

	@Column(name = "RI_FIRMA_AJUSTADOR")
	private String RiFirmaAjustador;

	@Column(name = "RI_FIRMA_ASEGURADO")
	private String RiFirmaAsegurado;

	@Column(name = "RI_FIRMA_TERCERO")
	private String RiFirmaTercero;

	@Column(name = "RI_FIRMA_RECIBIDO")
	private String RiFirmaRecibido;

	@Column(name = "RI_NOM_TERCERO")
	private String RiNomTercero;

	@Column(name = "RI_NOM_ASEGURADO")
	private String RiNomAsegurado;

	@Column(name = "CANCELADO")
	private Integer cancelado;

	@Column(name = "RI_NUM_REPORTE", length = 500)
	private String riNumReporte;

	@Column(name = "RI_NUM_TERCERO")
	private String riNumTercero;

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
	public AbstractFormatoReciboIngresoSiniestro() {
		super();
	}

	public String getRiNumTercero() {
		return riNumTercero;
	}

	public void setRiNumTercero(String riNumTercero) {
		this.riNumTercero = riNumTercero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRiNumSiniestro() {
		return riNumSiniestro;
	}

	public void setRiNumSiniestro(String riNumSiniestro) {
		this.riNumSiniestro = riNumSiniestro;
	}

	public String getRiFolio() {
		return riFolio;
	}

	public void setRiFolio(String riFolio) {
		this.riFolio = riFolio;
	}

	public Date getRiFecha() {
		return riFecha;
	}

	public void setRiFecha(Date riFecha) {
		this.riFecha = riFecha;
	}

	public String getRiNumPoliza() {
		return riNumPoliza;
	}

	public void setRiNumPoliza(String riNumPoliza) {
		this.riNumPoliza = riNumPoliza;
	}

	public String getRiNumInciso() {
		return riNumInciso;
	}

	public void setRiNumInciso(String riNumInciso) {
		this.riNumInciso = riNumInciso;
	}

	public String getRiClaveProv() {
		return riClaveProv;
	}

	public void setRiClaveProv(String riClaveProv) {
		this.riClaveProv = riClaveProv;
	}

	public String getRiCobertura() {
		return riCobertura;
	}

	public void setRiCobertura(String riCobertura) {
		this.riCobertura = riCobertura;
	}

	public String getRiAjustador() {
		return riAjustador;
	}

	public void setRiAjustador(String riAjustador) {
		this.riAjustador = riAjustador;
	}

	public String getRiRecibimosDe() {
		return riRecibimosDe;
	}

	public void setRiRecibimosDe(String riRecibimosDe) {
		this.riRecibimosDe = riRecibimosDe;
	}

	public String getRiRfc() {
		return riRfc;
	}

	public void setRiRfc(String riRfc) {
		this.riRfc = riRfc;
	}

	public String getRiEmail() {
		return riEmail;
	}

	public void setRiEmail(String riEmail) {
		this.riEmail = riEmail;
	}

	public String getRiTelefono() {
		return riTelefono;
	}

	public void setRiTelefono(String riTelefono) {
		this.riTelefono = riTelefono;
	}

	public String getRiDomicilio() {
		return riDomicilio;
	}

	public void setRiDomicilio(String riDomicilio) {
		this.riDomicilio = riDomicilio;
	}

	public String getRiCantidad() {
		return riCantidad;
	}

	public void setRiCantidad(String riCantidad) {
		this.riCantidad = riCantidad;
	}

	public String getRiImporteLetra() {
		return riImporteLetra;
	}

	public void setRiImporteLetra(String riImporteLetra) {
		this.riImporteLetra = riImporteLetra;
	}

	public String getRiConceptoDe() {
		return riConceptoDe;
	}

	public void setRiConceptoDe(String riConceptoDe) {
		this.riConceptoDe = riConceptoDe;
	}

	public Integer getRiValores() {
		return riValores;
	}

	public void setRiValores(Integer riValores) {
		this.riValores = riValores;
	}

	public String getRiBanco1() {
		return riBanco1;
	}

	public void setRiBanco1(String riBanco1) {
		this.riBanco1 = riBanco1;
	}

	public String getRiBanco2() {
		return riBanco2;
	}

	public void setRiBanco2(String riBanco2) {
		this.riBanco2 = riBanco2;
	}

	public String getRiBanco3() {
		return riBanco3;
	}

	public void setRiBanco3(String riBanco3) {
		this.riBanco3 = riBanco3;
	}

	public String getRiImporte1() {
		return riImporte1;
	}

	public void setRiImporte1(String riImporte1) {
		this.riImporte1 = riImporte1;
	}

	public String getRiImporte2() {
		return riImporte2;
	}

	public void setRiImporte2(String riImporte2) {
		this.riImporte2 = riImporte2;
	}

	public String getRiImporte3() {
		return riImporte3;
	}

	public void setRiImporte3(String riImporte3) {
		this.riImporte3 = riImporte3;
	}

	public String getRiAutorizacion1() {
		return riAutorizacion1;
	}

	public void setRiAutorizacion1(String riAutorizacion1) {
		this.riAutorizacion1 = riAutorizacion1;
	}

	public String getRiAutorizacion2() {
		return riAutorizacion2;
	}

	public void setRiAutorizacion2(String riAutorizacion2) {
		this.riAutorizacion2 = riAutorizacion2;
	}

	public String getRiAutorizacion3() {
		return riAutorizacion3;
	}

	public void setRiAutorizacion3(String riAutorizacion3) {
		this.riAutorizacion3 = riAutorizacion3;
	}

	public String getRiNumTarjeta1() {
		return riNumTarjeta1;
	}

	public void setRiNumTarjeta1(String riNumTarjeta1) {
		this.riNumTarjeta1 = riNumTarjeta1;
	}

	public String getRiNumTarjeta2() {
		return riNumTarjeta2;
	}

	public void setRiNumTarjeta2(String riNumTarjeta2) {
		this.riNumTarjeta2 = riNumTarjeta2;
	}

	public String getRiNumTarjeta3() {
		return riNumTarjeta3;
	}

	public void setRiNumTarjeta3(String riNumTarjeta3) {
		this.riNumTarjeta3 = riNumTarjeta3;
	}

	public String getRiImporteTotal() {
		return riImporteTotal;
	}

	public void setRiImporteTotal(String riImporteTotal) {
		this.riImporteTotal = riImporteTotal;
	}

	public String getRiLugarExp() {
		return riLugarExp;
	}

	public void setRiLugarExp(String riLugarExp) {
		this.riLugarExp = riLugarExp;
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

	public String getRiFirmaAjustador() {
		return RiFirmaAjustador;
	}

	public void setRiFirmaAjustador(String riFirmaAjustador) {
		RiFirmaAjustador = riFirmaAjustador;
	}

	public String getRiFirmaAsegurado() {
		return RiFirmaAsegurado;
	}

	public void setRiFirmaAsegurado(String riFirmaAsegurado) {
		RiFirmaAsegurado = riFirmaAsegurado;
	}

	public String getRiFirmaTercero() {
		return RiFirmaTercero;
	}

	public void setRiFirmaTercero(String riFirmaTercero) {
		RiFirmaTercero = riFirmaTercero;
	}

	public String getRiFirmaRecibido() {
		return RiFirmaRecibido;
	}

	public void setRiFirmaRecibido(String riFirmaRecibido) {
		RiFirmaRecibido = riFirmaRecibido;
	}

	public String getRiNomTercero() {
		return RiNomTercero;
	}

	public void setRiNomTercero(String riNomTercero) {
		RiNomTercero = riNomTercero;
	}

	public String getRiNomAsegurado() {
		return RiNomAsegurado;
	}

	public void setRiNomAsegurado(String riNomAsegurado) {
		RiNomAsegurado = riNomAsegurado;
	}

	public Integer getCancelado() {
		return cancelado;
	}

	public void setCancelado(Integer cancelado) {
		this.cancelado = cancelado;
	}

	public String getRiNumReporte() {
		return riNumReporte;
	}

	public void setRiNumReporte(String riNumReporte) {
		this.riNumReporte = riNumReporte;
	}

}
