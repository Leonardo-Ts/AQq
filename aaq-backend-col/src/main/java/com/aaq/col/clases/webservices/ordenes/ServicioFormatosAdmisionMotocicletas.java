package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;

public class ServicioFormatosAdmisionMotocicletas {

	private String usuario;
	private String passwd;
	private String oaTipoAuto;
	private String oaFolioElectro;
	private String oaNumEndoso;
	private String oaMarcaAuto;
	private String oaEmailCliente;
	private String oaDescDanios;

	private Integer oaDeducible;
	private String oaNumInciso;
	private String oaNumPoliza;
	private String oaNumReporte;
	private Integer oaTManual;
	private String oaPorcentajeDed;
	private String oaNumSerie;
	private String oaSumaAsegurada;
	private Integer oaAdminDeducible;
	private String oaNomAjustador;
	private String oaTelCliente;
	private String oaDaniosPre;
	private String oaRazonResponsable;
	private String oaFolio;
	private String oaNomCliente;
	private String oaRazonTelefono;
	private String oaRazonEnvio;
	private String oaPlacaAuto;
	private String oaRazonCobertura;
	private String oaModeloAuto;
	private Timestamp oaFecha;
	private String oaAsegurado;
	private String oaKilometraje;
	private String oaCantidad;
	private Integer oaTipoDeducible;
	private String oaClaveAjustador;
	private Integer oaPerdidaTotal;
	private String oaRazonDomicilio;
	private String oaNumSiniestro;
	private String oaColorAuto;
	private String oaAgravamiento;
	private Integer oaId;
	private Integer oaNivelInundacion;
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
	private String oa_codigo_qr;
	private Integer oa_pt_evidente;
	private Integer oa_abandono;

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
	 * @return the oaTipoAuto
	 */
	public String getOaTipoAuto() {
		return oaTipoAuto;
	}

	/**
	 * @param oaTipoAuto
	 *            the oaTipoAuto to set
	 */
	public void setOaTipoAuto(String oaTipoAuto) {
		this.oaTipoAuto = oaTipoAuto;
	}

	/**
	 * @return the oaFolioElectro
	 */
	public String getOaFolioElectro() {
		return oaFolioElectro;
	}

	/**
	 * @param oaFolioElectro
	 *            the oaFolioElectro to set
	 */
	public void setOaFolioElectro(String oaFolioElectro) {
		this.oaFolioElectro = oaFolioElectro;
	}

	/**
	 * @return the oaNumEndoso
	 */
	public String getOaNumEndoso() {
		return oaNumEndoso;
	}

	/**
	 * @param oaNumEndoso
	 *            the oaNumEndoso to set
	 */
	public void setOaNumEndoso(String oaNumEndoso) {
		this.oaNumEndoso = oaNumEndoso;
	}

	/**
	 * @return the oaMarcaAuto
	 */
	public String getOaMarcaAuto() {
		return oaMarcaAuto;
	}

	/**
	 * @param oaMarcaAuto
	 *            the oaMarcaAuto to set
	 */
	public void setOaMarcaAuto(String oaMarcaAuto) {
		this.oaMarcaAuto = oaMarcaAuto;
	}

	/**
	 * @return the oaEmailCliente
	 */
	public String getOaEmailCliente() {
		return oaEmailCliente;
	}

	/**
	 * @param oaEmailCliente
	 *            the oaEmailCliente to set
	 */
	public void setOaEmailCliente(String oaEmailCliente) {
		this.oaEmailCliente = oaEmailCliente;
	}

	/**
	 * @return the oaDescDanios
	 */
	public String getOaDescDanios() {
		return oaDescDanios;
	}

	/**
	 * @param oaDescDanios
	 *            the oaDescDanios to set
	 */
	public void setOaDescDanios(String oaDescDanios) {
		this.oaDescDanios = oaDescDanios;
	}

	/**
	 * @return the oaHora
	 */

	/**
	 * @return the oaDeducible
	 */
	public Integer getOaDeducible() {
		return oaDeducible;
	}

	/**
	 * @param oaDeducible
	 *            the oaDeducible to set
	 */
	public void setOaDeducible(Integer oaDeducible) {
		this.oaDeducible = oaDeducible;
	}

	/**
	 * @return the oaNumInciso
	 */
	public String getOaNumInciso() {
		return oaNumInciso;
	}

	/**
	 * @param oaNumInciso
	 *            the oaNumInciso to set
	 */
	public void setOaNumInciso(String oaNumInciso) {
		this.oaNumInciso = oaNumInciso;
	}

	/**
	 * @return the oaNumPoliza
	 */
	public String getOaNumPoliza() {
		return oaNumPoliza;
	}

	/**
	 * @param oaNumPoliza
	 *            the oaNumPoliza to set
	 */
	public void setOaNumPoliza(String oaNumPoliza) {
		this.oaNumPoliza = oaNumPoliza;
	}

	/**
	 * @return the oaNumReporte
	 */
	public String getOaNumReporte() {
		return oaNumReporte;
	}

	/**
	 * @param oaNumReporte
	 *            the oaNumReporte to set
	 */
	public void setOaNumReporte(String oaNumReporte) {
		this.oaNumReporte = oaNumReporte;
	}

	/**
	 * @return the oaTManual
	 */
	public Integer getOaTManual() {
		return oaTManual;
	}

	/**
	 * @param oaTManual
	 *            the oaTManual to set
	 */
	public void setOaTManual(Integer oaTManual) {
		this.oaTManual = oaTManual;
	}

	/**
	 * @return the oaPorcentajeDed
	 */
	public String getOaPorcentajeDed() {
		return oaPorcentajeDed;
	}

	/**
	 * @param oaPorcentajeDed
	 *            the oaPorcentajeDed to set
	 */
	public void setOaPorcentajeDed(String oaPorcentajeDed) {
		this.oaPorcentajeDed = oaPorcentajeDed;
	}

	/**
	 * @return the oaNumSerie
	 */
	public String getOaNumSerie() {
		return oaNumSerie;
	}

	/**
	 * @param oaNumSerie
	 *            the oaNumSerie to set
	 */
	public void setOaNumSerie(String oaNumSerie) {
		this.oaNumSerie = oaNumSerie;
	}

	/**
	 * @return the oaSumaAsegurada
	 */
	public String getOaSumaAsegurada() {
		return oaSumaAsegurada;
	}

	/**
	 * @param oaSumaAsegurada
	 *            the oaSumaAsegurada to set
	 */
	public void setOaSumaAsegurada(String oaSumaAsegurada) {
		this.oaSumaAsegurada = oaSumaAsegurada;
	}

	/**
	 * @return the oaAdminDeducible
	 */
	public Integer getOaAdminDeducible() {
		return oaAdminDeducible;
	}

	/**
	 * @param oaAdminDeducible
	 *            the oaAdminDeducible to set
	 */
	public void setOaAdminDeducible(Integer oaAdminDeducible) {
		this.oaAdminDeducible = oaAdminDeducible;
	}

	/**
	 * @return the oaNomAjustador
	 */
	public String getOaNomAjustador() {
		return oaNomAjustador;
	}

	/**
	 * @param oaNomAjustador
	 *            the oaNomAjustador to set
	 */
	public void setOaNomAjustador(String oaNomAjustador) {
		this.oaNomAjustador = oaNomAjustador;
	}

	/**
	 * @return the oaTelCliente
	 */
	public String getOaTelCliente() {
		return oaTelCliente;
	}

	/**
	 * @param oaTelCliente
	 *            the oaTelCliente to set
	 */
	public void setOaTelCliente(String oaTelCliente) {
		this.oaTelCliente = oaTelCliente;
	}

	/**
	 * @return the oaDaniosPre
	 */
	public String getOaDaniosPre() {
		return oaDaniosPre;
	}

	/**
	 * @param oaDaniosPre
	 *            the oaDaniosPre to set
	 */
	public void setOaDaniosPre(String oaDaniosPre) {
		this.oaDaniosPre = oaDaniosPre;
	}

	/**
	 * @return the oaRazonResponsable
	 */
	public String getOaRazonResponsable() {
		return oaRazonResponsable;
	}

	/**
	 * @param oaRazonResponsable
	 *            the oaRazonResponsable to set
	 */
	public void setOaRazonResponsable(String oaRazonResponsable) {
		this.oaRazonResponsable = oaRazonResponsable;
	}

	/**
	 * @return the oaFolio
	 */
	public String getOaFolio() {
		return oaFolio;
	}

	/**
	 * @param oaFolio
	 *            the oaFolio to set
	 */
	public void setOaFolio(String oaFolio) {
		this.oaFolio = oaFolio;
	}

	/**
	 * @return the oaNomCliente
	 */
	public String getOaNomCliente() {
		return oaNomCliente;
	}

	/**
	 * @param oaNomCliente
	 *            the oaNomCliente to set
	 */
	public void setOaNomCliente(String oaNomCliente) {
		this.oaNomCliente = oaNomCliente;
	}

	/**
	 * @return the oaRazonTelefono
	 */
	public String getOaRazonTelefono() {
		return oaRazonTelefono;
	}

	/**
	 * @param oaRazonTelefono
	 *            the oaRazonTelefono to set
	 */
	public void setOaRazonTelefono(String oaRazonTelefono) {
		this.oaRazonTelefono = oaRazonTelefono;
	}

	/**
	 * @return the oaRazonEnvio
	 */
	public String getOaRazonEnvio() {
		return oaRazonEnvio;
	}

	/**
	 * @param oaRazonEnvio
	 *            the oaRazonEnvio to set
	 */
	public void setOaRazonEnvio(String oaRazonEnvio) {
		this.oaRazonEnvio = oaRazonEnvio;
	}

	/**
	 * @return the oaPlacaAuto
	 */
	public String getOaPlacaAuto() {
		return oaPlacaAuto;
	}

	/**
	 * @param oaPlacaAuto
	 *            the oaPlacaAuto to set
	 */
	public void setOaPlacaAuto(String oaPlacaAuto) {
		this.oaPlacaAuto = oaPlacaAuto;
	}

	/**
	 * @return the oaRazonCobertura
	 */
	public String getOaRazonCobertura() {
		return oaRazonCobertura;
	}

	/**
	 * @param oaRazonCobertura
	 *            the oaRazonCobertura to set
	 */
	public void setOaRazonCobertura(String oaRazonCobertura) {
		this.oaRazonCobertura = oaRazonCobertura;
	}

	/**
	 * @return the oaModeloAuto
	 */
	public String getOaModeloAuto() {
		return oaModeloAuto;
	}

	/**
	 * @param oaModeloAuto
	 *            the oaModeloAuto to set
	 */
	public void setOaModeloAuto(String oaModeloAuto) {
		this.oaModeloAuto = oaModeloAuto;
	}

	/**
	 * @return the oaFecha
	 */
	public Timestamp getOaFecha() {
		return oaFecha;
	}

	/**
	 * @param oaFecha
	 *            the oaFecha to set
	 */
	public void setOaFecha(Timestamp oaFecha) {
		this.oaFecha = oaFecha;
	}

	/**
	 * @return the oaAsegurado
	 */
	public String getOaAsegurado() {
		return oaAsegurado;
	}

	/**
	 * @param oaAsegurado
	 *            the oaAsegurado to set
	 */
	public void setOaAsegurado(String oaAsegurado) {
		this.oaAsegurado = oaAsegurado;
	}

	/**
	 * @return the oaKilometraje
	 */
	public String getOaKilometraje() {
		return oaKilometraje;
	}

	/**
	 * @param oaKilometraje
	 *            the oaKilometraje to set
	 */
	public void setOaKilometraje(String oaKilometraje) {
		this.oaKilometraje = oaKilometraje;
	}

	/**
	 * @return the oaCantidad
	 */
	public String getOaCantidad() {
		return oaCantidad;
	}

	/**
	 * @param oaCantidad
	 *            the oaCantidad to set
	 */
	public void setOaCantidad(String oaCantidad) {
		this.oaCantidad = oaCantidad;
	}

	/**
	 * @return the oaTipoDeducible
	 */
	public Integer getOaTipoDeducible() {
		return oaTipoDeducible;
	}

	/**
	 * @param oaTipoDeducible
	 *            the oaTipoDeducible to set
	 */
	public void setOaTipoDeducible(Integer oaTipoDeducible) {
		this.oaTipoDeducible = oaTipoDeducible;
	}

	/**
	 * @return the oaClaveAjustador
	 */
	public String getOaClaveAjustador() {
		return oaClaveAjustador;
	}

	/**
	 * @param oaClaveAjustador
	 *            the oaClaveAjustador to set
	 */
	public void setOaClaveAjustador(String oaClaveAjustador) {
		this.oaClaveAjustador = oaClaveAjustador;
	}

	/**
	 * @return the oaPerdidaTotal
	 */
	public Integer getOaPerdidaTotal() {
		return oaPerdidaTotal;
	}

	/**
	 * @param oaPerdidaTotal
	 *            the oaPerdidaTotal to set
	 */
	public void setOaPerdidaTotal(Integer oaPerdidaTotal) {
		this.oaPerdidaTotal = oaPerdidaTotal;
	}

	/**
	 * @return the oaRazonDomicilio
	 */
	public String getOaRazonDomicilio() {
		return oaRazonDomicilio;
	}

	/**
	 * @param oaRazonDomicilio
	 *            the oaRazonDomicilio to set
	 */
	public void setOaRazonDomicilio(String oaRazonDomicilio) {
		this.oaRazonDomicilio = oaRazonDomicilio;
	}

	/**
	 * @return the oaNumSiniestro
	 */
	public String getOaNumSiniestro() {
		return oaNumSiniestro;
	}

	/**
	 * @param oaNumSiniestro
	 *            the oaNumSiniestro to set
	 */
	public void setOaNumSiniestro(String oaNumSiniestro) {
		this.oaNumSiniestro = oaNumSiniestro;
	}

	/**
	 * @return the oaColorAuto
	 */
	public String getOaColorAuto() {
		return oaColorAuto;
	}

	/**
	 * @param oaColorAuto
	 *            the oaColorAuto to set
	 */
	public void setOaColorAuto(String oaColorAuto) {
		this.oaColorAuto = oaColorAuto;
	}

	/**
	 * @return the oaAgravamiento
	 */
	public String getOaAgravamiento() {
		return oaAgravamiento;
	}

	/**
	 * @param oaAgravamiento
	 *            the oaAgravamiento to set
	 */
	public void setOaAgravamiento(String oaAgravamiento) {
		this.oaAgravamiento = oaAgravamiento;
	}

	/**
	 * @return the oaId
	 */
	public Integer getOaId() {
		return oaId;
	}

	/**
	 * @param oaId
	 *            the oaId to set
	 */
	public void setOaId(Integer oaId) {
		this.oaId = oaId;
	}

	/**
	 * @return the oaNivelInundacion
	 */
	public Integer getOaNivelInundacion() {
		return oaNivelInundacion;
	}

	/**
	 * @param oaNivelInundacion
	 *            the oaNivelInundacion to set
	 */
	public void setOaNivelInundacion(Integer oaNivelInundacion) {
		this.oaNivelInundacion = oaNivelInundacion;
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

	public String getOa_codigo_qr() {
		return oa_codigo_qr;
	}

	public void setOa_codigo_qr(String oa_codigo_qr) {
		this.oa_codigo_qr = oa_codigo_qr;
	}

	public Integer getOa_pt_evidente() {
		return oa_pt_evidente;
	}

	public void setOa_pt_evidente(Integer oa_pt_evidente) {
		this.oa_pt_evidente = oa_pt_evidente;
	}

	public Integer getOa_abandono() {
		return oa_abandono;
	}

	public void setOa_abandono(Integer oa_abandono) {
		this.oa_abandono = oa_abandono;
	}

}
