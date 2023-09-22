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
public abstract class AbstractCatalogoMP extends JMEntidad{

	private static final long serialVersionUID = -5875010812857951261L;

	@SequenceGenerator(name = "catalogo_MPSEQ", sequenceName = "CATALOGO_MP_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_MPSEQ")
	private Integer id;
	
	@Column(name = "clave", nullable = false, unique = true)
	private String clave;
	
	@Column(name = "ID_ENTIDAD", nullable = false, unique = true)
	private String idEntidad;
	
	@Column(name = "ID_MUNICIPIO", nullable = false, unique = true)
	private String idMunicipio;
	
	@Column(name = "DESCRIPCION", nullable = false, unique = true)
	private String descripcion;
	
	@Column(name = "DIRECCION", nullable = false, unique = true)
	private String direccion;
	
	@Column(name = "MUNICIPIO_LEGAL", nullable = false, unique = true)
	private String municipioLegal;
	
	@Column(name = "ENTIDAD", nullable = false, unique = true)
	private String entidad;
	
	@Column(name = "MUNICIPIO", nullable = false, unique = true)
	private String municipio;

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

	public String getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
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

	public String getMunicipioLegal() {
		return municipioLegal;
	}

	public void setMunicipioLegal(String municipioLegal) {
		this.municipioLegal = municipioLegal;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	
	

}
