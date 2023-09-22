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
public class ServicioFormatosEncuestaServicio {

	private ProveedorAdmi proveedor;

	private Integer esId;
	private String esAsegurado;
	private String esClaveAjustador;
	private String esEmailConductor;
	private Date esFecha;
	private String esLugar;
	private String esNomAsegurado;
	private String esNomConductor;
	private String esNumInciso;
	private String esNumPoliza;
	private String esNumReporte;
	private String esNumSiniestro;
	private String esObservaciones;
	private Integer esPregunta1;
	private Integer esPregunta10;
	private Integer esPregunta2;
	private Integer esPregunta3;
	private Integer esPregunta4;
	private Integer esPregunta5;
	private Integer esPregunta6;
	private Integer esPregunta7;
	private Integer esPregunta8;
	private Integer esPregunta9;
	private String esTelConductor;
	private String usuario;
	private String passwd;
	private int idAjustador;
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
	private String firmaAsegurado;

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
	 * @return the esId
	 */
	public Integer getEsId() {
		return esId;
	}

	/**
	 * @param esId
	 *            the esId to set
	 */
	public void setEsId(Integer esId) {
		this.esId = esId;
	}

	/**
	 * @return the esAsegurado
	 */
	public String getEsAsegurado() {
		return esAsegurado;
	}

	/**
	 * @param esAsegurado
	 *            the esAsegurado to set
	 */
	public void setEsAsegurado(String esAsegurado) {
		this.esAsegurado = esAsegurado;
	}

	/**
	 * @return the esClaveAjustador
	 */
	public String getEsClaveAjustador() {
		return esClaveAjustador;
	}

	/**
	 * @param esClaveAjustador
	 *            the esClaveAjustador to set
	 */
	public void setEsClaveAjustador(String esClaveAjustador) {
		this.esClaveAjustador = esClaveAjustador;
	}

	/**
	 * @return the esEmailConductor
	 */
	public String getEsEmailConductor() {
		return esEmailConductor;
	}

	/**
	 * @param esEmailConductor
	 *            the esEmailConductor to set
	 */
	public void setEsEmailConductor(String esEmailConductor) {
		this.esEmailConductor = esEmailConductor;
	}

	/**
	 * @return the esFecha
	 */
	public Date getEsFecha() {
		return esFecha;
	}

	/**
	 * @param esFecha
	 *            the esFecha to set
	 */
	public void setEsFecha(Date esFecha) {
		this.esFecha = esFecha;
	}

	/**
	 * @return the esLugar
	 */
	public String getEsLugar() {
		return esLugar;
	}

	/**
	 * @param esLugar
	 *            the esLugar to set
	 */
	public void setEsLugar(String esLugar) {
		this.esLugar = esLugar;
	}

	/**
	 * @return the esNomAsegurado
	 */
	public String getEsNomAsegurado() {
		return esNomAsegurado;
	}

	/**
	 * @param esNomAsegurado
	 *            the esNomAsegurado to set
	 */
	public void setEsNomAsegurado(String esNomAsegurado) {
		this.esNomAsegurado = esNomAsegurado;
	}

	/**
	 * @return the esNomConductor
	 */
	public String getEsNomConductor() {
		return esNomConductor;
	}

	/**
	 * @param esNomConductor
	 *            the esNomConductor to set
	 */
	public void setEsNomConductor(String esNomConductor) {
		this.esNomConductor = esNomConductor;
	}

	/**
	 * @return the esNumInciso
	 */
	public String getEsNumInciso() {
		return esNumInciso;
	}

	/**
	 * @param esNumInciso
	 *            the esNumInciso to set
	 */
	public void setEsNumInciso(String esNumInciso) {
		this.esNumInciso = esNumInciso;
	}

	/**
	 * @return the esNumPoliza
	 */
	public String getEsNumPoliza() {
		return esNumPoliza;
	}

	/**
	 * @param esNumPoliza
	 *            the esNumPoliza to set
	 */
	public void setEsNumPoliza(String esNumPoliza) {
		this.esNumPoliza = esNumPoliza;
	}

	/**
	 * @return the esNumReporte
	 */
	public String getEsNumReporte() {
		return esNumReporte;
	}

	/**
	 * @param esNumReporte
	 *            the esNumReporte to set
	 */
	public void setEsNumReporte(String esNumReporte) {
		this.esNumReporte = esNumReporte;
	}

	/**
	 * @return the esNumSiniestro
	 */
	public String getEsNumSiniestro() {
		return esNumSiniestro;
	}

	/**
	 * @param esNumSiniestro
	 *            the esNumSiniestro to set
	 */
	public void setEsNumSiniestro(String esNumSiniestro) {
		this.esNumSiniestro = esNumSiniestro;
	}

	/**
	 * @return the esObservaciones
	 */
	public String getEsObservaciones() {
		return esObservaciones;
	}

	/**
	 * @param esObservaciones
	 *            the esObservaciones to set
	 */
	public void setEsObservaciones(String esObservaciones) {
		this.esObservaciones = esObservaciones;
	}

	/**
	 * @return the esPregunta1
	 */
	public Integer getEsPregunta1() {
		return esPregunta1;
	}

	/**
	 * @param esPregunta1
	 *            the esPregunta1 to set
	 */
	public void setEsPregunta1(Integer esPregunta1) {
		this.esPregunta1 = esPregunta1;
	}

	/**
	 * @return the esPregunta10
	 */
	public Integer getEsPregunta10() {
		return esPregunta10;
	}

	/**
	 * @param esPregunta10
	 *            the esPregunta10 to set
	 */
	public void setEsPregunta10(Integer esPregunta10) {
		this.esPregunta10 = esPregunta10;
	}

	/**
	 * @return the esPregunta2
	 */
	public Integer getEsPregunta2() {
		return esPregunta2;
	}

	/**
	 * @param esPregunta2
	 *            the esPregunta2 to set
	 */
	public void setEsPregunta2(Integer esPregunta2) {
		this.esPregunta2 = esPregunta2;
	}

	/**
	 * @return the esPregunta3
	 */
	public Integer getEsPregunta3() {
		return esPregunta3;
	}

	/**
	 * @param esPregunta3
	 *            the esPregunta3 to set
	 */
	public void setEsPregunta3(Integer esPregunta3) {
		this.esPregunta3 = esPregunta3;
	}

	/**
	 * @return the esPregunta4
	 */
	public Integer getEsPregunta4() {
		return esPregunta4;
	}

	/**
	 * @param esPregunta4
	 *            the esPregunta4 to set
	 */
	public void setEsPregunta4(Integer esPregunta4) {
		this.esPregunta4 = esPregunta4;
	}

	/**
	 * @return the esPregunta5
	 */
	public Integer getEsPregunta5() {
		return esPregunta5;
	}

	/**
	 * @param esPregunta5
	 *            the esPregunta5 to set
	 */
	public void setEsPregunta5(Integer esPregunta5) {
		this.esPregunta5 = esPregunta5;
	}

	/**
	 * @return the esPregunta6
	 */
	public Integer getEsPregunta6() {
		return esPregunta6;
	}

	/**
	 * @param esPregunta6
	 *            the esPregunta6 to set
	 */
	public void setEsPregunta6(Integer esPregunta6) {
		this.esPregunta6 = esPregunta6;
	}

	/**
	 * @return the esPregunta7
	 */
	public Integer getEsPregunta7() {
		return esPregunta7;
	}

	/**
	 * @param esPregunta7
	 *            the esPregunta7 to set
	 */
	public void setEsPregunta7(Integer esPregunta7) {
		this.esPregunta7 = esPregunta7;
	}

	/**
	 * @return the esPregunta8
	 */
	public Integer getEsPregunta8() {
		return esPregunta8;
	}

	/**
	 * @param esPregunta8
	 *            the esPregunta8 to set
	 */
	public void setEsPregunta8(Integer esPregunta8) {
		this.esPregunta8 = esPregunta8;
	}

	/**
	 * @return the esPregunta9
	 */
	public Integer getEsPregunta9() {
		return esPregunta9;
	}

	/**
	 * @param esPregunta9
	 *            the esPregunta9 to set
	 */
	public void setEsPregunta9(Integer esPregunta9) {
		this.esPregunta9 = esPregunta9;
	}

	/**
	 * @return the esTelConductor
	 */
	public String getEsTelConductor() {
		return esTelConductor;
	}

	/**
	 * @param esTelConductor
	 *            the esTelConductor to set
	 */
	public void setEsTelConductor(String esTelConductor) {
		this.esTelConductor = esTelConductor;
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
	 * @return the idAjustador
	 */
	public int getIdAjustador() {
		return idAjustador;
	}

	/**
	 * @param idAjustador
	 *            the idAjustador to set
	 */
	public void setIdAjustador(int idAjustador) {
		this.idAjustador = idAjustador;
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

}