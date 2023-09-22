package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioCapufe {
	private String usuario;
	private String passwd;
	private String numeroKilometro;
	private boolean danosCam;
	private String cuerpo;
	private String responsable;
	private String causaAccidente;
	private String comoOcurrio;

	/**
	 * 
	 */
	public MovilServicioCapufe() {
		super();
	}

	/**
	 * Apr 6, 2011 10:28:09 PM
	 * 
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * Apr 6, 2011 10:28:09 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Apr 6, 2011 10:28:09 PM
	 * 
	 * @return the passwd
	 */
	public String getPasswd() {
		return this.passwd;
	}

	/**
	 * Apr 6, 2011 10:28:09 PM
	 * 
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	/**
	 * Apr 6, 2011 10:28:09 PM
	 * 
	 * @return the numeroKilometro
	 */
	public String getNumeroKilometro() {
		return this.numeroKilometro;
	}

	/**
	 * Apr 6, 2011 10:28:09 PM
	 * 
	 * @param numeroKilometro
	 *            the numeroKilometro to set
	 */
	public void setNumeroKilometro(final String numeroKilometro) {
		this.numeroKilometro = numeroKilometro;
	}

	/**
	 * 08/09/2011 14:09:59 Jose Miguel
	 * 
	 * @return the danosCam
	 */
	public boolean isDanosCam() {
		return this.danosCam;
	}

	/**
	 * 08/09/2011 14:09:59 Jose Miguel
	 * 
	 * @param danosCam
	 *            the danosCam to set
	 */
	public void setDanosCam(final boolean danosCam) {
		this.danosCam = danosCam;
	}

	/**
	 * mfernandez Dec 1, 2014 10:17:01 AM
	 * 
	 * @return the cuerpo
	 */
	public String getCuerpo() {
		return this.cuerpo;
	}

	/**
	 * mfernandez Dec 1, 2014 10:17:01 AM
	 * 
	 * @param cuerpo
	 *            the cuerpo to set
	 */
	public void setCuerpo(final String cuerpo) {
		this.cuerpo = cuerpo;
	}

	/**
	 * mfernandez Dec 1, 2014 10:19:12 AM
	 * 
	 * @return the responsable
	 */
	public String getResponsable() {
		return this.responsable;
	}

	/**
	 * mfernandez Dec 1, 2014 10:19:12 AM
	 * 
	 * @param responsable
	 *            the responsable to set
	 */
	public void setResponsable(final String responsable) {
		this.responsable = responsable;
	}

	/**
	 *
	 * @return la causa del accidente
	 */
	public String getCausaAccidente() {
		return causaAccidente;
	}

	/**
	 *
	 * @param causaAccidente la causa del accidente
	 */
	public void setCausaAccidente(final String causaAccidente) {
		this.causaAccidente = causaAccidente;
	}

	/**
	 * mfernandez 20 de enero 2015
	 * @return el como ocurrio
	 */
	public String getComoOcurrio() {
		return comoOcurrio;
	}

	/**
	 * mfernandez 20 de enero 2015
	 * @param comoOcurrio
	 */
	public void setComoOcurrio(final String comoOcurrio) {
		this.comoOcurrio = comoOcurrio;
	}
}
