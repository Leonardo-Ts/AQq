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
public class ServicioFormatosReparacionBienes {

	private String usuario;
	private String passwd;
	private Date fechaHora;
	private String rbAsegurado;
	private String rbCarMarca;
	private String rbCarModelo;
	private String rbClaveAjustador;
	private Integer rbCuerpoA;
	private String rbDanios;
	private Integer rbDaniosPre;
	private String rbDesDanios;
	private String rbDomAfectado;
	private String rbEmailRepara;

	private String rbFolio;
	private String rbFolioElectro;

	private String rbKm;
	private String rbMaterial;
	private String rbMedAlto;
	private String rbMedAncho;
	private String rbMedLong;
	private String rbNomAfectado;
	private String rbNomAjustador;
	private String rbNomRepara;
	private String rbNumEndoso;
	private String rbNumFotos;
	private String rbNumInciso;
	private String rbNumPoliza;
	private String rbNumReporte;
	private String rbNumSiniestro;
	private String rbObservaciones;
	private String rbOtros;
	private String rbRepreAfectado;
	private String rbTelAfectado;
	private String rbTelRepara;

	private String rbTramo;
	private String rbNomAsegurado;
	private String rbMunicipio;
	private String rbEstado;
	private Integer idAjustador;
	private Integer enviadoEmail;
	private String mensajeEmail;
	private String rbEmailAfectado;

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

	public ServicioFormatosReparacionBienes() {
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
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the rbAsegurado
	 */
	public String getRbAsegurado() {
		return rbAsegurado;
	}

	/**
	 * @param rbAsegurado
	 *            the rbAsegurado to set
	 */
	public void setRbAsegurado(String rbAsegurado) {
		this.rbAsegurado = rbAsegurado;
	}

	/**
	 * @return the rbCarMarca
	 */
	public String getRbCarMarca() {
		return rbCarMarca;
	}

	/**
	 * @param rbCarMarca
	 *            the rbCarMarca to set
	 */
	public void setRbCarMarca(String rbCarMarca) {
		this.rbCarMarca = rbCarMarca;
	}

	/**
	 * @return the rbCarModelo
	 */
	public String getRbCarModelo() {
		return rbCarModelo;
	}

	/**
	 * @param rbCarModelo
	 *            the rbCarModelo to set
	 */
	public void setRbCarModelo(String rbCarModelo) {
		this.rbCarModelo = rbCarModelo;
	}

	/**
	 * @return the rbClaveAjustador
	 */
	public String getRbClaveAjustador() {
		return rbClaveAjustador;
	}

	/**
	 * @param rbClaveAjustador
	 *            the rbClaveAjustador to set
	 */
	public void setRbClaveAjustador(String rbClaveAjustador) {
		this.rbClaveAjustador = rbClaveAjustador;
	}

	/**
	 * @return the rbCuerpoA
	 */
	public Integer getRbCuerpoA() {
		return rbCuerpoA;
	}

	/**
	 * @param rbCuerpoA
	 *            the rbCuerpoA to set
	 */
	public void setRbCuerpoA(Integer rbCuerpoA) {
		this.rbCuerpoA = rbCuerpoA;
	}

	/**
	 * @return the rbDanios
	 */
	public String getRbDanios() {
		return rbDanios;
	}

	/**
	 * @param rbDanios
	 *            the rbDanios to set
	 */
	public void setRbDanios(String rbDanios) {
		this.rbDanios = rbDanios;
	}

	/**
	 * @return the rbDaniosPre
	 */
	public Integer getRbDaniosPre() {
		return rbDaniosPre;
	}

	/**
	 * @param rbDaniosPre
	 *            the rbDaniosPre to set
	 */
	public void setRbDaniosPre(Integer rbDaniosPre) {
		this.rbDaniosPre = rbDaniosPre;
	}

	/**
	 * @return the rbDesDanios
	 */
	public String getRbDesDanios() {
		return rbDesDanios;
	}

	/**
	 * @param rbDesDanios
	 *            the rbDesDanios to set
	 */
	public void setRbDesDanios(String rbDesDanios) {
		this.rbDesDanios = rbDesDanios;
	}

	/**
	 * @return the rbDomAfectado
	 */
	public String getRbDomAfectado() {
		return rbDomAfectado;
	}

	/**
	 * @param rbDomAfectado
	 *            the rbDomAfectado to set
	 */
	public void setRbDomAfectado(String rbDomAfectado) {
		this.rbDomAfectado = rbDomAfectado;
	}

	/**
	 * @return the rbEmailRepara
	 */
	public String getRbEmailRepara() {
		return rbEmailRepara;
	}

	/**
	 * @param rbEmailRepara
	 *            the rbEmailRepara to set
	 */
	public void setRbEmailRepara(String rbEmailRepara) {
		this.rbEmailRepara = rbEmailRepara;
	}

	/**
	 * @return the rbFolio
	 */
	public String getRbFolio() {
		return rbFolio;
	}

	/**
	 * @param rbFolio
	 *            the rbFolio to set
	 */
	public void setRbFolio(String rbFolio) {
		this.rbFolio = rbFolio;
	}

	/**
	 * @return the rbFolioElectro
	 */
	public String getRbFolioElectro() {
		return rbFolioElectro;
	}

	/**
	 * @param rbFolioElectro
	 *            the rbFolioElectro to set
	 */
	public void setRbFolioElectro(String rbFolioElectro) {
		this.rbFolioElectro = rbFolioElectro;
	}

	/**
	 * @return the rbKm
	 */
	public String getRbKm() {
		return rbKm;
	}

	/**
	 * @param rbKm
	 *            the rbKm to set
	 */
	public void setRbKm(String rbKm) {
		this.rbKm = rbKm;
	}

	/**
	 * @return the rbMaterial
	 */
	public String getRbMaterial() {
		return rbMaterial;
	}

	/**
	 * @param rbMaterial
	 *            the rbMaterial to set
	 */
	public void setRbMaterial(String rbMaterial) {
		this.rbMaterial = rbMaterial;
	}

	/**
	 * @return the rbMedAlto
	 */
	public String getRbMedAlto() {
		return rbMedAlto;
	}

	/**
	 * @param rbMedAlto
	 *            the rbMedAlto to set
	 */
	public void setRbMedAlto(String rbMedAlto) {
		this.rbMedAlto = rbMedAlto;
	}

	/**
	 * @return the rbMedAncho
	 */
	public String getRbMedAncho() {
		return rbMedAncho;
	}

	/**
	 * @param rbMedAncho
	 *            the rbMedAncho to set
	 */
	public void setRbMedAncho(String rbMedAncho) {
		this.rbMedAncho = rbMedAncho;
	}

	/**
	 * @return the rbMedLong
	 */
	public String getRbMedLong() {
		return rbMedLong;
	}

	/**
	 * @param rbMedLong
	 *            the rbMedLong to set
	 */
	public void setRbMedLong(String rbMedLong) {
		this.rbMedLong = rbMedLong;
	}

	/**
	 * @return the rbNomAfectado
	 */
	public String getRbNomAfectado() {
		return rbNomAfectado;
	}

	/**
	 * @param rbNomAfectado
	 *            the rbNomAfectado to set
	 */
	public void setRbNomAfectado(String rbNomAfectado) {
		this.rbNomAfectado = rbNomAfectado;
	}

	/**
	 * @return the rbNomAjustador
	 */
	public String getRbNomAjustador() {
		return rbNomAjustador;
	}

	/**
	 * @param rbNomAjustador
	 *            the rbNomAjustador to set
	 */
	public void setRbNomAjustador(String rbNomAjustador) {
		this.rbNomAjustador = rbNomAjustador;
	}

	/**
	 * @return the rbNomRepara
	 */
	public String getRbNomRepara() {
		return rbNomRepara;
	}

	/**
	 * @param rbNomRepara
	 *            the rbNomRepara to set
	 */
	public void setRbNomRepara(String rbNomRepara) {
		this.rbNomRepara = rbNomRepara;
	}

	/**
	 * @return the rbNumEndoso
	 */
	public String getRbNumEndoso() {
		return rbNumEndoso;
	}

	/**
	 * @param rbNumEndoso
	 *            the rbNumEndoso to set
	 */
	public void setRbNumEndoso(String rbNumEndoso) {
		this.rbNumEndoso = rbNumEndoso;
	}

	/**
	 * @return the rbNumFotos
	 */
	public String getRbNumFotos() {
		return rbNumFotos;
	}

	/**
	 * @param rbNumFotos
	 *            the rbNumFotos to set
	 */
	public void setRbNumFotos(String rbNumFotos) {
		this.rbNumFotos = rbNumFotos;
	}

	/**
	 * @return the rbNumInciso
	 */
	public String getRbNumInciso() {
		return rbNumInciso;
	}

	/**
	 * @param rbNumInciso
	 *            the rbNumInciso to set
	 */
	public void setRbNumInciso(String rbNumInciso) {
		this.rbNumInciso = rbNumInciso;
	}

	/**
	 * @return the rbNumPoliza
	 */
	public String getRbNumPoliza() {
		return rbNumPoliza;
	}

	/**
	 * @param rbNumPoliza
	 *            the rbNumPoliza to set
	 */
	public void setRbNumPoliza(String rbNumPoliza) {
		this.rbNumPoliza = rbNumPoliza;
	}

	/**
	 * @return the rbNumReporte
	 */
	public String getRbNumReporte() {
		return rbNumReporte;
	}

	/**
	 * @param rbNumReporte
	 *            the rbNumReporte to set
	 */
	public void setRbNumReporte(String rbNumReporte) {
		this.rbNumReporte = rbNumReporte;
	}

	/**
	 * @return the rbNumSiniestro
	 */
	public String getRbNumSiniestro() {
		return rbNumSiniestro;
	}

	/**
	 * @param rbNumSiniestro
	 *            the rbNumSiniestro to set
	 */
	public void setRbNumSiniestro(String rbNumSiniestro) {
		this.rbNumSiniestro = rbNumSiniestro;
	}

	/**
	 * @return the rbObservaciones
	 */
	public String getRbObservaciones() {
		return rbObservaciones;
	}

	/**
	 * @param rbObservaciones
	 *            the rbObservaciones to set
	 */
	public void setRbObservaciones(String rbObservaciones) {
		this.rbObservaciones = rbObservaciones;
	}

	/**
	 * @return the rbOtros
	 */
	public String getRbOtros() {
		return rbOtros;
	}

	/**
	 * @param rbOtros
	 *            the rbOtros to set
	 */
	public void setRbOtros(String rbOtros) {
		this.rbOtros = rbOtros;
	}

	/**
	 * @return the rbRepreAfectado
	 */
	public String getRbRepreAfectado() {
		return rbRepreAfectado;
	}

	/**
	 * @param rbRepreAfectado
	 *            the rbRepreAfectado to set
	 */
	public void setRbRepreAfectado(String rbRepreAfectado) {
		this.rbRepreAfectado = rbRepreAfectado;
	}

	/**
	 * @return the rbTelAfectado
	 */
	public String getRbTelAfectado() {
		return rbTelAfectado;
	}

	/**
	 * @param rbTelAfectado
	 *            the rbTelAfectado to set
	 */
	public void setRbTelAfectado(String rbTelAfectado) {
		this.rbTelAfectado = rbTelAfectado;
	}

	/**
	 * @return the rbTelRepara
	 */
	public String getRbTelRepara() {
		return rbTelRepara;
	}

	/**
	 * @param rbTelRepara
	 *            the rbTelRepara to set
	 */
	public void setRbTelRepara(String rbTelRepara) {
		this.rbTelRepara = rbTelRepara;
	}

	/**
	 * @return the rbTramo
	 */
	public String getRbTramo() {
		return rbTramo;
	}

	/**
	 * @param rbTramo
	 *            the rbTramo to set
	 */
	public void setRbTramo(String rbTramo) {
		this.rbTramo = rbTramo;
	}

	/**
	 * @return the rbNomAsegurado
	 */
	public String getRbNomAsegurado() {
		return rbNomAsegurado;
	}

	/**
	 * @param rbNomAsegurado
	 *            the rbNomAsegurado to set
	 */
	public void setRbNomAsegurado(String rbNomAsegurado) {
		this.rbNomAsegurado = rbNomAsegurado;
	}

	/**
	 * @return the rbMunicipio
	 */
	public String getRbMunicipio() {
		return rbMunicipio;
	}

	/**
	 * @param rbMunicipio
	 *            the rbMunicipio to set
	 */
	public void setRbMunicipio(String rbMunicipio) {
		this.rbMunicipio = rbMunicipio;
	}

	/**
	 * @return the rbEstado
	 */
	public String getRbEstado() {
		return rbEstado;
	}

	/**
	 * @param rbEstado
	 *            the rbEstado to set
	 */
	public void setRbEstado(String rbEstado) {
		this.rbEstado = rbEstado;
	}

	/**
	 * @return the rbEmailAfectado
	 */
	public String getRbEmailAfectado() {
		return rbEmailAfectado;
	}

	/**
	 * @param rbEmailAfectado
	 *            the rbEmailAfectado to set
	 */
	public void setRbEmailAfectado(String rbEmailAfectado) {
		this.rbEmailAfectado = rbEmailAfectado;
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

}
