package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ajustador {
	private String estado;
	private String base;
	private String nombre;
	private String id;
	private String numeroRadio;
	private String numeroProveedor;
	private String numeroTelefono;
	private String fechaLocalizacion;
	private String reporteAtiendiendoPlacasSerie;
	private String reporteAtiendiendoNumero;
	private int reporteEsteDia;
	private String direccion;
	private String estatus;
	private String latitud;
	private String longitud;
	private String distanciaAlPunto;
	private String tiempoAlPunto;
	private String icono;
	private String fuenteDeCoordenadas;
	private Boolean av = true;
	private String tipoAv;
	private String geocerca;
	private String tiempoDeAtencion;
	private String tiempoSinAtencion;
	private String leido;
	private Boolean moto;
	private Boolean equipoPesado;
	private String unidadPlacas;
	private String unidadMarcaAjust;
	private String tiempoSinPosicion;
	/**
	 * Jose Miguel Nov 5, 2012 7:36:45 PM
	 */
	public Ajustador() {
		super();
	}

	/**
	 * @param base
	 * @param nombre
	 * @param id
	 * @param numeroRadio
	 * @param numeroProveedor
	 * @param numeroTelefono
	 * @param fechaLocalizacion
	 * @param reporteAtiendiendoPlacasSerie
	 * @param reporteAtiendiendoNumero
	 * @param reporteEsteDia
	 * @param direccion
	 * @param estatus
	 * @param latitud
	 * @param longitud
	 * @param distanciaAlPunto
	 * @param tiempoAlPunto
	 * @param icono
	 */
	public Ajustador(final String base, final String nombre, final String id, final String numeroRadio, final String numeroProveedor, final String numeroTelefono, final String fechaLocalizacion,
			final String reporteAtiendiendoPlacasSerie, final String reporteAtiendiendoNumero, final int reporteEsteDia, final String direccion, final String estatus, final String latitud,
			final String longitud, final String distanciaAlPunto, final String tiempoAlPunto, final String icono, final Boolean av, final String tipoAsistenciaVial, final Boolean moto,
			final Boolean equipoPesado , final String unidadPlacas, final String unidadMarcaAjust, final String tiempoSinPosicion) {
		super();
		this.base = base;
		this.nombre = nombre;
		this.id = id;
		this.numeroRadio = numeroRadio;
		this.numeroProveedor = numeroProveedor;
		this.numeroTelefono = numeroTelefono;
		this.fechaLocalizacion = fechaLocalizacion;
		this.reporteAtiendiendoPlacasSerie = reporteAtiendiendoPlacasSerie;
		this.reporteAtiendiendoNumero = reporteAtiendiendoNumero;
		this.reporteEsteDia = reporteEsteDia;
		this.direccion = direccion;
		this.estatus = estatus;
		this.latitud = latitud;
		this.longitud = longitud;
		this.distanciaAlPunto = distanciaAlPunto;
		this.tiempoAlPunto = tiempoAlPunto;
		this.icono = icono;
		this.av=av;
		this.tipoAv = tipoAsistenciaVial;
		this.moto = moto;
		this.equipoPesado = equipoPesado;
		this.unidadPlacas = unidadPlacas;
		this.unidadMarcaAjust = unidadMarcaAjust;
		this.tiempoSinPosicion = tiempoSinPosicion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the estado
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param estado es el identificador o el objeto del estado o entidad federativa
	 *            the estado to set
	 */
	public void setEstado(final String estado) {
		this.estado = estado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the base
	 */
	public String getBase() {
		return this.base;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param base
	 *            the base to set
	 */
	public void setBase(final String base) {
		this.base = base;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the numeroRadio
	 */
	public String getNumeroRadio() {
		return this.numeroRadio;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param numeroRadio
	 *            the numeroRadio to set
	 */
	public void setNumeroRadio(final String numeroRadio) {
		this.numeroRadio = numeroRadio;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the numeroProveedor
	 */
	public String getNumeroProveedor() {
		return this.numeroProveedor;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param numeroProveedor
	 *            the numeroProveedor to set
	 */
	public void setNumeroProveedor(final String numeroProveedor) {
		this.numeroProveedor = numeroProveedor;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the numeroTelefono
	 */
	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param numeroTelefono
	 *            the numeroTelefono to set
	 */
	public void setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the fechaLocalizacion
	 */
	public String getFechaLocalizacion() {
		return this.fechaLocalizacion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param fechaLocalizacion
	 *            the fechaLocalizacion to set
	 */
	public void setFechaLocalizacion(final String fechaLocalizacion) {
		this.fechaLocalizacion = fechaLocalizacion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the reporteAtiendiendoPlacasSerie
	 */
	public String getReporteAtiendiendoPlacasSerie() {
		return this.reporteAtiendiendoPlacasSerie;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param reporteAtiendiendoPlacasSerie
	 *            the reporteAtiendiendoPlacasSerie to set
	 */
	public void setReporteAtiendiendoPlacasSerie(final String reporteAtiendiendoPlacasSerie) {
		this.reporteAtiendiendoPlacasSerie = reporteAtiendiendoPlacasSerie;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the reporteAtiendiendoNumero
	 */
	public String getReporteAtiendiendoNumero() {
		return this.reporteAtiendiendoNumero;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param reporteAtiendiendoNumero
	 *            the reporteAtiendiendoNumero to set
	 */
	public void setReporteAtiendiendoNumero(final String reporteAtiendiendoNumero) {
		this.reporteAtiendiendoNumero = reporteAtiendiendoNumero;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the estatus
	 */
	public String getEstatus() {
		return this.estatus;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(final String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 7:40:48 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:11:00 PM
	 * 
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Jose Miguel Nov 5, 2012 8:11:00 PM
	 * 
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Jose Miguel Nov 16, 2012 12:19:33 PM
	 * 
	 * @return the distanciaAlPunto
	 */
	public String getDistanciaAlPunto() {
		return this.distanciaAlPunto;
	}
	
	/**
	 * Candi Perez Agt 28, 2017 
	 * 
	 * @return the tiempoAlPunto
	 */
	public String getTiempoAlPunto() {
		return this.tiempoAlPunto;
	}

	/**
	 * Jose Miguel Nov 16, 2012 12:19:33 PM
	 * 
	 * @param distanciaAlPunto
	 *            the distanciaAlPunto to set
	 */
	public void setDistanciaAlPunto(final String distanciaAlPunto) {
		this.distanciaAlPunto = distanciaAlPunto;
	}
	
	/**
	 * Candi Perez Agt 28, 2017 
	 * 
	 * @param tiempoAlPunto
	 *            the tiempoAlPunto to set
	 */
	public void setTiempoAlPunto(final String tiempoAlPunto) {
		this.tiempoAlPunto = tiempoAlPunto;
	}

	/**
	 *  May 6, 2013 3:54:01 PM
	 * 
	 * @param reporteEsteDia
	 *            the reporteEsteDia to set
	 */
	public void setReporteEsteDia(final int reporteEsteDia) {
		this.reporteEsteDia = reporteEsteDia;
	}

	/**
	 *  May 6, 2013 3:57:32 PM
	 * 
	 * @return the reporteEsteDia
	 */
	public int getReporteEsteDia() {
		return this.reporteEsteDia;
	}

	/**
	 *  Enero 26, 2013 3:57:32 PM
	 *
	 * @return la condicion
	 */
	public String getIcono() {
		return icono;
	}

	/**
	 *  Enero 26, 2013 3:57:32 PM
	 *
	 * @param icono
	 */
	public void setIcono(final String icono) {
		this.icono = icono;
	}

	/**
	 *  Enero 26, 2013 3:57:32 PM
	 *
	 * @return la fuente desde las coordenads
	 */
	public String getFuenteDeCoordenadas() {
		return fuenteDeCoordenadas;
	}


	/**
	 *  Enero 26, 2013 3:57:32 PM
	 *
 	 * @param fuenteDeCoordenadas
	 */
	public void setFuenteDeCoordenadas(final String fuenteDeCoordenadas) {
		this.fuenteDeCoordenadas = fuenteDeCoordenadas;
	}
	
	/**
	 * @return the av
	 */
	public Boolean getAv() {
		return this.av;
	}

	/**
	 * @param av the av to set
	 */
	public void setAv(final Boolean av) {
		this.av = av;
	}
	
	/**
	 * @return the tipoAv
	 */
	public String getTipoAv() {
		return tipoAv;
	}

	/**
	 * @param tipoAv the tipoAv to set
	 */
	public void setTipoAv(String tipoAv) {
		this.tipoAv = tipoAv;
	}

	/**
	 * @return the geocerca
	 */
	public String getGeocerca() {
		return geocerca;
	}

	/**
	 * @param geocerca the geocerca to set
	 */
	public void setGeocerca(final String geocerca) {
		this.geocerca = geocerca;
	}

	/**
	 * @return the tiempoDeAtencion
	 */
	public String getTiempoDeAtencion() {
		return tiempoDeAtencion;
	}

	/**
	 * @param tiempoDeAtencion the tiempoDeAtencion to set
	 */
	public void setTiempoDeAtencion(String tiempoDeAtencion) {
		this.tiempoDeAtencion = tiempoDeAtencion;
	}

	public String getTiempoSinAtencion() {
		return tiempoSinAtencion;
	}

	public void setTiempoSinAtencion(String tiempoSinAtencion) {
		this.tiempoSinAtencion = tiempoSinAtencion;
	}

	public String getLeido() {
		return leido;
	}

	public void setLeido(String leido) {
		this.leido = leido;
	}

	/**
	 * @return the moto
	 */
	public Boolean getMoto() {
		return moto;
	}

	/**
	 * @param moto the moto to set
	 */
	public void setMoto(Boolean moto) {
		this.moto = moto;
	}

	public Boolean getEquipoPesado() {
		return equipoPesado;
	}

	public void setEquipoPesado(Boolean equipoPesado) {
		this.equipoPesado = equipoPesado;
	}

	public String getUnidadPlacas() {
		return unidadPlacas;
	}

	public void setUnidadPlacas(String unidadPlacas) {
		this.unidadPlacas = unidadPlacas;
	}

	public String getUnidadMarcaAjust() {
		return unidadMarcaAjust;
	}

	public void setUnidadMarcaAjust(String unidadMarcaAjust) {
		this.unidadMarcaAjust = unidadMarcaAjust;
	}

	public String getTiempoSinPosicion() {
		return tiempoSinPosicion;
	}

	public void setTiempoSinPosicion(String tiempoSinPosicion) {
		this.tiempoSinPosicion = tiempoSinPosicion;
	}

	
}
