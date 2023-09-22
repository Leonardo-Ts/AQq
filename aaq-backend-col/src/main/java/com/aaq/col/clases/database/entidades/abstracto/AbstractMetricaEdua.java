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
public class AbstractMetricaEdua extends JMEntidad {

	private static final long serialVersionUID = 3147826497868636007L;

	@SequenceGenerator(name = "metricaEDUASeq", sequenceName = "METRICA_EDUA_SEQ", allocationSize = 1)
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metricaEDUASeq")
	private Integer id;

	@Column(name = "NUMERO_REPORTE",  nullable = true, unique = false)
	private String numeroReporte;
	
	@Column(name = "ENTIDAD",  nullable = true, unique = false)
	private String entidad;
	
	@Column(name = "BASE",  nullable = true, unique = false)
	private String base;
	
	@Column(name = "FECHA", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;
	
	@Column(name = "CLAVE_AJUSTADOR",  nullable = true, unique = false)
	private String claveAjustador;
	
	@Column(name = "GENERAR_FOLIO", nullable = true, unique = false)
	private Integer generarFolio;
	
	@Column(name = "SINCRONIZAR_STRO",  nullable = true, unique = false)
	private Integer sincronizarStro;
	
	@Column(name = "VINCULAR_FOLIO", nullable = false, unique = false)
	private Integer vincularFolio;
	
	@Column(name = "oa_moto", nullable = true, unique = false)
	private Integer oaMoto;
	
	@Column(name = "oa_ep",  nullable = true, unique = false)
	private Integer oaEP;
	
	@Column(name = "SINCRONIZAR_STRO_C",  nullable = true, unique = false)
	private Integer sincronizarStroC;
	
	@Column(name = "INFO_CONTRAPARTE",  nullable = true, unique = false)
	private Integer infoContraparte;
	
	@Column(name = "REFOLEO",  nullable = true, unique = false)
	private Integer refoleo;
	
	@Column(name = "EMISION_VALE",  nullable = true, unique = false)
	private Integer emisionValeDig;
	
	@Column(name = "RECEPCION_VALE_DIG",  nullable = true, unique = false)
	private Integer recepcionValeDig;
	
	@Column(name = "ORDEN_PAGO",  nullable = true, unique = false)
	private Integer ordenPago;
 
	@Column(name = "TERMINO_ATENCION",  nullable = true, unique = false)
	private Integer terminoAtencion;
	
	@Column(name = "PORCENTAJE",  nullable = true, unique = false)
	private String porcentaje;

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

	public Integer getGenerarFolio() {
		return generarFolio;
	}

	public void setGenerarFolio(Integer generarFolio) {
		this.generarFolio = generarFolio;
	}

	public Integer getSincronizarStro() {
		return sincronizarStro;
	}

	public void setSincronizarStro(Integer sincronizarStro) {
		this.sincronizarStro = sincronizarStro;
	}

	public Integer getVincularFolio() {
		return vincularFolio;
	}

	public void setVincularFolio(Integer vincularFolio) {
		this.vincularFolio = vincularFolio;
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

	public Integer getSincronizarStroC() {
		return sincronizarStroC;
	}

	public void setSincronizarStroC(Integer sincronizarStroC) {
		this.sincronizarStroC = sincronizarStroC;
	}

	public Integer getInfoContraparte() {
		return infoContraparte;
	}

	public void setInfoContraparte(Integer infoContraparte) {
		this.infoContraparte = infoContraparte;
	}

	public Integer getRefoleo() {
		return refoleo;
	}

	public void setRefoleo(Integer refoleo) {
		this.refoleo = refoleo;
	}

	public Integer getEmisionValeDig() {
		return emisionValeDig;
	}

	public void setEmisionValeDig(Integer emisionValeDig) {
		this.emisionValeDig = emisionValeDig;
	}

	public Integer getRecepcionValeDig() {
		return recepcionValeDig;
	}

	public void setRecepcionValeDig(Integer recepcionValeDig) {
		this.recepcionValeDig = recepcionValeDig;
	}

	public Integer getOrdenPago() {
		return ordenPago;
	}

	public void setOrdenPago(Integer ordenPago) {
		this.ordenPago = ordenPago;
	}

	public Integer getTerminoAtencion() {
		return terminoAtencion;
	}

	public void setTerminoAtencion(Integer terminoAtencion) {
		this.terminoAtencion = terminoAtencion;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
