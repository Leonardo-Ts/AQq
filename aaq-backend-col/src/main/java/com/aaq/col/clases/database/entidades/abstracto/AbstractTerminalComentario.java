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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTerminalComentario  extends JMEntidad {

	private static final long serialVersionUID = 4591826624695440253L;

	@Id
	@SequenceGenerator(name="TERMINAL_COMENTARIOS_ID_GENERATOR", sequenceName="TERMINAL_COMENTARIOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TERMINAL_COMENTARIOS_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "COMENTARIO" , length=500, nullable = true, unique = false)
	private String comentario;

	@Column(name = "FECHA", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	@Column(name = "USUARIO", length=40, nullable = true, unique = false)
	private String usuario;
	
	@Column(name = "USUARIO_VISTO", length=40, nullable = true, unique = false)
	private String usuarioVisto;

	public AbstractTerminalComentario() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioVisto() {
		return usuarioVisto;
	}

	public void setUsuarioVisto(String usuarioVisto) {
		this.usuarioVisto = usuarioVisto;
	}
	

}
