package com.aaq.col.clases.database.entidades.abstracto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractPuntoInteres.class)
public abstract class AbstractPuntoInteres_ { 

    public static volatile SingularAttribute<AbstractPuntoInteres, String> descripcion;
    public static volatile SingularAttribute<AbstractPuntoInteres, String> latitud;
    public static volatile SingularAttribute<AbstractPuntoInteres, String> longitud;
    public static volatile SingularAttribute<AbstractPuntoInteres, Estado> estado;
    public static volatile SingularAttribute<AbstractPuntoInteres, Integer> id;
    public static volatile SingularAttribute<AbstractPuntoInteres, Boolean> habilitado;
    public static volatile SingularAttribute<AbstractPuntoInteres, String> nombre;
    public static volatile SingularAttribute<AbstractPuntoInteres, PuntoInteresTipo> puntoInteresTipo;

}