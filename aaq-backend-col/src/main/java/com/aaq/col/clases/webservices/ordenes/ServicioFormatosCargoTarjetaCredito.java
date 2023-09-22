package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;
import java.util.Date;

public class ServicioFormatosCargoTarjetaCredito {

	private String usuario;
	private String passwd;
	
	
	private String tcNumReporte;
	private String tcNumSiniestro;
	private String tcNumAsegurado;
	private String tcNumAutorizacion;
	private String tcNombre;
	private Date tcFecha;
	private String tcDireccion;
	private String tcEstado;
	private String tcCp;
	private String tcTelefono;
	private String tcCantidadAutorizada;
	private Integer tcPagoOpcion;
	private String tcNumTarjeta;
	private String tcVencimientoTarjeta;
	private String tcClaveAjustador;
	

	private String firmaTarjetahabiente;
	
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
	private String tcNumPoliza;
	private String tcCorreo;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getTcNumReporte() {
		return tcNumReporte;
	}
	public void setTcNumReporte(String tcNumReporte) {
		this.tcNumReporte = tcNumReporte;
	}
	public String getTcNumSiniestro() {
		return tcNumSiniestro;
	}
	public void setTcNumSiniestro(String tcNumSiniestro) {
		this.tcNumSiniestro = tcNumSiniestro;
	}
	public String getTcNumAsegurado() {
		return tcNumAsegurado;
	}
	public void setTcNumAsegurado(String tcNumAsegurado) {
		this.tcNumAsegurado = tcNumAsegurado;
	}
	public String getTcNumAutorizacion() {
		return tcNumAutorizacion;
	}
	public void setTcNumAutorizacion(String tcNumAutorizacion) {
		this.tcNumAutorizacion = tcNumAutorizacion;
	}
	public String getTcNombre() {
		return tcNombre;
	}
	public void setTcNombre(String tcNombre) {
		this.tcNombre = tcNombre;
	}
	public Date getTcFecha() {
		return tcFecha;
	}
	public void setTcFecha(Date tcFecha) {
		this.tcFecha = tcFecha;
	}
	public String getTcDireccion() {
		return tcDireccion;
	}
	public void setTcDireccion(String tcDireccion) {
		this.tcDireccion = tcDireccion;
	}
	public String getTcEstado() {
		return tcEstado;
	}
	public void setTcEstado(String tcEstado) {
		this.tcEstado = tcEstado;
	}
	public String getTcCp() {
		return tcCp;
	}
	public void setTcCp(String tcCp) {
		this.tcCp = tcCp;
	}
	public String getTcTelefono() {
		return tcTelefono;
	}
	public void setTcTelefono(String tcTelefono) {
		this.tcTelefono = tcTelefono;
	}
	public String getTcCantidadAutorizada() {
		return tcCantidadAutorizada;
	}
	public void setTcCantidadAutorizada(String tcCantidadAutorizada) {
		this.tcCantidadAutorizada = tcCantidadAutorizada;
	}
	public Integer getTcPagoOpcion() {
		return tcPagoOpcion;
	}
	public void setTcPagoOpcion(Integer tcPagoOpcion) {
		this.tcPagoOpcion = tcPagoOpcion;
	}
	public String getTcNumTarjeta() {
		return tcNumTarjeta;
	}
	public void setTcNumTarjeta(String tcNumTarjeta) {
		this.tcNumTarjeta = tcNumTarjeta;
	}
	
	public String getTcVencimientoTarjeta() {
		return tcVencimientoTarjeta;
	}
	public void setTcVencimientoTarjeta(String tcVencimientoTarjeta) {
		this.tcVencimientoTarjeta = tcVencimientoTarjeta;
	}
	public String getTcClaveAjustador() {
		return tcClaveAjustador;
	}
	public void setTcClaveAjustador(String tcClaveAjustador) {
		this.tcClaveAjustador = tcClaveAjustador;
	}
	public String getFirmaTarjetahabiente() {
		return firmaTarjetahabiente;
	}
	public void setFirmaTarjetahabiente(String firmaTarjetahabiente) {
		this.firmaTarjetahabiente = firmaTarjetahabiente;
	}
	public Integer getEnviadoEmail() {
		return enviadoEmail;
	}
	public void setEnviadoEmail(Integer enviadoEmail) {
		this.enviadoEmail = enviadoEmail;
	}
	public String getMensajeEmail() {
		return mensajeEmail;
	}
	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
	}
	public Integer getProceso() {
		return proceso;
	}
	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}
	public Timestamp getHoraEnvioEmail() {
		return horaEnvioEmail;
	}
	public void setHoraEnvioEmail(Timestamp horaEnvioEmail) {
		this.horaEnvioEmail = horaEnvioEmail;
	}
	public Timestamp getHoraEnvioSftp() {
		return horaEnvioSftp;
	}
	public void setHoraEnvioSftp(Timestamp horaEnvioSftp) {
		this.horaEnvioSftp = horaEnvioSftp;
	}
	public String getNodoEnvio() {
		return nodoEnvio;
	}
	public void setNodoEnvio(String nodoEnvio) {
		this.nodoEnvio = nodoEnvio;
	}
	public Integer getCheck1() {
		return check1;
	}
	public void setCheck1(Integer check1) {
		this.check1 = check1;
	}
	public Integer getCheck2() {
		return check2;
	}
	public void setCheck2(Integer check2) {
		this.check2 = check2;
	}
	public Integer getCheck3() {
		return check3;
	}
	public void setCheck3(Integer check3) {
		this.check3 = check3;
	}
	public Integer getCheck4() {
		return check4;
	}
	public void setCheck4(Integer check4) {
		this.check4 = check4;
	}
	public String getTcNumPoliza() {
		return tcNumPoliza;
	}
	public void setTcNumPoliza(String tcNumPoliza) {
		this.tcNumPoliza = tcNumPoliza;
	}
	public String getTcCorreo() {
		return tcCorreo;
	}
	public void setTcCorreo(String tcCorreo) {
		this.tcCorreo = tcCorreo;
	}
	

}
