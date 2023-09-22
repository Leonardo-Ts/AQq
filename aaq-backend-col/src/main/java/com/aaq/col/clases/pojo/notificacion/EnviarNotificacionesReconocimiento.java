package com.aaq.col.clases.pojo.notificacion;

import java.util.ArrayList;
import java.util.List;

public class EnviarNotificacionesReconocimiento {
	
	private String reporte;
	private String fechaRegistro;
	private String fechaNotificacion;
	private String origen;
	private AseguradoReconocimiento asegurado;
	private ArrayList<TerceroReconocimiento> terceros  = new ArrayList<>();
	private List<String> reporteSimilitud;
	
	
	public String getReporte() {
		return reporte;
	}
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getFechaNotificacion() {
		return fechaNotificacion;
	}
	public void setFechaNotificacion(String fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public AseguradoReconocimiento getAsegurado() {
		return asegurado;
	}
	public void setAsegurado(AseguradoReconocimiento asegurado) {
		this.asegurado = asegurado;
	}
	public ArrayList<TerceroReconocimiento> getTerceros() {
		return terceros;
	}
	public void setTerceros(ArrayList<TerceroReconocimiento> terceros) {
		this.terceros = terceros;
	}
	public List<String> getReporteSimilitud() {
		return reporteSimilitud;
	}
	public void setReporteSimilitud(List<String> reporteSimilitud) {
		this.reporteSimilitud = reporteSimilitud;
	}
	
	
	
	

}
