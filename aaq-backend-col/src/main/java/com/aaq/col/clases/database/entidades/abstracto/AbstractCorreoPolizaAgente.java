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

/**
 * AbstractTerminalLog entity provides the base persistence definition of the
 * TerminalLog entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCorreoPolizaAgente extends JMEntidad {

	private static final long serialVersionUID = 4491205666350610773L;

	@SequenceGenerator(name = "correo_poliza_agenteSEQ", sequenceName = "correo_poliza_agente_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "correo_poliza_agenteSEQ")
	private Integer id;

	@Column(name = "clave_agente", length = 255, nullable = false, unique = true)
	private String claveAgente;

	@Column(name = "poliza", length = 255, nullable = false, unique = true)
	private String poliza;

	@Column(name = "correos", length = 500, nullable = false, unique = true)
	private String correos;
	
	
	// Constructors

		/** default constructor */
	public AbstractCorreoPolizaAgente() {
	 		super();
		}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the claveAgente
	 */
	public String getClaveAgente() {
		return claveAgente;
	}

	/**
	 * @param claveAgente the claveAgente to set
	 */
	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}

	/**
	 * @return the poliza
	 */
	public String getPoliza() {
		return poliza;
	}

	/**
	 * @param poliza the poliza to set
	 */
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	/**
	 * @return the correos
	 */
	public String getCorreos() {
		return correos;
	}

	/**
	 * @param correos the correos to set
	 */
	public void setCorreos(String correos) {
		this.correos = correos;
	}
	
	
	

}