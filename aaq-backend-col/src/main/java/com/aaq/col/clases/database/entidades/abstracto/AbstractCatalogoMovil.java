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
public abstract class AbstractCatalogoMovil extends JMEntidad {

	private static final long serialVersionUID = -1886009148488838355L;
	
	@Id
	@SequenceGenerator(name="CATALOGO_MOVIL_ID_GENERATOR", sequenceName="CATALOGO_MOVIL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOGO_MOVIL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=50)
	private String marca;

	@Column(nullable=false, length=50)
	private String modelo;

	public AbstractCatalogoMovil() {
		super();
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
