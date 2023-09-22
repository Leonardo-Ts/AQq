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
public abstract class AbstractReporteMovilSacTalleres extends JMEntidad {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8449606557948732698L;

	@SequenceGenerator(name = "reporte_movil_sac_talleresSEQ", sequenceName = "reporte_movil_sac_talleres_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_movil_sac_talleresSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "general_numero_reporte", length = 255, nullable = true, unique = false)
	private String generalNumeroReporte;
	
	@Column(name = "ajuste_ajustador_codigo", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorCodigo;

	@Column(name = "id_talleres", length = 255, nullable = true, unique = false)
	private String idTalleres;

	@Column(name = "codigo", length = 255, nullable = true, unique = false)
	private String codigo;

	@Column(name = "nombre", length = 255, nullable = true, unique = false)
	private String nombre;
	
	@Column(name = "tipo", length = 255, nullable = true, unique = false)
	private String tipo;

	@Column(name = "tipoafectado", length = 255, nullable = true, unique = false)
	private String tipoAfectado;
	
	@Column(name = "indicetercero", length = 255, nullable = true, unique = false)
	private String indiceTercero;

	@Column(name = "vale", length = 255, nullable = true, unique = false)
	private String vale;
	
	@Column(name = "notas", length = 255, nullable = true, unique = false)
	private String notas;
	
	
	// Constructors

	/** default constructor */
	public AbstractReporteMovilSacTalleres() {
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
	 * @return the idTalleres
	 */
	public String getIdTalleres() {
		return this.idTalleres;
	}


	/**
	 * @param idTalleres the idTalleres to set
	 */
	public void setIdTalleres(final String idTalleres) {
		this.idTalleres = idTalleres;
	}


	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}


	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return this.tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the tipoAfectado
	 */
	public String getTipoAfectado() {
		return this.tipoAfectado;
	}


	/**
	 * @param tipoAfectado the tipoAfectado to set
	 */
	public void setTipoAfectado(final String tipoAfectado) {
		this.tipoAfectado = tipoAfectado;
	}


	/**
	 * @return the indiceTercero
	 */
	public String getIndiceTercero() {
		return this.indiceTercero;
	}


	/**
	 * @param indiceTercero the indiceTercero to set
	 */
	public void setIndiceTercero(final String indiceTercero) {
		this.indiceTercero = indiceTercero;
	}


	/**
	 * @return the vale
	 */
	public String getVale() {
		return this.vale;
	}


	/**
	 * @param vale the vale to set
	 */
	public void setVale(final String vale) {
		this.vale = vale;
	}


	/**
	 * @return the notas
	 */
	public String getNotas() {
		return this.notas;
	}


	/**
	 * @param notas the notas to set
	 */
	public void setNotas(final String notas) {
		this.notas = notas;
	}
	
}