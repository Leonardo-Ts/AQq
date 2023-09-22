package com.aaq.col.clases.webservices.movil;

public class GETMovilReporteSiseGrua {
    private String gruaClave;

    private String gruaEstatus;

    private String proveedorClave;

    private String proveedorNombre;

    private String fechaEstimada;

    private String fechaHoraEstimada;

    public GETMovilReporteSiseGrua(final String gruaClave, final String gruaEstatus, final String proveedorClave,
                                final String proveedorNombre, final String fechaEstimada, final String fechaHoraEstimada) {
        super();
        this.gruaClave = gruaClave;
        this.gruaEstatus = gruaEstatus;
        this.proveedorClave = proveedorClave;
        this.proveedorNombre = proveedorNombre;
        this.fechaEstimada = fechaEstimada;
        this.fechaHoraEstimada = fechaHoraEstimada;
    }

    public GETMovilReporteSiseGrua() {
        super();
    }

	public String getGruaClave() {
		return gruaClave;
	}

	public void setGruaClave(String gruaClave) {
		this.gruaClave = gruaClave;
	}

	public String getGruaEstatus() {
		return gruaEstatus;
	}

	public void setGruaEstatus(String gruaEstatus) {
		this.gruaEstatus = gruaEstatus;
	}

	public String getProveedorClave() {
		return proveedorClave;
	}

	public void setProveedorClave(String proveedorClave) {
		this.proveedorClave = proveedorClave;
	}

	public String getProveedorNombre() {
		return proveedorNombre;
	}

	public void setProveedorNombre(String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}

	public String getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public String getFechaHoraEstimada() {
		return fechaHoraEstimada;
	}

	public void setFechaHoraEstimada(String fechaHoraEstimada) {
		this.fechaHoraEstimada = fechaHoraEstimada;
	}

   

}
