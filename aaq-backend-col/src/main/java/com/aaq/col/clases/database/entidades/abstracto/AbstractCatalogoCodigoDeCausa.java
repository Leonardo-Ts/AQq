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
public abstract class AbstractCatalogoCodigoDeCausa extends JMEntidad {

	private static final long serialVersionUID = 5123098927276477792L;

	@SequenceGenerator(name = "catalogo_codigo_de_causaSEQ", sequenceName = "catalogo_codigo_de_causa_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_codigo_de_causaSEQ")
	private Integer id;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "clave", length = 255, nullable = true, unique = true)
	private String clave;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;
	

	@Column(name = "CODIGO_ACCI", length = 255, nullable = true, unique = true)
	private String codigoAcci;
	
	public AbstractCatalogoCodigoDeCausa() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public Boolean getHabilitado() {
		return habilitado;
	}



	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}



	public String getCodigoAcci() {
		return codigoAcci;
	}



	public void setCodigoAcci(String codigoAcci) {
		this.codigoAcci = codigoAcci;
	}



}