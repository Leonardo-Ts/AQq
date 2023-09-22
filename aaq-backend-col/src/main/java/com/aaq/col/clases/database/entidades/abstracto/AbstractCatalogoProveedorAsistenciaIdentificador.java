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

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractCatalogoProveedorAsistenciaIdentificador entity provides the base
 * persistence definition of the CatalogoProveedorAsistenciaIdentificador
 * entity. @author mfernandez Fernandez
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoProveedorAsistenciaIdentificador extends JMEntidad {

	private static final long serialVersionUID = 8812417368012726080L;

	@SequenceGenerator(name = "catalogo_proveedor_asistencia_identificadorSEQ", sequenceName = "CATALOGO_PROVEEDOR_ASIST_ID_S", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_proveedor_asistencia_identificadorSEQ")
	private Integer id;

	@Column(name = "numero", nullable = false, unique = false)
	private Integer numero;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CatalogoProveedorAsistencia.class)
	@JoinColumn(name = "ID_CATALOGO_PROVEEDOR_ASIST", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private CatalogoProveedorAsistencia catalogoProveedorAsistencia;

	// Constructors

	/** default constructor */
	public AbstractCatalogoProveedorAsistenciaIdentificador() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:12 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:12 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:12 PM
	 * 
	 * @return the numero
	 */
	public Integer getNumero() {
		return this.numero;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:12 PM
	 * 
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:12 PM
	 * 
	 * @return the catalogoProveedorAsistencia
	 */
	public CatalogoProveedorAsistencia getCatalogoProveedorAsistencia() {
		return this.catalogoProveedorAsistencia;
	}

	/**
	 * mfernandez Aug 7, 2014 3:23:12 PM
	 * 
	 * @param catalogoProveedorAsistencia
	 *            the catalogoProveedorAsistencia to set
	 */
	public void setCatalogoProveedorAsistencia(final CatalogoProveedorAsistencia catalogoProveedorAsistencia) {
		this.catalogoProveedorAsistencia = catalogoProveedorAsistencia;
	}

}