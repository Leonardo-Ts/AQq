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
public abstract class AbstractCatalogoCodigoResponsabilidad extends JMEntidad {

	private static final long serialVersionUID = -1136949136291797278L;

	@SequenceGenerator(name = "catalogo_codigo_responsSEQ", sequenceName = "catalogo_codigo_respons_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_codigo_responsSEQ")
	private Integer id;

	@Column(name = "codigo", length = 255, nullable = false, unique = false)
	private String codigo;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;

	// Constructors

	/** default constructor */
	public AbstractCatalogoCodigoResponsabilidad() {
		super();
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
}