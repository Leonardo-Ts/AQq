package com.aaq.col.clases.webservices.formatos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormatoSolicitudDiagnostico {
	private String sd_Num_Reporte;
	private String sd_Fecha;
	private String sd_Num_Poliza;
	private String sd_Num_Endoso;
	private String sd_Num_Inciso;
	private String sd_Num_Siniestro;
	private String sd_Nom_Cliente;
	private String sd_Email_Cliente;
	private String sd_Tel_Cliente;
	private String sd_Razon_Envio;
	private String sd_Razon_Responsable;
	private String sd_Razon_Telefono;
	private String sd_Razon_Domicilio;
	private String sd_Razon_Cobertura;
	private String sd_Marca_Auto;
	private String sd_Tipo_Auto;
	private String sd_Modelo_Auto;
	private String sd_Kilometraje_Auto;
	private String sd_Num_Serie;
	private String sd_Color_Auto;
	private String sd_Placa_Auto;
	private String sd_Transmision;
	private String sd_Danios_Unidad;
	private String sd_Descripcion_Danios;
	private String sd_Danios_Pre;
	private String sd_Nom_Ajustador;
	private String sd_Clave_Ajustador;
	private String check_1;
	private String check_2;
	private String check_3;
	private String check_4;
	private String firma_Ajustador;
	private String firma_Asegurado;
	private String sd_Otro;
	private String sd_Nivel_Inundacion;
	private String sd_Descripcion_Danios_Pre;
	private String correo_oculto;
    private String fuente_ws;
    private String check_5;
	private String check_6;
	

	
	public String getCheck_5() {
		return check_5;
	}

	public void setCheck_5(String check_5) {
		this.check_5 = check_5;
	}

	public String getCheck_6() {
		return check_6;
	}

	public void setCheck_6(String check_6) {
		this.check_6 = check_6;
	}
	

	public String getFuente_ws() {
		return fuente_ws;
	}

	public void setFuente_ws(String fuente_ws) {
		this.fuente_ws = fuente_ws;
	}
	
	
	
	public String getCorreo_oculto() {
		return correo_oculto;
	}

	public void setCorreo_oculto(String correo_oculto) {
		this.correo_oculto = correo_oculto;
	}
	
	/**
	 * 
	 */
	public FormatoSolicitudDiagnostico() {
		super();
	}

	

	/**
	 * @return the sd_Num_Reporte
	 */
	public String getSd_Num_Reporte() {
		return sd_Num_Reporte;
	}

	/**
	 * @param sd_Num_Reporte the sd_Num_Reporte to set
	 */
	public void setSd_Num_Reporte(String sd_Num_Reporte) {
		this.sd_Num_Reporte = sd_Num_Reporte;
	}

	/**
	 * @return the sd_Fecha
	 */
	public String getSd_Fecha() {
		return sd_Fecha;
	}

	/**
	 * @param sd_Fecha the sd_Fecha to set
	 */
	public void setSd_Fecha(String sd_Fecha) {
		this.sd_Fecha = sd_Fecha;
	}

	/**
	 * @return the sd_Num_Poliza
	 */
	public String getSd_Num_Poliza() {
		return sd_Num_Poliza;
	}

	/**
	 * @param sd_Num_Poliza the sd_Num_Poliza to set
	 */
	public void setSd_Num_Poliza(String sd_Num_Poliza) {
		this.sd_Num_Poliza = sd_Num_Poliza;
	}

	/**
	 * @return the sd_Num_Endoso
	 */
	public String getSd_Num_Endoso() {
		return sd_Num_Endoso;
	}

	/**
	 * @param sd_Num_Endoso the sd_Num_Endoso to set
	 */
	public void setSd_Num_Endoso(String sd_Num_Endoso) {
		this.sd_Num_Endoso = sd_Num_Endoso;
	}

	/**
	 * @return the sd_Num_Inciso
	 */
	public String getSd_Num_Inciso() {
		return sd_Num_Inciso;
	}

	/**
	 * @param sd_Num_Inciso the sd_Num_Inciso to set
	 */
	public void setSd_Num_Inciso(String sd_Num_Inciso) {
		this.sd_Num_Inciso = sd_Num_Inciso;
	}

	/**
	 * @return the sd_Num_Siniestro
	 */
	public String getSd_Num_Siniestro() {
		return sd_Num_Siniestro;
	}

	/**
	 * @param sd_Num_Siniestro the sd_Num_Siniestro to set
	 */
	public void setSd_Num_Siniestro(String sd_Num_Siniestro) {
		this.sd_Num_Siniestro = sd_Num_Siniestro;
	}

	/**
	 * @return the sd_Nom_Cliente
	 */
	public String getSd_Nom_Cliente() {
		return sd_Nom_Cliente;
	}

	/**
	 * @param sd_Nom_Cliente the sd_Nom_Cliente to set
	 */
	public void setSd_Nom_Cliente(String sd_Nom_Cliente) {
		this.sd_Nom_Cliente = sd_Nom_Cliente;
	}

	/**
	 * @return the sd_Email_Cliente
	 */
	public String getSd_Email_Cliente() {
		return sd_Email_Cliente;
	}

	/**
	 * @param sd_Email_Cliente the sd_Email_Cliente to set
	 */
	public void setSd_Email_Cliente(String sd_Email_Cliente) {
		this.sd_Email_Cliente = sd_Email_Cliente;
	}

	/**
	 * @return the sd_Tel_Cliente
	 */
	public String getSd_Tel_Cliente() {
		return sd_Tel_Cliente;
	}

	/**
	 * @param sd_Tel_Cliente the sd_Tel_Cliente to set
	 */
	public void setSd_Tel_Cliente(String sd_Tel_Cliente) {
		this.sd_Tel_Cliente = sd_Tel_Cliente;
	}

	/**
	 * @return the sd_Razon_Envio
	 */
	public String getSd_Razon_Envio() {
		return sd_Razon_Envio;
	}

	/**
	 * @param sd_Razon_Envio the sd_Razon_Envio to set
	 */
	public void setSd_Razon_Envio(String sd_Razon_Envio) {
		this.sd_Razon_Envio = sd_Razon_Envio;
	}

	/**
	 * @return the sd_Razon_Responsable
	 */
	public String getSd_Razon_Responsable() {
		return sd_Razon_Responsable;
	}

	/**
	 * @param sd_Razon_Responsable the sd_Razon_Responsable to set
	 */
	public void setSd_Razon_Responsable(String sd_Razon_Responsable) {
		this.sd_Razon_Responsable = sd_Razon_Responsable;
	}

	/**
	 * @return the sd_Razon_Telefono
	 */
	public String getSd_Razon_Telefono() {
		return sd_Razon_Telefono;
	}

	/**
	 * @param sd_Razon_Telefono the sd_Razon_Telefono to set
	 */
	public void setSd_Razon_Telefono(String sd_Razon_Telefono) {
		this.sd_Razon_Telefono = sd_Razon_Telefono;
	}

	/**
	 * @return the sd_Razon_Domicilio
	 */
	public String getSd_Razon_Domicilio() {
		return sd_Razon_Domicilio;
	}

	/**
	 * @param sd_Razon_Domicilio the sd_Razon_Domicilio to set
	 */
	public void setSd_Razon_Domicilio(String sd_Razon_Domicilio) {
		this.sd_Razon_Domicilio = sd_Razon_Domicilio;
	}

	/**
	 * @return the sd_Razon_Cobertura
	 */
	public String getSd_Razon_Cobertura() {
		return sd_Razon_Cobertura;
	}

	/**
	 * @param sd_Razon_Cobertura the sd_Razon_Cobertura to set
	 */
	public void setSd_Razon_Cobertura(String sd_Razon_Cobertura) {
		this.sd_Razon_Cobertura = sd_Razon_Cobertura;
	}

	/**
	 * @return the sd_Marca_Auto
	 */
	public String getSd_Marca_Auto() {
		return sd_Marca_Auto;
	}

	/**
	 * @param sd_Marca_Auto the sd_Marca_Auto to set
	 */
	public void setSd_Marca_Auto(String sd_Marca_Auto) {
		this.sd_Marca_Auto = sd_Marca_Auto;
	}

	/**
	 * @return the sd_Tipo_Auto
	 */
	public String getSd_Tipo_Auto() {
		return sd_Tipo_Auto;
	}

	/**
	 * @param sd_Tipo_Auto the sd_Tipo_Auto to set
	 */
	public void setSd_Tipo_Auto(String sd_Tipo_Auto) {
		this.sd_Tipo_Auto = sd_Tipo_Auto;
	}

	/**
	 * @return the sd_Modelo_Auto
	 */
	public String getSd_Modelo_Auto() {
		return sd_Modelo_Auto;
	}

	/**
	 * @param sd_Modelo_Auto the sd_Modelo_Auto to set
	 */
	public void setSd_Modelo_Auto(String sd_Modelo_Auto) {
		this.sd_Modelo_Auto = sd_Modelo_Auto;
	}

	/**
	 * @return the sd_Kilometraje_Auto
	 */
	public String getSd_Kilometraje_Auto() {
		return sd_Kilometraje_Auto;
	}

	/**
	 * @param sd_Kilometraje_Auto the sd_Kilometraje_Auto to set
	 */
	public void setSd_Kilometraje_Auto(String sd_Kilometraje_Auto) {
		this.sd_Kilometraje_Auto = sd_Kilometraje_Auto;
	}

	/**
	 * @return the sd_Num_Serie
	 */
	public String getSd_Num_Serie() {
		return sd_Num_Serie;
	}

	/**
	 * @param sd_Num_Serie the sd_Num_Serie to set
	 */
	public void setSd_Num_Serie(String sd_Num_Serie) {
		this.sd_Num_Serie = sd_Num_Serie;
	}

	/**
	 * @return the sd_Color_Auto
	 */
	public String getSd_Color_Auto() {
		return sd_Color_Auto;
	}

	/**
	 * @param sd_Color_Auto the sd_Color_Auto to set
	 */
	public void setSd_Color_Auto(String sd_Color_Auto) {
		this.sd_Color_Auto = sd_Color_Auto;
	}

	/**
	 * @return the sd_Placa_Auto
	 */
	public String getSd_Placa_Auto() {
		return sd_Placa_Auto;
	}

	/**
	 * @param sd_Placa_Auto the sd_Placa_Auto to set
	 */
	public void setSd_Placa_Auto(String sd_Placa_Auto) {
		this.sd_Placa_Auto = sd_Placa_Auto;
	}

	/**
	 * @return the sd_Transmision
	 */
	public String getSd_Transmision() {
		return sd_Transmision;
	}

	/**
	 * @param sd_Transmision the sd_Transmision to set
	 */
	public void setSd_Transmision(String sd_Transmision) {
		this.sd_Transmision = sd_Transmision;
	}

	/**
	 * @return the sd_Danios_Unidad
	 */
	public String getSd_Danios_Unidad() {
		return sd_Danios_Unidad;
	}

	/**
	 * @param sd_Danios_Unidad the sd_Danios_Unidad to set
	 */
	public void setSd_Danios_Unidad(String sd_Danios_Unidad) {
		this.sd_Danios_Unidad = sd_Danios_Unidad;
	}

	/**
	 * @return the sd_Descripcion_Danios
	 */
	public String getSd_Descripcion_Danios() {
		return sd_Descripcion_Danios;
	}

	/**
	 * @param sd_Descripcion_Danios the sd_Descripcion_Danios to set
	 */
	public void setSd_Descripcion_Danios(String sd_Descripcion_Danios) {
		this.sd_Descripcion_Danios = sd_Descripcion_Danios;
	}

	/**
	 * @return the sd_Danios_Pre
	 */
	public String getSd_Danios_Pre() {
		return sd_Danios_Pre;
	}

	/**
	 * @param sd_Danios_Pre the sd_Danios_Pre to set
	 */
	public void setSd_Danios_Pre(String sd_Danios_Pre) {
		this.sd_Danios_Pre = sd_Danios_Pre;
	}

	/**
	 * @return the sd_Nom_Ajustador
	 */
	public String getSd_Nom_Ajustador() {
		return sd_Nom_Ajustador;
	}

	/**
	 * @param sd_Nom_Ajustador the sd_Nom_Ajustador to set
	 */
	public void setSd_Nom_Ajustador(String sd_Nom_Ajustador) {
		this.sd_Nom_Ajustador = sd_Nom_Ajustador;
	}

	/**
	 * @return the sd_Clave_Ajustador
	 */
	public String getSd_Clave_Ajustador() {
		return sd_Clave_Ajustador;
	}

	/**
	 * @param sd_Clave_Ajustador the sd_Clave_Ajustador to set
	 */
	public void setSd_Clave_Ajustador(String sd_Clave_Ajustador) {
		this.sd_Clave_Ajustador = sd_Clave_Ajustador;
	}

	/**
	 * @return the check_1
	 */
	public String getCheck_1() {
		return check_1;
	}

	/**
	 * @param check_1 the check_1 to set
	 */
	public void setCheck_1(String check_1) {
		this.check_1 = check_1;
	}

	/**
	 * @return the check_2
	 */
	public String getCheck_2() {
		return check_2;
	}

	/**
	 * @param check_2 the check_2 to set
	 */
	public void setCheck_2(String check_2) {
		this.check_2 = check_2;
	}

	/**
	 * @return the check_3
	 */
	public String getCheck_3() {
		return check_3;
	}

	/**
	 * @param check_3 the check_3 to set
	 */
	public void setCheck_3(String check_3) {
		this.check_3 = check_3;
	}

	/**
	 * @return the check_4
	 */
	public String getCheck_4() {
		return check_4;
	}

	/**
	 * @param check_4 the check_4 to set
	 */
	public void setCheck_4(String check_4) {
		this.check_4 = check_4;
	}

	/**
	 * @return the firma_Ajustador
	 */
	public String getFirma_Ajustador() {
		return firma_Ajustador;
	}

	/**
	 * @param firma_Ajustador the firma_Ajustador to set
	 */
	public void setFirma_Ajustador(String firma_Ajustador) {
		this.firma_Ajustador = firma_Ajustador;
	}

	/**
	 * @return the firma_Asegurado
	 */
	public String getFirma_Asegurado() {
		return firma_Asegurado;
	}

	/**
	 * @param firma_Asegurado the firma_Asegurado to set
	 */
	public void setFirma_Asegurado(String firma_Asegurado) {
		this.firma_Asegurado = firma_Asegurado;
	}

	/**
	 * @return the sd_Otro
	 */
	public String getSd_Otro() {
		return sd_Otro;
	}

	/**
	 * @param sd_Otro the sd_Otro to set
	 */
	public void setSd_Otro(String sd_Otro) {
		this.sd_Otro = sd_Otro;
	}

	/**
	 * @return the sd_Nivel_Inundacion
	 */
	public String getSd_Nivel_Inundacion() {
		return sd_Nivel_Inundacion;
	}

	/**
	 * @param sd_Nivel_Inundacion the sd_Nivel_Inundacion to set
	 */
	public void setSd_Nivel_Inundacion(String sd_Nivel_Inundacion) {
		this.sd_Nivel_Inundacion = sd_Nivel_Inundacion;
	}

	/**
	 * @return the sd_Descripcion_Danios_Pre
	 */
	public String getSd_Descripcion_Danios_Pre() {
		return sd_Descripcion_Danios_Pre;
	}

	/**
	 * @param sd_Descripcion_Danios_Pre the sd_Descripcion_Danios_Pre to set
	 */
	public void setSd_Descripcion_Danios_Pre(String sd_Descripcion_Danios_Pre) {
		this.sd_Descripcion_Danios_Pre = sd_Descripcion_Danios_Pre;
	}
}

