package com.aaq.col.clases.database.entidades.abstracto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.CarreteraTipo;
import com.aaq.col.clases.database.entidades.Estado;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractCarretera.class)
public abstract class AbstractCarretera_ { 

    public static volatile SingularAttribute<AbstractCarretera, CarreteraTipo> carreteraTipo;
    public static volatile SingularAttribute<AbstractCarretera, Double> latitud;
    public static volatile SingularAttribute<AbstractCarretera, Double> longitud;
    public static volatile SingularAttribute<AbstractCarretera, Estado> estado;
    public static volatile SingularAttribute<AbstractCarretera, Integer> id;
    public static volatile SingularAttribute<AbstractCarretera, String> nombre;

}