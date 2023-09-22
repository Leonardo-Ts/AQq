package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractUsuarioAlertas extends JMEntidad {

	private static final long serialVersionUID = -8416180146469987854L;

	@SequenceGenerator(name = "usuarioAlertasSEQ", sequenceName = "usuario_alertas_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioAlertasSEQ")
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private Usuario usuario;
	
	@Column(name = "TIEMPO_LIBRE", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean tiempoLibre;
	
	@Column(name = "TIEMPO_OCUPADO", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean tiempoOcupado;
	
	@Column(name = "ARRIBO_POST_TIEMPO", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean arriboPostTiempo;
	
	@Column(name = "LOGIN", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean login;
	
	@Column(name = "LOGOUT", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean logout;
	
	@Column(name = "TIPO_ALERTA", length = 15, nullable = false, unique = false)
	private String tipoAlerta;
	
	@Column(name = "NO_DISPONIBLES", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean noDisponibles;
	
	@Column(name = "TERMINO_DISTANCIA", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean terminoDistancia;
	

	// Constructors
	/** default constructor */
	public AbstractUsuarioAlertas() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getTiempoLibre() {
		return tiempoLibre;
	}

	public void setTiempoLibre(Boolean tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}

	public Boolean getTiempoOcupado() {
		return tiempoOcupado;
	}

	public void setTiempoOcupado(Boolean tiempoOcupado) {
		this.tiempoOcupado = tiempoOcupado;
	}

	public Boolean getArriboPostTiempo() {
		return arriboPostTiempo;
	}

	public void setArriboPostTiempo(Boolean arriboPostTiempo) {
		this.arriboPostTiempo = arriboPostTiempo;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public Boolean getLogout() {
		return logout;
	}

	public void setLogout(Boolean logout) {
		this.logout = logout;
	}

	public String getTipoAlerta() {
		return tipoAlerta;
	}

	public void setTipoAlerta(String tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}
	
	public Boolean getNoDisponibles() {
		return noDisponibles;
	}

	public void setNoDisponibles(Boolean noDisponibles) {
		this.noDisponibles = noDisponibles;
	}

	/**
	 * @return the terminoDistancia
	 */
	public Boolean getTerminoDistancia() {
		return terminoDistancia;
	}

	/**
	 * @param terminoDistancia the terminoDistancia to set
	 */
	public void setTerminoDistancia(Boolean terminoDistancia) {
		this.terminoDistancia = terminoDistancia;
	}

}
