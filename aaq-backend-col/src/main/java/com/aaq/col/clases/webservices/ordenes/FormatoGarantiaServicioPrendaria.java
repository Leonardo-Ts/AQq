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
public class FormatoGarantiaServicioPrendaria {

	private String passwd;
	private String emailDefault;
	private String gpPlacasAuto;
	private String gpNomAcreedor;
	private String gpBienes;
	private String gpSrColonia;
	private String gpClaveAjustador;
	private String gpDias;
	private String gpNomDeudor;
	private String gpNumReporte;
	private String gpSr;
	private String gpSrIdentificacion;
	private String gpAsegurado;
	private String gpCantidad;
	private String gpNumInciso;
	private String gpMarcaAuto;
	private Date gpFacturaFecha;

	private Date gpFecha;
	private String gpSrCp;
	private String gpCantidadLetra;
	private String gpModeloAuto;
	private String gpNumPoliza;
	private String gpTipoAuto;
	private Date gpFechaFirma;
	private String gpFacturaExpedida;
	private String gpColorAuto;
	private String gpSrCalle;
	private String gpSrMunicipio;

	private String gpSrCiudad;
	private String gpFactura;
	private String usuario;
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

	private String firmaDeudor;
	private String firmaAcreedor;

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

	public FormatoGarantiaServicioPrendaria() {
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
	 * @return the gpPlacasAuto
	 */
	public String getGpPlacasAuto() {
		return gpPlacasAuto;
	}

	/**
	 * @param gpPlacasAuto
	 *            the gpPlacasAuto to set
	 */
	public void setGpPlacasAuto(String gpPlacasAuto) {
		this.gpPlacasAuto = gpPlacasAuto;
	}

	/**
	 * @return the gpNomAcreedor
	 */
	public String getGpNomAcreedor() {
		return gpNomAcreedor;
	}

	/**
	 * @param gpNomAcreedor
	 *            the gpNomAcreedor to set
	 */
	public void setGpNomAcreedor(String gpNomAcreedor) {
		this.gpNomAcreedor = gpNomAcreedor;
	}

	/**
	 * @return the gpBienes
	 */
	public String getGpBienes() {
		return gpBienes;
	}

	/**
	 * @param gpBienes
	 *            the gpBienes to set
	 */
	public void setGpBienes(String gpBienes) {
		this.gpBienes = gpBienes;
	}

	/**
	 * @return the gpSrColonia
	 */
	public String getGpSrColonia() {
		return gpSrColonia;
	}

	/**
	 * @param gpSrColonia
	 *            the gpSrColonia to set
	 */
	public void setGpSrColonia(String gpSrColonia) {
		this.gpSrColonia = gpSrColonia;
	}

	/**
	 * @return the gpClaveAjustador
	 */
	public String getGpClaveAjustador() {
		return gpClaveAjustador;
	}

	/**
	 * @param gpClaveAjustador
	 *            the gpClaveAjustador to set
	 */
	public void setGpClaveAjustador(String gpClaveAjustador) {
		this.gpClaveAjustador = gpClaveAjustador;
	}

	/**
	 * @return the gpDias
	 */
	public String getGpDias() {
		return gpDias;
	}

	/**
	 * @param gpDias
	 *            the gpDias to set
	 */
	public void setGpDias(String gpDias) {
		this.gpDias = gpDias;
	}

	/**
	 * @return the gpNomDeudor
	 */
	public String getGpNomDeudor() {
		return gpNomDeudor;
	}

	/**
	 * @param gpNomDeudor
	 *            the gpNomDeudor to set
	 */
	public void setGpNomDeudor(String gpNomDeudor) {
		this.gpNomDeudor = gpNomDeudor;
	}

	/**
	 * @return the gpNumReporte
	 */
	public String getGpNumReporte() {
		return gpNumReporte;
	}

	/**
	 * @param gpNumReporte
	 *            the gpNumReporte to set
	 */
	public void setGpNumReporte(String gpNumReporte) {
		this.gpNumReporte = gpNumReporte;
	}

	/**
	 * @return the gpSr
	 */
	public String getGpSr() {
		return gpSr;
	}

	/**
	 * @param gpSr
	 *            the gpSr to set
	 */
	public void setGpSr(String gpSr) {
		this.gpSr = gpSr;
	}

	/**
	 * @return the gpSrIdentificacion
	 */
	public String getGpSrIdentificacion() {
		return gpSrIdentificacion;
	}

	/**
	 * @param gpSrIdentificacion
	 *            the gpSrIdentificacion to set
	 */
	public void setGpSrIdentificacion(String gpSrIdentificacion) {
		this.gpSrIdentificacion = gpSrIdentificacion;
	}

	/**
	 * @return the gpAsegurado
	 */
	public String getGpAsegurado() {
		return gpAsegurado;
	}

	/**
	 * @param gpAsegurado
	 *            the gpAsegurado to set
	 */
	public void setGpAsegurado(String gpAsegurado) {
		this.gpAsegurado = gpAsegurado;
	}

	/**
	 * @return the gpCantidad
	 */
	public String getGpCantidad() {
		return gpCantidad;
	}

	/**
	 * @param gpCantidad
	 *            the gpCantidad to set
	 */
	public void setGpCantidad(String gpCantidad) {
		this.gpCantidad = gpCantidad;
	}

	/**
	 * @return the gpNumInciso
	 */
	public String getGpNumInciso() {
		return gpNumInciso;
	}

	/**
	 * @param gpNumInciso
	 *            the gpNumInciso to set
	 */
	public void setGpNumInciso(String gpNumInciso) {
		this.gpNumInciso = gpNumInciso;
	}

	/**
	 * @return the gpMarcaAuto
	 */
	public String getGpMarcaAuto() {
		return gpMarcaAuto;
	}

	/**
	 * @param gpMarcaAuto
	 *            the gpMarcaAuto to set
	 */
	public void setGpMarcaAuto(String gpMarcaAuto) {
		this.gpMarcaAuto = gpMarcaAuto;
	}

	/**
	 * @return the gpFacturaFecha
	 */
	public Date getGpFacturaFecha() {
		return gpFacturaFecha;
	}

	/**
	 * @param gpFacturaFecha
	 *            the gpFacturaFecha to set
	 */
	public void setGpFacturaFecha(Date gpFacturaFecha) {
		this.gpFacturaFecha = gpFacturaFecha;
	}

	/**
	 * @return the gpFecha
	 */
	public Date getGpFecha() {
		return gpFecha;
	}

	/**
	 * @param gpFecha
	 *            the gpFecha to set
	 */
	public void setGpFecha(Date gpFecha) {
		this.gpFecha = gpFecha;
	}

	/**
	 * @return the gpSrCp
	 */
	public String getGpSrCp() {
		return gpSrCp;
	}

	/**
	 * @param gpSrCp
	 *            the gpSrCp to set
	 */
	public void setGpSrCp(String gpSrCp) {
		this.gpSrCp = gpSrCp;
	}

	/**
	 * @return the gpCantidadLetra
	 */
	public String getGpCantidadLetra() {
		return gpCantidadLetra;
	}

	/**
	 * @param gpCantidadLetra
	 *            the gpCantidadLetra to set
	 */
	public void setGpCantidadLetra(String gpCantidadLetra) {
		this.gpCantidadLetra = gpCantidadLetra;
	}

	/**
	 * @return the gpModeloAuto
	 */
	public String getGpModeloAuto() {
		return gpModeloAuto;
	}

	/**
	 * @param gpModeloAuto
	 *            the gpModeloAuto to set
	 */
	public void setGpModeloAuto(String gpModeloAuto) {
		this.gpModeloAuto = gpModeloAuto;
	}

	/**
	 * @return the gpNumPoliza
	 */
	public String getGpNumPoliza() {
		return gpNumPoliza;
	}

	/**
	 * @param gpNumPoliza
	 *            the gpNumPoliza to set
	 */
	public void setGpNumPoliza(String gpNumPoliza) {
		this.gpNumPoliza = gpNumPoliza;
	}

	/**
	 * @return the gpTipoAuto
	 */
	public String getGpTipoAuto() {
		return gpTipoAuto;
	}

	/**
	 * @param gpTipoAuto
	 *            the gpTipoAuto to set
	 */
	public void setGpTipoAuto(String gpTipoAuto) {
		this.gpTipoAuto = gpTipoAuto;
	}

	/**
	 * @return the gpFechaFirma
	 */
	public Date getGpFechaFirma() {
		return gpFechaFirma;
	}

	/**
	 * @param gpFechaFirma
	 *            the gpFechaFirma to set
	 */
	public void setGpFechaFirma(Date gpFechaFirma) {
		this.gpFechaFirma = gpFechaFirma;
	}

	/**
	 * @return the gpFacturaExpedida
	 */
	public String getGpFacturaExpedida() {
		return gpFacturaExpedida;
	}

	/**
	 * @param gpFacturaExpedida
	 *            the gpFacturaExpedida to set
	 */
	public void setGpFacturaExpedida(String gpFacturaExpedida) {
		this.gpFacturaExpedida = gpFacturaExpedida;
	}

	/**
	 * @return the gpColorAuto
	 */
	public String getGpColorAuto() {
		return gpColorAuto;
	}

	/**
	 * @param gpColorAuto
	 *            the gpColorAuto to set
	 */
	public void setGpColorAuto(String gpColorAuto) {
		this.gpColorAuto = gpColorAuto;
	}

	/**
	 * @return the gpSrCalle
	 */
	public String getGpSrCalle() {
		return gpSrCalle;
	}

	/**
	 * @param gpSrCalle
	 *            the gpSrCalle to set
	 */
	public void setGpSrCalle(String gpSrCalle) {
		this.gpSrCalle = gpSrCalle;
	}

	/**
	 * @return the gpSrMunicipio
	 */
	public String getGpSrMunicipio() {
		return gpSrMunicipio;
	}

	/**
	 * @param gpSrMunicipio
	 *            the gpSrMunicipio to set
	 */
	public void setGpSrMunicipio(String gpSrMunicipio) {
		this.gpSrMunicipio = gpSrMunicipio;
	}

	/**
	 * @return the gpSrCiudad
	 */
	public String getGpSrCiudad() {
		return gpSrCiudad;
	}

	/**
	 * @param gpSrCiudad
	 *            the gpSrCiudad to set
	 */
	public void setGpSrCiudad(String gpSrCiudad) {
		this.gpSrCiudad = gpSrCiudad;
	}

	/**
	 * @return the gpFactura
	 */
	public String getGpFactura() {
		return gpFactura;
	}

	/**
	 * @param gpFactura
	 *            the gpFactura to set
	 */
	public void setGpFactura(String gpFactura) {
		this.gpFactura = gpFactura;
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
	 * @param nodoEnvio
	 *            the nodoEnvio to set
	 */
	public void setNodoEnvio(String nodoEnvio) {
		this.nodoEnvio = nodoEnvio;
	}

	/**
	 * @return the firmaDeudor
	 */
	public String getFirmaDeudor() {
		return firmaDeudor;
	}

	/**
	 * @param firmaDeudor
	 *            the firmaDeudor to set
	 */
	public void setFirmaDeudor(String firmaDeudor) {
		this.firmaDeudor = firmaDeudor;
	}

	/**
	 * @return the firmaAcreedor
	 */
	public String getFirmaAcreedor() {
		return firmaAcreedor;
	}

	/**
	 * @param firmaAcreedor
	 *            the firmaAcreedor to set
	 */
	public void setFirmaAcreedor(String firmaAcreedor) {
		this.firmaAcreedor = firmaAcreedor;
	}

}
