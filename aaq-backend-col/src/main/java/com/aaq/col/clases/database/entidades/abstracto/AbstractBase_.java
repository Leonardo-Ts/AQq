package com.aaq.col.clases.database.entidades.abstracto;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractBase.class)
public abstract class AbstractBase_ { 

    public static volatile SingularAttribute<AbstractBase, String> zona;
    public static volatile SingularAttribute<AbstractBase, String> latitud;
    public static volatile SingularAttribute<AbstractBase, Estado> estado;
    public static volatile SingularAttribute<AbstractBase, String> longitud;
    public static volatile SingularAttribute<AbstractBase, Date> fechaModificacion;
    public static volatile SingularAttribute<AbstractBase, Integer> identidad_;
    public static volatile SingularAttribute<AbstractBase, String> direccion;
    public static volatile SingularAttribute<AbstractBase, Usuario> usuario;
    public static volatile SingularAttribute<AbstractBase, Integer> id;
    public static volatile SingularAttribute<AbstractBase, Boolean> habilitadoEnMapa;
    public static volatile SingularAttribute<AbstractBase, Boolean> habilitadoEnMapaCabina;
    public static volatile SingularAttribute<AbstractBase, Boolean> habilitado;
    public static volatile SingularAttribute<AbstractBase, String> nombre;
    public static volatile SingularAttribute<AbstractBase, Boolean> vulnerable;

}