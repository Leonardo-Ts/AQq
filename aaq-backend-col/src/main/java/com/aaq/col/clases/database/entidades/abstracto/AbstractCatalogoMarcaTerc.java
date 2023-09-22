package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
@ObjectTypeConverter(
		name="booleanConverter",
		dataType=java.lang.String.class,
		objectType=java.lang.Boolean.class,
		conversionValues={
			@ConversionValue(dataValue="t", objectValue="true"),
			@ConversionValue(dataValue="f", objectValue="false")
		},
		defaultObjectValue="false"
)
public abstract class AbstractCatalogoMarcaTerc extends JMEntidad{

	private static final long serialVersionUID = -8479350966544846603L;

	@SequenceGenerator(name = "catalogoMarcaTercSEQ", sequenceName = "CATALOGO_MARCA_TERC_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogoMarcaTercSEQ")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = false, unique = true)
	private String clave;
	
	@Column(name = "descripcion", length = 255, nullable = false, unique = true)
	private String descripcion;
	
	@Column(name = "AUTOS_SUBCOMPACTOS", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean subCompactos;
	
	@Column(name = "SEMIPESADO", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean semipesado;
	
	@Column(name = "PESADO", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean pesado;
	
	@Column(name = "MOTOS", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean motos;
	
	@Column(name = "BLINDADO", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean blindado;

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

	public Boolean getSubCompactos() {
		return subCompactos;
	}

	public void setSubCompactos(Boolean subCompactos) {
		this.subCompactos = subCompactos;
	}

	public Boolean getSemipesado() {
		return semipesado;
	}

	public void setSemipesado(Boolean semipesado) {
		this.semipesado = semipesado;
	}

	public Boolean getPesado() {
		return pesado;
	}

	public void setPesado(Boolean pesado) {
		this.pesado = pesado;
	}

	public Boolean getMotos() {
		return motos;
	}

	public void setMotos(Boolean motos) {
		this.motos = motos;
	}

	public Boolean getBlindado() {
		return blindado;
	}

	public void setBlindado(Boolean blindado) {
		this.blindado = blindado;
	}
	
	
	
	
}
