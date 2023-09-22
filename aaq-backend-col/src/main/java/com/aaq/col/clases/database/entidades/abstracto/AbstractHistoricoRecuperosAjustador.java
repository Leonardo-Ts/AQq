package com.aaq.col.clases.database.entidades.abstracto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractHistoricoRecuperosAjustador extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786778970851237330L;

	@SequenceGenerator(name = "historico_recuperos_ajustadorSEQ", sequenceName = "historico_recuperos_ajus_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_recuperos_ajustadorSEQ")
	private Integer id;

	@Column(name= "clave_recupero", length = 255, nullable = false, unique = false)
	private String claveRecupero;
	
	@Column(name= "descrip_recupero",length = 255, nullable = false, unique = false)
	private String descripcionRecupero;
	
	@Column(name= "total_vales", length = 255, nullable = false, unique = false)
	private String totalVales;
	
	@Column(name= "clave_aseguradora", length = 255, nullable = false, unique = false)
	private String claveAseguradora;
	
	@Column(name= "descrip_aseguradora", length = 255, nullable = false, unique = false)
	private String descripcionAseguradora;
	
	@Column(name= "clave_ajustador", length = 255, nullable = false, unique = false)
	private String claveAjustador;
	
	@Column(name= "reporte", length = 255, nullable = false, unique = false)
	private String reporte;
	
	@Column(name= "afectado", length = 255, nullable = false, unique = false)
	private String afectado;
	
	@Column(name= "numero_siniestro", length = 255, nullable = false, unique = false)
	private String numeroSiniestro;
	
	@Column(name= "folio_vale", length = 255, nullable = false, unique = false)
	private String folioVale;
	
	@Column(name= "monto", length = 255, nullable = false, unique = false)
	private String monto;
	
	@Column(name= "descrip_monto", length = 255, nullable = false, unique = false)
	private String descripcionMonto;
	
	// Constructors

	/** default constructor */
	public AbstractHistoricoRecuperosAjustador() {
		super();
	}

	/**
	 * full constructor
	 * 
	 */
	public AbstractHistoricoRecuperosAjustador(final String claveRecupero, final String descripcionRecupero, final String totalVales, final String claveAseguradora,
			 final String descripcionAseguradora, final String claveAjustador, final String reporte, final String afectado, 
			 final String numeroSiniestro, final String folioVale, final String monto, final String descripcionMonto) {
		this.claveRecupero = claveRecupero;
		this.descripcionRecupero = descripcionRecupero;
		this.totalVales = totalVales;
		this.claveAseguradora = claveAseguradora;
		this.descripcionAseguradora = descripcionAseguradora;
		this.claveAjustador = claveAjustador;
		this.reporte = reporte;
		this.afectado = afectado;
		this.numeroSiniestro = numeroSiniestro;
		this.folioVale = folioVale;
		this.monto = monto;
		this.descripcionMonto = descripcionMonto;
	}
	
	// Getters and Setters


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClaveRecupero() {
		return claveRecupero;
	}

	public void setClaveRecupero(String claveRecupero) {
		this.claveRecupero = claveRecupero;
	}

	public String getDescripcionRecupero() {
		return descripcionRecupero;
	}

	public void setDescripcionRecupero(String descripcionRecupero) {
		this.descripcionRecupero = descripcionRecupero;
	}

	public String getTotalVales() {
		return totalVales;
	}

	public void setTotalVales(String totalVales) {
		this.totalVales = totalVales;
	}

	public String getClaveAseguradora() {
		return claveAseguradora;
	}

	public void setClaveAseguradora(String claveAseguradora) {
		this.claveAseguradora = claveAseguradora;
	}

	public String getDescripcionAseguradora() {
		return descripcionAseguradora;
	}

	public void setDescripcionAseguradora(String descripcionAseguradora) {
		this.descripcionAseguradora = descripcionAseguradora;
	}

	public String getClaveAjustador() {
		return claveAjustador;
	}

	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getAfectado() {
		return afectado;
	}

	public void setAfectado(String afectado) {
		this.afectado = afectado;
	}

	public String getNumeroSiniestro() {
		return numeroSiniestro;
	}

	public void setNumeroSiniestro(String numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String getFolioVale() {
		return folioVale;
	}

	public void setFolioVale(String folioVale) {
		this.folioVale = folioVale;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getDescripcionMonto() {
		return descripcionMonto;
	}

	public void setDescripcionMonto(String descripcionMonto) {
		this.descripcionMonto = descripcionMonto;
	}	
	
}