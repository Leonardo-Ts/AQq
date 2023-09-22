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

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTransaccion extends JMEntidad {

	// Fields

	private static final long serialVersionUID = 549645638549878099L;

	@SequenceGenerator(name = "transaccionSEQ", sequenceName = "transaccion_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaccionSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "numero_reporte", length = 255, nullable = false, unique = true)
	private String numeroReporte;

	@Column(name = "tipo_de_cobro", length = 255, nullable = true, unique = true)
	private String tipoDeCobro;

	@Column(name = "numero_operacion", length = 255, nullable = true, unique = false)
	private String numeroOperacion;

	@Column(name = "numero_referencia", length = 255, nullable = true, unique = false)
	private String numeroReferencia;

	@Column(name = "numero_autorizacion", length = 255, nullable = true, unique = false)
	private String numeroAutorizacion;

	@Column(name = "numero_poliza", length = 255, nullable = true, unique = false)
	private String numeroPoliza;

	@Column(name = "datos_adicionales", nullable = true, unique = false)
	private String datosAdicionales;

	@Column(name = "monto", length = 255, nullable = true, unique = true)
	private String monto;

	@Column(name = "fuente", length = 255, nullable = true, unique = false)
	private String fuente;

	@Column(name = "clave_oficina", length = 255, nullable = true, unique = false)
	private String claveOficina;

	@Column(name = "cobertura_afectada", length = 255, nullable = true, unique = false)
	private String coberturaAfectada;

	@Column(name = "numero_siniestro", length = 255, nullable = true, unique = false)
	private String numeroSiniestro;

	@Column(name = "transaccion_aprobada", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean transaccionAprobada;

	@Column(name = "xml_tarjeta", nullable = true, unique = false)
	private String xmlTarjeta;

	@Column(name = "xml_respuesta", nullable = true, unique = false)
	private String xmlRespuesta;

	@Column(name = "voucher_general", nullable = true, unique = false)
	private String voucherGeneral;

	@Column(name = "voucher_comercio", nullable = true, unique = false)
	private String voucherComercio;

	@Column(name = "voucher_cliente", nullable = true, unique = false)
	private String voucherCliente;

	@Column(name = "respuesta_amigable", length = 255, nullable = true, unique = false)
	private String respuestaAmigable;

	@Column(name = "checksum", length = 255, nullable = true, unique = false)
	private String checksum;
	
	@Column(name = "meses_sin_intereses", length = 10, nullable = true, unique = false)
	private String mesesSinIntereses;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CatalogoCodigoRespuestaBancario.class)
	@JoinColumn(name = "id_codigo_respuesta_bancario", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private CatalogoCodigoRespuestaBancario catalogoCodigoRespuestaBancario;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "id_terminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Usuario usuario;
	
	@Column(name="CLAVE_ABOGADO", length=5, nullable=true, unique= false)
	private Integer claveAbogado;

	// Constructors

	/** default constructor */
	public AbstractTransaccion() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return this.numeroReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param numeroReporte
	 *            the numeroReporte to set
	 */
	public void setNumeroReporte(final String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the tipoDeCobro
	 */
	public String getTipoDeCobro() {
		return this.tipoDeCobro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param tipoDeCobro
	 *            the tipoDeCobro to set
	 */
	public void setTipoDeCobro(final String tipoDeCobro) {
		this.tipoDeCobro = tipoDeCobro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the numeroOperacion
	 */
	public String getNumeroOperacion() {
		return this.numeroOperacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param numeroOperacion
	 *            the numeroOperacion to set
	 */
	public void setNumeroOperacion(final String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the numeroReferencia
	 */
	public String getNumeroReferencia() {
		return this.numeroReferencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param numeroReferencia
	 *            the numeroReferencia to set
	 */
	public void setNumeroReferencia(final String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the numeroAutorizacion
	 */
	public String getNumeroAutorizacion() {
		return this.numeroAutorizacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param numeroAutorizacion
	 *            the numeroAutorizacion to set
	 */
	public void setNumeroAutorizacion(final String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the numeroPoliza
	 */
	public String getNumeroPoliza() {
		return this.numeroPoliza;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param numeroPoliza
	 *            the numeroPoliza to set
	 */
	public void setNumeroPoliza(final String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the datosAdicionales
	 */
	public String getDatosAdicionales() {
		return this.datosAdicionales;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param datosAdicionales
	 *            the datosAdicionales to set
	 */
	public void setDatosAdicionales(final String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the monto
	 */
	public String getMonto() {
		return this.monto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(final String monto) {
		this.monto = monto;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the fuente
	 */
	public String getFuente() {
		return this.fuente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param fuente
	 *            the fuente to set
	 */
	public void setFuente(final String fuente) {
		this.fuente = fuente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the claveOficina
	 */
	public String getClaveOficina() {
		return this.claveOficina;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param claveOficina
	 *            the claveOficina to set
	 */
	public void setClaveOficina(final String claveOficina) {
		this.claveOficina = claveOficina;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the coberturaAfectada
	 */
	public String getCoberturaAfectada() {
		return this.coberturaAfectada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param coberturaAfectada
	 *            the coberturaAfectada to set
	 */
	public void setCoberturaAfectada(final String coberturaAfectada) {
		this.coberturaAfectada = coberturaAfectada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the numeroSiniestro
	 */
	public String getNumeroSiniestro() {
		return this.numeroSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param numeroSiniestro
	 *            the numeroSiniestro to set
	 */
	public void setNumeroSiniestro(final String numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the transaccionAprobada
	 */
	public Boolean getTransaccionAprobada() {
		return this.transaccionAprobada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param transaccionAprobada
	 *            the transaccionAprobada to set
	 */
	public void setTransaccionAprobada(final Boolean transaccionAprobada) {
		this.transaccionAprobada = transaccionAprobada;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the xmlTarjeta
	 */
	public String getXmlTarjeta() {
		return this.xmlTarjeta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param xmlTarjeta
	 *            the xmlTarjeta to set
	 */
	public void setXmlTarjeta(final String xmlTarjeta) {
		this.xmlTarjeta = xmlTarjeta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the xmlRespuesta
	 */
	public String getXmlRespuesta() {
		return this.xmlRespuesta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param xmlRespuesta
	 *            the xmlRespuesta to set
	 */
	public void setXmlRespuesta(final String xmlRespuesta) {
		this.xmlRespuesta = xmlRespuesta;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the voucherGeneral
	 */
	public String getVoucherGeneral() {
		return this.voucherGeneral;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param voucherGeneral
	 *            the voucherGeneral to set
	 */
	public void setVoucherGeneral(final String voucherGeneral) {
		this.voucherGeneral = voucherGeneral;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the voucherComercio
	 */
	public String getVoucherComercio() {
		return this.voucherComercio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param voucherComercio
	 *            the voucherComercio to set
	 */
	public void setVoucherComercio(final String voucherComercio) {
		this.voucherComercio = voucherComercio;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the voucherCliente
	 */
	public String getVoucherCliente() {
		return this.voucherCliente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param voucherCliente
	 *            the voucherCliente to set
	 */
	public void setVoucherCliente(final String voucherCliente) {
		this.voucherCliente = voucherCliente;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the respuestaAmigable
	 */
	public String getRespuestaAmigable() {
		return this.respuestaAmigable;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param respuestaAmigable
	 *            the respuestaAmigable to set
	 */
	public void setRespuestaAmigable(final String respuestaAmigable) {
		this.respuestaAmigable = respuestaAmigable;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the checksum
	 */
	public String getChecksum() {
		return this.checksum;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param checksum
	 *            the checksum to set
	 */
	public void setChecksum(final String checksum) {
		this.checksum = checksum;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the mesesSinIntereses
	 */
	public String getMesesSinIntereses() {
		return mesesSinIntereses;
	}

	/**
	 * @author Arturo de la Cruz
	 * @param mesesSinIntereses the mesesSinIntereses to set
	 */
	public void setMesesSinIntereses(String mesesSinIntereses) {
		this.mesesSinIntereses = mesesSinIntereses;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the catalogoCodigoRespuestaBancario
	 */
	public CatalogoCodigoRespuestaBancario getCatalogoCodigoRespuestaBancario() {
		return this.catalogoCodigoRespuestaBancario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param catalogoCodigoRespuestaBancario
	 *            the catalogoCodigoRespuestaBancario to set
	 */
	public void setCatalogoCodigoRespuestaBancario(final CatalogoCodigoRespuestaBancario catalogoCodigoRespuestaBancario) {
		this.catalogoCodigoRespuestaBancario = catalogoCodigoRespuestaBancario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 4:50:10 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the claveAbogado
	 */
	public Integer getClaveAbogado() {
		return claveAbogado;
	}

	/**
	 * @param claveAbogado the claveAbogado to set
	 */
	public void setClaveAbogado(Integer claveAbogado) {
		this.claveAbogado = claveAbogado;
	}

}