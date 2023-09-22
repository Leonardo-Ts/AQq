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
public abstract class AbstractCatalogoFaq extends JMEntidad {

	private static final long serialVersionUID = -4258113056903320192L;

	@SequenceGenerator(name = "CATALOGO_FaqSeq", sequenceName = "CATALOGO_FAQ_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATALOGO_FaqSeq")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = false, unique = true)
	private String clave;
	
	@Column(name = "descripcion", length = 255, nullable = false, unique = true)
	private String descripcion;
	
	@Column(name = "MENSAJE", length = 255, nullable = false, unique = true)
	private String mensaje;
	
	@Column(name = "RESPONSABLE", length = 255, nullable = false, unique = true)
	private String responsable;

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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	

}
