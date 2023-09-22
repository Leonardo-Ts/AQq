package com.aaq.col.clases.webservices.movil.peticion;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MovilReporteSac {
    
    private Date fecha;
    private String generalNumeroReporte;
    private String generalNumeroPoliza;
    private String generalEndoso;
    private String generalInciso;
    private String generalNombreAsegurado;
    private String conductorNombre;
    private String vehiculoSerie;
    private String vehiculoPlacas;
    private String ajusteFechaPasadoAjustador;
    private String ajusteFechaArriboAjustador;
    private String ajusteFechaTerminoAjustador;
    private String generalComoOcurrio;
    private String ajusteHoraPasadoAjustador;
    private String ajusteHoraArriboAjustador;
    private String ajusteHoraTerminoAjustador;
    private String ajusteCodigoCausa;
    private String conductorTelefonoContacto;
    private String generalNumeroSiniestro;
    private String vehiculoMarca;
    private String vehiculoTipo;
    private String vehiculoModelo;
    private String vehiculoColor;
    private String generalUsuario;
    private Integer esReasignadoNumero;
    private Boolean esSegundaAtencion;
    private Boolean esReasignado;
    private String coordLatitudInicio;
    private String coordLongitudInicio;
    private String coordLatitudArribo;
    private String coordLongitudArribo;
    private String coordLatitudTermino;
    private String coordLongitudTermino;
    private String generalOficinaReporte;
    private String generalFechaOcurrido;
    private String generalHoraOcurrido;
    private String generalAseguradoCodigo;
    private String generalAseguradoTelefonoEncuesta;
    private String generalAseguradoTelefono;
    private String generalReporto;
    private String generalObservacion;
    private String generalTipoReporte;
    private String generalFechaRegistroSiniestro;
    private String conductorEdad;
    private String conductorSexo;
    private String ubicacionDireccion;
    private String ubicacionCarretera;
    private String ubicacionNacional;
    private String ubicacionCodigoPostal;
    private String ubicacionEntidad;
    private String ubicacionMunicipio;
    private String ubicacionColoniaCodigo;
    private String ubicacionColoniaDesc;
    private String vehiculoMotor;
    private String ajusteAjustadorCodigo;
    private String ajusteAjustadorNombre;
    private String ajusteAjustadorOficina;
    private String generalMonedaClave;
    private String generalMonedaNombre;
    private Date fechaReporteEnvioSms;
    private Date fechaReporteLecturaPorWs;
    private String ubicacionReferencia;
    private String token;
    private String generalAseguradoCorreo;
    private String generalAseguradoLatitudTelefonia;
    private String generalAseguradoLongitudTelefonia;
    private String generalAseguradoLatitudRadio;
    private String generalAseguradoLongitudRadio;
    
    @XmlElement(name = "Talleres")
    private MovilReporteSacTalleres talleres;
    @XmlElement(name = "terceros")
    private List<MovilReporteSacTercero> terceros;
    @XmlElement(name = "Gruas")
    private MovilReporteSacGruas gruas;
    
    /**
     *
     */
    public MovilReporteSac() {
        super();
    }

    
	/**
	 * @param fecha
	 * @param generalNumeroReporte
	 * @param generalNumeroPoliza
	 * @param generalEndoso
	 * @param generalInciso
	 * @param generalNombreAsegurado
	 * @param conductorNombre
	 * @param vehiculoSerie
	 * @param vehiculoPlacas
	 * @param ajusteFechaPasadoAjustador
	 * @param ajusteFechaArriboAjustador
	 * @param ajusteFechaTerminoAjustador
	 * @param generalComoOcurrio
	 * @param ajusteHoraPasadoAjustador
	 * @param ajusteHoraArriboAjustador
	 * @param ajusteHoraTerminoAjustador
	 * @param ajusteCodigoCausa
	 * @param conductorTelefonoContacto
	 * @param generalNumeroSiniestro
	 * @param vehiculoMarca
	 * @param vehiculoTipo
	 * @param vehiculoModelo
	 * @param vehiculoColor
	 * @param generalUsuario
	 * @param esReasignadoNumero
	 * @param esSegundaAtencion
	 * @param esReasignado
	 * @param coordLatitudInicio
	 * @param coordLongitudInicio
	 * @param coordLatitudArribo
	 * @param coordLongitudArribo
	 * @param coordLatitudTermino
	 * @param coordLongitudTermino
	 * @param generalOficinaReporte
	 * @param generalFechaOcurrido
	 * @param generalHoraOcurrido
	 * @param generalAseguradoCodigo
	 * @param generalAseguradoTelefonoEncuesta
	 * @param generalAseguradoTelefono
	 * @param generalReporto
	 * @param generalObservacion
	 * @param generalTipoReporte
	 * @param generalFechaRegistroSiniestro
	 * @param conductorEdad
	 * @param conductorSexo
	 * @param ubicacionDireccion
	 * @param ubicacionCarretera
	 * @param ubicacionNacional
	 * @param ubicacionCodigoPostal
	 * @param ubicacionEntidad
	 * @param ubicacionMunicipio
	 * @param ubicacionColoniaCodigo
	 * @param ubicacionColoniaDesc
	 * @param vehiculoMotor
	 * @param ajusteAjustadorCodigo
	 * @param ajusteAjustadorNombre
	 * @param ajusteAjustadorOficina
	 * @param generalMonedaClave
	 * @param generalMonedaNombre
	 * @param fechaReporteEnvioSms
	 * @param fechaReporteLecturaPorWs
	 * @param ubicacionReferencia
	 * @param token
	 * @param generalAseguradoCorreo
	 * @param generalAseguradoLatitudTelefonia
	 * @param generalAseguradoLongitudTelefonia
	 * @param generalAseguradoLatitudRadio
	 * @param generalAseguradoLongitudRadio
	 */
	public MovilReporteSac(Date fecha, String generalNumeroReporte,
			String generalNumeroPoliza, String generalEndoso,
			String generalInciso, String generalNombreAsegurado,
			String conductorNombre, String vehiculoSerie,
			String vehiculoPlacas, String ajusteFechaPasadoAjustador,
			String ajusteFechaArriboAjustador,
			String ajusteFechaTerminoAjustador, String generalComoOcurrio,
			String ajusteHoraPasadoAjustador, String ajusteHoraArriboAjustador,
			String ajusteHoraTerminoAjustador, String ajusteCodigoCausa,
			String conductorTelefonoContacto, String generalNumeroSiniestro,
			String vehiculoMarca, String vehiculoTipo, String vehiculoModelo,
			String vehiculoColor, String generalUsuario,
			Integer esReasignadoNumero, Boolean esSegundaAtencion,
			Boolean esReasignado, String coordLatitudInicio,
			String coordLongitudInicio, String coordLatitudArribo,
			String coordLongitudArribo, String coordLatitudTermino,
			String coordLongitudTermino, String generalOficinaReporte,
			String generalFechaOcurrido, String generalHoraOcurrido,
			String generalAseguradoCodigo,
			String generalAseguradoTelefonoEncuesta,
			String generalAseguradoTelefono, String generalReporto,
			String generalObservacion, String generalTipoReporte,
			String generalFechaRegistroSiniestro, String conductorEdad,
			String conductorSexo, String ubicacionDireccion,
			String ubicacionCarretera, String ubicacionNacional,
			String ubicacionCodigoPostal, String ubicacionEntidad,
			String ubicacionMunicipio, String ubicacionColoniaCodigo,
			String ubicacionColoniaDesc, String vehiculoMotor,
			String ajusteAjustadorCodigo, String ajusteAjustadorNombre,
			String ajusteAjustadorOficina, String generalMonedaClave,
			String generalMonedaNombre, Date fechaReporteEnvioSms,
			Date fechaReporteLecturaPorWs, String ubicacionReferencia,
			String token, String generalAseguradoCorreo, String generalAseguradoLatitudTelefonia, String generalAseguradoLongitudTelefonia,
			String generalAseguradoLatitudRadio, String generalAseguradoLongitudRadio) {
		super();
		this.fecha = fecha;
		this.generalNumeroReporte = generalNumeroReporte;
		this.generalNumeroPoliza = generalNumeroPoliza;
		this.generalEndoso = generalEndoso;
		this.generalInciso = generalInciso;
		this.generalNombreAsegurado = generalNombreAsegurado;
		this.conductorNombre = conductorNombre;
		this.vehiculoSerie = vehiculoSerie;
		this.vehiculoPlacas = vehiculoPlacas;
		this.ajusteFechaPasadoAjustador = ajusteFechaPasadoAjustador;
		this.ajusteFechaArriboAjustador = ajusteFechaArriboAjustador;
		this.ajusteFechaTerminoAjustador = ajusteFechaTerminoAjustador;
		this.generalComoOcurrio = generalComoOcurrio;
		this.ajusteHoraPasadoAjustador = ajusteHoraPasadoAjustador;
		this.ajusteHoraArriboAjustador = ajusteHoraArriboAjustador;
		this.ajusteHoraTerminoAjustador = ajusteHoraTerminoAjustador;
		this.ajusteCodigoCausa = ajusteCodigoCausa;
		this.conductorTelefonoContacto = conductorTelefonoContacto;
		this.generalNumeroSiniestro = generalNumeroSiniestro;
		this.vehiculoMarca = vehiculoMarca;
		this.vehiculoTipo = vehiculoTipo;
		this.vehiculoModelo = vehiculoModelo;
		this.vehiculoColor = vehiculoColor;
		this.generalUsuario = generalUsuario;
		this.esReasignadoNumero = esReasignadoNumero;
		this.esSegundaAtencion = esSegundaAtencion;
		this.esReasignado = esReasignado;
		this.coordLatitudInicio = coordLatitudInicio;
		this.coordLongitudInicio = coordLongitudInicio;
		this.coordLatitudArribo = coordLatitudArribo;
		this.coordLongitudArribo = coordLongitudArribo;
		this.coordLatitudTermino = coordLatitudTermino;
		this.coordLongitudTermino = coordLongitudTermino;
		this.generalOficinaReporte = generalOficinaReporte;
		this.generalFechaOcurrido = generalFechaOcurrido;
		this.generalHoraOcurrido = generalHoraOcurrido;
		this.generalAseguradoCodigo = generalAseguradoCodigo;
		this.generalAseguradoTelefonoEncuesta = generalAseguradoTelefonoEncuesta;
		this.generalAseguradoTelefono = generalAseguradoTelefono;
		this.generalReporto = generalReporto;
		this.generalObservacion = generalObservacion;
		this.generalTipoReporte = generalTipoReporte;
		this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
		this.conductorEdad = conductorEdad;
		this.conductorSexo = conductorSexo;
		this.ubicacionDireccion = ubicacionDireccion;
		this.ubicacionCarretera = ubicacionCarretera;
		this.ubicacionNacional = ubicacionNacional;
		this.ubicacionCodigoPostal = ubicacionCodigoPostal;
		this.ubicacionEntidad = ubicacionEntidad + " / " + ubicacionMunicipio;
		this.ubicacionMunicipio = ubicacionMunicipio;
		this.ubicacionColoniaCodigo = ubicacionColoniaCodigo;
		this.ubicacionColoniaDesc = ubicacionColoniaDesc;
		this.vehiculoMotor = vehiculoMotor;
		this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
		this.ajusteAjustadorNombre = ajusteAjustadorNombre;
		this.ajusteAjustadorOficina = ajusteAjustadorOficina;
		this.generalMonedaClave = generalMonedaClave;
		this.generalMonedaNombre = generalMonedaNombre;
		this.fechaReporteEnvioSms = fechaReporteEnvioSms;
		this.fechaReporteLecturaPorWs = fechaReporteLecturaPorWs;
		this.ubicacionReferencia = ubicacionReferencia;
		this.token = token;
		this.generalAseguradoCorreo = generalAseguradoCorreo;
		this.generalAseguradoLatitudTelefonia = generalAseguradoLatitudTelefonia;
		this.generalAseguradoLongitudTelefonia = generalAseguradoLongitudTelefonia;
		this.generalAseguradoLatitudRadio = generalAseguradoLatitudRadio;
		this.generalAseguradoLongitudRadio = generalAseguradoLongitudRadio;
	}





	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getGeneralNumeroReporte() {
		return generalNumeroReporte;
	}

	public void setGeneralNumeroReporte(String generalNumeroReporte) {
		this.generalNumeroReporte = generalNumeroReporte;
	}

	public String getGeneralNumeroPoliza() {
		return generalNumeroPoliza;
	}

	public void setGeneralNumeroPoliza(String generalNumeroPoliza) {
		this.generalNumeroPoliza = generalNumeroPoliza;
	}

	public String getGeneralEndoso() {
		return generalEndoso;
	}

	public void setGeneralEndoso(String generalEndoso) {
		this.generalEndoso = generalEndoso;
	}

	public String getGeneralInciso() {
		return generalInciso;
	}

	public void setGeneralInciso(String generalInciso) {
		this.generalInciso = generalInciso;
	}

	public String getGeneralNombreAsegurado() {
		return generalNombreAsegurado;
	}

	public void setGeneralNombreAsegurado(String generalNombreAsegurado) {
		this.generalNombreAsegurado = generalNombreAsegurado;
	}

	public String getConductorNombre() {
		return conductorNombre;
	}

	public void setConductorNombre(String conductorNombre) {
		this.conductorNombre = conductorNombre;
	}

	public String getVehiculoSerie() {
		return vehiculoSerie;
	}

	public void setVehiculoSerie(String vehiculoSerie) {
		this.vehiculoSerie = vehiculoSerie;
	}

	public String getVehiculoPlacas() {
		return vehiculoPlacas;
	}

	public void setVehiculoPlacas(String vehiculoPlacas) {
		this.vehiculoPlacas = vehiculoPlacas;
	}

	public String getAjusteFechaPasadoAjustador() {
		return ajusteFechaPasadoAjustador;
	}

	public void setAjusteFechaPasadoAjustador(String ajusteFechaPasadoAjustador) {
		this.ajusteFechaPasadoAjustador = ajusteFechaPasadoAjustador;
	}

	public String getAjusteFechaArriboAjustador() {
		return ajusteFechaArriboAjustador;
	}

	public void setAjusteFechaArriboAjustador(String ajusteFechaArriboAjustador) {
		this.ajusteFechaArriboAjustador = ajusteFechaArriboAjustador;
	}

	public String getAjusteFechaTerminoAjustador() {
		return ajusteFechaTerminoAjustador;
	}

	public void setAjusteFechaTerminoAjustador(String ajusteFechaTerminoAjustador) {
		this.ajusteFechaTerminoAjustador = ajusteFechaTerminoAjustador;
	}

	public String getGeneralComoOcurrio() {
		return generalComoOcurrio;
	}

	public void setGeneralComoOcurrio(String generalComoOcurrio) {
		this.generalComoOcurrio = generalComoOcurrio;
	}

	public String getAjusteHoraPasadoAjustador() {
		return ajusteHoraPasadoAjustador;
	}

	public void setAjusteHoraPasadoAjustador(String ajusteHoraPasadoAjustador) {
		this.ajusteHoraPasadoAjustador = ajusteHoraPasadoAjustador;
	}

	public String getAjusteHoraArriboAjustador() {
		return ajusteHoraArriboAjustador;
	}

	public void setAjusteHoraArriboAjustador(String ajusteHoraArriboAjustador) {
		this.ajusteHoraArriboAjustador = ajusteHoraArriboAjustador;
	}

	public String getAjusteHoraTerminoAjustador() {
		return ajusteHoraTerminoAjustador;
	}

	public void setAjusteHoraTerminoAjustador(String ajusteHoraTerminoAjustador) {
		this.ajusteHoraTerminoAjustador = ajusteHoraTerminoAjustador;
	}

	public String getAjusteCodigoCausa() {
		return ajusteCodigoCausa;
	}

	public void setAjusteCodigoCausa(String ajusteCodigoCausa) {
		this.ajusteCodigoCausa = ajusteCodigoCausa;
	}

	public String getConductorTelefonoContacto() {
		return conductorTelefonoContacto;
	}

	public void setConductorTelefonoContacto(String conductorTelefonoContacto) {
		this.conductorTelefonoContacto = conductorTelefonoContacto;
	}

	public String getGeneralNumeroSiniestro() {
		return generalNumeroSiniestro;
	}

	public void setGeneralNumeroSiniestro(String generalNumeroSiniestro) {
		this.generalNumeroSiniestro = generalNumeroSiniestro;
	}

	public String getVehiculoMarca() {
		return vehiculoMarca;
	}

	public void setVehiculoMarca(String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	public String getVehiculoTipo() {
		return vehiculoTipo;
	}

	public void setVehiculoTipo(String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}

	public String getVehiculoModelo() {
		return vehiculoModelo;
	}

	public void setVehiculoModelo(String vehiculoModelo) {
		this.vehiculoModelo = vehiculoModelo;
	}

	public String getVehiculoColor() {
		return vehiculoColor;
	}

	public void setVehiculoColor(String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	public String getGeneralUsuario() {
		return generalUsuario;
	}

	public void setGeneralUsuario(String generalUsuario) {
		this.generalUsuario = generalUsuario;
	}

	public Integer getEsReasignadoNumero() {
		return esReasignadoNumero;
	}

	public void setEsReasignadoNumero(Integer esReasignadoNumero) {
		this.esReasignadoNumero = esReasignadoNumero;
	}

	public Boolean getEsSegundaAtencion() {
		return esSegundaAtencion;
	}

	public void setEsSegundaAtencion(Boolean esSegundaAtencion) {
		this.esSegundaAtencion = esSegundaAtencion;
	}

	public Boolean getEsReasignado() {
		return esReasignado;
	}

	public void setEsReasignado(Boolean esReasignado) {
		this.esReasignado = esReasignado;
	}

	public String getCoordLatitudInicio() {
		return coordLatitudInicio;
	}

	public void setCoordLatitudInicio(String coordLatitudInicio) {
		this.coordLatitudInicio = coordLatitudInicio;
	}

	public String getCoordLongitudInicio() {
		return coordLongitudInicio;
	}

	public void setCoordLongitudInicio(String coordLongitudInicio) {
		this.coordLongitudInicio = coordLongitudInicio;
	}

	public String getCoordLatitudArribo() {
		return coordLatitudArribo;
	}

	public void setCoordLatitudArribo(String coordLatitudArribo) {
		this.coordLatitudArribo = coordLatitudArribo;
	}

	public String getCoordLongitudArribo() {
		return coordLongitudArribo;
	}

	public void setCoordLongitudArribo(String coordLongitudArribo) {
		this.coordLongitudArribo = coordLongitudArribo;
	}

	public String getCoordLatitudTermino() {
		return coordLatitudTermino;
	}

	public void setCoordLatitudTermino(String coordLatitudTermino) {
		this.coordLatitudTermino = coordLatitudTermino;
	}

	public String getCoordLongitudTermino() {
		return coordLongitudTermino;
	}

	public void setCoordLongitudTermino(String coordLongitudTermino) {
		this.coordLongitudTermino = coordLongitudTermino;
	}

	public String getGeneralOficinaReporte() {
		return generalOficinaReporte;
	}

	public void setGeneralOficinaReporte(String generalOficinaReporte) {
		this.generalOficinaReporte = generalOficinaReporte;
	}

	public String getGeneralFechaOcurrido() {
		return generalFechaOcurrido;
	}

	public void setGeneralFechaOcurrido(String generalFechaOcurrido) {
		this.generalFechaOcurrido = generalFechaOcurrido;
	}

	public String getGeneralHoraOcurrido() {
		return generalHoraOcurrido;
	}

	public void setGeneralHoraOcurrido(String generalHoraOcurrido) {
		this.generalHoraOcurrido = generalHoraOcurrido;
	}

	public String getGeneralAseguradoCodigo() {
		return generalAseguradoCodigo;
	}

	public void setGeneralAseguradoCodigo(String generalAseguradoCodigo) {
		this.generalAseguradoCodigo = generalAseguradoCodigo;
	}

	public String getGeneralAseguradoTelefonoEncuesta() {
		return generalAseguradoTelefonoEncuesta;
	}

	public void setGeneralAseguradoTelefonoEncuesta(
			String generalAseguradoTelefonoEncuesta) {
		this.generalAseguradoTelefonoEncuesta = generalAseguradoTelefonoEncuesta;
	}

	public String getGeneralAseguradoTelefono() {
		return generalAseguradoTelefono;
	}

	public void setGeneralAseguradoTelefono(String generalAseguradoTelefono) {
		this.generalAseguradoTelefono = generalAseguradoTelefono;
	}

	public String getGeneralReporto() {
		return generalReporto;
	}

	public void setGeneralReporto(String generalReporto) {
		this.generalReporto = generalReporto;
	}

	public String getGeneralObservacion() {
		return generalObservacion;
	}

	public void setGeneralObservacion(String generalObservacion) {
		this.generalObservacion = generalObservacion;
	}

	public String getGeneralTipoReporte() {
		return generalTipoReporte;
	}

	public void setGeneralTipoReporte(String generalTipoReporte) {
		this.generalTipoReporte = generalTipoReporte;
	}

	public String getGeneralFechaRegistroSiniestro() {
		return generalFechaRegistroSiniestro;
	}

	public void setGeneralFechaRegistroSiniestro(
			String generalFechaRegistroSiniestro) {
		this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
	}

	public String getConductorEdad() {
		return conductorEdad;
	}

	public void setConductorEdad(String conductorEdad) {
		this.conductorEdad = conductorEdad;
	}

	public String getConductorSexo() {
		return conductorSexo;
	}

	public void setConductorSexo(String conductorSexo) {
		this.conductorSexo = conductorSexo;
	}

	public String getUbicacionDireccion() {
		return ubicacionDireccion;
	}

	public void setUbicacionDireccion(String ubicacionDireccion) {
		this.ubicacionDireccion = ubicacionDireccion;
	}

	public String getUbicacionCarretera() {
		return ubicacionCarretera;
	}

	public void setUbicacionCarretera(String ubicacionCarretera) {
		this.ubicacionCarretera = ubicacionCarretera;
	}

	public String getUbicacionNacional() {
		return ubicacionNacional;
	}

	public void setUbicacionNacional(String ubicacionNacional) {
		this.ubicacionNacional = ubicacionNacional;
	}

	public String getUbicacionCodigoPostal() {
		return ubicacionCodigoPostal;
	}

	public void setUbicacionCodigoPostal(String ubicacionCodigoPostal) {
		this.ubicacionCodigoPostal = ubicacionCodigoPostal;
	}

	public String getUbicacionEntidad() {
		return ubicacionEntidad;
	}

	public void setUbicacionEntidad(String ubicacionEntidad) {
		this.ubicacionEntidad = ubicacionEntidad;
	}

	public String getUbicacionMunicipio() {
		return ubicacionMunicipio;
	}

	public void setUbicacionMunicipio(String ubicacionMunicipio) {
		this.ubicacionMunicipio = ubicacionMunicipio;
	}

	public String getUbicacionColoniaCodigo() {
		return ubicacionColoniaCodigo;
	}

	public void setUbicacionColoniaCodigo(String ubicacionColoniaCodigo) {
		this.ubicacionColoniaCodigo = ubicacionColoniaCodigo;
	}

	public String getUbicacionColoniaDesc() {
		return ubicacionColoniaDesc;
	}

	public void setUbicacionColoniaDesc(String ubicacionColoniaDesc) {
		this.ubicacionColoniaDesc = ubicacionColoniaDesc;
	}

	public String getVehiculoMotor() {
		return vehiculoMotor;
	}

	public void setVehiculoMotor(String vehiculoMotor) {
		this.vehiculoMotor = vehiculoMotor;
	}

	public String getAjusteAjustadorCodigo() {
		return ajusteAjustadorCodigo;
	}

	public void setAjusteAjustadorCodigo(String ajusteAjustadorCodigo) {
		this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
	}

	public String getAjusteAjustadorNombre() {
		return ajusteAjustadorNombre;
	}

	public void setAjusteAjustadorNombre(String ajusteAjustadorNombre) {
		this.ajusteAjustadorNombre = ajusteAjustadorNombre;
	}

	public String getAjusteAjustadorOficina() {
		return ajusteAjustadorOficina;
	}

	public void setAjusteAjustadorOficina(String ajusteAjustadorOficina) {
		this.ajusteAjustadorOficina = ajusteAjustadorOficina;
	}

	public String getGeneralMonedaClave() {
		return generalMonedaClave;
	}

	public void setGeneralMonedaClave(String generalMonedaClave) {
		this.generalMonedaClave = generalMonedaClave;
	}

	public String getGeneralMonedaNombre() {
		return generalMonedaNombre;
	}

	public void setGeneralMonedaNombre(String generalMonedaNombre) {
		this.generalMonedaNombre = generalMonedaNombre;
	}

	public Date getFechaReporteEnvioSms() {
		return fechaReporteEnvioSms;
	}

	public void setFechaReporteEnvioSms(Date fechaReporteEnvioSms) {
		this.fechaReporteEnvioSms = fechaReporteEnvioSms;
	}

	public Date getFechaReporteLecturaPorWs() {
		return fechaReporteLecturaPorWs;
	}

	public void setFechaReporteLecturaPorWs(Date fechaReporteLecturaPorWs) {
		this.fechaReporteLecturaPorWs = fechaReporteLecturaPorWs;
	}

	public String getUbicacionReferencia() {
		return ubicacionReferencia;
	}

	public void setUbicacionReferencia(String ubicacionReferencia) {
		this.ubicacionReferencia = ubicacionReferencia;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getGeneralAseguradoCorreo() {
		return generalAseguradoCorreo;
	}

	public void setGeneralAseguradoCorreo(String generalAseguradoCorreo) {
		this.generalAseguradoCorreo = generalAseguradoCorreo;
	}
	/**
	 * @return the generalAseguradoLatitudTelefonia
	 */
	public String getGeneralAseguradoLatitudTelefonia() {
		return generalAseguradoLatitudTelefonia;
	}


	/**
	 * @param generalAseguradoLatitudTelefonia the generalAseguradoLatitudTelefonia to set
	 */
	public void setGeneralAseguradoLatitudTelefonia(
			String generalAseguradoLatitudTelefonia) {
		this.generalAseguradoLatitudTelefonia = generalAseguradoLatitudTelefonia;
	}


	/**
	 * @return the generalAseguradoLongitudTelefonia
	 */
	public String getGeneralAseguradoLongitudTelefonia() {
		return generalAseguradoLongitudTelefonia;
	}


	/**
	 * @param generalAseguradoLongitudTelefonia the generalAseguradoLongitudTelefonia to set
	 */
	public void setGeneralAseguradoLongitudTelefonia(
			String generalAseguradoLongitudTelefonia) {
		this.generalAseguradoLongitudTelefonia = generalAseguradoLongitudTelefonia;
	}


	/**
	 * @return the generalAseguradoLatitudRadio
	 */
	public String getGeneralAseguradoLatitudRadio() {
		return generalAseguradoLatitudRadio;
	}


	/**
	 * @param generalAseguradoLatitudRadio the generalAseguradoLatitudRadio to set
	 */
	public void setGeneralAseguradoLatitudRadio(String generalAseguradoLatitudRadio) {
		this.generalAseguradoLatitudRadio = generalAseguradoLatitudRadio;
	}


	/**
	 * @return the generalAseguradoLongitudRadio
	 */
	public String getGeneralAseguradoLongitudRadio() {
		return generalAseguradoLongitudRadio;
	}


	/**
	 * @param generalAseguradoLongitudRadio the generalAseguradoLongitudRadio to set
	 */
	public void setGeneralAseguradoLongitudRadio(
			String generalAseguradoLongitudRadio) {
		this.generalAseguradoLongitudRadio = generalAseguradoLongitudRadio;
	}


	public List<MovilReporteSacTercero> getTerceros() {
		return terceros;
	}


	public void setTerceros(List<MovilReporteSacTercero> terceros) {
		this.terceros = terceros;
	}


	/**
	 * @return the talleres
	 */
	public MovilReporteSacTalleres getTalleres() {
		return talleres;
	}


	/**
	 * @param talleres the talleres to set
	 */
	public void setTalleres(MovilReporteSacTalleres talleres) {
		this.talleres = talleres;
	}


	/**
	 * @return the gruas
	 */
	public MovilReporteSacGruas getGruas() {
		return gruas;
	}


	/**
	 * @param gruas the gruas to set
	 */
	public void setGruas(MovilReporteSacGruas gruas) {
		this.gruas = gruas;
	}
}
