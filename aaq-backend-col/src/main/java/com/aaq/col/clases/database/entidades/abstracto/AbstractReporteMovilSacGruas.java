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
public abstract class AbstractReporteMovilSacGruas extends JMEntidad {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7630334178512092114L;

	@SequenceGenerator(name = "reporte_movil_sac_gruasSEQ", sequenceName = "reporte_movil_sac_gruas_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_movil_sac_gruasSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "general_numero_reporte", length = 15, nullable = true, unique = false)
	private String generalNumeroReporte;
	
	@Column(name = "ajuste_ajustador_codigo", length = 10, nullable = true, unique = false)
	private String ajusteAjustadorCodigo;
	
	@Column(name = "tipo_afectado", length = 10, nullable = true, unique = false)
	private String tipoAfectado;

	@Column(name = "clave", length = 10, nullable = true, unique = false)
	private String clave;

	@Column(name = "estatus", length = 20, nullable = true, unique = false)
	private String estatus;

	@Column(name = "proveedor_clave", length = 10, nullable = true, unique = false)
	private String proveedorClave;

	@Column(name = "proveedor_nombre", length = 255, nullable = true, unique = false)
	private String proveedorNombre;

	@Column(name = "fecha_estimada", length = 20, nullable = true, unique = false)
	private String fechaEstimada;

	@Column(name = "hora_estimada", length = 10, nullable = true, unique = false)
	private String horaEstimada;

	

	
	// Constructors

	/** default constructor */
	public AbstractReporteMovilSacGruas() {
		super();
	}

	
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 *
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 *
	 *
	 * @return the generalNumeroReporte
	 */
	public String getGeneralNumeroReporte() {
		return this.generalNumeroReporte;
	}

	/**
	 *
	 *
	 * @param generalNumeroReporte
	 *            the generalNumeroReporte to set
	 */
	public void setGeneralNumeroReporte(final String generalNumeroReporte) {
		this.generalNumeroReporte = generalNumeroReporte;
	}
	
	/**
	 * @return the ajusteAjustadorCodigo
	 */
	public String getAjusteAjustadorCodigo() {
		return this.ajusteAjustadorCodigo;
	}

	/**
	 *
	 *
	 * @param ajusteAjustadorCodigo
	 *            the ajusteAjustadorCodigo to set
	 */
	public void setAjusteAjustadorCodigo(final String ajusteAjustadorCodigo) {
		this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
	}


	/**
	 * @author Arturo de la Cruz
	 * @return the tipoAfectado
	 */
	public String getTipoAfectado() {
		return tipoAfectado;
	}


	/**
	 * @author Arturo de la Cruz
	 * @param tipoAfectado the tipoAfectado to set
	 */
	public void setTipoAfectado(String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}


	/**
	 * @return the clave
	 */
	public String getClave() {
		return this.clave;
	}


	/**
	 * @param clave the clave to set
	 */
	public void setClave(final String clave) {
		this.clave = clave;
	}


	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return this.estatus;
	}


	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(final String estatus) {
		this.estatus = estatus;
	}


	/**
	 * @return the proveedorClave
	 */
	public String getProveedorClave() {
		return this.proveedorClave;
	}


	/**
	 * @param proveedorClave the proveedorClave to set
	 */
	public void setProveedorClave(final String proveedorClave) {
		this.proveedorClave = proveedorClave;
	}


	/**
	 * @return the proveedorNombre
	 */
	public String getProveedorNombre() {
		return this.proveedorNombre;
	}


	/**
	 * @param proveedorNombre the proveedorNombre to set
	 */
	public void setProveedorNombre(final String proveedorNombre) {
		this.proveedorNombre = proveedorNombre;
	}


	/**
	 * @return the fechaEstimada
	 */
	public String getFechaEstimada() {
		return this.fechaEstimada;
	}


	/**
	 * @param fechaEstimada the fechaEstimada to set
	 */
	public void setFechaEstimada(final String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}


	/**
	 * @return the horaEstimada
	 */
	public String getHoraEstimada() {
		return this.horaEstimada;
	}


	/**
	 * @param horaEstimada the horaEstimada to set
	 */
	public void setHoraEstimada(final String horaEstimada) {
		this.horaEstimada = horaEstimada;
	}
	
}