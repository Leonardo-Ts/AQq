package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoOrdenServicio.class)
public abstract class AbstractFormatoOrdenServicio_ { 

	public static volatile SingularAttribute<FormatoOrdenServicio, Date> osFechaAtencion;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osSexoConductor;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> ftpRespuesta;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osPoliza;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osTipoAuto;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osNumInciso;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osPlacasAuto;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osNumReporte;
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> osEdadConductor;
	public static volatile SingularAttribute<FormatoOrdenServicio, Timestamp> osHoraArribo;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osNomAjustador;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osTelConductor;
	public static volatile SingularAttribute<FormatoOrdenServicio, Timestamp> osHoraTermino;
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> osTipoServicio;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osEmailConductor;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osLugarServicio;
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> osSurtidoCombustible;
	public static volatile SingularAttribute<FormatoOrdenServicio, Timestamp> osHoraReporte;
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> id;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osNumSiniestro;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osInformeAjustador;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osNomConductor;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osModeloAuto;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osClave;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osNumSerieAuto;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osAsegurado;

	public static volatile SingularAttribute<FormatoOrdenServicio, String> osMarcaAuto;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> osAnioAuto;
	
	public static volatile SingularAttribute<FormatoOrdenServicio, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> enviadoEmail;
	
	public static volatile SingularAttribute<FormatoOrdenServicio, Integer> proceso;
	public static volatile SingularAttribute<FormatoOrdenServicio, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoOrdenServicio, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoOrdenServicio, String> nodoEnvio;
   
}