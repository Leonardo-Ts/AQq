package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoInventarioUnicoPesado.class)
public abstract class AbstractFormatoInventarioUnicoPesado_ { 

	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, String> aaNomConductor;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, Integer> id;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, String> mensajeEmail;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, Integer> enviadoEmail;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, Integer> proceso;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado, Integer> enviadoFtp;
	public static volatile SingularAttribute<FormatoInventarioUnicoPesado,  String> ftp_respuesta; 



}