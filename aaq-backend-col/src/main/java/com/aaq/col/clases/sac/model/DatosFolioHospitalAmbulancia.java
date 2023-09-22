package com.aaq.col.clases.sac.model;

import com.aaq.col.clases.webservices.movil.peticion.MovilDatosAsegurado;

public class DatosFolioHospitalAmbulancia {

	private String reporte;
	private MovilDatosAsegurado movilDatosAsegurado;
	private String edadTercero;
	private String numeroTercero;
	private String tipoTercero;
	private String sexoTercero;
	private AsignacionProveedorLesionadoSac lesionadoTercero;
	private String telefonoTercero;
	private String atencion;
	private String correoTercero;
	private String cobertura;
	private String montoMedico;
	private String idObjeto;
	
	private String folioAMIS;
	private String nombreAjustadorTercero;
	private String polizaTercero;
	private String incisoPolizaTercero;
	
	
	/**
	 * 
	 */
	public DatosFolioHospitalAmbulancia() {
		super();
	}

	/**
	 * @param reporte
	 * @param movilDatosAsegurado
	 * @param edadTercero
	 * @param numeroTercero
	 * @param tipoTercero
	 * @param sexoTercero
	 * @param lesionadoTercero
	 * @param telefonoTercero
	 * @param atencion
	 * @param correoTercero
	 */
	public DatosFolioHospitalAmbulancia(String reporte, MovilDatosAsegurado movilDatosAsegurado,
			String edadTercero, String numeroTercero, String tipoTercero, String sexoTercero,
			AsignacionProveedorLesionadoSac lesionadoTercero,
			String telefonoTercero, String atencion, String correoTercero, String folioAMIS,
			String nombreAjustadorTercero, String polizaTercero, String incisoPolizaTercero) {
		super();
		this.reporte = reporte;
		this.movilDatosAsegurado = movilDatosAsegurado;
		this.edadTercero = edadTercero;
		this.numeroTercero = numeroTercero;
		this.tipoTercero = tipoTercero;
		this.sexoTercero = sexoTercero;
		this.lesionadoTercero = lesionadoTercero;
		this.telefonoTercero = telefonoTercero;
		this.atencion = atencion;
		this.correoTercero = correoTercero;
		this.folioAMIS = folioAMIS;
		this.nombreAjustadorTercero = nombreAjustadorTercero;
		this.polizaTercero = polizaTercero;
		this.incisoPolizaTercero = incisoPolizaTercero;
	}
	
	/**
	 * @return the reporte
	 */
	public String getReporte() {
		return reporte;
	}
	/**
	 * @param reporte the reporte to set
	 */
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	/**
	 * 
	 * @return edadTercero
	 */
	public String getEdadTercero() {
		return edadTercero;
	}
	/**
	 * 
	 * @param edadTercero the edadTercero to set
	 */
	public void setEdadTercero(String edadTercero) {
		this.edadTercero = edadTercero;
	}
	/**
	 * 
	 * @return movilDatosAsegurado
	 */
	public MovilDatosAsegurado getMovilDatosAsegurado() {
		return movilDatosAsegurado;
	}
	/**
	 * 
	 * @param movilDatosAsegurado the movilDatosAsegurado to set
	 */
	public void setMovilDatosAsegurado(MovilDatosAsegurado movilDatosAsegurado) {
		this.movilDatosAsegurado = movilDatosAsegurado;
	}
	/**
	 * @return the numeroTercero
	 */
	public String getNumeroTercero() {
		return numeroTercero;
	}
	/**
	 * @param numeroTercero the numeroTercero to set
	 */
	public void setNumeroTercero(String numeroTercero) {
		this.numeroTercero = numeroTercero;
	}
	/**
	 * @return the tipoTercero
	 */
	public String getTipoTercero() {
		return tipoTercero;
	}
	/**
	 * @param tipoTercero the tipoTercero to set
	 */
	public void setTipoTercero(String tipoTercero) {
		this.tipoTercero = tipoTercero;
	}
	/**
	 * @return the sexoTercero
	 */
	public String getSexoTercero() {
		return sexoTercero;
	}
	/**
	 * @param sexoTercero the sexoTercero to set
	 */
	public void setSexoTercero(String sexoTercero) {
		this.sexoTercero = sexoTercero;
	}
	/**
	 * @return the lesionadoTercero
	 */
	public AsignacionProveedorLesionadoSac getLesionadoTercero() {
		return lesionadoTercero;
	}
	/**
	 * @param lesionadoTercero the lesionadoTercero to set
	 */
	public void setLesionadoTercero(AsignacionProveedorLesionadoSac lesionadoTercero) {
		this.lesionadoTercero = lesionadoTercero;
	}
	/**
	 * @return the telefonoTercero
	 */
	public String getTelefonoTercero() {
		return telefonoTercero;
	}
	/**
	 * @param telefonoTercero the telefonoTercero to set
	 */
	public void setTelefonoTercero(String telefonoTercero) {
		this.telefonoTercero = telefonoTercero;
	}
	/**
	 * @return the atencion
	 */
	public String getAtencion() {
		return atencion;
	}
	/**
	 * @param atencion the atencion to set
	 */
	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}
	/**
	 * @return the correoTercero
	 */
	public String getCorreoTercero() {
		return correoTercero;
	}
	/**
	 * @param correoTercero the correoTercero to set
	 */
	public void setCorreoTercero(String correoTercero) {
		this.correoTercero = correoTercero;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getMontoMedico() {
		return montoMedico;
	}

	public void setMontoMedico(String montoMedico) {
		this.montoMedico = montoMedico;
	}

	public String getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getFolioAMIS() {
		return folioAMIS;
	}

	public void setFolioAMIS(String folioAMIS) {
		this.folioAMIS = folioAMIS;
	}

	public String getNombreAjustadorTercero() {
		return nombreAjustadorTercero;
	}

	public void setNombreAjustadorTercero(String nombreAjustadorTercero) {
		this.nombreAjustadorTercero = nombreAjustadorTercero;
	}

	public String getPolizaTercero() {
		return polizaTercero;
	}

	public void setPolizaTercero(String polizaTercero) {
		this.polizaTercero = polizaTercero;
	}

	public String getIncisoPolizaTercero() {
		return incisoPolizaTercero;
	}

	public void setIncisoPolizaTercero(String incisoPolizaTercero) {
		this.incisoPolizaTercero = incisoPolizaTercero;
	}
	
	
}
