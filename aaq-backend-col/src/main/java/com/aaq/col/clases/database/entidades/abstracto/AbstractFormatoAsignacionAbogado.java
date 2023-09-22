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
 public abstract class AbstractFormatoAsignacionAbogado extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opAbogadoSEQ", sequenceName = "formato_asignacion_abogado_seq", allocationSize = 1)
	 @Id
	 @Column(name = "AA_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opAbogadoSEQ")
	 private Integer id;
	
	@Column(name="AA_ASEGURADO",length=5)
	private String aaAsegurado;

	@Column(name="AA_AUTORIDAD", length=100)
	private String aaAutoridad;

	@Column(name="AA_CLAVE_ABOGADO", length=20)
	private String aaClaveAbogado;

	@Column(name="AA_CLAVE_AJUSTADOR", length=20)
	private String aaClaveAjustador;

	@Column(name="AA_COLOR_AUTO", length=20)
	private String aaColorAuto;

	@Column(name="AA_COMENTARIOS", length=150)
	private String aaComentarios;

	@Column(name="AA_COPIA_LICENCIA")
	private Integer aaCopiaLicencia;

	@Column(name="AA_COPIA_POLIZA")
	private Integer aaCopiaPoliza;

	@Column(name="AA_DANIOS_ESTIMADOS", length=50)
	private String aaDaniosEstimados;

	@Column(name="AA_DANIOS_NA", precision=126)
	private double aaDaniosNa;

	@Column(name="AA_DECLARACION_CONDUC")
	private Integer aaDeclaracionConduc;

	@Column(name="AA_DEDUCIBLE_RC")
	private Integer aaDeducibleRc;

	@Column(name="AA_DES_DANIOS_TER", length=300)
	private String aaDesDaniosTer;

	@Column(name="AA_DESCRIPCION_DANIOS", length=150)
	private String aaDescripcionDanios;

	@Column(name="AA_EMAIL", length=50)
	private String aaEmail;

	

	@Column(name="AA_GRUA")
	private Integer aaGrua;

	@Column(name="AA_GRUA_TERCERO")
	private Integer aaGruaTercero;

	@Column(name="AA_HORA_ABOGADO")
	private Timestamp aaHoraAbogado;

	@Column(name="AA_HORA_SINIESTRO")
	private Timestamp aaHoraSiniestro;

	@Column(name="AA_HORA_TURNADO")
	private Timestamp aaHoraTurnado;

	@Column(name="AA_INFORME", length=150)
	private String aaInforme;

	@Column(name="AA_LUGAR_SINIESTRO")
	private String aaLugarSiniestro;

	@Column(name="AA_MARCA_AUTO")
	private String aaMarcaAuto;

	@Column(name="AA_MONTO_CRUCERO", precision=126)
	private double aaMontoCrucero;

	@Column(name="AA_MONTO_DEDUCIBLE", precision=126)
	private double aaMontoDeducible;

	@Column(name="AA_NOM_ABOGADO", length=100)
	private String aaNomAbogado;

	@Column(name="AA_NOM_AJUSTADOR", length=100)
	private String aaNomAjustador;

	@Column(name="AA_NOM_ASEGURADO", length=100)
	private String aaNomAsegurado;

	@Column(name="AA_NOM_CONDUCTOR", length=100)
	private String aaNomConductor;

	@Column(name="AA_NOM_LESIONADOS", length=150)
	private String aaNomLesionados;

	@Column(name="AA_NOM_TERCERO", length=100)
	private String aaNomTercero;

	@Column(name="AA_NUM_ACCIDENTE", length=20)
	private String aaNumAccidente;

	@Column(name="AA_NUM_INCISO", length=20)
	private String aaNumInciso;

	@Column(name="AA_NUM_POLIZA", length=20)
	private String aaNumPoliza;

	@Column(name="AA_NUM_REPORTE", length=20)
	private String aaNumReporte;

	@Column(name="AA_NUM_SINIESTRO", length=20)
	private String aaNumSiniestro;

	@Column(name="AA_ORDEN_ADMISION")
	private Integer aaOrdenAdmision;

	@Column(name="AA_OTROS", length=200)
	private String aaOtros;

	@Column(name="AA_PAGADO")
	private Integer aaPagado;

	@Column(name="AA_PARTE_ACCIDEN")
	private Integer aaParteAcciden;

	@Column(name="AA_PASE_MEDICO")
	private Integer aaPaseMedico;

	@Column(name="AA_PLACA_AUTO", length=20)
	private String aaPlacaAuto;

	@Column(name="AA_PREGUNTA_1A")
	private Integer aaPregunta1A;
	
	@Column(name="AA_PREGUNTA_1")
	private Integer aaPregunta1;
	
	@Column(name="AA_PREGUNTA_1B")
	private Integer aaPregunta1B;

	@Column(name="AA_PREGUNTA_2")
	private Integer aaPregunta2;

	@Column(name="AA_PREGUNTA_3")
	private Integer aaPregunta3;

	@Column(name="AA_PREGUNTA_4")
	private Integer aaPregunta4;

	@Column(name="AA_PREGUNTA_5")
	private Integer aaPregunta5;

	@Column(name="AA_PREGUNTA_6")
	private Integer aaPregunta6;
	
	@Column(name="AA_PREGUNTA_7A")
	private Integer aaPregunta7A;
	
	@Column(name="AA_PREGUNTA_7B")
	private Integer aaPregunta7B;
	
	

	@Column(name="AA_PRESU_ASEGURADO")
	private Integer aaPresuAsegurado;

	@Column(name="AA_PROPIETARIO")
	private Integer aaPropietario;

	@Column(name="AA_TEL_CASA", length=15)
	private String aaTelCasa;

	@Column(name="AA_TEL_CASA_TERCERO", length=15)
	private String aaTelCasaTercero;

	@Column(name="AA_TEL_OFICINA", length=15)
	private String aaTelOficina;

	@Column(name="AA_TEL_OFICINA_TERCERO", length=15)
	private String aaTelOficinaTercero;

	@Column(name="AA_TIPO_AUTO")
	private String aaTipoAuto;

	@Column(name="AA_UBICACION_ACTUAL")
	private String aaUbicacionActual;

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
    
    
    @Column(name = "FIRMA_AJUSTADOR")
   	private String firmaAjustador;
       
    @Column(name = "FIRMA_ASEGURADO")
    private String firmaAsegurado;
    
    @Column(name = "FIRMA_ABOGADO")
    private String firmaAbogado;
    
    @Column(name = "FIRMA_TERCERO")
   	private String firmaTercero;
    
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
	public AbstractFormatoAsignacionAbogado() {
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
	 * @return the aaAsegurado
	 */
	public String getAaAsegurado() {
		return aaAsegurado;
	}





	/**
	 * @param aaAsegurado the aaAsegurado to set
	 */
	public void setAaAsegurado(String aaAsegurado) {
		this.aaAsegurado = aaAsegurado;
	}





	/**
	 * @return the aaAutoridad
	 */
	public String getAaAutoridad() {
		return aaAutoridad;
	}


	/**
	 * @param aaAutoridad the aaAutoridad to set
	 */
	public void setAaAutoridad(String aaAutoridad) {
		this.aaAutoridad = aaAutoridad;
	}


	/**
	 * @return the aaClaveAbogado
	 */
	public String getAaClaveAbogado() {
		return aaClaveAbogado;
	}


	/**
	 * @param aaClaveAbogado the aaClaveAbogado to set
	 */
	public void setAaClaveAbogado(String aaClaveAbogado) {
		this.aaClaveAbogado = aaClaveAbogado;
	}


	/**
	 * @return the aaClaveAjustador
	 */
	public String getAaClaveAjustador() {
		return aaClaveAjustador;
	}


	/**
	 * @param aaClaveAjustador the aaClaveAjustador to set
	 */
	public void setAaClaveAjustador(String aaClaveAjustador) {
		this.aaClaveAjustador = aaClaveAjustador;
	}


	/**
	 * @return the aaColorAuto
	 */
	public String getAaColorAuto() {
		return aaColorAuto;
	}


	/**
	 * @param aaColorAuto the aaColorAuto to set
	 */
	public void setAaColorAuto(String aaColorAuto) {
		this.aaColorAuto = aaColorAuto;
	}


	/**
	 * @return the aaComentarios
	 */
	public String getAaComentarios() {
		return aaComentarios;
	}


	/**
	 * @param aaComentarios the aaComentarios to set
	 */
	public void setAaComentarios(String aaComentarios) {
		this.aaComentarios = aaComentarios;
	}


	/**
	 * @return the aaCopiaLicencia
	 */
	public Integer getAaCopiaLicencia() {
		return aaCopiaLicencia;
	}


	/**
	 * @param aaCopiaLicencia the aaCopiaLicencia to set
	 */
	public void setAaCopiaLicencia(Integer aaCopiaLicencia) {
		this.aaCopiaLicencia = aaCopiaLicencia;
	}


	/**
	 * @return the aaCopiaPoliza
	 */
	public Integer getAaCopiaPoliza() {
		return aaCopiaPoliza;
	}


	/**
	 * @param aaCopiaPoliza the aaCopiaPoliza to set
	 */
	public void setAaCopiaPoliza(Integer aaCopiaPoliza) {
		this.aaCopiaPoliza = aaCopiaPoliza;
	}


	/**
	 * @return the aaDaniosEstimados
	 */
	public String getAaDaniosEstimados() {
		return aaDaniosEstimados;
	}


	/**
	 * @param aaDaniosEstimados the aaDaniosEstimados to set
	 */
	public void setAaDaniosEstimados(String aaDaniosEstimados) {
		this.aaDaniosEstimados = aaDaniosEstimados;
	}


	/**
	 * @return the aaDaniosNa
	 */
	public double getAaDaniosNa() {
		return aaDaniosNa;
	}


	/**
	 * @param aaDaniosNa the aaDaniosNa to set
	 */
	public void setAaDaniosNa(double aaDaniosNa) {
		this.aaDaniosNa = aaDaniosNa;
	}


	/**
	 * @return the aaDeclaracionConduc
	 */
	public Integer getAaDeclaracionConduc() {
		return aaDeclaracionConduc;
	}


	/**
	 * @param aaDeclaracionConduc the aaDeclaracionConduc to set
	 */
	public void setAaDeclaracionConduc(Integer aaDeclaracionConduc) {
		this.aaDeclaracionConduc = aaDeclaracionConduc;
	}


	/**
	 * @return the aaDeducibleRc
	 */
	public Integer getAaDeducibleRc() {
		return aaDeducibleRc;
	}


	/**
	 * @param aaDeducibleRc the aaDeducibleRc to set
	 */
	public void setAaDeducibleRc(Integer aaDeducibleRc) {
		this.aaDeducibleRc = aaDeducibleRc;
	}


	/**
	 * @return the aaDesDaniosTer
	 */
	public String getAaDesDaniosTer() {
		return aaDesDaniosTer;
	}


	/**
	 * @param aaDesDaniosTer the aaDesDaniosTer to set
	 */
	public void setAaDesDaniosTer(String aaDesDaniosTer) {
		this.aaDesDaniosTer = aaDesDaniosTer;
	}


	/**
	 * @return the aaDescripcionDanios
	 */
	public String getAaDescripcionDanios() {
		return aaDescripcionDanios;
	}


	/**
	 * @param aaDescripcionDanios the aaDescripcionDanios to set
	 */
	public void setAaDescripcionDanios(String aaDescripcionDanios) {
		this.aaDescripcionDanios = aaDescripcionDanios;
	}


	/**
	 * @return the aaEmail
	 */
	public String getAaEmail() {
		return aaEmail;
	}


	/**
	 * @param aaEmail the aaEmail to set
	 */
	public void setAaEmail(String aaEmail) {
		this.aaEmail = aaEmail;
	}


	


	/**
	 * @return the aaGrua
	 */
	public Integer getAaGrua() {
		return aaGrua;
	}


	/**
	 * @param aaGrua the aaGrua to set
	 */
	public void setAaGrua(Integer aaGrua) {
		this.aaGrua = aaGrua;
	}


	/**
	 * @return the aaGruaTercero
	 */
	public Integer getAaGruaTercero() {
		return aaGruaTercero;
	}


	/**
	 * @param aaGruaTercero the aaGruaTercero to set
	 */
	public void setAaGruaTercero(Integer aaGruaTercero) {
		this.aaGruaTercero = aaGruaTercero;
	}


	/**
	 * @return the aaHoraAbogado
	 */
	public Timestamp getAaHoraAbogado() {
		return aaHoraAbogado;
	}


	/**
	 * @param aaHoraAbogado the aaHoraAbogado to set
	 */
	public void setAaHoraAbogado(Timestamp aaHoraAbogado) {
		this.aaHoraAbogado = aaHoraAbogado;
	}


	/**
	 * @return the aaHoraSiniestro
	 */
	public Timestamp getAaHoraSiniestro() {
		return aaHoraSiniestro;
	}


	/**
	 * @param aaHoraSiniestro the aaHoraSiniestro to set
	 */
	public void setAaHoraSiniestro(Timestamp aaHoraSiniestro) {
		this.aaHoraSiniestro = aaHoraSiniestro;
	}


	/**
	 * @return the aaHoraTurnado
	 */
	public Timestamp getAaHoraTurnado() {
		return aaHoraTurnado;
	}


	/**
	 * @param aaHoraTurnado the aaHoraTurnado to set
	 */
	public void setAaHoraTurnado(Timestamp aaHoraTurnado) {
		this.aaHoraTurnado = aaHoraTurnado;
	}


	/**
	 * @return the aaInforme
	 */
	public String getAaInforme() {
		return aaInforme;
	}


	/**
	 * @param aaInforme the aaInforme to set
	 */
	public void setAaInforme(String aaInforme) {
		this.aaInforme = aaInforme;
	}


	/**
	 * @return the aaLugarSiniestro
	 */
	public String getAaLugarSiniestro() {
		return aaLugarSiniestro;
	}


	/**
	 * @param aaLugarSiniestro the aaLugarSiniestro to set
	 */
	public void setAaLugarSiniestro(String aaLugarSiniestro) {
		this.aaLugarSiniestro = aaLugarSiniestro;
	}


	/**
	 * @return the aaMarcaAuto
	 */
	public String getAaMarcaAuto() {
		return aaMarcaAuto;
	}


	/**
	 * @param aaMarcaAuto the aaMarcaAuto to set
	 */
	public void setAaMarcaAuto(String aaMarcaAuto) {
		this.aaMarcaAuto = aaMarcaAuto;
	}


	/**
	 * @return the aaMontoCrucero
	 */
	public double getAaMontoCrucero() {
		return aaMontoCrucero;
	}


	/**
	 * @param aaMontoCrucero the aaMontoCrucero to set
	 */
	public void setAaMontoCrucero(double aaMontoCrucero) {
		this.aaMontoCrucero = aaMontoCrucero;
	}


	/**
	 * @return the aaMontoDeducible
	 */
	public double getAaMontoDeducible() {
		return aaMontoDeducible;
	}


	/**
	 * @param aaMontoDeducible the aaMontoDeducible to set
	 */
	public void setAaMontoDeducible(double aaMontoDeducible) {
		this.aaMontoDeducible = aaMontoDeducible;
	}


	/**
	 * @return the aaNomAbogado
	 */
	public String getAaNomAbogado() {
		return aaNomAbogado;
	}


	/**
	 * @param aaNomAbogado the aaNomAbogado to set
	 */
	public void setAaNomAbogado(String aaNomAbogado) {
		this.aaNomAbogado = aaNomAbogado;
	}


	/**
	 * @return the aaNomAjustador
	 */
	public String getAaNomAjustador() {
		return aaNomAjustador;
	}


	/**
	 * @param aaNomAjustador the aaNomAjustador to set
	 */
	public void setAaNomAjustador(String aaNomAjustador) {
		this.aaNomAjustador = aaNomAjustador;
	}


	/**
	 * @return the aaNomAsegurado
	 */
	public String getAaNomAsegurado() {
		return aaNomAsegurado;
	}


	/**
	 * @param aaNomAsegurado the aaNomAsegurado to set
	 */
	public void setAaNomAsegurado(String aaNomAsegurado) {
		this.aaNomAsegurado = aaNomAsegurado;
	}


	/**
	 * @return the aaNomConductor
	 */
	public String getAaNomConductor() {
		return aaNomConductor;
	}


	/**
	 * @param aaNomConductor the aaNomConductor to set
	 */
	public void setAaNomConductor(String aaNomConductor) {
		this.aaNomConductor = aaNomConductor;
	}


	/**
	 * @return the aaNomLesionados
	 */
	public String getAaNomLesionados() {
		return aaNomLesionados;
	}


	/**
	 * @param aaNomLesionados the aaNomLesionados to set
	 */
	public void setAaNomLesionados(String aaNomLesionados) {
		this.aaNomLesionados = aaNomLesionados;
	}


	/**
	 * @return the aaNomTercero
	 */
	public String getAaNomTercero() {
		return aaNomTercero;
	}


	/**
	 * @param aaNomTercero the aaNomTercero to set
	 */
	public void setAaNomTercero(String aaNomTercero) {
		this.aaNomTercero = aaNomTercero;
	}


	/**
	 * @return the aaNumAccidente
	 */
	public String getAaNumAccidente() {
		return aaNumAccidente;
	}


	/**
	 * @param aaNumAccidente the aaNumAccidente to set
	 */
	public void setAaNumAccidente(String aaNumAccidente) {
		this.aaNumAccidente = aaNumAccidente;
	}


	/**
	 * @return the aaNumInciso
	 */
	public String getAaNumInciso() {
		return aaNumInciso;
	}


	/**
	 * @param aaNumInciso the aaNumInciso to set
	 */
	public void setAaNumInciso(String aaNumInciso) {
		this.aaNumInciso = aaNumInciso;
	}


	/**
	 * @return the aaNumPoliza
	 */
	public String getAaNumPoliza() {
		return aaNumPoliza;
	}


	/**
	 * @param aaNumPoliza the aaNumPoliza to set
	 */
	public void setAaNumPoliza(String aaNumPoliza) {
		this.aaNumPoliza = aaNumPoliza;
	}


	/**
	 * @return the aaNumReporte
	 */
	public String getAaNumReporte() {
		return aaNumReporte;
	}


	/**
	 * @param aaNumReporte the aaNumReporte to set
	 */
	public void setAaNumReporte(String aaNumReporte) {
		this.aaNumReporte = aaNumReporte;
	}


	/**
	 * @return the aaNumSiniestro
	 */
	public String getAaNumSiniestro() {
		return aaNumSiniestro;
	}


	/**
	 * @param aaNumSiniestro the aaNumSiniestro to set
	 */
	public void setAaNumSiniestro(String aaNumSiniestro) {
		this.aaNumSiniestro = aaNumSiniestro;
	}


	/**
	 * @return the aaOrdenAdmision
	 */
	public Integer getAaOrdenAdmision() {
		return aaOrdenAdmision;
	}


	/**
	 * @param aaOrdenAdmision the aaOrdenAdmision to set
	 */
	public void setAaOrdenAdmision(Integer aaOrdenAdmision) {
		this.aaOrdenAdmision = aaOrdenAdmision;
	}


	/**
	 * @return the aaOtros
	 */
	public String getAaOtros() {
		return aaOtros;
	}


	/**
	 * @param aaOtros the aaOtros to set
	 */
	public void setAaOtros(String aaOtros) {
		this.aaOtros = aaOtros;
	}


	/**
	 * @return the aaPagado
	 */
	public Integer getAaPagado() {
		return aaPagado;
	}


	/**
	 * @param aaPagado the aaPagado to set
	 */
	public void setAaPagado(Integer aaPagado) {
		this.aaPagado = aaPagado;
	}


	/**
	 * @return the aaParteAcciden
	 */
	public Integer getAaParteAcciden() {
		return aaParteAcciden;
	}


	/**
	 * @param aaParteAcciden the aaParteAcciden to set
	 */
	public void setAaParteAcciden(Integer aaParteAcciden) {
		this.aaParteAcciden = aaParteAcciden;
	}


	/**
	 * @return the aaPaseMedico
	 */
	public Integer getAaPaseMedico() {
		return aaPaseMedico;
	}


	/**
	 * @param aaPaseMedico the aaPaseMedico to set
	 */
	public void setAaPaseMedico(Integer aaPaseMedico) {
		this.aaPaseMedico = aaPaseMedico;
	}


	/**
	 * @return the aaPlacaAuto
	 */
	public String getAaPlacaAuto() {
		return aaPlacaAuto;
	}


	/**
	 * @param aaPlacaAuto the aaPlacaAuto to set
	 */
	public void setAaPlacaAuto(String aaPlacaAuto) {
		this.aaPlacaAuto = aaPlacaAuto;
	}


	


	/**
	 * @return the aaPregunta1A
	 */
	public Integer getAaPregunta1A() {
		return aaPregunta1A;
	}


	/**
	 * @param aaPregunta1A the aaPregunta1A to set
	 */
	public void setAaPregunta1A(Integer aaPregunta1A) {
		this.aaPregunta1A = aaPregunta1A;
	}


	/**
	 * @return the aaPregunta1B
	 */
	public Integer getAaPregunta1B() {
		return aaPregunta1B;
	}


	/**
	 * @param aaPregunta1B the aaPregunta1B to set
	 */
	public void setAaPregunta1B(Integer aaPregunta1B) {
		this.aaPregunta1B = aaPregunta1B;
	}


	/**
	 * @return the aaPregunta2
	 */
	public Integer getAaPregunta2() {
		return aaPregunta2;
	}


	/**
	 * @param aaPregunta2 the aaPregunta2 to set
	 */
	public void setAaPregunta2(Integer aaPregunta2) {
		this.aaPregunta2 = aaPregunta2;
	}


	/**
	 * @return the aaPregunta3
	 */
	public Integer getAaPregunta3() {
		return aaPregunta3;
	}


	/**
	 * @param aaPregunta3 the aaPregunta3 to set
	 */
	public void setAaPregunta3(Integer aaPregunta3) {
		this.aaPregunta3 = aaPregunta3;
	}


	/**
	 * @return the aaPregunta4
	 */
	public Integer getAaPregunta4() {
		return aaPregunta4;
	}


	/**
	 * @param aaPregunta4 the aaPregunta4 to set
	 */
	public void setAaPregunta4(Integer aaPregunta4) {
		this.aaPregunta4 = aaPregunta4;
	}


	/**
	 * @return the aaPregunta5
	 */
	public Integer getAaPregunta5() {
		return aaPregunta5;
	}


	/**
	 * @param aaPregunta5 the aaPregunta5 to set
	 */
	public void setAaPregunta5(Integer aaPregunta5) {
		this.aaPregunta5 = aaPregunta5;
	}


	/**
	 * @return the aaPregunta6
	 */
	public Integer getAaPregunta6() {
		return aaPregunta6;
	}


	/**
	 * @param aaPregunta6 the aaPregunta6 to set
	 */
	public void setAaPregunta6(Integer aaPregunta6) {
		this.aaPregunta6 = aaPregunta6;
	}


	/**
	 * @return the aaPresuAsegurado
	 */
	public Integer getAaPresuAsegurado() {
		return aaPresuAsegurado;
	}


	/**
	 * @param aaPresuAsegurado the aaPresuAsegurado to set
	 */
	public void setAaPresuAsegurado(Integer aaPresuAsegurado) {
		this.aaPresuAsegurado = aaPresuAsegurado;
	}


	/**
	 * @return the aaPropietario
	 */
	public Integer getAaPropietario() {
		return aaPropietario;
	}


	/**
	 * @param aaPropietario the aaPropietario to set
	 */
	public void setAaPropietario(Integer aaPropietario) {
		this.aaPropietario = aaPropietario;
	}


	/**
	 * @return the aaTelCasa
	 */
	public String getAaTelCasa() {
		return aaTelCasa;
	}


	/**
	 * @param aaTelCasa the aaTelCasa to set
	 */
	public void setAaTelCasa(String aaTelCasa) {
		this.aaTelCasa = aaTelCasa;
	}


	/**
	 * @return the aaTelCasaTercero
	 */
	public String getAaTelCasaTercero() {
		return aaTelCasaTercero;
	}


	/**
	 * @param aaTelCasaTercero the aaTelCasaTercero to set
	 */
	public void setAaTelCasaTercero(String aaTelCasaTercero) {
		this.aaTelCasaTercero = aaTelCasaTercero;
	}


	/**
	 * @return the aaTelOficina
	 */
	public String getAaTelOficina() {
		return aaTelOficina;
	}


	/**
	 * @param aaTelOficina the aaTelOficina to set
	 */
	public void setAaTelOficina(String aaTelOficina) {
		this.aaTelOficina = aaTelOficina;
	}


	/**
	 * @return the aaTelOficinaTercero
	 */
	public String getAaTelOficinaTercero() {
		return aaTelOficinaTercero;
	}


	/**
	 * @param aaTelOficinaTercero the aaTelOficinaTercero to set
	 */
	public void setAaTelOficinaTercero(String aaTelOficinaTercero) {
		this.aaTelOficinaTercero = aaTelOficinaTercero;
	}


	/**
	 * @return the aaTipoAuto
	 */
	public String getAaTipoAuto() {
		return aaTipoAuto;
	}


	/**
	 * @param aaTipoAuto the aaTipoAuto to set
	 */
	public void setAaTipoAuto(String aaTipoAuto) {
		this.aaTipoAuto = aaTipoAuto;
	}


	/**
	 * @return the aaUbicacionActual
	 */
	public String getAaUbicacionActual() {
		return aaUbicacionActual;
	}


	/**
	 * @param aaUbicacionActual the aaUbicacionActual to set
	 */
	public void setAaUbicacionActual(String aaUbicacionActual) {
		this.aaUbicacionActual = aaUbicacionActual;
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
	 * @return the aaPregunta1
	 */
	public Integer getAaPregunta1() {
		return aaPregunta1;
	}


	/**
	 * @param aaPregunta1 the aaPregunta1 to set
	 */
	public void setAaPregunta1(Integer aaPregunta1) {
		this.aaPregunta1 = aaPregunta1;
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
	 * @return the firmaAjustador
	 */
	public String getFirmaAjustador() {
		return firmaAjustador;
	}





	/**
	 * @param firmaAjustador the firmaAjustador to set
	 */
	public void setFirmaAjustador(String firmaAjustador) {
		this.firmaAjustador = firmaAjustador;
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
	 * @return the firmaAbogado
	 */
	public String getFirmaAbogado() {
		return firmaAbogado;
	}





	/**
	 * @param firmaAbogado the firmaAbogado to set
	 */
	public void setFirmaAbogado(String firmaAbogado) {
		this.firmaAbogado = firmaAbogado;
	}





	/**
	 * @return the aaPregunta7A
	 */
	public Integer getAaPregunta7A() {
		return aaPregunta7A;
	}





	/**
	 * @param aaPregunta7A the aaPregunta7A to set
	 */
	public void setAaPregunta7A(Integer aaPregunta7A) {
		this.aaPregunta7A = aaPregunta7A;
	}





	/**
	 * @return the aaPregunta7B
	 */
	public Integer getAaPregunta7B() {
		return aaPregunta7B;
	}





	/**
	 * @param aaPregunta7B the aaPregunta7B to set
	 */
	public void setAaPregunta7B(Integer aaPregunta7B) {
		this.aaPregunta7B = aaPregunta7B;
	}





	public String getFirmaTercero() {
		return firmaTercero;
	}





	public void setFirmaTercero(String firmaTercero) {
		this.firmaTercero = firmaTercero;
	}






	
	
	
}