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
public abstract class AbstractCatalogoTramoCar extends JMEntidad {

	private static final long serialVersionUID = -702717177528434085L;
	

	@SequenceGenerator(name = "catalogo_tramoCarretSEQ", sequenceName = "CATALOGO_TRAMO_CARRET_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_tramoCarretSEQ")
	private Integer id;


	@Column(name = "CLAVE", length = 255, nullable = true, unique = true)
	private String clave;
	
	@Column(name = "DESCRIPCION", length = 255, nullable = false, unique = true)
	private String descripcion;

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

	public AbstractCatalogoTramoCar() {
		super();
	}
	

	
}
