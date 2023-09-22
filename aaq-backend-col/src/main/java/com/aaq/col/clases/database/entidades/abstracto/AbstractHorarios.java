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

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractHorarios entity provides the base persistence definition of the
 * Horarios entity. @author MyEclipse Persistence Tools
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractHorarios extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6887126282626979698L;

	@SequenceGenerator(name = "horariosSEQ", sequenceName = "catalogo_horarios_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "horariosSEQ")
	private Integer id;

	@Column(name = "clave_horario", length = 255, nullable = false, unique = false)
	private String clave_horario;
	
	@Column(name = "dia_semana_num")
	private int dia_semana_num;

	@Column(name = "hora_entrada", length = 255, nullable = false, unique = false)
	private String hora_entrada;
	
	@Column(name = "hora_salida", length = 255, nullable = false, unique = false)
	private String hora_salida;
	
	@Column(name = "descanso", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean descanso;
	
	@Column(name = "dia_semana", length = 255, nullable = false, unique = false)
	private String dia_semana;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "identidad", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;
	
	@Column(name = "identidad", nullable = false, unique = true, insertable = false, updatable = false)
	private Integer identidad_;
	

	/** default constructor */
	public AbstractHorarios() {
		super();
	}
	
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDescanso() {
		return descanso;
	}

	public void setDescanso(Boolean descanso) {
		this.descanso = descanso;
	}

	public String getClave_horario() {
		return clave_horario;
	}

	public void setClave_horario(String clave_horario) {
		this.clave_horario = clave_horario;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public int getDia_semana_num() {
		return dia_semana_num;
	}

	public void setDia_semana_num(int dia_semana_num) {
		this.dia_semana_num = dia_semana_num;
	}

	public String getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}

	public Integer getIdentidad_() {
		return identidad_;
	}

	public void setIdentidad_(Integer identidad_) {
		this.identidad_ = identidad_;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}