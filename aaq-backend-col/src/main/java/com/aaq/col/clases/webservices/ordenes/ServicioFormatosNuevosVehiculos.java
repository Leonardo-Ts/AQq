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
public class ServicioFormatosNuevosVehiculos {

	private String usuario;
	private String passwd;
	private String nvFolio;
	private String nvPlacas;
	private ProveedorAdmi proveedor;
	private Integer nvId;
	private Integer idAjustador;
	private String nvAsegurado;
	private String nvClaveAjustador;
	private Integer nvDerivadaAuto;
	private String nvDaniosPre;
	private String nvEmail;
	private Date nvFecha;
	private Date nvFechaInspeccion;
	private Integer nvFotoMotor;
	private Integer nvFotoSerie;
	private Timestamp nvHora;
	private String nvKilometrosAuto;
	private String nvModeloAuto;
	private String nvMotorAuto;
	private String nvNombreAjustador;
	private String nvNombreCliente;
	private String nvNumInciso;
	private String nvNumPoliza;
	private String nvNumReporte;
	private String nvNumSerieAuto;
	private String nvObservacionesAuto;
	private String nvOficna;
	private Integer nvProcedenciaAuto;
	private String nvPuertasAuto;
	private String nvSolicitante;
	private String nvTelSolicitante;
	private String nvTipoAuto;
	private Integer nvTipoEmpleado;
	private Integer nvTotalFotos;
	private String nvTransmisionAuto;
	private String nvUbicacion;
	private String nvUnidadAuto;
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

	public ServicioFormatosNuevosVehiculos() {
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
	 * @return the nvId
	 */
	public Integer getNvId() {
		return nvId;
	}

	/**
	 * @param nvId
	 *            the nvId to set
	 */
	public void setNvId(Integer nvId) {
		this.nvId = nvId;
	}

	/**
	 * @return the nvAsegurado
	 */
	public String getNvAsegurado() {
		return nvAsegurado;
	}

	/**
	 * @param nvAsegurado
	 *            the nvAsegurado to set
	 */
	public void setNvAsegurado(String nvAsegurado) {
		this.nvAsegurado = nvAsegurado;
	}

	/**
	 * @return the nvClaveAjustador
	 */
	public String getNvClaveAjustador() {
		return nvClaveAjustador;
	}

	/**
	 * @param nvClaveAjustador
	 *            the nvClaveAjustador to set
	 */
	public void setNvClaveAjustador(String nvClaveAjustador) {
		this.nvClaveAjustador = nvClaveAjustador;
	}

	/**
	 * @return the nvDerivadaAuto
	 */
	public Integer getNvDerivadaAuto() {
		return nvDerivadaAuto;
	}

	/**
	 * @param nvDerivadaAuto
	 *            the nvDerivadaAuto to set
	 */
	public void setNvDerivadaAuto(Integer nvDerivadaAuto) {
		this.nvDerivadaAuto = nvDerivadaAuto;
	}

	/**
	 * @return the nvEmail
	 */
	public String getNvEmail() {
		return nvEmail;
	}

	/**
	 * @param nvEmail
	 *            the nvEmail to set
	 */
	public void setNvEmail(String nvEmail) {
		this.nvEmail = nvEmail;
	}

	/**
	 * @return the nvFecha
	 */
	public Date getNvFecha() {
		return nvFecha;
	}

	/**
	 * @param nvFecha
	 *            the nvFecha to set
	 */
	public void setNvFecha(Date nvFecha) {
		this.nvFecha = nvFecha;
	}

	/**
	 * @return the nvFechaInspeccion
	 */
	public Date getNvFechaInspeccion() {
		return nvFechaInspeccion;
	}

	/**
	 * @param nvFechaInspeccion
	 *            the nvFechaInspeccion to set
	 */
	public void setNvFechaInspeccion(Date nvFechaInspeccion) {
		this.nvFechaInspeccion = nvFechaInspeccion;
	}

	/**
	 * @return the nvFotoMotor
	 */
	public Integer getNvFotoMotor() {
		return nvFotoMotor;
	}

	/**
	 * @param nvFotoMotor
	 *            the nvFotoMotor to set
	 */
	public void setNvFotoMotor(Integer nvFotoMotor) {
		this.nvFotoMotor = nvFotoMotor;
	}

	/**
	 * @return the nvFotoSerie
	 */
	public Integer getNvFotoSerie() {
		return nvFotoSerie;
	}

	/**
	 * @param nvFotoSerie
	 *            the nvFotoSerie to set
	 */
	public void setNvFotoSerie(Integer nvFotoSerie) {
		this.nvFotoSerie = nvFotoSerie;
	}

	/**
	 * @return the nvHora
	 */
	public Timestamp getNvHora() {
		return nvHora;
	}

	/**
	 * @param nvHora
	 *            the nvHora to set
	 */
	public void setNvHora(Timestamp nvHora) {
		this.nvHora = nvHora;
	}

	/**
	 * @return the nvKilometrosAuto
	 */
	public String getNvKilometrosAuto() {
		return nvKilometrosAuto;
	}

	/**
	 * @param nvKilometrosAuto
	 *            the nvKilometrosAuto to set
	 */
	public void setNvKilometrosAuto(String nvKilometrosAuto) {
		this.nvKilometrosAuto = nvKilometrosAuto;
	}

	/**
	 * @return the nvModeloAuto
	 */
	public String getNvModeloAuto() {
		return nvModeloAuto;
	}

	/**
	 * @param nvModeloAuto
	 *            the nvModeloAuto to set
	 */
	public void setNvModeloAuto(String nvModeloAuto) {
		this.nvModeloAuto = nvModeloAuto;
	}

	/**
	 * @return the nvMotorAuto
	 */
	public String getNvMotorAuto() {
		return nvMotorAuto;
	}

	/**
	 * @param nvMotorAuto
	 *            the nvMotorAuto to set
	 */
	public void setNvMotorAuto(String nvMotorAuto) {
		this.nvMotorAuto = nvMotorAuto;
	}

	/**
	 * @return the nvNombreAjustador
	 */
	public String getNvNombreAjustador() {
		return nvNombreAjustador;
	}

	/**
	 * @param nvNombreAjustador
	 *            the nvNombreAjustador to set
	 */
	public void setNvNombreAjustador(String nvNombreAjustador) {
		this.nvNombreAjustador = nvNombreAjustador;
	}

	/**
	 * @return the nvNombreCliente
	 */
	public String getNvNombreCliente() {
		return nvNombreCliente;
	}

	/**
	 * @param nvNombreCliente
	 *            the nvNombreCliente to set
	 */
	public void setNvNombreCliente(String nvNombreCliente) {
		this.nvNombreCliente = nvNombreCliente;
	}

	/**
	 * @return the nvNumInciso
	 */
	public String getNvNumInciso() {
		return nvNumInciso;
	}

	/**
	 * @param nvNumInciso
	 *            the nvNumInciso to set
	 */
	public void setNvNumInciso(String nvNumInciso) {
		this.nvNumInciso = nvNumInciso;
	}

	/**
	 * @return the nvNumPoliza
	 */
	public String getNvNumPoliza() {
		return nvNumPoliza;
	}

	/**
	 * @param nvNumPoliza
	 *            the nvNumPoliza to set
	 */
	public void setNvNumPoliza(String nvNumPoliza) {
		this.nvNumPoliza = nvNumPoliza;
	}

	/**
	 * @return the nvNumReporte
	 */
	public String getNvNumReporte() {
		return nvNumReporte;
	}

	/**
	 * @param nvNumReporte
	 *            the nvNumReporte to set
	 */
	public void setNvNumReporte(String nvNumReporte) {
		this.nvNumReporte = nvNumReporte;
	}

	/**
	 * @return the nvNumSerieAuto
	 */
	public String getNvNumSerieAuto() {
		return nvNumSerieAuto;
	}

	/**
	 * @param nvNumSerieAuto
	 *            the nvNumSerieAuto to set
	 */
	public void setNvNumSerieAuto(String nvNumSerieAuto) {
		this.nvNumSerieAuto = nvNumSerieAuto;
	}

	/**
	 * @return the nvObservacionesAuto
	 */
	public String getNvObservacionesAuto() {
		return nvObservacionesAuto;
	}

	/**
	 * @param nvObservacionesAuto
	 *            the nvObservacionesAuto to set
	 */
	public void setNvObservacionesAuto(String nvObservacionesAuto) {
		this.nvObservacionesAuto = nvObservacionesAuto;
	}

	/**
	 * @return the nvOficna
	 */
	public String getNvOficna() {
		return nvOficna;
	}

	/**
	 * @param nvOficna
	 *            the nvOficna to set
	 */
	public void setNvOficna(String nvOficna) {
		this.nvOficna = nvOficna;
	}

	/**
	 * @return the nvProcedenciaAuto
	 */
	public Integer getNvProcedenciaAuto() {
		return nvProcedenciaAuto;
	}

	/**
	 * @param nvProcedenciaAuto
	 *            the nvProcedenciaAuto to set
	 */
	public void setNvProcedenciaAuto(Integer nvProcedenciaAuto) {
		this.nvProcedenciaAuto = nvProcedenciaAuto;
	}

	/**
	 * @return the nvPuertasAuto
	 */
	public String getNvPuertasAuto() {
		return nvPuertasAuto;
	}

	/**
	 * @param nvPuertasAuto
	 *            the nvPuertasAuto to set
	 */
	public void setNvPuertasAuto(String nvPuertasAuto) {
		this.nvPuertasAuto = nvPuertasAuto;
	}

	/**
	 * @return the nvSolicitante
	 */
	public String getNvSolicitante() {
		return nvSolicitante;
	}

	/**
	 * @param nvSolicitante
	 *            the nvSolicitante to set
	 */
	public void setNvSolicitante(String nvSolicitante) {
		this.nvSolicitante = nvSolicitante;
	}

	/**
	 * @return the nvTelSolicitante
	 */
	public String getNvTelSolicitante() {
		return nvTelSolicitante;
	}

	/**
	 * @param nvTelSolicitante
	 *            the nvTelSolicitante to set
	 */
	public void setNvTelSolicitante(String nvTelSolicitante) {
		this.nvTelSolicitante = nvTelSolicitante;
	}

	/**
	 * @return the nvTipoAuto
	 */
	public String getNvTipoAuto() {
		return nvTipoAuto;
	}

	/**
	 * @param nvTipoAuto
	 *            the nvTipoAuto to set
	 */
	public void setNvTipoAuto(String nvTipoAuto) {
		this.nvTipoAuto = nvTipoAuto;
	}

	/**
	 * @return the nvTipoEmpleado
	 */
	public Integer getNvTipoEmpleado() {
		return nvTipoEmpleado;
	}

	/**
	 * @param nvTipoEmpleado
	 *            the nvTipoEmpleado to set
	 */
	public void setNvTipoEmpleado(Integer nvTipoEmpleado) {
		this.nvTipoEmpleado = nvTipoEmpleado;
	}

	/**
	 * @return the nvTotalFotos
	 */
	public Integer getNvTotalFotos() {
		return nvTotalFotos;
	}

	/**
	 * @param nvTotalFotos
	 *            the nvTotalFotos to set
	 */
	public void setNvTotalFotos(Integer nvTotalFotos) {
		this.nvTotalFotos = nvTotalFotos;
	}

	/**
	 * @return the nvTransmisionAuto
	 */
	public String getNvTransmisionAuto() {
		return nvTransmisionAuto;
	}

	/**
	 * @param nvTransmisionAuto
	 *            the nvTransmisionAuto to set
	 */
	public void setNvTransmisionAuto(String nvTransmisionAuto) {
		this.nvTransmisionAuto = nvTransmisionAuto;
	}

	/**
	 * @return the nvUbicacion
	 */
	public String getNvUbicacion() {
		return nvUbicacion;
	}

	/**
	 * @param nvUbicacion
	 *            the nvUbicacion to set
	 */
	public void setNvUbicacion(String nvUbicacion) {
		this.nvUbicacion = nvUbicacion;
	}

	/**
	 * @return the nvUnidadAuto
	 */
	public String getNvUnidadAuto() {
		return nvUnidadAuto;
	}

	/**
	 * @param nvUnidadAuto
	 *            the nvUnidadAuto to set
	 */
	public void setNvUnidadAuto(String nvUnidadAuto) {
		this.nvUnidadAuto = nvUnidadAuto;
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
	 * @return the nvFolio
	 */
	public String getNvFolio() {
		return nvFolio;
	}

	/**
	 * @param nvFolio
	 *            the nvFolio to set
	 */
	public void setNvFolio(String nvFolio) {
		this.nvFolio = nvFolio;
	}

	/**
	 * @return the nvPlacas
	 */
	public String getNvPlacas() {
		return nvPlacas;
	}

	/**
	 * @param nvPlacas
	 *            the nvPlacas to set
	 */
	public void setNvPlacas(String nvPlacas) {
		this.nvPlacas = nvPlacas;
	}

	/**
	 * @return the nvDaniosPre
	 */
	public String getNvDaniosPre() {
		return nvDaniosPre;
	}

	/**
	 * @param nvDaniosPre
	 *            the nvDaniosPre to set
	 */
	public void setNvDaniosPre(String nvDaniosPre) {
		this.nvDaniosPre = nvDaniosPre;
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
