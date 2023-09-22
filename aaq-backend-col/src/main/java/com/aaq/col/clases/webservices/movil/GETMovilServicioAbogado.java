package com.aaq.col.clases.webservices.movil;

public class GETMovilServicioAbogado {
	private String usuario;

	private String passwd;

	private String numeroReporte;

	private Boolean conductorDetenido;

	private Boolean vehiculoDetenido;

	private Integer numeroLesionadosNA;

	private Integer numeroLesionadosTS;

	private Integer numeroMuertosNA;

	private Integer numeroMuertosTS;

	private String lugarAPresentarse;

	public GETMovilServicioAbogado() {
		super();
	}

	public GETMovilServicioAbogado(final String usuario, final String passwd, final String numeroReporte,
			final Boolean conductorDetenido, final Boolean vehiculoDetenido, final Integer numeroLesionadosNA,
			final Integer numeroLesionadosTS, final Integer numeroMuertosNA, final Integer numeroMuertosTS,
			final String lugarAPresentarse) {
		super();
		this.usuario = usuario;
		this.passwd = passwd;
		this.numeroReporte = numeroReporte;
		this.conductorDetenido = conductorDetenido;
		this.vehiculoDetenido = vehiculoDetenido;
		this.numeroLesionadosNA = numeroLesionadosNA;
		this.numeroLesionadosTS = numeroLesionadosTS;
		this.numeroMuertosNA = numeroMuertosNA;
		this.numeroMuertosTS = numeroMuertosTS;
		this.lugarAPresentarse = lugarAPresentarse;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNumeroReporte() {
		return numeroReporte;
	}

	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	public Boolean getConductorDetenido() {
		return conductorDetenido;
	}

	public void setConductorDetenido(Boolean conductorDetenido) {
		this.conductorDetenido = conductorDetenido;
	}

	public Boolean getVehiculoDetenido() {
		return vehiculoDetenido;
	}

	public void setVehiculoDetenido(Boolean vehiculoDetenido) {
		this.vehiculoDetenido = vehiculoDetenido;
	}

	public Integer getNumeroLesionadosNA() {
		return numeroLesionadosNA;
	}

	public void setNumeroLesionadosNA(Integer numeroLesionadosNA) {
		this.numeroLesionadosNA = numeroLesionadosNA;
	}

	public Integer getNumeroLesionadosTS() {
		return numeroLesionadosTS;
	}

	public void setNumeroLesionadosTS(Integer numeroLesionadosTS) {
		this.numeroLesionadosTS = numeroLesionadosTS;
	}

	public Integer getNumeroMuertosNA() {
		return numeroMuertosNA;
	}

	public void setNumeroMuertosNA(Integer numeroMuertosNA) {
		this.numeroMuertosNA = numeroMuertosNA;
	}

	public Integer getNumeroMuertosTS() {
		return numeroMuertosTS;
	}

	public void setNumeroMuertosTS(Integer numeroMuertosTS) {
		this.numeroMuertosTS = numeroMuertosTS;
	}

	public String getLugarAPresentarse() {
		return lugarAPresentarse;
	}

	public void setLugarAPresentarse(String lugarAPresentarse) {
		this.lugarAPresentarse = lugarAPresentarse;
	}

	

}
