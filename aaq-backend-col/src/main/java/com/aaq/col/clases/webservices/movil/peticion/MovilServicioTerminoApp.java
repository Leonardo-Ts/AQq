package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioTerminoApp {

	private String usuario;

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
	
	private String latitudTerminoAjustador;
	
	private String longitudTerminoAjustador;
	
	private String numeroReporte;

	/**
	 * Jose Miguel Jun 24, 2011 2:00:08 AM
	 * 
	 * @return the roboLocalizado
	 */
	public Boolean getRoboLocalizado() {
		return this.roboLocalizado;
	}

	/**
	 * Jose Miguel Jun 24, 2011 2:00:08 AM
	 * 
	 * @param roboLocalizado
	 *            the roboLocalizado to set
	 */
	public void setRoboLocalizado(final Boolean roboLocalizado) {
		this.roboLocalizado = roboLocalizado;
	}

	/**
	 * 
	 */
	public MovilServicioTerminoApp() {
		super();
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @return the fechaHora
	 */
	public String getFechaHora() {
		return this.fechaHora;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @return the datosRepuve
	 */
	public MovilDatosRepuve getDatosRepuve() {
		return this.datosRepuve;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @return the datosRobo
	 */
	public MovilDatosRobo getDatosRobo() {
		return this.datosRobo;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(final String fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @param datosRepuve
	 *            the datosRepuve to set
	 */
	public void setDatosRepuve(final MovilDatosRepuve datosRepuve) {
		this.datosRepuve = datosRepuve;
	}

	/**
	 * Apr 6, 2011 10:17:41 PM
	 * 
	 * @param datosRobo
	 *            the datosRobo to set
	 */
	public void setDatosRobo(final MovilDatosRobo datosRobo) {
		this.datosRobo = datosRobo;
	}

	/**
	 * Jose Miguel Jun 22, 2011 11:37:11 AM
	 * 
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return this.observaciones;
	}

	/**
	 * Jose Miguel Jun 22, 2011 11:37:11 AM
	 * 
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(final String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 *  Jan 13, 2014 10:29:58 AM
	 * 
	 * @return the preAveriguacion
	 */
	public String getPreAveriguacion() {
		return this.preAveriguacion;
	}

	/**
	 *  Jan 13, 2014 10:29:58 AM
	 * 
	 * @param preAveriguacion
	 *            the preAveriguacion to set
	 */
	public void setPreAveriguacion(final String preAveriguacion) {
		this.preAveriguacion = preAveriguacion;
	}
	
	/**
	 * @return the aseguradoCorreo
	 */
	public String getAseguradoCorreo() {
		return this.aseguradoCorreo;
	}

	/**
	 * @param aseguradoCorreo the aseguradoCorreo to set
	 */
	public void setAseguradoCorreo(final String aseguradoCorreo) {
		this.aseguradoCorreo = aseguradoCorreo;
	}

	public String getDescripcionDanosPrexistentes() {
		return descripcionDanosPrexistentes;
	}

	public void setDescripcionDanosPrexistentes(String descripcionDanosPrexistentes) {
		this.descripcionDanosPrexistentes = descripcionDanosPrexistentes;
	}

	/**
	 * @return the serie
	 */
	public String getSerieAsegurado() {
		return serieAsegurado;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerieAsegurado(String serieAsegurado) {
		this.serieAsegurado = serieAsegurado;
	}

	/**
	 * @return the placas
	 */
	public String getPlacas() {
		return placas;
	}

	/**
	 * @param placas the placas to set
	 */
	public void setPlacas(String placas) {
		this.placas = placas;
	}

	/**
	 * @return the colorAsegurado
	 */
	public int getColorAsegurado() {
		return colorAsegurado;
	}

	/**
	 * @param colorAsegurado the colorAsegurado to set
	 */
	public void setColorAsegurado(int colorAsegurado) {
		this.colorAsegurado = colorAsegurado;
	}

	/**
	 * @return the motorAsegurado
	 */
	public String getMotorAsegurado() {
		return motorAsegurado;
	}

	/**
	 * @param motorAsegurado the motorAsegurado to set
	 */
	public void setMotorAsegurado(String motorAsegurado) {
		this.motorAsegurado = motorAsegurado;
	}
	
	/**
	 * @return the codigoResponsabilidad
	 */
	public String getCodigoResponsabilidad() {
		return codigoResponsabilidad;
	}
	
	/**
	 * @return the codigoMatriz
	 */
	public String getCodigoMatriz() {
		return codigoMatriz;
	}

	/**
	 * @param codigoMatriz the codigoMatriz to set
	 */
	public void setCodigoMatriz(String codigoMatriz) {
		this.codigoMatriz = codigoMatriz;
	}

	/**
	 * @return the matriz
	 */
	public Boolean getMatriz() {
		return matriz;
	}

	/**
	 * @param matriz the matriz to set
	 */
	public void setMatriz(Boolean matriz) {
		this.matriz = matriz;
	}

	/**
	 * @param codigoResponsabilidad the codigoResponsabilidad to set
	 */
	public void setCodigoResponsabilidad(String codigoResponsabilidad) {
		this.codigoResponsabilidad = codigoResponsabilidad;

	}
	
	public String getLatitudTerminoAjustador() {
		return latitudTerminoAjustador;
	}

	public void setLatitudTerminoAjustador(String latitudTerminoAjustador) {
		this.latitudTerminoAjustador = latitudTerminoAjustador;
	}

	public String getLongitudTerminoAjustador() {
		return longitudTerminoAjustador;
	}

	public void setLongitudTerminoAjustador(String longitudTerminoAjustador) {
		this.longitudTerminoAjustador = longitudTerminoAjustador;
	}

	public String getNumeroReporte() {
		return numeroReporte;
	}

	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
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
