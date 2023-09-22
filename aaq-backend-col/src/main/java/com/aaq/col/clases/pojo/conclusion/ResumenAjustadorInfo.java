package com.aaq.col.clases.pojo.conclusion;

import java.util.List;

import com.aaq.col.clases.webservices.movil.aex.Adicionales;
import com.aaq.col.clases.webservices.movil.aex.Asegurado;
import com.aaq.col.clases.webservices.movil.aex.Recuperos;
import com.aaq.col.clases.webservices.movil.aex.Reporte;
import com.aaq.col.clases.webservices.movil.aex.Terceros;
import com.aaq.col.clases.webservices.movil.aex.Tiempos;
import com.aaq.col.clases.webservices.movil.aex.Ubicacion;

public class ResumenAjustadorInfo {

	private Reporte reporte;
	private Asegurado asegurado;
	private Tiempos tiempos;
	private Adicionales adicionales;
	private Coberturas estimaciones ;
	private Terceros terceros ;
	private Recuperos recuperos ;
	private Ubicacion ubicacion;
	private List<String> docEntregados;
	private List<Coberturas> coberturas;
	private List<Reparacion> reparacion;
	private List<Grua> solicitarGrua;
	private List<PaseMedico> paseMedico;
	private List<Abogado> abogados;
	
	public Reporte getReporte() {
		return reporte;
	}
	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	public Asegurado getAsegurado() {
		return asegurado;
	}
	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}
	public Tiempos getTiempos() {
		return tiempos;
	}
	public void setTiempos(Tiempos tiempos) {
		this.tiempos = tiempos;
	}
	public Adicionales getAdicionales() {
		return adicionales;
	}
	public void setAdicionales(Adicionales adicionales) {
		this.adicionales = adicionales;
	}
	
	public Coberturas getEstimaciones() {
		return estimaciones;
	}
	public Terceros getTerceros() {
		return terceros;
	}
	public void setTerceros(Terceros terceros) {
		this.terceros = terceros;
	}
	public Recuperos getRecuperos() {
		return recuperos;
	}
	public void setRecuperos(Recuperos recuperos) {
		this.recuperos = recuperos;
	}
	public void setEstimaciones(Coberturas estimaciones) {
		this.estimaciones = estimaciones;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<String> getDocEntregados() {
		return docEntregados;
	}
	public void setDocEntregados(List<String> docEntregados) {
		this.docEntregados = docEntregados;
	}
	public List<Coberturas> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<Coberturas> coberturas) {
		this.coberturas = coberturas;
	}
	public List<Reparacion> getReparacion() {
		return reparacion;
	}
	public void setReparacion(List<Reparacion> reparacion) {
		this.reparacion = reparacion;
	}
	public List<Grua> getSolicitarGrua() {
		return solicitarGrua;
	}
	public void setSolicitarGrua(List<Grua> solicitarGrua) {
		this.solicitarGrua = solicitarGrua;
	}
	public List<PaseMedico> getPaseMedico() {
		return paseMedico;
	}
	public void setPaseMedico(List<PaseMedico> paseMedico) {
		this.paseMedico = paseMedico;
	}
	public List<Abogado> getAbogados() {
		return abogados;
	}
	public void setAbogados(List<Abogado> abogados) {
		this.abogados = abogados;
	}
	
	
	
}
