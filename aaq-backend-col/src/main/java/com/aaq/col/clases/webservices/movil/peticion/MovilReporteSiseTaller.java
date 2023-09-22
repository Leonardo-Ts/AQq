package com.aaq.col.clases.webservices.movil.peticion;

public class MovilReporteSiseTaller {
	private String id;

	private String codigo;

	private String nombre;

	private String tipo;

	private String tipoAfectado;

	private String indiceTercero;

	private String vale;

	private String notas;

	/**
	 *  Dec 9, 2013 2:51:44 PM
	 */
	public MovilReporteSiseTaller() {
		super();
	}

	/**
	 *  Dec 9, 2013 2:54:14 PM
	 * 
	 * @param id
	 * @param codigo
	 * @param nombre
	 * @param tipo
	 * @param tipoAfectado
	 * @param indiceTercero
	 * @param vale
	 * @param notas
	 */
	public MovilReporteSiseTaller(final String id, final String codigo, final String nombre, final String tipo,
			final String tipoAfectado, final String indiceTercero, final String vale, final String notas) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.tipoAfectado = tipoAfectado;
		this.indiceTercero = indiceTercero;
		this.vale = vale;
		this.notas = notas;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the tipoAfectado
	 */
	public String getTipoAfectado() {
		return this.tipoAfectado;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param tipoAfectado
	 *            the tipoAfectado to set
	 */
	public void setTipoAfectado(final String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the indiceTercero
	 */
	public String getIndiceTercero() {
		return this.indiceTercero;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param indiceTercero
	 *            the indiceTercero to set
	 */
	public void setIndiceTercero(final String indiceTercero) {
		this.indiceTercero = indiceTercero;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the vale
	 */
	public String getVale() {
		return this.vale;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param vale
	 *            the vale to set
	 */
	public void setVale(final String vale) {
		this.vale = vale;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @return the notas
	 */
	public String getNotas() {
		return this.notas;
	}

	/**
	 *  Dec 9, 2013 2:54:03 PM
	 * 
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(final String notas) {
		this.notas = notas;
	}

}
