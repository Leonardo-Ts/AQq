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

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractControlFotografias extends JMEntidad {

	private static final long serialVersionUID = 3913875334908291881L;
	
	@SequenceGenerator(name = "controlFotosSEQ", sequenceName = "CONTROL_FOTOGRAFIAS_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "controlFotosSEQ")
	private Integer id;

	@Column(name = "NOMBRE_FOTO", length = 250, nullable = false)
	private String nombreFoto;
	
	@Column(name = "NUM_REPORTE", length = 20, nullable = false)
	private String numReporte;
	
	@Column(name = "CLAVE_DOCUMENTAL", length = 50, nullable = false)
	private String claveDocumental;
	
	@Column(name = "afectado", length = 20, nullable = false)
	private String afectado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "ID_TERMINAL" , referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Terminal terminal;
	
	@Column(name = "FECHA", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "ENVIADO", nullable = false, unique = true)
	@Convert("booleanConverter")
	private Boolean enviado;
	
	@Column(name = "AJUSTADOR", length = 255, nullable = false)
	private String ajustador;
	
	@Column(name = "DETALLE", length = 500, nullable = false)
	private String detalle;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "ID_IDENTIDAD" , referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Base.class)
	@JoinColumn(name = "ID_ZONA" , referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Base base;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public String getNumReporte() {
		return numReporte;
	}

	public void setNumReporte(String numReporte) {
		this.numReporte = numReporte;
	}

	public String getClaveDocumental() {
		return claveDocumental;
	}

	public void setClaveDocumental(String claveDocumental) {
		this.claveDocumental = claveDocumental;
	}

	public String getAfectado() {
		return afectado;
	}

	public void setAfectado(String afectado) {
		this.afectado = afectado;
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

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	public String getAjustador() {
		return ajustador;
	}

	public void setAjustador(String ajustador) {
		this.ajustador = ajustador;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	
}
