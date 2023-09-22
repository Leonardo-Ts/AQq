package com.aaq.col.clases.xml.webservices;

public class JMWSAsignacionProveedor {

	private String numProveedor;
	private Integer tipoProveedor;
	private String ramo;
	private String ejercicio;
	private String numReporte;
	private String atencion;
	private String monto;
	private JMWSAsignacionProveedorLesionado lesionado;
	private String cveAmbulancia;
	private String usuarioModifica;
	private String folioVale;
    private String codigoME;
    
	public JMWSAsignacionProveedor() {
		super();
	}
	
	public String getNumProveedor() {
		return numProveedor;
	}
	public void setNumProveedor(String numProveedor) {
		this.numProveedor = numProveedor;
	}
	public Integer getTipoProveedor() {
		return tipoProveedor;
	}
	public void setTipoProveedor(Integer tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	public String getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getNumReporte() {
		return numReporte;
	}
	public void setNumReporte(String numReporte) {
		this.numReporte = numReporte;
	}
	public String getAtencion() {
		return atencion;
	}
	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public JMWSAsignacionProveedorLesionado getLesionado() {
		return lesionado;
	}
	public void setLesionado(JMWSAsignacionProveedorLesionado lesionado) {
		this.lesionado = lesionado;
	}
	public String getCveAmbulancia() {
		return cveAmbulancia;
	}
	public void setCveAmbulancia(String cveAmbulancia) {
		this.cveAmbulancia = cveAmbulancia;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public String getFolioVale() {
		return folioVale;
	}
	public void setFolioVale(String folioVale) {
		this.folioVale = folioVale;
	}
	public String getCodigoME() {
		return codigoME;
	}
	public void setCodigoME(String codigoME) {
		this.codigoME = codigoME;
	}
    
    
}
