package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoEncuestaServicio;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoEncuestaServicio.class)
public abstract class AbstractFormatoEncuestaServicio_ { 

	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esTelConductor;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> id;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esNumSiniestro;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esNumReporte;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esNomAsegurado;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esLugar;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esClaveAjustador;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta8;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta9;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta6;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esNomConductor;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta7;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta4;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta5;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta2;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta3;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta1;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esFtpRespuesta;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esNumInciso;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esNumPoliza;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esAsegurado;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Date> esFecha;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> esPregunta10;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esObservaciones;

	public static volatile SingularAttribute<FormatoEncuestaServicio, String> esEmailConductor;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> enviadoEmail;
	
	public static volatile SingularAttribute<FormatoEncuestaServicio, Integer> proceso;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoEncuestaServicio, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoEncuestaServicio, String> nodoEnvio;

}