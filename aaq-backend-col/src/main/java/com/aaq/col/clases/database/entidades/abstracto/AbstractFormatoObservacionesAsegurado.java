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
 public abstract class AbstractFormatoObservacionesAsegurado extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opObservacionesAseguradoSEQ", sequenceName = "formato_observaciones_asegurado_seq", allocationSize = 1)
	@Id
	 @Column(name = "FOA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opObservacionesAseguradoSEQ")
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
    
   
    
    @Column(name="FOA_NUM_REPORTE")
	private String foaNumReporte;
    
    @Column(name="FOA_NUM_SINIESTRO")
	private String foaNumSiniestro;
    
    @Column(name="FOA_NUM_POLIZA")
	private String foaNumPoliza;
    
    @Column(name="FOA_NUM_ASEGURADO") 
	private String foaNumAsegurado;
    
    @Column(name="FOA_NOM_AJUSTADOR") 
	private String foaNomAjustador;
    
    @Column(name="FOA_OBSERVACIONES")
	private String foaObservaciones;
    
    @Column(name="FOA_NOM_CONDUCTOR")
	private String foaNomConductor;
    
    @Column(name="FOA_TELEFONO")
	private String foaTelefono;
    
    @Column(name="FOA_CORREO_CONDUCTOR")
	private String foaCorreoConductor;
    
    @Column(name="FOA_CLAVE_AJUSTADOR")
	private String foaClaveAjustador;
    
    @Column(name="FOA_FECHA")
	private Date foaFecha;
    
    @Column(name="FOA_LUGAR")
	private String foaLugar;
    
    @Column(name="FIRMA_CONDUCTOR")
	private String firmaConductor;
    
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
    
    @Column(name="PUNTO_UNO")
    private Integer puntoUno;
    
    @Column(name="PUNTO_DOS")
    private Integer puntoDos;
    
    @Column(name="PUNTO_TRES")
    private Integer puntoTres;
    
    @Column(name="PUNTO_CUATRO")
    private Integer puntoCuatro;
    
    @Column(name="PUNTO_CINCO")
    private Integer puntoCinco;
    
    

	public Integer getPuntoUno() {
		return puntoUno;
	}
	public void setPuntoUno(Integer puntoUno) {
		this.puntoUno = puntoUno;
	}
	public Integer getPuntoDos() {
		return puntoDos;
	}
	public void setPuntoDos(Integer puntoDos) {
		this.puntoDos = puntoDos;
	}
	public Integer getPuntoTres() {
		return puntoTres;
	}
	public void setPuntoTres(Integer puntoTres) {
		this.puntoTres = puntoTres;
	}
	public Integer getPuntoCuatro() {
		return puntoCuatro;
	}
	public void setPuntoCuatro(Integer puntoCuatro) {
		this.puntoCuatro = puntoCuatro;
	}
	public Integer getPuntoCinco() {
		return puntoCinco;
	}
	public void setPuntoCinco(Integer puntoCinco) {
		this.puntoCinco = puntoCinco;
	}
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

	

	public String getFoaNumReporte() {
		return foaNumReporte;
	}

	public void setFoaNumReporte(String foaNumReporte) {
		this.foaNumReporte = foaNumReporte;
	}

	public String getFoaNumSiniestro() {
		return foaNumSiniestro;
	}

	public void setFoaNumSiniestro(String foaNumSiniestro) {
		this.foaNumSiniestro = foaNumSiniestro;
	}

	public String getFoaNumPoliza() {
		return foaNumPoliza;
	}

	public void setFoaNumPoliza(String foaNumPoliza) {
		this.foaNumPoliza = foaNumPoliza;
	}

	public String getFoaNumAsegurado() {
		return foaNumAsegurado;
	}

	public void setFoaNumAsegurado(String foaNumAsegurado) {
		this.foaNumAsegurado = foaNumAsegurado;
	}

	public String getFoaNomAjustador() {
		return foaNomAjustador;
	}

	public void setFoaNomAjustador(String foaNomAjustador) {
		this.foaNomAjustador = foaNomAjustador;
	}

	public String getFoaObservaciones() {
		return foaObservaciones;
	}

	public void setFoaObservaciones(String foaObservaciones) {
		this.foaObservaciones = foaObservaciones;
	}

	public String getFoaNomConductor() {
		return foaNomConductor;
	}

	public void setFoaNomConductor(String foaNomConductor) {
		this.foaNomConductor = foaNomConductor;
	}

	public String getFoaTelefono() {
		return foaTelefono;
	}

	public void setFoaTelefono(String foaTelefono) {
		this.foaTelefono = foaTelefono;
	}

	public String getFoaCorreoConductor() {
		return foaCorreoConductor;
	}

	public void setFoaCorreoConductor(String foaCorreoConductor) {
		this.foaCorreoConductor = foaCorreoConductor;
	}

	public String getFoaClaveAjustador() {
		return foaClaveAjustador;
	}

	public void setFoaClaveAjustador(String foaClaveAjustador) {
		this.foaClaveAjustador = foaClaveAjustador;
	}

	public Date getFoaFecha() {
		return foaFecha;
	}

	public void setFoaFecha(Date foaFecha) {
		this.foaFecha = foaFecha;
	}

	public String getFoaLugar() {
		return foaLugar;
	}

	public void setFoaLugar(String foaLugar) {
		this.foaLugar = foaLugar;
	}

	public String getFirmaConductor() {
		return firmaConductor;
	}

	public void setFirmaConductor(String firmaConductor) {
		this.firmaConductor = firmaConductor;
	}
    
    


}