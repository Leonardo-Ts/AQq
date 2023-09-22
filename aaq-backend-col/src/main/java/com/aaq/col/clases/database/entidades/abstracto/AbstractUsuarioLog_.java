package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Usuario;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractUsuarioLog.class)
public abstract class AbstractUsuarioLog_ { 

    public static volatile SingularAttribute<AbstractUsuarioLog, Boolean> valida;
    public static volatile SingularAttribute<AbstractUsuarioLog, Date> fecha;
    public static volatile SingularAttribute<AbstractUsuarioLog, String> latitud;
    public static volatile SingularAttribute<AbstractUsuarioLog, String> longitud;
    public static volatile SingularAttribute<AbstractUsuarioLog, String> direccion;
    public static volatile SingularAttribute<AbstractUsuarioLog, Usuario> usuario;
    public static volatile SingularAttribute<AbstractUsuarioLog, Integer> id;
    public static volatile SingularAttribute<AbstractUsuarioLog, Double> metrosRecorridos;
    public static volatile SingularAttribute<AbstractUsuarioLog, Double> velocidad;
    public static volatile SingularAttribute<AbstractUsuarioLog, Double> segundosTranscurridos;

}