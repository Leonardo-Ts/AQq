package com.aaq.col.clases.pojo.conclusion;

import java.io.Serializable;
import java.util.List;


public class ConclusionAjustador implements Serializable{

	private static final long serialVersionUID = -6064826456132972901L;
	
	private String numeroReporte;
	private String claveAjustador;
	private String narracion;
	private String croquis;
	private String deslindeResponsabilidad;
	private String claveAgente;
	private String nombreAsegurado;
	private String nombreConductor;
	private String correoAsegurado;
	private String poliza;
	private String inciso;
	//Datos de AUTO
	private String vehiculoMarca;
	private String vehiculoModelo;
	private String vehiculoSerie;
	private String vehiculoPlacas;
	private String vehiculoColor;
	private String codigoCausa;
	private String fechaOcurrido;
	private String fechaAsignacion;
	private String fechaArribo;
// Ubicacion Siniestro
	private String ubicacionSiniestro;
	private String colonia;
	private String ciudad;
	
	private String fechaTermino;
	private String causaAccidente;
	private String responsabilidadTermino;

	private List<Coberturas> coberturas;
	private List<Reparacion> reparacion;
	private List<Gruas> solicitarGrua;
	private List<PaseMedico> paseMedico;
	private List<Abogados> abogados;
	
	private List<String> documentosEntregados;
	//Nuevos datos
	private String firmaConductor;
	private String munDeleg;
	private String numSiniestro;
	
	private List<String> correoDestinatario;
	
	public String getClaveAjustador() {
		return claveAjustador;
	}
	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}
	public String getNarracion() {
		return narracion;
	}
	public void setNarracion(String narracion) {
		this.narracion = narracion;
	}
	
	public String getCroquis() {
		return croquis;
	}
	public void setCroquis(String croquis) {
		this.croquis = croquis;
	}
	public void setFirmaConductor(String firmaConductor) {
		this.firmaConductor = firmaConductor;
	}
	public String getDeslindeResponsabilidad() {
		return deslindeResponsabilidad;
	}
	public void setDeslindeResponsabilidad(String deslindeResponsabilidad) {
		this.deslindeResponsabilidad = deslindeResponsabilidad;
	}
	public String getClaveAgente() {
		return claveAgente;
	}
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}
	public String getNombreAsegurado() {
		return nombreAsegurado;
	}
	public void setNombreAsegurado(String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
	}
	public String getNombreConductor() {
		return nombreConductor;
	}
	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}
	public String getCorreoAsegurado() {
		return correoAsegurado;
	}
	public void setCorreoAsegurado(String correoAsegurado) {
		this.correoAsegurado = correoAsegurado;
	}
	
	public String getVehiculoSerie() {
		return vehiculoSerie;
	}
	public void setVehiculoSerie(String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}
	
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getVehiculoMarca() {
		return vehiculoMarca;
	}
	public void setVehiculoMarca(String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}
	public String getVehiculoModelo() {
		return vehiculoModelo;
	}
	public void setVehiculoModelo(String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}
	public String getVehiculoPlacas() {
		return vehiculoPlacas;
	}
	public void setVehiculoPlacas(String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}
	public String getVehiculoColor() {
		return vehiculoColor;
	}
	public void setVehiculoColor(String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}
	public String getCodigoCausa() {
		return codigoCausa;
	}
	public void setCodigoCausa(String codigoCausa) {
		this.codigoCausa = codigoCausa;
	}

	
	public String getUbicacionSiniestro() {
		return ubicacionSiniestro;
	}
	public void setUbicacionSiniestro(String ubicacionSiniestro) {
		this.ubicacionSiniestro = ubicacionSiniestro;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCausaAccidente() {
		return causaAccidente;
	}
	public void setCausaAccidente(String causaAccidente) {
		this.causaAccidente = causaAccidente;
	}
	public String getResponsabilidadTermino() {
		return responsabilidadTermino;
	}
	public void setResponsabilidadTermino(String responsabilidadTermino) {
		this.responsabilidadTermino = responsabilidadTermino;
	}
	
	
//	public Date getFecha() {
//		return fecha;
//	}
//	public void setFecha(Date fecha) {
//		this.fecha = fecha;
//	}
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
	
	public List<Gruas> getSolicitarGrua() {
		return solicitarGrua;
	}
	public void setSolicitarGrua(List<Gruas> solicitarGrua) {
		this.solicitarGrua = solicitarGrua;
	}
	public void setAbogados(List<Abogados> abogados) {
		this.abogados = abogados;
	}
	public List<PaseMedico> getPaseMedico() {
		return paseMedico;
	}
	public void setPaseMedico(List<PaseMedico> paseMedico) {
		this.paseMedico = paseMedico;
	}
	
	public String getMunDeleg() {
		return munDeleg;
	}
	public void setMunDeleg(String munDeleg) {
		this.munDeleg = munDeleg;
	}
	public String getNumSiniestro() {
		return numSiniestro;
	}
	public void setNumSiniestro(String numSiniestro) {
		this.numSiniestro = numSiniestro;
	}
	
	public List<String> getCorreoDestinatario() {
		return correoDestinatario;
	}
	public void setCorreoDestinatario(List<String> correoDestinatario) {
		this.correoDestinatario = correoDestinatario;
	}
	public String getNumeroReporte() {
		return numeroReporte;
	}
	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}
	public String getFirmaConductor() {
		return firmaConductor;
	}
	public String getInciso() {
		return inciso;
	}
	public void setInciso(String inciso) {
		this.inciso = inciso;
	}
	public String getFechaOcurrido() {
		return fechaOcurrido;
	}
	public void setFechaOcurrido(String fechaOcurrido) {
		this.fechaOcurrido = fechaOcurrido;
	}
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public String getFechaArribo() {
		return fechaArribo;
	}
	public void setFechaArribo(String fechaArribo) {
		this.fechaArribo = fechaArribo;
	}
	public String getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public List<String> getDocumentosEntregados() {
		return documentosEntregados;
	}
	public void setDocumentosEntregados(List<String> documentosEntregados) {
		this.documentosEntregados = documentosEntregados;
	}
	public List<Abogados> getAbogados() {
		return abogados;
	}

	
	
	
	
}
