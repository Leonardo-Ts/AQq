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
public class ServicioFormatosInspeccionPesado {

	private String usuario;
	private String passwd;
	private String ipAsegurado;
	private Date ipFecha;
	private Integer ipEquipo;
	private String ipTipo;

	private Integer ipPagoSiNo;
	private String ipUbicacion;
	private Date ipDiaHora;
	private Integer ipAdaptaciones;
	private String ipAtencion;
	private String ipColor;

	private String ipNomAjustador;
	private Integer ipImportacion1;

	private Integer ipImportacion2;
	private Integer ipPago;
	private String ipModelo;
	private String ipNumPoliza;
	private Integer ipTipoEncargado;
	private String ipEstandarT;
	private Integer ipEquipoSiNo;
	private String ipEmail;

	private String ipOficina;
	private String ipNomCliente;
	private Integer ipCalificacion;
	private String ipKilometraje;
	private Integer ipAdaptacionesSiNo;
	private Integer ipCirculacion;
	private Integer ipTCirculacion1;
	private Integer ipTCirculacion2;
	private String ipFolio;
	private String ipTotalFotos;
	private Integer ipDocumentacion1;
	private Integer ipDocumentacion2;

	private Integer ipProcedencia;
	private String ipTelefono;
	private String ipPuertasD;
	private Date ipFechaInspeccion;
	private Integer ipAseguradoCompa;
	private String ipClaveAjustador;
	private String ipPlacas;
	private String ipCompania;
	private String ipSolicitante;
	private String ipNumSerie;
	private String ipObservaciones;
	private Integer ipSalvamentos;
	private String ipNumReporte;
	private String ipNumInciso;
	private String ipNumSiniestro;
	private String ipMarca;
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

	public ServicioFormatosInspeccionPesado() {
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
	 * @return the ipNumReporte
	 */
	public String getIpNumReporte() {
		return ipNumReporte;
	}

	/**
	 * @param ipNumReporte
	 *            the ipNumReporte to set
	 */
	public void setIpNumReporte(String ipNumReporte) {
		this.ipNumReporte = ipNumReporte;
	}

	/**
	 * @return the ipMarca
	 */
	public String getIpMarca() {
		return ipMarca;
	}

	/**
	 * @param ipMarca
	 *            the ipMarca to set
	 */
	public void setIpMarca(String ipMarca) {
		this.ipMarca = ipMarca;
	}

	/**
	 * @return the ipNumInciso
	 */
	public String getIpNumInciso() {
		return ipNumInciso;
	}

	/**
	 * @param ipNumInciso
	 *            the ipNumInciso to set
	 */
	public void setIpNumInciso(String ipNumInciso) {
		this.ipNumInciso = ipNumInciso;
	}

	/**
	 * @return the ipNumSiniestro
	 */
	public String getIpNumSiniestro() {
		return ipNumSiniestro;
	}

	/**
	 * @param ipNumSiniestro
	 *            the ipNumSiniestro to set
	 */
	public void setIpNumSiniestro(String ipNumSiniestro) {
		this.ipNumSiniestro = ipNumSiniestro;
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
	 * @return the ipAsegurado
	 */
	public String getIpAsegurado() {
		return ipAsegurado;
	}

	/**
	 * @param ipAsegurado
	 *            the ipAsegurado to set
	 */
	public void setIpAsegurado(String ipAsegurado) {
		this.ipAsegurado = ipAsegurado;
	}

	/**
	 * @return the ipFecha
	 */
	public Date getIpFecha() {
		return ipFecha;
	}

	/**
	 * @param ipFecha
	 *            the ipFecha to set
	 */
	public void setIpFecha(Date ipFecha) {
		this.ipFecha = ipFecha;
	}

	/**
	 * @return the ipEquipo
	 */
	public Integer getIpEquipo() {
		return ipEquipo;
	}

	/**
	 * @param ipEquipo
	 *            the ipEquipo to set
	 */
	public void setIpEquipo(Integer ipEquipo) {
		this.ipEquipo = ipEquipo;
	}

	/**
	 * @return the ipTipo
	 */
	public String getIpTipo() {
		return ipTipo;
	}

	/**
	 * @param ipTipo
	 *            the ipTipo to set
	 */
	public void setIpTipo(String ipTipo) {
		this.ipTipo = ipTipo;
	}

	/**
	 * @return the ipPagoSiNo
	 */
	public Integer getIpPagoSiNo() {
		return ipPagoSiNo;
	}

	/**
	 * @param ipPagoSiNo
	 *            the ipPagoSiNo to set
	 */
	public void setIpPagoSiNo(Integer ipPagoSiNo) {
		this.ipPagoSiNo = ipPagoSiNo;
	}

	/**
	 * @return the ipUbicacion
	 */
	public String getIpUbicacion() {
		return ipUbicacion;
	}

	/**
	 * @param ipUbicacion
	 *            the ipUbicacion to set
	 */
	public void setIpUbicacion(String ipUbicacion) {
		this.ipUbicacion = ipUbicacion;
	}

	/**
	 * @return the ipDiaHora
	 */
	public Date getIpDiaHora() {
		return ipDiaHora;
	}

	/**
	 * @param ipDiaHora
	 *            the ipDiaHora to set
	 */
	public void setIpDiaHora(Date ipDiaHora) {
		this.ipDiaHora = ipDiaHora;
	}

	/**
	 * @return the ipAdaptaciones
	 */
	public Integer getIpAdaptaciones() {
		return ipAdaptaciones;
	}

	/**
	 * @param ipAdaptaciones
	 *            the ipAdaptaciones to set
	 */
	public void setIpAdaptaciones(Integer ipAdaptaciones) {
		this.ipAdaptaciones = ipAdaptaciones;
	}

	/**
	 * @return the ipAtencion
	 */
	public String getIpAtencion() {
		return ipAtencion;
	}

	/**
	 * @param ipAtencion
	 *            the ipAtencion to set
	 */
	public void setIpAtencion(String ipAtencion) {
		this.ipAtencion = ipAtencion;
	}

	/**
	 * @return the ipColor
	 */
	public String getIpColor() {
		return ipColor;
	}

	/**
	 * @param ipColor
	 *            the ipColor to set
	 */
	public void setIpColor(String ipColor) {
		this.ipColor = ipColor;
	}

	/**
	 * @return the ipNomAjustador
	 */
	public String getIpNomAjustador() {
		return ipNomAjustador;
	}

	/**
	 * @param ipNomAjustador
	 *            the ipNomAjustador to set
	 */
	public void setIpNomAjustador(String ipNomAjustador) {
		this.ipNomAjustador = ipNomAjustador;
	}

	/**
	 * @return the ipImportacion1
	 */
	public Integer getIpImportacion1() {
		return ipImportacion1;
	}

	/**
	 * @param ipImportacion1
	 *            the ipImportacion1 to set
	 */
	public void setIpImportacion1(Integer ipImportacion1) {
		this.ipImportacion1 = ipImportacion1;
	}

	/**
	 * @return the ipImportacion2
	 */
	public Integer getIpImportacion2() {
		return ipImportacion2;
	}

	/**
	 * @param ipImportacion2
	 *            the ipImportacion2 to set
	 */
	public void setIpImportacion2(Integer ipImportacion2) {
		this.ipImportacion2 = ipImportacion2;
	}

	/**
	 * @return the ipPago
	 */
	public Integer getIpPago() {
		return ipPago;
	}

	/**
	 * @param ipPago
	 *            the ipPago to set
	 */
	public void setIpPago(Integer ipPago) {
		this.ipPago = ipPago;
	}

	/**
	 * @return the ipModelo
	 */
	public String getIpModelo() {
		return ipModelo;
	}

	/**
	 * @param ipModelo
	 *            the ipModelo to set
	 */
	public void setIpModelo(String ipModelo) {
		this.ipModelo = ipModelo;
	}

	/**
	 * @return the ipNumPoliza
	 */
	public String getIpNumPoliza() {
		return ipNumPoliza;
	}

	/**
	 * @param ipNumPoliza
	 *            the ipNumPoliza to set
	 */
	public void setIpNumPoliza(String ipNumPoliza) {
		this.ipNumPoliza = ipNumPoliza;
	}

	/**
	 * @return the ipTipoEncargado
	 */
	public Integer getIpTipoEncargado() {
		return ipTipoEncargado;
	}

	/**
	 * @param ipTipoEncargado
	 *            the ipTipoEncargado to set
	 */
	public void setIpTipoEncargado(Integer ipTipoEncargado) {
		this.ipTipoEncargado = ipTipoEncargado;
	}

	/**
	 * @return the ipEstandarT
	 */
	public String getIpEstandarT() {
		return ipEstandarT;
	}

	/**
	 * @param ipEstandarT
	 *            the ipEstandarT to set
	 */
	public void setIpEstandarT(String ipEstandarT) {
		this.ipEstandarT = ipEstandarT;
	}

	/**
	 * @return the ipEquipoSiNo
	 */
	public Integer getIpEquipoSiNo() {
		return ipEquipoSiNo;
	}

	/**
	 * @param ipEquipoSiNo
	 *            the ipEquipoSiNo to set
	 */
	public void setIpEquipoSiNo(Integer ipEquipoSiNo) {
		this.ipEquipoSiNo = ipEquipoSiNo;
	}

	/**
	 * @return the ipEmail
	 */
	public String getIpEmail() {
		return ipEmail;
	}

	/**
	 * @param ipEmail
	 *            the ipEmail to set
	 */
	public void setIpEmail(String ipEmail) {
		this.ipEmail = ipEmail;
	}

	/**
	 * @return the ipOficina
	 */
	public String getIpOficina() {
		return ipOficina;
	}

	/**
	 * @param ipOficina
	 *            the ipOficina to set
	 */
	public void setIpOficina(String ipOficina) {
		this.ipOficina = ipOficina;
	}

	/**
	 * @return the ipNomCliente
	 */
	public String getIpNomCliente() {
		return ipNomCliente;
	}

	/**
	 * @param ipNomCliente
	 *            the ipNomCliente to set
	 */
	public void setIpNomCliente(String ipNomCliente) {
		this.ipNomCliente = ipNomCliente;
	}

	/**
	 * @return the ipCalificacion
	 */
	public Integer getIpCalificacion() {
		return ipCalificacion;
	}

	/**
	 * @param ipCalificacion
	 *            the ipCalificacion to set
	 */
	public void setIpCalificacion(Integer ipCalificacion) {
		this.ipCalificacion = ipCalificacion;
	}

	/**
	 * @return the ipKilometraje
	 */
	public String getIpKilometraje() {
		return ipKilometraje;
	}

	/**
	 * @param ipKilometraje
	 *            the ipKilometraje to set
	 */
	public void setIpKilometraje(String ipKilometraje) {
		this.ipKilometraje = ipKilometraje;
	}

	/**
	 * @return the ipAdaptacionesSiNo
	 */
	public Integer getIpAdaptacionesSiNo() {
		return ipAdaptacionesSiNo;
	}

	/**
	 * @param ipAdaptacionesSiNo
	 *            the ipAdaptacionesSiNo to set
	 */
	public void setIpAdaptacionesSiNo(Integer ipAdaptacionesSiNo) {
		this.ipAdaptacionesSiNo = ipAdaptacionesSiNo;
	}

	/**
	 * @return the ipCirculacion
	 */
	public Integer getIpCirculacion() {
		return ipCirculacion;
	}

	/**
	 * @param ipCirculacion
	 *            the ipCirculacion to set
	 */
	public void setIpCirculacion(Integer ipCirculacion) {
		this.ipCirculacion = ipCirculacion;
	}

	/**
	 * @return the ipTCirculacion1
	 */
	public Integer getIpTCirculacion1() {
		return ipTCirculacion1;
	}

	/**
	 * @param ipTCirculacion1
	 *            the ipTCirculacion1 to set
	 */
	public void setIpTCirculacion1(Integer ipTCirculacion1) {
		this.ipTCirculacion1 = ipTCirculacion1;
	}

	/**
	 * @return the ipTCirculacion2
	 */
	public Integer getIpTCirculacion2() {
		return ipTCirculacion2;
	}

	/**
	 * @param ipTCirculacion2
	 *            the ipTCirculacion2 to set
	 */
	public void setIpTCirculacion2(Integer ipTCirculacion2) {
		this.ipTCirculacion2 = ipTCirculacion2;
	}

	/**
	 * @return the ipFolio
	 */
	public String getIpFolio() {
		return ipFolio;
	}

	/**
	 * @param ipFolio
	 *            the ipFolio to set
	 */
	public void setIpFolio(String ipFolio) {
		this.ipFolio = ipFolio;
	}

	/**
	 * @return the ipTotalFotos
	 */
	public String getIpTotalFotos() {
		return ipTotalFotos;
	}

	/**
	 * @param ipTotalFotos
	 *            the ipTotalFotos to set
	 */
	public void setIpTotalFotos(String ipTotalFotos) {
		this.ipTotalFotos = ipTotalFotos;
	}

	/**
	 * @return the ipDocumentacion1
	 */
	public Integer getIpDocumentacion1() {
		return ipDocumentacion1;
	}

	/**
	 * @param ipDocumentacion1
	 *            the ipDocumentacion1 to set
	 */
	public void setIpDocumentacion1(Integer ipDocumentacion1) {
		this.ipDocumentacion1 = ipDocumentacion1;
	}

	/**
	 * @return the ipDocumentacion2
	 */
	public Integer getIpDocumentacion2() {
		return ipDocumentacion2;
	}

	/**
	 * @param ipDocumentacion2
	 *            the ipDocumentacion2 to set
	 */
	public void setIpDocumentacion2(Integer ipDocumentacion2) {
		this.ipDocumentacion2 = ipDocumentacion2;
	}

	/**
	 * @return the ipProcedencia
	 */
	public Integer getIpProcedencia() {
		return ipProcedencia;
	}

	/**
	 * @param ipProcedencia
	 *            the ipProcedencia to set
	 */
	public void setIpProcedencia(Integer ipProcedencia) {
		this.ipProcedencia = ipProcedencia;
	}

	/**
	 * @return the ipTelefono
	 */
	public String getIpTelefono() {
		return ipTelefono;
	}

	/**
	 * @param ipTelefono
	 *            the ipTelefono to set
	 */
	public void setIpTelefono(String ipTelefono) {
		this.ipTelefono = ipTelefono;
	}

	/**
	 * @return the ipPuertasD
	 */
	public String getIpPuertasD() {
		return ipPuertasD;
	}

	/**
	 * @param ipPuertasD
	 *            the ipPuertasD to set
	 */
	public void setIpPuertasD(String ipPuertasD) {
		this.ipPuertasD = ipPuertasD;
	}

	/**
	 * @return the ipFechaInspeccion
	 */
	public Date getIpFechaInspeccion() {
		return ipFechaInspeccion;
	}

	/**
	 * @param ipFechaInspeccion
	 *            the ipFechaInspeccion to set
	 */
	public void setIpFechaInspeccion(Date ipFechaInspeccion) {
		this.ipFechaInspeccion = ipFechaInspeccion;
	}

	/**
	 * @return the ipAseguradoCompa
	 */
	public Integer getIpAseguradoCompa() {
		return ipAseguradoCompa;
	}

	/**
	 * @param ipAseguradoCompa
	 *            the ipAseguradoCompa to set
	 */
	public void setIpAseguradoCompa(Integer ipAseguradoCompa) {
		this.ipAseguradoCompa = ipAseguradoCompa;
	}

	/**
	 * @return the ipClaveAjustador
	 */
	public String getIpClaveAjustador() {
		return ipClaveAjustador;
	}

	/**
	 * @param ipClaveAjustador
	 *            the ipClaveAjustador to set
	 */
	public void setIpClaveAjustador(String ipClaveAjustador) {
		this.ipClaveAjustador = ipClaveAjustador;
	}

	/**
	 * @return the ipPlacas
	 */
	public String getIpPlacas() {
		return ipPlacas;
	}

	/**
	 * @param ipPlacas
	 *            the ipPlacas to set
	 */
	public void setIpPlacas(String ipPlacas) {
		this.ipPlacas = ipPlacas;
	}

	/**
	 * @return the ipCompania
	 */
	public String getIpCompania() {
		return ipCompania;
	}

	/**
	 * @param ipCompania
	 *            the ipCompania to set
	 */
	public void setIpCompania(String ipCompania) {
		this.ipCompania = ipCompania;
	}

	/**
	 * @return the ipSolicitante
	 */
	public String getIpSolicitante() {
		return ipSolicitante;
	}

	/**
	 * @param ipSolicitante
	 *            the ipSolicitante to set
	 */
	public void setIpSolicitante(String ipSolicitante) {
		this.ipSolicitante = ipSolicitante;
	}

	/**
	 * @return the ipNumSerie
	 */
	public String getIpNumSerie() {
		return ipNumSerie;
	}

	/**
	 * @param ipNumSerie
	 *            the ipNumSerie to set
	 */
	public void setIpNumSerie(String ipNumSerie) {
		this.ipNumSerie = ipNumSerie;
	}

	/**
	 * @return the ipObservaciones
	 */
	public String getIpObservaciones() {
		return ipObservaciones;
	}

	/**
	 * @param ipObservaciones
	 *            the ipObservaciones to set
	 */
	public void setIpObservaciones(String ipObservaciones) {
		this.ipObservaciones = ipObservaciones;
	}

	/**
	 * @return the ipSalvamentos
	 */
	public Integer getIpSalvamentos() {
		return ipSalvamentos;
	}

	/**
	 * @param ipSalvamentos
	 *            the ipSalvamentos to set
	 */
	public void setIpSalvamentos(Integer ipSalvamentos) {
		this.ipSalvamentos = ipSalvamentos;
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
