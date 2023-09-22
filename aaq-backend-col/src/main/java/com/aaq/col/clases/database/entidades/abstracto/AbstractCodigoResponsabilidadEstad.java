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

import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractCodigoResponsabilidadEstad extends JMEntidad{

	private static final long serialVersionUID = -1189684877922602358L;

	@SequenceGenerator(name = "codigoResponsabilidadEstadSEQ", sequenceName = "CODIGO_RESPONSABILIDAD_ESTADISTICA_SEQ", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codigoResponsabilidadEstadSEQ")
	private Integer id;
	
	@Column(name = "FECHA", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@Column(name = "NUMERO_REPORTE",  nullable = false, unique = false)
	private String numeroReporte;
	
	@Column(name = "NUMERO_POLIZA",  nullable = false, unique = false)
	private String numeroPoliza;
	
	@Column(name = "NUMERO_INCISO",  nullable = false, unique = false)
	private String numeroInciso;
	
	@Column(name = "FECHA_OCURRIDO",  nullable = false, unique = false)
	private String fechaOcurrido;
	
	@Column(name = "CODIGO_CAUSA",  nullable = false, unique = false)
	private String codigoCausa;
	
	@Column(name = "ESTADO",  nullable = false, unique = false)
	private String estado;
	
	@Column(name = "MUNICIPIO",  nullable = false, unique = false)
	private String municipio;
	
	@Column(name = "CLAVE_AJUSTADOR",  nullable = false, unique = false)
	private String claveAjustador;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
   	@JoinColumn(name = "ID_TERMINAL", referencedColumnName = "ID", nullable = true, unique = true, insertable = true, updatable = true)
   	private Terminal terminal;
	
	@Column(name = "NOMBRE_AJUSTADOR",  nullable = false, unique = false)
	private String nombreAjustador;
	
	@Column(name = "CODIGO_RESPONSABILIDAD",  nullable = false, unique = false)
	private String codigoResponsabilidad;
	
	@Column(name = "MATRIZ", nullable = true, unique = true)
	@Convert("booleanConverter")
	private Boolean matriz;
	
	@Column(name = "CODIGO_MATRIZ",  nullable = false, unique = false)
	private String codigoMatriz;
	
	@Column(name = "CODIGO_RESPONSABILIDAD_DUA",  nullable = false, unique = false)
	private String codigoResponsabilidadDUA;
	
	@Column(name = "CONCLUSION_DUA",  nullable = false, unique = false)
	private String conclusionDUA;
	
	@Column(name = "FOLIO_EDUA",  nullable = false, unique = false)
	private String folioEDUA;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public String getNumeroReporte() {
		return numeroReporte;
	}

	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getNumeroInciso() {
		return numeroInciso;
	}

	public void setNumeroInciso(String numeroInciso) {
		this.numeroInciso = numeroInciso;
	}

	public String getFechaOcurrido() {
		return fechaOcurrido;
	}

	public void setFechaOcurrido(String fechaOcurrido) {
		this.fechaOcurrido = fechaOcurrido;
	}

	public String getCodigoCausa() {
		return codigoCausa;
	}

	public void setCodigoCausa(String codigoCausa) {
		this.codigoCausa = codigoCausa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getClaveAjustador() {
		return claveAjustador;
	}

	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public String getNombreAjustador() {
		return nombreAjustador;
	}

	public void setNombreAjustador(String nombreAjustador) {
		this.nombreAjustador = nombreAjustador;
	}

	public String getCodigoResponsabilidad() {
		return codigoResponsabilidad;
	}

	public void setCodigoResponsabilidad(String codigoResponsabilidad) {
		this.codigoResponsabilidad = codigoResponsabilidad;
	}

	public Boolean getMatriz() {
		return matriz;
	}

	public void setMatriz(Boolean matriz) {
		this.matriz = matriz;
	}

	public String getCodigoMatriz() {
		return codigoMatriz;
	}

	public void setCodigoMatriz(String codigoMatriz) {
		this.codigoMatriz = codigoMatriz;
	}

	public String getCodigoResponsabilidadDUA() {
		return codigoResponsabilidadDUA;
	}

	public void setCodigoResponsabilidadDUA(String codigoResponsabilidadDUA) {
		this.codigoResponsabilidadDUA = codigoResponsabilidadDUA;
	}

	public String getConclusionDUA() {
		return conclusionDUA;
	}

	public void setConclusionDUA(String conclusionDUA) {
		this.conclusionDUA = conclusionDUA;
	}

	public String getFolioEDUA() {
		return folioEDUA;
	}

	public void setFolioEDUA(String folioEDUA) {
		this.folioEDUA = folioEDUA;
	}


	
}
