package com.aaq.col.clases.webservices.movil.peticion;

public class MovilReporteSacGrua {

	private String gruaClave;

	private String gruaEstatus;

	private String proveedorClave;

	private String proveedorNombre;

	private String fechaEstimada;

	private String fechaHoraEstimada;

	
	/**
	 * @param gruaClave
	 * @param gruaEstatus
	 * @param proveedorClave
	 * @param proveedorNombre
	 * @param fechaEstimada
	 * @param fechaHoraEstimada
	 */
	public MovilReporteSacGrua(String gruaClave, String gruaEstatus,
			String proveedorClave, String proveedorNombre,
			String fechaEstimada, String fechaHoraEstimada) {
		super();
		this.gruaClave = gruaClave;
		this.gruaEstatus = gruaEstatus;
		this.proveedorClave = proveedorClave;
		this.proveedorNombre = proveedorNombre;
		this.fechaEstimada = fechaEstimada;
		this.fechaHoraEstimada = fechaHoraEstimada;
	}


	/**
	 * @return the gruaClave
	 */
	public String getGruaClave() {
		return gruaClave;
	}


	/**
	 * @param gruaClave the gruaClave to set
	 */
	public void setGruaClave(String gruaClave) {
		this.gruaClave = gruaClave;
	}


	/**
	 * @return the gruaEstatus
	 */
	public String getGruaEstatus() {
		return gruaEstatus;
	}


	/**
	 * @param gruaEstatus the gruaEstatus to set
	 */
	public void setGruaEstatus(String gruaEstatus) {
		this.gruaEstatus = gruaEstatus;
	}


	/**
	 * @return the proveedorClave
	 */
	public String getProveedorClave() {
		return proveedorClave;
	}


	/**
	 * @param proveedorClave the proveedorClave to set
	 */
	public void setProveedorClave(String proveedorClave) {
		this.proveedorClave = proveedorClave;
	}


	/**
	 * @return the proveedorNombre
	 */
	public String getProveedorNombre() {
		return proveedorNombre;
	}


	/**
	 * @param proveedorNombre the proveedorNombre to set
	 */
	public void setProveedorNombre(String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}


	/**
	 * @return the fechaEstimada
	 */
	public String getFechaEstimada() {
		return fechaEstimada;
	}


	/**
	 * @param fechaEstimada the fechaEstimada to set
	 */
	public void setFechaEstimada(String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}


	/**
	 * @return the fechaHoraEstimada
	 */
	public String getFechaHoraEstimada() {
		return fechaHoraEstimada;
	}


	/**
	 * @param fechaHoraEstimada the fechaHoraEstimada to set
	 */
	public void setFechaHoraEstimada(String fechaHoraEstimada) {
		this.fechaHoraEstimada = fechaHoraEstimada;
	}
	
	
	
	
}

