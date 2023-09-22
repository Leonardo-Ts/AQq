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

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractInfoReconocimiento  extends JMEntidad{

	/**
	 * 
	 */
	private static final long serialVersionUID = -367406420473458448L;
	
	
	@SequenceGenerator(name="reconocimientoSEQ", sequenceName="INFO_RECONOCIMIENTO_SEQ", allocationSize=1)
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="reconocimientoSEQ")
	private Integer id;
	
	@Column(name="NOMBRE", length= 100, nullable=false, unique=false)
	private String nombre;
	
	@Column(name="APELLIDO_PAT", length=100, nullable= false, unique=false)
	private String apellidoPaterno;
	
	@Column(name="APELLIDO_MAT", length= 100, nullable=false, unique=false)
	private String apellidoMaterno;
	
	@Column(name="CURP", length=18, nullable= false, unique=false)
	private String curp;
	
	@Column(name="NUMERO_REPORTE", length=20, nullable= false, unique=false)
	private String reporte;
	
	@Column(name="FECHA", nullable= false, unique=false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
//	@Column(name="TIPO_AFECTADO", length=10, nullable=false, unique=false)
//	private String tipoAfectado;

	public AbstractInfoReconocimiento() {
		super();
	}
	 
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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

//	public String getTipoAfectado() {
//		return tipoAfectado;
//	}
//
//	public void setTipoAfectado(String tipoAfectado) {
//		this.tipoAfectado = tipoAfectado;
//	}
	
	
}
