 package com.aaq.col.clases.webservices.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reporte {
	private String idEstado;

	private String idAjustador;

	private String latitud;

	private String longitud;

	private String numeroReporte;

	private String identificadorUnico;

	private String claveDeEntidad;

	private String ubCalle;

	private String ubColonia;

	private String ubMunicipio;

	private String ubEntreCalle;

	private String ubEsquina;

	private String ubCarreteraNombre;

	private String ubCarreteraKilometro;

	private String ubNumeroInterior;

	private String ubNumeroExterior;

	private String ubReferencia;

	private String ubEstado;

	private String ubPais;

	private String ubCodigoPostal;

	private Boolean cerrarLocalizacion;

	private Boolean cerrarAsignacion;

	private String IdMunSepomex;

	private String IdEntSepomex;

	/**
	 * @param idEstado
	 * @param idAjustador
	 * @param latitud
	 * @param longitud
	 * @param numeroReporte
	 * @param identificadorUnico
	 * @param claveDeEntidad
	 * @param ubCalle
	 * @param ubColonia
	 * @param ubMunicipio
	 * @param ubEntreCalle
	 * @param ubEsquina
	 * @param ubCarreteraNombre
	 * @param ubCarreteraKilometro
	 * @param ubNumeroInterior
	 * @param ubNumeroExterior
	 * @param ubReferencia
	 * @param ubEstado
	 * @param ubPais
	 * @param ubCodigoPostal
	 * @param cerrarLocalizacion
	 * @param cerrarAsignacion
	 * @param idMunSepomex
	 * @param idEntSepomex
	 */
	public Reporte(final String idEstado, final String idAjustador, final String latitud, final String longitud,
			final String numeroReporte, final String identificadorUnico, final String claveDeEntidad,
			final String ubCalle, final String ubColonia, final String ubMunicipio, final String ubEntreCalle,
			final String ubEsquina, final String ubCarreteraNombre, final String ubCarreteraKilometro,
			final String ubNumeroInterior, final String ubNumeroExterior, final String ubReferencia,
			final String ubEstado, final String ubPais, final String ubCodigoPostal, final Boolean cerrarLocalizacion,
			final Boolean cerrarAsignacion, final String idMunSepomex, final String idEntSepomex) {
		super();
		this.idEstado = idEstado;
		this.idAjustador = idAjustador;
		this.latitud = latitud;
		this.longitud = longitud;
		this.numeroReporte = numeroReporte;
		this.identificadorUnico = identificadorUnico;
		this.claveDeEntidad = claveDeEntidad;
		this.ubCalle = ubCalle;
		this.ubColonia = ubColonia;
		this.ubMunicipio = ubMunicipio;
		this.ubEntreCalle = ubEntreCalle;
		this.ubEsquina = ubEsquina;
		this.ubCarreteraNombre = ubCarreteraNombre;
		this.ubCarreteraKilometro = ubCarreteraKilometro;
		this.ubNumeroInterior = ubNumeroInterior;
		this.ubNumeroExterior = ubNumeroExterior;
		this.ubReferencia = ubReferencia;
		this.ubEstado = ubEstado;
		this.ubPais = ubPais;
		this.ubCodigoPostal = ubCodigoPostal;
		this.cerrarLocalizacion = cerrarLocalizacion;
		this.cerrarAsignacion = cerrarAsignacion;
		this.IdMunSepomex = idMunSepomex;
		this.IdEntSepomex = idEntSepomex;
	}

	/**
	 * Jose Miguel Jan 16, 2013 12:37:36 PM
	 */
	public Reporte() {
		super();
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the idEstado
	 */
	public String getIdEstado() {
		return this.idEstado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param idEstado
	 *            the idEstado to set
	 */
	public void setIdEstado(final String idEstado) {
		this.idEstado = idEstado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the idAjustador
	 */
	public String getIdAjustador() {
		return this.idAjustador;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param idAjustador
	 *            the idAjustador to set
	 */
	public void setIdAjustador(final String idAjustador) {
		this.idAjustador = idAjustador;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the latitud
	 */
	public String getLatitud() {
		return this.latitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param latitud
	 *            the latitud to set
	 */
	public void setLatitud(final String latitud) {
		this.latitud = latitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the longitud
	 */
	public String getLongitud() {
		return this.longitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param longitud
	 *            the longitud to set
	 */
	public void setLongitud(final String longitud) {
		this.longitud = longitud;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param numeroReporte
	 *            the numeroReporte to set
	 */
	public void setNumeroReporte(final String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the identificadorUnico
	 */
	public String getIdentificadorUnico() {
		return this.identificadorUnico;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param identificadorUnico
	 *            the identificadorUnico to set
	 */
	public void setIdentificadorUnico(final String identificadorUnico) {
		this.identificadorUnico = identificadorUnico;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubCalle
	 */
	public String getUbCalle() {
		return this.ubCalle;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubCalle
	 *            the ubCalle to set
	 */
	public void setUbCalle(final String ubCalle) {
		this.ubCalle = ubCalle;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubColonia
	 */
	public String getUbColonia() {
		return this.ubColonia;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubColonia
	 *            the ubColonia to set
	 */
	public void setUbColonia(final String ubColonia) {
		this.ubColonia = ubColonia;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubMunicipio
	 */
	public String getUbMunicipio() {
		return this.ubMunicipio;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubMunicipio
	 *            the ubMunicipio to set
	 */
	public void setUbMunicipio(final String ubMunicipio) {
		this.ubMunicipio = ubMunicipio;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubEntreCalle
	 */
	public String getUbEntreCalle() {
		return this.ubEntreCalle;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubEntreCalle
	 *            the ubEntreCalle to set
	 */
	public void setUbEntreCalle(final String ubEntreCalle) {
		this.ubEntreCalle = ubEntreCalle;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubEsquina
	 */
	public String getUbEsquina() {
		return this.ubEsquina;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubEsquina
	 *            the ubEsquina to set
	 */
	public void setUbEsquina(final String ubEsquina) {
		this.ubEsquina = ubEsquina;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubNumeroInterior
	 */
	public String getUbNumeroInterior() {
		return this.ubNumeroInterior;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubNumeroInterior
	 *            the ubNumeroInterior to set
	 */
	public void setUbNumeroInterior(final String ubNumeroInterior) {
		this.ubNumeroInterior = ubNumeroInterior;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubNumeroExterior
	 */
	public String getUbNumeroExterior() {
		return this.ubNumeroExterior;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubNumeroExterior
	 *            the ubNumeroExterior to set
	 */
	public void setUbNumeroExterior(final String ubNumeroExterior) {
		this.ubNumeroExterior = ubNumeroExterior;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubReferencia
	 */
	public String getUbReferencia() {
		return this.ubReferencia;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubReferencia
	 *            the ubReferencia to set
	 */
	public void setUbReferencia(final String ubReferencia) {
		this.ubReferencia = ubReferencia;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubEstado
	 */
	public String getUbEstado() {
		return this.ubEstado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubEstado
	 *            the ubEstado to set
	 */
	public void setUbEstado(final String ubEstado) {
		this.ubEstado = ubEstado;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubPais
	 */
	public String getUbPais() {
		return this.ubPais;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubPais
	 *            the ubPais to set
	 */
	public void setUbPais(final String ubPais) {
		this.ubPais = ubPais;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @return the ubCodigoPostal
	 */
	public String getUbCodigoPostal() {
		return this.ubCodigoPostal;
	}

	/**
	 * Jose Miguel Nov 5, 2012 10:12:35 PM
	 * 
	 * @param ubCodigoPostal
	 *            the ubCodigoPostal to set
	 */
	public void setUbCodigoPostal(final String ubCodigoPostal) {
		this.ubCodigoPostal = ubCodigoPostal;
	}

	/**
	 * Jose Miguel Nov 5, 2012 11:16:31 PM
	 * 
	 * @return the ubCarreteraNombre
	 */
	public String getUbCarreteraNombre() {
		return this.ubCarreteraNombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 11:16:31 PM
	 * 
	 * @param ubCarreteraNombre
	 *            the ubCarreteraNombre to set
	 */
	public void setUbCarreteraNombre(final String ubCarreteraNombre) {
		this.ubCarreteraNombre = ubCarreteraNombre;
	}

	/**
	 * Jose Miguel Nov 5, 2012 11:16:31 PM
	 * 
	 * @return the ubCarreteraKilometro
	 */
	public String getUbCarreteraKilometro() {
		return this.ubCarreteraKilometro;
	}

	/**
	 * Jose Miguel Nov 5, 2012 11:16:31 PM
	 * 
	 * @param ubCarreteraKilometro
	 *            the ubCarreteraKilometro to set
	 */
	public void setUbCarreteraKilometro(final String ubCarreteraKilometro) {
		this.ubCarreteraKilometro = ubCarreteraKilometro;
	}

	/**
	 * Jose Miguel Jan 16, 2013 12:47:06 PM
	 * 
	 * @return the claveDeEntidad
	 */
	public String getClaveDeEntidad() {
		return this.claveDeEntidad;
	}

	/**
	 * Jose Miguel Jan 16, 2013 12:47:06 PM
	 * 
	 * @param claveDeEntidad
	 *            the claveDeEntidad to set
	 */
	public void setClaveDeEntidad(final String claveDeEntidad) {
		this.claveDeEntidad = claveDeEntidad;
	}

	/**
	 * Jose Miguel Jan 24, 2013 5:18:11 PM
	 * 
	 * @return the cerrarLocalizacion
	 */
	public Boolean getCerrarLocalizacion() {
		return this.cerrarLocalizacion;
	}

	/**
	 * Jose Miguel Jan 24, 2013 5:18:11 PM
	 * 
	 * @param cerrarLocalizacion
	 *            the cerrarLocalizacion to set
	 */
	public void setCerrarLocalizacion(final Boolean cerrarLocalizacion) {
		this.cerrarLocalizacion = cerrarLocalizacion;
	}

	/**
	 * Jose Miguel Jan 24, 2013 5:18:11 PM
	 * 
	 * @return the cerrarAsignacion
	 */
	public Boolean getCerrarAsignacion() {
		return this.cerrarAsignacion;
	}

	/**
	 * Jose Miguel Jan 24, 2013 5:18:11 PM
	 * 
	 * @param cerrarAsignacion
	 *            the cerrarAsignacion to set
	 */
	public void setCerrarAsignacion(final Boolean cerrarAsignacion) {
		this.cerrarAsignacion = cerrarAsignacion;
	}

	/**
	 *  May 14, 2013 1:47:04 PM
	 * 
	 * @return the idMunSepomex
	 */
	public String getIdMunSepomex() {
		return this.IdMunSepomex;
	}

	/**
	 *  May 14, 2013 1:47:04 PM
	 * 
	 * @param idMunSepomex
	 *            the idMunSepomex to set
	 */
	public void setIdMunSepomex(final String idMunSepomex) {
		this.IdMunSepomex = idMunSepomex;
	}

	/**
	 *  May 14, 2013 1:47:04 PM
	 * 
	 * @return the idEntSepomex
	 */
	public String getIdEntSepomex() {
		return this.IdEntSepomex;
	}

	/**
	 *  May 14, 2013 1:47:04 PM
	 * 
	 * @param idEntSepomex
	 *            the idEntSepomex to set
	 */
	public void setIdEntSepomex(final String idEntSepomex) {
		this.IdEntSepomex = idEntSepomex;
	}

}
