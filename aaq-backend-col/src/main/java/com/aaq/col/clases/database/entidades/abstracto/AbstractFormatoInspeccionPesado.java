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
 public abstract class AbstractFormatoInspeccionPesado extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opIPesadoSEQ", sequenceName = "formato_inspeccion_pesado_seq", allocationSize = 1)
	@Id
	@Column(name = "IP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opIPesadoSEQ")
	private Integer id;
	

	 
		@Column(name="IP_ADAPTACIONES")
		private Integer ipAdaptaciones;

		@Column(name="IP_ADAPTACIONES_SI_NO")
		private Integer ipAdaptacionesSiNo;

		@Column(name="IP_ASEGURADO", length=5)
		private String ipAsegurado;

		@Column(name="IP_ASEGURADO_COMPA")
		private Integer ipAseguradoCompa;

		@Column(name="IP_ATENCION", length=100)
		private String ipAtencion;

		@Column(name="IP_CALIFICACION")
		private Integer ipCalificacion;

		@Column(name="IP_CIRCULACION")
		private Integer ipCirculacion;

		@Column(name="IP_CLAVE_AJUSTADOR", length=20)
		private String ipClaveAjustador;

		@Column(name="IP_COLOR", length=20)
		private String ipColor;

		@Column(name="IP_COMPANIA", length=100)
		private String ipCompania;

		@Temporal(TemporalType.DATE)
		@Column(name="IP_DIA_HORA")
		private Date ipDiaHora;

		@Column(name="IP_DOCUMENTACION_1")
		private Integer ipDocumentacion1;

		@Column(name="IP_DOCUMENTACION_2")
		private Integer ipDocumentacion2;
		
		@Column(name="IP_MARCA", length=50)
		private String ipMarca;

		@Column(name="IP_EMAIL", length=50)
		private String ipEmail;

		@Column(name="IP_EQUIPO")
		private Integer ipEquipo;

		@Column(name="IP_EQUIPO_SI_NO")
		private Integer ipEquipoSiNo;

		@Column(name="IP_ESTANDAR_T", length=1)
		private String ipEstandarT;

		@Temporal(TemporalType.DATE)
		@Column(name="IP_FECHA")
		private Date ipFecha;

		@Temporal(TemporalType.DATE)
		@Column(name="IP_FECHA_INSPECCION")
		private Date ipFechaInspeccion;


		@Column(name="IP_IMPORTACION_1")
		private Integer ipImportacion1;

		@Column(name="IP_IMPORTACION_2")
		private Integer ipImportacion2;

		@Column(name="IP_KILOMETRAJE", length=20)
		private String ipKilometraje;

		@Column(name="IP_MODELO", length=50)
		private String ipModelo;

		@Column(name="IP_NOM_AJUSTADOR", length=100)
		private String ipNomAjustador;

		@Column(name="IP_NOM_CLIENTE", length=100)
		private String ipNomCliente;

		@Column(name="IP_NUM_POLIZA", length=20)
		private String ipNumPoliza;

		@Column(name="IP_NUM_SERIE", length=50)
		private String ipNumSerie;

		@Column(name="IP_OBSERVACIONES", length=500)
		private String ipObservaciones;

		@Column(name="IP_OFICINA", length=100)
		private String ipOficina;

		@Column(name="IP_PAGO")
		private Integer ipPago;

		@Column(name="IP_PAGO_SI_NO")
		private Integer ipPagoSiNo;

		@Column(name="IP_PLACAS", length=20)
		private String ipPlacas;

		@Column(name="IP_PROCEDENCIA")
		private Integer ipProcedencia;

		@Column(name="IP_PUERTAS_D", length=1)
		private String ipPuertasD;

		@Column(name="IP_SALVAMENTOS")
		private Integer ipSalvamentos;

		@Column(name="IP_SOLICITANTE", length=100)
		private String ipSolicitante;

		@Column(name="IP_T_CIRCULACION_1")
		private Integer ipTCirculacion1;

		@Column(name="IP_T_CIRCULACION_2")
		private Integer ipTCirculacion2;

		@Column(name="IP_TELEFONO", length=15)
		private String ipTelefono;

		@Column(name="IP_TIPO", length=50)
		private String ipTipo;

		@Column(name="IP_TIPO_ENCARGADO")
		private Integer ipTipoEncargado;

		@Column(name="IP_TOTAL_FOTOS", length=20)
		private String ipTotalFotos;

		@Column(name="IP_NUM_REPORTE", length=20)
		private String ipNumReporte;
		
		@Column(name="IP_NUM_INCISO", length=20)
		private String ipNumInciso;
		
		@Column(name="IP_NUM_SINIESTRO", length=20)
		private String ipNumSiniestro;
		
		@Column(name="IP_UBICACION", length=200)
		private String ipUbicacion;
	 @Column(name = "enviado_ftp", nullable = true, unique = false)
	
	 private Integer enviadoFtp;
	 
	 @Column(name = "ftp_respuesta", length = 255, nullable = true, unique = false)
	 private String respuestaFtp;
	
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
	public AbstractFormatoInspeccionPesado() {
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
	 * @return the ipAdaptaciones
	 */
	public Integer getIpAdaptaciones() {
		return ipAdaptaciones;
	}


	/**
	 * @param ipAdaptaciones the ipAdaptaciones to set
	 */
	public void setIpAdaptaciones(Integer ipAdaptaciones) {
		this.ipAdaptaciones = ipAdaptaciones;
	}


	/**
	 * @return the ipAdaptacionesSiNo
	 */
	public Integer getIpAdaptacionesSiNo() {
		return ipAdaptacionesSiNo;
	}


	/**
	 * @param ipAdaptacionesSiNo the ipAdaptacionesSiNo to set
	 */
	public void setIpAdaptacionesSiNo(Integer ipAdaptacionesSiNo) {
		this.ipAdaptacionesSiNo = ipAdaptacionesSiNo;
	}


	


	/**
	 * @return the ipAsegurado
	 */
	public String getIpAsegurado() {
		return ipAsegurado;
	}




	/**
	 * @param ipAsegurado the ipAsegurado to set
	 */
	public void setIpAsegurado(String ipAsegurado) {
		this.ipAsegurado = ipAsegurado;
	}




	/**
	 * @return the ipAseguradoCompa
	 */
	public Integer getIpAseguradoCompa() {
		return ipAseguradoCompa;
	}


	/**
	 * @param ipAseguradoCompa the ipAseguradoCompa to set
	 */
	public void setIpAseguradoCompa(Integer ipAseguradoCompa) {
		this.ipAseguradoCompa = ipAseguradoCompa;
	}


	/**
	 * @return the ipAtencion
	 */
	public String getIpAtencion() {
		return ipAtencion;
	}


	/**
	 * @param ipAtencion the ipAtencion to set
	 */
	public void setIpAtencion(String ipAtencion) {
		this.ipAtencion = ipAtencion;
	}


	/**
	 * @return the ipCalificacion
	 */
	public Integer getIpCalificacion() {
		return ipCalificacion;
	}


	/**
	 * @param ipCalificacion the ipCalificacion to set
	 */
	public void setIpCalificacion(Integer ipCalificacion) {
		this.ipCalificacion = ipCalificacion;
	}


	/**
	 * @return the ipCirculacion
	 */
	public Integer getIpCirculacion() {
		return ipCirculacion;
	}


	/**
	 * @param ipCirculacion the ipCirculacion to set
	 */
	public void setIpCirculacion(Integer ipCirculacion) {
		this.ipCirculacion = ipCirculacion;
	}


	/**
	 * @return the ipClaveAjustador
	 */
	public String getIpClaveAjustador() {
		return ipClaveAjustador;
	}


	/**
	 * @param ipClaveAjustador the ipClaveAjustador to set
	 */
	public void setIpClaveAjustador(String ipClaveAjustador) {
		this.ipClaveAjustador = ipClaveAjustador;
	}


	/**
	 * @return the ipColor
	 */
	public String getIpColor() {
		return ipColor;
	}


	/**
	 * @param ipColor the ipColor to set
	 */
	public void setIpColor(String ipColor) {
		this.ipColor = ipColor;
	}


	/**
	 * @return the ipCompania
	 */
	public String getIpCompania() {
		return ipCompania;
	}


	/**
	 * @param ipCompania the ipCompania to set
	 */
	public void setIpCompania(String ipCompania) {
		this.ipCompania = ipCompania;
	}


	/**
	 * @return the ipDiaHora
	 */
	public Date getIpDiaHora() {
		return ipDiaHora;
	}


	/**
	 * @param ipDiaHora the ipDiaHora to set
	 */
	public void setIpDiaHora(Date ipDiaHora) {
		this.ipDiaHora = ipDiaHora;
	}


	/**
	 * @return the ipDocumentacion1
	 */
	public Integer getIpDocumentacion1() {
		return ipDocumentacion1;
	}


	/**
	 * @param ipDocumentacion1 the ipDocumentacion1 to set
	 */
	public void setIpDocumentacion1(Integer ipDocumentacion1) {
		this.ipDocumentacion1 = ipDocumentacion1;
	}


	/**
	 * @return the ipDocumentacion2
	 */
	public Integer getIpDocumentacion2() {
		return ipDocumentacion2;
	}


	/**
	 * @param ipDocumentacion2 the ipDocumentacion2 to set
	 */
	public void setIpDocumentacion2(Integer ipDocumentacion2) {
		this.ipDocumentacion2 = ipDocumentacion2;
	}


	/**
	 * @return the ipEmail
	 */
	public String getIpEmail() {
		return ipEmail;
	}


	/**
	 * @param ipEmail the ipEmail to set
	 */
	public void setIpEmail(String ipEmail) {
		this.ipEmail = ipEmail;
	}


	/**
	 * @return the ipEquipo
	 */
	public Integer getIpEquipo() {
		return ipEquipo;
	}


	/**
	 * @param ipEquipo the ipEquipo to set
	 */
	public void setIpEquipo(Integer ipEquipo) {
		this.ipEquipo = ipEquipo;
	}


	/**
	 * @return the ipEquipoSiNo
	 */
	public Integer getIpEquipoSiNo() {
		return ipEquipoSiNo;
	}


	/**
	 * @param ipEquipoSiNo the ipEquipoSiNo to set
	 */
	public void setIpEquipoSiNo(Integer ipEquipoSiNo) {
		this.ipEquipoSiNo = ipEquipoSiNo;
	}


	/**
	 * @return the ipEstandarT
	 */
	public String getIpEstandarT() {
		return ipEstandarT;
	}


	/**
	 * @param ipEstandarT the ipEstandarT to set
	 */
	public void setIpEstandarT(String ipEstandarT) {
		this.ipEstandarT = ipEstandarT;
	}


	/**
	 * @return the ipFecha
	 */
	public Date getIpFecha() {
		return ipFecha;
	}


	/**
	 * @param ipFecha the ipFecha to set
	 */
	public void setIpFecha(Date ipFecha) {
		this.ipFecha = ipFecha;
	}


	/**
	 * @return the ipFechaInspeccion
	 */
	public Date getIpFechaInspeccion() {
		return ipFechaInspeccion;
	}


	/**
	 * @param ipFechaInspeccion the ipFechaInspeccion to set
	 */
	public void setIpFechaInspeccion(Date ipFechaInspeccion) {
		this.ipFechaInspeccion = ipFechaInspeccion;
	}


	


	/**
	 * @return the ipImportacion1
	 */
	public Integer getIpImportacion1() {
		return ipImportacion1;
	}


	/**
	 * @param ipImportacion1 the ipImportacion1 to set
	 */
	public void setIpImportacion1(Integer ipImportacion1) {
		this.ipImportacion1 = ipImportacion1;
	}


	/**
	 * @return the ipImportacion2
	 */
	public Integer getIpImportacion2() {
		return ipImportacion2;
	}


	/**
	 * @param ipImportacion2 the ipImportacion2 to set
	 */
	public void setIpImportacion2(Integer ipImportacion2) {
		this.ipImportacion2 = ipImportacion2;
	}


	/**
	 * @return the ipKilometraje
	 */
	public String getIpKilometraje() {
		return ipKilometraje;
	}


	/**
	 * @param ipKilometraje the ipKilometraje to set
	 */
	public void setIpKilometraje(String ipKilometraje) {
		this.ipKilometraje = ipKilometraje;
	}


	/**
	 * @return the ipModelo
	 */
	public String getIpModelo() {
		return ipModelo;
	}


	/**
	 * @param ipModelo the ipModelo to set
	 */
	public void setIpModelo(String ipModelo) {
		this.ipModelo = ipModelo;
	}


	/**
	 * @return the ipNomAjustador
	 */
	public String getIpNomAjustador() {
		return ipNomAjustador;
	}


	/**
	 * @param ipNomAjustador the ipNomAjustador to set
	 */
	public void setIpNomAjustador(String ipNomAjustador) {
		this.ipNomAjustador = ipNomAjustador;
	}


	/**
	 * @return the ipNomCliente
	 */
	public String getIpNomCliente() {
		return ipNomCliente;
	}


	/**
	 * @param ipNomCliente the ipNomCliente to set
	 */
	public void setIpNomCliente(String ipNomCliente) {
		this.ipNomCliente = ipNomCliente;
	}


	/**
	 * @return the ipNumPoliza
	 */
	public String getIpNumPoliza() {
		return ipNumPoliza;
	}


	/**
	 * @param ipNumPoliza the ipNumPoliza to set
	 */
	public void setIpNumPoliza(String ipNumPoliza) {
		this.ipNumPoliza = ipNumPoliza;
	}


	/**
	 * @return the ipMarca
	 */
	public String getIpMarca() {
		return ipMarca;
	}




	/**
	 * @param ipMarca the ipMarca to set
	 */
	public void setIpMarca(String ipMarca) {
		this.ipMarca = ipMarca;
	}




	/**
	 * @return the ipNumSerie
	 */
	public String getIpNumSerie() {
		return ipNumSerie;
	}


	/**
	 * @param ipNumSerie the ipNumSerie to set
	 */
	public void setIpNumSerie(String ipNumSerie) {
		this.ipNumSerie = ipNumSerie;
	}


	/**
	 * @return the ipObservaciones
	 */
	public String getIpObservaciones() {
		return ipObservaciones;
	}


	/**
	 * @param ipObservaciones the ipObservaciones to set
	 */
	public void setIpObservaciones(String ipObservaciones) {
		this.ipObservaciones = ipObservaciones;
	}


	/**
	 * @return the ipOficina
	 */
	public String getIpOficina() {
		return ipOficina;
	}


	/**
	 * @param ipOficina the ipOficina to set
	 */
	public void setIpOficina(String ipOficina) {
		this.ipOficina = ipOficina;
	}


	/**
	 * @return the ipPago
	 */
	public Integer getIpPago() {
		return ipPago;
	}


	/**
	 * @param ipPago the ipPago to set
	 */
	public void setIpPago(Integer ipPago) {
		this.ipPago = ipPago;
	}


	/**
	 * @return the ipPagoSiNo
	 */
	public Integer getIpPagoSiNo() {
		return ipPagoSiNo;
	}


	/**
	 * @param ipPagoSiNo the ipPagoSiNo to set
	 */
	public void setIpPagoSiNo(Integer ipPagoSiNo) {
		this.ipPagoSiNo = ipPagoSiNo;
	}


	/**
	 * @return the ipPlacas
	 */
	public String getIpPlacas() {
		return ipPlacas;
	}


	/**
	 * @param ipPlacas the ipPlacas to set
	 */
	public void setIpPlacas(String ipPlacas) {
		this.ipPlacas = ipPlacas;
	}


	/**
	 * @return the ipProcedencia
	 */
	public Integer getIpProcedencia() {
		return ipProcedencia;
	}


	/**
	 * @param ipProcedencia the ipProcedencia to set
	 */
	public void setIpProcedencia(Integer ipProcedencia) {
		this.ipProcedencia = ipProcedencia;
	}


	/**
	 * @return the ipPuertasD
	 */
	public String getIpPuertasD() {
		return ipPuertasD;
	}


	/**
	 * @param ipPuertasD the ipPuertasD to set
	 */
	public void setIpPuertasD(String ipPuertasD) {
		this.ipPuertasD = ipPuertasD;
	}


	/**
	 * @return the ipSalvamentos
	 */
	public Integer getIpSalvamentos() {
		return ipSalvamentos;
	}


	/**
	 * @param ipSalvamentos the ipSalvamentos to set
	 */
	public void setIpSalvamentos(Integer ipSalvamentos) {
		this.ipSalvamentos = ipSalvamentos;
	}


	/**
	 * @return the ipSolicitante
	 */
	public String getIpSolicitante() {
		return ipSolicitante;
	}


	/**
	 * @param ipSolicitante the ipSolicitante to set
	 */
	public void setIpSolicitante(String ipSolicitante) {
		this.ipSolicitante = ipSolicitante;
	}


	/**
	 * @return the ipTCirculacion1
	 */
	public Integer getIpTCirculacion1() {
		return ipTCirculacion1;
	}


	/**
	 * @param ipTCirculacion1 the ipTCirculacion1 to set
	 */
	public void setIpTCirculacion1(Integer ipTCirculacion1) {
		this.ipTCirculacion1 = ipTCirculacion1;
	}


	/**
	 * @return the ipTCirculacion2
	 */
	public Integer getIpTCirculacion2() {
		return ipTCirculacion2;
	}


	/**
	 * @param ipTCirculacion2 the ipTCirculacion2 to set
	 */
	public void setIpTCirculacion2(Integer ipTCirculacion2) {
		this.ipTCirculacion2 = ipTCirculacion2;
	}


	/**
	 * @return the ipTelefono
	 */
	public String getIpTelefono() {
		return ipTelefono;
	}


	/**
	 * @param ipTelefono the ipTelefono to set
	 */
	public void setIpTelefono(String ipTelefono) {
		this.ipTelefono = ipTelefono;
	}


	/**
	 * @return the ipTipo
	 */
	public String getIpTipo() {
		return ipTipo;
	}


	/**
	 * @param ipTipo the ipTipo to set
	 */
	public void setIpTipo(String ipTipo) {
		this.ipTipo = ipTipo;
	}


	/**
	 * @return the ipTipoEncargado
	 */
	public Integer getIpTipoEncargado() {
		return ipTipoEncargado;
	}


	/**
	 * @param ipTipoEncargado the ipTipoEncargado to set
	 */
	public void setIpTipoEncargado(Integer ipTipoEncargado) {
		this.ipTipoEncargado = ipTipoEncargado;
	}


	/**
	 * @return the ipTotalFotos
	 */
	public String getIpTotalFotos() {
		return ipTotalFotos;
	}


	/**
	 * @param ipTotalFotos the ipTotalFotos to set
	 */
	public void setIpTotalFotos(String ipTotalFotos) {
		this.ipTotalFotos = ipTotalFotos;
	}


	/**
	 * @return the ipNumReporte
	 */
	public String getIpNumReporte() {
		return ipNumReporte;
	}


	/**
	 * @param ipNumReporte the ipNumReporte to set
	 */
	public void setIpNumReporte(String ipNumReporte) {
		this.ipNumReporte = ipNumReporte;
	}


	/**
	 * @return the ipNumInciso
	 */
	public String getIpNumInciso() {
		return ipNumInciso;
	}


	/**
	 * @param ipNumInciso the ipNumInciso to set
	 */
	public void setIpNumInciso(String ipNumInciso) {
		this.ipNumInciso = ipNumInciso;
	}


	/**
	 * @return the ipNumSiniestro
	 */
	public String getIpNumSiniestro() {
		return ipNumSiniestro;
	}


	/**
	 * @param ipNumSiniestro the ipNumSiniestro to set
	 */
	public void setIpNumSiniestro(String ipNumSiniestro) {
		this.ipNumSiniestro = ipNumSiniestro;
	}


	/**
	 * @return the ipUbicacion
	 */
	public String getIpUbicacion() {
		return ipUbicacion;
	}


	/**
	 * @param ipUbicacion the ipUbicacion to set
	 */
	public void setIpUbicacion(String ipUbicacion) {
		this.ipUbicacion = ipUbicacion;
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
	 * @return the respuestaFtp
	 */
	public String getRespuestaFtp() {
		return respuestaFtp;
	}


	/**
	 * @param respuestaFtp the respuestaFtp to set
	 */
	public void setRespuestaFtp(String respuestaFtp) {
		this.respuestaFtp = respuestaFtp;
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