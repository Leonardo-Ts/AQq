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
public class ServicioFormatosAsistenciaVial {

	private String usuario;
	private String passwd;
	private ProveedorAdmi proveedor;
	private Integer avId;
	private String avAsegurado;
	private String avClaveAjustador;
	private String avComentarios;
	private String avEmail;
	private Date avFecha;
	private String avNomAsegurado;
	private String avNumInciso;
	private String avNumPoliza;
	private String avNumReporte;
	private Integer avPregunta1;
	private Integer avPregunta2;
	private Integer avPregunta3;
	private Integer avPregunta4;
	private String avPregunta5;
	private Integer avPregunta6;
	private Integer avPregunta7;
	private Integer idAjustador;
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

	public ServicioFormatosAsistenciaVial() {
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
	 * @return the avId
	 */
	public Integer getAvId() {
		return avId;
	}

	/**
	 * @param avId
	 *            the avId to set
	 */
	public void setAvId(Integer avId) {
		this.avId = avId;
	}

	/**
	 * @return the avAsegurado
	 */
	public String getAvAsegurado() {
		return avAsegurado;
	}

	/**
	 * @param avAsegurado
	 *            the avAsegurado to set
	 */
	public void setAvAsegurado(String avAsegurado) {
		this.avAsegurado = avAsegurado;
	}

	/**
	 * @return the avClaveAjustador
	 */
	public String getAvClaveAjustador() {
		return avClaveAjustador;
	}

	/**
	 * @param avClaveAjustador
	 *            the avClaveAjustador to set
	 */
	public void setAvClaveAjustador(String avClaveAjustador) {
		this.avClaveAjustador = avClaveAjustador;
	}

	/**
	 * @return the avComentarios
	 */
	public String getAvComentarios() {
		return avComentarios;
	}

	/**
	 * @param avComentarios
	 *            the avComentarios to set
	 */
	public void setAvComentarios(String avComentarios) {
		this.avComentarios = avComentarios;
	}

	/**
	 * @return the avEmail
	 */
	public String getAvEmail() {
		return avEmail;
	}

	/**
	 * @param avEmail
	 *            the avEmail to set
	 */
	public void setAvEmail(String avEmail) {
		this.avEmail = avEmail;
	}

	/**
	 * @return the avFecha
	 */
	public Date getAvFecha() {
		return avFecha;
	}

	/**
	 * @param avFecha
	 *            the avFecha to set
	 */
	public void setAvFecha(Date avFecha) {
		this.avFecha = avFecha;
	}

	/**
	 * @return the avNomAsegurado
	 */
	public String getAvNomAsegurado() {
		return avNomAsegurado;
	}

	/**
	 * @param avNomAsegurado
	 *            the avNomAsegurado to set
	 */
	public void setAvNomAsegurado(String avNomAsegurado) {
		this.avNomAsegurado = avNomAsegurado;
	}

	/**
	 * @return the avNumInciso
	 */
	public String getAvNumInciso() {
		return avNumInciso;
	}

	/**
	 * @param avNumInciso
	 *            the avNumInciso to set
	 */
	public void setAvNumInciso(String avNumInciso) {
		this.avNumInciso = avNumInciso;
	}

	/**
	 * @return the avNumPoliza
	 */
	public String getAvNumPoliza() {
		return avNumPoliza;
	}

	/**
	 * @param avNumPoliza
	 *            the avNumPoliza to set
	 */
	public void setAvNumPoliza(String avNumPoliza) {
		this.avNumPoliza = avNumPoliza;
	}

	/**
	 * @return the avNumReporte
	 */
	public String getAvNumReporte() {
		return avNumReporte;
	}

	/**
	 * @param avNumReporte
	 *            the avNumReporte to set
	 */
	public void setAvNumReporte(String avNumReporte) {
		this.avNumReporte = avNumReporte;
	}

	/**
	 * @return the avPregunta1
	 */
	public Integer getAvPregunta1() {
		return avPregunta1;
	}

	/**
	 * @param avPregunta1
	 *            the avPregunta1 to set
	 */
	public void setAvPregunta1(Integer avPregunta1) {
		this.avPregunta1 = avPregunta1;
	}

	/**
	 * @return the avPregunta2
	 */
	public Integer getAvPregunta2() {
		return avPregunta2;
	}

	/**
	 * @param avPregunta2
	 *            the avPregunta2 to set
	 */
	public void setAvPregunta2(Integer avPregunta2) {
		this.avPregunta2 = avPregunta2;
	}

	/**
	 * @return the avPregunta3
	 */
	public Integer getAvPregunta3() {
		return avPregunta3;
	}

	/**
	 * @param avPregunta3
	 *            the avPregunta3 to set
	 */
	public void setAvPregunta3(Integer avPregunta3) {
		this.avPregunta3 = avPregunta3;
	}

	/**
	 * @return the avPregunta4
	 */
	public Integer getAvPregunta4() {
		return avPregunta4;
	}

	/**
	 * @param avPregunta4
	 *            the avPregunta4 to set
	 */
	public void setAvPregunta4(Integer avPregunta4) {
		this.avPregunta4 = avPregunta4;
	}

	/**
	 * @return the avPregunta5
	 */
	public String getAvPregunta5() {
		return avPregunta5;
	}

	/**
	 * @param avPregunta5
	 *            the avPregunta5 to set
	 */
	public void setAvPregunta5(String avPregunta5) {
		this.avPregunta5 = avPregunta5;
	}

	/**
	 * @return the avPregunta6
	 */
	public Integer getAvPregunta6() {
		return avPregunta6;
	}

	/**
	 * @param avPregunta6
	 *            the avPregunta6 to set
	 */
	public void setAvPregunta6(Integer avPregunta6) {
		this.avPregunta6 = avPregunta6;
	}

	/**
	 * @return the avPregunta7
	 */
	public Integer getAvPregunta7() {
		return avPregunta7;
	}

	/**
	 * @param avPregunta7
	 *            the avPregunta7 to set
	 */
	public void setAvPregunta7(Integer avPregunta7) {
		this.avPregunta7 = avPregunta7;
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

}