package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractGeocerca.class)
public abstract class AbstractGeocerca_ { 

    public static volatile SingularAttribute<AbstractGeocerca, String> descripcion;
    public static volatile SingularAttribute<AbstractGeocerca, Date> fecha;
    public static volatile SingularAttribute<AbstractGeocerca, Estado> estado;
    public static volatile SingularAttribute<AbstractGeocerca, String> color;
    public static volatile SingularAttribute<AbstractGeocerca, Usuario> usuario;
    public static volatile SingularAttribute<AbstractGeocerca, Integer> id;
    public static volatile SingularAttribute<AbstractGeocerca, Boolean> habilitado;
    public static volatile SingularAttribute<AbstractGeocerca, String> nombre;

}