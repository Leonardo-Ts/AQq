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

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCatalogoPartesAuto extends JMEntidad {

	private static final long serialVersionUID = -769982941163697105L;

	@SequenceGenerator(name = "catalogo_partesautoSEQ", sequenceName = "CATALOGO_PARTES_AUTO_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_partesautoSEQ")
	private Integer id;

	@Column(name = "TIPO_PARTE",  nullable = false, unique = false)
	private String tipoParte;
	
	@Column(name = "NUM_PARTE",  nullable = false, unique = false)
	private String numParte;
	
	@Column(name = "NOMBRE_PARTE",  nullable = false, unique = false)
	private String nombreParte;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoParte() {
		return tipoParte;
	}

	public void setTipoParte(String tipoParte) {
		this.tipoParte = tipoParte;
	}

	public String getNumParte() {
		return numParte;
	}

	public void setNumParte(String numParte) {
		this.numParte = numParte;
	}

	public String getNombreParte() {
		return nombreParte;
	}

	public void setNombreParte(String nombreParte) {
		this.nombreParte = nombreParte;
	}
	
	
}
