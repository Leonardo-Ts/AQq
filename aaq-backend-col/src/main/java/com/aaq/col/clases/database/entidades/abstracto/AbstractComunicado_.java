package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractComunicado.class)
public abstract class AbstractComunicado_ { 

    public static volatile SingularAttribute<AbstractComunicado, Estado> estado;
    public static volatile SingularAttribute<AbstractComunicado, Date> fechaCaptura;
    public static volatile SingularAttribute<AbstractComunicado, Date> fechaInicio;
    public static volatile SingularAttribute<AbstractComunicado, Date> fechaTermino;
    public static volatile SingularAttribute<AbstractComunicado, Usuario> usuario;
    public static volatile SingularAttribute<AbstractComunicado, Integer> id;
    public static volatile SingularAttribute<AbstractComunicado, Terminal> terminal;
    public static volatile SingularAttribute<AbstractComunicado, String> texo;
    public static volatile SingularAttribute<AbstractComunicado, Base> base;

}