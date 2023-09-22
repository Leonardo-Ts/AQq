/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;
//import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class ServicioFormatosAsignacionAbogado {

	private String usuario;
	private String passwd;
	private ProveedorAdmi proveedor;
	private String aaNomConductor;
	private String aaMarcaAuto;
	private String aaColorAuto;
	private String aaNomAjustador;
	private Integer aaGrua;

	private Integer aaPagado;
	private Double aaDaniosNa;
	private String aaTelOficina;
	private String aaTelCasa;
	private Integer aaPaseMedico;
	private String aaClaveAbogado;
	private String aaAutoridad;
	private String aaAsegurado;
	private String aaEmail;
	private String aaDescripcionDanios;
	private Timestamp aaHoraSiniestro;
	private String aaNomLesionados;
	private Integer aaPregunta1A;
	private Integer aaPregunta1;
	private Integer aaPregunta1B;
	private String aaTelOficinaTercero;

	private Integer aaPregunta3;
	private String aaNumSiniestro;
	private Integer aaPregunta2;
	private String aaNomTercero;
	private Integer aaPregunta5;
	private Integer aaPregunta4;
	private Integer aaPregunta6;
	private String aaTipoAuto;
	private Integer aaPresuAsegurado;
	private String aaInforme;
	private Integer aaCopiaLicencia;

	private String aaDaniosEstimados;
	private Integer aaGruaTercero;
	private String aaLugarSiniestro;
	private String aaOtros;
	private Integer aaPropietario;
	private String aaNomAbogado;
	private String aaNumPoliza;
	private Integer aaDeducibleRc;
	private String aaUbicacionActual;
	private String aaNumInciso;
	private Integer aaOrdenAdmision;
	private Timestamp aaHoraAbogado;
	private String aaClaveAjustador;
	private Integer aaCopiaPoliza;
	private Double aaMontoCrucero;
	private Integer aaParteAcciden;
	private String aaNumAccidente;
	private Double aaMontoDeducible;
	private String aaNomAsegurado;
	private String aaPlacaAuto;
	private Timestamp aaHoraTurnado;
	private String aaDesDaniosTer;
	private String aaTelCasaTercero;
	private Integer aaId;
	private Integer idAjustador;;
	private Integer aaDeclaracionConduc;
	private String aaNumReporte;
	private String aaComentarios;
	private Integer enviadoEmail;
	private String mensajeEmail;

	private Integer proceso;
	private Timestamp horaEnvioEmail;
	private Timestamp horaEnvioSftp;
	private String nodoEnvio;

	private Integer check1;
	private Integer check2;
	private Integer check3;
	private Integer check4;

	private String firmaAjustador;
	private String firmaAsegurado;
	private String firmaAbogado;
	private Integer aaPregunta7A;
	private Integer aaPregunta7B;
	private String firma_tercero;

	/**
	 * @return the proceso
	 */
	public Integer getProceso() {
		return proceso;
	}

	/**
	 * @param proceso
	 *            the proceso to set
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
	 * @param horaEnvioEmail
	 *            the horaEnvioEmail to set
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
	 * @param horaEnvioSftp
	 *            the horaEnvioSftp to set
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
	 * @param nodoEnvio
	 *            the nodoEnvio to set
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
	 * @param enviadoEmail
	 *            the enviadoEmail to set
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
	 * @param mensajeEmail
	 *            the mensajeEmail to set
	 */
	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
	}

	public ServicioFormatosAsignacionAbogado() {
		super();

	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the proveedor
	 */
	public ProveedorAdmi getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(ProveedorAdmi proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the aaNomConductor
	 */
	public String getAaNomConductor() {
		return aaNomConductor;
	}

	/**
	 * @param aaNomConductor
	 *            the aaNomConductor to set
	 */
	public void setAaNomConductor(String aaNomConductor) {
		this.aaNomConductor = aaNomConductor;
	}

	/**
	 * @return the aaMarcaAuto
	 */
	public String getAaMarcaAuto() {
		return aaMarcaAuto;
	}

	/**
	 * @param aaMarcaAuto
	 *            the aaMarcaAuto to set
	 */
	public void setAaMarcaAuto(String aaMarcaAuto) {
		this.aaMarcaAuto = aaMarcaAuto;
	}

	/**
	 * @return the aaColorAuto
	 */
	public String getAaColorAuto() {
		return aaColorAuto;
	}

	/**
	 * @param aaColorAuto
	 *            the aaColorAuto to set
	 */
	public void setAaColorAuto(String aaColorAuto) {
		this.aaColorAuto = aaColorAuto;
	}

	/**
	 * @return the aaNomAjustador
	 */
	public String getAaNomAjustador() {
		return aaNomAjustador;
	}

	/**
	 * @param aaNomAjustador
	 *            the aaNomAjustador to set
	 */
	public void setAaNomAjustador(String aaNomAjustador) {
		this.aaNomAjustador = aaNomAjustador;
	}

	/**
	 * @return the aaGrua
	 */
	public Integer getAaGrua() {
		return aaGrua;
	}

	/**
	 * @param aaGrua
	 *            the aaGrua to set
	 */
	public void setAaGrua(Integer aaGrua) {
		this.aaGrua = aaGrua;
	}

	/**
	 * @return the aaPagado
	 */
	public Integer getAaPagado() {
		return aaPagado;
	}

	/**
	 * @param aaPagado
	 *            the aaPagado to set
	 */
	public void setAaPagado(Integer aaPagado) {
		this.aaPagado = aaPagado;
	}

	/**
	 * @return the aaDaniosNa
	 */
	public Double getAaDaniosNa() {
		return aaDaniosNa;
	}

	/**
	 * @param aaDaniosNa
	 *            the aaDaniosNa to set
	 */
	public void setAaDaniosNa(Double aaDaniosNa) {
		this.aaDaniosNa = aaDaniosNa;
	}

	/**
	 * @return the aaTelOficina
	 */
	public String getAaTelOficina() {
		return aaTelOficina;
	}

	/**
	 * @param aaTelOficina
	 *            the aaTelOficina to set
	 */
	public void setAaTelOficina(String aaTelOficina) {
		this.aaTelOficina = aaTelOficina;
	}

	/**
	 * @return the aaTelCasa
	 */
	public String getAaTelCasa() {
		return aaTelCasa;
	}

	/**
	 * @param aaTelCasa
	 *            the aaTelCasa to set
	 */
	public void setAaTelCasa(String aaTelCasa) {
		this.aaTelCasa = aaTelCasa;
	}

	/**
	 * @return the aaPaseMedico
	 */
	public Integer getAaPaseMedico() {
		return aaPaseMedico;
	}

	/**
	 * @param aaPaseMedico
	 *            the aaPaseMedico to set
	 */
	public void setAaPaseMedico(Integer aaPaseMedico) {
		this.aaPaseMedico = aaPaseMedico;
	}

	/**
	 * @return the aaClaveAbogado
	 */
	public String getAaClaveAbogado() {
		return aaClaveAbogado;
	}

	/**
	 * @param aaClaveAbogado
	 *            the aaClaveAbogado to set
	 */
	public void setAaClaveAbogado(String aaClaveAbogado) {
		this.aaClaveAbogado = aaClaveAbogado;
	}

	/**
	 * @return the aaAutoridad
	 */
	public String getAaAutoridad() {
		return aaAutoridad;
	}

	/**
	 * @param aaAutoridad
	 *            the aaAutoridad to set
	 */
	public void setAaAutoridad(String aaAutoridad) {
		this.aaAutoridad = aaAutoridad;
	}

	/**
	 * @return the aaAsegurado
	 */
	public String getAaAsegurado() {
		return aaAsegurado;
	}

	/**
	 * @param aaAsegurado
	 *            the aaAsegurado to set
	 */
	public void setAaAsegurado(String aaAsegurado) {
		this.aaAsegurado = aaAsegurado;
	}

	/**
	 * @return the aaEmail
	 */
	public String getAaEmail() {
		return aaEmail;
	}

	/**
	 * @param aaEmail
	 *            the aaEmail to set
	 */
	public void setAaEmail(String aaEmail) {
		this.aaEmail = aaEmail;
	}

	/**
	 * @return the aaDescripcionDanios
	 */
	public String getAaDescripcionDanios() {
		return aaDescripcionDanios;
	}

	/**
	 * @param aaDescripcionDanios
	 *            the aaDescripcionDanios to set
	 */
	public void setAaDescripcionDanios(String aaDescripcionDanios) {
		this.aaDescripcionDanios = aaDescripcionDanios;
	}

	/**
	 * @return the aaHoraSiniestro
	 */
	public Timestamp getAaHoraSiniestro() {
		return aaHoraSiniestro;
	}

	/**
	 * @param aaHoraSiniestro
	 *            the aaHoraSiniestro to set
	 */
	public void setAaHoraSiniestro(Timestamp aaHoraSiniestro) {
		this.aaHoraSiniestro = aaHoraSiniestro;
	}

	/**
	 * @return the aaNomLesionados
	 */
	public String getAaNomLesionados() {
		return aaNomLesionados;
	}

	/**
	 * @param aaNomLesionados
	 *            the aaNomLesionados to set
	 */
	public void setAaNomLesionados(String aaNomLesionados) {
		this.aaNomLesionados = aaNomLesionados;
	}

	/**
	 * @return the aaPregunta1A
	 */
	public Integer getAaPregunta1A() {
		return aaPregunta1A;
	}

	/**
	 * @param aaPregunta1A
	 *            the aaPregunta1A to set
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
	 * @param aaPregunta1B
	 *            the aaPregunta1B to set
	 */
	public void setAaPregunta1B(Integer aaPregunta1B) {
		this.aaPregunta1B = aaPregunta1B;
	}

	/**
	 * @return the aaTelOficinaTercero
	 */
	public String getAaTelOficinaTercero() {
		return aaTelOficinaTercero;
	}

	/**
	 * @param aaTelOficinaTercero
	 *            the aaTelOficinaTercero to set
	 */
	public void setAaTelOficinaTercero(String aaTelOficinaTercero) {
		this.aaTelOficinaTercero = aaTelOficinaTercero;
	}

	/**
	 * @return the aaPregunta3
	 */
	public Integer getAaPregunta3() {
		return aaPregunta3;
	}

	/**
	 * @param aaPregunta3
	 *            the aaPregunta3 to set
	 */
	public void setAaPregunta3(Integer aaPregunta3) {
		this.aaPregunta3 = aaPregunta3;
	}

	/**
	 * @return the aaNumSiniestro
	 */
	public String getAaNumSiniestro() {
		return aaNumSiniestro;
	}

	/**
	 * @param aaNumSiniestro
	 *            the aaNumSiniestro to set
	 */
	public void setAaNumSiniestro(String aaNumSiniestro) {
		this.aaNumSiniestro = aaNumSiniestro;
	}

	/**
	 * @return the aaPregunta2
	 */
	public Integer getAaPregunta2() {
		return aaPregunta2;
	}

	/**
	 * @param aaPregunta2
	 *            the aaPregunta2 to set
	 */
	public void setAaPregunta2(Integer aaPregunta2) {
		this.aaPregunta2 = aaPregunta2;
	}

	/**
	 * @return the aaNomTercero
	 */
	public String getAaNomTercero() {
		return aaNomTercero;
	}

	/**
	 * @param aaNomTercero
	 *            the aaNomTercero to set
	 */
	public void setAaNomTercero(String aaNomTercero) {
		this.aaNomTercero = aaNomTercero;
	}

	/**
	 * @return the aaPregunta5
	 */
	public Integer getAaPregunta5() {
		return aaPregunta5;
	}

	/**
	 * @param aaPregunta5
	 *            the aaPregunta5 to set
	 */
	public void setAaPregunta5(Integer aaPregunta5) {
		this.aaPregunta5 = aaPregunta5;
	}

	/**
	 * @return the aaPregunta4
	 */
	public Integer getAaPregunta4() {
		return aaPregunta4;
	}

	/**
	 * @param aaPregunta4
	 *            the aaPregunta4 to set
	 */
	public void setAaPregunta4(Integer aaPregunta4) {
		this.aaPregunta4 = aaPregunta4;
	}

	/**
	 * @return the aaPregunta6
	 */
	public Integer getAaPregunta6() {
		return aaPregunta6;
	}

	/**
	 * @param aaPregunta6
	 *            the aaPregunta6 to set
	 */
	public void setAaPregunta6(Integer aaPregunta6) {
		this.aaPregunta6 = aaPregunta6;
	}

	/**
	 * @return the aaTipoAuto
	 */
	public String getAaTipoAuto() {
		return aaTipoAuto;
	}

	/**
	 * @param aaTipoAuto
	 *            the aaTipoAuto to set
	 */
	public void setAaTipoAuto(String aaTipoAuto) {
		this.aaTipoAuto = aaTipoAuto;
	}

	/**
	 * @return the aaPresuAsegurado
	 */
	public Integer getAaPresuAsegurado() {
		return aaPresuAsegurado;
	}

	/**
	 * @param aaPresuAsegurado
	 *            the aaPresuAsegurado to set
	 */
	public void setAaPresuAsegurado(Integer aaPresuAsegurado) {
		this.aaPresuAsegurado = aaPresuAsegurado;
	}

	/**
	 * @return the aaInforme
	 */
	public String getAaInforme() {
		return aaInforme;
	}

	/**
	 * @param aaInforme
	 *            the aaInforme to set
	 */
	public void setAaInforme(String aaInforme) {
		this.aaInforme = aaInforme;
	}

	/**
	 * @return the aaCopiaLicencia
	 */
	public Integer getAaCopiaLicencia() {
		return aaCopiaLicencia;
	}

	/**
	 * @param aaCopiaLicencia
	 *            the aaCopiaLicencia to set
	 */
	public void setAaCopiaLicencia(Integer aaCopiaLicencia) {
		this.aaCopiaLicencia = aaCopiaLicencia;
	}

	/**
	 * @return the aaDaniosEstimados
	 */
	public String getAaDaniosEstimados() {
		return aaDaniosEstimados;
	}

	/**
	 * @param aaDaniosEstimados
	 *            the aaDaniosEstimados to set
	 */
	public void setAaDaniosEstimados(String aaDaniosEstimados) {
		this.aaDaniosEstimados = aaDaniosEstimados;
	}

	/**
	 * @return the aaGruaTercero
	 */
	public Integer getAaGruaTercero() {
		return aaGruaTercero;
	}

	/**
	 * @param aaGruaTercero
	 *            the aaGruaTercero to set
	 */
	public void setAaGruaTercero(Integer aaGruaTercero) {
		this.aaGruaTercero = aaGruaTercero;
	}

	/**
	 * @return the aaLugarSiniestro
	 */
	public String getAaLugarSiniestro() {
		return aaLugarSiniestro;
	}

	/**
	 * @param aaLugarSiniestro
	 *            the aaLugarSiniestro to set
	 */
	public void setAaLugarSiniestro(String aaLugarSiniestro) {
		this.aaLugarSiniestro = aaLugarSiniestro;
	}

	/**
	 * @return the aaOtros
	 */
	public String getAaOtros() {
		return aaOtros;
	}

	/**
	 * @param aaOtros
	 *            the aaOtros to set
	 */
	public void setAaOtros(String aaOtros) {
		this.aaOtros = aaOtros;
	}

	/**
	 * @return the aaPropietario
	 */
	public Integer getAaPropietario() {
		return aaPropietario;
	}

	/**
	 * @param aaPropietario
	 *            the aaPropietario to set
	 */
	public void setAaPropietario(Integer aaPropietario) {
		this.aaPropietario = aaPropietario;
	}

	/**
	 * @return the aaNomAbogado
	 */
	public String getAaNomAbogado() {
		return aaNomAbogado;
	}

	/**
	 * @param aaNomAbogado
	 *            the aaNomAbogado to set
	 */
	public void setAaNomAbogado(String aaNomAbogado) {
		this.aaNomAbogado = aaNomAbogado;
	}

	/**
	 * @return the aaNumPoliza
	 */
	public String getAaNumPoliza() {
		return aaNumPoliza;
	}

	/**
	 * @param aaNumPoliza
	 *            the aaNumPoliza to set
	 */
	public void setAaNumPoliza(String aaNumPoliza) {
		this.aaNumPoliza = aaNumPoliza;
	}

	/**
	 * @return the aaDeducibleRc
	 */
	public Integer getAaDeducibleRc() {
		return aaDeducibleRc;
	}

	/**
	 * @param aaDeducibleRc
	 *            the aaDeducibleRc to set
	 */
	public void setAaDeducibleRc(Integer aaDeducibleRc) {
		this.aaDeducibleRc = aaDeducibleRc;
	}

	/**
	 * @return the aaUbicacionActual
	 */
	public String getAaUbicacionActual() {
		return aaUbicacionActual;
	}

	/**
	 * @param aaUbicacionActual
	 *            the aaUbicacionActual to set
	 */
	public void setAaUbicacionActual(String aaUbicacionActual) {
		this.aaUbicacionActual = aaUbicacionActual;
	}

	/**
	 * @return the aaNumInciso
	 */
	public String getAaNumInciso() {
		return aaNumInciso;
	}

	/**
	 * @param aaNumInciso
	 *            the aaNumInciso to set
	 */
	public void setAaNumInciso(String aaNumInciso) {
		this.aaNumInciso = aaNumInciso;
	}

	/**
	 * @return the aaOrdenAdmision
	 */
	public Integer getAaOrdenAdmision() {
		return aaOrdenAdmision;
	}

	/**
	 * @param aaOrdenAdmision
	 *            the aaOrdenAdmision to set
	 */
	public void setAaOrdenAdmision(Integer aaOrdenAdmision) {
		this.aaOrdenAdmision = aaOrdenAdmision;
	}

	/**
	 * @return the aaHoraAbogado
	 */
	public Timestamp getAaHoraAbogado() {
		return aaHoraAbogado;
	}

	/**
	 * @param aaHoraAbogado
	 *            the aaHoraAbogado to set
	 */
	public void setAaHoraAbogado(Timestamp aaHoraAbogado) {
		this.aaHoraAbogado = aaHoraAbogado;
	}

	/**
	 * @return the aaClaveAjustador
	 */
	public String getAaClaveAjustador() {
		return aaClaveAjustador;
	}

	/**
	 * @param aaClaveAjustador
	 *            the aaClaveAjustador to set
	 */
	public void setAaClaveAjustador(String aaClaveAjustador) {
		this.aaClaveAjustador = aaClaveAjustador;
	}

	/**
	 * @return the aaCopiaPoliza
	 */
	public Integer getAaCopiaPoliza() {
		return aaCopiaPoliza;
	}

	/**
	 * @param aaCopiaPoliza
	 *            the aaCopiaPoliza to set
	 */
	public void setAaCopiaPoliza(Integer aaCopiaPoliza) {
		this.aaCopiaPoliza = aaCopiaPoliza;
	}

	/**
	 * @return the aaMontoCrucero
	 */
	public Double getAaMontoCrucero() {
		return aaMontoCrucero;
	}

	/**
	 * @param aaMontoCrucero
	 *            the aaMontoCrucero to set
	 */
	public void setAaMontoCrucero(Double aaMontoCrucero) {
		this.aaMontoCrucero = aaMontoCrucero;
	}

	/**
	 * @return the aaParteAcciden
	 */
	public Integer getAaParteAcciden() {
		return aaParteAcciden;
	}

	/**
	 * @param aaParteAcciden
	 *            the aaParteAcciden to set
	 */
	public void setAaParteAcciden(Integer aaParteAcciden) {
		this.aaParteAcciden = aaParteAcciden;
	}

	/**
	 * @return the aaNumAccidente
	 */
	public String getAaNumAccidente() {
		return aaNumAccidente;
	}

	/**
	 * @param aaNumAccidente
	 *            the aaNumAccidente to set
	 */
	public void setAaNumAccidente(String aaNumAccidente) {
		this.aaNumAccidente = aaNumAccidente;
	}

	/**
	 * @return the aaMontoDeducible
	 */
	public Double getAaMontoDeducible() {
		return aaMontoDeducible;
	}

	/**
	 * @param aaMontoDeducible
	 *            the aaMontoDeducible to set
	 */
	public void setAaMontoDeducible(Double aaMontoDeducible) {
		this.aaMontoDeducible = aaMontoDeducible;
	}

	/**
	 * @return the aaNomAsegurado
	 */
	public String getAaNomAsegurado() {
		return aaNomAsegurado;
	}

	/**
	 * @param aaNomAsegurado
	 *            the aaNomAsegurado to set
	 */
	public void setAaNomAsegurado(String aaNomAsegurado) {
		this.aaNomAsegurado = aaNomAsegurado;
	}

	/**
	 * @return the aaPlacaAuto
	 */
	public String getAaPlacaAuto() {
		return aaPlacaAuto;
	}

	/**
	 * @param aaPlacaAuto
	 *            the aaPlacaAuto to set
	 */
	public void setAaPlacaAuto(String aaPlacaAuto) {
		this.aaPlacaAuto = aaPlacaAuto;
	}

	/**
	 * @return the aaHoraTurnado
	 */
	public Timestamp getAaHoraTurnado() {
		return aaHoraTurnado;
	}

	/**
	 * @param aaHoraTurnado
	 *            the aaHoraTurnado to set
	 */
	public void setAaHoraTurnado(Timestamp aaHoraTurnado) {
		this.aaHoraTurnado = aaHoraTurnado;
	}

	/**
	 * @return the aaDesDaniosTer
	 */
	public String getAaDesDaniosTer() {
		return aaDesDaniosTer;
	}

	/**
	 * @param aaDesDaniosTer
	 *            the aaDesDaniosTer to set
	 */
	public void setAaDesDaniosTer(String aaDesDaniosTer) {
		this.aaDesDaniosTer = aaDesDaniosTer;
	}

	/**
	 * @return the aaTelCasaTercero
	 */
	public String getAaTelCasaTercero() {
		return aaTelCasaTercero;
	}

	/**
	 * @param aaTelCasaTercero
	 *            the aaTelCasaTercero to set
	 */
	public void setAaTelCasaTercero(String aaTelCasaTercero) {
		this.aaTelCasaTercero = aaTelCasaTercero;
	}

	/**
	 * @return the aaId
	 */
	public Integer getAaId() {
		return aaId;
	}

	/**
	 * @param aaId
	 *            the aaId to set
	 */
	public void setAaId(Integer aaId) {
		this.aaId = aaId;
	}

	/**
	 * @return the idAjustador
	 */
	public Integer getIdAjustador() {
		return idAjustador;
	}

	/**
	 * @param idAjustador
	 *            the idAjustador to set
	 */
	public void setIdAjustador(Integer idAjustador) {
		this.idAjustador = idAjustador;
	}

	/**
	 * @return the aaDeclaracionConduc
	 */
	public Integer getAaDeclaracionConduc() {
		return aaDeclaracionConduc;
	}

	/**
	 * @param aaDeclaracionConduc
	 *            the aaDeclaracionConduc to set
	 */
	public void setAaDeclaracionConduc(Integer aaDeclaracionConduc) {
		this.aaDeclaracionConduc = aaDeclaracionConduc;
	}

	/**
	 * @return the aaNumReporte
	 */
	public String getAaNumReporte() {
		return aaNumReporte;
	}

	/**
	 * @param aaNumReporte
	 *            the aaNumReporte to set
	 */
	public void setAaNumReporte(String aaNumReporte) {
		this.aaNumReporte = aaNumReporte;
	}

	/**
	 * @return the aaComentarios
	 */
	public String getAaComentarios() {
		return aaComentarios;
	}

	/**
	 * @param aaComentarios
	 *            the aaComentarios to set
	 */
	public void setAaComentarios(String aaComentarios) {
		this.aaComentarios = aaComentarios;
	}

	/**
	 * @return the aaPregunta1
	 */
	public Integer getAaPregunta1() {
		return aaPregunta1;
	}

	/**
	 * @param aaPregunta1
	 *            the aaPregunta1 to set
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
	 * @param check1
	 *            the check1 to set
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
	 * @param check2
	 *            the check2 to set
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
	 * @param check3
	 *            the check3 to set
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
	 * @param check4
	 *            the check4 to set
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
	 * @param firmaAjustador
	 *            the firmaAjustador to set
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
	 * @param firmaAsegurado
	 *            the firmaAsegurado to set
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
	 * @param firmaAbogado
	 *            the firmaAbogado to set
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
	 * @param aaPregunta7A
	 *            the aaPregunta7A to set
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
	 * @param aaPregunta7B
	 *            the aaPregunta7B to set
	 */
	public void setAaPregunta7B(Integer aaPregunta7B) {
		this.aaPregunta7B = aaPregunta7B;
	}

	public String getFirma_tercero() {
		return firma_tercero;
	}

	public void setFirma_tercero(String firma_tercero) {
		this.firma_tercero = firma_tercero;
	}
	
	

}