package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractConfiguracion.class)
public abstract class AbstractConfiguracion_ { 

    public static volatile SingularAttribute<AbstractConfiguracion, Date> fecha;
    public static volatile SingularAttribute<AbstractConfiguracion, String> llave;
    public static volatile SingularAttribute<AbstractConfiguracion, String> valor;
    public static volatile SingularAttribute<AbstractConfiguracion, Usuario> usuario;
    public static volatile SingularAttribute<AbstractConfiguracion, Integer> id;
    public static volatile SingularAttribute<AbstractConfiguracion, String> nombre;

}