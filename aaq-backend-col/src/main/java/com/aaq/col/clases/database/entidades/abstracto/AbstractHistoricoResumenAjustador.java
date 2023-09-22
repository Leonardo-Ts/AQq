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
public abstract class AbstractHistoricoResumenAjustador extends JMEntidad {
	private static final long serialVersionUID = 2600838927904855135L;

	@SequenceGenerator(name = "hist_res_ajusSEQ", sequenceName = "hist_res_ajus_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hist_res_ajusSEQ")
	private Integer id;

	@Column(name = "fecha_actividad", nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActividad;

	@Column(name = "clave_ajustador", length = 10, nullable = true, unique = false)
	private String claveAjustador;

	@Column(name = "nombre_ajustador", length = 255, nullable = true, unique = false)
	private String nombreAjustador;
	
	@Column(name = "general_numero_reporte", length = 11, nullable = true, unique = false)
	private String generalNumeroReporte;
	
	@Column(name = "poliza", length = 20, nullable = true, unique = false)
	private String poliza;
	
	@Column(name = "inciso_estatus", length = 100, nullable = true, unique = false)
	private String incisoEstatus;
	
	@Column(name = "actividad", length = 200, nullable = true, unique = false)
	private String actividad;
	
	@Column(name = "usuario", length = 50, nullable = true, unique = false)
	private String usuario;
	
	@Column(name = "fuente", length = 255, nullable = true, unique = false)
	private String fuente;
	
	@Column(name = "descripcion_actividad", length = 500, nullable = true, unique = false)
	private String descripcionActividad;
	
	@Column(name = "resultado", length = 100, nullable = true, unique = false)
	private String resultado;

	// Constructors

	/** default constructor */
	public AbstractHistoricoResumenAjustador() {
		super();
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the fechaActividad
	 */
	public java.util.Date getFechaActividad() {
		return fechaActividad;
	}

	/**
	 * @param fechaActividad the fechaActividad to set
	 */
	public void setFechaActividad(java.util.Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

	/**
	 * @return the claveAjustador
	 */
	public String getClaveAjustador() {
		return claveAjustador;
	}

	/**
	 * @param claveAjustador the claveAjustador to set
	 */
	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}

	/**
	 * @return the nombreAjustador
	 */
	public String getNombreAjustador() {
		return nombreAjustador;
	}

	/**
	 * @param nombreAjustador the nombreAjustador to set
	 */
	public void setNombreAjustador(String nombreAjustador) {
		this.nombreAjustador = nombreAjustador;
	}

	/**
	 * @return the generalNumeroReporte
	 */
	public String getGeneralNumeroReporte() {
		return generalNumeroReporte;
	}

	/**
	 * @param generalNumeroReporte the generalNumeroReporte to set
	 */
	public void setGeneralNumeroReporte(String generalNumeroReporte) {
		this.generalNumeroReporte = generalNumeroReporte;
	}

	/**
	 * @return the poliza
	 */
	public String getPoliza() {
		return poliza;
	}

	/**
	 * @param poliza the poliza to set
	 */
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	/**
	 * @return the incisoEstatus
	 */
	public String getIncisoEstatus() {
		return incisoEstatus;
	}

	/**
	 * @param incisoEstatus the incisoEstatus to set
	 */
	public void setIncisoEstatus(String incisoEstatus) {
		this.incisoEstatus = incisoEstatus;
	}

	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the fuente
	 */
	public String getFuente() {
		return fuente;
	}

	/**
	 * @param fuente the fuente to set
	 */
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	/**
	 * @return the descripcionActividad
	 */
	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	/**
	 * @param descripcionActividad the descripcionActividad to set
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}