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
 public abstract class AbstractFormatoInventarioAutomoviles extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	 @SequenceGenerator(name = "opInventarioSEQ", sequenceName = "formato_inventario_automoviles_seq", allocationSize = 1)
	 @Id
	 @Column(name = "IA_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opInventarioSEQ")
	 private Integer id;
	
	 
	 @Column(name="ENVIADO_FTP")
		private Integer enviadoFtp;

		@Column(name="FTP_RESPUESTA", length=255)
		private String ftpRespuesta;

		@Column(name="IA_ANIO_AUTO", length=20)
		private String iaAnioAuto;

		@Column(name="IA_ASEGURADO", length=5)
		private String iaAsegurado;

		@Column(name="IA_CANTIDAD", length=2)
		private String iaCantidad;
		
		@Column(name="EMAIL_DEFAULT")
		private String emailDefault;

		@Column(name="IA_CLAVE_AJUSTADOR")
		private String iaClaveAjustador;

		@Column(name="IA_COLOR_AUTO", length=20)
		private String iaColorAuto;

		@Column(name="IA_COMBUSTIBLE")
		private Integer iaCombustible;

		@Column(name="IA_DES_AUTO", length=4000)
		private String iaDesAuto;

		@Column(name="IA_DESTINO")
		private Integer iaDestino;

		@Column(name="IA_DIR_DESTINO", length=150)
		private String iaDirDestino;

	


		@Column(name="IA_HORA")
		private Timestamp iaHora;

		@Column(name="IA_INVENTARIO_1", length=4000)
		private String iaInventario1;

		@Column(name="IA_INVENTARIO_2", length=4000)
		private String iaInventario2;

		@Column(name="IA_INVENTARIO_3", length=4000)
		private String iaInventario3;

		@Column(name="IA_INVENTARIO_4", length=4000)
		private String iaInventario4;

		@Column(name="IA_INVENTARIO_5", length=4000)
		private String iaInventario5;

		@Column(name="IA_KILOMETRAJE", length=20)
		private String iaKilometraje;

		@Column(name="IA_LLAVES")
		private Integer iaLlaves;

		@Column(name="IA_MARCA_AUTO", length=30)
		private String iaMarcaAuto;


		@Column(name="IA_NOM_AJUSTADOR", length=100)
		private String iaNomAjustador;

		@Column(name="IA_NOM_ASEGURADO", length=100)
		private String iaNomAsegurado;

		@Column(name="IA_NOM_DESTINO", length=100)
		private String iaNomDestino;

		@Column(name="IA_NOM_OPERADOR", length=100)
		private String iaNomOperador;

		@Column(name="IA_NOM_RAZON", length=100)
		private String iaNomRazon;

		@Column(name="IA_NUM_INCISO", length=20)
		private String iaNumInciso;

		@Column(name="IA_NUM_MOTOR", length=20)
		private String iaNumMotor;

		@Column(name="IA_NUM_POLIZA", length=20)
		private String iaNumPoliza;

		@Column(name="IA_NUM_REPORTE", length=20)
		private String iaNumReporte;

		@Column(name="IA_NUM_SERIE", length=20)
		private String iaNumSerie;

		@Column(name="IA_NUM_SINIESTRO", length=20)
		private String iaNumSiniestro;

		@Column(name="IA_OBSERVACION", length=200)
		private String iaObservacion;

		@Column(name="IA_PLACAS_AUTO", length=20)
		private String iaPlacasAuto;

		@Column(name="IA_PUERTAS_AUTO")
		private Integer iaPuertasAuto;

		@Column(name="IA_T_MANUAL")
		private Integer iaTManual;

		@Column(name="IA_TIPO_AUTO", length=30)
		private String iaTipoAuto;

		@Column(name="IA_VIDA_LLANTAS")
		private Integer iaVidaLlantas;
		
		@Column(name="IA_OBJETOS_PER")
		private Integer iaObjetosPer;

	
	 
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
	    
	    
	    @Column(name = "FIRMA_ASEGURADO")
		private String firmaAsegurado;
	    
	    @Column(name = "FIRMA_OPER_RECIBE")
		private String firmaOperRecibe;
	    
	    @Column(name = "FIRMA_AJUS_RECIBE")
		private String firmaAjusRecibe;
	    
	    @Column(name="NIU")
		private String niu;
	    
	    @Column(name="IA_CORREO_GRUA", length=255)
		private String iaCorreoGrua;
	    
	   @Column(name = "IA_CORREO_TALLER", length = 255)
		private String iaCorreoTaller;
	   
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
	public AbstractFormatoInventarioAutomoviles() {
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
	 * @return the iaAnioAuto
	 */
	public String getIaAnioAuto() {
		return iaAnioAuto;
	}



	/**
	 * @param iaAnioAuto the iaAnioAuto to set
	 */
	public void setIaAnioAuto(String iaAnioAuto) {
		this.iaAnioAuto = iaAnioAuto;
	}






	/**
	 * @return the iaAsegurado
	 */
	public String getIaAsegurado() {
		return iaAsegurado;
	}





	/**
	 * @param iaAsegurado the iaAsegurado to set
	 */
	public void setIaAsegurado(String iaAsegurado) {
		this.iaAsegurado = iaAsegurado;
	}





	/**
	 * @return the iaCantidad
	 */
	public String getIaCantidad() {
		return iaCantidad;
	}



	/**
	 * @param iaCantidad the iaCantidad to set
	 */
	public void setIaCantidad(String iaCantidad) {
		this.iaCantidad = iaCantidad;
	}



	/**
	 * @return the iaClaveAjustador
	 */
	public String getIaClaveAjustador() {
		return iaClaveAjustador;
	}



	/**
	 * @param iaClaveAjustador the iaClaveAjustador to set
	 */
	public void setIaClaveAjustador(String iaClaveAjustador) {
		this.iaClaveAjustador = iaClaveAjustador;
	}



	/**
	 * @return the iaColorAuto
	 */
	public String getIaColorAuto() {
		return iaColorAuto;
	}



	/**
	 * @param iaColorAuto the iaColorAuto to set
	 */
	public void setIaColorAuto(String iaColorAuto) {
		this.iaColorAuto = iaColorAuto;
	}



	/**
	 * @return the iaCombustible
	 */
	public Integer getIaCombustible() {
		return iaCombustible;
	}



	/**
	 * @param iaCombustible the iaCombustible to set
	 */
	public void setIaCombustible(Integer iaCombustible) {
		this.iaCombustible = iaCombustible;
	}



	/**
	 * @return the iaDesAuto
	 */
	public String getIaDesAuto() {
		return iaDesAuto;
	}



	/**
	 * @param iaDesAuto the iaDesAuto to set
	 */
	public void setIaDesAuto(String iaDesAuto) {
		this.iaDesAuto = iaDesAuto;
	}



	/**
	 * @return the iaDestino
	 */
	public Integer getIaDestino() {
		return iaDestino;
	}



	/**
	 * @param iaDestino the iaDestino to set
	 */
	public void setIaDestino(Integer iaDestino) {
		this.iaDestino = iaDestino;
	}



	/**
	 * @return the iaDirDestino
	 */
	public String getIaDirDestino() {
		return iaDirDestino;
	}



	/**
	 * @param iaDirDestino the iaDirDestino to set
	 */
	public void setIaDirDestino(String iaDirDestino) {
		this.iaDirDestino = iaDirDestino;
	}





	



	/**
	 * @return the iaHora
	 */
	public Timestamp getIaHora() {
		return iaHora;
	}



	/**
	 * @param iaHora the iaHora to set
	 */
	public void setIaHora(Timestamp iaHora) {
		this.iaHora = iaHora;
	}



	/**
	 * @return the iaInventario1
	 */
	public String getIaInventario1() {
		return iaInventario1;
	}



	/**
	 * @param iaInventario1 the iaInventario1 to set
	 */
	public void setIaInventario1(String iaInventario1) {
		this.iaInventario1 = iaInventario1;
	}



	/**
	 * @return the iaInventario2
	 */
	public String getIaInventario2() {
		return iaInventario2;
	}



	/**
	 * @param iaInventario2 the iaInventario2 to set
	 */
	public void setIaInventario2(String iaInventario2) {
		this.iaInventario2 = iaInventario2;
	}



	/**
	 * @return the iaInventario3
	 */
	public String getIaInventario3() {
		return iaInventario3;
	}



	/**
	 * @param iaInventario3 the iaInventario3 to set
	 */
	public void setIaInventario3(String iaInventario3) {
		this.iaInventario3 = iaInventario3;
	}



	/**
	 * @return the iaInventario4
	 */
	public String getIaInventario4() {
		return iaInventario4;
	}



	/**
	 * @param iaInventario4 the iaInventario4 to set
	 */
	public void setIaInventario4(String iaInventario4) {
		this.iaInventario4 = iaInventario4;
	}



	/**
	 * @return the iaInventario5
	 */
	public String getIaInventario5() {
		return iaInventario5;
	}



	/**
	 * @param iaInventario5 the iaInventario5 to set
	 */
	public void setIaInventario5(String iaInventario5) {
		this.iaInventario5 = iaInventario5;
	}



	/**
	 * @return the iaKilometraje
	 */
	public String getIaKilometraje() {
		return iaKilometraje;
	}



	/**
	 * @param iaKilometraje the iaKilometraje to set
	 */
	public void setIaKilometraje(String iaKilometraje) {
		this.iaKilometraje = iaKilometraje;
	}



	/**
	 * @return the iaLlaves
	 */
	public Integer getIaLlaves() {
		return iaLlaves;
	}



	/**
	 * @param iaLlaves the iaLlaves to set
	 */
	public void setIaLlaves(Integer iaLlaves) {
		this.iaLlaves = iaLlaves;
	}



	/**
	 * @return the iaMarcaAuto
	 */
	public String getIaMarcaAuto() {
		return iaMarcaAuto;
	}



	/**
	 * @param iaMarcaAuto the iaMarcaAuto to set
	 */
	public void setIaMarcaAuto(String iaMarcaAuto) {
		this.iaMarcaAuto = iaMarcaAuto;
	}



	



	/**
	 * @return the iaNomAjustador
	 */
	public String getIaNomAjustador() {
		return iaNomAjustador;
	}



	/**
	 * @param iaNomAjustador the iaNomAjustador to set
	 */
	public void setIaNomAjustador(String iaNomAjustador) {
		this.iaNomAjustador = iaNomAjustador;
	}



	/**
	 * @return the iaNomAsegurado
	 */
	public String getIaNomAsegurado() {
		return iaNomAsegurado;
	}



	/**
	 * @param iaNomAsegurado the iaNomAsegurado to set
	 */
	public void setIaNomAsegurado(String iaNomAsegurado) {
		this.iaNomAsegurado = iaNomAsegurado;
	}



	/**
	 * @return the iaNomDestino
	 */
	public String getIaNomDestino() {
		return iaNomDestino;
	}



	/**
	 * @param iaNomDestino the iaNomDestino to set
	 */
	public void setIaNomDestino(String iaNomDestino) {
		this.iaNomDestino = iaNomDestino;
	}



	/**
	 * @return the iaNomOperador
	 */
	public String getIaNomOperador() {
		return iaNomOperador;
	}



	/**
	 * @param iaNomOperador the iaNomOperador to set
	 */
	public void setIaNomOperador(String iaNomOperador) {
		this.iaNomOperador = iaNomOperador;
	}



	/**
	 * @return the iaNomRazon
	 */
	public String getIaNomRazon() {
		return iaNomRazon;
	}



	/**
	 * @param iaNomRazon the iaNomRazon to set
	 */
	public void setIaNomRazon(String iaNomRazon) {
		this.iaNomRazon = iaNomRazon;
	}



	/**
	 * @return the iaNumInciso
	 */
	public String getIaNumInciso() {
		return iaNumInciso;
	}



	/**
	 * @param iaNumInciso the iaNumInciso to set
	 */
	public void setIaNumInciso(String iaNumInciso) {
		this.iaNumInciso = iaNumInciso;
	}



	/**
	 * @return the iaNumMotor
	 */
	public String getIaNumMotor() {
		return iaNumMotor;
	}



	/**
	 * @param iaNumMotor the iaNumMotor to set
	 */
	public void setIaNumMotor(String iaNumMotor) {
		this.iaNumMotor = iaNumMotor;
	}



	/**
	 * @return the iaNumPoliza
	 */
	public String getIaNumPoliza() {
		return iaNumPoliza;
	}



	/**
	 * @param iaNumPoliza the iaNumPoliza to set
	 */
	public void setIaNumPoliza(String iaNumPoliza) {
		this.iaNumPoliza = iaNumPoliza;
	}



	/**
	 * @return the iaNumReporte
	 */
	public String getIaNumReporte() {
		return iaNumReporte;
	}



	/**
	 * @param iaNumReporte the iaNumReporte to set
	 */
	public void setIaNumReporte(String iaNumReporte) {
		this.iaNumReporte = iaNumReporte;
	}



	/**
	 * @return the iaNumSerie
	 */
	public String getIaNumSerie() {
		return iaNumSerie;
	}



	/**
	 * @param iaNumSerie the iaNumSerie to set
	 */
	public void setIaNumSerie(String iaNumSerie) {
		this.iaNumSerie = iaNumSerie;
	}



	/**
	 * @return the iaNumSiniestro
	 */
	public String getIaNumSiniestro() {
		return iaNumSiniestro;
	}



	/**
	 * @param iaNumSiniestro the iaNumSiniestro to set
	 */
	public void setIaNumSiniestro(String iaNumSiniestro) {
		this.iaNumSiniestro = iaNumSiniestro;
	}



	/**
	 * @return the iaObservacion
	 */
	public String getIaObservacion() {
		return iaObservacion;
	}



	/**
	 * @param iaObservacion the iaObservacion to set
	 */
	public void setIaObservacion(String iaObservacion) {
		this.iaObservacion = iaObservacion;
	}



	/**
	 * @return the iaPlacasAuto
	 */
	public String getIaPlacasAuto() {
		return iaPlacasAuto;
	}



	/**
	 * @param iaPlacasAuto the iaPlacasAuto to set
	 */
	public void setIaPlacasAuto(String iaPlacasAuto) {
		this.iaPlacasAuto = iaPlacasAuto;
	}



	/**
	 * @return the iaPuertasAuto
	 */
	public Integer getIaPuertasAuto() {
		return iaPuertasAuto;
	}



	/**
	 * @param iaPuertasAuto the iaPuertasAuto to set
	 */
	public void setIaPuertasAuto(Integer iaPuertasAuto) {
		this.iaPuertasAuto = iaPuertasAuto;
	}



	/**
	 * @return the iaTManual
	 */
	public Integer getIaTManual() {
		return iaTManual;
	}



	/**
	 * @param iaTManual the iaTManual to set
	 */
	public void setIaTManual(Integer iaTManual) {
		this.iaTManual = iaTManual;
	}



	/**
	 * @return the iaTipoAuto
	 */
	public String getIaTipoAuto() {
		return iaTipoAuto;
	}



	/**
	 * @param iaTipoAuto the iaTipoAuto to set
	 */
	public void setIaTipoAuto(String iaTipoAuto) {
		this.iaTipoAuto = iaTipoAuto;
	}



	/**
	 * @return the iaVidaLlantas
	 */
	public Integer getIaVidaLlantas() {
		return iaVidaLlantas;
	}



	/**
	 * @param iaVidaLlantas the iaVidaLlantas to set
	 */
	public void setIaVidaLlantas(Integer iaVidaLlantas) {
		this.iaVidaLlantas = iaVidaLlantas;
	}




	
	

	/**
	 * @return the iaObjetosPer
	 */
	public Integer getIaObjetosPer() {
		return iaObjetosPer;
	}





	/**
	 * @param iaObjetosPer the iaObjetosPer to set
	 */
	public void setIaObjetosPer(Integer iaObjetosPer) {
		this.iaObjetosPer = iaObjetosPer;
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





	/**
	 * @return the firmaOperRecibe
	 */
	public String getFirmaOperRecibe() {
		return firmaOperRecibe;
	}





	/**
	 * @param firmaOperRecibe the firmaOperRecibe to set
	 */
	public void setFirmaOperRecibe(String firmaOperRecibe) {
		this.firmaOperRecibe = firmaOperRecibe;
	}





	/**
	 * @return the firmaAjusRecibe
	 */
	public String getFirmaAjusRecibe() {
		return firmaAjusRecibe;
	}





	/**
	 * @param firmaAjusRecibe the firmaAjusRecibe to set
	 */
	public void setFirmaAjusRecibe(String firmaAjusRecibe) {
		this.firmaAjusRecibe = firmaAjusRecibe;
	}





	public String getNiu() {
		return niu;
	}





	public void setNiu(String niu) {
		this.niu = niu;
	}



	
	
	public String getIaCorreoGrua() {
		return iaCorreoGrua;
	}


	public void setIaCorreoGrua(String iaCorreoGrua) {
		this.iaCorreoGrua = iaCorreoGrua;
	}


	public String getIaCorreoTaller() {
		return iaCorreoTaller;
	}


	public void setIaCorreoTaller(String iaCorreoTaller) {
		this.iaCorreoTaller = iaCorreoTaller;
	}




}