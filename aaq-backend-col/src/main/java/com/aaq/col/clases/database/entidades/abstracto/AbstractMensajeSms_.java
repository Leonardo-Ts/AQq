package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractMensajeSms.class)
public abstract class AbstractMensajeSms_ { 

    public static volatile SingularAttribute<AbstractMensajeSms, String> agente;
    public static volatile SingularAttribute<AbstractMensajeSms, String> numeroreporte;
    public static volatile SingularAttribute<AbstractMensajeSms, String> ramo;
    public static volatile SingularAttribute<AbstractMensajeSms, String> causa;
    public static volatile SingularAttribute<AbstractMensajeSms, String> descripcioncausa;
    public static volatile SingularAttribute<AbstractMensajeSms, String> asegurado;
    public static volatile SingularAttribute<AbstractMensajeSms, String> telefonodestino;
    public static volatile SingularAttribute<AbstractMensajeSms, Terminal> terminal;
    public static volatile SingularAttribute<AbstractMensajeSms, String> poliza;
    public static volatile SingularAttribute<AbstractMensajeSms, String> direccionIp;
    public static volatile SingularAttribute<AbstractMensajeSms, String> ejercicio;
    public static volatile SingularAttribute<AbstractMensajeSms, String> texto;
    public static volatile SingularAttribute<AbstractMensajeSms, Date> fecha;
    public static volatile SingularAttribute<AbstractMensajeSms, String> oficina;
    public static volatile SingularAttribute<AbstractMensajeSms, String> mensajeoriginal;
    public static volatile SingularAttribute<AbstractMensajeSms, Usuario> usuario;
    public static volatile SingularAttribute<AbstractMensajeSms, Integer> id;
    public static volatile SingularAttribute<AbstractMensajeSms, String> gerente;

}