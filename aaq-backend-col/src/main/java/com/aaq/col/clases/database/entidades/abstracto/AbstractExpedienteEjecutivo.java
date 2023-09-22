package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

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

import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@Access(AccessType.FIELD)
@MappedSuperclass
@ObjectTypeConverter(
		name="booleanConverter",
		dataType=java.lang.String.class,
		objectType=java.lang.Boolean.class,
		conversionValues={
			@ConversionValue(dataValue="t", objectValue="true"),
			@ConversionValue(dataValue="f", objectValue="false")
		},
		defaultObjectValue="false"
)
public abstract class AbstractExpedienteEjecutivo extends JMEntidad {

	private static final long serialVersionUID = 2846502876852239926L;

	@SequenceGenerator(name = "expedienteEjecutivoSEQ", sequenceName = "EXPEDIENTE_EJECUTIVO_SEQ", allocationSize = 1)
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expedienteEjecutivoSEQ")
	private Integer id;

	@Column( name="REPORTE", nullable = true, unique=false)
	private String reporte;
	
	@Column( name="CLAVE_PROVEEDOR", nullable = true, unique=false)
	private String claveProveedor;
	
	@Column( name="SFTP", nullable = true, unique=false)
	@Convert("booleanConverter")
	private boolean sftp;
	
	@Column( name="CORREO", nullable = true, unique=false)
	@Convert("booleanConverter")
	private boolean correo;
	
	@Column(name = "ID_F_RECLAMACION_PEND", nullable = true, unique = false)
	private Integer idFReclamacionPend;
	
	@Column(name = "ID_F_ENCUESTA", nullable = true, unique = false)
	private Integer idFEncuesta;
	
	@Column(name = "ID_F_ASISTENCIA_VIAL",nullable = true, unique = false)
	private Integer idFAsistenciaVial;
	
	@Column(name = "ID_F_NUEVO_VEH", nullable = true, unique = false)
	private Integer idFNuevoVehi;
	
	@Column(name = "ID_F_PASE_MED", nullable = true, unique = false)
	private Integer idFPaseMed;
	
	@Column(name = "ID_F_ASIG_ABOG",nullable = true, unique = false)
	private Integer idFAsignacionAbog;
	
	@Column(name = "ID_F_VALE_AMBUL", nullable = true, unique = false)
	private Integer idFValeAmb;
	
	@Column(name = "ID_F_ORDEN_SERV", nullable = true, unique = false)
	private Integer idFOrdenServ;
	
	@Column(name = "ID_F_REPARACION_BIENES", nullable = true, unique = false)
	private Integer idFReparacionBienes;
	
	@Column(name = "ID_F_GARANTIA_PRENDARIA"  , nullable = true, unique = false)
	private Integer idFGarantiaPrendaria;
	
	@Column(name = "ID_F_DECLARACION_U", nullable = true, unique = false)
	private Integer idFDeclaracionU;
	
	@Column(name = "ID_F_INVENTARIO_AUTO" , nullable = true, unique = false)
	private Integer idFInventarioAuto;
	
	@Column(name = "ID_F_CUESTIONARIO_ROBO",nullable = true, unique = false)
	private Integer idFCuestionarioRobo;
	
	@Column(name = "ID_F_ADMISION_AUTO", nullable = true, unique = false)
	private Integer idFAdmisionAuto;
	
	@Column(name = "ID_F_ADMISION_MOTO", nullable = true, unique = false)
	private Integer idFAdmisionMoto;
	
	@Column(name = "ID_F_ADMISION_PESADO", nullable = true, unique = false)
	private Integer idFAdmisionPesado;
	
	@Column(name = "ID_F_INSPECCION_PESADO", nullable = true, unique = false)
	private Integer idFInspeccionPesado;
	
	@Column(name = "ID_F_INSPECCION_MOTO", nullable = true, unique = false)
	private Integer idFInspeccionMoto;
	
	@Column(name = "ID_F_RECIBO_ING_SINI", nullable = true, unique = false)
	private Integer idFReciboIngSin;
	
	@Column(name = "ID_F_RECIBO_PAGO_DED" , nullable = true, unique = false)
	private Integer idFReciboPagoDed;
	
	@Column(name = "ID_F_SOLICITUD_DIAG" , nullable = true, unique = false)
	private Integer idFSolicDiag;
	
	@Column(name = "ID_F_MEMORIA_DESC" ,nullable = true, unique = false)
	private Integer idFMemoriaDesc;
	
	@Column(name = "FECHA", nullable = true, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name = "NOMBRE_EXPEDIENTE" , nullable = true, unique = false)
	String nombreExpediente;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Estado.class)
	@JoinColumn(name = "ID_ESTADO" , referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Base.class)
	@JoinColumn(name = "ID_BASE" , referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Base base;
	
	@Column(name = "ID_F_CARGO_TARJETA" , nullable = true, unique = false)
	private Integer idFCargoTarjeta ;
	
	@Column( name="CAUSA", nullable = true, unique=false)
	private String causa;
	
	@Column(name="FOLIO", nullable= true, unique= false)
	private Integer folio;
	
	@Column(name="ID_TERMINAL", nullable = true, unique = false)
	private Integer terminal;
	
	@Column(name = "ID_F_RESPO_CIVIL_CONTRAC" , nullable = true, unique = false)
	private Integer idFResponsabilidadCivil ;
	
	@Column(name = "ID_F_ORDEN_BIENES_DIV" ,nullable = true, unique = false)
	private Integer idFOrdenBienesDiversos ;
	
	@Column(name= "ID_F_OBSERVACION_ASEG",nullable = true, unique = false)
	private Integer idFObservacionAseg;
	
	@Column(name= "ID_F_INVENTARIO_UNICO_PESADO",nullable = true, unique = false)
	private Integer idFInventarioUnicPesado;
	
	@Column(name= "ID_F_RECLAM_SIN_COMPR_PEAJE", nullable = true, unique = false)
	private Integer idFReclamacionComprobPeaje;
	
	@Column( name="ES_AJUSTE_EXPRES", nullable = true, unique=false)
	@Convert("booleanConverter")
	private boolean esAjusteExpres;
	
	@Column(name = "MENSAJE_SFTP" , nullable = true, unique = false)
	private String mensajeSftp;
	
	@Column(name = "MENSAJE_MAIL" , nullable = true, unique = false)
	private String mensajeMail;
	

	public AbstractExpedienteEjecutivo() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getClaveProveedor() {
		return claveProveedor;
	}

	public void setClaveProveedor(String claveProveedor) {
		this.claveProveedor = claveProveedor;
	}

	public boolean isSftp() {
		return sftp;
	}

	public void setSftp(boolean sftp) {
		this.sftp = sftp;
	}

	public boolean isCorreo() {
		return correo;
	}

	public void setCorreo(boolean correo) {
		this.correo = correo;
	}

	public Integer getIdFReclamacionPend() {
		return idFReclamacionPend;
	}

	public void setIdFReclamacionPend(Integer idFReclamacionPend) {
		this.idFReclamacionPend = idFReclamacionPend;
	}

	public Integer getIdFEncuesta() {
		return idFEncuesta;
	}

	public void setIdFEncuesta(Integer idFEncuesta) {
		this.idFEncuesta = idFEncuesta;
	}

	public Integer getIdFAsistenciaVial() {
		return idFAsistenciaVial;
	}

	public void setIdFAsistenciaVial(Integer idFAsistenciaVial) {
		this.idFAsistenciaVial = idFAsistenciaVial;
	}

	public Integer getIdFNuevoVehi() {
		return idFNuevoVehi;
	}

	public void setIdFNuevoVehi(Integer idFNuevoVehi) {
		this.idFNuevoVehi = idFNuevoVehi;
	}

	public Integer getIdFPaseMed() {
		return idFPaseMed;
	}

	public void setIdFPaseMed(Integer idFPaseMed) {
		this.idFPaseMed = idFPaseMed;
	}

	public Integer getIdFAsignacionAbog() {
		return idFAsignacionAbog;
	}

	public void setIdFAsignacionAbog(Integer idFAsignacionAbog) {
		this.idFAsignacionAbog = idFAsignacionAbog;
	}

	public Integer getIdFValeAmb() {
		return idFValeAmb;
	}

	public void setIdFValeAmb(Integer idFValeAmb) {
		this.idFValeAmb = idFValeAmb;
	}

	public Integer getIdFOrdenServ() {
		return idFOrdenServ;
	}

	public void setIdFOrdenServ(Integer idFOrdenServ) {
		this.idFOrdenServ = idFOrdenServ;
	}

	public Integer getIdFReparacionBienes() {
		return idFReparacionBienes;
	}

	public void setIdFReparacionBienes(Integer idFReparacionBienes) {
		this.idFReparacionBienes = idFReparacionBienes;
	}

	public Integer getIdFGarantiaPrendaria() {
		return idFGarantiaPrendaria;
	}

	public void setIdFGarantiaPrendaria(Integer idFGarantiaPrendaria) {
		this.idFGarantiaPrendaria = idFGarantiaPrendaria;
	}

	public Integer getIdFDeclaracionU() {
		return idFDeclaracionU;
	}

	public void setIdFDeclaracionU(Integer idFDeclaracionU) {
		this.idFDeclaracionU = idFDeclaracionU;
	}

	public Integer getIdFInventarioAuto() {
		return idFInventarioAuto;
	}

	public void setIdFInventarioAuto(Integer idFInventarioAuto) {
		this.idFInventarioAuto = idFInventarioAuto;
	}

	public Integer getIdFCuestionarioRobo() {
		return idFCuestionarioRobo;
	}

	public void setIdFCuestionarioRobo(Integer idFCuestionarioRobo) {
		this.idFCuestionarioRobo = idFCuestionarioRobo;
	}

	public Integer getIdFAdmisionAuto() {
		return idFAdmisionAuto;
	}

	public void setIdFAdmisionAuto(Integer idFAdmisionAuto) {
		this.idFAdmisionAuto = idFAdmisionAuto;
	}

	public Integer getIdFAdmisionMoto() {
		return idFAdmisionMoto;
	}

	public void setIdFAdmisionMoto(Integer idFAdmisionMoto) {
		this.idFAdmisionMoto = idFAdmisionMoto;
	}

	public Integer getIdFAdmisionPesado() {
		return idFAdmisionPesado;
	}

	public void setIdFAdmisionPesado(Integer idFAdmisionPesado) {
		this.idFAdmisionPesado = idFAdmisionPesado;
	}

	public Integer getIdFInspeccionPesado() {
		return idFInspeccionPesado;
	}

	public void setIdFInspeccionPesado(Integer idFInspeccionPesado) {
		this.idFInspeccionPesado = idFInspeccionPesado;
	}

	public Integer getIdFInspeccionMoto() {
		return idFInspeccionMoto;
	}

	public void setIdFInspeccionMoto(Integer idFInspeccionMoto) {
		this.idFInspeccionMoto = idFInspeccionMoto;
	}

	public Integer getIdFReciboIngSin() {
		return idFReciboIngSin;
	}

	public void setIdFReciboIngSin(Integer idFReciboIngSin) {
		this.idFReciboIngSin = idFReciboIngSin;
	}

	public Integer getIdFReciboPagoDed() {
		return idFReciboPagoDed;
	}

	public void setIdFReciboPagoDed(Integer idFReciboPagoDed) {
		this.idFReciboPagoDed = idFReciboPagoDed;
	}

	public Integer getIdFSolicDiag() {
		return idFSolicDiag;
	}

	public void setIdFSolicDiag(Integer idFSolicDiag) {
		this.idFSolicDiag = idFSolicDiag;
	}

	public Integer getIdFMemoriaDesc() {
		return idFMemoriaDesc;
	}

	public void setIdFMemoriaDesc(Integer idFMemoriaDesc) {
		this.idFMemoriaDesc = idFMemoriaDesc;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreExpediente() {
		return nombreExpediente;
	}

	public void setNombreExpediente(String nombreExpediente) {
		this.nombreExpediente = nombreExpediente;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getIdFCargoTarjeta() {
		return idFCargoTarjeta;
	}

	public void setIdFCargoTarjeta(Integer idFCargoTarjeta) {
		this.idFCargoTarjeta = idFCargoTarjeta;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Integer getFolio() {
		return folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public Integer getIdFResponsabilidadCivil() {
		return idFResponsabilidadCivil;
	}

	public void setIdFResponsabilidadCivil(Integer idFResponsabilidadCivil) {
		this.idFResponsabilidadCivil = idFResponsabilidadCivil;
	}

	public Integer getIdFOrdenBienesDiversos() {
		return idFOrdenBienesDiversos;
	}

	public void setIdFOrdenBienesDiversos(Integer idFOrdenBienesDiversos) {
		this.idFOrdenBienesDiversos = idFOrdenBienesDiversos;
	}

	public Integer getIdFObservacionAseg() {
		return idFObservacionAseg;
	}

	public void setIdFObservacionAseg(Integer idFObservacionAseg) {
		this.idFObservacionAseg = idFObservacionAseg;
	}

	public Integer getIdFInventarioUnicPesado() {
		return idFInventarioUnicPesado;
	}

	public void setIdFInventarioUnicPesado(Integer idFInventarioUnicPesado) {
		this.idFInventarioUnicPesado = idFInventarioUnicPesado;
	}

	public Integer getIdFReclamacionComprobPeaje() {
		return idFReclamacionComprobPeaje;
	}

	public void setIdFReclamacionComprobPeaje(Integer idFReclamacionComprobPeaje) {
		this.idFReclamacionComprobPeaje = idFReclamacionComprobPeaje;
	}

	public boolean isEsAjusteExpres() {
		return esAjusteExpres;
	}

	public void setEsAjusteExpres(boolean esAjusteExpres) {
		this.esAjusteExpres = esAjusteExpres;
	}

	public String getMensajeSftp() {
		return mensajeSftp;
	}

	public void setMensajeSftp(String mensajeSftp) {
		this.mensajeSftp = mensajeSftp;
	}

	public String getMensajeMail() {
		return mensajeMail;
	}

	public void setMensajeMail(String mensajeMail) {
		this.mensajeMail = mensajeMail;
	}
	
	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	public Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

	
	
	

}
