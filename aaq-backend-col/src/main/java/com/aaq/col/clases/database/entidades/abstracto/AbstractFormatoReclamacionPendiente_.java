package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoReclamacionPendiente.class)
public abstract class AbstractFormatoReclamacionPendiente_ { 

	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNumReporte;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> emailDefault;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpAsegurado;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpObservaciones;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpObsEndosoAclara;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> ftpRespuesta;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> rpOtros;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNumReclamacion;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Long> id;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNomAjustador;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> rpCopiaActaMp;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Timestamp> rpFecha;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> rpPolizaVigente;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> rpReciboPago;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNombreConductor;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> rpLicencia;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpClaveAjustador;


	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNomConductor;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> rpDfEndoso;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNumInciso;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> rpNumPoliza;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> enviadoEmail;
	
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Integer> proceso;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoReclamacionPendiente, String> nodoEnvio;


	
}