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
 public abstract class AbstractFormatoReclamacionComprobantePeaje extends JMEntidad {

	private static final long serialVersionUID = 5473717999158319092L;

	@SequenceGenerator(name = "opPeajeUPSEQ", sequenceName = "formato_reclamacion_comrpobante_peaje_seq", allocationSize = 1)
	 @Id
	 @Column(name = "RCP_ID")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opPeajeUPSEQ")
	 private Integer id;
	
	@Column(name="ENVIADO_FTP")
	private Integer enviadoFtp;

	@Column(name="FTP_RESPUESTA", length=255)
	private String ftpRespuesta;
	
	@Column(name="ENVIADO_EMAIL")
	private Integer enviadoEmail;

    @Column(name="MENSAJES_EMAIL", length=255)
	private String mensajeEmail;
      
    @Column(name="PROCESO")
	private Integer proceso;
    
    @Column(name="HORA_ENVIO_EMAIL")
	private Timestamp horaEnvioEmail;
    
    @Column(name="HORA_ENVIO_Sftp")
   	private Timestamp horaEnvioSftp;
    
    @Column(name="NODO_ENVIO", length=255)
   	private String nodoEnvio;
     
    @Column(name="CHECK_1")
    private Integer check1;
    
    @Column(name="CHECK_2")
    private Integer check2;
    
    @Column(name="CHECK_3")
    private Integer check3;
    
    @Column(name="CHECK_4")
    private Integer check4;
    
  
    
    @Column(name="FIRMA_AJUSTADOR")
	private String firma_ajustador;
    
    @Column(name="FIRMA_ADMINISTRACION")
	private String firma_administracion;
    
    
    @Column(name="FIRMA_USUARIO")
	private String firma_usuario;
    
    @Column(name="FIRMA_TESTIGO1")
	private String firma_testigo1;
    
    @Column(name="FIRMA_TESTIGO2")
   	private String firma_testigo2;

    
 
	
	 public String getRcp_num_reporte() {
		return rcp_num_reporte;
	}

	public void setRcp_num_reporte(String rcp_num_reporte) {
		this.rcp_num_reporte = rcp_num_reporte;
	}

	public String getRcp_num_siniestro() {
		return rcp_num_siniestro;
	}

	public void setRcp_num_siniestro(String rcp_num_siniestro) {
		this.rcp_num_siniestro = rcp_num_siniestro;
	}

	public String getRcp_num_poliza() {
		return rcp_num_poliza;
	}

	public void setRcp_num_poliza(String rcp_num_poliza) {
		this.rcp_num_poliza = rcp_num_poliza;
	}

	public String getRcp_num_asegurado() {
		return rcp_num_asegurado;
	}

	public void setRcp_num_asegurado(String rcp_num_asegurado) {
		this.rcp_num_asegurado = rcp_num_asegurado;
	}

	@Column(name="RCP_NUM_REPORTE")
		private String rcp_num_reporte;
	    
	    @Column(name="RCP_NUM_SINIESTRO")
		private String rcp_num_siniestro;
	    
	    @Column(name="RCP_NUM_POLIZA")
		private String rcp_num_poliza;
	    
	    @Column(name="RCP_NUM_ASEGURADO") 
		private String rcp_num_asegurado;
    
    @Column(name=" RCP_NOM_USUARIO")
    private String rcp_nom_usuario;

    @Column(name=" RCP_SEXO_USUARIO")
    private String rcp_sexo_usuario;

    @Column(name=" RCP_EDAD_USUARIO")
    private String rcp_edad_usuario;

    @Column(name=" RCP_ESTADO_CIVIL_USUARIO")
    private String rcp_estado_civil_usuario;

    @Column(name=" RCP_OCUPACION_USUARIO")
    private String rcp_ocupacion_usuario;

    @Column(name=" RCP_TELEFONO_USUARIO")
    private String rcp_telefono_usuario;

    @Column(name=" RCP_CORREO_USUARIO")
    private String rcp_correo_usuario;

    @Column(name=" RCP_CALLE_USUARIO")
    private String rcp_calle_usuario;

    @Column(name=" RCP_COLONIA_USUARIO")
    private String rcp_colonia_usuario;

    @Column(name=" RCP_CP_USUARIO")
    private String rcp_cp_usuario;

    @Column(name=" RCP_ESTADO_USUARIO")
    private String rcp_estado_usuario;

    @Column(name=" RCP_POBLACION_USUARIO")
    private String rcp_poblacion_usuario;

    @Column(name=" RCP_DELEGACION_USUARIO")
    private String rcp_delegacion_usuario;

    @Column(name=" RCP_CALLE_OFICINA")
    private String rcp_calle_oficina;

    @Column(name=" RCP_COLONIA_OFICINA")
    private String rcp_colonia_oficina;

    @Column(name=" RCP_CP_OFICINA")
    private String rcp_cp_oficina;

    @Column(name=" RCP_ESTADO_OFICINA")
    private String rcp_estado_oficina;

    @Column(name=" RCP_POBLACION_OFICINA")
    private String rcp_poblacion_oficina;

    @Column(name=" RCP_DELEGACION_OFICINA")
    private String rcp_delegacion_oficina;

    @Column(name=" RCP_RAZON_CIRCULA_AUTO")
    private Integer rcp_razon_circula_auto;

    @Column(name=" RCP_FECHA_SINIESTRO")
    private Date rcp_fecha_siniestro;

    @Column(name=" RCP_MARCA_VEHICULO")
    private String rcp_marca_vehiculo;

    @Column(name=" RCP_VEHICULO_PROPIO")
    private Integer rcp_vehiculo_propio;

    @Column(name=" RCP_LICENCIA")
    private String rcp_licencia;

    @Column(name=" RCP_ORIGEN_VIAJE")
    private String rcp_origen_viaje;

    @Column(name=" RCP_DESTINO_VIAJE")
    private String rcp_destino_viaje;

    @Column(name=" RCP_MOTIVO_NO_COMPROB")
    private String rcp_motivo_no_comprob;

    @Column(name=" RCP_NOM_AJUSTADOR")
    private String rcp_nom_ajustador;

    @Column(name=" RCP_CLAVE_AJUSTADOR")
    private String rcp_clave_ajustador;

    @Column(name=" RCP_NOM_ADMINISTRACION")
    private String rcp_nom_administracion;

    @Column(name=" RCP_TESTIGO_1")
    private String rcp_testigo_1;

    @Column(name=" RCP_TESTIGO_2")
    private String rcp_testigo_2;

    @Column(name=" RCP_PAGO_PREVIO_PEAJE")
    private Integer rcp_pago_previo_peaje;

    @Column(name=" RCP_NOM_PLAZA_1")
    private String rcp_nom_plaza_1;

    @Column(name=" RCP_NOM_PLAZA_2")
    private String rcp_nom_plaza_2;

    @Column(name=" RCP_CANTIDAD_PLAZA_1")
    private String rcp_cantidad_plaza_1;

    @Column(name=" RCP_CANTIDAD_PLAZA_2")
    private String rcp_cantidad_plaza_2;

    @Column(name=" RCP_FRECUENCIA_CIRCULA")
    private String rcp_frecuencia_circula;

    @Column(name=" RCP_TARJETA_IAVE")
    private Integer rcp_tarjeta_iave;

    @Column(name=" RCP_PAGO_TARJETA_CREDITO")
    private String rcp_pago_tarjeta_credito;

    @Column(name=" RCP_VIA_INGRESO")
    private String rcp_via_ingreso;

    @Column(name=" RCP_MOTIVO_DANIO")
    private String rcp_motivo_danio;

    @Column(name=" RCP_CAUSA_METEOROLOGICA")
    private Integer rcp_causa_meteorologica;

    @Column(name=" RCP_CAUSA_EVENTO")
    private Integer rcp_causa_evento;

    @Column(name=" RCP_INGIRIO_SUSTANCIA")
    private Integer rcp_ingirio_sustancia;

    @Column(name=" RCP_VEHICULO_ASEGURADO")
    private Integer rcp_vehiculo_asegurado;

    @Column(name=" RCP_VEHICULO_ASEGURADO_POLIZA")
    private String rcp_vehiculo_asegurado_poliza;

    @Column(name=" RCP_VEHICULO_ASEGURADO_COMPANIA")
    private String rcp_vehiculo_asegurado_compania;

    @Column(name=" RCP_ANEXO_IDENTIFICACION")
    private String rcp_anexo_identificacion;

    @Column(name=" RCP_ANEXO_LICENCIA")
    private String rcp_anexo_licencia;

    @Column(name=" RCP_ANEXO_NARRACION")
    private String rcp_anexo_narracion;

    @Column(name=" RCP_NOM_TESTIGO")
    private String rcp_nom_testigo;

    @Column(name=" RCP_RELACION_TESTIGO")
    private String rcp_relacion_testigo;

    @Column(name=" RCP_TELEFONO_TESTIGO")
    private String rcp_telefono_testigo;

    @Column(name=" RCP_CALLE_TESTIGO")
    private String rcp_calle_testigo;

    @Column(name=" RCP_COLONIA_TESTIGO")
    private String rcp_colonia_testigo;

    @Column(name=" RCP_CP_TESTIGO")
    private String rcp_cp_testigo;

    @Column(name=" RCP_ESTADO_TESTIGO")
    private String rcp_estado_testigo;

    @Column(name=" RCP_POBLACION_TESTIGO")
    private String rcp_poblacion_testigo;

    @Column(name=" RCP_DELEGACION_TESTIGO")
    private String rcp_delegacion_testigo;

    @Column(name=" RCP_DECLARACION_TESTIGO")
    private String rcp_declaracion_testigo;
    
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

	public String getMensajeEmail() {
		return mensajeEmail;
	}

	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
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

	

	public String getRcp_nom_usuario() {
		return rcp_nom_usuario;
	}

	public void setRcp_nom_usuario(String rcp_nom_usuario) {
		this.rcp_nom_usuario = rcp_nom_usuario;
	}

	public String getRcp_sexo_usuario() {
		return rcp_sexo_usuario;
	}

	public void setRcp_sexo_usuario(String rcp_sexo_usuario) {
		this.rcp_sexo_usuario = rcp_sexo_usuario;
	}

	public String getRcp_edad_usuario() {
		return rcp_edad_usuario;
	}

	public void setRcp_edad_usuario(String rcp_edad_usuario) {
		this.rcp_edad_usuario = rcp_edad_usuario;
	}

	public String getRcp_estado_civil_usuario() {
		return rcp_estado_civil_usuario;
	}

	public void setRcp_estado_civil_usuario(String rcp_estado_civil_usuario) {
		this.rcp_estado_civil_usuario = rcp_estado_civil_usuario;
	}

	public String getRcp_ocupacion_usuario() {
		return rcp_ocupacion_usuario;
	}

	public void setRcp_ocupacion_usuario(String rcp_ocupacion_usuario) {
		this.rcp_ocupacion_usuario = rcp_ocupacion_usuario;
	}

	public String getRcp_telefono_usuario() {
		return rcp_telefono_usuario;
	}

	public void setRcp_telefono_usuario(String rcp_telefono_usuario) {
		this.rcp_telefono_usuario = rcp_telefono_usuario;
	}

	public String getRcp_correo_usuario() {
		return rcp_correo_usuario;
	}

	public void setRcp_correo_usuario(String rcp_correo_usuario) {
		this.rcp_correo_usuario = rcp_correo_usuario;
	}

	public String getRcp_calle_usuario() {
		return rcp_calle_usuario;
	}

	public void setRcp_calle_usuario(String rcp_calle_usuario) {
		this.rcp_calle_usuario = rcp_calle_usuario;
	}

	public String getRcp_colonia_usuario() {
		return rcp_colonia_usuario;
	}

	public void setRcp_colonia_usuario(String rcp_colonia_usuario) {
		this.rcp_colonia_usuario = rcp_colonia_usuario;
	}

	public String getRcp_cp_usuario() {
		return rcp_cp_usuario;
	}

	public void setRcp_cp_usuario(String rcp_cp_usuario) {
		this.rcp_cp_usuario = rcp_cp_usuario;
	}

	public String getRcp_estado_usuario() {
		return rcp_estado_usuario;
	}

	public void setRcp_estado_usuario(String rcp_estado_usuario) {
		this.rcp_estado_usuario = rcp_estado_usuario;
	}

	public String getRcp_poblacion_usuario() {
		return rcp_poblacion_usuario;
	}

	public void setRcp_poblacion_usuario(String rcp_poblacion_usuario) {
		this.rcp_poblacion_usuario = rcp_poblacion_usuario;
	}

	public String getRcp_delegacion_usuario() {
		return rcp_delegacion_usuario;
	}

	public void setRcp_delegacion_usuario(String rcp_delegacion_usuario) {
		this.rcp_delegacion_usuario = rcp_delegacion_usuario;
	}

	public String getRcp_calle_oficina() {
		return rcp_calle_oficina;
	}

	public void setRcp_calle_oficina(String rcp_calle_oficina) {
		this.rcp_calle_oficina = rcp_calle_oficina;
	}

	public String getRcp_colonia_oficina() {
		return rcp_colonia_oficina;
	}

	public void setRcp_colonia_oficina(String rcp_colonia_oficina) {
		this.rcp_colonia_oficina = rcp_colonia_oficina;
	}

	public String getRcp_cp_oficina() {
		return rcp_cp_oficina;
	}

	public void setRcp_cp_oficina(String rcp_cp_oficina) {
		this.rcp_cp_oficina = rcp_cp_oficina;
	}

	public String getRcp_estado_oficina() {
		return rcp_estado_oficina;
	}

	public void setRcp_estado_oficina(String rcp_estado_oficina) {
		this.rcp_estado_oficina = rcp_estado_oficina;
	}

	public String getRcp_poblacion_oficina() {
		return rcp_poblacion_oficina;
	}

	public void setRcp_poblacion_oficina(String rcp_poblacion_oficina) {
		this.rcp_poblacion_oficina = rcp_poblacion_oficina;
	}

	public String getRcp_delegacion_oficina() {
		return rcp_delegacion_oficina;
	}

	public void setRcp_delegacion_oficina(String rcp_delegacion_oficina) {
		this.rcp_delegacion_oficina = rcp_delegacion_oficina;
	}

	public Integer getRcp_razon_circula_auto() {
		return rcp_razon_circula_auto;
	}

	public void setRcp_razon_circula_auto(Integer rcp_razon_circula_auto) {
		this.rcp_razon_circula_auto = rcp_razon_circula_auto;
	}

	public Date getRcp_fecha_siniestro() {
		return rcp_fecha_siniestro;
	}

	public void setRcp_fecha_siniestro(Date rcp_fecha_siniestro) {
		this.rcp_fecha_siniestro = rcp_fecha_siniestro;
	}

	public String getRcp_marca_vehiculo() {
		return rcp_marca_vehiculo;
	}

	public void setRcp_marca_vehiculo(String rcp_marca_vehiculo) {
		this.rcp_marca_vehiculo = rcp_marca_vehiculo;
	}

	public Integer getRcp_vehiculo_propio() {
		return rcp_vehiculo_propio;
	}

	public void setRcp_vehiculo_propio(Integer rcp_vehiculo_propio) {
		this.rcp_vehiculo_propio = rcp_vehiculo_propio;
	}

	public String getRcp_licencia() {
		return rcp_licencia;
	}

	public void setRcp_licencia(String rcp_licencia) {
		this.rcp_licencia = rcp_licencia;
	}

	public String getRcp_origen_viaje() {
		return rcp_origen_viaje;
	}

	public void setRcp_origen_viaje(String rcp_origen_viaje) {
		this.rcp_origen_viaje = rcp_origen_viaje;
	}

	public String getRcp_destino_viaje() {
		return rcp_destino_viaje;
	}

	public void setRcp_destino_viaje(String rcp_destino_viaje) {
		this.rcp_destino_viaje = rcp_destino_viaje;
	}

	public String getRcp_motivo_no_comprob() {
		return rcp_motivo_no_comprob;
	}

	public void setRcp_motivo_no_comprob(String rcp_motivo_no_comprob) {
		this.rcp_motivo_no_comprob = rcp_motivo_no_comprob;
	}

	public String getRcp_nom_ajustador() {
		return rcp_nom_ajustador;
	}

	public void setRcp_nom_ajustador(String rcp_nom_ajustador) {
		this.rcp_nom_ajustador = rcp_nom_ajustador;
	}

	public String getRcp_clave_ajustador() {
		return rcp_clave_ajustador;
	}

	public void setRcp_clave_ajustador(String rcp_clave_ajustador) {
		this.rcp_clave_ajustador = rcp_clave_ajustador;
	}

	public String getRcp_nom_administracion() {
		return rcp_nom_administracion;
	}

	public void setRcp_nom_administracion(String rcp_nom_administracion) {
		this.rcp_nom_administracion = rcp_nom_administracion;
	}

	public String getRcp_testigo_1() {
		return rcp_testigo_1;
	}

	public void setRcp_testigo_1(String rcp_testigo_1) {
		this.rcp_testigo_1 = rcp_testigo_1;
	}

	public String getRcp_testigo_2() {
		return rcp_testigo_2;
	}

	public void setRcp_testigo_2(String rcp_testigo_2) {
		this.rcp_testigo_2 = rcp_testigo_2;
	}

	public Integer getRcp_pago_previo_peaje() {
		return rcp_pago_previo_peaje;
	}

	public void setRcp_pago_previo_peaje(Integer rcp_pago_previo_peaje) {
		this.rcp_pago_previo_peaje = rcp_pago_previo_peaje;
	}

	public String getRcp_nom_plaza_1() {
		return rcp_nom_plaza_1;
	}

	public void setRcp_nom_plaza_1(String rcp_nom_plaza_1) {
		this.rcp_nom_plaza_1 = rcp_nom_plaza_1;
	}

	public String getRcp_nom_plaza_2() {
		return rcp_nom_plaza_2;
	}

	public void setRcp_nom_plaza_2(String rcp_nom_plaza_2) {
		this.rcp_nom_plaza_2 = rcp_nom_plaza_2;
	}

	public String getRcp_cantidad_plaza_1() {
		return rcp_cantidad_plaza_1;
	}

	public void setRcp_cantidad_plaza_1(String rcp_cantidad_plaza_1) {
		this.rcp_cantidad_plaza_1 = rcp_cantidad_plaza_1;
	}

	public String getRcp_cantidad_plaza_2() {
		return rcp_cantidad_plaza_2;
	}

	public void setRcp_cantidad_plaza_2(String rcp_cantidad_plaza_2) {
		this.rcp_cantidad_plaza_2 = rcp_cantidad_plaza_2;
	}

	public String getRcp_frecuencia_circula() {
		return rcp_frecuencia_circula;
	}

	public void setRcp_frecuencia_circula(String rcp_frecuencia_circula) {
		this.rcp_frecuencia_circula = rcp_frecuencia_circula;
	}

	public Integer getRcp_tarjeta_iave() {
		return rcp_tarjeta_iave;
	}

	public void setRcp_tarjeta_iave(Integer rcp_tarjeta_iave) {
		this.rcp_tarjeta_iave = rcp_tarjeta_iave;
	}

	public String getRcp_pago_tarjeta_credito() {
		return rcp_pago_tarjeta_credito;
	}

	public void setRcp_pago_tarjeta_credito(String rcp_pago_tarjeta_credito) {
		this.rcp_pago_tarjeta_credito = rcp_pago_tarjeta_credito;
	}

	public String getRcp_via_ingreso() {
		return rcp_via_ingreso;
	}

	public void setRcp_via_ingreso(String rcp_via_ingreso) {
		this.rcp_via_ingreso = rcp_via_ingreso;
	}

	public String getRcp_motivo_danio() {
		return rcp_motivo_danio;
	}

	public void setRcp_motivo_danio(String rcp_motivo_danio) {
		this.rcp_motivo_danio = rcp_motivo_danio;
	}

	public Integer getRcp_causa_meteorologica() {
		return rcp_causa_meteorologica;
	}

	public void setRcp_causa_meteorologica(Integer rcp_causa_meteorologica) {
		this.rcp_causa_meteorologica = rcp_causa_meteorologica;
	}

	public Integer getRcp_causa_evento() {
		return rcp_causa_evento;
	}

	public void setRcp_causa_evento(Integer rcp_causa_evento) {
		this.rcp_causa_evento = rcp_causa_evento;
	}

	public Integer getRcp_ingirio_sustancia() {
		return rcp_ingirio_sustancia;
	}

	public void setRcp_ingirio_sustancia(Integer rcp_ingirio_sustancia) {
		this.rcp_ingirio_sustancia = rcp_ingirio_sustancia;
	}

	public Integer getRcp_vehiculo_asegurado() {
		return rcp_vehiculo_asegurado;
	}

	public void setRcp_vehiculo_asegurado(Integer rcp_vehiculo_asegurado) {
		this.rcp_vehiculo_asegurado = rcp_vehiculo_asegurado;
	}

	public String getRcp_vehiculo_asegurado_poliza() {
		return rcp_vehiculo_asegurado_poliza;
	}

	public void setRcp_vehiculo_asegurado_poliza(String rcp_vehiculo_asegurado_poliza) {
		this.rcp_vehiculo_asegurado_poliza = rcp_vehiculo_asegurado_poliza;
	}

	public String getRcp_vehiculo_asegurado_compania() {
		return rcp_vehiculo_asegurado_compania;
	}

	public void setRcp_vehiculo_asegurado_compania(String rcp_vehiculo_asegurado_compania) {
		this.rcp_vehiculo_asegurado_compania = rcp_vehiculo_asegurado_compania;
	}

	public String getRcp_anexo_identificacion() {
		return rcp_anexo_identificacion;
	}

	public void setRcp_anexo_identificacion(String rcp_anexo_identificacion) {
		this.rcp_anexo_identificacion = rcp_anexo_identificacion;
	}

	public String getRcp_anexo_licencia() {
		return rcp_anexo_licencia;
	}

	public void setRcp_anexo_licencia(String rcp_anexo_licencia) {
		this.rcp_anexo_licencia = rcp_anexo_licencia;
	}

	public String getRcp_anexo_narracion() {
		return rcp_anexo_narracion;
	}

	public void setRcp_anexo_narracion(String rcp_anexo_narracion) {
		this.rcp_anexo_narracion = rcp_anexo_narracion;
	}

	public String getRcp_nom_testigo() {
		return rcp_nom_testigo;
	}

	public void setRcp_nom_testigo(String rcp_nom_testigo) {
		this.rcp_nom_testigo = rcp_nom_testigo;
	}

	public String getRcp_relacion_testigo() {
		return rcp_relacion_testigo;
	}

	public void setRcp_relacion_testigo(String rcp_relacion_testigo) {
		this.rcp_relacion_testigo = rcp_relacion_testigo;
	}

	public String getRcp_telefono_testigo() {
		return rcp_telefono_testigo;
	}

	public void setRcp_telefono_testigo(String rcp_telefono_testigo) {
		this.rcp_telefono_testigo = rcp_telefono_testigo;
	}

	public String getRcp_calle_testigo() {
		return rcp_calle_testigo;
	}

	public void setRcp_calle_testigo(String rcp_calle_testigo) {
		this.rcp_calle_testigo = rcp_calle_testigo;
	}

	public String getRcp_colonia_testigo() {
		return rcp_colonia_testigo;
	}

	public void setRcp_colonia_testigo(String rcp_colonia_testigo) {
		this.rcp_colonia_testigo = rcp_colonia_testigo;
	}

	public String getRcp_cp_testigo() {
		return rcp_cp_testigo;
	}

	public void setRcp_cp_testigo(String rcp_cp_testigo) {
		this.rcp_cp_testigo = rcp_cp_testigo;
	}

	public String getRcp_estado_testigo() {
		return rcp_estado_testigo;
	}

	public void setRcp_estado_testigo(String rcp_estado_testigo) {
		this.rcp_estado_testigo = rcp_estado_testigo;
	}

	public String getRcp_poblacion_testigo() {
		return rcp_poblacion_testigo;
	}

	public void setRcp_poblacion_testigo(String rcp_poblacion_testigo) {
		this.rcp_poblacion_testigo = rcp_poblacion_testigo;
	}

	public String getRcp_delegacion_testigo() {
		return rcp_delegacion_testigo;
	}

	public void setRcp_delegacion_testigo(String rcp_delegacion_testigo) {
		this.rcp_delegacion_testigo = rcp_delegacion_testigo;
	}

	public String getRcp_declaracion_testigo() {
		return rcp_declaracion_testigo;
	}

	public void setRcp_declaracion_testigo(String rcp_declaracion_testigo) {
		this.rcp_declaracion_testigo = rcp_declaracion_testigo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFirma_ajustador() {
		return firma_ajustador;
	}

	public void setFirma_ajustador(String firma_ajustador) {
		this.firma_ajustador = firma_ajustador;
	}

	public String getFirma_administracion() {
		return firma_administracion;
	}

	public void setFirma_administracion(String firma_administracion) {
		this.firma_administracion = firma_administracion;
	}

	public String getFirma_usuario() {
		return firma_usuario;
	}

	public void setFirma_usuario(String firma_usuario) {
		this.firma_usuario = firma_usuario;
	}

	public String getFirma_testigo1() {
		return firma_testigo1;
	}

	public void setFirma_testigo1(String firma_testigo1) {
		this.firma_testigo1 = firma_testigo1;
	}

	public String getFirma_testigo2() {
		return firma_testigo2;
	}

	public void setFirma_testigo2(String firma_testigo2) {
		this.firma_testigo2 = firma_testigo2;
	}

    
    
    
	
	
}