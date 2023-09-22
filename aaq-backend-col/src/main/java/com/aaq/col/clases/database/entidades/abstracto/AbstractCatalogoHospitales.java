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
public abstract class AbstractCatalogoHospitales extends JMEntidad {

	private static final long serialVersionUID = 4398684287294970849L;

	@SequenceGenerator(name = "catalogo_hospitalesSEQ", sequenceName = "CATALOGO_HOSPITALES_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_hospitalesSEQ")
	private Integer id;

	@Column(name = "CLAVE", length = 255, nullable = false, unique = false)
	private String clave;

	@Column(name = "DESCRIPCION", length = 255, nullable = true, unique = true)
	private String descripcion;
	
	@Column(name = "DIRECCION", length = 255, nullable = false, unique = true)
	private String direccion;
	
	@Column(name = "TELEFONO", length = 255, nullable = false, unique = true)
	private String telefono;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
