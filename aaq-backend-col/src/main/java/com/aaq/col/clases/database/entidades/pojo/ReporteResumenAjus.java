package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReporteResumenAjus implements Serializable{

	private static final long serialVersionUID = 8630296128698117966L;
	
	private String reporte;
	private String claveAjustador;
	private Date fecha;
	private String ajustador;
	private String codigoCausa;
	private String nombreAsgurado;
	private String telefono;
	private String poliza;
	private String estatusPoliza;
	private String marca;
	private String correoAsegurado;
	private String inciso;
	private String modelo;
	private String origenAsig;
	private Date fechaAsig;
	private String usuarioAsig;
	private String servicioAmbulanciaAsig;
	private String proximidadAsig;
	private String origenArribo;
	private Date fechaArribo;
	private String origenTermino;
	private Date fechaTermino;
	private String observacionesTermino;
	private String responsabilidadTermino;
	private String descDaniosPreTermino;
	private List<Tercero> terceros;
	private List<Recupero> recuperos;
	private List<SolicitarFolio> folio;
	private String ruta;
	private List<Cobertura> coberturas;
	private List<SolicitarGrua> solicitarGrua;
	private List<CobroData> cobroBancario;
	private List<DatosRobo> datosRobos;
	private List<Abogado> abogados;
	
	private JRDataSource tercerosD;
	private JRDataSource recuperoD;
	private JRDataSource solicitarFolioD;
	private JRDataSource coberturasD;
	private JRDataSource solicitarGruaD;
	private JRDataSource cobroBancarioD;
	private JRDataSource robosD;
	private JRDataSource abogadosD;
	
	private String nombreConductor;
	private String vehiculoSerie;
	
	private String placas;
	
	public String getReporte() {
		return reporte;
	}
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	public String getClaveAjustador() {
		return claveAjustador;
	}
	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getAjustador() {
		return ajustador;
	}
	public void setAjustador(String ajustador) {
		this.ajustador = ajustador;
	}
	public String getNombreAsgurado() {
		return nombreAsgurado;
	}
	public void setNombreAsgurado(String nombreAsgurado) {
		this.nombreAsgurado = nombreAsgurado;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCorreoAsegurado() {
		return correoAsegurado;
	}
	public void setCorreoAsegurado(String correoAsegurado) {
		this.correoAsegurado = correoAsegurado;
	}
	public String getInciso() {
		return inciso;
	}
	public void setInciso(String inciso) {
		this.inciso = inciso;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getOrigenAsig() {
		return origenAsig;
	}
	public void setOrigenAsig(String origenAsig) {
		this.origenAsig = origenAsig;
	}
	public Date getFechaAsig() {
		return fechaAsig;
	}
	public void setFechaAsig(Date fechaAsig) {
		this.fechaAsig = fechaAsig;
	}
	public String getOrigenArribo() {
		return origenArribo;
	}
	public void setOrigenArribo(String origenArribo) {
		this.origenArribo = origenArribo;
	}
	public Date getFechaArribo() {
		return fechaArribo;
	}
	public void setFechaArribo(Date fechaArribo) {
		this.fechaArribo = fechaArribo;
	}
	public String getOrigenTermino() {
		return origenTermino;
	}
	public void setOrigenTermino(String origenTermino) {
		this.origenTermino = origenTermino;
	}	
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public String getObservacionesTermino() {
		return observacionesTermino;
	}
	public void setObservacionesTermino(String observacionesTermino) {
		this.observacionesTermino = observacionesTermino;
	}
	public String getResponsabilidadTermino() {
		return responsabilidadTermino;
	}
	public void setResponsabilidadTermino(String responsabilidadTermino) {
		this.responsabilidadTermino = responsabilidadTermino;
	}
	public List<Tercero> getTerceros() {
		return terceros;
	}
	public void setTerceros(List<Tercero> terceros) {
		this.terceros = terceros;
	}
	public List<Recupero> getRecuperos() {
		return recuperos;
	}
	public void setRecuperos(List<Recupero> recuperos) {
		this.recuperos = recuperos;
	}
	public List<SolicitarFolio> getFolio() {
		return folio;
	}
	public void setFolio(List<SolicitarFolio> folio) {
		this.folio = folio;
	}
	
	public List<Cobertura> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<Cobertura> coberturas) {
		this.coberturas = coberturas;
	}
	public JRDataSource getCoberturasD() {
		return new JRBeanCollectionDataSource(this.coberturas);
	}
	public void setCoberturasD(JRDataSource coberturasD) {
		this.coberturasD = coberturasD;
	}
	public JRDataSource getTercerosD() {
		
		return new JRBeanCollectionDataSource(this.terceros);
	}
	public void setTercerosD(JRDataSource tercerosD) {
		this.tercerosD = tercerosD;
	}
	
	public String getProximidadAsig() {
		return proximidadAsig;
	}
	public void setProximidadAsig(String proximidadAsig) {
		this.proximidadAsig = proximidadAsig;
	}

	public String getDescDaniosPreTermino() {
		return descDaniosPreTermino;
	}
	public void setDescDaniosPreTermino(String descDaniosPreTermino) {
		this.descDaniosPreTermino = descDaniosPreTermino;
	}
	public String getCodigoCausa() {
		return codigoCausa;
	}
	public void setCodigoCausa(String codigoCausa) {
		this.codigoCausa = codigoCausa;
	}
	public String getEstatusPoliza() {
		return estatusPoliza;
	}
	public void setEstatusPoliza(String estatusPoliza) {
		this.estatusPoliza = estatusPoliza;
	}
	
	public String getUsuarioAsig() {
		return usuarioAsig;
	}
	public void setUsuarioAsig(String usuarioAsig) {
		this.usuarioAsig = usuarioAsig;
	}
	public String getServicioAmbulanciaAsig() {
		return servicioAmbulanciaAsig;
	}
	public void setServicioAmbulanciaAsig(String servicioAmbulanciaAsig) {
		this.servicioAmbulanciaAsig = servicioAmbulanciaAsig;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public JRDataSource getRecuperoD() {
		return new JRBeanCollectionDataSource(this.recuperos);
	}
	public void setRecuperoD(JRDataSource recuperoD) {
		this.recuperoD = recuperoD;
	}
	public JRDataSource getSolicitarFolioD() {
		return new JRBeanCollectionDataSource(this.folio);
	}
	public void setSolicitarFolioD(JRDataSource solicitarFolioD) {
		this.solicitarFolioD = solicitarFolioD;
	}
	public List<SolicitarGrua> getSolicitarGrua() {
		return solicitarGrua;
	}
	public void setSolicitarGrua(List<SolicitarGrua> solicitarGrua) {
		this.solicitarGrua = solicitarGrua;
	}
	public JRDataSource getSolicitarGruaD() {
		return new JRBeanCollectionDataSource(this.solicitarGrua);
	}
	public void setSolicitarGruaD(JRDataSource solicitarGruaD) {
		this.solicitarGruaD = solicitarGruaD;
	}
	public JRDataSource getCobroBancarioD() {
		return new JRBeanCollectionDataSource(this.cobroBancario);
	}
	public void setCobroBancarioD(JRDataSource cobroBancarioD) {
		this.cobroBancarioD = cobroBancarioD;
	}
	public List<CobroData> getCobroBancario() {
		return cobroBancario;
	}
	public void setCobroBancario(List<CobroData> cobroBancario) {
		this.cobroBancario = cobroBancario;
	}
	public List<DatosRobo> getDatosRobos() {
		return datosRobos;
	}
	public void setDatosRobos(List<DatosRobo> datosRobos) {
		this.datosRobos = datosRobos;
	}
	public JRDataSource getRobosD() {
		return new JRBeanCollectionDataSource(this.datosRobos);
	}
	public void setRobosD(JRDataSource robosD) {
		this.robosD = robosD;
	}
	public List<Abogado> getAbogados() {
		return abogados;
	}
	public void setAbogados(List<Abogado> abogados) {
		this.abogados = abogados;
	}
	public JRDataSource getAbogadosD() {
		return new JRBeanCollectionDataSource(this.abogados);
	}
	public void setAbogadosD(JRDataSource abogadosD) {
		this.abogadosD = abogadosD;
	}
	
	/**
	 * @return the nombreConductor
	 */
	public String getNombreConductor() {
		return nombreConductor;
	}
	/**
	 * @param nombreConductor the nombreConductor to set
	 */
	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}
	
	/**
	 * @return the numeroSerie
	 */
	public String getVehiculoSerie() {
		return vehiculoSerie;
	}
	/**
	 * @param numeroSerie the numeroSerie to set
	 */
	public void setVehiculoSerie(String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}
		
	/**
	 * @return the placas
	 */
	public String getPlacas() {
		return placas;
	}
	/**
	 * @param placas the placas to set
	 */
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	@Override
	public String toString() {
		return "ReporteResumenAjus [reporte=" + reporte + ", claveAjustador="
				+ claveAjustador + ", fecha=" + fecha + ", ajustador="
				+ ajustador + ", codigoCausa=" + codigoCausa
				+ ", nombreAsgurado=" + nombreAsgurado +", nombreConductor=" + nombreConductor + ", telefono="
				+ telefono + ", poliza=" + poliza + ", estatusPoliza="
				+ estatusPoliza + ", marca=" + marca + ", correoAsegurado="
				+ correoAsegurado + ", inciso=" + inciso + ", modelo=" + modelo + ", numSerie=" + vehiculoSerie
				+ ", origenAsig=" + origenAsig + ", fechaAsig=" + fechaAsig
				+ ", usuarioAsig=" + usuarioAsig + ", servicioAmbulanciaAsig="
				+ servicioAmbulanciaAsig + ", proximidadAsig=" + proximidadAsig
				+ ", origenArribo=" + origenArribo + ", fechaArribo="
				+ fechaArribo + ", origenTermino=" + origenTermino
				+ ", fechaTermino=" + fechaTermino + ", observacionesTermino="
				+ observacionesTermino + ", responsabilidadTermino="
				+ responsabilidadTermino + ", descDaniosPreTermino="
				+ descDaniosPreTermino + ", terceros=" + terceros
				+ ", recuperos=" + recuperos + ", folio=" + folio + ", ruta="
				+ ruta + ", coberturas=" + coberturas + ", solicitarGrua="
				+ solicitarGrua + ", cobroBancario=" + cobroBancario
				+ ", datosRobos=" + datosRobos + ", abogados=" + abogados
				+ ", tercerosD=" + tercerosD + ", recuperoD=" + recuperoD
				+ ", solicitarFolioD=" + solicitarFolioD + ", coberturasD="
				+ coberturasD + ", solicitarGruaD=" + solicitarGruaD
				+ ", cobroBancarioD=" + cobroBancarioD + ", robosD=" + robosD
				+ ", abogadosD=" + abogadosD + "]";
	}
	
	
}
