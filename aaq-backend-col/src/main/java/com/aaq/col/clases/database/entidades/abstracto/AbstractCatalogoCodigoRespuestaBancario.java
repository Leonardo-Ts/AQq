/*
 * Propietario y confidencial.
 *
 * Copyright (C) Integracion de Sistemas de Avanzada Tecnologia, SA de CV - Todos los Derechos Reservados.
 * La copia no autorizada de este archivo, por cualquier medio, esta estrictamente prohibida
 * Los contenidos de este archivo estan sujetos a cambio en cualquier momento sin aviso previo.
 * Este documento no confiere al receptor el derecho o licencia de hacer, usar, vender o practicar cualquier
 * tecnologia o metodos descritos en el mismo.
 * Ninguno de los contenidos, en su totalidad o en partes, pueden ser copiados o distribidos por cualquier
 * medio fisico o electronico sin el consentimiento previo, expreso y escrito de
 * Integracion de  Sistemas de Avanzada Tecnologia
 *
 * Proprietary and confidential
 *
 * Copyright (C) Controltrack, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * All information contained herein is, and remains
 * the property of Controltrack Inc and its suppliers, if any.
 * The intellectual and technical concepts contained herein are proprietary to Controltrack Inc.
 *
 *
 * Desarrolloado por Jose Miguel Fernandez <mfernandez@controltrack.net>, Octubre 2005 - Marzo 2015
 *
 *
 */

package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.eclipse.persistence.annotations.Convert;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoCodigoRespuestaBancario extends JMEntidad {

	private static final long serialVersionUID = -4258113056903320192L;

	@SequenceGenerator(name = "catalogo_codigo_respuesta_bancarioSEQ", sequenceName = "CATALOGO_CODIGO_RESPUESTA_BAN", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_codigo_respuesta_bancarioSEQ")
	private Integer id;

	@Column(name = "codigoiso", length = 255, nullable = false, unique = true)
	private String codigoiso;

	@Column(name = "codigob24", length = 255, nullable = false, unique = true)
	private String codigob24;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "advertencia", nullable = false, unique = false)
	@Convert("booleanConverter")
	private Boolean advertencia;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	// Constructors

	/** default constructor */
	public AbstractCatalogoCodigoRespuestaBancario() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @return the codigoiso
	 */
	public String getCodigoiso() {
		return this.codigoiso;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @param codigoiso
	 *            the codigoiso to set
	 */
	public void setCodigoiso(final String codigoiso) {
		this.codigoiso = codigoiso;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @return the codigob24
	 */
	public String getCodigob24() {
		return this.codigob24;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @param codigob24
	 *            the codigob24 to set
	 */
	public void setCodigob24(final String codigob24) {
		this.codigob24 = codigob24;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @return the advertencia
	 */
	public Boolean getAdvertencia() {
		return this.advertencia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @param advertencia
	 *            the advertencia to set
	 */
	public void setAdvertencia(final Boolean advertencia) {
		this.advertencia = advertencia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:20:14 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

}