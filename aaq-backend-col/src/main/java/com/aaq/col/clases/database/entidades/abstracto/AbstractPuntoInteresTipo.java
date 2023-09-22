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

/**
 * AbstractPuntoInteresTipo entity provides the base persistence definition of
 * the PuntoInteresTipo entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractPuntoInteresTipo extends JMEntidad {

	private static final long serialVersionUID = -8466852995659019402L;

	@SequenceGenerator(name = "punto_interes_tipoSEQ", sequenceName = "punto_interes_tipo_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "punto_interes_tipoSEQ")
	private Integer id;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "nombre", length = 255, nullable = false, unique = true)
	private String nombre;

	@Column(name = "icono", length = 255, nullable = true, unique = false)
	private String icono;

	@Column(name = "largo", length = 255, nullable = true, unique = false)
	private String largo;

	@Column(name = "ancho", length = 255, nullable = true, unique = false)
	private String ancho;

	@Column(name = "habilitado", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean habilitado;

	// Constructors

	/** default constructor */
	public AbstractPuntoInteresTipo() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @return the icono
	 */
	public String getIcono() {
		return this.icono;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @param icono
	 *            the icono to set
	 */
	public void setIcono(final String icono) {
		this.icono = icono;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @return the habilitado
	 */
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	/**
	 * mfernandez Aug 7, 2014 3:54:11 PM
	 * 
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(final Boolean habilitado) {
		this.habilitado = habilitado;
	}

	/**
	 * mfernandez Aug 16, 2014 9:14:00 PM
	 * 
	 * @return the largo
	 */
	public String getLargo() {
		return this.largo;
	}

	/**
	 * mfernandez Aug 16, 2014 9:14:00 PM
	 * 
	 * @param largo
	 *            the largo to set
	 */
	public void setLargo(final String largo) {
		this.largo = largo;
	}

	/**
	 * mfernandez Aug 16, 2014 9:14:00 PM
	 * 
	 * @return the ancho
	 */
	public String getAncho() {
		return this.ancho;
	}

	/**
	 * mfernandez Aug 16, 2014 9:14:00 PM
	 * 
	 * @param ancho
	 *            the ancho to set
	 */
	public void setAncho(final String ancho) {
		this.ancho = ancho;
	}

}