package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;

public class Cobro implements Serializable {

	private static final long serialVersionUID = -4764320868584622945L;

	private String tipoCobro;
	private String monto;
	private String mesesSinIntereses;
	private String coberturaAfectada;
	
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
}
