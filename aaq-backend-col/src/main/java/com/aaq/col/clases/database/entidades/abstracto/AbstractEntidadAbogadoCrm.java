package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractEntidadAbogadoCrm extends JMEntidad {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7277464983559154816L;

	//@SequenceGenerator(name = "frecuenciaSEQ", sequenceName = "frecuencia_seq", allocationSize = 1)
	@Id
	@Column(name = "z_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frecuenciaSEQ")
	private Integer id;
	
	@Column(name = "edopob", length = 70, nullable = false, unique = true)
	private String edoPob;

	@Enumerated(EnumType.STRING)
	@Column(name = "estatus", nullable = true, unique = false)
	private Estatus abogadoCrmEstatus;

	@Column(name = "crm_abogado", nullable = true, unique = false)
	private Integer crmAbogado;

	// Constructors

	/** default constructor */
	public AbstractEntidadAbogadoCrm() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:34:05 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:34:05 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the edoPob
	 */
	public String getEdoPob() {
		return edoPob;
	}

	/**
	 * @param edoPob
	 *            the edoPob to set
	 */
	public void setEdoPob(String edoPob) {
		this.edoPob = edoPob;
	}

	/**
	 * @return the abogadoCrmEstatus
	 */
	public Estatus getAbogadoCrmEstatus() {
		return abogadoCrmEstatus;
	}

	/**
	 * @param abogadoCrmEstatus
	 *            the abogadoCrmEstatus to set
	 */
	public void setAbogadoCrmEstatus(Estatus abogadoCrmEstatus) {
		this.abogadoCrmEstatus = abogadoCrmEstatus;
	}

	/**
	 * @return the crmAbogado
	 */
	public Integer getCrmAbogado() {
		return crmAbogado;
	}

	/**
	 * @param crmAbogado
	 *            the crmAbogado to set
	 */
	public void setCrmAbogado(Integer crmAbogado) {
		this.crmAbogado = crmAbogado;
	}
	
	public enum Estatus {
	    A, I
	}
}