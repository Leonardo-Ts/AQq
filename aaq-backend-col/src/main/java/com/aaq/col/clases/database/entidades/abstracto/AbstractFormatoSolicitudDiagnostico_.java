package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoSolicitudDiagnostico.class)
public abstract class AbstractFormatoSolicitudDiagnostico_ { 

	
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> id;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdRazonResponsable;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdRazonTelefono;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdRazonDomicilio;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdRazonCobertura;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdMarcaAuto;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdTipoAuto;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdModeloAuto;

	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdKilometrajeAuto;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdNumSerie;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdColorAuto;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdPlacaAuto;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> sdTransmision;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> sdDaniosUnidad;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> sdDescripcionDanios;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> sdDaniosPre;

	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdNomAjustador;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdClaveAjustador;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> enviadoFtp;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> ftpRespuesta;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> enviadoEmail;
	
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> mensajesEmail;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Integer> proceso;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> sdOtro;

	
	
	
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<AbstractFormatoSolicitudDiagnostico, String> nodoEnvio;
	
	
	
	
	

}