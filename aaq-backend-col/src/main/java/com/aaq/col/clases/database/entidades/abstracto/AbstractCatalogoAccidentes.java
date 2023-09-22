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
public abstract class AbstractCatalogoAccidentes extends JMEntidad {

	private static final long serialVersionUID = 773292040926506030L;

	@SequenceGenerator(name = "catalogo_accidentesSEQ", sequenceName = "CATALOGO_ACCIDENTES_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_accidentesSEQ")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = false, unique = false)
	private String clave;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;
	
	@Column(name = "codigo", length = 255, nullable = true, unique = false)
	private String codigo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
