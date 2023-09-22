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
public abstract class AbstractCatalogoCredenciales extends JMEntidad {

	private static final long serialVersionUID = -5508355442561805962L;

	@SequenceGenerator(name = "catalogo_credencialesSEQ", sequenceName = "CATALOGO_CREDENCIALES_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_credencialesSEQ")
	private Integer id;

	@Column(name = "NOMBRE",  nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "URL",  nullable = false, unique = true)
	private String url;
	
	@Column(name = "DIRECCION",  nullable = false, unique = true)
	private String direccion;
	
	@Column(name = "PWD",  nullable = false, unique = true)
	private String pwd;
	
	@Column(name = "USUARIO",  nullable = false, unique = true)
	private String usuario;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
