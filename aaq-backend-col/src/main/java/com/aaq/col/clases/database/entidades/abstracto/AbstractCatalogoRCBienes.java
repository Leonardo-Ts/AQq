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
public abstract class AbstractCatalogoRCBienes extends JMEntidad {

	private static final long serialVersionUID = 2866203498333953369L;

	@SequenceGenerator(name = "catalogo_rcbienesSEQ", sequenceName = "CATALOGO_RC_BIENES_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_rcbienesSEQ")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = false, unique = false)
	private String clave;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;
	
	@Column(name = "TIPO_AFECTA", length = 255, nullable = true, unique = false)
	private String tipoAfecta;

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

	public String getTipoAfecta() {
		return tipoAfecta;
	}

	public void setTipoAfecta(String tipoAfecta) {
		this.tipoAfecta = tipoAfecta;
	}
	
	
	
}
