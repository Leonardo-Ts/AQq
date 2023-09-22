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
 public abstract class AbstractFormatoCatalogos extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "catalogosSEQ", sequenceName = "FORMATO_CATALOGOS_SEQ", allocationSize = 1) /// SE PUEDE COMENTAR CREO
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogosSEQ")
	private Integer id;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="VALORES")
	private String valores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	
	
	
 }

