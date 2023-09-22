package com.aaq.col.clases.webservices.movil;

public class GETMovilServicioArca {
	private String usuario;

	private String passwd;

	private String lesionados;

	private Integer num;

	private Integer vehiculosImplicados;

	private Boolean Dpa;

	private String obra;

	private String descripcionHechos;

	private Boolean turnadoLegal;

	private Double montoDanos;

	private Boolean mediosComunicacion;

	private String reporte;

	public GETMovilServicioArca() {
		super();

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

	public String getLesionados() {
		return lesionados;
	}

	public void setLesionados(String lesionados) {
		this.lesionados = lesionados;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getVehiculosImplicados() {
		return vehiculosImplicados;
	}

	public void setVehiculosImplicados(Integer vehiculosImplicados) {
		this.vehiculosImplicados = vehiculosImplicados;
	}

	public Boolean getDpa() {
		return Dpa;
	}

	public void setDpa(Boolean dpa) {
		Dpa = dpa;
	}

	public String getObra() {
		return obra;
	}

	public void setObra(String obra) {
		this.obra = obra;
	}

	public String getDescripcionHechos() {
		return descripcionHechos;
	}

	public void setDescripcionHechos(String descripcionHechos) {
		this.descripcionHechos = descripcionHechos;
	}

	public Boolean getTurnadoLegal() {
		return turnadoLegal;
	}

	public void setTurnadoLegal(Boolean turnadoLegal) {
		this.turnadoLegal = turnadoLegal;
	}

	public Double getMontoDanos() {
		return montoDanos;
	}

	public void setMontoDanos(Double montoDanos) {
		this.montoDanos = montoDanos;
	}

	public Boolean getMediosComunicacion() {
		return mediosComunicacion;
	}

	public void setMediosComunicacion(Boolean mediosComunicacion) {
		this.mediosComunicacion = mediosComunicacion;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}


}
