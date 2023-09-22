package com.aaq.col.clases.webservices.movil.peticion;

public class MovilDatosTercero {
	// *** DATOS TERCERO
	private String consecutivoTercero;
	private String vehiculoMarca;
	private String vehiculoModelo;
	private String vehiculoColor;
	private String vehiculoTipo;
	private String terceroNombre;
	private String terceroCorreo;
	private String terceroSerie;
	private String terceroTelefono;
	private Boolean atropello;
	private String vehiculoClave;
	private String nombreAjustadorTercero;
	private String polizaTercero;
	private String incisoPolizaTercero; 
	
	// *** DATOS OBJETO
	private String bache;
	private String malla;
	private String objetoFijoOSemimoviente;
	private String terceroCorreoObjeto;
	private String terceroNombreObjeto;
	private String terceroTelefonoObjeto;
	private String idObjeto;
	
	
	/**
	 * 14/07/2015 14:26 Erasto Bernabe
	 * @return the vehiculoClave
	 */
	public String getVehiculoClave() {
		return this.vehiculoClave;
	}

	/**
	 * 14/07/2015 14:26 Erasto Bernabe
	 * @param vehiculoClave the vehiculoClave to set
	 */
	public void setVehiculoClave(final String vehiculoClave) {
		this.vehiculoClave = vehiculoClave;
	}

	/**
	 * 08/09/2011 14:00:58 Jose Miguel
	 * 
	 * @return the vehiculoModelo
	 */
	public String getVehiculoModelo() {
		return this.vehiculoModelo;
	}

	/**
	 * 08/09/2011 14:00:58 Jose Miguel
	 * 
	 * @param vehiculoModelo
	 *            the vehiculoModelo to set
	 */
	public void setVehiculoModelo(final String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}

	/**
	 * 08/09/2011 14:00:58 Jose Miguel
	 * 
	 * @return the vehiculoColor
	 */
	public String getVehiculoColor() {
		return this.vehiculoColor;
	}

	/**
	 * 08/09/2011 14:00:58 Jose Miguel
	 * 
	 * @param vehiculoColor
	 *            the vehiculoColor to set
	 */
	public void setVehiculoColor(final String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	private String vehiculoPlacas;

	private String conductor;

	/**
	 * 
	 */
	public MovilDatosTercero() {
		super();
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @return the vehiculoMarca
	 */
	public String getVehiculoMarca() {
		return this.vehiculoMarca;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @return the vehiculoTipo
	 */
	public String getVehiculoTipo() {
		return this.vehiculoTipo;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @return the vehiculoPlacas
	 */
	public String getVehiculoPlacas() {
		return this.vehiculoPlacas;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @return the conductor
	 */
	public String getConductor() {
		return this.conductor;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @param vehiculoMarca
	 *            the vehiculoMarca to set
	 */
	public void setVehiculoMarca(final String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @param vehiculoTipo
	 *            the vehiculoTipo to set
	 */
	public void setVehiculoTipo(final String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @param vehiculoPlacas
	 *            the vehiculoPlacas to set
	 */
	public void setVehiculoPlacas(final String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}

	/**
	 * Apr 6, 2011 10:20:20 PM
	 * 
	 * @param conductor
	 *            the conductor to set
	 */
	public void setConductor(final String conductor) {
		this.conductor = conductor;
	}

	/**
	 * Jose Miguel Jun 27, 2011 10:18:57 AM
	 * 
	 * @return the consecutivoTercero
	 */
	public String getConsecutivoTercero() {
		return this.consecutivoTercero;
	}

	/**
	 * Jose Miguel Jun 27, 2011 10:18:57 AM
	 * 
	 * @param consecutivoTercero
	 *            the consecutivoTercero to set
	 */
	public void setConsecutivoTercero(final String consecutivoTercero) {
		this.consecutivoTercero = consecutivoTercero;
	}

	/**
	 * Jose Miguel Nov 13, 2012 2:28:09 AM
	 * 
	 * @return the atropello
	 */
	public Boolean getAtropello() {
		return this.atropello;
	}

	/**
	 * Jose Miguel Nov 13, 2012 2:28:09 AM
	 * 
	 * @param atropello
	 *            the atropello to set
	 */
	public void setAtropello(final Boolean atropello) {
		this.atropello = atropello;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @return the terceroNombre
	 */
	public String getTerceroNombre() {
		return this.terceroNombre;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @param terceroNombre
	 *            the terceroNombre to set
	 */
	public void setTerceroNombre(final String terceroNombre) {
		this.terceroNombre = terceroNombre;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @return the terceroCorreo
	 */
	public String getTerceroCorreo() {
		return this.terceroCorreo;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @param terceroCorreo
	 *            the terceroCorreo to set
	 */
	public void setTerceroCorreo(final String terceroCorreo) {
		this.terceroCorreo = terceroCorreo;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @return the terceroSerie
	 */
	public String getTerceroSerie() {
		return this.terceroSerie;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @param terceroSerie
	 *            the terceroSerie to set
	 */
	public void setTerceroSerie(final String terceroSerie) {
		this.terceroSerie = terceroSerie;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @return the terceroTelefono
	 */
	public String getTerceroTelefono() {
		return this.terceroTelefono;
	}

	/**
	 * Jun 27, 2014 5:12:33 PM mfernandez
	 * 
	 * @param terceroTelefono
	 *            the terceroTelefono to set
	 */
	public void setTerceroTelefono(final String terceroTelefono) {
		this.terceroTelefono = terceroTelefono;
	}

	public String getNombreAjustadorTercero() {
		return nombreAjustadorTercero;
	}

	public void setNombreAjustadorTercero(String nombreAjustadorTercero) {
		this.nombreAjustadorTercero = nombreAjustadorTercero;
	}

	public String getPolizaTercero() {
		return polizaTercero;
	}

	public void setPolizaTercero(String polizaTercero) {
		this.polizaTercero = polizaTercero;
	}

	public String getIncisoPolizaTercero() {
		return incisoPolizaTercero;
	}

	public void setIncisoPolizaTercero(String incisoPolizaTercero) {
		this.incisoPolizaTercero = incisoPolizaTercero;
	}

	public String getBache() {
		return bache;
	}

	public void setBache(String bache) {
		this.bache = bache;
	}

	public String getMalla() {
		return malla;
	}

	public void setMalla(String malla) {
		this.malla = malla;
	}

	public String getObjetoFijoOSemimoviente() {
		return objetoFijoOSemimoviente;
	}

	public void setObjetoFijoOSemimoviente(String objetoFijoOSemimoviente) {
		this.objetoFijoOSemimoviente = objetoFijoOSemimoviente;
	}

	public String getTerceroCorreoObjeto() {
		return terceroCorreoObjeto;
	}

	public void setTerceroCorreoObjeto(String terceroCorreoObjeto) {
		this.terceroCorreoObjeto = terceroCorreoObjeto;
	}

	public String getTerceroNombreObjeto() {
		return terceroNombreObjeto;
	}

	public void setTerceroNombreObjeto(String terceroNombreObjeto) {
		this.terceroNombreObjeto = terceroNombreObjeto;
	}

	public String getTerceroTelefonoObjeto() {
		return terceroTelefonoObjeto;
	}

	public void setTerceroTelefonoObjeto(String terceroTelefonoObjeto) {
		this.terceroTelefonoObjeto = terceroTelefonoObjeto;
	}

	public String getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}

	
	

}
