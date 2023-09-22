package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoAsistenciaVial.class)
public abstract class AbstractFormatoAsistenciaVial_ { 

	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avAsegurado;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avNumInciso;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> ftpRespuesta;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avNomAsegurado;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Date> avFecha;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avNumPoliza;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avClaveAjustador;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avEmail;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> avPregunta6;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avPregunta5;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> avPregunta4;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> avPregunta3;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> avPregunta2;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> avPregunta1;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avNumReporte;

	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> id;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> avComentarios;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> avPregunta7;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> enviadoEmail;
	
	public static volatile SingularAttribute<FormatoAsistenciaVial, Integer> proceso;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoAsistenciaVial, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoAsistenciaVial, String> nodoEnvio;


}