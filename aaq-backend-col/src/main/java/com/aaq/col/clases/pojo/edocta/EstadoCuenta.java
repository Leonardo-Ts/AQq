package com.aaq.col.clases.pojo.edocta;

import java.util.List;

public class EstadoCuenta {
	
	private String textPoliza;
	private String textInciso;
	private String textEndoso;
	private AseguradoEdoCta asegurado;
	private VehiculoEdoCta vehiculo;
	private PolizaEdoCta poliza;
	private GeneralEdoCta general;
	private AgenteEdoCta agente;
	private List<ReciboEdoCta> recibos;
	private List<CoberturasEdoCta> coberturas;
	private List<SiniestroEdoCta> siniestros;
	private List<ReporteEdoCta> reportes;
	private List<EstimacionEdoCta> estimaciones;
	private List<EquipoEspecialEdoCta> equiposEspeciales;
	private List<AdaptacionEdoCta> adaptaciones;
	private List<CondicionEspecialEdoCta> condicionesEspeciales;
	private String deducibleAdm;
	private String msjAgente;
//	private String ultimoEndoso;
	private String comentario;
//	private List<String> infoDeducible;
	private String beneficiarioPrefe;
	private String conautoBTH;
	private String provAvq;
	private String cobDaniosMateriales;
	private String sumaAsegDaniosMat;
	private String codigoTarifa;
	private String inspeccionVeh;
	private String daniosPreexistentes;
	private List<String> listaDaniosPreExis;
	private String fechaInspeccion;
//	private List<TitulosCatEdoCta> catalogo;
	
	
	public GeneralEdoCta getGeneral() {
		return general;
	}
	public void setGeneral(GeneralEdoCta general) {
		this.general = general;
	}
	public AseguradoEdoCta getAsegurado() {
		return asegurado;
	}
	public void setAsegurado(AseguradoEdoCta asegurado) {
		this.asegurado = asegurado;
	}
	public PolizaEdoCta getPoliza() {
		return poliza;
	}
	public void setPoliza(PolizaEdoCta poliza) {
		this.poliza = poliza;
	}
	public AgenteEdoCta getAgente() {
		return agente;
	}
	public void setAgente(AgenteEdoCta agente) {
		this.agente = agente;
	}
	public List<ReciboEdoCta> getRecibos() {
		return recibos;
	}
	public void setRecibos(List<ReciboEdoCta> recibos) {
		this.recibos = recibos;
	}
	public VehiculoEdoCta getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(VehiculoEdoCta vehiculo) {
		this.vehiculo = vehiculo;
	}
	public List<CoberturasEdoCta> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<CoberturasEdoCta> coberturas) {
		this.coberturas = coberturas;
	}
	public String getTextPoliza() {
		return textPoliza;
	}
	public void setTextPoliza(String textPoliza) {
		this.textPoliza = textPoliza;
	}
	public String getTextInciso() {
		return textInciso;
	}
	public void setTextInciso(String textInciso) {
		this.textInciso = textInciso;
	}
	public String getTextEndoso() {
		return textEndoso;
	}
	public void setTextEndoso(String textEndoso) {
		this.textEndoso = textEndoso;
	}
	public List<SiniestroEdoCta> getSiniestros() {
		return siniestros;
	}
	public void setSiniestros(List<SiniestroEdoCta> siniestros) {
		this.siniestros = siniestros;
	}
	public List<ReporteEdoCta> getReportes() {
		return reportes;
	}
	public void setReportes(List<ReporteEdoCta> reportes) {
		this.reportes = reportes;
	}
	public List<EstimacionEdoCta> getEstimaciones() {
		return estimaciones;
	}
	public void setEstimaciones(List<EstimacionEdoCta> estimaciones) {
		this.estimaciones = estimaciones;
	}
	public List<EquipoEspecialEdoCta> getEquiposEspeciales() {
		return equiposEspeciales;
	}
	public void setEquiposEspeciales(List<EquipoEspecialEdoCta> equiposEspeciales) {
		this.equiposEspeciales = equiposEspeciales;
	}
	public List<AdaptacionEdoCta> getAdaptaciones() {
		return adaptaciones;
	}
	public void setAdaptaciones(List<AdaptacionEdoCta> adaptaciones) {
		this.adaptaciones = adaptaciones;
	}
	public List<CondicionEspecialEdoCta> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}
	public void setCondicionesEspeciales(List<CondicionEspecialEdoCta> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
	}
	public String getDeducibleAdm() {
		return deducibleAdm;
	}
	public void setDeducibleAdm(String deducibleAdm) {
		this.deducibleAdm = deducibleAdm;
	}
	public String getMsjAgente() {
		return msjAgente;
	}
	public void setMsjAgente(String msjAgente) {
		this.msjAgente = msjAgente;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
//	public List<String> getInfoDeducible() {
//		return infoDeducible;
//	}
//	public void setInfoDeducible(List<String> infoDeducible) {
//		this.infoDeducible = infoDeducible;
//	}
	public String getBeneficiarioPrefe() {
		return beneficiarioPrefe;
	}
	public void setBeneficiarioPrefe(String beneficiarioPrefe) {
		this.beneficiarioPrefe = beneficiarioPrefe;
	}
	public String getConautoBTH() {
		return conautoBTH;
	}
	public void setConautoBTH(String conautoBTH) {
		this.conautoBTH = conautoBTH;
	}
	public String getProvAvq() {
		return provAvq;
	}
	public void setProvAvq(String provAvq) {
		this.provAvq = provAvq;
	}
	public String getCobDaniosMateriales() {
		return cobDaniosMateriales;
	}
	public void setCobDaniosMateriales(String cobDaniosMateriales) {
		this.cobDaniosMateriales = cobDaniosMateriales;
	}
	public String getSumaAsegDaniosMat() {
		return sumaAsegDaniosMat;
	}
	public void setSumaAsegDaniosMat(String sumaAsegDaniosMat) {
		this.sumaAsegDaniosMat = sumaAsegDaniosMat;
	}
	public String getCodigoTarifa() {
		return codigoTarifa;
	}
	public void setCodigoTarifa(String codigoTarifa) {
		this.codigoTarifa = codigoTarifa;
	}
	public String getInspeccionVeh() {
		return inspeccionVeh;
	}
	public void setInspeccionVeh(String inspeccionVeh) {
		this.inspeccionVeh = inspeccionVeh;
	}
	public String getDaniosPreexistentes() {
		return daniosPreexistentes;
	}
	public void setDaniosPreexistentes(String daniosPreexistentes) {
		this.daniosPreexistentes = daniosPreexistentes;
	}
	public List<String> getListaDaniosPreExis() {
		return listaDaniosPreExis;
	}
	public void setListaDaniosPreExis(List<String> listaDaniosPreExis) {
		this.listaDaniosPreExis = listaDaniosPreExis;
	}
	public String getFechaInspeccion() {
		return fechaInspeccion;
	}
	public void setFechaInspeccion(String fechaInspeccion) {
		this.fechaInspeccion = fechaInspeccion;
	}
	
	
	

}
