package com.aaq.col.clases.sac.model;

public class DatosSolicitudAbogado {

	private String numeroReporte;
	private String codigoAjustador;

	// Parametros de Solicitud, esto al final se concatena en separacion por
	// "pipes"
	private String motivoAsignacion;
	private String apreciacionResponsabilidad;
	private String idEntidad;
	private String lugarPresentarse;
	private Boolean vehiculoDetenido;
	private int numLesa;
	private int numHoma;
	private int numLest;
	private int numHomt;
	private Boolean conductorDetenido;
	private String descripPresentarse;
	private int pt;

	public DatosSolicitudAbogado() {
		super();
	}

	/**
	 * @param numeroReporte
	 * @param codigoAjustador
	 * @param motivoAsignacion
	 * @param apreciacionResponsabilidad
	 * @param idEntidad
	 * @param lugarPresentarse
	 * @param vehiculoDetenido
	 * @param numLesa
	 * @param numHoma
	 * @param numLest
	 * @param numHomt
	 * @param conductorDetenido
	 */
	public DatosSolicitudAbogado(String numeroReporte, String codigoAjustador, String motivoAsignacion, String apreciacionResponsabilidad, String idEntidad, String lugarPresentarse,
			Boolean vehiculoDetenido, int numLesa, int numHoma, int numLest, int numHomt, Boolean conductorDetenido, String descripPresentarse,
			int pt) {
		super();
		this.numeroReporte = numeroReporte;
		this.codigoAjustador = codigoAjustador;
		this.motivoAsignacion = motivoAsignacion;
		this.apreciacionResponsabilidad = apreciacionResponsabilidad;
		this.idEntidad = idEntidad;
		this.lugarPresentarse = lugarPresentarse;
		this.vehiculoDetenido = vehiculoDetenido;
		this.numLesa = numLesa;
		this.numHoma = numHoma;
		this.numLest = numLest;
		this.numHomt = numHomt;
		this.conductorDetenido = conductorDetenido;
		this.descripPresentarse = descripPresentarse;
		this.pt = pt;
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
	 * @return the codigoAjustador
	 */
	public String getCodigoAjustador() {
		return codigoAjustador;
	}

	/**
	 * @param codigoAjustador
	 *            the codigoAjustador to set
	 */
	public void setCodigoAjustador(String codigoAjustador) {
		this.codigoAjustador = codigoAjustador;
	}

	/**
	 * @return the motivoAsignacion
	 */
	public String getMotivoAsignacion() {
		return motivoAsignacion;
	}

	/**
	 * @param motivoAsignacion
	 *            the motivoAsignacion to set
	 */
	public void setMotivoAsignacion(String motivoAsignacion) {
		this.motivoAsignacion = motivoAsignacion;
	}

	/**
	 * @return the apreciacionResponsabilidad
	 */
	public String getApreciacionResponsabilidad() {
		return apreciacionResponsabilidad;
	}

	/**
	 * @param apreciacionResponsabilidad
	 *            the apreciacionResponsabilidad to set
	 */
	public void setApreciacionResponsabilidad(String apreciacionResponsabilidad) {
		this.apreciacionResponsabilidad = apreciacionResponsabilidad;
	}

	/**
	 * @return the idEntidad
	 */
	public String getIdEntidad() {
		return idEntidad;
	}

	/**
	 * @param idEntidad
	 *            the idEntidad to set
	 */
	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	/**
	 * @return the lugarPresentarse
	 */
	public String getLugarPresentarse() {
		return lugarPresentarse;
	}

	/**
	 * @param lugarPresentarse
	 *            the lugarPresentarse to set
	 */
	public void setLugarPresentarse(String lugarPresentarse) {
		this.lugarPresentarse = lugarPresentarse;
	}

	/**
	 * @return the vehiculoDetenido
	 */
	public Boolean getVehiculoDetenido() {
		return vehiculoDetenido;
	}

	/**
	 * @param vehiculoDetenido
	 *            the vehiculoDetenido to set
	 */
	public void setVehiculoDetenido(Boolean vehiculoDetenido) {
		this.vehiculoDetenido = vehiculoDetenido;
	}

	/**
	 * @return the numLesa
	 */
	public int getNumLesa() {
		return numLesa;
	}

	/**
	 * @param numLesa
	 *            the numLesa to set
	 */
	public void setNumLesa(int numLesa) {
		this.numLesa = numLesa;
	}

	/**
	 * @return the numHoma
	 */
	public int getNumHoma() {
		return numHoma;
	}

	/**
	 * @param numHoma
	 *            the numHoma to set
	 */
	public void setNumHoma(int numHoma) {
		this.numHoma = numHoma;
	}

	/**
	 * @return the numLest
	 */
	public int getNumLest() {
		return numLest;
	}

	/**
	 * @param numLest
	 *            the numLest to set
	 */
	public void setNumLest(int numLest) {
		this.numLest = numLest;
	}

	/**
	 * @return the numHomt
	 */
	public int getNumHomt() {
		return numHomt;
	}

	/**
	 * @param numHomt
	 *            the numHomt to set
	 */
	public void setNumHomt(int numHomt) {
		this.numHomt = numHomt;
	}

	/**
	 * @return the conductorDetenido
	 */
	public Boolean getConductorDetenido() {
		return conductorDetenido;
	}

	/**
	 * @param conductorDetenido
	 *            the conductorDetenido to set
	 */
	public void setConductorDetenido(Boolean conductorDetenido) {
		this.conductorDetenido = conductorDetenido;
	}

	/**
	 * @return the descAPresentarse
	 */
	public String getDescripPresentarse() {
		return descripPresentarse;
	}

	/**
	 * @param descAPresentarse the descAPresentarse to set
	 */
	public void setDescripPresentarse(String descripPresentarse) {
		this.descripPresentarse = descripPresentarse;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}
	
	
}
