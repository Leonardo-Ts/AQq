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

import com.aaq.col.clases.database.entidades.Grupo;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractGuardiaGrupo extends JMEntidad {

	private static final long serialVersionUID = -1707526951045462434L;

	@SequenceGenerator(name = "guardias_grupoSEQ", sequenceName = "guardias_grupo_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guardias_grupoSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Grupo.class)
	@JoinColumn(name = "idgrupo", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Grupo grupo;

	@Column(name = "lunes", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean lunesGuardia;
	
	@Column(name = "martes", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean martesGuardia;
	
	@Column(name = "miercoles", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean miercolesGuardia;
	
	@Column(name = "jueves", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean juevesGuardia;
	
	@Column(name = "viernes", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean viernesGuardia;
	
	@Column(name = "sabado", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean sabadoGuardia;
	
	@Column(name = "domingo", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean domingoGuardia;
	
	@Column(name = "activar", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean activarGuardia;

	// Constructors

	/** default constructor */
	public AbstractGuardiaGrupo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Boolean getLunesGuardia() {
		return lunesGuardia;
	}

	public void setLunesGuardia(Boolean lunesGuardia) {
		this.lunesGuardia = lunesGuardia;
	}

	public Boolean getMartesGuardia() {
		return martesGuardia;
	}

	public void setMartesGuardia(Boolean martesGuardia) {
		this.martesGuardia = martesGuardia;
	}

	public Boolean getMiercolesGuardia() {
		return miercolesGuardia;
	}

	public void setMiercolesGuardia(Boolean miercolesGuardia) {
		this.miercolesGuardia = miercolesGuardia;
	}

	public Boolean getJuevesGuardia() {
		return juevesGuardia;
	}

	public void setJuevesGuardia(Boolean juevesGuardia) {
		this.juevesGuardia = juevesGuardia;
	}

	public Boolean getViernesGuardia() {
		return viernesGuardia;
	}

	public void setViernesGuardia(Boolean viernesGuardia) {
		this.viernesGuardia = viernesGuardia;
	}

	public Boolean getSabadoGuardia() {
		return sabadoGuardia;
	}

	public void setSabadoGuardia(Boolean sabadoGuardia) {
		this.sabadoGuardia = sabadoGuardia;
	}

	public Boolean getDomingoGuardia() {
		return domingoGuardia;
	}

	public void setDomingoGuardia(Boolean domingoGuardia) {
		this.domingoGuardia = domingoGuardia;
	}

	public Boolean getActivarGuardia() {
		return activarGuardia;
	}

	public void setActivarGuardia(Boolean activarGuardia) {
		this.activarGuardia = activarGuardia;
	}
	
	

}