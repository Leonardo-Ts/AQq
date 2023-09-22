package com.aaq.col.clases.database.entidades.abstracto;

 import java.sql.Timestamp;

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
 public abstract class AbstractLogFormatosAjustadorError extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opLogAjustadorSEQ", sequenceName = "log_formatos_ajustador_error_seq", allocationSize = 1)
	 @Id
	 @Column(name = "ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opLogAjustadorSEQ")
	 private Integer id;
	
	@Column(name="DESCRIPCION", length=4000)
	private String descripcion;

	@Column(name="NOMBRE_FORMATO", length=100)
	private String nombreFormato;

	@Column(name="FOLIO_FORMATO", length=30)
	private String folioFormato;

	@Column(name="FECHA_HORA")
	private Timestamp fechaHora;
    
    


	
	 
	// Constructors

	/** default constructor */
	public AbstractLogFormatosAjustadorError() {
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}






	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}






	/**
	 * @return the nombreFormato
	 */
	public String getNombreFormato() {
		return nombreFormato;
	}






	/**
	 * @param nombreFormato the nombreFormato to set
	 */
	public void setNombreFormato(String nombreFormato) {
		this.nombreFormato = nombreFormato;
	}






	/**
	 * @return the folioFormato
	 */
	public String getFolioFormato() {
		return folioFormato;
	}






	/**
	 * @param folioFormato the folioFormato to set
	 */
	public void setFolioFormato(String folioFormato) {
		this.folioFormato = folioFormato;
	}






	/**
	 * @return the fechaHora
	 */
	public Timestamp getFechaHora() {
		return fechaHora;
	}






	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	
	








 }

