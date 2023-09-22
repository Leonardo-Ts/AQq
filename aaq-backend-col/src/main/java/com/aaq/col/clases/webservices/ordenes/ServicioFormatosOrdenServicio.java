/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;
import java.util.Date;

//import javax.persistence.metamodel.SingularAttribute;
//
//import com.jmfg.siicaserver.system.database.entidades.FormatoOrdenServicio;

/**
 * @author jpestrategica6
 *
 */
public class ServicioFormatosOrdenServicio {

	private String passwd;
	private Date osFechaAtencion;
	private String osSexoConductor;
	private String ftpRespuesta;
	private String osPoliza;
	private String osTipoAuto;
	private String osNumInciso;
	private String osPlacasAuto;
	private String osNumReporte;
	private Integer osEdadConductor;
	private Timestamp osHoraArribo;
	private String osNomAjustador;
	private String osTelConductor;
	private Timestamp osHoraTermino;
	private Integer osTipoServicio;
	private String osEmailConductor;
	private String osLugarServicio;
	private Integer osSurtidoCombustible;
	private Timestamp osHoraReporte;
	private Integer enviadoFtp;
	private Integer osId;
	private String osNumSiniestro;
	private String osInformeAjustador;
	private String osNomConductor;
	private String osModeloAuto;
	private String osClave;
	private String osNumSerieAuto;
	private String osAsegurado;
	private String usuario;
	private String osMarcaAuto;
	private String osAnioAuto;
	private String osNumFolio;

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

	public ServicioFormatosOrdenServicio() {
		super();

	}

	/**
	 * @return the osFechaAtencion
	 */
	public Date getOsFechaAtencion() {
		return osFechaAtencion;
	}

	/**
	 * @param osFechaAtencion
	 *            the osFechaAtencion to set
	 */
	public void setOsFechaAtencion(Date osFechaAtencion) {
		this.osFechaAtencion = osFechaAtencion;
	}

	/**
	 * @return the osSexoConductor
	 */
	public String getOsSexoConductor() {
		return osSexoConductor;
	}

	/**
	 * @param osSexoConductor
	 *            the osSexoConductor to set
	 */
	public void setOsSexoConductor(String osSexoConductor) {
		this.osSexoConductor = osSexoConductor;
	}

	/**
	 * @return the ftpRespuesta
	 */
	public String getFtpRespuesta() {
		return ftpRespuesta;
	}

	/**
	 * @param ftpRespuesta
	 *            the ftpRespuesta to set
	 */
	public void setFtpRespuesta(String ftpRespuesta) {
		this.ftpRespuesta = ftpRespuesta;
	}

	/**
	 * @return the osPoliza
	 */
	public String getOsPoliza() {
		return osPoliza;
	}

	/**
	 * @param osPoliza
	 *            the osPoliza to set
	 */
	public void setOsPoliza(String osPoliza) {
		this.osPoliza = osPoliza;
	}

	/**
	 * @return the osTipoAuto
	 */
	public String getOsTipoAuto() {
		return osTipoAuto;
	}

	/**
	 * @param osTipoAuto
	 *            the osTipoAuto to set
	 */
	public void setOsTipoAuto(String osTipoAuto) {
		this.osTipoAuto = osTipoAuto;
	}

	/**
	 * @return the osNumInciso
	 */
	public String getOsNumInciso() {
		return osNumInciso;
	}

	/**
	 * @param osNumInciso
	 *            the osNumInciso to set
	 */
	public void setOsNumInciso(String osNumInciso) {
		this.osNumInciso = osNumInciso;
	}

	/**
	 * @return the osPlacasAuto
	 */
	public String getOsPlacasAuto() {
		return osPlacasAuto;
	}

	/**
	 * @param osPlacasAuto
	 *            the osPlacasAuto to set
	 */
	public void setOsPlacasAuto(String osPlacasAuto) {
		this.osPlacasAuto = osPlacasAuto;
	}

	/**
	 * @return the osNumReporte
	 */
	public String getOsNumReporte() {
		return osNumReporte;
	}

	/**
	 * @param osNumReporte
	 *            the osNumReporte to set
	 */
	public void setOsNumReporte(String osNumReporte) {
		this.osNumReporte = osNumReporte;
	}

	/**
	 * @return the osEdadConductor
	 */
	public Integer getOsEdadConductor() {
		return osEdadConductor;
	}

	/**
	 * @param osEdadConductor
	 *            the osEdadConductor to set
	 */
	public void setOsEdadConductor(Integer osEdadConductor) {
		this.osEdadConductor = osEdadConductor;
	}

	/**
	 * @return the osHoraArribo
	 */
	public Timestamp getOsHoraArribo() {
		return osHoraArribo;
	}

	/**
	 * @param osHoraArribo
	 *            the osHoraArribo to set
	 */
	public void setOsHoraArribo(Timestamp osHoraArribo) {
		this.osHoraArribo = osHoraArribo;
	}

	/**
	 * @return the osNomAjustador
	 */
	public String getOsNomAjustador() {
		return osNomAjustador;
	}

	/**
	 * @param osNomAjustador
	 *            the osNomAjustador to set
	 */
	public void setOsNomAjustador(String osNomAjustador) {
		this.osNomAjustador = osNomAjustador;
	}

	/**
	 * @return the osTelConductor
	 */
	public String getOsTelConductor() {
		return osTelConductor;
	}

	/**
	 * @param osTelConductor
	 *            the osTelConductor to set
	 */
	public void setOsTelConductor(String osTelConductor) {
		this.osTelConductor = osTelConductor;
	}

	/**
	 * @return the osHoraTermino
	 */
	public Timestamp getOsHoraTermino() {
		return osHoraTermino;
	}

	/**
	 * @param osHoraTermino
	 *            the osHoraTermino to set
	 */
	public void setOsHoraTermino(Timestamp osHoraTermino) {
		this.osHoraTermino = osHoraTermino;
	}

	/**
	 * @return the osTipoServicio
	 */
	public Integer getOsTipoServicio() {
		return osTipoServicio;
	}

	/**
	 * @param osTipoServicio
	 *            the osTipoServicio to set
	 */
	public void setOsTipoServicio(Integer osTipoServicio) {
		this.osTipoServicio = osTipoServicio;
	}

	/**
	 * @return the osEmailConductor
	 */
	public String getOsEmailConductor() {
		return osEmailConductor;
	}

	/**
	 * @param osEmailConductor
	 *            the osEmailConductor to set
	 */
	public void setOsEmailConductor(String osEmailConductor) {
		this.osEmailConductor = osEmailConductor;
	}

	/**
	 * @return the osLugarServicio
	 */
	public String getOsLugarServicio() {
		return osLugarServicio;
	}

	/**
	 * @param osLugarServicio
	 *            the osLugarServicio to set
	 */
	public void setOsLugarServicio(String osLugarServicio) {
		this.osLugarServicio = osLugarServicio;
	}

	/**
	 * @return the osSurtidoCombustible
	 */
	public Integer getOsSurtidoCombustible() {
		return osSurtidoCombustible;
	}

	/**
	 * @param osSurtidoCombustible
	 *            the osSurtidoCombustible to set
	 */
	public void setOsSurtidoCombustible(Integer osSurtidoCombustible) {
		this.osSurtidoCombustible = osSurtidoCombustible;
	}

	/**
	 * @return the osHoraReporte
	 */
	public Timestamp getOsHoraReporte() {
		return osHoraReporte;
	}

	/**
	 * @param osHoraReporte
	 *            the osHoraReporte to set
	 */
	public void setOsHoraReporte(Timestamp osHoraReporte) {
		this.osHoraReporte = osHoraReporte;
	}

	/**
	 * @return the enviadoFtp
	 */
	public Integer getEnviadoFtp() {
		return enviadoFtp;
	}

	/**
	 * @param enviadoFtp
	 *            the enviadoFtp to set
	 */
	public void setEnviadoFtp(Integer enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}

	/**
	 * @return the osId
	 */
	public Integer getOsId() {
		return osId;
	}

	/**
	 * @param osId
	 *            the osId to set
	 */
	public void setOsId(Integer osId) {
		this.osId = osId;
	}

	/**
	 * @return the osNumSiniestro
	 */
	public String getOsNumSiniestro() {
		return osNumSiniestro;
	}

	/**
	 * @param osNumSiniestro
	 *            the osNumSiniestro to set
	 */
	public void setOsNumSiniestro(String osNumSiniestro) {
		this.osNumSiniestro = osNumSiniestro;
	}

	/**
	 * @return the osInformeAjustador
	 */
	public String getOsInformeAjustador() {
		return osInformeAjustador;
	}

	/**
	 * @param osInformeAjustador
	 *            the osInformeAjustador to set
	 */
	public void setOsInformeAjustador(String osInformeAjustador) {
		this.osInformeAjustador = osInformeAjustador;
	}

	/**
	 * @return the osNomConductor
	 */
	public String getOsNomConductor() {
		return osNomConductor;
	}

	/**
	 * @param osNomConductor
	 *            the osNomConductor to set
	 */
	public void setOsNomConductor(String osNomConductor) {
		this.osNomConductor = osNomConductor;
	}

	/**
	 * @return the osModeloAuto
	 */
	public String getOsModeloAuto() {
		return osModeloAuto;
	}

	/**
	 * @param osModeloAuto
	 *            the osModeloAuto to set
	 */
	public void setOsModeloAuto(String osModeloAuto) {
		this.osModeloAuto = osModeloAuto;
	}

	/**
	 * @return the osClave
	 */
	public String getOsClave() {
		return osClave;
	}

	/**
	 * @param osClave
	 *            the osClave to set
	 */
	public void setOsClave(String osClave) {
		this.osClave = osClave;
	}

	/**
	 * @return the osNumSerieAuto
	 */
	public String getOsNumSerieAuto() {
		return osNumSerieAuto;
	}

	/**
	 * @param osNumSerieAuto
	 *            the osNumSerieAuto to set
	 */
	public void setOsNumSerieAuto(String osNumSerieAuto) {
		this.osNumSerieAuto = osNumSerieAuto;
	}

	/**
	 * @return the osAsegurado
	 */
	public String getOsAsegurado() {
		return osAsegurado;
	}

	/**
	 * @param osAsegurado
	 *            the osAsegurado to set
	 */
	public void setOsAsegurado(String osAsegurado) {
		this.osAsegurado = osAsegurado;
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
	 * @return the osMarcaAuto
	 */
	public String getOsMarcaAuto() {
		return osMarcaAuto;
	}

	/**
	 * @param osMarcaAuto
	 *            the osMarcaAuto to set
	 */
	public void setOsMarcaAuto(String osMarcaAuto) {
		this.osMarcaAuto = osMarcaAuto;
	}

	/**
	 * @return the osAnioAuto
	 */
	public String getOsAnioAuto() {
		return osAnioAuto;
	}

	/**
	 * @param osAnioAuto
	 *            the osAnioAuto to set
	 */
	public void setOsAnioAuto(String osAnioAuto) {
		this.osAnioAuto = osAnioAuto;
	}

	/**
	 * @return the osNumFolio
	 */
	public String getOsNumFolio() {
		return osNumFolio;
	}

	/**
	 * @param osNumFolio
	 *            the osNumFolio to set
	 */
	public void setOsNumFolio(String osNumFolio) {
		this.osNumFolio = osNumFolio;
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
