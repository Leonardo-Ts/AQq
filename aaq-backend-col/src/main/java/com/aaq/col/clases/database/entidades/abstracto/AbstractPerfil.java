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

import com.aaq.col.clases.database.entidades.CatalogoRoles;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractPerfil extends JMEntidad {

	private static final long serialVersionUID = -1802005569228013567L;

	@SequenceGenerator(name = "perfilSEQ", sequenceName = "perfil_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfilSEQ")
	private Integer id;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoRoles.class)
	@JoinColumn(name = "idrol", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoRoles rol;
	
	// Constructors

	/** default constructor */
	public AbstractPerfil() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:58 PM
	 * 
	 * @return the id
	 */
//	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:58 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:58 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:58 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:58 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:51:58 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	/***
	 * Catalogo Roles
	 * @return
	 */
	
	public CatalogoRoles getRol() {
		return this.rol;
	}

	public void setRol(final CatalogoRoles rol) {
		this.rol = rol;
	}

}