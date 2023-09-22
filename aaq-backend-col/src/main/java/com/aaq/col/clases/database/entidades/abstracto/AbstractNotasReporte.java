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

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractNotasReporte extends JMEntidad{
	
	private static final long serialVersionUID = 854638115259644855L;
	
	@SequenceGenerator(name = "notasReporteSeq", sequenceName = "NOTAS_REPORTE_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notasReporteSeq")
	private Integer id;

	@Column(name = "NOTAS", nullable = false, unique = true)
	private String notas;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "ID_TERMINAL", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;
	
	@Column(name = "FECHA", nullable = true, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@Column(name = "USUARIO", nullable = false, unique = true)
	private String usuario;
	
	@Column(name = "REPORTE", nullable = false, unique = true)
	private String reporte;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "ID_ESTADO", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Base.class)
	@JoinColumn(name = "ID_BASE", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Base base;
	
	@Column(name = "CAUSA_NOTA", nullable = false, unique = true)
	private String causaNota;

	
	public AbstractNotasReporte() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	public String getCausaNota() {
		return causaNota;
	}

	public void setCausaNota(String causaNota) {
		this.causaNota = causaNota;
	}
	
}
