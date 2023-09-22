/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class OrdenesPasesServicioEquipoPesado {

	private String usuario;
	private String passwd;
	private Date fechaHora;
	private String numeroReporte;
	private String numeroPoliza;
	private String tipoAtencion;
	private String conductor;
	private String telefonoConductor;
	private String sumaAsegurada;
	private String tipoDeducible;
	private String porcentajeDeducible;
	private ProveedorEP proveedor;
	private VehiculoEP vehiculo;

	/**
	 * 
	 */
	public OrdenesPasesServicioEquipoPesado() {
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
	 * @return the tipoAtencion
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}

	/**
	 * @param tipoAtencion
	 *            the tipoAtencion to set
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
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
	 * @return the proveedor
	 */
	public ProveedorEP getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(ProveedorEP proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the vehiculo
	 */
	public VehiculoEP getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo
	 *            the vehiculo to set
	 */
	public void setVehiculo(VehiculoEP vehiculo) {
		this.vehiculo = vehiculo;
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
