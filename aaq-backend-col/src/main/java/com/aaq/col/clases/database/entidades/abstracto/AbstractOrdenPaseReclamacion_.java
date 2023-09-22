package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractOrdenPaseReclamacion.class)
public abstract class AbstractOrdenPaseReclamacion_ { 

	public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, Integer> id;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, String> usuario;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, Date> fechaHora;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, String> numeroReporte;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, String> documentosFaltantes;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, String> observaciones;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, Boolean> enviadoFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, String> respuestaFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, String> reporteNumeroPoliza;
    public static volatile SingularAttribute<AbstractOrdenPaseReclamacion, Terminal> terminal;
    
}