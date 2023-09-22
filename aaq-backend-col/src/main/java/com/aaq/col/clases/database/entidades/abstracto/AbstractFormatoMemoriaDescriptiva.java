package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

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
public abstract class AbstractFormatoMemoriaDescriptiva extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opMemeoriaSEQ", sequenceName = "formato_memoria_descriptiva_seq", allocationSize = 1)
	@Id
	@Column(name = "SG_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opMemeoriaSEQ")
	private Integer id;
	
	  @Column(name="CHECK_1")
	    private Integer check1;
	    
	    @Column(name="CHECK_2")
	    private Integer check2;
	    
	    @Column(name="CHECK_3")
	    private Integer check3;
	    
	    @Column(name="CHECK_4")
	    private Integer check4;

	@Column(name = "ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name = "FTP_RESPUESTA", length = 20)
	private String ftpRespuesta;

	@Column(name = "ENVIADO_EMAIL")
	private Integer enviadoEmail;

	@Column(name = "MENSAJES_EMAIL", length = 20)
	private String mensajesEmail;

	@Column(name = "PROCESO")
	private Integer proceso;

	@Column(name = "HORA_ENVIO_EMAIL")
	private Timestamp horaEnvioEmail;

	@Column(name = "HORA_ENVIO_SFTP")
	private Timestamp horaEnvioSftp;

	@Column(name = "NODO_ENVIO", length = 255)
	private String nodoEnvio;

	@Column(name = "SG_FOLIO_ELECTRO")
	private String folioElectro;

	@Column(name = "SG_NUM_REPORTE")
	private String reporte;

	@Column(name = "SG_NUM_SINIESTRO")
	private String siniestro;

	@Column(name = "SG_FECHA")
	private Date fecha;

	@Column(name = "SG_NUM_POLIZA")
	private String poliza;

	@Column(name = "SG_NUM_ENDOSO")
	private String endoso;

	@Column(name = "SG_NUM_INCISO")
	private String inciso;

	@Column(name = "SG_NOM_ASEGURADO")
	private String nomSocial;

	@Column(name = "SG_TIPO_ASEGURADO")
	private String tipoAsegurado;

	@Column(name = "SG_MARCA_AUTO")
	private String marca;

	@Column(name = "SG_TIPO_AUTO")
	private String tipo;

	@Column(name = "SG_MODELO_AUTO")
	private String modelo;

	@Column(name = "SG_PLACAS_AUTO")
	private String placas;

	@Column(name = "SG_COLOR_AUTO")
	private String color;

	@Column(name = "SG_DURACION_MANIOBRA")
	private String duracionMan;

	@Column(name = "SG_GRUA_LUGAR")
	private Integer gruaLugar;

	@Column(name = "SG_CONCESION")
	private Integer concesion;

	@Column(name = "SG_ESTATAL_FEDERAL")
	private Integer estatalFede;

	@Column(name = "SG_TIPO_MANIOBRA")
	private String maniobras;

	@Column(name = "SG_TIPO_GRUA")
	private String tipoGrua;

	@Column(name = "SG_OTRA")
	private String otraGruaTexto;

	@Column(name = "SG_PROVEEDOR")
	private String proveedor;

	@Column(name = "SG_UBI_ORIGEN")
	private String ubicacionOrigen;

	@Column(name = "SG_UBI_DESTINO")
	private String trasladoDestino;

	@Column(name = "SG_MANIO_ESPECIALES")
	private String manEspeciales;

	@Column(name = "SG_NOM_EMPLEADO")
	private String nomEmpleado;

	@Column(name = "SG_CLAVE_EMPLEADO")
	private String claveEmpleado;

	@Column(name = "SG_NOM_OPERADOR")
	private String nomOperadorGrua;

	@Column(name = "EMAIL_DEFAULT")
	private String correo;

	@Column(name = "SG_COBERTURA")
	private Integer cobertura;

	@Column(name = "OTRAGRUA")
	private Integer otraGrua;

	@Column(name = "CARDAN1")
	private Integer cardan1;

	@Column(name = "CARDAN2")
	private Integer cardan2;

	@Column(name = "CARDAN3")
	private Integer cardan3;

	@Column(name = "TIPOGRUAABANDERAMIENTO")
	private String tipoGruaAbander;

	@Column(name = "TRASPALEO")
	private Integer traspaleo;

	@Column(name = "TIPOTRASPALEO")
	private String tipoTraspaleo;

	@Column(name = "CANTIDADGRUASTEXTO")
	private String cantidadGruasTexto;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "DOMICILIOPROVEEDOR")
	private String domicilioProv;

	@Column(name = "HORARIOSOLICITADO")
	private String horarioSolicitado;

	@Column(name = "HORARIOARRIBO")
	private String horarioArribo;

	@Column(name = "HORARIOTRASLADO")
	private String horarioTraslado;

	@Column(name = "CAMIONTONELADAS")
	private Integer camionToneladas;

	@Column(name = "SERVICIODESACOPLAR")
	private Integer servicioDesacoplar;

	@Column(name = "SERVICIOABANDERAM")
	private Integer servicioAbanderaM;

	@Column(name = "SERVICIOABANDERAG")
	private Integer servicioAbanderaG;

	@Column(name = "SERVICIOENGANCHE")
	private Integer servicioEnganche;

	@Column(name = "SERVICIOFUERAC")
	private Integer servicioFueraC;

	@Column(name = "SERVICIOSOBREC")
	private Integer servicioSobreC;

	@Column(name = "SERVICIOVOLCADURA")
	private Integer servicioVolcadura;

	@Column(name = "SERVICIOCARGA")
	private Integer servicioCarga;

	@Column(name = "SERVICIORESCATE")
	private Integer servicioRescate;

	@Column(name = "SERVICIOCUSTODIA")
	private Integer servicioCustodia;

	@Column(name = "SERVICIOMANIOBRA")
	private Integer servicioManiobra;

	@Column(name = "NUMECOGRUA")
	private String numEcoGrua;

	@Column(name = "MANUALHORA")
	private String manualHora;

	@Column(name = "GRUAHORA")
	private String gruaHora;

	@Column(name = "FIRMAASEGURADO")
	private String firmaAsegurado;

	@Column(name = "FIRMAEMPLEADO")
	private String firmaEmpleado;

	@Column(name = "FIRMAOPERADORGRUA")
	private String firmaOperadorGrua;

	@Column(name = "CROQUIS")
	private String croquis;

	@Column(name = "ABAN_CANTIDAD_GRUAS")
	private String cantidadGruas;

	@Column(name="NUM_CONSECUTIVO")
	private Integer numConsecutivo;

    @Column(name="CORREO_OCULTO")
	private String correoOculto;
    
    @Column(name="FUENTE_WS")
	private String fuenteWs;
    
    @Column(name="CHECK_5")
    private Integer check5;
    
    @Column(name="CHECK_6")
    private Integer check6;
    
    

	public Integer getCheck5() {
		return check5;
	}
	public void setCheck5(Integer check5) {
		this.check5 = check5;
	}
	public Integer getCheck6() {
		return check6;
	}
	public void setCheck6(Integer check6) {
		this.check6 = check6;
	}
    

	public String getFuenteWs() {
		return fuenteWs;
	}
	public void setFuenteWs(String fuenteWs) {
		this.fuenteWs = fuenteWs;
	}

	public Integer getNumConsecutivo() {
		return numConsecutivo;
	}
	public void setNumConsecutivo(Integer numConsecutivo) {
		this.numConsecutivo = numConsecutivo;
	}
	
	public String getCorreoOculto() {
		return correoOculto;
	}
	public void setCorreoOculto(String correoOculto) {
		this.correoOculto = correoOculto;
	}

	/** default constructor */
	public AbstractFormatoMemoriaDescriptiva() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnviadoFtp() {
		return enviadoFtp;
	}

	public void setEnviadoFtp(Integer enviadoFtp) {
		this.enviadoFtp = enviadoFtp;
	}

	public String getFtpRespuesta() {
		return ftpRespuesta;
	}

	public void setFtpRespuesta(String ftpRespuesta) {
		this.ftpRespuesta = ftpRespuesta;
	}

	public Integer getEnviadoEmail() {
		return enviadoEmail;
	}

	public void setEnviadoEmail(Integer enviadoEmail) {
		this.enviadoEmail = enviadoEmail;
	}

	public String getMensajesEmail() {
		return mensajesEmail;
	}

	public void setMensajesEmail(String mensajesEmail) {
		this.mensajesEmail = mensajesEmail;
	}

	public Integer getProceso() {
		return proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

	public Timestamp getHoraEnvioEmail() {
		return horaEnvioEmail;
	}

	public void setHoraEnvioEmail(Timestamp horaEnvioEmail) {
		this.horaEnvioEmail = horaEnvioEmail;
	}

	public Timestamp getHoraEnvioSftp() {
		return horaEnvioSftp;
	}

	public void setHoraEnvioSftp(Timestamp horaEnvioSftp) {
		this.horaEnvioSftp = horaEnvioSftp;
	}

	public String getNodoEnvio() {
		return nodoEnvio;
	}

	public void setNodoEnvio(String nodoEnvio) {
		this.nodoEnvio = nodoEnvio;
	}

	public String getFolioElectro() {
		return folioElectro;
	}

	public void setFolioElectro(String folioElectro) {
		this.folioElectro = folioElectro;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getSiniestro() {
		return siniestro;
	}

	public void setSiniestro(String siniestro) {
		this.siniestro = siniestro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getEndoso() {
		return endoso;
	}

	public void setEndoso(String endoso) {
		this.endoso = endoso;
	}

	public String getInciso() {
		return inciso;
	}

	public void setInciso(String inciso) {
		this.inciso = inciso;
	}

	public String getNomSocial() {
		return nomSocial;
	}

	public void setNomSocial(String nomSocial) {
		this.nomSocial = nomSocial;
	}

	public String getTipoAsegurado() {
		return tipoAsegurado;
	}

	public void setTipoAsegurado(String tipoAsegurado) {
		this.tipoAsegurado = tipoAsegurado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlacas() {
		return placas;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDuracionMan() {
		return duracionMan;
	}

	public void setDuracionMan(String duracionMan) {
		this.duracionMan = duracionMan;
	}

	public Integer getGruaLugar() {
		return gruaLugar;
	}

	public void setGruaLugar(Integer gruaLugar) {
		this.gruaLugar = gruaLugar;
	}

	public Integer getConcesion() {
		return concesion;
	}

	public void setConcesion(Integer concesion) {
		this.concesion = concesion;
	}

	public Integer getEstatalFede() {
		return estatalFede;
	}

	public void setEstatalFede(Integer estatalFede) {
		this.estatalFede = estatalFede;
	}

	public String getManiobras() {
		return maniobras;
	}

	public void setManiobras(String maniobras) {
		this.maniobras = maniobras;
	}

	public String getTipoGrua() {
		return tipoGrua;
	}

	public void setTipoGrua(String tipoGrua) {
		this.tipoGrua = tipoGrua;
	}

	public String getOtraGruaTexto() {
		return otraGruaTexto;
	}

	public void setOtraGruaTexto(String otraGruaTexto) {
		this.otraGruaTexto = otraGruaTexto;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getUbicacionOrigen() {
		return ubicacionOrigen;
	}

	public void setUbicacionOrigen(String ubicacionOrigen) {
		this.ubicacionOrigen = ubicacionOrigen;
	}

	public String getTrasladoDestino() {
		return trasladoDestino;
	}

	public void setTrasladoDestino(String trasladoDestino) {
		this.trasladoDestino = trasladoDestino;
	}

	public String getManEspeciales() {
		return manEspeciales;
	}

	public void setManEspeciales(String manEspeciales) {
		this.manEspeciales = manEspeciales;
	}

	public String getNomEmpleado() {
		return nomEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public String getClaveEmpleado() {
		return claveEmpleado;
	}

	public void setClaveEmpleado(String claveEmpleado) {
		this.claveEmpleado = claveEmpleado;
	}

	public String getNomOperadorGrua() {
		return nomOperadorGrua;
	}

	public void setNomOperadorGrua(String nomOperadorGrua) {
		this.nomOperadorGrua = nomOperadorGrua;
	}

	public Integer getCobertura() {
		return cobertura;
	}

	public void setCobertura(Integer cobertura) {
		this.cobertura = cobertura;
	}

	public Integer getOtraGrua() {
		return otraGrua;
	}

	public void setOtraGrua(Integer otraGrua) {
		this.otraGrua = otraGrua;
	}

	public Integer getCardan1() {
		return cardan1;
	}

	public void setCardan1(Integer cardan1) {
		this.cardan1 = cardan1;
	}

	public Integer getCardan2() {
		return cardan2;
	}

	public void setCardan2(Integer cardan2) {
		this.cardan2 = cardan2;
	}

	public Integer getCardan3() {
		return cardan3;
	}

	public void setCardan3(Integer cardan3) {
		this.cardan3 = cardan3;
	}

	public String getTipoGruaAbander() {
		return tipoGruaAbander;
	}

	public void setTipoGruaAbander(String tipoGruaAbander) {
		this.tipoGruaAbander = tipoGruaAbander;
	}

	public Integer getTraspaleo() {
		return traspaleo;
	}

	public void setTraspaleo(Integer traspaleo) {
		this.traspaleo = traspaleo;
	}

	public String getTipoTraspaleo() {
		return tipoTraspaleo;
	}

	public void setTipoTraspaleo(String tipoTraspaleo) {
		this.tipoTraspaleo = tipoTraspaleo;
	}

	public String getCantidadGruasTexto() {
		return cantidadGruasTexto;
	}

	public void setCantidadGruasTexto(String cantidadGruasTexto) {
		this.cantidadGruasTexto = cantidadGruasTexto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilioProv() {
		return domicilioProv;
	}

	public void setDomicilioProv(String domicilioProv) {
		this.domicilioProv = domicilioProv;
	}

	public String getHorarioSolicitado() {
		return horarioSolicitado;
	}

	public void setHorarioSolicitado(String horarioSolicitado) {
		this.horarioSolicitado = horarioSolicitado;
	}

	public String getHorarioArribo() {
		return horarioArribo;
	}

	public void setHorarioArribo(String horarioArribo) {
		this.horarioArribo = horarioArribo;
	}

	public String getHorarioTraslado() {
		return horarioTraslado;
	}

	public void setHorarioTraslado(String horarioTraslado) {
		this.horarioTraslado = horarioTraslado;
	}

	public Integer getCamionToneladas() {
		return camionToneladas;
	}

	public void setCamionToneladas(Integer camionToneladas) {
		this.camionToneladas = camionToneladas;
	}

	public Integer getServicioDesacoplar() {
		return servicioDesacoplar;
	}

	public void setServicioDesacoplar(Integer servicioDesacoplar) {
		this.servicioDesacoplar = servicioDesacoplar;
	}

	public Integer getServicioAbanderaM() {
		return servicioAbanderaM;
	}

	public void setServicioAbanderaM(Integer servicioAbanderaM) {
		this.servicioAbanderaM = servicioAbanderaM;
	}

	public Integer getServicioAbanderaG() {
		return servicioAbanderaG;
	}

	public void setServicioAbanderaG(Integer servicioAbanderaG) {
		this.servicioAbanderaG = servicioAbanderaG;
	}

	public Integer getServicioEnganche() {
		return servicioEnganche;
	}

	public void setServicioEnganche(Integer servicioEnganche) {
		this.servicioEnganche = servicioEnganche;
	}

	public Integer getServicioFueraC() {
		return servicioFueraC;
	}

	public void setServicioFueraC(Integer servicioFueraC) {
		this.servicioFueraC = servicioFueraC;
	}

	public Integer getServicioSobreC() {
		return servicioSobreC;
	}

	public void setServicioSobreC(Integer servicioSobreC) {
		this.servicioSobreC = servicioSobreC;
	}

	public Integer getServicioVolcadura() {
		return servicioVolcadura;
	}

	public void setServicioVolcadura(Integer servicioVolcadura) {
		this.servicioVolcadura = servicioVolcadura;
	}

	public Integer getServicioCarga() {
		return servicioCarga;
	}

	public void setServicioCarga(Integer servicioCarga) {
		this.servicioCarga = servicioCarga;
	}

	public Integer getServicioRescate() {
		return servicioRescate;
	}

	public void setServicioRescate(Integer servicioRescate) {
		this.servicioRescate = servicioRescate;
	}

	public Integer getServicioCustodia() {
		return servicioCustodia;
	}

	public void setServicioCustodia(Integer servicioCustodia) {
		this.servicioCustodia = servicioCustodia;
	}

	public Integer getServicioManiobra() {
		return servicioManiobra;
	}

	public void setServicioManiobra(Integer servicioManiobra) {
		this.servicioManiobra = servicioManiobra;
	}

	public String getNumEcoGrua() {
		return numEcoGrua;
	}

	public void setNumEcoGrua(String numEcoGrua) {
		this.numEcoGrua = numEcoGrua;
	}

	public String getManualHora() {
		return manualHora;
	}

	public void setManualHora(String manualHora) {
		this.manualHora = manualHora;
	}

	public String getGruaHora() {
		return gruaHora;
	}

	public void setGruaHora(String gruaHora) {
		this.gruaHora = gruaHora;
	}

	public String getFirmaAsegurado() {
		return firmaAsegurado;
	}

	public void setFirmaAsegurado(String firmaAsegurado) {
		this.firmaAsegurado = firmaAsegurado;
	}

	public String getFirmaEmpleado() {
		return firmaEmpleado;
	}

	public void setFirmaEmpleado(String firmaEmpleado) {
		this.firmaEmpleado = firmaEmpleado;
	}

	public String getFirmaOperadorGrua() {
		return firmaOperadorGrua;
	}

	public void setFirmaOperadorGrua(String firmaOperadorGrua) {
		this.firmaOperadorGrua = firmaOperadorGrua;
	}

	public String getCroquis() {
		return croquis;
	}

	public void setCroquis(String croquis) {
		this.croquis = croquis;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCantidadGruas() {
		return cantidadGruas;
	}

	public void setCantidadGruas(String cantidadGruas) {
		this.cantidadGruas = cantidadGruas;
	}

	public Integer getCheck1() {
		return check1;
	}

	public void setCheck1(Integer check1) {
		this.check1 = check1;
	}

	public Integer getCheck2() {
		return check2;
	}

	public void setCheck2(Integer check2) {
		this.check2 = check2;
	}

	public Integer getCheck3() {
		return check3;
	}

	public void setCheck3(Integer check3) {
		this.check3 = check3;
	}

	public Integer getCheck4() {
		return check4;
	}

	public void setCheck4(Integer check4) {
		this.check4 = check4;
	}
	
	

}