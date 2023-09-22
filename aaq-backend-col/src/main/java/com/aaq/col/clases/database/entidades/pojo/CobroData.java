package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.Date;

public class CobroData implements Serializable {

	private static final long serialVersionUID = 2141816509586341508L;

	private Date fecha;
	private String tipoCobro;
	private String monto;
	private String mesesSinIntereses;
	private String coberturaAfectada;
	private String estatus;
	private String numeroAutorizacion;
	private String numeroOperacion;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoCobro() {
		return tipoCobro;
	}
	public void setTipoCobro(String tipoCobro) {
		this.tipoCobro = tipoCobro;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getMesesSinIntereses() {
		return mesesSinIntereses;
	}
	public void setMesesSinIntereses(String mesesSinIntereses) {
		this.mesesSinIntereses = mesesSinIntereses;
	}
	public String getCoberturaAfectada() {
		return coberturaAfectada;
	}
	public void setCoberturaAfectada(String coberturaAfectada) {
		this.coberturaAfectada = coberturaAfectada;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}
	public String getNumeroOperacion() {
		return numeroOperacion;
	}
	public void setNumeroOperacion(String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

}
