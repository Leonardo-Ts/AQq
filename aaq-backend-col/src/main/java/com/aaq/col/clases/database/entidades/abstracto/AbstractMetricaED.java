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
public class AbstractMetricaED extends JMEntidad {

	private static final long serialVersionUID = -3098761822235818583L;

	@SequenceGenerator(name = "metricaEDSeq", sequenceName = "METRICA_ED_SEQ", allocationSize = 1)
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metricaEDSeq")
	private Integer id;

	@Column(name = "NUMERO_REPORTE",  nullable = true, unique = false)
	private String numeroReporte;
	
	@Column(name = "dua", nullable = true, unique = false)
	private Integer dua;
	
	@Column(name = "involucrado",  nullable = true, unique = false)
	private String involucrado;
	
	@Column(name = "oa_auto", nullable = false, unique = false)
	private Integer oaAuto;
	
	@Column(name = "oa_moto", nullable = true, unique = false)
	private Integer oaMoto;
	
	@Column(name = "oa_ep",  nullable = true, unique = false)
	private Integer oaEP;
	
	@Column(name = "ENTIDAD",  nullable = true, unique = false)
	private String entidad;
	
	@Column(name = "BASE",  nullable = true, unique = false)
	private String base;
	
	@Column(name = "FECHA", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@Column(name = "CLAVE_AJUSTADOR",  nullable = true, unique = false)
	private String claveAjustador;
	
	@Column(name = "EDUA",  nullable = true, unique = false)
	private Integer edua;
	
	@Column(name = "FOLIO",  nullable = true, unique = false)
	private String folio;
	
	@Column(name = "CODIGO_CAUSA",  nullable = true, unique = false)
	private String codigoCausa;
	
	@Column(name = "ENVIADO",  nullable = true, unique = false)
    @Convert("booleanConverter")
	private Boolean enviado;

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

	public Integer getDua() {
		return dua;
	}

	public void setDua(Integer dua) {
		this.dua = dua;
	}

	public String getInvolucrado() {
		return involucrado;
	}

	public void setInvolucrado(String involucrado) {
		this.involucrado = involucrado;
	}

	public Integer getOaAuto() {
		return oaAuto;
	}

	public void setOaAuto(Integer oaAuto) {
		this.oaAuto = oaAuto;
	}

	public Integer getOaMoto() {
		return oaMoto;
	}

	public void setOaMoto(Integer oaMoto) {
		this.oaMoto = oaMoto;
	}

	public Integer getOaEP() {
		return oaEP;
	}

	public void setOaEP(Integer oaEP) {
		this.oaEP = oaEP;
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

	public String getClaveAjustador() {
		return claveAjustador;
	}

	public void setClaveAjustador(String claveAjustador) {
		this.claveAjustador = claveAjustador;
	}

	public Integer getEdua() {
		return edua;
	}

	public void setEdua(Integer edua) {
		this.edua = edua;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getCodigoCausa() {
		return codigoCausa;
	}

	public void setCodigoCausa(String codigoCausa) {
		this.codigoCausa = codigoCausa;
	}

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}
	
	
	
}
