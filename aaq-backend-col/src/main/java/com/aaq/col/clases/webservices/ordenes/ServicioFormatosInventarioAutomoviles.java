package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;

public class ServicioFormatosInventarioAutomoviles {

	private String usuario;
	private String passwd;
	private String iaNumReporte;
	private String iaTipoAuto;
	private String iaAsegurado;
	private Timestamp iaHora;
	private String iaInventario1;
	private String iaInventario2;
	private String iaInventario3;
	private String iaInventario4;
	private String iaInventario5;
	private String iaNomAjustador;
	private String iaNumMotor;
	private String iaAnioAuto;
	private String iaNomAsegurado;
	private String iaNumSiniestro;
	private String iaDirDestino;
	private String iaCantidad;
	private String iaObservacion;
	private Integer iaId;
	private Integer iaPuertasAuto;
	private String iaClaveAjustador;
	private String iaColorAuto;
	private String iaMarcaAuto;
	private String iaNomDestino;
	private String iaKilometraje;
	private Integer iaVidaLlantas;
	private String iaNumSerie;
	private Integer iaCombustible;
	private String iaNumInciso;
	private String iaNumPoliza;
	private String iaDesAuto;
	private String iaFolio;
	private String iaNomOperador;

	private String iaNomRazon;

	private Integer iaLlaves;
	private String iaPlacasAuto;
	private Integer iaTManual;
	private Integer iaDestino;
	private ProveedorAdmi proveedor;
	private String emailDefault;
	private Integer enviadoEmail;
	private String mensajeEmail;
	private Integer iaObjetosPer;

	private Integer proceso;
	private Timestamp horaEnvioEmail;
	private Timestamp horaEnvioSftp;
	private String nodoEnvio;

	private Integer check1;
	private Integer check2;
	private Integer check3;
	private Integer check4;

	private String firmaAsegurado;
	private String firmaOperRecibe;
	private String firmaAjusRecibe;
	private String niu;
	private String iaCorreoGrua;
	private String iaCorreoTaller;

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
	 * @return the iaNumReporte
	 */
	public String getIaNumReporte() {
		return iaNumReporte;
	}

	/**
	 * @param iaNumReporte
	 *            the iaNumReporte to set
	 */
	public void setIaNumReporte(String iaNumReporte) {
		this.iaNumReporte = iaNumReporte;
	}

	/**
	 * @return the iaTipoAuto
	 */
	public String getIaTipoAuto() {
		return iaTipoAuto;
	}

	/**
	 * @param iaTipoAuto
	 *            the iaTipoAuto to set
	 */
	public void setIaTipoAuto(String iaTipoAuto) {
		this.iaTipoAuto = iaTipoAuto;
	}

	/**
	 * @return the iaAsegurado
	 */
	public String getIaAsegurado() {
		return iaAsegurado;
	}

	/**
	 * @param iaAsegurado
	 *            the iaAsegurado to set
	 */
	public void setIaAsegurado(String iaAsegurado) {
		this.iaAsegurado = iaAsegurado;
	}

	/**
	 * @return the iaHora
	 */
	public Timestamp getIaHora() {
		return iaHora;
	}

	/**
	 * @param iaHora
	 *            the iaHora to set
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
	 * @param iaInventario1
	 *            the iaInventario1 to set
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
	 * @param iaInventario2
	 *            the iaInventario2 to set
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
	 * @param iaInventario3
	 *            the iaInventario3 to set
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
	 * @param iaInventario4
	 *            the iaInventario4 to set
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
	 * @param iaInventario5
	 *            the iaInventario5 to set
	 */
	public void setIaInventario5(String iaInventario5) {
		this.iaInventario5 = iaInventario5;
	}

	/**
	 * @return the iaNomAjustador
	 */
	public String getIaNomAjustador() {
		return iaNomAjustador;
	}

	/**
	 * @param iaNomAjustador
	 *            the iaNomAjustador to set
	 */
	public void setIaNomAjustador(String iaNomAjustador) {
		this.iaNomAjustador = iaNomAjustador;
	}

	/**
	 * @return the iaNumMotor
	 */
	public String getIaNumMotor() {
		return iaNumMotor;
	}

	/**
	 * @param iaNumMotor
	 *            the iaNumMotor to set
	 */
	public void setIaNumMotor(String iaNumMotor) {
		this.iaNumMotor = iaNumMotor;
	}

	/**
	 * @return the iaAnioAuto
	 */
	public String getIaAnioAuto() {
		return iaAnioAuto;
	}

	/**
	 * @param iaAnioAuto
	 *            the iaAnioAuto to set
	 */
	public void setIaAnioAuto(String iaAnioAuto) {
		this.iaAnioAuto = iaAnioAuto;
	}

	/**
	 * @return the iaNomAsegurado
	 */
	public String getIaNomAsegurado() {
		return iaNomAsegurado;
	}

	/**
	 * @param iaNomAsegurado
	 *            the iaNomAsegurado to set
	 */
	public void setIaNomAsegurado(String iaNomAsegurado) {
		this.iaNomAsegurado = iaNomAsegurado;
	}

	/**
	 * @return the iaNumSiniestro
	 */
	public String getIaNumSiniestro() {
		return iaNumSiniestro;
	}

	/**
	 * @param iaNumSiniestro
	 *            the iaNumSiniestro to set
	 */
	public void setIaNumSiniestro(String iaNumSiniestro) {
		this.iaNumSiniestro = iaNumSiniestro;
	}

	/**
	 * @return the iaDirDestino
	 */
	public String getIaDirDestino() {
		return iaDirDestino;
	}

	/**
	 * @param iaDirDestino
	 *            the iaDirDestino to set
	 */
	public void setIaDirDestino(String iaDirDestino) {
		this.iaDirDestino = iaDirDestino;
	}

	/**
	 * @return the iaCantidad
	 */
	public String getIaCantidad() {
		return iaCantidad;
	}

	/**
	 * @param iaCantidad
	 *            the iaCantidad to set
	 */
	public void setIaCantidad(String iaCantidad) {
		this.iaCantidad = iaCantidad;
	}

	/**
	 * @return the iaObservacion
	 */
	public String getIaObservacion() {
		return iaObservacion;
	}

	/**
	 * @param iaObservacion
	 *            the iaObservacion to set
	 */
	public void setIaObservacion(String iaObservacion) {
		this.iaObservacion = iaObservacion;
	}

	/**
	 * @return the iaId
	 */
	public Integer getIaId() {
		return iaId;
	}

	/**
	 * @param iaId
	 *            the iaId to set
	 */
	public void setIaId(Integer iaId) {
		this.iaId = iaId;
	}

	/**
	 * @return the iaPuertasAuto
	 */
	public Integer getIaPuertasAuto() {
		return iaPuertasAuto;
	}

	/**
	 * @param iaPuertasAuto
	 *            the iaPuertasAuto to set
	 */
	public void setIaPuertasAuto(Integer iaPuertasAuto) {
		this.iaPuertasAuto = iaPuertasAuto;
	}

	/**
	 * @return the iaClaveAjustador
	 */
	public String getIaClaveAjustador() {
		return iaClaveAjustador;
	}

	/**
	 * @param iaClaveAjustador
	 *            the iaClaveAjustador to set
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
	 * @param iaColorAuto
	 *            the iaColorAuto to set
	 */
	public void setIaColorAuto(String iaColorAuto) {
		this.iaColorAuto = iaColorAuto;
	}

	/**
	 * @return the iaMarcaAuto
	 */
	public String getIaMarcaAuto() {
		return iaMarcaAuto;
	}

	/**
	 * @param iaMarcaAuto
	 *            the iaMarcaAuto to set
	 */
	public void setIaMarcaAuto(String iaMarcaAuto) {
		this.iaMarcaAuto = iaMarcaAuto;
	}

	/**
	 * @return the iaNomDestino
	 */
	public String getIaNomDestino() {
		return iaNomDestino;
	}

	/**
	 * @param iaNomDestino
	 *            the iaNomDestino to set
	 */
	public void setIaNomDestino(String iaNomDestino) {
		this.iaNomDestino = iaNomDestino;
	}

	/**
	 * @return the iaKilometraje
	 */
	public String getIaKilometraje() {
		return iaKilometraje;
	}

	/**
	 * @param iaKilometraje
	 *            the iaKilometraje to set
	 */
	public void setIaKilometraje(String iaKilometraje) {
		this.iaKilometraje = iaKilometraje;
	}

	/**
	 * @return the iaVidaLlantas
	 */
	public Integer getIaVidaLlantas() {
		return iaVidaLlantas;
	}

	/**
	 * @param iaVidaLlantas
	 *            the iaVidaLlantas to set
	 */
	public void setIaVidaLlantas(Integer iaVidaLlantas) {
		this.iaVidaLlantas = iaVidaLlantas;
	}

	/**
	 * @return the iaNumSerie
	 */
	public String getIaNumSerie() {
		return iaNumSerie;
	}

	/**
	 * @param iaNumSerie
	 *            the iaNumSerie to set
	 */
	public void setIaNumSerie(String iaNumSerie) {
		this.iaNumSerie = iaNumSerie;
	}

	/**
	 * @return the iaCombustible
	 */
	public Integer getIaCombustible() {
		return iaCombustible;
	}

	/**
	 * @param iaCombustible
	 *            the iaCombustible to set
	 */
	public void setIaCombustible(Integer iaCombustible) {
		this.iaCombustible = iaCombustible;
	}

	/**
	 * @return the iaNumInciso
	 */
	public String getIaNumInciso() {
		return iaNumInciso;
	}

	/**
	 * @param iaNumInciso
	 *            the iaNumInciso to set
	 */
	public void setIaNumInciso(String iaNumInciso) {
		this.iaNumInciso = iaNumInciso;
	}

	/**
	 * @return the iaNumPoliza
	 */
	public String getIaNumPoliza() {
		return iaNumPoliza;
	}

	/**
	 * @param iaNumPoliza
	 *            the iaNumPoliza to set
	 */
	public void setIaNumPoliza(String iaNumPoliza) {
		this.iaNumPoliza = iaNumPoliza;
	}

	/**
	 * @return the iaDesAuto
	 */
	public String getIaDesAuto() {
		return iaDesAuto;
	}

	/**
	 * @param iaDesAuto
	 *            the iaDesAuto to set
	 */
	public void setIaDesAuto(String iaDesAuto) {
		this.iaDesAuto = iaDesAuto;
	}

	/**
	 * @return the iaFolio
	 */
	public String getIaFolio() {
		return iaFolio;
	}

	/**
	 * @param iaFolio
	 *            the iaFolio to set
	 */
	public void setIaFolio(String iaFolio) {
		this.iaFolio = iaFolio;
	}

	/**
	 * @return the iaNomOperador
	 */
	public String getIaNomOperador() {
		return iaNomOperador;
	}

	/**
	 * @param iaNomOperador
	 *            the iaNomOperador to set
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
	 * @param iaNomRazon
	 *            the iaNomRazon to set
	 */
	public void setIaNomRazon(String iaNomRazon) {
		this.iaNomRazon = iaNomRazon;
	}

	/**
	 * @return the iaLlaves
	 */
	public Integer getIaLlaves() {
		return iaLlaves;
	}

	/**
	 * @param iaLlaves
	 *            the iaLlaves to set
	 */
	public void setIaLlaves(Integer iaLlaves) {
		this.iaLlaves = iaLlaves;
	}

	/**
	 * @return the iaPlacasAuto
	 */
	public String getIaPlacasAuto() {
		return iaPlacasAuto;
	}

	/**
	 * @param iaPlacasAuto
	 *            the iaPlacasAuto to set
	 */
	public void setIaPlacasAuto(String iaPlacasAuto) {
		this.iaPlacasAuto = iaPlacasAuto;
	}

	/**
	 * @return the iaTManual
	 */
	public Integer getIaTManual() {
		return iaTManual;
	}

	/**
	 * @param iaTManual
	 *            the iaTManual to set
	 */
	public void setIaTManual(Integer iaTManual) {
		this.iaTManual = iaTManual;
	}

	/**
	 * @return the iaDestino
	 */
	public Integer getIaDestino() {
		return iaDestino;
	}

	/**
	 * @param iaDestino
	 *            the iaDestino to set
	 */
	public void setIaDestino(Integer iaDestino) {
		this.iaDestino = iaDestino;
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
	 * @return the iaObjetosPer
	 */
	public Integer getIaObjetosPer() {
		return iaObjetosPer;
	}

	/**
	 * @param iaObjetosPer
	 *            the iaObjetosPer to set
	 */
	public void setIaObjetosPer(Integer iaObjetosPer) {
		this.iaObjetosPer = iaObjetosPer;
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

	/**
	 * @return the firmaOperRecibe
	 */
	public String getFirmaOperRecibe() {
		return firmaOperRecibe;
	}

	/**
	 * @param firmaOperRecibe
	 *            the firmaOperRecibe to set
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
	 * @param firmaAjusRecibe
	 *            the firmaAjusRecibe to set
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
