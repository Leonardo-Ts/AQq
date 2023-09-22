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
 public abstract class AbstractFormatoInventarioUnicoPesado extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opInspeccionUPSEQ", sequenceName = "formato_inspeccion_unico_pesado_seq", allocationSize = 1)
	 @Id
	 @Column(name = "INP_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opInspeccionUPSEQ")
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
    
   
     @Column(name="INP_NUM_REPORTE") 
     private String inNumReporte; 
     
	 @Column(name="INP_NUM_SINIESTRO") 
	 private String inp_num_siniestro;
	 
	 @Column(name="INP_NUM_POLIZA") 
	 private String inpNumPoliza;
	 
	 @Column(name="INP_NUM_ASEGURADO") 
	 private String inpNumAsegurado; 
	 
	 @Column(name="INP_NOMBRE_AFECTADO") 
	 private String inpNombreAfectado;  
	 
	 @Column(name="INP_LLAVES") 
	 private Integer inp_llaves; 
	 
	 @Column(name="INP_FECHA") 
	 private Timestamp inp_fecha; 
	 
	 @Column(name="INP_NUM_ENDOSO") 
	 private String inp_num_endoso;
	 
	 @Column(name="INP_NUM_INCISO") 
	 private String inp_num_inciso;
	 
	 @Column(name="INP_MARCA") 
	 private String inp_marca;
	 
	 @Column(name="INP_TIPO") 
	 private String inpTipo;
	 
	 @Column(name="INP_PUERTAS")
	 private String inpPuertas;
	 
	 @Column(name="INP_MODELO") 
	 private String inpModelo;
	 
	 @Column(name="INP_NUM_MOTOR") 
	 private String inpNumMotor;
	 
	 @Column(name="INP_KILOMETRAJE") 
	 private String inpKilometraje;
	 
	 @Column(name="INP_COMBUSTIBLE") 
	 private Integer inpCombustible;
	 
	 @Column(name="INP_CORREO") 
	 private String inpCorreo;
	 
	 @Column(name="INP_TRACTOCAMION_PIEZA") 
	 private String inpTractocamionPieza;
	 
	 @Column(name="INP_ORIGINALES_CAMION") 
	 private String inpOriginalesCamion;
	 
	 @Column(name="INP_RENOVADAS_CAMION") 
	 private String inpRenovadasCamion;
	 
	 @Column(name="INP_DANIADAS_CAMION") 
	 private String inpDaniadasCamion;
	 
	 @Column(name="INP_FALTANTES_CAMION") 
	 private String inpFaltantesCamion;
	 
	 @Column(name="INP_DANIADAS_REMOLQUE") 
	 private String inpDaniadasRemolque;
	 
	 @Column(name="INP_FALTANTES_REMOLQUE")
	 private String inoFaltantesRemolque;
	 
	 @Column(name="INP_NOMBRE_CONDUCTOR") 
	 private String inpNombreConductor;
	 
	 @Column(name="INP_NOMBRE_OPERADOR_GRUA") 
	 private String inpNombreOperadorGrua;
	 
	 
	 @Column(name="INP_CASO1_FECHA") 
	 private  Date inpCaso1Fecha; 
	 
	 @Column(name="INP_CASO1_LUGAR") 
	 private String inpCaso1Lugar;
	 
	 @Column(name="INP_CASO1_OBSERVACIONES") 
	 private String inpCaso1Observaciones;
	 
	 @Column(name="INP_CASO1_NOM_ENTREGA") 
	 private String inpCaso1NomEntrega;
	 
	 @Column(name="INP_CASO1_NOM_RECIBE") 
	 private String inpCaso1NomRecibe;
	 
	 
	 
	 @Column(name="INP_CASO2_FECHA") 
	 private  Date inpCaso2Fecha; 
	 
	 @Column(name="INP_CASO2_LUGAR") 
	 private String inpCaso2Lugar;
	 
	 @Column(name="INP_CASO2_OBSERVACIONES") 
	 private String inpCaso2Observaciones;
	 
	 @Column(name="INP_CASO2_NOM_ENTREGA") 
	 private String inpCaso2NomEntrega;
	 
	 @Column(name="INP_CASO2_NOM_RECIBE") 
	 private String inpCaso2NomRecibe;
	 
	 
	 @Column(name="INP_CASO3_FECHA") 
	 private  Date inpCaso3Fecha; 
	 
	 @Column(name="INP_CASO3_LUGAR") 
	 private String inpCaso3Lugar;
	 
	 @Column(name="INP_CASO3_OBSERVACIONES") 
	 private String inpCaso3Observaciones;
	 
	 @Column(name="INP_CASO3_NOM_ENTREGA") 
	 private String inpCaso3NomEntrega;
	 
	 @Column(name="INP_CASO3_NOM_RECIBE") 
	 private String inpCaso3NomRecibe;
	 
	 @Column(name="FIRMA_AJUSTADOR") 
	 private String firmaAjustador;
	 
	 @Column(name="FIRMA_CONDUCTOR") 
	 private String firmaConductor;
	 
	 @Column(name=	"FIRMA_OPERADOR_GRUA") 
	 private String firmaOperadoGrua;
	 
	 @Column(name="FIRMA_CASO1_ENTREGA") 
	 private String FIRMA_CASO1_ENTREGA;
	 
	@Column(name="FIRMA_CASO1_RECIBE") 
	private String FIRMA_CASO1_RECIBE;
	
	@Column(name="FIRMA_CASO2_ENTREGA") 
	private String FIRMA_CASO2_ENTREGA;
	
	@Column(name="FIRMA_CASO2_RECIBE") 
	private String FIRMA_CASO2_RECIBE;
	
	@Column(name="FIRMA_CASO3_ENTREGA") 
	private String FIRMA_CASO3_ENTREGA;
	
	@Column(name="FIRMA_CASO3_RECIBE") 
	private String FIRMA_CASO3_RECIBE;
	
	 @Column(name="INP_NOM_AJUSTADOR") 
	 private String inpNomAjustador;
	 
	 @Column(name="INP_CLAVE_AJUSTADOR") 
	 private String inpClaveAjustador;
	 
	 @Column(name="INP_FOLIO_E") 
	 private String inpFolioE;
	 
	 @Column(name="INP_SERIE") 
	 private String inpSerie;
	 
	 @Column(name="INP_COLOR") 
	 private String inpColor;
	 
	 @Column(name="INP_PLACAS") 
	 private String inpPlacas;
	 


		@Column(name="INP_CORREO_GRUA") 
	private String inpCorreoGrua;

	 	@Column(name="INP_CORREO_TALLER") 
	private String inpCorreoTaller;

	 	@Column(name="INP_CASO_1_UBICACION_FLECHA") 
	private Integer inpCaso1UbicacionFlecha;

		@Column(name="INP_CASO_1_A_LUGAR") 
	private String inpCaso1ALugar;

		@Column(name="INP_CASO_1_PRESTADOR") 
	private String inpCaso1Prestador;

		@Column(name="INP_CASO_1_DANIOS_FALTANTES") 
	private String inpCaso1DaniosFaltantes;

		@Column(name="INP_CASO_1_CRUCERO") 
	private String inpCaso1Crucero;

		@Column(name="INP_CASO_1_TALLER") 
	private String inpCaso1Taller;

		@Column(name="INP_CASO_1_MP") 
	private String inpCaso1Mp;

		@Column(name="INP_CASO_1_AJUSTADOR") 
	private String inpCaso1Ajustador;


	 	@Column(name="INP_CASO_2_UBICACION_FLECHA") 
	private Integer inpCaso2UbicacionFlecha;

		@Column(name="INP_CASO_2_A_LUGAR") 
	private String inpCaso2ALugar;

		@Column(name="INP_CASO_2_PRESTADOR") 
	private String inpCaso2Prestador;

		@Column(name="INP_CASO_2_DANIOS_FALTANTES") 
	private String inpCaso2DaniosFaltantes;

		@Column(name="INP_CASO_2_CRUCERO") 
	private String inpCaso2Crucero;

		@Column(name="INP_CASO_2_TALLER") 
	private String inpCaso2Taller;

		@Column(name="INP_CASO_2_MP") 
	private String inpCaso2Mp;

		@Column(name="INP_CASO_2_AJUSTADOR") 
	private String inpCaso2Ajustador;

	

	@Column(name="INP_CASO_3_UBICACION_FLECHA") 
	private Integer inpCaso3UbicacionFlecha;

		@Column(name="INP_CASO_3_A_LUGAR") 
	private String inpCaso3ALugar;

		@Column(name="INP_CASO_3_PRESTADOR") 
	private String inpCaso3Prestador;

		@Column(name="INP_CASO_3_DANIOS_FALTANTES") 
	private String inpCaso3DaniosFaltantes;

		@Column(name="INP_CASO_3_CRUCERO") 
	private String inpCaso3Crucero;

		@Column(name="INP_CASO_3_TALLER") 
	private String inpCaso3Taller;

		@Column(name="INP_CASO_3_MP") 
	private String inpCaso3Mp;

		@Column(name="INP_CASO_3_AJUSTADOR") 
	private String inpCaso3Ajustador;


		@Column(name="INP_NOM_ENTREGA_GRAL") 
	private String inpNomEntregaGral;

			@Column(name="INP_NOM_RECIBE_GRAL") 
	private String inpNomRecibeGral;

			@Column(name="FIRMA_RECIBE_GRAL") 
	private String firmaRecibeGral;

			@Column(name="FIRMA_ENTREGA_GRAL") 
	private String firmaEntregaGral;
			
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

	

	public String getInNumReporte() {
		return inNumReporte;
	}

	public void setInNumReporte(String inNumReporte) {
		this.inNumReporte = inNumReporte;
	}

	public String getInp_num_siniestro() {
		return inp_num_siniestro;
	}

	public void setInp_num_siniestro(String inp_num_siniestro) {
		this.inp_num_siniestro = inp_num_siniestro;
	}

	public String getInpNumPoliza() {
		return inpNumPoliza;
	}

	public void setInpNumPoliza(String inpNumPoliza) {
		this.inpNumPoliza = inpNumPoliza;
	}

	public String getInpNumAsegurado() {
		return inpNumAsegurado;
	}

	public void setInpNumAsegurado(String inpNumAsegurado) {
		this.inpNumAsegurado = inpNumAsegurado;
	}

	public String getInpNombreAfectado() {
		return inpNombreAfectado;
	}

	public void setInpNombreAfectado(String inpNombreAfectado) {
		this.inpNombreAfectado = inpNombreAfectado;
	}

	

	public Timestamp getInp_fecha() {
		return inp_fecha;
	}

	public void setInp_fecha(Timestamp inp_fecha) {
		this.inp_fecha = inp_fecha;
	}

	public String getInp_num_endoso() {
		return inp_num_endoso;
	}

	public void setInp_num_endoso(String inp_num_endoso) {
		this.inp_num_endoso = inp_num_endoso;
	}

	public String getInp_num_inciso() {
		return inp_num_inciso;
	}

	public void setInp_num_inciso(String inp_num_inciso) {
		this.inp_num_inciso = inp_num_inciso;
	}

	public String getInp_marca() {
		return inp_marca;
	}

	public void setInp_marca(String inp_marca) {
		this.inp_marca = inp_marca;
	}

	public String getInpTipo() {
		return inpTipo;
	}

	public void setInpTipo(String inpTipo) {
		this.inpTipo = inpTipo;
	}

	public String getInpPuertas() {
		return inpPuertas;
	}

	public void setInpPuertas(String inpPuertas) {
		this.inpPuertas = inpPuertas;
	}

	public String getInpModelo() {
		return inpModelo;
	}

	public void setInpModelo(String inpModelo) {
		this.inpModelo = inpModelo;
	}

	public String getInpNumMotor() {
		return inpNumMotor;
	}

	public void setInpNumMotor(String inpNumMotor) {
		this.inpNumMotor = inpNumMotor;
	}

	public String getInpKilometraje() {
		return inpKilometraje;
	}

	public void setInpKilometraje(String inpKilometraje) {
		this.inpKilometraje = inpKilometraje;
	}

	

	public String getInpCorreo() {
		return inpCorreo;
	}

	public void setInpCorreo(String inpCorreo) {
		this.inpCorreo = inpCorreo;
	}

	public String getInpTractocamionPieza() {
		return inpTractocamionPieza;
	}

	public void setInpTractocamionPieza(String inpTractocamionPieza) {
		this.inpTractocamionPieza = inpTractocamionPieza;
	}

	public String getInpOriginalesCamion() {
		return inpOriginalesCamion;
	}

	public void setInpOriginalesCamion(String inpOriginalesCamion) {
		this.inpOriginalesCamion = inpOriginalesCamion;
	}

	

	public String getInpRenovadasCamion() {
		return inpRenovadasCamion;
	}

	public void setInpRenovadasCamion(String inpRenovadasCamion) {
		this.inpRenovadasCamion = inpRenovadasCamion;
	}

	public String getInpDaniadasCamion() {
		return inpDaniadasCamion;
	}

	public void setInpDaniadasCamion(String inpDaniadasCamion) {
		this.inpDaniadasCamion = inpDaniadasCamion;
	}

	public String getInpFaltantesCamion() {
		return inpFaltantesCamion;
	}

	public void setInpFaltantesCamion(String inpFaltantesCamion) {
		this.inpFaltantesCamion = inpFaltantesCamion;
	}

	public String getInpDaniadasRemolque() {
		return inpDaniadasRemolque;
	}

	public void setInpDaniadasRemolque(String inpDaniadasRemolque) {
		this.inpDaniadasRemolque = inpDaniadasRemolque;
	}

	public String getInoFaltantesRemolque() {
		return inoFaltantesRemolque;
	}

	public void setInoFaltantesRemolque(String inoFaltantesRemolque) {
		this.inoFaltantesRemolque = inoFaltantesRemolque;
	}

	public String getInpNombreConductor() {
		return inpNombreConductor;
	}

	public void setInpNombreConductor(String inpNombreConductor) {
		this.inpNombreConductor = inpNombreConductor;
	}

	public String getInpNombreOperadorGrua() {
		return inpNombreOperadorGrua;
	}

	public void setInpNombreOperadorGrua(String inpNombreOperadorGrua) {
		this.inpNombreOperadorGrua = inpNombreOperadorGrua;
	}

	public Date getInpCaso1Fecha() {
		return inpCaso1Fecha;
	}

	public void setInpCaso1Fecha(Date inpCaso1Fecha) {
		this.inpCaso1Fecha = inpCaso1Fecha;
	}

	public String getInpCaso1Lugar() {
		return inpCaso1Lugar;
	}

	public void setInpCaso1Lugar(String inpCaso1Lugar) {
		this.inpCaso1Lugar = inpCaso1Lugar;
	}

	public String getInpCaso1Observaciones() {
		return inpCaso1Observaciones;
	}

	public void setInpCaso1Observaciones(String inpCaso1Observaciones) {
		this.inpCaso1Observaciones = inpCaso1Observaciones;
	}

	public String getInpCaso1NomEntrega() {
		return inpCaso1NomEntrega;
	}

	public void setInpCaso1NomEntrega(String inpCaso1NomEntrega) {
		this.inpCaso1NomEntrega = inpCaso1NomEntrega;
	}

	public String getInpCaso1NomRecibe() {
		return inpCaso1NomRecibe;
	}

	public void setInpCaso1NomRecibe(String inpCaso1NomRecibe) {
		this.inpCaso1NomRecibe = inpCaso1NomRecibe;
	}



	public String getFirmaAjustador() {
		return firmaAjustador;
	}

	public void setFirmaAjustador(String firmaAjustador) {
		this.firmaAjustador = firmaAjustador;
	}

	public String getFirmaConductor() {
		return firmaConductor;
	}

	public void setFirmaConductor(String firmaConductor) {
		this.firmaConductor = firmaConductor;
	}

	public String getFirmaOperadoGrua() {
		return firmaOperadoGrua;
	}

	public void setFirmaOperadoGrua(String firmaOperadoGrua) {
		this.firmaOperadoGrua = firmaOperadoGrua;
	}



	public String getInpNomAjustador() {
		return inpNomAjustador;
	}

	public void setInpNomAjustador(String inpNomAjustador) {
		this.inpNomAjustador = inpNomAjustador;
	}

	public String getInpClaveAjustador() {
		return inpClaveAjustador;
	}

	public void setInpClaveAjustador(String inpClaveAjustador) {
		this.inpClaveAjustador = inpClaveAjustador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getInpCaso2Fecha() {
		return inpCaso2Fecha;
	}

	public void setInpCaso2Fecha(Date inpCaso2Fecha) {
		this.inpCaso2Fecha = inpCaso2Fecha;
	}

	public String getInpCaso2Lugar() {
		return inpCaso2Lugar;
	}

	public void setInpCaso2Lugar(String inpCaso2Lugar) {
		this.inpCaso2Lugar = inpCaso2Lugar;
	}

	public String getInpCaso2Observaciones() {
		return inpCaso2Observaciones;
	}

	public void setInpCaso2Observaciones(String inpCaso2Observaciones) {
		this.inpCaso2Observaciones = inpCaso2Observaciones;
	}

	public String getInpCaso2NomEntrega() {
		return inpCaso2NomEntrega;
	}

	public void setInpCaso2NomEntrega(String inpCaso2NomEntrega) {
		this.inpCaso2NomEntrega = inpCaso2NomEntrega;
	}

	public String getInpCaso2NomRecibe() {
		return inpCaso2NomRecibe;
	}

	public void setInpCaso2NomRecibe(String inpCaso2NomRecibe) {
		this.inpCaso2NomRecibe = inpCaso2NomRecibe;
	}

	public Date getInpCaso3Fecha() {
		return inpCaso3Fecha;
	}

	public void setInpCaso3Fecha(Date inpCaso3Fecha) {
		this.inpCaso3Fecha = inpCaso3Fecha;
	}

	public String getInpCaso3Lugar() {
		return inpCaso3Lugar;
	}

	public void setInpCaso3Lugar(String inpCaso3Lugar) {
		this.inpCaso3Lugar = inpCaso3Lugar;
	}

	public String getInpCaso3Observaciones() {
		return inpCaso3Observaciones;
	}

	public void setInpCaso3Observaciones(String inpCaso3Observaciones) {
		this.inpCaso3Observaciones = inpCaso3Observaciones;
	}

	public String getInpCaso3NomEntrega() {
		return inpCaso3NomEntrega;
	}

	public void setInpCaso3NomEntrega(String inpCaso3NomEntrega) {
		this.inpCaso3NomEntrega = inpCaso3NomEntrega;
	}

	public String getInpCaso3NomRecibe() {
		return inpCaso3NomRecibe;
	}

	public void setInpCaso3NomRecibe(String inpCaso3NomRecibe) {
		this.inpCaso3NomRecibe = inpCaso3NomRecibe;
	}

	public String getFIRMA_CASO1_ENTREGA() {
		return FIRMA_CASO1_ENTREGA;
	}

	public void setFIRMA_CASO1_ENTREGA(String fIRMA_CASO1_ENTREGA) {
		FIRMA_CASO1_ENTREGA = fIRMA_CASO1_ENTREGA;
	}

	public String getFIRMA_CASO1_RECIBE() {
		return FIRMA_CASO1_RECIBE;
	}

	public void setFIRMA_CASO1_RECIBE(String fIRMA_CASO1_RECIBE) {
		FIRMA_CASO1_RECIBE = fIRMA_CASO1_RECIBE;
	}

	public String getFIRMA_CASO2_ENTREGA() {
		return FIRMA_CASO2_ENTREGA;
	}

	public void setFIRMA_CASO2_ENTREGA(String fIRMA_CASO2_ENTREGA) {
		FIRMA_CASO2_ENTREGA = fIRMA_CASO2_ENTREGA;
	}

	public String getFIRMA_CASO2_RECIBE() {
		return FIRMA_CASO2_RECIBE;
	}

	public void setFIRMA_CASO2_RECIBE(String fIRMA_CASO2_RECIBE) {
		FIRMA_CASO2_RECIBE = fIRMA_CASO2_RECIBE;
	}

	public String getFIRMA_CASO3_ENTREGA() {
		return FIRMA_CASO3_ENTREGA;
	}

	public void setFIRMA_CASO3_ENTREGA(String fIRMA_CASO3_ENTREGA) {
		FIRMA_CASO3_ENTREGA = fIRMA_CASO3_ENTREGA;
	}

	public String getFIRMA_CASO3_RECIBE() {
		return FIRMA_CASO3_RECIBE;
	}

	public void setFIRMA_CASO3_RECIBE(String fIRMA_CASO3_RECIBE) {
		FIRMA_CASO3_RECIBE = fIRMA_CASO3_RECIBE;
	}

	public String getInpFolioE() {
		return inpFolioE;
	}

	public void setInpFolioE(String inpFolioE) {
		this.inpFolioE = inpFolioE;
	}

	public String getInpSerie() {
		return inpSerie;
	}

	public void setInpSerie(String inpSerie) {
		this.inpSerie = inpSerie;
	}

	public String getInpColor() {
		return inpColor;
	}

	public void setInpColor(String inpColor) {
		this.inpColor = inpColor;
	}

	public String getInpPlacas() {
		return inpPlacas;
	}

	public void setInpPlacas(String inpPlacas) {
		this.inpPlacas = inpPlacas;
	}

	public Integer getInp_llaves() {
		return inp_llaves;
	}

	public void setInp_llaves(Integer inp_llaves) {
		this.inp_llaves = inp_llaves;
	}

	public Integer getInpCombustible() {
		return inpCombustible;
	}

	public void setInpCombustible(Integer inpCombustible) {
		this.inpCombustible = inpCombustible;
	}

	public String getInpCorreoGrua() {
		return inpCorreoGrua;
	}

	public void setInpCorreoGrua(String inpCorreoGrua) {
		this.inpCorreoGrua = inpCorreoGrua;
	}

	public String getInpCorreoTaller() {
		return inpCorreoTaller;
	}

	public void setInpCorreoTaller(String inpCorreoTaller) {
		this.inpCorreoTaller = inpCorreoTaller;
	}

	public Integer getInpCaso1UbicacionFlecha() {
		return inpCaso1UbicacionFlecha;
	}

	public void setInpCaso1UbicacionFlecha(Integer inpCaso1UbicacionFlecha) {
		this.inpCaso1UbicacionFlecha = inpCaso1UbicacionFlecha;
	}

	public String getInpCaso1ALugar() {
		return inpCaso1ALugar;
	}

	public void setInpCaso1ALugar(String inpCaso1ALugar) {
		this.inpCaso1ALugar = inpCaso1ALugar;
	}

	public String getInpCaso1Prestador() {
		return inpCaso1Prestador;
	}

	public void setInpCaso1Prestador(String inpCaso1Prestador) {
		this.inpCaso1Prestador = inpCaso1Prestador;
	}

	public String getInpCaso1DaniosFaltantes() {
		return inpCaso1DaniosFaltantes;
	}

	public void setInpCaso1DaniosFaltantes(String inpCaso1DaniosFaltantes) {
		this.inpCaso1DaniosFaltantes = inpCaso1DaniosFaltantes;
	}

	public String getInpCaso1Crucero() {
		return inpCaso1Crucero;
	}

	public void setInpCaso1Crucero(String inpCaso1Crucero) {
		this.inpCaso1Crucero = inpCaso1Crucero;
	}

	public String getInpCaso1Taller() {
		return inpCaso1Taller;
	}

	public void setInpCaso1Taller(String inpCaso1Taller) {
		this.inpCaso1Taller = inpCaso1Taller;
	}

	public String getInpCaso1Mp() {
		return inpCaso1Mp;
	}

	public void setInpCaso1Mp(String inpCaso1Mp) {
		this.inpCaso1Mp = inpCaso1Mp;
	}

	public String getInpCaso1Ajustador() {
		return inpCaso1Ajustador;
	}

	public void setInpCaso1Ajustador(String inpCaso1Ajustador) {
		this.inpCaso1Ajustador = inpCaso1Ajustador;
	}

	public Integer getInpCaso2UbicacionFlecha() {
		return inpCaso2UbicacionFlecha;
	}

	public void setInpCaso2UbicacionFlecha(Integer inpCaso2UbicacionFlecha) {
		this.inpCaso2UbicacionFlecha = inpCaso2UbicacionFlecha;
	}

	public String getInpCaso2ALugar() {
		return inpCaso2ALugar;
	}

	public void setInpCaso2ALugar(String inpCaso2ALugar) {
		this.inpCaso2ALugar = inpCaso2ALugar;
	}

	public String getInpCaso2Prestador() {
		return inpCaso2Prestador;
	}

	public void setInpCaso2Prestador(String inpCaso2Prestador) {
		this.inpCaso2Prestador = inpCaso2Prestador;
	}

	public String getInpCaso2DaniosFaltantes() {
		return inpCaso2DaniosFaltantes;
	}

	public void setInpCaso2DaniosFaltantes(String inpCaso2DaniosFaltantes) {
		this.inpCaso2DaniosFaltantes = inpCaso2DaniosFaltantes;
	}

	public String getInpCaso2Crucero() {
		return inpCaso2Crucero;
	}

	public void setInpCaso2Crucero(String inpCaso2Crucero) {
		this.inpCaso2Crucero = inpCaso2Crucero;
	}

	public String getInpCaso2Taller() {
		return inpCaso2Taller;
	}

	public void setInpCaso2Taller(String inpCaso2Taller) {
		this.inpCaso2Taller = inpCaso2Taller;
	}

	public String getInpCaso2Mp() {
		return inpCaso2Mp;
	}

	public void setInpCaso2Mp(String inpCaso2Mp) {
		this.inpCaso2Mp = inpCaso2Mp;
	}

	public String getInpCaso2Ajustador() {
		return inpCaso2Ajustador;
	}

	public void setInpCaso2Ajustador(String inpCaso2Ajustador) {
		this.inpCaso2Ajustador = inpCaso2Ajustador;
	}

	public Integer getInpCaso3UbicacionFlecha() {
		return inpCaso3UbicacionFlecha;
	}

	public void setInpCaso3UbicacionFlecha(Integer inpCaso3UbicacionFlecha) {
		this.inpCaso3UbicacionFlecha = inpCaso3UbicacionFlecha;
	}

	public String getInpCaso3ALugar() {
		return inpCaso3ALugar;
	}

	public void setInpCaso3ALugar(String inpCaso3ALugar) {
		this.inpCaso3ALugar = inpCaso3ALugar;
	}

	public String getInpCaso3Prestador() {
		return inpCaso3Prestador;
	}

	public void setInpCaso3Prestador(String inpCaso3Prestador) {
		this.inpCaso3Prestador = inpCaso3Prestador;
	}

	public String getInpCaso3DaniosFaltantes() {
		return inpCaso3DaniosFaltantes;
	}

	public void setInpCaso3DaniosFaltantes(String inpCaso3DaniosFaltantes) {
		this.inpCaso3DaniosFaltantes = inpCaso3DaniosFaltantes;
	}

	public String getInpCaso3Crucero() {
		return inpCaso3Crucero;
	}

	public void setInpCaso3Crucero(String inpCaso3Crucero) {
		this.inpCaso3Crucero = inpCaso3Crucero;
	}

	public String getInpCaso3Taller() {
		return inpCaso3Taller;
	}

	public void setInpCaso3Taller(String inpCaso3Taller) {
		this.inpCaso3Taller = inpCaso3Taller;
	}

	public String getInpCaso3Mp() {
		return inpCaso3Mp;
	}

	public void setInpCaso3Mp(String inpCaso3Mp) {
		this.inpCaso3Mp = inpCaso3Mp;
	}

	public String getInpCaso3Ajustador() {
		return inpCaso3Ajustador;
	}

	public void setInpCaso3Ajustador(String inpCaso3Ajustador) {
		this.inpCaso3Ajustador = inpCaso3Ajustador;
	}

	public String getInpNomEntregaGral() {
		return inpNomEntregaGral;
	}

	public void setInpNomEntregaGral(String inpNomEntregaGral) {
		this.inpNomEntregaGral = inpNomEntregaGral;
	}

	public String getInpNomRecibeGral() {
		return inpNomRecibeGral;
	}

	public void setInpNomRecibeGral(String inpNomRecibeGral) {
		this.inpNomRecibeGral = inpNomRecibeGral;
	}

	public String getFirmaRecibeGral() {
		return firmaRecibeGral;
	}

	public void setFirmaRecibeGral(String firmaRecibeGral) {
		this.firmaRecibeGral = firmaRecibeGral;
	}

	public String getFirmaEntregaGral() {
		return firmaEntregaGral;
	}

	public void setFirmaEntregaGral(String firmaEntregaGral) {
		this.firmaEntregaGral = firmaEntregaGral;
	} 
	 
	
	
	
}