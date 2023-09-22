package com.aaq.col.clases.database.entidades.pojo;
import java.io.Serializable;
import java.util.Date;

public class Cobertura implements Serializable{

	private static final long serialVersionUID = 3102435863546899805L;
	
	private Date fecha;
	private String decClaveCobertura;
	private String monto;
	private String claveCobertura;	
	
	public String getDecClaveCobertura() {
		return decClaveCobertura;
	}
	public void setDecClaveCobertura(String decClaveCobertura) {
		this.decClaveCobertura = decClaveCobertura;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getClaveCobertura() {
		return claveCobertura;
	}
	public void setClaveCobertura(String claveCobertura) {
		this.claveCobertura = claveCobertura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
