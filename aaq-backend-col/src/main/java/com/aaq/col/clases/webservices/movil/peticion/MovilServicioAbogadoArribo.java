package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioAbogadoArribo {
	private String usuario;

	private String passwd;

	private String numeroReporte;

	private String fechaHora;

	public MovilServicioAbogadoArribo() {
		super();

	}

	public MovilServicioAbogadoArribo(final String usuario, final String passwd, final String numeroReporte,
			final String fechaHora) {
		super();
		this.usuario = usuario;
		this.passwd = passwd;
		this.numeroReporte = numeroReporte;
		this.fechaHora = fechaHora;
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

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	
}
