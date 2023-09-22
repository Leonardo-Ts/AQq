package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aaq.col.clases.database.entidades.Grupo;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractHorarioGrupo extends JMEntidad {

	private static final long serialVersionUID = -1707526951045462434L;

	@SequenceGenerator(name = "horario_gruposSEQ", sequenceName = "horario_grupos_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "horario_gruposSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Grupo.class)
	@JoinColumn(name = "idgrupo", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Grupo grupo;

	@JoinColumn(name = "clavehorario", referencedColumnName = "clavehorario", nullable = false)
	private String claveHorario;
	
	@Column(name = "fechainicio", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Column(name = "fechafin", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	// Constructors

	/** default constructor */
	public AbstractHorarioGrupo() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getClaveHorario() {
		return claveHorario;
	}

	public void setClaveHorario(String claveHorario) {
		this.claveHorario = claveHorario;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


}