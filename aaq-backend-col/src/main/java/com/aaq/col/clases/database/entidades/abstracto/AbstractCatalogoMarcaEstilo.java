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

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoMarcaEstilo extends JMEntidad {

	private static final long serialVersionUID = -7171269400536735555L;

	@SequenceGenerator(name = "catalogo_marca_estiloSEQ", sequenceName = "catalogo_marca_estilo_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_marca_estiloSEQ")
	private Integer id;

	@Column(name = "clave", length = 255, nullable = false, unique = true)
	private String clave;

	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CatalogoMarca.class)
	@JoinColumn(name = "id_catalogo_marca", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private CatalogoMarca catalogoMarca;

	// Constructors

	/** default constructor */
	public AbstractCatalogoMarcaEstilo() {
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @return the clave
	 */
	public String getClave() {
		return this.clave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(final String clave) {
		this.clave = clave;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @return the catalogoMarca
	 */
	public CatalogoMarca getCatalogoMarca() {
		return this.catalogoMarca;
	}

	/**
	 * mfernandez Aug 7, 2014 3:21:19 PM
	 * 
	 * @param catalogoMarca
	 *            the catalogoMarca to set
	 */
	public void setCatalogoMarca(final CatalogoMarca catalogoMarca) {
		this.catalogoMarca = catalogoMarca;
	}

}