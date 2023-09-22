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
 public abstract class AbstractFormatoReciboPagoDeducible extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opReciboDeducibleSEQ", sequenceName = "formato_recibo_deducible_seq", allocationSize = 1)
	 
	@Id
	 @Column(name = "RD_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opReciboDeducibleSEQ")
	 private Integer id;
	
	@Column(name="RD_FECHA")
	private Date rdFecha;
	
	@Column(name="RD_VALORES")
	private Integer rdValores;
    
	@Column(name="RD_NUM_SINIESTRO", length=300)
	private String rdNumSiniestro;
	
	@Column(name="RD_NUM_REPORTE", length=300)
	private String rdNumReporte;
	
	@Column(name="RD_FOLIO", length=300)
	private String rdFolio;
	

	@Column(name="RD_NUM_POLIZA", length=300)
	private String rdNumPoliza;

	@Column(name="RD_NUM_INCISO", length=300)
	private String rdNumInciso;
	

	@Column(name="RD_CLAVE", length=300)
	private String rdClave;
	

	@Column(name="RD_AJUSTADOR", length=300)
	private String rdAjustador;
	

	@Column(name="RD_RECIBIMOS_DE", length=300)
	private String rdRecibimosDe;
	

	@Column(name="RD_RFC", length=300)
	private String rdRfc;
	

	@Column(name="RD_EMAIL", length=300)
	private String rdEmail;
	

	@Column(name="RD_TELEFONO", length=300)
	private String rdTelefono;
	

	@Column(name="RD_DOMICILIO", length=300)
	private String rdDomicilio;
	

	@Column(name="RD_CANTIDAD", length=300)
	private String rdCantidad;
	

	@Column(name="RD_IMPORTE_LETRA", length=300)
	private String rdImporteLetra;
	

	@Column(name="RD_CONCEPTO_DE", length=300)
	private String rdConceptoDe;
	
	

	@Column(name="RD_NUM_CUENTA1", length=300)
	private String rdNumCuenta1;
	

	@Column(name="RD_NUM_CUENTA2", length=300)
	private String rdNumCuenta2;
	

	@Column(name="RD_BANCO1", length=300)
	private String rdBanco1;
	
	@Column(name="RD_BANCO2", length=300)
	private String rdBanco2;
	
	@Column(name="RD_IMPORTE1", length=300)
	private String rdImporte1;
	
	@Column(name="RD_IMPORTE2", length=300)
	private String rdImporte2;
	
	@Column(name="RD_AUTORIZACION1", length=300)
	private String rdAutorizacion1;
	
	@Column(name="RD_AUTORIZACION2", length=300)
	private String rdAutorizacion2;
	
	@Column(name="RD_NUM_TARJETA1", length=300)
	private String rdNumTarjeta1;
	
	@Column(name="RD_NUM_TARJETA2", length=300)
	private String rdNumTarjeta2;
	
	@Column(name="RD_BANCO1B", length=300)
	private String rdBanco1B;
	
	@Column(name="RD_BANCO2B", length=300)
	private String rdBanco2B;
	
	@Column(name="RD_IMPORTE1B", length=300)
	private String rdImporte1B;
	
	@Column(name="RD_IMPORTE2B", length=300)
	private String rdImporte2B;
	

	@Column(name="RD_IMPORTE_TOTAL", length=300)
	private String rdImporteTotal;
	
	@Column(name="RD_LUGAR_EXP", length=300)
	private String rdLugarExp;
	
	@Column(name="RD_FIRMA_RECIBIDO", length=300)
	private String rdFirmaRecibido;
	
		
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
    
    @Column(name="CANCELADO")
    private Integer cancelado;
    

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
	public AbstractFormatoReciboPagoDeducible() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getRdFecha() {
		return rdFecha;
	}



	public void setRdFecha(Date rdFecha) {
		this.rdFecha = rdFecha;
	}



	public Integer getRdValores() {
		return rdValores;
	}



	public void setRdValores(Integer rdValores) {
		this.rdValores = rdValores;
	}



	public String getRdNumSiniestro() {
		return rdNumSiniestro;
	}



	public void setRdNumSiniestro(String rdNumSiniestro) {
		this.rdNumSiniestro = rdNumSiniestro;
	}



	public String getRdNumReporte() {
		return rdNumReporte;
	}



	public void setRdNumReporte(String rdNumReporte) {
		this.rdNumReporte = rdNumReporte;
	}



	public String getRdFolio() {
		return rdFolio;
	}



	public void setRdFolio(String rdFolio) {
		this.rdFolio = rdFolio;
	}



	public String getRdNumPoliza() {
		return rdNumPoliza;
	}



	public void setRdNumPoliza(String rdNumPoliza) {
		this.rdNumPoliza = rdNumPoliza;
	}



	public String getRdNumInciso() {
		return rdNumInciso;
	}



	public void setRdNumInciso(String rdNumInciso) {
		this.rdNumInciso = rdNumInciso;
	}



	public String getRdClave() {
		return rdClave;
	}



	public void setRdClave(String rdClave) {
		this.rdClave = rdClave;
	}



	public String getRdAjustador() {
		return rdAjustador;
	}



	public void setRdAjustador(String rdAjustador) {
		this.rdAjustador = rdAjustador;
	}



	public String getRdRecibimosDe() {
		return rdRecibimosDe;
	}



	public void setRdRecibimosDe(String rdRecibimosDe) {
		this.rdRecibimosDe = rdRecibimosDe;
	}



	public String getRdRfc() {
		return rdRfc;
	}



	public void setRdRfc(String rdRfc) {
		this.rdRfc = rdRfc;
	}



	public String getRdEmail() {
		return rdEmail;
	}



	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}



	public String getRdTelefono() {
		return rdTelefono;
	}



	public void setRdTelefono(String rdTelefono) {
		this.rdTelefono = rdTelefono;
	}



	public String getRdDomicilio() {
		return rdDomicilio;
	}



	public void setRdDomicilio(String rdDomicilio) {
		this.rdDomicilio = rdDomicilio;
	}



	public String getRdCantidad() {
		return rdCantidad;
	}



	public void setRdCantidad(String rdCantidad) {
		this.rdCantidad = rdCantidad;
	}



	public String getRdImporteLetra() {
		return rdImporteLetra;
	}



	public void setRdImporteLetra(String rdImporteLetra) {
		this.rdImporteLetra = rdImporteLetra;
	}



	public String getRdConceptoDe() {
		return rdConceptoDe;
	}



	public void setRdConceptoDe(String rdConceptoDe) {
		this.rdConceptoDe = rdConceptoDe;
	}



	public String getRdNumCuenta1() {
		return rdNumCuenta1;
	}



	public void setRdNumCuenta1(String rdNumCuenta1) {
		this.rdNumCuenta1 = rdNumCuenta1;
	}



	public String getRdNumCuenta2() {
		return rdNumCuenta2;
	}



	public void setRdNumCuenta2(String rdNumCuenta2) {
		this.rdNumCuenta2 = rdNumCuenta2;
	}



	public String getRdBanco1() {
		return rdBanco1;
	}



	public void setRdBanco1(String rdBanco1) {
		this.rdBanco1 = rdBanco1;
	}



	public String getRdBanco2() {
		return rdBanco2;
	}



	public void setRdBanco2(String rdBanco2) {
		this.rdBanco2 = rdBanco2;
	}



	public String getRdImporte1() {
		return rdImporte1;
	}



	public void setRdImporte1(String rdImporte1) {
		this.rdImporte1 = rdImporte1;
	}



	public String getRdImporte2() {
		return rdImporte2;
	}



	public void setRdImporte2(String rdImporte2) {
		this.rdImporte2 = rdImporte2;
	}



	public String getRdAutorizacion1() {
		return rdAutorizacion1;
	}



	public void setRdAutorizacion1(String rdAutorizacion1) {
		this.rdAutorizacion1 = rdAutorizacion1;
	}



	public String getRdAutorizacion2() {
		return rdAutorizacion2;
	}



	public void setRdAutorizacion2(String rdAutorizacion2) {
		this.rdAutorizacion2 = rdAutorizacion2;
	}



	public String getRdNumTarjeta1() {
		return rdNumTarjeta1;
	}



	public void setRdNumTarjeta1(String rdNumTarjeta1) {
		this.rdNumTarjeta1 = rdNumTarjeta1;
	}



	public String getRdNumTarjeta2() {
		return rdNumTarjeta2;
	}



	public void setRdNumTarjeta2(String rdNumTarjeta2) {
		this.rdNumTarjeta2 = rdNumTarjeta2;
	}



	public String getRdBanco1B() {
		return rdBanco1B;
	}



	public void setRdBanco1B(String rdBanco1B) {
		this.rdBanco1B = rdBanco1B;
	}



	public String getRdBanco2B() {
		return rdBanco2B;
	}



	public void setRdBanco2B(String rdBanco2B) {
		this.rdBanco2B = rdBanco2B;
	}



	public String getRdImporte1B() {
		return rdImporte1B;
	}



	public void setRdImporte1B(String rdImporte1B) {
		this.rdImporte1B = rdImporte1B;
	}



	public String getRdImporte2B() {
		return rdImporte2B;
	}



	public void setRdImporte2B(String rdImporte2B) {
		this.rdImporte2B = rdImporte2B;
	}



	public String getRdImporteTotal() {
		return rdImporteTotal;
	}



	public void setRdImporteTotal(String rdImporteTotal) {
		this.rdImporteTotal = rdImporteTotal;
	}



	public String getRdLugarExp() {
		return rdLugarExp;
	}



	public void setRdLugarExp(String rdLugarExp) {
		this.rdLugarExp = rdLugarExp;
	}



	public String getRdFirmaRecibido() {
		return rdFirmaRecibido;
	}



	public void setRdFirmaRecibido(String rdFirmaRecibido) {
		this.rdFirmaRecibido = rdFirmaRecibido;
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



	public Integer getCancelado() {
		return cancelado;
	}



	public void setCancelado(Integer cancelado) {
		this.cancelado = cancelado;
	}


	



 }

