package com.aaq.col.clases.webservices.movil.peticion;

public class MovilReporteSiseGrua {
	private String gruaClave;

	private String gruaEstatus;

	private String proveedorClave;

	private String proveedorNombre;

	private String fechaEstimada;

	private String fechaHoraEstimada;
	
	private String tipoAfectado;

	/**
	 * Dec 11, 2013 7:41:39 PM
	 *
	 * @param gruaClave
	 * @param gruaEstatus
	 * @param proveedorClave
	 * @param proveedorNombre
	 * @param fechaEstimada
	 * @param fechaHoraEstimada
	 */
	public MovilReporteSiseGrua(final String gruaClave, final String gruaEstatus, final String proveedorClave,
			final String proveedorNombre, final String fechaEstimada, final String fechaHoraEstimada) {
		super();
		this.gruaClave = gruaClave;
		this.gruaEstatus = gruaEstatus;
		this.proveedorClave = proveedorClave;
		this.proveedorNombre = proveedorNombre;
		this.fechaEstimada = fechaEstimada;
		this.fechaHoraEstimada = fechaHoraEstimada;
	}

	/**
	 * Nov 30, 2017 16:17:39 PM
	 *
	 * @param gruaClave
	 * @param gruaEstatus
	 * @param proveedorClave
	 * @param proveedorNombre
	 * @param fechaEstimada
	 * @param fechaHoraEstimada
	 * @param tipoAfectado
	 */
	public MovilReporteSiseGrua(final String gruaClave, final String gruaEstatus,
			final String proveedorClave, final String proveedorNombre, final String fechaEstimada,
			final String fechaHoraEstimada, final String tipoAfectado) {
		super();
		this.gruaClave = gruaClave;
		this.gruaEstatus = gruaEstatus;
		this.proveedorClave = proveedorClave;
		this.proveedorNombre = proveedorNombre;
		this.fechaEstimada = fechaEstimada;
		this.fechaHoraEstimada = fechaHoraEstimada;
		this.tipoAfectado = tipoAfectado;
	}

	/**
	 * Dec 11, 2013 7:39:56 PM
	 */
	public MovilReporteSiseGrua() {
		super();
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @return the gruaClave
	 */
	public String getGruaClave() {
		return this.gruaClave;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @param gruaClave
	 *            the gruaClave to set
	 */
	public void setGruaClave(final String gruaClave) {
		this.gruaClave = gruaClave;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @return the gruaEstatus
	 */
	public String getGruaEstatus() {
		return this.gruaEstatus;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @param gruaEstatus
	 *            the gruaEstatus to set
	 */
	public void setGruaEstatus(final String gruaEstatus) {
		this.gruaEstatus = gruaEstatus;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @return the proveedorClave
	 */
	public String getProveedorClave() {
		return this.proveedorClave;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @param proveedorClave
	 *            the proveedorClave to set
	 */
	public void setProveedorClave(final String proveedorClave) {
		this.proveedorClave = proveedorClave;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @return the proveedorNombre
	 */
	public String getProveedorNombre() {
		return this.proveedorNombre;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @param proveedorNombre
	 *            the proveedorNombre to set
	 */
	public void setProveedorNombre(final String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @return the fechaEstimada
	 */
	public String getFechaEstimada() {
		return this.fechaEstimada;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @param fechaEstimada
	 *            the fechaEstimada to set
	 */
	public void setFechaEstimada(final String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @return the fechaHoraEstimada
	 */
	public String getFechaHoraEstimada() {
		return this.fechaHoraEstimada;
	}

	/**
	 * Dec 11, 2013 7:41:28 PM
	 *
	 * @param fechaHoraEstimada
	 *            the fechaHoraEstimada to set
	 */
	public void setFechaHoraEstimada(final String fechaHoraEstimada) {
		this.fechaHoraEstimada = fechaHoraEstimada;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the tipoAfectado
	 */
	public String getTipoAfectado() {
		return tipoAfectado;
	}

	/**
	 * @author Arturo de la Cruz
	 * @param tipoAfectado the tipoAfectado to set
	 */
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}

}
