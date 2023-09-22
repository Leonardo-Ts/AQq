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
 public abstract class AbstractFormatoCargoTarjetaCredito extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opPagoIndemnizacionSEQ", sequenceName = "formato_pago_indemnizacion_seq", allocationSize = 1)
	 @Id
	 @Column(name = "TC_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opCargoSEQ")
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
    
    @Column(name="TC_NUM_REPORTE")
	private String tcNumReporte;
    
    @Column(name="TC_NUM_SINIESTRO")
   	private String tcNumSiniestro;

    @Column(name="TC_NUM_ASEGURADO")
   	private String TtcNumAsegurado;
	
    @Column(name="TC_NUM_AUTORIZACION")
   	private String tcNumAutorizacion;
    
    @Column(name="TC_NOMBRE")
   	private String tcNombre;
	
    @Column(name="TC_FECHA")
   	private Date tcFecha;
	
    
    @Column(name="TC_DIRECCION")
   	private String tcDireccion;
	
    
    @Column(name="TC_ESTADO")
   	private String tcEstado;
	
    
	 @Column(name="TC_CP")
	 private String tcCp;
	 
	 @Column(name="TC_TELEFONO")
	 private String tcTelefono;
	 
	 @Column(name="TC_CANTIDAD_AUTORIZADA")
	 private String tcCantidadAutorizada;
	 
	 @Column(name="TC_PAGO_OPCION")
	 private Integer tcPagoOpcion;
	 
	 @Column(name="TC_NUM_TARJETA")
	 private String tcNumTarjeta;
	 

	 
	 @Column(name="TC_VENCIMIENTO_TARJETA")
	 private String tcVencimientoTarjeta;
	 
	 @Column(name="TC_CLAVE_AJUSTADOR")
	 private String tcClaveAjustador;
	 

    @Column(name = "FIRMA_TARJETAHABIENTE")
	private String firmaTarjetahabiente;
    

 
    @Column(name = "TC_NUM_POLIZA")
	private String tcNumPoliza;
    

    @Column(name = "TC_CORREO")
	private String tcCorreo;
    
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
	public AbstractFormatoCargoTarjetaCredito() {
		super();
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




	public String getTcNumReporte() {
		return tcNumReporte;
	}




	public void setTcNumReporte(String tcNumReporte) {
		this.tcNumReporte = tcNumReporte;
	}




	public String getTcNumSiniestro() {
		return tcNumSiniestro;
	}




	public void setTcNumSiniestro(String tcNumSiniestro) {
		this.tcNumSiniestro = tcNumSiniestro;
	}




	public String getTtcNumAsegurado() {
		return TtcNumAsegurado;
	}




	public void setTtcNumAsegurado(String ttcNumAsegurado) {
		TtcNumAsegurado = ttcNumAsegurado;
	}




	public String getTcNumAutorizacion() {
		return tcNumAutorizacion;
	}




	public void setTcNumAutorizacion(String tcNumAutorizacion) {
		this.tcNumAutorizacion = tcNumAutorizacion;
	}




	public String getTcNombre() {
		return tcNombre;
	}




	public void setTcNombre(String tcNombre) {
		this.tcNombre = tcNombre;
	}




	public Date getTcFecha() {
		return tcFecha;
	}




	public void setTcFecha(Date tcFecha) {
		this.tcFecha = tcFecha;
	}




	public String getTcDireccion() {
		return tcDireccion;
	}




	public void setTcDireccion(String tcDireccion) {
		this.tcDireccion = tcDireccion;
	}




	public String getTcEstado() {
		return tcEstado;
	}




	public void setTcEstado(String tcEstado) {
		this.tcEstado = tcEstado;
	}




	public String getTcCp() {
		return tcCp;
	}




	public void setTcCp(String tcCp) {
		this.tcCp = tcCp;
	}




	public String getTcTelefono() {
		return tcTelefono;
	}




	public void setTcTelefono(String tcTelefono) {
		this.tcTelefono = tcTelefono;
	}




	public String getTcCantidadAutorizada() {
		return tcCantidadAutorizada;
	}




	public void setTcCantidadAutorizada(String tcCantidadAutorizada) {
		this.tcCantidadAutorizada = tcCantidadAutorizada;
	}




	public Integer getTcPagoOpcion() {
		return tcPagoOpcion;
	}




	public void setTcPagoOpcion(Integer tcPagoOpcion) {
		this.tcPagoOpcion = tcPagoOpcion;
	}




	public String getTcNumTarjeta() {
		return tcNumTarjeta;
	}




	public void setTcNumTarjeta(String tcNumTarjeta) {
		this.tcNumTarjeta = tcNumTarjeta;
	}







	public String getTcVencimientoTarjeta() {
		return tcVencimientoTarjeta;
	}




	public void setTcVencimientoTarjeta(String tcVencimientoTarjeta) {
		this.tcVencimientoTarjeta = tcVencimientoTarjeta;
	}




	public String getTcClaveAjustador() {
		return tcClaveAjustador;
	}




	public void setTcClaveAjustador(String tcClaveAjustador) {
		this.tcClaveAjustador = tcClaveAjustador;
	}




	public String getFirmaTarjetahabiente() {
		return firmaTarjetahabiente;
	}




	public void setFirmaTarjetahabiente(String firmaTarjetahabiente) {
		this.firmaTarjetahabiente = firmaTarjetahabiente;
	}







	public String getTcNumPoliza() {
		return tcNumPoliza;
	}




	public void setTcNumPoliza(String tcNumPoliza) {
		this.tcNumPoliza = tcNumPoliza;
	}




	public String getTcCorreo() {
		return tcCorreo;
	}




	public void setTcCorreo(String tcCorreo) {
		this.tcCorreo = tcCorreo;
	}






 }

