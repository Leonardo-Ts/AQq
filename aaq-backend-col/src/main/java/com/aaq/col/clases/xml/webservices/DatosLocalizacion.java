package com.aaq.col.clases.xml.webservices;

import java.util.Date;

public class DatosLocalizacion {

	private String reporte;

	private String identificador;

	private String latitud;

	private String longitud;

	private String estado;

	private String municipio;

	private String colonia;

	private String codigoPostal;

	private String calle;

	private String entreCalle;

	private String referencia;

	private String carretera;

	private String numeroProveedorAsignado;

	private Integer husoHorario;

	private Boolean cerrarLocalizacion;

	private Boolean cerrarAsignacion;

	private Date fecha;

	private String idMunSepoMex;

	private String idEntSepoMex;

	private String numeroExterior;

	private String kilometro;

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEntreCalle() {
		return entreCalle;
	}

	public void setEntreCalle(String entreCalle) {
		this.entreCalle = entreCalle;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCarretera() {
		return carretera;
	}

	public void setCarretera(String carretera) {
		this.carretera = carretera;
	}

	public String getNumeroProveedorAsignado() {
		return numeroProveedorAsignado;
	}

	public void setNumeroProveedorAsignado(String numeroProveedorAsignado) {
		this.numeroProveedorAsignado = numeroProveedorAsignado;
	}

	public Integer getHusoHorario() {
		return husoHorario;
	}

	public void setHusoHorario(Integer husoHorario) {
		this.husoHorario = husoHorario;
	}

	public Boolean getCerrarLocalizacion() {
		return cerrarLocalizacion;
	}

	public void setCerrarLocalizacion(Boolean cerrarLocalizacion) {
		this.cerrarLocalizacion = cerrarLocalizacion;
	}

	public Boolean getCerrarAsignacion() {
		return cerrarAsignacion;
	}

	public void setCerrarAsignacion(Boolean cerrarAsignacion) {
		this.cerrarAsignacion = cerrarAsignacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdMunSepoMex() {
		return idMunSepoMex;
	}

	public void setIdMunSepoMex(String idMunSepoMex) {
		this.idMunSepoMex = idMunSepoMex;
	}

	public String getIdEntSepoMex() {
		return idEntSepoMex;
	}

	public void setIdEntSepoMex(String idEntSepoMex) {
		this.idEntSepoMex = idEntSepoMex;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getKilometro() {
		return kilometro;
	}

	public void setKilometro(String kilometro) {
		this.kilometro = kilometro;
	}

	public DatosLocalizacion() {
		super();
	}

	public DatosLocalizacion(String reporte, String identificador, String latitud, String longitud, String estado,
			String municipio, String colonia, String codigoPostal, String calle, String entreCalle, String referencia,
			String carretera, String numeroProveedorAsignado, Integer husoHorario, Boolean cerrarLocalizacion,
			Boolean cerrarAsignacion, Date fecha, String idMunSepoMex, String idEntSepoMex, String numeroExterior,
			String kilometro) {
		super();
		this.reporte = reporte;
		this.identificador = identificador;
		this.latitud = latitud;
		this.longitud = longitud;
		this.estado = estado;
		this.municipio = municipio;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.entreCalle = entreCalle;
		this.referencia = referencia;
		this.carretera = carretera;
		this.numeroProveedorAsignado = numeroProveedorAsignado;
		this.husoHorario = husoHorario;
		this.cerrarLocalizacion = cerrarLocalizacion;
		this.cerrarAsignacion = cerrarAsignacion;
		this.fecha = fecha;
		this.idMunSepoMex = idMunSepoMex;
		this.idEntSepoMex = idEntSepoMex;
		this.numeroExterior = numeroExterior;
		this.kilometro = kilometro;
	}
	
	
	
	
}
