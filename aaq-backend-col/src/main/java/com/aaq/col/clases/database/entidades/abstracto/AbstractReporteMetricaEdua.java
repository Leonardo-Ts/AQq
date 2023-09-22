package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractReporteMetricaEdua extends JMEntidad {

	private static final long serialVersionUID = 3307990976251387576L;

	@SequenceGenerator(name = "reporteMetricaEDua", sequenceName = "REPORTE_METRICA_EDUA_SEQ", allocationSize = 1)
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporteMetricaEDua")
	private Integer id;

	@Column(name = "NUMERO_REPORTE",  nullable = true, unique = false)
	private String numeroReporte;
	
	@Column(name = "GENERAL_USUARIO", nullable = true, unique = false)
	private String generalUsuario;
	
	@Column(name = "GENERAL_ORIGEN",  nullable = true, unique = false)
	private String generalOrigen;
	
	@Column(name = "E_DUA", nullable = false, unique = false)
	@Convert("booleanConverter")
	private Boolean eDua;
	
	@Column(name = "CLAVE_AJUSTADOR", nullable = true, unique = false)
	private String claveAjustador;
	
	@Column(name = "ID_TERMINAL",  nullable = true, unique = false)
	private Integer idTerminal;
	
	@Column(name = "ENTIDAD",  nullable = true, unique = false)
	private String entidad;
	
	@Column(name = "BASE",  nullable = true, unique = false)
	private String base;
	
	@Column(name = "FECHA", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@Column(name = "INTERACCION_COMPLETA", nullable = false, unique = false)
	@Convert("booleanConverter")
	private Boolean interaccionCompleta;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroReporte() {
		return numeroReporte;
	}

	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	public String getGeneralUsuario() {
		return generalUsuario;
	}

	public void setGeneralUsuario(String generalUsuario) {
		this.generalUsuario = generalUsuario;
	}

	public String getGeneralOrigen() {
		return generalOrigen;
	}

	public void setGeneralOrigen(String generalOrigen) {
		this.generalOrigen = generalOrigen;
	}

	public Boolean geteDua() {
		return eDua;
	}

	public void seteDua(Boolean eDua) {
		this.eDua = eDua;
	}

	public String getClaveAjustador() {
		return claveAjustador;
	}

	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}

	public Integer getIdTerminal() {
		return idTerminal;
	}

	public void setIdTerminal(Integer idTerminal) {
		this.idTerminal = idTerminal;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getInteraccionCompleta() {
		return interaccionCompleta;
	}

	public void setInteraccionCompleta(Boolean interaccionCompleta) {
		this.interaccionCompleta = interaccionCompleta;
	}
	
}
