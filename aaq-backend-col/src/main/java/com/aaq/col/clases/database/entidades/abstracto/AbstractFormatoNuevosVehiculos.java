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
 public abstract class AbstractFormatoNuevosVehiculos extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opNuevosSEQ", sequenceName = "formato_nuevos_vehiculos_seq", allocationSize = 1)
	 @Id
	 @Column(name = "NV_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opNuevosSEQ")
	 private Integer id;
	
	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=20)
	private String ftpRespuesta;
	
	@Column(name="NV_DANIOS_PRE")
	private String nvDaniosPre;
	
	@Column(name="NV_PLACAS", length=30)
	private String nvPlacas;

	@Column(name="NV_ASEGURADO", length=5)
	private String nvAsegurado;

	@Column(name="NV_CLAVE_AJUSTADOR", length=20)
	private String nvClaveAjustador;

	@Column(name="NV_DERIVADA_AUTO")
	private Integer nvDerivadaAuto;



	@Column(name="NV_EMAIL", length=100)
	private String nvEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="NV_FECHA")
	private Date nvFecha;

	@Temporal(TemporalType.DATE)
	@Column(name="NV_FECHA_INSPECCION")
	private Date nvFechaInspeccion;

	@Column(name="NV_FOTO_MOTOR")
	private Integer nvFotoMotor;

	@Column(name="NV_FOTO_SERIE")
	private Integer nvFotoSerie;

	@Column(name="NV_HORA")
	private Timestamp nvHora;

	@Column(name="NV_KILOMETROS_AUTO", length=20)
	private String nvKilometrosAuto;

	@Column(name="NV_MODELO_AUTO", length=50)
	private String nvModeloAuto;

	@Column(name="NV_MOTOR_AUTO", length=20)
	private String nvMotorAuto;

	@Column(name="NV_NOMBRE_AJUSTADOR", length=100)
	private String nvNombreAjustador;

	@Column(name="NV_NOMBRE_CLIENTE", length=100)
	private String nvNombreCliente;

	@Column(name="NV_NUM_INCISO", length=20)
	private String nvNumInciso;

	@Column(name="NV_NUM_POLIZA", length=20)
	private String nvNumPoliza;

	@Column(name="NV_NUM_REPORTE", length=20)
	private String nvNumReporte;

	@Column(name="NV_NUM_SERIE_AUTO", length=20)
	private String nvNumSerieAuto;

	@Column(name="NV_OBSERVACIONES_AUTO", length=300)
	private String nvObservacionesAuto;

	@Column(name="NV_OFICNA", length=50)
	private String nvOficna;

	@Column(name="NV_PROCEDENCIA_AUTO")
	private Integer nvProcedenciaAuto;

	@Column(name="NV_PUERTAS_AUTO", length=1)
	private String nvPuertasAuto;

	@Column(name="NV_SOLICITANTE", length=100)
	private String nvSolicitante;

	@Column(name="NV_TEL_SOLICITANTE", length=15)
	private String nvTelSolicitante;

	@Column(name="NV_TIPO_AUTO", length=50)
	private String nvTipoAuto;

	@Column(name="NV_TIPO_EMPLEADO")
	private Integer nvTipoEmpleado;

	@Column(name="NV_TOTAL_FOTOS")
	private Integer nvTotalFotos;

	@Column(name="NV_TRANSMISION_AUTO", length=1)
	private String nvTransmisionAuto;

	@Column(name="NV_UBICACION", length=100)
	private String nvUbicacion;

	@Column(name="NV_UNIDAD_AUTO", length=50)
	private String nvUnidadAuto;


	
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
    
    
    @Column(name = "FIRMA_CLIENTE")
	private String firmaCliente;
    
    @Column(name = "FIRMA_AGENTE")
	private String firmaAgente;
    
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
	public AbstractFormatoNuevosVehiculos() {
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
	 * @return the nvAsegurado
	 */
	public String getNvAsegurado() {
		return nvAsegurado;
	}









	/**
	 * @param nvAsegurado the nvAsegurado to set
	 */
	public void setNvAsegurado(String nvAsegurado) {
		this.nvAsegurado = nvAsegurado;
	}









	/**
	 * @return the nvClaveAjustador
	 */
	public String getNvClaveAjustador() {
		return nvClaveAjustador;
	}




	/**
	 * @param nvClaveAjustador the nvClaveAjustador to set
	 */
	public void setNvClaveAjustador(String nvClaveAjustador) {
		this.nvClaveAjustador = nvClaveAjustador;
	}




	/**
	 * @return the nvDerivadaAuto
	 */
	public Integer getNvDerivadaAuto() {
		return nvDerivadaAuto;
	}




	/**
	 * @param nvDerivadaAuto the nvDerivadaAuto to set
	 */
	public void setNvDerivadaAuto(Integer nvDerivadaAuto) {
		this.nvDerivadaAuto = nvDerivadaAuto;
	}







	/**
	 * @return the nvEmail
	 */
	public String getNvEmail() {
		return nvEmail;
	}




	/**
	 * @param nvEmail the nvEmail to set
	 */
	public void setNvEmail(String nvEmail) {
		this.nvEmail = nvEmail;
	}




	/**
	 * @return the nvFecha
	 */
	public Date getNvFecha() {
		return nvFecha;
	}




	/**
	 * @param nvFecha the nvFecha to set
	 */
	public void setNvFecha(Date nvFecha) {
		this.nvFecha = nvFecha;
	}




	/**
	 * @return the nvFechaInspeccion
	 */
	public Date getNvFechaInspeccion() {
		return nvFechaInspeccion;
	}




	/**
	 * @param nvFechaInspeccion the nvFechaInspeccion to set
	 */
	public void setNvFechaInspeccion(Date nvFechaInspeccion) {
		this.nvFechaInspeccion = nvFechaInspeccion;
	}




	/**
	 * @return the nvFotoMotor
	 */
	public Integer getNvFotoMotor() {
		return nvFotoMotor;
	}




	/**
	 * @param nvFotoMotor the nvFotoMotor to set
	 */
	public void setNvFotoMotor(Integer nvFotoMotor) {
		this.nvFotoMotor = nvFotoMotor;
	}




	/**
	 * @return the nvFotoSerie
	 */
	public Integer getNvFotoSerie() {
		return nvFotoSerie;
	}




	/**
	 * @param nvFotoSerie the nvFotoSerie to set
	 */
	public void setNvFotoSerie(Integer nvFotoSerie) {
		this.nvFotoSerie = nvFotoSerie;
	}




	/**
	 * @return the nvHora
	 */
	public Timestamp getNvHora() {
		return nvHora;
	}




	/**
	 * @param nvHora the nvHora to set
	 */
	public void setNvHora(Timestamp nvHora) {
		this.nvHora = nvHora;
	}




	/**
	 * @return the nvKilometrosAuto
	 */
	public String getNvKilometrosAuto() {
		return nvKilometrosAuto;
	}




	/**
	 * @param nvKilometrosAuto the nvKilometrosAuto to set
	 */
	public void setNvKilometrosAuto(String nvKilometrosAuto) {
		this.nvKilometrosAuto = nvKilometrosAuto;
	}




	/**
	 * @return the nvModeloAuto
	 */
	public String getNvModeloAuto() {
		return nvModeloAuto;
	}




	/**
	 * @param nvModeloAuto the nvModeloAuto to set
	 */
	public void setNvModeloAuto(String nvModeloAuto) {
		this.nvModeloAuto = nvModeloAuto;
	}




	/**
	 * @return the nvMotorAuto
	 */
	public String getNvMotorAuto() {
		return nvMotorAuto;
	}




	/**
	 * @param nvMotorAuto the nvMotorAuto to set
	 */
	public void setNvMotorAuto(String nvMotorAuto) {
		this.nvMotorAuto = nvMotorAuto;
	}




	/**
	 * @return the nvNombreAjustador
	 */
	public String getNvNombreAjustador() {
		return nvNombreAjustador;
	}




	/**
	 * @param nvNombreAjustador the nvNombreAjustador to set
	 */
	public void setNvNombreAjustador(String nvNombreAjustador) {
		this.nvNombreAjustador = nvNombreAjustador;
	}




	/**
	 * @return the nvNombreCliente
	 */
	public String getNvNombreCliente() {
		return nvNombreCliente;
	}




	/**
	 * @param nvNombreCliente the nvNombreCliente to set
	 */
	public void setNvNombreCliente(String nvNombreCliente) {
		this.nvNombreCliente = nvNombreCliente;
	}




	/**
	 * @return the nvNumInciso
	 */
	public String getNvNumInciso() {
		return nvNumInciso;
	}




	/**
	 * @param nvNumInciso the nvNumInciso to set
	 */
	public void setNvNumInciso(String nvNumInciso) {
		this.nvNumInciso = nvNumInciso;
	}




	/**
	 * @return the nvNumPoliza
	 */
	public String getNvNumPoliza() {
		return nvNumPoliza;
	}




	/**
	 * @param nvNumPoliza the nvNumPoliza to set
	 */
	public void setNvNumPoliza(String nvNumPoliza) {
		this.nvNumPoliza = nvNumPoliza;
	}




	/**
	 * @return the nvNumReporte
	 */
	public String getNvNumReporte() {
		return nvNumReporte;
	}




	/**
	 * @param nvNumReporte the nvNumReporte to set
	 */
	public void setNvNumReporte(String nvNumReporte) {
		this.nvNumReporte = nvNumReporte;
	}




	/**
	 * @return the nvNumSerieAuto
	 */
	public String getNvNumSerieAuto() {
		return nvNumSerieAuto;
	}




	/**
	 * @param nvNumSerieAuto the nvNumSerieAuto to set
	 */
	public void setNvNumSerieAuto(String nvNumSerieAuto) {
		this.nvNumSerieAuto = nvNumSerieAuto;
	}




	/**
	 * @return the nvObservacionesAuto
	 */
	public String getNvObservacionesAuto() {
		return nvObservacionesAuto;
	}




	/**
	 * @param nvObservacionesAuto the nvObservacionesAuto to set
	 */
	public void setNvObservacionesAuto(String nvObservacionesAuto) {
		this.nvObservacionesAuto = nvObservacionesAuto;
	}




	/**
	 * @return the nvOficna
	 */
	public String getNvOficna() {
		return nvOficna;
	}




	/**
	 * @param nvOficna the nvOficna to set
	 */
	public void setNvOficna(String nvOficna) {
		this.nvOficna = nvOficna;
	}




	/**
	 * @return the nvProcedenciaAuto
	 */
	public Integer getNvProcedenciaAuto() {
		return nvProcedenciaAuto;
	}




	/**
	 * @param nvProcedenciaAuto the nvProcedenciaAuto to set
	 */
	public void setNvProcedenciaAuto(Integer nvProcedenciaAuto) {
		this.nvProcedenciaAuto = nvProcedenciaAuto;
	}




	/**
	 * @return the nvPuertasAuto
	 */
	public String getNvPuertasAuto() {
		return nvPuertasAuto;
	}




	/**
	 * @param nvPuertasAuto the nvPuertasAuto to set
	 */
	public void setNvPuertasAuto(String nvPuertasAuto) {
		this.nvPuertasAuto = nvPuertasAuto;
	}




	/**
	 * @return the nvSolicitante
	 */
	public String getNvSolicitante() {
		return nvSolicitante;
	}




	/**
	 * @param nvSolicitante the nvSolicitante to set
	 */
	public void setNvSolicitante(String nvSolicitante) {
		this.nvSolicitante = nvSolicitante;
	}




	/**
	 * @return the nvTelSolicitante
	 */
	public String getNvTelSolicitante() {
		return nvTelSolicitante;
	}




	/**
	 * @param nvTelSolicitante the nvTelSolicitante to set
	 */
	public void setNvTelSolicitante(String nvTelSolicitante) {
		this.nvTelSolicitante = nvTelSolicitante;
	}




	/**
	 * @return the nvTipoAuto
	 */
	public String getNvTipoAuto() {
		return nvTipoAuto;
	}




	/**
	 * @param nvTipoAuto the nvTipoAuto to set
	 */
	public void setNvTipoAuto(String nvTipoAuto) {
		this.nvTipoAuto = nvTipoAuto;
	}




	/**
	 * @return the nvTipoEmpleado
	 */
	public Integer getNvTipoEmpleado() {
		return nvTipoEmpleado;
	}




	/**
	 * @param nvTipoEmpleado the nvTipoEmpleado to set
	 */
	public void setNvTipoEmpleado(Integer nvTipoEmpleado) {
		this.nvTipoEmpleado = nvTipoEmpleado;
	}




	/**
	 * @return the nvTotalFotos
	 */
	public Integer getNvTotalFotos() {
		return nvTotalFotos;
	}




	/**
	 * @param nvTotalFotos the nvTotalFotos to set
	 */
	public void setNvTotalFotos(Integer nvTotalFotos) {
		this.nvTotalFotos = nvTotalFotos;
	}




	/**
	 * @return the nvTransmisionAuto
	 */
	public String getNvTransmisionAuto() {
		return nvTransmisionAuto;
	}




	/**
	 * @param nvTransmisionAuto the nvTransmisionAuto to set
	 */
	public void setNvTransmisionAuto(String nvTransmisionAuto) {
		this.nvTransmisionAuto = nvTransmisionAuto;
	}




	/**
	 * @return the nvUbicacion
	 */
	public String getNvUbicacion() {
		return nvUbicacion;
	}




	/**
	 * @param nvUbicacion the nvUbicacion to set
	 */
	public void setNvUbicacion(String nvUbicacion) {
		this.nvUbicacion = nvUbicacion;
	}




	/**
	 * @return the nvUnidadAuto
	 */
	public String getNvUnidadAuto() {
		return nvUnidadAuto;
	}




	/**
	 * @param nvUnidadAuto the nvUnidadAuto to set
	 */
	public void setNvUnidadAuto(String nvUnidadAuto) {
		this.nvUnidadAuto = nvUnidadAuto;
	}







	



	/**
	 * @return the nvDaniosPre
	 */
	public String getNvDaniosPre() {
		return nvDaniosPre;
	}









	/**
	 * @param nvDaniosPre the nvDaniosPre to set
	 */
	public void setNvDaniosPre(String nvDaniosPre) {
		this.nvDaniosPre = nvDaniosPre;
	}









	/**
	 * @return the nvPlacas
	 */
	public String getNvPlacas() {
		return nvPlacas;
	}




	/**
	 * @param nvPlacas the nvPlacas to set
	 */
	public void setNvPlacas(String nvPlacas) {
		this.nvPlacas = nvPlacas;
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
	 * @return the firmaCliente
	 */
	public String getFirmaCliente() {
		return firmaCliente;
	}









	/**
	 * @param firmaCliente the firmaCliente to set
	 */
	public void setFirmaCliente(String firmaCliente) {
		this.firmaCliente = firmaCliente;
	}









	/**
	 * @return the firmaAgente
	 */
	public String getFirmaAgente() {
		return firmaAgente;
	}









	/**
	 * @param firmaAgente the firmaAgente to set
	 */
	public void setFirmaAgente(String firmaAgente) {
		this.firmaAgente = firmaAgente;
	}
	
	
	



}