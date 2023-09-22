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
public class ServicioFormatosReclamacionPendiente {

	private Integer rpId;
	private Integer idAjustador;
	private String rpAsegurado;
	private String rpClaveAjustador;
	private Integer rpCopiaActaMp;
	private String rpNombreConductor;
	private Integer rpDfEndoso;
	private Date rpFecha;
	private Integer rpLicencia;
	private String rpNomAjustador;
	private String rpNomConductor;
	private String rpNumInciso;
	private String rpNumPoliza;
	private String rpNumReclamacion;
	private String rpNumReporte;
	private String rpObsEndosoAclara;
	private String rpObservaciones;
	private Integer rpOtros;
	private Integer rpReciboPago;
	private String usuario;
	private String passwd;
	private String emailDefault;
	private Integer rpPolizaVigente;
	private ProveedorAdmi proveedor;
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
	private String rp_datos_oficina;

	public String getRp_datos_oficina() {
		return rp_datos_oficina;
	}

	public void setRp_datos_oficina(String rp_datos_oficina) {
		this.rp_datos_oficina = rp_datos_oficina;
	}

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

	public ServicioFormatosReclamacionPendiente() {
		super();

	}

	/**
	 * @return the rpId
	 */
	public Integer getRpId() {
		return rpId;
	}

	/**
	 * @param rpId
	 *            the rpId to set
	 */
	public void setRpId(int rpId) {
		this.rpId = rpId;
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
	 * @return the rpAsegurado
	 */
	public String getRpAsegurado() {
		return rpAsegurado;
	}

	/**
	 * @param rpAsegurado
	 *            the rpAsegurado to set
	 */
	public void setRpAsegurado(String rpAsegurado) {
		this.rpAsegurado = rpAsegurado;
	}

	/**
	 * @return the rpClaveAjustador
	 */
	public String getRpClaveAjustador() {
		return rpClaveAjustador;
	}

	/**
	 * @param rpClaveAjustador
	 *            the rpClaveAjustador to set
	 */
	public void setRpClaveAjustador(String rpClaveAjustador) {
		this.rpClaveAjustador = rpClaveAjustador;
	}

	/**
	 * @return the rpCopiaActaMp
	 */
	public Integer getRpCopiaActaMp() {
		return rpCopiaActaMp;
	}

	/**
	 * @param rpCopiaActaMp
	 *            the rpCopiaActaMp to set
	 */
	public void setRpCopiaActaMp(Integer rpCopiaActaMp) {
		this.rpCopiaActaMp = rpCopiaActaMp;
	}

	/**
	 * @return the rpFecha
	 */
	public Date getRpFecha() {
		return rpFecha;
	}

	/**
	 * @param rpFecha
	 *            the rpFecha to set
	 */
	public void setRpFecha(Date rpFecha) {
		this.rpFecha = rpFecha;
	}

	/**
	 * @return the rpLicencia
	 */
	public Integer getRpLicencia() {
		return rpLicencia;
	}

	/**
	 * @param rpLicencia
	 *            the rpLicencia to set
	 */
	public void setRpLicencia(Integer rpLicencia) {
		this.rpLicencia = rpLicencia;
	}

	/**
	 * @return the rpNomAjustador
	 */
	public String getRpNomAjustador() {
		return rpNomAjustador;
	}

	/**
	 * @param rpNomAjustador
	 *            the rpNomAjustador to set
	 */
	public void setRpNomAjustador(String rpNomAjustador) {
		this.rpNomAjustador = rpNomAjustador;
	}

	/**
	 * @return the rpNomConductor
	 */
	public String getRpNomConductor() {
		return rpNomConductor;
	}

	/**
	 * @param rpNomConductor
	 *            the rpNomConductor to set
	 */
	public void setRpNomConductor(String rpNomConductor) {
		this.rpNomConductor = rpNomConductor;
	}

	/**
	 * @return the rpNumInciso
	 */
	public String getRpNumInciso() {
		return rpNumInciso;
	}

	/**
	 * @param rpNumInciso
	 *            the rpNumInciso to set
	 */
	public void setRpNumInciso(String rpNumInciso) {
		this.rpNumInciso = rpNumInciso;
	}

	/**
	 * @return the rpNumPoliza
	 */
	public String getRpNumPoliza() {
		return rpNumPoliza;
	}

	/**
	 * @param rpNumPoliza
	 *            the rpNumPoliza to set
	 */
	public void setRpNumPoliza(String rpNumPoliza) {
		this.rpNumPoliza = rpNumPoliza;
	}

	/**
	 * @return the rpNumReclamacion
	 */
	public String getRpNumReclamacion() {
		return rpNumReclamacion;
	}

	/**
	 * @param rpNumReclamacion
	 *            the rpNumReclamacion to set
	 */
	public void setRpNumReclamacion(String rpNumReclamacion) {
		this.rpNumReclamacion = rpNumReclamacion;
	}

	/**
	 * @return the rpNumReporte
	 */
	public String getRpNumReporte() {
		return rpNumReporte;
	}

	/**
	 * @param rpNumReporte
	 *            the rpNumReporte to set
	 */
	public void setRpNumReporte(String rpNumReporte) {
		this.rpNumReporte = rpNumReporte;
	}

	/**
	 * @return the rpObsEndosoAclara
	 */
	public String getRpObsEndosoAclara() {
		return rpObsEndosoAclara;
	}

	/**
	 * @param rpObsEndosoAclara
	 *            the rpObsEndosoAclara to set
	 */
	public void setRpObsEndosoAclara(String rpObsEndosoAclara) {
		this.rpObsEndosoAclara = rpObsEndosoAclara;
	}

	/**
	 * @return the rpObservaciones
	 */
	public String getRpObservaciones() {
		return rpObservaciones;
	}

	/**
	 * @param rpObservaciones
	 *            the rpObservaciones to set
	 */
	public void setRpObservaciones(String rpObservaciones) {
		this.rpObservaciones = rpObservaciones;
	}

	/**
	 * @return the rpOtros
	 */
	public Integer getRpOtros() {
		return rpOtros;
	}

	/**
	 * @param rpOtros
	 *            the rpOtros to set
	 */
	public void setRpOtros(Integer rpOtros) {
		this.rpOtros = rpOtros;
	}

	/**
	 * @return the rpReciboPago
	 */
	public Integer getRpReciboPago() {
		return rpReciboPago;
	}

	/**
	 * @param rpReciboPago
	 *            the rpReciboPago to set
	 */
	public void setRpReciboPago(Integer rpReciboPago) {
		this.rpReciboPago = rpReciboPago;
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
	 * @return the rpNombreConductor
	 */
	public String getRpNombreConductor() {
		return rpNombreConductor;
	}

	/**
	 * @param rpNombreConductor
	 *            the rpNombreConductor to set
	 */
	public void setRpNombreConductor(String rpNombreConductor) {
		this.rpNombreConductor = rpNombreConductor;
	}

	/**
	 * @return the rpDfEndoso
	 */
	public Integer getRpDfEndoso() {
		return rpDfEndoso;
	}

	/**
	 * @param rpDfEndoso
	 *            the rpDfEndoso to set
	 */
	public void setRpDfEndoso(Integer rpDfEndoso) {
		this.rpDfEndoso = rpDfEndoso;
	}

	/**
	 * @param rpId
	 *            the rpId to set
	 */
	public void setRpId(Integer rpId) {
		this.rpId = rpId;
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
	 * @return the rpPolizaVigente
	 */
	public Integer getRpPolizaVigente() {
		return rpPolizaVigente;
	}

	/**
	 * @param rpPolizaVigente
	 *            the rpPolizaVigente to set
	 */
	public void setRpPolizaVigente(Integer rpPolizaVigente) {
		this.rpPolizaVigente = rpPolizaVigente;
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
