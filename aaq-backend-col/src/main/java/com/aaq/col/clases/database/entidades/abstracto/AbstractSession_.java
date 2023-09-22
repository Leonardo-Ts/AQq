package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractSession.class)
public abstract class AbstractSession_ { 

    public static volatile SingularAttribute<AbstractSession, String> paginaActual;
    public static volatile SingularAttribute<AbstractSession, Date> fechaInicio;
    public static volatile SingularAttribute<AbstractSession, Usuario> usuario;
    public static volatile SingularAttribute<AbstractSession, Integer> id;
    public static volatile SingularAttribute<AbstractSession, Date> fechaUltimoMovimiento;
    public static volatile SingularAttribute<AbstractSession, String> direccionIp;
    public static volatile SingularAttribute<AbstractSession, String> identificadorDeSession;

}