package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;

public class ServicioFormatosAdmisionPesado {

	private String usuario;
	private String passwd;
	private String opTelAsegurado;
	private String opSiniestroCaja;
	private String opNumEndoso;
	private String opPlacasAutoAfe;
	private String opNomAjustador;
	private String opSerieAutoAfe;
	private String opColorAutoAfe;
	private String opNomTaller;
	private String opModeloTer;
	private Timestamp ofFecha;
	private String opMotorAutoAse;
	private String opMarcaAutoAfe;
	private String opPlacasAutoAse;
	private String opDaniosTanque;
	private String opDirTaller;
	private String opConductorAfe;
	private String opCantidad;
	private String opNumReporte;

	private String opSiniestroTanque;
	private String opTelTaller;
	private String opFolioElectro;
	private String opColorAutoAse;
	private String opAsegurado;
	private String opClaveAjustador;
	private String opMarcaAutoAse;
	private String opDedDias;
	private String opAtencionTaller;
	private String opDefinicion;
	private String opDaniosCamion;
	private String opSumaAsegurado;
	private String opSerieAutoAse;
	private String opTipoAutoAse;
	private String opModeloAse;
	private String opNumSiniestro;
	private Timestamp opVigencia;
	private String opNumPoliza;
	private String opDaniosCaja;
	private String opTelConAfe;
	private Integer opTipoDeducible;
	private String opFolio;
	private String opNumInciso;
	private Integer opDeducible;
	private String opTipoAutoAfe;
	private Integer opDedAdmin;
	private String opSiniestroCamion;

	private String opNomAsegurado;
	private Integer opId;
	private String opConductorAse;
	private String opNomAfe;
	private String opTelConAse;
	private String opTelAfe;

	private String opMotorAutoAfe;
	private ProveedorAdmi proveedor;
	private String emailDefault;
	private Integer enviadoEmail;
	private String mensajeEmail;
	private String opEmailTercero;

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
	private String niu;
	private String oa_codigo_qr;
	private Integer op_pt_evidente;
	private Integer op_abandono;

	/**
	 * @return the proceso
	 */
	public Integer getProceso() {
		return proceso;
	}

	public Integer getOp_pt_evidente() {
		return op_pt_evidente;
	}

	public void setOp_pt_evidente(Integer op_pt_evidente) {
		this.op_pt_evidente = op_pt_evidente;
	}

	public Integer getOp_abandono() {
		return op_abandono;
	}

	public void setOp_abandono(Integer op_abandono) {
		this.op_abandono = op_abandono;
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
	 * @return the opTelAsegurado
	 */
	public String getOpTelAsegurado() {
		return opTelAsegurado;
	}

	/**
	 * @param opTelAsegurado
	 *            the opTelAsegurado to set
	 */
	public void setOpTelAsegurado(String opTelAsegurado) {
		this.opTelAsegurado = opTelAsegurado;
	}

	/**
	 * @return the opSiniestroCaja
	 */
	public String getOpSiniestroCaja() {
		return opSiniestroCaja;
	}

	/**
	 * @param opSiniestroCaja
	 *            the opSiniestroCaja to set
	 */
	public void setOpSiniestroCaja(String opSiniestroCaja) {
		this.opSiniestroCaja = opSiniestroCaja;
	}

	/**
	 * @return the opNumEndoso
	 */
	public String getOpNumEndoso() {
		return opNumEndoso;
	}

	/**
	 * @param opNumEndoso
	 *            the opNumEndoso to set
	 */
	public void setOpNumEndoso(String opNumEndoso) {
		this.opNumEndoso = opNumEndoso;
	}

	/**
	 * @return the opPlacasAutoAfe
	 */
	public String getOpPlacasAutoAfe() {
		return opPlacasAutoAfe;
	}

	/**
	 * @param opPlacasAutoAfe
	 *            the opPlacasAutoAfe to set
	 */
	public void setOpPlacasAutoAfe(String opPlacasAutoAfe) {
		this.opPlacasAutoAfe = opPlacasAutoAfe;
	}

	/**
	 * @return the opNomAjustador
	 */
	public String getOpNomAjustador() {
		return opNomAjustador;
	}

	/**
	 * @param opNomAjustador
	 *            the opNomAjustador to set
	 */
	public void setOpNomAjustador(String opNomAjustador) {
		this.opNomAjustador = opNomAjustador;
	}

	/**
	 * @return the opSerieAutoAfe
	 */
	public String getOpSerieAutoAfe() {
		return opSerieAutoAfe;
	}

	/**
	 * @param opSerieAutoAfe
	 *            the opSerieAutoAfe to set
	 */
	public void setOpSerieAutoAfe(String opSerieAutoAfe) {
		this.opSerieAutoAfe = opSerieAutoAfe;
	}

	/**
	 * @return the opColorAutoAfe
	 */
	public String getOpColorAutoAfe() {
		return opColorAutoAfe;
	}

	/**
	 * @param opColorAutoAfe
	 *            the opColorAutoAfe to set
	 */
	public void setOpColorAutoAfe(String opColorAutoAfe) {
		this.opColorAutoAfe = opColorAutoAfe;
	}

	/**
	 * @return the opNomTaller
	 */
	public String getOpNomTaller() {
		return opNomTaller;
	}

	/**
	 * @param opNomTaller
	 *            the opNomTaller to set
	 */
	public void setOpNomTaller(String opNomTaller) {
		this.opNomTaller = opNomTaller;
	}

	/**
	 * @return the opModeloTer
	 */
	public String getOpModeloTer() {
		return opModeloTer;
	}

	/**
	 * @param opModeloTer
	 *            the opModeloTer to set
	 */
	public void setOpModeloTer(String opModeloTer) {
		this.opModeloTer = opModeloTer;
	}

	/**
	 * @return the ofFecha
	 */
	public Timestamp getOfFecha() {
		return ofFecha;
	}

	/**
	 * @param ofFecha
	 *            the ofFecha to set
	 */
	public void setOfFecha(Timestamp ofFecha) {
		this.ofFecha = ofFecha;
	}

	/**
	 * @return the opMotorAutoAse
	 */
	public String getOpMotorAutoAse() {
		return opMotorAutoAse;
	}

	/**
	 * @param opMotorAutoAse
	 *            the opMotorAutoAse to set
	 */
	public void setOpMotorAutoAse(String opMotorAutoAse) {
		this.opMotorAutoAse = opMotorAutoAse;
	}

	/**
	 * @return the opMarcaAutoAfe
	 */
	public String getOpMarcaAutoAfe() {
		return opMarcaAutoAfe;
	}

	/**
	 * @param opMarcaAutoAfe
	 *            the opMarcaAutoAfe to set
	 */
	public void setOpMarcaAutoAfe(String opMarcaAutoAfe) {
		this.opMarcaAutoAfe = opMarcaAutoAfe;
	}

	/**
	 * @return the opPlacasAutoAse
	 */
	public String getOpPlacasAutoAse() {
		return opPlacasAutoAse;
	}

	/**
	 * @param opPlacasAutoAse
	 *            the opPlacasAutoAse to set
	 */
	public void setOpPlacasAutoAse(String opPlacasAutoAse) {
		this.opPlacasAutoAse = opPlacasAutoAse;
	}

	/**
	 * @return the opDaniosTanque
	 */
	public String getOpDaniosTanque() {
		return opDaniosTanque;
	}

	/**
	 * @param opDaniosTanque
	 *            the opDaniosTanque to set
	 */
	public void setOpDaniosTanque(String opDaniosTanque) {
		this.opDaniosTanque = opDaniosTanque;
	}

	/**
	 * @return the opDirTaller
	 */
	public String getOpDirTaller() {
		return opDirTaller;
	}

	/**
	 * @param opDirTaller
	 *            the opDirTaller to set
	 */
	public void setOpDirTaller(String opDirTaller) {
		this.opDirTaller = opDirTaller;
	}

	/**
	 * @return the opConductorAfe
	 */
	public String getOpConductorAfe() {
		return opConductorAfe;
	}

	/**
	 * @param opConductorAfe
	 *            the opConductorAfe to set
	 */
	public void setOpConductorAfe(String opConductorAfe) {
		this.opConductorAfe = opConductorAfe;
	}

	/**
	 * @return the opCantidad
	 */
	public String getOpCantidad() {
		return opCantidad;
	}

	/**
	 * @param opCantidad
	 *            the opCantidad to set
	 */
	public void setOpCantidad(String opCantidad) {
		this.opCantidad = opCantidad;
	}

	/**
	 * @return the opNumReporte
	 */
	public String getOpNumReporte() {
		return opNumReporte;
	}

	/**
	 * @param opNumReporte
	 *            the opNumReporte to set
	 */
	public void setOpNumReporte(String opNumReporte) {
		this.opNumReporte = opNumReporte;
	}

	/**
	 * @return the opSiniestroTanque
	 */
	public String getOpSiniestroTanque() {
		return opSiniestroTanque;
	}

	/**
	 * @param opSiniestroTanque
	 *            the opSiniestroTanque to set
	 */
	public void setOpSiniestroTanque(String opSiniestroTanque) {
		this.opSiniestroTanque = opSiniestroTanque;
	}

	/**
	 * @return the opTelTaller
	 */
	public String getOpTelTaller() {
		return opTelTaller;
	}

	/**
	 * @param opTelTaller
	 *            the opTelTaller to set
	 */
	public void setOpTelTaller(String opTelTaller) {
		this.opTelTaller = opTelTaller;
	}

	/**
	 * @return the opFolioElectro
	 */
	public String getOpFolioElectro() {
		return opFolioElectro;
	}

	/**
	 * @param opFolioElectro
	 *            the opFolioElectro to set
	 */
	public void setOpFolioElectro(String opFolioElectro) {
		this.opFolioElectro = opFolioElectro;
	}

	/**
	 * @return the opColorAutoAse
	 */
	public String getOpColorAutoAse() {
		return opColorAutoAse;
	}

	/**
	 * @param opColorAutoAse
	 *            the opColorAutoAse to set
	 */
	public void setOpColorAutoAse(String opColorAutoAse) {
		this.opColorAutoAse = opColorAutoAse;
	}

	/**
	 * @return the opAsegurado
	 */
	public String getOpAsegurado() {
		return opAsegurado;
	}

	/**
	 * @param opAsegurado
	 *            the opAsegurado to set
	 */
	public void setOpAsegurado(String opAsegurado) {
		this.opAsegurado = opAsegurado;
	}

	/**
	 * @return the opClaveAjustador
	 */
	public String getOpClaveAjustador() {
		return opClaveAjustador;
	}

	/**
	 * @param opClaveAjustador
	 *            the opClaveAjustador to set
	 */
	public void setOpClaveAjustador(String opClaveAjustador) {
		this.opClaveAjustador = opClaveAjustador;
	}

	/**
	 * @return the opMarcaAutoAse
	 */
	public String getOpMarcaAutoAse() {
		return opMarcaAutoAse;
	}

	/**
	 * @param opMarcaAutoAse
	 *            the opMarcaAutoAse to set
	 */
	public void setOpMarcaAutoAse(String opMarcaAutoAse) {
		this.opMarcaAutoAse = opMarcaAutoAse;
	}

	/**
	 * @return the opDedDias
	 */
	public String getOpDedDias() {
		return opDedDias;
	}

	/**
	 * @param opDedDias
	 *            the opDedDias to set
	 */
	public void setOpDedDias(String opDedDias) {
		this.opDedDias = opDedDias;
	}

	/**
	 * @return the opAtencionTaller
	 */
	public String getOpAtencionTaller() {
		return opAtencionTaller;
	}

	/**
	 * @param opAtencionTaller
	 *            the opAtencionTaller to set
	 */
	public void setOpAtencionTaller(String opAtencionTaller) {
		this.opAtencionTaller = opAtencionTaller;
	}

	/**
	 * @return the opDefinicion
	 */
	public String getOpDefinicion() {
		return opDefinicion;
	}

	/**
	 * @param opDefinicion
	 *            the opDefinicion to set
	 */
	public void setOpDefinicion(String opDefinicion) {
		this.opDefinicion = opDefinicion;
	}

	/**
	 * @return the opDaniosCamion
	 */
	public String getOpDaniosCamion() {
		return opDaniosCamion;
	}

	/**
	 * @param opDaniosCamion
	 *            the opDaniosCamion to set
	 */
	public void setOpDaniosCamion(String opDaniosCamion) {
		this.opDaniosCamion = opDaniosCamion;
	}

	/**
	 * @return the opSumaAsegurado
	 */
	public String getOpSumaAsegurado() {
		return opSumaAsegurado;
	}

	/**
	 * @param opSumaAsegurado
	 *            the opSumaAsegurado to set
	 */
	public void setOpSumaAsegurado(String opSumaAsegurado) {
		this.opSumaAsegurado = opSumaAsegurado;
	}

	/**
	 * @return the opSerieAutoAse
	 */
	public String getOpSerieAutoAse() {
		return opSerieAutoAse;
	}

	/**
	 * @param opSerieAutoAse
	 *            the opSerieAutoAse to set
	 */
	public void setOpSerieAutoAse(String opSerieAutoAse) {
		this.opSerieAutoAse = opSerieAutoAse;
	}

	/**
	 * @return the opTipoAutoAse
	 */
	public String getOpTipoAutoAse() {
		return opTipoAutoAse;
	}

	/**
	 * @param opTipoAutoAse
	 *            the opTipoAutoAse to set
	 */
	public void setOpTipoAutoAse(String opTipoAutoAse) {
		this.opTipoAutoAse = opTipoAutoAse;
	}

	/**
	 * @return the opModeloAse
	 */
	public String getOpModeloAse() {
		return opModeloAse;
	}

	/**
	 * @param opModeloAse
	 *            the opModeloAse to set
	 */
	public void setOpModeloAse(String opModeloAse) {
		this.opModeloAse = opModeloAse;
	}

	/**
	 * @return the opNumSiniestro
	 */
	public String getOpNumSiniestro() {
		return opNumSiniestro;
	}

	/**
	 * @param opNumSiniestro
	 *            the opNumSiniestro to set
	 */
	public void setOpNumSiniestro(String opNumSiniestro) {
		this.opNumSiniestro = opNumSiniestro;
	}

	/**
	 * @return the opVigencia
	 */
	public Timestamp getOpVigencia() {
		return opVigencia;
	}

	/**
	 * @param opVigencia
	 *            the opVigencia to set
	 */
	public void setOpVigencia(Timestamp opVigencia) {
		this.opVigencia = opVigencia;
	}

	/**
	 * @return the opNumPoliza
	 */
	public String getOpNumPoliza() {
		return opNumPoliza;
	}

	/**
	 * @param opNumPoliza
	 *            the opNumPoliza to set
	 */
	public void setOpNumPoliza(String opNumPoliza) {
		this.opNumPoliza = opNumPoliza;
	}

	/**
	 * @return the opDaniosCaja
	 */
	public String getOpDaniosCaja() {
		return opDaniosCaja;
	}

	/**
	 * @param opDaniosCaja
	 *            the opDaniosCaja to set
	 */
	public void setOpDaniosCaja(String opDaniosCaja) {
		this.opDaniosCaja = opDaniosCaja;
	}

	/**
	 * @return the opTelConAfe
	 */
	public String getOpTelConAfe() {
		return opTelConAfe;
	}

	/**
	 * @param opTelConAfe
	 *            the opTelConAfe to set
	 */
	public void setOpTelConAfe(String opTelConAfe) {
		this.opTelConAfe = opTelConAfe;
	}

	/**
	 * @return the opTipoDeducible
	 */
	public Integer getOpTipoDeducible() {
		return opTipoDeducible;
	}

	/**
	 * @param opTipoDeducible
	 *            the opTipoDeducible to set
	 */
	public void setOpTipoDeducible(Integer opTipoDeducible) {
		this.opTipoDeducible = opTipoDeducible;
	}

	/**
	 * @return the opFolio
	 */
	public String getOpFolio() {
		return opFolio;
	}

	/**
	 * @param opFolio
	 *            the opFolio to set
	 */
	public void setOpFolio(String opFolio) {
		this.opFolio = opFolio;
	}

	/**
	 * @return the opNumInciso
	 */
	public String getOpNumInciso() {
		return opNumInciso;
	}

	/**
	 * @param opNumInciso
	 *            the opNumInciso to set
	 */
	public void setOpNumInciso(String opNumInciso) {
		this.opNumInciso = opNumInciso;
	}

	/**
	 * @return the opDeducible
	 */
	public Integer getOpDeducible() {
		return opDeducible;
	}

	/**
	 * @param opDeducible
	 *            the opDeducible to set
	 */
	public void setOpDeducible(Integer opDeducible) {
		this.opDeducible = opDeducible;
	}

	/**
	 * @return the opTipoAutoAfe
	 */
	public String getOpTipoAutoAfe() {
		return opTipoAutoAfe;
	}

	/**
	 * @param opTipoAutoAfe
	 *            the opTipoAutoAfe to set
	 */
	public void setOpTipoAutoAfe(String opTipoAutoAfe) {
		this.opTipoAutoAfe = opTipoAutoAfe;
	}

	/**
	 * @return the opDedAdmin
	 */
	public Integer getOpDedAdmin() {
		return opDedAdmin;
	}

	/**
	 * @param opDedAdmin
	 *            the opDedAdmin to set
	 */
	public void setOpDedAdmin(Integer opDedAdmin) {
		this.opDedAdmin = opDedAdmin;
	}

	/**
	 * @return the opSiniestroCamion
	 */
	public String getOpSiniestroCamion() {
		return opSiniestroCamion;
	}

	/**
	 * @param opSiniestroCamion
	 *            the opSiniestroCamion to set
	 */
	public void setOpSiniestroCamion(String opSiniestroCamion) {
		this.opSiniestroCamion = opSiniestroCamion;
	}

	/**
	 * @return the opNomAsegurado
	 */
	public String getOpNomAsegurado() {
		return opNomAsegurado;
	}

	/**
	 * @param opNomAsegurado
	 *            the opNomAsegurado to set
	 */
	public void setOpNomAsegurado(String opNomAsegurado) {
		this.opNomAsegurado = opNomAsegurado;
	}

	/**
	 * @return the opId
	 */
	public Integer getOpId() {
		return opId;
	}

	/**
	 * @param opId
	 *            the opId to set
	 */
	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	/**
	 * @return the opConductorAse
	 */
	public String getOpConductorAse() {
		return opConductorAse;
	}

	/**
	 * @param opConductorAse
	 *            the opConductorAse to set
	 */
	public void setOpConductorAse(String opConductorAse) {
		this.opConductorAse = opConductorAse;
	}

	/**
	 * @return the opNomAfe
	 */
	public String getOpNomAfe() {
		return opNomAfe;
	}

	/**
	 * @param opNomAfe
	 *            the opNomAfe to set
	 */
	public void setOpNomAfe(String opNomAfe) {
		this.opNomAfe = opNomAfe;
	}

	/**
	 * @return the opTelConAse
	 */
	public String getOpTelConAse() {
		return opTelConAse;
	}

	/**
	 * @param opTelConAse
	 *            the opTelConAse to set
	 */
	public void setOpTelConAse(String opTelConAse) {
		this.opTelConAse = opTelConAse;
	}

	/**
	 * @return the opTelAfe
	 */
	public String getOpTelAfe() {
		return opTelAfe;
	}

	/**
	 * @param opTelAfe
	 *            the opTelAfe to set
	 */
	public void setOpTelAfe(String opTelAfe) {
		this.opTelAfe = opTelAfe;
	}

	/**
	 * @return the opMotorAutoAfe
	 */
	public String getOpMotorAutoAfe() {
		return opMotorAutoAfe;
	}

	/**
	 * @param opMotorAutoAfe
	 *            the opMotorAutoAfe to set
	 */
	public void setOpMotorAutoAfe(String opMotorAutoAfe) {
		this.opMotorAutoAfe = opMotorAutoAfe;
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
	 * @return the opEmailTercero
	 */
	public String getOpEmailTercero() {
		return opEmailTercero;
	}

	/**
	 * @param opEmailTercero
	 *            the opEmailTercero to set
	 */
	public void setOpEmailTercero(String opEmailTercero) {
		this.opEmailTercero = opEmailTercero;
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

	public String getNiu() {
		return niu;
	}

	public void setNiu(String niu) {
		this.niu = niu;
	}

	public String getOa_codigo_qr() {
		return oa_codigo_qr;
	}

	public void setOa_codigo_qr(String oa_codigo_qr) {
		this.oa_codigo_qr = oa_codigo_qr;
	}

}
