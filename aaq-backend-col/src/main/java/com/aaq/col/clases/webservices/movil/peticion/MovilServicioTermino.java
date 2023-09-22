package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioTermino {

	private String usuario;
	private String passwd;
	private String observaciones;
	private String preAveriguacion;
	private Boolean roboLocalizado;
	private String fechaHora;
	private String aseguradoCorreo;
	private String descripcionDanosPrexistentes;
	private MovilDatosRepuve datosRepuve;
	private MovilDatosRobo datosRobo;
	private String serieAsegurado;
	private String placas;
	private int colorAsegurado;
	private String motorAsegurado;
	private String codigoResponsabilidad;
	private String codigoMatriz;
	private Boolean matriz;
	private Boolean  estadoUnidad;
	private String motivoNoInsp;
	private String cvAccidente;
	private Boolean polizaTurista;
	private String numeroPolizaTurista;
	private String incisoPolizaTurista;
	private String codigoResponsabilidadDUA;
	
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
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getPreAveriguacion() {
		return preAveriguacion;
	}
	public void setPreAveriguacion(String preAveriguacion) {
		this.preAveriguacion = preAveriguacion;
	}
	public Boolean getRoboLocalizado() {
		return roboLocalizado;
	}
	public void setRoboLocalizado(Boolean roboLocalizado) {
		this.roboLocalizado = roboLocalizado;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getAseguradoCorreo() {
		return aseguradoCorreo;
	}
	public void setAseguradoCorreo(String aseguradoCorreo) {
		this.aseguradoCorreo = aseguradoCorreo;
	}
	public String getDescripcionDanosPrexistentes() {
		return descripcionDanosPrexistentes;
	}
	public void setDescripcionDanosPrexistentes(String descripcionDanosPrexistentes) {
		this.descripcionDanosPrexistentes = descripcionDanosPrexistentes;
	}
	public MovilDatosRepuve getDatosRepuve() {
		return datosRepuve;
	}
	public void setDatosRepuve(MovilDatosRepuve datosRepuve) {
		this.datosRepuve = datosRepuve;
	}
	public MovilDatosRobo getDatosRobo() {
		return datosRobo;
	}
	public void setDatosRobo(MovilDatosRobo datosRobo) {
		this.datosRobo = datosRobo;
	}
	public String getSerieAsegurado() {
		return serieAsegurado;
	}
	public void setSerieAsegurado(String serieAsegurado) {
		this.serieAsegurado = serieAsegurado;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public int getColorAsegurado() {
		return colorAsegurado;
	}
	public void setColorAsegurado(int colorAsegurado) {
		this.colorAsegurado = colorAsegurado;
	}
	public String getMotorAsegurado() {
		return motorAsegurado;
	}
	public void setMotorAsegurado(String motorAsegurado) {
		this.motorAsegurado = motorAsegurado;
	}
	public String getCodigoResponsabilidad() {
		return codigoResponsabilidad;
	}
	public void setCodigoResponsabilidad(String codigoResponsabilidad) {
		this.codigoResponsabilidad = codigoResponsabilidad;
	}
	public String getCodigoMatriz() {
		return codigoMatriz;
	}
	public void setCodigoMatriz(String codigoMatriz) {
		this.codigoMatriz = codigoMatriz;
	}
	public Boolean getMatriz() {
		return matriz;
	}
	public void setMatriz(Boolean matriz) {
		this.matriz = matriz;
	}
	public Boolean getEstadoUnidad() {
		return estadoUnidad;
	}
	public void setEstadoUnidad(Boolean estadoUnidad) {
		this.estadoUnidad = estadoUnidad;
	}
	public String getMotivoNoInsp() {
		return motivoNoInsp;
	}
	public void setMotivoNoInsp(String motivoNoInsp) {
		this.motivoNoInsp = motivoNoInsp;
	}
	public String getCvAccidente() {
		return cvAccidente;
	}
	public void setCvAccidente(String cvAccidente) {
		this.cvAccidente = cvAccidente;
	}
	public Boolean getPolizaTurista() {
		return polizaTurista;
	}
	public void setPolizaTurista(Boolean polizaTurista) {
		this.polizaTurista = polizaTurista;
	}
	public String getNumeroPolizaTurista() {
		return numeroPolizaTurista;
	}
	public void setNumeroPolizaTurista(String numeroPolizaTurista) {
		this.numeroPolizaTurista = numeroPolizaTurista;
	}
	public String getIncisoPolizaTurista() {
		return incisoPolizaTurista;
	}
	public void setIncisoPolizaTurista(String incisoPolizaTurista) {
		this.incisoPolizaTurista = incisoPolizaTurista;
	}
	public String getCodigoResponsabilidadDUA() {
		return codigoResponsabilidadDUA;
	}
	public void setCodigoResponsabilidadDUA(String codigoResponsabilidadDUA) {
		this.codigoResponsabilidadDUA = codigoResponsabilidadDUA;
	}	
	
	public static boolean containsAny(String str, char[] searchChars) {
		if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for (int j = 0; j < searchChars.length; j++) {
				if (searchChars[j] == ch) {
					return true;
				}
			}
		}
		return false;
	}
	
}
