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
 public abstract class AbstractFormatoInspeccionMoto extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opIMotoSEQ", sequenceName = "formato_inspeccion_moto_seq", allocationSize = 1)
	@Id
	@Column(name = "IM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opIMotoSEQ")
	private Integer id;
	

	 


	 

	
		
	 @Column(name="ENVIADO_EMAIL")
		private Integer enviadoEmail;

		@Column(name="ENVIADO_FTP")
		private Integer enviadoFtp;

		@Column(name="FTP_RESPUESTA", length=255)
		private String ftpRespuesta;



		@Column(name="IM_ADAPTACIONES")
		private Integer imAdaptaciones;

		@Column(name="IM_ADAPTACIONES_SI_NO")
		private Integer imAdaptacionesSiNo;

		@Column(name="IM_ASEGURADO", length=5)
		private String imAsegurado;

		@Column(name="IM_ASEGURADO_COMPA")
		private Integer imAseguradoCompa;

		@Column(name="IM_ATENCION", length=100)
		private String imAtencion;

		@Column(name="IM_CIRCULACION")
		private Integer imCirculacion;

		@Column(name="IM_CLAVE_AJUSTADOR", length=20)
		private String imClaveAjustador;

		@Column(name="IM_COLOR", length=20)
		private String imColor;

		@Column(name="IM_COMPANIA", length=100)
		private String imCompania;

		@Temporal(TemporalType.DATE)
		@Column(name="IM_DIA_HORA")
		private Date imDiaHora;

		@Column(name="IM_DOCUMENTACION_1")
		private Integer imDocumentacion1;

		@Column(name="IM_DOCUMENTACION_2")
		private Integer imDocumentacion2;

		@Column(name="IM_EMAIL", length=50)
		private String imEmail;

		@Column(name="IM_EQUIPO_SI_NO")
		private Integer imEquipoSiNo;

		@Column(name="IM_ESTANDAR_T", length=1)
		private String imEstandarT;

		@Temporal(TemporalType.DATE)
		@Column(name="IM_FECHA")
		private Date imFecha;

		@Temporal(TemporalType.DATE)
		@Column(name="IM_FECHA_INSPECCION")
		private Date imFechaInspeccion;


		@Column(name="IM_IMPORTACION_1")
		private Integer imImportacion1;

		@Column(name="IM_KILOMETRAJE", length=20)
		private String imKilometraje;

		@Column(name="IM_MARCA", length=50)
		private String imMarca;

		@Column(name="IM_MODELO", length=50)
		private String imModelo;

		@Column(name="IM_NOM_AJUSTADOR", length=100)
		private String imNomAjustador;

		@Column(name="IM_NOM_CLIENTE", length=100)
		private String imNomCliente;

		@Column(name="IM_NUM_INCISO", length=20)
		private String imNumInciso;

		@Column(name="IM_NUM_POLIZA", length=20)
		private String imNumPoliza;

		@Column(name="IM_NUM_REPORTE", length=20)
		private String imNumReporte;

		@Column(name="IM_NUM_SERIE", length=50)
		private String imNumSerie;

		@Column(name="IM_NUM_SINIESTRO", length=20)
		private String imNumSiniestro;

		@Column(name="IM_OBSERVACIONES", length=500)
		private String imObservaciones;

		@Column(name="IM_OFICINA", length=100)
		private String imOficina;

		@Column(name="IM_PAGO")
		private Integer imPago;

		@Column(name="IM_PAGO_SI_NO")
		private Integer imPagoSiNo;

		@Column(name="IM_PLACAS", length=20)
		private String imPlacas;

		@Column(name="IM_PROCEDENCIA")
		private Integer imProcedencia;

		@Column(name="IM_SOLICITANTE", length=100)
		private String imSolicitante;

		@Column(name="IM_T_CIRCULACION_1")
		private Integer imTCirculacion1;

		@Column(name="IM_TELEFONO", length=15)
		private String imTelefono;

		@Column(name="IM_TIPO", length=50)
		private String imTipo;

		@Column(name="IM_TIPO_ENCARGADO")
		private Integer imTipoEncargado;

		@Column(name="IM_TOTAL_FOTOS", length=20)
		private String imTotalFotos;

		@Column(name="IM_UBICACION", length=200)
		private String imUbicacion;

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
	public AbstractFormatoInspeccionMoto() {
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
	 * @return the imAdaptaciones
	 */
	public Integer getImAdaptaciones() {
		return imAdaptaciones;
	}


	/**
	 * @param imAdaptaciones the imAdaptaciones to set
	 */
	public void setImAdaptaciones(Integer imAdaptaciones) {
		this.imAdaptaciones = imAdaptaciones;
	}


	/**
	 * @return the imAdaptacionesSiNo
	 */
	public Integer getImAdaptacionesSiNo() {
		return imAdaptacionesSiNo;
	}


	/**
	 * @param imAdaptacionesSiNo the imAdaptacionesSiNo to set
	 */
	public void setImAdaptacionesSiNo(Integer imAdaptacionesSiNo) {
		this.imAdaptacionesSiNo = imAdaptacionesSiNo;
	}


	


	/**
	 * @return the imAsegurado
	 */
	public String getImAsegurado() {
		return imAsegurado;
	}


	/**
	 * @param imAsegurado the imAsegurado to set
	 */
	public void setImAsegurado(String imAsegurado) {
		this.imAsegurado = imAsegurado;
	}


	/**
	 * @return the imAseguradoCompa
	 */
	public Integer getImAseguradoCompa() {
		return imAseguradoCompa;
	}


	/**
	 * @param imAseguradoCompa the imAseguradoCompa to set
	 */
	public void setImAseguradoCompa(Integer imAseguradoCompa) {
		this.imAseguradoCompa = imAseguradoCompa;
	}


	/**
	 * @return the imAtencion
	 */
	public String getImAtencion() {
		return imAtencion;
	}


	/**
	 * @param imAtencion the imAtencion to set
	 */
	public void setImAtencion(String imAtencion) {
		this.imAtencion = imAtencion;
	}


	/**
	 * @return the imCirculacion
	 */
	public Integer getImCirculacion() {
		return imCirculacion;
	}


	/**
	 * @param imCirculacion the imCirculacion to set
	 */
	public void setImCirculacion(Integer imCirculacion) {
		this.imCirculacion = imCirculacion;
	}


	/**
	 * @return the imClaveAjustador
	 */
	public String getImClaveAjustador() {
		return imClaveAjustador;
	}


	/**
	 * @param imClaveAjustador the imClaveAjustador to set
	 */
	public void setImClaveAjustador(String imClaveAjustador) {
		this.imClaveAjustador = imClaveAjustador;
	}


	/**
	 * @return the imColor
	 */
	public String getImColor() {
		return imColor;
	}


	/**
	 * @param imColor the imColor to set
	 */
	public void setImColor(String imColor) {
		this.imColor = imColor;
	}


	/**
	 * @return the imCompania
	 */
	public String getImCompania() {
		return imCompania;
	}


	/**
	 * @param imCompania the imCompania to set
	 */
	public void setImCompania(String imCompania) {
		this.imCompania = imCompania;
	}


	/**
	 * @return the imDiaHora
	 */
	public Date getImDiaHora() {
		return imDiaHora;
	}


	/**
	 * @param imDiaHora the imDiaHora to set
	 */
	public void setImDiaHora(Date imDiaHora) {
		this.imDiaHora = imDiaHora;
	}


	/**
	 * @return the imDocumentacion1
	 */
	public Integer getImDocumentacion1() {
		return imDocumentacion1;
	}


	/**
	 * @param imDocumentacion1 the imDocumentacion1 to set
	 */
	public void setImDocumentacion1(Integer imDocumentacion1) {
		this.imDocumentacion1 = imDocumentacion1;
	}


	/**
	 * @return the imDocumentacion2
	 */
	public Integer getImDocumentacion2() {
		return imDocumentacion2;
	}


	/**
	 * @param imDocumentacion2 the imDocumentacion2 to set
	 */
	public void setImDocumentacion2(Integer imDocumentacion2) {
		this.imDocumentacion2 = imDocumentacion2;
	}


	/**
	 * @return the imEmail
	 */
	public String getImEmail() {
		return imEmail;
	}


	/**
	 * @param imEmail the imEmail to set
	 */
	public void setImEmail(String imEmail) {
		this.imEmail = imEmail;
	}


	/**
	 * @return the imEquipoSiNo
	 */
	public Integer getImEquipoSiNo() {
		return imEquipoSiNo;
	}


	/**
	 * @param imEquipoSiNo the imEquipoSiNo to set
	 */
	public void setImEquipoSiNo(Integer imEquipoSiNo) {
		this.imEquipoSiNo = imEquipoSiNo;
	}


	/**
	 * @return the imEstandarT
	 */
	public String getImEstandarT() {
		return imEstandarT;
	}


	/**
	 * @param imEstandarT the imEstandarT to set
	 */
	public void setImEstandarT(String imEstandarT) {
		this.imEstandarT = imEstandarT;
	}


	/**
	 * @return the imFecha
	 */
	public Date getImFecha() {
		return imFecha;
	}


	/**
	 * @param imFecha the imFecha to set
	 */
	public void setImFecha(Date imFecha) {
		this.imFecha = imFecha;
	}


	/**
	 * @return the imFechaInspeccion
	 */
	public Date getImFechaInspeccion() {
		return imFechaInspeccion;
	}


	/**
	 * @param imFechaInspeccion the imFechaInspeccion to set
	 */
	public void setImFechaInspeccion(Date imFechaInspeccion) {
		this.imFechaInspeccion = imFechaInspeccion;
	}


	


	/**
	 * @return the imImportacion1
	 */
	public Integer getImImportacion1() {
		return imImportacion1;
	}


	/**
	 * @param imImportacion1 the imImportacion1 to set
	 */
	public void setImImportacion1(Integer imImportacion1) {
		this.imImportacion1 = imImportacion1;
	}


	/**
	 * @return the imKilometraje
	 */
	public String getImKilometraje() {
		return imKilometraje;
	}


	/**
	 * @param imKilometraje the imKilometraje to set
	 */
	public void setImKilometraje(String imKilometraje) {
		this.imKilometraje = imKilometraje;
	}


	/**
	 * @return the imMarca
	 */
	public String getImMarca() {
		return imMarca;
	}


	/**
	 * @param imMarca the imMarca to set
	 */
	public void setImMarca(String imMarca) {
		this.imMarca = imMarca;
	}


	/**
	 * @return the imModelo
	 */
	public String getImModelo() {
		return imModelo;
	}


	/**
	 * @param imModelo the imModelo to set
	 */
	public void setImModelo(String imModelo) {
		this.imModelo = imModelo;
	}


	/**
	 * @return the imNomAjustador
	 */
	public String getImNomAjustador() {
		return imNomAjustador;
	}


	/**
	 * @param imNomAjustador the imNomAjustador to set
	 */
	public void setImNomAjustador(String imNomAjustador) {
		this.imNomAjustador = imNomAjustador;
	}


	/**
	 * @return the imNomCliente
	 */
	public String getImNomCliente() {
		return imNomCliente;
	}


	/**
	 * @param imNomCliente the imNomCliente to set
	 */
	public void setImNomCliente(String imNomCliente) {
		this.imNomCliente = imNomCliente;
	}


	/**
	 * @return the imNumInciso
	 */
	public String getImNumInciso() {
		return imNumInciso;
	}


	/**
	 * @param imNumInciso the imNumInciso to set
	 */
	public void setImNumInciso(String imNumInciso) {
		this.imNumInciso = imNumInciso;
	}


	/**
	 * @return the imNumPoliza
	 */
	public String getImNumPoliza() {
		return imNumPoliza;
	}


	/**
	 * @param imNumPoliza the imNumPoliza to set
	 */
	public void setImNumPoliza(String imNumPoliza) {
		this.imNumPoliza = imNumPoliza;
	}


	/**
	 * @return the imNumReporte
	 */
	public String getImNumReporte() {
		return imNumReporte;
	}


	/**
	 * @param imNumReporte the imNumReporte to set
	 */
	public void setImNumReporte(String imNumReporte) {
		this.imNumReporte = imNumReporte;
	}


	/**
	 * @return the imNumSerie
	 */
	public String getImNumSerie() {
		return imNumSerie;
	}


	/**
	 * @param imNumSerie the imNumSerie to set
	 */
	public void setImNumSerie(String imNumSerie) {
		this.imNumSerie = imNumSerie;
	}


	/**
	 * @return the imNumSiniestro
	 */
	public String getImNumSiniestro() {
		return imNumSiniestro;
	}


	/**
	 * @param imNumSiniestro the imNumSiniestro to set
	 */
	public void setImNumSiniestro(String imNumSiniestro) {
		this.imNumSiniestro = imNumSiniestro;
	}


	/**
	 * @return the imObservaciones
	 */
	public String getImObservaciones() {
		return imObservaciones;
	}


	/**
	 * @param imObservaciones the imObservaciones to set
	 */
	public void setImObservaciones(String imObservaciones) {
		this.imObservaciones = imObservaciones;
	}


	/**
	 * @return the imOficina
	 */
	public String getImOficina() {
		return imOficina;
	}


	/**
	 * @param imOficina the imOficina to set
	 */
	public void setImOficina(String imOficina) {
		this.imOficina = imOficina;
	}


	/**
	 * @return the imPago
	 */
	public Integer getImPago() {
		return imPago;
	}


	/**
	 * @param imPago the imPago to set
	 */
	public void setImPago(Integer imPago) {
		this.imPago = imPago;
	}


	/**
	 * @return the imPagoSiNo
	 */
	public Integer getImPagoSiNo() {
		return imPagoSiNo;
	}


	/**
	 * @param imPagoSiNo the imPagoSiNo to set
	 */
	public void setImPagoSiNo(Integer imPagoSiNo) {
		this.imPagoSiNo = imPagoSiNo;
	}


	/**
	 * @return the imPlacas
	 */
	public String getImPlacas() {
		return imPlacas;
	}


	/**
	 * @param imPlacas the imPlacas to set
	 */
	public void setImPlacas(String imPlacas) {
		this.imPlacas = imPlacas;
	}


	/**
	 * @return the imProcedencia
	 */
	public Integer getImProcedencia() {
		return imProcedencia;
	}


	/**
	 * @param imProcedencia the imProcedencia to set
	 */
	public void setImProcedencia(Integer imProcedencia) {
		this.imProcedencia = imProcedencia;
	}


	/**
	 * @return the imSolicitante
	 */
	public String getImSolicitante() {
		return imSolicitante;
	}


	/**
	 * @param imSolicitante the imSolicitante to set
	 */
	public void setImSolicitante(String imSolicitante) {
		this.imSolicitante = imSolicitante;
	}


	/**
	 * @return the imTCirculacion1
	 */
	public Integer getImTCirculacion1() {
		return imTCirculacion1;
	}


	/**
	 * @param imTCirculacion1 the imTCirculacion1 to set
	 */
	public void setImTCirculacion1(Integer imTCirculacion1) {
		this.imTCirculacion1 = imTCirculacion1;
	}


	/**
	 * @return the imTelefono
	 */
	public String getImTelefono() {
		return imTelefono;
	}


	/**
	 * @param imTelefono the imTelefono to set
	 */
	public void setImTelefono(String imTelefono) {
		this.imTelefono = imTelefono;
	}


	/**
	 * @return the imTipo
	 */
	public String getImTipo() {
		return imTipo;
	}


	/**
	 * @param imTipo the imTipo to set
	 */
	public void setImTipo(String imTipo) {
		this.imTipo = imTipo;
	}


	/**
	 * @return the imTipoEncargado
	 */
	public Integer getImTipoEncargado() {
		return imTipoEncargado;
	}


	/**
	 * @param imTipoEncargado the imTipoEncargado to set
	 */
	public void setImTipoEncargado(Integer imTipoEncargado) {
		this.imTipoEncargado = imTipoEncargado;
	}


	/**
	 * @return the imTotalFotos
	 */
	public String getImTotalFotos() {
		return imTotalFotos;
	}


	/**
	 * @param imTotalFotos the imTotalFotos to set
	 */
	public void setImTotalFotos(String imTotalFotos) {
		this.imTotalFotos = imTotalFotos;
	}


	/**
	 * @return the imUbicacion
	 */
	public String getImUbicacion() {
		return imUbicacion;
	}


	/**
	 * @param imUbicacion the imUbicacion to set
	 */
	public void setImUbicacion(String imUbicacion) {
		this.imUbicacion = imUbicacion;
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