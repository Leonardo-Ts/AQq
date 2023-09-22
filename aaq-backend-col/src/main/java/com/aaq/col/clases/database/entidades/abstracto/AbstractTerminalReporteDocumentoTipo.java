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
public abstract class AbstractTerminalReporteDocumentoTipo extends JMEntidad {
	static final long serialVersionUID = -4667253348127852766L;

	@SequenceGenerator(name = "terminal_reporte_documento_tipoSEQ", sequenceName = "TERMINAL_REPORTE_DOC_TIPO_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_reporte_documento_tipoSEQ")
	private Integer id;

	@Column(name = "tipo", length = 255, nullable = true, unique = true)
	private String tipo;

	@Column(name = "clave", length = 255, nullable = true, unique = true)
	private String clave;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	// Constructors

	/** default constructor */
	public AbstractTerminalReporteDocumentoTipo() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @return the clave
	 */
	public String getClave() {
		return this.clave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(final String clave) {
		this.clave = clave;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 4:49:22 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

}