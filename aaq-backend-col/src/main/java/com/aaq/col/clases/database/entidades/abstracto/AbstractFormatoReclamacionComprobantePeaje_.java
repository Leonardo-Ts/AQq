package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoReclamacionComprobantePeaje.class)
public abstract class AbstractFormatoReclamacionComprobantePeaje_ { 
	
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, Integer> id;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, Integer> enviadoEmail;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, Integer> proceso;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoReclamacionComprobantePeaje,  String> ftp_respuesta; 



}