package com.aaq.col.clases.webservices.movil;

import java.util.Date;

public class GETMovilServicioConsultaReporteSiniestroHistorico {
	private String usuario;

	private String passwd;

	private Date fechaInicio;

	private Date fechaFin;

	public GETMovilServicioConsultaReporteSiniestroHistorico() {
		super();

	}

	public GETMovilServicioConsultaReporteSiniestroHistorico(final String usuario, final String passwd,
			final Date fechaInicio, final Date fechaFin) {
		super();
		this.usuario = usuario;
		this.passwd = passwd;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


}
