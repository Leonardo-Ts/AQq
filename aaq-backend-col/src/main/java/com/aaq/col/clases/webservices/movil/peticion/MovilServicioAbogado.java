package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioAbogado {

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
	private String responsabilidad;
	private Integer motivoSolicitud;
	private String idEntidad;
	private String descAPresentarse;
	private Boolean pt;

	public MovilServicioAbogado() {
		super();
	}

	/**
	 * @param usuario
	 * @param passwd
	 * @param numeroReporte
	 * @param conductorDetenido
	 * @param vehiculoDetenido
	 * @param numeroLesionadosNA
	 * @param numeroLesionadosTS
	 * @param numeroMuertosNA
	 * @param numeroMuertosTS
	 * @param lugarAPresentarse
	 * @param responsabilidad
	 * @param motivoSolicitud
	 * @param idEntidad
	 */
	public MovilServicioAbogado(final String usuario, final String passwd, final String numeroReporte,
			final Boolean conductorDetenido, final Boolean vehiculoDetenido, final Integer numeroLesionadosNA,
			final Integer numeroLesionadosTS, final Integer numeroMuertosNA, final Integer numeroMuertosTS,
			final String lugarAPresentarse, final String responsabilidad, final Integer motivoSolicitud,
			final String idEntidad, final String descAPresentarse, final Boolean pt) {
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
		this.responsabilidad = responsabilidad;
		this.motivoSolicitud = motivoSolicitud;
		this.idEntidad = idEntidad;
		this.pt = pt;
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

	public String getResponsabilidad() {
		return responsabilidad;
	}

	public void setResponsabilidad(String responsabilidad) {
		this.responsabilidad = responsabilidad;
	}

	public Integer getMotivoSolicitud() {
		return motivoSolicitud;
	}

	public void setMotivoSolicitud(Integer motivoSolicitud) {
		this.motivoSolicitud = motivoSolicitud;
	}

	public String getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getDescAPresentarse() {
		return descAPresentarse;
	}

	public void setDescAPresentarse(String descAPresentarse) {
		this.descAPresentarse = descAPresentarse;
	}

	public Boolean getPt() {
		return pt;
	}

	public void setPt(Boolean pt) {
		this.pt = pt;
	}

	
}
