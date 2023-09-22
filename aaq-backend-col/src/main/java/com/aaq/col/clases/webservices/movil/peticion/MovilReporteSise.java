package com.aaq.col.clases.webservices.movil.peticion;


import java.util.ArrayList;
import java.util.Date;

public class MovilReporteSise {
    private String catalogoCodigoDeCausa;
    private String estado;
    private Date fecha;
    private String generalNumeroReporte;
    private String generalNumeroPoliza;
//    private String generalPolizaEstatus;
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
    private String polizaDeducibleNocturno;
    private String servicioAmbulancia;
    private String tipoUnidadAsegurado;
    private ArrayList<MovilReporteSiseTaller> talleres = new ArrayList<>();
    private ArrayList<MovilReporteSiseTercero> terceros = new ArrayList<>();
    private ArrayList<MovilReporteSiseGrua> gruas = new ArrayList<>();

    /**
     *
     */
    public MovilReporteSise() {
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
     * @param polizaDeducibleNocturno
     * @param servicioAmbulancia
     */
    public MovilReporteSise(final String catalogoCodigoDeCausa, final String estado, final Date fecha,
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
                            final String generalCorreoAsegurado, final String polizaDeducibleNocturno,
                            final String tipoUnidadAsegurado,
                            final String servicioAmbulancia ) {
//                            , final String generalPolizaEstatus) {
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
        this.ubicacionEntidad = ubicacionEntidad + " / " + ubicacionMunicipio;
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
        this.polizaDeducibleNocturno = polizaDeducibleNocturno;
        this.tipoUnidadAsegurado = tipoUnidadAsegurado;
        this.servicioAmbulancia = servicioAmbulancia;
//        this.generalPolizaEstatus = generalPolizaEstatus;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @return the catalogoCodigoDeCausa
     */
    public String getCatalogoCodigoDeCausa() {
        return this.catalogoCodigoDeCausa;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @param catalogoCodigoDeCausa the catalogoCodigoDeCausa to set
     */
    public void setCatalogoCodigoDeCausa(final String catalogoCodigoDeCausa) {
        this.catalogoCodigoDeCausa = catalogoCodigoDeCausa;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @return the estado
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @param estado es el identificador o el objeto del estado o entidad federativa the estado to set
     */
    public void setEstado(final String estado) {
        this.estado = estado;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @return the fecha
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @param fecha the fecha to set
     */
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    /**
     *  Feb 25, 2013 10:49:57 AM
     *
     * @return the generalNumeroReporte
     */
    public String getGeneralNumeroReporte() {
        return this.generalNumeroReporte;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalNumeroReporte the generalNumeroReporte to set
     */
    public void setGeneralNumeroReporte(final String generalNumeroReporte) {
        this.generalNumeroReporte = generalNumeroReporte;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalNumeroPoliza
     */
    public String getGeneralNumeroPoliza() {
        return this.generalNumeroPoliza;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalNumeroPoliza the generalNumeroPoliza to set
     */
    public void setGeneralNumeroPoliza(final String generalNumeroPoliza) {
        this.generalNumeroPoliza = generalNumeroPoliza;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalEndoso
     */
    public String getGeneralEndoso() {
        return this.generalEndoso;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalEndoso the generalEndoso to set
     */
    public void setGeneralEndoso(final String generalEndoso) {
        this.generalEndoso = generalEndoso;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalInciso
     */
    public String getGeneralInciso() {
        return this.generalInciso;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalInciso the generalInciso to set
     */
    public void setGeneralInciso(final String generalInciso) {
        this.generalInciso = generalInciso;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalNombreAsegurado
     */
    public String getGeneralNombreAsegurado() {
        return this.generalNombreAsegurado;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalNombreAsegurado the generalNombreAsegurado to set
     */
    public void setGeneralNombreAsegurado(final String generalNombreAsegurado) {
        this.generalNombreAsegurado = generalNombreAsegurado;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the conductorNombre
     */
    public String getConductorNombre() {
        return this.conductorNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param conductorNombre the conductorNombre to set
     */
    public void setConductorNombre(final String conductorNombre) {
        this.conductorNombre = conductorNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoSerie
     */
    public String getVehiculoSerie() {
        return this.vehiculoSerie;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoSerie the vehiculoSerie to set
     */
    public void setVehiculoSerie(final String vehiculoSerie) {
        this.vehiculoSerie = vehiculoSerie;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoPlacas
     */
    public String getVehiculoPlacas() {
        return this.vehiculoPlacas;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoPlacas the vehiculoPlacas to set
     */
    public void setVehiculoPlacas(final String vehiculoPlacas) {
        this.vehiculoPlacas = vehiculoPlacas;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteFechaPasadoAjustador
     */
    public String getAjusteFechaPasadoAjustador() {
        return this.ajusteFechaPasadoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteFechaPasadoAjustador the ajusteFechaPasadoAjustador to set
     */
    public void setAjusteFechaPasadoAjustador(final String ajusteFechaPasadoAjustador) {
        this.ajusteFechaPasadoAjustador = ajusteFechaPasadoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteFechaArriboAjustador
     */
    public String getAjusteFechaArriboAjustador() {
        return this.ajusteFechaArriboAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteFechaArriboAjustador the ajusteFechaArriboAjustador to set
     */
    public void setAjusteFechaArriboAjustador(final String ajusteFechaArriboAjustador) {
        this.ajusteFechaArriboAjustador = ajusteFechaArriboAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteFechaTerminoAjustador
     */
    public String getAjusteFechaTerminoAjustador() {
        return this.ajusteFechaTerminoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteFechaTerminoAjustador the ajusteFechaTerminoAjustador to set
     */
    public void setAjusteFechaTerminoAjustador(final String ajusteFechaTerminoAjustador) {
        this.ajusteFechaTerminoAjustador = ajusteFechaTerminoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalComoOcurrio
     */
    public String getGeneralComoOcurrio() {
        return this.generalComoOcurrio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalComoOcurrio the generalComoOcurrio to set
     */
    public void setGeneralComoOcurrio(final String generalComoOcurrio) {
        this.generalComoOcurrio = generalComoOcurrio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteHoraPasadoAjustador
     */
    public String getAjusteHoraPasadoAjustador() {
        return this.ajusteHoraPasadoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteHoraPasadoAjustador the ajusteHoraPasadoAjustador to set
     */
    public void setAjusteHoraPasadoAjustador(final String ajusteHoraPasadoAjustador) {
        this.ajusteHoraPasadoAjustador = ajusteHoraPasadoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteHoraArriboAjustador
     */
    public String getAjusteHoraArriboAjustador() {
        return this.ajusteHoraArriboAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteHoraArriboAjustador the ajusteHoraArriboAjustador to set
     */
    public void setAjusteHoraArriboAjustador(final String ajusteHoraArriboAjustador) {
        this.ajusteHoraArriboAjustador = ajusteHoraArriboAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteHoraTerminoAjustador
     */
    public String getAjusteHoraTerminoAjustador() {
        return this.ajusteHoraTerminoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteHoraTerminoAjustador the ajusteHoraTerminoAjustador to set
     */
    public void setAjusteHoraTerminoAjustador(final String ajusteHoraTerminoAjustador) {
        this.ajusteHoraTerminoAjustador = ajusteHoraTerminoAjustador;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteCodigoCausa
     */
    public String getAjusteCodigoCausa() {
        return this.ajusteCodigoCausa;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteCodigoCausa the ajusteCodigoCausa to set
     */
    public void setAjusteCodigoCausa(final String ajusteCodigoCausa) {
        this.ajusteCodigoCausa = ajusteCodigoCausa;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the conductorTelefonoContacto
     */
    public String getConductorTelefonoContacto() {
        return this.conductorTelefonoContacto;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param conductorTelefonoContacto the conductorTelefonoContacto to set
     */
    public void setConductorTelefonoContacto(final String conductorTelefonoContacto) {
        this.conductorTelefonoContacto = conductorTelefonoContacto;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalNumeroSiniestro
     */
    public String getGeneralNumeroSiniestro() {
        return this.generalNumeroSiniestro;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalNumeroSiniestro the generalNumeroSiniestro to set
     */
    public void setGeneralNumeroSiniestro(final String generalNumeroSiniestro) {
        this.generalNumeroSiniestro = generalNumeroSiniestro;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoMarca
     */
    public String getVehiculoMarca() {
        return this.vehiculoMarca;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoMarca the vehiculoMarca to set
     */
    public void setVehiculoMarca(final String vehiculoMarca) {
        this.vehiculoMarca = vehiculoMarca;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoTipo
     */
    public String getVehiculoTipo() {
        return this.vehiculoTipo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoTipo the vehiculoTipo to set
     */
    public void setVehiculoTipo(final String vehiculoTipo) {
        this.vehiculoTipo = vehiculoTipo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoModelo
     */
    public String getVehiculoModelo() {
        return this.vehiculoModelo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoModelo the vehiculoModelo to set
     */
    public void setVehiculoModelo(final String vehiculoModelo) {
        this.vehiculoModelo = vehiculoModelo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoColor
     */
    public String getVehiculoColor() {
        return this.vehiculoColor;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoColor the vehiculoColor to set
     */
    public void setVehiculoColor(final String vehiculoColor) {
        this.vehiculoColor = vehiculoColor;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalUsuario
     */
    public String getGeneralUsuario() {
        return this.generalUsuario;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalUsuario the generalUsuario to set
     */
    public void setGeneralUsuario(final String generalUsuario) {
        this.generalUsuario = generalUsuario;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the esReasignadoNumero
     */
    public Integer getEsReasignadoNumero() {
        return this.esReasignadoNumero;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param esReasignadoNumero the esReasignadoNumero to set
     */
    public void setEsReasignadoNumero(final Integer esReasignadoNumero) {
        this.esReasignadoNumero = esReasignadoNumero;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the esSegundaAtencion
     */
    public Boolean getEsSegundaAtencion() {
        return this.esSegundaAtencion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param esSegundaAtencion the esSegundaAtencion to set
     */
    public void setEsSegundaAtencion(final Boolean esSegundaAtencion) {
        this.esSegundaAtencion = esSegundaAtencion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the esReasignado
     */
    public Boolean getEsReasignado() {
        return this.esReasignado;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param esReasignado the esReasignado to set
     */
    public void setEsReasignado(final Boolean esReasignado) {
        this.esReasignado = esReasignado;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the coordLatitudInicio
     */
    public String getCoordLatitudInicio() {
        return this.coordLatitudInicio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param coordLatitudInicio the coordLatitudInicio to set
     */
    public void setCoordLatitudInicio(final String coordLatitudInicio) {
        this.coordLatitudInicio = coordLatitudInicio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the coordLongitudInicio
     */
    public String getCoordLongitudInicio() {
        return this.coordLongitudInicio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param coordLongitudInicio the coordLongitudInicio to set
     */
    public void setCoordLongitudInicio(final String coordLongitudInicio) {
        this.coordLongitudInicio = coordLongitudInicio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the coordLatitudArribo
     */
    public String getCoordLatitudArribo() {
        return this.coordLatitudArribo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param coordLatitudArribo the coordLatitudArribo to set
     */
    public void setCoordLatitudArribo(final String coordLatitudArribo) {
        this.coordLatitudArribo = coordLatitudArribo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the coordLongitudArribo
     */
    public String getCoordLongitudArribo() {
        return this.coordLongitudArribo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param coordLongitudArribo the coordLongitudArribo to set
     */
    public void setCoordLongitudArribo(final String coordLongitudArribo) {
        this.coordLongitudArribo = coordLongitudArribo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the coordLatitudTermino
     */
    public String getCoordLatitudTermino() {
        return this.coordLatitudTermino;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param coordLatitudTermino the coordLatitudTermino to set
     */
    public void setCoordLatitudTermino(final String coordLatitudTermino) {
        this.coordLatitudTermino = coordLatitudTermino;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the coordLongitudTermino
     */
    public String getCoordLongitudTermino() {
        return this.coordLongitudTermino;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param coordLongitudTermino the coordLongitudTermino to set
     */
    public void setCoordLongitudTermino(final String coordLongitudTermino) {
        this.coordLongitudTermino = coordLongitudTermino;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalOficinaReporte
     */
    public String getGeneralOficinaReporte() {
        return this.generalOficinaReporte;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalOficinaReporte the generalOficinaReporte to set
     */
    public void setGeneralOficinaReporte(final String generalOficinaReporte) {
        this.generalOficinaReporte = generalOficinaReporte;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalFechaOcurrido
     */
    public String getGeneralFechaOcurrido() {
        return this.generalFechaOcurrido;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalFechaOcurrido the generalFechaOcurrido to set
     */
    public void setGeneralFechaOcurrido(final String generalFechaOcurrido) {
        this.generalFechaOcurrido = generalFechaOcurrido;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalHoraOcurrido
     */
    public String getGeneralHoraOcurrido() {
        return this.generalHoraOcurrido;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalHoraOcurrido the generalHoraOcurrido to set
     */
    public void setGeneralHoraOcurrido(final String generalHoraOcurrido) {
        this.generalHoraOcurrido = generalHoraOcurrido;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalAseguradoCodigo
     */
    public String getGeneralAseguradoCodigo() {
        return this.generalAseguradoCodigo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalAseguradoCodigo the generalAseguradoCodigo to set
     */
    public void setGeneralAseguradoCodigo(final String generalAseguradoCodigo) {
        this.generalAseguradoCodigo = generalAseguradoCodigo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalAseguradoTelefonoEncuesta
     */
    public String getGeneralAseguradoTelefonoEncuesta() {
        return this.generalAseguradoTelefonoEncuesta;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalAseguradoTelefonoEncuesta the generalAseguradoTelefonoEncuesta to set
     */
    public void setGeneralAseguradoTelefonoEncuesta(final String generalAseguradoTelefonoEncuesta) {
        this.generalAseguradoTelefonoEncuesta = generalAseguradoTelefonoEncuesta;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalAseguradoTelefono
     */
    public String getGeneralAseguradoTelefono() {
        return this.generalAseguradoTelefono;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalAseguradoTelefono the generalAseguradoTelefono to set
     */
    public void setGeneralAseguradoTelefono(final String generalAseguradoTelefono) {
        this.generalAseguradoTelefono = generalAseguradoTelefono;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalReporto
     */
    public String getGeneralReporto() {
        return this.generalReporto;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalReporto the generalReporto to set
     */
    public void setGeneralReporto(final String generalReporto) {
        this.generalReporto = generalReporto;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalObservacion
     */
    public String getGeneralObservacion() {
        return this.generalObservacion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalObservacion the generalObservacion to set
     */
    public void setGeneralObservacion(final String generalObservacion) {
        this.generalObservacion = generalObservacion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalTipoReporte
     */
    public String getGeneralTipoReporte() {
        return this.generalTipoReporte;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalTipoReporte the generalTipoReporte to set
     */
    public void setGeneralTipoReporte(final String generalTipoReporte) {
        this.generalTipoReporte = generalTipoReporte;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the conductorEdad
     */
    public String getConductorEdad() {
        return this.conductorEdad;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param conductorEdad the conductorEdad to set
     */
    public void setConductorEdad(final String conductorEdad) {
        this.conductorEdad = conductorEdad;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the conductorSexo
     */
    public String getConductorSexo() {
        return this.conductorSexo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param conductorSexo the conductorSexo to set
     */
    public void setConductorSexo(final String conductorSexo) {
        this.conductorSexo = conductorSexo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionDireccion
     */
    public String getUbicacionDireccion() {
        return this.ubicacionDireccion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionDireccion the ubicacionDireccion to set
     */
    public void setUbicacionDireccion(final String ubicacionDireccion) {
        this.ubicacionDireccion = ubicacionDireccion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionCarretera
     */
    public String getUbicacionCarretera() {
        return this.ubicacionCarretera;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionCarretera the ubicacionCarretera to set
     */
    public void setUbicacionCarretera(final String ubicacionCarretera) {
        this.ubicacionCarretera = ubicacionCarretera;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionNacional
     */
    public String getUbicacionNacional() {
        return this.ubicacionNacional;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionNacional the ubicacionNacional to set
     */
    public void setUbicacionNacional(final String ubicacionNacional) {
        this.ubicacionNacional = ubicacionNacional;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionCodigoPostal
     */
    public String getUbicacionCodigoPostal() {
        return this.ubicacionCodigoPostal;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionCodigoPostal the ubicacionCodigoPostal to set
     */
    public void setUbicacionCodigoPostal(final String ubicacionCodigoPostal) {
        this.ubicacionCodigoPostal = ubicacionCodigoPostal;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionEntidad
     */
    public String getUbicacionEntidad() {
        return this.ubicacionEntidad;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionEntidad the ubicacionEntidad to set
     */
    public void setUbicacionEntidad(final String ubicacionEntidad) {
        this.ubicacionEntidad = ubicacionEntidad;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionMunicipio
     */
    public String getUbicacionMunicipio() {
        return this.ubicacionMunicipio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionMunicipio the ubicacionMunicipio to set
     */
    public void setUbicacionMunicipio(final String ubicacionMunicipio) {
        this.ubicacionMunicipio = ubicacionMunicipio;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionColoniaCodigo
     */
    public String getUbicacionColoniaCodigo() {
        return this.ubicacionColoniaCodigo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionColoniaCodigo the ubicacionColoniaCodigo to set
     */
    public void setUbicacionColoniaCodigo(final String ubicacionColoniaCodigo) {
        this.ubicacionColoniaCodigo = ubicacionColoniaCodigo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ubicacionColoniaDesc
     */
    public String getUbicacionColoniaDesc() {
        return this.ubicacionColoniaDesc;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ubicacionColoniaDesc the ubicacionColoniaDesc to set
     */
    public void setUbicacionColoniaDesc(final String ubicacionColoniaDesc) {
        this.ubicacionColoniaDesc = ubicacionColoniaDesc;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoArmadoraClave
     */
    public String getVehiculoArmadoraClave() {
        return this.vehiculoArmadoraClave;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoArmadoraClave the vehiculoArmadoraClave to set
     */
    public void setVehiculoArmadoraClave(final String vehiculoArmadoraClave) {
        this.vehiculoArmadoraClave = vehiculoArmadoraClave;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoArmadoraNombre
     */
    public String getVehiculoArmadoraNombre() {
        return this.vehiculoArmadoraNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoArmadoraNombre the vehiculoArmadoraNombre to set
     */
    public void setVehiculoArmadoraNombre(final String vehiculoArmadoraNombre) {
        this.vehiculoArmadoraNombre = vehiculoArmadoraNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the vehiculoMotor
     */
    public String getVehiculoMotor() {
        return this.vehiculoMotor;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param vehiculoMotor the vehiculoMotor to set
     */
    public void setVehiculoMotor(final String vehiculoMotor) {
        this.vehiculoMotor = vehiculoMotor;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteAjustadorCodigo
     */
    public String getAjusteAjustadorCodigo() {
        return this.ajusteAjustadorCodigo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteAjustadorCodigo the ajusteAjustadorCodigo to set
     */
    public void setAjusteAjustadorCodigo(final String ajusteAjustadorCodigo) {
        this.ajusteAjustadorCodigo = ajusteAjustadorCodigo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteAjustadorNombre
     */
    public String getAjusteAjustadorNombre() {
        return this.ajusteAjustadorNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteAjustadorNombre the ajusteAjustadorNombre to set
     */
    public void setAjusteAjustadorNombre(final String ajusteAjustadorNombre) {
        this.ajusteAjustadorNombre = ajusteAjustadorNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteAjustadorOficina
     */
    public String getAjusteAjustadorOficina() {
        return this.ajusteAjustadorOficina;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteAjustadorOficina the ajusteAjustadorOficina to set
     */
    public void setAjusteAjustadorOficina(final String ajusteAjustadorOficina) {
        this.ajusteAjustadorOficina = ajusteAjustadorOficina;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteAveriguacion
     */
    public String getAjusteAveriguacion() {
        return this.ajusteAveriguacion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteAveriguacion the ajusteAveriguacion to set
     */
    public void setAjusteAveriguacion(final String ajusteAveriguacion) {
        this.ajusteAveriguacion = ajusteAveriguacion;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteDeducible
     */
    public String getAjusteDeducible() {
        return this.ajusteDeducible;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteDeducible the ajusteDeducible to set
     */
    public void setAjusteDeducible(final String ajusteDeducible) {
        this.ajusteDeducible = ajusteDeducible;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteMinisterioPublioc
     */
    public String getAjusteMinisterioPublioc() {
        return this.ajusteMinisterioPublioc;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteMinisterioPublioc the ajusteMinisterioPublioc to set
     */
    public void setAjusteMinisterioPublioc(final String ajusteMinisterioPublioc) {
        this.ajusteMinisterioPublioc = ajusteMinisterioPublioc;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajustePfp
     */
    public String getAjustePfp() {
        return this.ajustePfp;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajustePfp the ajustePfp to set
     */
    public void setAjustePfp(final String ajustePfp) {
        this.ajustePfp = ajustePfp;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteRecuperoTipo
     */
    public String getAjusteRecuperoTipo() {
        return this.ajusteRecuperoTipo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteRecuperoTipo the ajusteRecuperoTipo to set
     */
    public void setAjusteRecuperoTipo(final String ajusteRecuperoTipo) {
        this.ajusteRecuperoTipo = ajusteRecuperoTipo;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the ajusteRecuperoNotas
     */
    public String getAjusteRecuperoNotas() {
        return this.ajusteRecuperoNotas;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param ajusteRecuperoNotas the ajusteRecuperoNotas to set
     */
    public void setAjusteRecuperoNotas(final String ajusteRecuperoNotas) {
        this.ajusteRecuperoNotas = ajusteRecuperoNotas;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the consultadoWs
     */
    public Boolean getConsultadoWs() {
        return this.consultadoWs;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param consultadoWs the consultadoWs to set
     */
    public void setConsultadoWs(final Boolean consultadoWs) {
        this.consultadoWs = consultadoWs;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalFechaRegistroSiniestro
     */
    public String getGeneralFechaRegistroSiniestro() {
        return this.generalFechaRegistroSiniestro;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalFechaRegistroSiniestro the generalFechaRegistroSiniestro to set
     */
    public void setGeneralFechaRegistroSiniestro(final String generalFechaRegistroSiniestro) {
        this.generalFechaRegistroSiniestro = generalFechaRegistroSiniestro;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalMonedaClave
     */
    public String getGeneralMonedaClave() {
        return this.generalMonedaClave;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalMonedaClave the generalMonedaClave to set
     */
    public void setGeneralMonedaClave(final String generalMonedaClave) {
        this.generalMonedaClave = generalMonedaClave;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @return the generalMonedaNombre
     */
    public String getGeneralMonedaNombre() {
        return this.generalMonedaNombre;
    }

    /**
     *  Feb 25, 2013 10:49:58 AM
     *
     * @param generalMonedaNombre the generalMonedaNombre to set
     */
    public void setGeneralMonedaNombre(final String generalMonedaNombre) {
        this.generalMonedaNombre = generalMonedaNombre;
    }

    /**
     *  Dec 9, 2013 2:56:34 PM
     *
     * @return the talleres
     */
    public ArrayList<MovilReporteSiseTaller> getTalleres() {
        return this.talleres;
    }

    /**
     *  Dec 9, 2013 2:56:34 PM
     *
     * @param talleres the talleres to set
     */
    public void setTalleres(final ArrayList<MovilReporteSiseTaller> talleres) {
        this.talleres = talleres;
    }

    /**
     *  Dec 9, 2013 2:56:34 PM
     *
     * @return the terceros
     */
    public ArrayList<MovilReporteSiseTercero> getTerceros() {
        return this.terceros;
    }

    /**
     *  Dec 9, 2013 2:56:34 PM
     *
     * @param terceros the terceros to set
     */
    public void setTerceros(final ArrayList<MovilReporteSiseTercero> terceros) {
        this.terceros = terceros;
    }

    /**
     *  Dec 11, 2013 7:41:54 PM
     *
     * @return the gruas
     */
    public ArrayList<MovilReporteSiseGrua> getGruas() {
        return this.gruas;
    }

    /**
     *  Dec 11, 2013 7:41:54 PM
     *
     * @param gruas the gruas to set
     */
    public void setGruas(final ArrayList<MovilReporteSiseGrua> gruas) {
        this.gruas = gruas;
    }

    /**
     * Mar 11, 2014 1:49:03 PM
     *
     * @return the ubicacionReferencia
     */
    public String getUbicacionReferencia() {
        return this.ubicacionReferencia;
    }

    /**
     * Mar 11, 2014 1:49:03 PM
     *
     * @param ubicacionReferencia the ubicacionReferencia to set
     */
    public void setUbicacionReferencia(final String ubicacionReferencia) {
        this.ubicacionReferencia = ubicacionReferencia;
    }

    /**
     * Jul 21, 2014 1:24:37 PM mfernandez
     *
     * @return the token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Jul 21, 2014 1:24:37 PM mfernandez
     *
     * @param token the token to set
     */
    public void setToken(final String token) {
        this.token = token;
    }

	/**
	 * @return the generalAseguradoLatitudTelefonia
	 */
	public String getGeneralAseguradoLatitudTelefonia() {
		return this.generalAseguradoLatitudTelefonia;
	}

	/**
	 * @param generalAseguradoLatitudTelefonia the generalAseguradoLatitudTelefonia to set
	 */
	public void setGeneralAseguradoLatitudTelefonia(
			final String generalAseguradoLatitudTelefonia) {
		this.generalAseguradoLatitudTelefonia = generalAseguradoLatitudTelefonia;
	}

	/**
	 * @return the generalAseguradoLongitudTelefonia
	 */
	public String getGeneralAseguradoLongitudTelefonia() {
		return this.generalAseguradoLongitudTelefonia;
	}

	/**
	 * @param generalAseguradoLongitudTelefonia the generalAseguradoLongitudTelefonia to set
	 */
	public void setGeneralAseguradoLongitudTelefonia(
			final String generalAseguradoLongitudTelefonia) {
		this.generalAseguradoLongitudTelefonia = generalAseguradoLongitudTelefonia;
	}

	/**
	 * @return the generalAseguradoLatitudRadio
	 */
	public String getGeneralAseguradoLatitudRadio() {
		return this.generalAseguradoLatitudRadio;
	}

	/**
	 * @param generalAseguradoLatitudRadio the generalAseguradoLatitudRadio to set
	 */
	public void setGeneralAseguradoLatitudRadio(final String generalAseguradoLatitudRadio) {
		this.generalAseguradoLatitudRadio = generalAseguradoLatitudRadio;
	}

	/**
	 * @return the generalAseguradoLongitudRadio
	 */
	public String getGeneralAseguradoLongitudRadio() {
		return this.generalAseguradoLongitudRadio;
	}

	/**
	 * @param generalAseguradoLongitudRadio the generalAseguradoLongitudRadio to set
	 */
	public void setGeneralAseguradoLongitudRadio(
			final String generalAseguradoLongitudRadio) {
		this.generalAseguradoLongitudRadio = generalAseguradoLongitudRadio;
	}

	/**
	 * @return the generalAseguradoCorreo
	 */
	public String getGeneralAseguradoCorreo() {
		return this.generalAseguradoCorreo;
	}

	/**
	 * @param generalAseguradoCorreo the generalAseguradoCorreo to set
	 */
	public void setGeneralAseguradoCorreo(final String generalAseguradoCorreo) {
		this.generalAseguradoCorreo = generalAseguradoCorreo;
	}

	/**
	 * @author Arturo de la Cruz
	 * @return the polizaDeducibleNocturno
	 */
	public String getPolizaDeducibleNocturno() {
		return polizaDeducibleNocturno;
	}

	/**
	 * @author Arturo de la Cruz
	 * @param polizaDeducibleNocturno the polizaDeducibleNocturno to set
	 */
	public void setPolizaDeducibleNocturno(String polizaDeducibleNocturno) {
		this.polizaDeducibleNocturno = polizaDeducibleNocturno;
	}
	
	/**
	 * @return the servicioAmbulancia
	 */
	public String getServicioAmbulancia() {
		return servicioAmbulancia;
	}

	/**
	 * @param servicioAmbulancia the servicioAmbulancia to set
	 */
	public void setServicioAmbulancia(String servicioAmbulancia) {
		this.servicioAmbulancia = servicioAmbulancia;
	}

	/**
	 * @return the tipoUnidadAsegurado
	 */
	public String getTipoUnidadAsegurado() {
		return tipoUnidadAsegurado;
	}

	/**
	 * @param tipoUnidadAsegurado the tipoUnidadAsegurado to set
	 */
	public void setTipoUnidadAsegurado(String tipoUnidadAsegurado) {
		this.tipoUnidadAsegurado = tipoUnidadAsegurado;
	}

	/**
	 * @return the generalPolizaEstatus
	 */
//	public String getGeneralPolizaEstatus() {
//		return generalPolizaEstatus;
//	}

	/**
	 * @param generalPolizaEstatus the generalPolizaEstatus to set
	 */
//	public void setGeneralPolizaEstatus(String generalPolizaEstatus) {
//		this.generalPolizaEstatus = generalPolizaEstatus;
//	}
	
	
	
}
