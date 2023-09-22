package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoNuevosVehiculos.class)
public abstract class AbstractFormatoNuevosVehiculos_ { 

	


	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvPlacas;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> id;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvAsegurado;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvClaveAjustador;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvDerivadaAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvDaniosPre;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvEmail;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Date> nvFecha;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Date> nvFechaInspeccion;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvFotoMotor;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvFotoSerie;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Timestamp> nvHora;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvKilometrosAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvModeloAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvMotorAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvNombreAjustador;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvNombreCliente;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvNumInciso;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvNumPoliza;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvNumReporte;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvNumSerieAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvObservacionesAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvOficna;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvProcedenciaAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvPuertasAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvSolicitante;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvTelSolicitante;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvTipoAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvTipoEmpleado;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> nvTotalFotos;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvTransmisionAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvUbicacion;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nvUnidadAuto;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> ftpRespuesta;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> enviadoFtp;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> mensajeEmail;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, Integer> enviadoEmail;

	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos,  Integer> proceso;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos,  Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos,  Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<AbstractFormatoNuevosVehiculos, String> nodoEnvio;
	
	
}