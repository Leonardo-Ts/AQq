package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractModulo entity provides the base persistence definition of the Modulo
 * entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass

public abstract class AbstractModulo extends JMEntidad {

	private static final long serialVersionUID = -2566152903861267463L;

	@SequenceGenerator(name = "moduloSEQ", sequenceName = "modulo_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moduloSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "nombresiicav3", length = 255, nullable = true, unique = true)
	private String nombresiicav3;

	@Column(name = "pagina", length = 255, nullable = true, unique = true)
	private String pagina;

	@Column(name = "nombrecorto", length = 255, nullable = true, unique = false)
	private String nombrecorto;

	@Column(name = "descripcion", length = 255, nullable = true, unique = false)
	private String descripcion;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@Column(name = "accion", length = 255, nullable = true, unique = false)
	private String accion;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ModuloPadre.class)
	@JoinColumn(name = "idmodulopadre", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private ModuloPadre moduloPadre;

	// Constructors

	/** default constructor */
	public AbstractModulo() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:47:56 PM
	 * 
	 * @return the id
	 */
//	@Override
	public Integer getId() {
		return this.id;
	}
	
	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getNombresiicav3() {
		return this.nombresiicav3;
	}

	public void setNombresiicav3(final String nombresiicav3) {
		this.nombresiicav3 = nombresiicav3;
	}

	public String getPagina() {
		return this.pagina;
	}

	public void setPagina(final String pagina) {
		this.pagina = pagina;
	}

	public String getNombrecorto() {
		return this.nombrecorto;
	}

	public void setNombrecorto(final String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(final String accion) {
		this.accion = accion;
	}

	public ModuloPadre getModuloPadre() {
		return this.moduloPadre;
	}

	public void setModuloPadre(final ModuloPadre moduloPadre) {
		this.moduloPadre = moduloPadre;
	}

}