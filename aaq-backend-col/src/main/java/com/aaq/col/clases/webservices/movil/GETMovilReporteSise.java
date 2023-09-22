package com.aaq.col.clases.webservices.movil;


import java.util.ArrayList;
import java.util.Date;

public class GETMovilReporteSise {
    private String catalogoCodigoDeCausa;
    private String estado;
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
    private String vehiculoArmadoraClave;
    private String vehiculoArmadoraNombre;
    private String vehiculoMotor;
    private String ajusteAjustadorCodigo;
    private String ajusteAjustadorNombre;
    private String ajusteAjustadorOficina;
    private String ajusteAveriguacion;
    private String ajusteDeducible;
    private String ajusteMinisterioPublioc;
    private String ajustePfp;
    private String ajusteRecuperoTipo;
    private String ajusteRecuperoNotas;
    private Boolean consultadoWs;
    private String generalFechaRegistroSiniestro;
    private String generalMonedaClave;
    private String generalMonedaNombre;
    private String ubicacionReferencia;
    private String token;
    private String generalAseguradoCorreo;
    private String generalAseguradoLatitudTelefonia;
    private String generalAseguradoLongitudTelefonia;
    private String generalAseguradoLatitudRadio;
    private String generalAseguradoLongitudRadio;
    private ArrayList<GETMovilReporteSiseTaller> talleres = new ArrayList<>();
    private ArrayList<GETMovilReporteSiseTercero> terceros = new ArrayList<>();
    private ArrayList<GETMovilReporteSiseGrua> gruas = new ArrayList<>();

    /**
     *
     */
    public GETMovilReporteSise() {
        super();
    }

    /**
     * @param catalogoCodigoDeCausa
     * @param estado es el identificador o el objeto del estado o entidad federativa
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
     * @param vehiculoArmadoraClave
     * @param vehiculoArmadoraNombre
     * @param vehiculoMotor
     * @param ajusteAjustadorCodigo
     * @param ajusteAjustadorNombre
     * @param ajusteAjustadorOficina
     * @param ajusteAveriguacion
     * @param ajusteDeducible
     * @param ajusteMinisterioPublioc
     * @param ajustePfp
     * @param ajusteRecuperoTipo
     * @param ajusteRecuperoNotas
     * @param consultadoWs
     * @param generalFechaRegistroSiniestro
     * @param generalMonedaClave
     * @param generalMonedaNombre
     * @param ubicacionReferencia
     * @param token
     */
    public GETMovilReporteSise(final String catalogoCodigoDeCausa, final String estado, final Date fecha,
                            final String generalNumeroReporte, final String generalNumeroPoliza, final String generalEndoso,
                            final String generalInciso, final String generalNombreAsegurado, final String conductorNombre,
                            final String vehiculoSerie, final String vehiculoPlacas, final String ajusteFechaPasadoAjustador,
                            final String ajusteFechaArriboAjustador, final String ajusteFechaTerminoAjustador,
                            final String generalComoOcurrio, final String ajusteHoraPasadoAjustador,
                            final String ajusteHoraArriboAjustador, final String ajusteHoraTerminoAjustador,
                            final String ajusteCodigoCausa, final String conductorTelefonoContacto,
                            final String generalNumeroSiniestro, final String vehiculoMarca, final String vehiculoTipo,
                            final String vehiculoModelo, final String vehiculoColor, final String generalUsuario,
                            final Integer esReasignadoNumero, final Boolean esSegundaAtencion, final Boolean esReasignado,
                            final String coordLatitudInicio, final String coordLongitudInicio, final String coordLatitudArribo,
                            final String coordLongitudArribo, final String coordLatitudTermino, final String coordLongitudTermino,
                            final String generalOficinaReporte, final String generalFechaOcurrido, final String generalHoraOcurrido,
                            final String generalAseguradoCodigo, final String generalAseguradoTelefonoEncuesta,
                            final String generalAseguradoTelefono, final String generalReporto, final String generalObservacion,
                            final String generalTipoReporte, final String conductorEdad, final String conductorSexo,
                            final String ubicacionDireccion, final String ubicacionCarretera, final String ubicacionNacional,
                            final String ubicacionCodigoPostal, final String ubicacionEntidad, final String ubicacionMunicipio,
                            final String ubicacionColoniaCodigo, final String ubicacionColoniaDesc, final String vehiculoArmadoraClave,
                            final String vehiculoArmadoraNombre, final String vehiculoMotor, final String ajusteAjustadorCodigo,
                            final String ajusteAjustadorNombre, final String ajusteAjustadorOficina, final String ajusteAveriguacion,
                            final String ajusteDeducible, final String ajusteMinisterioPublioc, final String ajustePfp,
                            final String ajusteRecuperoTipo, final String ajusteRecuperoNotas, final Boolean consultadoWs,
                            final String generalFechaRegistroSiniestro, final String generalMonedaClave,
                            final String generalMonedaNombre, final String ubicacionReferencia, final String token,final String generalAseguradoLatitudTelefonia,
                            final String generalAseguradoLongitudTelefonia, final String generalAseguradoLatitudRadio, final String generalAseguradoLongitudRadio,
                            final String generalCorreoAsegurado) {
        super();
        this.catalogoCodigoDeCausa = catalogoCodigoDeCausa;
        this.estado = estado;
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
        this.conductorEdad = conductorEdad;
        this.conductorSexo = conductorSexo;
        this.ubicacionDireccion = ubicacionDireccion;
        this.ubicacionCarretera = ubicacionCarretera;
        this.ubicacionNacional = ubicacionNacional;
        this.ubicacionCodigoPostal = ubicacionCodigoPostal;
        this.ubicacionEntidad = ubicacionEntidad;
        this.ubicacionMunicipio = ubicacionMunicipio;
        this.ubicacionColoniaCodigo = ubicacionColoniaCodigo;
        this.ubicacionColoniaDesc = ubicacionColoniaDesc;
        this.vehiculoArmadoraClave = vehiculoArmadoraClave;
        this.vehiculoArmadoraNombre = vehiculoArmadoraNombre;
        this.vehiculoMotor = vehiculoMotor;
        this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
        this.ajusteAjustadorNombre = ajusteAjustadorNombre;
        this.ajusteAjustadorOficina = ajusteAjustadorOficina;
        this.ajusteAveriguacion = ajusteAveriguacion;
        this.ajusteDeducible = ajusteDeducible;
        this.ajusteMinisterioPublioc = ajusteMinisterioPublioc;
        this.ajustePfp = ajustePfp;
        this.ajusteRecuperoTipo = ajusteRecuperoTipo;
        this.ajusteRecuperoNotas = ajusteRecuperoNotas;
        this.consultadoWs = consultadoWs;
        this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
        this.generalMonedaClave = generalMonedaClave;
        this.generalMonedaNombre = generalMonedaNombre;
        this.ubicacionReferencia = ubicacionReferencia;
        this.token = token;
        this.generalAseguradoCorreo=generalCorreoAsegurado;
        this.generalAseguradoLatitudTelefonia = generalAseguradoLatitudTelefonia;
        this.generalAseguradoLongitudTelefonia = generalAseguradoLongitudTelefonia;
        this.generalAseguradoLatitudRadio = generalAseguradoLatitudRadio;
        this.generalAseguradoLongitudRadio = generalAseguradoLongitudRadio;
    }

	public String getCatalogoCodigoDeCausa() {
		return catalogoCodigoDeCausa;
	}

	public void setCatalogoCodigoDeCausa(String catalogoCodigoDeCausa) {
		this.catalogoCodigoDeCausa = catalogoCodigoDeCausa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public void setGeneralAseguradoTelefonoEncuesta(String generalAseguradoTelefonoEncuesta) {
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

	public String getVehiculoArmadoraClave() {
		return vehiculoArmadoraClave;
	}

	public void setVehiculoArmadoraClave(String vehiculoArmadoraClave) {
		this.vehiculoArmadoraClave = vehiculoArmadoraClave;
	}

	public String getVehiculoArmadoraNombre() {
		return vehiculoArmadoraNombre;
	}

	public void setVehiculoArmadoraNombre(String vehiculoArmadoraNombre) {
		this.vehiculoArmadoraNombre = vehiculoArmadoraNombre;
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

	public String getAjusteAveriguacion() {
		return ajusteAveriguacion;
	}

	public void setAjusteAveriguacion(String ajusteAveriguacion) {
		this.ajusteAveriguacion = ajusteAveriguacion;
	}

	public String getAjusteDeducible() {
		return ajusteDeducible;
	}

	public void setAjusteDeducible(String ajusteDeducible) {
		this.ajusteDeducible = ajusteDeducible;
	}

	public String getAjusteMinisterioPublioc() {
		return ajusteMinisterioPublioc;
	}

	public void setAjusteMinisterioPublioc(String ajusteMinisterioPublioc) {
		this.ajusteMinisterioPublioc = ajusteMinisterioPublioc;
	}

	public String getAjustePfp() {
		return ajustePfp;
	}

	public void setAjustePfp(String ajustePfp) {
		this.ajustePfp = ajustePfp;
	}

	public String getAjusteRecuperoTipo() {
		return ajusteRecuperoTipo;
	}

	public void setAjusteRecuperoTipo(String ajusteRecuperoTipo) {
		this.ajusteRecuperoTipo = ajusteRecuperoTipo;
	}

	public String getAjusteRecuperoNotas() {
		return ajusteRecuperoNotas;
	}

	public void setAjusteRecuperoNotas(String ajusteRecuperoNotas) {
		this.ajusteRecuperoNotas = ajusteRecuperoNotas;
	}

	public Boolean getConsultadoWs() {
		return consultadoWs;
	}

	public void setConsultadoWs(Boolean consultadoWs) {
		this.consultadoWs = consultadoWs;
	}

	public String getGeneralFechaRegistroSiniestro() {
		return generalFechaRegistroSiniestro;
	}

	public void setGeneralFechaRegistroSiniestro(String generalFechaRegistroSiniestro) {
		this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
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

	public String getGeneralAseguradoLatitudTelefonia() {
		return generalAseguradoLatitudTelefonia;
	}

	public void setGeneralAseguradoLatitudTelefonia(String generalAseguradoLatitudTelefonia) {
		this.generalAseguradoLatitudTelefonia = generalAseguradoLatitudTelefonia;
	}

	public String getGeneralAseguradoLongitudTelefonia() {
		return generalAseguradoLongitudTelefonia;
	}

	public void setGeneralAseguradoLongitudTelefonia(String generalAseguradoLongitudTelefonia) {
		this.generalAseguradoLongitudTelefonia = generalAseguradoLongitudTelefonia;
	}

	public String getGeneralAseguradoLatitudRadio() {
		return generalAseguradoLatitudRadio;
	}

	public void setGeneralAseguradoLatitudRadio(String generalAseguradoLatitudRadio) {
		this.generalAseguradoLatitudRadio = generalAseguradoLatitudRadio;
	}

	public String getGeneralAseguradoLongitudRadio() {
		return generalAseguradoLongitudRadio;
	}

	public void setGeneralAseguradoLongitudRadio(String generalAseguradoLongitudRadio) {
		this.generalAseguradoLongitudRadio = generalAseguradoLongitudRadio;
	}

	public ArrayList<GETMovilReporteSiseTaller> getTalleres() {
		return talleres;
	}

	public void setTalleres(ArrayList<GETMovilReporteSiseTaller> talleres) {
		this.talleres = talleres;
	}

	public ArrayList<GETMovilReporteSiseTercero> getTerceros() {
		return terceros;
	}

	public void setTerceros(ArrayList<GETMovilReporteSiseTercero> terceros) {
		this.terceros = terceros;
	}

	public ArrayList<GETMovilReporteSiseGrua> getGruas() {
		return gruas;
	}

	public void setGruas(ArrayList<GETMovilReporteSiseGrua> gruas) {
		this.gruas = gruas;
	}

    
}
