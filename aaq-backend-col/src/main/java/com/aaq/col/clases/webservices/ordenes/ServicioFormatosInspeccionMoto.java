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
public class ServicioFormatosInspeccionMoto {

	String passwd;
	String imNumSerie;
	Integer imAseguradoCompa;
	String imCompania;

	String imAsegurado;
	String imEstandarT;
	Integer imPago;
	Integer imAdaptaciones;
	String imPlacas;
	Integer idAjustador;
	String imFolio;
	String imNomAjustador;
	Integer enviadoEmail;
	Integer imTCirculacion1;
	String imMarca;
	String imNumSiniestro;
	String imTipo;
	Integer imEquipoSiNo;
	Integer imImportacion1;
	String imSolicitante;
	String imNumReporte;
	String imEmail;
	String imModelo;
	String imClaveAjustador;
	String imUbicacion;
	String usuario;
	String imKilometraje;
	String imTelefono;
	Integer imTipoEncargado;
	Date imFecha;
	Date imFechaInspeccion;
	Integer imAdaptacionesSiNo;
	String imOficina;
	Integer imCirculacion;
	String imColor;
	Integer imProcedencia;
	String mensajeEmail;
	Integer imPagoSiNo;
	Integer imDocumentacion2;
	Integer imDocumentacion1;
	String imNumInciso;

	String imNumPoliza;

	String imTotalFotos;
	Date imDiaHora;
	String imObservaciones;
	String imAtencion;
	String imNomCliente;

	private Integer proceso;
	private Timestamp horaEnvioEmail;
	private Timestamp horaEnvioSftp;
	private String nodoEnvio;

	private Integer check1;
	private Integer check2;
	private Integer check3;
	private Integer check4;

	private String firmaCliente;
	private String firmaAgente;

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
	 * @return the imNumSerie
	 */
	public String getImNumSerie() {
		return imNumSerie;
	}

	/**
	 * @param imNumSerie
	 *            the imNumSerie to set
	 */
	public void setImNumSerie(String imNumSerie) {
		this.imNumSerie = imNumSerie;
	}

	/**
	 * @return the imAseguradoCompa
	 */
	public Integer getImAseguradoCompa() {
		return imAseguradoCompa;
	}

	/**
	 * @param imAseguradoCompa
	 *            the imAseguradoCompa to set
	 */
	public void setImAseguradoCompa(Integer imAseguradoCompa) {
		this.imAseguradoCompa = imAseguradoCompa;
	}

	/**
	 * @return the imCompania
	 */
	public String getImCompania() {
		return imCompania;
	}

	/**
	 * @param imCompania
	 *            the imCompania to set
	 */
	public void setImCompania(String imCompania) {
		this.imCompania = imCompania;
	}

	/**
	 * @return the imAsegurado
	 */
	public String getImAsegurado() {
		return imAsegurado;
	}

	/**
	 * @param imAsegurado
	 *            the imAsegurado to set
	 */
	public void setImAsegurado(String imAsegurado) {
		this.imAsegurado = imAsegurado;
	}

	/**
	 * @return the imEstandarT
	 */
	public String getImEstandarT() {
		return imEstandarT;
	}

	/**
	 * @param imEstandarT
	 *            the imEstandarT to set
	 */
	public void setImEstandarT(String imEstandarT) {
		this.imEstandarT = imEstandarT;
	}

	/**
	 * @return the imPago
	 */
	public Integer getImPago() {
		return imPago;
	}

	/**
	 * @param imPago
	 *            the imPago to set
	 */
	public void setImPago(Integer imPago) {
		this.imPago = imPago;
	}

	/**
	 * @return the imAdaptaciones
	 */
	public Integer getImAdaptaciones() {
		return imAdaptaciones;
	}

	/**
	 * @param imAdaptaciones
	 *            the imAdaptaciones to set
	 */
	public void setImAdaptaciones(Integer imAdaptaciones) {
		this.imAdaptaciones = imAdaptaciones;
	}

	/**
	 * @return the imPlacas
	 */
	public String getImPlacas() {
		return imPlacas;
	}

	/**
	 * @param imPlacas
	 *            the imPlacas to set
	 */
	public void setImPlacas(String imPlacas) {
		this.imPlacas = imPlacas;
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
	 * @return the imFolio
	 */
	public String getImFolio() {
		return imFolio;
	}

	/**
	 * @param imFolio
	 *            the imFolio to set
	 */
	public void setImFolio(String imFolio) {
		this.imFolio = imFolio;
	}

	/**
	 * @return the imNomAjustador
	 */
	public String getImNomAjustador() {
		return imNomAjustador;
	}

	/**
	 * @param imNomAjustador
	 *            the imNomAjustador to set
	 */
	public void setImNomAjustador(String imNomAjustador) {
		this.imNomAjustador = imNomAjustador;
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
	 * @return the imTCirculacion1
	 */
	public Integer getImTCirculacion1() {
		return imTCirculacion1;
	}

	/**
	 * @param imTCirculacion1
	 *            the imTCirculacion1 to set
	 */
	public void setImTCirculacion1(Integer imTCirculacion1) {
		this.imTCirculacion1 = imTCirculacion1;
	}

	/**
	 * @return the imMarca
	 */
	public String getImMarca() {
		return imMarca;
	}

	/**
	 * @param imMarca
	 *            the imMarca to set
	 */
	public void setImMarca(String imMarca) {
		this.imMarca = imMarca;
	}

	/**
	 * @return the imNumSiniestro
	 */
	public String getImNumSiniestro() {
		return imNumSiniestro;
	}

	/**
	 * @param imNumSiniestro
	 *            the imNumSiniestro to set
	 */
	public void setImNumSiniestro(String imNumSiniestro) {
		this.imNumSiniestro = imNumSiniestro;
	}

	/**
	 * @return the imTipo
	 */
	public String getImTipo() {
		return imTipo;
	}

	/**
	 * @param imTipo
	 *            the imTipo to set
	 */
	public void setImTipo(String imTipo) {
		this.imTipo = imTipo;
	}

	/**
	 * @return the imEquipoSiNo
	 */
	public Integer getImEquipoSiNo() {
		return imEquipoSiNo;
	}

	/**
	 * @param imEquipoSiNo
	 *            the imEquipoSiNo to set
	 */
	public void setImEquipoSiNo(Integer imEquipoSiNo) {
		this.imEquipoSiNo = imEquipoSiNo;
	}

	/**
	 * @return the imImportacion1
	 */
	public Integer getImImportacion1() {
		return imImportacion1;
	}

	/**
	 * @param imImportacion1
	 *            the imImportacion1 to set
	 */
	public void setImImportacion1(Integer imImportacion1) {
		this.imImportacion1 = imImportacion1;
	}

	/**
	 * @return the imSolicitante
	 */
	public String getImSolicitante() {
		return imSolicitante;
	}

	/**
	 * @param imSolicitante
	 *            the imSolicitante to set
	 */
	public void setImSolicitante(String imSolicitante) {
		this.imSolicitante = imSolicitante;
	}

	/**
	 * @return the imNumReporte
	 */
	public String getImNumReporte() {
		return imNumReporte;
	}

	/**
	 * @param imNumReporte
	 *            the imNumReporte to set
	 */
	public void setImNumReporte(String imNumReporte) {
		this.imNumReporte = imNumReporte;
	}

	/**
	 * @return the imEmail
	 */
	public String getImEmail() {
		return imEmail;
	}

	/**
	 * @param imEmail
	 *            the imEmail to set
	 */
	public void setImEmail(String imEmail) {
		this.imEmail = imEmail;
	}

	/**
	 * @return the imModelo
	 */
	public String getImModelo() {
		return imModelo;
	}

	/**
	 * @param imModelo
	 *            the imModelo to set
	 */
	public void setImModelo(String imModelo) {
		this.imModelo = imModelo;
	}

	/**
	 * @return the imClaveAjustador
	 */
	public String getImClaveAjustador() {
		return imClaveAjustador;
	}

	/**
	 * @param imClaveAjustador
	 *            the imClaveAjustador to set
	 */
	public void setImClaveAjustador(String imClaveAjustador) {
		this.imClaveAjustador = imClaveAjustador;
	}

	/**
	 * @return the imUbicacion
	 */
	public String getImUbicacion() {
		return imUbicacion;
	}

	/**
	 * @param imUbicacion
	 *            the imUbicacion to set
	 */
	public void setImUbicacion(String imUbicacion) {
		this.imUbicacion = imUbicacion;
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
	 * @return the imKilometraje
	 */
	public String getImKilometraje() {
		return imKilometraje;
	}

	/**
	 * @param imKilometraje
	 *            the imKilometraje to set
	 */
	public void setImKilometraje(String imKilometraje) {
		this.imKilometraje = imKilometraje;
	}

	/**
	 * @return the imTelefono
	 */
	public String getImTelefono() {
		return imTelefono;
	}

	/**
	 * @param imTelefono
	 *            the imTelefono to set
	 */
	public void setImTelefono(String imTelefono) {
		this.imTelefono = imTelefono;
	}

	/**
	 * @return the imTipoEncargado
	 */
	public Integer getImTipoEncargado() {
		return imTipoEncargado;
	}

	/**
	 * @param imTipoEncargado
	 *            the imTipoEncargado to set
	 */
	public void setImTipoEncargado(Integer imTipoEncargado) {
		this.imTipoEncargado = imTipoEncargado;
	}

	/**
	 * @return the imFecha
	 */
	public Date getImFecha() {
		return imFecha;
	}

	/**
	 * @param imFecha
	 *            the imFecha to set
	 */
	public void setImFecha(Date imFecha) {
		this.imFecha = imFecha;
	}

	/**
	 * @return the imFechaInspeccion
	 */
	public Date getImFechaInspeccion() {
		return imFechaInspeccion;
	}

	/**
	 * @param imFechaInspeccion
	 *            the imFechaInspeccion to set
	 */
	public void setImFechaInspeccion(Date imFechaInspeccion) {
		this.imFechaInspeccion = imFechaInspeccion;
	}

	/**
	 * @return the imAdaptacionesSiNo
	 */
	public Integer getImAdaptacionesSiNo() {
		return imAdaptacionesSiNo;
	}

	/**
	 * @param imAdaptacionesSiNo
	 *            the imAdaptacionesSiNo to set
	 */
	public void setImAdaptacionesSiNo(Integer imAdaptacionesSiNo) {
		this.imAdaptacionesSiNo = imAdaptacionesSiNo;
	}

	/**
	 * @return the imOficina
	 */
	public String getImOficina() {
		return imOficina;
	}

	/**
	 * @param imOficina
	 *            the imOficina to set
	 */
	public void setImOficina(String imOficina) {
		this.imOficina = imOficina;
	}

	/**
	 * @return the imCirculacion
	 */
	public Integer getImCirculacion() {
		return imCirculacion;
	}

	/**
	 * @param imCirculacion
	 *            the imCirculacion to set
	 */
	public void setImCirculacion(Integer imCirculacion) {
		this.imCirculacion = imCirculacion;
	}

	/**
	 * @return the imColor
	 */
	public String getImColor() {
		return imColor;
	}

	/**
	 * @param imColor
	 *            the imColor to set
	 */
	public void setImColor(String imColor) {
		this.imColor = imColor;
	}

	/**
	 * @return the imProcedencia
	 */
	public Integer getImProcedencia() {
		return imProcedencia;
	}

	/**
	 * @param imProcedencia
	 *            the imProcedencia to set
	 */
	public void setImProcedencia(Integer imProcedencia) {
		this.imProcedencia = imProcedencia;
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
	 * @return the imPagoSiNo
	 */
	public Integer getImPagoSiNo() {
		return imPagoSiNo;
	}

	/**
	 * @param imPagoSiNo
	 *            the imPagoSiNo to set
	 */
	public void setImPagoSiNo(Integer imPagoSiNo) {
		this.imPagoSiNo = imPagoSiNo;
	}

	/**
	 * @return the imDocumentacion2
	 */
	public Integer getImDocumentacion2() {
		return imDocumentacion2;
	}

	/**
	 * @param imDocumentacion2
	 *            the imDocumentacion2 to set
	 */
	public void setImDocumentacion2(Integer imDocumentacion2) {
		this.imDocumentacion2 = imDocumentacion2;
	}

	/**
	 * @return the imDocumentacion1
	 */
	public Integer getImDocumentacion1() {
		return imDocumentacion1;
	}

	/**
	 * @param imDocumentacion1
	 *            the imDocumentacion1 to set
	 */
	public void setImDocumentacion1(Integer imDocumentacion1) {
		this.imDocumentacion1 = imDocumentacion1;
	}

	/**
	 * @return the imNumInciso
	 */
	public String getImNumInciso() {
		return imNumInciso;
	}

	/**
	 * @param imNumInciso
	 *            the imNumInciso to set
	 */
	public void setImNumInciso(String imNumInciso) {
		this.imNumInciso = imNumInciso;
	}

	/**
	 * @return the imNumPoliza
	 */
	public String getImNumPoliza() {
		return imNumPoliza;
	}

	/**
	 * @param imNumPoliza
	 *            the imNumPoliza to set
	 */
	public void setImNumPoliza(String imNumPoliza) {
		this.imNumPoliza = imNumPoliza;
	}

	/**
	 * @return the imTotalFotos
	 */
	public String getImTotalFotos() {
		return imTotalFotos;
	}

	/**
	 * @param imTotalFotos
	 *            the imTotalFotos to set
	 */
	public void setImTotalFotos(String imTotalFotos) {
		this.imTotalFotos = imTotalFotos;
	}

	/**
	 * @return the imDiaHora
	 */
	public Date getImDiaHora() {
		return imDiaHora;
	}

	/**
	 * @param imDiaHora
	 *            the imDiaHora to set
	 */
	public void setImDiaHora(Date imDiaHora) {
		this.imDiaHora = imDiaHora;
	}

	/**
	 * @return the imObservaciones
	 */
	public String getImObservaciones() {
		return imObservaciones;
	}

	/**
	 * @param imObservaciones
	 *            the imObservaciones to set
	 */
	public void setImObservaciones(String imObservaciones) {
		this.imObservaciones = imObservaciones;
	}

	/**
	 * @return the imAtencion
	 */
	public String getImAtencion() {
		return imAtencion;
	}

	/**
	 * @param imAtencion
	 *            the imAtencion to set
	 */
	public void setImAtencion(String imAtencion) {
		this.imAtencion = imAtencion;
	}

	/**
	 * @return the imNomCliente
	 */
	public String getImNomCliente() {
		return imNomCliente;
	}

	/**
	 * @param imNomCliente
	 *            the imNomCliente to set
	 */
	public void setImNomCliente(String imNomCliente) {
		this.imNomCliente = imNomCliente;
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
	 * @return the firmaCliente
	 */
	public String getFirmaCliente() {
		return firmaCliente;
	}

	/**
	 * @param firmaCliente
	 *            the firmaCliente to set
	 */
	public void setFirmaCliente(String firmaCliente) {
		this.firmaCliente = firmaCliente;
	}

	/**
	 * @return the firmaAgente
	 */
	public String getFirmaAgente() {
		return firmaAgente;
	}

	/**
	 * @param firmaAgente
	 *            the firmaAgente to set
	 */
	public void setFirmaAgente(String firmaAgente) {
		this.firmaAgente = firmaAgente;
	}

}
