package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractReporteMovilSac.class)
public abstract class AbstractReporteMovilSac_ {

	public static volatile SingularAttribute<AbstractReporteMovilSac, Integer> id;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Date> fecha;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalNumeroReporte;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalNumeroReporteSise;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalNumeroPoliza;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalEndoso;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalInciso;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalNombreAsegurado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> conductorNombre;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoSerie;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoPlacas;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteFechaPasadoAjustador;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteFechaArriboAjustador;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteFechaTerminoAjustador;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalComoOcurrio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteHoraPasadoAjustador;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteHoraArriboAjustador;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteHoraTerminoAjustador;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteCodigoCausa;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> conductorTelefonoContacto;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalNumeroSiniestro;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoMarca;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoTipo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoModelo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoColor;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalUsuario;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Integer> esReasignadoNumero;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> esSegundaAtencion;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> esReasignado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> coordLatitudInicio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> coordLongitudInicio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> coordLatitudArribo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> coordLongitudArribo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> coordLatitudTermino;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> coordLongitudTermino;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalOficinaReporte;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalFechaOcurrido;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalHoraOcurrido;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalAseguradoCodigo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalAseguradoTelefonoEncuesta;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalAseguradoTelefono;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalReporto;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalObservacion;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalTipoReporte;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalFechaRegistroSiniestro;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> conductorEdad;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> conductorSexo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionDireccion;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionCarretera;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionNacional;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionCodigoPostal;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionEntidad;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionMunicipio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionColoniaCodigo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionColoniaDesc;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> vehiculoMotor;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteAjustadorCodigo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteAjustadorNombre;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ajusteAjustadorOficina;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalMonedaClave;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalMonedaNombre;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Date> fechaReporteEnvioSms;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Date> fechaReporteLecturaPorWs;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionReferencia;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> token;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> generalCorreoAsegurado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> quienLlegoPrimero;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> tramoCarretero;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> preAveriguacion;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> repuveAveriguacionPreviaFecha;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> repuveEntidadFederativa;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> repuveMunicipio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> repuveNumeroAveriguacion;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> roboLocalizado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> roboLocalizadoEn;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> roboDependencia;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> roboFecha;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> roboTelefono;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> serviciosdiversos_consecutivos;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> proximidad;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> latitudTelefonia;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> longitudTelefonia;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> latitudRadio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> longitudRadio;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> deducibleNocturno;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> codigoResponsabilidad;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> servicioAmbulancia;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> datosArca;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> matriz;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> codigoMatriz;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> distanciaAlArribo;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> servicioAsistenciaVial;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> latitudArriboAsegurado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> longitudArriboAsegurado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, Boolean> arriboCloud;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> tipoUnidadAsegurado;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> claveAgente;
	public static volatile SingularAttribute<AbstractReporteMovilSac, String> ubicacionCorrecta;
	


}