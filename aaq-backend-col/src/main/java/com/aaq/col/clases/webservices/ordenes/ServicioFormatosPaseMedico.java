/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class ServicioFormatosPaseMedico {

	private String usuario;
	private String passwd;
	private ProveedorAdmi proveedor;
	private Integer pmId;

	private Integer idAjustador;

	private Integer pmAmbulatoria;
	private String pmAsegurado;
	private Integer pmCausaLesion;
	private String pmClaveAjustador;
	private String pmClaveClinica;
	private String pmClaveMedico;
	private Integer pmCoberturaAfec;
	private Integer pmConvenio;
	private String pmDomClinica;
	private String pmEdadLesionado;
	private String pmEmailAsegurado;
	private Date pmFechaEmision;
	private Date pmFechaSiniestro;
	private String pmFolio;
	private String pmFolioElectro;
	private String pmIdeLesionado;
	private String pmLesionesAparentes;
	private Integer pmLugarEmision;
	private String pmLugarEstado;
	private Integer pmMedicoRed;

	private String pmNomAjustador;
	private String pmNomAsegurado;
	private String pmNomClinica;
	private String pmNomLesionado;
	private String pmNomMedico;
	private String pmNumEndoso;
	private String pmNumInciso;
	private String pmNumLesionado;
	private String pmNumOcupantes;
	private String pmNumPoliza;
	private String pmNumReporte;
	private String pmNumSiniestro;
	private String pmOtraCobertura;
	private String pmOtraLesion;
	private String pmOtroVehiculo;
	private String pmTelClinica;
	private String pmTelLesionado;
	private String pmTelMedico;
	private Integer pmTipoClinica;
	private Integer pmTipoVehiculo;
	private Integer enviadoEmail;
	private String mensajeEmail;
	private String pmEmailLesionado;

	private Integer proceso;
	private Timestamp horaEnvioEmail;
	private Timestamp horaEnvioSftp;
	private String nodoEnvio;

	private Integer check1;
	private Integer check2;
	private Integer check3;
	private Integer check4;

	private String firmaAjustador;
	private String firmaAsegurado;
	private String firmaLesionado;

	/**
	 * @return the proceso
	 */
	public Integer getProceso() {
		return proceso;
	}

	/**
	 * @param proceso
	 *            the proceso to set
	 */
	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the horaEnvioEmail
	 */
	public Timestamp getHoraEnvioEmail() {
		return horaEnvioEmail;
	}

	/**
	 * @param horaEnvioEmail
	 *            the horaEnvioEmail to set
	 */
	public void setHoraEnvioEmail(Timestamp horaEnvioEmail) {
		this.horaEnvioEmail = horaEnvioEmail;
	}

	/**
	 * @return the horaEnvioSftp
	 */
	public Timestamp getHoraEnvioSftp() {
		return horaEnvioSftp;
	}

	/**
	 * @param horaEnvioSftp
	 *            the horaEnvioSftp to set
	 */
	public void setHoraEnvioSftp(Timestamp horaEnvioSftp) {
		this.horaEnvioSftp = horaEnvioSftp;
	}

	/**
	 * @return the nodoEnvio
	 */
	public String getNodoEnvio() {
		return nodoEnvio;
	}

	/**
	 * @param nodoEnvio
	 *            the nodoEnvio to set
	 */
	public void setNodoEnvio(String nodoEnvio) {
		this.nodoEnvio = nodoEnvio;
	}

	/**
	 * @return the enviadoEmail
	 */
	public Integer getEnviadoEmail() {
		return enviadoEmail;
	}

	/**
	 * @param enviadoEmail
	 *            the enviadoEmail to set
	 */
	public void setEnviadoEmail(Integer enviadoEmail) {
		this.enviadoEmail = enviadoEmail;
	}

	/**
	 * @return the mensajeEmail
	 */
	public String getMensajeEmail() {
		return mensajeEmail;
	}

	/**
	 * @param mensajeEmail
	 *            the mensajeEmail to set
	 */
	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
	}

	public ServicioFormatosPaseMedico() {
		super();

	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the proveedor
	 */
	public ProveedorAdmi getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(ProveedorAdmi proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the pmId
	 */
	public Integer getPmId() {
		return pmId;
	}

	/**
	 * @param pmId
	 *            the pmId to set
	 */
	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}

	/**
	 * @return the idAjustador
	 */
	public Integer getIdAjustador() {
		return idAjustador;
	}

	/**
	 * @param idAjustador
	 *            the idAjustador to set
	 */
	public void setIdAjustador(Integer idAjustador) {
		this.idAjustador = idAjustador;
	}

	/**
	 * @return the pmAmbulatoria
	 */
	public Integer getPmAmbulatoria() {
		return pmAmbulatoria;
	}

	/**
	 * @param pmAmbulatoria
	 *            the pmAmbulatoria to set
	 */
	public void setPmAmbulatoria(Integer pmAmbulatoria) {
		this.pmAmbulatoria = pmAmbulatoria;
	}

	/**
	 * @return the pmAsegurado
	 */
	public String getPmAsegurado() {
		return pmAsegurado;
	}

	/**
	 * @param pmAsegurado
	 *            the pmAsegurado to set
	 */
	public void setPmAsegurado(String pmAsegurado) {
		this.pmAsegurado = pmAsegurado;
	}

	/**
	 * @return the pmCausaLesion
	 */
	public Integer getPmCausaLesion() {
		return pmCausaLesion;
	}

	/**
	 * @param pmCausaLesion
	 *            the pmCausaLesion to set
	 */
	public void setPmCausaLesion(Integer pmCausaLesion) {
		this.pmCausaLesion = pmCausaLesion;
	}

	/**
	 * @return the pmClaveAjustador
	 */
	public String getPmClaveAjustador() {
		return pmClaveAjustador;
	}

	/**
	 * @param pmClaveAjustador
	 *            the pmClaveAjustador to set
	 */
	public void setPmClaveAjustador(String pmClaveAjustador) {
		this.pmClaveAjustador = pmClaveAjustador;
	}

	/**
	 * @return the pmClaveClinica
	 */
	public String getPmClaveClinica() {
		return pmClaveClinica;
	}

	/**
	 * @param pmClaveClinica
	 *            the pmClaveClinica to set
	 */
	public void setPmClaveClinica(String pmClaveClinica) {
		this.pmClaveClinica = pmClaveClinica;
	}

	/**
	 * @return the pmClaveMedico
	 */
	public String getPmClaveMedico() {
		return pmClaveMedico;
	}

	/**
	 * @param pmClaveMedico
	 *            the pmClaveMedico to set
	 */
	public void setPmClaveMedico(String pmClaveMedico) {
		this.pmClaveMedico = pmClaveMedico;
	}

	/**
	 * @return the pmCoberturaAfec
	 */
	public Integer getPmCoberturaAfec() {
		return pmCoberturaAfec;
	}

	/**
	 * @param pmCoberturaAfec
	 *            the pmCoberturaAfec to set
	 */
	public void setPmCoberturaAfec(Integer pmCoberturaAfec) {
		this.pmCoberturaAfec = pmCoberturaAfec;
	}

	/**
	 * @return the pmConvenio
	 */
	public Integer getPmConvenio() {
		return pmConvenio;
	}

	/**
	 * @param pmConvenio
	 *            the pmConvenio to set
	 */
	public void setPmConvenio(Integer pmConvenio) {
		this.pmConvenio = pmConvenio;
	}

	/**
	 * @return the pmDomClinica
	 */
	public String getPmDomClinica() {
		return pmDomClinica;
	}

	/**
	 * @param pmDomClinica
	 *            the pmDomClinica to set
	 */
	public void setPmDomClinica(String pmDomClinica) {
		this.pmDomClinica = pmDomClinica;
	}

	/**
	 * @return the pmEdadLesionado
	 */
	public String getPmEdadLesionado() {
		return pmEdadLesionado;
	}

	/**
	 * @param pmEdadLesionado
	 *            the pmEdadLesionado to set
	 */
	public void setPmEdadLesionado(String pmEdadLesionado) {
		this.pmEdadLesionado = pmEdadLesionado;
	}

	/**
	 * @return the pmEmailAsegurado
	 */
	public String getPmEmailAsegurado() {
		return pmEmailAsegurado;
	}

	/**
	 * @param pmEmailAsegurado
	 *            the pmEmailAsegurado to set
	 */
	public void setPmEmailAsegurado(String pmEmailAsegurado) {
		this.pmEmailAsegurado = pmEmailAsegurado;
	}

	/**
	 * @return the pmFechaEmision
	 */
	public Date getPmFechaEmision() {
		return pmFechaEmision;
	}

	/**
	 * @param pmFechaEmision
	 *            the pmFechaEmision to set
	 */
	public void setPmFechaEmision(Date pmFechaEmision) {
		this.pmFechaEmision = pmFechaEmision;
	}

	/**
	 * @return the pmFechaSiniestro
	 */
	public Date getPmFechaSiniestro() {
		return pmFechaSiniestro;
	}

	/**
	 * @param pmFechaSiniestro
	 *            the pmFechaSiniestro to set
	 */
	public void setPmFechaSiniestro(Date pmFechaSiniestro) {
		this.pmFechaSiniestro = pmFechaSiniestro;
	}

	/**
	 * @return the pmFolio
	 */
	public String getPmFolio() {
		return pmFolio;
	}

	/**
	 * @param pmFolio
	 *            the pmFolio to set
	 */
	public void setPmFolio(String pmFolio) {
		this.pmFolio = pmFolio;
	}

	/**
	 * @return the pmFolioElectro
	 */
	public String getPmFolioElectro() {
		return pmFolioElectro;
	}

	/**
	 * @param pmFolioElectro
	 *            the pmFolioElectro to set
	 */
	public void setPmFolioElectro(String pmFolioElectro) {
		this.pmFolioElectro = pmFolioElectro;
	}

	/**
	 * @return the pmIdeLesionado
	 */
	public String getPmIdeLesionado() {
		return pmIdeLesionado;
	}

	/**
	 * @param pmIdeLesionado
	 *            the pmIdeLesionado to set
	 */
	public void setPmIdeLesionado(String pmIdeLesionado) {
		this.pmIdeLesionado = pmIdeLesionado;
	}

	/**
	 * @return the pmLesionesAparentes
	 */
	public String getPmLesionesAparentes() {
		return pmLesionesAparentes;
	}

	/**
	 * @param pmLesionesAparentes
	 *            the pmLesionesAparentes to set
	 */
	public void setPmLesionesAparentes(String pmLesionesAparentes) {
		this.pmLesionesAparentes = pmLesionesAparentes;
	}

	/**
	 * @return the pmLugarEmision
	 */
	public Integer getPmLugarEmision() {
		return pmLugarEmision;
	}

	/**
	 * @param pmLugarEmision
	 *            the pmLugarEmision to set
	 */
	public void setPmLugarEmision(Integer pmLugarEmision) {
		this.pmLugarEmision = pmLugarEmision;
	}

	/**
	 * @return the pmLugarEstado
	 */
	public String getPmLugarEstado() {
		return pmLugarEstado;
	}

	/**
	 * @param pmLugarEstado
	 *            the pmLugarEstado to set
	 */
	public void setPmLugarEstado(String pmLugarEstado) {
		this.pmLugarEstado = pmLugarEstado;
	}

	/**
	 * @return the pmMedicoRed
	 */
	public Integer getPmMedicoRed() {
		return pmMedicoRed;
	}

	/**
	 * @param pmMedicoRed
	 *            the pmMedicoRed to set
	 */
	public void setPmMedicoRed(Integer pmMedicoRed) {
		this.pmMedicoRed = pmMedicoRed;
	}

	/**
	 * @return the pmNomAjustador
	 */
	public String getPmNomAjustador() {
		return pmNomAjustador;
	}

	/**
	 * @param pmNomAjustador
	 *            the pmNomAjustador to set
	 */
	public void setPmNomAjustador(String pmNomAjustador) {
		this.pmNomAjustador = pmNomAjustador;
	}

	/**
	 * @return the pmNomAsegurado
	 */
	public String getPmNomAsegurado() {
		return pmNomAsegurado;
	}

	/**
	 * @param pmNomAsegurado
	 *            the pmNomAsegurado to set
	 */
	public void setPmNomAsegurado(String pmNomAsegurado) {
		this.pmNomAsegurado = pmNomAsegurado;
	}

	/**
	 * @return the pmNomClinica
	 */
	public String getPmNomClinica() {
		return pmNomClinica;
	}

	/**
	 * @param pmNomClinica
	 *            the pmNomClinica to set
	 */
	public void setPmNomClinica(String pmNomClinica) {
		this.pmNomClinica = pmNomClinica;
	}

	/**
	 * @return the pmNomLesionado
	 */
	public String getPmNomLesionado() {
		return pmNomLesionado;
	}

	/**
	 * @param pmNomLesionado
	 *            the pmNomLesionado to set
	 */
	public void setPmNomLesionado(String pmNomLesionado) {
		this.pmNomLesionado = pmNomLesionado;
	}

	/**
	 * @return the pmNomMedico
	 */
	public String getPmNomMedico() {
		return pmNomMedico;
	}

	/**
	 * @param pmNomMedico
	 *            the pmNomMedico to set
	 */
	public void setPmNomMedico(String pmNomMedico) {
		this.pmNomMedico = pmNomMedico;
	}

	/**
	 * @return the pmNumEndoso
	 */
	public String getPmNumEndoso() {
		return pmNumEndoso;
	}

	/**
	 * @param pmNumEndoso
	 *            the pmNumEndoso to set
	 */
	public void setPmNumEndoso(String pmNumEndoso) {
		this.pmNumEndoso = pmNumEndoso;
	}

	/**
	 * @return the pmNumInciso
	 */
	public String getPmNumInciso() {
		return pmNumInciso;
	}

	/**
	 * @param pmNumInciso
	 *            the pmNumInciso to set
	 */
	public void setPmNumInciso(String pmNumInciso) {
		this.pmNumInciso = pmNumInciso;
	}

	/**
	 * @return the pmNumLesionado
	 */
	public String getPmNumLesionado() {
		return pmNumLesionado;
	}

	/**
	 * @param pmNumLesionado
	 *            the pmNumLesionado to set
	 */
	public void setPmNumLesionado(String pmNumLesionado) {
		this.pmNumLesionado = pmNumLesionado;
	}

	/**
	 * @return the pmNumOcupantes
	 */
	public String getPmNumOcupantes() {
		return pmNumOcupantes;
	}

	/**
	 * @param pmNumOcupantes
	 *            the pmNumOcupantes to set
	 */
	public void setPmNumOcupantes(String pmNumOcupantes) {
		this.pmNumOcupantes = pmNumOcupantes;
	}

	/**
	 * @return the pmNumPoliza
	 */
	public String getPmNumPoliza() {
		return pmNumPoliza;
	}

	/**
	 * @param pmNumPoliza
	 *            the pmNumPoliza to set
	 */
	public void setPmNumPoliza(String pmNumPoliza) {
		this.pmNumPoliza = pmNumPoliza;
	}

	/**
	 * @return the pmNumReporte
	 */
	public String getPmNumReporte() {
		return pmNumReporte;
	}

	/**
	 * @param pmNumReporte
	 *            the pmNumReporte to set
	 */
	public void setPmNumReporte(String pmNumReporte) {
		this.pmNumReporte = pmNumReporte;
	}

	/**
	 * @return the pmNumSiniestro
	 */
	public String getPmNumSiniestro() {
		return pmNumSiniestro;
	}

	/**
	 * @param pmNumSiniestro
	 *            the pmNumSiniestro to set
	 */
	public void setPmNumSiniestro(String pmNumSiniestro) {
		this.pmNumSiniestro = pmNumSiniestro;
	}

	/**
	 * @return the pmOtraCobertura
	 */
	public String getPmOtraCobertura() {
		return pmOtraCobertura;
	}

	/**
	 * @param pmOtraCobertura
	 *            the pmOtraCobertura to set
	 */
	public void setPmOtraCobertura(String pmOtraCobertura) {
		this.pmOtraCobertura = pmOtraCobertura;
	}

	/**
	 * @return the pmOtraLesion
	 */
	public String getPmOtraLesion() {
		return pmOtraLesion;
	}

	/**
	 * @param pmOtraLesion
	 *            the pmOtraLesion to set
	 */
	public void setPmOtraLesion(String pmOtraLesion) {
		this.pmOtraLesion = pmOtraLesion;
	}

	/**
	 * @return the pmOtroVehiculo
	 */
	public String getPmOtroVehiculo() {
		return pmOtroVehiculo;
	}

	/**
	 * @param pmOtroVehiculo
	 *            the pmOtroVehiculo to set
	 */
	public void setPmOtroVehiculo(String pmOtroVehiculo) {
		this.pmOtroVehiculo = pmOtroVehiculo;
	}

	/**
	 * @return the pmTelClinica
	 */
	public String getPmTelClinica() {
		return pmTelClinica;
	}

	/**
	 * @param pmTelClinica
	 *            the pmTelClinica to set
	 */
	public void setPmTelClinica(String pmTelClinica) {
		this.pmTelClinica = pmTelClinica;
	}

	/**
	 * @return the pmTelLesionado
	 */
	public String getPmTelLesionado() {
		return pmTelLesionado;
	}

	/**
	 * @param pmTelLesionado
	 *            the pmTelLesionado to set
	 */
	public void setPmTelLesionado(String pmTelLesionado) {
		this.pmTelLesionado = pmTelLesionado;
	}

	/**
	 * @return the pmTelMedico
	 */
	public String getPmTelMedico() {
		return pmTelMedico;
	}

	/**
	 * @param pmTelMedico
	 *            the pmTelMedico to set
	 */
	public void setPmTelMedico(String pmTelMedico) {
		this.pmTelMedico = pmTelMedico;
	}

	/**
	 * @return the pmTipoClinica
	 */
	public Integer getPmTipoClinica() {
		return pmTipoClinica;
	}

	/**
	 * @param pmTipoClinica
	 *            the pmTipoClinica to set
	 */
	public void setPmTipoClinica(Integer pmTipoClinica) {
		this.pmTipoClinica = pmTipoClinica;
	}

	/**
	 * @return the pmTipoVehiculo
	 */
	public Integer getPmTipoVehiculo() {
		return pmTipoVehiculo;
	}

	/**
	 * @param pmTipoVehiculo
	 *            the pmTipoVehiculo to set
	 */
	public void setPmTipoVehiculo(Integer pmTipoVehiculo) {
		this.pmTipoVehiculo = pmTipoVehiculo;
	}

	/**
	 * @return the pmEmailLesionado
	 */
	public String getPmEmailLesionado() {
		return pmEmailLesionado;
	}

	/**
	 * @param pmEmailLesionado
	 *            the pmEmailLesionado to set
	 */
	public void setPmEmailLesionado(String pmEmailLesionado) {
		this.pmEmailLesionado = pmEmailLesionado;
	}

	/**
	 * @return the check1
	 */
	public Integer getCheck1() {
		return check1;
	}

	/**
	 * @param check1
	 *            the check1 to set
	 */
	public void setCheck1(Integer check1) {
		this.check1 = check1;
	}

	/**
	 * @return the check2
	 */
	public Integer getCheck2() {
		return check2;
	}

	/**
	 * @param check2
	 *            the check2 to set
	 */
	public void setCheck2(Integer check2) {
		this.check2 = check2;
	}

	/**
	 * @return the check3
	 */
	public Integer getCheck3() {
		return check3;
	}

	/**
	 * @param check3
	 *            the check3 to set
	 */
	public void setCheck3(Integer check3) {
		this.check3 = check3;
	}

	/**
	 * @return the check4
	 */
	public Integer getCheck4() {
		return check4;
	}

	/**
	 * @param check4
	 *            the check4 to set
	 */
	public void setCheck4(Integer check4) {
		this.check4 = check4;
	}

	/**
	 * @return the firmaAjustador
	 */
	public String getFirmaAjustador() {
		return firmaAjustador;
	}

	/**
	 * @param firmaAjustador
	 *            the firmaAjustador to set
	 */
	public void setFirmaAjustador(String firmaAjustador) {
		this.firmaAjustador = firmaAjustador;
	}

	/**
	 * @return the firmaAsegurado
	 */
	public String getFirmaAsegurado() {
		return firmaAsegurado;
	}

	/**
	 * @param firmaAsegurado
	 *            the firmaAsegurado to set
	 */
	public void setFirmaAsegurado(String firmaAsegurado) {
		this.firmaAsegurado = firmaAsegurado;
	}

	/**
	 * @return the firmaLesionado
	 */
	public String getFirmaLesionado() {
		return firmaLesionado;
	}

	/**
	 * @param firmaLesionado
	 *            the firmaLesionado to set
	 */
	public void setFirmaLesionado(String firmaLesionado) {
		this.firmaLesionado = firmaLesionado;
	}

}