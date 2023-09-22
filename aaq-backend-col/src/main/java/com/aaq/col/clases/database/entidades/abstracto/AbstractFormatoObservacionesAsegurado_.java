package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoObservacionesAsegurado.class)
public abstract class AbstractFormatoObservacionesAsegurado_ {  

	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> aaNomConductor;	
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> id;	
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> enviadoEmail;	
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> proceso;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> nodoEnvio;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> firmaConductor;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_NUM_REPORTE;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_NUM_SINIESTRO;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_NUM_POLIZA;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_NUM_ASEGURADO;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_NOM_AJUSTADOR;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_OBSERVACIONES;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_NOM_CONDUCTOR;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_TELEFONO;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_CORREO_CONDUCTOR;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_CLAVE_AJUSTADOR;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Date> FOA_FECHA;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, String> FOA_LUGAR;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> CHECK_1;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> CHECK_2;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> CHECK_3;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> CHECK_4;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoObservacionesAsegurado,  String> ftp_respuesta; 



}