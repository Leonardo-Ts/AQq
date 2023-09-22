package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoCoberturas extends JMEntidad {

	private static final long serialVersionUID = -1136949136291797278L;

	@SequenceGenerator(name = "catalogo_coberturasSEQ", sequenceName = "CATALOGO_COBERTURAS_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_coberturasSEQ")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = false, unique = false)
	private String clave;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;

	// Constructors

	/** default constructor */
	public AbstractCatalogoCoberturas() {
		super();
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(final String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
}