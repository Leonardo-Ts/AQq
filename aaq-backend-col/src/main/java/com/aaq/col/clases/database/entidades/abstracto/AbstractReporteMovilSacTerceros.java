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
public abstract class AbstractReporteMovilSacTerceros extends JMEntidad {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7277464983559154816L;

	@SequenceGenerator(name = "reporte_movil_sac_terceroSEQ", sequenceName = "reporte_movil_sac_terceros_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reporte_movil_sac_terceroSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "general_numero_reporte", length = 255, nullable = true, unique = false)
	private String generalNumeroReporte;
	
	@Column(name = "ajuste_ajustador_codigo", length = 255, nullable = true, unique = false)
	private String ajusteAjustadorCodigo;

	@Column(name = "id_tercero", length = 255, nullable = true, unique = false)
	private String idTercero;

	@Column(name = "marca", length = 255, nullable = true, unique = false)
	private String vehiculoMarca;

	@Column(name = "tipo", length = 255, nullable = true, unique = false)
	private String vehiculoTipo;

	@Column(name = "ano_modelo", length = 255, nullable = true, unique = false)
	private String vehiculoAnoModelo;

	@Column(name = "placa", length = 255, nullable = true, unique = false)
	private String vehiculoPlacas;
	
	@Column(name = "serie", length = 255, nullable = true, unique = false)
	private String vehiculoSerie;
	
	@Column(name = "color", length = 255, nullable = true, unique = false)
	private String vehiculoColor;
	
	@Column(name = "conductor", length = 255, nullable = true, unique = false)
	private String vehiculoConductor;
	
	@Column(name = "telefono_contacto", length = 255, nullable = true, unique = false)
	private String telefonoContacto;
	
	@Column(name = "general_numero_reporte_sise", length = 255, nullable = true, unique = false)
	private String generalNumeroReporteSise;
	
	// Constructors

	/** default constructor */
	public AbstractReporteMovilSacTerceros() {
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
	 *
	 *
	 * @return the vehiculoSerie
	 */
	public String getVehiculoSerie() {
		return this.vehiculoSerie;
	}

	/**
	 *
	 *
	 * @param vehiculoSerie
	 *            the vehiculoSerie to set
	 */
	public void setVehiculoSerie(final String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}

	/**
	 *
	 *
	 * @return the vehiculoPlacas
	 */
	public String getVehiculoPlacas() {
		return this.vehiculoPlacas;
	}

	/**
	 *
	 *
	 * @param vehiculoPlacas
	 *            the vehiculoPlacas to set
	 */
	public void setVehiculoPlacas(final String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}

	/**
	 *
	 *
	 * @return the vehiculoMarca
	 */
	public String getVehiculoMarca() {
		return this.vehiculoMarca;
	}

	/**
	 * 
	 *
	 * @param vehiculoMarca
	 *            the vehiculoMarca to set
	 */
	public void setVehiculoMarca(final String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	/**
	 *
	 *
	 * @return the vehiculoTipo
	 */
	public String getVehiculoTipo() {
		return this.vehiculoTipo;
	}

	/**
	 * 
	 *
	 * @param vehiculoTipo
	 *            the vehiculoTipo to set
	 */
	public void setVehiculoTipo(final String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}

	/**
	 * 
	 *
	 * @return the vehiculoColor
	 */
	public String getVehiculoColor() {
		return this.vehiculoColor;
	}

	/**
	 *
	 *
	 * @param vehiculoColor
	 *            the vehiculoColor to set
	 */
	public void setVehiculoColor(final String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	/**
	 *
	 *
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
	 * @return the idTercero
	 */
	public String getIdTercero() {
		return this.idTercero;
	}


	/**
	 * @param idTercero the idTercero to set
	 */
	public void setIdTercero(final String idTercero) {
		this.idTercero = idTercero;
	}


	/**
	 * @return the vehiculoAnoModelo
	 */
	public String getVehiculoAnoModelo() {
		return this.vehiculoAnoModelo;
	}


	/**
	 * @param vehiculoAnoModelo the vehiculoAnoModelo to set
	 */
	public void setVehiculoAnoModelo(final String vehiculoAnoModelo) {
		this.vehiculoAnoModelo = vehiculoAnoModelo;
	}


	/**
	 * @return the vehiculoConductor
	 */
	public String getVehiculoConductor() {
		return this.vehiculoConductor;
	}


	/**
	 * @param vehiculoConductor the vehiculoConductor to set
	 */
	public void setVehiculoConductor(final String vehiculoConductor) {
		this.vehiculoConductor = vehiculoConductor;
	}


	/**
	 * @return the telefonoContacto
	 */
	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}


	/**
	 * @param telefonoContacto the telefonoContacto to set
	 */
	public void setTelefonoContacto(final String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}


	/**
	 * @author Arturo de la Cruz
	 * @return the generalNumeroReporteSise
	 */
	public String getGeneralNumeroReporteSise() {
		return generalNumeroReporteSise;
	}


	/**
	 * @author Arturo de la Cruz
	 * @param generalNumeroReporteSise the generalNumeroReporteSise to set
	 */
	public void setGeneralNumeroReporteSise(String generalNumeroReporteSise) {
		this.generalNumeroReporteSise = generalNumeroReporteSise;
	}
}