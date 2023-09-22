/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class ServicioFormatosValeAmbulancia {

	private Integer vaId;

	private Integer idAjustador;
	private String usuario;
	private String vaAsegurado;
	private String vaClaveAjustador;
	private String vaDatosConductor;
	private String vaDatosLesionado;
	private String vaDiagnostico;
	private String vaDirPaciente;
	private String vaEdadPaciente;

	private String vaFolio;
	private String vaFolioElectro;
	private Date vaHora;
	private String vaHospital;
	private String vaLugar;
	private String vaNomAjustador;
	private String vaNomPaciente;
	private String vaNomRazon;
	private String vaNumEndoso;
	private String vaNumInciso;
	private String vaNumPoliza;
	private String vaNumReporte;
	private String vaNumSiniestro;
	private String vaSexo;
	private String vaTelPaciente;

	private Integer id_ajustador;
	private String passwd;
	private String emailDefault;

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
	private String firmaConductor;
	private String firmaLesionado;

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

	public ServicioFormatosValeAmbulancia() {
		super();

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
	 * @return the vaId
	 */
	public Integer getVaId() {
		return vaId;
	}

	/**
	 * @param vaId
	 *            the vaId to set
	 */
	public void setVaId(Integer vaId) {
		this.vaId = vaId;
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
	 * @return the vaAsegurado
	 */
	public String getVaAsegurado() {
		return vaAsegurado;
	}

	/**
	 * @param vaAsegurado
	 *            the vaAsegurado to set
	 */
	public void setVaAsegurado(String vaAsegurado) {
		this.vaAsegurado = vaAsegurado;
	}

	/**
	 * @return the vaClaveAjustador
	 */
	public String getVaClaveAjustador() {
		return vaClaveAjustador;
	}

	/**
	 * @param vaClaveAjustador
	 *            the vaClaveAjustador to set
	 */
	public void setVaClaveAjustador(String vaClaveAjustador) {
		this.vaClaveAjustador = vaClaveAjustador;
	}

	/**
	 * @return the vaDatosConductor
	 */
	public String getVaDatosConductor() {
		return vaDatosConductor;
	}

	/**
	 * @param vaDatosConductor
	 *            the vaDatosConductor to set
	 */
	public void setVaDatosConductor(String vaDatosConductor) {
		this.vaDatosConductor = vaDatosConductor;
	}

	/**
	 * @return the vaDatosLesionado
	 */
	public String getVaDatosLesionado() {
		return vaDatosLesionado;
	}

	/**
	 * @param vaDatosLesionado
	 *            the vaDatosLesionado to set
	 */
	public void setVaDatosLesionado(String vaDatosLesionado) {
		this.vaDatosLesionado = vaDatosLesionado;
	}

	/**
	 * @return the vaDiagnostico
	 */
	public String getVaDiagnostico() {
		return vaDiagnostico;
	}

	/**
	 * @param vaDiagnostico
	 *            the vaDiagnostico to set
	 */
	public void setVaDiagnostico(String vaDiagnostico) {
		this.vaDiagnostico = vaDiagnostico;
	}

	/**
	 * @return the vaDirPaciente
	 */
	public String getVaDirPaciente() {
		return vaDirPaciente;
	}

	/**
	 * @param vaDirPaciente
	 *            the vaDirPaciente to set
	 */
	public void setVaDirPaciente(String vaDirPaciente) {
		this.vaDirPaciente = vaDirPaciente;
	}

	/**
	 * @return the vaEdadPaciente
	 */
	public String getVaEdadPaciente() {
		return vaEdadPaciente;
	}

	/**
	 * @param vaEdadPaciente
	 *            the vaEdadPaciente to set
	 */
	public void setVaEdadPaciente(String vaEdadPaciente) {
		this.vaEdadPaciente = vaEdadPaciente;
	}

	/**
	 * @return the vaFolio
	 */
	public String getVaFolio() {
		return vaFolio;
	}

	/**
	 * @param vaFolio
	 *            the vaFolio to set
	 */
	public void setVaFolio(String vaFolio) {
		this.vaFolio = vaFolio;
	}

	/**
	 * @return the vaFolioElectro
	 */
	public String getVaFolioElectro() {
		return vaFolioElectro;
	}

	/**
	 * @param vaFolioElectro
	 *            the vaFolioElectro to set
	 */
	public void setVaFolioElectro(String vaFolioElectro) {
		this.vaFolioElectro = vaFolioElectro;
	}

	/**
	 * @return the vaHora
	 */
	public Date getVaHora() {
		return vaHora;
	}

	/**
	 * @param vaHora
	 *            the vaHora to set
	 */
	public void setVaHora(Date vaHora) {
		this.vaHora = vaHora;
	}

	/**
	 * @return the vaHospital
	 */
	public String getVaHospital() {
		return vaHospital;
	}

	/**
	 * @param vaHospital
	 *            the vaHospital to set
	 */
	public void setVaHospital(String vaHospital) {
		this.vaHospital = vaHospital;
	}

	/**
	 * @return the vaLugar
	 */
	public String getVaLugar() {
		return vaLugar;
	}

	/**
	 * @param vaLugar
	 *            the vaLugar to set
	 */
	public void setVaLugar(String vaLugar) {
		this.vaLugar = vaLugar;
	}

	/**
	 * @return the vaNomAjustador
	 */
	public String getVaNomAjustador() {
		return vaNomAjustador;
	}

	/**
	 * @param vaNomAjustador
	 *            the vaNomAjustador to set
	 */
	public void setVaNomAjustador(String vaNomAjustador) {
		this.vaNomAjustador = vaNomAjustador;
	}

	/**
	 * @return the vaNomPaciente
	 */
	public String getVaNomPaciente() {
		return vaNomPaciente;
	}

	/**
	 * @param vaNomPaciente
	 *            the vaNomPaciente to set
	 */
	public void setVaNomPaciente(String vaNomPaciente) {
		this.vaNomPaciente = vaNomPaciente;
	}

	/**
	 * @return the vaNomRazon
	 */
	public String getVaNomRazon() {
		return vaNomRazon;
	}

	/**
	 * @param vaNomRazon
	 *            the vaNomRazon to set
	 */
	public void setVaNomRazon(String vaNomRazon) {
		this.vaNomRazon = vaNomRazon;
	}

	/**
	 * @return the vaNumEndoso
	 */
	public String getVaNumEndoso() {
		return vaNumEndoso;
	}

	/**
	 * @param vaNumEndoso
	 *            the vaNumEndoso to set
	 */
	public void setVaNumEndoso(String vaNumEndoso) {
		this.vaNumEndoso = vaNumEndoso;
	}

	/**
	 * @return the vaNumInciso
	 */
	public String getVaNumInciso() {
		return vaNumInciso;
	}

	/**
	 * @param vaNumInciso
	 *            the vaNumInciso to set
	 */
	public void setVaNumInciso(String vaNumInciso) {
		this.vaNumInciso = vaNumInciso;
	}

	/**
	 * @return the vaNumPoliza
	 */
	public String getVaNumPoliza() {
		return vaNumPoliza;
	}

	/**
	 * @param vaNumPoliza
	 *            the vaNumPoliza to set
	 */
	public void setVaNumPoliza(String vaNumPoliza) {
		this.vaNumPoliza = vaNumPoliza;
	}

	/**
	 * @return the vaNumReporte
	 */
	public String getVaNumReporte() {
		return vaNumReporte;
	}

	/**
	 * @param vaNumReporte
	 *            the vaNumReporte to set
	 */
	public void setVaNumReporte(String vaNumReporte) {
		this.vaNumReporte = vaNumReporte;
	}

	/**
	 * @return the vaNumSiniestro
	 */
	public String getVaNumSiniestro() {
		return vaNumSiniestro;
	}

	/**
	 * @param vaNumSiniestro
	 *            the vaNumSiniestro to set
	 */
	public void setVaNumSiniestro(String vaNumSiniestro) {
		this.vaNumSiniestro = vaNumSiniestro;
	}

	/**
	 * @return the vaSexo
	 */
	public String getVaSexo() {
		return vaSexo;
	}

	/**
	 * @param vaSexo
	 *            the vaSexo to set
	 */
	public void setVaSexo(String vaSexo) {
		this.vaSexo = vaSexo;
	}

	/**
	 * @return the vaTelPaciente
	 */
	public String getVaTelPaciente() {
		return vaTelPaciente;
	}

	/**
	 * @param vaTelPaciente
	 *            the vaTelPaciente to set
	 */
	public void setVaTelPaciente(String vaTelPaciente) {
		this.vaTelPaciente = vaTelPaciente;
	}

	/**
	 * @return the id_ajustador
	 */
	public Integer getId_ajustador() {
		return id_ajustador;
	}

	/**
	 * @param id_ajustador
	 *            the id_ajustador to set
	 */
	public void setId_ajustador(Integer id_ajustador) {
		this.id_ajustador = id_ajustador;
	}

	/**
	 * @return the emailDefault
	 */
	public String getEmailDefault() {
		return emailDefault;
	}

	/**
	 * @param emailDefault
	 *            the emailDefault to set
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
	 * @return the firmaConductor
	 */
	public String getFirmaConductor() {
		return firmaConductor;
	}

	/**
	 * @param firmaConductor
	 *            the firmaConductor to set
	 */
	public void setFirmaConductor(String firmaConductor) {
		this.firmaConductor = firmaConductor;
	}

	/**
	 * @return the firmaLesionado
	 */
	public String getFirmaLesionado() {
		return firmaLesionado;
	}

	/**
	 * @param firmaLesionado
	 *            the firmaLesionado to set
	 */
	public void setFirmaLesionado(String firmaLesionado) {
		this.firmaLesionado = firmaLesionado;
	}

}
