package com.aaq.col.clases.pojo.aaq;

import java.util.List;

public class FotografiasReg {

	private String usuario;
	private String pwd;
	private String numReporte;
	private List<DatosFotos> datosFotos;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNumReporte() {
		return numReporte;
	}
	public void setNumReporte(String numReporte) {
		this.numReporte = numReporte;
	}
	public List<DatosFotos> getDatosFotos() {
		return datosFotos;
	}
	public void setDatosFotos(List<DatosFotos> datosFotos) {
		this.datosFotos = datosFotos;
	}
	
	
	
}
