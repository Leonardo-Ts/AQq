package com.aaq.col.clases.database.entidades.abstracto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Estado;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractCartografia.class)
public abstract class AbstractCartografia_ { 

    public static volatile SingularAttribute<AbstractCartografia, Double> latitud;
    public static volatile SingularAttribute<AbstractCartografia, Double> longitud;
    public static volatile SingularAttribute<AbstractCartografia, Integer> tipo;
    public static volatile SingularAttribute<AbstractCartografia, Estado> estado;
    public static volatile SingularAttribute<AbstractCartografia, String> definicion;
    public static volatile SingularAttribute<AbstractCartografia, Double> zoom;
    public static volatile SingularAttribute<AbstractCartografia, Integer> id;

}