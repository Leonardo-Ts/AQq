package com.aaq.col.clases.pojo.conclusion;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReporteResumenAjustN implements Serializable {
	

	private static final long serialVersionUID = 2365419838837035269L;
	
	
	private String ajustador;
	private String cedulaAjustador;
	private String narracion;
	private InputStream croquis;
	private String deslindeResponsabilidad;
	private String ruta;
	
	private String poliza;
	private String inciso;
	private String claveAgente;
	private String nombreAsegurado;
	private String nombreConductor;
	private String correoAsegurado;
	private String marca;
	private String modelo;
	private String vehiculoSerie;
	private String placas;
	private String color;
	
	private String codigoCausa;
	private Date fechaOcurrido;
	private String reporte;
	private String ubicacionSiniestro;
	private Date fechaAsig;
	private Date fechaArribo;
	private String colonia;
	private String ciudad;
	private Date fechaTermino;
	
	private String causaAccidente;
	private String responsabilidadTermino;
	private String docEntregados;
	private String deducibleRC;
	private String monto;
	
	private String servicioSolicitadoTaller;
	private String claveProveedorTaller;
	private String nombreProveedorTaller;
	
	// Grua
	private String codigoGrua;
	private String tipoAfectado;
	private String respuestaGruasColi;
	private Date fechaGrua;
	private String claveProveedor;
	private String proveedorNombre;
	
	//Pase Medico
	private String servicioSolicitado;
	private String nombreProveedor;
	private String nombreAfectado;
	private String ambulancia;
	
	private String docDua;
	private String docAdmAutos;
	private String docAsigAbogado;
	private String docEncuesta;
	private String docAdmEquipoP;

	// Abogados
	private Date fecha;

	private List<Coberturas> coberturas;
	private List<Reparacion> reparacion;
	private List<Grua> solicitarGrua;
	private List<PaseMedico> paseMedico;
	private List<Abogado> abogados;
	private List<GruaEquipoPesado> solicitarGruaEP;
	
	@SuppressWarnings("unused")
	private JRDataSource coberturasD;
	@SuppressWarnings("unused")
	private JRDataSource reparacionD;
	@SuppressWarnings("unused")
	private JRDataSource paseMedicoD;
	@SuppressWarnings("unused")
	private JRDataSource solicitarGruaD;
	@SuppressWarnings("unused")
	private JRDataSource abogadosD;
	@SuppressWarnings("unused")
	private JRDataSource solicitarGruaEPD;

	
	//Nuevos datos
	private InputStream firmaConductor;
	private String munDeleg;
	private String numSiniestro;
	private String nombreTitular;
	private InputStream firmaConductorT;
	
	
	public String getAjustador() {
		return ajustador;
	}
	public void setAjustador(String ajustador) {
		this.ajustador = ajustador;
	}
	public String getCedulaAjustador() {
		return cedulaAjustador;
	}
	public void setCedulaAjustador(String cedulaAjustador) {
		this.cedulaAjustador = cedulaAjustador;
	}
	public String getNarracion() {
		return narracion;
	}
	public void setNarracion(String narracion) {
		this.narracion = narracion;
	}
	
	public InputStream getCroquis() {
		return croquis;
	}
	public void setCroquis(InputStream croquis) {
		this.croquis = croquis;
	}
	public String getDeslindeResponsabilidad() {
		return deslindeResponsabilidad;
	}
	public void setDeslindeResponsabilidad(String deslindeResponsabilidad) {
		this.deslindeResponsabilidad = deslindeResponsabilidad;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
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
	
	public List<Coberturas> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<Coberturas> coberturas) {
		this.coberturas = coberturas;
	}
	
///*******************JRBeanCollectionDataSource*************************/
	public JRDataSource getCoberturasD() {
		return new JRBeanCollectionDataSource(this.coberturas);
	}
	public void setCoberturasD(JRDataSource coberturasD) {
		this.coberturasD = coberturasD;
	}
	
	public JRDataSource getReparacionD() {
		return new JRBeanCollectionDataSource(this.reparacion);
	}
	public void setReparacionD(JRDataSource reparacionD) {
		this.reparacionD = reparacionD;
	}
	
	public JRDataSource getPaseMedicoD() {
		return new JRBeanCollectionDataSource(this.paseMedico);
	}
	public void setPaseMedicoD(JRDataSource paseMedicoD) {
		this.paseMedicoD = paseMedicoD;
	}
	
	public JRDataSource getSolicitarGruaD() {
		return new JRBeanCollectionDataSource(this.solicitarGrua);
	}
	public void setSolicitarGruaD(JRDataSource solicitarGruaD) {
		this.solicitarGruaD = solicitarGruaD;
	}
	
	public JRDataSource getAbogadosD() {
		return new JRBeanCollectionDataSource(this.abogados);
	}
	public void setAbogadosD(JRDataSource abogadosD) {
		this.abogadosD = abogadosD;
	}
	public JRDataSource getSolicitarGruaEPD() {
		return new JRBeanCollectionDataSource(this.solicitarGruaEP);
	}
	public void setSolicitarGruaEPD(JRDataSource solicitarGruaEPD) {
		this.solicitarGruaEPD = solicitarGruaEPD;
	}
	
	
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getInciso() {
		return inciso;
	}
	public void setInciso(String inciso) {
		this.inciso = inciso;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getVehiculoSerie() {
		return vehiculoSerie;
	}
	public void setVehiculoSerie(String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCodigoCausa() {
		return codigoCausa;
	}
	public void setCodigoCausa(String codigoCausa) {
		this.codigoCausa = codigoCausa;
	}
	public Date getFechaOcurrido() {
		return fechaOcurrido;
	}
	public void setFechaOcurrido(Date fechaOcurrido) {
		this.fechaOcurrido = fechaOcurrido;
	}
	public String getReporte() {
		return reporte;
	}
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	public String getUbicacionSiniestro() {
		return ubicacionSiniestro;
	}
	public void setUbicacionSiniestro(String ubicacionSiniestro) {
		this.ubicacionSiniestro = ubicacionSiniestro;
	}
	public Date getFechaAsig() {
		return fechaAsig;
	}
	public void setFechaAsig(Date fechaAsig) {
		this.fechaAsig = fechaAsig;
	}
	public Date getFechaArribo() {
		return fechaArribo;
	}
	public void setFechaArribo(Date fechaArribo) {
		this.fechaArribo = fechaArribo;
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
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
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
	public String getDocEntregados() {
		return docEntregados;
	}
	public void setDocEntregados(String docEntregados) {
		this.docEntregados = docEntregados;
	}
	public String getDeducibleRC() {
		return deducibleRC;
	}
	public void setDeducibleRC(String deducibleRC) {
		this.deducibleRC = deducibleRC;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getServicioSolicitadoTaller() {
		return servicioSolicitadoTaller;
	}
	public void setServicioSolicitadoTaller(String servicioSolicitadoTaller) {
		this.servicioSolicitadoTaller = servicioSolicitadoTaller;
	}
	public String getClaveProveedorTaller() {
		return claveProveedorTaller;
	}
	public void setClaveProveedorTaller(String claveProveedorTaller) {
		this.claveProveedorTaller = claveProveedorTaller;
	}
	public String getNombreProveedorTaller() {
		return nombreProveedorTaller;
	}
	public void setNombreProveedorTaller(String nombreProveedorTaller) {
		this.nombreProveedorTaller = nombreProveedorTaller;
	}
	public String getCodigoGrua() {
		return codigoGrua;
	}
	public void setCodigoGrua(String codigoGrua) {
		this.codigoGrua = codigoGrua;
	}
	public String getTipoAfectado() {
		return tipoAfectado;
	}
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}
	public String getRespuestaGruasColi() {
		return respuestaGruasColi;
	}
	public void setRespuestaGruasColi(String respuestaGruasColi) {
		this.respuestaGruasColi = respuestaGruasColi;
	}
	public Date getFechaGrua() {
		return fechaGrua;
	}
	public void setFechaGrua(Date fechaGrua) {
		this.fechaGrua = fechaGrua;
	}
	public String getClaveProveedor() {
		return claveProveedor;
	}
	public void setClaveProveedor(String claveProveedor) {
		this.claveProveedor = claveProveedor;
	}
	public String getProveedorNombre() {
		return proveedorNombre;
	}
	public void setProveedorNombre(String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}
	public String getServicioSolicitado() {
		return servicioSolicitado;
	}
	public void setServicioSolicitado(String servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getNombreAfectado() {
		return nombreAfectado;
	}
	public void setNombreAfectado(String nombreAfectado) {
		this.nombreAfectado = nombreAfectado;
	}
	public String getAmbulancia() {
		return ambulancia;
	}
	public void setAmbulancia(String ambulancia) {
		this.ambulancia = ambulancia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public InputStream getFirmaConductor() {
		return firmaConductor;
	}
	public void setFirmaConductor(InputStream firmaConductor) {
		this.firmaConductor = firmaConductor;
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
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public InputStream getFirmaConductorT() {
		return firmaConductorT;
	}
	public void setFirmaConductorT(InputStream firmaConductorT) {
		this.firmaConductorT = firmaConductorT;
	}
	public String getDocDua() {
		return docDua;
	}
	public void setDocDua(String docDua) {
		this.docDua = docDua;
	}
	public String getDocAdmAutos() {
		return docAdmAutos;
	}
	public void setDocAdmAutos(String docAdmAutos) {
		this.docAdmAutos = docAdmAutos;
	}
	public String getDocAsigAbogado() {
		return docAsigAbogado;
	}
	public void setDocAsigAbogado(String docAsigAbogado) {
		this.docAsigAbogado = docAsigAbogado;
	}
	public String getDocEncuesta() {
		return docEncuesta;
	}
	public void setDocEncuesta(String docEncuesta) {
		this.docEncuesta = docEncuesta;
	}
	public String getDocAdmEquipoP() {
		return docAdmEquipoP;
	}
	public void setDocAdmEquipoP(String docAdmEquipoP) {
		this.docAdmEquipoP = docAdmEquipoP;
	}
	public List<GruaEquipoPesado> getSolicitarGruaEP() {
		return solicitarGruaEP;
	}
	public void setSolicitarGruaEP(List<GruaEquipoPesado> solicitarGruaEP) {
		this.solicitarGruaEP = solicitarGruaEP;
	}
	
	
	
	
	
	

}
