/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class OrdenesPasesServicioAdmision {

	private String usuario;
	private String passwd;
	private String numeroReporte;
	private String numeroPoliza;
	private Date fechaHora;

	private String tipoOrden;
	private String tipoAfectado;
	private String conductor;
	private String telefonoConductor;
	private String oficina;
	private String ubicacion;
	private ProveedorAdmi proveedor;
	private String cobertura;
	private VehiculoAdmi vehiculo;
	private String danosPreexistentes;
	private String danosSiniestro;

	/**
	 * Clausula de Deducible
	 */
	private Boolean deducible;
	private String tipoDeducible;
	private String sumaAsegurada;
	private String porcentajeDeducible;
	private String monto;
	private String observaciones;

	public OrdenesPasesServicioAdmision() {
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
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the tipoOrden
	 */
	public String getTipoOrden() {
		return tipoOrden;
	}

	/**
	 * @param tipoOrden
	 *            the tipoOrden to set
	 */
	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	/**
	 * @return the tipoAfectado
	 */
	public String getTipoAfectado() {
		return tipoAfectado;
	}

	/**
	 * @param tipoAfectado
	 *            the tipoAfectado to set
	 */
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}

	/**
	 * @return the conductor
	 */
	public String getConductor() {
		return conductor;
	}

	/**
	 * @param conductor
	 *            the conductor to set
	 */
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	/**
	 * @return the telefonoConductor
	 */
	public String getTelefonoConductor() {
		return telefonoConductor;
	}

	/**
	 * @param telefonoConductor
	 *            the telefonoConductor to set
	 */
	public void setTelefonoConductor(String telefonoConductor) {
		this.telefonoConductor = telefonoConductor;
	}

	/**
	 * @return the oficina
	 */
	public String getOficina() {
		return oficina;
	}

	/**
	 * @param oficina
	 *            the oficina to set
	 */
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	 * @return the cobertura
	 */
	public String getCobertura() {
		return cobertura;
	}

	/**
	 * @param cobertura
	 *            the cobertura to set
	 */
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	/**
	 * @return the vehiculo
	 */
	public VehiculoAdmi getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo
	 *            the vehiculo to set
	 */
	public void setVehiculo(VehiculoAdmi vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * @return the danosPreexistentes
	 */
	public String getDanosPreexistentes() {
		return danosPreexistentes;
	}

	/**
	 * @param danosPreexistentes
	 *            the danosPreexistentes to set
	 */
	public void setDanosPreexistentes(String danosPreexistentes) {
		this.danosPreexistentes = danosPreexistentes;
	}

	/**
	 * @return the danosSiniestro
	 */
	public String getDanosSiniestro() {
		return danosSiniestro;
	}

	/**
	 * @param danosSiniestro
	 *            the danosSiniestro to set
	 */
	public void setDanosSiniestro(String danosSiniestro) {
		this.danosSiniestro = danosSiniestro;
	}

	/**
	 * @return the deducible
	 */
	public Boolean getDeducible() {
		return deducible;
	}

	/**
	 * @param deducible
	 *            the deducible to set
	 */
	public void setDeducible(Boolean deducible) {
		this.deducible = deducible;
	}

	/**
	 * @return the tipoDeducible
	 */
	public String getTipoDeducible() {
		return tipoDeducible;
	}

	/**
	 * @param tipoDeducible
	 *            the tipoDeducible to set
	 */
	public void setTipoDeducible(String tipoDeducible) {
		this.tipoDeducible = tipoDeducible;
	}

	/**
	 * @return the sumaAsegurada
	 */
	public String getSumaAsegurada() {
		return sumaAsegurada;
	}

	/**
	 * @param sumaAsegurada
	 *            the sumaAsegurada to set
	 */
	public void setSumaAsegurada(String sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	/**
	 * @return the porcentajeDeducible
	 */
	public String getPorcentajeDeducible() {
		return porcentajeDeducible;
	}

	/**
	 * @param porcentajeDeducible
	 *            the porcentajeDeducible to set
	 */
	public void setPorcentajeDeducible(String porcentajeDeducible) {
		this.porcentajeDeducible = porcentajeDeducible;
	}

	/**
	 * @return the monto
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return numeroReporte;
	}

	/**
	 * @param numeroReporte
	 *            the numeroReporte to set
	 */
	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	/**
	 * @return the numeroPoliza
	 */
	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	/**
	 * @param numeroPoliza
	 *            the numeroPoliza to set
	 */
	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

}
